package com.tencent.wework.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWAPIFactory {
    /* renamed from: jv */
    public static IWWAPI m50230jv(Context context) {
        AppMethodBeat.m2504i(80490);
        WWAPIImpl wWAPIImpl = new WWAPIImpl(context);
        AppMethodBeat.m2505o(80490);
        return wWAPIImpl;
    }
}
