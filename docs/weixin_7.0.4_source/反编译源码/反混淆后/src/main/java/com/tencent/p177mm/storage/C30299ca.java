package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.storage.ca */
public final class C30299ca extends C7563j<C23512bz> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C23512bz.ccO, "UserOpenIdInApp")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(29075);
        AppMethodBeat.m2505o(29075);
    }

    public C30299ca(C4927e c4927e) {
        super(c4927e, C23512bz.ccO, "UserOpenIdInApp", null);
        AppMethodBeat.m2504i(29071);
        this.bSd = c4927e;
        c4927e.mo10108hY("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        c4927e.mo10108hY("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
        AppMethodBeat.m2505o(29071);
    }

    public final C23512bz apZ(String str) {
        AppMethodBeat.m2504i(29072);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(29072);
            return null;
        }
        Cursor a = this.bSd.mo10105a("UserOpenIdInApp", null, "openId=?", new String[]{C5046bo.m7586vA(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            C23512bz c23512bz = new C23512bz();
            c23512bz.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(29072);
            return c23512bz;
        }
        C4990ab.m7420w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.m2505o(29072);
        return null;
    }

    /* renamed from: a */
    public final boolean mo48505a(C23512bz c23512bz) {
        AppMethodBeat.m2504i(29073);
        if (c23512bz == null || C5046bo.isNullOrNil(c23512bz.field_appId) || C5046bo.isNullOrNil(c23512bz.field_openId) || C5046bo.isNullOrNil(c23512bz.field_username)) {
            C4990ab.m7420w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            AppMethodBeat.m2505o(29073);
            return false;
        }
        boolean z;
        if (this.bSd.replace("UserOpenIdInApp", C23512bz.ccO.xDc, c23512bz.mo10098Hl()) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7411d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", c23512bz.field_appId, c23512bz.field_username, Boolean.valueOf(z));
        AppMethodBeat.m2505o(29073);
        return z;
    }
}
