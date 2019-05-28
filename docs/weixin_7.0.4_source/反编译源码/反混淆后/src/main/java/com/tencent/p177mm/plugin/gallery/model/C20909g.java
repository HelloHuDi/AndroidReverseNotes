package com.tencent.p177mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.gallery.model.g */
public final class C20909g {
    private C7306ak fbD;
    HandlerThread mOa = new HandlerThread("galleryDecodeHanlderThread", 10);
    HandlerThread mOb;
    HandlerThread mOc;
    C7306ak mOd = null;
    C7306ak mOe;
    C7306ak mOf;

    public C20909g() {
        AppMethodBeat.m2504i(21273);
        C4990ab.m7410d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
        this.mOa.start();
        this.mOb = new HandlerThread("galleryQueryHandlerThread", 1);
        this.mOe = null;
        this.mOb.start();
        this.mOc = new HandlerThread("galleryAfterTakePicThreadThread", 0);
        this.mOf = null;
        this.mOc.start();
        AppMethodBeat.m2505o(21273);
    }

    private C7306ak bCm() {
        AppMethodBeat.m2504i(21274);
        if (this.mOd == null && this.mOa != null) {
            this.mOd = new C7306ak(this.mOa.getLooper());
        }
        C7306ak c7306ak = this.mOd;
        AppMethodBeat.m2505o(21274);
        return c7306ak;
    }

    /* renamed from: wp */
    public final void mo36237wp(int i) {
        AppMethodBeat.m2504i(21275);
        try {
            Process.setThreadPriority(this.mOc.getThreadId(), i);
            AppMethodBeat.m2505o(21275);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.GalleryHandlerThread", e, "", new Object[0]);
            AppMethodBeat.m2505o(21275);
        }
    }

    public final C7306ak bCn() {
        AppMethodBeat.m2504i(21276);
        if (this.mOe == null) {
            this.mOe = new C7306ak(this.mOb.getLooper());
        }
        C7306ak c7306ak = this.mOe;
        AppMethodBeat.m2505o(21276);
        return c7306ak;
    }

    public final C7306ak bCo() {
        AppMethodBeat.m2504i(21277);
        if (this.fbD == null) {
            this.fbD = new C7306ak(Looper.getMainLooper());
        }
        C7306ak c7306ak = this.fbD;
        AppMethodBeat.m2505o(21277);
        return c7306ak;
    }

    /* renamed from: W */
    public final void mo36231W(Runnable runnable) {
        AppMethodBeat.m2504i(21278);
        C7306ak bCm = bCm();
        if (bCm == null) {
            C4990ab.m7412e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
            AppMethodBeat.m2505o(21278);
            return;
        }
        bCm.post(runnable);
        AppMethodBeat.m2505o(21278);
    }

    /* renamed from: X */
    public final void mo36232X(Runnable runnable) {
        AppMethodBeat.m2504i(21279);
        if (bCm() == null) {
            C4990ab.m7412e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
            AppMethodBeat.m2505o(21279);
            return;
        }
        C4990ab.m7417i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", Boolean.valueOf(bCm().postAtFrontOfQueueV2(runnable)));
        AppMethodBeat.m2505o(21279);
    }

    public final void bCp() {
        AppMethodBeat.m2504i(21280);
        C7306ak bCm = bCm();
        if (bCm == null) {
            C4990ab.m7412e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
            AppMethodBeat.m2505o(21280);
            return;
        }
        bCm.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(21280);
    }

    /* renamed from: d */
    public final void mo36236d(Runnable runnable) {
        AppMethodBeat.m2504i(21281);
        bCo().post(runnable);
        AppMethodBeat.m2505o(21281);
    }
}
