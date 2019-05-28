package com.tencent.p177mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.modelstat.a */
public final class C42219a {

    /* renamed from: com.tencent.mm.modelstat.a$a */
    public enum C32832a {
        Expose(1),
        Click(2);
        
        public int value;

        static {
            AppMethodBeat.m2505o(16611);
        }

        private C32832a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: a */
    public static void m74510a(C7620bi c7620bi, C32832a c32832a) {
        AppMethodBeat.m2504i(16612);
        if (C5046bo.isNullOrNil(c7620bi.dJE)) {
            AppMethodBeat.m2505o(16612);
            return;
        }
        int i;
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20ExpIdStr", c7620bi.dJE + ",");
        c32831d.mo53400l("21OpType", c32832a.value + ",");
        c32831d.mo53400l("22msgId", c7620bi.field_msgSvrId + ",");
        c32831d.mo53400l("23MessageType", c7620bi.getType() + ",");
        if (c7620bi.bAA()) {
            C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
            if (X == null) {
                i = 0;
            } else {
                i = X.type;
            }
        } else {
            i = 0;
        }
        String str = c7620bi.field_talker;
        c32831d.mo53400l("24AppMsgInnerType", i + ",");
        c32831d.mo53400l("25curUsername", str + ",");
        String str2 = "";
        if (c7620bi.field_isSend == 1) {
            str2 = C1853r.m3846Yz();
        } else if (str == null || !C1855t.m3896kH(str)) {
            str2 = str;
        } else if (c7620bi.field_content != null) {
            int ox = C1829bf.m3761ox(c7620bi.field_content);
            if (ox != -1) {
                str2 = c7620bi.field_content.substring(0, ox).trim();
            }
        }
        c32831d.mo53400l("26msgPostUserName", str2 + ",");
        c32831d.mo53400l("27MediaState", c7620bi.dJF + ",");
        C4990ab.m7418v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + c32831d.mo53398Fk());
        C7060h.pYm.mo8381e(13564, c32831d);
        AppMethodBeat.m2505o(16612);
    }
}
