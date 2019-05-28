package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(71574);
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        if (!(stringExtra == null || stringExtra2 == null)) {
            Bundle extras = intent.getExtras();
            if (NativeProtocol.isErrorResult(intent)) {
                onFailedAppCall(stringExtra, stringExtra2, extras);
                AppMethodBeat.m2505o(71574);
                return;
            }
            onSuccessfulAppCall(stringExtra, stringExtra2, extras);
        }
        AppMethodBeat.m2505o(71574);
    }

    /* Access modifiers changed, original: protected */
    public void onSuccessfulAppCall(String str, String str2, Bundle bundle) {
    }

    /* Access modifiers changed, original: protected */
    public void onFailedAppCall(String str, String str2, Bundle bundle) {
    }
}
