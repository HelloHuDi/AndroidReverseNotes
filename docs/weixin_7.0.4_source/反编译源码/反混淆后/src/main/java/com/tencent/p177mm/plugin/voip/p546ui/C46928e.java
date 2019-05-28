package com.tencent.p177mm.plugin.voip.p546ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.plugin.voip.widget.BaseSmallView;

/* renamed from: com.tencent.mm.plugin.voip.ui.e */
public final class C46928e extends BaseSmallView {
    private TextView timeTv = ((TextView) findViewById(2131828572));

    public C46928e(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(4980);
        LayoutInflater.from(context).inflate(2130971036, this);
        AppMethodBeat.m2505o(4980);
    }

    public final void aca(String str) {
        AppMethodBeat.m2504i(4981);
        this.timeTv.setTextSize(1, 14.0f);
        this.timeTv.setText(str);
        AppMethodBeat.m2505o(4981);
    }

    public final void abZ(String str) {
        AppMethodBeat.m2504i(4982);
        this.timeTv.setTextSize(1, 12.0f);
        this.timeTv.setText(str);
        AppMethodBeat.m2505o(4982);
    }

    public final void setCaptureView(CaptureView captureView) {
    }

    public final void cLq() {
    }

    public final void cLr() {
    }

    public final void onAnimationEnd() {
    }

    public final OpenGlRender getFilterData() {
        return null;
    }
}
