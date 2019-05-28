package com.tencent.wework.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWAPIFactory {
    public static IWWAPI jv(Context context) {
        AppMethodBeat.i(80490);
        WWAPIImpl wWAPIImpl = new WWAPIImpl(context);
        AppMethodBeat.o(80490);
        return wWAPIImpl;
    }
}
