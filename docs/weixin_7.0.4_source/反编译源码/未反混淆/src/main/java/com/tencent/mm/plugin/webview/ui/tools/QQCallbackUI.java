package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20150202", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class QQCallbackUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7470);
        ab.i("MicroMsg.webview.QQCallbackUI", "QQCallbackUI onCreate");
        super.onCreate(bundle);
        finish();
        AppMethodBeat.o(7470);
    }
}
