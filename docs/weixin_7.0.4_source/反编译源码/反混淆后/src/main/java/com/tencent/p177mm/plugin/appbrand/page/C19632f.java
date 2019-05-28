package com.tencent.p177mm.plugin.appbrand.page;

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
import com.tencent.luggage.p147g.C8873f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.widget.C46700c;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.widget.C33575a;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout.C24597a;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout.C25025b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0014J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010*\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.f */
public final class C19632f extends SwipeBackLayout implements DialogInterface {
    private OnClickListener iqW;
    private OnClickListener iqX;
    private Animation iqY;
    Animation iqZ;
    C38470q ira;
    private C7355b irb;
    C10933b irc;
    ImageView ird;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$2"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$b */
    static final class C10666b implements View.OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ C19632f ire;

        C10666b(C19632f c19632f, Context context) {
            this.ire = c19632f;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134760);
            C38470q b = this.ire.ira;
            if (b != null) {
                C6750i runtime = b.getRuntime();
                if (runtime != null) {
                    C33183g.m54275a(runtime.getAppId(), C33184d.CLOSE);
                    runtime.close();
                    AppMethodBeat.m2505o(134760);
                    return;
                }
            }
            AppMethodBeat.m2505o(134760);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$1"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$a */
    static final class C19631a implements View.OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ C19632f ire;

        C19631a(C19632f c19632f, Context context) {
            this.ire = c19632f;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134759);
            this.ire.dismiss();
            AppMethodBeat.m2505o(134759);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$2 */
    static final class C196332 implements View.OnClickListener {
        final /* synthetic */ C19632f ire;

        C196332(C19632f c19632f) {
            this.ire = c19632f;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134763);
            OnClickListener positiveButton = this.ire.getPositiveButton();
            if (positiveButton != null) {
                positiveButton.onClick(this.ire, -1);
                AppMethodBeat.m2505o(134763);
                return;
            }
            AppMethodBeat.m2505o(134763);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$d */
    public static final class C19634d extends C46700c {
        final /* synthetic */ C19632f ire;
        final /* synthetic */ Runnable irh;

        C19634d(C19632f c19632f, Runnable runnable) {
            this.ire = c19632f;
            this.irh = runnable;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(134766);
            this.ire.iqZ = null;
            Runnable runnable = this.irh;
            if (runnable != null) {
                runnable.run();
                AppMethodBeat.m2505o(134766);
                return;
            }
            AppMethodBeat.m2505o(134766);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$1", "Lme/imid/swipebacklayout/lib/SwipeBackLayout$SwipeListenerEx;", "onContentViewSwipedBack", "", "onDispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onEdgeTouch", "edgeFlag", "", "onScrollOverThreshold", "onScrollStateChange", "state", "scrollPercent", "", "onViewReleased", "", "willSwipeBack", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$1 */
    public static final class C196351 implements C25025b {
        final /* synthetic */ C19632f ire;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.page.f$1$a */
        static final class C19630a implements Runnable {
            final /* synthetic */ C196351 irf;

            C19630a(C196351 c196351) {
                this.irf = c196351;
            }

            public final void run() {
                AppMethodBeat.m2504i(134761);
                ViewParent parent = this.irf.ire.getParent();
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup != null) {
                    viewGroup.removeView(this.irf.ire);
                    AppMethodBeat.m2505o(134761);
                    return;
                }
                AppMethodBeat.m2505o(134761);
            }
        }

        C196351(C19632f c19632f) {
            this.ire = c19632f;
        }

        /* renamed from: h */
        public final void mo3956h(int i, float f) {
        }

        /* renamed from: xv */
        public final void mo3958xv() {
        }

        /* renamed from: l */
        public final void mo3957l(MotionEvent motionEvent) {
        }

        /* renamed from: ba */
        public final boolean mo3955ba(boolean z) {
            return false;
        }

        public final void aJd() {
            AppMethodBeat.m2504i(134762);
            this.ire.setVisibility(8);
            this.ire.post(new C19630a(this));
            AppMethodBeat.m2505o(134762);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.f$c */
    public static final class C19636c extends C46700c {
        final /* synthetic */ C19632f ire;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.page.f$c$a */
        static final class C19637a implements Runnable {
            final /* synthetic */ C19636c irg;

            C19637a(C19636c c19636c) {
                this.irg = c19636c;
            }

            public final void run() {
                AppMethodBeat.m2504i(134764);
                this.irg.ire.cleanup();
                AppMethodBeat.m2505o(134764);
            }
        }

        C19636c(C19632f c19632f) {
            this.ire = c19632f;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(134765);
            this.ire.setVisibility(8);
            C5004al.m7441d(new C19637a(this));
            AppMethodBeat.m2505o(134765);
        }
    }

    public C19632f(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(134774);
        C33468at.m54677cr(this);
        mo65734a((C24597a) new C196351(this));
        C7355b c7355b = new C7355b(context);
        c7355b.setClickable(true);
        c7355b.setBackgroundColor(-1);
        c7355b.setWillNotDraw(false);
        c7355b.mo15854qM(false);
        c7355b.mo15851K(0, true);
        this.irb = c7355b;
        addView(this.irb, new LayoutParams(-1, -1));
        setContentView(this.irb);
        C10933b c10933b = new C10933b(context);
        c10933b.setFullscreenMode(false);
        c10933b.setBackButtonClickListener(new C19631a(this, context));
        c10933b.setCloseButtonClickListener(new C10666b(this, context));
        C7355b c7355b2 = this.irb;
        if (c7355b2 == null) {
            C25052j.dWJ();
        }
        c7355b2.addView(c10933b, new FrameLayout.LayoutParams(-1, C33575a.m54827de(context)));
        this.irc = c10933b;
        View inflate = LayoutInflater.from(context).inflate(2130968695, this.irb, false);
        ((TextView) inflate.findViewById(2131821110)).setText(C25738R.string.f8963kx);
        ((TextView) inflate.findViewById(2131821173)).setText(C25738R.string.f8962kw);
        c7355b = this.irb;
        if (c7355b == null) {
            C25052j.dWJ();
        }
        c7355b.addView(inflate);
        C25052j.m39375o(inflate, "this");
        LayoutParams layoutParams = inflate.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            layoutParams = null;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = C33575a.m54827de(context);
        }
        this.ird = (ImageView) findViewById(2131821109);
        findViewById(2131821173).setOnClickListener(new C196332(this));
        AppMethodBeat.m2505o(134774);
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
        AppMethodBeat.m2504i(134767);
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
            AppMethodBeat.m2505o(134767);
            return;
        }
        AppMethodBeat.m2505o(134767);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(134768);
        Animation animation = this.iqY;
        if (animation != null) {
            animation.cancel();
        }
        this.iqY = AnimationUtils.loadAnimation(getContext(), C5206a.ynf);
        Animation animation2 = this.iqY;
        if (animation2 == null) {
            C25052j.dWJ();
        }
        animation2.setAnimationListener(new C19636c(this));
        animation = this.iqY;
        if (animation == null) {
            C25052j.dWJ();
        }
        startAnimation(animation);
        AppMethodBeat.m2505o(134768);
    }

    public final void aJc() {
        AppMethodBeat.m2504i(134769);
        setVisibility(8);
        cleanup();
        AppMethodBeat.m2505o(134769);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(134770);
        dismiss();
        OnClickListener onClickListener = this.iqX;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
            AppMethodBeat.m2505o(134770);
            return;
        }
        AppMethodBeat.m2505o(134770);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(134771);
        super.onDetachedFromWindow();
        this.iqW = null;
        this.iqX = null;
        this.iqY = null;
        this.iqZ = null;
        this.ira = null;
        AppMethodBeat.m2505o(134771);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(134772);
        if (this.iqY == null && this.iqZ == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.m2505o(134772);
            return dispatchTouchEvent;
        }
        AppMethodBeat.m2505o(134772);
        return true;
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(134773);
        if (this.iqY != null || this.iqZ != null) {
            AppMethodBeat.m2505o(134773);
            return true;
        } else if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            C8873f.m15846az(getContext());
            dismiss();
            AppMethodBeat.m2505o(134773);
            return true;
        } else {
            boolean dispatchKeyEventPreIme = super.dispatchKeyEventPreIme(keyEvent);
            AppMethodBeat.m2505o(134773);
            return dispatchKeyEventPreIme;
        }
    }
}
