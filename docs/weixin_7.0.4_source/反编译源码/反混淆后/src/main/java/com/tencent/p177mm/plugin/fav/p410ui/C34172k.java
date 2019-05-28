package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.k */
public final class C34172k {
    /* renamed from: K */
    public static String m56020K(Context context, int i) {
        AppMethodBeat.m2504i(74184);
        String string;
        if (i <= 0) {
            string = context.getString(C25738R.string.bsa, new Object[]{Integer.valueOf(0)});
            AppMethodBeat.m2505o(74184);
            return string;
        }
        int i2 = i % 60;
        if (i / 60 == 0) {
            string = context.getString(C25738R.string.bsa, new Object[]{Integer.valueOf(i2)});
            AppMethodBeat.m2505o(74184);
            return string;
        }
        string = context.getString(C25738R.string.bs_, new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i2)});
        AppMethodBeat.m2505o(74184);
        return string;
    }

    /* renamed from: Md */
    public static boolean m56022Md(String str) {
        AppMethodBeat.m2504i(74185);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(74185);
            return false;
        } else if (str.equals(C4996ah.getContext().getResources().getString(C25738R.string.cnx))) {
            AppMethodBeat.m2505o(74185);
            return false;
        } else {
            AppMethodBeat.m2505o(74185);
            return true;
        }
    }

    /* renamed from: L */
    public static String m56021L(Context context, int i) {
        AppMethodBeat.m2504i(74186);
        String str = "[" + context.getResources().getString(i) + "]";
        AppMethodBeat.m2505o(74186);
        return str;
    }
}
