package com.tencent.tencentmap.mapsdk.maps.a;

import java.io.Serializable;

public abstract class m implements Serializable {
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
    private Object a;

    public abstract void readFrom(k kVar);

    public abstract void writeTo(l lVar);

    public void display(StringBuilder stringBuilder, int i) {
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
    }

    public m newInit() {
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
        l lVar = new l();
        writeTo(lVar);
        return lVar.b();
    }

    public byte[] toByteArray(String str) {
        l lVar = new l();
        lVar.a(str);
        writeTo(lVar);
        return lVar.b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        display(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public static String toDisplaySimpleString(m mVar) {
        if (mVar == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        mVar.displaySimple(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public Object getTag() {
        return this.a;
    }

    public void setTag(Object obj) {
        this.a = obj;
    }
}
