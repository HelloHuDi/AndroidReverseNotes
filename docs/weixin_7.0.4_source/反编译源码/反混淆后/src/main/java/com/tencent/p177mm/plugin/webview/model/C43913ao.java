package com.tencent.p177mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

/* renamed from: com.tencent.mm.plugin.webview.model.ao */
public final class C43913ao {
    public static C43913ao umH = new C43913ao();
    public boolean hasInit;
    public C40281e umI = null;

    static {
        AppMethodBeat.m2504i(6745);
        AppMethodBeat.m2505o(6745);
    }

    private C43913ao() {
    }

    public static C43913ao cXP() {
        return umH;
    }

    public final void setNetWorkState(int i) {
        AppMethodBeat.m2504i(6744);
        String str = "MicroMsg.WebViewVideoProxy";
        String str2 = "set networkd state = %d, callbacker == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.umI == null);
        C4990ab.m7417i(str, str2, objArr);
        if (this.umI != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_video_proxy_net_state", i);
            try {
                this.umI.mo6226g(ReaderCallback.READER_TOAST, bundle);
                AppMethodBeat.m2505o(6744);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(6744);
    }
}
