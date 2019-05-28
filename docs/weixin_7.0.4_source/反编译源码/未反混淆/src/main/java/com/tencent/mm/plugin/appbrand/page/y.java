package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;

@SuppressLint({"ViewConstructor"})
public final class y extends x {
    private aj isJ;
    private a itV;
    private b itW;
    private boolean itX = false;
    private LinearLayout itY;
    private TextView itZ;
    private View iua;
    private ImageView iub;
    private ImageView iuc;
    private ImageView iud;
    private long iue = 0;

    public interface a {
        void aJR();
    }

    public interface b {
        void nT(int i);
    }

    public y(Context context, aj ajVar) {
        super(context);
        AppMethodBeat.i(87290);
        this.isJ = ajVar;
        this.itY = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.cy, this, false);
        LinearLayout linearLayout = this.itY;
        View wrapperView = ajVar.getWrapperView();
        this.itI = linearLayout;
        this.itJ = new FrameLayout(getContext());
        this.itJ.setLayoutParams(new LayoutParams(-1, -1));
        this.itJ.addView(linearLayout);
        this.WL = wrapperView;
        this.itK = new FrameLayout(getContext());
        this.itK.setLayoutParams(new LayoutParams(-1, -1));
        this.itK.addView(wrapperView);
        addView(this.itJ);
        addView(this.itK);
        this.itZ = (TextView) findViewById(R.id.u_);
        this.iua = findViewById(R.id.ua);
        this.iub = (ImageView) findViewById(R.id.ub);
        this.iuc = (ImageView) findViewById(R.id.uc);
        this.iud = (ImageView) findViewById(R.id.ud);
        AppMethodBeat.o(87290);
    }

    public final void setOnPullDownListener(a aVar) {
        this.itV = aVar;
    }

    public final void setOnPullDownOffsetListener(b bVar) {
        this.itW = bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void pt(int i) {
        AppMethodBeat.i(87293);
        if (this.itW != null) {
            this.itW.nT(i);
        }
        if (this.itX) {
            if (i > this.itY.getHeight()) {
                i = this.itY.getHeight();
            }
            LinearLayout linearLayout = this.itY;
            linearLayout.setTranslationY((float) (i - linearLayout.getHeight()));
            AppMethodBeat.o(87293);
            return;
        }
        AppMethodBeat.o(87293);
    }

    public final void aKe() {
        AppMethodBeat.i(87294);
        long currentTimeMillis = System.currentTimeMillis() - this.iue;
        if (currentTimeMillis < 1000) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87289);
                    y.this.aKb();
                    AppMethodBeat.o(87289);
                }
            }, 1000 - currentTimeMillis);
            AppMethodBeat.o(87294);
            return;
        }
        aKb();
        AppMethodBeat.o(87294);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aAO() {
        AppMethodBeat.i(87295);
        boolean aAO = this.isJ.aAO();
        AppMethodBeat.o(87295);
        return aAO;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getStayHeight() {
        AppMethodBeat.i(87296);
        int height = this.itY.getHeight();
        AppMethodBeat.o(87296);
        return height;
    }

    public final void setHeadViewHeight(int i) {
        AppMethodBeat.i(87297);
        if (i <= this.itY.getHeight()) {
            AppMethodBeat.o(87297);
            return;
        }
        this.itY.getLayoutParams().height = i;
        this.itY.requestLayout();
        AppMethodBeat.o(87297);
    }

    public final void bq(String str, int i) {
        AppMethodBeat.i(87298);
        setBackgroundTextStyle(str);
        setPullDownBackgroundColor(i);
        AppMethodBeat.o(87298);
    }

    public final void setBackgroundTextStyle(String str) {
        AppMethodBeat.i(87299);
        if ("light".equals(str)) {
            this.iub.setImageDrawable(e(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
            this.iuc.setImageDrawable(e(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
            this.iud.setImageDrawable(e(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
            this.itZ.setTextColor(-1);
            this.itZ.setAlpha(0.4f);
            AppMethodBeat.o(87299);
            return;
        }
        if ("dark".equals(str) || !"ignore".equals(str)) {
            this.iub.setImageDrawable(e(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
            this.iuc.setImageDrawable(e(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
            this.iud.setImageDrawable(e(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
            this.itZ.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.itZ.setAlpha(0.2f);
        }
        AppMethodBeat.o(87299);
    }

    public final void setPullDownText(String str) {
        AppMethodBeat.i(87300);
        if (bo.isNullOrNil(str)) {
            this.itZ.setVisibility(8);
            AppMethodBeat.o(87300);
            return;
        }
        this.itZ.setVisibility(0);
        this.itZ.setText(str);
        AppMethodBeat.o(87300);
    }

    public final void dO(boolean z) {
        AppMethodBeat.i(87301);
        this.itX = z;
        setNeedStay(z);
        this.iua.setVisibility(z ? 0 : 4);
        AppMethodBeat.o(87301);
    }

    private static AnimationDrawable e(int i, float[] fArr) {
        AppMethodBeat.i(87302);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(k(i, fArr[0]), 0);
        animationDrawable.addFrame(k(i, fArr[1]), 300);
        animationDrawable.addFrame(k(i, fArr[2]), 300);
        animationDrawable.addFrame(k(i, fArr[3]), 300);
        AppMethodBeat.o(87302);
        return animationDrawable;
    }

    private static Drawable k(int i, float f) {
        AppMethodBeat.i(87303);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        AppMethodBeat.o(87303);
        return shapeDrawable;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKc() {
        AppMethodBeat.i(87291);
        ((AnimationDrawable) this.iub.getDrawable()).start();
        ((AnimationDrawable) this.iuc.getDrawable()).start();
        ((AnimationDrawable) this.iud.getDrawable()).start();
        if (this.itV != null) {
            this.itV.aJR();
        }
        this.iue = System.currentTimeMillis();
        AppMethodBeat.o(87291);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKd() {
        AppMethodBeat.i(87292);
        ((AnimationDrawable) this.iub.getDrawable()).stop();
        ((AnimationDrawable) this.iub.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.iuc.getDrawable()).stop();
        ((AnimationDrawable) this.iuc.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.iud.getDrawable()).stop();
        ((AnimationDrawable) this.iud.getDrawable()).selectDrawable(0);
        AppMethodBeat.o(87292);
    }
}
