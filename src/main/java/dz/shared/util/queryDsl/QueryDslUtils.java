package dz.shared.util.queryDsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QueryDslUtils {
    //
    public static BooleanExpression eqIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return target.eq(value);
    }

    public static BooleanExpression eqAnyIfNotNull(StringPath target, StringPath target2, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return target.eq(value).or(target2.eq(value));
    }

    public static BooleanExpression eqIfNotNull(NumberPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return target.eq(value);
    }

    public static BooleanExpression eqIfNotNull(NumberPath target, Integer value) {
        //
        if (Objects.isNull(value)) {
            return null;
        }

        return target.eq(value);
    }


    public static BooleanExpression eqIfNotNull(BooleanPath target, Boolean value) {
        //
        if (value == null) {
            return null;
        }

        return target.eq(value);
    }

    public static BooleanExpression eqIfNotNull(EnumPath target, Enum value) {
        //
        if (value == null) {
            return null;
        }

        return target.eq(value);
    }

    public static BooleanExpression containsIfNotNull(SimplePath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return Expressions.stringOperation(Ops.STRING_CAST, target).contains(value);
    }


    public static BooleanExpression containsIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.contains(value);
    }

    public static BooleanExpression likeIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.like("%" + value + "%");
    }

    public static BooleanExpression likeIfNotNull(StringPath target, String value, char escape) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.like("%" + value + "%", escape);
    }

    public static BooleanExpression likeIfNotNull(SimplePath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return Expressions.stringOperation(Ops.STRING_CAST, target).like("%" + value + "%");
    }

    public static BooleanExpression likeIfNotNull(SimplePath target, String value, char escape) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return Expressions.stringOperation(Ops.STRING_CAST, target).like("%" + value + "%", escape);
    }

    public static BooleanExpression likeIfNotNull(String value, StringPath target) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return Expressions.asString(value).like(target);
    }

    public static BooleanExpression startWithIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.like(value + "%");
    }

    public static BooleanExpression startWithIfNotNull(StringPath target, String value, char escape) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.like(value + "%", escape);
    }

    public static BooleanExpression betweenIfNotNull(NumberPath<Long> target, Long startDate, Long endDate) {
        //
        if (startDate == null && endDate == null) {
            return null;
        }

        if (startDate == null) {
            startDate = 0l;
        }

        if (endDate == null) {
            endDate = Long.MAX_VALUE;
        }

        return target.between(startDate, endDate);
    }

    public static BooleanExpression betweenIfNotNull(NumberPath<Long> target, Range<Long> range) {
        //
        if (range == null) {
            return null;
        }
        return target.between(range.getMinimum(), range.getMaximum());
    }

    @Deprecated
    public static BooleanBuilder betweenAnyOfIfNotNull(NumberPath<Long> target, Range<Long>... ranges) {
        //
        if (ranges == null || ranges.length < 1) {
            return null;
        }

        BooleanBuilder anyOfBooleanBuilder = new BooleanBuilder();
        anyOfBooleanBuilder.andAnyOf(Arrays.asList(ranges).stream().map(range -> betweenIfNotNull(target, range))
                .filter(Objects::nonNull).toArray(BooleanExpression[]::new));

        return anyOfBooleanBuilder;
    }

    public static BooleanBuilder betweenAnyOfIfNotNull(NumberPath<Long> target, List<Range<Long>> ranges) {
        //
        if (CollectionUtils.isEmpty(ranges)) {
            return null;
        }

        BooleanBuilder anyOfBooleanBuilder = new BooleanBuilder();
        anyOfBooleanBuilder.andAnyOf(ranges.stream().map(range -> betweenIfNotNull(target, range))
                .filter(Objects::nonNull).toArray(BooleanExpression[]::new));

        return anyOfBooleanBuilder;
    }


    public static BooleanExpression inIfNotNull(StringPath target, String... values) {
        //
        if (values == null || values.length < 1) {
            return null;
        }

        return target.in(Arrays.asList(values));
    }

    public static BooleanExpression notInIfNotNull(StringPath target, List<String> values) {
        //
        if (CollectionUtils.isEmpty(values)) {
            return null;
        }

        return target.notIn(values);
    }

    public static BooleanExpression inIfNotNull(StringPath target, List<String> values) {
        //
        if (CollectionUtils.isEmpty(values)) {
            return null;
        }

        return target.in(values);
    }

    public static BooleanExpression inAnyIfNotNull(StringPath target, StringPath target2, List<String> values) {
        //
        if (CollectionUtils.isEmpty(values)) {
            return null;
        }

        return target.in(values).or(target2.in(values));
    }

    public static BooleanExpression inIfNotNull(EnumPath target, Enum... values) {
        //
        if (values == null || values.length < 1) {
            return null;
        }

        return target.in(Arrays.asList(values));
    }

    public static <T extends Enum<T>> BooleanExpression inIfNotNull(EnumPath<T> target, List<T> values) {
        return CollectionUtils.isEmpty(values) ? null : target.in(values);
    }

    public static <T extends Enum<T>> BooleanExpression notInIfNotNull(EnumPath<T> target, List<T> values) {
        return CollectionUtils.isEmpty(values) ? null : target.notIn(values);
    }

    public static BooleanExpression gtIfNotNull(NumberPath target, Integer value) {
        //
        if (value == null) {
            return null;
        }
        return target.gt(value);
    }

    public static BooleanExpression goeIfNotNull(NumberPath target, Integer value) {
        //
        if (value == null) {
            return null;
        }
        return target.goe(value);
    }

    public static BooleanExpression ltIfNotNull(NumberPath target, Integer value) {
        //
        if (value == null) {
            return null;
        }
        return target.lt(value);
    }

    public static BooleanExpression loeIfNotNull(NumberPath target, Integer value) {
        //
        if (value == null) {
            return null;
        }
        return target.loe(value);
    }

    public static BooleanExpression gtIfNotNull(NumberPath target, Long value) {
        //
        if (value == null) {
            return null;
        }
        return target.gt(value);
    }

    public static BooleanExpression ltIfNotNull(NumberPath target, Long value) {
        //
        if (value == null) {
            return null;
        }
        return target.lt(value);
    }

    public static BooleanExpression loeIfNotNull(NumberPath target, Long value) {
        //
        if (value == null) {
            return null;
        }
        return target.loe(value);
    }

    public static BooleanExpression gtIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.gt(value);
    }

    public static BooleanExpression goeIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.goe(value);
    }

    public static BooleanExpression ltIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.lt(value);
    }

    public static BooleanExpression loeIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return target.loe(value);
    }


    public static BooleanExpression containsIfNotNull(ListPath target, Object value) {
        //
        if (value == null) {
            return null;
        }

        return target.contains(value);
    }

    public static BooleanExpression existsIfNotNull(NumberPath target, Boolean value) {
        //
        if (value == null) {
            return null;
        }

        return value ? target.goe(1) : target.loe(0);
    }

    public static BooleanExpression existsIfNotNull(ListPath target, Boolean value) {
        //
        if (value == null) {
            return null;
        }

        return value ? target.size().goe(1) : target.size().loe(0);
    }

    public static BooleanExpression notEqIfNotNull(StringPath target, String value) {
        //
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        return target.ne(value);
    }
}
