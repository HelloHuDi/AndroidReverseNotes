package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.C38615k.C11044a;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.ui.widget.ThreeDotsLoadingView */
public class ThreeDotsLoadingView extends FrameLayout {
    /* renamed from: OG */
    private boolean f16221OG = false;
    private int zOE = WebView.NIGHT_MODE_COLOR;
    private boolean zOF = false;
    private ViewGroup zOG;
    private ImageView zOH;
    private ImageView zOI;
    private ImageView zOJ;
    private final Runnable zOK = new C409021();

    /* renamed from: com.tencent.mm.ui.widget.ThreeDotsLoadingView$1 */
    class C409021 implements Runnable {
        C409021() {
        }

        public final void run() {
            AppMethodBeat.m2504i(77514);
            ThreeDotsLoadingView.m70896a(ThreeDotsLoadingView.this);
            ((AnimationDrawable) ThreeDotsLoadingView.this.zOH.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.zOI.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.zOJ.getDrawable()).start();
            AppMethodBeat.m2505o(77514);
        }
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(77515);
        init(context, attributeSet);
        AppMethodBeat.m2505o(77515);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(77516);
        init(context, attributeSet);
        AppMethodBeat.m2505o(77516);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(77517);
        this.zOG = (ViewGroup) LayoutInflater.from(context).inflate(2130969927, this, true);
        this.zOH = (ImageView) this.zOG.findViewById(2131825243);
        this.zOI = (ImageView) this.zOG.findViewById(2131825244);
        this.zOJ = (ImageView) this.zOG.findViewById(2131825245);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11044a.ThreeDotsLoadingView);
            this.zOE = obtainStyledAttributes.getColor(0, WebView.NIGHT_MODE_COLOR);
            obtainStyledAttributes.recycle();
        }
        dKU();
        AppMethodBeat.m2505o(77517);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(77518);
        if (8 == i || 4 == i) {
            dKT();
        }
        super.setVisibility(i);
        AppMethodBeat.m2505o(77518);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(77519);
        super.onAttachedToWindow();
        if (this.zOF) {
            this.zOF = false;
            dKS();
        }
        AppMethodBeat.m2505o(77519);
    }

    public void setAlpha(float f) {
        AppMethodBeat.m2504i(77520);
        this.zOH.setAlpha(f);
        this.zOI.setAlpha(f);
        this.zOJ.setAlpha(f);
        if (getBackground() != null) {
            getBackground().setAlpha(Math.round(255.0f * f));
        }
        AppMethodBeat.m2505o(77520);
    }

    public final void dKS() {
        AppMethodBeat.m2504i(77521);
        if (!C0477s.m930av(this)) {
            this.zOF = true;
            AppMethodBeat.m2505o(77521);
        } else if (this.f16221OG) {
            AppMethodBeat.m2505o(77521);
        } else {
            this.f16221OG = true;
            dKU();
            postDelayed(this.zOK, 300);
            AppMethodBeat.m2505o(77521);
        }
    }

    public final void dKT() {
        AppMethodBeat.m2504i(77522);
        this.zOF = false;
        if (this.f16221OG) {
            this.f16221OG = false;
            removeCallbacks(this.zOK);
            if (this.zOH.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) this.zOH.getDrawable()).stop();
                ((AnimationDrawable) this.zOI.getDrawable()).stop();
                ((AnimationDrawable) this.zOJ.getDrawable()).stop();
            }
            AppMethodBeat.m2505o(77522);
            return;
        }
        AppMethodBeat.m2505o(77522);
    }

    private void dKU() {
        AppMethodBeat.m2504i(77523);
        this.zOH.setImageDrawable(ThreeDotsLoadingView.m70901k(this.zOE, 0.5f));
        this.zOI.setImageDrawable(ThreeDotsLoadingView.m70901k(this.zOE, 0.4f));
        this.zOJ.setImageDrawable(ThreeDotsLoadingView.m70901k(this.zOE, 0.3f));
        AppMethodBeat.m2505o(77523);
    }

    /* renamed from: e */
    private static AnimationDrawable m70900e(int i, float[] fArr) {
        int i2 = 0;
        AppMethodBeat.m2504i(77524);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        while (i2 < 3) {
            animationDrawable.addFrame(ThreeDotsLoadingView.m70901k(i, fArr[i2]), 300);
            i2++;
        }
        AppMethodBeat.m2505o(77524);
        return animationDrawable;
    }

    /* renamed from: k */
    private static Drawable m70901k(int i, float f) {
        AppMethodBeat.m2504i(77525);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        AppMethodBeat.m2505o(77525);
        return shapeDrawable;
    }

    /* renamed from: a */
    static /* synthetic */ void m70896a(ThreeDotsLoadingView threeDotsLoadingView) {
        AppMethodBeat.m2504i(77526);
        threeDotsLoadingView.zOH.setImageDrawable(ThreeDotsLoadingView.m70900e(threeDotsLoadingView.zOE, new float[]{0.4f, 0.3f, 0.5f}));
        threeDotsLoadingView.zOI.setImageDrawable(ThreeDotsLoadingView.m70900e(threeDotsLoadingView.zOE, new float[]{0.5f, 0.4f, 0.3f}));
        threeDotsLoadingView.zOJ.setImageDrawable(ThreeDotsLoadingView.m70900e(threeDotsLoadingView.zOE, new float[]{0.3f, 0.5f, 0.4f}));
        AppMethodBeat.m2505o(77526);
    }
}
