package com.tencent.mm.plugin.appbrand.widget.i;

import a.f.b.j;
import a.k.u;
import a.l;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.HashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", "index", "isPackageIcon", "", "luggage-wxa-app_release"})
public final class f {
    final HashMap<Integer, d> jpy = new HashMap();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "destroy"})
    static final class a implements com.tencent.mm.plugin.appbrand.widget.i.d.a {
        final /* synthetic */ f jpz;

        a(f fVar) {
            this.jpz = fVar;
        }

        public final void destroy(int i) {
            AppMethodBeat.i(87607);
            if (i >= 0) {
                this.jpz.jpy.put(Integer.valueOf(i), null);
            }
            AppMethodBeat.o(87607);
        }
    }

    public f() {
        AppMethodBeat.i(87611);
        AppMethodBeat.o(87611);
    }

    public final d a(String str, c cVar, q qVar, int i) {
        AppMethodBeat.i(87608);
        j.p(str, "iconPath");
        j.p(cVar, "errorHandler");
        j.p(qVar, "service");
        d a = a(str, cVar, qVar);
        a.setIndex(i);
        a.a((com.tencent.mm.plugin.appbrand.widget.i.d.a) new a(this));
        d dVar = (d) this.jpy.get(Integer.valueOf(i));
        if (dVar != null) {
            dVar.cancel();
        }
        this.jpy.put(Integer.valueOf(i), a);
        AppMethodBeat.o(87608);
        return a;
    }

    private static d a(String str, c cVar, q qVar) {
        AppMethodBeat.i(87609);
        Object obj = (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str)) ? 1 : null;
        d gVar;
        if (1 == obj) {
            gVar = new g(str, cVar, qVar);
            AppMethodBeat.o(87609);
            return gVar;
        } else if (true == u.jb(str, "wxfile://")) {
            gVar = new i(str, cVar, qVar);
            AppMethodBeat.o(87609);
            return gVar;
        } else if (true == EW(str)) {
            gVar = new h(str, cVar, qVar);
            AppMethodBeat.o(87609);
            return gVar;
        } else {
            gVar = new b(str, cVar);
            AppMethodBeat.o(87609);
            return gVar;
        }
    }

    private static boolean EW(String str) {
        AppMethodBeat.i(87610);
        if (u.jc(str, ".png") || u.jc(str, FileUtils.PIC_POSTFIX_JPEG) || u.jc(str, ".bmp") || u.jc(str, ".gif")) {
            AppMethodBeat.o(87610);
            return true;
        }
        AppMethodBeat.o(87610);
        return false;
    }
}
