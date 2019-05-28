package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.b.j;
import a.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.b;
import com.tencent.mm.plugin.emojicapture.model.a.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojicapture_release"})
public final class EmojiCaptureReceiver extends BroadcastReceiver {
    private final String TAG = "MicroMsg.EmojiCaptureReceiver";

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(2838);
        j.p(context, "context");
        j.p(intent, "intent");
        String action = intent.getAction();
        ab.i(this.TAG, "onReceive: ".concat(String.valueOf(action)));
        if (action == null) {
            AppMethodBeat.o(2838);
            return;
        }
        switch (action.hashCode()) {
            case -2121123626:
                if (action.equals("com.tencent.mm.Emoji_Capture_Res")) {
                    int intExtra = intent.getIntExtra("res_sub_type", 0);
                    boolean booleanExtra = intent.getBooleanExtra("res_result", false);
                    ab.i(this.TAG, "onReceive: res update " + intExtra + ' ' + booleanExtra);
                    if (booleanExtra) {
                        c cVar = c.lhS;
                        c.uu(intExtra);
                        AppMethodBeat.o(2838);
                        return;
                    }
                }
                break;
            case 1555831307:
                if (action.equals("com.tencent.mm.Emoji_Capture_Upload")) {
                    long longExtra = intent.getLongExtra("upload_time_enter", 0);
                    boolean booleanExtra2 = intent.getBooleanExtra("upload_success", false);
                    String stringExtra = intent.getStringExtra("upload_md5");
                    b bVar = b.ezV;
                    b.b(longExtra, booleanExtra2, stringExtra);
                    ab.i(this.TAG, "onReceive: upload " + longExtra + ", " + booleanExtra2 + ", " + stringExtra);
                    break;
                }
                break;
        }
        AppMethodBeat.o(2838);
    }
}
