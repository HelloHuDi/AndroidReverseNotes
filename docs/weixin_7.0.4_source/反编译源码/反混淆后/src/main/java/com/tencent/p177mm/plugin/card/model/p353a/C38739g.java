package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.agp;
import com.tencent.p177mm.protocal.protobuf.agq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "(Ljava/lang/String;JDDI)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.g */
public final class C38739g extends C11283k<agq> {
    private static final String TAG = TAG;
    public static final C33766a kfj = new C33766a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.g$a */
    public static final class C33766a {
        private C33766a() {
        }

        public /* synthetic */ C33766a(byte b) {
            this();
        }
    }

    public C38739g(String str, long j, double d, double d2, int i) {
        C25052j.m39376p(str, "marchantId");
        AppMethodBeat.m2504i(89167);
        agp agp = new agp();
        agq agq = new agq();
        agp.vSR = str;
        agp.vTi = j;
        agp.latitude = d;
        agp.longitude = d2;
        agp.wnj = i;
        mo22982a(agp, agq, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
        C4990ab.m7417i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", str, Long.valueOf(j), Double.valueOf(d), Double.valueOf(d2));
        AppMethodBeat.m2505o(89167);
    }

    static {
        AppMethodBeat.m2504i(89168);
        AppMethodBeat.m2505o(89168);
    }
}
