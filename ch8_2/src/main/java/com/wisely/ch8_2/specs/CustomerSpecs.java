package com.wisely.ch8_2.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * <内容说明>
 *
 * @author jiang.zhenxiong
 * created on 2018/6/4 10:07
 */
public class CustomerSpecs {

    /**
     * 定义一个返回值为Specification的方法byAuto。
     * 这里使用的是泛型T，所以这个Specification是可以用于任意的实体类的。
     * 它接受的参数是entityManager和当前的包含值作为查询条件的实体类对象。
     * @param entityManager
     * @param example
     * @param <T>
     * @return
     */
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        // 获得当前实体类对象类的类型
        final Class<T> type = (Class<T>) example.getClass();
        return (Specification<T>) (root, criteriaQuery, criteriaBuilder) -> {
            // 新建Predicate列表存储构造的查询条件
            List<Predicate> predicates = new ArrayList<>();
            // 获得实体类的EntityType，可以从EntityType获得实体类的属性。
            EntityType<T> entity = entityManager.getMetamodel().entity(type);

            for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                Object attrValue = getValue(example, attr);
                if (attrValue != null) {
                    if (attr.getJavaType() == String.class) {
                        if (!StringUtils.isEmpty(attr)) {
                            predicates.add(criteriaBuilder.like(root.get(attribute(entity, attr.getName(), String.class)), pattern((String) attrValue)));
                        }
                    } else {
                        predicates.add(criteriaBuilder.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())), attrValue));
                    }
                }
            }
            // 将条件列表转换成Predicate
            return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    /**
     * 通过反射获得实体类对象对应属性的属性值
     * @param example
     * @param attr
     * @param <T>
     * @return
     */
    private static  <T> Object getValue(T example, Attribute<T, ?> attr) {
        return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
    }

    /**
     * 获得实体类的当前属性的SingularAttribute，SingularAttribute包含的是实体类的某个单独属性
     * @param entity
     * @param fieldName
     * @param fieldClass
     * @param <E>
     * @param <T>
     * @return
     */
    private static  <E, T>SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
        return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
    }

    /**
     * 构造like的查询模式，即前后加%
     * @param str
     * @return
     */
    private static String pattern(String str) {
        return "%" + str + "%";
    }
}
