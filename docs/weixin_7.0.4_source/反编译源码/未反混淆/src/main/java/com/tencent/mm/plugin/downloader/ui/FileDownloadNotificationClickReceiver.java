package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class FileDownloadNotificationClickReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(2521);
        ab.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
        ab.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = ".concat(String.valueOf(bo.cc(context))));
        Bundle extras = intent.getExtras();
        Intent intent2 = new Intent(context, FileDownloadConfirmUI.class);
        intent2.putExtras(extras);
        intent2.setFlags(268435456);
        context.startActivity(intent2);
        AppMethodBeat.o(2521);
    }
}
