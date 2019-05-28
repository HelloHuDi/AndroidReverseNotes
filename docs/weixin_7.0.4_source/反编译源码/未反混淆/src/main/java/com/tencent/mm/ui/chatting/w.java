package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class w {
    private LinearLayout lfQ;
    private OnClickListener pLd = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(30814);
            d.kT(1);
            t.na("gh_43f2581f6fd6");
            Intent intent = new Intent();
            intent.putExtra("key_is_latest", true);
            intent.putExtra("rank_id", "#");
            intent.putExtra("key_only_show_latest_rank", true);
            intent.putExtra("app_username", s.mJ("gh_43f2581f6fd6"));
            intent.putExtra("device_type", 1);
            com.tencent.mm.bp.d.b(view.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
            AppMethodBeat.o(30814);
        }
    };
    private ChatFooterCustom yIr;
    private FrameLayout yIs;

    public w(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(30815);
        this.yIr = chatFooterCustom;
        AppMethodBeat.o(30815);
    }

    public final void ctT() {
        AppMethodBeat.i(30816);
        ab.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
        this.yIr.findViewById(R.id.an2).setVisibility(8);
        this.yIr.findViewById(R.id.an5).setVisibility(8);
        this.lfQ = (LinearLayout) this.yIr.findViewById(R.id.an4);
        this.lfQ.setWeightSum(1.0f);
        this.yIs = (FrameLayout) this.lfQ.getChildAt(0);
        this.yIs.setVisibility(0);
        this.yIs.setOnClickListener(this.pLd);
        ((TextView) this.yIs.findViewById(R.id.an0)).setText(R.string.bi7);
        this.yIs.findViewById(R.id.amz).setVisibility(8);
        this.yIs.getChildAt(2).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.lfQ.getChildAt(i).setVisibility(8);
        }
        AppMethodBeat.o(30816);
    }
}
