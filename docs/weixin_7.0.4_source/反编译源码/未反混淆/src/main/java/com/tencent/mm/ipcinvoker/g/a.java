package com.tencent.mm.ipcinvoker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import java.lang.reflect.Field;

public final class a<FieldType> {
    private Class<?> eGE;
    private String eGF;
    private Field mField;
    private boolean mInited;

    public a(Class<?> cls, String str) {
        AppMethodBeat.i(114116);
        if (str.length() == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
            AppMethodBeat.o(114116);
            throw illegalArgumentException;
        }
        this.eGE = cls;
        this.eGF = str;
        AppMethodBeat.o(114116);
    }

    private synchronized void prepare() {
        AppMethodBeat.i(114117);
        if (this.mInited) {
            AppMethodBeat.o(114117);
        } else {
            Class cls = this.eGE;
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(this.eGF);
                    declaredField.setAccessible(true);
                    this.mField = declaredField;
                    break;
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }
            this.mInited = true;
            AppMethodBeat.o(114117);
        }
    }

    private synchronized FieldType PU() {
        FieldType fieldType = null;
        synchronized (this) {
            AppMethodBeat.i(114118);
            prepare();
            if (this.mField == null) {
                b.w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", this.eGF);
                AppMethodBeat.o(114118);
            } else {
                try {
                    fieldType = this.mField.get(null);
                    AppMethodBeat.o(114118);
                } catch (ClassCastException e) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unable to cast object");
                    AppMethodBeat.o(114118);
                    throw illegalArgumentException;
                }
            }
        }
        return fieldType;
    }

    public final synchronized FieldType PV() {
        FieldType fieldType;
        AppMethodBeat.i(114119);
        fieldType = null;
        try {
            fieldType = PU();
        } catch (NoSuchFieldException e) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e);
        } catch (IllegalAccessException e2) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e2);
        } catch (IllegalArgumentException e3) {
            b.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e3);
        }
        AppMethodBeat.o(114119);
        return fieldType;
    }
}
