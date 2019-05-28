package com.tencent.p177mm.plugin.brandservice.p349ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.CommonVideoView;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPCommonVideoView */
public class MPCommonVideoView extends CommonVideoView {

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPCommonVideoView$1 */
    class C201121 implements Runnable {
        C201121() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138056);
            if (MPCommonVideoView.this.klq != null) {
                MPCommonVideoView.this.klq.setOneTimeVideoTextureUpdateCallback(MPCommonVideoView.this);
            }
            AppMethodBeat.m2505o(138056);
        }
    }

    public MPCommonVideoView(Context context) {
        super(context);
    }

    public MPCommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MPCommonVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: gR */
    public final void mo35358gR(long j) {
        AppMethodBeat.m2504i(138057);
        super.mo35358gR(j);
        this.fbD.postDelayed(new C201121(), j);
        AppMethodBeat.m2505o(138057);
    }
}
