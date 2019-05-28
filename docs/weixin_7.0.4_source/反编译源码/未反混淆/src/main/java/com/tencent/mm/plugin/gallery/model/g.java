package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class g {
    private ak fbD;
    HandlerThread mOa = new HandlerThread("galleryDecodeHanlderThread", 10);
    HandlerThread mOb;
    HandlerThread mOc;
    ak mOd = null;
    ak mOe;
    ak mOf;

    public g() {
        AppMethodBeat.i(21273);
        ab.d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
        this.mOa.start();
        this.mOb = new HandlerThread("galleryQueryHandlerThread", 1);
        this.mOe = null;
        this.mOb.start();
        this.mOc = new HandlerThread("galleryAfterTakePicThreadThread", 0);
        this.mOf = null;
        this.mOc.start();
        AppMethodBeat.o(21273);
    }

    private ak bCm() {
        AppMethodBeat.i(21274);
        if (this.mOd == null && this.mOa != null) {
            this.mOd = new ak(this.mOa.getLooper());
        }
        ak akVar = this.mOd;
        AppMethodBeat.o(21274);
        return akVar;
    }

    public final void wp(int i) {
        AppMethodBeat.i(21275);
        try {
            Process.setThreadPriority(this.mOc.getThreadId(), i);
            AppMethodBeat.o(21275);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.GalleryHandlerThread", e, "", new Object[0]);
            AppMethodBeat.o(21275);
        }
    }

    public final ak bCn() {
        AppMethodBeat.i(21276);
        if (this.mOe == null) {
            this.mOe = new ak(this.mOb.getLooper());
        }
        ak akVar = this.mOe;
        AppMethodBeat.o(21276);
        return akVar;
    }

    public final ak bCo() {
        AppMethodBeat.i(21277);
        if (this.fbD == null) {
            this.fbD = new ak(Looper.getMainLooper());
        }
        ak akVar = this.fbD;
        AppMethodBeat.o(21277);
        return akVar;
    }

    public final void W(Runnable runnable) {
        AppMethodBeat.i(21278);
        ak bCm = bCm();
        if (bCm == null) {
            ab.e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
            AppMethodBeat.o(21278);
            return;
        }
        bCm.post(runnable);
        AppMethodBeat.o(21278);
    }

    public final void X(Runnable runnable) {
        AppMethodBeat.i(21279);
        if (bCm() == null) {
            ab.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
            AppMethodBeat.o(21279);
            return;
        }
        ab.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", Boolean.valueOf(bCm().postAtFrontOfQueueV2(runnable)));
        AppMethodBeat.o(21279);
    }

    public final void bCp() {
        AppMethodBeat.i(21280);
        ak bCm = bCm();
        if (bCm == null) {
            ab.e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
            AppMethodBeat.o(21280);
            return;
        }
        bCm.removeCallbacksAndMessages(null);
        AppMethodBeat.o(21280);
    }

    public final void d(Runnable runnable) {
        AppMethodBeat.i(21281);
        bCo().post(runnable);
        AppMethodBeat.o(21281);
    }
}
