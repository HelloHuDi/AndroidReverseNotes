package com.tencent.p177mm.p200ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.ay.b */
public final class C25849b extends C1304a {
    public String cxb = null;
    public String fLc;
    public LinkedList<String> fLd = new LinkedList();
    public String fLe = null;
    public String text = null;

    public C25849b(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
        AppMethodBeat.m2504i(5553);
        AppMethodBeat.m2505o(5553);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(5554);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.m2505o(5554);
            return false;
        }
        C4990ab.m7417i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", C5046bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (C5046bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            C4990ab.m7413e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", C5046bo.nullAsNil(this.TYPE));
            AppMethodBeat.m2505o(5554);
            return false;
        }
        this.fLc = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket";
        if (this.values.containsKey(fKU)) {
            this.text = C5046bo.nullAsNil((String) this.values.get(fKU));
        }
        if (this.values.containsKey(str)) {
            this.fLe = C5046bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.cxb = C5046bo.nullAsNil((String) this.values.get(str2));
        }
        this.fKW = this.text;
        if (this.cKd.dtS()) {
            this.fKW += " " + C4996ah.getContext().getString(C25738R.string.cbo);
        } else {
            this.fKY.add(this.fLe);
            this.fKZ.add(Integer.valueOf(this.fKW.length()));
            this.fKW += this.fLe;
            this.fLa.add(Integer.valueOf(this.fKW.length()));
        }
        for (String str3 : this.values.keySet()) {
            if (str3.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
                this.fLd.add(this.values.get(str3));
            }
        }
        AppMethodBeat.m2505o(5554);
        return true;
    }
}
