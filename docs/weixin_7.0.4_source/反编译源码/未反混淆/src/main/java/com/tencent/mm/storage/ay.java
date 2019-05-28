package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class ay extends j<ax> implements e {
    public static final String[] fnj = new String[]{j.a(ax.ccO, "fmessage_msginfo")};
    private static final String[] xIq = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )"};
    public com.tencent.mm.sdk.e.e bSd;

    static {
        AppMethodBeat.i(1302);
        AppMethodBeat.o(1302);
    }

    public ay(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, ax.ccO, "fmessage_msginfo", xIq);
        this.bSd = eVar;
    }

    public final ax[] apv(String str) {
        AppMethodBeat.i(1294);
        ab.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
        Cursor a = this.bSd.a("select *, rowid from fmessage_msginfo  where talker = '" + bo.vA(str) + "' order by createTime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            ax axVar = new ax();
            axVar.d(a);
            arrayList.add(axVar);
        }
        a.close();
        ax[] axVarArr = (ax[]) arrayList.toArray(new ax[arrayList.size()]);
        AppMethodBeat.o(1294);
        return axVarArr;
    }

    public final ax apw(String str) {
        ax axVar = null;
        AppMethodBeat.i(1295);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
            AppMethodBeat.o(1295);
        } else {
            Cursor a = this.bSd.a("select * from fmessage_msginfo where talker = '" + bo.vA(str) + "' order by createTime DESC limit 1", null, 2);
            axVar = new ax();
            if (a.moveToFirst()) {
                axVar.d(a);
            }
            a.close();
            AppMethodBeat.o(1295);
        }
        return axVar;
    }

    public final ax apx(String str) {
        AppMethodBeat.i(1296);
        ax[] eq = eq(str, 1);
        if (eq == null || eq.length <= 0) {
            AppMethodBeat.o(1296);
            return null;
        }
        ax axVar = eq[0];
        AppMethodBeat.o(1296);
        return axVar;
    }

    public final ax[] eq(String str, int i) {
        AppMethodBeat.i(1297);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
            AppMethodBeat.o(1297);
            return null;
        }
        Cursor a = this.bSd.a("select * from fmessage_msginfo where isSend != 1 and talker = '" + bo.vA(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            ax axVar = new ax();
            axVar.d(a);
            arrayList.add(axVar);
        }
        a.close();
        ax[] axVarArr = (ax[]) arrayList.toArray(new ax[arrayList.size()]);
        AppMethodBeat.o(1297);
        return axVarArr;
    }

    public final boolean b(ax axVar) {
        AppMethodBeat.i(1298);
        if (axVar == null) {
            ab.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
            AppMethodBeat.o(1298);
            return false;
        } else if (super.b((c) axVar)) {
            anF(axVar.xDa);
            AppMethodBeat.o(1298);
            return true;
        } else {
            AppMethodBeat.o(1298);
            return false;
        }
    }

    public final List<ax> bOw() {
        AppMethodBeat.i(1299);
        ab.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, type = 0");
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("select *, rowid from fmessage_msginfo where type = 0", null, 2);
        while (a.moveToNext()) {
            ax axVar = new ax();
            axVar.d(a);
            arrayList.add(axVar);
        }
        a.close();
        ab.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + arrayList.size());
        AppMethodBeat.o(1299);
        return arrayList;
    }

    public final boolean QS(String str) {
        AppMethodBeat.i(1300);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
            AppMethodBeat.o(1300);
            return false;
        }
        boolean hY = this.bSd.hY("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + bo.vA(str) + "'");
        AppMethodBeat.o(1300);
        return hY;
    }
}
