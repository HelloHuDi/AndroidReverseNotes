package com.tencent.p177mm.p1593bk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.bk.a */
public final class C41793a {
    /* renamed from: fY */
    public static float m73795fY(long j) {
        float f = 1.0f;
        AppMethodBeat.m2504i(16633);
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        f = (float) Math.round(f);
        AppMethodBeat.m2505o(16633);
        return f;
    }

    /* renamed from: B */
    public static CharSequence m73794B(Context context, int i) {
        AppMethodBeat.m2504i(16634);
        if (i <= 0) {
            String string = context.getString(C25738R.string.brd, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
            AppMethodBeat.m2505o(16634);
            return string;
        }
        int i2 = i % 60;
        CharSequence string2 = context.getString(C25738R.string.brd, new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i2)});
        AppMethodBeat.m2505o(16634);
        return string2;
    }
}
