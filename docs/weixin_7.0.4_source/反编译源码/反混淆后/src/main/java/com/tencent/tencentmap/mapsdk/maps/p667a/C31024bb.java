package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41014c;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bb */
public final class C31024bb extends C44499az {
    public C31024bb(Context context) {
        super(context, 0, 100);
    }

    /* renamed from: b */
    public final void mo41920b(boolean z) {
    }

    /* renamed from: a */
    public final C36481aa mo41919a() {
        AppMethodBeat.m2504i(98542);
        try {
            C36481aa a = C24349e.m37574a(mo70869c(), C41014c.m71224m(), "".getBytes(), -1, -1);
            if (a != null) {
                AppMethodBeat.m2505o(98542);
                return a;
            }
            AppMethodBeat.m2505o(98542);
            return null;
        } catch (Throwable th) {
            C16205ag.m24684a(th);
            C16205ag.m24687d("encode2RequestPackage failed", new Object[0]);
            AppMethodBeat.m2505o(98542);
            return null;
        }
    }
}
