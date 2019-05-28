package com.eclipsesource.a;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

public abstract class h implements Serializable {
    @Deprecated
    public static final h aLi = a.aLi;
    @Deprecated
    public static final h aLj = a.aLj;
    @Deprecated
    public static final h aLk = a.aLk;

    public abstract void a(i iVar);

    h() {
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

    public e oS() {
        throw new UnsupportedOperationException("Not an object: " + toString());
    }

    public b oN() {
        throw new UnsupportedOperationException("Not an array: " + toString());
    }

    public int oP() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public long oQ() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public double oR() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public String pq() {
        throw new UnsupportedOperationException("Not a string: " + toString());
    }

    public boolean oO() {
        throw new UnsupportedOperationException("Not a boolean: " + toString());
    }

    public String toString() {
        return a(l.aLN);
    }

    public final String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        if (lVar == null) {
            try {
                throw new NullPointerException("config is null");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        m mVar = new m(stringWriter);
        a(lVar.a(mVar));
        mVar.flush();
        return stringWriter.toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
