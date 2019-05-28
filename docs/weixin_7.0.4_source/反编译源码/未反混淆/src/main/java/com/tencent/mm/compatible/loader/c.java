package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c<T> {
    private String classname;
    private Field eum;
    private String fieldName;
    private boolean inited;
    private Object obj;

    public c(Object obj, String str, String str2) {
        AppMethodBeat.i(51926);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("obj cannot be null");
            AppMethodBeat.o(51926);
            throw illegalArgumentException;
        }
        this.obj = obj;
        this.fieldName = str;
        this.classname = str2;
        AppMethodBeat.o(51926);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A:{Splitter:B:5:0x001a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:22:0x0067, code skipped:
            r1.getSuperclass();
            com.tencent.matrix.trace.core.AppMethodBeat.o(51927);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void prepare() {
        AppMethodBeat.i(51927);
        if (this.inited) {
            AppMethodBeat.o(51927);
            return;
        }
        this.inited = true;
        Class cls = this.obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(this.fieldName);
                declaredField.setAccessible(true);
                this.eum = declaredField;
                cls.getSuperclass();
                AppMethodBeat.o(51927);
                return;
            } catch (Exception e) {
                if (this.classname != null && !this.classname.equals("")) {
                    for (Field field : cls.getDeclaredFields()) {
                        if (field.getType().getName().equals(this.classname)) {
                            field.setAccessible(true);
                            this.eum = field;
                            break;
                        }
                    }
                }
                cls = cls.getSuperclass();
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(51927);
    }

    public final T get() {
        AppMethodBeat.i(51928);
        prepare();
        if (this.eum == null) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
            AppMethodBeat.o(51928);
            throw noSuchFieldException;
        }
        try {
            Object obj = this.eum.get(this.obj);
            AppMethodBeat.o(51928);
            return obj;
        } catch (ClassCastException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unable to cast object");
            AppMethodBeat.o(51928);
            throw illegalArgumentException;
        }
    }

    public final void set(T t) {
        AppMethodBeat.i(51929);
        prepare();
        if (this.eum == null) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
            AppMethodBeat.o(51929);
            throw noSuchFieldException;
        }
        this.eum.set(this.obj, t);
        AppMethodBeat.o(51929);
    }

    public final boolean Mg() {
        AppMethodBeat.i(51930);
        prepare();
        if (this.eum != null) {
            AppMethodBeat.o(51930);
            return true;
        }
        AppMethodBeat.o(51930);
        return false;
    }
}
