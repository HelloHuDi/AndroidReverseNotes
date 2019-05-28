package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;

public class MPCommonVideoView extends CommonVideoView {
    public MPCommonVideoView(Context context) {
        super(context);
    }

    public MPCommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MPCommonVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void gR(long j) {
        AppMethodBeat.i(138057);
        super.gR(j);
        this.fbD.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138056);
                if (MPCommonVideoView.this.klq != null) {
                    MPCommonVideoView.this.klq.setOneTimeVideoTextureUpdateCallback(MPCommonVideoView.this);
                }
                AppMethodBeat.o(138056);
            }
        }, j);
        AppMethodBeat.o(138057);
    }
}
