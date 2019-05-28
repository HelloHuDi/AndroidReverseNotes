package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class k {
    public static String K(Context context, int i) {
        AppMethodBeat.i(74184);
        String string;
        if (i <= 0) {
            string = context.getString(R.string.bsa, new Object[]{Integer.valueOf(0)});
            AppMethodBeat.o(74184);
            return string;
        }
        int i2 = i % 60;
        if (i / 60 == 0) {
            string = context.getString(R.string.bsa, new Object[]{Integer.valueOf(i2)});
            AppMethodBeat.o(74184);
            return string;
        }
        string = context.getString(R.string.bs_, new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i2)});
        AppMethodBeat.o(74184);
        return string;
    }

    public static boolean Md(String str) {
        AppMethodBeat.i(74185);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(74185);
            return false;
        } else if (str.equals(ah.getContext().getResources().getString(R.string.cnx))) {
            AppMethodBeat.o(74185);
            return false;
        } else {
            AppMethodBeat.o(74185);
            return true;
        }
    }

    public static String L(Context context, int i) {
        AppMethodBeat.i(74186);
        String str = "[" + context.getResources().getString(i) + "]";
        AppMethodBeat.o(74186);
        return str;
    }
}
