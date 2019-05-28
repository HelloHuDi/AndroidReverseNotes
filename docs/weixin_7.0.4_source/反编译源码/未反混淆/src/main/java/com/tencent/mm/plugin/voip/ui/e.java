package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;

public final class e extends BaseSmallView {
    private TextView timeTv = ((TextView) findViewById(R.id.f50));

    public e(Context context) {
        super(context, null);
        AppMethodBeat.i(4980);
        LayoutInflater.from(context).inflate(R.layout.b2k, this);
        AppMethodBeat.o(4980);
    }

    public final void aca(String str) {
        AppMethodBeat.i(4981);
        this.timeTv.setTextSize(1, 14.0f);
        this.timeTv.setText(str);
        AppMethodBeat.o(4981);
    }

    public final void abZ(String str) {
        AppMethodBeat.i(4982);
        this.timeTv.setTextSize(1, 12.0f);
        this.timeTv.setText(str);
        AppMethodBeat.o(4982);
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
