package com.tencent.p177mm.plugin.story.p536ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C35171g;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.api.C39864o.C35172a;
import com.tencent.p177mm.plugin.story.api.C46269m.C29273a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p533d.C22232a;
import com.tencent.p177mm.plugin.story.model.p533d.C22233c;
import com.tencent.p177mm.plugin.story.model.p533d.C29305b;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C35180c;
import com.tencent.p177mm.plugin.story.p531g.C4116b;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C35251l;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C35251l.C13884b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41381u.C31596c;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "()V", "galleryBg", "Landroid/widget/ImageView;", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "hPosition", "", "vPosition", "finishWithResult", "", "result", "getForceOrientation", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "storyUIBackPressed", "storyUIHasStory", "storyUINoStory", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.StoryBrowseUI */
public final class StoryBrowseUI extends MMActivity implements C35171g {
    private static final String TAG = TAG;
    public static final C13800a sev = new C13800a();
    private ImageView mmX;
    private int ses;
    private int set;
    private C35251l seu;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryBrowseUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryBrowseUI$a */
    public static final class C13800a {
        private C13800a() {
        }

        public /* synthetic */ C13800a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryBrowseUI$b */
    public static final class C16871b implements C13884b {
        final /* synthetic */ StoryBrowseUI sew;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StoryBrowseUI$b$a */
        static final class C16872a implements Runnable {
            final /* synthetic */ C16871b sex;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.story.ui.StoryBrowseUI$b$a$1 */
            static final class C168731 implements Runnable {
                final /* synthetic */ C16872a sey;

                C168731(C16872a c16872a) {
                    this.sey = c16872a;
                }

                public final void run() {
                    AppMethodBeat.m2504i(109987);
                    StoryBrowseUI.m46542c(this.sey.sex.sew);
                    this.sey.sex.sew.overridePendingTransition(0, 0);
                    AppMethodBeat.m2505o(109987);
                }
            }

            C16872a(C16871b c16871b) {
                this.sex = c16871b;
            }

            public final void run() {
                AppMethodBeat.m2504i(109988);
                new C7306ak().post(new C168731(this));
                AppMethodBeat.m2505o(109988);
            }
        }

        C16871b(StoryBrowseUI storyBrowseUI) {
            this.sew = storyBrowseUI;
        }

        /* renamed from: bc */
        public final void mo26102bc(float f) {
            AppMethodBeat.m2504i(109989);
            ImageView a = this.sew.mmX;
            if (a != null) {
                a.setAlpha(f);
                AppMethodBeat.m2505o(109989);
                return;
            }
            AppMethodBeat.m2505o(109989);
        }

        public final void cCg() {
            long j = 0;
            AppMethodBeat.m2504i(109990);
            C35251l b = this.sew.seu;
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
                b.animate().translationY((float) b.getHeight()).setDuration(j).withEndAction(new C16872a(this)).start();
                AppMethodBeat.m2505o(109990);
                return;
            }
            AppMethodBeat.m2505o(109990);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryBrowseUI$c */
    static final class C29313c implements Runnable {
        final /* synthetic */ String hBP;
        final /* synthetic */ C31596c seA;
        final /* synthetic */ StoryBrowseUI sew;
        final /* synthetic */ C31596c sez;

        C29313c(StoryBrowseUI storyBrowseUI, C31596c c31596c, String str, C31596c c31596c2) {
            this.sew = storyBrowseUI;
            this.sez = c31596c;
            this.hBP = str;
            this.seA = c31596c2;
        }

        /* JADX WARNING: Missing block: B:14:0x00b6, code skipped:
            if (com.tencent.p177mm.plugin.story.p531g.C22212h.cAs().mo20732FF() == 13) goto L_0x00b8;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            C35168e c35168e;
            List U;
            C22212h c22212h;
            AppMethodBeat.m2504i(109991);
            C35251l b = this.sew.seu;
            if (b != null) {
                b.getVideoViewMgrFromPreLoad();
                b.mo55932K(false, true);
                b.setVideoViewMgrFromPreLoad(false);
                b.setCurrentHItem(this.sew.set);
            }
            C22212h c22212h2 = C22212h.scu;
            if (C22212h.cAs().mo20732FF() != 4) {
                c22212h2 = C22212h.scu;
                if (C22212h.cAs().mo20732FF() != 6) {
                    c22212h2 = C22212h.scu;
                    if (C22212h.cAs().mo20732FF() == 5) {
                        c35168e = (C35168e) C1720g.m3530M(C35168e.class);
                        U = C7987l.m14170U(this.hBP);
                        c22212h = C22212h.scu;
                        c35168e.reportWaitPlayList(U, C22212h.cAs().mo20732FF());
                        AppMethodBeat.m2505o(109991);
                        return;
                    }
                    c22212h2 = C22212h.scu;
                    if (C22212h.cAs().mo20732FF() != 12) {
                        c22212h2 = C22212h.scu;
                    }
                    if (this.seA.AVE != null && (this.seA.AVE instanceof C22232a)) {
                        c35168e = (C35168e) C1720g.m3530M(C35168e.class);
                        U = ((C22232a) this.seA.AVE).fxt;
                        c22212h = C22212h.scu;
                        c35168e.reportWaitPlayList(U, C22212h.cAs().mo20732FF());
                    }
                    AppMethodBeat.m2505o(109991);
                    return;
                }
            }
            c35168e = (C35168e) C1720g.m3530M(C35168e.class);
            U = (ArrayList) this.sez.AVE;
            c22212h = C22212h.scu;
            c35168e.reportWaitPlayList(U, C22212h.cAs().mo20732FF());
            AppMethodBeat.m2505o(109991);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m46542c(StoryBrowseUI storyBrowseUI) {
        AppMethodBeat.m2504i(110001);
        storyBrowseUI.cCf();
        AppMethodBeat.m2505o(110001);
    }

    static {
        AppMethodBeat.m2504i(110000);
        AppMethodBeat.m2505o(110000);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(109992);
        C4990ab.m7416i(TAG, "StoryBrowseUI create ".concat(String.valueOf(this)));
        supportRequestWindowFeature(1);
        dxS();
        super.onCreate(bundle);
        C35180c c35180c = C35180c.sbQ;
        C35180c.czS();
        C4116b c4116b = C4116b.sbw;
        C4116b.czS();
        mo17375Ne(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        C3475d.m5783iV(true);
        RelativeLayout relativeLayout = new RelativeLayout(dxU());
        relativeLayout.setBackgroundColor(0);
        ImageView imageView = new ImageView(dxU());
        imageView.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.mmX = imageView;
        this.set = getIntent().getIntExtra("h_position", 0);
        this.ses = getIntent().getIntExtra("v_position", 0);
        String stringExtra = getIntent().getStringExtra("username");
        C31596c c31596c = new C31596c();
        c31596c.AVE = getIntent().getStringArrayListExtra("user_list");
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("user_date_list");
        boolean booleanExtra = getIntent().getBooleanExtra("delete_when_first_empty", false);
        String stringExtra2 = getIntent().getStringExtra("gallery_chat_room");
        long longExtra = getIntent().getLongExtra("data_seed_key", 0);
        C22212h c22212h = C22212h.scu;
        String sessionId = C22212h.cAs().getSessionId();
        boolean booleanExtra2 = getIntent().getBooleanExtra("gallery_is_for_sns", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("gallery_story_need_action", false);
        C4990ab.m7416i(TAG, "vPosition " + this.ses);
        c22212h = C22212h.scu;
        C22212h.cAv();
        c22212h = C22212h.scu;
        C22212h.cAs().mo20742bF((long) C5023at.m7472gC(dxU()));
        c22212h = C22212h.scu;
        C22212h.cAs().mo20747bK(0);
        c22212h = C22212h.scu;
        C22212h.cAs().mo20749bM(0);
        C31596c c31596c2 = new C31596c();
        c31596c2.AVE = C35172a.cxg().mo55835kW(longExtra);
        if (c31596c2.AVE == null || !(c31596c2.AVE instanceof C39864o)) {
            C4133a c4133a;
            if (!C5046bo.isNullOrNil(stringExtra)) {
                c4133a = C43644j.rST;
                if (C5046bo.isEqual(stringExtra, C4133a.cnk())) {
                    if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                        this.seu = new C35251l(this, C29273a.SelfGallery);
                        c31596c2.AVE = stringExtra;
                    } else {
                        this.seu = new C35251l(this, C29273a.HistoryGallery);
                        c31596c2.AVE = stringArrayListExtra;
                    }
                }
            }
            if (!C5046bo.isNullOrNil(stringExtra)) {
                c4133a = C43644j.rST;
                if (!C5046bo.isEqual(stringExtra, C4133a.cnk())) {
                    this.seu = new C35251l(this, C29273a.SingleGallery);
                    c31596c2.AVE = stringExtra;
                }
            }
            if (((ArrayList) c31596c.AVE) != null) {
                this.seu = new C35251l(this, C29273a.MultiUserGallery);
                c31596c2.AVE = new ArrayList((ArrayList) c31596c.AVE);
            }
        } else {
            C29273a c29273a;
            C39864o c39864o = (C39864o) c31596c2.AVE;
            C25052j.m39376p(c39864o, "dataSeed");
            if ((c39864o instanceof C29305b) || (c39864o instanceof C22232a) || !(c39864o instanceof C22233c)) {
                c29273a = C29273a.MultiUserGallery;
            } else {
                C4133a c4133a2 = C43644j.rST;
                if (C5046bo.isEqual(C4133a.cnk(), ((C22233c) c39864o).username)) {
                    c29273a = C29273a.FavSelfStoryGallery;
                } else {
                    c29273a = C29273a.FavOtherStoryGallery;
                }
            }
            this.seu = new C35251l(this, c29273a, this.ses, booleanExtra3);
        }
        C35251l c35251l = this.seu;
        if (c35251l != null) {
            c35251l.setDeleteWhenFirstEmpty(booleanExtra);
        }
        c35251l = this.seu;
        if (c35251l != null) {
            c35251l.setChatRoom(stringExtra2);
        }
        c35251l = this.seu;
        if (c35251l != null) {
            c35251l.setSessionId(sessionId);
        }
        c35251l = this.seu;
        if (c35251l != null) {
            c35251l.setForSns(booleanExtra2);
        }
        c35251l = this.seu;
        if (c35251l != null) {
            c35251l.setDataSeed(c31596c2.AVE);
        }
        C35251l c35251l2 = this.seu;
        if (c35251l2 != null) {
            c35251l2.setStoryBrowseUIListener(this);
        }
        c35251l = this.seu;
        if (c35251l != null) {
            c35251l.setCurrentVItem(this.ses);
        }
        c35251l = this.seu;
        if (c35251l != null) {
            c35251l.setCanDragScale(true);
        }
        c35251l2 = this.seu;
        if (c35251l2 != null) {
            c35251l2.setGalleryScaleListener(new C16871b(this));
        }
        relativeLayout.addView(this.mmX, new LayoutParams(-1, -1));
        relativeLayout.addView(this.seu, new LayoutParams(-1, -1));
        setContentView((View) relativeLayout);
        c35251l2 = this.seu;
        if (c35251l2 != null) {
            c35251l2.post(new C29313c(this, c31596c, stringExtra, c31596c2));
            AppMethodBeat.m2505o(109992);
            return;
        }
        AppMethodBeat.m2505o(109992);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(109993);
        C4990ab.m7416i(TAG, "onResume ".concat(String.valueOf(this)));
        super.onResume();
        C35251l c35251l = this.seu;
        if (c35251l != null) {
            c35251l.onResume();
        }
        c35251l = this.seu;
        if (c35251l != null) {
            c35251l.cwK();
            AppMethodBeat.m2505o(109993);
            return;
        }
        AppMethodBeat.m2505o(109993);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(109994);
        C4990ab.m7416i(TAG, "onPause ".concat(String.valueOf(this)));
        super.onPause();
        C35251l c35251l = this.seu;
        if (c35251l != null) {
            c35251l.onPause();
            AppMethodBeat.m2505o(109994);
            return;
        }
        AppMethodBeat.m2505o(109994);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(109995);
        C4990ab.m7416i(TAG, "onDestroy ".concat(String.valueOf(this)));
        super.onDestroy();
        C35251l c35251l = this.seu;
        if (c35251l != null) {
            c35251l.onDestroy();
        }
        C35180c c35180c = C35180c.sbQ;
        C35180c.onDestroy();
        AppMethodBeat.m2505o(109995);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(109996);
        C35251l c35251l = this.seu;
        if (c35251l == null || !c35251l.mo55964wY()) {
            cCf();
        }
        AppMethodBeat.m2505o(109996);
    }

    public final void caA() {
        AppMethodBeat.m2504i(109997);
        cCf();
        AppMethodBeat.m2505o(109997);
    }

    public final void caB() {
    }

    public final void caC() {
        AppMethodBeat.m2504i(109998);
        cCf();
        AppMethodBeat.m2505o(109998);
    }

    private final void cCf() {
        AppMethodBeat.m2504i(109999);
        C22212h c22212h = C22212h.scu;
        C22212h.cAs().mo20742bF((long) C5023at.m7472gC(dxU()));
        c22212h = C22212h.scu;
        C22212h.cAs().mo20746bJ(System.currentTimeMillis());
        c22212h = C22212h.scu;
        C22212h.cAt();
        C35180c c35180c = C35180c.sbQ;
        C35180c.onDestroy();
        setResult(-1);
        finish();
        AppMethodBeat.m2505o(109999);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
