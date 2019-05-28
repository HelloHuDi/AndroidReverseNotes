package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {
    private LinearLayout lfQ;
    private OnClickListener pLd = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(30526);
            ((d) g.K(d.class)).a(view.getContext(), null, null);
            AppMethodBeat.o(30526);
        }
    };
    private ChatFooterCustom yIr;
    private FrameLayout yIs;

    public h(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(30527);
        this.yIr = chatFooterCustom;
        AppMethodBeat.o(30527);
    }

    public final void ctT() {
        AppMethodBeat.i(30528);
        ab.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
        this.yIr.setVisibility(8);
        this.yIr.findViewById(R.id.an2).setVisibility(8);
        this.yIr.findViewById(R.id.an5).setVisibility(8);
        this.lfQ = (LinearLayout) this.yIr.findViewById(R.id.an4);
        this.lfQ.setWeightSum(1.0f);
        this.yIs = (FrameLayout) this.lfQ.getChildAt(0);
        this.yIs.setVisibility(0);
        this.yIs.setOnClickListener(this.pLd);
        ((TextView) this.yIs.findViewById(R.id.an0)).setText(R.string.b7m);
        this.yIs.findViewById(R.id.amz).setVisibility(8);
        this.yIs.getChildAt(2).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.lfQ.getChildAt(i).setVisibility(8);
        }
        AppMethodBeat.o(30528);
    }
}
