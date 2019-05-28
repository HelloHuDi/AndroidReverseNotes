package com.tencent.p177mm.plugin.appbrand.page;

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
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.y */
public final class C33481y extends C10679x {
    private C27221aj isJ;
    private C33482a itV;
    private C33484b itW;
    private boolean itX = false;
    private LinearLayout itY;
    private TextView itZ;
    private View iua;
    private ImageView iub;
    private ImageView iuc;
    private ImageView iud;
    private long iue = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.y$a */
    public interface C33482a {
        void aJR();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.y$1 */
    class C334831 implements Runnable {
        C334831() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87289);
            C33481y.this.aKb();
            AppMethodBeat.m2505o(87289);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.y$b */
    public interface C33484b {
        /* renamed from: nT */
        void mo21652nT(int i);
    }

    public C33481y(Context context, C27221aj c27221aj) {
        super(context);
        AppMethodBeat.m2504i(87290);
        this.isJ = c27221aj;
        this.itY = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130968711, this, false);
        LinearLayout linearLayout = this.itY;
        View wrapperView = c27221aj.getWrapperView();
        this.itI = linearLayout;
        this.itJ = new FrameLayout(getContext());
        this.itJ.setLayoutParams(new LayoutParams(-1, -1));
        this.itJ.addView(linearLayout);
        this.f2880WL = wrapperView;
        this.itK = new FrameLayout(getContext());
        this.itK.setLayoutParams(new LayoutParams(-1, -1));
        this.itK.addView(wrapperView);
        addView(this.itJ);
        addView(this.itK);
        this.itZ = (TextView) findViewById(2131821320);
        this.iua = findViewById(2131821321);
        this.iub = (ImageView) findViewById(2131821322);
        this.iuc = (ImageView) findViewById(2131821323);
        this.iud = (ImageView) findViewById(2131821324);
        AppMethodBeat.m2505o(87290);
    }

    public final void setOnPullDownListener(C33482a c33482a) {
        this.itV = c33482a;
    }

    public final void setOnPullDownOffsetListener(C33484b c33484b) {
        this.itW = c33484b;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: pt */
    public final void mo22228pt(int i) {
        AppMethodBeat.m2504i(87293);
        if (this.itW != null) {
            this.itW.mo21652nT(i);
        }
        if (this.itX) {
            if (i > this.itY.getHeight()) {
                i = this.itY.getHeight();
            }
            LinearLayout linearLayout = this.itY;
            linearLayout.setTranslationY((float) (i - linearLayout.getHeight()));
            AppMethodBeat.m2505o(87293);
            return;
        }
        AppMethodBeat.m2505o(87293);
    }

    public final void aKe() {
        AppMethodBeat.m2504i(87294);
        long currentTimeMillis = System.currentTimeMillis() - this.iue;
        if (currentTimeMillis < 1000) {
            postDelayed(new C334831(), 1000 - currentTimeMillis);
            AppMethodBeat.m2505o(87294);
            return;
        }
        aKb();
        AppMethodBeat.m2505o(87294);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aAO() {
        AppMethodBeat.m2504i(87295);
        boolean aAO = this.isJ.aAO();
        AppMethodBeat.m2505o(87295);
        return aAO;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getStayHeight() {
        AppMethodBeat.m2504i(87296);
        int height = this.itY.getHeight();
        AppMethodBeat.m2505o(87296);
        return height;
    }

    public final void setHeadViewHeight(int i) {
        AppMethodBeat.m2504i(87297);
        if (i <= this.itY.getHeight()) {
            AppMethodBeat.m2505o(87297);
            return;
        }
        this.itY.getLayoutParams().height = i;
        this.itY.requestLayout();
        AppMethodBeat.m2505o(87297);
    }

    /* renamed from: bq */
    public final void mo53965bq(String str, int i) {
        AppMethodBeat.m2504i(87298);
        setBackgroundTextStyle(str);
        setPullDownBackgroundColor(i);
        AppMethodBeat.m2505o(87298);
    }

    public final void setBackgroundTextStyle(String str) {
        AppMethodBeat.m2504i(87299);
        if ("light".equals(str)) {
            this.iub.setImageDrawable(C33481y.m54680e(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
            this.iuc.setImageDrawable(C33481y.m54680e(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
            this.iud.setImageDrawable(C33481y.m54680e(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
            this.itZ.setTextColor(-1);
            this.itZ.setAlpha(0.4f);
            AppMethodBeat.m2505o(87299);
            return;
        }
        if ("dark".equals(str) || !"ignore".equals(str)) {
            this.iub.setImageDrawable(C33481y.m54680e(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
            this.iuc.setImageDrawable(C33481y.m54680e(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
            this.iud.setImageDrawable(C33481y.m54680e(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
            this.itZ.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.itZ.setAlpha(0.2f);
        }
        AppMethodBeat.m2505o(87299);
    }

    public final void setPullDownText(String str) {
        AppMethodBeat.m2504i(87300);
        if (C5046bo.isNullOrNil(str)) {
            this.itZ.setVisibility(8);
            AppMethodBeat.m2505o(87300);
            return;
        }
        this.itZ.setVisibility(0);
        this.itZ.setText(str);
        AppMethodBeat.m2505o(87300);
    }

    /* renamed from: dO */
    public final void mo53966dO(boolean z) {
        AppMethodBeat.m2504i(87301);
        this.itX = z;
        setNeedStay(z);
        this.iua.setVisibility(z ? 0 : 4);
        AppMethodBeat.m2505o(87301);
    }

    /* renamed from: e */
    private static AnimationDrawable m54680e(int i, float[] fArr) {
        AppMethodBeat.m2504i(87302);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(C33481y.m54681k(i, fArr[0]), 0);
        animationDrawable.addFrame(C33481y.m54681k(i, fArr[1]), 300);
        animationDrawable.addFrame(C33481y.m54681k(i, fArr[2]), 300);
        animationDrawable.addFrame(C33481y.m54681k(i, fArr[3]), 300);
        AppMethodBeat.m2505o(87302);
        return animationDrawable;
    }

    /* renamed from: k */
    private static Drawable m54681k(int i, float f) {
        AppMethodBeat.m2504i(87303);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        AppMethodBeat.m2505o(87303);
        return shapeDrawable;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKc() {
        AppMethodBeat.m2504i(87291);
        ((AnimationDrawable) this.iub.getDrawable()).start();
        ((AnimationDrawable) this.iuc.getDrawable()).start();
        ((AnimationDrawable) this.iud.getDrawable()).start();
        if (this.itV != null) {
            this.itV.aJR();
        }
        this.iue = System.currentTimeMillis();
        AppMethodBeat.m2505o(87291);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKd() {
        AppMethodBeat.m2504i(87292);
        ((AnimationDrawable) this.iub.getDrawable()).stop();
        ((AnimationDrawable) this.iub.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.iuc.getDrawable()).stop();
        ((AnimationDrawable) this.iuc.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.iud.getDrawable()).stop();
        ((AnimationDrawable) this.iud.getDrawable()).selectDrawable(0);
        AppMethodBeat.m2505o(87292);
    }
}
