package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005H\u0016¢\u0006\u0002\u0010\u0014R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mScreenAdaptiveViews", "", "Ljava/lang/Class;", "Landroid/view/ViewGroup;", "[Ljava/lang/Class;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "onCreateWidget", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class d extends a {
    private final Class<? extends ViewGroup>[] iqS = new Class[]{b.class, com.tencent.mm.plugin.appbrand.widget.i.a.class};

    public d() {
        AppMethodBeat.i(134758);
        AppMethodBeat.o(134758);
    }

    public final <WIDGET extends View> WIDGET b(Context context, Class<WIDGET> cls) {
        Object obj = null;
        AppMethodBeat.i(134757);
        j.p(context, "context");
        j.p(cls, "clazz");
        for (Object j : this.iqS) {
            if (j.j(j, cls)) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            View b = super.b(new com.tencent.mm.plugin.appbrand.ui.l(context), cls);
            AppMethodBeat.o(134757);
            return b;
        }
        WIDGET b2 = super.b(context, cls);
        AppMethodBeat.o(134757);
        return b2;
    }
}
