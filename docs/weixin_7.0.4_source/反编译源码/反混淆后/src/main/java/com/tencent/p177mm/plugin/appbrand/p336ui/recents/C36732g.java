package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001e\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014J&\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderController;", "context", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "inflateChildren", "", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AbsAppBrandLauncherListHeader;", "childrenContainer", "showRecents", "", "inflateCollection", "inflateNearBy", "inflateRecents", "inflateWagame", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.g */
public final class C36732g extends C33565f {
    public C36732g(Activity activity, ViewGroup viewGroup) {
        C25052j.m39376p(activity, "context");
        C25052j.m39376p(viewGroup, "viewGroup");
        super(activity, viewGroup, true, true);
        AppMethodBeat.m2504i(135138);
        AppMethodBeat.m2505o(135138);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final List<C27336a> mo54049a(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.m2504i(135133);
        C25052j.m39376p(activity, "context");
        C25052j.m39376p(viewGroup, "childrenContainer");
        ArrayList arrayList = new ArrayList(2);
        C33565f.m54798a((List) arrayList, mo54051b(activity, viewGroup, z));
        C33565f.m54798a((List) arrayList, mo54050b(activity, viewGroup));
        C33565f.m54798a((List) arrayList, mo54052c(activity, viewGroup));
        C33565f.m54798a((List) arrayList, mo54048a(activity, viewGroup));
        List list = arrayList;
        AppMethodBeat.m2505o(135133);
        return list;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final C27336a mo54050b(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(135134);
        C27336a b = super.mo54050b(activity, viewGroup);
        if (b != null) {
            b.mo6421eH(false);
        }
        AppMethodBeat.m2505o(135134);
        return b;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C27336a mo54052c(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(135135);
        C27336a c = super.mo54052c(activity, viewGroup);
        if (c != null) {
            c.mo6421eH(true);
        }
        AppMethodBeat.m2505o(135135);
        return c;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C27336a mo54048a(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(135136);
        C27336a a = super.mo54048a(activity, viewGroup);
        if (a != null) {
            a.mo6421eH(false);
        }
        AppMethodBeat.m2505o(135136);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final C27336a mo54051b(Activity activity, ViewGroup viewGroup, boolean z) {
        AppMethodBeat.m2504i(135137);
        C27336a b = super.mo54051b(activity, viewGroup, z);
        if (b != null) {
            b.mo6421eH(false);
        }
        AppMethodBeat.m2505o(135137);
        return b;
    }
}
