package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.e;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements f {
    public byte[] eMl = new byte[0];
    public List<n> kaA = am.bbf().baU();
    public List<n> kaB = new ArrayList();
    private List<WeakReference<d>> kaD = new ArrayList();
    public e kfo;
    private int kfp = 0;
    public int kfq = 5;
    public ak mHandler = new ak(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        public final void run() {
            AppMethodBeat.i(87970);
            ab.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
            g.RO().eJo.a(new h(), 0);
            AppMethodBeat.o(87970);
        }
    };

    public a() {
        AppMethodBeat.i(87972);
        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", Integer.valueOf(this.kaA.size()));
        g.RO().eJo.a((int) i.SCENE_BIZ_SCROLL, (f) this);
        AppMethodBeat.o(87972);
    }

    public final void a(byy byy) {
        AppMethodBeat.i(87973);
        if (byy == null) {
            ab.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
            AppMethodBeat.o(87973);
            return;
        }
        ShareCardInfo GK = am.bbe().GK(byy.cMC);
        String str = "MicroMsg.ShareCardBatchGetCardMgr";
        String str2 = "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d";
        Object[] objArr = new Object[3];
        objArr[0] = byy.cMC;
        objArr[1] = Long.valueOf(GK == null ? 0 : GK.field_updateSeq);
        objArr[2] = Long.valueOf(byy.wYf);
        ab.i(str, str2, objArr);
        if (GK == null || GK.field_updateSeq != byy.wYf) {
            n c = n.c(byy);
            synchronized (this.eMl) {
                try {
                    if (this.kaA.contains(c)) {
                    } else if (this.kaB.contains(c)) {
                        AppMethodBeat.o(87973);
                    } else {
                        this.kaA.add(c);
                        boolean b = am.bbf().b((c) c);
                        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", Boolean.valueOf(b));
                        AppMethodBeat.o(87973);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(87973);
                }
            }
        } else {
            ab.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
            AppMethodBeat.o(87973);
        }
    }

    /* JADX WARNING: Missing block: B:11:0x002f, code skipped:
            if (r6.kfo == null) goto L_0x0044;
     */
    /* JADX WARNING: Missing block: B:12:0x0031, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
            com.tencent.matrix.trace.core.AppMethodBeat.o(87974);
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
            r4.add(((com.tencent.mm.plugin.card.sharecard.model.n) r3.get(r1)).field_card_id);
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:24:0x006d, code skipped:
            r3.addAll(r0.subList(0, 10));
     */
    /* JADX WARNING: Missing block: B:25:0x0075, code skipped:
            r6.kfo = new com.tencent.mm.plugin.card.sharecard.model.e(r4);
            com.tencent.mm.kernel.g.RO().eJo.a(r6.kfo, 0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(87974);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bai() {
        AppMethodBeat.i(87974);
        LinkedList linkedList = new LinkedList();
        synchronized (this.eMl) {
            try {
                if (this.kaA.size() == 0) {
                    ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, no pending cardinfo ,no need to get");
                } else {
                    linkedList.addAll(this.kaA);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87974);
            }
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87975);
        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.kfo = null;
        ArrayList<n> K;
        o bbf;
        if (i == 0 && i2 == 0) {
            K = K(((e) mVar).kdY);
            ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", Integer.valueOf(K.size()));
            synchronized (this.eMl) {
                try {
                    this.kaA.removeAll(K);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(87975);
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = g.RP().eJN.iV(Thread.currentThread().getId());
            bbf = am.bbf();
            if (K.size() == 0) {
                ab.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
            } else {
                for (n nVar : K) {
                    if (nVar != null) {
                        bbf.a((c) nVar, new String[0]);
                    }
                }
            }
            g.RP().eJN.mB(iV);
            ab.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            bai();
            aVU();
            AppMethodBeat.o(87975);
            return;
        }
        ab.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        K = K(((e) mVar).kdX);
        synchronized (this.eMl) {
            try {
                if (K.size() > 0) {
                    this.kaA.removeAll(K);
                    this.kaB.addAll(K);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87975);
            }
        }
        bbf = am.bbf();
        if (K.size() == 0) {
            ab.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
            return;
        }
        for (n nVar2 : K) {
            if (nVar2 != null) {
                nVar2.field_retryCount++;
                bbf.c(nVar2, new String[0]);
            }
        }
        AppMethodBeat.o(87975);
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
            if (r0.equals(((com.tencent.mm.plugin.card.sharecard.model.n) r6.get(r4)).field_card_id) == false) goto L_0x0062;
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(87976);
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ArrayList<n> K(LinkedList<String> linkedList) {
        AppMethodBeat.i(87976);
        ArrayList<n> arrayList = new ArrayList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (this.eMl) {
            try {
                if (this.kaA.size() == 0) {
                    ab.e("MicroMsg.ShareCardBatchGetCardMgr", "getSuccessShareCardSyncItem pendingList size is 0");
                } else {
                    linkedList2.addAll(this.kaA);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87976);
            }
        }
        return arrayList;
    }

    public final void bbr() {
        int i;
        AppMethodBeat.i(87977);
        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i2 = currentTimeMillis - this.kfp;
        if (this.kfq <= 0) {
            i = 5;
        } else {
            i = this.kfq;
        }
        if (i2 >= i) {
            g.RO().eJo.a(new h(), 0);
        } else {
            ab.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is ".concat(String.valueOf(i2)));
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, (long) (i * 1000));
        }
        this.kfp = currentTimeMillis;
        AppMethodBeat.o(87977);
    }

    public final void aVU() {
        AppMethodBeat.i(87978);
        if (this.kaD == null) {
            AppMethodBeat.o(87978);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    d dVar = (d) weakReference.get();
                    if (dVar != null) {
                        dVar.bag();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87978);
                return;
            }
        }
    }

    public final void a(d dVar) {
        AppMethodBeat.i(87979);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(dVar));
        AppMethodBeat.o(87979);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(87980);
        if (this.kaD == null) {
            AppMethodBeat.o(87980);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    d dVar2 = (d) weakReference.get();
                    if (dVar2 != null && dVar2.equals(dVar)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.o(87980);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87980);
                return;
            }
        }
    }
}
