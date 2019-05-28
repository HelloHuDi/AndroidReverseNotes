package com.tencent.p177mm.plugin.appbrand.widget.actionbar;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C27217d.C10657a;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C45662b;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.p177mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.p177mm.plugin.appbrand.widget.CircleProgressDrawable.C2510b;
import com.tencent.p177mm.plugin.appbrand.widget.CircleProgressDrawable.C2511c;
import com.tencent.p177mm.plugin.appbrand.widget.CircleProgressDrawable.C2512a;
import com.tencent.p177mm.plugin.appbrand.widget.CircleProgressDrawable.RingPathTransform;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b */
public class C10933b extends LinearLayout implements C33578f {
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
    protected C10938c iUK = new C10938c();
    private C33576e iUL;
    private C10937a iUM;
    private final Set<C27354a> iUN = new LinkedHashSet();
    private boolean iUO = false;
    private AppBrandActionBarCustomImageView iUP;
    protected ImageView iUu;
    protected View iUv;
    protected View iUw;
    protected TextView iUx;
    protected TextView iUy;
    protected ProgressBar iUz;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b$1 */
    class C109321 implements OnClickListener {
        C109321() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(87449);
            C10933b.this.iUK.mo22512cA(C10933b.this.iUv);
            AppMethodBeat.m2505o(87449);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b$2 */
    class C109342 implements OnClickListener {
        C109342() {
        }

        public final void onClick(View view) {
            Object obj;
            AppMethodBeat.m2504i(87450);
            C10938c c10938c = C10933b.this.iUK;
            AppBrandCapsuleHomeButton appBrandCapsuleHomeButton = C10933b.this.iUC;
            if (c10938c.iUS.isEmpty()) {
                obj = null;
            } else {
                Iterator it = c10938c.iUS.iterator();
                while (it.hasNext()) {
                    ((OnClickListener) it.next()).onClick(appBrandCapsuleHomeButton);
                }
                obj = 1;
            }
            if (obj == null) {
                C10933b.this.iUK.mo22512cA(C10933b.this.iUC);
            }
            AppMethodBeat.m2505o(87450);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b$3 */
    class C109353 implements OnClickListener {
        private long iUR = 0;

        C109353() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(87451);
            if (System.currentTimeMillis() - this.iUR < 250) {
                for (C27354a aGw : C10933b.this.iUN) {
                    aGw.aGw();
                }
                this.iUR = 0;
            }
            this.iUR = System.currentTimeMillis();
            AppMethodBeat.m2505o(87451);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b$4 */
    public class C109364 implements Runnable {
        final /* synthetic */ Bitmap val$bitmap;
        final /* synthetic */ OnClickListener val$listener;

        public C109364(Bitmap bitmap, OnClickListener onClickListener) {
            this.val$bitmap = bitmap;
            this.val$listener = onClickListener;
        }

        public final void run() {
            AppMethodBeat.m2504i(87452);
            C10933b.this.iUP.setVisibility(0);
            C10933b.this.iUP.setImageBitmap(this.val$bitmap);
            C10933b.this.iUP.setClickable(true);
            C10933b.this.iUP.setOnClickListener(this.val$listener);
            AppMethodBeat.m2505o(87452);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b$a */
    public interface C10937a {
        /* renamed from: a */
        void mo22217a(ImageView imageView, View view);
    }

    public C10933b(Context context) {
        super(context);
        AppMethodBeat.m2504i(87453);
        setOrientation(1);
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(C25738R.color.f11695dt);
        addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130968654, this, false));
        this.iUF = -1;
        this.iUG = getResources().getColor(C25738R.color.f11695dt);
        this.iUH = 1.0d;
        this.iUu = (ImageView) findViewById(2131821113);
        this.iUv = findViewById(2131821112);
        this.iUw = findViewById(2131821120);
        this.iUx = (TextView) findViewById(2131821122);
        this.iUy = (TextView) findViewById(2131821123);
        this.iUz = (ProgressBar) findViewById(2131821124);
        this.iUA = new CircleProgressDrawable();
        this.iUB = (AppBrandOptionButton) findViewById(2131821116);
        this.iUC = (AppBrandCapsuleHomeButton) findViewById(2131821118);
        this.iUD = (LinearLayout) findViewById(2131821115);
        this.iUP = (AppBrandActionBarCustomImageView) findViewById(2131821119);
        this.iUE = (ImageView) findViewById(2131821117);
        this.iUL = new C33576e();
        C33576e c33576e = this.iUL;
        AppBrandOptionButton appBrandOptionButton = this.iUB;
        C25052j.m39376p(appBrandOptionButton, "button");
        c33576e.iUZ = appBrandOptionButton;
        this.iUv.setOnClickListener(new C109321());
        this.iUC.setOnClickListener(new C109342());
        this.iUB.setAccessibilityLabel(getContext().getString(C25738R.string.f8832g_));
        this.iUC.setAccessibilityLabel(getContext().getString(C25738R.string.f8828g6));
        AppMethodBeat.m2505o(87453);
    }

    public void setBackButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(87454);
        this.iUK.iUT.add(onClickListener);
        AppMethodBeat.m2505o(87454);
    }

    public void setCloseButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(87455);
        this.iUK.iUS.add(onClickListener);
        AppMethodBeat.m2505o(87455);
    }

    public void setCapsuleHomeButtonLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.m2504i(87456);
        this.iUC.setOnLongClickListener(onLongClickListener);
        AppMethodBeat.m2505o(87456);
    }

    /* renamed from: a */
    public final void mo22478a(C27354a c27354a) {
        AppMethodBeat.m2504i(87457);
        this.iUN.add(c27354a);
        if (!this.iUO) {
            aOH();
            this.iUO = true;
        }
        AppMethodBeat.m2505o(87457);
    }

    public void setMainTitle(String str) {
        AppMethodBeat.m2504i(87458);
        boolean isLayoutRequested = isLayoutRequested();
        this.iUx.setText(str);
        if (isLayoutRequested) {
            requestLayout();
        }
        AppMethodBeat.m2505o(87458);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(87459);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(87459);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(87460);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(87460);
    }

    public CharSequence getMainTitle() {
        AppMethodBeat.m2504i(87461);
        CharSequence text = this.iUx.getText();
        AppMethodBeat.m2505o(87461);
        return text;
    }

    public void setSubTitle(String str) {
        AppMethodBeat.m2504i(87462);
        if (C5046bo.isNullOrNil(str)) {
            this.iUy.setVisibility(8);
        } else {
            this.iUy.setVisibility(0);
            this.iUy.setText(str);
        }
        this.iUy.clearAnimation();
        AppMethodBeat.m2505o(87462);
    }

    private void aOH() {
        AppMethodBeat.m2504i(87463);
        this.iUw.setOnClickListener(new C109353());
        AppMethodBeat.m2505o(87463);
    }

    public double getBackgroundAlpha() {
        return this.iUH;
    }

    public void setBackgroundAlpha(double d) {
        AppMethodBeat.m2504i(87464);
        this.iUH = d;
        if (!this.iUJ) {
            super.getBackground().setAlpha((int) (255.0d * d));
        }
        AppMethodBeat.m2505o(87464);
    }

    public void setBackgroundColor(int i) {
        AppMethodBeat.m2504i(87465);
        this.iUG = i;
        if (this.iUJ) {
            super.setBackgroundColor(0);
        } else {
            super.setBackgroundColor(i);
        }
        setBackgroundAlpha(this.iUH);
        AppMethodBeat.m2505o(87465);
    }

    public final int getBackgroundColor() {
        if (this.iUJ) {
            return 0;
        }
        return this.iUG;
    }

    public void setOptionButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(87466);
        this.iUB.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(87466);
    }

    /* renamed from: eP */
    public final void mo22482eP(boolean z) {
        AppMethodBeat.m2504i(87467);
        if (z) {
            this.iUD.setVisibility(0);
            AppMethodBeat.m2505o(87467);
            return;
        }
        this.iUD.setVisibility(8);
        AppMethodBeat.m2505o(87467);
    }

    public final boolean aOI() {
        AppMethodBeat.m2504i(87468);
        if (this.iUD.getVisibility() == 0) {
            AppMethodBeat.m2505o(87468);
            return true;
        }
        AppMethodBeat.m2505o(87468);
        return false;
    }

    public final void aOJ() {
        AppMethodBeat.m2504i(87469);
        this.iUB.reset();
        this.iUC.reset();
        aOL();
        AppMethodBeat.m2505o(87469);
    }

    public void setForegroundStyle(String str) {
        AppMethodBeat.m2504i(87470);
        this.iUF = C10657a.m18353Dk(str).ivl;
        aOK();
        AppMethodBeat.m2505o(87470);
    }

    public void setForegroundStyle(boolean z) {
        AppMethodBeat.m2504i(87471);
        this.iUF = z ? WebView.NIGHT_MODE_COLOR : -1;
        aOK();
        AppMethodBeat.m2505o(87471);
    }

    public void setForegroundColor(int i) {
        AppMethodBeat.m2504i(87472);
        this.iUF = i;
        aOK();
        AppMethodBeat.m2505o(87472);
    }

    public int getForegroundColor() {
        return this.iUF;
    }

    private void aOK() {
        AppMethodBeat.m2504i(87473);
        if (this.iUM == null) {
            this.iUu.setImageResource(C25738R.drawable.auq);
            this.iUu.setColorFilter(this.iUF, Mode.SRC_ATOP);
        } else {
            this.iUM.mo22217a(this.iUu, this.iUv);
        }
        this.iUx.setTextColor(this.iUF);
        this.iUy.setTextColor(this.iUF);
        this.iUA.setStrokeColor(this.iUF);
        this.iUz.setLayerType(1, null);
        this.iUz.setIndeterminateDrawable(this.iUA);
        aOL();
        m18663qg(this.iUF);
        AppMethodBeat.m2505o(87473);
    }

    /* renamed from: qg */
    private void m18663qg(int i) {
        AppMethodBeat.m2504i(87474);
        if (i == -1) {
            this.iUE.setImageResource(C25738R.color.f11728ez);
            this.iUD.setBackgroundResource(C25738R.drawable.f6365bs);
            AppMethodBeat.m2505o(87474);
            return;
        }
        this.iUE.setImageResource(C25738R.color.f11729f0);
        this.iUD.setBackgroundResource(C25738R.drawable.f6366bt);
        AppMethodBeat.m2505o(87474);
    }

    private void aOL() {
        AppMethodBeat.m2504i(87475);
        if (this.iUF == -1) {
            this.iUB.setColor(-1);
            this.iUC.setColor(-1);
            AppMethodBeat.m2505o(87475);
            return;
        }
        this.iUB.setColor(WebView.NIGHT_MODE_COLOR);
        this.iUC.setColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.m2505o(87475);
    }

    public void setNavBackOrClose(boolean z) {
        AppMethodBeat.m2504i(87476);
        aOK();
        AppMethodBeat.m2505o(87476);
    }

    public void setNavHidden(boolean z) {
        AppMethodBeat.m2504i(87477);
        this.iUI = z;
        aOM();
        AppMethodBeat.m2505o(87477);
    }

    private void aOM() {
        AppMethodBeat.m2504i(87478);
        View view = this.iUv;
        int i = (this.iUJ || this.iUI) ? 8 : 0;
        view.setVisibility(i);
        requestLayout();
        AppMethodBeat.m2505o(87478);
    }

    public void setLoadingIconVisibility(boolean z) {
        AppMethodBeat.m2504i(87479);
        this.iUz.setVisibility(z ? 0 : 8);
        if (z) {
            CircleProgressDrawable circleProgressDrawable = this.iUA;
            circleProgressDrawable.f1251uC.clear();
            ArrayList arrayList = circleProgressDrawable.f1251uC;
            RingPathTransform ringPathTransform = circleProgressDrawable.iTZ;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ringPathTransform, "trimPathStart", new float[]{0.0f, 0.75f});
            ofFloat.setDuration(1333);
            ofFloat.setInterpolator(C2511c.iUa);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathEnd", new float[]{0.0f, 0.75f});
            ofFloat2.setDuration(1333);
            ofFloat2.setInterpolator(C2510b.iUa);
            ofFloat2.setRepeatCount(-1);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathOffset", new float[]{0.0f, 0.25f});
            ofFloat3.setDuration(1333);
            ofFloat3.setInterpolator(C2512a.iUa);
            ofFloat3.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            arrayList.add(animatorSet);
            ArrayList arrayList2 = circleProgressDrawable.f1251uC;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(circleProgressDrawable.jbC, "rotation", new float[]{0.0f, 720.0f});
            ofFloat4.setDuration(6665);
            ofFloat4.setInterpolator(C2512a.iUa);
            ofFloat4.setRepeatCount(-1);
            arrayList2.add(ofFloat4);
            this.iUA.start();
            AppMethodBeat.m2505o(87479);
            return;
        }
        this.iUA.stop();
        AppMethodBeat.m2505o(87479);
    }

    public C45662b getCapsuleBar() {
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
        AppMethodBeat.m2504i(87480);
        this.iUJ = z;
        aOM();
        this.iUw.setVisibility(this.iUJ ? 4 : 0);
        requestLayout();
        setBackgroundColor(this.iUG);
        AppMethodBeat.m2505o(87480);
    }

    public final void aON() {
        AppMethodBeat.m2504i(87481);
        this.iUv.setVisibility(0);
        requestLayout();
        AppMethodBeat.m2505o(87481);
    }

    public void setNavResetStyleListener(C10937a c10937a) {
        this.iUM = c10937a;
    }
}
