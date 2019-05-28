package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class f<T> {
    private WeakReference<T> eQD;
    private a eQE = new a("");
    private final int eQF;
    public int height = 0;
    public int width = 0;

    public f(T t) {
        this.eQD = new WeakReference(t);
        if (t != null) {
            this.eQF = t.hashCode();
        } else {
            this.eQF = hashCode();
        }
    }

    public final View getView() {
        if (this.eQD != null) {
            Object obj = this.eQD.get();
            if (obj != null && (obj instanceof View)) {
                return (View) obj;
            }
        }
        return null;
    }
}
