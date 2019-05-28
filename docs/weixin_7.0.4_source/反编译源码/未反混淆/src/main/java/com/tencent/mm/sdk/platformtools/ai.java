package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai {
    public volatile boolean xzf;

    public ai() {
        this.xzf = false;
    }

    public ai(boolean z) {
        this.xzf = z;
    }

    public final void open() {
        AppMethodBeat.i(52058);
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
                AppMethodBeat.o(52058);
            }
        }
    }

    public final void close() {
        synchronized (this) {
            this.xzf = false;
        }
    }

    public final void block() {
        AppMethodBeat.i(52059);
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
                    AppMethodBeat.o(52059);
                }
            }
        }
    }

    public final boolean doJ() {
        AppMethodBeat.i(52060);
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
                    AppMethodBeat.o(52060);
                }
            }
            return z;
        }
        block();
        AppMethodBeat.o(52060);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(52061);
        String str = "MMConditionVariable[" + hashCode() + "," + this.xzf + "]";
        AppMethodBeat.o(52061);
        return str;
    }
}
