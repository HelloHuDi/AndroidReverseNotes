package com.tencent.p659pb.common.p1102c;

import java.util.Iterator;

/* renamed from: com.tencent.pb.common.c.g */
public final class C40956g {
    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    /* renamed from: iA */
    public static boolean m71019iA(String str, String str2) {
        if (str == null) {
            return str2 == null;
        } else {
            return str.equals(str2);
        }
    }

    /* renamed from: a */
    public static String m71018a(Iterable<?> iterable, String str, String str2) {
        Iterator it = iterable.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (it.hasNext()) {
            stringBuilder.append(it.next().toString().replace(str, str2));
            if (it.hasNext()) {
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public static boolean equals(String str, String str2) {
        if (str == str2 || (str != null && str2 != null && str.equals(str2))) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String atI(String str) {
        if (C40956g.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
