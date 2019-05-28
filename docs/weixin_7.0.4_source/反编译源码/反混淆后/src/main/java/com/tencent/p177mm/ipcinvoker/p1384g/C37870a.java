package com.tencent.p177mm.ipcinvoker.p1384g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.ipcinvoker.g.a */
public final class C37870a<FieldType> {
    private Class<?> eGE;
    private String eGF;
    private Field mField;
    private boolean mInited;

    public C37870a(Class<?> cls, String str) {
        AppMethodBeat.m2504i(114116);
        if (str.length() == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
            AppMethodBeat.m2505o(114116);
            throw illegalArgumentException;
        }
        this.eGE = cls;
        this.eGF = str;
        AppMethodBeat.m2505o(114116);
    }

    private synchronized void prepare() {
        AppMethodBeat.m2504i(114117);
        if (this.mInited) {
            AppMethodBeat.m2505o(114117);
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
            AppMethodBeat.m2505o(114117);
        }
    }

    /* renamed from: PU */
    private synchronized FieldType m63907PU() {
        FieldType fieldType = null;
        synchronized (this) {
            AppMethodBeat.m2504i(114118);
            prepare();
            if (this.mField == null) {
                C26340b.m41918w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", this.eGF);
                AppMethodBeat.m2505o(114118);
            } else {
                try {
                    fieldType = this.mField.get(null);
                    AppMethodBeat.m2505o(114118);
                } catch (ClassCastException e) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unable to cast object");
                    AppMethodBeat.m2505o(114118);
                    throw illegalArgumentException;
                }
            }
        }
        return fieldType;
    }

    /* renamed from: PV */
    public final synchronized FieldType mo60592PV() {
        FieldType fieldType;
        AppMethodBeat.m2504i(114119);
        fieldType = null;
        try {
            fieldType = m63907PU();
        } catch (NoSuchFieldException e) {
            C26340b.m41917i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e);
        } catch (IllegalAccessException e2) {
            C26340b.m41917i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e2);
        } catch (IllegalArgumentException e3) {
            C26340b.m41917i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e3);
        }
        AppMethodBeat.m2505o(114119);
        return fieldType;
    }
}
