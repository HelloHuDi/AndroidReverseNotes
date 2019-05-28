package com.tencent.p177mm;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C1241c;
import com.tencent.p177mm.api.C25784s;
import com.tencent.p177mm.api.C25784s.C25785a;
import com.tencent.p177mm.api.C25784s.C25786b;
import com.tencent.p177mm.api.C25784s.C8957c;
import com.tencent.p177mm.api.C37464n;
import com.tencent.p177mm.api.C37465p;
import com.tencent.p177mm.cache.ArtistCacheManager;
import com.tencent.p177mm.cache.ArtistCacheManager.C181231;
import com.tencent.p177mm.cache.ArtistCacheManager.C18126a;
import com.tencent.p177mm.p843bx.C41913c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.view.C16051a;
import com.tencent.p177mm.view.C46718d;
import com.tencent.p177mm.view.C5739b;

/* renamed from: com.tencent.mm.a */
public final class C17865a extends C25784s {
    private C16051a cbM;
    private C37465p cbN;

    /* renamed from: com.tencent.mm.a$a */
    public static class C17866a implements C25786b {
        /* renamed from: Ae */
        public final C25784s mo33296Ae() {
            AppMethodBeat.m2504i(116127);
            C17865a c17865a = new C17865a();
            AppMethodBeat.m2505o(116127);
            return c17865a;
        }
    }

    /* renamed from: aQ */
    public final C1241c mo33294aQ(Context context) {
        AppMethodBeat.m2504i(116128);
        if (this.cbM == null) {
            if (this.ccP.ccR == C8957c.VIDEO) {
                this.cbM = new C46718d(context, this.ccP);
            } else if (this.ccP.ccR == C8957c.PHOTO) {
                this.cbM = new C5739b(context, this.ccP);
            }
        }
        C16051a c16051a = this.cbM;
        AppMethodBeat.m2505o(116128);
        return c16051a;
    }

    /* renamed from: a */
    public final void mo33293a(C25785a c25785a) {
        AppMethodBeat.m2504i(116131);
        super.mo33293a(c25785a);
        ArtistCacheManager Jc = ArtistCacheManager.m28552Jc();
        String bc = C5046bo.m7532bc(this.ccP.path, "MicroMsg.MMPhotoEditorImpl");
        Jc.efl = bc;
        if (!ArtistCacheManager.efj.containsKey(bc)) {
            ArtistCacheManager.efj.put(bc, new C18126a());
        }
        AppMethodBeat.m2505o(116131);
    }

    /* renamed from: Ac */
    public final C37465p mo33290Ac() {
        AppMethodBeat.m2504i(116133);
        if (this.cbN == null) {
            this.cbN = new C41913c(this.cbM.getPresenter());
        }
        C37465p c37465p = this.cbN;
        AppMethodBeat.m2505o(116133);
        return c37465p;
    }

    /* renamed from: Ad */
    public final void mo33291Ad() {
        AppMethodBeat.m2504i(116134);
        ArtistCacheManager.m28552Jc().mo33606Jd();
        AppMethodBeat.m2505o(116134);
    }

    /* renamed from: a */
    public final void mo33292a(C37464n c37464n) {
        AppMethodBeat.m2504i(116129);
        this.cbM.getPresenter().mo33563a(c37464n, !mo33290Ac().mo60382Ay());
        AppMethodBeat.m2505o(116129);
    }

    /* renamed from: Ab */
    public final boolean mo33289Ab() {
        AppMethodBeat.m2504i(116130);
        boolean Ab = this.cbM.getPresenter().mo33559Ab();
        AppMethodBeat.m2505o(116130);
        return Ab;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(116132);
        if (!this.ccP.ccS) {
            ArtistCacheManager Jc = ArtistCacheManager.m28552Jc();
            String bc = C5046bo.m7532bc(this.ccP.path, "MicroMsg.MMPhotoEditorImpl");
            Jc.efl = null;
            if (ArtistCacheManager.efj.containsKey(bc)) {
                ((C18126a) ArtistCacheManager.efj.get(bc)).clearAll();
                ArtistCacheManager.efj.remove(bc);
            }
            C7305d.post(new C181231(), "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
        if (this.cbM != null) {
            this.cbM.getPresenter().onDestroy();
        }
        try {
            this.cbM.getChatFooterPanel().destroy();
            AppMethodBeat.m2505o(116132);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMPhotoEditorImpl", "[onDestroy] may be has destory!");
            AppMethodBeat.m2505o(116132);
        }
    }
}
