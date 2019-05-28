package com.tencent.p177mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.location.C14865a;
import com.tencent.p177mm.pluginsdk.location.C14866b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.location.model.j */
public final class C21172j implements C14865a {
    /* renamed from: h */
    int f4386h = 300;
    HashMap<Long, WeakReference<ImageView>> nJU = new HashMap();
    HashMap<Long, C5136b> nJV = new HashMap();
    HashMap<Long, WeakReference<ProgressBar>> nJW = new HashMap();
    HashMap<Long, WeakReference<ImageView>> nJX = new HashMap();
    HashMap<C5136b, C7620bi> nJY = new HashMap();
    HashMap<Long, Integer> nJZ = new HashMap();
    HashSet<Long> nKa = new HashSet();
    /* renamed from: w */
    int f4387w = 300;

    public C21172j() {
        AppMethodBeat.m2504i(113326);
        start();
        AppMethodBeat.m2505o(113326);
    }

    /* Access modifiers changed, original: final */
    public final void start() {
        AppMethodBeat.m2504i(113327);
        C39287l.bJw().mo73938a(this);
        AppMethodBeat.m2505o(113327);
    }

    /* renamed from: a */
    public final void mo27185a(String str, C14866b c14866b) {
        AppMethodBeat.m2504i(113328);
        if (c14866b == null) {
            AppMethodBeat.m2505o(113328);
        } else if (this.nJV.containsKey(Long.valueOf(c14866b.itemId))) {
            C7620bi c7620bi = (C7620bi) this.nJY.remove((C5136b) this.nJV.get(Long.valueOf(c14866b.itemId)));
            if (c7620bi == null) {
                AppMethodBeat.m2505o(113328);
                return;
            }
            WeakReference weakReference = (WeakReference) this.nJU.get(Long.valueOf(c7620bi.field_msgId));
            if (weakReference == null || weakReference.get() == null) {
                AppMethodBeat.m2505o(113328);
            } else if (this.nJZ.containsKey(Long.valueOf(c7620bi.field_msgId))) {
                ((ImageView) weakReference.get()).setImageBitmap(C32291o.ahl().mo73084a(c7620bi.field_msgId, str, ((Integer) this.nJZ.remove(Long.valueOf(c7620bi.field_msgId))).intValue(), this.f4387w, this.f4386h, c7620bi.field_isSend == 0));
                weakReference = (WeakReference) this.nJW.remove(Long.valueOf(c7620bi.field_msgId));
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((ProgressBar) weakReference.get()).setVisibility(8);
                }
                WeakReference weakReference2 = (WeakReference) this.nJX.remove(Long.valueOf(c7620bi.field_msgId));
                if (!(weakReference2 == null || weakReference2.get() == null)) {
                    ((ImageView) weakReference2.get()).setVisibility(0);
                }
                AppMethodBeat.m2505o(113328);
            } else {
                AppMethodBeat.m2505o(113328);
            }
        } else {
            AppMethodBeat.m2505o(113328);
        }
    }

    /* renamed from: a */
    public final void mo27184a(C14866b c14866b) {
        AppMethodBeat.m2504i(113329);
        if (c14866b == null) {
            AppMethodBeat.m2505o(113329);
        } else if (this.nJV.containsKey(Long.valueOf(c14866b.itemId))) {
            C7620bi c7620bi = (C7620bi) this.nJY.remove((C5136b) this.nJV.get(Long.valueOf(c14866b.itemId)));
            if (c7620bi == null) {
                AppMethodBeat.m2505o(113329);
                return;
            }
            this.nJU.get(Long.valueOf(c7620bi.field_msgId));
            if (c7620bi != null && (c7620bi.dJB < 0 || c7620bi.dJB > 5)) {
                c7620bi.mo14789id(0);
                c7620bi.mo14789id(c7620bi.dJB + 1);
                if (C1720g.m3531RK()) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c7620bi.field_msgId, c7620bi);
                    C4990ab.m7417i("MicroMsg.StaticMapMsgLogic", "on error count %d", Integer.valueOf(c7620bi.dJB));
                }
            }
            AppMethodBeat.m2505o(113329);
        } else {
            AppMethodBeat.m2505o(113329);
        }
    }
}
