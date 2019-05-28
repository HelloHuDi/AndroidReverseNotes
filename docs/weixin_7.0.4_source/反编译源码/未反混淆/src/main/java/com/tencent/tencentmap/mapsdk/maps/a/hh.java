package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hh {
    private ExecutorService a;
    private ExecutorService b;
    private hf c;
    private hg d;

    public void a(hf hfVar) {
        this.c = hfVar;
    }

    public void a(hg hgVar) {
        this.d = hgVar;
    }

    public void a() {
        AppMethodBeat.i(99533);
        a(null);
        AppMethodBeat.o(99533);
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(99534);
        this.c = null;
        if (this.a != null) {
            this.a.shutdown();
            this.a = null;
        }
        if (this.b != null) {
            this.b.shutdown();
            this.b = null;
        }
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(99534);
    }

    public void a(final String str) {
        AppMethodBeat.i(99535);
        if (this.c == null) {
            AppMethodBeat.o(99535);
            return;
        }
        if (this.a == null) {
            this.a = Executors.newFixedThreadPool(5);
        }
        try {
            if (!this.a.isShutdown()) {
                this.a.execute(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(99531);
                        hh.a(hh.this, str);
                        AppMethodBeat.o(99531);
                    }
                });
            }
            AppMethodBeat.o(99535);
        } catch (IllegalMonitorStateException e) {
            AppMethodBeat.o(99535);
        }
    }

    private void b(String str) {
        AppMethodBeat.i(99536);
        try {
            byte[] a = this.c.a(str);
            if (a != null && a.length == 0) {
                a = null;
            }
            a(str, a);
            AppMethodBeat.o(99536);
        } catch (Exception e) {
            a(str, null);
            AppMethodBeat.o(99536);
        }
    }

    private void a(final String str, final byte[] bArr) {
        AppMethodBeat.i(99537);
        if (this.d == null) {
            AppMethodBeat.o(99537);
            return;
        }
        if (this.b == null) {
            this.b = Executors.newSingleThreadExecutor();
        }
        if (!this.b.isShutdown()) {
            this.b.execute(new Runnable() {
                public void run() {
                    AppMethodBeat.i(99532);
                    try {
                        if (bArr == null) {
                            hh.this.d.c(str);
                        }
                        hh.this.d.a(str, bArr);
                        AppMethodBeat.o(99532);
                    } catch (Exception e) {
                        AppMethodBeat.o(99532);
                    }
                }
            });
        }
        AppMethodBeat.o(99537);
    }
}
