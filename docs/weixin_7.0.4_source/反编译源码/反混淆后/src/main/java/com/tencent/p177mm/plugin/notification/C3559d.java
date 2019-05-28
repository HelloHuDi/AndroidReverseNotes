package com.tencent.p177mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C42184aq;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21280t;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.notification.d */
public final class C3559d implements C21280t {
    private static List<C42184aq> oVx = new ArrayList();
    private List<C7620bi> oVA;
    private boolean oVy;
    private boolean oVz;

    static {
        AppMethodBeat.m2504i(125807);
        AppMethodBeat.m2505o(125807);
    }

    /* renamed from: a */
    public static void m5893a(C42184aq c42184aq) {
        AppMethodBeat.m2504i(125801);
        synchronized (oVx) {
            try {
                if (!oVx.contains(c42184aq)) {
                    oVx.add(c42184aq);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125801);
            }
        }
    }

    /* renamed from: b */
    public static void m5894b(C42184aq c42184aq) {
        AppMethodBeat.m2504i(125802);
        synchronized (oVx) {
            try {
                oVx.remove(c42184aq);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125802);
            }
        }
    }

    public C3559d() {
        this(false);
    }

    public C3559d(boolean z) {
        AppMethodBeat.m2504i(125803);
        this.oVy = false;
        this.oVz = false;
        this.oVA = new LinkedList();
        this.oVy = z;
        this.oVz = false;
        this.oVA = new LinkedList();
        AppMethodBeat.m2505o(125803);
    }

    public final void bOs() {
        AppMethodBeat.m2504i(125804);
        final LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.oVA);
        this.oVA.clear();
        if (linkedList.size() == 0) {
            AppMethodBeat.m2505o(125804);
            return;
        }
        ArrayList<C42184aq> arrayList = new ArrayList();
        synchronized (oVx) {
            try {
                for (C42184aq add : oVx) {
                    arrayList.add(add);
                }
            } finally {
                AppMethodBeat.m2505o(125804);
            }
        }
        for (final C42184aq add2 : arrayList) {
            new C7306ak(add2.getLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(125799);
                    add2.mo27970L(linkedList);
                    AppMethodBeat.m2505o(125799);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(125805);
     */
    /* JADX WARNING: Missing block: B:21:0x004d, code skipped:
            r0 = ((com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j.class)).mo15372XU().mo15356RA(new com.tencent.p177mm.storage.C5140bq.C5139a(com.tencent.p177mm.platformtools.C1946aa.m4148a(r7.vEB)).apT(""));
     */
    /* JADX WARNING: Missing block: B:22:0x006f, code skipped:
            if (r0 == null) goto L_0x0084;
     */
    /* JADX WARNING: Missing block: B:24:0x0075, code skipped:
            if (r0.dum() != false) goto L_0x0084;
     */
    /* JADX WARNING: Missing block: B:25:0x0077, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.SyncMessageNotifier", "account no notification");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(125805);
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
            r1.add((com.tencent.p177mm.model.C42184aq) r3.next());
     */
    /* JADX WARNING: Missing block: B:36:0x00ab, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(125805);
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
            r0 = (com.tencent.p177mm.model.C42184aq) r1.next();
            new com.tencent.p177mm.sdk.platformtools.C7306ak(r0.getLooper()).post(new com.tencent.p177mm.plugin.notification.C3559d.C35612(r5));
     */
    /* JADX WARNING: Missing block: B:43:0x00d7, code skipped:
            r5.oVA.add(r6);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(125805);
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
    /* renamed from: a */
    public final void mo8118a(final C7620bi c7620bi, final C7254cm c7254cm) {
        AppMethodBeat.m2504i(125805);
        if (this.oVy) {
            C4990ab.m7416i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
            AppMethodBeat.m2505o(125805);
            return;
        }
        synchronized (oVx) {
            try {
                if (oVx.isEmpty()) {
                    C4990ab.m7416i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125805);
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ String m5895c(C7254cm c7254cm) {
        AppMethodBeat.m2504i(125806);
        String a = C1946aa.m4148a(c7254cm.vEB);
        String a2 = C1946aa.m4148a(c7254cm.vEC);
        if (C5046bo.isNullOrNil(a) || C5046bo.isNullOrNil(a2)) {
            C4990ab.m7412e("MicroMsg.SyncMessageNotifier", "empty fromuser or touser");
            AppMethodBeat.m2505o(125806);
            return null;
        }
        a2 = C1946aa.m4148a(c7254cm.vED);
        if (C5046bo.isNullOrNil(a2)) {
            AppMethodBeat.m2505o(125806);
            return null;
        }
        if (C1855t.m3896kH(a)) {
            int ox = C1829bf.m3761ox(a2);
            if (ox != -1) {
                a2 = (a2 + " ").substring(ox + 2).trim();
            }
        }
        a2 = C5046bo.anj(a2);
        AppMethodBeat.m2505o(125806);
        return a2;
    }
}
