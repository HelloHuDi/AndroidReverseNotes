package com.tencent.p177mm.plugin.fav.p408b.p970f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C43056e;
import com.tencent.p177mm.plugin.fav.p407a.C6895s;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.b.f.b */
public final class C34132b extends C7563j<C43056e> implements C6895s {
    private C4927e bSd;

    public C34132b(C4927e c4927e) {
        super(c4927e, C43056e.ccO, "FavConfigInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: aV */
    public final void mo15172aV(byte[] bArr) {
        AppMethodBeat.m2504i(5422);
        C43056e bvt = bvt();
        boolean c;
        if (8216 == bvt.field_configId) {
            bvt.field_value = C5046bo.m7543cd(bArr);
            c = mo10103c(bvt, new String[0]);
            C4990ab.m7417i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", bvt.field_value, Boolean.valueOf(c));
            AppMethodBeat.m2505o(5422);
            return;
        }
        bvt.field_configId = 8216;
        bvt.field_value = C5046bo.m7543cd(bArr);
        c = mo10101b((C4925c) bvt);
        C4990ab.m7417i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", bvt.field_value, Boolean.valueOf(c));
        AppMethodBeat.m2505o(5422);
    }

    private C43056e bvt() {
        AppMethodBeat.m2504i(5423);
        C43056e c43056e = new C43056e();
        C4990ab.m7411d("MicroMsg.FavConfigStorage", "get fav config sql %s", "select * from FavConfigInfo where configId = 8216");
        Cursor a = this.bSd.mo10104a("select * from FavConfigInfo where configId = 8216", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                c43056e.mo8995d(a);
            }
            a.close();
        }
        AppMethodBeat.m2505o(5423);
        return c43056e;
    }

    public final byte[] buP() {
        byte[] anf;
        AppMethodBeat.m2504i(5424);
        C43056e bvt = bvt();
        if (8216 != bvt.field_configId) {
            C4990ab.m7420w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
            C1720g.m3537RQ();
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(8224, Boolean.FALSE)).booleanValue()) {
                C4990ab.m7420w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
            } else {
                C1720g.m3537RQ();
                C4990ab.m7417i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8216, (Object) "")));
                anf = C5046bo.anf(r0);
                mo15172aV(anf);
                C4990ab.m7420w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(8224, Boolean.TRUE);
                AppMethodBeat.m2505o(5424);
                return anf;
            }
        }
        C4990ab.m7417i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", Integer.valueOf(bvt.field_configId), bvt.field_value);
        anf = C5046bo.anf(bvt.field_value);
        AppMethodBeat.m2505o(5424);
        return anf;
    }
}
