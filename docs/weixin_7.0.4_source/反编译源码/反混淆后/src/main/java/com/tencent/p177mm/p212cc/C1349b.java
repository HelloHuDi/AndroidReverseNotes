package com.tencent.p177mm.p212cc;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* renamed from: com.tencent.mm.cc.b */
public final class C1349b {
    private final C1348a<?>[] xHJ;
    private final HashMap<String, C1348a<?>> xHK = new HashMap();

    /* renamed from: com.tencent.mm.cc.b$a */
    public interface C1348a<T> {
        T get();

        String name();
    }

    public C1349b(Context context) {
        AppMethodBeat.m2504i(58949);
        C1350c c1350c = new C1350c(context);
        this.xHJ = new C1348a[]{c1350c.xHL, c1350c.xHM};
        AppMethodBeat.m2505o(58949);
    }
}
