package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.f;

@l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u001cH\u0002J\r\u0010\u001d\u001a\u00020\fH\u0010¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0013J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0004R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView;", "context", "Landroid/content/Context;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;)V", "mFloatViewHolder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "getRecyclerView", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "animateFloatViewHolderAppearance", "", "floatHolder", "attachDragCallback", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/ItemDragCallback;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "createFloatViewForCallback", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "holder", "getOffsetOfFloatAnimation", "", "onBindFloatViewHolder", "originHolder", "onCreateFloatViewHolder", "Landroid/view/ViewGroup;", "onListMayChanged", "onListMayChanged$plugin_appbrand_integration_release", "onViewAdded", "child", "resetFloatViewHolder", "setRubbishViewVisible", "visibility", "", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public class b extends DragFeatureView {
    private n iLE;
    private final i iLF;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000q\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J@\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J.\u0010\u0015\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J4\u0010\u0018\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¨\u0006\u001d¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$2$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IItemDragResultCallback;", "isCanCancel", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "target", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "isCanMove", "holder", "from", "", "to", "itemContent", "", "isDragEnable", "onCreateFloatView", "Landroid/view/View;", "onDelete", "", "dragObject", "onDrag", "floatView", "area", "onDragEnd", "startPos", "endPos", "isInserted", "onDragRelease", "plugin-appbrand-integration_release"})
    public static final class a implements com.tencent.mm.plugin.appbrand.widget.desktop.a.a {
        final /* synthetic */ b iLG;

        a(b bVar) {
            this.iLG = bVar;
        }

        public final void a(int i, int i2, Object obj, boolean z) {
            AppMethodBeat.i(135078);
            this.iLG.aMZ();
            AppMethodBeat.o(135078);
        }

        public final void by(Object obj) {
            AppMethodBeat.i(135079);
            this.iLG.aMZ();
            AppMethodBeat.o(135079);
        }

        public final View b(RecyclerView recyclerView, v vVar) {
            AppMethodBeat.i(135080);
            b bVar = this.iLG;
            if (recyclerView == null) {
                j.dWJ();
            }
            if (vVar == null) {
                a.v vVar2 = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionViewHolder");
                AppMethodBeat.o(135080);
                throw vVar2;
            }
            View a = b.a(bVar, recyclerView, (n) vVar);
            AppMethodBeat.o(135080);
            return a;
        }

        public final void a(v vVar, View view, Object obj, int i) {
        }

        public final void cu(View view) {
            AppMethodBeat.i(135081);
            j.p(view, "floatView");
            AppMethodBeat.o(135081);
        }

        public final boolean O(v vVar) {
            return true;
        }

        public final boolean a(v vVar, Object obj) {
            return true;
        }

        public final boolean P(v vVar) {
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/OnDragCallback;", "getDragViewTransX", "", "getDragViewTransY", "getScaleView", "Landroid/view/View;", "floatView", "onDragObject", "", "o", "onPositionChanged", "", "dragObject", "targetPosition", "", "plugin-appbrand-integration_release"})
    public static final class b implements f {
        b() {
        }

        public final void f(Object obj, int i) {
        }

        public final Object bz(Object obj) {
            AppMethodBeat.i(135082);
            if (obj == null) {
                j.dWJ();
            }
            AppMethodBeat.o(135082);
            return obj;
        }

        public final float aNa() {
            return 0.0f;
        }

        public final float aNb() {
            return 0.0f;
        }

        public final View cv(View view) {
            return null;
        }
    }

    public b(Context context, i iVar) {
        j.p(context, "context");
        j.p(iVar, "recyclerView");
        super(context);
        AppMethodBeat.i(135086);
        this.iLF = iVar;
        AppMethodBeat.o(135086);
    }

    public final i getRecyclerView() {
        return this.iLF;
    }

    public void aMZ() {
    }

    public final c<?> N(v vVar) {
        AppMethodBeat.i(135083);
        if (vVar == null || vVar.kk() != 1) {
            AppMethodBeat.o(135083);
            return null;
        }
        FrameLayout frameLayout = this;
        android.support.v7.widget.RecyclerView.a adapter = this.iLF.getAdapter();
        if (adapter == null) {
            a.v vVar2 = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionAdapter");
            AppMethodBeat.o(135083);
            throw vVar2;
        }
        e eVar = new e(frameLayout, ((a) adapter).iLD, new b());
        eVar.a(new a(this));
        c cVar = eVar;
        AppMethodBeat.o(135083);
        return cVar;
    }

    public final void setRubbishViewVisible(int i) {
        AppMethodBeat.i(135084);
        super.setRubbishViewVisible(i);
        AppMethodBeat.o(135084);
    }

    public final void onViewAdded(View view) {
        Object obj;
        AppMethodBeat.i(135085);
        super.onViewAdded(view);
        n nVar = this.iLE;
        if (nVar != null) {
            obj = nVar.apJ;
        } else {
            obj = null;
        }
        if (j.j(view, obj)) {
            float f;
            n nVar2 = this.iLE;
            if (nVar2 == null) {
                j.dWJ();
            }
            ViewPropertyAnimator animate = nVar2.apJ.animate();
            View view2 = nVar2.apJ;
            j.o(view2, "floatHolder.itemView");
            float translationY = view2.getTranslationY();
            TextView textView = nVar2.iLP;
            LayoutParams layoutParams = textView.getLayoutParams();
            if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
                layoutParams = null;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            float height = (float) textView.getHeight();
            if (layoutParams2 != null) {
                f = ((float) (layoutParams2.bottomMargin + layoutParams2.topMargin)) + height;
            } else {
                f = height;
            }
            animate.translationY((f / 2.0f) + translationY).setDuration(1).start();
            nVar2.apJ.animate().scaleX(1.3f).scaleY(1.3f).setDuration(200).setListener(null).setUpdateListener(null).start();
            nVar2.apJ.animate().alpha(0.6f).setDuration(200).setListener(null).setUpdateListener(null).start();
        }
        AppMethodBeat.o(135085);
    }

    public static final /* synthetic */ View a(b bVar, RecyclerView recyclerView, n nVar) {
        View inflate;
        View view;
        AppMethodBeat.i(135087);
        if (bVar.iLE == null) {
            inflate = LayoutInflater.from(bVar.getContext()).inflate(R.layout.br, recyclerView, false);
            j.o(inflate, "LayoutInflater.from(cont…list_item, parent, false)");
            bVar.iLE = new n(inflate);
        }
        n nVar2 = bVar.iLE;
        if (nVar2 == null) {
            j.dWJ();
        }
        inflate = nVar2.apJ;
        j.o(inflate, "floatHolder.itemView");
        LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            view = nVar.apJ;
            j.o(view, "originHolder.itemView");
            layoutParams.width = view.getWidth();
        }
        inflate = nVar2.apJ;
        j.o(inflate, "floatHolder.itemView");
        layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            view = nVar.apJ;
            j.o(view, "originHolder.itemView");
            layoutParams.height = view.getHeight();
        }
        nVar2.iLP.setVisibility(4);
        LocalUsageInfo localUsageInfo = nVar.iLT;
        if (localUsageInfo == null) {
            j.dWJ();
        }
        nVar2.f(localUsageInfo);
        nVar2.iLR.setScaleX(1.0f);
        nVar2.iLR.setScaleY(1.0f);
        inflate = nVar2.apJ;
        j.o(inflate, "floatHolder.itemView");
        inflate.setAlpha(1.0f);
        inflate = nVar2.apJ;
        j.o(inflate, "floatHolder.itemView");
        view = nVar.apJ;
        j.o(view, "originHolder.itemView");
        inflate.setTranslationX(view.getX());
        View view2 = nVar2.apJ;
        j.o(view2, "floatHolder.itemView");
        inflate = nVar.apJ;
        j.o(inflate, "originHolder.itemView");
        view2.setTranslationY(inflate.getY());
        nVar2 = bVar.iLE;
        if (nVar2 == null) {
            j.dWJ();
        }
        view2 = nVar2.apJ;
        j.o(view2, "mFloatViewHolder!!.itemView");
        AppMethodBeat.o(135087);
        return view2;
    }
}
