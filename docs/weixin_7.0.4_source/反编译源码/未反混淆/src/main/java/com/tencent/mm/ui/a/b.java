package com.tencent.mm.ui.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
    private final String TAG = "MicroMsg.Accessibility.Tool";
    private List<String> yqZ = new ArrayList();

    public b() {
        AppMethodBeat.i(106140);
        AppMethodBeat.o(106140);
    }

    public final b aqI(String str) {
        AppMethodBeat.i(106141);
        this.yqZ.add(str);
        AppMethodBeat.o(106141);
        return this;
    }

    public final void eD(View view) {
        AppMethodBeat.i(106142);
        if (view != null && this.yqZ.size() > 0) {
            String str;
            String str2 = "";
            Iterator it = this.yqZ.iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str + ((String) it.next()) + ",";
            }
            view.setContentDescription(str);
        }
        AppMethodBeat.o(106142);
    }
}
