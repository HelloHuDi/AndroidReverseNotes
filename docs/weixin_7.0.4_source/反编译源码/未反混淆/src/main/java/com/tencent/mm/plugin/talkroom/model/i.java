package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i {
    List<d> callbacks = new LinkedList();
    ak handler = new ak(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ String nKY;
        final /* synthetic */ String nKZ;

        AnonymousClass10(String str, String str2) {
            this.nKY = str;
            this.nKZ = str2;
        }

        public final void run() {
            AppMethodBeat.i(25856);
            synchronized (i.this.callbacks) {
                try {
                    for (d aU : i.this.callbacks) {
                        aU.aU(this.nKY, this.nKZ);
                    }
                } finally {
                    AppMethodBeat.o(25856);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.model.i$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String ejI;

        AnonymousClass11(String str) {
            this.ejI = str;
        }

        public final void run() {
            AppMethodBeat.i(25857);
            synchronized (i.this.callbacks) {
                try {
                    Iterator it = i.this.callbacks.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } finally {
                    AppMethodBeat.o(25857);
                }
            }
        }
    }

    public i() {
        AppMethodBeat.i(25859);
        AppMethodBeat.o(25859);
    }

    public final void akC() {
        AppMethodBeat.i(25860);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25847);
                synchronized (i.this.callbacks) {
                    try {
                        for (d akC : i.this.callbacks) {
                            akC.akC();
                        }
                    } finally {
                        AppMethodBeat.o(25847);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass1.run();
            AppMethodBeat.o(25860);
            return;
        }
        this.handler.post(anonymousClass1);
        AppMethodBeat.o(25860);
    }

    public final void l(final String str, final int i, final int i2) {
        AppMethodBeat.i(25861);
        AnonymousClass5 anonymousClass5 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25851);
                synchronized (i.this.callbacks) {
                    try {
                        for (d l : i.this.callbacks) {
                            l.l(str, i, i2);
                        }
                    } finally {
                        AppMethodBeat.o(25851);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass5.run();
            AppMethodBeat.o(25861);
            return;
        }
        this.handler.post(anonymousClass5);
        AppMethodBeat.o(25861);
    }

    public final void mk(final int i) {
        AppMethodBeat.i(25862);
        AnonymousClass7 anonymousClass7 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25853);
                synchronized (i.this.callbacks) {
                    try {
                        for (d mk : i.this.callbacks) {
                            mk.mk(i);
                        }
                    } finally {
                        AppMethodBeat.o(25853);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass7.run();
            AppMethodBeat.o(25862);
            return;
        }
        this.handler.post(anonymousClass7);
        AppMethodBeat.o(25862);
    }

    public final void tO(final String str) {
        AppMethodBeat.i(25863);
        AnonymousClass8 anonymousClass8 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25854);
                synchronized (i.this.callbacks) {
                    try {
                        for (d tO : i.this.callbacks) {
                            tO.tO(str);
                        }
                    } finally {
                        AppMethodBeat.o(25854);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass8.run();
            AppMethodBeat.o(25863);
            return;
        }
        this.handler.post(anonymousClass8);
        AppMethodBeat.o(25863);
    }

    public final void g(final int i, final int i2, final String str) {
        AppMethodBeat.i(25864);
        AnonymousClass9 anonymousClass9 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25855);
                synchronized (i.this.callbacks) {
                    try {
                        for (d g : i.this.callbacks) {
                            g.g(i, i2, str);
                        }
                    } finally {
                        AppMethodBeat.o(25855);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass9.run();
            AppMethodBeat.o(25864);
            return;
        }
        this.handler.post(anonymousClass9);
        AppMethodBeat.o(25864);
    }

    public final void akE() {
        AppMethodBeat.i(25865);
        AnonymousClass12 anonymousClass12 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25858);
                synchronized (i.this.callbacks) {
                    try {
                        for (d akE : i.this.callbacks) {
                            akE.akE();
                        }
                    } finally {
                        AppMethodBeat.o(25858);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass12.run();
            AppMethodBeat.o(25865);
            return;
        }
        this.handler.post(anonymousClass12);
        AppMethodBeat.o(25865);
    }

    public final void akH() {
        AppMethodBeat.i(25866);
        AnonymousClass4 anonymousClass4 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(25850);
                synchronized (i.this.callbacks) {
                    try {
                        for (d akH : i.this.callbacks) {
                            akH.akH();
                        }
                    } finally {
                        AppMethodBeat.o(25850);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass4.run();
            AppMethodBeat.o(25866);
            return;
        }
        this.handler.post(anonymousClass4);
        AppMethodBeat.o(25866);
    }
}
