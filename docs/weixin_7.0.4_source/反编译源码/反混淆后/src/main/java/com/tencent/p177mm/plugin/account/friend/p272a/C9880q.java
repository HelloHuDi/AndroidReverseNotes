package com.tencent.p177mm.plugin.account.friend.p272a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.a.q */
public final class C9880q extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private C7480h fni;

    public C9880q(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: a */
    private boolean m17520a(C45499p c45499p) {
        AppMethodBeat.m2504i(108402);
        if (c45499p == null) {
            AppMethodBeat.m2505o(108402);
            return false;
        }
        c45499p.bJt = -1;
        if (((int) this.fni.insert("invitefriendopen", "username", c45499p.mo73293Hl())) != -1) {
            AppMethodBeat.m2505o(108402);
            return true;
        }
        AppMethodBeat.m2505o(108402);
        return false;
    }

    /* renamed from: b */
    public final boolean mo21239b(C45499p c45499p) {
        AppMethodBeat.m2504i(108403);
        boolean c;
        if (mo21240wi(c45499p.getUsername())) {
            c = m17521c(c45499p);
            AppMethodBeat.m2505o(108403);
            return c;
        }
        c = m17520a(c45499p);
        AppMethodBeat.m2505o(108403);
        return c;
    }

    /* renamed from: wi */
    public final boolean mo21240wi(String str) {
        AppMethodBeat.m2504i(108405);
        Cursor a = this.fni.mo10104a("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.m2505o(108405);
        return moveToFirst;
    }

    /* renamed from: c */
    private boolean m17521c(C45499p c45499p) {
        AppMethodBeat.m2504i(108404);
        c45499p.bJt = -1;
        if (this.fni.update("invitefriendopen", c45499p.mo73293Hl(), "username=?", new String[]{c45499p.getUsername()}) > 0) {
            AppMethodBeat.m2505o(108404);
            return true;
        }
        AppMethodBeat.m2505o(108404);
        return false;
    }
}
