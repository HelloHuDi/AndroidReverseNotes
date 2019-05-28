package com.tencent.mm.cc;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b {
    private final a<?>[] xHJ;
    private final HashMap<String, a<?>> xHK = new HashMap();

    public interface a<T> {
        T get();

        String name();
    }

    public b(Context context) {
        AppMethodBeat.i(58949);
        c cVar = new c(context);
        this.xHJ = new a[]{cVar.xHL, cVar.xHM};
        AppMethodBeat.o(58949);
    }
}
