package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class at implements e {
    public List<WeakReference<e>> qNf = new LinkedList();

    public at() {
        AppMethodBeat.i(36670);
        AppMethodBeat.o(36670);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(36671);
        for (WeakReference weakReference : this.qNf) {
            if (weakReference != null && weakReference.get() != null && ((e) weakReference.get()).equals(eVar)) {
                AppMethodBeat.o(36671);
                return;
            }
        }
        this.qNf.add(new WeakReference(eVar));
        AppMethodBeat.o(36671);
    }

    public final void a(int i, String str, long j, TimeLineObject timeLineObject, boolean z, bb bbVar) {
        AppMethodBeat.i(36672);
        for (WeakReference weakReference : this.qNf) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, timeLineObject, z, bbVar);
            }
        }
        AppMethodBeat.o(36672);
    }

    public final void a(int i, String str, long j, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.i(36673);
        for (WeakReference weakReference : this.qNf) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, timeLineObject, z);
            }
        }
        AppMethodBeat.o(36673);
    }
}
