package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class h extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public com.tencent.mm.cd.h fni;

    public h(com.tencent.mm.cd.h hVar) {
        this.fni = hVar;
    }

    public final Cursor wa(String str) {
        AppMethodBeat.i(108334);
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" where ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        Cursor a = this.fni.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0);
        AppMethodBeat.o(108334);
        return a;
    }

    public final boolean a(g gVar) {
        boolean z;
        AppMethodBeat.i(108335);
        String str = "Func Set always conv_flag == flag_all";
        if (gVar.bJt == -1) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        Cursor a = this.fni.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + bo.vA(String.valueOf(gVar.dtU)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            int update = this.fni.update("facebookfriend", gVar.Hl(), "fbid=?", new String[]{gVar.dtU});
            if (update > 0) {
                doNotify();
            }
            if (update > 0) {
                AppMethodBeat.o(108335);
                return true;
            }
            AppMethodBeat.o(108335);
            return false;
        }
        if (gVar != null) {
            gVar.bJt = -1;
            if (((int) this.fni.insert("facebookfriend", "fbid", gVar.Hl())) != -1) {
                AppMethodBeat.o(108335);
                return true;
            }
        }
        AppMethodBeat.o(108335);
        return false;
    }

    public final boolean apM() {
        AppMethodBeat.i(108336);
        boolean hY = this.fni.hY("facebookfriend", "delete from facebookfriend");
        AppMethodBeat.o(108336);
        return hY;
    }

    public final g wb(String str) {
        g gVar = null;
        AppMethodBeat.i(108337);
        Cursor a = this.fni.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(108337);
        } else {
            if (a.moveToFirst()) {
                gVar = new g();
                gVar.d(a);
            }
            a.close();
            AppMethodBeat.o(108337);
        }
        return gVar;
    }
}
