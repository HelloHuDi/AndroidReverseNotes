package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.ui.container.a;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class d extends a implements OnClickListener {
    public d(ViewGroup viewGroup, a aVar) {
        super(viewGroup, aVar);
    }

    public final int btU() {
        return R.layout.xb;
    }

    public final void initView() {
        AppMethodBeat.i(806);
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().bsL();
        FaceDetectReporter.bsJ().lUA = System.currentTimeMillis();
        MMAnimateView mMAnimateView = (MMAnimateView) findViewById(R.id.bmk);
        mMAnimateView.setImageResource(R.raw.face_ready_gif);
        mMAnimateView.start();
        ((Button) findViewById(R.id.bmn)).setOnClickListener(this);
        AppMethodBeat.o(806);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(807);
        if (view.getId() == R.id.bmn) {
            setVisibility(8);
            this.mds.startPreview();
        }
        AppMethodBeat.o(807);
    }
}
