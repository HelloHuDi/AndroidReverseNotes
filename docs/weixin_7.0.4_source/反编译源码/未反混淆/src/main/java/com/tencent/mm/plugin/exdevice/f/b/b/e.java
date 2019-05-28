package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e extends j<com.tencent.mm.plugin.exdevice.f.b.a.e> {
    public static final String[] fnj = new String[]{j.a(com.tencent.mm.plugin.exdevice.f.b.a.e.ccO, "HardDeviceLikeUser")};
    private com.tencent.mm.sdk.e.e bSd;

    static {
        AppMethodBeat.i(19518);
        AppMethodBeat.o(19518);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, com.tencent.mm.plugin.exdevice.f.b.a.e.ccO, "HardDeviceLikeUser", null);
        AppMethodBeat.i(19515);
        this.bSd = eVar;
        eVar.hY("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
        AppMethodBeat.o(19515);
    }

    public final ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> Ks(String str) {
        ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList = null;
        AppMethodBeat.i(19516);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
            AppMethodBeat.o(19516);
        } else {
            String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceLikeUser", "rankID", Param.TIMESTAMP});
            Cursor a = this.bSd.a(format, new String[]{bo.bc(str, "")}, 2);
            if (a == null) {
                ab.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
                AppMethodBeat.o(19516);
            } else {
                if (a.moveToFirst()) {
                    arrayList = new ArrayList();
                    do {
                        com.tencent.mm.plugin.exdevice.f.b.a.e eVar = new com.tencent.mm.plugin.exdevice.f.b.a.e();
                        eVar.d(a);
                        arrayList.add(eVar);
                    } while (a.moveToNext());
                }
                a.close();
                AppMethodBeat.o(19516);
            }
        }
        return arrayList;
    }

    public final void a(String str, String str2, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList) {
        AppMethodBeat.i(19517);
        Assert.assertTrue(!bo.isNullOrNil(str));
        if (arrayList == null) {
            ab.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
            AppMethodBeat.o(19517);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            boolean z;
            com.tencent.mm.plugin.exdevice.f.b.a.e eVar = (com.tencent.mm.plugin.exdevice.f.b.a.e) it.next();
            if (eVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (c(eVar, "rankID", "username")) {
                ab.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
            } else if (b((c) eVar)) {
                ab.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
            } else {
                ab.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
            }
        }
        ad.bpf().a("HardDeviceLikeUser", new d(str, str2, null));
        AppMethodBeat.o(19517);
    }
}
