package com.tencent.mm.plugin.appbrand.s;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class h<Task> extends d {
    final b iRp = new b(this, (byte) 0);
    private final a iRq = new a(this, (byte) 0);
    final String iRr;
    private final Queue<Task> iRs = new LinkedList();

    final class a extends com.tencent.mm.plugin.appbrand.report.h {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(73196);
            if (2 == message.what) {
                h.this.b((com.tencent.mm.sdk.d.a) h.this.iRp);
                AppMethodBeat.o(73196);
                return true;
            }
            boolean k = super.k(message);
            AppMethodBeat.o(73196);
            return k;
        }

        public final String getName() {
            AppMethodBeat.i(73197);
            String str = h.this.iRr + "|StateExecuting";
            AppMethodBeat.o(73197);
            return str;
        }
    }

    final class b extends com.tencent.mm.plugin.appbrand.report.h {
        private b() {
        }

        /* synthetic */ b(h hVar, byte b) {
            this();
        }

        public final void enter() {
            AppMethodBeat.i(73198);
            super.enter();
            h.a(h.this);
            AppMethodBeat.o(73198);
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(73199);
            if (1 == message.what || 2 == message.what) {
                h.a(h.this);
                AppMethodBeat.o(73199);
                return true;
            }
            boolean k = super.k(message);
            AppMethodBeat.o(73199);
            return k;
        }

        public final String getName() {
            AppMethodBeat.i(73200);
            String str = h.this.iRr + "|StateIdle";
            AppMethodBeat.o(73200);
            return str;
        }
    }

    public abstract boolean aCD();

    public abstract void bu(Task task);

    protected h(String str, Looper looper) {
        super(str, looper);
        this.iRr = str;
        a(this.iRp);
        a(this.iRq);
        b((c) this.iRp);
        start();
    }

    public final void bF(Task task) {
        if (!aCD()) {
            synchronized (this.iRs) {
                this.iRs.offer(task);
            }
            sendMessage(1);
        }
    }

    public final void avC() {
        super.avC();
        synchronized (this.iRs) {
            this.iRs.clear();
        }
    }

    static /* synthetic */ void a(h hVar) {
        Object poll;
        synchronized (hVar.iRs) {
            poll = hVar.iRs.poll();
        }
        if (poll != null) {
            hVar.b((com.tencent.mm.sdk.d.a) hVar.iRq);
            hVar.bu(poll);
        }
    }
}
