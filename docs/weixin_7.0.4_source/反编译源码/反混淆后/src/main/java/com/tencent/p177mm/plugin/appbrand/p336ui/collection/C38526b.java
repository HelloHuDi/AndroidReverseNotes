package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.DragFeatureView;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C2541a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C27359f;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C38576c;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a.C38577e;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u001cH\u0002J\r\u0010\u001d\u001a\u00020\fH\u0010¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0013J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0004R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/DragFeatureView;", "context", "Landroid/content/Context;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;)V", "mFloatViewHolder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "getRecyclerView", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "animateFloatViewHolderAppearance", "", "floatHolder", "attachDragCallback", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/ItemDragCallback;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "createFloatViewForCallback", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "holder", "getOffsetOfFloatAnimation", "", "onBindFloatViewHolder", "originHolder", "onCreateFloatViewHolder", "Landroid/view/ViewGroup;", "onListMayChanged", "onListMayChanged$plugin_appbrand_integration_release", "onViewAdded", "child", "resetFloatViewHolder", "setRubbishViewVisible", "visibility", "", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.b */
public class C38526b extends DragFeatureView {
    private C33554n iLE;
    private final C10871i iLF;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000q\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J@\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J.\u0010\u0015\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J4\u0010\u0018\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¨\u0006\u001d¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$2$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/IItemDragResultCallback;", "isCanCancel", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "target", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "isCanMove", "holder", "from", "", "to", "itemContent", "", "isDragEnable", "onCreateFloatView", "Landroid/view/View;", "onDelete", "", "dragObject", "onDrag", "floatView", "area", "onDragEnd", "startPos", "endPos", "isInserted", "onDragRelease", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.b$a */
    public static final class C38527a implements C2541a {
        final /* synthetic */ C38526b iLG;

        C38527a(C38526b c38526b) {
            this.iLG = c38526b;
        }

        /* renamed from: a */
        public final void mo6500a(int i, int i2, Object obj, boolean z) {
            AppMethodBeat.m2504i(135078);
            this.iLG.aMZ();
            AppMethodBeat.m2505o(135078);
        }

        /* renamed from: by */
        public final void mo6504by(Object obj) {
            AppMethodBeat.m2504i(135079);
            this.iLG.aMZ();
            AppMethodBeat.m2505o(135079);
        }

        /* renamed from: b */
        public final View mo6503b(RecyclerView recyclerView, C41531v c41531v) {
            AppMethodBeat.m2504i(135080);
            C38526b c38526b = this.iLG;
            if (recyclerView == null) {
                C25052j.dWJ();
            }
            if (c41531v == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionViewHolder");
                AppMethodBeat.m2505o(135080);
                throw c44941v;
            }
            View a = C38526b.m65241a(c38526b, recyclerView, (C33554n) c41531v);
            AppMethodBeat.m2505o(135080);
            return a;
        }

        /* renamed from: a */
        public final void mo6501a(C41531v c41531v, View view, Object obj, int i) {
        }

        /* renamed from: cu */
        public final void mo6505cu(View view) {
            AppMethodBeat.m2504i(135081);
            C25052j.m39376p(view, "floatView");
            AppMethodBeat.m2505o(135081);
        }

        /* renamed from: O */
        public final boolean mo6498O(C41531v c41531v) {
            return true;
        }

        /* renamed from: a */
        public final boolean mo6502a(C41531v c41531v, Object obj) {
            return true;
        }

        /* renamed from: P */
        public final boolean mo6499P(C41531v c41531v) {
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView$attachDragCallback$1", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/OnDragCallback;", "getDragViewTransX", "", "getDragViewTransY", "getScaleView", "Landroid/view/View;", "floatView", "onDragObject", "", "o", "onPositionChanged", "", "dragObject", "targetPosition", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.b$b */
    public static final class C38528b implements C27359f {
        C38528b() {
        }

        /* renamed from: f */
        public final void mo22524f(Object obj, int i) {
        }

        /* renamed from: bz */
        public final Object mo22522bz(Object obj) {
            AppMethodBeat.m2504i(135082);
            if (obj == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(135082);
            return obj;
        }

        public final float aNa() {
            return 0.0f;
        }

        public final float aNb() {
            return 0.0f;
        }

        /* renamed from: cv */
        public final View mo22523cv(View view) {
            return null;
        }
    }

    public C38526b(Context context, C10871i c10871i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c10871i, "recyclerView");
        super(context);
        AppMethodBeat.m2504i(135086);
        this.iLF = c10871i;
        AppMethodBeat.m2505o(135086);
    }

    public final C10871i getRecyclerView() {
        return this.iLF;
    }

    public void aMZ() {
    }

    /* renamed from: N */
    public final C38576c<?> mo54132N(C41531v c41531v) {
        AppMethodBeat.m2504i(135083);
        if (c41531v == null || c41531v.mo66455kk() != 1) {
            AppMethodBeat.m2505o(135083);
            return null;
        }
        FrameLayout frameLayout = this;
        C41523a adapter = this.iLF.getAdapter();
        if (adapter == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionAdapter");
            AppMethodBeat.m2505o(135083);
            throw c44941v;
        }
        C38577e c38577e = new C38577e(frameLayout, ((C19778a) adapter).iLD, new C38528b());
        c38577e.mo61319a(new C38527a(this));
        C38576c c38576c = c38577e;
        AppMethodBeat.m2505o(135083);
        return c38576c;
    }

    public final void setRubbishViewVisible(int i) {
        AppMethodBeat.m2504i(135084);
        super.setRubbishViewVisible(i);
        AppMethodBeat.m2505o(135084);
    }

    public final void onViewAdded(View view) {
        Object obj;
        AppMethodBeat.m2504i(135085);
        super.onViewAdded(view);
        C33554n c33554n = this.iLE;
        if (c33554n != null) {
            obj = c33554n.apJ;
        } else {
            obj = null;
        }
        if (C25052j.m39373j(view, obj)) {
            float f;
            C33554n c33554n2 = this.iLE;
            if (c33554n2 == null) {
                C25052j.dWJ();
            }
            ViewPropertyAnimator animate = c33554n2.apJ.animate();
            View view2 = c33554n2.apJ;
            C25052j.m39375o(view2, "floatHolder.itemView");
            float translationY = view2.getTranslationY();
            TextView textView = c33554n2.iLP;
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
            c33554n2.apJ.animate().scaleX(1.3f).scaleY(1.3f).setDuration(200).setListener(null).setUpdateListener(null).start();
            c33554n2.apJ.animate().alpha(0.6f).setDuration(200).setListener(null).setUpdateListener(null).start();
        }
        AppMethodBeat.m2505o(135085);
    }

    /* renamed from: a */
    public static final /* synthetic */ View m65241a(C38526b c38526b, RecyclerView recyclerView, C33554n c33554n) {
        View inflate;
        View view;
        AppMethodBeat.m2504i(135087);
        if (c38526b.iLE == null) {
            inflate = LayoutInflater.from(c38526b.getContext()).inflate(2130968667, recyclerView, false);
            C25052j.m39375o(inflate, "LayoutInflater.from(cont…list_item, parent, false)");
            c38526b.iLE = new C33554n(inflate);
        }
        C33554n c33554n2 = c38526b.iLE;
        if (c33554n2 == null) {
            C25052j.dWJ();
        }
        inflate = c33554n2.apJ;
        C25052j.m39375o(inflate, "floatHolder.itemView");
        LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            view = c33554n.apJ;
            C25052j.m39375o(view, "originHolder.itemView");
            layoutParams.width = view.getWidth();
        }
        inflate = c33554n2.apJ;
        C25052j.m39375o(inflate, "floatHolder.itemView");
        layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            view = c33554n.apJ;
            C25052j.m39375o(view, "originHolder.itemView");
            layoutParams.height = view.getHeight();
        }
        c33554n2.iLP.setVisibility(4);
        LocalUsageInfo localUsageInfo = c33554n.iLT;
        if (localUsageInfo == null) {
            C25052j.dWJ();
        }
        c33554n2.mo54035f(localUsageInfo);
        c33554n2.iLR.setScaleX(1.0f);
        c33554n2.iLR.setScaleY(1.0f);
        inflate = c33554n2.apJ;
        C25052j.m39375o(inflate, "floatHolder.itemView");
        inflate.setAlpha(1.0f);
        inflate = c33554n2.apJ;
        C25052j.m39375o(inflate, "floatHolder.itemView");
        view = c33554n.apJ;
        C25052j.m39375o(view, "originHolder.itemView");
        inflate.setTranslationX(view.getX());
        View view2 = c33554n2.apJ;
        C25052j.m39375o(view2, "floatHolder.itemView");
        inflate = c33554n.apJ;
        C25052j.m39375o(inflate, "originHolder.itemView");
        view2.setTranslationY(inflate.getY());
        c33554n2 = c38526b.iLE;
        if (c33554n2 == null) {
            C25052j.dWJ();
        }
        view2 = c33554n2.apJ;
        C25052j.m39375o(view2, "mFloatViewHolder!!.itemView");
        AppMethodBeat.m2505o(135087);
        return view2;
    }
}
