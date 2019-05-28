package com.tencent.p177mm.p1174aa;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;

/* renamed from: com.tencent.mm.aa.g */
public final class C41724g extends JSONException {
    public C41724g(String str) {
        super(str);
    }

    public C41724g(Throwable th) {
        super(Log.getStackTraceString(th));
        AppMethodBeat.m2504i(117624);
        AppMethodBeat.m2505o(117624);
    }
}
