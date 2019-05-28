package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class CaptureView extends ObservableSurfaceView {
    public CaptureView(Context context) {
        super(context);
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_TEXT_FIND_RESULT);
        init();
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_TEXT_FIND_RESULT);
    }

    public CaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(5043);
        init();
        AppMethodBeat.o(5043);
    }

    public CaptureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(5044);
        init();
        AppMethodBeat.o(5044);
    }

    private void init() {
        AppMethodBeat.i(5045);
        if (j.cLO()) {
            setNeedSetType(true);
        }
        AppMethodBeat.o(5045);
    }
}
