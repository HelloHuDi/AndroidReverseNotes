package com.google.android.exoplayer2.p110h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C41619t;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.android.exoplayer2.h.s */
public final class C41613s {
    IOException biw;
    final ExecutorService bqJ;
    C32058b<? extends C32059c> bqK;

    /* renamed from: com.google.android.exoplayer2.h.s$a */
    public interface C8683a<T extends C32059c> {
        /* renamed from: a */
        int mo2603a(T t, long j, long j2, IOException iOException);

        /* renamed from: a */
        void mo2604a(T t, long j, long j2);

        /* renamed from: a */
        void mo2605a(T t, long j, long j2, boolean z);
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.exoplayer2.h.s$b */
    final class C32058b<T extends C32059c> extends Handler implements Runnable {
        private final T bqL;
        private final C8683a<T> bqM;
        public final int bqN;
        private final long bqO;
        private IOException bqP;
        private int bqQ;
        private volatile Thread bqR;
        private volatile boolean released;

        public C32058b(Looper looper, T t, C8683a<T> c8683a, int i, long j) {
            super(looper);
            this.bqL = t;
            this.bqM = c8683a;
            this.bqN = i;
            this.bqO = j;
        }

        public final void start(long j) {
            AppMethodBeat.m2504i(95844);
            C45039a.checkState(C41613s.this.bqK == null);
            C41613s.this.bqK = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
                AppMethodBeat.m2505o(95844);
                return;
            }
            execute();
            AppMethodBeat.m2505o(95844);
        }

        public final void cancel(boolean z) {
            AppMethodBeat.m2504i(95845);
            this.released = z;
            this.bqP = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.bqL.mo19287se();
                if (this.bqR != null) {
                    this.bqR.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.bqM.mo2605a(this.bqL, elapsedRealtime, elapsedRealtime - this.bqO, true);
            }
            AppMethodBeat.m2505o(95845);
        }

        public final void run() {
            AppMethodBeat.m2504i(95846);
            try {
                this.bqR = Thread.currentThread();
                if (!this.bqL.mo19288sf()) {
                    C41619t.beginSection("load:" + this.bqL.getClass().getSimpleName());
                    this.bqL.mo19289sg();
                    C41619t.endSection();
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
                AppMethodBeat.m2505o(95846);
            } catch (IOException e) {
                if (!this.released) {
                    obtainMessage(3, e).sendToTarget();
                }
                AppMethodBeat.m2505o(95846);
            } catch (InterruptedException e2) {
                C45039a.checkState(this.bqL.mo19288sf());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
                AppMethodBeat.m2505o(95846);
            } catch (Exception e3) {
                if (!this.released) {
                    obtainMessage(3, new C32061f(e3)).sendToTarget();
                }
                AppMethodBeat.m2505o(95846);
            } catch (OutOfMemoryError e4) {
                if (!this.released) {
                    obtainMessage(3, new C32061f(e4)).sendToTarget();
                }
                AppMethodBeat.m2505o(95846);
            } catch (Error e5) {
                if (!this.released) {
                    obtainMessage(4, e5).sendToTarget();
                }
                AppMethodBeat.m2505o(95846);
                throw e5;
            } catch (Throwable th) {
                C41619t.endSection();
                AppMethodBeat.m2505o(95846);
            }
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(95847);
            if (this.released) {
                AppMethodBeat.m2505o(95847);
            } else if (message.what == 0) {
                execute();
                AppMethodBeat.m2505o(95847);
            } else if (message.what == 4) {
                Error error = (Error) message.obj;
                AppMethodBeat.m2505o(95847);
                throw error;
            } else {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.bqO;
                if (this.bqL.mo19288sf()) {
                    this.bqM.mo2605a(this.bqL, elapsedRealtime, j, false);
                    AppMethodBeat.m2505o(95847);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.bqM.mo2605a(this.bqL, elapsedRealtime, j, false);
                        AppMethodBeat.m2505o(95847);
                        return;
                    case 2:
                        this.bqM.mo2604a(this.bqL, elapsedRealtime, j);
                        AppMethodBeat.m2505o(95847);
                        return;
                    case 3:
                        this.bqP = (IOException) message.obj;
                        int a = this.bqM.mo2603a(this.bqL, elapsedRealtime, j, this.bqP);
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
                        C41613s.this.biw = this.bqP;
                        AppMethodBeat.m2505o(95847);
                        return;
                        break;
                }
                AppMethodBeat.m2505o(95847);
            }
        }

        private void execute() {
            AppMethodBeat.m2504i(95848);
            this.bqP = null;
            C41613s.this.bqJ.execute(C41613s.this.bqK);
            AppMethodBeat.m2505o(95848);
        }

        private void finish() {
            C41613s.this.bqK = null;
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.s$c */
    public interface C32059c {
        /* renamed from: se */
        void mo19287se();

        /* renamed from: sf */
        boolean mo19288sf();

        /* renamed from: sg */
        void mo19289sg();
    }

    /* renamed from: com.google.android.exoplayer2.h.s$d */
    public interface C32060d {
        /* renamed from: rZ */
        void mo52350rZ();
    }

    /* renamed from: com.google.android.exoplayer2.h.s$f */
    public static final class C32061f extends IOException {
        public C32061f(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            AppMethodBeat.m2504i(95851);
            AppMethodBeat.m2505o(95851);
        }
    }

    /* renamed from: com.google.android.exoplayer2.h.s$e */
    static final class C37262e extends Handler implements Runnable {
        private final C32060d bqT;

        public C37262e(C32060d c32060d) {
            this.bqT = c32060d;
        }

        public final void run() {
            AppMethodBeat.m2504i(95849);
            sendEmptyMessage(0);
            AppMethodBeat.m2505o(95849);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(95850);
            this.bqT.mo52350rZ();
            AppMethodBeat.m2505o(95850);
        }
    }

    public C41613s(String str) {
        AppMethodBeat.m2504i(95852);
        this.bqJ = C17675v.m27557aO(str);
        AppMethodBeat.m2505o(95852);
    }

    /* renamed from: a */
    public final <T extends C32059c> long mo66741a(T t, C8683a<T> c8683a, int i) {
        AppMethodBeat.m2504i(95853);
        Looper myLooper = Looper.myLooper();
        C45039a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new C32058b(myLooper, t, c8683a, i, elapsedRealtime).start(0);
        AppMethodBeat.m2505o(95853);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.bqK != null;
    }

    public final void cancelLoading() {
        AppMethodBeat.m2504i(95854);
        this.bqK.cancel(false);
        AppMethodBeat.m2505o(95854);
    }

    /* renamed from: a */
    public final boolean mo66742a(C32060d c32060d) {
        AppMethodBeat.m2504i(95855);
        boolean z = false;
        if (this.bqK != null) {
            this.bqK.cancel(true);
            if (c32060d != null) {
                this.bqJ.execute(new C37262e(c32060d));
            }
        } else if (c32060d != null) {
            c32060d.mo52350rZ();
            z = true;
        }
        this.bqJ.shutdown();
        AppMethodBeat.m2505o(95855);
        return z;
    }
}
