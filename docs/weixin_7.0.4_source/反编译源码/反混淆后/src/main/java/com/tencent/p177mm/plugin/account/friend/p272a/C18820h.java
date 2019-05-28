package com.tencent.p177mm.plugin.account.friend.p272a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.account.friend.a.h */
public final class C18820h extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public C7480h fni;

    public C18820h(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: wa */
    public final Cursor mo34098wa(String str) {
        AppMethodBeat.m2504i(108334);
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" where ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        Cursor a = this.fni.mo10104a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0);
        AppMethodBeat.m2505o(108334);
        return a;
    }

    /* renamed from: a */
    public final boolean mo34096a(C45497g c45497g) {
        boolean z;
        AppMethodBeat.m2504i(108335);
        String str = "Func Set always conv_flag == flag_all";
        if (c45497g.bJt == -1) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        Cursor a = this.fni.mo10104a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + C5046bo.m7586vA(String.valueOf(c45497g.dtU)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            int update = this.fni.update("facebookfriend", c45497g.mo73287Hl(), "fbid=?", new String[]{c45497g.dtU});
            if (update > 0) {
                doNotify();
            }
            if (update > 0) {
                AppMethodBeat.m2505o(108335);
                return true;
            }
            AppMethodBeat.m2505o(108335);
            return false;
        }
        if (c45497g != null) {
            c45497g.bJt = -1;
            if (((int) this.fni.insert("facebookfriend", "fbid", c45497g.mo73287Hl())) != -1) {
                AppMethodBeat.m2505o(108335);
                return true;
            }
        }
        AppMethodBeat.m2505o(108335);
        return false;
    }

    public final boolean apM() {
        AppMethodBeat.m2504i(108336);
        boolean hY = this.fni.mo10108hY("facebookfriend", "delete from facebookfriend");
        AppMethodBeat.m2505o(108336);
        return hY;
    }

    /* renamed from: wb */
    public final C45497g mo34099wb(String str) {
        C45497g c45497g = null;
        AppMethodBeat.m2504i(108337);
        Cursor a = this.fni.mo10104a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.username = \"" + str + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(108337);
        } else {
            if (a.moveToFirst()) {
                c45497g = new C45497g();
                c45497g.mo73290d(a);
            }
            a.close();
            AppMethodBeat.m2505o(108337);
        }
        return c45497g;
    }
}
