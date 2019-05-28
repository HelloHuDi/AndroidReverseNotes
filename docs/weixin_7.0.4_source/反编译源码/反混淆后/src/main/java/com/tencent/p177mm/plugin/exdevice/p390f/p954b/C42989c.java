package com.tencent.p177mm.plugin.exdevice.p390f.p954b;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C2968f;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C34023j;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C34026m;
import com.tencent.p177mm.plugin.exdevice.p390f.p391a.C38936l;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C45882d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34029d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.c */
public final class C42989c implements C1202f {
    public C11647f lwf;
    public C2968f lwg;

    public C42989c() {
        AppMethodBeat.m2504i(19478);
        C4990ab.m7410d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        C9638aw.m17182Rg().mo14539a(1042, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1041, (C1202f) this);
        C9638aw.m17182Rg().mo14539a((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_8, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1040, (C1202f) this);
        AppMethodBeat.m2505o(19478);
    }

    /* renamed from: d */
    public static void m76340d(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(19479);
        C9638aw.m17182Rg().mo14541a(new C38936l(str3, str2, i, str), 0);
        AppMethodBeat.m2505o(19479);
    }

    /* renamed from: Kn */
    public static ArrayList<C34029d> m76339Kn(String str) {
        ArrayList<C34029d> arrayList = null;
        AppMethodBeat.m2504i(19480);
        C4990ab.m7410d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
            AppMethodBeat.m2505o(19480);
        } else {
            C45882d boX = C45891ad.boX();
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
                AppMethodBeat.m2505o(19480);
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceRankInfo", "rankID", C8741b.SCORE});
                Cursor a = boX.bSd.mo10104a(format, new String[]{C5046bo.m7532bc(str, "")}, 2);
                if (a == null) {
                    C4990ab.m7412e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    AppMethodBeat.m2505o(19480);
                } else {
                    if (a.moveToFirst()) {
                        arrayList = new ArrayList();
                        do {
                            C34029d c34029d = new C34029d();
                            c34029d.mo8995d(a);
                            arrayList.add(c34029d);
                        } while (a.moveToNext());
                    } else {
                        C4990ab.m7410d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    }
                    a.close();
                    AppMethodBeat.m2505o(19480);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static void m76341f(String str, ArrayList<C34029d> arrayList) {
        AppMethodBeat.m2504i(19481);
        C45882d boX = C45891ad.boX();
        Assert.assertTrue(!C5046bo.isNullOrNil(str));
        if (arrayList != null) {
            int i;
            Cursor a = boX.bSd.mo10104a(String.format("select COUNT(*) from %s where %s = ?", new Object[]{"HardDeviceRankInfo", "rankID"}), new String[]{C5046bo.m7532bc(str, "")}, 2);
            if (a == null) {
                C4990ab.m7412e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i = 0;
            } else {
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    C4990ab.m7410d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    i = 0;
                }
                a.close();
            }
            Iterator it;
            if (i == 0) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    boX.mo73713a((C34029d) it.next(), false);
                }
                AppMethodBeat.m2505o(19481);
                return;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                boX.mo73714b((C34029d) it.next(), false);
            }
            AppMethodBeat.m2505o(19481);
            return;
        }
        C4990ab.m7420w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
        AppMethodBeat.m2505o(19481);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19482);
        C4990ab.m7411d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (c1207m instanceof C34023j) {
            if (!(i == 0 && i2 == 0)) {
                C4990ab.m7420w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
                AppMethodBeat.m2505o(19482);
                return;
            }
        } else if (c1207m instanceof C38936l) {
            if (!(i == 0 && i2 == 0)) {
                C4990ab.m7420w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
                AppMethodBeat.m2505o(19482);
                return;
            }
        } else if ((c1207m instanceof C34026m) && !(i == 0 && i2 == 0)) {
            C4990ab.m7420w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
        }
        AppMethodBeat.m2505o(19482);
    }
}
