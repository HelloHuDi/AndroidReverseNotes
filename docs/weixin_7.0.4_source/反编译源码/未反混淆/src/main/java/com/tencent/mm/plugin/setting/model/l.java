package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class l {
    public final al eKj;
    Object mLock = new Object();
    public Runnable mRunnable;
    public boolean qjN;
    public boolean qjO;
    public boolean qjP;
    final CountDownLatch qjQ;
    HashSet<String> qjR = new HashSet();
    HashSet<String> qjS = new HashSet();
    HashSet<String> qjT = new HashSet();
    HashSet<String> qjU = new HashSet();
    public a qjV;
    public h qjW;
    public long qjX;

    class a implements f, Runnable {
        CountDownLatch countDownLatch;
        h qke;
        m qkf;
        long start;

        a(h hVar, CountDownLatch countDownLatch) {
            this.qke = hVar;
            this.countDownLatch = countDownLatch;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(126874);
            if (i == 0 && i2 == 0) {
                if (mVar.getType() == 292) {
                    this.qkf = mVar;
                    d.post(this, "load_unfamiliar_contact");
                }
                AppMethodBeat.o(126874);
                return;
            }
            ab.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            this.countDownLatch.countDown();
            AppMethodBeat.o(126874);
        }

        public final void run() {
            AppMethodBeat.i(126875);
            tx txVar = new tx();
            txVar.cPY.cQa = this.qkf;
            com.tencent.mm.sdk.b.a.xxA.m(txVar);
            int i = txVar.cPZ.state;
            List list = txVar.cPZ.cQb;
            String str = "MicroMsg.UnfamiliarContactEngine";
            String str2 = "[callback] state:%s,tagList is null?%s,tagList size:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(list == null);
            objArr[2] = Integer.valueOf(list == null ? 0 : list.size());
            ab.i(str, str2, objArr);
            if (i != 1) {
                if (list != null) {
                    l.this.qjU.addAll(list);
                }
                ab.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", Long.valueOf(System.currentTimeMillis() - this.start));
                this.countDownLatch.countDown();
                AppMethodBeat.o(126875);
                return;
            }
            if (this.qke != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(126872);
                        a.this.qke.a(e.OVER_ONE_MIN);
                        AppMethodBeat.o(126872);
                    }
                });
            }
            l.this.eKj.m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(126873);
                    a.cis();
                    AppMethodBeat.o(126873);
                }
            }, 30000);
            AppMethodBeat.o(126875);
        }

        static void cis() {
            AppMethodBeat.i(126876);
            ic icVar = new ic();
            icVar.cDb.cAd = 3;
            com.tencent.mm.sdk.b.a.xxA.m(icVar);
            AppMethodBeat.o(126876);
        }
    }

    public l(boolean z, boolean z2, boolean z3, h hVar) {
        AppMethodBeat.i(126877);
        this.qjN = z;
        this.qjO = z2;
        this.qjP = z3;
        ab.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", Integer.valueOf((this.qjP ? 1 : 0) + ((this.qjN ? 1 : 0) + (this.qjO ? 1 : 0))), Boolean.valueOf(this.qjO), Boolean.valueOf(this.qjN), Boolean.valueOf(this.qjP));
        this.qjQ = new CountDownLatch(r0);
        this.eKj = new al("UnfamiliarContactEngine");
        this.qjW = hVar;
        AppMethodBeat.o(126877);
    }

    /* Access modifiers changed, original: final */
    public final void g(LinkedList<String> linkedList, int i) {
        AppMethodBeat.i(126878);
        final long currentTimeMillis = System.currentTimeMillis();
        final int size = i + 10 < linkedList.size() ? i + 10 : linkedList.size();
        final List subList = linkedList.subList(i, size);
        i iVar = new i();
        iVar.hbo = 8;
        iVar.query = bo.c(subList, ",");
        final LinkedList<String> linkedList2 = linkedList;
        iVar.mEw = new com.tencent.mm.plugin.fts.a.l() {
            final int limit = size;

            public final void b(j jVar) {
                AppMethodBeat.i(126871);
                List list = jVar.mEy;
                String str;
                String str2;
                Object[] objArr;
                boolean z;
                int i;
                Object[] objArr2;
                Object[] objArr3;
                if (list == null || list.size() <= 0) {
                    str = "MicroMsg.UnfamiliarContactEngine";
                    str2 = "[getSameChatInfoTask] list is null? %s ";
                    objArr = new Object[1];
                    if (subList == null) {
                        z = true;
                        i = 0;
                        objArr2 = objArr;
                        objArr3 = objArr;
                    } else {
                        z = false;
                        i = 0;
                        objArr2 = objArr;
                        objArr3 = objArr;
                    }
                    objArr2[i] = Boolean.valueOf(z);
                    ab.e(str, str2, objArr3);
                } else {
                    com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) list.get(0);
                    if (lVar.userData == null || !(lVar.userData instanceof HashMap)) {
                        boolean z2;
                        str = "MicroMsg.UnfamiliarContactEngine";
                        str2 = "[getSameChatInfoTask] is null?%s is instanceof List";
                        objArr = new Object[2];
                        if (lVar.userData == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr[0] = Boolean.valueOf(z2);
                        z = lVar.userData instanceof HashMap;
                        i = 1;
                        objArr2 = objArr;
                        objArr3 = objArr;
                        objArr2[i] = Boolean.valueOf(z);
                        ab.e(str, str2, objArr3);
                    } else {
                        HashMap hashMap = (HashMap) lVar.userData;
                        synchronized (l.this.mLock) {
                            try {
                                for (String str3 : subList) {
                                    if (hashMap.containsKey(str3)) {
                                        int i2;
                                        for (com.tencent.mm.plugin.fts.a.a.l lVar2 : (List) hashMap.get(str3)) {
                                            if (lVar2.mEB < 100) {
                                                i2 = 1;
                                                break;
                                            }
                                        }
                                        i2 = 0;
                                        if (i2 == 0) {
                                            l.this.qjT.add(str3);
                                        }
                                    } else {
                                        l.this.qjT.add(str3);
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(126871);
                            }
                        }
                    }
                }
                if (this.limit >= linkedList2.size()) {
                    ab.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", Integer.valueOf(linkedList2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    l.this.qjQ.countDown();
                    AppMethodBeat.o(126871);
                    return;
                }
                l.this.g(linkedList2, this.limit);
                AppMethodBeat.o(126871);
            }
        };
        iVar.handler = this.eKj.doN();
        ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(126878);
    }

    static /* synthetic */ void a(l lVar, LinkedList linkedList) {
        AppMethodBeat.i(126879);
        if (lVar.qjO) {
            lVar.qjV = new a(lVar.qjW, lVar.qjQ);
            f fVar = lVar.qjV;
            fVar.start = System.currentTimeMillis();
            g.Rg().a(292, fVar);
            a.cis();
        }
        if (lVar.qjN) {
            final HashSet hashSet = new HashSet();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            final long currentTimeMillis = System.currentTimeMillis() - 15552000000L;
            ab.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] timestamp:%s size:%s", Long.valueOf(currentTimeMillis), Integer.valueOf(hashSet.size()));
            final long currentTimeMillis2 = System.currentTimeMillis();
            i iVar = new i();
            iVar.hbo = 9;
            iVar.query = String.valueOf(currentTimeMillis);
            iVar.mEw = new com.tencent.mm.plugin.fts.a.l() {
                public final void b(j jVar) {
                    AppMethodBeat.i(126869);
                    List<com.tencent.mm.plugin.fts.a.a.l> list = jVar.mEy;
                    if (list != null) {
                        for (com.tencent.mm.plugin.fts.a.a.l lVar : list) {
                            hashSet.remove(lVar.mDx);
                            l.this.qjS.add(lVar.mDx);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().r(str, currentTimeMillis, System.currentTimeMillis()) > 0) {
                            ab.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", str, Integer.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().r(str, currentTimeMillis, System.currentTimeMillis())));
                        } else {
                            Cursor a = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(str, currentTimeMillis, System.currentTimeMillis(), true);
                            if (a.getCount() > 0) {
                                Cursor a2 = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(str, currentTimeMillis, System.currentTimeMillis(), false);
                                if (a2.getCount() <= 0) {
                                    l.this.qjS.add(str);
                                }
                                a2.close();
                            } else {
                                l.this.qjS.add(str);
                            }
                            a.close();
                        }
                    }
                    ab.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    l.this.qjQ.countDown();
                    AppMethodBeat.o(126869);
                }
            };
            iVar.handler = lVar.eKj.doN();
            ((n) g.M(n.class)).search(2, iVar);
        }
        if (lVar.qjP) {
            lVar.g(linkedList, 0);
        }
        AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(126868);
                try {
                    l.this.qjQ.await();
                    long currentTimeMillis = System.currentTimeMillis();
                    l.this.qjR.clear();
                    l.this.qjS.remove(r.Yz());
                    l.this.qjR.addAll(l.this.qjS);
                    l.this.qjR.addAll(l.this.qjT);
                    l.this.qjR.addAll(l.this.qjU);
                    if (l.this.qjO) {
                        l.this.qjR.retainAll(l.this.qjU);
                    }
                    if (l.this.qjP) {
                        l.this.qjR.retainAll(l.this.qjT);
                    }
                    if (l.this.qjN) {
                        l.this.qjR.retainAll(l.this.qjS);
                    }
                    l.this.qjW.e(l.this.qjR);
                    ab.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(126866);
                            l.this.qjW.onSuccess();
                            AppMethodBeat.o(126866);
                        }
                    });
                    ab.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", Long.valueOf(System.currentTimeMillis() - l.this.qjX));
                    AppMethodBeat.o(126868);
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", e, "", new Object[0]);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(126867);
                            l.this.qjW.onError();
                            AppMethodBeat.o(126867);
                        }
                    });
                    AppMethodBeat.o(126868);
                }
            }
        };
        lVar.mRunnable = anonymousClass2;
        d.post(anonymousClass2, "MicroMsg.UnfamiliarContactEngineAwait");
        AppMethodBeat.o(126879);
    }
}
