package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.a.a.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.lang.ref.WeakReference;

@SuppressLint({"ViewConstructor"})
public final class j extends b implements com.tencent.mm.plugin.appbrand.launching.j, q {
    private i gPI;
    private ThreeDotsLoadingView iDW;
    private TextView iFX;
    private LinearLayout iFY;
    private com.tencent.mm.plugin.appbrand.widget.actionbar.b iFZ;
    private TextView iGc;
    private View iJh;
    private View iJi;
    private ImageView kU = ((ImageView) findViewById(R.id.w5));

    static /* synthetic */ void a(j jVar, int i) {
        AppMethodBeat.i(102332);
        super.K(i, true);
        AppMethodBeat.o(102332);
    }

    /* JADX WARNING: Missing block: B:5:0x0045, code skipped:
            if (r0.isRecycled() == false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(Context context, i iVar) {
        super(context);
        AppMethodBeat.i(102326);
        this.gPI = iVar;
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.f9do, this);
        ImageView imageView = this.kU;
        if (v.fpX != null) {
            Bitmap bitmap = (Bitmap) v.fpX.get();
            if (bitmap != null) {
            }
        }
        v.fpX = new WeakReference(BitmapFactory.decodeResource(ah.getResources(), R.drawable.bbn));
        android.support.v4.a.a.b a = d.a(ah.getResources(), (Bitmap) v.fpX.get());
        a.dA();
        imageView.setImageDrawable(a);
        this.iFX = (TextView) findViewById(R.id.w6);
        this.iDW = (ThreeDotsLoadingView) findViewById(R.id.w7);
        this.iFY = (LinearLayout) findViewById(R.id.w2);
        this.iJi = findViewById(R.id.w4);
        this.iJh = findViewById(R.id.w3);
        this.iGc = (TextView) findViewById(R.id.vu);
        this.iFZ = a.dh(getContext());
        this.iFY.addView(this.iFZ.getActionView());
        this.iFX.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.a.de(getContext());
        K(-1, true);
        this.iFZ.setFullscreenMode(true);
        this.iFZ.setForegroundStyle("black");
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(102324);
                g.a(j.this.gPI.mAppId, g.d.CLOSE);
                j.this.gPI.finish();
                AppMethodBeat.o(102324);
            }
        };
        this.iFZ.setCloseButtonClickListener(anonymousClass2);
        this.iFZ.setBackButtonClickListener(anonymousClass2);
        this.iDW.dKS();
        AppMethodBeat.o(102326);
    }

    public final void cz(String str, String str2) {
        AppMethodBeat.i(102327);
        com.tencent.mm.modelappbrand.a.b.abR().a(this.kU, str, null, f.fqH);
        this.iFX.setText(str2);
        AppMethodBeat.o(102327);
    }

    public final void aHS() {
        AppMethodBeat.i(102328);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102323);
                final ViewParent parent = j.this.getParent();
                if (parent instanceof ViewGroup) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
                    ofInt.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(102321);
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            int argb = Color.argb(intValue, 255, 255, 255);
                            j.this.iJh.setBackgroundColor(argb);
                            j.a(j.this, argb);
                            if (intValue == 0) {
                                j.this.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(102320);
                                        j.this.setVisibility(8);
                                        ((ViewGroup) parent).removeView(j.this);
                                        AppMethodBeat.o(102320);
                                    }
                                });
                            }
                            AppMethodBeat.o(102321);
                        }
                    });
                    ofInt.setStartDelay((long) Math.round(((float) ofInt.getDuration()) * 0.8f));
                    ofInt.setDuration((long) Math.round(((float) ofInt.getDuration()) * 0.2f));
                    ofInt.setInterpolator(new android.support.v4.view.b.a());
                    ofInt.start();
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                    ofFloat.setDuration((long) Math.round(((float) ofFloat.getDuration()) * 0.8f));
                    ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(102322);
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            j.this.iFX.setTextColor(Color.argb(Math.round(255.0f * floatValue), 0, 0, 0));
                            j.this.iDW.setAlpha(floatValue);
                            j.this.kU.setAlpha(floatValue);
                            j.this.kU.setScaleY(floatValue);
                            j.this.kU.setScaleX(floatValue);
                            j.this.K(-1, true);
                            AppMethodBeat.o(102322);
                        }
                    });
                    ofFloat.setInterpolator(new android.support.v4.view.b.b());
                    ofFloat.start();
                    AppMethodBeat.o(102323);
                    return;
                }
                AppMethodBeat.o(102323);
            }
        });
        AppMethodBeat.o(102328);
    }

    public final void aHT() {
        AppMethodBeat.i(102329);
        this.iFZ.setNavHidden(true);
        AppMethodBeat.o(102329);
    }

    public final View getView() {
        return this;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(102330);
        super.onAttachedToWindow();
        n.q(getContext(), false);
        AppMethodBeat.o(102330);
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }

    public final void setProgress(int i) {
    }

    public final void nm(final int i) {
        AppMethodBeat.i(102331);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102325);
                ab.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + i);
                if (i == 3) {
                    j.this.iGc.setVisibility(0);
                    j.this.iGc.setText(R.string.uu);
                }
                AppMethodBeat.o(102325);
            }
        });
        AppMethodBeat.o(102331);
    }
}
