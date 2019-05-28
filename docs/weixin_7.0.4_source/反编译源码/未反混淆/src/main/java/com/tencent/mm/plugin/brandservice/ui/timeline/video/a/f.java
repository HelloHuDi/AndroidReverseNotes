package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.b;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001eJ(\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "", "()V", "TAG", "", "animationEnd", "", "getAnimationEnd", "()Z", "setAnimationEnd", "(Z)V", "animationView", "Landroid/view/View;", "appMsgGetDone", "getAppMsgGetDone", "setAppMsgGetDone", "bg", "duration", "", "enable", "getEnable", "setEnable", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isAnimated", "mHeight", "mLeft", "mTop", "mWidth", "handleAnimation", "", "savedInstanceState", "Landroid/os/Bundle;", "callBack", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "hideAnimationView", "init", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "view", "showAnimationView", "plugin-brandservice_release"})
public final class f {
    public final String TAG = "MicroMsg.MPVideoImageAnimationHelper";
    int duration = 300;
    public boolean enable = true;
    public boolean jYD;
    public e jYE;
    public View jYF;
    public View jYG;
    public boolean jYH;
    public boolean jYI;
    public int mHeight;
    public int mWidth;
    public int xJ;
    public int xL;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper$handleAnimation$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-brandservice_release"})
    public static final class a implements OnPreDrawListener {
        final /* synthetic */ f jYJ;
        final /* synthetic */ b jYK;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper$handleAnimation$1$onPreDraw$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-brandservice_release"})
        public static final class a implements b {
            final /* synthetic */ a jYL;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            static final class a implements Runnable {
                final /* synthetic */ a jYM;

                a(a aVar) {
                    this.jYM = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(15330);
                    this.jYM.jYL.jYJ.jYI = true;
                    this.jYM.jYL.jYJ.aYP();
                    AppMethodBeat.o(15330);
                }
            }

            a(a aVar) {
                this.jYL = aVar;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(15331);
                View findViewById = f.a(this.jYL.jYJ).findViewById(R.id.a9d);
                j.o(findViewById, "animationView.findViewBy…View>(R.id.video_loading)");
                findViewById.setVisibility(0);
                al.n(new a(this), 150);
                findViewById = this.jYL.jYJ.jYG;
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                if (this.jYL.jYK != null) {
                    this.jYL.jYK.onAnimationEnd();
                }
                AppMethodBeat.o(15331);
            }
        }

        public a(f fVar, b bVar) {
            this.jYJ = fVar;
            this.jYK = bVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(15332);
            ViewTreeObserver viewTreeObserver = f.a(this.jYJ).getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            f.b(this.jYJ).PJ(this.jYJ.duration);
            if (this.jYJ.jYG != null) {
                View view = this.jYJ.jYG;
                if (view == null) {
                    j.dWJ();
                }
                view.setAlpha(1.0f);
                view = this.jYJ.jYG;
                if (view == null) {
                    j.dWJ();
                }
                view.animate().setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator()).alpha(0.0f);
            }
            f.b(this.jYJ).a(f.a(this.jYJ), null, new a(this));
            AppMethodBeat.o(15332);
            return true;
        }
    }

    public static final /* synthetic */ View a(f fVar) {
        AppMethodBeat.i(15335);
        View view = fVar.jYF;
        if (view == null) {
            j.avw("animationView");
        }
        AppMethodBeat.o(15335);
        return view;
    }

    public static final /* synthetic */ e b(f fVar) {
        AppMethodBeat.i(15336);
        e eVar = fVar.jYE;
        if (eVar == null) {
            j.avw("imagePreviewAnimation");
        }
        AppMethodBeat.o(15336);
        return eVar;
    }

    public final void a(Intent intent, Context context, View view, View view2) {
        AppMethodBeat.i(15333);
        j.p(intent, "intent");
        j.p(context, "context");
        j.p(view, "view");
        this.jYE = new e(context);
        this.jYF = view;
        this.jYG = view2;
        this.xL = intent.getIntExtra("img_gallery_top", 0);
        this.xJ = intent.getIntExtra("img_gallery_left", 0);
        this.mWidth = intent.getIntExtra("img_gallery_width", 0);
        this.mHeight = intent.getIntExtra("img_gallery_height", 0);
        AppMethodBeat.o(15333);
    }

    public final void aYP() {
        AppMethodBeat.i(15334);
        if ((this.jYI && this.jYH) || !this.enable) {
            View view = this.jYF;
            if (view == null) {
                j.avw("animationView");
            }
            view.setVisibility(8);
        }
        AppMethodBeat.o(15334);
    }
}
