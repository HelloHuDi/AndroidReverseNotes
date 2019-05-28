package com.google.android.gms.internal.measurement;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;

final class zzgk extends Thread {
    private final /* synthetic */ zzgg zzalz;
    private final Object zzamc = new Object();
    private final BlockingQueue<zzgj<?>> zzamd;

    public zzgk(zzgg zzgg, String str, BlockingQueue<zzgj<?>> blockingQueue) {
        this.zzalz = zzgg;
        AppMethodBeat.m2504i(69059);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzamd = blockingQueue;
        setName(str);
        AppMethodBeat.m2505o(69059);
    }

    private final void zza(InterruptedException interruptedException) {
        AppMethodBeat.m2504i(69062);
        this.zzalz.zzge().zzip().zzg(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        AppMethodBeat.m2505o(69062);
    }

    public final void run() {
        AppMethodBeat.m2504i(69060);
        Object obj = null;
        while (obj == null) {
            try {
                this.zzalz.zzalv.acquire();
                obj = 1;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzgj zzgj = (zzgj) this.zzamd.poll();
                if (zzgj != null) {
                    Process.setThreadPriority(zzgj.zzamb ? threadPriority : 10);
                    zzgj.run();
                } else {
                    synchronized (this.zzamc) {
                        try {
                            if (this.zzamd.peek() == null && !this.zzalz.zzalw) {
                                this.zzamc.wait(30000);
                            }
                        } catch (InterruptedException e2) {
                            zza(e2);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(69060);
                            throw th;
                        }
                    }
                    synchronized (this.zzalz.zzalu) {
                        if (this.zzamd.peek() == null) {
                            break;
                        }
                    }
                }
            }
            synchronized (this.zzalz.zzalu) {
                try {
                    this.zzalz.zzalv.release();
                    this.zzalz.zzalu.notifyAll();
                    if (this == this.zzalz.zzalo) {
                        this.zzalz.zzalo = null;
                    } else if (this == this.zzalz.zzalp) {
                        this.zzalz.zzalp = null;
                    } else {
                        this.zzalz.zzge().zzim().log("Current scheduler thread is neither worker nor network");
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.m2505o(69060);
                    throw th2;
                }
            }
            AppMethodBeat.m2505o(69060);
        } catch (Throwable th22) {
            AppMethodBeat.m2505o(69060);
            throw th22;
        }
    }

    public final void zzjn() {
        AppMethodBeat.m2504i(69061);
        synchronized (this.zzamc) {
            try {
                this.zzamc.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69061);
            }
        }
    }
}
