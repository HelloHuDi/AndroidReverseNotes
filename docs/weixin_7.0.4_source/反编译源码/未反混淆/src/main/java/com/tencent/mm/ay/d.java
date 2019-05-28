package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class d extends a {
    public String cxb;
    public String fLc;
    public LinkedList<String> fLd = new LinkedList();
    public int fLf;
    public LinkedList<String> fLg = new LinkedList();
    public LinkedList<String> fLh = new LinkedList();
    public String fLi = null;
    public String fLj = null;
    public String fLk = null;
    public String text = null;

    public d(Map<String, String> map, bi biVar) {
        super(map, biVar);
        AppMethodBeat.i(5556);
        AppMethodBeat.o(5556);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Yt() {
        int i = 0;
        AppMethodBeat.i(5557);
        if (this.values == null) {
            ab.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(5557);
            return false;
        }
        ab.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            ab.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", bo.nullAsNil(this.TYPE));
            AppMethodBeat.o(5557);
            return false;
        }
        this.fLc = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername";
        String str4 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.fLk = bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str3)) {
            this.fLi = bo.nullAsNil((String) this.values.get(str3));
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
                this.fLd.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.fLg.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.fLh.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.fLd.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
                this.fLg.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
                this.fLh.add(bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        AppMethodBeat.o(5557);
        return true;
    }
}
