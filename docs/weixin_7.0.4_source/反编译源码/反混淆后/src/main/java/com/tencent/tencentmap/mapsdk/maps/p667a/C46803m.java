package com.tencent.tencentmap.mapsdk.maps.p667a;

import java.io.Serializable;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.m */
public abstract class C46803m implements Serializable {
    public static final byte BYTE = (byte) 0;
    public static final byte DOUBLE = (byte) 5;
    public static final byte FLOAT = (byte) 4;
    public static final byte INT = (byte) 2;
    public static final int JCE_MAX_STRING_LENGTH = 104857600;
    public static final byte LIST = (byte) 9;
    public static final byte LONG = (byte) 3;
    public static final byte MAP = (byte) 8;
    public static final byte SHORT = (byte) 1;
    public static final byte SIMPLE_LIST = (byte) 13;
    public static final byte STRING1 = (byte) 6;
    public static final byte STRING4 = (byte) 7;
    public static final byte STRUCT_BEGIN = (byte) 10;
    public static final byte STRUCT_END = (byte) 11;
    public static final byte ZERO_TAG = (byte) 12;
    /* renamed from: a */
    private Object f18263a;

    public abstract void readFrom(C31070k c31070k);

    public abstract void writeTo(C24398l c24398l);

    public void display(StringBuilder stringBuilder, int i) {
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
    }

    public C46803m newInit() {
        return null;
    }

    public void recyle() {
    }

    public boolean containField(String str) {
        return false;
    }

    public Object getFieldByName(String str) {
        return null;
    }

    public void setFieldByName(String str, Object obj) {
    }

    public byte[] toByteArray() {
        C24398l c24398l = new C24398l();
        writeTo(c24398l);
        return c24398l.mo40685b();
    }

    public byte[] toByteArray(String str) {
        C24398l c24398l = new C24398l();
        c24398l.mo40662a(str);
        writeTo(c24398l);
        return c24398l.mo40685b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        display(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public static String toDisplaySimpleString(C46803m c46803m) {
        if (c46803m == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        c46803m.displaySimple(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public Object getTag() {
        return this.f18263a;
    }

    public void setTag(Object obj) {
        this.f18263a = obj;
    }
}
