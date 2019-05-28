package com.tencent.p177mm.plugin.downloader.p1250ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.downloader.ui.FileDownloadNotificationClickReceiver */
public class FileDownloadNotificationClickReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(2521);
        C4990ab.m7416i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
        C4990ab.m7416i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = ".concat(String.valueOf(C5046bo.m7542cc(context))));
        Bundle extras = intent.getExtras();
        Intent intent2 = new Intent(context, FileDownloadConfirmUI.class);
        intent2.putExtras(extras);
        intent2.setFlags(268435456);
        context.startActivity(intent2);
        AppMethodBeat.m2505o(2521);
    }
}
