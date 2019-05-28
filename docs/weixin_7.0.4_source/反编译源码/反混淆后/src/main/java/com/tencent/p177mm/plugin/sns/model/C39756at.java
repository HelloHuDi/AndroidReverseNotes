package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p520ui.C4052bb;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.model.at */
public final class C39756at implements C29057e {
    public List<WeakReference<C29057e>> qNf = new LinkedList();

    public C39756at() {
        AppMethodBeat.m2504i(36670);
        AppMethodBeat.m2505o(36670);
    }

    /* renamed from: a */
    public final void mo62858a(C29057e c29057e) {
        AppMethodBeat.m2504i(36671);
        for (WeakReference weakReference : this.qNf) {
            if (weakReference != null && weakReference.get() != null && ((C29057e) weakReference.get()).equals(c29057e)) {
                AppMethodBeat.m2505o(36671);
                return;
            }
        }
        this.qNf.add(new WeakReference(c29057e));
        AppMethodBeat.m2505o(36671);
    }

    /* renamed from: a */
    public final void mo37369a(int i, String str, long j, TimeLineObject timeLineObject, boolean z, C4052bb c4052bb) {
        AppMethodBeat.m2504i(36672);
        for (WeakReference weakReference : this.qNf) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((C29057e) weakReference.get()).mo37369a(i, str, j, timeLineObject, z, c4052bb);
            }
        }
        AppMethodBeat.m2505o(36672);
    }

    /* renamed from: a */
    public final void mo37368a(int i, String str, long j, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.m2504i(36673);
        for (WeakReference weakReference : this.qNf) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((C29057e) weakReference.get()).mo37368a(i, str, j, timeLineObject, z);
            }
        }
        AppMethodBeat.m2505o(36673);
    }
}
