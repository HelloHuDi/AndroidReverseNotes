package com.tencent.p177mm.plugin.appbrand.widget.actionbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C44705a;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C45662b;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "()V", "mAnimator", "Landroid/animation/Animator;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pause", "resume", "setDescription", "resId", "", "setLogo", "drawable", "setStyle", "style", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarColoredStylePart$Style;", "wrap", "button", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.e */
public final class C33576e extends C44705a implements C45662b, C2405a {
    /* renamed from: Cz */
    private Animator f15040Cz;
    AppBrandOptionButton iUZ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl$applyLogo$1$1"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.e$a */
    static final class C33577a implements AnimatorUpdateListener {
        final /* synthetic */ AppBrandOptionButton iVa;
        final /* synthetic */ Drawable iVb;

        C33577a(AppBrandOptionButton appBrandOptionButton, Drawable drawable) {
            this.iVa = appBrandOptionButton;
            this.iVb = drawable;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(87598);
            this.iVa.getButtonImage().setImageDrawable(this.iVb);
            AppMethodBeat.m2505o(87598);
        }
    }

    public final void setLogo(Drawable drawable) {
        AppMethodBeat.m2504i(87599);
        mo54077q(drawable);
        AppMethodBeat.m2505o(87599);
    }

    public final void setLogo(int i) {
    }

    /* renamed from: pE */
    public final void mo6314pE(int i) {
    }

    public final C2405a aKh() {
        return this;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(87601);
        clearAnimation();
        this.iUZ = null;
        AppMethodBeat.m2505o(87601);
    }

    public final void resume() {
        AppMethodBeat.m2504i(87602);
        Animator animator = this.f15040Cz;
        if (animator != null) {
            animator.resume();
            AppMethodBeat.m2505o(87602);
            return;
        }
        AppMethodBeat.m2505o(87602);
    }

    public final void pause() {
        AppMethodBeat.m2504i(87603);
        Animator animator = this.f15040Cz;
        if (animator != null) {
            animator.pause();
            AppMethodBeat.m2505o(87603);
            return;
        }
        AppMethodBeat.m2505o(87603);
    }

    /* renamed from: q */
    public final void mo54077q(Drawable drawable) {
        AppMethodBeat.m2504i(87604);
        AppBrandOptionButton appBrandOptionButton = this.iUZ;
        if (appBrandOptionButton == null) {
            C25052j.dWJ();
        }
        clearAnimation();
        if (drawable == null) {
            appBrandOptionButton.reset();
            AppMethodBeat.m2505o(87604);
            return;
        }
        Animator animator;
        appBrandOptionButton.getButtonImage().setImageDrawable(drawable);
        Animator cs = C44705a.m81346cs(appBrandOptionButton.getButtonImage());
        if (cs instanceof ValueAnimator) {
            animator = cs;
        } else {
            animator = null;
        }
        ValueAnimator valueAnimator = (ValueAnimator) animator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new C33577a(appBrandOptionButton, drawable));
        }
        cs.start();
        this.f15040Cz = cs;
        AppMethodBeat.m2505o(87604);
    }

    /* renamed from: y */
    public final void mo54078y(CharSequence charSequence) {
    }

    public final Context getContext() {
        AppMethodBeat.m2504i(87605);
        AppBrandOptionButton appBrandOptionButton = this.iUZ;
        if (appBrandOptionButton == null) {
            C25052j.dWJ();
        }
        Context context = appBrandOptionButton.getContext();
        C25052j.m39375o(context, "mButton!!.context");
        AppMethodBeat.m2505o(87605);
        return context;
    }

    private final void clearAnimation() {
        AppMethodBeat.m2504i(87606);
        Animator animator = this.f15040Cz;
        if (animator != null) {
            animator.cancel();
        }
        AppBrandOptionButton appBrandOptionButton = this.iUZ;
        if (appBrandOptionButton != null) {
            ImageView buttonImage = appBrandOptionButton.getButtonImage();
            if (buttonImage != null) {
                buttonImage.clearAnimation();
                AppMethodBeat.m2505o(87606);
                return;
            }
        }
        AppMethodBeat.m2505o(87606);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(87600);
        mo54077q(null);
        AppMethodBeat.m2505o(87600);
    }
}
