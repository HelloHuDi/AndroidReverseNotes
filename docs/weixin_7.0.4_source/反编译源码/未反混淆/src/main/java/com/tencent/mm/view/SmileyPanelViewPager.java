package com.tencent.mm.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.p;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.a.i;

public class SmileyPanelViewPager extends CustomViewPager {
    private a AaN;
    private boolean AaO = x.gu(getContext());
    private com.tencent.mm.view.f.a Aaj;
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    private int jiO = 0;
    private int jiP = 0;

    public interface a {
        void QA(int i);
    }

    public SmileyPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62951);
        if (bo.getInt(VERSION.SDK, 0) >= 9) {
            setOverScrollMode(2);
        }
        AppMethodBeat.o(62951);
    }

    public void setSmileyPanelViewPagerLayoutListener(a aVar) {
        this.AaN = aVar;
    }

    public void setPanelStg(com.tencent.mm.view.f.a aVar) {
        this.Aaj = aVar;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(62952);
        super.onSizeChanged(i, i2, i3, i4);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        boolean gu = x.gu(getContext());
        if (this.Aaj != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.jiO) || (i > 0 && i != this.jiP)))) {
            if (this.Aaj.jiL <= 0) {
                this.Aaj.QH(i2);
            }
            this.Aaj.jiM = i;
            this.Aaj.zyD = 0;
            if (!(this.AaN == null || (this.Aaj.Aez && !this.Aaj.AeA && this.AaO == gu))) {
                ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
                this.Aaj.AeA = false;
                this.AaN.QA(i2);
            }
        }
        this.AaO = gu;
        if (i2 > 0) {
            this.jiO = i2;
        }
        if (i > 0) {
            this.jiP = i;
        }
        AppMethodBeat.o(62952);
    }

    public void setAdapter(p pVar) {
        AppMethodBeat.i(62953);
        super.setAdapter(pVar);
        AppMethodBeat.o(62953);
    }

    public void setAdapter(i iVar) {
        AppMethodBeat.i(62954);
        if (iVar != null) {
            iVar.refreshData();
            iVar.Abw = false;
        }
        super.setAdapter(iVar);
        AppMethodBeat.o(62954);
    }
}
