package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C13431a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.p1026a.C39764c;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart */
public class RadarChart extends Chart {
    private Context context;
    public ArrayList<C13431a> qYj;
    private C39764c qYk = new C39764c();
    public TextView qYl;
    private RadarGrid qYm;
    private RadarDataLayer[] qYn;
    private C21940a qYo;
    private boolean qYp = true;
    private boolean qYq = true;
    public int qYr = 3;
    public int qYs = 0;
    private int qYt = 4;
    public Spannable[] qYu;
    private float qYv = 1.0f;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(36958);
        this.context = context;
        AppMethodBeat.m2505o(36958);
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(36959);
        this.context = context;
        AppMethodBeat.m2505o(36959);
    }

    public void setData(C13431a... c13431aArr) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(36960);
        removeAllViews();
        for (C13431a size : c13431aArr) {
            if (size.size() <= 0) {
                Exception exception = new Exception("Not enough elements.");
                AppMethodBeat.m2505o(36960);
                throw exception;
            }
        }
        for (C13431a size2 : c13431aArr) {
            i = 0;
            while (i < c13431aArr.length) {
                if (size2.mo25506a(c13431aArr[i])) {
                    i++;
                } else {
                    Error error = new Error("Layer not compatible.");
                    AppMethodBeat.m2505o(36960);
                    throw error;
                }
            }
        }
        this.qYu = c13431aArr[0].cpi();
        this.qYs = c13431aArr[0].size();
        if (this.qYj == null) {
            this.qYj = new ArrayList();
        }
        for (Object add : c13431aArr) {
            this.qYj.add(add);
        }
        this.qYm = new RadarGrid(this.context, this.qYs, this.qYt, this.qYv, this.qYu, this.qYk);
        addView(this.qYm);
        this.qYn = new RadarDataLayer[this.qYr];
        while (i2 < this.qYn.length && this.qYj.size() > i2) {
            this.qYn[i2] = new RadarDataLayer(this.context, this.qYv, (C13431a) this.qYj.get(i2));
            addView(this.qYn[i2]);
            i2++;
        }
        if (this.qYo == null) {
            this.qYo = new C21940a(this.context, this.qYk);
        }
        addView(this.qYo);
        AppMethodBeat.m2505o(36960);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(36961);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
        AppMethodBeat.m2505o(36961);
    }

    public void setLatitudeNum(int i) {
        this.qYt = i;
    }

    public void setGridStyle(C39764c c39764c) {
        AppMethodBeat.m2504i(36962);
        this.qYk = c39764c;
        if (this.qYm != null) {
            this.qYm.setGridStyle(c39764c);
        }
        AppMethodBeat.m2505o(36962);
    }

    public C39764c getGridStyle() {
        AppMethodBeat.m2504i(36963);
        C39764c c39764c;
        if (this.qYm == null) {
            c39764c = this.qYk;
            AppMethodBeat.m2505o(36963);
            return c39764c;
        }
        this.qYk = this.qYm.getGridStyle();
        c39764c = this.qYm.getGridStyle();
        AppMethodBeat.m2505o(36963);
        return c39764c;
    }
}
