package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<T> implements b<T> {
    private Class<? extends T> aIl;
    private Config ayC;

    public a(Class<? extends T> cls) {
        this(cls, (byte) 0);
    }

    private a(Class<? extends T> cls, byte b) {
        this.aIl = cls;
        this.ayC = null;
    }

    public final T or() {
        AppMethodBeat.i(115606);
        if (this.ayC == null) {
            Object newInstance = this.aIl.newInstance();
            AppMethodBeat.o(115606);
            return newInstance;
        }
        T newInstance2 = this.aIl.getConstructor(new Class[]{Config.class}).newInstance(new Object[]{this.ayC});
        AppMethodBeat.o(115606);
        return newInstance2;
    }
}
