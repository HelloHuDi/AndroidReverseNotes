package com.tencent.p177mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.video.ObservableSurfaceView;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

/* renamed from: com.tencent.mm.plugin.voip.video.CaptureView */
public class CaptureView extends ObservableSurfaceView {
    public CaptureView(Context context) {
        super(context);
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_TEXT_FIND_RESULT);
        init();
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_TEXT_FIND_RESULT);
    }

    public CaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(5043);
        init();
        AppMethodBeat.m2505o(5043);
    }

    public CaptureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(5044);
        init();
        AppMethodBeat.m2505o(5044);
    }

    private void init() {
        AppMethodBeat.m2504i(5045);
        if (C43739j.cLO()) {
            setNeedSetType(true);
        }
        AppMethodBeat.m2505o(5045);
    }
}
