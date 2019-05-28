package com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.a.b */
public final class C14369b extends C36383a {
    public C14369b(String str, String str2) {
        AppMethodBeat.m2504i(48503);
        HashMap hashMap = new HashMap();
        hashMap.put("old_pin", str);
        hashMap.put("new_pin", String.valueOf(str2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48503);
    }

    public final int cOX() {
        return 2;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }
}
