package com.tencent.p177mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.emoji.sync.EmojiUpdateReceiver */
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
        AppMethodBeat.m2504i(62269);
        if (ACTION.equals(intent.getAction())) {
            String stringExtra;
            String stringExtra2 = intent.getStringExtra(ezN);
            C4990ab.m7417i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", stringExtra, stringExtra2);
            if (ezO.equals(stringExtra2)) {
                C32497a.m53203OB().mo53138ca(false);
                AppMethodBeat.m2505o(62269);
                return;
            } else if (ezP.equals(stringExtra2)) {
                C32497a.m53203OB().mo53139cb(false);
                AppMethodBeat.m2505o(62269);
                return;
            } else if (ezQ.equals(stringExtra2)) {
                C32497a.m53203OB().eyx = true;
                AppMethodBeat.m2505o(62269);
                return;
            } else if (ezR.equals(stringExtra2)) {
                C32497a.m53203OB().mo53140cc(false);
                AppMethodBeat.m2505o(62269);
                return;
            } else if (ezS.equals(stringExtra2)) {
                C32497a.m53203OB().mo53141cd(false);
                AppMethodBeat.m2505o(62269);
                return;
            } else if (ezT.equals(stringExtra2)) {
                stringExtra = intent.getStringExtra("md5");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                C37682a c37682a = C37682a.exs;
                C37682a.m63730q(stringExtra, booleanExtra);
            }
        }
        AppMethodBeat.m2505o(62269);
    }
}
