package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d extends j<com.tencent.mm.plugin.exdevice.f.b.a.d> {
    public static final String[] fnj = new String[]{j.a(com.tencent.mm.plugin.exdevice.f.b.a.d.ccO, "HardDeviceRankInfo")};
    public e bSd;

    static {
        AppMethodBeat.i(19514);
        AppMethodBeat.o(19514);
    }

    public d(e eVar) {
        super(eVar, com.tencent.mm.plugin.exdevice.f.b.a.d.ccO, "HardDeviceRankInfo", null);
        AppMethodBeat.i(19508);
        this.bSd = eVar;
        eVar.hY("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
        AppMethodBeat.o(19508);
    }

    public final com.tencent.mm.plugin.exdevice.f.b.a.d a(com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        com.tencent.mm.plugin.exdevice.f.b.a.d dVar2 = null;
        AppMethodBeat.i(19509);
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankInfo", "rankID", "username"});
        Cursor a = this.bSd.a(format, new String[]{bo.bc(dVar.lvL, ""), bo.bc(dVar.username, "")}, 2);
        if (a == null) {
            ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
            AppMethodBeat.o(19509);
        } else {
            if (a.moveToFirst()) {
                dVar2 = new com.tencent.mm.plugin.exdevice.f.b.a.d();
                dVar2.d(a);
            } else {
                ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            }
            a.close();
            AppMethodBeat.o(19509);
        }
        return dVar2;
    }

    public final void g(String str, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> arrayList) {
        AppMethodBeat.i(19510);
        if (bo.isNullOrNil(str) || arrayList == null) {
            ab.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
            AppMethodBeat.o(19510);
            return;
        }
        ab.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", str, Integer.valueOf(arrayList.size()));
        for (int i = 0; i < arrayList.size(); i++) {
            a((com.tencent.mm.plugin.exdevice.f.b.a.d) arrayList.get(i), false);
        }
        ad.bpf().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(str, null, null));
        AppMethodBeat.o(19510);
    }

    public final boolean a(com.tencent.mm.plugin.exdevice.f.b.a.d dVar, boolean z) {
        AppMethodBeat.i(19511);
        if (b(dVar, z)) {
            AppMethodBeat.o(19511);
        } else {
            c(dVar, z);
            AppMethodBeat.o(19511);
        }
        return true;
    }

    public final boolean b(com.tencent.mm.plugin.exdevice.f.b.a.d dVar, boolean z) {
        AppMethodBeat.i(19512);
        Assert.assertTrue(dVar != null);
        com.tencent.mm.plugin.exdevice.f.b.a.d a = a(new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        if (a != null) {
            a.field_likecount = dVar.field_likecount;
            a.field_selfLikeState = dVar.field_selfLikeState;
            c(a, "rankID", "username");
            ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
            if (z) {
                ad.bpf().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
            }
            AppMethodBeat.o(19512);
            return true;
        }
        AppMethodBeat.o(19512);
        return false;
    }

    private boolean c(com.tencent.mm.plugin.exdevice.f.b.a.d dVar, boolean z) {
        AppMethodBeat.i(19513);
        Assert.assertTrue(dVar != null);
        b((c) dVar);
        ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
        if (z) {
            ad.bpf().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        }
        AppMethodBeat.o(19513);
        return true;
    }
}
