package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20150202", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class FileDownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(2440);
        if (context == null || intent == null) {
            AppMethodBeat.o(2440);
            return;
        }
        String action = intent.getAction();
        ab.i("MicroMsg.FileDownloadReceiver", action);
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
            AppMethodBeat.o(2440);
            return;
        }
        action.equals("android.intent.action.DOWNLOAD_COMPLETE");
        AppMethodBeat.o(2440);
    }
}
