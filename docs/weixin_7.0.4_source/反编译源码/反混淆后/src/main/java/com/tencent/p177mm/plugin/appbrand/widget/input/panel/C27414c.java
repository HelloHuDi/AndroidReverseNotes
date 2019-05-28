package com.tencent.p177mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.panel.c */
public class C27414c {
    boolean jiH = false;
    C19902b jiJ;
    C19904f jiK;
    int jiL;
    int jiM;
    Context jiq;

    public final C42745a aRH() {
        AppMethodBeat.m2504i(134330);
        if (this.jiJ == null) {
            this.jiJ = new C19902b();
            this.jiJ.jiq = this.jiq;
            this.jiJ.setPanelManager(this);
        }
        C19902b c19902b = this.jiJ;
        AppMethodBeat.m2505o(134330);
        return c19902b;
    }

    public static int[] aMw() {
        AppMethodBeat.m2504i(134331);
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        AppMethodBeat.m2505o(134331);
        return r1;
    }

    /* Access modifiers changed, original: protected */
    public C26003e aRr() {
        AppMethodBeat.m2504i(134332);
        C26003e dqK = C26003e.dqK();
        AppMethodBeat.m2505o(134332);
        return dqK;
    }
}
