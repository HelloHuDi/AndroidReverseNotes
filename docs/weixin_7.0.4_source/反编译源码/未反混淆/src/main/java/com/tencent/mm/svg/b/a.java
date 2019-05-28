package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<T> {
    private String classname;
    public Field eum;
    private String fieldName;
    private boolean inited;
    public Object obj;

    public a(Object obj, String str) {
        AppMethodBeat.i(70119);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("obj cannot be null");
            AppMethodBeat.o(70119);
            throw illegalArgumentException;
        }
        this.obj = obj;
        this.fieldName = str;
        this.classname = null;
        AppMethodBeat.o(70119);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A:{Splitter:B:5:0x001a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:22:0x0067, code skipped:
            r1.getSuperclass();
            com.tencent.matrix.trace.core.AppMethodBeat.o(70120);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void prepare() {
        AppMethodBeat.i(70120);
        if (this.inited) {
            AppMethodBeat.o(70120);
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
                AppMethodBeat.o(70120);
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
        AppMethodBeat.o(70120);
    }

    public final T get() {
        AppMethodBeat.i(70121);
        prepare();
        if (this.eum == null) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
            AppMethodBeat.o(70121);
            throw noSuchFieldException;
        }
        try {
            Object obj = this.eum.get(this.obj);
            AppMethodBeat.o(70121);
            return obj;
        } catch (ClassCastException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unable to cast object");
            AppMethodBeat.o(70121);
            throw illegalArgumentException;
        }
    }

    public final boolean Mg() {
        AppMethodBeat.i(70122);
        prepare();
        if (this.eum != null) {
            AppMethodBeat.o(70122);
            return true;
        }
        AppMethodBeat.o(70122);
        return false;
    }
}
