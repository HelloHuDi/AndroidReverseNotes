package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.akt;
import com.tencent.p177mm.protocal.protobuf.aku;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.i */
public final class C33767i extends C11283k<aku> {
    private static final String TAG = TAG;
    public static final C33768a kfm = new C33768a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktInvalidTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.i$a */
    public static final class C33768a {
        private C33768a() {
        }

        public /* synthetic */ C33768a(byte b) {
            this();
        }
    }

    public C33767i(int i, int i2, double d, double d2) {
        AppMethodBeat.m2504i(89171);
        akt akt = new akt();
        aku aku = new aku();
        akt.offset = i;
        akt.vKW = i2;
        akt.latitude = d;
        akt.longitude = d2;
        mo22982a(akt, aku, 2979, "/cgi-bin/mmpay-bin/mktgetmktinvalidtickethomepage");
        C4990ab.m7417i(TAG, "offset: %s, reqnum: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(89171);
    }

    static {
        AppMethodBeat.m2504i(89172);
        AppMethodBeat.m2505o(89172);
    }
}
