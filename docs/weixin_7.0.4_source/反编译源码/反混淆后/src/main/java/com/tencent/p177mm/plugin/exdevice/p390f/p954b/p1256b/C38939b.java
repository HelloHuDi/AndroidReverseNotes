package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C27834d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C11646a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.b.b */
public final class C38939b extends C7563j<C11646a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C11646a.ccO, "HardDeviceChampionInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(19506);
        AppMethodBeat.m2505o(19506);
    }

    public C38939b(C4927e c4927e) {
        super(c4927e, C11646a.ccO, "HardDeviceChampionInfo", null);
        AppMethodBeat.m2504i(19503);
        this.bSd = c4927e;
        c4927e.mo10108hY("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
        AppMethodBeat.m2505o(19503);
    }

    /* renamed from: Kr */
    public final C11646a mo61824Kr(String str) {
        C11646a c11646a = null;
        AppMethodBeat.m2504i(19504);
        String format = String.format("select *, rowid from %s where %s = ? limit 1", new Object[]{"HardDeviceChampionInfo", "username"});
        Cursor a = this.bSd.mo10104a(format, new String[]{C5046bo.m7532bc(str, "")}, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
            AppMethodBeat.m2505o(19504);
        } else {
            if (a.moveToFirst()) {
                c11646a = new C11646a();
                c11646a.mo8995d(a);
            } else {
                C4990ab.m7410d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
            }
            a.close();
            AppMethodBeat.m2505o(19504);
        }
        return c11646a;
    }

    /* renamed from: a */
    public final boolean mo61825a(C11646a c11646a) {
        AppMethodBeat.m2504i(19505);
        Assert.assertTrue(c11646a != null);
        if (mo10103c(c11646a, "username")) {
            C4990ab.m7410d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
            C45891ad.bpf().mo61822a("HardDeviceChampionInfo", new C27834d(null, null, c11646a.field_username));
            AppMethodBeat.m2505o(19505);
            return true;
        } else if (mo10101b((C4925c) c11646a)) {
            C4990ab.m7410d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
            C45891ad.bpf().mo61822a("HardDeviceChampionInfo", new C27834d(null, null, c11646a.field_username));
            AppMethodBeat.m2505o(19505);
            return true;
        } else {
            C4990ab.m7420w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
            AppMethodBeat.m2505o(19505);
            return false;
        }
    }
}
