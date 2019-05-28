package com.tencent.p177mm.plugin.wallet.bind.p553ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;

/* renamed from: com.tencent.mm.plugin.wallet.bind.ui.b */
public final class C22528b {
    /* renamed from: b */
    public static boolean m34221b(Bankcard bankcard) {
        AppMethodBeat.m2504i(45739);
        if (bankcard == null) {
            AppMethodBeat.m2505o(45739);
            return false;
        }
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(45739);
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            AppMethodBeat.m2505o(45739);
            return true;
        }
        int i = 0;
        while (i < split.length) {
            String str2 = split[i];
            if (str2 == null || !str2.equals(bankcard.field_bankcardType)) {
                i++;
            } else {
                AppMethodBeat.m2505o(45739);
                return false;
            }
        }
        AppMethodBeat.m2505o(45739);
        return true;
    }
}
