package com.tencent.p177mm.p612ui.chatting.p618h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C18678t;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.h.a */
public final class C46654a extends C1304a {
    public String yYO;
    public long yYP = 0;

    /* renamed from: com.tencent.mm.ui.chatting.h.a$1 */
    class C53431 implements Runnable {
        C53431() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32502);
            C46654a.this.cKd.setType(10002);
            C18678t.m29196a(C4996ah.getContext().getString(C25738R.string.ao0), "", C46654a.this.cKd, "");
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(C46654a.this.cKd.field_msgId, C46654a.this.cKd);
            C4990ab.m7417i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", Long.valueOf(C46654a.this.cKd.field_msgId));
            AppMethodBeat.m2505o(32502);
        }
    }

    public C46654a(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
    }

    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(32503);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.m2505o(32503);
            return false;
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
            this.yYO = (String) this.values.get(".sysmsg.invokeMessage.preContent");
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
            this.yYP = C5046bo.anl((String) this.values.get(".sysmsg.invokeMessage.timestamp"));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : this.values.keySet()) {
            String str2;
            if (!str2.startsWith(".sysmsg.invokeMessage.text")) {
                if (str2.startsWith(".sysmsg.invokeMessage.link.text") && !C5046bo.isNullOrNil((String) this.values.get(str2))) {
                    str2 = (String) this.values.get(str2);
                    stringBuilder.append(str2);
                    this.fKY.add(str2);
                    i = str2.length();
                }
                i = i;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.fKZ.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.fLa.add(Integer.valueOf(stringBuilder.length()));
        this.fKW = stringBuilder.toString();
        if (C1839cb.aaE() - this.yYP >= 300000 && !C5046bo.isNullOrNil(this.yYO)) {
            C7305d.post(new C53431(), "[checkExpired]");
        }
        AppMethodBeat.m2505o(32503);
        return true;
    }
}
