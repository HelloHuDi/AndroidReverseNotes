package com.tencent.p177mm.p707ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ba.b */
public final class C45179b extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public C7480h fni;

    public C45179b(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: b */
    public final boolean mo73164b(C37504a c37504a) {
        AppMethodBeat.m2504i(78434);
        Assert.assertTrue(c37504a != null);
        ContentValues Hl = c37504a.mo60438Hl();
        if (Hl.size() > 0) {
            if (this.fni.update("chattingbginfo", Hl, "username= ?", new String[]{c37504a.getUsername()}) > 0) {
                anF(c37504a.getUsername());
                AppMethodBeat.m2505o(78434);
                return true;
            }
        }
        AppMethodBeat.m2505o(78434);
        return false;
    }

    /* renamed from: sU */
    public final C37504a mo73165sU(String str) {
        C37504a c37504a = null;
        AppMethodBeat.m2504i(78435);
        Cursor a = this.fni.mo10104a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(78435);
        } else {
            if (a.moveToFirst()) {
                c37504a = new C37504a();
                c37504a.mo60439d(a);
            }
            a.close();
            AppMethodBeat.m2505o(78435);
        }
        return c37504a;
    }

    /* renamed from: a */
    public final boolean mo73163a(C37504a c37504a) {
        AppMethodBeat.m2504i(78433);
        c37504a.bJt = -1;
        if (((int) this.fni.insert("chattingbginfo", "username", c37504a.mo60438Hl())) != -1) {
            anF(c37504a.getUsername());
            AppMethodBeat.m2505o(78433);
            return true;
        }
        AppMethodBeat.m2505o(78433);
        return false;
    }
}
