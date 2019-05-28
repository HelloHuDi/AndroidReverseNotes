package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.b;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "HardDeviceRankFollowInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(19502);
        AppMethodBeat.o(19502);
    }

    public a(e eVar) {
        super(eVar, c.ccO, "HardDeviceRankFollowInfo", null);
        AppMethodBeat.i(19490);
        this.bSd = eVar;
        eVar.hY("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
        AppMethodBeat.o(19490);
    }

    public final c a(b bVar) {
        AppMethodBeat.i(19491);
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "username", "appusername"});
        Cursor a = this.bSd.a(format, new String[]{bo.bc(bVar.lvL, ""), bo.bc(bVar.username, ""), bo.bc(bVar.appName, "")}, 2);
        if (a == null) {
            ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
            AppMethodBeat.o(19491);
            return null;
        }
        c cVar = null;
        if (a.moveToFirst()) {
            cVar = new c();
            cVar.d(a);
        } else {
            ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
        }
        a.close();
        AppMethodBeat.o(19491);
        return cVar;
    }

    public final boolean Kp(String str) {
        AppMethodBeat.i(19492);
        boolean N = N("hardcode_rank_id", "hardcode_app_name", str);
        AppMethodBeat.o(19492);
        return N;
    }

    private boolean N(String str, String str2, String str3) {
        AppMethodBeat.i(19493);
        String format = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername", "username"});
        Cursor a = this.bSd.a(format, new String[]{bo.bc(str, ""), bo.bc(str2, ""), bo.bc(str3, "")}, 2);
        if (a == null) {
            ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
            AppMethodBeat.o(19493);
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        ab.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", Boolean.valueOf(moveToFirst));
        AppMethodBeat.o(19493);
        return moveToFirst;
    }

    public final ArrayList<c> bpk() {
        ArrayList<c> arrayList = null;
        AppMethodBeat.i(19494);
        String format = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername"});
        Cursor a = this.bSd.a(format, new String[]{"hardcode_rank_id", "hardcode_app_name"}, 2);
        if (a == null) {
            ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
            AppMethodBeat.o(19494);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    c cVar = new c();
                    cVar.d(a);
                    ab.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", Integer.valueOf(a.getColumnIndex("rowid")), cVar.toString());
                    arrayList.add(cVar);
                } while (a.moveToNext());
                ab.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", Integer.valueOf(arrayList.size()), arrayList.toString());
            } else {
                ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            a.close();
            AppMethodBeat.o(19494);
        }
        return arrayList;
    }

    public final void a(ArrayList<ach> arrayList, String str, String str2) {
        AppMethodBeat.i(19495);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ach ach = (ach) it.next();
                c cVar = new c();
                cVar.field_rankID = str;
                cVar.field_step = ach.hzv;
                cVar.field_username = ach.username;
                cVar.field_appusername = str2;
                a(cVar);
            }
        }
        AppMethodBeat.o(19495);
    }

    public final void by(List<c> list) {
        AppMethodBeat.i(19496);
        String str = "hardcode_app_name";
        if (bo.isNullOrNil("hardcode_rank_id") || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
        } else {
            int delete = this.bSd.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[]{r0, str});
            ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", r0, str, Integer.valueOf(delete));
        }
        if (list != null) {
            for (c cVar : list) {
                cVar.field_rankID = "hardcode_rank_id";
                cVar.field_appusername = "hardcode_app_name";
                a(cVar);
            }
        }
        AppMethodBeat.o(19496);
    }

    private boolean a(c cVar) {
        AppMethodBeat.i(19497);
        if (b(cVar)) {
            AppMethodBeat.o(19497);
        } else {
            c(cVar);
            AppMethodBeat.o(19497);
        }
        return true;
    }

    public final boolean Kq(String str) {
        AppMethodBeat.i(19498);
        boolean O = O("hardcode_rank_id", "hardcode_app_name", str);
        AppMethodBeat.o(19498);
        return O;
    }

    private boolean O(String str, String str2, String str3) {
        AppMethodBeat.i(19499);
        c a = a(new b(str, str2, str3));
        if (a != null) {
            a((com.tencent.mm.sdk.e.c) a, "rankID", "appusername", "username");
            ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            AppMethodBeat.o(19499);
            return true;
        }
        AppMethodBeat.o(19499);
        return false;
    }

    private boolean b(c cVar) {
        AppMethodBeat.i(19500);
        Assert.assertTrue(cVar != null);
        c a = a(new b(cVar.field_rankID, cVar.field_appusername, cVar.field_username));
        if (a != null) {
            a.field_step = cVar.field_step;
            c(a, "rankID", "appusername", "username");
            ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            AppMethodBeat.o(19500);
            return true;
        }
        AppMethodBeat.o(19500);
        return false;
    }

    private boolean c(c cVar) {
        AppMethodBeat.i(19501);
        Assert.assertTrue(cVar != null);
        b((com.tencent.mm.sdk.e.c) cVar);
        ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
        AppMethodBeat.o(19501);
        return true;
    }
}
