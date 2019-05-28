package com.tencent.p177mm.plugin.appbrand.page;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10442k;
import java.util.HashSet;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.t */
public final class C45666t {
    private static boolean isA = true;
    public static final C45666t isB = new C45666t();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "()V", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.t$a */
    static final class C16694a extends HashSet<C44709u> implements C10442k {
        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.m2504i(102474);
            if (obj instanceof C44709u) {
                boolean contains = super.contains((C44709u) obj);
                AppMethodBeat.m2505o(102474);
                return contains;
            }
            AppMethodBeat.m2505o(102474);
            return false;
        }

        public final /* bridge */ boolean remove(Object obj) {
            AppMethodBeat.m2504i(102475);
            if (obj instanceof C44709u) {
                boolean remove = super.remove((C44709u) obj);
                AppMethodBeat.m2505o(102475);
                return remove;
            }
            AppMethodBeat.m2505o(102475);
            return false;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.m2504i(102476);
            int size = super.size();
            AppMethodBeat.m2505o(102476);
            return size;
        }
    }

    static {
        AppMethodBeat.m2504i(102480);
        AppMethodBeat.m2505o(102480);
    }

    private C45666t() {
    }

    /* renamed from: ev */
    public static final void m84357ev(boolean z) {
        isA = z;
    }

    /* renamed from: d */
    public static final void m84355d(C44709u c44709u) {
        AppMethodBeat.m2504i(102477);
        C25052j.m39376p(c44709u, "page");
        if (c44709u.getRuntime() == null) {
            AppMethodBeat.m2505o(102477);
            return;
        }
        try {
            C6750i runtime = c44709u.getRuntime();
            C25052j.m39375o(runtime, "page.runtime");
            C45666t.m84354B(runtime).remove(c44709u);
            AppMethodBeat.m2505o(102477);
        } catch (Exception e) {
            C45124d.m82933w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(102477);
        }
    }

    /* renamed from: B */
    private static C16694a m84354B(C6750i c6750i) {
        C16694a c16694a;
        AppMethodBeat.m2504i(102479);
        C16694a c16694a2 = (C16694a) c6750i.mo14987ab(C16694a.class);
        if (c16694a2 == null) {
            c16694a = new C16694a();
            c6750i.mo14985a((C10442k) c16694a);
        } else {
            c16694a = c16694a2;
        }
        AppMethodBeat.m2505o(102479);
        return c16694a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A:{Catch:{ Exception -> 0x0073 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public static final boolean m84356e(C44709u c44709u) {
        boolean z = false;
        AppMethodBeat.m2504i(102478);
        C25052j.m39376p(c44709u, "page");
        try {
            if (isA) {
                if (!c44709u.atU()) {
                    C6750i runtime = c44709u.getRuntime();
                    if (runtime == null || !runtime.atr()) {
                        int pageCount;
                        runtime = c44709u.getRuntime();
                        if (runtime != null) {
                            C38470q asV = runtime.asV();
                            if (asV != null) {
                                pageCount = asV.getPageCount();
                                if (pageCount > 5) {
                                    C19640n aJv = c44709u.aJv();
                                    if (!(aJv == null || !aJv.isInBackground() || (c44709u.aJv() instanceof C27224g) || c44709u.getRuntime() == null)) {
                                        runtime = c44709u.getRuntime();
                                        C25052j.m39375o(runtime, "page.runtime");
                                        C16694a B = C45666t.m84354B(runtime);
                                        if (B.size() < 2) {
                                            B.add(c44709u);
                                            z = true;
                                        }
                                    }
                                }
                            }
                        }
                        pageCount = 0;
                        if (pageCount > 5) {
                        }
                    } else {
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            C45124d.m82933w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "canTrimThisPAge ".concat(String.valueOf(e)));
        }
        AppMethodBeat.m2505o(102478);
        return z;
    }
}
