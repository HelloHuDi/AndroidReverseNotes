package com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input;

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
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewSmileyViewPager.C23156a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewSmileyViewPager.C23157b;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel */
public class WebViewSmileyPanel extends LinearLayout implements OnPageChangeListener, C23156a {
    /* renamed from: WL */
    View f1289WL = null;
    private boolean jgc = false;
    MMActivity jiE;
    private MMDotView jiG;
    private boolean jiH = true;
    private C4658a uKC;
    private WebViewSmileyViewPager uKD = null;
    C14685c uKz;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel$1 */
    class C46571 implements Runnable {
        C46571() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10109);
            WebViewSmileyPanel.this.onPageSelected(WebViewSmileyPanel.this.uKD.getCurrentItem());
            AppMethodBeat.m2505o(10109);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel$a */
    public interface C4658a {
        void aRg();

        void append(String str);
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageScrollStateChanged(int i) {
    }

    public final void aRC() {
        AppMethodBeat.m2504i(10111);
        if (this.uKD == null) {
            AppMethodBeat.m2505o(10111);
            return;
        }
        this.uKz.jiH = C40619x.m70075gu(getContext());
        C23157b c23157b = (C23157b) this.uKD.getAdapter();
        if (c23157b != null) {
            c23157b.jiR.clear();
            c23157b.uKz = this.uKz;
            c23157b.notifyDataSetChanged();
        } else {
            c23157b = new C23157b();
            c23157b.uKz = this.uKz;
            this.uKD.setAdapter(c23157b);
        }
        this.uKD.post(new C46571());
        AppMethodBeat.m2505o(10111);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(10112);
        super.onSizeChanged(i, i2, i3, i4);
        aRG();
        AppMethodBeat.m2505o(10112);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(10113);
        if (this.jgc) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, C8415j.INVALID_ID));
            AppMethodBeat.m2505o(10113);
            return;
        }
        C40619x.m70075gu(getContext());
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(10113);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(10114);
        init();
        AppMethodBeat.m2505o(10114);
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(10115);
        init();
        AppMethodBeat.m2505o(10115);
    }

    public void setOnTextOperationListener(C4658a c4658a) {
        this.uKC = c4658a;
        this.uKz.uKG = this.uKC;
    }

    /* Access modifiers changed, original: protected|final */
    public final C14685c getManager() {
        return this.uKz;
    }

    private void init() {
        AppMethodBeat.m2504i(10116);
        this.jiE = (MMActivity) getContext();
        this.uKz = new C14685c();
        this.uKz.jiq = getContext();
        this.uKz.uKG = this.uKC;
        AppMethodBeat.m2505o(10116);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(10117);
        if (i == 0) {
            this.jgc = false;
        } else {
            this.jgc = true;
        }
        super.setVisibility(i);
        if (!this.jgc) {
            this.jiE.aqX();
            if (this.f1289WL == null || getChildCount() <= 0) {
                if (this.f1289WL == null) {
                    this.f1289WL = View.inflate(C4996ah.getContext(), 2130971219, null);
                } else if (this.f1289WL.getParent() != null) {
                    ((ViewGroup) this.f1289WL.getParent()).removeView(this.f1289WL);
                }
                this.uKD = (WebViewSmileyViewPager) this.f1289WL.findViewById(2131821506);
                this.uKD.setOnPageChangeListener(this);
                this.uKD.setPanelManager(this.uKz);
                this.uKD.setOnSizeChangedListener(this);
                this.jiG = (MMDotView) this.f1289WL.findViewById(2131821505);
                this.jiG.setDotCount(1);
                aRG();
                addView(this.f1289WL, new LayoutParams(-1, -1));
            } else {
                this.f1289WL.setVisibility(0);
                AppMethodBeat.m2505o(10117);
                return;
            }
        }
        AppMethodBeat.m2505o(10117);
    }

    private void aRG() {
        AppMethodBeat.m2504i(10118);
        if (this.jiG == null) {
            AppMethodBeat.m2505o(10118);
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
        AppMethodBeat.m2505o(10118);
    }

    public void onPageSelected(int i) {
        AppMethodBeat.m2504i(10110);
        C40349a ddb = this.uKz.ddb();
        int pageCount = ddb.getPageCount();
        int i2 = i - ddb.jis;
        if (pageCount <= 1) {
            this.jiG.setVisibility(4);
            AppMethodBeat.m2505o(10110);
            return;
        }
        this.jiG.setVisibility(0);
        this.jiG.setDotCount(pageCount);
        this.jiG.setSelectedDot(i2);
        AppMethodBeat.m2505o(10110);
    }
}
