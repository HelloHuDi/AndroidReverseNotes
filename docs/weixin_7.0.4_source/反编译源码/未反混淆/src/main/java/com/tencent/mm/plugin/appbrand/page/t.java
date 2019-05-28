package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import java.util.HashSet;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class t {
    private static boolean isA = true;
    public static final t isB = new t();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "()V", "luggage-wechat-full-sdk_release"})
    static final class a extends HashSet<u> implements k {
        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(102474);
            if (obj instanceof u) {
                boolean contains = super.contains((u) obj);
                AppMethodBeat.o(102474);
                return contains;
            }
            AppMethodBeat.o(102474);
            return false;
        }

        public final /* bridge */ boolean remove(Object obj) {
            AppMethodBeat.i(102475);
            if (obj instanceof u) {
                boolean remove = super.remove((u) obj);
                AppMethodBeat.o(102475);
                return remove;
            }
            AppMethodBeat.o(102475);
            return false;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(102476);
            int size = super.size();
            AppMethodBeat.o(102476);
            return size;
        }
    }

    static {
        AppMethodBeat.i(102480);
        AppMethodBeat.o(102480);
    }

    private t() {
    }

    public static final void ev(boolean z) {
        isA = z;
    }

    public static final void d(u uVar) {
        AppMethodBeat.i(102477);
        j.p(uVar, "page");
        if (uVar.getRuntime() == null) {
            AppMethodBeat.o(102477);
            return;
        }
        try {
            i runtime = uVar.getRuntime();
            j.o(runtime, "page.runtime");
            B(runtime).remove(uVar);
            AppMethodBeat.o(102477);
        } catch (Exception e) {
            d.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(e)));
            AppMethodBeat.o(102477);
        }
    }

    private static a B(i iVar) {
        a aVar;
        AppMethodBeat.i(102479);
        a aVar2 = (a) iVar.ab(a.class);
        if (aVar2 == null) {
            aVar = new a();
            iVar.a((k) aVar);
        } else {
            aVar = aVar2;
        }
        AppMethodBeat.o(102479);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A:{Catch:{ Exception -> 0x0073 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean e(u uVar) {
        boolean z = false;
        AppMethodBeat.i(102478);
        j.p(uVar, "page");
        try {
            if (isA) {
                if (!uVar.atU()) {
                    i runtime = uVar.getRuntime();
                    if (runtime == null || !runtime.atr()) {
                        int pageCount;
                        runtime = uVar.getRuntime();
                        if (runtime != null) {
                            q asV = runtime.asV();
                            if (asV != null) {
                                pageCount = asV.getPageCount();
                                if (pageCount > 5) {
                                    n aJv = uVar.aJv();
                                    if (!(aJv == null || !aJv.isInBackground() || (uVar.aJv() instanceof g) || uVar.getRuntime() == null)) {
                                        runtime = uVar.getRuntime();
                                        j.o(runtime, "page.runtime");
                                        a B = B(runtime);
                                        if (B.size() < 2) {
                                            B.add(uVar);
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
            d.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "canTrimThisPAge ".concat(String.valueOf(e)));
        }
        AppMethodBeat.o(102478);
        return z;
    }
}
