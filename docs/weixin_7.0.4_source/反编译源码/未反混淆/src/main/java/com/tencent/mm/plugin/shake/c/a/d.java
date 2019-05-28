package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public float ecs = -85.0f;
    public float ect = -1000.0f;
    Map<String, Object> kaV = new HashMap();
    int qsn = 0;
    long qso = 0;
    String qsp = "";

    public d() {
        AppMethodBeat.i(24517);
        this.kaV.clear();
        AppMethodBeat.o(24517);
    }

    public final void putValue(String str, Object obj) {
        AppMethodBeat.i(24518);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(24518);
            return;
        }
        this.kaV.put(str, obj);
        AppMethodBeat.o(24518);
    }
}
