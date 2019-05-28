package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.akv;
import com.tencent.p177mm.protocal.protobuf.akw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "(IIDD)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.j */
public final class C33769j extends C11283k<akw> {
    private static String TAG = "MicroMsg.CgiGetMktTicketHomePage";
    public static final C20136a kfn = new C20136a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.j$a */
    public static final class C20136a {
        private C20136a() {
        }

        public /* synthetic */ C20136a(byte b) {
            this();
        }
    }

    public C33769j(int i, int i2, double d, double d2) {
        AppMethodBeat.m2504i(89173);
        akv akv = new akv();
        akw akw = new akw();
        akv.offset = i;
        akv.vKW = i2;
        akv.latitude = d;
        akv.longitude = d2;
        mo22982a(akv, akw, 2940, "/cgi-bin/mmpay-bin/mktgetmkttickethomepage");
        C4990ab.m7417i(TAG, "offset: %s, reqnum: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(89173);
    }

    static {
        AppMethodBeat.m2504i(89174);
        AppMethodBeat.m2505o(89174);
    }
}
