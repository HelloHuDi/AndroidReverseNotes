package com.tencent.p177mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MMDotView;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.C11031b;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.C36741a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase */
public class AppBrandSmileyPanelBase extends LinearLayout implements OnPageChangeListener, C11031b {
    /* renamed from: WL */
    private View f16156WL = null;
    private boolean jgc = false;
    private C19904f jiD;
    private MMActivity jiE;
    private AppBrandSmileyViewPager jiF = null;
    private MMDotView jiG;
    private boolean jiH = true;
    private C27414c jir;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase$1 */
    class C386051 implements Runnable {
        C386051() {
        }

        public final void run() {
            AppMethodBeat.m2504i(134312);
            AppBrandSmileyPanelBase.this.onPageSelected(AppBrandSmileyPanelBase.this.jiF.getCurrentItem());
            AppMethodBeat.m2505o(134312);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageScrollStateChanged(int i) {
    }

    public final void aRC() {
        AppMethodBeat.m2504i(134314);
        if (this.jiF == null) {
            AppMethodBeat.m2505o(134314);
            return;
        }
        this.jir.jiH = C40619x.m70075gu(getContext());
        C36741a c36741a = (C36741a) this.jiF.getAdapter();
        if (c36741a != null) {
            c36741a.jiR.clear();
            c36741a.jir = this.jir;
            c36741a.notifyDataSetChanged();
        } else {
            c36741a = new C36741a();
            c36741a.jir = this.jir;
            this.jiF.setAdapter(c36741a);
        }
        this.jiF.post(new C386051());
        AppMethodBeat.m2505o(134314);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(134315);
        super.onSizeChanged(i, i2, i3, i4);
        aRG();
        AppMethodBeat.m2505o(134315);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(134316);
        if (this.jgc) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, C8415j.INVALID_ID));
            AppMethodBeat.m2505o(134316);
            return;
        }
        C40619x.m70075gu(getContext());
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(134316);
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"WrongCall"})
    /* renamed from: du */
    public final void mo61393du(int i, int i2) {
        AppMethodBeat.m2504i(134317);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(134317);
    }

    public AppBrandSmileyPanelBase(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(134318);
        init();
        AppMethodBeat.m2505o(134318);
    }

    public AppBrandSmileyPanelBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134319);
        init();
        AppMethodBeat.m2505o(134319);
    }

    public void setOnTextOperationListener(C19904f c19904f) {
        this.jiD = c19904f;
        this.jir.jiK = this.jiD;
    }

    /* Access modifiers changed, original: protected|final */
    public final C27414c getManager() {
        return this.jir;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(134320);
        C27414c c27414c = this.jir;
        c27414c.jiJ = null;
        c27414c.jiq = null;
        if (this.f16156WL != null) {
            ((ViewGroup) this.f16156WL.getParent()).removeView(this.f16156WL);
            ((ViewGroup) this.f16156WL).removeAllViews();
            this.f16156WL = null;
        }
        this.jiE = null;
        AppMethodBeat.m2505o(134320);
    }

    public final void aRD() {
        AppMethodBeat.m2504i(134321);
        if (this.f16156WL != null) {
            this.f16156WL.setVisibility(0);
        }
        AppMethodBeat.m2505o(134321);
    }

    public final void aRE() {
        AppMethodBeat.m2504i(134322);
        if (this.f16156WL != null) {
            this.f16156WL.setVisibility(4);
        }
        AppMethodBeat.m2505o(134322);
    }

    private void init() {
        AppMethodBeat.m2504i(134323);
        this.jiE = (MMActivity) C5546d.m8371cY(getContext());
        this.jir = aQY();
        this.jir.jiq = getContext();
        this.jir.jiK = this.jiD;
        AppMethodBeat.m2505o(134323);
    }

    /* Access modifiers changed, original: protected */
    public C27414c aQY() {
        AppMethodBeat.m2504i(134324);
        C27414c c27414c = new C27414c();
        AppMethodBeat.m2505o(134324);
        return c27414c;
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(134325);
        if (i == 0) {
            this.jgc = false;
        } else {
            this.jgc = true;
        }
        super.setVisibility(i);
        if (!this.jgc) {
            this.jiE.aqX();
            initView();
        }
        AppMethodBeat.m2505o(134325);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: qG */
    public final void mo61399qG(int i) {
        AppMethodBeat.m2504i(134326);
        super.setVisibility(i);
        AppMethodBeat.m2505o(134326);
    }

    private void aRF() {
        AppMethodBeat.m2504i(134327);
        this.f16156WL.setVisibility(0);
        AppMethodBeat.m2505o(134327);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.m2504i(134328);
        if (this.f16156WL == null || getChildCount() <= 0) {
            if (this.f16156WL == null) {
                this.f16156WL = View.inflate(C4996ah.getContext(), 2130968772, null);
            } else if (this.f16156WL.getParent() != null) {
                ((ViewGroup) this.f16156WL.getParent()).removeView(this.f16156WL);
            }
            this.jiF = (AppBrandSmileyViewPager) this.f16156WL.findViewById(2131821506);
            this.jiF.setOnPageChangeListener(this);
            this.jiF.setPanelManager(this.jir);
            this.jiF.setOnSizeChangedListener(this);
            this.jiG = (MMDotView) this.f16156WL.findViewById(2131821505);
            this.jiG.setDotCount(1);
            aRG();
            addView(this.f16156WL, new LayoutParams(-1, -1));
            AppMethodBeat.m2505o(134328);
            return;
        }
        aRF();
        AppMethodBeat.m2505o(134328);
    }

    private void aRG() {
        AppMethodBeat.m2504i(134329);
        if (this.jiG == null) {
            AppMethodBeat.m2505o(134329);
            return;
        }
        boolean gu = C40619x.m70075gu(getContext());
        if (gu != this.jiH) {
            RelativeLayout.LayoutParams layoutParams;
            if (gu) {
                this.jiG.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9966lo));
                layoutParams = (RelativeLayout.LayoutParams) this.jiG.getLayoutParams();
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(C25738R.dimen.a15);
                this.jiG.setLayoutParams(layoutParams);
            } else {
                this.jiG.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9958le));
                layoutParams = (RelativeLayout.LayoutParams) this.jiG.getLayoutParams();
                layoutParams.bottomMargin = 0;
                this.jiG.setLayoutParams(layoutParams);
            }
            this.jiH = gu;
        }
        AppMethodBeat.m2505o(134329);
    }

    public void onPageSelected(int i) {
        AppMethodBeat.m2504i(134313);
        C42745a aRH = this.jir.aRH();
        int pageCount = aRH.getPageCount();
        int i2 = i - aRH.jis;
        if (pageCount <= 1) {
            this.jiG.setVisibility(4);
            AppMethodBeat.m2505o(134313);
            return;
        }
        this.jiG.setVisibility(0);
        this.jiG.setDotCount(pageCount);
        this.jiG.setSelectedDot(i2);
        AppMethodBeat.m2505o(134313);
    }
}
