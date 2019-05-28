package com.tencent.p177mm.p612ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.chatting.w */
public final class C23891w {
    private LinearLayout lfQ;
    private OnClickListener pLd = new C238921();
    private ChatFooterCustom yIr;
    private FrameLayout yIs;

    /* renamed from: com.tencent.mm.ui.chatting.w$1 */
    class C238921 implements OnClickListener {
        C238921() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30814);
            C22162d.m33785kT(1);
            C1855t.m3932na("gh_43f2581f6fd6");
            Intent intent = new Intent();
            intent.putExtra("key_is_latest", true);
            intent.putExtra("rank_id", "#");
            intent.putExtra("key_only_show_latest_rank", true);
            intent.putExtra("app_username", C1854s.m3866mJ("gh_43f2581f6fd6"));
            intent.putExtra("device_type", 1);
            C25985d.m41467b(view.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
            AppMethodBeat.m2505o(30814);
        }
    }

    public C23891w(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.m2504i(30815);
        this.yIr = chatFooterCustom;
        AppMethodBeat.m2505o(30815);
    }

    public final void ctT() {
        AppMethodBeat.m2504i(30816);
        C4990ab.m7416i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
        this.yIr.findViewById(2131822434).setVisibility(8);
        this.yIr.findViewById(2131822437).setVisibility(8);
        this.lfQ = (LinearLayout) this.yIr.findViewById(2131822436);
        this.lfQ.setWeightSum(1.0f);
        this.yIs = (FrameLayout) this.lfQ.getChildAt(0);
        this.yIs.setVisibility(0);
        this.yIs.setOnClickListener(this.pLd);
        ((TextView) this.yIs.findViewById(2131822432)).setText(C25738R.string.bi7);
        this.yIs.findViewById(2131822431).setVisibility(8);
        this.yIs.getChildAt(2).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.lfQ.getChildAt(i).setVisibility(8);
        }
        AppMethodBeat.m2505o(30816);
    }
}
