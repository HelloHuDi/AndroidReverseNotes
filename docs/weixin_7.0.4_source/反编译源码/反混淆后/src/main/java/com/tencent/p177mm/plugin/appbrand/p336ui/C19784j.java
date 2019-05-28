package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.p057v4.p058a.p059a.C37111b;
import android.support.p057v4.p058a.p059a.C37112d;
import android.support.p057v4.view.p068b.C6198a;
import android.support.p057v4.view.p068b.C6199b;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.launching.C38422j;
import com.tencent.p177mm.plugin.appbrand.widget.C33575a;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C33578f.C33579a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.WeakReference;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.j */
public final class C19784j extends C7355b implements C38422j, C27333q {
    private C6750i gPI;
    private ThreeDotsLoadingView iDW;
    private TextView iFX;
    private LinearLayout iFY;
    private C10933b iFZ;
    private TextView iGc;
    private View iJh;
    private View iJi;
    /* renamed from: kU */
    private ImageView f4356kU = ((ImageView) findViewById(2131821389));

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.j$1 */
    class C197801 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.j$1$2 */
        class C197832 implements AnimatorUpdateListener {
            C197832() {
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.m2504i(102322);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C19784j.this.iFX.setTextColor(Color.argb(Math.round(255.0f * floatValue), 0, 0, 0));
                C19784j.this.iDW.setAlpha(floatValue);
                C19784j.this.f4356kU.setAlpha(floatValue);
                C19784j.this.f4356kU.setScaleY(floatValue);
                C19784j.this.f4356kU.setScaleX(floatValue);
                C19784j.this.mo15851K(-1, true);
                AppMethodBeat.m2505o(102322);
            }
        }

        C197801() {
        }

        public final void run() {
            AppMethodBeat.m2504i(102323);
            final ViewParent parent = C19784j.this.getParent();
            if (parent instanceof ViewGroup) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
                ofInt.addUpdateListener(new AnimatorUpdateListener() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.ui.j$1$1$1 */
                    class C197821 implements Runnable {
                        C197821() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(102320);
                            C19784j.this.setVisibility(8);
                            ((ViewGroup) parent).removeView(C19784j.this);
                            AppMethodBeat.m2505o(102320);
                        }
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.m2504i(102321);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        int argb = Color.argb(intValue, 255, 255, 255);
                        C19784j.this.iJh.setBackgroundColor(argb);
                        C19784j.m30615a(C19784j.this, argb);
                        if (intValue == 0) {
                            C19784j.this.post(new C197821());
                        }
                        AppMethodBeat.m2505o(102321);
                    }
                });
                ofInt.setStartDelay((long) Math.round(((float) ofInt.getDuration()) * 0.8f));
                ofInt.setDuration((long) Math.round(((float) ofInt.getDuration()) * 0.2f));
                ofInt.setInterpolator(new C6198a());
                ofInt.start();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                ofFloat.setDuration((long) Math.round(((float) ofFloat.getDuration()) * 0.8f));
                ofFloat.addUpdateListener(new C197832());
                ofFloat.setInterpolator(new C6199b());
                ofFloat.start();
                AppMethodBeat.m2505o(102323);
                return;
            }
            AppMethodBeat.m2505o(102323);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.j$2 */
    class C197852 implements OnClickListener {
        C197852() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(102324);
            C33183g.m54275a(C19784j.this.gPI.mAppId, C33184d.CLOSE);
            C19784j.this.gPI.finish();
            AppMethodBeat.m2505o(102324);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m30615a(C19784j c19784j, int i) {
        AppMethodBeat.m2504i(102332);
        super.mo15851K(i, true);
        AppMethodBeat.m2505o(102332);
    }

    /* JADX WARNING: Missing block: B:5:0x0045, code skipped:
            if (r0.isRecycled() == false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C19784j(Context context, C6750i c6750i) {
        super(context);
        AppMethodBeat.m2504i(102326);
        this.gPI = c6750i;
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(2130968738, this);
        ImageView imageView = this.f4356kU;
        if (C45708v.fpX != null) {
            Bitmap bitmap = (Bitmap) C45708v.fpX.get();
            if (bitmap != null) {
            }
        }
        C45708v.fpX = new WeakReference(BitmapFactory.decodeResource(C4996ah.getResources(), C25738R.drawable.bbn));
        C37111b a = C37112d.m62123a(C4996ah.getResources(), (Bitmap) C45708v.fpX.get());
        a.mo59157dA();
        imageView.setImageDrawable(a);
        this.iFX = (TextView) findViewById(2131821390);
        this.iDW = (ThreeDotsLoadingView) findViewById(2131821391);
        this.iFY = (LinearLayout) findViewById(2131821386);
        this.iJi = findViewById(2131821388);
        this.iJh = findViewById(2131821387);
        this.iGc = (TextView) findViewById(2131821378);
        this.iFZ = C33579a.m54831dh(getContext());
        this.iFY.addView(this.iFZ.getActionView());
        this.iFX.getLayoutParams().height = C33575a.m54827de(getContext());
        mo15851K(-1, true);
        this.iFZ.setFullscreenMode(true);
        this.iFZ.setForegroundStyle("black");
        C197852 c197852 = new C197852();
        this.iFZ.setCloseButtonClickListener(c197852);
        this.iFZ.setBackButtonClickListener(c197852);
        this.iDW.dKS();
        AppMethodBeat.m2505o(102326);
    }

    /* renamed from: cz */
    public final void mo22399cz(String str, String str2) {
        AppMethodBeat.m2504i(102327);
        C37926b.abR().mo60683a(this.f4356kU, str, null, C42201f.fqH);
        this.iFX.setText(str2);
        AppMethodBeat.m2505o(102327);
    }

    public final void aHS() {
        AppMethodBeat.m2504i(102328);
        post(new C197801());
        AppMethodBeat.m2505o(102328);
    }

    public final void aHT() {
        AppMethodBeat.m2504i(102329);
        this.iFZ.setNavHidden(true);
        AppMethodBeat.m2505o(102329);
    }

    public final View getView() {
        return this;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(102330);
        super.onAttachedToWindow();
        C42696n.m75623q(getContext(), false);
        AppMethodBeat.m2505o(102330);
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }

    public final void setProgress(int i) {
    }

    /* renamed from: nm */
    public final void mo6247nm(final int i) {
        AppMethodBeat.m2504i(102331);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102325);
                C4990ab.m7416i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + i);
                if (i == 3) {
                    C19784j.this.iGc.setVisibility(0);
                    C19784j.this.iGc.setText(C25738R.string.f9267uu);
                }
                AppMethodBeat.m2505o(102325);
            }
        });
        AppMethodBeat.m2505o(102331);
    }
}
