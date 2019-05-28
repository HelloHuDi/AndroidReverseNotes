package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;

public final class ac {
    public static String Hb(int i) {
        AppMethodBeat.i(45331);
        Context context = ah.getContext();
        String str = "";
        switch (i) {
            case 0:
                str = context.getString(R.string.fiy);
                break;
            case 1:
                str = context.getString(R.string.fj1);
                break;
            case 2:
                str = context.getString(R.string.fj2);
                break;
            case 3:
                str = context.getString(R.string.fiz);
                break;
            case 4:
                str = context.getString(R.string.fj0);
                break;
        }
        AppMethodBeat.o(45331);
        return str;
    }
}
