package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface d {

    public static class a {
        private Lock aCZ = new ReentrantLock();
        private LinkedBlockingQueue<d> oxI;
        private final int oxJ;
        private Callable<d> oxK;
        private volatile int size = 0;

        public a(int i, Callable<d> callable) {
            AppMethodBeat.i(3637);
            this.oxJ = i;
            this.oxI = new LinkedBlockingQueue(i);
            this.oxK = callable;
            AppMethodBeat.o(3637);
        }

        public final d bQd() {
            d dVar = null;
            AppMethodBeat.i(3638);
            long yz = bo.yz();
            ab.d("FetcherPool", "acquireFetcher");
            if (this.oxI == null) {
                ab.d("FetcherPool", "acquireFetcher no pool directly return null");
                AppMethodBeat.o(3638);
            } else {
                this.aCZ.lock();
                ab.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", Integer.valueOf(this.oxI.size()), Integer.valueOf(this.size), Integer.valueOf(this.oxJ));
                if (this.oxI == null) {
                    this.aCZ.unlock();
                    AppMethodBeat.o(3638);
                } else {
                    if (!this.oxI.isEmpty() || this.size >= this.oxJ) {
                        ab.d("FetcherPool", "waiting fetcher");
                        this.aCZ.unlock();
                        dVar = (d) this.oxI.poll(5, TimeUnit.SECONDS);
                    } else {
                        ab.d("FetcherPool", "new fetcher");
                        this.size++;
                        this.aCZ.unlock();
                        dVar = bQe();
                    }
                    ab.d("FetcherPool", "time flee, acquireFetcher cost time %d", Long.valueOf(bo.az(yz)));
                    AppMethodBeat.o(3638);
                }
            }
            return dVar;
        }

        private d bQe() {
            AppMethodBeat.i(3639);
            if (this.oxK == null) {
                IllegalStateException illegalStateException = new IllegalStateException("fetcher generator can not be null.");
                AppMethodBeat.o(3639);
                throw illegalStateException;
            }
            try {
                d dVar = (d) this.oxK.call();
                ab.d("FetcherPool", "time flee, construct fetcher instance cost %d", Long.valueOf(bo.az(bo.yz())));
                AppMethodBeat.o(3639);
                return dVar;
            } catch (Exception e) {
                ab.printErrStackTrace("FetcherPool", e, " fetcher generater call error %s", e.getMessage());
                AppMethodBeat.o(3639);
                throw e;
            }
        }

        public final void a(d dVar) {
            AppMethodBeat.i(3640);
            ab.d("FetcherPool", "reuseFetcher");
            if (dVar == null) {
                ab.e("FetcherPool", "Null object can not be reused.");
                AppMethodBeat.o(3640);
            } else if (this.oxI == null) {
                dVar.release();
                AppMethodBeat.o(3640);
            } else if (this.oxI.contains(dVar)) {
                IllegalStateException illegalStateException = new IllegalStateException("fetcher already in pool");
                AppMethodBeat.o(3640);
                throw illegalStateException;
            } else {
                this.oxI.offer(dVar);
                AppMethodBeat.o(3640);
            }
        }

        public final void destroy() {
            AppMethodBeat.i(3641);
            if (this.oxI == null) {
                AppMethodBeat.o(3641);
                return;
            }
            this.aCZ.lock();
            if (this.oxI == null) {
                this.aCZ.unlock();
                AppMethodBeat.o(3641);
                return;
            }
            try {
                Iterator it = this.oxI.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).release();
                }
            } catch (Exception e) {
                ab.printErrStackTrace("FetcherPool", e, "destroy fetcher %s", e.getMessage());
            } finally {
                this.oxI = null;
                this.aCZ.unlock();
                AppMethodBeat.o(3641);
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
