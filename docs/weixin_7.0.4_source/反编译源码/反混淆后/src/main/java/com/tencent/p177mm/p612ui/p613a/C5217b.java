package com.tencent.p177mm.p612ui.p613a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.a.b */
public final class C5217b {
    private final String TAG = "MicroMsg.Accessibility.Tool";
    private List<String> yqZ = new ArrayList();

    public C5217b() {
        AppMethodBeat.m2504i(106140);
        AppMethodBeat.m2505o(106140);
    }

    public final C5217b aqI(String str) {
        AppMethodBeat.m2504i(106141);
        this.yqZ.add(str);
        AppMethodBeat.m2505o(106141);
        return this;
    }

    /* renamed from: eD */
    public final void mo10720eD(View view) {
        AppMethodBeat.m2504i(106142);
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
        AppMethodBeat.m2505o(106142);
    }
}
