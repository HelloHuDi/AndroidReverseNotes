package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import a.v;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class ae {
    public static final a haH = new a();
    private static final long haj = TimeUnit.DAYS.toSeconds(1);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$Companion;", "", "()V", "FETCH_FREQUENCY", "", "TAG", "", "fetchListFromServer", "", "reason", "", "prescene", "plugin-appbrand-integration_release"})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "kotlin.jvm.PlatformType", "back", "call"})
        static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ int haI;
            final /* synthetic */ long haJ;

            a(int i, long j) {
                this.haI = i;
                this.haJ = j;
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(134555);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                if (aVar != null) {
                    q acN;
                    int i = this.haI;
                    int i2 = aVar.errType;
                    int i3 = aVar.errCode;
                    String str = aVar.aIm;
                    m mVar = aVar.cwn;
                    if (mVar != null) {
                        acN = mVar.acN();
                    } else {
                        acN = null;
                    }
                    if (!(acN instanceof b)) {
                        acN = null;
                    }
                    t.a(i, i2, i3, str, (b) acN, Long.valueOf(this.haJ));
                    AppMethodBeat.o(134555);
                    return aVar;
                }
                AppMethodBeat.o(134555);
                return null;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static /* synthetic */ void cQ(int i, int i2) {
            AppMethodBeat.i(134557);
            if ((i2 & 1) != 0) {
                i = 5;
            }
            cP(i, 0);
            AppMethodBeat.o(134557);
        }

        public static void cP(int i, int i2) {
            int i3;
            AppMethodBeat.i(134556);
            if (i == 2 || i == 7 || i == 8) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                e RP = g.RP();
                j.o(RP, "MMKernel.storage()");
                Object obj = RP.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_COLLECTION_LIST_FETCH_NEXT_TIME_SEC_LONG, Long.valueOf(0));
                if (obj == null) {
                    v vVar = new v("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(134556);
                    throw vVar;
                } else if (((Long) obj).longValue() > bo.anT()) {
                    ab.d("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "daily fetch blocked by frequency");
                    AppMethodBeat.o(134556);
                    return;
                } else {
                    RP = g.RP();
                    j.o(RP, "MMKernel.storage()");
                    RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_COLLECTION_LIST_FETCH_NEXT_TIME_SEC_LONG, Long.valueOf(bo.anT() + ae.haj));
                }
            }
            ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection].FetchStarListLogic", "fetchList reason=" + i + ", prescene=" + i2);
            new y(i, i2, 2, BaseClientBuilder.API_PRIORITY_OTHER, 0).acy().j(new a(i, bo.anU()));
            AppMethodBeat.o(134556);
        }
    }

    static {
        AppMethodBeat.i(134558);
        AppMethodBeat.o(134558);
    }
}
