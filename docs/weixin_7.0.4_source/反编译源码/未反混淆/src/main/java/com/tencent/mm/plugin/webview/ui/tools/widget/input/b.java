package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.cb.e;
import com.tencent.mm.sdk.platformtools.ah;

public final class b extends a {
    private static final int jit = a.fromDPToPix(ah.getContext(), 48);
    private static final int jiu = a.fromDPToPix(ah.getContext(), 43);

    static {
        AppMethodBeat.i(10103);
        AppMethodBeat.o(10103);
    }

    private int aRB() {
        AppMethodBeat.i(10097);
        c cVar = this.uKz;
        if (cVar.jiM <= 1) {
            r2 = new int[2];
            Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
            r2[0] = defaultDisplay.getWidth();
            r2[1] = defaultDisplay.getHeight();
            cVar.jiM = r2[0];
        }
        int i = cVar.jiM;
        AppMethodBeat.o(10097);
        return i;
    }

    public final int aRz() {
        AppMethodBeat.i(10099);
        int aRA = aRA() * getRowCount();
        AppMethodBeat.o(10099);
        return aRA;
    }

    public final int getPageCount() {
        AppMethodBeat.i(10100);
        if (aRz() <= 0) {
            AppMethodBeat.o(10100);
            return 0;
        }
        int ceil = (int) Math.ceil(((double) e.dqK().aRt()) / ((double) aRz()));
        AppMethodBeat.o(10100);
        return ceil;
    }

    public final int aRA() {
        AppMethodBeat.i(10101);
        if (this.uKz.jiH) {
            AppMethodBeat.o(10101);
            return 7;
        }
        int aRB = aRB() / jiu;
        AppMethodBeat.o(10101);
        return aRB;
    }

    public final int getRowCount() {
        int i = 3;
        int i2 = this.uKz.jiL / jit;
        if (i2 <= 3) {
            i = i2;
        }
        return i <= 0 ? 1 : i;
    }

    public final View qN(int i) {
        View view = null;
        AppMethodBeat.i(10096);
        Context context = this.jiq;
        c cVar = this.uKz;
        d dVar = new d();
        dVar.mIndex = i;
        dVar.uKH = this;
        dVar.mContext = context;
        dVar.uKz = cVar;
        if (dVar.mContext == null || dVar.uKH == null) {
            AppMethodBeat.o(10096);
        } else {
            view = View.inflate(dVar.mContext, R.layout.b7j, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).setPanelManager(dVar.uKz);
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i2 = dVar.mIndex;
                int aRy = dVar.uKH.aRy();
                int aRz = dVar.uKH.aRz();
                int aRA = dVar.uKH.aRA();
                int rowCount = dVar.uKH.getRowCount();
                int rowSpacing = dVar.uKH.getRowSpacing();
                webViewSmileyGrid.setLayoutParams(new LayoutParams(-1, -1));
                webViewSmileyGrid.setBackgroundResource(0);
                webViewSmileyGrid.setStretchMode(2);
                webViewSmileyGrid.setOnItemClickListener(webViewSmileyGrid.arw);
                webViewSmileyGrid.jiy = i2;
                webViewSmileyGrid.jiw = aRy;
                webViewSmileyGrid.jix = aRz;
                webViewSmileyGrid.jiz = rowSpacing;
                webViewSmileyGrid.jiA = aRA;
                webViewSmileyGrid.jiB = rowCount;
                webViewSmileyGrid.setNumColumns(aRA);
                i2 = webViewSmileyGrid.getRowSpacing();
                rowSpacing = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                aRy = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(rowSpacing, i2, aRy, 0);
                webViewSmileyGrid.uKA = new a(webViewSmileyGrid, (byte) 0);
                webViewSmileyGrid.setAdapter(webViewSmileyGrid.uKA);
                webViewSmileyGrid.uKA.notifyDataSetChanged();
            }
            AppMethodBeat.o(10096);
        }
        return view;
    }

    public final int aRy() {
        AppMethodBeat.i(10098);
        int aRt = e.dqK().aRt();
        AppMethodBeat.o(10098);
        return aRt;
    }

    public final int getRowSpacing() {
        AppMethodBeat.i(10102);
        int rowCount = (this.uKz.jiL - (jit * getRowCount())) / (getRowCount() + 1);
        AppMethodBeat.o(10102);
        return rowCount;
    }
}
