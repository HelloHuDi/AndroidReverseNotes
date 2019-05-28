package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class g {
    private static final String TAG = TAG;
    public static final a soq = new a();
    boolean soj;
    private final c sok = new c(this);
    private final Runnable sol;
    private View som;
    private final l son;
    private final GalleryRecyclerView soo;
    private final j sop;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.g$2 */
    static final class AnonymousClass2 implements Runnable {
        final /* synthetic */ g sos;

        AnonymousClass2(g gVar) {
            this.sos = gVar;
        }

        public final void run() {
            AppMethodBeat.i(110739);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.sos.son.getContext(), 112);
            View inflate = LayoutInflater.from(this.sos.son.getContext()).inflate(R.layout.az1, this.sos.son, false);
            this.sos.som = inflate;
            View findViewById = inflate.findViewById(R.id.euq);
            j.o(findViewById, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
            ((ImageView) findViewById).setImageDrawable(ah.f(this.sos.son.getContext(), R.raw.close_icon_nor, -1));
            LayoutParams layoutParams = new LayoutParams(-1, fromDPToPix);
            layoutParams.addRule(12, 1);
            this.sos.son.addView(inflate, layoutParams);
            j.o(inflate, "layout");
            inflate.setAlpha(0.0f);
            inflate.animate().alpha(1.0f).start();
            this.sos.soo.ce(fromDPToPix);
            this.sos.soj = true;
            AppMethodBeat.o(110739);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
    public static final class c extends m {
        final /* synthetic */ g sos;

        c(g gVar) {
            this.sos = gVar;
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.i(110741);
            j.p(recyclerView, "recyclerView");
            if (!this.sos.soj && i2 > 0) {
                ab.i(g.TAG, "onScrolled ".concat(String.valueOf(i2)));
                e RP = com.tencent.mm.kernel.g.RP();
                j.o(RP, "storage()");
                RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
                this.sos.cCG();
            }
            AppMethodBeat.o(110741);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends k implements a.f.a.a<y> {
        final /* synthetic */ g sos;

        b(g gVar) {
            this.sos = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(110740);
            this.sos.sop.i(this.sos.soo);
            al.af(this.sos.sol);
            this.sos.son.removeView(this.sos.som);
            this.sos.soo.b((m) this.sos.sok);
            y yVar = y.AUy;
            AppMethodBeat.o(110740);
            return yVar;
        }
    }

    public g(l lVar, GalleryRecyclerView galleryRecyclerView, j jVar) {
        j.p(lVar, "gallery");
        j.p(galleryRecyclerView, "recyclerView");
        j.p(jVar, "pageScrollHelper");
        AppMethodBeat.i(110744);
        this.son = lVar;
        this.soo = galleryRecyclerView;
        this.sop = jVar;
        e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "storage()");
        if (RP.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, false)) {
            this.sol = AnonymousClass1.sor;
            this.sop.i(this.soo);
            AppMethodBeat.o(110744);
            return;
        }
        this.sol = new AnonymousClass2(this);
        al.n(this.sol, 5000);
        this.soo.a((m) this.sok);
        AppMethodBeat.o(110744);
    }

    static {
        AppMethodBeat.i(110745);
        AppMethodBeat.o(110745);
    }

    public final void cCG() {
        AppMethodBeat.i(110742);
        com.tencent.mm.ab.b.a(new b(this));
        AppMethodBeat.o(110742);
    }

    public final void destroy() {
        AppMethodBeat.i(110743);
        al.af(this.sol);
        this.son.removeView(this.som);
        this.soo.b((m) this.sok);
        AppMethodBeat.o(110743);
    }
}
