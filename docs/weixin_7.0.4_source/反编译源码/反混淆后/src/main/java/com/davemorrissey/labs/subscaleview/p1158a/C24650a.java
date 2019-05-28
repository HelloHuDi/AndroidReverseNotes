package com.davemorrissey.labs.subscaleview.p1158a;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.davemorrissey.labs.subscaleview.a.a */
public final class C24650a<T> implements C17564b<T> {
    private Class<? extends T> aIl;
    private Config ayC;

    public C24650a(Class<? extends T> cls) {
        this(cls, (byte) 0);
    }

    private C24650a(Class<? extends T> cls, byte b) {
        this.aIl = cls;
        this.ayC = null;
    }

    /* renamed from: or */
    public final T mo31995or() {
        AppMethodBeat.m2504i(115606);
        if (this.ayC == null) {
            Object newInstance = this.aIl.newInstance();
            AppMethodBeat.m2505o(115606);
            return newInstance;
        }
        T newInstance2 = this.aIl.getConstructor(new Class[]{Config.class}).newInstance(new Object[]{this.ayC});
        AppMethodBeat.m2505o(115606);
        return newInstance2;
    }
}
