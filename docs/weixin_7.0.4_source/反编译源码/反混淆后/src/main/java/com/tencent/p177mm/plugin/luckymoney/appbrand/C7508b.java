package com.tencent.p177mm.plugin.luckymoney.appbrand;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.receive.WxaLuckyMoneyReceiveUI;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.b */
public final class C7508b implements C6963a {
    /* renamed from: a */
    public final void mo15200a(MMActivity mMActivity, String str, int i, String str2, int i2) {
        AppMethodBeat.m2504i(41980);
        mMActivity.startActivityForResult(new Intent(mMActivity, WxaLuckyMoneyPrepareUI.class).putExtra("appId", str).putExtra("defaultWishingWord", str2).putExtra("range", i), i2);
        AppMethodBeat.m2505o(41980);
    }

    /* renamed from: a */
    public final void mo15201a(MMActivity mMActivity, String str, String str2, int i) {
        AppMethodBeat.m2504i(41981);
        mMActivity.startActivityForResult(new Intent(mMActivity, WxaLuckyMoneyReceiveUI.class).putExtra("appId", str2).putExtra("sendId", str), i);
        AppMethodBeat.m2505o(41981);
    }
}
