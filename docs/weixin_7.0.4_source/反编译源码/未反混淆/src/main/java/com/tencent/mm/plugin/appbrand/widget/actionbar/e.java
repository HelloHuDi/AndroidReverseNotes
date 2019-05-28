package com.tencent.mm.plugin.appbrand.widget.actionbar;

import a.f.b.j;
import a.l;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.b;

@l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "()V", "mAnimator", "Landroid/animation/Animator;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pause", "resume", "setDescription", "resId", "", "setLogo", "drawable", "setStyle", "style", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarColoredStylePart$Style;", "wrap", "button", "luggage-wxa-app_release"})
public final class e extends com.tencent.mm.plugin.appbrand.page.a.a implements b, com.tencent.mm.plugin.appbrand.page.a.c.a {
    private Animator Cz;
    AppBrandOptionButton iUZ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl$applyLogo$1$1"})
    static final class a implements AnimatorUpdateListener {
        final /* synthetic */ AppBrandOptionButton iVa;
        final /* synthetic */ Drawable iVb;

        a(AppBrandOptionButton appBrandOptionButton, Drawable drawable) {
            this.iVa = appBrandOptionButton;
            this.iVb = drawable;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(87598);
            this.iVa.getButtonImage().setImageDrawable(this.iVb);
            AppMethodBeat.o(87598);
        }
    }

    public final void setLogo(Drawable drawable) {
        AppMethodBeat.i(87599);
        q(drawable);
        AppMethodBeat.o(87599);
    }

    public final void setLogo(int i) {
    }

    public final void pE(int i) {
    }

    public final com.tencent.mm.plugin.appbrand.page.a.c.a aKh() {
        return this;
    }

    public final void destroy() {
        AppMethodBeat.i(87601);
        clearAnimation();
        this.iUZ = null;
        AppMethodBeat.o(87601);
    }

    public final void resume() {
        AppMethodBeat.i(87602);
        Animator animator = this.Cz;
        if (animator != null) {
            animator.resume();
            AppMethodBeat.o(87602);
            return;
        }
        AppMethodBeat.o(87602);
    }

    public final void pause() {
        AppMethodBeat.i(87603);
        Animator animator = this.Cz;
        if (animator != null) {
            animator.pause();
            AppMethodBeat.o(87603);
            return;
        }
        AppMethodBeat.o(87603);
    }

    public final void q(Drawable drawable) {
        AppMethodBeat.i(87604);
        AppBrandOptionButton appBrandOptionButton = this.iUZ;
        if (appBrandOptionButton == null) {
            j.dWJ();
        }
        clearAnimation();
        if (drawable == null) {
            appBrandOptionButton.reset();
            AppMethodBeat.o(87604);
            return;
        }
        Animator animator;
        appBrandOptionButton.getButtonImage().setImageDrawable(drawable);
        Animator cs = com.tencent.mm.plugin.appbrand.page.a.a.cs(appBrandOptionButton.getButtonImage());
        if (cs instanceof ValueAnimator) {
            animator = cs;
        } else {
            animator = null;
        }
        ValueAnimator valueAnimator = (ValueAnimator) animator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new a(appBrandOptionButton, drawable));
        }
        cs.start();
        this.Cz = cs;
        AppMethodBeat.o(87604);
    }

    public final void y(CharSequence charSequence) {
    }

    public final Context getContext() {
        AppMethodBeat.i(87605);
        AppBrandOptionButton appBrandOptionButton = this.iUZ;
        if (appBrandOptionButton == null) {
            j.dWJ();
        }
        Context context = appBrandOptionButton.getContext();
        j.o(context, "mButton!!.context");
        AppMethodBeat.o(87605);
        return context;
    }

    private final void clearAnimation() {
        AppMethodBeat.i(87606);
        Animator animator = this.Cz;
        if (animator != null) {
            animator.cancel();
        }
        AppBrandOptionButton appBrandOptionButton = this.iUZ;
        if (appBrandOptionButton != null) {
            ImageView buttonImage = appBrandOptionButton.getButtonImage();
            if (buttonImage != null) {
                buttonImage.clearAnimation();
                AppMethodBeat.o(87606);
                return;
            }
        }
        AppMethodBeat.o(87606);
    }

    public final void dismiss() {
        AppMethodBeat.i(87600);
        q(null);
        AppMethodBeat.o(87600);
    }
}
