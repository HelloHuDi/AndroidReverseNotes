package com.tencent.p177mm.plugin.appbrand.p329s;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.report.C42672h;
import com.tencent.p177mm.sdk.p602d.C4886a;
import com.tencent.p177mm.sdk.p602d.C4887d;
import com.tencent.p177mm.sdk.p602d.C7292c;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.appbrand.s.h */
public abstract class C27292h<Task> extends C4887d {
    final C27291b iRp = new C27291b(this, (byte) 0);
    private final C19713a iRq = new C19713a(this, (byte) 0);
    final String iRr;
    private final Queue<Task> iRs = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.appbrand.s.h$a */
    final class C19713a extends C42672h {
        private C19713a() {
        }

        /* synthetic */ C19713a(C27292h c27292h, byte b) {
            this();
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(73196);
            if (2 == message.what) {
                C27292h.this.mo10075b((C4886a) C27292h.this.iRp);
                AppMethodBeat.m2505o(73196);
                return true;
            }
            boolean k = super.mo10090k(message);
            AppMethodBeat.m2505o(73196);
            return k;
        }

        public final String getName() {
            AppMethodBeat.m2504i(73197);
            String str = C27292h.this.iRr + "|StateExecuting";
            AppMethodBeat.m2505o(73197);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.h$b */
    final class C27291b extends C42672h {
        private C27291b() {
        }

        /* synthetic */ C27291b(C27292h c27292h, byte b) {
            this();
        }

        public final void enter() {
            AppMethodBeat.m2504i(73198);
            super.enter();
            C27292h.m43328a(C27292h.this);
            AppMethodBeat.m2505o(73198);
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(73199);
            if (1 == message.what || 2 == message.what) {
                C27292h.m43328a(C27292h.this);
                AppMethodBeat.m2505o(73199);
                return true;
            }
            boolean k = super.mo10090k(message);
            AppMethodBeat.m2505o(73199);
            return k;
        }

        public final String getName() {
            AppMethodBeat.m2504i(73200);
            String str = C27292h.this.iRr + "|StateIdle";
            AppMethodBeat.m2505o(73200);
            return str;
        }
    }

    public abstract boolean aCD();

    /* renamed from: bu */
    public abstract void mo15053bu(Task task);

    protected C27292h(String str, Looper looper) {
        super(str, looper);
        this.iRr = str;
        mo10073a(this.iRp);
        mo10073a(this.iRq);
        mo10076b((C7292c) this.iRp);
        start();
    }

    /* renamed from: bF */
    public final void mo44978bF(Task task) {
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

    /* renamed from: a */
    static /* synthetic */ void m43328a(C27292h c27292h) {
        Object poll;
        synchronized (c27292h.iRs) {
            poll = c27292h.iRs.poll();
        }
        if (poll != null) {
            c27292h.mo10075b((C4886a) c27292h.iRq);
            c27292h.mo15053bu(poll);
        }
    }
}
