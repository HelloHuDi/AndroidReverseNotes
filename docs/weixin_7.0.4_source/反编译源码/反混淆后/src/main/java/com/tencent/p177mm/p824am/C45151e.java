package com.tencent.p177mm.p824am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.am.e */
public final class C45151e extends C1812ai {
    public final void transfer(int i) {
        AppMethodBeat.m2504i(16433);
        C4990ab.m7411d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (mo5386kw(i)) {
            C7060h.pYm.mo15419k(336, 10, 1);
            long currentTimeMillis = System.currentTimeMillis();
            C9638aw.m17190ZK();
            if (C5046bo.m7567h((Integer) C18628c.m29072Ry().get(86017, null)) == 3) {
                C4990ab.m7420w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
                AppMethodBeat.m2505o(16433);
                return;
            }
            C9638aw.m17190ZK();
            C18628c.m29069Ru().mo10108hY("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
            C9638aw.m17190ZK();
            Cursor c = C18628c.m29078XM().mo15734c("@all.weixin.android", "", null);
            c.moveToFirst();
            while (!c.isAfterLast()) {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(c);
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo15739d(c7616ad.field_username, c7616ad);
                c.moveToNext();
            }
            c.close();
            C4990ab.m7411d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(86017, Integer.valueOf(3));
            C4990ab.m7410d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            AppMethodBeat.m2505o(16433);
            return;
        }
        C4990ab.m7420w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
        AppMethodBeat.m2505o(16433);
    }

    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 604176383;
    }

    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
