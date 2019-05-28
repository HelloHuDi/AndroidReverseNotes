package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Context;
import android.graphics.Rect;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.f */
final class C10867f extends C25373h {
    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(135100);
        if (rect == null) {
            C25052j.dWJ();
        }
        rect.left = 0;
        rect.right = 0;
        rect.top = 0;
        if (recyclerView == null) {
            C25052j.dWJ();
        }
        C17480i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
            AppMethodBeat.m2505o(135100);
            throw c44941v;
        }
        int i;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (view == null) {
            C25052j.dWJ();
        }
        C41531v aZ = recyclerView.mo66337aZ(view);
        C25052j.m39375o(aZ, "parent.getChildViewHolder(view!!)");
        int kj = aZ.mo66454kj();
        C41523a adapter = recyclerView.getAdapter();
        C25052j.m39375o(adapter, "parent.adapter");
        if (kj >= gridLayoutManager.mo51943iD() * (adapter.getItemCount() / gridLayoutManager.mo51943iD())) {
            i = 0;
        } else {
            Context context = recyclerView.getContext();
            C25052j.m39375o(context, "parent.context");
            i = context.getResources().getDimensionPixelSize(C25738R.dimen.f10180tj);
        }
        rect.bottom = i;
        AppMethodBeat.m2505o(135100);
    }
}
