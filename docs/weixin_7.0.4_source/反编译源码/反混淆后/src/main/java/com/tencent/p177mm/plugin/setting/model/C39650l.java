package com.tencent.p177mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26247tx;
import com.tencent.p177mm.p230g.p231a.C9379ic;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.setting.p505ui.setting.UnfamiliarContactDetailUI.C21804h;
import com.tencent.p177mm.plugin.setting.p505ui.setting.UnfamiliarContactDetailUI.C21823e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.mm.plugin.setting.model.l */
public final class C39650l {
    public final C5004al eKj;
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
    public C39652a qjV;
    public C21804h qjW;
    public long qjX;

    /* renamed from: com.tencent.mm.plugin.setting.model.l$2 */
    class C131912 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.setting.model.l$2$2 */
        class C131902 implements Runnable {
            C131902() {
            }

            public final void run() {
                AppMethodBeat.m2504i(126867);
                C39650l.this.qjW.onError();
                AppMethodBeat.m2505o(126867);
            }
        }

        /* renamed from: com.tencent.mm.plugin.setting.model.l$2$1 */
        class C131921 implements Runnable {
            C131921() {
            }

            public final void run() {
                AppMethodBeat.m2504i(126866);
                C39650l.this.qjW.onSuccess();
                AppMethodBeat.m2505o(126866);
            }
        }

        C131912() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126868);
            try {
                C39650l.this.qjQ.await();
                long currentTimeMillis = System.currentTimeMillis();
                C39650l.this.qjR.clear();
                C39650l.this.qjS.remove(C1853r.m3846Yz());
                C39650l.this.qjR.addAll(C39650l.this.qjS);
                C39650l.this.qjR.addAll(C39650l.this.qjT);
                C39650l.this.qjR.addAll(C39650l.this.qjU);
                if (C39650l.this.qjO) {
                    C39650l.this.qjR.retainAll(C39650l.this.qjU);
                }
                if (C39650l.this.qjP) {
                    C39650l.this.qjR.retainAll(C39650l.this.qjT);
                }
                if (C39650l.this.qjN) {
                    C39650l.this.qjR.retainAll(C39650l.this.qjS);
                }
                C39650l.this.qjW.mo37273e(C39650l.this.qjR);
                C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                C5004al.m7441d(new C131921());
                C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", Long.valueOf(System.currentTimeMillis() - C39650l.this.qjX));
                AppMethodBeat.m2505o(126868);
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", e, "", new Object[0]);
                C5004al.m7441d(new C131902());
                AppMethodBeat.m2505o(126868);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.model.l$1 */
    public class C348491 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(126865);
            C39650l c39650l = C39650l.this;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList = new LinkedList();
            C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
            String str = "@all.contact.without.chatroom";
            ArrayList arrayList = new ArrayList();
            arrayList.add("tmessage");
            arrayList.add("officialaccounts");
            arrayList.add("filehelper");
            arrayList.add("helper_entry");
            arrayList.add(C1853r.m3846Yz());
            C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
            if (RA != null) {
                arrayList.add(RA.name);
            }
            arrayList.add("blogapp");
            Cursor a = XM.mo15703a(str, null, arrayList, null, false, false);
            if (a != null) {
                a.moveToFirst();
                while (!a.isAfterLast()) {
                    C7616ad c7616ad = new C7616ad();
                    c7616ad.mo8995d(a);
                    linkedList.add(c7616ad.field_username);
                    a.moveToNext();
                }
                a.close();
            }
            C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList.size()));
            C39650l.m67769a(c39650l, linkedList);
            AppMethodBeat.m2505o(126865);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.model.l$a */
    class C39652a implements C1202f, Runnable {
        CountDownLatch countDownLatch;
        C21804h qke;
        C1207m qkf;
        long start;

        /* renamed from: com.tencent.mm.plugin.setting.model.l$a$1 */
        class C131931 implements Runnable {
            C131931() {
            }

            public final void run() {
                AppMethodBeat.m2504i(126872);
                C39652a.this.qke.mo37272a(C21823e.OVER_ONE_MIN);
                AppMethodBeat.m2505o(126872);
            }
        }

        /* renamed from: com.tencent.mm.plugin.setting.model.l$a$2 */
        class C289322 implements Runnable {
            C289322() {
            }

            public final void run() {
                AppMethodBeat.m2504i(126873);
                C39652a.cis();
                AppMethodBeat.m2505o(126873);
            }
        }

        C39652a(C21804h c21804h, CountDownLatch countDownLatch) {
            this.qke = c21804h;
            this.countDownLatch = countDownLatch;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(126874);
            if (i == 0 && i2 == 0) {
                if (c1207m.getType() == 292) {
                    this.qkf = c1207m;
                    C7305d.post(this, "load_unfamiliar_contact");
                }
                AppMethodBeat.m2505o(126874);
                return;
            }
            C4990ab.m7413e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            this.countDownLatch.countDown();
            AppMethodBeat.m2505o(126874);
        }

        public final void run() {
            AppMethodBeat.m2504i(126875);
            C26247tx c26247tx = new C26247tx();
            c26247tx.cPY.cQa = this.qkf;
            C4879a.xxA.mo10055m(c26247tx);
            int i = c26247tx.cPZ.state;
            List list = c26247tx.cPZ.cQb;
            String str = "MicroMsg.UnfamiliarContactEngine";
            String str2 = "[callback] state:%s,tagList is null?%s,tagList size:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(list == null);
            objArr[2] = Integer.valueOf(list == null ? 0 : list.size());
            C4990ab.m7417i(str, str2, objArr);
            if (i != 1) {
                if (list != null) {
                    C39650l.this.qjU.addAll(list);
                }
                C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", Long.valueOf(System.currentTimeMillis() - this.start));
                this.countDownLatch.countDown();
                AppMethodBeat.m2505o(126875);
                return;
            }
            if (this.qke != null) {
                C5004al.m7441d(new C131931());
            }
            C39650l.this.eKj.mo10310m(new C289322(), 30000);
            AppMethodBeat.m2505o(126875);
        }

        static void cis() {
            AppMethodBeat.m2504i(126876);
            C9379ic c9379ic = new C9379ic();
            c9379ic.cDb.cAd = 3;
            C4879a.xxA.mo10055m(c9379ic);
            AppMethodBeat.m2505o(126876);
        }
    }

    public C39650l(boolean z, boolean z2, boolean z3, C21804h c21804h) {
        AppMethodBeat.m2504i(126877);
        this.qjN = z;
        this.qjO = z2;
        this.qjP = z3;
        C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", Integer.valueOf((this.qjP ? 1 : 0) + ((this.qjN ? 1 : 0) + (this.qjO ? 1 : 0))), Boolean.valueOf(this.qjO), Boolean.valueOf(this.qjN), Boolean.valueOf(this.qjP));
        this.qjQ = new CountDownLatch(r0);
        this.eKj = new C5004al("UnfamiliarContactEngine");
        this.qjW = c21804h;
        AppMethodBeat.m2505o(126877);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final void mo62615g(LinkedList<String> linkedList, int i) {
        AppMethodBeat.m2504i(126878);
        final long currentTimeMillis = System.currentTimeMillis();
        final int size = i + 10 < linkedList.size() ? i + 10 : linkedList.size();
        final List subList = linkedList.subList(i, size);
        C20846i c20846i = new C20846i();
        c20846i.hbo = 8;
        c20846i.query = C5046bo.m7536c(subList, ",");
        final LinkedList<String> linkedList2 = linkedList;
        c20846i.mEw = new C28114l() {
            final int limit = size;

            /* renamed from: b */
            public final void mo8215b(C28109j c28109j) {
                AppMethodBeat.m2504i(126871);
                List list = c28109j.mEy;
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
                    C4990ab.m7413e(str, str2, objArr3);
                } else {
                    C45966l c45966l = (C45966l) list.get(0);
                    if (c45966l.userData == null || !(c45966l.userData instanceof HashMap)) {
                        boolean z2;
                        str = "MicroMsg.UnfamiliarContactEngine";
                        str2 = "[getSameChatInfoTask] is null?%s is instanceof List";
                        objArr = new Object[2];
                        if (c45966l.userData == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr[0] = Boolean.valueOf(z2);
                        z = c45966l.userData instanceof HashMap;
                        i = 1;
                        objArr2 = objArr;
                        objArr3 = objArr;
                        objArr2[i] = Boolean.valueOf(z);
                        C4990ab.m7413e(str, str2, objArr3);
                    } else {
                        HashMap hashMap = (HashMap) c45966l.userData;
                        synchronized (C39650l.this.mLock) {
                            try {
                                for (String str3 : subList) {
                                    if (hashMap.containsKey(str3)) {
                                        int i2;
                                        for (C45966l c45966l2 : (List) hashMap.get(str3)) {
                                            if (c45966l2.mEB < 100) {
                                                i2 = 1;
                                                break;
                                            }
                                        }
                                        i2 = 0;
                                        if (i2 == 0) {
                                            C39650l.this.qjT.add(str3);
                                        }
                                    } else {
                                        C39650l.this.qjT.add(str3);
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(126871);
                            }
                        }
                    }
                }
                if (this.limit >= linkedList2.size()) {
                    C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", Integer.valueOf(linkedList2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    C39650l.this.qjQ.countDown();
                    AppMethodBeat.m2505o(126871);
                    return;
                }
                C39650l.this.mo62615g(linkedList2, this.limit);
                AppMethodBeat.m2505o(126871);
            }
        };
        c20846i.handler = this.eKj.doN();
        ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(126878);
    }

    /* renamed from: a */
    static /* synthetic */ void m67769a(C39650l c39650l, LinkedList linkedList) {
        AppMethodBeat.m2504i(126879);
        if (c39650l.qjO) {
            c39650l.qjV = new C39652a(c39650l.qjW, c39650l.qjQ);
            C1202f c1202f = c39650l.qjV;
            c1202f.start = System.currentTimeMillis();
            C1720g.m3540Rg().mo14539a(292, c1202f);
            C39652a.cis();
        }
        if (c39650l.qjN) {
            final HashSet hashSet = new HashSet();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            final long currentTimeMillis = System.currentTimeMillis() - 15552000000L;
            C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] timestamp:%s size:%s", Long.valueOf(currentTimeMillis), Integer.valueOf(hashSet.size()));
            final long currentTimeMillis2 = System.currentTimeMillis();
            C20846i c20846i = new C20846i();
            c20846i.hbo = 9;
            c20846i.query = String.valueOf(currentTimeMillis);
            c20846i.mEw = new C28114l() {
                /* renamed from: b */
                public final void mo8215b(C28109j c28109j) {
                    AppMethodBeat.m2504i(126869);
                    List<C45966l> list = c28109j.mEy;
                    if (list != null) {
                        for (C45966l c45966l : list) {
                            hashSet.remove(c45966l.mDx);
                            C39650l.this.qjS.add(c45966l.mDx);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15349r(str, currentTimeMillis, System.currentTimeMillis()) > 0) {
                            C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", str, Integer.valueOf(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15349r(str, currentTimeMillis, System.currentTimeMillis())));
                        } else {
                            Cursor a = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15283a(str, currentTimeMillis, System.currentTimeMillis(), true);
                            if (a.getCount() > 0) {
                                Cursor a2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15283a(str, currentTimeMillis, System.currentTimeMillis(), false);
                                if (a2.getCount() <= 0) {
                                    C39650l.this.qjS.add(str);
                                }
                                a2.close();
                            } else {
                                C39650l.this.qjS.add(str);
                            }
                            a.close();
                        }
                    }
                    C4990ab.m7417i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    C39650l.this.qjQ.countDown();
                    AppMethodBeat.m2505o(126869);
                }
            };
            c20846i.handler = c39650l.eKj.doN();
            ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        }
        if (c39650l.qjP) {
            c39650l.mo62615g(linkedList, 0);
        }
        C131912 c131912 = new C131912();
        c39650l.mRunnable = c131912;
        C7305d.post(c131912, "MicroMsg.UnfamiliarContactEngineAwait");
        AppMethodBeat.m2505o(126879);
    }
}
