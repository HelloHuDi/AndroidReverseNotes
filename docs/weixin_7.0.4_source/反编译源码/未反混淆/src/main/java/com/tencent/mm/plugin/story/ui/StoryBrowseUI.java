package com.tencent.mm.plugin.story.ui;

import a.l;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
public final class StoryBrowseUI extends MMActivity implements g {
    private static final String TAG = TAG;
    public static final a sev = new a();
    private ImageView mmX;
    private int ses;
    private int set;
    private com.tencent.mm.plugin.story.ui.view.gallery.l seu;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    public static final class b implements com.tencent.mm.plugin.story.ui.view.gallery.l.b {
        final /* synthetic */ StoryBrowseUI sew;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b sex;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.story.ui.StoryBrowseUI$b$a$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ a sey;

                AnonymousClass1(a aVar) {
                    this.sey = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(109987);
                    StoryBrowseUI.c(this.sey.sex.sew);
                    this.sey.sex.sew.overridePendingTransition(0, 0);
                    AppMethodBeat.o(109987);
                }
            }

            a(b bVar) {
                this.sex = bVar;
            }

            public final void run() {
                AppMethodBeat.i(109988);
                new ak().post(new AnonymousClass1(this));
                AppMethodBeat.o(109988);
            }
        }

        b(StoryBrowseUI storyBrowseUI) {
            this.sew = storyBrowseUI;
        }

        public final void bc(float f) {
            AppMethodBeat.i(109989);
            ImageView a = this.sew.mmX;
            if (a != null) {
                a.setAlpha(f);
                AppMethodBeat.o(109989);
                return;
            }
            AppMethodBeat.o(109989);
        }

        public final void cCg() {
            long j = 0;
            AppMethodBeat.i(109990);
            com.tencent.mm.plugin.story.ui.view.gallery.l b = this.sew.seu;
            if (b != null) {
                b.setEnabled(false);
                long height = (long) (((((float) b.getHeight()) - b.getTranslationY()) / ((float) b.getHeight())) * 300.0f);
                if (height >= 0) {
                    j = height;
                }
                ImageView a = this.sew.mmX;
                if (a != null) {
                    ViewPropertyAnimator animate = a.animate();
                    if (animate != null) {
                        animate = animate.alpha(0.0f);
                        if (animate != null) {
                            animate = animate.setDuration(j);
                            if (animate != null) {
                                animate.start();
                            }
                        }
                    }
                }
                b.animate().translationY((float) b.getHeight()).setDuration(j).withEndAction(new a(this)).start();
                AppMethodBeat.o(109990);
                return;
            }
            AppMethodBeat.o(109990);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ String hBP;
        final /* synthetic */ a.f.b.u.c seA;
        final /* synthetic */ StoryBrowseUI sew;
        final /* synthetic */ a.f.b.u.c sez;

        c(StoryBrowseUI storyBrowseUI, a.f.b.u.c cVar, String str, a.f.b.u.c cVar2) {
            this.sew = storyBrowseUI;
            this.sez = cVar;
            this.hBP = str;
            this.seA = cVar2;
        }

        /* JADX WARNING: Missing block: B:14:0x00b6, code skipped:
            if (com.tencent.mm.plugin.story.g.h.cAs().FF() == 13) goto L_0x00b8;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            e eVar;
            List U;
            h hVar;
            AppMethodBeat.i(109991);
            com.tencent.mm.plugin.story.ui.view.gallery.l b = this.sew.seu;
            if (b != null) {
                b.getVideoViewMgrFromPreLoad();
                b.K(false, true);
                b.setVideoViewMgrFromPreLoad(false);
                b.setCurrentHItem(this.sew.set);
            }
            h hVar2 = h.scu;
            if (h.cAs().FF() != 4) {
                hVar2 = h.scu;
                if (h.cAs().FF() != 6) {
                    hVar2 = h.scu;
                    if (h.cAs().FF() == 5) {
                        eVar = (e) com.tencent.mm.kernel.g.M(e.class);
                        U = a.a.l.U(this.hBP);
                        hVar = h.scu;
                        eVar.reportWaitPlayList(U, h.cAs().FF());
                        AppMethodBeat.o(109991);
                        return;
                    }
                    hVar2 = h.scu;
                    if (h.cAs().FF() != 12) {
                        hVar2 = h.scu;
                    }
                    if (this.seA.AVE != null && (this.seA.AVE instanceof com.tencent.mm.plugin.story.model.d.a)) {
                        eVar = (e) com.tencent.mm.kernel.g.M(e.class);
                        U = ((com.tencent.mm.plugin.story.model.d.a) this.seA.AVE).fxt;
                        hVar = h.scu;
                        eVar.reportWaitPlayList(U, h.cAs().FF());
                    }
                    AppMethodBeat.o(109991);
                    return;
                }
            }
            eVar = (e) com.tencent.mm.kernel.g.M(e.class);
            U = (ArrayList) this.sez.AVE;
            hVar = h.scu;
            eVar.reportWaitPlayList(U, h.cAs().FF());
            AppMethodBeat.o(109991);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void c(StoryBrowseUI storyBrowseUI) {
        AppMethodBeat.i(110001);
        storyBrowseUI.cCf();
        AppMethodBeat.o(110001);
    }

    static {
        AppMethodBeat.i(110000);
        AppMethodBeat.o(110000);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(109992);
        ab.i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
        supportRequestWindowFeature(1);
        dxS();
        super.onCreate(bundle);
        com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
        com.tencent.mm.plugin.story.g.c.czS();
        com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
        com.tencent.mm.plugin.story.g.b.czS();
        Ne(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        d.iV(true);
        RelativeLayout relativeLayout = new RelativeLayout(dxU());
        relativeLayout.setBackgroundColor(0);
        ImageView imageView = new ImageView(dxU());
        imageView.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.mmX = imageView;
        this.set = getIntent().getIntExtra("h_position", 0);
        this.ses = getIntent().getIntExtra("v_position", 0);
        String stringExtra = getIntent().getStringExtra("username");
        a.f.b.u.c cVar2 = new a.f.b.u.c();
        cVar2.AVE = getIntent().getStringArrayListExtra("user_list");
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("user_date_list");
        boolean booleanExtra = getIntent().getBooleanExtra("delete_when_first_empty", false);
        String stringExtra2 = getIntent().getStringExtra("gallery_chat_room");
        long longExtra = getIntent().getLongExtra("data_seed_key", 0);
        h hVar = h.scu;
        String sessionId = h.cAs().getSessionId();
        boolean booleanExtra2 = getIntent().getBooleanExtra("gallery_is_for_sns", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("gallery_story_need_action", false);
        ab.i(TAG, "vPosition " + this.ses);
        hVar = h.scu;
        h.cAv();
        hVar = h.scu;
        h.cAs().bF((long) at.gC(dxU()));
        hVar = h.scu;
        h.cAs().bK(0);
        hVar = h.scu;
        h.cAs().bM(0);
        a.f.b.u.c cVar3 = new a.f.b.u.c();
        cVar3.AVE = com.tencent.mm.plugin.story.api.o.a.cxg().kW(longExtra);
        if (cVar3.AVE == null || !(cVar3.AVE instanceof o)) {
            com.tencent.mm.plugin.story.model.j.a aVar;
            if (!bo.isNullOrNil(stringExtra)) {
                aVar = j.rST;
                if (bo.isEqual(stringExtra, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                    if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                        this.seu = new com.tencent.mm.plugin.story.ui.view.gallery.l(this, com.tencent.mm.plugin.story.api.m.a.SelfGallery);
                        cVar3.AVE = stringExtra;
                    } else {
                        this.seu = new com.tencent.mm.plugin.story.ui.view.gallery.l(this, com.tencent.mm.plugin.story.api.m.a.HistoryGallery);
                        cVar3.AVE = stringArrayListExtra;
                    }
                }
            }
            if (!bo.isNullOrNil(stringExtra)) {
                aVar = j.rST;
                if (!bo.isEqual(stringExtra, com.tencent.mm.plugin.story.model.j.a.cnk())) {
                    this.seu = new com.tencent.mm.plugin.story.ui.view.gallery.l(this, com.tencent.mm.plugin.story.api.m.a.SingleGallery);
                    cVar3.AVE = stringExtra;
                }
            }
            if (((ArrayList) cVar2.AVE) != null) {
                this.seu = new com.tencent.mm.plugin.story.ui.view.gallery.l(this, com.tencent.mm.plugin.story.api.m.a.MultiUserGallery);
                cVar3.AVE = new ArrayList((ArrayList) cVar2.AVE);
            }
        } else {
            com.tencent.mm.plugin.story.api.m.a aVar2;
            o oVar = (o) cVar3.AVE;
            a.f.b.j.p(oVar, "dataSeed");
            if ((oVar instanceof com.tencent.mm.plugin.story.model.d.b) || (oVar instanceof com.tencent.mm.plugin.story.model.d.a) || !(oVar instanceof com.tencent.mm.plugin.story.model.d.c)) {
                aVar2 = com.tencent.mm.plugin.story.api.m.a.MultiUserGallery;
            } else {
                com.tencent.mm.plugin.story.model.j.a aVar3 = j.rST;
                if (bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), ((com.tencent.mm.plugin.story.model.d.c) oVar).username)) {
                    aVar2 = com.tencent.mm.plugin.story.api.m.a.FavSelfStoryGallery;
                } else {
                    aVar2 = com.tencent.mm.plugin.story.api.m.a.FavOtherStoryGallery;
                }
            }
            this.seu = new com.tencent.mm.plugin.story.ui.view.gallery.l(this, aVar2, this.ses, booleanExtra3);
        }
        com.tencent.mm.plugin.story.ui.view.gallery.l lVar = this.seu;
        if (lVar != null) {
            lVar.setDeleteWhenFirstEmpty(booleanExtra);
        }
        lVar = this.seu;
        if (lVar != null) {
            lVar.setChatRoom(stringExtra2);
        }
        lVar = this.seu;
        if (lVar != null) {
            lVar.setSessionId(sessionId);
        }
        lVar = this.seu;
        if (lVar != null) {
            lVar.setForSns(booleanExtra2);
        }
        lVar = this.seu;
        if (lVar != null) {
            lVar.setDataSeed(cVar3.AVE);
        }
        com.tencent.mm.plugin.story.ui.view.gallery.l lVar2 = this.seu;
        if (lVar2 != null) {
            lVar2.setStoryBrowseUIListener(this);
        }
        lVar = this.seu;
        if (lVar != null) {
            lVar.setCurrentVItem(this.ses);
        }
        lVar = this.seu;
        if (lVar != null) {
            lVar.setCanDragScale(true);
        }
        lVar2 = this.seu;
        if (lVar2 != null) {
            lVar2.setGalleryScaleListener(new b(this));
        }
        relativeLayout.addView(this.mmX, new LayoutParams(-1, -1));
        relativeLayout.addView(this.seu, new LayoutParams(-1, -1));
        setContentView((View) relativeLayout);
        lVar2 = this.seu;
        if (lVar2 != null) {
            lVar2.post(new c(this, cVar2, stringExtra, cVar3));
            AppMethodBeat.o(109992);
            return;
        }
        AppMethodBeat.o(109992);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.i(109993);
        ab.i(TAG, "onResume ".concat(String.valueOf(this)));
        super.onResume();
        com.tencent.mm.plugin.story.ui.view.gallery.l lVar = this.seu;
        if (lVar != null) {
            lVar.onResume();
        }
        lVar = this.seu;
        if (lVar != null) {
            lVar.cwK();
            AppMethodBeat.o(109993);
            return;
        }
        AppMethodBeat.o(109993);
    }

    public final void onPause() {
        AppMethodBeat.i(109994);
        ab.i(TAG, "onPause ".concat(String.valueOf(this)));
        super.onPause();
        com.tencent.mm.plugin.story.ui.view.gallery.l lVar = this.seu;
        if (lVar != null) {
            lVar.onPause();
            AppMethodBeat.o(109994);
            return;
        }
        AppMethodBeat.o(109994);
    }

    public final void onDestroy() {
        AppMethodBeat.i(109995);
        ab.i(TAG, "onDestroy ".concat(String.valueOf(this)));
        super.onDestroy();
        com.tencent.mm.plugin.story.ui.view.gallery.l lVar = this.seu;
        if (lVar != null) {
            lVar.onDestroy();
        }
        com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
        com.tencent.mm.plugin.story.g.c.onDestroy();
        AppMethodBeat.o(109995);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(109996);
        com.tencent.mm.plugin.story.ui.view.gallery.l lVar = this.seu;
        if (lVar == null || !lVar.wY()) {
            cCf();
        }
        AppMethodBeat.o(109996);
    }

    public final void caA() {
        AppMethodBeat.i(109997);
        cCf();
        AppMethodBeat.o(109997);
    }

    public final void caB() {
    }

    public final void caC() {
        AppMethodBeat.i(109998);
        cCf();
        AppMethodBeat.o(109998);
    }

    private final void cCf() {
        AppMethodBeat.i(109999);
        h hVar = h.scu;
        h.cAs().bF((long) at.gC(dxU()));
        hVar = h.scu;
        h.cAs().bJ(System.currentTimeMillis());
        hVar = h.scu;
        h.cAt();
        com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
        com.tencent.mm.plugin.story.g.c.onDestroy();
        setResult(-1);
        finish();
        AppMethodBeat.o(109999);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
