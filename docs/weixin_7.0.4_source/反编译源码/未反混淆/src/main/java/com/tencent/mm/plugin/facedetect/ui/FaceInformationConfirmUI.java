package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class FaceInformationConfirmUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(505);
        super.onCreate(bundle);
        AppMethodBeat.o(505);
    }

    public final int getLayoutId() {
        return 0;
    }
}
