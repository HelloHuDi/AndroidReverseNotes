package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.RejectedExecutionException;

class ReflectConstructor {
    private Class<?> mClass;
    private Constructor<?> mConstructor;
    private Class<?>[] mParameterTypes;

    public ReflectConstructor(Class<?> cls, Class<?>... clsArr) {
        AppMethodBeat.i(85512);
        init(cls, clsArr);
        AppMethodBeat.o(85512);
    }

    public boolean init(Class<?> cls, Class<?>... clsArr) {
        AppMethodBeat.i(85513);
        this.mClass = cls;
        this.mParameterTypes = clsArr;
        this.mConstructor = null;
        if (this.mClass == null) {
            AppMethodBeat.o(85513);
            return false;
        }
        try {
            this.mConstructor = this.mClass.getConstructor(this.mParameterTypes);
        } catch (NoSuchMethodException e) {
            try {
                this.mConstructor = this.mClass.getDeclaredConstructor(this.mParameterTypes);
                this.mConstructor.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
        }
        if (this.mConstructor != null) {
            AppMethodBeat.o(85513);
            return true;
        }
        AppMethodBeat.o(85513);
        return false;
    }

    public Object newInstance(Object... objArr) {
        RejectedExecutionException rejectedExecutionException;
        AppMethodBeat.i(85514);
        if (this.mConstructor == null) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(toString());
            AppMethodBeat.o(85514);
            throw unsupportedOperationException;
        }
        try {
            Object newInstance = this.mConstructor.newInstance(objArr);
            AppMethodBeat.o(85514);
            return newInstance;
        } catch (IllegalAccessException e) {
            rejectedExecutionException = new RejectedExecutionException(e);
            AppMethodBeat.o(85514);
            throw rejectedExecutionException;
        } catch (InstantiationException e2) {
            rejectedExecutionException = new RejectedExecutionException(e2);
            AppMethodBeat.o(85514);
            throw rejectedExecutionException;
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(85514);
            throw e3;
        } catch (InvocationTargetException e4) {
            RuntimeException runtimeException = new RuntimeException(e4.getCause());
            AppMethodBeat.o(85514);
            throw runtimeException;
        }
    }

    public boolean isNull() {
        return this.mConstructor == null;
    }

    public String toString() {
        AppMethodBeat.i(85515);
        String constructor;
        if (this.mConstructor != null) {
            constructor = this.mConstructor.toString();
            AppMethodBeat.o(85515);
            return constructor;
        }
        constructor = "";
        if (this.mClass != null) {
            constructor = constructor + this.mClass.toString();
        }
        AppMethodBeat.o(85515);
        return constructor;
    }
}
