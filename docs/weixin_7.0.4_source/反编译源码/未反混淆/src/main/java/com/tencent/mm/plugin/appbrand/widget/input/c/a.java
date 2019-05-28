package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class a {
    private final ak jec = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(77442);
            if (1000 == message.what) {
                String str = (String) message.obj;
                int i = message.arg1;
                if (a.this.jin != null) {
                    a.this.jin.bh(str, i);
                }
            }
            AppMethodBeat.o(77442);
        }
    };
    public volatile c jin;

    public a() {
        AppMethodBeat.i(77443);
        AppMethodBeat.o(77443);
    }

    public final void a(CharSequence charSequence, boolean z) {
        AppMethodBeat.i(77444);
        if (charSequence == null) {
            AppMethodBeat.o(77444);
            return;
        }
        Message obtainMessage = this.jec.obtainMessage(1000, Selection.getSelectionEnd(charSequence), 0, charSequence.toString());
        this.jec.removeMessages(1000);
        this.jec.sendMessageDelayed(obtainMessage, z ? 150 : 0);
        AppMethodBeat.o(77444);
    }
}
