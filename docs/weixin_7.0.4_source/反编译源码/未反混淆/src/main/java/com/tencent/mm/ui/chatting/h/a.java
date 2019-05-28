package com.tencent.mm.ui.chatting.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class a extends com.tencent.mm.ay.a {
    public String yYO;
    public long yYP = 0;

    public a(Map<String, String> map, bi biVar) {
        super(map, biVar);
    }

    public final boolean Yt() {
        AppMethodBeat.i(32503);
        if (this.values == null) {
            ab.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(32503);
            return false;
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
            this.yYO = (String) this.values.get(".sysmsg.invokeMessage.preContent");
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
            this.yYP = bo.anl((String) this.values.get(".sysmsg.invokeMessage.timestamp"));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : this.values.keySet()) {
            String str2;
            if (!str2.startsWith(".sysmsg.invokeMessage.text")) {
                if (str2.startsWith(".sysmsg.invokeMessage.link.text") && !bo.isNullOrNil((String) this.values.get(str2))) {
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
        if (cb.aaE() - this.yYP >= 300000 && !bo.isNullOrNil(this.yYO)) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32502);
                    a.this.cKd.setType(10002);
                    t.a(ah.getContext().getString(R.string.ao0), "", a.this.cKd, "");
                    aw.ZK();
                    c.XO().a(a.this.cKd.field_msgId, a.this.cKd);
                    ab.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", Long.valueOf(a.this.cKd.field_msgId));
                    AppMethodBeat.o(32502);
                }
            }, "[checkExpired]");
        }
        AppMethodBeat.o(32503);
        return true;
    }
}
