package com.tencent.p177mm.plugin.emojicapture.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p228d.C41949b;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C45864c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver */
public final class EmojiCaptureReceiver extends BroadcastReceiver {
    private final String TAG = "MicroMsg.EmojiCaptureReceiver";

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(2838);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(intent, "intent");
        String action = intent.getAction();
        C4990ab.m7416i(this.TAG, "onReceive: ".concat(String.valueOf(action)));
        if (action == null) {
            AppMethodBeat.m2505o(2838);
            return;
        }
        switch (action.hashCode()) {
            case -2121123626:
                if (action.equals("com.tencent.mm.Emoji_Capture_Res")) {
                    int intExtra = intent.getIntExtra("res_sub_type", 0);
                    boolean booleanExtra = intent.getBooleanExtra("res_result", false);
                    C4990ab.m7416i(this.TAG, "onReceive: res update " + intExtra + ' ' + booleanExtra);
                    if (booleanExtra) {
                        C45864c c45864c = C45864c.lhS;
                        C45864c.m84967uu(intExtra);
                        AppMethodBeat.m2505o(2838);
                        return;
                    }
                }
                break;
            case 1555831307:
                if (action.equals("com.tencent.mm.Emoji_Capture_Upload")) {
                    long longExtra = intent.getLongExtra("upload_time_enter", 0);
                    boolean booleanExtra2 = intent.getBooleanExtra("upload_success", false);
                    String stringExtra = intent.getStringExtra("upload_md5");
                    C41949b c41949b = C41949b.ezV;
                    C41949b.m74084b(longExtra, booleanExtra2, stringExtra);
                    C4990ab.m7416i(this.TAG, "onReceive: upload " + longExtra + ", " + booleanExtra2 + ", " + stringExtra);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(2838);
    }
}
