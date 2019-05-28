package com.tencent.mm.plugin.appbrand.ui.recents;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001e\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014J&\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderController;", "context", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "inflateChildren", "", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AbsAppBrandLauncherListHeader;", "childrenContainer", "showRecents", "", "inflateCollection", "inflateNearBy", "inflateRecents", "inflateWagame", "plugin-appbrand-integration_release"})
public final class g extends f {
    public g(Activity activity, ViewGroup viewGroup) {
        j.p(activity, "context");
        j.p(viewGroup, "viewGroup");
        super(activity, viewGroup, true, true);
        AppMethodBeat.i(135138);
        AppMethodBeat.o(135138);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<a> a(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.i(135133);
        j.p(activity, "context");
        j.p(viewGroup, "childrenContainer");
        ArrayList arrayList = new ArrayList(2);
        f.a((List) arrayList, b(activity, viewGroup, z));
        f.a((List) arrayList, b(activity, viewGroup));
        f.a((List) arrayList, c(activity, viewGroup));
        f.a((List) arrayList, a(activity, viewGroup));
        List list = arrayList;
        AppMethodBeat.o(135133);
        return list;
    }

    /* Access modifiers changed, original: protected|final */
    public final a b(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(135134);
        a b = super.b(activity, viewGroup);
        if (b != null) {
            b.eH(false);
        }
        AppMethodBeat.o(135134);
        return b;
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(135135);
        a c = super.c(activity, viewGroup);
        if (c != null) {
            c.eH(true);
        }
        AppMethodBeat.o(135135);
        return c;
    }

    /* Access modifiers changed, original: protected|final */
    public final a a(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(135136);
        a a = super.a(activity, viewGroup);
        if (a != null) {
            a.eH(false);
        }
        AppMethodBeat.o(135136);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final a b(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.i(135137);
        a b = super.b(activity, viewGroup, z);
        if (b != null) {
            b.eH(false);
        }
        AppMethodBeat.o(135137);
        return b;
    }
}
