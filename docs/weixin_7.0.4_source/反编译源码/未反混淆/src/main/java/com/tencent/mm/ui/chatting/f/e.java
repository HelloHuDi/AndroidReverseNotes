package com.tencent.mm.ui.chatting.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.f.d.b;
import com.tencent.mm.ui.chatting.f.d.c;
import com.tencent.mm.ui.chatting.f.d.d;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e implements d {
    private static final HandlerThread yYE = new HandlerThread("ListDataLoader$Thread");
    private final Handler bYm;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(32485);
            if (e.this.yYF.get()) {
                ab.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
                AppMethodBeat.o(32485);
                return;
            }
            switch (message.what) {
                case 1:
                    d dVar = (d) message.obj;
                    dVar.yYD = e.this.yYH.fd(dVar.yYB);
                    e.this.yYG.a(dVar);
                    ab.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! result:%s", dVar.toString());
                    break;
            }
            AppMethodBeat.o(32485);
        }
    };
    private AtomicBoolean yYF = new AtomicBoolean(false);
    private f yYG;
    private c yYH;

    class a implements Runnable {
        boolean cNi;
        com.tencent.mm.ui.chatting.f.d.a yYA;
        AtomicBoolean yYF;
        c yYJ;

        a(com.tencent.mm.ui.chatting.f.d.a aVar, boolean z, c cVar, AtomicBoolean atomicBoolean) {
            this.yYA = aVar;
            this.cNi = z;
            this.yYJ = cVar;
            this.yYF = atomicBoolean;
        }

        public final void run() {
            AppMethodBeat.i(32487);
            long currentTimeMillis = System.currentTimeMillis();
            final d dVar = new d(this.yYA);
            e.this.yYH.a(this.yYA, this.yYJ.b(dVar), dVar, new b() {
                public final void dY() {
                    AppMethodBeat.i(32486);
                    a.this.yYJ.c(dVar);
                    a aVar = a.this;
                    d dVar = dVar;
                    if (aVar.yYF.get()) {
                        ab.w("MicroMsg.ChattingLoader.ListDataLoader", "has cancel!");
                        AppMethodBeat.o(32486);
                        return;
                    }
                    Message message = new Message();
                    message.what = 1;
                    message.obj = dVar;
                    if (aVar.cNi && Looper.myLooper() == Looper.getMainLooper()) {
                        e.this.mMainHandler.handleMessage(message);
                        AppMethodBeat.o(32486);
                        return;
                    }
                    e.this.mMainHandler.sendMessage(message);
                    AppMethodBeat.o(32486);
                }
            });
            ab.d("MicroMsg.ChattingLoader.ListDataLoader", "[LoadTask.run] cost:%dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(32487);
        }
    }

    static {
        AppMethodBeat.i(32491);
        AppMethodBeat.o(32491);
    }

    public e(f fVar, c cVar) {
        AppMethodBeat.i(32488);
        this.yYG = fVar;
        this.yYH = cVar;
        if (!yYE.isAlive()) {
            yYE.start();
        }
        this.bYm = new Handler(yYE.getLooper());
        AppMethodBeat.o(32488);
    }

    public final void a(com.tencent.mm.ui.chatting.f.d.a aVar, boolean z, c cVar) {
        AppMethodBeat.i(32489);
        ab.i("MicroMsg.ChattingLoader.ListDataLoader", "[load] mode:%s isBlock:%s thread:%s", aVar, Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()));
        a aVar2 = new a(aVar, z, cVar, this.yYF);
        if (z) {
            aVar2.run();
            AppMethodBeat.o(32489);
            return;
        }
        this.bYm.post(aVar2);
        AppMethodBeat.o(32489);
    }

    public final void cancel() {
        AppMethodBeat.i(32490);
        ab.i("MicroMsg.ChattingLoader.ListDataLoader", "[cancel]");
        this.yYF.set(true);
        this.yYF = new AtomicBoolean(false);
        this.bYm.removeCallbacksAndMessages(null);
        this.mMainHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(32490);
    }
}
