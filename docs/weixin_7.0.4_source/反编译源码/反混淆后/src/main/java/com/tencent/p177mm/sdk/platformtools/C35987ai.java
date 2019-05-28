package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.ai */
public final class C35987ai {
    public volatile boolean xzf;

    public C35987ai() {
        this.xzf = false;
    }

    public C35987ai(boolean z) {
        this.xzf = z;
    }

    public final void open() {
        AppMethodBeat.m2504i(52058);
        synchronized (this) {
            try {
                boolean z = this.xzf;
                this.xzf = true;
                if (!z) {
                    notifyAll();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(52058);
            }
        }
    }

    public final void close() {
        synchronized (this) {
            this.xzf = false;
        }
    }

    public final void block() {
        AppMethodBeat.m2504i(52059);
        synchronized (this) {
            while (!this.xzf) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(52059);
                }
            }
        }
    }

    public final boolean doJ() {
        AppMethodBeat.m2504i(52060);
        if (500 != 0) {
            boolean z;
            synchronized (this) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = 500 + currentTimeMillis;
                    while (!this.xzf && currentTimeMillis < j) {
                        try {
                            wait(j - currentTimeMillis);
                        } catch (InterruptedException e) {
                        }
                        currentTimeMillis = System.currentTimeMillis();
                    }
                    z = this.xzf;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(52060);
                }
            }
            return z;
        }
        block();
        AppMethodBeat.m2505o(52060);
        return true;
    }

    public final String toString() {
        AppMethodBeat.m2504i(52061);
        String str = "MMConditionVariable[" + hashCode() + "," + this.xzf + "]";
        AppMethodBeat.m2505o(52061);
        return str;
    }
}
