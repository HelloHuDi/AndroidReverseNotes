package com.tencent.p177mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive */
public class FileDownloadPendingReceive extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(2439);
        C4990ab.m7416i("MicroMsg.FileDownloadPendingReceive", "onReceive()");
        intent.setComponent(new ComponentName(intent.getComponent().getPackageName(), FileDownloadService.class.getName()));
        C25985d.m41463aH(intent);
        AppMethodBeat.m2505o(2439);
    }
}
