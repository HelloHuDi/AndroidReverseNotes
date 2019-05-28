package com.tencent.p177mm.plugin.card.p352b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.card.b.e */
public final class C38727e {
    public Map<String, Object> kaV = new HashMap();
    public CardInfo kau = null;

    public C38727e() {
        AppMethodBeat.m2504i(87671);
        this.kaV.clear();
        AppMethodBeat.m2505o(87671);
    }

    public final void putValue(String str, Object obj) {
        AppMethodBeat.m2504i(87672);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87672);
            return;
        }
        this.kaV.put(str, obj);
        AppMethodBeat.m2505o(87672);
    }

    public final Object getValue(String str) {
        AppMethodBeat.m2504i(87673);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87673);
            return null;
        } else if (this.kaV.containsKey(str)) {
            Object obj = this.kaV.get(str);
            AppMethodBeat.m2505o(87673);
            return obj;
        } else {
            AppMethodBeat.m2505o(87673);
            return null;
        }
    }
}
