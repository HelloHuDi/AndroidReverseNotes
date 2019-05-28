package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C37139r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C33569q;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/SmoothScrollLinerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "supportsPredictiveItemAnimations", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.j */
public final class C38564j extends LinearLayoutManager {
    private final Context context;

    public C38564j(Context context) {
        C25052j.m39376p(context, "context");
        AppMethodBeat.m2504i(135216);
        this.context = context;
        AppMethodBeat.m2505o(135216);
    }

    /* renamed from: a */
    public final void mo1755a(RecyclerView recyclerView, int i) {
        AppMethodBeat.m2504i(135215);
        C25052j.m39376p(recyclerView, "recyclerView");
        C33569q c33569q = new C33569q(this.context, this);
        c33569q.mo59207cv(i);
        mo31829a((C37139r) c33569q);
        AppMethodBeat.m2505o(135215);
    }

    /* renamed from: iE */
    public final boolean mo1774iE() {
        return false;
    }
}
