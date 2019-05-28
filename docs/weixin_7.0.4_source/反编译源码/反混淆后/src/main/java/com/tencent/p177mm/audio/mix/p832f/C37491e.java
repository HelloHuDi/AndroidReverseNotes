package com.tencent.p177mm.audio.mix.p832f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;

/* renamed from: com.tencent.mm.audio.mix.f.e */
public final class C37491e<T> {
    private T cnY;

    public C37491e(T t) {
        this.cnY = t;
    }

    /* renamed from: al */
    public final synchronized T mo60421al(T t) {
        Object obj;
        AppMethodBeat.m2504i(137194);
        obj = this.cnY;
        this.cnY = t;
        C45174b.m83209i("StateRunner", obj.toString() + " -> " + this.cnY.toString());
        AppMethodBeat.m2505o(137194);
        return obj;
    }

    /* renamed from: g */
    public final synchronized boolean mo60422g(T... tArr) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(137195);
            for (int i = 0; i <= 0; i++) {
                if (this.cnY.equals(tArr[0])) {
                    z = true;
                    AppMethodBeat.m2505o(137195);
                    break;
                }
            }
            AppMethodBeat.m2505o(137195);
        }
        return z;
    }

    public final synchronized T get() {
        return this.cnY;
    }
}
