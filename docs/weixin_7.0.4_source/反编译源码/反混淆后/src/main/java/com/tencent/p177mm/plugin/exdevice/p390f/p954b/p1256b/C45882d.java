package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C27834d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34029d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.b.d */
public final class C45882d extends C7563j<C34029d> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C34029d.ccO, "HardDeviceRankInfo")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(19514);
        AppMethodBeat.m2505o(19514);
    }

    public C45882d(C4927e c4927e) {
        super(c4927e, C34029d.ccO, "HardDeviceRankInfo", null);
        AppMethodBeat.m2504i(19508);
        this.bSd = c4927e;
        c4927e.mo10108hY("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
        AppMethodBeat.m2505o(19508);
    }

    /* renamed from: a */
    public final C34029d mo73712a(C27834d c27834d) {
        C34029d c34029d = null;
        AppMethodBeat.m2504i(19509);
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankInfo", "rankID", "username"});
        Cursor a = this.bSd.mo10104a(format, new String[]{C5046bo.m7532bc(c27834d.lvL, ""), C5046bo.m7532bc(c27834d.username, "")}, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
            AppMethodBeat.m2505o(19509);
        } else {
            if (a.moveToFirst()) {
                c34029d = new C34029d();
                c34029d.mo8995d(a);
            } else {
                C4990ab.m7410d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            }
            a.close();
            AppMethodBeat.m2505o(19509);
        }
        return c34029d;
    }

    /* renamed from: g */
    public final void mo73715g(String str, ArrayList<C34029d> arrayList) {
        AppMethodBeat.m2504i(19510);
        if (C5046bo.isNullOrNil(str) || arrayList == null) {
            C4990ab.m7420w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
            AppMethodBeat.m2505o(19510);
            return;
        }
        C4990ab.m7417i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", str, Integer.valueOf(arrayList.size()));
        for (int i = 0; i < arrayList.size(); i++) {
            mo73713a((C34029d) arrayList.get(i), false);
        }
        C45891ad.bpf().mo61822a("HardDeviceRankInfo", new C27834d(str, null, null));
        AppMethodBeat.m2505o(19510);
    }

    /* renamed from: a */
    public final boolean mo73713a(C34029d c34029d, boolean z) {
        AppMethodBeat.m2504i(19511);
        if (mo73714b(c34029d, z)) {
            AppMethodBeat.m2505o(19511);
        } else {
            m85010c(c34029d, z);
            AppMethodBeat.m2505o(19511);
        }
        return true;
    }

    /* renamed from: b */
    public final boolean mo73714b(C34029d c34029d, boolean z) {
        AppMethodBeat.m2504i(19512);
        Assert.assertTrue(c34029d != null);
        C34029d a = mo73712a(new C27834d(c34029d.field_rankID, c34029d.field_appusername, c34029d.field_username));
        if (a != null) {
            a.field_likecount = c34029d.field_likecount;
            a.field_selfLikeState = c34029d.field_selfLikeState;
            mo10103c(a, "rankID", "username");
            C4990ab.m7410d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
            if (z) {
                C45891ad.bpf().mo61822a("HardDeviceRankInfo", new C27834d(c34029d.field_rankID, c34029d.field_appusername, c34029d.field_username));
            }
            AppMethodBeat.m2505o(19512);
            return true;
        }
        AppMethodBeat.m2505o(19512);
        return false;
    }

    /* renamed from: c */
    private boolean m85010c(C34029d c34029d, boolean z) {
        AppMethodBeat.m2504i(19513);
        Assert.assertTrue(c34029d != null);
        mo10101b((C4925c) c34029d);
        C4990ab.m7410d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
        if (z) {
            C45891ad.bpf().mo61822a("HardDeviceRankInfo", new C27834d(c34029d.field_rankID, c34029d.field_appusername, c34029d.field_username));
        }
        AppMethodBeat.m2505o(19513);
        return true;
    }
}
