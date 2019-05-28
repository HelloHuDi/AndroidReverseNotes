package com.tencent.p177mm.storage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C6663ag;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.v */
public final class C7624v extends C7563j<C7577u> implements C1361a, C6663ag {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    public static final String[] fnj = new String[]{C7563j.m13217a(C7577u.ccO, "chatroom")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_HEICHA);
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_HEICHA);
    }

    public C7624v(C4927e c4927e) {
        super(c4927e, C7577u.ccO, "chatroom", diI);
        this.bSd = c4927e;
    }

    /* renamed from: oa */
    public final C7577u mo14885oa(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_FEIHONG);
        C4925c c7577u = new C7577u();
        c7577u.field_chatroomname = str;
        if (super.mo10102b(c7577u, "chatroomname")) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_FEIHONG);
            return c7577u;
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_FEIHONG);
        return null;
    }

    /* renamed from: ob */
    public final C7577u mo14886ob(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_SHIZI);
        C4925c c7577u = new C7577u();
        c7577u.field_chatroomname = str;
        if (super.mo10102b(c7577u, "chatroomname")) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_SHIZI);
        } else {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_SHIZI);
        }
        return c7577u;
    }

    /* renamed from: n */
    public final void mo14884n(String str, long j) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_HUANGDAN);
        this.bSd.mo10108hY("chatroom", "update chatroom set modifytime = " + j + " where chatroomname = '" + C5046bo.m7586vA(str) + "'");
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_HUANGDAN);
    }

    /* renamed from: oc */
    public final String mo14887oc(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.bSd.mo10104a("select roomowner from chatroom where chatroomname='" + C5046bo.m7586vA(str) + "'", null, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
            return null;
        }
        C7577u c7577u;
        if (a.moveToFirst()) {
            c7577u = new C7577u();
            c7577u.mo8995d(a);
        } else {
            c7577u = null;
        }
        a.close();
        if (c7577u == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
            return null;
        }
        String str2 = c7577u.field_roomowner;
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_SHUILAN);
        return str2;
    }

    /* renamed from: od */
    public final String mo14888od(String str) {
        C7577u c7577u;
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_XINXUE);
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.bSd.mo10104a("select memberlist from chatroom where chatroomname='" + C5046bo.m7586vA(str) + "'", null, 2);
        if (a.moveToFirst()) {
            c7577u = new C7577u();
            c7577u.mo8995d(a);
        } else {
            c7577u = null;
        }
        a.close();
        if (c7577u == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_XINXUE);
            return null;
        }
        String str2 = c7577u.field_memberlist;
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_XINXUE);
        return str2;
    }

    /* renamed from: oh */
    public final int mo14892oh(String str) {
        C7577u c7577u = null;
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_LIULI);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Cursor a = this.bSd.mo10104a("select memberCount from chatroom where chatroomname='" + C5046bo.m7586vA(str) + "'", null, 2);
            if (a.moveToFirst()) {
                c7577u = new C7577u();
                c7577u.mo8995d(a);
            }
            a.close();
            if (c7577u == null) {
                C4990ab.m7417i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
                return 0;
            }
            if (c7577u.field_memberCount < 0) {
                int length = mo14888od(str).split(";").length;
                c7577u.field_memberCount = length;
                this.bSd.mo10108hY("chatroom", "update chatroom set memberCount = " + length + " where chatroomname = '" + C5046bo.m7586vA(str) + "'");
                C4990ab.m7417i("MicroMsg.ChatroomStorage", "[getMemberCount] init field_memberCount! username:%s count:%s", str, Integer.valueOf(length));
            }
            int i = c7577u.field_memberCount;
            C4990ab.m7417i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
            return i;
        } catch (Throwable th) {
            C4990ab.m7417i("MicroMsg.ChatroomStorage", "[getMemberCount] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_LIULI);
        }
    }

    /* renamed from: mJ */
    public final String mo14883mJ(String str) {
        C7577u c7577u;
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_MUDAN);
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.bSd.mo10104a("select displayname from chatroom where chatroomname='" + C5046bo.m7586vA(str) + "'", null, 2);
        if (a.moveToFirst()) {
            c7577u = new C7577u();
            c7577u.mo8995d(a);
        } else {
            c7577u = null;
        }
        a.close();
        if (c7577u == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_MUDAN);
            return null;
        }
        String str2 = c7577u.field_displayname;
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_MUDAN);
        return str2;
    }

    /* renamed from: oe */
    public final List<String> mo14889oe(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_MENGHUANG);
        String od = mo14888od(str);
        if (od == null) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_MENGHUANG);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (!od.equals("")) {
            String[] split = od.split(";");
            for (Object add : split) {
                linkedList.add(add);
            }
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_MENGHUANG);
        return linkedList;
    }

    /* renamed from: of */
    public final boolean mo14890of(String str) {
        C7577u c7577u = null;
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_CHAZHI);
        Cursor a = this.bSd.mo10104a("select * from chatroom where chatroomname='" + C5046bo.m7586vA(str) + "'", null, 2);
        if (a.moveToFirst()) {
            c7577u = new C7577u();
            c7577u.mo8995d(a);
        }
        a.close();
        if (c7577u == null || (c7577u.field_roomflag & 1) != 0) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_CHAZHI);
            return false;
        }
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_CHAZHI);
        return true;
    }

    /* renamed from: og */
    public final boolean mo14891og(String str) {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_WEISHI_LIUJIN);
        Assert.assertTrue(str.length() > 0);
        if (this.bSd.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_LIUJIN);
            return false;
        }
        anF(str);
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_WEISHI_LIUJIN);
        return true;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        return 0;
    }
}
