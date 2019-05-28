package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public Map<String, Object> kaV = new HashMap();
    public CardInfo kau = null;

    public e() {
        AppMethodBeat.i(87671);
        this.kaV.clear();
        AppMethodBeat.o(87671);
    }

    public final void putValue(String str, Object obj) {
        AppMethodBeat.i(87672);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87672);
            return;
        }
        this.kaV.put(str, obj);
        AppMethodBeat.o(87672);
    }

    public final Object getValue(String str) {
        AppMethodBeat.i(87673);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87673);
            return null;
        } else if (this.kaV.containsKey(str)) {
            Object obj = this.kaV.get(str);
            AppMethodBeat.o(87673);
            return obj;
        } else {
            AppMethodBeat.o(87673);
            return null;
        }
    }
}
