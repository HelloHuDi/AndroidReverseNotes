package com.google.android.exoplayer2.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class s {
    IOException biw;
    final ExecutorService bqJ;
    b<? extends c> bqK;

    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    @SuppressLint({"HandlerLeak"})
    final class b<T extends c> extends Handler implements Runnable {
        private final T bqL;
        private final a<T> bqM;
        public final int bqN;
        private final long bqO;
        private IOException bqP;
        private int bqQ;
        private volatile Thread bqR;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.bqL = t;
            this.bqM = aVar;
            this.bqN = i;
            this.bqO = j;
        }

        public final void start(long j) {
            AppMethodBeat.i(95844);
            com.google.android.exoplayer2.i.a.checkState(s.this.bqK == null);
            s.this.bqK = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
                AppMethodBeat.o(95844);
                return;
            }
            execute();
            AppMethodBeat.o(95844);
        }

        public final void cancel(boolean z) {
            AppMethodBeat.i(95845);
            this.released = z;
            this.bqP = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.bqL.se();
                if (this.bqR != null) {
                    this.bqR.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.bqM.a(this.bqL, elapsedRealtime, elapsedRealtime - this.bqO, true);
            }
            AppMethodBeat.o(95845);
        }

        public final void run() {
            AppMethodBeat.i(95846);
            try {
                this.bqR = Thread.currentThread();
                if (!this.bqL.sf()) {
                    t.beginSection("load:" + this.bqL.getClass().getSimpleName());
                    this.bqL.sg();
                    t.endSection();
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
                AppMethodBeat.o(95846);
            } catch (IOException e) {
                if (!this.released) {
                    obtainMessage(3, e).sendToTarget();
                }
                AppMethodBeat.o(95846);
            } catch (InterruptedException e2) {
                com.google.android.exoplayer2.i.a.checkState(this.bqL.sf());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
                AppMethodBeat.o(95846);
            } catch (Exception e3) {
                if (!this.released) {
                    obtainMessage(3, new f(e3)).sendToTarget();
                }
                AppMethodBeat.o(95846);
            } catch (OutOfMemoryError e4) {
                if (!this.released) {
                    obtainMessage(3, new f(e4)).sendToTarget();
                }
                AppMethodBeat.o(95846);
            } catch (Error e5) {
                if (!this.released) {
                    obtainMessage(4, e5).sendToTarget();
                }
                AppMethodBeat.o(95846);
                throw e5;
            } catch (Throwable th) {
                t.endSection();
                AppMethodBeat.o(95846);
            }
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(95847);
            if (this.released) {
                AppMethodBeat.o(95847);
            } else if (message.what == 0) {
                execute();
                AppMethodBeat.o(95847);
            } else if (message.what == 4) {
                Error error = (Error) message.obj;
                AppMethodBeat.o(95847);
                throw error;
            } else {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.bqO;
                if (this.bqL.sf()) {
                    this.bqM.a(this.bqL, elapsedRealtime, j, false);
                    AppMethodBeat.o(95847);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.bqM.a(this.bqL, elapsedRealtime, j, false);
                        AppMethodBeat.o(95847);
                        return;
                    case 2:
                        this.bqM.a(this.bqL, elapsedRealtime, j);
                        AppMethodBeat.o(95847);
                        return;
                    case 3:
                        this.bqP = (IOException) message.obj;
                        int a = this.bqM.a(this.bqL, elapsedRealtime, j, this.bqP);
                        if (a != 3) {
                            if (a != 2) {
                                if (a == 1) {
                                    a = 1;
                                } else {
                                    a = this.bqQ + 1;
                                }
                                this.bqQ = a;
                                start((long) Math.min((this.bqQ - 1) * 1000, 5000));
                                break;
                            }
                        }
                        s.this.biw = this.bqP;
                        AppMethodBeat.o(95847);
                        return;
                        break;
                }
                AppMethodBeat.o(95847);
            }
        }

        private void execute() {
            AppMethodBeat.i(95848);
            this.bqP = null;
            s.this.bqJ.execute(s.this.bqK);
            AppMethodBeat.o(95848);
        }

        private void finish() {
            s.this.bqK = null;
        }
    }

    public interface c {
        void se();

        boolean sf();

        void sg();
    }

    public interface d {
        void rZ();
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            AppMethodBeat.i(95851);
            AppMethodBeat.o(95851);
        }
    }

    static final class e extends Handler implements Runnable {
        private final d bqT;

        public e(d dVar) {
            this.bqT = dVar;
        }

        public final void run() {
            AppMethodBeat.i(95849);
            sendEmptyMessage(0);
            AppMethodBeat.o(95849);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(95850);
            this.bqT.rZ();
            AppMethodBeat.o(95850);
        }
    }

    public s(String str) {
        AppMethodBeat.i(95852);
        this.bqJ = v.aO(str);
        AppMethodBeat.o(95852);
    }

    public final <T extends c> long a(T t, a<T> aVar, int i) {
        AppMethodBeat.i(95853);
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.i.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0);
        AppMethodBeat.o(95853);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.bqK != null;
    }

    public final void cancelLoading() {
        AppMethodBeat.i(95854);
        this.bqK.cancel(false);
        AppMethodBeat.o(95854);
    }

    public final boolean a(d dVar) {
        AppMethodBeat.i(95855);
        boolean z = false;
        if (this.bqK != null) {
            this.bqK.cancel(true);
            if (dVar != null) {
                this.bqJ.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.rZ();
            z = true;
        }
        this.bqJ.shutdown();
        AppMethodBeat.o(95855);
        return z;
    }
}
