package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "HardDeviceChampionInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(19506);
        AppMethodBeat.o(19506);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "HardDeviceChampionInfo", null);
        AppMethodBeat.i(19503);
        this.bSd = eVar;
        eVar.hY("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
        AppMethodBeat.o(19503);
    }

    public final a Kr(String str) {
        a aVar = null;
        AppMethodBeat.i(19504);
        String format = String.format("select *, rowid from %s where %s = ? limit 1", new Object[]{"HardDeviceChampionInfo", "username"});
        Cursor a = this.bSd.a(format, new String[]{bo.bc(str, "")}, 2);
        if (a == null) {
            ab.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
            AppMethodBeat.o(19504);
        } else {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.d(a);
            } else {
                ab.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
            }
            a.close();
            AppMethodBeat.o(19504);
        }
        return aVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(19505);
        Assert.assertTrue(aVar != null);
        if (c(aVar, "username")) {
            ab.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
            ad.bpf().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            AppMethodBeat.o(19505);
            return true;
        } else if (b((c) aVar)) {
            ab.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
            ad.bpf().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            AppMethodBeat.o(19505);
            return true;
        } else {
            ab.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
            AppMethodBeat.o(19505);
            return false;
        }
    }
}
