package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001eJ(\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "", "()V", "TAG", "", "animationEnd", "", "getAnimationEnd", "()Z", "setAnimationEnd", "(Z)V", "animationView", "Landroid/view/View;", "appMsgGetDone", "getAppMsgGetDone", "setAppMsgGetDone", "bg", "duration", "", "enable", "getEnable", "setEnable", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isAnimated", "mHeight", "mLeft", "mTop", "mWidth", "handleAnimation", "", "savedInstanceState", "Landroid/os/Bundle;", "callBack", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "hideAnimationView", "init", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "view", "showAnimationView", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f */
public final class C33743f {
    public final String TAG = "MicroMsg.MPVideoImageAnimationHelper";
    int duration = 300;
    public boolean enable = true;
    public boolean jYD;
    public C30759e jYE;
    public View jYF;
    public View jYG;
    public boolean jYH;
    public boolean jYI;
    public int mHeight;
    public int mWidth;
    /* renamed from: xJ */
    public int f15043xJ;
    /* renamed from: xL */
    public int f15044xL;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper$handleAnimation$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f$a */
    public static final class C20109a implements OnPreDrawListener {
        final /* synthetic */ C33743f jYJ;
        final /* synthetic */ C24051b jYK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper$handleAnimation$1$onPreDraw$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f$a$a */
        public static final class C11264a implements C24051b {
            final /* synthetic */ C20109a jYL;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f$a$a$a */
            static final class C11265a implements Runnable {
                final /* synthetic */ C11264a jYM;

                C11265a(C11264a c11264a) {
                    this.jYM = c11264a;
                }

                public final void run() {
                    AppMethodBeat.m2504i(15330);
                    this.jYM.jYL.jYJ.jYI = true;
                    this.jYM.jYL.jYJ.aYP();
                    AppMethodBeat.m2505o(15330);
                }
            }

            C11264a(C20109a c20109a) {
                this.jYL = c20109a;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                AppMethodBeat.m2504i(15331);
                View findViewById = C33743f.m55134a(this.jYL.jYJ).findViewById(2131821891);
                C25052j.m39375o(findViewById, "animationView.findViewBy…View>(R.id.video_loading)");
                findViewById.setVisibility(0);
                C5004al.m7442n(new C11265a(this), 150);
                findViewById = this.jYL.jYJ.jYG;
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                if (this.jYL.jYK != null) {
                    this.jYL.jYK.onAnimationEnd();
                }
                AppMethodBeat.m2505o(15331);
            }
        }

        public C20109a(C33743f c33743f, C24051b c24051b) {
            this.jYJ = c33743f;
            this.jYK = c24051b;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(15332);
            ViewTreeObserver viewTreeObserver = C33743f.m55134a(this.jYJ).getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            C33743f.m55135b(this.jYJ).mo49165PJ(this.jYJ.duration);
            if (this.jYJ.jYG != null) {
                View view = this.jYJ.jYG;
                if (view == null) {
                    C25052j.dWJ();
                }
                view.setAlpha(1.0f);
                view = this.jYJ.jYG;
                if (view == null) {
                    C25052j.dWJ();
                }
                view.animate().setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).alpha(0.0f);
            }
            C33743f.m55135b(this.jYJ).mo49166a(C33743f.m55134a(this.jYJ), null, new C11264a(this));
            AppMethodBeat.m2505o(15332);
            return true;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ View m55134a(C33743f c33743f) {
        AppMethodBeat.m2504i(15335);
        View view = c33743f.jYF;
        if (view == null) {
            C25052j.avw("animationView");
        }
        AppMethodBeat.m2505o(15335);
        return view;
    }

    /* renamed from: b */
    public static final /* synthetic */ C30759e m55135b(C33743f c33743f) {
        AppMethodBeat.m2504i(15336);
        C30759e c30759e = c33743f.jYE;
        if (c30759e == null) {
            C25052j.avw("imagePreviewAnimation");
        }
        AppMethodBeat.m2505o(15336);
        return c30759e;
    }

    /* renamed from: a */
    public final void mo54273a(Intent intent, Context context, View view, View view2) {
        AppMethodBeat.m2504i(15333);
        C25052j.m39376p(intent, "intent");
        C25052j.m39376p(context, "context");
        C25052j.m39376p(view, "view");
        this.jYE = new C30759e(context);
        this.jYF = view;
        this.jYG = view2;
        this.f15044xL = intent.getIntExtra("img_gallery_top", 0);
        this.f15043xJ = intent.getIntExtra("img_gallery_left", 0);
        this.mWidth = intent.getIntExtra("img_gallery_width", 0);
        this.mHeight = intent.getIntExtra("img_gallery_height", 0);
        AppMethodBeat.m2505o(15333);
    }

    public final void aYP() {
        AppMethodBeat.m2504i(15334);
        if ((this.jYI && this.jYH) || !this.enable) {
            View view = this.jYF;
            if (view == null) {
                C25052j.avw("animationView");
            }
            view.setVisibility(8);
        }
        AppMethodBeat.m2505o(15334);
    }
}
