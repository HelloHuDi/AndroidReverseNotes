package com.tencent.p177mm.plugin.appbrand.appusage;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.concurrent.TimeUnit;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.ae */
public final class C26766ae {
    public static final C26764a haH = new C26764a();
    private static final long haj = TimeUnit.DAYS.toSeconds(1);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.ae$a */
    public static final class C26764a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "back", "call"})
        /* renamed from: com.tencent.mm.plugin.appbrand.appusage.ae$a$a */
        static final class C26765a<_Ret, _Var> implements C5681a<_Ret, _Var> {
            final /* synthetic */ int haI;
            final /* synthetic */ long haJ;

            C26765a(int i, long j) {
                this.haI = i;
                this.haJ = j;
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(134555);
                C37441a c37441a = (C37441a) obj;
                if (c37441a != null) {
                    C1929q acN;
                    int i = this.haI;
                    int i2 = c37441a.errType;
                    int i3 = c37441a.errCode;
                    String str = c37441a.aIm;
                    C1207m c1207m = c37441a.cwn;
                    if (c1207m != null) {
                        acN = c1207m.acN();
                    } else {
                        acN = null;
                    }
                    if (!(acN instanceof C7472b)) {
                        acN = null;
                    }
                    C26783t.m42627a(i, i2, i3, str, (C7472b) acN, Long.valueOf(this.haJ));
                    AppMethodBeat.m2505o(134555);
                    return c37441a;
                }
                AppMethodBeat.m2505o(134555);
                return null;
            }
        }

        private C26764a() {
        }

        public /* synthetic */ C26764a(byte b) {
            this();
        }

        /* renamed from: cQ */
        public static /* synthetic */ void m42597cQ(int i, int i2) {
            AppMethodBeat.m2504i(134557);
            if ((i2 & 1) != 0) {
                i = 5;
            }
            C26764a.m42596cP(i, 0);
            AppMethodBeat.m2505o(134557);
        }

        /* renamed from: cP */
        public static void m42596cP(int i, int i2) {
            int i3;
            AppMethodBeat.m2504i(134556);
            if (i == 2 || i == 7 || i == 8) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                C1706e RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "MMKernel.storage()");
                Object obj = RP.mo5239Ry().get(C5127a.USERINFO_APP_BRAND_COLLECTION_LIST_FETCH_NEXT_TIME_SEC_LONG, Long.valueOf(0));
                if (obj == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.m2505o(134556);
                    throw c44941v;
                } else if (((Long) obj).longValue() > C5046bo.anT()) {
                    C4990ab.m7410d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
                    AppMethodBeat.m2505o(134556);
                    return;
                } else {
                    RP = C1720g.m3536RP();
                    C25052j.m39375o(RP, "MMKernel.storage()");
                    RP.mo5239Ry().set(C5127a.USERINFO_APP_BRAND_COLLECTION_LIST_FETCH_NEXT_TIME_SEC_LONG, Long.valueOf(C5046bo.anT() + C26766ae.haj));
                }
            }
            C4990ab.m7416i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + i + ", prescene=" + i2);
            new C45523y(i, i2, 2, BaseClientBuilder.API_PRIORITY_OTHER, 0).acy().mo60494j(new C26765a(i, C5046bo.anU()));
            AppMethodBeat.m2505o(134556);
        }
    }

    static {
        AppMethodBeat.m2504i(134558);
        AppMethodBeat.m2505o(134558);
    }
}
