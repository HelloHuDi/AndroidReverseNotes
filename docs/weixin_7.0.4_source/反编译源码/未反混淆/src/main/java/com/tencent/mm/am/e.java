package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class e extends ai {
    public final void transfer(int i) {
        AppMethodBeat.i(16433);
        ab.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (kw(i)) {
            h.pYm.k(336, 10, 1);
            long currentTimeMillis = System.currentTimeMillis();
            aw.ZK();
            if (bo.h((Integer) c.Ry().get(86017, null)) == 3) {
                ab.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
                AppMethodBeat.o(16433);
                return;
            }
            aw.ZK();
            c.Ru().hY("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
            aw.ZK();
            Cursor c = c.XM().c("@all.weixin.android", "", null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                ad adVar = new ad();
                adVar.d(c);
                aw.ZK();
                c.XM().d(adVar.field_username, adVar);
                c.moveToNext();
            }
            c.close();
            ab.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            aw.ZK();
            c.Ry().set(86017, Integer.valueOf(3));
            ab.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            AppMethodBeat.o(16433);
            return;
        }
        ab.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
        AppMethodBeat.o(16433);
    }

    public final boolean kw(int i) {
        return i != 0 && i < 604176383;
    }

    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
