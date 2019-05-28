package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.ac */
public final class C14104ac {
    /* renamed from: Hb */
    public static String m22282Hb(int i) {
        AppMethodBeat.m2504i(45331);
        Context context = C4996ah.getContext();
        String str = "";
        switch (i) {
            case 0:
                str = context.getString(C25738R.string.fiy);
                break;
            case 1:
                str = context.getString(C25738R.string.fj1);
                break;
            case 2:
                str = context.getString(C25738R.string.fj2);
                break;
            case 3:
                str = context.getString(C25738R.string.fiz);
                break;
            case 4:
                str = context.getString(C25738R.string.fj0);
                break;
        }
        AppMethodBeat.m2505o(45331);
        return str;
    }
}
