package com.tencent.mm.plugin.appbrand.weishi;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ui.q;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"ViewConstructor"})
public final class b extends FrameLayout implements q {
    private i gPI;
    private com.tencent.mm.plugin.appbrand.widget.actionbar.b iFZ;
    private ImageView iTN = ((ImageView) findViewById(R.id.ri));
    private View iTQ = findViewById(R.id.w1);

    public b(Context context, i iVar) {
        super(context);
        AppMethodBeat.i(133630);
        this.gPI = iVar;
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.dn, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.w2);
        this.iFZ = a.dh(getContext());
        linearLayout.addView(this.iFZ.getActionView());
        this.iFZ.setNavResetStyleListener(new com.tencent.mm.plugin.appbrand.widget.actionbar.b.a() {
            public final void a(ImageView imageView, View view) {
                AppMethodBeat.i(133623);
                if (imageView != null) {
                    imageView.clearColorFilter();
                    imageView.setImageDrawable(com.tencent.mm.svg.a.a.f(b.this.getContext().getResources(), R.raw.app_brand_weishi_video_btn_close));
                }
                if (view != null) {
                    view.setBackground(null);
                }
                AppMethodBeat.o(133623);
            }
        });
        this.iFZ.setFullscreenMode(true);
        this.iFZ.setForegroundStyle(false);
        this.iFZ.eP(false);
        this.iFZ.aON();
        this.iFZ.setBackButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133624);
                ab.i("MicroMsg.AppBrandThumbLoadingSplash", "thumb click close button");
                e.aOz();
                if (b.this.gPI != null) {
                    g.a(b.this.gPI.mAppId, d.CLOSE);
                    b.this.gPI.close();
                }
                AppMethodBeat.o(133624);
            }
        });
        if (this.gPI != null && (this.gPI.yf() instanceof AppBrandInitConfigLU)) {
            AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) this.gPI.yf();
            String str = appBrandInitConfigLU.bQj.thumbUrl;
            String str2 = appBrandInitConfigLU.bQj.ijv;
            ab.i("MicroMsg.AppBrandThumbLoadingSplash", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", str, str2);
            if (!bo.isNullOrNil(str)) {
                cV(str, "file://".concat(String.valueOf(str2)));
                AppMethodBeat.o(133630);
                return;
            } else if (!bo.isNullOrNil(str2)) {
                cV("file://".concat(String.valueOf(str2)), null);
            }
        }
        AppMethodBeat.o(133630);
    }

    private void cV(String str, final String str2) {
        AppMethodBeat.i(133631);
        ab.i("MicroMsg.AppBrandThumbLoadingSplash", "loadThumbImage:%s", str);
        com.tencent.mm.modelappbrand.a.b.abR().a(new com.tencent.mm.modelappbrand.a.b.i() {
            public final void abU() {
            }

            public final void x(Bitmap bitmap) {
                AppMethodBeat.i(133625);
                ab.i("MicroMsg.AppBrandThumbLoadingSplash", "splash thumb loaded");
                b.a(b.this, bitmap);
                AppMethodBeat.o(133625);
            }

            public final void mr() {
                AppMethodBeat.i(133626);
                ab.e("MicroMsg.AppBrandThumbLoadingSplash", "splash thumb loaded fail");
                if (str2 != null) {
                    b.a(b.this, str2);
                }
                AppMethodBeat.o(133626);
            }

            public final String wP() {
                return "AppBrandWeishiLoadingSplash#THUMB";
            }
        }, str, null, null);
        AppMethodBeat.o(133631);
    }

    public final void aHS() {
        AppMethodBeat.i(133632);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133629);
                final ViewParent parent = b.this.getParent();
                if (parent instanceof ViewGroup) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
                    ofInt.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(133628);
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            b.this.iTQ.setBackgroundColor(Color.argb(intValue, 0, 0, 0));
                            if (intValue == 0) {
                                b.this.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(133627);
                                        b.this.setVisibility(8);
                                        ((ViewGroup) parent).removeView(b.this);
                                        AppMethodBeat.o(133627);
                                    }
                                });
                            }
                            AppMethodBeat.o(133628);
                        }
                    });
                    ofInt.setStartDelay((long) Math.round(((float) ofInt.getDuration()) * 0.8f));
                    ofInt.setDuration((long) Math.round(((float) ofInt.getDuration()) * 0.2f));
                    ofInt.setInterpolator(new android.support.v4.view.b.a());
                    ofInt.start();
                    AppMethodBeat.o(133629);
                    return;
                }
                AppMethodBeat.o(133629);
            }
        });
        AppMethodBeat.o(133632);
    }

    public final void cz(String str, String str2) {
    }

    public final void aHT() {
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }
}
