package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

final class h extends Handler {
    private /* synthetic */ g bCA;

    h(g gVar) {
        this.bCA = gVar;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(123224);
        switch (message.what) {
            case 100:
                this.bCA.bCB.fM(message.getData().getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE));
                AppMethodBeat.o(123224);
                return;
            case 200:
                this.bCA.bCB.a((a) message.obj);
                break;
        }
        AppMethodBeat.o(123224);
    }
}
