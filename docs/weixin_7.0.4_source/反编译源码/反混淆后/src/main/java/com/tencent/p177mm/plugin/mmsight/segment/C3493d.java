package com.tencent.p177mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.d */
public interface C3493d {

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.d$a */
    public static class C3494a {
        private Lock aCZ = new ReentrantLock();
        private LinkedBlockingQueue<C3493d> oxI;
        private final int oxJ;
        private Callable<C3493d> oxK;
        private volatile int size = 0;

        public C3494a(int i, Callable<C3493d> callable) {
            AppMethodBeat.m2504i(3637);
            this.oxJ = i;
            this.oxI = new LinkedBlockingQueue(i);
            this.oxK = callable;
            AppMethodBeat.m2505o(3637);
        }

        public final C3493d bQd() {
            C3493d c3493d = null;
            AppMethodBeat.m2504i(3638);
            long yz = C5046bo.m7588yz();
            C4990ab.m7410d("FetcherPool", "acquireFetcher");
            if (this.oxI == null) {
                C4990ab.m7410d("FetcherPool", "acquireFetcher no pool directly return null");
                AppMethodBeat.m2505o(3638);
            } else {
                this.aCZ.lock();
                C4990ab.m7411d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", Integer.valueOf(this.oxI.size()), Integer.valueOf(this.size), Integer.valueOf(this.oxJ));
                if (this.oxI == null) {
                    this.aCZ.unlock();
                    AppMethodBeat.m2505o(3638);
                } else {
                    if (!this.oxI.isEmpty() || this.size >= this.oxJ) {
                        C4990ab.m7410d("FetcherPool", "waiting fetcher");
                        this.aCZ.unlock();
                        c3493d = (C3493d) this.oxI.poll(5, TimeUnit.SECONDS);
                    } else {
                        C4990ab.m7410d("FetcherPool", "new fetcher");
                        this.size++;
                        this.aCZ.unlock();
                        c3493d = bQe();
                    }
                    C4990ab.m7411d("FetcherPool", "time flee, acquireFetcher cost time %d", Long.valueOf(C5046bo.m7525az(yz)));
                    AppMethodBeat.m2505o(3638);
                }
            }
            return c3493d;
        }

        private C3493d bQe() {
            AppMethodBeat.m2504i(3639);
            if (this.oxK == null) {
                IllegalStateException illegalStateException = new IllegalStateException("fetcher generator can not be null.");
                AppMethodBeat.m2505o(3639);
                throw illegalStateException;
            }
            try {
                C3493d c3493d = (C3493d) this.oxK.call();
                C4990ab.m7411d("FetcherPool", "time flee, construct fetcher instance cost %d", Long.valueOf(C5046bo.m7525az(C5046bo.m7588yz())));
                AppMethodBeat.m2505o(3639);
                return c3493d;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("FetcherPool", e, " fetcher generater call error %s", e.getMessage());
                AppMethodBeat.m2505o(3639);
                throw e;
            }
        }

        /* renamed from: a */
        public final void mo7966a(C3493d c3493d) {
            AppMethodBeat.m2504i(3640);
            C4990ab.m7410d("FetcherPool", "reuseFetcher");
            if (c3493d == null) {
                C4990ab.m7412e("FetcherPool", "Null object can not be reused.");
                AppMethodBeat.m2505o(3640);
            } else if (this.oxI == null) {
                c3493d.release();
                AppMethodBeat.m2505o(3640);
            } else if (this.oxI.contains(c3493d)) {
                IllegalStateException illegalStateException = new IllegalStateException("fetcher already in pool");
                AppMethodBeat.m2505o(3640);
                throw illegalStateException;
            } else {
                this.oxI.offer(c3493d);
                AppMethodBeat.m2505o(3640);
            }
        }

        public final void destroy() {
            AppMethodBeat.m2504i(3641);
            if (this.oxI == null) {
                AppMethodBeat.m2505o(3641);
                return;
            }
            this.aCZ.lock();
            if (this.oxI == null) {
                this.aCZ.unlock();
                AppMethodBeat.m2505o(3641);
                return;
            }
            try {
                Iterator it = this.oxI.iterator();
                while (it.hasNext()) {
                    ((C3493d) it.next()).release();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("FetcherPool", e, "destroy fetcher %s", e.getMessage());
            } finally {
                this.oxI = null;
                this.aCZ.unlock();
                AppMethodBeat.m2505o(3641);
            }
        }
    }

    int getDurationMs();

    Bitmap getFrameAtTime(long j);

    int getScaledHeight();

    int getScaledWidth();

    void init(String str, int i, int i2, int i3);

    void release();

    void reuseBitmap(Bitmap bitmap);
}
