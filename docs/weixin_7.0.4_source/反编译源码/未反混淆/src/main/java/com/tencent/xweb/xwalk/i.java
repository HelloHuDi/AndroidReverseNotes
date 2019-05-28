package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.g;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCoreWrapper;

public final class i implements g {
    public final void deleteOrigin(String str) {
        AppMethodBeat.i(85247);
        Log.i("XWStorage", "delete origin ret is ".concat(String.valueOf(XWalkCoreWrapper.invokeRuntimeChannel(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN, new Object[]{str}))));
        AppMethodBeat.o(85247);
    }
}
