package com.tencent.p177mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20150202", reviewer = 20, vComment = {EType.RECEIVERCHECK})
/* renamed from: com.tencent.mm.plugin.downloader.model.FileDownloadReceiver */
public class FileDownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(2440);
        if (context == null || intent == null) {
            AppMethodBeat.m2505o(2440);
            return;
        }
        String action = intent.getAction();
        C4990ab.m7416i("MicroMsg.FileDownloadReceiver", action);
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
            AppMethodBeat.m2505o(2440);
            return;
        }
        action.equals("android.intent.action.DOWNLOAD_COMPLETE");
        AppMethodBeat.m2505o(2440);
    }
}
