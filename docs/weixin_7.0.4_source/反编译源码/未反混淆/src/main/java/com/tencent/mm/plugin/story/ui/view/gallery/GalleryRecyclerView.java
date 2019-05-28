package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.m;
import a.f.a.q;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.ui.a.i;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u000223B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017Re\u0010\u0018\u001aM\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RL\u0010$\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001f\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "childControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "childRecyclerView", "value", "", "isActive", "()Z", "setActive", "(Z)V", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "onRowSelected", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "row", "rowView", "pageControl", "", "getOnRowSelected", "()Lkotlin/jvm/functions/Function3;", "setOnRowSelected", "(Lkotlin/jvm/functions/Function3;)V", "onScrollCallback", "Lkotlin/Function2;", "position", "", "offset", "getOnScrollCallback", "()Lkotlin/jvm/functions/Function2;", "setOnScrollCallback", "(Lkotlin/jvm/functions/Function2;)V", "selectedRow", "child", "Landroid/view/View;", "setScrollEnable", "enabled", "Companion", "VerticalAdapter", "plugin-story_release"})
public final class GalleryRecyclerView extends RecyclerView {
    private static final String TAG = TAG;
    public static final a snX = new a();
    boolean csi;
    int rZb;
    private final com.tencent.mm.plugin.story.ui.b.b snT;
    RecyclerView snU;
    q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, y> snV;
    private m<? super Integer, ? super Float, y> snW;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J$\u0010\u001f\u001a\u00020\n2\u001c\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120!J\u0016\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR>\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120\u0010j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012`\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;)V", "bindCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getBindCallback", "()Lkotlin/jvm/functions/Function1;", "setBindCallback", "(Lkotlin/jvm/functions/Function1;)V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "prePosition", "preRow", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "updateChildRecyclerPosition", "row", "plugin-story_release"})
    public final class b extends android.support.v7.widget.RecyclerView.a<s> {
        private final ArrayList<ArrayList<g>> rZR = new ArrayList();
        a.f.a.b<? super Integer, y> tBr;
        int tBs = -1;
        int tBt;
        private final n tBu = new n();

        public b() {
            AppMethodBeat.i(139112);
            this.tBu.aF(0, 2);
            AppMethodBeat.o(139112);
        }

        public final /* synthetic */ void k(v vVar) {
            AppMethodBeat.i(139111);
            s sVar = (s) vVar;
            j.p(sVar, "holder");
            super.k(sVar);
            if (sVar.iJP.getChildCount() > 0) {
                v aZ = sVar.iJP.aZ(sVar.iJP.getChildAt(0));
                if (aZ instanceof i) {
                    ((i) aZ).cCi();
                }
            }
            AppMethodBeat.o(139111);
        }

        public final void dI(List<? extends ArrayList<g>> list) {
            AppMethodBeat.i(139107);
            j.p(list, "items");
            this.rZR.clear();
            this.rZR.addAll(list);
            AppMethodBeat.o(139107);
        }

        public final int getItemCount() {
            AppMethodBeat.i(139109);
            int size = this.rZR.size();
            AppMethodBeat.o(139109);
            return size;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView$1 */
    static final class AnonymousClass1 extends k implements m<Integer, View, y> {
        final /* synthetic */ GalleryRecyclerView snY;

        AnonymousClass1(GalleryRecyclerView galleryRecyclerView) {
            this.snY = galleryRecyclerView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            RecyclerView recyclerView;
            RecyclerView.i layoutManager;
            AppMethodBeat.i(110726);
            int intValue = ((Number) obj).intValue();
            View view = (View) obj2;
            j.p(view, "child");
            GalleryRecyclerView galleryRecyclerView = this.snY;
            j.p(view, "child");
            int i = galleryRecyclerView.rZb;
            galleryRecyclerView.rZb = intValue;
            RecyclerView recyclerView2 = galleryRecyclerView.snU;
            s sVar = (s) galleryRecyclerView.aZ(view);
            if (sVar != null) {
                recyclerView = sVar.iJP;
            } else {
                recyclerView = null;
            }
            galleryRecyclerView.snU = recyclerView;
            q qVar = galleryRecyclerView.snV;
            if (qVar != null) {
                Object obj3;
                Integer valueOf = Integer.valueOf(intValue);
                RecyclerView recyclerView3 = galleryRecyclerView.snU;
                if (sVar != null) {
                    obj3 = sVar.srC;
                } else {
                    obj3 = null;
                }
                qVar.g(valueOf, recyclerView3, obj3);
            }
            if (recyclerView2 != null) {
                layoutManager = recyclerView2.getLayoutManager();
            } else {
                layoutManager = null;
            }
            com.tencent.mm.plugin.story.ui.b.b bVar = (com.tencent.mm.plugin.story.ui.b.b) layoutManager;
            if (galleryRecyclerView.getAdapter() instanceof b) {
                android.support.v7.widget.RecyclerView.a adapter = galleryRecyclerView.getAdapter();
                if (adapter == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView.VerticalAdapter");
                    AppMethodBeat.o(110726);
                    throw vVar;
                }
                int i2;
                b bVar2 = (b) adapter;
                if (bVar != null) {
                    i2 = bVar.llU;
                } else {
                    i2 = 0;
                }
                bVar2.tBs = i;
                bVar2.tBt = i2;
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110726);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "offset", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView$2 */
    static final class AnonymousClass2 extends k implements m<Integer, Float, y> {
        final /* synthetic */ GalleryRecyclerView snY;

        AnonymousClass2(GalleryRecyclerView galleryRecyclerView) {
            this.snY = galleryRecyclerView;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(110727);
            int intValue = ((Number) obj).intValue();
            float floatValue = ((Number) obj2).floatValue();
            m onScrollCallback = this.snY.getOnScrollCallback();
            if (onScrollCallback != null) {
                onScrollCallback.m(Integer.valueOf(intValue), Float.valueOf(floatValue));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110727);
            return yVar;
        }
    }

    public GalleryRecyclerView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110729);
        this.snT = new com.tencent.mm.plugin.story.ui.b.b(context);
        setLayoutManager(this.snT);
        this.snT.lqs = new AnonymousClass1(this);
        this.snT.shb = new AnonymousClass2(this);
        b((h) new b(1));
        setItemAnimator(null);
        setItemViewCacheSize(0);
        AppMethodBeat.o(110729);
    }

    public GalleryRecyclerView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110730);
        AppMethodBeat.o(110730);
    }

    static {
        AppMethodBeat.i(110731);
        AppMethodBeat.o(110731);
    }

    public final com.tencent.mm.plugin.story.ui.b.b getLayoutManager() {
        return this.snT;
    }

    public final q<Integer, RecyclerView, GalleryHorizontalControlView, y> getOnRowSelected() {
        return this.snV;
    }

    public final void setOnRowSelected(q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, y> qVar) {
        this.snV = qVar;
    }

    public final m<Integer, Float, y> getOnScrollCallback() {
        return this.snW;
    }

    public final void setOnScrollCallback(m<? super Integer, ? super Float, y> mVar) {
        this.snW = mVar;
    }

    public final void setActive(boolean z) {
        android.support.v7.widget.RecyclerView.a adapter;
        AppMethodBeat.i(139113);
        this.csi = z;
        RecyclerView recyclerView = this.snU;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof com.tencent.mm.plugin.story.ui.a.g) {
            recyclerView = this.snU;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryGalleryAdapter");
                AppMethodBeat.o(139113);
                throw vVar;
            }
            ((com.tencent.mm.plugin.story.ui.a.g) adapter).csi = z;
        }
        AppMethodBeat.o(139113);
    }

    public final void setScrollEnable(boolean z) {
        AppMethodBeat.i(110728);
        this.snT.shc = z;
        RecyclerView recyclerView = this.snU;
        RecyclerView.i layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager instanceof com.tencent.mm.plugin.story.ui.b.b) {
            ((com.tencent.mm.plugin.story.ui.b.b) layoutManager).shc = z;
        }
        AppMethodBeat.o(110728);
    }
}
