package com.tencent.mm.plugin.wallet.bind.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

public final class b {
    public static boolean b(Bankcard bankcard) {
        AppMethodBeat.i(45739);
        if (bankcard == null) {
            AppMethodBeat.o(45739);
            return false;
        }
        g.RQ();
        String str = (String) g.RP().Ry().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(45739);
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(45739);
            return true;
        }
        int i = 0;
        while (i < split.length) {
            String str2 = split[i];
            if (str2 == null || !str2.equals(bankcard.field_bankcardType)) {
                i++;
            } else {
                AppMethodBeat.o(45739);
                return false;
            }
        }
        AppMethodBeat.o(45739);
        return true;
    }
}
