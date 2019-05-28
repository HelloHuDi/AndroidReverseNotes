package com.tencent.p177mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid.C38604a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.b */
public final class C19902b extends C42745a {
    private static final int jit = C1338a.fromDPToPix(C4996ah.getContext(), 48);
    private static final int jiu = C1338a.fromDPToPix(C4996ah.getContext(), 43);

    static {
        AppMethodBeat.m2504i(134306);
        AppMethodBeat.m2505o(134306);
    }

    private int aRB() {
        AppMethodBeat.m2504i(134300);
        C27414c c27414c = this.jir;
        if (c27414c.jiM <= 1) {
            c27414c.jiM = C27414c.aMw()[0];
        }
        int i = c27414c.jiM;
        AppMethodBeat.m2505o(134300);
        return i;
    }

    public final int aRy() {
        AppMethodBeat.m2504i(134301);
        int aRt = this.jir.aRr().aRt();
        AppMethodBeat.m2505o(134301);
        return aRt;
    }

    public final int aRz() {
        AppMethodBeat.m2504i(134302);
        int aRA = aRA() * getRowCount();
        AppMethodBeat.m2505o(134302);
        return aRA;
    }

    public final int getPageCount() {
        AppMethodBeat.m2504i(134303);
        if (aRz() <= 0) {
            AppMethodBeat.m2505o(134303);
            return 0;
        }
        int ceil = (int) Math.ceil(((double) aRy()) / ((double) aRz()));
        AppMethodBeat.m2505o(134303);
        return ceil;
    }

    public final int aRA() {
        AppMethodBeat.m2504i(134304);
        if (this.jir.jiH) {
            AppMethodBeat.m2505o(134304);
            return 7;
        }
        int aRB = aRB() / jiu;
        AppMethodBeat.m2505o(134304);
        return aRB;
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.jir.jiL / jit;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }

    /* renamed from: qN */
    public final View mo35148qN(int i) {
        View view = null;
        AppMethodBeat.m2504i(134299);
        Context context = this.jiq;
        C27414c c27414c = this.jir;
        C19903d c19903d = new C19903d();
        c19903d.mIndex = i;
        c19903d.jiN = this;
        c19903d.mContext = context;
        c19903d.jir = c27414c;
        if (c19903d.mContext == null || c19903d.jiN == null) {
            AppMethodBeat.m2505o(134299);
        } else {
            view = View.inflate(c19903d.mContext, 2130968773, null);
            if (view instanceof AppBrandSmileyGrid) {
                ((AppBrandSmileyGrid) view).setPanelManager(c19903d.jir);
                AppBrandSmileyGrid appBrandSmileyGrid = (AppBrandSmileyGrid) view;
                int i2 = c19903d.mIndex;
                int aRy = c19903d.jiN.aRy();
                int aRz = c19903d.jiN.aRz();
                int aRA = c19903d.jiN.aRA();
                int rowCount = c19903d.jiN.getRowCount();
                int rowSpacing = c19903d.jiN.getRowSpacing();
                appBrandSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                appBrandSmileyGrid.setBackgroundResource(0);
                appBrandSmileyGrid.setStretchMode(2);
                appBrandSmileyGrid.setOnItemClickListener(appBrandSmileyGrid.arw);
                appBrandSmileyGrid.jiy = i2;
                appBrandSmileyGrid.jiw = aRy;
                appBrandSmileyGrid.jix = aRz;
                appBrandSmileyGrid.jiz = rowSpacing;
                appBrandSmileyGrid.jiA = aRA;
                appBrandSmileyGrid.jiB = rowCount;
                appBrandSmileyGrid.setNumColumns(aRA);
                i2 = appBrandSmileyGrid.getRowSpacing();
                rowSpacing = C1338a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                aRy = C1338a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = C1338a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                }
                appBrandSmileyGrid.setPadding(rowSpacing, i2, aRy, 0);
                appBrandSmileyGrid.jiv = new C38604a(appBrandSmileyGrid, (byte) 0);
                appBrandSmileyGrid.setAdapter(appBrandSmileyGrid.jiv);
                appBrandSmileyGrid.jiv.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(134299);
        }
        return view;
    }

    public final int getRowSpacing() {
        AppMethodBeat.m2504i(134305);
        int rowCount = (this.jir.jiL - (jit * getRowCount())) / (getRowCount() + 1);
        AppMethodBeat.m2505o(134305);
        return rowCount;
    }
}
