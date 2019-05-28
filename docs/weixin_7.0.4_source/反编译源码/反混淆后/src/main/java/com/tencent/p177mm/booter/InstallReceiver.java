package com.tencent.p177mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
/* renamed from: com.tencent.mm.booter.InstallReceiver */
public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(15839);
        if (context == null || intent == null) {
            AppMethodBeat.m2505o(15839);
            return;
        }
        String action = intent.getAction();
        C4990ab.m7417i("MicroMsg.InstallReceiver", "action:[%s]", action);
        if (C5046bo.isNullOrNil(action) || !action.equals("com.android.vending.INSTALL_REFERRER")) {
            C4990ab.m7412e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
            AppMethodBeat.m2505o(15839);
            return;
        }
        action = "";
        try {
            action = intent.getStringExtra("referrer");
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.InstallReceiver", "%s", C5046bo.m7574l(e));
        }
        C4990ab.m7417i("MicroMsg.InstallReceiver", "get referer:[%s]", action);
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.InstallReceiver", "get referer is null or nil");
            AppMethodBeat.m2505o(15839);
            return;
        }
        C4990ab.m7410d("MicroMsg.InstallReceiver", "[PREF] write installreferer = ".concat(String.valueOf(action)));
        context.getSharedPreferences(C4996ah.doA(), 0).edit().putString("installreferer", action).commit();
        AppMethodBeat.m2505o(15839);
    }
}
