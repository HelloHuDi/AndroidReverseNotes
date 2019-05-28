package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public final class ao {
    public static ao umH = new ao();
    public boolean hasInit;
    public e umI = null;

    static {
        AppMethodBeat.i(6745);
        AppMethodBeat.o(6745);
    }

    private ao() {
    }

    public static ao cXP() {
        return umH;
    }

    public final void setNetWorkState(int i) {
        AppMethodBeat.i(6744);
        String str = "MicroMsg.WebViewVideoProxy";
        String str2 = "set networkd state = %d, callbacker == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.umI == null);
        ab.i(str, str2, objArr);
        if (this.umI != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_video_proxy_net_state", i);
            try {
                this.umI.g(ReaderCallback.READER_TOAST, bundle);
                AppMethodBeat.o(6744);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", e.getMessage());
            }
        }
        AppMethodBeat.o(6744);
    }
}
