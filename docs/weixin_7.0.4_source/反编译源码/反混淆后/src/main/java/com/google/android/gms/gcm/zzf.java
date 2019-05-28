package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf extends Handler {
    private final /* synthetic */ GoogleCloudMessaging zzai;

    zzf(GoogleCloudMessaging googleCloudMessaging, Looper looper) {
        this.zzai = googleCloudMessaging;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(70029);
        if (message != null) {
            Object obj = message.obj;
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            this.zzai.zzag.add(intent);
            AppMethodBeat.m2505o(70029);
            return;
        }
        if (!GoogleCloudMessaging.zzd(this.zzai, intent)) {
            intent.setPackage(this.zzai.zzk.getPackageName());
            this.zzai.zzk.sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(70029);
    }
}
