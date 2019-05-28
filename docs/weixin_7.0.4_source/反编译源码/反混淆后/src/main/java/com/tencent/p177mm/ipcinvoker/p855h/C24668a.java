package com.tencent.p177mm.ipcinvoker.p855h;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p855h.p1193a.C18513a;

/* renamed from: com.tencent.mm.ipcinvoker.h.a */
public final class C24668a implements C18513a {
    /* renamed from: a */
    public final void mo20818a(int i, String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(114123);
        if (i < 4) {
            AppMethodBeat.m2505o(114123);
            return;
        }
        Log.println(i, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(114123);
    }
}
