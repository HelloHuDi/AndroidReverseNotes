package com.tencent.p177mm.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p057v4.view.C25365p;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.CustomViewPager;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.view.p1097f.C16067a;
import com.tencent.p177mm.view.p645a.C16042i;

/* renamed from: com.tencent.mm.view.SmileyPanelViewPager */
public class SmileyPanelViewPager extends CustomViewPager {
    private C16036a AaN;
    private boolean AaO = C40619x.m70075gu(getContext());
    private C16067a Aaj;
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    private int jiO = 0;
    private int jiP = 0;

    /* renamed from: com.tencent.mm.view.SmileyPanelViewPager$a */
    public interface C16036a {
        /* renamed from: QA */
        void mo28398QA(int i);
    }

    public SmileyPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(62951);
        if (C5046bo.getInt(VERSION.SDK, 0) >= 9) {
            setOverScrollMode(2);
        }
        AppMethodBeat.m2505o(62951);
    }

    public void setSmileyPanelViewPagerLayoutListener(C16036a c16036a) {
        this.AaN = c16036a;
    }

    public void setPanelStg(C16067a c16067a) {
        this.Aaj = c16067a;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(62952);
        super.onSizeChanged(i, i2, i3, i4);
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        boolean gu = C40619x.m70075gu(getContext());
        if (this.Aaj != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.jiO) || (i > 0 && i != this.jiP)))) {
            if (this.Aaj.jiL <= 0) {
                this.Aaj.mo28455QH(i2);
            }
            this.Aaj.jiM = i;
            this.Aaj.zyD = 0;
            if (!(this.AaN == null || (this.Aaj.Aez && !this.Aaj.AeA && this.AaO == gu))) {
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
                this.Aaj.AeA = false;
                this.AaN.mo28398QA(i2);
            }
        }
        this.AaO = gu;
        if (i2 > 0) {
            this.jiO = i2;
        }
        if (i > 0) {
            this.jiP = i;
        }
        AppMethodBeat.m2505o(62952);
    }

    public void setAdapter(C25365p c25365p) {
        AppMethodBeat.m2504i(62953);
        super.setAdapter(c25365p);
        AppMethodBeat.m2505o(62953);
    }

    public void setAdapter(C16042i c16042i) {
        AppMethodBeat.m2504i(62954);
        if (c16042i != null) {
            c16042i.refreshData();
            c16042i.Abw = false;
        }
        super.setAdapter(c16042i);
        AppMethodBeat.m2505o(62954);
    }
}
