package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.graphics.Rect;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.l */
final class C45701l extends C25373h {
    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        AppMethodBeat.m2504i(135114);
        if (recyclerView != null) {
            C41531v aZ = recyclerView.mo66337aZ(view);
            if (aZ != null) {
                if (aZ instanceof C33552m) {
                    int i;
                    View view2 = ((C33552m) aZ).iLS;
                    int kj = ((C33552m) aZ).mo66454kj();
                    C41523a adapter = recyclerView.getAdapter();
                    if (kj == (adapter != null ? adapter.getItemCount() : -1) - 1) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                    view2.setVisibility(i);
                }
                AppMethodBeat.m2505o(135114);
                return;
            }
        }
        AppMethodBeat.m2505o(135114);
    }
}
