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
import android.support.p057v4.p058a.p059a.C0280a;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.i */
final class C44945i extends C41487h {
    /* renamed from: qL */
    private InsetDrawable f17658qL;

    /* renamed from: android.support.design.widget.i$a */
    static class C8347a extends GradientDrawable {
        C8347a() {
        }

        public final boolean isStateful() {
            return true;
        }
    }

    C44945i(VisibilityAwareImageButton visibilityAwareImageButton, C25312k c25312k) {
        super(visibilityAwareImageButton, c25312k);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo66212a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.f16752qv = C0280a.m467f(mo66219cj());
        C0280a.m457a(this.f16752qv, colorStateList);
        if (mode != null) {
            C0280a.m460a(this.f16752qv, mode);
        }
        if (i2 > 0) {
            this.f16754qx = mo66211a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f16754qx, this.f16752qv});
        } else {
            this.f16754qx = null;
            layerDrawable = this.f16752qv;
        }
        this.f16753qw = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.f16755qy = this.f16753qw;
        this.f16747qD.setBackgroundDrawable(this.f16753qw);
    }

    /* Access modifiers changed, original: final */
    public final void setRippleColor(int i) {
        if (this.f16753qw instanceof RippleDrawable) {
            ((RippleDrawable) this.f16753qw).setColor(ColorStateList.valueOf(i));
        } else {
            super.setRippleColor(i);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final void mo66225o(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.f16746qC, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f16746qC, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(f16742qr);
            stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.f16746qC, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f16746qC, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(f16742qr);
            stateListAnimator.addState(f16741qB, animatorSet);
            AnimatorSet animatorSet2 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f16746qC, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.f16746qC, View.TRANSLATION_Z, new float[]{this.f16746qC.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f16746qC, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            animatorSet2.setInterpolator(f16742qr);
            stateListAnimator.addState(ENABLED_STATE_SET, animatorSet2);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.f16746qC, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f16746qC, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet.setInterpolator(f16742qr);
            stateListAnimator.addState(EMPTY_STATE_SET, animatorSet);
            this.f16746qC.setStateListAnimator(stateListAnimator);
        } else if (this.f16746qC.isEnabled()) {
            this.f16746qC.setElevation(f);
            if (this.f16746qC.isFocused() || this.f16746qC.isPressed()) {
                this.f16746qC.setTranslationZ(f2);
            } else {
                this.f16746qC.setTranslationZ(0.0f);
            }
        } else {
            this.f16746qC.setElevation(0.0f);
            this.f16746qC.setTranslationZ(0.0f);
        }
        if (this.f16747qD.mo18192cd()) {
            mo66216cg();
        }
    }

    public final float getElevation() {
        return this.f16746qC.getElevation();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cf */
    public final void mo66215cf() {
        mo66216cg();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo66223e(Rect rect) {
        if (this.f16747qD.mo18192cd()) {
            this.f17658qL = new InsetDrawable(this.f16753qw, rect.left, rect.top, rect.right, rect.bottom);
            this.f16747qD.setBackgroundDrawable(this.f17658qL);
            return;
        }
        this.f16747qD.setBackgroundDrawable(this.f16753qw);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo66213c(int[] iArr) {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ce */
    public final void mo66214ce() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ch */
    public final boolean mo66217ch() {
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ci */
    public final C31842d mo66218ci() {
        return new C8345e();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ck */
    public final GradientDrawable mo66220ck() {
        return new C8347a();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo66222d(Rect rect) {
        if (this.f16747qD.mo18192cd()) {
            float radius = this.f16747qD.getRadius();
            float elevation = this.f16746qC.getElevation() + this.f16745qA;
            int ceil = (int) Math.ceil((double) C37100j.m62063d(elevation, radius, false));
            int ceil2 = (int) Math.ceil((double) C37100j.m62062c(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
