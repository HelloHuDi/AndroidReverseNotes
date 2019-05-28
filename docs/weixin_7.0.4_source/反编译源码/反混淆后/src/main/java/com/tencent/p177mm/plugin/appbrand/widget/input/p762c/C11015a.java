package com.tencent.p177mm.plugin.appbrand.widget.input.p762c;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.c.a */
public final class C11015a {
    private final C7306ak jec = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(77442);
            if (1000 == message.what) {
                String str = (String) message.obj;
                int i = message.arg1;
                if (C11015a.this.jin != null) {
                    C11015a.this.jin.mo53807bh(str, i);
                }
            }
            AppMethodBeat.m2505o(77442);
        }
    };
    public volatile C38599c jin;

    public C11015a() {
        AppMethodBeat.m2504i(77443);
        AppMethodBeat.m2505o(77443);
    }

    /* renamed from: a */
    public final void mo22672a(CharSequence charSequence, boolean z) {
        AppMethodBeat.m2504i(77444);
        if (charSequence == null) {
            AppMethodBeat.m2505o(77444);
            return;
        }
        Message obtainMessage = this.jec.obtainMessage(1000, Selection.getSelectionEnd(charSequence), 0, charSequence.toString());
        this.jec.removeMessages(1000);
        this.jec.sendMessageDelayed(obtainMessage, z ? 150 : 0);
        AppMethodBeat.m2505o(77444);
    }
}
