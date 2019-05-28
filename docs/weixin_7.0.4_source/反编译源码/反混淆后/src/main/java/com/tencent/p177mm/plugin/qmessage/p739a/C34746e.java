package com.tencent.p177mm.plugin.qmessage.p739a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.qmessage.a.e */
public final class C34746e extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS qcontact ( username text  PRIMARY KEY , qq long  , extinfo text  , needupdate int  , extupdateseq long  , imgupdateseq long  , reserved1 int  , reserved2 int  , reserved3 int  , reserved4 int  , reserved5 text  , reserved6 text  , reserved7 text  , reserved8 text  ) "};
    private C7480h fni;

    public C34746e(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: a */
    public final boolean mo55346a(String str, C12873d c12873d) {
        AppMethodBeat.m2504i(24083);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (c12873d == null) {
            AppMethodBeat.m2505o(24083);
            return false;
        }
        if (this.fni.update("qcontact", c12873d.mo24896Hl(), "username=?", new String[]{str}) > 0) {
            AppMethodBeat.m2505o(24083);
            return true;
        }
        AppMethodBeat.m2505o(24083);
        return false;
    }

    /* renamed from: Vb */
    public final C12873d mo55344Vb(String str) {
        C12873d c12873d = null;
        AppMethodBeat.m2504i(24084);
        Cursor a = this.fni.mo10104a("select qcontact.username,qcontact.qq,qcontact.extinfo,qcontact.needupdate,qcontact.extupdateseq,qcontact.imgupdateseq,qcontact.reserved1,qcontact.reserved2,qcontact.reserved3,qcontact.reserved4,qcontact.reserved5,qcontact.reserved6,qcontact.reserved7,qcontact.reserved8 from qcontact   where qcontact.username = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(24084);
        } else {
            if (a.moveToFirst()) {
                c12873d = new C12873d();
                c12873d.mo24898d(a);
            }
            a.close();
            AppMethodBeat.m2505o(24084);
        }
        return c12873d;
    }

    /* renamed from: a */
    public final boolean mo55345a(C12873d c12873d) {
        AppMethodBeat.m2504i(24082);
        c12873d.bJt = -1;
        if (((int) this.fni.insert("qcontact", "username", c12873d.mo24896Hl())) != -1) {
            AppMethodBeat.m2505o(24082);
            return true;
        }
        AppMethodBeat.m2505o(24082);
        return false;
    }
}
