package com.tencent.p177mm.plugin.shake.p511ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p211cb.C45278c;
import com.tencent.p177mm.p211cb.C9212g;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame */
public class ShakeEggAnimFrame extends FrameLayout {
    List<View> qul = new ArrayList();
    int qum = 0;
    int size = 0;

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame$a */
    abstract class C3835a extends Animation {
        protected int duration = 100;
        View targetView;

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame$a$1 */
        class C38361 implements Runnable {
            C38361() {
            }

            public final void run() {
                AppMethodBeat.m2504i(24710);
                if (C3835a.this.targetView != null) {
                    C3835a.this.targetView.clearAnimation();
                    ShakeEggAnimFrame shakeEggAnimFrame = ShakeEggAnimFrame.this;
                    View view = C3835a.this.targetView;
                    shakeEggAnimFrame.qul.remove(view);
                    shakeEggAnimFrame.removeView(view);
                }
                AppMethodBeat.m2505o(24710);
            }
        }

        C3835a() {
        }

        public final void ckA() {
            Assert.assertTrue(this.targetView != null);
            this.targetView.post(new C38361());
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame$b */
    class C3837b extends C3835a {
        private int hkc;
        private int hkd;
        private float qup;
        private float quq;
        private float qur;
        private float qus;
        private float qut = 0.01f;
        private float quu = 0.02f;
        private float quv;
        private float quw;
        private float qux;
        private float quy;

        public C3837b(int i, int i2) {
            super();
            AppMethodBeat.m2504i(24711);
            this.hkc = i;
            this.hkd = i2;
            this.qup = ShakeEggAnimFrame.m6129Y(0.1f, 0.9f);
            this.quq = this.qup;
            this.qus = ShakeEggAnimFrame.m6129Y(-0.3f, -0.1f);
            restart();
            AppMethodBeat.m2505o(24711);
        }

        /* Access modifiers changed, original: protected|final */
        public final void applyTransformation(float f, Transformation transformation) {
            AppMethodBeat.m2504i(24712);
            float f2 = this.quv;
            float f3 = this.qux;
            if (this.quv != this.quw) {
                f2 = this.quv + ((this.quw - this.quv) * f);
            }
            if (this.qux != this.quy) {
                f3 = this.qux + ((this.quy - this.qux) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (f == 1.0f) {
                restart();
            }
            AppMethodBeat.m2505o(24712);
        }

        private void restart() {
            AppMethodBeat.m2504i(24713);
            if (this.qus > 0.0f) {
                this.quu += this.qut;
            }
            this.qur = this.qus;
            this.qus += this.quu;
            if (this.qur > 1.1f) {
                ckA();
            }
            m6131aE();
            AppMethodBeat.m2505o(24713);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(24714);
            super.initialize(i, i2, i3, i4);
            setRepeatCount(-1);
            setDuration((long) this.duration);
            AppMethodBeat.m2505o(24714);
        }

        /* renamed from: aE */
        private void m6131aE() {
            this.quv = this.qup * ((float) this.hkc);
            this.quw = this.quq * ((float) this.hkc);
            this.qux = this.qur * ((float) this.hkd);
            this.quy = this.qus * ((float) this.hkd);
        }
    }

    public ShakeEggAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(24715);
        AppMethodBeat.m2505o(24715);
    }

    /* renamed from: Y */
    static float m6129Y(float f, float f2) {
        AppMethodBeat.m2504i(24717);
        float random = (((float) Math.random()) * (f2 - f)) + f;
        AppMethodBeat.m2505o(24717);
        return random;
    }

    private int getSize() {
        AppMethodBeat.m2504i(24718);
        int textSize;
        if (this.size == 0) {
            textSize = (int) (((double) new TextView(getContext()).getTextSize()) * 1.2d);
            AppMethodBeat.m2505o(24718);
            return textSize;
        }
        textSize = this.size;
        AppMethodBeat.m2505o(24718);
        return textSize;
    }

    /* renamed from: aa */
    public final void mo8495aa(Activity activity) {
        AppMethodBeat.m2504i(24716);
        for (View view : this.qul) {
            view.clearAnimation();
            removeView(view);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        setVisibility(0);
        for (int i = 0; i < 30; i++) {
            C3837b c3837b = new C3837b(displayMetrics.widthPixels, displayMetrics.heightPixels);
            C9212g.dqQ();
            C37626b dqD = C37626b.dqD();
            Drawable a = dqD.mo60447a((C45278c) dqD.xFK.get(107), true);
            a.setBounds(0, 0, getSize(), getSize());
            ImageSpan imageSpan = new ImageSpan(a, 1);
            SpannableString spannableString = new SpannableString("  ");
            spannableString.setSpan(imageSpan, 0, 1, 33);
            TextView textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setText(spannableString);
            textView.setAnimation(c3837b);
            textView.setTag(c3837b);
            addView(textView);
            c3837b.targetView = textView;
            this.qul.add(textView);
        }
        AppMethodBeat.m2505o(24716);
    }
}
