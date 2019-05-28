package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.e;
import com.tencent.mm.sdk.platformtools.ah;

public class c {
    boolean jiH = false;
    b jiJ;
    f jiK;
    int jiL;
    int jiM;
    Context jiq;

    public final a aRH() {
        AppMethodBeat.i(134330);
        if (this.jiJ == null) {
            this.jiJ = new b();
            this.jiJ.jiq = this.jiq;
            this.jiJ.setPanelManager(this);
        }
        b bVar = this.jiJ;
        AppMethodBeat.o(134330);
        return bVar;
    }

    public static int[] aMw() {
        AppMethodBeat.i(134331);
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        AppMethodBeat.o(134331);
        return r1;
    }

    /* Access modifiers changed, original: protected */
    public e aRr() {
        AppMethodBeat.i(134332);
        e dqK = e.dqK();
        AppMethodBeat.o(134332);
        return dqK;
    }
}
