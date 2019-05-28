package com.tencent.p177mm.plugin.record.p493ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26146ge;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3710b;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3711c;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3712a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.record.ui.c */
public final class C28845c implements C3709a {
    public C28845c(Context context) {
        AppMethodBeat.m2504i(24190);
        C26146ge c26146ge = new C26146ge();
        c26146ge.cAt.context = context;
        C4879a.xxA.mo10055m(c26146ge);
        AppMethodBeat.m2505o(24190);
    }

    /* renamed from: a */
    public final void mo8342a(C3712a c3712a) {
        AppMethodBeat.m2504i(24191);
        C4990ab.m7411d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", Long.valueOf(c3712a.pKv));
        C26146ge c26146ge = new C26146ge();
        c26146ge.cAt.opType = 1;
        c26146ge.cAt.cAw = c3712a.cAw;
        c26146ge.cAt.cAv = c3712a.cAv;
        c26146ge.cAt.cvv = c3712a.pKv;
        c26146ge.cAt.cAx = c3712a.cAx;
        c26146ge.cAt.width = c3712a.width;
        c26146ge.cAt.height = c3712a.height;
        C4879a.xxA.mo10055m(c26146ge);
        AppMethodBeat.m2505o(24191);
    }

    /* renamed from: a */
    public final Bitmap mo8341a(C3711c c3711c) {
        AppMethodBeat.m2504i(24192);
        C26146ge c26146ge = new C26146ge();
        c26146ge.cAt.opType = 0;
        c26146ge.cAt.cAv = c3711c.cAv;
        c26146ge.cAt.cvv = c3711c.pKv;
        C4879a.xxA.mo10055m(c26146ge);
        C4990ab.m7411d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", Long.valueOf(c3711c.pKv), c26146ge.cAu.cAB);
        Bitmap bitmap = c26146ge.cAu.cAB;
        AppMethodBeat.m2505o(24192);
        return bitmap;
    }

    /* renamed from: a */
    public final Bitmap mo8340a(C3710b c3710b) {
        AppMethodBeat.m2504i(24193);
        C26146ge c26146ge = new C26146ge();
        c26146ge.cAt.opType = 2;
        c26146ge.cAt.cAA = false;
        if (c3710b.cAy) {
            c26146ge.cAt.cAv = c3710b.cAv;
            c26146ge.cAt.cAy = c3710b.cAy;
        } else {
            c26146ge.cAt.cAv = c3710b.cAv;
            c26146ge.cAt.cvv = c3710b.pKv;
            c26146ge.cAt.maxWidth = c3710b.maxWidth;
            c26146ge.cAt.cAz = c3710b.cAz;
        }
        C4879a.xxA.mo10055m(c26146ge);
        C4990ab.m7411d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", Long.valueOf(c3710b.pKv), c3710b.cAv.mnd, c26146ge.cAu.cAB, Boolean.valueOf(c26146ge.cAt.cAy));
        Bitmap bitmap = c26146ge.cAu.cAB;
        AppMethodBeat.m2505o(24193);
        return bitmap;
    }

    public final void ceH() {
        AppMethodBeat.m2504i(24194);
        C26146ge c26146ge = new C26146ge();
        c26146ge.cAt.opType = 4;
        C4879a.xxA.mo10055m(c26146ge);
        AppMethodBeat.m2505o(24194);
    }
}
