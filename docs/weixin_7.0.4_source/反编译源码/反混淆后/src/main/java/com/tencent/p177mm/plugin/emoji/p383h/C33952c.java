package com.tencent.p177mm.plugin.emoji.p383h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.C42935b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emoji.h.c */
public final class C33952c {
    private final String TAG = "MicroMsg.emoji.UseSmileyTool";
    public int iGJ;
    public String lgK;

    public C33952c(int i) {
        this.iGJ = i;
    }

    /* renamed from: a */
    public static void m55568a(Intent intent, String str, Activity activity) {
        AppMethodBeat.m2504i(53868);
        if (intent == null) {
            AppMethodBeat.m2505o(53868);
            return;
        }
        C33952c.m55569a(intent.getStringExtra("Select_Conv_User"), str, activity);
        AppMethodBeat.m2505o(53868);
    }

    /* renamed from: a */
    public static void m55569a(String str, String str2, Activity activity) {
        AppMethodBeat.m2504i(53869);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
            AppMethodBeat.m2505o(53869);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("smiley_product_id", str2);
        C42935b.gkE.mo38915d(intent, (Context) activity);
        AppMethodBeat.m2505o(53869);
    }

    /* renamed from: A */
    public final void mo54501A(Activity activity) {
        AppMethodBeat.m2504i(53870);
        C4990ab.m7410d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
        Intent intent = new Intent();
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
        C25985d.m41466b((Context) activity, ".ui.transmit.SelectConversationUI", intent, this.iGJ);
        activity.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
        AppMethodBeat.m2505o(53870);
    }
}
