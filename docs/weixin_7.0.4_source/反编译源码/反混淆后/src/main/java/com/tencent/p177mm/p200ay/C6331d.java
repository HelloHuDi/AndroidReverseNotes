package com.tencent.p177mm.p200ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.ay.d */
public final class C6331d extends C1304a {
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

    public C6331d(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
        AppMethodBeat.m2504i(5556);
        AppMethodBeat.m2505o(5556);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        int i = 0;
        AppMethodBeat.m2504i(5557);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.m2505o(5557);
            return false;
        }
        C4990ab.m7417i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", C5046bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (C5046bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            C4990ab.m7413e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", C5046bo.nullAsNil(this.TYPE));
            AppMethodBeat.m2505o(5557);
            return false;
        }
        this.fLc = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername";
        String str4 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.fLk = C5046bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str3)) {
            this.fLi = C5046bo.nullAsNil((String) this.values.get(str3));
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
                this.fLd.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.fLg.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.fLh.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.fLd.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
                this.fLg.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
                this.fLh.add(C5046bo.nullAsNil((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        AppMethodBeat.m2505o(5557);
        return true;
    }
}
