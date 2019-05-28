package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;

public final class c {
    private final String TAG = "MicroMsg.emoji.UseSmileyTool";
    public int iGJ;
    public String lgK;

    public c(int i) {
        this.iGJ = i;
    }

    public static void a(Intent intent, String str, Activity activity) {
        AppMethodBeat.i(53868);
        if (intent == null) {
            AppMethodBeat.o(53868);
            return;
        }
        a(intent.getStringExtra("Select_Conv_User"), str, activity);
        AppMethodBeat.o(53868);
    }

    public static void a(String str, String str2, Activity activity) {
        AppMethodBeat.i(53869);
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
            AppMethodBeat.o(53869);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("smiley_product_id", str2);
        b.gkE.d(intent, (Context) activity);
        AppMethodBeat.o(53869);
    }

    public final void A(Activity activity) {
        AppMethodBeat.i(53870);
        ab.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
        Intent intent = new Intent();
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
        d.b((Context) activity, ".ui.transmit.SelectConversationUI", intent, this.iGJ);
        activity.overridePendingTransition(R.anim.cg, R.anim.b6);
        AppMethodBeat.o(53870);
    }
}
