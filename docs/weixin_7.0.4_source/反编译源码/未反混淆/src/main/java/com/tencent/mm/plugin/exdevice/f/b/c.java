package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c implements f {
    public f lwf;
    public com.tencent.mm.plugin.exdevice.f.a.f lwg;

    public c() {
        AppMethodBeat.i(19478);
        ab.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        aw.Rg().a(1042, (f) this);
        aw.Rg().a(1041, (f) this);
        aw.Rg().a((int) FilterEnum4Shaka.MIC_SHAKA_ADD2_8, (f) this);
        aw.Rg().a(1040, (f) this);
        AppMethodBeat.o(19478);
    }

    public static void d(String str, String str2, String str3, int i) {
        AppMethodBeat.i(19479);
        aw.Rg().a(new l(str3, str2, i, str), 0);
        AppMethodBeat.o(19479);
    }

    public static ArrayList<d> Kn(String str) {
        ArrayList<d> arrayList = null;
        AppMethodBeat.i(19480);
        ab.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
            AppMethodBeat.o(19480);
        } else {
            com.tencent.mm.plugin.exdevice.f.b.b.d boX = ad.boX();
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
                AppMethodBeat.o(19480);
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceRankInfo", "rankID", b.SCORE});
                Cursor a = boX.bSd.a(format, new String[]{bo.bc(str, "")}, 2);
                if (a == null) {
                    ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    AppMethodBeat.o(19480);
                } else {
                    if (a.moveToFirst()) {
                        arrayList = new ArrayList();
                        do {
                            d dVar = new d();
                            dVar.d(a);
                            arrayList.add(dVar);
                        } while (a.moveToNext());
                    } else {
                        ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    }
                    a.close();
                    AppMethodBeat.o(19480);
                }
            }
        }
        return arrayList;
    }

    public static void f(String str, ArrayList<d> arrayList) {
        AppMethodBeat.i(19481);
        com.tencent.mm.plugin.exdevice.f.b.b.d boX = ad.boX();
        Assert.assertTrue(!bo.isNullOrNil(str));
        if (arrayList != null) {
            int i;
            Cursor a = boX.bSd.a(String.format("select COUNT(*) from %s where %s = ?", new Object[]{"HardDeviceRankInfo", "rankID"}), new String[]{bo.bc(str, "")}, 2);
            if (a == null) {
                ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i = 0;
            } else {
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    i = 0;
                }
                a.close();
            }
            Iterator it;
            if (i == 0) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    boX.a((d) it.next(), false);
                }
                AppMethodBeat.o(19481);
                return;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                boX.b((d) it.next(), false);
            }
            AppMethodBeat.o(19481);
            return;
        }
        ab.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
        AppMethodBeat.o(19481);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19482);
        ab.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (mVar instanceof j) {
            if (!(i == 0 && i2 == 0)) {
                ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
                AppMethodBeat.o(19482);
                return;
            }
        } else if (mVar instanceof l) {
            if (!(i == 0 && i2 == 0)) {
                ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
                AppMethodBeat.o(19482);
                return;
            }
        } else if ((mVar instanceof com.tencent.mm.plugin.exdevice.f.a.m) && !(i == 0 && i2 == 0)) {
            ab.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
        }
        AppMethodBeat.o(19482);
    }
}
