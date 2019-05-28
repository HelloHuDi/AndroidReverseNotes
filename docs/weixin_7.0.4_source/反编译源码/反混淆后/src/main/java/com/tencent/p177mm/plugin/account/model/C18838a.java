package com.tencent.p177mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42017jy;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C45474a;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C32956ab;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C9877al;
import com.tencent.p177mm.plugin.account.p765a.p766a.C45491b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.account.model.a */
public final class C18838a implements C1202f {
    C45491b fAY = new C188413();
    boolean fPO = false;
    C4884c gyA = new C188391();
    C7306ak gyB = new C188402();
    Set<String> gyz = Collections.synchronizedSet(new HashSet());

    /* renamed from: com.tencent.mm.plugin.account.model.a$1 */
    class C188391 extends C4884c<C42017jy> {
        C188391() {
            AppMethodBeat.m2504i(124653);
            this.xxI = C42017jy.class.getName().hashCode();
            AppMethodBeat.m2505o(124653);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124654);
            C4990ab.m7417i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", ((C42017jy) c4883b).cFk.username, Boolean.valueOf(C18838a.this.fPO));
            C18838a.this.gyz.add(r8.cFk.username);
            if (!C18838a.this.fPO) {
                C18838a.this.gyB.removeMessages(0);
                C18838a.this.gyB.sendEmptyMessageDelayed(0, 10000);
            }
            AppMethodBeat.m2505o(124654);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.a$2 */
    class C188402 extends C7306ak {
        C188402() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(124655);
            switch (message.what) {
                case 0:
                    C18838a.this.fPO = true;
                    if (!C45474a.syncAddrBook(C18838a.this.fAY)) {
                        C18838a.this.fPO = false;
                    }
                    C4990ab.m7417i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", Boolean.valueOf(r0));
                    break;
            }
            AppMethodBeat.m2505o(124655);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.a$3 */
    class C188413 implements C45491b {
        C188413() {
        }

        /* renamed from: cN */
        public final void mo14963cN(boolean z) {
            AppMethodBeat.m2504i(124656);
            C4990ab.m7417i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", Boolean.valueOf(z));
            if (!z) {
                AppMethodBeat.m2505o(124656);
            } else if (C38033l.aqb().size() > 0) {
                C4990ab.m7416i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
                C1720g.m3540Rg().mo14539a((int) C19394e.CTRL_INDEX, C18838a.this);
                System.currentTimeMillis();
                C38033l.apX();
                C1720g.m3540Rg().mo14541a(new C9877al(C38033l.aqb(), C38033l.aqa()), 0);
                AppMethodBeat.m2505o(124656);
            } else {
                C4990ab.m7416i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
                String[] strArr = (String[]) C18838a.this.gyz.toArray(new String[0]);
                C18838a.this.gyz.clear();
                ArrayList arrayList = new ArrayList();
                for (String vT : strArr) {
                    C18817a vT2 = C32923a.getAddrUploadStg().mo34089vT(vT);
                    if (vT2 == null || C5046bo.isNullOrNil(vT2.apG())) {
                        C4990ab.m7417i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", vT);
                    } else {
                        arrayList.add(vT2.apG());
                        C4990ab.m7417i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", vT2.apG(), vT);
                    }
                }
                C1720g.m3540Rg().mo14539a(32, C18838a.this);
                if (arrayList.size() == 0) {
                    C4990ab.m7416i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
                    C1720g.m3540Rg().mo14541a(new C32956ab(), 0);
                    AppMethodBeat.m2505o(124656);
                    return;
                }
                C4990ab.m7417i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", Integer.valueOf(arrayList.size()));
                C1720g.m3540Rg().mo14541a(new C32956ab(arrayList, null), 0);
                AppMethodBeat.m2505o(124656);
            }
        }
    }

    public C18838a() {
        AppMethodBeat.m2504i(124657);
        C4879a.xxA.mo10052c(this.gyA);
        AppMethodBeat.m2505o(124657);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124658);
        if (c1207m.getType() == C19394e.CTRL_INDEX) {
            C1720g.m3540Rg().mo14546b((int) C19394e.CTRL_INDEX, (C1202f) this);
            if (i == 0 && i2 == 0) {
                C1720g.m3540Rg().mo14539a(32, (C1202f) this);
                C9877al c9877al = (C9877al) c1207m;
                C1720g.m3540Rg().mo14541a(new C32956ab(c9877al.gwp, c9877al.gwq), 0);
            } else {
                C4990ab.m7412e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i + ", errCode = " + i2);
                this.fPO = false;
            }
        }
        if (c1207m.getType() == 32) {
            this.fPO = false;
            C1720g.m3540Rg().mo14546b(32, (C1202f) this);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                C26529w.m42358co(C4996ah.getContext());
            } else {
                C4990ab.m7412e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i + ", errCode = " + i2);
                AppMethodBeat.m2505o(124658);
                return;
            }
        }
        AppMethodBeat.m2505o(124658);
    }
}
