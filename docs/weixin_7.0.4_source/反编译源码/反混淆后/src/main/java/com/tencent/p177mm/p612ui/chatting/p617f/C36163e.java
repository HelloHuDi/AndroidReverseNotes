package com.tencent.p177mm.p612ui.chatting.p617f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40750b;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40751c;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.ui.chatting.f.e */
public final class C36163e implements C40748d {
    private static final HandlerThread yYE = new HandlerThread("ListDataLoader$Thread");
    private final Handler bYm;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(32485);
            if (C36163e.this.yYF.get()) {
                C4990ab.m7420w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
                AppMethodBeat.m2505o(32485);
                return;
            }
            switch (message.what) {
                case 1:
                    C40752d c40752d = (C40752d) message.obj;
                    c40752d.yYD = C36163e.this.yYH.mo10971fd(c40752d.yYB);
                    C36163e.this.yYG.mo10968a(c40752d);
                    C4990ab.m7417i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! result:%s", c40752d.toString());
                    break;
            }
            AppMethodBeat.m2505o(32485);
        }
    };
    private AtomicBoolean yYF = new AtomicBoolean(false);
    private C36166f yYG;
    private C5338c yYH;

    /* renamed from: com.tencent.mm.ui.chatting.f.e$a */
    class C36164a implements Runnable {
        boolean cNi;
        C40749a yYA;
        AtomicBoolean yYF;
        C40751c yYJ;

        C36164a(C40749a c40749a, boolean z, C40751c c40751c, AtomicBoolean atomicBoolean) {
            this.yYA = c40749a;
            this.cNi = z;
            this.yYJ = c40751c;
            this.yYF = atomicBoolean;
        }

        public final void run() {
            AppMethodBeat.m2504i(32487);
            long currentTimeMillis = System.currentTimeMillis();
            final C40752d c40752d = new C40752d(this.yYA);
            C36163e.this.yYH.mo10970a(this.yYA, this.yYJ.mo31090b(c40752d), c40752d, new C40750b() {
                /* renamed from: dY */
                public final void mo15847dY() {
                    AppMethodBeat.m2504i(32486);
                    C36164a.this.yYJ.mo31091c(c40752d);
                    C36164a c36164a = C36164a.this;
                    C40752d c40752d = c40752d;
                    if (c36164a.yYF.get()) {
                        C4990ab.m7420w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                        AppMethodBeat.m2505o(32486);
                        return;
                    }
                    Message message = new Message();
                    message.what = 1;
                    message.obj = c40752d;
                    if (c36164a.cNi && Looper.myLooper() == Looper.getMainLooper()) {
                        C36163e.this.mMainHandler.handleMessage(message);
                        AppMethodBeat.m2505o(32486);
                        return;
                    }
                    C36163e.this.mMainHandler.sendMessage(message);
                    AppMethodBeat.m2505o(32486);
                }
            });
            C4990ab.m7411d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(32487);
        }
    }

    static {
        AppMethodBeat.m2504i(32491);
        AppMethodBeat.m2505o(32491);
    }

    public C36163e(C36166f c36166f, C5338c c5338c) {
        AppMethodBeat.m2504i(32488);
        this.yYG = c36166f;
        this.yYH = c5338c;
        if (!yYE.isAlive()) {
            yYE.start();
        }
        this.bYm = new Handler(yYE.getLooper());
        AppMethodBeat.m2505o(32488);
    }

    /* renamed from: a */
    public final void mo57055a(C40749a c40749a, boolean z, C40751c c40751c) {
        AppMethodBeat.m2504i(32489);
        C4990ab.m7417i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", c40749a, Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()));
        C36164a c36164a = new C36164a(c40749a, z, c40751c, this.yYF);
        if (z) {
            c36164a.run();
            AppMethodBeat.m2505o(32489);
            return;
        }
        this.bYm.post(c36164a);
        AppMethodBeat.m2505o(32489);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(32490);
        C4990ab.m7416i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
        this.yYF.set(true);
        this.yYF = new AtomicBoolean(false);
        this.bYm.removeCallbacksAndMessages(null);
        this.mMainHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(32490);
    }
}
