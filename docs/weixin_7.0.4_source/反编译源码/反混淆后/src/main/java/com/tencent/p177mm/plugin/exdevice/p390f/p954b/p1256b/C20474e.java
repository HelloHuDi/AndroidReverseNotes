package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b;

import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C27834d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C38937e;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.b.e */
public final class C20474e extends C7563j<C38937e> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C38937e.ccO, "HardDeviceLikeUser")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(19518);
        AppMethodBeat.m2505o(19518);
    }

    public C20474e(C4927e c4927e) {
        super(c4927e, C38937e.ccO, "HardDeviceLikeUser", null);
        AppMethodBeat.m2504i(19515);
        this.bSd = c4927e;
        c4927e.mo10108hY("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
        AppMethodBeat.m2505o(19515);
    }

    /* renamed from: Ks */
    public final ArrayList<C38937e> mo35789Ks(String str) {
        ArrayList<C38937e> arrayList = null;
        AppMethodBeat.m2504i(19516);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
            AppMethodBeat.m2505o(19516);
        } else {
            String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceLikeUser", "rankID", Param.TIMESTAMP});
            Cursor a = this.bSd.mo10104a(format, new String[]{C5046bo.m7532bc(str, "")}, 2);
            if (a == null) {
                C4990ab.m7412e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
                AppMethodBeat.m2505o(19516);
            } else {
                if (a.moveToFirst()) {
                    arrayList = new ArrayList();
                    do {
                        C38937e c38937e = new C38937e();
                        c38937e.mo8995d(a);
                        arrayList.add(c38937e);
                    } while (a.moveToNext());
                }
                a.close();
                AppMethodBeat.m2505o(19516);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo35790a(String str, String str2, ArrayList<C38937e> arrayList) {
        AppMethodBeat.m2504i(19517);
        Assert.assertTrue(!C5046bo.isNullOrNil(str));
        if (arrayList == null) {
            C4990ab.m7416i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
            AppMethodBeat.m2505o(19517);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            boolean z;
            C38937e c38937e = (C38937e) it.next();
            if (c38937e != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (mo10103c(c38937e, "rankID", "username")) {
                C4990ab.m7410d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
            } else if (mo10101b((C4925c) c38937e)) {
                C4990ab.m7410d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
            } else {
                C4990ab.m7420w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
            }
        }
        C45891ad.bpf().mo61822a("HardDeviceLikeUser", new C27834d(str, str2, null));
        AppMethodBeat.m2505o(19517);
    }
}
