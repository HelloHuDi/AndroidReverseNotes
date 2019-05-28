package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.statusbar.d;

public class AppBrandSmileyPanelBase extends LinearLayout implements OnPageChangeListener, b {
    private View WL = null;
    private boolean jgc = false;
    private f jiD;
    private MMActivity jiE;
    private AppBrandSmileyViewPager jiF = null;
    private MMDotView jiG;
    private boolean jiH = true;
    private c jir;

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageScrollStateChanged(int i) {
    }

    public final void aRC() {
        AppMethodBeat.i(134314);
        if (this.jiF == null) {
            AppMethodBeat.o(134314);
            return;
        }
        this.jir.jiH = x.gu(getContext());
        a aVar = (a) this.jiF.getAdapter();
        if (aVar != null) {
            aVar.jiR.clear();
            aVar.jir = this.jir;
            aVar.notifyDataSetChanged();
        } else {
            aVar = new a();
            aVar.jir = this.jir;
            this.jiF.setAdapter(aVar);
        }
        this.jiF.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(134312);
                AppBrandSmileyPanelBase.this.onPageSelected(AppBrandSmileyPanelBase.this.jiF.getCurrentItem());
                AppMethodBeat.o(134312);
            }
        });
        AppMethodBeat.o(134314);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(134315);
        super.onSizeChanged(i, i2, i3, i4);
        aRG();
        AppMethodBeat.o(134315);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(134316);
        if (this.jgc) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, j.INVALID_ID));
            AppMethodBeat.o(134316);
            return;
        }
        x.gu(getContext());
        super.onMeasure(i, i2);
        AppMethodBeat.o(134316);
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"WrongCall"})
    public final void du(int i, int i2) {
        AppMethodBeat.i(134317);
        super.onMeasure(i, i2);
        AppMethodBeat.o(134317);
    }

    public AppBrandSmileyPanelBase(Context context) {
        super(context, null);
        AppMethodBeat.i(134318);
        init();
        AppMethodBeat.o(134318);
    }

    public AppBrandSmileyPanelBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134319);
        init();
        AppMethodBeat.o(134319);
    }

    public void setOnTextOperationListener(f fVar) {
        this.jiD = fVar;
        this.jir.jiK = this.jiD;
    }

    /* Access modifiers changed, original: protected|final */
    public final c getManager() {
        return this.jir;
    }

    public final void onDestroy() {
        AppMethodBeat.i(134320);
        c cVar = this.jir;
        cVar.jiJ = null;
        cVar.jiq = null;
        if (this.WL != null) {
            ((ViewGroup) this.WL.getParent()).removeView(this.WL);
            ((ViewGroup) this.WL).removeAllViews();
            this.WL = null;
        }
        this.jiE = null;
        AppMethodBeat.o(134320);
    }

    public final void aRD() {
        AppMethodBeat.i(134321);
        if (this.WL != null) {
            this.WL.setVisibility(0);
        }
        AppMethodBeat.o(134321);
    }

    public final void aRE() {
        AppMethodBeat.i(134322);
        if (this.WL != null) {
            this.WL.setVisibility(4);
        }
        AppMethodBeat.o(134322);
    }

    private void init() {
        AppMethodBeat.i(134323);
        this.jiE = (MMActivity) d.cY(getContext());
        this.jir = aQY();
        this.jir.jiq = getContext();
        this.jir.jiK = this.jiD;
        AppMethodBeat.o(134323);
    }

    /* Access modifiers changed, original: protected */
    public c aQY() {
        AppMethodBeat.i(134324);
        c cVar = new c();
        AppMethodBeat.o(134324);
        return cVar;
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(134325);
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
        AppMethodBeat.o(134325);
    }

    /* Access modifiers changed, original: protected|final */
    public final void qG(int i) {
        AppMethodBeat.i(134326);
        super.setVisibility(i);
        AppMethodBeat.o(134326);
    }

    private void aRF() {
        AppMethodBeat.i(134327);
        this.WL.setVisibility(0);
        AppMethodBeat.o(134327);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.i(134328);
        if (this.WL == null || getChildCount() <= 0) {
            if (this.WL == null) {
                this.WL = View.inflate(ah.getContext(), R.layout.el, null);
            } else if (this.WL.getParent() != null) {
                ((ViewGroup) this.WL.getParent()).removeView(this.WL);
            }
            this.jiF = (AppBrandSmileyViewPager) this.WL.findViewById(R.id.yz);
            this.jiF.setOnPageChangeListener(this);
            this.jiF.setPanelManager(this.jir);
            this.jiF.setOnSizeChangedListener(this);
            this.jiG = (MMDotView) this.WL.findViewById(R.id.yy);
            this.jiG.setDotCount(1);
            aRG();
            addView(this.WL, new LayoutParams(-1, -1));
            AppMethodBeat.o(134328);
            return;
        }
        aRF();
        AppMethodBeat.o(134328);
    }

    private void aRG() {
        AppMethodBeat.i(134329);
        if (this.jiG == null) {
            AppMethodBeat.o(134329);
            return;
        }
        boolean gu = x.gu(getContext());
        if (gu != this.jiH) {
            RelativeLayout.LayoutParams layoutParams;
            if (gu) {
                this.jiG.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.lo));
                layoutParams = (RelativeLayout.LayoutParams) this.jiG.getLayoutParams();
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.a15);
                this.jiG.setLayoutParams(layoutParams);
            } else {
                this.jiG.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.le));
                layoutParams = (RelativeLayout.LayoutParams) this.jiG.getLayoutParams();
                layoutParams.bottomMargin = 0;
                this.jiG.setLayoutParams(layoutParams);
            }
            this.jiH = gu;
        }
        AppMethodBeat.o(134329);
    }

    public void onPageSelected(int i) {
        AppMethodBeat.i(134313);
        a aRH = this.jir.aRH();
        int pageCount = aRH.getPageCount();
        int i2 = i - aRH.jis;
        if (pageCount <= 1) {
            this.jiG.setVisibility(4);
            AppMethodBeat.o(134313);
            return;
        }
        this.jiG.setVisibility(0);
        this.jiG.setDotCount(pageCount);
        this.jiG.setSelectedDot(i2);
        AppMethodBeat.o(134313);
    }
}
