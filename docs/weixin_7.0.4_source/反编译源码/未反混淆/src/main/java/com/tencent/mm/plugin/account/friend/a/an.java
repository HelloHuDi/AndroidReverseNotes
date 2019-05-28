package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class an extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )"};
    public final h fni;

    public an(h hVar) {
        this.fni = hVar;
    }

    public final am mY(int i) {
        am amVar = null;
        AppMethodBeat.i(108496);
        Cursor a = this.fni.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = ".concat(String.valueOf(i)), null, 2);
        if (a == null) {
            AppMethodBeat.o(108496);
        } else {
            if (a.moveToFirst()) {
                amVar = new am();
                amVar.d(a);
            }
            a.close();
            AppMethodBeat.o(108496);
        }
        return amVar;
    }

    public final boolean a(am amVar) {
        AppMethodBeat.i(108497);
        Assert.assertTrue(amVar != null);
        ContentValues aqk = amVar.aqk();
        if (aqk.size() <= 0) {
            ab.e("MicroMsg.QQGroupStorage", "update failed, no values set");
            AppMethodBeat.o(108497);
            return false;
        }
        if (this.fni.update("qqgroup", aqk, "grouopid= ?", new String[]{amVar.gwu}) <= 0) {
            AppMethodBeat.o(108497);
            return false;
        }
        doNotify();
        AppMethodBeat.o(108497);
        return true;
    }
}
