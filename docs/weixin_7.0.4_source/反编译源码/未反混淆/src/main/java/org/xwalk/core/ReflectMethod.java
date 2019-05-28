package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

public class ReflectMethod {
    private Object[] mArguments;
    private Class<?> mClass;
    private Object mInstance;
    private Method mMethod;
    private String mName;
    private Class<?>[] mParameterTypes;

    public ReflectMethod(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.i(85516);
        init(obj, null, str, clsArr);
        AppMethodBeat.o(85516);
    }

    public ReflectMethod(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(85517);
        init(null, cls, str, clsArr);
        AppMethodBeat.o(85517);
    }

    public boolean init(Object obj, Class<?> cls, String str, Class<?>... clsArr) {
        Class cls2;
        AppMethodBeat.i(85518);
        this.mInstance = obj;
        if (cls2 == null) {
            cls2 = obj != null ? obj.getClass() : null;
        }
        this.mClass = cls2;
        this.mName = str;
        this.mParameterTypes = clsArr;
        this.mMethod = null;
        if (this.mClass == null) {
            AppMethodBeat.o(85518);
            return false;
        }
        try {
            this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
        } catch (NoSuchMethodException e) {
            Class cls3 = this.mClass;
            while (cls3 != null) {
                try {
                    this.mMethod = cls3.getDeclaredMethod(this.mName, this.mParameterTypes);
                    this.mMethod.setAccessible(true);
                    break;
                } catch (NoSuchMethodException e2) {
                    cls3 = cls3.getSuperclass();
                }
            }
        }
        if (this.mMethod != null) {
            AppMethodBeat.o(85518);
            return true;
        }
        AppMethodBeat.o(85518);
        return false;
    }

    public Object invoke(Object... objArr) {
        AppMethodBeat.i(85519);
        if (this.mMethod == null) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(toString());
            AppMethodBeat.o(85519);
            throw unsupportedOperationException;
        }
        try {
            Object invoke = this.mMethod.invoke(this.mInstance, objArr);
            AppMethodBeat.o(85519);
            return invoke;
        } catch (IllegalAccessException | NullPointerException e) {
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(e);
            AppMethodBeat.o(85519);
            throw rejectedExecutionException;
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(85519);
            throw e2;
        } catch (InvocationTargetException e3) {
            RuntimeException runtimeException = new RuntimeException(e3.getCause());
            AppMethodBeat.o(85519);
            throw runtimeException;
        }
    }

    public boolean isNull() {
        return this.mMethod == null;
    }

    public String toString() {
        AppMethodBeat.i(85520);
        String method;
        if (this.mMethod != null) {
            method = this.mMethod.toString();
            AppMethodBeat.o(85520);
            return method;
        }
        method = "";
        if (this.mClass != null) {
            method = method + this.mClass.toString() + ".";
        }
        if (this.mName != null) {
            method = method + this.mName;
        }
        AppMethodBeat.o(85520);
        return method;
    }

    public String getName() {
        return this.mName;
    }

    public Object getInstance() {
        return this.mInstance;
    }

    public Object[] getArguments() {
        return this.mArguments;
    }

    public void setArguments(Object... objArr) {
        this.mArguments = objArr;
    }

    public Object invokeWithArguments() {
        AppMethodBeat.i(85521);
        Object invoke = invoke(this.mArguments);
        AppMethodBeat.o(85521);
        return invoke;
    }
}
