package com.tencent.mm.plugin.appbrand.widget.actionbar;

import a.f.b.j;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class b extends LinearLayout implements f {
    protected CircleProgressDrawable iUA;
    protected AppBrandOptionButton iUB;
    protected AppBrandCapsuleHomeButton iUC;
    protected LinearLayout iUD;
    protected ImageView iUE;
    protected int iUF;
    protected int iUG;
    protected double iUH;
    protected boolean iUI = false;
    protected boolean iUJ = false;
    protected c iUK = new c();
    private e iUL;
    private a iUM;
    private final Set<a> iUN = new LinkedHashSet();
    private boolean iUO = false;
    private AppBrandActionBarCustomImageView iUP;
    protected ImageView iUu;
    protected View iUv;
    protected View iUw;
    protected TextView iUx;
    protected TextView iUy;
    protected ProgressBar iUz;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b$4 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ Bitmap val$bitmap;
        final /* synthetic */ OnClickListener val$listener;

        public AnonymousClass4(Bitmap bitmap, OnClickListener onClickListener) {
            this.val$bitmap = bitmap;
            this.val$listener = onClickListener;
        }

        public final void run() {
            AppMethodBeat.i(87452);
            b.this.iUP.setVisibility(0);
            b.this.iUP.setImageBitmap(this.val$bitmap);
            b.this.iUP.setClickable(true);
            b.this.iUP.setOnClickListener(this.val$listener);
            AppMethodBeat.o(87452);
        }
    }

    public interface a {
        void a(ImageView imageView, View view);
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(87453);
        setOrientation(1);
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(R.color.dt);
        addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.be, this, false));
        this.iUF = -1;
        this.iUG = getResources().getColor(R.color.dt);
        this.iUH = 1.0d;
        this.iUu = (ImageView) findViewById(R.id.oo);
        this.iUv = findViewById(R.id.on);
        this.iUw = findViewById(R.id.ov);
        this.iUx = (TextView) findViewById(R.id.ox);
        this.iUy = (TextView) findViewById(R.id.oy);
        this.iUz = (ProgressBar) findViewById(R.id.oz);
        this.iUA = new CircleProgressDrawable();
        this.iUB = (AppBrandOptionButton) findViewById(R.id.or);
        this.iUC = (AppBrandCapsuleHomeButton) findViewById(R.id.ot);
        this.iUD = (LinearLayout) findViewById(R.id.oq);
        this.iUP = (AppBrandActionBarCustomImageView) findViewById(R.id.ou);
        this.iUE = (ImageView) findViewById(R.id.os);
        this.iUL = new e();
        e eVar = this.iUL;
        AppBrandOptionButton appBrandOptionButton = this.iUB;
        j.p(appBrandOptionButton, "button");
        eVar.iUZ = appBrandOptionButton;
        this.iUv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(87449);
                b.this.iUK.cA(b.this.iUv);
                AppMethodBeat.o(87449);
            }
        });
        this.iUC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Object obj;
                AppMethodBeat.i(87450);
                c cVar = b.this.iUK;
                AppBrandCapsuleHomeButton appBrandCapsuleHomeButton = b.this.iUC;
                if (cVar.iUS.isEmpty()) {
                    obj = null;
                } else {
                    Iterator it = cVar.iUS.iterator();
                    while (it.hasNext()) {
                        ((OnClickListener) it.next()).onClick(appBrandCapsuleHomeButton);
                    }
                    obj = 1;
                }
                if (obj == null) {
                    b.this.iUK.cA(b.this.iUC);
                }
                AppMethodBeat.o(87450);
            }
        });
        this.iUB.setAccessibilityLabel(getContext().getString(R.string.g_));
        this.iUC.setAccessibilityLabel(getContext().getString(R.string.g6));
        AppMethodBeat.o(87453);
    }

    public void setBackButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(87454);
        this.iUK.iUT.add(onClickListener);
        AppMethodBeat.o(87454);
    }

    public void setCloseButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(87455);
        this.iUK.iUS.add(onClickListener);
        AppMethodBeat.o(87455);
    }

    public void setCapsuleHomeButtonLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(87456);
        this.iUC.setOnLongClickListener(onLongClickListener);
        AppMethodBeat.o(87456);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(87457);
        this.iUN.add(aVar);
        if (!this.iUO) {
            aOH();
            this.iUO = true;
        }
        AppMethodBeat.o(87457);
    }

    public void setMainTitle(String str) {
        AppMethodBeat.i(87458);
        boolean isLayoutRequested = isLayoutRequested();
        this.iUx.setText(str);
        if (isLayoutRequested) {
            requestLayout();
        }
        AppMethodBeat.o(87458);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(87459);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(87459);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(87460);
        super.onMeasure(i, i2);
        AppMethodBeat.o(87460);
    }

    public CharSequence getMainTitle() {
        AppMethodBeat.i(87461);
        CharSequence text = this.iUx.getText();
        AppMethodBeat.o(87461);
        return text;
    }

    public void setSubTitle(String str) {
        AppMethodBeat.i(87462);
        if (bo.isNullOrNil(str)) {
            this.iUy.setVisibility(8);
        } else {
            this.iUy.setVisibility(0);
            this.iUy.setText(str);
        }
        this.iUy.clearAnimation();
        AppMethodBeat.o(87462);
    }

    private void aOH() {
        AppMethodBeat.i(87463);
        this.iUw.setOnClickListener(new OnClickListener() {
            private long iUR = 0;

            public final void onClick(View view) {
                AppMethodBeat.i(87451);
                if (System.currentTimeMillis() - this.iUR < 250) {
                    for (a aGw : b.this.iUN) {
                        aGw.aGw();
                    }
                    this.iUR = 0;
                }
                this.iUR = System.currentTimeMillis();
                AppMethodBeat.o(87451);
            }
        });
        AppMethodBeat.o(87463);
    }

    public double getBackgroundAlpha() {
        return this.iUH;
    }

    public void setBackgroundAlpha(double d) {
        AppMethodBeat.i(87464);
        this.iUH = d;
        if (!this.iUJ) {
            super.getBackground().setAlpha((int) (255.0d * d));
        }
        AppMethodBeat.o(87464);
    }

    public void setBackgroundColor(int i) {
        AppMethodBeat.i(87465);
        this.iUG = i;
        if (this.iUJ) {
            super.setBackgroundColor(0);
        } else {
            super.setBackgroundColor(i);
        }
        setBackgroundAlpha(this.iUH);
        AppMethodBeat.o(87465);
    }

    public final int getBackgroundColor() {
        if (this.iUJ) {
            return 0;
        }
        return this.iUG;
    }

    public void setOptionButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(87466);
        this.iUB.setOnClickListener(onClickListener);
        AppMethodBeat.o(87466);
    }

    public final void eP(boolean z) {
        AppMethodBeat.i(87467);
        if (z) {
            this.iUD.setVisibility(0);
            AppMethodBeat.o(87467);
            return;
        }
        this.iUD.setVisibility(8);
        AppMethodBeat.o(87467);
    }

    public final boolean aOI() {
        AppMethodBeat.i(87468);
        if (this.iUD.getVisibility() == 0) {
            AppMethodBeat.o(87468);
            return true;
        }
        AppMethodBeat.o(87468);
        return false;
    }

    public final void aOJ() {
        AppMethodBeat.i(87469);
        this.iUB.reset();
        this.iUC.reset();
        aOL();
        AppMethodBeat.o(87469);
    }

    public void setForegroundStyle(String str) {
        AppMethodBeat.i(87470);
        this.iUF = com.tencent.mm.plugin.appbrand.page.a.d.a.Dk(str).ivl;
        aOK();
        AppMethodBeat.o(87470);
    }

    public void setForegroundStyle(boolean z) {
        AppMethodBeat.i(87471);
        this.iUF = z ? WebView.NIGHT_MODE_COLOR : -1;
        aOK();
        AppMethodBeat.o(87471);
    }

    public void setForegroundColor(int i) {
        AppMethodBeat.i(87472);
        this.iUF = i;
        aOK();
        AppMethodBeat.o(87472);
    }

    public int getForegroundColor() {
        return this.iUF;
    }

    private void aOK() {
        AppMethodBeat.i(87473);
        if (this.iUM == null) {
            this.iUu.setImageResource(R.drawable.auq);
            this.iUu.setColorFilter(this.iUF, Mode.SRC_ATOP);
        } else {
            this.iUM.a(this.iUu, this.iUv);
        }
        this.iUx.setTextColor(this.iUF);
        this.iUy.setTextColor(this.iUF);
        this.iUA.setStrokeColor(this.iUF);
        this.iUz.setLayerType(1, null);
        this.iUz.setIndeterminateDrawable(this.iUA);
        aOL();
        qg(this.iUF);
        AppMethodBeat.o(87473);
    }

    private void qg(int i) {
        AppMethodBeat.i(87474);
        if (i == -1) {
            this.iUE.setImageResource(R.color.ez);
            this.iUD.setBackgroundResource(R.drawable.bs);
            AppMethodBeat.o(87474);
            return;
        }
        this.iUE.setImageResource(R.color.f0);
        this.iUD.setBackgroundResource(R.drawable.bt);
        AppMethodBeat.o(87474);
    }

    private void aOL() {
        AppMethodBeat.i(87475);
        if (this.iUF == -1) {
            this.iUB.setColor(-1);
            this.iUC.setColor(-1);
            AppMethodBeat.o(87475);
            return;
        }
        this.iUB.setColor(WebView.NIGHT_MODE_COLOR);
        this.iUC.setColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(87475);
    }

    public void setNavBackOrClose(boolean z) {
        AppMethodBeat.i(87476);
        aOK();
        AppMethodBeat.o(87476);
    }

    public void setNavHidden(boolean z) {
        AppMethodBeat.i(87477);
        this.iUI = z;
        aOM();
        AppMethodBeat.o(87477);
    }

    private void aOM() {
        AppMethodBeat.i(87478);
        View view = this.iUv;
        int i = (this.iUJ || this.iUI) ? 8 : 0;
        view.setVisibility(i);
        requestLayout();
        AppMethodBeat.o(87478);
    }

    public void setLoadingIconVisibility(boolean z) {
        AppMethodBeat.i(87479);
        this.iUz.setVisibility(z ? 0 : 8);
        if (z) {
            CircleProgressDrawable circleProgressDrawable = this.iUA;
            circleProgressDrawable.uC.clear();
            ArrayList arrayList = circleProgressDrawable.uC;
            RingPathTransform ringPathTransform = circleProgressDrawable.iTZ;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ringPathTransform, "trimPathStart", new float[]{0.0f, 0.75f});
            ofFloat.setDuration(1333);
            ofFloat.setInterpolator(c.iUa);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathEnd", new float[]{0.0f, 0.75f});
            ofFloat2.setDuration(1333);
            ofFloat2.setInterpolator(com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.b.iUa);
            ofFloat2.setRepeatCount(-1);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathOffset", new float[]{0.0f, 0.25f});
            ofFloat3.setDuration(1333);
            ofFloat3.setInterpolator(com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.a.iUa);
            ofFloat3.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            arrayList.add(animatorSet);
            ArrayList arrayList2 = circleProgressDrawable.uC;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(circleProgressDrawable.jbC, "rotation", new float[]{0.0f, 720.0f});
            ofFloat4.setDuration(6665);
            ofFloat4.setInterpolator(com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.a.iUa);
            ofFloat4.setRepeatCount(-1);
            arrayList2.add(ofFloat4);
            this.iUA.start();
            AppMethodBeat.o(87479);
            return;
        }
        this.iUA.stop();
        AppMethodBeat.o(87479);
    }

    public com.tencent.mm.plugin.appbrand.page.a.b getCapsuleBar() {
        return this.iUL;
    }

    public View getActionView() {
        return this;
    }

    public View getCapsuleView() {
        return this.iUD;
    }

    public final boolean isFullscreenMode() {
        return this.iUJ;
    }

    public void setFullscreenMode(boolean z) {
        AppMethodBeat.i(87480);
        this.iUJ = z;
        aOM();
        this.iUw.setVisibility(this.iUJ ? 4 : 0);
        requestLayout();
        setBackgroundColor(this.iUG);
        AppMethodBeat.o(87480);
    }

    public final void aON() {
        AppMethodBeat.i(87481);
        this.iUv.setVisibility(0);
        requestLayout();
        AppMethodBeat.o(87481);
    }

    public void setNavResetStyleListener(a aVar) {
        this.iUM = aVar;
    }
}
