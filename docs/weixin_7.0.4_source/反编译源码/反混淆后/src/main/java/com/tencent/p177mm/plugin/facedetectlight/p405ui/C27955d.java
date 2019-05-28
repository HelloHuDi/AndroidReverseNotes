package com.tencent.p177mm.plugin.facedetectlight.p405ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.container.C20670a;
import com.tencent.p177mm.plugin.gif.MMAnimateView;

/* renamed from: com.tencent.mm.plugin.facedetectlight.ui.d */
public final class C27955d extends C11826a implements OnClickListener {
    public C27955d(ViewGroup viewGroup, C20670a c20670a) {
        super(viewGroup, c20670a);
    }

    public final int btU() {
        return 2130969467;
    }

    public final void initView() {
        AppMethodBeat.m2504i(806);
        FaceDetectReporter.bsJ().bsK();
        FaceDetectReporter.bsJ().bsL();
        FaceDetectReporter.bsJ().lUA = System.currentTimeMillis();
        MMAnimateView mMAnimateView = (MMAnimateView) findViewById(2131823784);
        mMAnimateView.setImageResource(C1318a.face_ready_gif);
        mMAnimateView.start();
        ((Button) findViewById(2131823787)).setOnClickListener(this);
        AppMethodBeat.m2505o(806);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(807);
        if (view.getId() == 2131823787) {
            setVisibility(8);
            this.mds.startPreview();
        }
        AppMethodBeat.m2505o(807);
    }
}
