package com.tencent.p177mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.C19793l;
import com.tencent.p177mm.plugin.appbrand.page.C2410ap.C2411a;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C10989a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005H\u0016¢\u0006\u0002\u0010\u0014R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mScreenAdaptiveViews", "", "Ljava/lang/Class;", "Landroid/view/ViewGroup;", "[Ljava/lang/Class;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "onCreateWidget", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.d */
public final class C31330d extends C2411a {
    private final Class<? extends ViewGroup>[] iqS = new Class[]{C10933b.class, C10989a.class};

    public C31330d() {
        AppMethodBeat.m2504i(134758);
        AppMethodBeat.m2505o(134758);
    }

    /* renamed from: b */
    public final <WIDGET extends View> WIDGET mo6322b(Context context, Class<WIDGET> cls) {
        Object obj = null;
        AppMethodBeat.m2504i(134757);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(cls, "clazz");
        for (Object j : this.iqS) {
            if (C25052j.m39373j(j, cls)) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            View b = super.mo6322b(new C19793l(context), cls);
            AppMethodBeat.m2505o(134757);
            return b;
        }
        WIDGET b2 = super.mo6322b(context, cls);
        AppMethodBeat.m2505o(134757);
        return b2;
    }
}
