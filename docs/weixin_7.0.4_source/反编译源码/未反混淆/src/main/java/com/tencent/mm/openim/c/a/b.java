package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
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

    public b(Map<String, String> map, bi biVar) {
        super(map, biVar);
        AppMethodBeat.i(78918);
        AppMethodBeat.o(78918);
    }

    public final boolean Yt() {
        int i = 0;
        AppMethodBeat.i(78919);
        if (this.values == null) {
            ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(78919);
            return false;
        }
        ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")) {
            ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", bo.nullAsNil(this.TYPE));
            AppMethodBeat.o(78919);
            return false;
        }
        this.fLc = (String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName");
        String str = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text";
        String str2 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter";
        String str4 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.fLk = bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str3 + ".username")) {
            this.fLi = bo.nullAsNil((String) this.values.get(str3 + ".username"));
        }
        if (this.values.containsKey(str3 + ".appid")) {
            this.gft = bo.nullAsNil((String) this.values.get(str3 + ".appid"));
        }
        if (this.values.containsKey(str3 + ".descid")) {
            this.gfu = bo.nullAsNil((String) this.values.get(str3 + ".descid"));
        }
        if (this.values.containsKey(str4)) {
            this.fLj = bo.nullAsNil((String) this.values.get(str4));
        }
        if (this.values.containsKey(fKU)) {
            this.text = bo.nullAsNil((String) this.values.get(fKU));
        }
        if (this.values.containsKey(str2)) {
            this.cxb = (String) this.values.get(str2);
        }
        if (this.values.containsKey(str5)) {
            this.fLf = bo.getInt((String) this.values.get(str5), 0);
        }
        if (this.cKd.dtS()) {
            this.fKY.clear();
            this.fKZ.clear();
            this.fLa.clear();
            this.fKW = this.text + " ";
            this.fKZ.add(Integer.valueOf(this.fKW.length()));
            this.fKY.add(ah.getContext().getString(R.string.cbk));
            this.fKW += ah.getContext().getString(R.string.cbk);
            this.fLa.add(Integer.valueOf(this.fKW.length()));
        } else {
            this.fKZ.add(Integer.valueOf(this.text.length()));
            this.fKY.add(this.fLk);
            this.fKW = this.text + this.fLk;
            this.fLa.add(Integer.valueOf(this.fKW.length()));
        }
        while (i < this.fLf) {
            if (i == 0) {
                this.fLd.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
                this.fLg.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
                this.gfr.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
                this.gfs.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
                this.fLh.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
            } else {
                this.fLd.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
                this.fLg.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
                this.gfs.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
                this.gfr.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
                this.fLh.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        AppMethodBeat.o(78919);
        return true;
    }
}
