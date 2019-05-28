package com.tencent.p177mm.plugin.wallet_core.utils;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.utils.c */
public final class C46374c {
    /* renamed from: aw */
    public static boolean m87176aw(Intent intent) {
        AppMethodBeat.m2504i(48008);
        if (intent == null) {
            AppMethodBeat.m2505o(48008);
            return false;
        }
        if (intent.getIntExtra("key_pay_reslut_type", 0) == 1000) {
            C4990ab.m7417i("MicroMsg.WalletPayUtil", "onActivityResult isCanFinish %s %s", Integer.valueOf(intent.getIntExtra("key_pay_reslut_type", 0)), C5046bo.dpG().toString());
            AppMethodBeat.m2505o(48008);
            return true;
        }
        AppMethodBeat.m2505o(48008);
        return false;
    }

    /* renamed from: ax */
    public static boolean m87177ax(Intent intent) {
        AppMethodBeat.m2504i(48009);
        if (intent == null) {
            AppMethodBeat.m2505o(48009);
            return false;
        }
        if (intent.getIntExtra("key_pay_reslut_type", 0) == 1001) {
            C4990ab.m7417i("MicroMsg.WalletPayUtil", "onActivityResult isCanIgnore %s %s", Integer.valueOf(intent.getIntExtra("key_pay_reslut_type", 0)), C5046bo.dpG().toString());
            AppMethodBeat.m2505o(48009);
            return true;
        }
        AppMethodBeat.m2505o(48009);
        return false;
    }
}
