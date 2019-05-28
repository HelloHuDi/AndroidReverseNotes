package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a {

    public enum a {
        Expose(1),
        Click(2);
        
        public int value;

        static {
            AppMethodBeat.o(16611);
        }

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(bi biVar, a aVar) {
        AppMethodBeat.i(16612);
        if (bo.isNullOrNil(biVar.dJE)) {
            AppMethodBeat.o(16612);
            return;
        }
        int i;
        d dVar = new d();
        dVar.l("20ExpIdStr", biVar.dJE + ",");
        dVar.l("21OpType", aVar.value + ",");
        dVar.l("22msgId", biVar.field_msgSvrId + ",");
        dVar.l("23MessageType", biVar.getType() + ",");
        if (biVar.bAA()) {
            b X = b.X(biVar.field_content, biVar.field_reserved);
            if (X == null) {
                i = 0;
            } else {
                i = X.type;
            }
        } else {
            i = 0;
        }
        String str = biVar.field_talker;
        dVar.l("24AppMsgInnerType", i + ",");
        dVar.l("25curUsername", str + ",");
        String str2 = "";
        if (biVar.field_isSend == 1) {
            str2 = r.Yz();
        } else if (str == null || !t.kH(str)) {
            str2 = str;
        } else if (biVar.field_content != null) {
            int ox = bf.ox(biVar.field_content);
            if (ox != -1) {
                str2 = biVar.field_content.substring(0, ox).trim();
            }
        }
        dVar.l("26msgPostUserName", str2 + ",");
        dVar.l("27MediaState", biVar.dJF + ",");
        ab.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + dVar.Fk());
        h.pYm.e(13564, dVar);
        AppMethodBeat.o(16612);
    }
}
