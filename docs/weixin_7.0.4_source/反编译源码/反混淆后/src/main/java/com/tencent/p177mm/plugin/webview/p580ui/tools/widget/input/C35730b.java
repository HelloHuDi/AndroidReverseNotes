package com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewSmileyGrid.C29964a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.b */
public final class C35730b extends C40349a {
    private static final int jit = C1338a.fromDPToPix(C4996ah.getContext(), 48);
    private static final int jiu = C1338a.fromDPToPix(C4996ah.getContext(), 43);

    static {
        AppMethodBeat.m2504i(10103);
        AppMethodBeat.m2505o(10103);
    }

    private int aRB() {
        AppMethodBeat.m2504i(10097);
        C14685c c14685c = this.uKz;
        if (c14685c.jiM <= 1) {
            r2 = new int[2];
            Display defaultDisplay = ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay();
            r2[0] = defaultDisplay.getWidth();
            r2[1] = defaultDisplay.getHeight();
            c14685c.jiM = r2[0];
        }
        int i = c14685c.jiM;
        AppMethodBeat.m2505o(10097);
        return i;
    }

    public final int aRz() {
        AppMethodBeat.m2504i(10099);
        int aRA = aRA() * getRowCount();
        AppMethodBeat.m2505o(10099);
        return aRA;
    }

    public final int getPageCount() {
        AppMethodBeat.m2504i(10100);
        if (aRz() <= 0) {
            AppMethodBeat.m2505o(10100);
            return 0;
        }
        int ceil = (int) Math.ceil(((double) C26003e.dqK().aRt()) / ((double) aRz()));
        AppMethodBeat.m2505o(10100);
        return ceil;
    }

    public final int aRA() {
        AppMethodBeat.m2504i(10101);
        if (this.uKz.jiH) {
            AppMethodBeat.m2505o(10101);
            return 7;
        }
        int aRB = aRB() / jiu;
        AppMethodBeat.m2505o(10101);
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

    /* renamed from: qN */
    public final View mo56469qN(int i) {
        View view = null;
        AppMethodBeat.m2504i(10096);
        Context context = this.jiq;
        C14685c c14685c = this.uKz;
        C14686d c14686d = new C14686d();
        c14686d.mIndex = i;
        c14686d.uKH = this;
        c14686d.mContext = context;
        c14686d.uKz = c14685c;
        if (c14686d.mContext == null || c14686d.uKH == null) {
            AppMethodBeat.m2505o(10096);
        } else {
            view = View.inflate(c14686d.mContext, 2130971220, null);
            if (view instanceof WebViewSmileyGrid) {
                ((WebViewSmileyGrid) view).setPanelManager(c14686d.uKz);
                WebViewSmileyGrid webViewSmileyGrid = (WebViewSmileyGrid) view;
                int i2 = c14686d.mIndex;
                int aRy = c14686d.uKH.aRy();
                int aRz = c14686d.uKH.aRz();
                int aRA = c14686d.uKH.aRA();
                int rowCount = c14686d.uKH.getRowCount();
                int rowSpacing = c14686d.uKH.getRowSpacing();
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
                rowSpacing = C1338a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                aRy = C1338a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                if (i2 == 0) {
                    i2 = C1338a.fromDPToPix(webViewSmileyGrid.getContext(), 6);
                }
                webViewSmileyGrid.setPadding(rowSpacing, i2, aRy, 0);
                webViewSmileyGrid.uKA = new C29964a(webViewSmileyGrid, (byte) 0);
                webViewSmileyGrid.setAdapter(webViewSmileyGrid.uKA);
                webViewSmileyGrid.uKA.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(10096);
        }
        return view;
    }

    public final int aRy() {
        AppMethodBeat.m2504i(10098);
        int aRt = C26003e.dqK().aRt();
        AppMethodBeat.m2505o(10098);
        return aRt;
    }

    public final int getRowSpacing() {
        AppMethodBeat.m2504i(10102);
        int rowCount = (this.uKz.jiL - (jit * getRowCount())) / (getRowCount() + 1);
        AppMethodBeat.m2505o(10102);
        return rowCount;
    }
}
