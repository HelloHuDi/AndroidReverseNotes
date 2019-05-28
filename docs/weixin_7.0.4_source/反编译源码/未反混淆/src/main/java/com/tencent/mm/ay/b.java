package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
    public String cxb = null;
    public String fLc;
    public LinkedList<String> fLd = new LinkedList();
    public String fLe = null;
    public String text = null;

    public b(Map<String, String> map, bi biVar) {
        super(map, biVar);
        AppMethodBeat.i(5553);
        AppMethodBeat.o(5553);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Yt() {
        AppMethodBeat.i(5554);
        if (this.values == null) {
            ab.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(5554);
            return false;
        }
        ab.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            ab.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", bo.nullAsNil(this.TYPE));
            AppMethodBeat.o(5554);
            return false;
        }
        this.fLc = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket";
        if (this.values.containsKey(fKU)) {
            this.text = bo.nullAsNil((String) this.values.get(fKU));
        }
        if (this.values.containsKey(str)) {
            this.fLe = bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.cxb = bo.nullAsNil((String) this.values.get(str2));
        }
        this.fKW = this.text;
        if (this.cKd.dtS()) {
            this.fKW += " " + ah.getContext().getString(R.string.cbo);
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
        AppMethodBeat.o(5554);
        return true;
    }
}
