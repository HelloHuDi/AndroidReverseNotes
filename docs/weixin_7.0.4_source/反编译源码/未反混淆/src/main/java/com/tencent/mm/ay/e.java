package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class e extends a {
    public String cGA;
    public LinkedList<String> fLl = new LinkedList();
    public String url;

    public e(Map<String, String> map, bi biVar) {
        super(map, biVar);
        AppMethodBeat.i(5558);
        AppMethodBeat.o(5558);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Yt() {
        AppMethodBeat.i(5559);
        if (this.values == null) {
            ab.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(5559);
            return false;
        }
        ab.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            ab.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", bo.nullAsNil(this.TYPE));
            AppMethodBeat.o(5559);
            return false;
        }
        this.url = bo.nullAsNil((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.cGA = bo.nullAsNil((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
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
        ab.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", this.url, this.cGA, Integer.valueOf(this.fLl.size()));
        AppMethodBeat.o(5559);
        return true;
    }
}
