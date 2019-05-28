package com.p123qq.p803wx.voice.embed.recognizer;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

/* renamed from: com.qq.wx.voice.embed.recognizer.h */
final class C45077h extends Handler {
    private /* synthetic */ C37310g bCA;

    C45077h(C37310g c37310g) {
        this.bCA = c37310g;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(123224);
        switch (message.what) {
            case 100:
                this.bCA.bCB.mo43299fM(message.getData().getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE));
                AppMethodBeat.m2505o(123224);
                return;
            case 200:
                this.bCA.bCB.mo43298a((C25590a) message.obj);
                break;
        }
        AppMethodBeat.m2505o(123224);
    }
}
