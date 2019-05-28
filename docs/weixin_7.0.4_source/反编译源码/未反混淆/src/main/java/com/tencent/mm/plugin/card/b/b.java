package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements f {
    public byte[] eMl = new byte[0];
    public List<ak> kaA = am.baX().baU();
    public List<ak> kaB = new ArrayList();
    private s kaC;
    public List<WeakReference<d>> kaD = new ArrayList();

    public b() {
        AppMethodBeat.i(87630);
        ab.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", Integer.valueOf(this.kaA.size()));
        g.RO().eJo.a(559, (f) this);
        AppMethodBeat.o(87630);
    }

    public final void detach() {
        AppMethodBeat.i(87631);
        this.kaA.clear();
        this.kaB.clear();
        if (this.kaC != null) {
            g.RO().eJo.c(this.kaC);
        }
        g.RO().eJo.b(559, (f) this);
        AppMethodBeat.o(87631);
    }

    public final void a(ok okVar) {
        AppMethodBeat.i(87632);
        if (okVar == null) {
            ab.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
            AppMethodBeat.o(87632);
            return;
        }
        CardInfo Gu = am.baW().Gu(okVar.vUK);
        String str = "MicroMsg.BatchGetCardMgr";
        String str2 = "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d";
        Object[] objArr = new Object[3];
        objArr[0] = okVar.vUK;
        objArr[1] = Long.valueOf(Gu == null ? 0 : Gu.field_updateSeq);
        objArr[2] = Long.valueOf(okVar.vUL);
        ab.i(str, str2, objArr);
        if (Gu == null || Gu.field_updateSeq != okVar.vUL) {
            ak b = ak.b(okVar);
            synchronized (this.eMl) {
                try {
                    if (this.kaA.contains(b)) {
                    } else if (this.kaB.contains(b)) {
                        AppMethodBeat.o(87632);
                    } else {
                        this.kaA.add(b);
                        boolean b2 = am.baX().b((c) b);
                        ab.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", Boolean.valueOf(b2));
                        AppMethodBeat.o(87632);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(87632);
                }
            }
        } else {
            ab.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
            AppMethodBeat.o(87632);
        }
    }

    public final void bai() {
        AppMethodBeat.i(87633);
        if (this.kaA.size() == 0) {
            ab.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
            AppMethodBeat.o(87633);
        } else if (this.kaC != null) {
            ab.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
            AppMethodBeat.o(87633);
        } else {
            LinkedList linkedList = new LinkedList();
            if (this.kaA.size() <= 10) {
                linkedList.addAll(this.kaA);
            } else {
                linkedList.addAll(this.kaA.subList(0, 10));
            }
            this.kaC = new s(linkedList);
            g.RO().eJo.a(this.kaC, 0);
            AppMethodBeat.o(87633);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(87634);
        ab.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.kaC = null;
        LinkedList<ak> linkedList = ((s) mVar).kdY;
        al baX;
        if (i == 0 && i2 == 0) {
            String str2 = "MicroMsg.BatchGetCardMgr";
            String str3 = "onSceneEnd, batch get succ, remove succ id list, size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            ab.i(str2, str3, objArr);
            if (linkedList != null) {
                synchronized (this.eMl) {
                    try {
                        this.kaA.removeAll(linkedList);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(87634);
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = g.RP().eJN.iV(Thread.currentThread().getId());
            baX = am.baX();
            if (linkedList == null || linkedList.size() == 0) {
                ab.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
            } else {
                for (ak akVar : linkedList) {
                    if (akVar != null) {
                        baX.a((c) akVar, new String[0]);
                    }
                }
            }
            g.RP().eJN.mB(iV);
            ab.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            bai();
            if (this.kaD != null) {
                while (i3 < this.kaD.size()) {
                    WeakReference weakReference = (WeakReference) this.kaD.get(i3);
                    if (weakReference != null) {
                        d dVar = (d) weakReference.get();
                        if (dVar != null) {
                            dVar.bag();
                        }
                    }
                    i3++;
                }
            }
            AppMethodBeat.o(87634);
            return;
        }
        ab.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        synchronized (this.eMl) {
            if (linkedList != null) {
                try {
                    if (linkedList.size() > 0) {
                        this.kaA.removeAll(linkedList);
                        this.kaB.addAll(linkedList);
                    }
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(87634);
                    }
                }
            }
        }
        baX = am.baX();
        if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            AppMethodBeat.o(87634);
            return;
        }
        for (ak akVar2 : linkedList) {
            if (akVar2 != null) {
                akVar2.field_retryCount++;
                baX.c(akVar2, new String[0]);
            }
        }
        AppMethodBeat.o(87634);
    }

    public static void sO(int i) {
        AppMethodBeat.i(87635);
        g.RO().eJo.a(new w(i), 0);
        AppMethodBeat.o(87635);
    }

    public static void baj() {
        AppMethodBeat.i(87636);
        int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(1))).intValue();
        ab.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(intValue)));
        g.RO().eJo.a(new ad((double) am.bbc().ecs, (double) am.bbc().ect, intValue), 0);
        AppMethodBeat.o(87636);
    }
}
