package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    public static boolean aw(Intent intent) {
        AppMethodBeat.i(48008);
        if (intent == null) {
            AppMethodBeat.o(48008);
            return false;
        }
        if (intent.getIntExtra("key_pay_reslut_type", 0) == 1000) {
            ab.i("MicroMsg.WalletPayUtil", "onActivityResult isCanFinish %s %s", Integer.valueOf(intent.getIntExtra("key_pay_reslut_type", 0)), bo.dpG().toString());
            AppMethodBeat.o(48008);
            return true;
        }
        AppMethodBeat.o(48008);
        return false;
    }

    public static boolean ax(Intent intent) {
        AppMethodBeat.i(48009);
        if (intent == null) {
            AppMethodBeat.o(48009);
            return false;
        }
        if (intent.getIntExtra("key_pay_reslut_type", 0) == 1001) {
            ab.i("MicroMsg.WalletPayUtil", "onActivityResult isCanIgnore %s %s", Integer.valueOf(intent.getIntExtra("key_pay_reslut_type", 0)), bo.dpG().toString());
            AppMethodBeat.o(48009);
            return true;
        }
        AppMethodBeat.o(48009);
        return false;
    }
}
