package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C23457wn;
import com.tencent.p177mm.protocal.protobuf.C30239wo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.d */
public final class C27582d extends C11283k<C30239wo> {
    private static String TAG = "MicroMsg.CgiDeleteCardInTicketList";
    public static final C27583a kff = new C27583a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteCardInTicketList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.d$a */
    public static final class C27583a {
        private C27583a() {
        }

        public /* synthetic */ C27583a(byte b) {
            this();
        }
    }

    public C27582d(String str) {
        C25052j.m39376p(str, "cardId");
        AppMethodBeat.m2504i(89158);
        C23457wn c23457wn = new C23457wn();
        C30239wo c30239wo = new C30239wo();
        c23457wn.vCb = str;
        mo22982a(c23457wn, c30239wo, 1739, "/cgi-bin/mmpay-bin/mktdeletecardinticketlist");
        C4990ab.m7417i(TAG, "cardid: %s", str);
        AppMethodBeat.m2505o(89158);
    }

    static {
        AppMethodBeat.m2504i(89159);
        AppMethodBeat.m2505o(89159);
    }
}
