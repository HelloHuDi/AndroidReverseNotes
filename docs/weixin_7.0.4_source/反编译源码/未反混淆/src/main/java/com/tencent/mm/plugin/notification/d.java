package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d implements t {
    private static List<aq> oVx = new ArrayList();
    private List<bi> oVA;
    private boolean oVy;
    private boolean oVz;

    static {
        AppMethodBeat.i(125807);
        AppMethodBeat.o(125807);
    }

    public static void a(aq aqVar) {
        AppMethodBeat.i(125801);
        synchronized (oVx) {
            try {
                if (!oVx.contains(aqVar)) {
                    oVx.add(aqVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125801);
            }
        }
    }

    public static void b(aq aqVar) {
        AppMethodBeat.i(125802);
        synchronized (oVx) {
            try {
                oVx.remove(aqVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125802);
            }
        }
    }

    public d() {
        this(false);
    }

    public d(boolean z) {
        AppMethodBeat.i(125803);
        this.oVy = false;
        this.oVz = false;
        this.oVA = new LinkedList();
        this.oVy = z;
        this.oVz = false;
        this.oVA = new LinkedList();
        AppMethodBeat.o(125803);
    }

    public final void bOs() {
        AppMethodBeat.i(125804);
        final LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.oVA);
        this.oVA.clear();
        if (linkedList.size() == 0) {
            AppMethodBeat.o(125804);
            return;
        }
        ArrayList<aq> arrayList = new ArrayList();
        synchronized (oVx) {
            try {
                for (aq add : oVx) {
                    arrayList.add(add);
                }
            } finally {
                AppMethodBeat.o(125804);
            }
        }
        for (final aq add2 : arrayList) {
            new ak(add2.getLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125799);
                    add2.L(linkedList);
                    AppMethodBeat.o(125799);
                }
            });
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0033, code skipped:
            if (r6.field_isSend != 0) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:15:0x0038, code skipped:
            if (r6.field_status != 4) goto L_0x004d;
     */
    /* JADX WARNING: Missing block: B:16:0x003a, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
            com.tencent.matrix.trace.core.AppMethodBeat.o(125805);
     */
    /* JADX WARNING: Missing block: B:21:0x004d, code skipped:
            r0 = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XU().RA(new com.tencent.mm.storage.bq.a(com.tencent.mm.platformtools.aa.a(r7.vEB)).apT(""));
     */
    /* JADX WARNING: Missing block: B:22:0x006f, code skipped:
            if (r0 == null) goto L_0x0084;
     */
    /* JADX WARNING: Missing block: B:24:0x0075, code skipped:
            if (r0.dum() != false) goto L_0x0084;
     */
    /* JADX WARNING: Missing block: B:25:0x0077, code skipped:
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SyncMessageNotifier", "account no notification");
            com.tencent.matrix.trace.core.AppMethodBeat.o(125805);
     */
    /* JADX WARNING: Missing block: B:27:0x0086, code skipped:
            if (r5.oVz != false) goto L_0x00d7;
     */
    /* JADX WARNING: Missing block: B:28:0x0088, code skipped:
            r5.oVz = true;
            r1 = new java.util.ArrayList();
            r2 = oVx;
     */
    /* JADX WARNING: Missing block: B:29:0x0092, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r3 = oVx.iterator();
     */
    /* JADX WARNING: Missing block: B:33:0x009d, code skipped:
            if (r3.hasNext() == false) goto L_0x00af;
     */
    /* JADX WARNING: Missing block: B:34:0x009f, code skipped:
            r1.add((com.tencent.mm.model.aq) r3.next());
     */
    /* JADX WARNING: Missing block: B:36:0x00ab, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(125805);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:39:0x00b0, code skipped:
            r1 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:41:0x00b8, code skipped:
            if (r1.hasNext() == false) goto L_0x00d2;
     */
    /* JADX WARNING: Missing block: B:42:0x00ba, code skipped:
            r0 = (com.tencent.mm.model.aq) r1.next();
            new com.tencent.mm.sdk.platformtools.ak(r0.getLooper()).post(new com.tencent.mm.plugin.notification.d.AnonymousClass2(r5));
     */
    /* JADX WARNING: Missing block: B:43:0x00d7, code skipped:
            r5.oVA.add(r6);
            com.tencent.matrix.trace.core.AppMethodBeat.o(125805);
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:51:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final bi biVar, final cm cmVar) {
        AppMethodBeat.i(125805);
        if (this.oVy) {
            ab.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
            AppMethodBeat.o(125805);
            return;
        }
        synchronized (oVx) {
            try {
                if (oVx.isEmpty()) {
                    ab.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125805);
            }
        }
    }

    static /* synthetic */ String c(cm cmVar) {
        AppMethodBeat.i(125806);
        String a = aa.a(cmVar.vEB);
        String a2 = aa.a(cmVar.vEC);
        if (bo.isNullOrNil(a) || bo.isNullOrNil(a2)) {
            ab.e("MicroMsg.SyncMessageNotifier", "empty fromuser or touser");
            AppMethodBeat.o(125806);
            return null;
        }
        a2 = aa.a(cmVar.vED);
        if (bo.isNullOrNil(a2)) {
            AppMethodBeat.o(125806);
            return null;
        }
        if (com.tencent.mm.model.t.kH(a)) {
            int ox = bf.ox(a2);
            if (ox != -1) {
                a2 = (a2 + " ").substring(ox + 2).trim();
            }
        }
        a2 = bo.anj(a2);
        AppMethodBeat.o(125806);
        return a2;
    }
}
