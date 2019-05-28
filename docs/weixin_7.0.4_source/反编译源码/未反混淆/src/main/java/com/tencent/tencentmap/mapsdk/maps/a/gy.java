package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class gy extends Thread {
    private gm a;
    private boolean b = false;
    private boolean c = false;
    private byte[] d = null;

    public gy(gm gmVar) {
        this.a = gmVar;
    }

    public void run() {
        AppMethodBeat.i(99499);
        while (!this.b) {
            if (this.c) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                } catch (Throwable th) {
                    AppMethodBeat.o(99499);
                }
            } else if (!d()) {
                try {
                    sleep(160);
                } catch (InterruptedException e2) {
                }
            }
        }
        c();
        if (this.d != null) {
            synchronized (this.d) {
                try {
                    this.d.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99499);
                }
            }
            return;
        }
        AppMethodBeat.o(99499);
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(99500);
        this.d = bArr;
        this.b = true;
        interrupt();
        AppMethodBeat.o(99500);
    }

    public void a() {
        this.c = true;
    }

    public void b() {
        AppMethodBeat.i(99501);
        this.c = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99501);
            }
        }
    }

    public void c() {
    }

    private boolean d() {
        AppMethodBeat.i(99502);
        if (this.a != null) {
            boolean j = this.a.j();
            AppMethodBeat.o(99502);
            return j;
        }
        AppMethodBeat.o(99502);
        return false;
    }
}
