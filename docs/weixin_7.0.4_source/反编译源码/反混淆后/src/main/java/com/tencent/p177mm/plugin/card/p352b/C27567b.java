package com.tencent.p177mm.plugin.card.p352b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.base.C42838d;
import com.tencent.p177mm.plugin.card.model.C11291s;
import com.tencent.p177mm.plugin.card.model.C20140ak;
import com.tencent.p177mm.plugin.card.model.C20141al;
import com.tencent.p177mm.plugin.card.model.C38750w;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.C45783ad;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.protocal.protobuf.C15370ok;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.b.b */
public final class C27567b implements C1202f {
    public byte[] eMl = new byte[0];
    public List<C20140ak> kaA = C42852am.baX().baU();
    public List<C20140ak> kaB = new ArrayList();
    private C11291s kaC;
    public List<WeakReference<C42838d>> kaD = new ArrayList();

    public C27567b() {
        AppMethodBeat.m2504i(87630);
        C4990ab.m7417i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", Integer.valueOf(this.kaA.size()));
        C1720g.m3535RO().eJo.mo14539a(559, (C1202f) this);
        AppMethodBeat.m2505o(87630);
    }

    public final void detach() {
        AppMethodBeat.m2504i(87631);
        this.kaA.clear();
        this.kaB.clear();
        if (this.kaC != null) {
            C1720g.m3535RO().eJo.mo14547c(this.kaC);
        }
        C1720g.m3535RO().eJo.mo14546b(559, (C1202f) this);
        AppMethodBeat.m2505o(87631);
    }

    /* renamed from: a */
    public final void mo45369a(C15370ok c15370ok) {
        AppMethodBeat.m2504i(87632);
        if (c15370ok == null) {
            C4990ab.m7412e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
            AppMethodBeat.m2505o(87632);
            return;
        }
        CardInfo Gu = C42852am.baW().mo45383Gu(c15370ok.vUK);
        String str = "MicroMsg.BatchGetCardMgr";
        String str2 = "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d";
        Object[] objArr = new Object[3];
        objArr[0] = c15370ok.vUK;
        objArr[1] = Long.valueOf(Gu == null ? 0 : Gu.field_updateSeq);
        objArr[2] = Long.valueOf(c15370ok.vUL);
        C4990ab.m7417i(str, str2, objArr);
        if (Gu == null || Gu.field_updateSeq != c15370ok.vUL) {
            C20140ak b = C20140ak.m31160b(c15370ok);
            synchronized (this.eMl) {
                try {
                    if (this.kaA.contains(b)) {
                    } else if (this.kaB.contains(b)) {
                        AppMethodBeat.m2505o(87632);
                    } else {
                        this.kaA.add(b);
                        boolean b2 = C42852am.baX().mo10101b((C4925c) b);
                        C4990ab.m7417i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", Boolean.valueOf(b2));
                        AppMethodBeat.m2505o(87632);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(87632);
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
            AppMethodBeat.m2505o(87632);
        }
    }

    public final void bai() {
        AppMethodBeat.m2504i(87633);
        if (this.kaA.size() == 0) {
            C4990ab.m7416i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
            AppMethodBeat.m2505o(87633);
        } else if (this.kaC != null) {
            C4990ab.m7416i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
            AppMethodBeat.m2505o(87633);
        } else {
            LinkedList linkedList = new LinkedList();
            if (this.kaA.size() <= 10) {
                linkedList.addAll(this.kaA);
            } else {
                linkedList.addAll(this.kaA.subList(0, 10));
            }
            this.kaC = new C11291s(linkedList);
            C1720g.m3535RO().eJo.mo14541a(this.kaC, 0);
            AppMethodBeat.m2505o(87633);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(87634);
        C4990ab.m7417i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.kaC = null;
        LinkedList<C20140ak> linkedList = ((C11291s) c1207m).kdY;
        C20141al baX;
        if (i == 0 && i2 == 0) {
            String str2 = "MicroMsg.BatchGetCardMgr";
            String str3 = "onSceneEnd, batch get succ, remove succ id list, size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            C4990ab.m7417i(str2, str3, objArr);
            if (linkedList != null) {
                synchronized (this.eMl) {
                    try {
                        this.kaA.removeAll(linkedList);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(87634);
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
            baX = C42852am.baX();
            if (linkedList == null || linkedList.size() == 0) {
                C4990ab.m7412e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
            } else {
                for (C20140ak c20140ak : linkedList) {
                    if (c20140ak != null) {
                        baX.mo16760a((C4925c) c20140ak, new String[0]);
                    }
                }
            }
            C1720g.m3536RP().eJN.mo15640mB(iV);
            C4990ab.m7417i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            bai();
            if (this.kaD != null) {
                while (i3 < this.kaD.size()) {
                    WeakReference weakReference = (WeakReference) this.kaD.get(i3);
                    if (weakReference != null) {
                        C42838d c42838d = (C42838d) weakReference.get();
                        if (c42838d != null) {
                            c42838d.bag();
                        }
                    }
                    i3++;
                }
            }
            AppMethodBeat.m2505o(87634);
            return;
        }
        C4990ab.m7413e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        synchronized (this.eMl) {
            if (linkedList != null) {
                try {
                    if (linkedList.size() > 0) {
                        this.kaA.removeAll(linkedList);
                        this.kaB.addAll(linkedList);
                    }
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(87634);
                    }
                }
            }
        }
        baX = C42852am.baX();
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            AppMethodBeat.m2505o(87634);
            return;
        }
        for (C20140ak c20140ak2 : linkedList) {
            if (c20140ak2 != null) {
                c20140ak2.field_retryCount++;
                baX.mo10103c(c20140ak2, new String[0]);
            }
        }
        AppMethodBeat.m2505o(87634);
    }

    /* renamed from: sO */
    public static void m43779sO(int i) {
        AppMethodBeat.m2504i(87635);
        C1720g.m3535RO().eJo.mo14541a(new C38750w(i), 0);
        AppMethodBeat.m2505o(87635);
    }

    public static void baj() {
        AppMethodBeat.m2504i(87636);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(1))).intValue();
        C4990ab.m7416i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(intValue)));
        C1720g.m3535RO().eJo.mo14541a(new C45783ad((double) C42852am.bbc().ecs, (double) C42852am.bbc().ect, intValue), 0);
        AppMethodBeat.m2505o(87636);
    }
}
