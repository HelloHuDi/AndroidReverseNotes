package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.os.Bundle;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20150202", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.QQCallbackUI */
public class QQCallbackUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7470);
        C4990ab.m7416i("MicroMsg.webview.QQCallbackUI", "QQCallbackUI onCreate");
        super.onCreate(bundle);
        finish();
        AppMethodBeat.m2505o(7470);
    }
}
