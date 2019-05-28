package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\f¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Companion", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.v */
public final class C45628v extends C38369p {
    public static final int CTRL_INDEX = 590;
    public static final String NAME = "onKeyboardHeightChange";
    public static final C38395a hwn = new C38395a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.v$a */
    public static final class C38395a {
        private C38395a() {
        }

        public /* synthetic */ C38395a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(87573);
        AppMethodBeat.m2505o(87573);
    }

    /* renamed from: a */
    public final void mo73408a(int i, C38492q c38492q, C44709u c44709u, Integer num) {
        AppMethodBeat.m2504i(87572);
        C25052j.m39376p(c38492q, "service");
        C25052j.m39376p(c44709u, "page");
        mo67975n("height", Integer.valueOf(C42668g.m75569pZ(i)));
        if (num != null) {
            mo67975n("inputId", Integer.valueOf(num.intValue()));
        }
        mo61031i(c38492q).aCj();
        mo61031i(c44709u).aCj();
        AppMethodBeat.m2505o(87572);
    }
}
