package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C35964wr;
import com.tencent.p177mm.protocal.protobuf.C40585ws;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "marchantId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.e */
public final class C16723e extends C11283k<C40585ws> {
    private static final String TAG = TAG;
    public static final C11282a kfg = new C11282a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.e$a */
    public static final class C11282a {
        private C11282a() {
        }

        public /* synthetic */ C11282a(byte b) {
            this();
        }
    }

    public C16723e(String str) {
        C25052j.m39376p(str, "marchantId");
        AppMethodBeat.m2504i(89160);
        C35964wr c35964wr = new C35964wr();
        C40585ws c40585ws = new C40585ws();
        c35964wr.vSR = str;
        mo22982a(c35964wr, c40585ws, 1768, "/cgi-bin/mmpay-bin/mktdeletemchinlist");
        C4990ab.m7417i(TAG, "delete mch: %s", str);
        AppMethodBeat.m2505o(89160);
    }

    static {
        AppMethodBeat.m2504i(89161);
        AppMethodBeat.m2505o(89161);
    }
}
