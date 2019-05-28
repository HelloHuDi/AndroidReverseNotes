package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ca extends j<bz> {
    public static final String[] fnj = new String[]{j.a(bz.ccO, "UserOpenIdInApp")};
    public e bSd;

    static {
        AppMethodBeat.i(29075);
        AppMethodBeat.o(29075);
    }

    public ca(e eVar) {
        super(eVar, bz.ccO, "UserOpenIdInApp", null);
        AppMethodBeat.i(29071);
        this.bSd = eVar;
        eVar.hY("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        eVar.hY("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
        AppMethodBeat.o(29071);
    }

    public final bz apZ(String str) {
        AppMethodBeat.i(29072);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(29072);
            return null;
        }
        Cursor a = this.bSd.a("UserOpenIdInApp", null, "openId=?", new String[]{bo.vA(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bz bzVar = new bz();
            bzVar.d(a);
            a.close();
            AppMethodBeat.o(29072);
            return bzVar;
        }
        ab.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.o(29072);
        return null;
    }

    public final boolean a(bz bzVar) {
        AppMethodBeat.i(29073);
        if (bzVar == null || bo.isNullOrNil(bzVar.field_appId) || bo.isNullOrNil(bzVar.field_openId) || bo.isNullOrNil(bzVar.field_username)) {
            ab.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            AppMethodBeat.o(29073);
            return false;
        }
        boolean z;
        if (this.bSd.replace("UserOpenIdInApp", bz.ccO.xDc, bzVar.Hl()) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", bzVar.field_appId, bzVar.field_username, Boolean.valueOf(z));
        AppMethodBeat.o(29073);
        return z;
    }
}
