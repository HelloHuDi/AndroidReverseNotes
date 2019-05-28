package com.tencent.p177mm.plugin.gallery.p427ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.gallery.ui.e */
final class C43150e {
    int aaF = -1;
    private C44743c mQS;

    public C43150e(C44743c c44743c) {
        this.mQS = c44743c;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wB */
    public final void mo68672wB(int i) {
        AppMethodBeat.m2504i(21496);
        C44743c c44743c = this.mQS;
        if (c44743c.mOH == null || c44743c.mOH.size() <= i || i < 0) {
            AppMethodBeat.m2505o(21496);
            return;
        }
        long j = ((MediaItem) c44743c.mOH.get(i)).mOk;
        String str = ((MediaItem) c44743c.mOH.get(i)).lZg;
        String str2 = ((MediaItem) c44743c.mOH.get(i)).fPT;
        if (C5046bo.isNullOrNil(str)) {
            str = str2;
        }
        C34237e.bBY().mo68659b(str, ((MediaItem) c44743c.mOH.get(i)).getType(), str2, j);
        AppMethodBeat.m2505o(21496);
    }
}
