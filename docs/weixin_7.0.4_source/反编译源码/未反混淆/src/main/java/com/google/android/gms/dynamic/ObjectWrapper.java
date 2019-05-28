package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class ObjectWrapper<T> extends Stub {
    private final T zzabn;

    private ObjectWrapper(T t) {
        this.zzabn = t;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        IllegalArgumentException illegalArgumentException;
        AppMethodBeat.i(90397);
        Object obj;
        if (iObjectWrapper instanceof ObjectWrapper) {
            obj = ((ObjectWrapper) iObjectWrapper).zzabn;
            AppMethodBeat.o(90397);
            return obj;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int length = declaredFields.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Field field2 = declaredFields[i];
            if (field2.isSynthetic()) {
                field2 = field;
            } else {
                i2++;
            }
            i++;
            field = field2;
        }
        IllegalArgumentException illegalArgumentException2;
        if (i2 != 1) {
            illegalArgumentException2 = new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
            AppMethodBeat.o(90397);
            throw illegalArgumentException2;
        } else if (field.isAccessible()) {
            illegalArgumentException2 = new IllegalArgumentException("IObjectWrapper declared field not private!");
            AppMethodBeat.o(90397);
            throw illegalArgumentException2;
        } else {
            field.setAccessible(true);
            try {
                obj = field.get(asBinder);
                AppMethodBeat.o(90397);
                return obj;
            } catch (NullPointerException e) {
                illegalArgumentException = new IllegalArgumentException("Binder object is null.", e);
                AppMethodBeat.o(90397);
                throw illegalArgumentException;
            } catch (IllegalAccessException e2) {
                illegalArgumentException = new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
                AppMethodBeat.o(90397);
                throw illegalArgumentException;
            }
        }
    }

    public static <T> IObjectWrapper wrap(T t) {
        AppMethodBeat.i(90396);
        ObjectWrapper objectWrapper = new ObjectWrapper(t);
        AppMethodBeat.o(90396);
        return objectWrapper;
    }
}
