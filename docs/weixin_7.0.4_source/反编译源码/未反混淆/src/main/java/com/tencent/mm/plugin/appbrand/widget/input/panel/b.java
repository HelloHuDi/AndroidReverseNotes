package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class b extends a {
    private static final int jit = a.fromDPToPix(ah.getContext(), 48);
    private static final int jiu = a.fromDPToPix(ah.getContext(), 43);

    static {
        AppMethodBeat.i(134306);
        AppMethodBeat.o(134306);
    }

    private int aRB() {
        AppMethodBeat.i(134300);
        c cVar = this.jir;
        if (cVar.jiM <= 1) {
            cVar.jiM = c.aMw()[0];
        }
        int i = cVar.jiM;
        AppMethodBeat.o(134300);
        return i;
    }

    public final int aRy() {
        AppMethodBeat.i(134301);
        int aRt = this.jir.aRr().aRt();
        AppMethodBeat.o(134301);
        return aRt;
    }

    public final int aRz() {
        AppMethodBeat.i(134302);
        int aRA = aRA() * getRowCount();
        AppMethodBeat.o(134302);
        return aRA;
    }

    public final int getPageCount() {
        AppMethodBeat.i(134303);
        if (aRz() <= 0) {
            AppMethodBeat.o(134303);
            return 0;
        }
        int ceil = (int) Math.ceil(((double) aRy()) / ((double) aRz()));
        AppMethodBeat.o(134303);
        return ceil;
    }

    public final int aRA() {
        AppMethodBeat.i(134304);
        if (this.jir.jiH) {
            AppMethodBeat.o(134304);
            return 7;
        }
        int aRB = aRB() / jiu;
        AppMethodBeat.o(134304);
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

    public final View qN(int i) {
        View view = null;
        AppMethodBeat.i(134299);
        Context context = this.jiq;
        c cVar = this.jir;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.jiN = this;
        dVar.mContext = context;
        dVar.jir = cVar;
        if (dVar.mContext == null || dVar.jiN == null) {
            AppMethodBeat.o(134299);
        } else {
            view = View.inflate(dVar.mContext, R.layout.em, null);
            if (view instanceof AppBrandSmileyGrid) {
                ((AppBrandSmileyGrid) view).setPanelManager(dVar.jir);
                AppBrandSmileyGrid appBrandSmileyGrid = (AppBrandSmileyGrid) view;
                int i2 = dVar.mIndex;
                int aRy = dVar.jiN.aRy();
                int aRz = dVar.jiN.aRz();
                int aRA = dVar.jiN.aRA();
                int rowCount = dVar.jiN.getRowCount();
                int rowSpacing = dVar.jiN.getRowSpacing();
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
                rowSpacing = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                aRy = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(appBrandSmileyGrid.getContext(), 6);
                }
                appBrandSmileyGrid.setPadding(rowSpacing, i2, aRy, 0);
                appBrandSmileyGrid.jiv = new a(appBrandSmileyGrid, (byte) 0);
                appBrandSmileyGrid.setAdapter(appBrandSmileyGrid.jiv);
                appBrandSmileyGrid.jiv.notifyDataSetChanged();
            }
            AppMethodBeat.o(134299);
        }
        return view;
    }

    public final int getRowSpacing() {
        AppMethodBeat.i(134305);
        int rowCount = (this.jir.jiL - (jit * getRowCount())) / (getRowCount() + 1);
        AppMethodBeat.o(134305);
        return rowCount;
    }
}
