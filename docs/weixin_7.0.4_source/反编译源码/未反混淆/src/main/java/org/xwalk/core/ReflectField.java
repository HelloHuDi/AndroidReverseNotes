package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.concurrent.RejectedExecutionException;

public class ReflectField {
    private Class<?> mClass;
    private Field mField;
    private Object mInstance;
    private String mName;

    public ReflectField(Object obj, String str) {
        AppMethodBeat.i(4194);
        init(obj, null, str);
        AppMethodBeat.o(4194);
    }

    public ReflectField(Class<?> cls, String str) {
        AppMethodBeat.i(4195);
        init(null, cls, str);
        AppMethodBeat.o(4195);
    }

    public boolean init(Object obj, Class<?> cls, String str) {
        Class cls2;
        AppMethodBeat.i(4196);
        this.mInstance = obj;
        if (cls2 == null) {
            cls2 = obj != null ? obj.getClass() : null;
        }
        this.mClass = cls2;
        this.mName = str;
        this.mField = null;
        if (this.mClass == null) {
            AppMethodBeat.o(4196);
            return false;
        }
        try {
            this.mField = this.mClass.getField(this.mName);
        } catch (NoSuchFieldException e) {
            Class cls3 = this.mClass;
            while (cls3 != null) {
                try {
                    this.mField = cls3.getDeclaredField(this.mName);
                    this.mField.setAccessible(true);
                    break;
                } catch (NoSuchFieldException e2) {
                    cls3 = cls3.getSuperclass();
                }
            }
        }
        if (this.mField != null) {
            AppMethodBeat.o(4196);
            return true;
        }
        AppMethodBeat.o(4196);
        return false;
    }

    public Object get() {
        AppMethodBeat.i(4197);
        if (this.mField == null) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(toString());
            AppMethodBeat.o(4197);
            throw unsupportedOperationException;
        }
        try {
            Object obj = this.mField.get(this.mInstance);
            AppMethodBeat.o(4197);
            return obj;
        } catch (IllegalAccessException | NullPointerException e) {
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(e);
            AppMethodBeat.o(4197);
            throw rejectedExecutionException;
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(4197);
            throw e2;
        } catch (ExceptionInInitializerError e3) {
            RuntimeException runtimeException = new RuntimeException(e3);
            AppMethodBeat.o(4197);
            throw runtimeException;
        }
    }

    public boolean isNull() {
        return this.mField == null;
    }

    public String toString() {
        AppMethodBeat.i(4198);
        String field;
        if (this.mField != null) {
            field = this.mField.toString();
            AppMethodBeat.o(4198);
            return field;
        }
        field = "";
        if (this.mClass != null) {
            field = field + this.mClass.toString() + ".";
        }
        if (this.mName != null) {
            field = field + this.mName;
        }
        AppMethodBeat.o(4198);
        return field;
    }

    public String getName() {
        return this.mName;
    }

    public Object getInstance() {
        return this.mInstance;
    }
}
