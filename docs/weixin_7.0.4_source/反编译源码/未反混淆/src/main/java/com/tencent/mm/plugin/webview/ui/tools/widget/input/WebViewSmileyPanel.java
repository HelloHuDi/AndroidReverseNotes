package com.tencent.mm.plugin.webview.ui.tools.widget.input;

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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel extends LinearLayout implements OnPageChangeListener, com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.a {
    View WL = null;
    private boolean jgc = false;
    MMActivity jiE;
    private MMDotView jiG;
    private boolean jiH = true;
    private a uKC;
    private WebViewSmileyViewPager uKD = null;
    c uKz;

    public interface a {
        void aRg();

        void append(String str);
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageScrollStateChanged(int i) {
    }

    public final void aRC() {
        AppMethodBeat.i(10111);
        if (this.uKD == null) {
            AppMethodBeat.o(10111);
            return;
        }
        this.uKz.jiH = x.gu(getContext());
        b bVar = (b) this.uKD.getAdapter();
        if (bVar != null) {
            bVar.jiR.clear();
            bVar.uKz = this.uKz;
            bVar.notifyDataSetChanged();
        } else {
            bVar = new b();
            bVar.uKz = this.uKz;
            this.uKD.setAdapter(bVar);
        }
        this.uKD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(10109);
                WebViewSmileyPanel.this.onPageSelected(WebViewSmileyPanel.this.uKD.getCurrentItem());
                AppMethodBeat.o(10109);
            }
        });
        AppMethodBeat.o(10111);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(10112);
        super.onSizeChanged(i, i2, i3, i4);
        aRG();
        AppMethodBeat.o(10112);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(10113);
        if (this.jgc) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, j.INVALID_ID));
            AppMethodBeat.o(10113);
            return;
        }
        x.gu(getContext());
        super.onMeasure(i, i2);
        AppMethodBeat.o(10113);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        AppMethodBeat.i(10114);
        init();
        AppMethodBeat.o(10114);
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(10115);
        init();
        AppMethodBeat.o(10115);
    }

    public void setOnTextOperationListener(a aVar) {
        this.uKC = aVar;
        this.uKz.uKG = this.uKC;
    }

    /* Access modifiers changed, original: protected|final */
    public final c getManager() {
        return this.uKz;
    }

    private void init() {
        AppMethodBeat.i(10116);
        this.jiE = (MMActivity) getContext();
        this.uKz = new c();
        this.uKz.jiq = getContext();
        this.uKz.uKG = this.uKC;
        AppMethodBeat.o(10116);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(10117);
        if (i == 0) {
            this.jgc = false;
        } else {
            this.jgc = true;
        }
        super.setVisibility(i);
        if (!this.jgc) {
            this.jiE.aqX();
            if (this.WL == null || getChildCount() <= 0) {
                if (this.WL == null) {
                    this.WL = View.inflate(ah.getContext(), R.layout.b7i, null);
                } else if (this.WL.getParent() != null) {
                    ((ViewGroup) this.WL.getParent()).removeView(this.WL);
                }
                this.uKD = (WebViewSmileyViewPager) this.WL.findViewById(R.id.yz);
                this.uKD.setOnPageChangeListener(this);
                this.uKD.setPanelManager(this.uKz);
                this.uKD.setOnSizeChangedListener(this);
                this.jiG = (MMDotView) this.WL.findViewById(R.id.yy);
                this.jiG.setDotCount(1);
                aRG();
                addView(this.WL, new LayoutParams(-1, -1));
            } else {
                this.WL.setVisibility(0);
                AppMethodBeat.o(10117);
                return;
            }
        }
        AppMethodBeat.o(10117);
    }

    private void aRG() {
        AppMethodBeat.i(10118);
        if (this.jiG == null) {
            AppMethodBeat.o(10118);
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
        AppMethodBeat.o(10118);
    }

    public void onPageSelected(int i) {
        AppMethodBeat.i(10110);
        a ddb = this.uKz.ddb();
        int pageCount = ddb.getPageCount();
        int i2 = i - ddb.jis;
        if (pageCount <= 1) {
            this.jiG.setVisibility(4);
            AppMethodBeat.o(10110);
            return;
        }
        this.jiG.setVisibility(0);
        this.jiG.setDotCount(pageCount);
        this.jiG.setSelectedDot(i2);
        AppMethodBeat.o(10110);
    }
}
