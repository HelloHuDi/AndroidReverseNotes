package com.tencent.mm.plugin.card.model.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "marchantId", "", "lastReceiveTime", "", "latitude", "", "longitude", "sortRule", "", "(Ljava/lang/String;JDDI)V", "Companion", "plugin-card_release"})
public final class g extends k<agq> {
    private static final String TAG = TAG;
    public static final a kfj = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardPkgMchInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public g(String str, long j, double d, double d2, int i) {
        j.p(str, "marchantId");
        AppMethodBeat.i(89167);
        agp agp = new agp();
        agq agq = new agq();
        agp.vSR = str;
        agp.vTi = j;
        agp.latitude = d;
        agp.longitude = d2;
        agp.wnj = i;
        a(agp, agq, 2769, "/cgi-bin/mmpay-bin/mktgetcardpkgmchinfo");
        ab.i(TAG, "marchantid: %s, lastReceiveTime: %s, lat: %s, long: %s", str, Long.valueOf(j), Double.valueOf(d), Double.valueOf(d2));
        AppMethodBeat.o(89167);
    }

    static {
        AppMethodBeat.i(89168);
        AppMethodBeat.o(89168);
    }
}
