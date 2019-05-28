package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.storage.bp */
public final class C30298bp extends C7563j<C23511bo> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C23511bo.ccO, "OpenMsgListener")};
    public C4927e bSd;

    /* renamed from: a */
    public final /* synthetic */ boolean mo10099a(C4925c c4925c) {
        AppMethodBeat.m2504i(29068);
        C23511bo c23511bo = (C23511bo) c4925c;
        if (c23511bo == null || C5046bo.isNullOrNil(c23511bo.field_appId)) {
            C4990ab.m7420w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            AppMethodBeat.m2505o(29068);
            return false;
        }
        C4990ab.m7411d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", c23511bo.field_appId, Boolean.valueOf(this.bSd.replace("OpenMsgListener", C23511bo.ccO.xDc, c23511bo.mo10098Hl()) > 0));
        AppMethodBeat.m2505o(29068);
        return this.bSd.replace("OpenMsgListener", C23511bo.ccO.xDc, c23511bo.mo10098Hl()) > 0;
    }

    static {
        AppMethodBeat.m2504i(29069);
        AppMethodBeat.m2505o(29069);
    }

    public C30298bp(C4927e c4927e) {
        super(c4927e, C23511bo.ccO, "OpenMsgListener", null);
        AppMethodBeat.m2504i(29065);
        this.bSd = c4927e;
        c4927e.mo10108hY("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        c4927e.mo10108hY("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
        AppMethodBeat.m2505o(29065);
    }

    public final C23511bo apN(String str) {
        AppMethodBeat.m2504i(29066);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(29066);
            return null;
        }
        Cursor a = this.bSd.mo10105a("OpenMsgListener", null, "appId=?", new String[]{C5046bo.m7586vA(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            C23511bo c23511bo = new C23511bo();
            c23511bo.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(29066);
            return c23511bo;
        }
        C4990ab.m7420w("MicroMsg.OpenMsgListenerStorage", "get null with appId:".concat(String.valueOf(str)));
        a.close();
        AppMethodBeat.m2505o(29066);
        return null;
    }

    public final Cursor dui() {
        AppMethodBeat.m2504i(29067);
        Cursor rawQuery = rawQuery("select * from OpenMsgListener where (status = ?) ", "1");
        AppMethodBeat.m2505o(29067);
        return rawQuery;
    }
}
