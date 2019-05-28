package com.tencent.mm.aa;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;

public final class g extends JSONException {
    public g(String str) {
        super(str);
    }

    public g(Throwable th) {
        super(Log.getStackTraceString(th));
        AppMethodBeat.i(117624);
        AppMethodBeat.o(117624);
    }
}
