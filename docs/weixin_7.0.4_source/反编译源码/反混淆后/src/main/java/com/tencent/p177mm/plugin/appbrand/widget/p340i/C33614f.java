package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C33612d.C33613a;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.HashMap;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", "index", "isPackageIcon", "", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.f */
public final class C33614f {
    final HashMap<Integer, C33612d> jpy = new HashMap();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "destroy"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.i.f$a */
    static final class C27396a implements C33613a {
        final /* synthetic */ C33614f jpz;

        C27396a(C33614f c33614f) {
            this.jpz = c33614f;
        }

        public final void destroy(int i) {
            AppMethodBeat.m2504i(87607);
            if (i >= 0) {
                this.jpz.jpy.put(Integer.valueOf(i), null);
            }
            AppMethodBeat.m2505o(87607);
        }
    }

    public C33614f() {
        AppMethodBeat.m2504i(87611);
        AppMethodBeat.m2505o(87611);
    }

    /* renamed from: a */
    public final C33612d mo54189a(String str, C33611c c33611c, C38492q c38492q, int i) {
        AppMethodBeat.m2504i(87608);
        C25052j.m39376p(str, "iconPath");
        C25052j.m39376p(c33611c, "errorHandler");
        C25052j.m39376p(c38492q, "service");
        C33612d a = C33614f.m54887a(str, c33611c, c38492q);
        a.setIndex(i);
        a.mo54184a((C33613a) new C27396a(this));
        C33612d c33612d = (C33612d) this.jpy.get(Integer.valueOf(i));
        if (c33612d != null) {
            c33612d.cancel();
        }
        this.jpy.put(Integer.valueOf(i), a);
        AppMethodBeat.m2505o(87608);
        return a;
    }

    /* renamed from: a */
    private static C33612d m54887a(String str, C33611c c33611c, C38492q c38492q) {
        AppMethodBeat.m2504i(87609);
        Object obj = (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str)) ? 1 : null;
        C33612d c2554g;
        if (1 == obj) {
            c2554g = new C2554g(str, c33611c, c38492q);
            AppMethodBeat.m2505o(87609);
            return c2554g;
        } else if (true == C6163u.m9839jb(str, "wxfile://")) {
            c2554g = new C11004i(str, c33611c, c38492q);
            AppMethodBeat.m2505o(87609);
            return c2554g;
        } else if (true == C33614f.m54886EW(str)) {
            c2554g = new C11002h(str, c33611c, c38492q);
            AppMethodBeat.m2505o(87609);
            return c2554g;
        } else {
            c2554g = new C36737b(str, c33611c);
            AppMethodBeat.m2505o(87609);
            return c2554g;
        }
    }

    /* renamed from: EW */
    private static boolean m54886EW(String str) {
        AppMethodBeat.m2504i(87610);
        if (C6163u.m9840jc(str, ".png") || C6163u.m9840jc(str, FileUtils.PIC_POSTFIX_JPEG) || C6163u.m9840jc(str, ".bmp") || C6163u.m9840jc(str, ".gif")) {
            AppMethodBeat.m2505o(87610);
            return true;
        }
        AppMethodBeat.m2505o(87610);
        return false;
    }
}
