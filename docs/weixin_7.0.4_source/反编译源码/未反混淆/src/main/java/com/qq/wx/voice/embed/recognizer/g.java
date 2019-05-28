package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

final class g {
    Handler b = new h(this);
    c bCB;

    public g() {
        AppMethodBeat.i(123225);
        AppMethodBeat.o(123225);
    }

    public final void a(int i) {
        AppMethodBeat.i(123226);
        Message obtainMessage = this.b.obtainMessage(100);
        Bundle bundle = new Bundle();
        bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i);
        obtainMessage.setData(bundle);
        this.b.sendMessage(obtainMessage);
        AppMethodBeat.o(123226);
    }
}
