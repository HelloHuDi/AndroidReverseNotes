package com.tencent.mm.plugin.auto.service;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public class MMAutoMessageReplyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(17110);
        String n = w.n(intent, "key_username");
        if (n == null) {
            AppMethodBeat.o(17110);
            return;
        }
        Bundle resultsFromIntent;
        CharSequence charSequence;
        if (VERSION.SDK_INT >= 20) {
            resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        } else {
            if (VERSION.SDK_INT >= 16) {
                Intent intent2;
                ClipData clipData = intent.getClipData();
                if (clipData == null) {
                    intent2 = null;
                } else {
                    ClipDescription description = clipData.getDescription();
                    if (!description.hasMimeType("text/vnd.android.intent")) {
                        intent2 = null;
                    } else if (description.getLabel().equals("android.remoteinput.results")) {
                        intent2 = clipData.getItemAt(0).getIntent();
                    } else {
                        intent2 = null;
                    }
                }
                if (intent2 != null) {
                    resultsFromIntent = (Bundle) intent2.getExtras().getParcelable("android.remoteinput.resultsData");
                }
            }
            resultsFromIntent = null;
        }
        if (resultsFromIntent != null) {
            charSequence = resultsFromIntent.getCharSequence("key_voice_reply_text");
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            ab.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", n);
            AppMethodBeat.o(17110);
            return;
        }
        ab.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", n, charSequence.toString());
        g.bOk().F(n, charSequence.toString(), t.nK(n));
        AppMethodBeat.o(17110);
    }
}
