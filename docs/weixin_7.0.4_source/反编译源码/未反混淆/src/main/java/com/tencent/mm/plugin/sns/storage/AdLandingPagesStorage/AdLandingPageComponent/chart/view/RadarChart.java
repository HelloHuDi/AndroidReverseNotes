package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart extends Chart {
    private Context context;
    public ArrayList<a> qYj;
    private c qYk = new c();
    public TextView qYl;
    private RadarGrid qYm;
    private RadarDataLayer[] qYn;
    private a qYo;
    private boolean qYp = true;
    private boolean qYq = true;
    public int qYr = 3;
    public int qYs = 0;
    private int qYt = 4;
    public Spannable[] qYu;
    private float qYv = 1.0f;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(36958);
        this.context = context;
        AppMethodBeat.o(36958);
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(36959);
        this.context = context;
        AppMethodBeat.o(36959);
    }

    public void setData(a... aVarArr) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(36960);
        removeAllViews();
        for (a size : aVarArr) {
            if (size.size() <= 0) {
                Exception exception = new Exception("Not enough elements.");
                AppMethodBeat.o(36960);
                throw exception;
            }
        }
        for (a size2 : aVarArr) {
            i = 0;
            while (i < aVarArr.length) {
                if (size2.a(aVarArr[i])) {
                    i++;
                } else {
                    Error error = new Error("Layer not compatible.");
                    AppMethodBeat.o(36960);
                    throw error;
                }
            }
        }
        this.qYu = aVarArr[0].cpi();
        this.qYs = aVarArr[0].size();
        if (this.qYj == null) {
            this.qYj = new ArrayList();
        }
        for (Object add : aVarArr) {
            this.qYj.add(add);
        }
        this.qYm = new RadarGrid(this.context, this.qYs, this.qYt, this.qYv, this.qYu, this.qYk);
        addView(this.qYm);
        this.qYn = new RadarDataLayer[this.qYr];
        while (i2 < this.qYn.length && this.qYj.size() > i2) {
            this.qYn[i2] = new RadarDataLayer(this.context, this.qYv, (a) this.qYj.get(i2));
            addView(this.qYn[i2]);
            i2++;
        }
        if (this.qYo == null) {
            this.qYo = new a(this.context, this.qYk);
        }
        addView(this.qYo);
        AppMethodBeat.o(36960);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(36961);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
        AppMethodBeat.o(36961);
    }

    public void setLatitudeNum(int i) {
        this.qYt = i;
    }

    public void setGridStyle(c cVar) {
        AppMethodBeat.i(36962);
        this.qYk = cVar;
        if (this.qYm != null) {
            this.qYm.setGridStyle(cVar);
        }
        AppMethodBeat.o(36962);
    }

    public c getGridStyle() {
        AppMethodBeat.i(36963);
        c cVar;
        if (this.qYm == null) {
            cVar = this.qYk;
            AppMethodBeat.o(36963);
            return cVar;
        }
        this.qYk = this.qYm.getGridStyle();
        cVar = this.qYm.getGridStyle();
        AppMethodBeat.o(36963);
        return cVar;
    }
}
