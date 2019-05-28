package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;

public final class l implements a {
    private static l yXL;
    HashSet<Long> yXM = new HashSet();
    a yXN;

    private l() {
        AppMethodBeat.i(32399);
        AppMethodBeat.o(32399);
    }

    public static l dGI() {
        AppMethodBeat.i(32400);
        if (yXL == null) {
            yXL = new l();
        }
        l lVar = yXL;
        AppMethodBeat.o(32400);
        return lVar;
    }

    public final boolean nr(long j) {
        AppMethodBeat.i(32401);
        boolean contains = this.yXM.contains(Long.valueOf(j));
        AppMethodBeat.o(32401);
        return contains;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
        AppMethodBeat.i(32402);
        if (this.yXN != null) {
            this.yXN.a(j, j2, i, i2, obj, i3, i4, mVar);
        }
        AppMethodBeat.o(32402);
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(32403);
        if (this.yXN != null) {
            this.yXN.a(j, j2, i, i2, obj, i3, i4, str, mVar);
        } else {
            aw.ZK();
            ab.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", Long.valueOf(c.XO().jf(j2).field_msgId));
            c.b(ah.getContext(), r2, false);
        }
        this.yXM.remove(Long.valueOf(j2));
        AppMethodBeat.o(32403);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.i(32404);
        if (this.yXN != null) {
            this.yXN.a(j, j2, i, i2, obj);
        }
        this.yXM.remove(Long.valueOf(j2));
        AppMethodBeat.o(32404);
    }
}
