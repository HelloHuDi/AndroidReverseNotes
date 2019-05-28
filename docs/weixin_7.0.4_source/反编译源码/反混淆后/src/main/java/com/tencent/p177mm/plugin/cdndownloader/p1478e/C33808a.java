package com.tencent.p177mm.plugin.cdndownloader.p1478e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.cdndownloader.e.a */
public final class C33808a<E> extends HashSet<E> {
    private C33809b ktx;

    public C33808a(C33809b c33809b) {
        this.ktx = c33809b;
    }

    private synchronized void beY() {
        AppMethodBeat.m2504i(932);
        this.ktx.beX();
        AppMethodBeat.m2505o(932);
    }

    private synchronized void beZ() {
        AppMethodBeat.m2504i(933);
        this.ktx.remove();
        AppMethodBeat.m2505o(933);
    }

    private synchronized void bfa() {
        AppMethodBeat.m2504i(934);
        this.ktx.clear();
        AppMethodBeat.m2505o(934);
    }

    public final synchronized boolean add(E e) {
        boolean add;
        AppMethodBeat.m2504i(935);
        add = super.add(e);
        beY();
        AppMethodBeat.m2505o(935);
        return add;
    }

    public final void clear() {
        AppMethodBeat.m2504i(936);
        super.clear();
        bfa();
        AppMethodBeat.m2505o(936);
    }

    public final synchronized boolean remove(Object obj) {
        boolean remove;
        AppMethodBeat.m2504i(937);
        remove = super.remove(obj);
        beZ();
        AppMethodBeat.m2505o(937);
        return remove;
    }
}
