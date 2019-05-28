package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.akr;
import com.tencent.p177mm.protocal.protobuf.aks;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "offset", "", "reqNum", "lat", "", "lon", "scene", "sortRule", "(IIDDII)V", "sortType", "getSortType", "()I", "setSortType", "(I)V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.h */
public final class C45782h extends C11283k<aks> {
    private static final String TAG = TAG;
    public static final C38740a kfl = new C38740a();
    public int kfk;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.h$a */
    public static final class C38740a {
        private C38740a() {
        }

        public /* synthetic */ C38740a(byte b) {
            this();
        }
    }

    public C45782h(int i, int i2, double d, double d2, int i3) {
        AppMethodBeat.m2504i(89169);
        akr akr = new akr();
        aks aks = new aks();
        akr.offset = i;
        akr.vKW = i2;
        akr.latitude = d;
        akr.longitude = d2;
        akr.wnj = i3;
        mo22982a(akr, aks, 2619, "/cgi-bin/mmpay-bin/mktgetmktcardhomepage");
        this.kfk = i3;
        C4990ab.m7417i(TAG, "offset: %s, reqnum: %s, scene: %s, sortRule: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1), Integer.valueOf(i3));
        C4990ab.m7411d(TAG, "lat: %s, lng: %s", Double.valueOf(d), Double.valueOf(d2));
        AppMethodBeat.m2505o(89169);
    }

    static {
        AppMethodBeat.m2504i(89170);
        AppMethodBeat.m2505o(89170);
    }
}
