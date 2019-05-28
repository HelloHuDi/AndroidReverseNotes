package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C44578g;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCoreWrapper;

/* renamed from: com.tencent.xweb.xwalk.i */
public final class C36618i implements C44578g {
    public final void deleteOrigin(String str) {
        AppMethodBeat.m2504i(85247);
        Log.m81049i("XWStorage", "delete origin ret is ".concat(String.valueOf(XWalkCoreWrapper.invokeRuntimeChannel(XWalkCoreWrapper.INVOKE_RUNTIME_ID_DELETE_ORIGIN, new Object[]{str}))));
        AppMethodBeat.m2505o(85247);
    }
}
