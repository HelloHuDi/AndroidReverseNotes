package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;

public class FileDownloadPendingReceive extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(2439);
        ab.i("MicroMsg.FileDownloadPendingReceive", "onReceive()");
        intent.setComponent(new ComponentName(intent.getComponent().getPackageName(), FileDownloadService.class.getName()));
        d.aH(intent);
        AppMethodBeat.o(2439);
    }
}
