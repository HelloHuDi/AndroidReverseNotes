package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C26759c.C26760a;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C42370h.C38124a;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C10922e;
import com.tencent.p177mm.protocal.protobuf.C23440sq;
import com.tencent.p177mm.protocal.protobuf.anl;
import com.tencent.p177mm.protocal.protobuf.ars;
import com.tencent.p177mm.protocal.protobuf.bqd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37091y;
import p000a.C44856f;
import p000a.p001a.C36646h;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0014H\u0003J \u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00142\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J,\u00104\u001a&\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r 5*\u0012\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r\u0018\u00010\f0\fH\u0002J\u000e\u00106\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0014J\u0006\u00107\u001a\u00020\u001cJ\u000e\u00108\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0014J\u0006\u00109\u001a\u00020\u0014J\u0006\u0010:\u001a\u00020\u0014J\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010<\u001a\u00020\u0004J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0002J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\"J\u0018\u0010B\u001a\u00020\"2\u0006\u0010>\u001a\u00020?2\u0006\u0010'\u001a\u00020\u0014H\u0002J*\u0010C\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00142\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u001b\u001a\u00020\u0014H\u0002J\u0006\u0010E\u001a\u00020\u001cJ\u0006\u0010F\u001a\u00020\u001cJ\u000e\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0014J\u000e\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\"J\u0006\u0010K\u001a\u00020\"J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000Rg\u0010\u0015\u001aO\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\f8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b)\u0010\u000fR\u000e\u0010+\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d */
public final class C19095d {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C19095d.class), "rList", "getRList()Ljava/util/LinkedList;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C19095d.class), "dataList", "getDataList()Ljava/util/LinkedList;"))};
    private static C19095d hbt;
    public static final C19096a hbu = new C19096a();
    public int cPK;
    private final C26763k hbg;
    public final C26759c hbh;
    private final C44856f hbi;
    public long hbj;
    long hbk;
    public int hbl;
    public int hbm;
    public boolean hbn;
    public int hbo;
    private final C44856f hbp;
    private boolean hbq;
    private C38124a hbr;
    public C36933q<? super Integer, ? super LinkedList<bqd>, ? super Integer, C37091y> hbs;
    long lastUpdateTime;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$c */
    static final class C2083c extends C25053k implements C31214a<LinkedList<bqd>> {
        public static final C2083c hbw = new C2083c();

        static {
            AppMethodBeat.m2504i(134572);
            AppMethodBeat.m2505o(134572);
        }

        C2083c() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134571);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.m2505o(134571);
            return linkedList;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$d */
    static final class C10109d implements C26760a {
        final /* synthetic */ C19095d hbv;

        C10109d(C19095d c19095d) {
            this.hbv = c19095d;
        }

        /* renamed from: G */
        public final void mo21466G(float f, float f2) {
            AppMethodBeat.m2504i(134573);
            Iterator it = C19095d.m29714g(this.hbv).iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                C19095d c19095d = this.hbv;
                C25052j.m39375o(num, "item");
                C19095d.m29705a(c19095d, num.intValue(), f, f2);
            }
            C19095d.m29714g(this.hbv).clear();
            AppMethodBeat.m2505o(134573);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$e */
    public static final class C10110e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C19095d hbv;
        final /* synthetic */ int hbx;

        public C10110e(C19095d c19095d, int i) {
            this.hbv = c19095d;
            this.hbx = i;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134574);
            C19095d.m29704a(this.hbv, this.hbx);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134574);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$f */
    public static final class C10111f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C19095d hbv;

        public C10111f(C19095d c19095d) {
            this.hbv = c19095d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            AppMethodBeat.m2504i(134575);
            C19095d c19095d = this.hbv;
            if (C5046bo.anT() - c19095d.lastUpdateTime > c19095d.hbk) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendLogic", "data is timeout, need to update from server");
                this.hbv.hbl = 0;
                this.hbv.hbm = 0;
                this.hbv.cPK = 0;
                C19095d.m29704a(this.hbv, this.hbv.hbm);
                C10922e.m18649pX(2);
            } else {
                C19095d.m29708a(this.hbv, C19095d.m29713f(this.hbv), this.hbv.hbl);
                C10922e.m18649pX(1);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134575);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$a */
    public static final class C19096a {
        private C19096a() {
        }

        public /* synthetic */ C19096a(byte b) {
            this();
        }

        public final synchronized C19095d aya() {
            C19095d axZ;
            AppMethodBeat.m2504i(134568);
            if (C19095d.hbt == null) {
                C19095d.hbt = new C19095d();
            }
            axZ = C19095d.hbt;
            if (axZ == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(134568);
            return axZ;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$b */
    public static final class C19097b implements C38124a {
        final /* synthetic */ C19095d hbv;

        C19097b(C19095d c19095d) {
            this.hbv = c19095d;
        }

        /* renamed from: a */
        public final void mo34320a(anl anl) {
            AppMethodBeat.m2504i(134569);
            C25052j.m39376p(anl, "response");
            C19095d.m29707a(this.hbv, anl);
            AppMethodBeat.m2505o(134569);
        }

        public final void ayb() {
            AppMethodBeat.m2504i(134570);
            C19095d.m29706a(this.hbv, 1, null, 6);
            AppMethodBeat.m2505o(134570);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$h */
    static final class C19098h extends C25053k implements C31214a<LinkedList<Integer>> {
        public static final C19098h hbz = new C19098h();

        static {
            AppMethodBeat.m2504i(134579);
            AppMethodBeat.m2505o(134579);
        }

        C19098h() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134578);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.m2505o(134578);
            return linkedList;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 2>", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$g */
    static final class C19099g extends C25053k implements C36933q<Integer, LinkedList<bqd>, Integer, C37091y> {
        public static final C19099g hby = new C19099g();

        static {
            AppMethodBeat.m2504i(134577);
            AppMethodBeat.m2505o(134577);
        }

        C19099g() {
            super(3);
        }

        /* renamed from: g */
        public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(134576);
            ((Number) obj).intValue();
            LinkedList linkedList = (LinkedList) obj2;
            ((Number) obj3).intValue();
            C25052j.m39376p(linkedList, "<anonymous parameter 1>");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134576);
            return c37091y;
        }
    }

    static {
        AppMethodBeat.m2504i(134580);
        AppMethodBeat.m2505o(134580);
    }

    private final LinkedList<Integer> axX() {
        AppMethodBeat.m2504i(134581);
        LinkedList linkedList = (LinkedList) this.hbi.getValue();
        AppMethodBeat.m2505o(134581);
        return linkedList;
    }

    public final LinkedList<bqd> axY() {
        AppMethodBeat.m2504i(134582);
        LinkedList linkedList = (LinkedList) this.hbp.getValue();
        AppMethodBeat.m2505o(134582);
        return linkedList;
    }

    private C19095d() {
        AppMethodBeat.m2504i(134586);
        this.hbg = new C26763k();
        this.hbh = new C26759c();
        this.hbi = C17344i.m26854g(C19098h.hbz);
        this.hbo = 1;
        this.hbp = C17344i.m26854g(C2083c.hbw);
        this.hbr = new C19097b(this);
        this.hbs = C19099g.hby;
        AppMethodBeat.m2505o(134586);
    }

    public /* synthetic */ C19095d(byte b) {
        this();
    }

    /* renamed from: f */
    public static final /* synthetic */ LinkedList m29713f(C19095d c19095d) {
        AppMethodBeat.m2504i(134589);
        LinkedList axY = c19095d.axY();
        AppMethodBeat.m2505o(134589);
        return axY;
    }

    /* renamed from: g */
    public static final /* synthetic */ LinkedList m29714g(C19095d c19095d) {
        AppMethodBeat.m2504i(134590);
        LinkedList axX = c19095d.axX();
        AppMethodBeat.m2505o(134590);
        return axX;
    }

    /* renamed from: a */
    private final void m29703a(int i, LinkedList<bqd> linkedList, int i2) {
        AppMethodBeat.m2504i(134583);
        C36933q c36933q = this.hbs;
        if (c36933q != null) {
            c36933q.mo9028g(Integer.valueOf(i), linkedList, Integer.valueOf(i2));
            AppMethodBeat.m2505o(134583);
            return;
        }
        AppMethodBeat.m2505o(134583);
    }

    /* renamed from: a */
    private final void m29702a(int i, float f, float f2) {
        AppMethodBeat.m2504i(134585);
        if (C1720g.m3531RK()) {
            C23440sq c23440sq = new C23440sq();
            c23440sq.waf = C5023at.getNetTypeString(C4996ah.getContext());
            c23440sq.longitude = (double) f;
            c23440sq.latitude = (double) f2;
            if (C5058f.DEBUG && i != 0 && this.hbq) {
                C26763k c26763k = this.hbg;
                LinkedList linkedList = new LinkedList();
                bqd bqd = new bqd();
                c26763k.mo44538a(bqd);
                bqd.kLg = "####客户端mock数据####大视频";
                bqd.iAd = 6;
                bqd.wSr = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
                bqd.wSt = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
                linkedList.addLast(bqd);
                Collection collection = linkedList;
                bqd[] bqdArr = new bqd[4];
                for (int i2 = 0; i2 < 4; i2++) {
                    bqd bqd2 = new bqd();
                    c26763k.mo44538a(bqd2);
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
                C25052j.m39376p(collection, "receiver$0");
                C25052j.m39376p(bqdArr, MessengerShareContentUtility.ELEMENTS);
                collection.addAll(C36646h.asList(bqdArr));
                int size = i == 2 ? 0 : linkedList.size();
                Thread.sleep(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                m29703a(0, linkedList, size);
                AppMethodBeat.m2505o(134585);
                return;
            }
            C42370h.m74961a(i, c23440sq, this.hbj, this.hbr, this.hbo);
            AppMethodBeat.m2505o(134585);
            return;
        }
        AppMethodBeat.m2505o(134585);
    }
}
