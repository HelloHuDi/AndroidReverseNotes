package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.g */
public final class C4175g {
    private static final String TAG = TAG;
    public static final C4179a soq = new C4179a();
    boolean soj;
    private final C4178c sok = new C4178c(this);
    private final Runnable sol;
    private View som;
    private final C35251l son;
    private final GalleryRecyclerView soo;
    private final C4185j sop;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.g$2 */
    static final class C41762 implements Runnable {
        final /* synthetic */ C4175g sos;

        C41762(C4175g c4175g) {
            this.sos = c4175g;
        }

        public final void run() {
            AppMethodBeat.m2504i(110739);
            int fromDPToPix = C1338a.fromDPToPix(this.sos.son.getContext(), 112);
            View inflate = LayoutInflater.from(this.sos.son.getContext()).inflate(2130970901, this.sos.son, false);
            this.sos.som = inflate;
            View findViewById = inflate.findViewById(2131828192);
            C25052j.m39375o(findViewById, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
            ((ImageView) findViewById).setImageDrawable(C5225ah.m7962f(this.sos.son.getContext(), C1318a.close_icon_nor, -1));
            LayoutParams layoutParams = new LayoutParams(-1, fromDPToPix);
            layoutParams.addRule(12, 1);
            this.sos.son.addView(inflate, layoutParams);
            C25052j.m39375o(inflate, "layout");
            inflate.setAlpha(0.0f);
            inflate.animate().alpha(1.0f).start();
            this.sos.soo.mo66356ce(fromDPToPix);
            this.sos.soj = true;
            AppMethodBeat.m2505o(110739);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.g$1 */
    static final class C41771 implements Runnable {
        public static final C41771 sor = new C41771();

        static {
            AppMethodBeat.m2504i(110738);
            AppMethodBeat.m2505o(110738);
        }

        C41771() {
        }

        public final void run() {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.g$c */
    public static final class C4178c extends C41530m {
        final /* synthetic */ C4175g sos;

        C4178c(C4175g c4175g) {
            this.sos = c4175g;
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(110741);
            C25052j.m39376p(recyclerView, "recyclerView");
            if (!this.sos.soj && i2 > 0) {
                C4990ab.m7416i(C4175g.TAG, "onScrolled ".concat(String.valueOf(i2)));
                C1706e RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "storage()");
                RP.mo5239Ry().set(C5127a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
                this.sos.cCG();
            }
            AppMethodBeat.m2505o(110741);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.g$a */
    public static final class C4179a {
        private C4179a() {
        }

        public /* synthetic */ C4179a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.g$b */
    static final class C4180b extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C4175g sos;

        C4180b(C4175g c4175g) {
            this.sos = c4175g;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(110740);
            this.sos.sop.mo42393i(this.sos.soo);
            C5004al.m7439af(this.sos.sol);
            this.sos.son.removeView(this.sos.som);
            this.sos.soo.mo66348b((C41530m) this.sos.sok);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110740);
            return c37091y;
        }
    }

    public C4175g(C35251l c35251l, GalleryRecyclerView galleryRecyclerView, C4185j c4185j) {
        C25052j.m39376p(c35251l, "gallery");
        C25052j.m39376p(galleryRecyclerView, "recyclerView");
        C25052j.m39376p(c4185j, "pageScrollHelper");
        AppMethodBeat.m2504i(110744);
        this.son = c35251l;
        this.soo = galleryRecyclerView;
        this.sop = c4185j;
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        if (RP.mo5239Ry().getBoolean(C5127a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, false)) {
            this.sol = C41771.sor;
            this.sop.mo42393i(this.soo);
            AppMethodBeat.m2505o(110744);
            return;
        }
        this.sol = new C41762(this);
        C5004al.m7442n(this.sol, 5000);
        this.soo.mo66332a((C41530m) this.sok);
        AppMethodBeat.m2505o(110744);
    }

    static {
        AppMethodBeat.m2504i(110745);
        AppMethodBeat.m2505o(110745);
    }

    public final void cCG() {
        AppMethodBeat.m2504i(110742);
        C8902b.m16042a(new C4180b(this));
        AppMethodBeat.m2505o(110742);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(110743);
        C5004al.m7439af(this.sol);
        this.son.removeView(this.som);
        this.soo.mo66348b((C41530m) this.sok);
        AppMethodBeat.m2505o(110743);
    }
}
