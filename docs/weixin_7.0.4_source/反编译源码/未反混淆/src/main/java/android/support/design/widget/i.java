package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;

final class i extends h {
    private InsetDrawable qL;

    static class a extends GradientDrawable {
        a() {
        }

        public final boolean isStateful() {
            return true;
        }
    }

    i(VisibilityAwareImageButton visibilityAwareImageButton, k kVar) {
        super(visibilityAwareImageButton, kVar);
    }

    /* Access modifiers changed, original: final */
    public final void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.qv = android.support.v4.a.a.a.f(cj());
        android.support.v4.a.a.a.a(this.qv, colorStateList);
        if (mode != null) {
            android.support.v4.a.a.a.a(this.qv, mode);
        }
        if (i2 > 0) {
            this.qx = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.qx, this.qv});
        } else {
            this.qx = null;
            layerDrawable = this.qv;
        }
        this.qw = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.qy = this.qw;
        this.qD.setBackgroundDrawable(this.qw);
    }

    /* Access modifiers changed, original: final */
    public final void setRippleColor(int i) {
        if (this.qw instanceof RippleDrawable) {
            ((RippleDrawable) this.qw).setColor(ColorStateList.valueOf(i));
        } else {
            super.setRippleColor(i);
        }
    }

    /* Access modifiers changed, original: final */
    public final void o(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.qC, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.qC, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(qr);
            stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.qC, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.qC, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(qr);
            stateListAnimator.addState(qB, animatorSet);
            AnimatorSet animatorSet2 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.qC, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.qC, View.TRANSLATION_Z, new float[]{this.qC.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.qC, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            animatorSet2.setInterpolator(qr);
            stateListAnimator.addState(ENABLED_STATE_SET, animatorSet2);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.qC, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.qC, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet.setInterpolator(qr);
            stateListAnimator.addState(EMPTY_STATE_SET, animatorSet);
            this.qC.setStateListAnimator(stateListAnimator);
        } else if (this.qC.isEnabled()) {
            this.qC.setElevation(f);
            if (this.qC.isFocused() || this.qC.isPressed()) {
                this.qC.setTranslationZ(f2);
            } else {
                this.qC.setTranslationZ(0.0f);
            }
        } else {
            this.qC.setElevation(0.0f);
            this.qC.setTranslationZ(0.0f);
        }
        if (this.qD.cd()) {
            cg();
        }
    }

    public final float getElevation() {
        return this.qC.getElevation();
    }

    /* Access modifiers changed, original: final */
    public final void cf() {
        cg();
    }

    /* Access modifiers changed, original: final */
    public final void e(Rect rect) {
        if (this.qD.cd()) {
            this.qL = new InsetDrawable(this.qw, rect.left, rect.top, rect.right, rect.bottom);
            this.qD.setBackgroundDrawable(this.qL);
            return;
        }
        this.qD.setBackgroundDrawable(this.qw);
    }

    /* Access modifiers changed, original: final */
    public final void c(int[] iArr) {
    }

    /* Access modifiers changed, original: final */
    public final void ce() {
    }

    /* Access modifiers changed, original: final */
    public final boolean ch() {
        return false;
    }

    /* Access modifiers changed, original: final */
    public final d ci() {
        return new e();
    }

    /* Access modifiers changed, original: final */
    public final GradientDrawable ck() {
        return new a();
    }

    /* Access modifiers changed, original: final */
    public final void d(Rect rect) {
        if (this.qD.cd()) {
            float radius = this.qD.getRadius();
            float elevation = this.qC.getElevation() + this.qA;
            int ceil = (int) Math.ceil((double) j.d(elevation, radius, false));
            int ceil2 = (int) Math.ceil((double) j.c(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
