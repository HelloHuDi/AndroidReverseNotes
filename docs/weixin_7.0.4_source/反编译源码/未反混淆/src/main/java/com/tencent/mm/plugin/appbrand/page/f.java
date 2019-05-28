package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.al;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0014J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010*\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class f extends SwipeBackLayout implements DialogInterface {
    private OnClickListener iqW;
    private OnClickListener iqX;
    private Animation iqY;
    Animation iqZ;
    q ira;
    private com.tencent.mm.ui.statusbar.b irb;
    com.tencent.mm.plugin.appbrand.widget.actionbar.b irc;
    ImageView ird;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$2"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ f ire;

        b(f fVar, Context context) {
            this.ire = fVar;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134760);
            q b = this.ire.ira;
            if (b != null) {
                i runtime = b.getRuntime();
                if (runtime != null) {
                    g.a(runtime.getAppId(), com.tencent.mm.plugin.appbrand.g.d.CLOSE);
                    runtime.close();
                    AppMethodBeat.o(134760);
                    return;
                }
            }
            AppMethodBeat.o(134760);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ f ire;

        a(f fVar, Context context) {
            this.ire = fVar;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134759);
            this.ire.dismiss();
            AppMethodBeat.o(134759);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$2 */
    static final class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ f ire;

        AnonymousClass2(f fVar) {
            this.ire = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134763);
            OnClickListener positiveButton = this.ire.getPositiveButton();
            if (positiveButton != null) {
                positiveButton.onClick(this.ire, -1);
                AppMethodBeat.o(134763);
                return;
            }
            AppMethodBeat.o(134763);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
    public static final class d extends com.tencent.mm.ui.widget.c {
        final /* synthetic */ f ire;
        final /* synthetic */ Runnable irh;

        d(f fVar, Runnable runnable) {
            this.ire = fVar;
            this.irh = runnable;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(134766);
            this.ire.iqZ = null;
            Runnable runnable = this.irh;
            if (runnable != null) {
                runnable.run();
                AppMethodBeat.o(134766);
                return;
            }
            AppMethodBeat.o(134766);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$1", "Lme/imid/swipebacklayout/lib/SwipeBackLayout$SwipeListenerEx;", "onContentViewSwipedBack", "", "onDispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onEdgeTouch", "edgeFlag", "", "onScrollOverThreshold", "onScrollStateChange", "state", "scrollPercent", "", "onViewReleased", "", "willSwipeBack", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$1 */
    public static final class AnonymousClass1 implements me.imid.swipebacklayout.lib.SwipeBackLayout.b {
        final /* synthetic */ f ire;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ AnonymousClass1 irf;

            a(AnonymousClass1 anonymousClass1) {
                this.irf = anonymousClass1;
            }

            public final void run() {
                AppMethodBeat.i(134761);
                ViewParent parent = this.irf.ire.getParent();
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup != null) {
                    viewGroup.removeView(this.irf.ire);
                    AppMethodBeat.o(134761);
                    return;
                }
                AppMethodBeat.o(134761);
            }
        }

        AnonymousClass1(f fVar) {
            this.ire = fVar;
        }

        public final void h(int i, float f) {
        }

        public final void xv() {
        }

        public final void l(MotionEvent motionEvent) {
        }

        public final boolean ba(boolean z) {
            return false;
        }

        public final void aJd() {
            AppMethodBeat.i(134762);
            this.ire.setVisibility(8);
            this.ire.post(new a(this));
            AppMethodBeat.o(134762);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
    public static final class c extends com.tencent.mm.ui.widget.c {
        final /* synthetic */ f ire;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c irg;

            a(c cVar) {
                this.irg = cVar;
            }

            public final void run() {
                AppMethodBeat.i(134764);
                this.irg.ire.cleanup();
                AppMethodBeat.o(134764);
            }
        }

        c(f fVar) {
            this.ire = fVar;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(134765);
            this.ire.setVisibility(8);
            al.d(new a(this));
            AppMethodBeat.o(134765);
        }
    }

    public f(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(134774);
        at.cr(this);
        a((me.imid.swipebacklayout.lib.SwipeBackLayout.a) new AnonymousClass1(this));
        com.tencent.mm.ui.statusbar.b bVar = new com.tencent.mm.ui.statusbar.b(context);
        bVar.setClickable(true);
        bVar.setBackgroundColor(-1);
        bVar.setWillNotDraw(false);
        bVar.qM(false);
        bVar.K(0, true);
        this.irb = bVar;
        addView(this.irb, new LayoutParams(-1, -1));
        setContentView(this.irb);
        com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar2 = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(context);
        bVar2.setFullscreenMode(false);
        bVar2.setBackButtonClickListener(new a(this, context));
        bVar2.setCloseButtonClickListener(new b(this, context));
        com.tencent.mm.ui.statusbar.b bVar3 = this.irb;
        if (bVar3 == null) {
            j.dWJ();
        }
        bVar3.addView(bVar2, new FrameLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.de(context)));
        this.irc = bVar2;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ci, this.irb, false);
        ((TextView) inflate.findViewById(R.id.ol)).setText(R.string.kx);
        ((TextView) inflate.findViewById(R.id.qa)).setText(R.string.kw);
        bVar = this.irb;
        if (bVar == null) {
            j.dWJ();
        }
        bVar.addView(inflate);
        j.o(inflate, "this");
        LayoutParams layoutParams = inflate.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            layoutParams = null;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = com.tencent.mm.plugin.appbrand.widget.a.de(context);
        }
        this.ird = (ImageView) findViewById(R.id.ok);
        findViewById(R.id.qa).setOnClickListener(new AnonymousClass2(this));
        AppMethodBeat.o(134774);
    }

    public final OnClickListener getPositiveButton() {
        return this.iqW;
    }

    public final void setPositiveButton(OnClickListener onClickListener) {
        this.iqW = onClickListener;
    }

    public final OnClickListener getNegativeButton() {
        return this.iqX;
    }

    public final void setNegativeButton(OnClickListener onClickListener) {
        this.iqX = onClickListener;
    }

    public final void cleanup() {
        AnimationListener animationListener = null;
        AppMethodBeat.i(134767);
        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        animation = getAnimation();
        if (animation != null) {
            animation.setAnimationListener(null);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            Object animationListener2 = parent;
        }
        ViewGroup viewGroup = (ViewGroup) animationListener2;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            AppMethodBeat.o(134767);
            return;
        }
        AppMethodBeat.o(134767);
    }

    public final void dismiss() {
        AppMethodBeat.i(134768);
        Animation animation = this.iqY;
        if (animation != null) {
            animation.cancel();
        }
        this.iqY = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.ui.MMFragmentActivity.a.ynf);
        Animation animation2 = this.iqY;
        if (animation2 == null) {
            j.dWJ();
        }
        animation2.setAnimationListener(new c(this));
        animation = this.iqY;
        if (animation == null) {
            j.dWJ();
        }
        startAnimation(animation);
        AppMethodBeat.o(134768);
    }

    public final void aJc() {
        AppMethodBeat.i(134769);
        setVisibility(8);
        cleanup();
        AppMethodBeat.o(134769);
    }

    public final void cancel() {
        AppMethodBeat.i(134770);
        dismiss();
        OnClickListener onClickListener = this.iqX;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
            AppMethodBeat.o(134770);
            return;
        }
        AppMethodBeat.o(134770);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(134771);
        super.onDetachedFromWindow();
        this.iqW = null;
        this.iqX = null;
        this.iqY = null;
        this.iqZ = null;
        this.ira = null;
        AppMethodBeat.o(134771);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(134772);
        if (this.iqY == null && this.iqZ == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(134772);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(134772);
        return true;
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        AppMethodBeat.i(134773);
        if (this.iqY != null || this.iqZ != null) {
            AppMethodBeat.o(134773);
            return true;
        } else if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            com.tencent.luggage.g.f.az(getContext());
            dismiss();
            AppMethodBeat.o(134773);
            return true;
        } else {
            boolean dispatchKeyEventPreIme = super.dispatchKeyEventPreIme(keyEvent);
            AppMethodBeat.o(134773);
            return dispatchKeyEventPreIme;
        }
    }
}
