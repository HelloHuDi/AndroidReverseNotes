package com.tencent.p177mm.plugin.shake.p506c.p507a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.shake.c.a.d */
public final class C46197d {
    public float ecs = -85.0f;
    public float ect = -1000.0f;
    Map<String, Object> kaV = new HashMap();
    int qsn = 0;
    long qso = 0;
    String qsp = "";

    public C46197d() {
        AppMethodBeat.m2504i(24517);
        this.kaV.clear();
        AppMethodBeat.m2505o(24517);
    }

    public final void putValue(String str, Object obj) {
        AppMethodBeat.m2504i(24518);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(24518);
            return;
        }
        this.kaV.put(str, obj);
        AppMethodBeat.m2505o(24518);
    }
}
