package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.account.friend.a.an */
public final class C26585an extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )"};
    public final C7480h fni;

    public C26585an(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: mY */
    public final C26584am mo44366mY(int i) {
        C26584am c26584am = null;
        AppMethodBeat.m2504i(108496);
        Cursor a = this.fni.mo10104a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = ".concat(String.valueOf(i)), null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(108496);
        } else {
            if (a.moveToFirst()) {
                c26584am = new C26584am();
                c26584am.mo44364d(a);
            }
            a.close();
            AppMethodBeat.m2505o(108496);
        }
        return c26584am;
    }

    /* renamed from: a */
    public final boolean mo44365a(C26584am c26584am) {
        AppMethodBeat.m2504i(108497);
        Assert.assertTrue(c26584am != null);
        ContentValues aqk = c26584am.aqk();
        if (aqk.size() <= 0) {
            C4990ab.m7412e("MicroMsg.QQGroupStorage", "update failed, no values set");
            AppMethodBeat.m2505o(108497);
            return false;
        }
        if (this.fni.update("qqgroup", aqk, "grouopid= ?", new String[]{c26584am.gwu}) <= 0) {
            AppMethodBeat.m2505o(108497);
            return false;
        }
        doNotify();
        AppMethodBeat.m2505o(108497);
        return true;
    }
}
