package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
final class f extends h {
    public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        AppMethodBeat.i(135100);
        if (rect == null) {
            j.dWJ();
        }
        rect.left = 0;
        rect.right = 0;
        rect.top = 0;
        if (recyclerView == null) {
            j.dWJ();
        }
        i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            v vVar = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
            AppMethodBeat.o(135100);
            throw vVar;
        }
        int i;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (view == null) {
            j.dWJ();
        }
        RecyclerView.v aZ = recyclerView.aZ(view);
        j.o(aZ, "parent.getChildViewHolder(view!!)");
        int kj = aZ.kj();
        a adapter = recyclerView.getAdapter();
        j.o(adapter, "parent.adapter");
        if (kj >= gridLayoutManager.iD() * (adapter.getItemCount() / gridLayoutManager.iD())) {
            i = 0;
        } else {
            Context context = recyclerView.getContext();
            j.o(context, "parent.context");
            i = context.getResources().getDimensionPixelSize(R.dimen.tj);
        }
        rect.bottom = i;
        AppMethodBeat.o(135100);
    }
}
