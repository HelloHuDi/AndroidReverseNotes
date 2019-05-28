package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;

final class b implements OAuthListener {
    final /* synthetic */ a f;

    b(a aVar) {
        this.f = aVar;
    }

    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        AppMethodBeat.i(128053);
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{oAuthErrCode.toString(), str}));
        this.f.d = null;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f.c);
        for (OAuthListener onAuthFinish : arrayList) {
            onAuthFinish.onAuthFinish(oAuthErrCode, str);
        }
        AppMethodBeat.o(128053);
    }

    public final void onAuthGotQrcode(String str, byte[] bArr) {
        AppMethodBeat.i(128051);
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(str)));
        ArrayList<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.f.c);
        for (OAuthListener onAuthGotQrcode : arrayList) {
            onAuthGotQrcode.onAuthGotQrcode(str, bArr);
        }
        AppMethodBeat.o(128051);
    }

    public final void onQrcodeScanned() {
        AppMethodBeat.i(128052);
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f.handler != null) {
            this.f.handler.post(new c(this));
        }
        AppMethodBeat.o(128052);
    }
}
