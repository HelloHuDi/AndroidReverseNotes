package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(15839);
        if (context == null || intent == null) {
            AppMethodBeat.o(15839);
            return;
        }
        String action = intent.getAction();
        ab.i("MicroMsg.InstallReceiver", "action:[%s]", action);
        if (bo.isNullOrNil(action) || !action.equals("com.android.vending.INSTALL_REFERRER")) {
            ab.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
            AppMethodBeat.o(15839);
            return;
        }
        action = "";
        try {
            action = intent.getStringExtra("referrer");
        } catch (Exception e) {
            ab.e("MicroMsg.InstallReceiver", "%s", bo.l(e));
        }
        ab.i("MicroMsg.InstallReceiver", "get referer:[%s]", action);
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.InstallReceiver", "get referer is null or nil");
            AppMethodBeat.o(15839);
            return;
        }
        ab.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = ".concat(String.valueOf(action)));
        context.getSharedPreferences(ah.doA(), 0).edit().putString("installreferer", action).commit();
        AppMethodBeat.o(15839);
    }
}
