package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class EmojiUpdateReceiver extends BroadcastReceiver {
    public static String ACTION = "com.tencent.mm.Emoji_Update";
    public static String ezN = "type";
    public static String ezO = "update_all_custom_emoji";
    public static String ezP = "update_download_custom_emoji";
    public static String ezQ = "update_store_emoji";
    public static String ezR = "update_group_info";
    public static String ezS = "update_capture_emoji";
    public static String ezT = "update_emoji_download";

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(62269);
        if (ACTION.equals(intent.getAction())) {
            String stringExtra;
            String stringExtra2 = intent.getStringExtra(ezN);
            ab.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", stringExtra, stringExtra2);
            if (ezO.equals(stringExtra2)) {
                a.OB().ca(false);
                AppMethodBeat.o(62269);
                return;
            } else if (ezP.equals(stringExtra2)) {
                a.OB().cb(false);
                AppMethodBeat.o(62269);
                return;
            } else if (ezQ.equals(stringExtra2)) {
                a.OB().eyx = true;
                AppMethodBeat.o(62269);
                return;
            } else if (ezR.equals(stringExtra2)) {
                a.OB().cc(false);
                AppMethodBeat.o(62269);
                return;
            } else if (ezS.equals(stringExtra2)) {
                a.OB().cd(false);
                AppMethodBeat.o(62269);
                return;
            } else if (ezT.equals(stringExtra2)) {
                stringExtra = intent.getStringExtra("md5");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                com.tencent.mm.emoji.loader.a aVar = com.tencent.mm.emoji.loader.a.exs;
                com.tencent.mm.emoji.loader.a.q(stringExtra, booleanExtra);
            }
        }
        AppMethodBeat.o(62269);
    }
}
