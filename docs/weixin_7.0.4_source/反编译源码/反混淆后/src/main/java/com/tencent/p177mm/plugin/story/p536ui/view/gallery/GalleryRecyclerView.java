package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C17482n;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C29324g;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C46923i;
import com.tencent.p177mm.plugin.story.p536ui.p1305b.C22262b;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u000223B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017Re\u0010\u0018\u001aM\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RL\u0010$\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001f\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "childControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "childRecyclerView", "value", "", "isActive", "()Z", "setActive", "(Z)V", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "onRowSelected", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "row", "rowView", "pageControl", "", "getOnRowSelected", "()Lkotlin/jvm/functions/Function3;", "setOnRowSelected", "(Lkotlin/jvm/functions/Function3;)V", "onScrollCallback", "Lkotlin/Function2;", "position", "", "offset", "getOnScrollCallback", "()Lkotlin/jvm/functions/Function2;", "setOnScrollCallback", "(Lkotlin/jvm/functions/Function2;)V", "selectedRow", "child", "Landroid/view/View;", "setScrollEnable", "enabled", "Companion", "VerticalAdapter", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView */
public final class GalleryRecyclerView extends RecyclerView {
    private static final String TAG = TAG;
    public static final C13880a snX = new C13880a();
    boolean csi;
    int rZb;
    private final C22262b snT;
    RecyclerView snU;
    C36933q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, C37091y> snV;
    private C31591m<? super Integer, ? super Float, C37091y> snW;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J$\u0010\u001f\u001a\u00020\n2\u001c\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120!J\u0016\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR>\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120\u0010j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012`\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;)V", "bindCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getBindCallback", "()Lkotlin/jvm/functions/Function1;", "setBindCallback", "(Lkotlin/jvm/functions/Function1;)V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "prePosition", "preRow", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "updateChildRecyclerPosition", "row", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView$b */
    public final class C13879b extends C41523a<C46926s> {
        private final ArrayList<ArrayList<C43640g>> rZR = new ArrayList();
        C17126b<? super Integer, C37091y> tBr;
        int tBs = -1;
        int tBt;
        private final C17482n tBu = new C17482n();

        public C13879b() {
            AppMethodBeat.m2504i(139112);
            this.tBu.mo31883aF(0, 2);
            AppMethodBeat.m2505o(139112);
        }

        /* renamed from: k */
        public final /* synthetic */ void mo26080k(C41531v c41531v) {
            AppMethodBeat.m2504i(139111);
            C46926s c46926s = (C46926s) c41531v;
            C25052j.m39376p(c46926s, "holder");
            super.mo26080k(c46926s);
            if (c46926s.iJP.getChildCount() > 0) {
                C41531v aZ = c46926s.iJP.mo66337aZ(c46926s.iJP.getChildAt(0));
                if (aZ instanceof C46923i) {
                    ((C46923i) aZ).cCi();
                }
            }
            AppMethodBeat.m2505o(139111);
        }

        /* renamed from: dI */
        public final void mo26079dI(List<? extends ArrayList<C43640g>> list) {
            AppMethodBeat.m2504i(139107);
            C25052j.m39376p(list, "items");
            this.rZR.clear();
            this.rZR.addAll(list);
            AppMethodBeat.m2505o(139107);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(139109);
            int size = this.rZR.size();
            AppMethodBeat.m2505o(139109);
            return size;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView$a */
    public static final class C13880a {
        private C13880a() {
        }

        public /* synthetic */ C13880a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView$1 */
    static final class C138811 extends C25053k implements C31591m<Integer, View, C37091y> {
        final /* synthetic */ GalleryRecyclerView snY;

        C138811(GalleryRecyclerView galleryRecyclerView) {
            this.snY = galleryRecyclerView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            RecyclerView recyclerView;
            C17480i layoutManager;
            AppMethodBeat.m2504i(110726);
            int intValue = ((Number) obj).intValue();
            View view = (View) obj2;
            C25052j.m39376p(view, "child");
            GalleryRecyclerView galleryRecyclerView = this.snY;
            C25052j.m39376p(view, "child");
            int i = galleryRecyclerView.rZb;
            galleryRecyclerView.rZb = intValue;
            RecyclerView recyclerView2 = galleryRecyclerView.snU;
            C46926s c46926s = (C46926s) galleryRecyclerView.mo66337aZ(view);
            if (c46926s != null) {
                recyclerView = c46926s.iJP;
            } else {
                recyclerView = null;
            }
            galleryRecyclerView.snU = recyclerView;
            C36933q c36933q = galleryRecyclerView.snV;
            if (c36933q != null) {
                Object obj3;
                Integer valueOf = Integer.valueOf(intValue);
                RecyclerView recyclerView3 = galleryRecyclerView.snU;
                if (c46926s != null) {
                    obj3 = c46926s.srC;
                } else {
                    obj3 = null;
                }
                c36933q.mo9028g(valueOf, recyclerView3, obj3);
            }
            if (recyclerView2 != null) {
                layoutManager = recyclerView2.getLayoutManager();
            } else {
                layoutManager = null;
            }
            C22262b c22262b = (C22262b) layoutManager;
            if (galleryRecyclerView.getAdapter() instanceof C13879b) {
                C41523a adapter = galleryRecyclerView.getAdapter();
                if (adapter == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView.VerticalAdapter");
                    AppMethodBeat.m2505o(110726);
                    throw c44941v;
                }
                int i2;
                C13879b c13879b = (C13879b) adapter;
                if (c22262b != null) {
                    i2 = c22262b.llU;
                } else {
                    i2 = 0;
                }
                c13879b.tBs = i;
                c13879b.tBt = i2;
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110726);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "offset", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView$2 */
    static final class C138822 extends C25053k implements C31591m<Integer, Float, C37091y> {
        final /* synthetic */ GalleryRecyclerView snY;

        C138822(GalleryRecyclerView galleryRecyclerView) {
            this.snY = galleryRecyclerView;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(110727);
            int intValue = ((Number) obj).intValue();
            float floatValue = ((Number) obj2).floatValue();
            C31591m onScrollCallback = this.snY.getOnScrollCallback();
            if (onScrollCallback != null) {
                onScrollCallback.mo212m(Integer.valueOf(intValue), Float.valueOf(floatValue));
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110727);
            return c37091y;
        }
    }

    public GalleryRecyclerView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110729);
        this.snT = new C22262b(context);
        setLayoutManager(this.snT);
        this.snT.lqs = new C138811(this);
        this.snT.shb = new C138822(this);
        mo66346b((C25373h) new C35247b(1));
        setItemAnimator(null);
        setItemViewCacheSize(0);
        AppMethodBeat.m2505o(110729);
    }

    public GalleryRecyclerView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110730);
        AppMethodBeat.m2505o(110730);
    }

    static {
        AppMethodBeat.m2504i(110731);
        AppMethodBeat.m2505o(110731);
    }

    public final C22262b getLayoutManager() {
        return this.snT;
    }

    public final C36933q<Integer, RecyclerView, GalleryHorizontalControlView, C37091y> getOnRowSelected() {
        return this.snV;
    }

    public final void setOnRowSelected(C36933q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, C37091y> c36933q) {
        this.snV = c36933q;
    }

    public final C31591m<Integer, Float, C37091y> getOnScrollCallback() {
        return this.snW;
    }

    public final void setOnScrollCallback(C31591m<? super Integer, ? super Float, C37091y> c31591m) {
        this.snW = c31591m;
    }

    public final void setActive(boolean z) {
        C41523a adapter;
        AppMethodBeat.m2504i(139113);
        this.csi = z;
        RecyclerView recyclerView = this.snU;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof C29324g) {
            recyclerView = this.snU;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryGalleryAdapter");
                AppMethodBeat.m2505o(139113);
                throw c44941v;
            }
            ((C29324g) adapter).csi = z;
        }
        AppMethodBeat.m2505o(139113);
    }

    public final void setScrollEnable(boolean z) {
        AppMethodBeat.m2504i(110728);
        this.snT.shc = z;
        RecyclerView recyclerView = this.snU;
        C17480i layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager instanceof C22262b) {
            ((C22262b) layoutManager).shc = z;
        }
        AppMethodBeat.m2505o(110728);
    }
}
