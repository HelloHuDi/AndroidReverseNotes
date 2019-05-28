package com.tencent.p177mm.plugin.emoji.p384ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity */
public abstract class EmojiBaseActivity extends MMActivity {
    private C27748a kZk;
    C27747b kZl;
    private HandlerThread mHandlerThread;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity$b */
    class C27747b extends C7306ak {
        C27747b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53298);
            super.handleMessage(message);
            EmojiBaseActivity.this.mo30732m(message);
            AppMethodBeat.m2505o(53298);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity$a */
    class C27748a extends C7306ak {
        C27748a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53297);
            super.handleMessage(message);
            EmojiBaseActivity.this.mo30731l(message);
            AppMethodBeat.m2505o(53297);
        }
    }

    /* renamed from: l */
    public abstract void mo30731l(Message message);

    /* renamed from: m */
    public abstract void mo30732m(Message message);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandlerThread = C7305d.anM("EmojiBaseActivity_handlerThread");
        this.mHandlerThread.start();
        this.kZk = new C27748a(this.mHandlerThread.getLooper());
        this.kZl = new C27747b(getMainLooper());
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

    /* renamed from: dS */
    public final void mo45578dS(int i, int i2) {
        if (this.kZl != null) {
            this.kZl.sendEmptyMessageDelayed(i, (long) i2);
        }
    }

    /* renamed from: n */
    public final void mo45579n(Message message) {
        if (this.kZl != null) {
            this.kZl.sendMessage(message);
        }
    }

    public final void blo() {
        if (this.kZl != null) {
            this.kZl.removeMessages(131074);
        }
    }

    /* renamed from: o */
    public final void mo45580o(Message message) {
        if (this.kZk != null) {
            this.kZk.sendMessage(message);
        }
    }
}
