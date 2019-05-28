package com.tencent.p177mm.openim.p1211c.p1212a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.openim.c.a.b */
public final class C42242b extends C1304a {
    public String cxb;
    public String fLc;
    public LinkedList<String> fLd = new LinkedList();
    public int fLf;
    public LinkedList<String> fLg = new LinkedList();
    public LinkedList<String> fLh = new LinkedList();
    public String fLi = null;
    public String fLj = null;
    public String fLk = null;
    public LinkedList<String> gfr = new LinkedList();
    public LinkedList<String> gfs = new LinkedList();
    public String gft = null;
    public String gfu = null;
    public String text = null;

    public C42242b(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
        AppMethodBeat.m2504i(78918);
        AppMethodBeat.m2505o(78918);
    }

    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        int i = 0;
        AppMethodBeat.m2504i(78919);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.m2505o(78919);
            return false;
        }
        C4990ab.m7417i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", C5046bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (C5046bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")) {
            C4990ab.m7413e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", C5046bo.nullAsNil(this.TYPE));
            AppMethodBeat.m2505o(78919);
            return false;
        }
        this.fLc = (String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName");
        String str = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text";
        String str2 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter";
        String str4 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.fLk = C5046bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str3 + ".username")) {
            this.fLi = C5046bo.nullAsNil((String) this.values.get(str3 + ".username"));
        }
        if (this.values.containsKey(str3 + ".appid")) {
            this.gft = C5046bo.nullAsNil((String) this.values.get(str3 + ".appid"));
        }
        if (this.values.containsKey(str3 + ".descid")) {
            this.gfu = C5046bo.nullAsNil((String) this.values.get(str3 + ".descid"));
        }
        if (this.values.containsKey(str4)) {
            this.fLj = C5046bo.nullAsNil((String) this.values.get(str4));
        }
        if (this.values.containsKey(fKU)) {
            this.text = C5046bo.nullAsNil((String) this.values.get(fKU));
        }
        if (this.values.containsKey(str2)) {
            this.cxb = (String) this.values.get(str2);
        }
        if (this.values.containsKey(str5)) {
            this.fLf = C5046bo.getInt((String) this.values.get(str5), 0);
        }
        if (this.cKd.dtS()) {
            this.fKY.clear();
            this.fKZ.clear();
            this.fLa.clear();
            this.fKW = this.text + " ";
            this.fKZ.add(Integer.valueOf(this.fKW.length()));
            this.fKY.add(C4996ah.getContext().getString(C25738R.string.cbk));
            this.fKW += C4996ah.getContext().getString(C25738R.string.cbk);
            this.fLa.add(Integer.valueOf(this.fKW.length()));
        } else {
            this.fKZ.add(Integer.valueOf(this.text.length()));
            this.fKY.add(this.fLk);
            this.fKW = this.text + this.fLk;
            this.fLa.add(Integer.valueOf(this.fKW.length()));
        }
        while (i < this.fLf) {
            if (i == 0) {
                this.fLd.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
                this.fLg.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
                this.gfr.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
                this.gfs.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
                this.fLh.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
            } else {
                this.fLd.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
                this.fLg.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
                this.gfs.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
                this.gfr.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
                this.fLh.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        AppMethodBeat.m2505o(78919);
        return true;
    }
}
