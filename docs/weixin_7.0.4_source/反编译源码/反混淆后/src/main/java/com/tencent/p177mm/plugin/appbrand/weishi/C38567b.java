package com.tencent.p177mm.plugin.appbrand.weishi;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.p057v4.view.p068b.C6198a;
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
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27333q;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b.C10937a;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C33578f.C33579a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.svg.p610a.C5147a;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.weishi.b */
public final class C38567b extends FrameLayout implements C27333q {
    private C6750i gPI;
    private C10933b iFZ;
    private ImageView iTN = ((ImageView) findViewById(2131821218));
    private View iTQ = findViewById(2131821385);

    /* renamed from: com.tencent.mm.plugin.appbrand.weishi.b$2 */
    class C109302 implements OnClickListener {
        C109302() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133624);
            C4990ab.m7416i("MicroMsg.AppBrandThumbLoadingSplash", "thumb click close button");
            C33572e.aOz();
            if (C38567b.this.gPI != null) {
                C33183g.m54275a(C38567b.this.gPI.mAppId, C33184d.CLOSE);
                C38567b.this.gPI.close();
            }
            AppMethodBeat.m2505o(133624);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.weishi.b$1 */
    class C273531 implements C10937a {
        C273531() {
        }

        /* renamed from: a */
        public final void mo22217a(ImageView imageView, View view) {
            AppMethodBeat.m2504i(133623);
            if (imageView != null) {
                imageView.clearColorFilter();
                imageView.setImageDrawable(C5147a.m7837f(C38567b.this.getContext().getResources(), C1318a.app_brand_weishi_video_btn_close));
            }
            if (view != null) {
                view.setBackground(null);
            }
            AppMethodBeat.m2505o(133623);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.weishi.b$4 */
    class C385684 implements Runnable {
        C385684() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133629);
            final ViewParent parent = C38567b.this.getParent();
            if (parent instanceof ViewGroup) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
                ofInt.addUpdateListener(new AnimatorUpdateListener() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.weishi.b$4$1$1 */
                    class C109311 implements Runnable {
                        C109311() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(133627);
                            C38567b.this.setVisibility(8);
                            ((ViewGroup) parent).removeView(C38567b.this);
                            AppMethodBeat.m2505o(133627);
                        }
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.m2504i(133628);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        C38567b.this.iTQ.setBackgroundColor(Color.argb(intValue, 0, 0, 0));
                        if (intValue == 0) {
                            C38567b.this.post(new C109311());
                        }
                        AppMethodBeat.m2505o(133628);
                    }
                });
                ofInt.setStartDelay((long) Math.round(((float) ofInt.getDuration()) * 0.8f));
                ofInt.setDuration((long) Math.round(((float) ofInt.getDuration()) * 0.2f));
                ofInt.setInterpolator(new C6198a());
                ofInt.start();
                AppMethodBeat.m2505o(133629);
                return;
            }
            AppMethodBeat.m2505o(133629);
        }
    }

    public C38567b(Context context, C6750i c6750i) {
        super(context);
        AppMethodBeat.m2504i(133630);
        this.gPI = c6750i;
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(2130968737, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131821386);
        this.iFZ = C33579a.m54831dh(getContext());
        linearLayout.addView(this.iFZ.getActionView());
        this.iFZ.setNavResetStyleListener(new C273531());
        this.iFZ.setFullscreenMode(true);
        this.iFZ.setForegroundStyle(false);
        this.iFZ.mo22482eP(false);
        this.iFZ.aON();
        this.iFZ.setBackButtonClickListener(new C109302());
        if (this.gPI != null && (this.gPI.mo15035yf() instanceof AppBrandInitConfigLU)) {
            AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) this.gPI.mo15035yf();
            String str = appBrandInitConfigLU.bQj.thumbUrl;
            String str2 = appBrandInitConfigLU.bQj.ijv;
            C4990ab.m7417i("MicroMsg.AppBrandThumbLoadingSplash", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", str, str2);
            if (!C5046bo.isNullOrNil(str)) {
                m65331cV(str, "file://".concat(String.valueOf(str2)));
                AppMethodBeat.m2505o(133630);
                return;
            } else if (!C5046bo.isNullOrNil(str2)) {
                m65331cV("file://".concat(String.valueOf(str2)), null);
            }
        }
        AppMethodBeat.m2505o(133630);
    }

    /* renamed from: cV */
    private void m65331cV(String str, final String str2) {
        AppMethodBeat.m2504i(133631);
        C4990ab.m7417i("MicroMsg.AppBrandThumbLoadingSplash", "loadThumbImage:%s", str);
        C37926b.abR().mo60686a(new C9676i() {
            public final void abU() {
            }

            /* renamed from: x */
            public final void mo6524x(Bitmap bitmap) {
                AppMethodBeat.m2504i(133625);
                C4990ab.m7416i("MicroMsg.AppBrandThumbLoadingSplash", "splash thumb loaded");
                C38567b.m65328a(C38567b.this, bitmap);
                AppMethodBeat.m2505o(133625);
            }

            /* renamed from: mr */
            public final void mo6522mr() {
                AppMethodBeat.m2504i(133626);
                C4990ab.m7412e("MicroMsg.AppBrandThumbLoadingSplash", "splash thumb loaded fail");
                if (str2 != null) {
                    C38567b.m65329a(C38567b.this, str2);
                }
                AppMethodBeat.m2505o(133626);
            }

            /* renamed from: wP */
            public final String mo6523wP() {
                return "AppBrandWeishiLoadingSplash#THUMB";
            }
        }, str, null, null);
        AppMethodBeat.m2505o(133631);
    }

    public final void aHS() {
        AppMethodBeat.m2504i(133632);
        post(new C385684());
        AppMethodBeat.m2505o(133632);
    }

    /* renamed from: cz */
    public final void mo22399cz(String str, String str2) {
    }

    public final void aHT() {
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }
}
