package com.tencent.p177mm.p612ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.chatting.h */
public final class C15686h {
    private LinearLayout lfQ;
    private OnClickListener pLd = new C156871();
    private ChatFooterCustom yIr;
    private FrameLayout yIs;

    /* renamed from: com.tencent.mm.ui.chatting.h$1 */
    class C156871 implements OnClickListener {
        C156871() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30526);
            ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(view.getContext(), null, null);
            AppMethodBeat.m2505o(30526);
        }
    }

    public C15686h(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.m2504i(30527);
        this.yIr = chatFooterCustom;
        AppMethodBeat.m2505o(30527);
    }

    public final void ctT() {
        AppMethodBeat.m2504i(30528);
        C4990ab.m7416i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
        this.yIr.setVisibility(8);
        this.yIr.findViewById(2131822434).setVisibility(8);
        this.yIr.findViewById(2131822437).setVisibility(8);
        this.lfQ = (LinearLayout) this.yIr.findViewById(2131822436);
        this.lfQ.setWeightSum(1.0f);
        this.yIs = (FrameLayout) this.lfQ.getChildAt(0);
        this.yIs.setVisibility(0);
        this.yIs.setOnClickListener(this.pLd);
        ((TextView) this.yIs.findViewById(2131822432)).setText(C25738R.string.b7m);
        this.yIs.findViewById(2131822431).setVisibility(8);
        this.yIs.getChildAt(2).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.lfQ.getChildAt(i).setVisibility(8);
        }
        AppMethodBeat.m2505o(30528);
    }
}
