package com.tencent.p177mm.loader.p246e.p247b;

import android.view.View;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.loader.e.b.f */
public final class C32731f<T> {
    private WeakReference<T> eQD;
    private C42156a eQE = new C42156a("");
    private final int eQF;
    public int height = 0;
    public int width = 0;

    public C32731f(T t) {
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
