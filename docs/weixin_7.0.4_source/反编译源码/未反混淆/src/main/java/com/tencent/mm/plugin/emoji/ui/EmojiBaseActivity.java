package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity extends MMActivity {
    private a kZk;
    b kZl;
    private HandlerThread mHandlerThread;

    class b extends ak {
        b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(53298);
            super.handleMessage(message);
            EmojiBaseActivity.this.m(message);
            AppMethodBeat.o(53298);
        }
    }

    class a extends ak {
        a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(53297);
            super.handleMessage(message);
            EmojiBaseActivity.this.l(message);
            AppMethodBeat.o(53297);
        }
    }

    public abstract void l(Message message);

    public abstract void m(Message message);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandlerThread = d.anM("EmojiBaseActivity_handlerThread");
        this.mHandlerThread.start();
        this.kZk = new a(this.mHandlerThread.getLooper());
        this.kZl = new b(getMainLooper());
    }

    public void onDestroy() {
        super.onDestroy();
        if (!(this.kZk == null || this.kZk.getLooper() == null)) {
            this.kZk.getLooper().quit();
        }
        this.mHandlerThread = null;
        this.kZk = null;
        this.kZl = null;
    }

    public final void dS(int i, int i2) {
        if (this.kZl != null) {
            this.kZl.sendEmptyMessageDelayed(i, (long) i2);
        }
    }

    public final void n(Message message) {
        if (this.kZl != null) {
            this.kZl.sendMessage(message);
        }
    }

    public final void blo() {
        if (this.kZl != null) {
            this.kZl.removeMessages(131074);
        }
    }

    public final void o(Message message) {
        if (this.kZk != null) {
            this.kZk.sendMessage(message);
        }
    }
}
