package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.k.a;
import com.tencent.smtt.sdk.WebView;

public class ThreeDotsLoadingView extends FrameLayout {
    private boolean OG = false;
    private int zOE = WebView.NIGHT_MODE_COLOR;
    private boolean zOF = false;
    private ViewGroup zOG;
    private ImageView zOH;
    private ImageView zOI;
    private ImageView zOJ;
    private final Runnable zOK = new Runnable() {
        public final void run() {
            AppMethodBeat.i(77514);
            ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
            ((AnimationDrawable) ThreeDotsLoadingView.this.zOH.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.zOI.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.zOJ.getDrawable()).start();
            AppMethodBeat.o(77514);
        }
    };

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(77515);
        init(context, attributeSet);
        AppMethodBeat.o(77515);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(77516);
        init(context, attributeSet);
        AppMethodBeat.o(77516);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(77517);
        this.zOG = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.a9p, this, true);
        this.zOH = (ImageView) this.zOG.findViewById(R.id.cp1);
        this.zOI = (ImageView) this.zOG.findViewById(R.id.cp2);
        this.zOJ = (ImageView) this.zOG.findViewById(R.id.cp3);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.ThreeDotsLoadingView);
            this.zOE = obtainStyledAttributes.getColor(0, WebView.NIGHT_MODE_COLOR);
            obtainStyledAttributes.recycle();
        }
        dKU();
        AppMethodBeat.o(77517);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(77518);
        if (8 == i || 4 == i) {
            dKT();
        }
        super.setVisibility(i);
        AppMethodBeat.o(77518);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(77519);
        super.onAttachedToWindow();
        if (this.zOF) {
            this.zOF = false;
            dKS();
        }
        AppMethodBeat.o(77519);
    }

    public void setAlpha(float f) {
        AppMethodBeat.i(77520);
        this.zOH.setAlpha(f);
        this.zOI.setAlpha(f);
        this.zOJ.setAlpha(f);
        if (getBackground() != null) {
            getBackground().setAlpha(Math.round(255.0f * f));
        }
        AppMethodBeat.o(77520);
    }

    public final void dKS() {
        AppMethodBeat.i(77521);
        if (!s.av(this)) {
            this.zOF = true;
            AppMethodBeat.o(77521);
        } else if (this.OG) {
            AppMethodBeat.o(77521);
        } else {
            this.OG = true;
            dKU();
            postDelayed(this.zOK, 300);
            AppMethodBeat.o(77521);
        }
    }

    public final void dKT() {
        AppMethodBeat.i(77522);
        this.zOF = false;
        if (this.OG) {
            this.OG = false;
            removeCallbacks(this.zOK);
            if (this.zOH.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) this.zOH.getDrawable()).stop();
                ((AnimationDrawable) this.zOI.getDrawable()).stop();
                ((AnimationDrawable) this.zOJ.getDrawable()).stop();
            }
            AppMethodBeat.o(77522);
            return;
        }
        AppMethodBeat.o(77522);
    }

    private void dKU() {
        AppMethodBeat.i(77523);
        this.zOH.setImageDrawable(k(this.zOE, 0.5f));
        this.zOI.setImageDrawable(k(this.zOE, 0.4f));
        this.zOJ.setImageDrawable(k(this.zOE, 0.3f));
        AppMethodBeat.o(77523);
    }

    private static AnimationDrawable e(int i, float[] fArr) {
        int i2 = 0;
        AppMethodBeat.i(77524);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        while (i2 < 3) {
            animationDrawable.addFrame(k(i, fArr[i2]), 300);
            i2++;
        }
        AppMethodBeat.o(77524);
        return animationDrawable;
    }

    private static Drawable k(int i, float f) {
        AppMethodBeat.i(77525);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        AppMethodBeat.o(77525);
        return shapeDrawable;
    }

    static /* synthetic */ void a(ThreeDotsLoadingView threeDotsLoadingView) {
        AppMethodBeat.i(77526);
        threeDotsLoadingView.zOH.setImageDrawable(e(threeDotsLoadingView.zOE, new float[]{0.4f, 0.3f, 0.5f}));
        threeDotsLoadingView.zOI.setImageDrawable(e(threeDotsLoadingView.zOE, new float[]{0.5f, 0.4f, 0.3f}));
        threeDotsLoadingView.zOJ.setImageDrawable(e(threeDotsLoadingView.zOE, new float[]{0.3f, 0.5f, 0.4f}));
        AppMethodBeat.o(77526);
    }
}
