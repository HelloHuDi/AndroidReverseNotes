package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements a {
    int h = 300;
    HashMap<Long, WeakReference<ImageView>> nJU = new HashMap();
    HashMap<Long, b> nJV = new HashMap();
    HashMap<Long, WeakReference<ProgressBar>> nJW = new HashMap();
    HashMap<Long, WeakReference<ImageView>> nJX = new HashMap();
    HashMap<b, bi> nJY = new HashMap();
    HashMap<Long, Integer> nJZ = new HashMap();
    HashSet<Long> nKa = new HashSet();
    int w = 300;

    public j() {
        AppMethodBeat.i(113326);
        start();
        AppMethodBeat.o(113326);
    }

    /* Access modifiers changed, original: final */
    public final void start() {
        AppMethodBeat.i(113327);
        l.bJw().a(this);
        AppMethodBeat.o(113327);
    }

    public final void a(String str, com.tencent.mm.pluginsdk.location.b bVar) {
        AppMethodBeat.i(113328);
        if (bVar == null) {
            AppMethodBeat.o(113328);
        } else if (this.nJV.containsKey(Long.valueOf(bVar.itemId))) {
            bi biVar = (bi) this.nJY.remove((b) this.nJV.get(Long.valueOf(bVar.itemId)));
            if (biVar == null) {
                AppMethodBeat.o(113328);
                return;
            }
            WeakReference weakReference = (WeakReference) this.nJU.get(Long.valueOf(biVar.field_msgId));
            if (weakReference == null || weakReference.get() == null) {
                AppMethodBeat.o(113328);
            } else if (this.nJZ.containsKey(Long.valueOf(biVar.field_msgId))) {
                ((ImageView) weakReference.get()).setImageBitmap(o.ahl().a(biVar.field_msgId, str, ((Integer) this.nJZ.remove(Long.valueOf(biVar.field_msgId))).intValue(), this.w, this.h, biVar.field_isSend == 0));
                weakReference = (WeakReference) this.nJW.remove(Long.valueOf(biVar.field_msgId));
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((ProgressBar) weakReference.get()).setVisibility(8);
                }
                WeakReference weakReference2 = (WeakReference) this.nJX.remove(Long.valueOf(biVar.field_msgId));
                if (!(weakReference2 == null || weakReference2.get() == null)) {
                    ((ImageView) weakReference2.get()).setVisibility(0);
                }
                AppMethodBeat.o(113328);
            } else {
                AppMethodBeat.o(113328);
            }
        } else {
            AppMethodBeat.o(113328);
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.b bVar) {
        AppMethodBeat.i(113329);
        if (bVar == null) {
            AppMethodBeat.o(113329);
        } else if (this.nJV.containsKey(Long.valueOf(bVar.itemId))) {
            bi biVar = (bi) this.nJY.remove((b) this.nJV.get(Long.valueOf(bVar.itemId)));
            if (biVar == null) {
                AppMethodBeat.o(113329);
                return;
            }
            this.nJU.get(Long.valueOf(biVar.field_msgId));
            if (biVar != null && (biVar.dJB < 0 || biVar.dJB > 5)) {
                biVar.id(0);
                biVar.id(biVar.dJB + 1);
                if (g.RK()) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(biVar.field_msgId, biVar);
                    ab.i("MicroMsg.StaticMapMsgLogic", "on error count %d", Integer.valueOf(biVar.dJB));
                }
            }
            AppMethodBeat.o(113329);
        } else {
            AppMethodBeat.o(113329);
        }
    }
}
