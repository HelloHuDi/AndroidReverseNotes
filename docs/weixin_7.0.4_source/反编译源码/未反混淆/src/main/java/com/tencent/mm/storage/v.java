package com.tencent.mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.model.ag;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v extends j<u> implements a, ag {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    public static final String[] fnj = new String[]{j.a(u.ccO, "chatroom")};
    private e bSd;

    static {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_HEICHA);
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_HEICHA);
    }

    public v(e eVar) {
        super(eVar, u.ccO, "chatroom", diI);
        this.bSd = eVar;
    }

    public final u oa(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_FEIHONG);
        c uVar = new u();
        uVar.field_chatroomname = str;
        if (super.b(uVar, "chatroomname")) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_FEIHONG);
            return uVar;
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_FEIHONG);
        return null;
    }

    public final u ob(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_SHIZI);
        c uVar = new u();
        uVar.field_chatroomname = str;
        if (super.b(uVar, "chatroomname")) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_SHIZI);
        } else {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_SHIZI);
        }
        return uVar;
    }

    public final void n(String str, long j) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_HUANGDAN);
        this.bSd.hY("chatroom", "update chatroom set modifytime = " + j + " where chatroomname = '" + bo.vA(str) + "'");
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_HUANGDAN);
    }

    public final String oc(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.bSd.a("select roomowner from chatroom where chatroomname='" + bo.vA(str) + "'", null, 2);
        if (a == null) {
            ab.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
            return null;
        }
        u uVar;
        if (a.moveToFirst()) {
            uVar = new u();
            uVar.d(a);
        } else {
            uVar = null;
        }
        a.close();
        if (uVar == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
            return null;
        }
        String str2 = uVar.field_roomowner;
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
        return str2;
    }

    public final String od(String str) {
        u uVar;
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_XINXUE);
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.bSd.a("select memberlist from chatroom where chatroomname='" + bo.vA(str) + "'", null, 2);
        if (a.moveToFirst()) {
            uVar = new u();
            uVar.d(a);
        } else {
            uVar = null;
        }
        a.close();
        if (uVar == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_XINXUE);
            return null;
        }
        String str2 = uVar.field_memberlist;
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_XINXUE);
        return str2;
    }

    public final int oh(String str) {
        u uVar = null;
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_LIULI);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Cursor a = this.bSd.a("select memberCount from chatroom where chatroomname='" + bo.vA(str) + "'", null, 2);
            if (a.moveToFirst()) {
                uVar = new u();
                uVar.d(a);
            }
            a.close();
            if (uVar == null) {
                ab.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
                return 0;
            }
            if (uVar.field_memberCount < 0) {
                int length = od(str).split(";").length;
                uVar.field_memberCount = length;
                this.bSd.hY("chatroom", "update chatroom set memberCount = " + length + " where chatroomname = '" + bo.vA(str) + "'");
                ab.i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", str, Integer.valueOf(length));
            }
            int i = uVar.field_memberCount;
            ab.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
            return i;
        } catch (Throwable th) {
            ab.i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
        }
    }

    public final String mJ(String str) {
        u uVar;
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_MUDAN);
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.bSd.a("select displayname from chatroom where chatroomname='" + bo.vA(str) + "'", null, 2);
        if (a.moveToFirst()) {
            uVar = new u();
            uVar.d(a);
        } else {
            uVar = null;
        }
        a.close();
        if (uVar == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_MUDAN);
            return null;
        }
        String str2 = uVar.field_displayname;
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_MUDAN);
        return str2;
    }

    public final List<String> oe(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_MENGHUANG);
        String od = od(str);
        if (od == null) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_MENGHUANG);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (!od.equals("")) {
            String[] split = od.split(";");
            for (Object add : split) {
                linkedList.add(add);
            }
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_MENGHUANG);
        return linkedList;
    }

    public final boolean of(String str) {
        u uVar = null;
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_CHAZHI);
        Cursor a = this.bSd.a("select * from chatroom where chatroomname='" + bo.vA(str) + "'", null, 2);
        if (a.moveToFirst()) {
            uVar = new u();
            uVar.d(a);
        }
        a.close();
        if (uVar == null || (uVar.field_roomflag & 1) != 0) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_CHAZHI);
            return false;
        }
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_CHAZHI);
        return true;
    }

    public final boolean og(String str) {
        AppMethodBeat.i(FilterEnum4Shaka.MIC_WEISHI_LIUJIN);
        Assert.assertTrue(str.length() > 0);
        if (this.bSd.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_LIUJIN);
            return false;
        }
        anF(str);
        AppMethodBeat.o(FilterEnum4Shaka.MIC_WEISHI_LIUJIN);
        return true;
    }

    public final int a(g gVar) {
        return 0;
    }
}
