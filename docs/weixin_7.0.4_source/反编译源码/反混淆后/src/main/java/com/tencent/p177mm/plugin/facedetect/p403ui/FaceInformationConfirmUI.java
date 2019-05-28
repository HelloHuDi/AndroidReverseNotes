package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceInformationConfirmUI */
public class FaceInformationConfirmUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(505);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(505);
    }

    public final int getLayoutId() {
        return 0;
    }
}
