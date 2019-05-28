package com.p123qq.p803wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

/* renamed from: com.qq.wx.voice.embed.recognizer.g */
final class C37310g {
    /* renamed from: b */
    Handler f15850b = new C45077h(this);
    C25591c bCB;

    public C37310g() {
        AppMethodBeat.m2504i(123225);
        AppMethodBeat.m2505o(123225);
    }

    /* renamed from: a */
    public final void mo60016a(int i) {
        AppMethodBeat.m2504i(123226);
        Message obtainMessage = this.f15850b.obtainMessage(100);
        Bundle bundle = new Bundle();
        bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i);
        obtainMessage.setData(bundle);
        this.f15850b.sendMessage(obtainMessage);
        AppMethodBeat.m2505o(123226);
    }
}
