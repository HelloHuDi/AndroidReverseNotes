package com.eclipsesource.p096a;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

/* renamed from: com.eclipsesource.a.h */
public abstract class C0803h implements Serializable {
    @Deprecated
    public static final C0803h aLi = C25470a.aLi;
    @Deprecated
    public static final C0803h aLj = C25470a.aLj;
    @Deprecated
    public static final C0803h aLk = C25470a.aLk;

    /* renamed from: a */
    public abstract void mo2353a(C0804i c0804i);

    C0803h() {
    }

    public boolean isObject() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    /* renamed from: oS */
    public C31986e mo2366oS() {
        throw new UnsupportedOperationException("Not an object: " + toString());
    }

    /* renamed from: oN */
    public C37205b mo2361oN() {
        throw new UnsupportedOperationException("Not an array: " + toString());
    }

    /* renamed from: oP */
    public int mo2363oP() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    /* renamed from: oQ */
    public long mo2364oQ() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    /* renamed from: oR */
    public double mo2365oR() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    /* renamed from: pq */
    public String mo2367pq() {
        throw new UnsupportedOperationException("Not a string: " + toString());
    }

    /* renamed from: oO */
    public boolean mo2362oO() {
        throw new UnsupportedOperationException("Not a boolean: " + toString());
    }

    public String toString() {
        return mo2352a(C45009l.aLN);
    }

    /* renamed from: a */
    public final String mo2352a(C45009l c45009l) {
        StringWriter stringWriter = new StringWriter();
        if (c45009l == null) {
            try {
                throw new NullPointerException("config is null");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        C31989m c31989m = new C31989m(stringWriter);
        mo2353a(c45009l.mo2380a(c31989m));
        c31989m.flush();
        return stringWriter.toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
