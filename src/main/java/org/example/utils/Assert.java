package org.example.utils;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public final class Assert {

    public static <X extends Throwable> void notEmpty(Collection<?> collection, Supplier<? extends X> x) throws X {
        if (collection == null || collection.isEmpty()) throw x.get();
    }

    public static <X extends Throwable> void notNull(Object o, Supplier<? extends X> x) throws X {
        if (o == null) throw x.get();
    }

    public static <X extends Throwable> void notBlank(String str, Supplier<? extends X> x) throws X {
        if (str == null || str.trim().equals("")) throw x.get();
    }

    public static void notNull(Object o, RuntimeException e) throws RuntimeException {
        if (o == null) throw e;
    }

    public static <X extends Throwable> void isTrue(boolean expression, Supplier<? extends X> x) throws X {
        if (!expression) throw x.get();
    }

    public static void isTrue(boolean expression, RuntimeException throwable) throws RuntimeException {
        if (!expression) throw throwable;
    }

    public static <X extends Throwable> void isFalse(boolean expression, Supplier<? extends X> x) throws X {
        if (expression) throw x.get();
    }

    public static <X extends Throwable> void isEquals(Object o1, Object o2, Supplier<? extends X> x) throws X {
        if (!o1.equals(o2)) throw x.get();
    }

    public static <X extends Throwable> void isAfter(LocalDateTime from, LocalDateTime to, Supplier<? extends X> x) throws X {
        if (!from.isAfter(to)) throw x.get();
    }

    public static <X extends Throwable> void isBefore(LocalDateTime from, LocalDateTime to, Supplier<? extends X> x) throws X {
        if (from.isAfter(to)) throw x.get();
    }

    public static <X extends Throwable> void notEquals(Object o1, Object o2, Supplier<? extends X> x) throws X {
        if (o1.equals(o2)) throw x.get();
    }

    public static <X extends Throwable> void isLess(int n1, int n2, Supplier<? extends X> x) throws X {
        if (n1 >= n2) throw x.get();
    }

    public static <X extends Throwable> void isLessOrEquals(int n1, int n2, Supplier<? extends X> x) throws X {
        if (n1 > n2) throw x.get();
    }

    public static <X extends Throwable> void isGreater(int n1, int n2, Supplier<? extends X> x) throws X {
        if (n1 <= n2) throw x.get();
    }

    public static <X extends Throwable> void isGreaterOrEquals(int n1, int n2, Supplier<? extends X> x) throws X {
        if (n1 < n2) throw x.get();
    }

    public static <X extends Throwable, T> void contains(Set<T> set, T t, Supplier<? extends X> x) throws X {
        Assert.notEmpty(set, x);
        if (!set.contains(t)) throw x.get();
    }

    public static <X extends Throwable> void isNull(Object o, Supplier<? extends X> x) throws X {
        if (o != null) throw x.get();
    }

    public static <X extends Throwable> void isEmpty(List list, Supplier<? extends X> x) throws X {
        if (list != null && !list.isEmpty()) throw x.get();
    }
}