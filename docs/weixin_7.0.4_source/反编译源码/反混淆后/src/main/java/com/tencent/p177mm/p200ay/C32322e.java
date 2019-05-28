package com.tencent.p177mm.p200ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.ay.e */
public final class C32322e extends C1304a {
    public String cGA;
    public LinkedList<String> fLl = new LinkedList();
    public String url;

    public C32322e(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
        AppMethodBeat.m2504i(5558);
        AppMethodBeat.m2505o(5558);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(5559);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.m2505o(5559);
            return false;
        }
        C4990ab.m7417i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", C5046bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (C5046bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            C4990ab.m7413e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", C5046bo.nullAsNil(this.TYPE));
            AppMethodBeat.m2505o(5559);
            return false;
        }
        this.url = C5046bo.nullAsNil((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.cGA = C5046bo.nullAsNil((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
        this.fLl.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
        for (String str : this.values.keySet()) {
            if (str.startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
                this.fLl.add(this.values.get(str));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str2 : this.values.keySet()) {
            if (!str2.startsWith(fKU)) {
                int length;
                if (str2.startsWith(".sysmsg.delchatroommember.link.text")) {
                    stringBuilder.append((String) this.values.get(str2));
                    this.fKY.add(this.values.get(str2));
                    length = ((String) this.values.get(str2)).length();
                } else {
                    length = i;
                }
                i = length;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.fKZ.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.fLa.add(Integer.valueOf(stringBuilder.length()));
        this.fKW = stringBuilder.toString();
        C4990ab.m7417i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", this.url, this.cGA, Integer.valueOf(this.fLl.size()));
        AppMethodBeat.m2505o(5559);
        return true;
    }
}
