package com.tencent.mm;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.n;
import com.tencent.mm.api.p;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.b;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.view.d;

public final class a extends s {
    private com.tencent.mm.view.a cbM;
    private p cbN;

    public static class a implements b {
        public final s Ae() {
            AppMethodBeat.i(116127);
            a aVar = new a();
            AppMethodBeat.o(116127);
            return aVar;
        }
    }

    public final c aQ(Context context) {
        AppMethodBeat.i(116128);
        if (this.cbM == null) {
            if (this.ccP.ccR == s.c.VIDEO) {
                this.cbM = new d(context, this.ccP);
            } else if (this.ccP.ccR == s.c.PHOTO) {
                this.cbM = new com.tencent.mm.view.b(context, this.ccP);
            }
        }
        com.tencent.mm.view.a aVar = this.cbM;
        AppMethodBeat.o(116128);
        return aVar;
    }

    public final void a(com.tencent.mm.api.s.a aVar) {
        AppMethodBeat.i(116131);
        super.a(aVar);
        ArtistCacheManager Jc = ArtistCacheManager.Jc();
        String bc = bo.bc(this.ccP.path, "MicroMsg.MMPhotoEditorImpl");
        Jc.efl = bc;
        if (!ArtistCacheManager.efj.containsKey(bc)) {
            ArtistCacheManager.efj.put(bc, new com.tencent.mm.cache.ArtistCacheManager.a());
        }
        AppMethodBeat.o(116131);
    }

    public final p Ac() {
        AppMethodBeat.i(116133);
        if (this.cbN == null) {
            this.cbN = new com.tencent.mm.bx.c(this.cbM.getPresenter());
        }
        p pVar = this.cbN;
        AppMethodBeat.o(116133);
        return pVar;
    }

    public final void Ad() {
        AppMethodBeat.i(116134);
        ArtistCacheManager.Jc().Jd();
        AppMethodBeat.o(116134);
    }

    public final void a(n nVar) {
        AppMethodBeat.i(116129);
        this.cbM.getPresenter().a(nVar, !Ac().Ay());
        AppMethodBeat.o(116129);
    }

    public final boolean Ab() {
        AppMethodBeat.i(116130);
        boolean Ab = this.cbM.getPresenter().Ab();
        AppMethodBeat.o(116130);
        return Ab;
    }

    public final void onDestroy() {
        AppMethodBeat.i(116132);
        if (!this.ccP.ccS) {
            ArtistCacheManager Jc = ArtistCacheManager.Jc();
            String bc = bo.bc(this.ccP.path, "MicroMsg.MMPhotoEditorImpl");
            Jc.efl = null;
            if (ArtistCacheManager.efj.containsKey(bc)) {
                ((com.tencent.mm.cache.ArtistCacheManager.a) ArtistCacheManager.efj.get(bc)).clearAll();
                ArtistCacheManager.efj.remove(bc);
            }
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(116205);
                    com.tencent.mm.ch.a.asR(e.evi);
                    AppMethodBeat.o(116205);
                }
            }, "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
        if (this.cbM != null) {
            this.cbM.getPresenter().onDestroy();
        }
        try {
            this.cbM.getChatFooterPanel().destroy();
            AppMethodBeat.o(116132);
        } catch (Exception e) {
            ab.e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
            AppMethodBeat.o(116132);
        }
    }
}
