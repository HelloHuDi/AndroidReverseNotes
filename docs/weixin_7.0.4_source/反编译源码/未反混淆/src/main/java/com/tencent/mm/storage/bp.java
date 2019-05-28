package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class bp extends j<bo> {
    public static final String[] fnj = new String[]{j.a(bo.ccO, "OpenMsgListener")};
    public e bSd;

    public final /* synthetic */ boolean a(c cVar) {
        AppMethodBeat.i(29068);
        bo boVar = (bo) cVar;
        if (boVar == null || bo.isNullOrNil(boVar.field_appId)) {
            ab.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            AppMethodBeat.o(29068);
            return false;
        }
        ab.d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", boVar.field_appId, Boolean.valueOf(this.bSd.replace("OpenMsgListener", bo.ccO.xDc, boVar.Hl()) > 0));
        AppMethodBeat.o(29068);
        return this.bSd.replace("OpenMsgListener", bo.ccO.xDc, boVar.Hl()) > 0;
    }

    static {
        AppMethodBeat.i(29069);
        AppMethodBeat.o(29069);
    }

    public bp(e eVar) {
        super(eVar, bo.ccO, "OpenMsgListener", null);
        AppMethodBeat.i(29065);
        this.bSd = eVar;
        eVar.hY("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        eVar.hY("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
        AppMethodBeat.o(29065);
    }

    public final bo apN(String str) {
        AppMethodBeat.i(29066);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(29066);
            return null;
        }
        Cursor a = this.bSd.a("OpenMsgListener", null, "appId=?", new String[]{bo.vA(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bo boVar = new bo();
            boVar.d(a);
            a.close();
            AppMethodBeat.o(29066);
            return boVar;
        }
        ab.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.o(29066);
        return null;
    }

    public final Cursor dui() {
        AppMethodBeat.i(29067);
        Cursor rawQuery = rawQuery("select * from OpenMsgListener where (status = ?) ", "1");
        AppMethodBeat.o(29067);
        return rawQuery;
    }
}
