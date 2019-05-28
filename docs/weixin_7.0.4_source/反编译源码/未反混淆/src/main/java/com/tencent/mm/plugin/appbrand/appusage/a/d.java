package com.tencent.mm.plugin.appbrand.appusage.a;

import a.f.a.q;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
import a.y;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0014H\u0003J \u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00142\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J,\u00104\u001a&\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r 5*\u0012\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r\u0018\u00010\f0\fH\u0002J\u000e\u00106\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0014J\u0006\u00107\u001a\u00020\u001cJ\u000e\u00108\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0014J\u0006\u00109\u001a\u00020\u0014J\u0006\u0010:\u001a\u00020\u0014J\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010<\u001a\u00020\u0004J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0002J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\"J\u0018\u0010B\u001a\u00020\"2\u0006\u0010>\u001a\u00020?2\u0006\u0010'\u001a\u00020\u0014H\u0002J*\u0010C\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00142\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u001b\u001a\u00020\u0014H\u0002J\u0006\u0010E\u001a\u00020\u001cJ\u0006\u0010F\u001a\u00020\u001cJ\u000e\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0014J\u000e\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\"J\u0006\u0010K\u001a\u00020\"J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000Rg\u0010\u0015\u001aO\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\f8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b)\u0010\u000fR\u000e\u0010+\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(d.class), "rList", "getRList()Ljava/util/LinkedList;")), v.a(new t(v.aN(d.class), "dataList", "getDataList()Ljava/util/LinkedList;"))};
    private static d hbt;
    public static final a hbu = new a();
    public int cPK;
    private final k hbg;
    public final c hbh;
    private final a.f hbi;
    public long hbj;
    long hbk;
    public int hbl;
    public int hbm;
    public boolean hbn;
    public int hbo;
    private final a.f hbp;
    private boolean hbq;
    private com.tencent.mm.plugin.appbrand.appusage.a.h.a hbr;
    public q<? super Integer, ? super LinkedList<bqd>, ? super Integer, y> hbs;
    long lastUpdateTime;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<LinkedList<bqd>> {
        public static final c hbw = new c();

        static {
            AppMethodBeat.i(134572);
            AppMethodBeat.o(134572);
        }

        c() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134571);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(134571);
            return linkedList;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
    static final class d implements com.tencent.mm.plugin.appbrand.appusage.a.c.a {
        final /* synthetic */ d hbv;

        d(d dVar) {
            this.hbv = dVar;
        }

        public final void G(float f, float f2) {
            AppMethodBeat.i(134573);
            Iterator it = d.g(this.hbv).iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                d dVar = this.hbv;
                j.o(num, "item");
                d.a(dVar, num.intValue(), f, f2);
            }
            d.g(this.hbv).clear();
            AppMethodBeat.o(134573);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class e extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ d hbv;
        final /* synthetic */ int hbx;

        public e(d dVar, int i) {
            this.hbv = dVar;
            this.hbx = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134574);
            d.a(this.hbv, this.hbx);
            y yVar = y.AUy;
            AppMethodBeat.o(134574);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    public static final class f extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ d hbv;

        public f(d dVar) {
            this.hbv = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            AppMethodBeat.i(134575);
            d dVar = this.hbv;
            if (bo.anT() - dVar.lastUpdateTime > dVar.hbk) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                ab.i("MicroMsg.Recommend.AppBrandRecommendLogic", "data is timeout, need to update from server");
                this.hbv.hbl = 0;
                this.hbv.hbm = 0;
                this.hbv.cPK = 0;
                d.a(this.hbv, this.hbv.hbm);
                com.tencent.mm.plugin.appbrand.ui.recommend.e.pX(2);
            } else {
                d.a(this.hbv, d.f(this.hbv), this.hbv.hbl);
                com.tencent.mm.plugin.appbrand.ui.recommend.e.pX(1);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134575);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final synchronized d aya() {
            d axZ;
            AppMethodBeat.i(134568);
            if (d.hbt == null) {
                d.hbt = new d();
            }
            axZ = d.hbt;
            if (axZ == null) {
                j.dWJ();
            }
            AppMethodBeat.o(134568);
            return axZ;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
    public static final class b implements com.tencent.mm.plugin.appbrand.appusage.a.h.a {
        final /* synthetic */ d hbv;

        b(d dVar) {
            this.hbv = dVar;
        }

        public final void a(anl anl) {
            AppMethodBeat.i(134569);
            j.p(anl, "response");
            d.a(this.hbv, anl);
            AppMethodBeat.o(134569);
        }

        public final void ayb() {
            AppMethodBeat.i(134570);
            d.a(this.hbv, 1, null, 6);
            AppMethodBeat.o(134570);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.a<LinkedList<Integer>> {
        public static final h hbz = new h();

        static {
            AppMethodBeat.i(134579);
            AppMethodBeat.o(134579);
        }

        h() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134578);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(134578);
            return linkedList;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 2>", "invoke"})
    static final class g extends a.f.b.k implements q<Integer, LinkedList<bqd>, Integer, y> {
        public static final g hby = new g();

        static {
            AppMethodBeat.i(134577);
            AppMethodBeat.o(134577);
        }

        g() {
            super(3);
        }

        public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(134576);
            ((Number) obj).intValue();
            LinkedList linkedList = (LinkedList) obj2;
            ((Number) obj3).intValue();
            j.p(linkedList, "<anonymous parameter 1>");
            y yVar = y.AUy;
            AppMethodBeat.o(134576);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(134580);
        AppMethodBeat.o(134580);
    }

    private final LinkedList<Integer> axX() {
        AppMethodBeat.i(134581);
        LinkedList linkedList = (LinkedList) this.hbi.getValue();
        AppMethodBeat.o(134581);
        return linkedList;
    }

    public final LinkedList<bqd> axY() {
        AppMethodBeat.i(134582);
        LinkedList linkedList = (LinkedList) this.hbp.getValue();
        AppMethodBeat.o(134582);
        return linkedList;
    }

    private d() {
        AppMethodBeat.i(134586);
        this.hbg = new k();
        this.hbh = new c();
        this.hbi = i.g(h.hbz);
        this.hbo = 1;
        this.hbp = i.g(c.hbw);
        this.hbr = new b(this);
        this.hbs = g.hby;
        AppMethodBeat.o(134586);
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static final /* synthetic */ LinkedList f(d dVar) {
        AppMethodBeat.i(134589);
        LinkedList axY = dVar.axY();
        AppMethodBeat.o(134589);
        return axY;
    }

    public static final /* synthetic */ LinkedList g(d dVar) {
        AppMethodBeat.i(134590);
        LinkedList axX = dVar.axX();
        AppMethodBeat.o(134590);
        return axX;
    }

    private final void a(int i, LinkedList<bqd> linkedList, int i2) {
        AppMethodBeat.i(134583);
        q qVar = this.hbs;
        if (qVar != null) {
            qVar.g(Integer.valueOf(i), linkedList, Integer.valueOf(i2));
            AppMethodBeat.o(134583);
            return;
        }
        AppMethodBeat.o(134583);
    }

    private final void a(int i, float f, float f2) {
        AppMethodBeat.i(134585);
        if (com.tencent.mm.kernel.g.RK()) {
            sq sqVar = new sq();
            sqVar.waf = at.getNetTypeString(ah.getContext());
            sqVar.longitude = (double) f;
            sqVar.latitude = (double) f2;
            if (com.tencent.mm.sdk.platformtools.f.DEBUG && i != 0 && this.hbq) {
                k kVar = this.hbg;
                LinkedList linkedList = new LinkedList();
                bqd bqd = new bqd();
                kVar.a(bqd);
                bqd.kLg = "####客户端mock数据####大视频";
                bqd.iAd = 6;
                bqd.wSr = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
                bqd.wSt = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
                linkedList.addLast(bqd);
                Collection collection = linkedList;
                bqd[] bqdArr = new bqd[4];
                for (int i2 = 0; i2 < 4; i2++) {
                    bqd bqd2 = new bqd();
                    kVar.a(bqd2);
                    bqd2.wSv = new ars();
                    bqd2.wSv.wvH = 1500;
                    bqd2.wSv.wvG = 1750;
                    bqd2.iAd = 5;
                    switch (i2) {
                        case 0:
                            bqd2.kLg = "####客户端mock数据####商品tt";
                            bqd2.wSv.wvJ = true;
                            bqd2.wSv.wvI = true;
                            break;
                        case 1:
                            bqd2.kLg = "####客户端mock数据####商品tf";
                            bqd2.wSv.wvJ = true;
                            bqd2.wSv.wvI = false;
                            break;
                        case 2:
                            bqd2.kLg = "####客户端mock数据####商品ff";
                            bqd2.wSv.wvJ = false;
                            bqd2.wSv.wvI = false;
                            break;
                        default:
                            bqd2.kLg = "####客户端mock数据####商品ft";
                            bqd2.wSv.wvJ = false;
                            bqd2.wSv.wvI = true;
                            break;
                    }
                    bqd2.kLg += i;
                    bqdArr[i2] = bqd2;
                }
                j.p(collection, "receiver$0");
                j.p(bqdArr, MessengerShareContentUtility.ELEMENTS);
                collection.addAll(a.a.h.asList(bqdArr));
                int size = i == 2 ? 0 : linkedList.size();
                Thread.sleep(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                a(0, linkedList, size);
                AppMethodBeat.o(134585);
                return;
            }
            h.a(i, sqVar, this.hbj, this.hbr, this.hbo);
            AppMethodBeat.o(134585);
            return;
        }
        AppMethodBeat.o(134585);
    }
}
