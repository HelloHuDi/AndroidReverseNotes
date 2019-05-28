package com.tencent.p177mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.i */
public final class C33164i {
    private static final C33164i hlI = new C33164i();
    private Map<String, String> hlH = new HashMap();

    static {
        AppMethodBeat.m2504i(10702);
        AppMethodBeat.m2505o(10702);
    }

    public static C33164i azC() {
        return hlI;
    }

    public C33164i() {
        AppMethodBeat.m2504i(10697);
        AppMethodBeat.m2505o(10697);
    }

    /* renamed from: bK */
    public final void mo53693bK(String str, String str2) {
        AppMethodBeat.m2504i(10698);
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(10698);
            return;
        }
        this.hlH.put(str, str2);
        AppMethodBeat.m2505o(10698);
    }

    /* renamed from: zV */
    public final String mo53694zV(String str) {
        AppMethodBeat.m2504i(10699);
        String str2 = (String) this.hlH.get(str);
        AppMethodBeat.m2505o(10699);
        return str2;
    }

    /* renamed from: zW */
    public final void mo53695zW(String str) {
        AppMethodBeat.m2504i(10700);
        this.hlH.remove(str);
        AppMethodBeat.m2505o(10700);
    }

    public final Collection<String> azD() {
        AppMethodBeat.m2504i(10701);
        Collection values = this.hlH.values();
        AppMethodBeat.m2505o(10701);
        return values;
    }
}
