package com.tencent.p177mm.plugin.card.sharecard.p932a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.base.C42838d;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.sharecard.model.C38753o;
import com.tencent.p177mm.plugin.card.sharecard.model.C42859h;
import com.tencent.p177mm.plugin.card.sharecard.model.C45789e;
import com.tencent.p177mm.plugin.card.sharecard.model.C46901n;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.protocal.protobuf.byy;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.sharecard.a.a */
public final class C42855a implements C1202f {
    public byte[] eMl = new byte[0];
    public List<C46901n> kaA = C42852am.bbf().baU();
    public List<C46901n> kaB = new ArrayList();
    private List<WeakReference<C42838d>> kaD = new ArrayList();
    public C45789e kfo;
    private int kfp = 0;
    public int kfq = 5;
    public C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    private Runnable mRunnable = new C112941();

    /* renamed from: com.tencent.mm.plugin.card.sharecard.a.a$1 */
    class C112941 implements Runnable {
        C112941() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87970);
            C4990ab.m7416i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
            C1720g.m3535RO().eJo.mo14541a(new C42859h(), 0);
            AppMethodBeat.m2505o(87970);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.a.a$2 */
    public class C337732 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(87971);
            C1720g.m3535RO().eJo.mo14541a(new C42859h(), 0);
            AppMethodBeat.m2505o(87971);
        }
    }

    public C42855a() {
        AppMethodBeat.m2504i(87972);
        C4990ab.m7417i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", Integer.valueOf(this.kaA.size()));
        C1720g.m3535RO().eJo.mo14539a((int) C1625i.SCENE_BIZ_SCROLL, (C1202f) this);
        AppMethodBeat.m2505o(87972);
    }

    /* renamed from: a */
    public final void mo68359a(byy byy) {
        AppMethodBeat.m2504i(87973);
        if (byy == null) {
            C4990ab.m7412e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
            AppMethodBeat.m2505o(87973);
            return;
        }
        ShareCardInfo GK = C42852am.bbe().mo35397GK(byy.cMC);
        String str = "MicroMsg.ShareCardBatchGetCardMgr";
        String str2 = "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d";
        Object[] objArr = new Object[3];
        objArr[0] = byy.cMC;
        objArr[1] = Long.valueOf(GK == null ? 0 : GK.field_updateSeq);
        objArr[2] = Long.valueOf(byy.wYf);
        C4990ab.m7417i(str, str2, objArr);
        if (GK == null || GK.field_updateSeq != byy.wYf) {
            C46901n c = C46901n.m89271c(byy);
            synchronized (this.eMl) {
                try {
                    if (this.kaA.contains(c)) {
                    } else if (this.kaB.contains(c)) {
                        AppMethodBeat.m2505o(87973);
                    } else {
                        this.kaA.add(c);
                        boolean b = C42852am.bbf().mo10101b((C4925c) c);
                        C4990ab.m7417i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", Boolean.valueOf(b));
                        AppMethodBeat.m2505o(87973);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(87973);
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
            AppMethodBeat.m2505o(87973);
        }
    }

    /* JADX WARNING: Missing block: B:11:0x002f, code skipped:
            if (r6.kfo == null) goto L_0x0044;
     */
    /* JADX WARNING: Missing block: B:12:0x0031, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(87974);
     */
    /* JADX WARNING: Missing block: B:17:0x0044, code skipped:
            r3 = new java.util.LinkedList();
     */
    /* JADX WARNING: Missing block: B:18:0x004d, code skipped:
            if (r0.size() > 10) goto L_0x006d;
     */
    /* JADX WARNING: Missing block: B:19:0x004f, code skipped:
            r3.addAll(r0);
     */
    /* JADX WARNING: Missing block: B:20:0x0052, code skipped:
            r4 = new java.util.LinkedList();
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:22:0x005c, code skipped:
            if (r1 >= r3.size()) goto L_0x0075;
     */
    /* JADX WARNING: Missing block: B:23:0x005e, code skipped:
            r4.add(((com.tencent.p177mm.plugin.card.sharecard.model.C46901n) r3.get(r1)).field_card_id);
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:24:0x006d, code skipped:
            r3.addAll(r0.subList(0, 10));
     */
    /* JADX WARNING: Missing block: B:25:0x0075, code skipped:
            r6.kfo = new com.tencent.p177mm.plugin.card.sharecard.model.C45789e(r4);
            com.tencent.p177mm.kernel.C1720g.m3535RO().eJo.mo14541a(r6.kfo, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(87974);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bai() {
        AppMethodBeat.m2504i(87974);
        LinkedList linkedList = new LinkedList();
        synchronized (this.eMl) {
            try {
                if (this.kaA.size() == 0) {
                    C4990ab.m7416i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
                } else {
                    linkedList.addAll(this.kaA);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87974);
            }
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87975);
        C4990ab.m7417i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.kfo = null;
        ArrayList<C46901n> K;
        C38753o bbf;
        if (i == 0 && i2 == 0) {
            K = m76067K(((C45789e) c1207m).kdY);
            C4990ab.m7417i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", Integer.valueOf(K.size()));
            synchronized (this.eMl) {
                try {
                    this.kaA.removeAll(K);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(87975);
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
            bbf = C42852am.bbf();
            if (K.size() == 0) {
                C4990ab.m7412e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
            } else {
                for (C46901n c46901n : K) {
                    if (c46901n != null) {
                        bbf.mo16760a((C4925c) c46901n, new String[0]);
                    }
                }
            }
            C1720g.m3536RP().eJN.mo15640mB(iV);
            C4990ab.m7417i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            bai();
            aVU();
            AppMethodBeat.m2505o(87975);
            return;
        }
        C4990ab.m7413e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        K = m76067K(((C45789e) c1207m).kdX);
        synchronized (this.eMl) {
            try {
                if (K.size() > 0) {
                    this.kaA.removeAll(K);
                    this.kaB.addAll(K);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87975);
            }
        }
        bbf = C42852am.bbf();
        if (K.size() == 0) {
            C4990ab.m7412e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
            return;
        }
        for (C46901n c46901n2 : K) {
            if (c46901n2 != null) {
                c46901n2.field_retryCount++;
                bbf.mo10103c(c46901n2, new String[0]);
            }
        }
        AppMethodBeat.m2505o(87975);
    }

    /* JADX WARNING: Missing block: B:10:0x0031, code skipped:
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:12:0x0036, code skipped:
            if (r2 >= r9.size()) goto L_0x0070;
     */
    /* JADX WARNING: Missing block: B:13:0x0038, code skipped:
            r0 = (java.lang.String) r9.get(r2);
            r4 = 0;
     */
    /* JADX WARNING: Missing block: B:15:0x0043, code skipped:
            if (r4 >= r6.size()) goto L_0x006c;
     */
    /* JADX WARNING: Missing block: B:16:0x0045, code skipped:
            if (r0 == null) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:18:0x004b, code skipped:
            if (r6.get(r4) == null) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:20:0x0059, code skipped:
            if (r0.equals(((com.tencent.p177mm.plugin.card.sharecard.model.C46901n) r6.get(r4)).field_card_id) == false) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:21:0x005b, code skipped:
            r5.add(r6.get(r4));
     */
    /* JADX WARNING: Missing block: B:22:0x0062, code skipped:
            r4 = r4 + 1;
     */
    /* JADX WARNING: Missing block: B:27:0x006c, code skipped:
            r2 = r2 + 1;
     */
    /* JADX WARNING: Missing block: B:28:0x0070, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(87976);
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: K */
    private ArrayList<C46901n> m76067K(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(87976);
        ArrayList<C46901n> arrayList = new ArrayList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (this.eMl) {
            try {
                if (this.kaA.size() == 0) {
                    C4990ab.m7412e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
                } else {
                    linkedList2.addAll(this.kaA);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87976);
            }
        }
        return arrayList;
    }

    public final void bbr() {
        int i;
        AppMethodBeat.m2504i(87977);
        C4990ab.m7416i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i2 = currentTimeMillis - this.kfp;
        if (this.kfq <= 0) {
            i = 5;
        } else {
            i = this.kfq;
        }
        if (i2 >= i) {
            C1720g.m3535RO().eJo.mo14541a(new C42859h(), 0);
        } else {
            C4990ab.m7416i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is ".concat(String.valueOf(i2)));
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, (long) (i * 1000));
        }
        this.kfp = currentTimeMillis;
        AppMethodBeat.m2505o(87977);
    }

    public final void aVU() {
        AppMethodBeat.m2504i(87978);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87978);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C42838d c42838d = (C42838d) weakReference.get();
                    if (c42838d != null) {
                        c42838d.bag();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87978);
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo68358a(C42838d c42838d) {
        AppMethodBeat.m2504i(87979);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(c42838d));
        AppMethodBeat.m2505o(87979);
    }

    /* renamed from: b */
    public final void mo68361b(C42838d c42838d) {
        AppMethodBeat.m2504i(87980);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87980);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C42838d c42838d2 = (C42838d) weakReference.get();
                    if (c42838d2 != null && c42838d2.equals(c42838d)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.m2505o(87980);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87980);
                return;
            }
        }
    }
}
