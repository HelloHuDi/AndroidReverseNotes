package com.tencent.p177mm.plugin.card.p352b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24699w;
import com.tencent.p177mm.plugin.card.model.C11285ac;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.b.c */
public final class C11268c implements C1202f {
    List<WeakReference<C11269a>> kaD = new ArrayList();
    String kaE = "";
    public LinkedList<String> kaF = new LinkedList();
    public int kaG;
    private int kaH;
    private int kaI;
    private int kaJ;
    private int kaK = 60;
    private boolean kaL = false;
    private C7564ap kaM = new C7564ap(new C112701(), false);
    private C7564ap kaN = new C7564ap(new C112712(), false);

    /* renamed from: com.tencent.mm.plugin.card.b.c$a */
    public interface C11269a {
        /* renamed from: Gj */
        void mo22968Gj(String str);

        void bap();

        void onSuccess();
    }

    /* renamed from: com.tencent.mm.plugin.card.b.c$1 */
    class C112701 implements C5015a {
        C112701() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(87637);
            C4990ab.m7416i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
            C11268c.this.mo22959Gk(C11268c.this.kaE);
            C11268c.this.bal();
            AppMethodBeat.m2505o(87637);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.b.c$2 */
    class C112712 implements C5015a {
        C112712() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(87638);
            C4990ab.m7416i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
            C11268c c11268c = C11268c.this;
            C4990ab.m7416i("MicroMsg.CardCodeMgr", "onCodeChange()");
            if (c11268c.kaD != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c11268c.kaD.size()) {
                        break;
                    }
                    WeakReference weakReference = (WeakReference) c11268c.kaD.get(i2);
                    if (weakReference != null) {
                        C11269a c11269a = (C11269a) weakReference.get();
                        if (c11269a != null) {
                            c11269a.bap();
                        }
                    }
                    i = i2 + 1;
                }
            }
            C11268c.this.ban();
            AppMethodBeat.m2505o(87638);
            return true;
        }
    }

    public C11268c() {
        AppMethodBeat.m2504i(87639);
        AppMethodBeat.m2505o(87639);
    }

    /* renamed from: a */
    public final void mo22960a(C11269a c11269a) {
        AppMethodBeat.m2504i(87641);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(c11269a));
        AppMethodBeat.m2505o(87641);
    }

    /* renamed from: b */
    public final void mo22961b(C11269a c11269a) {
        AppMethodBeat.m2504i(87642);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87642);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C11269a c11269a2 = (C11269a) weakReference.get();
                    if (c11269a2 != null && c11269a2.equals(c11269a)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.m2505o(87642);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87642);
                return;
            }
        }
    }

    private void onSuccess() {
        AppMethodBeat.m2504i(87643);
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87643);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C11269a c11269a = (C11269a) weakReference.get();
                    if (c11269a != null) {
                        c11269a.onSuccess();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87643);
                return;
            }
        }
    }

    /* renamed from: Gj */
    private void m18987Gj(String str) {
        AppMethodBeat.m2504i(87644);
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87644);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C11269a c11269a = (C11269a) weakReference.get();
                    if (c11269a != null) {
                        c11269a.mo22968Gj(str);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87644);
                return;
            }
        }
    }

    public final String getCode() {
        AppMethodBeat.m2504i(87645);
        String str;
        if (this.kaF == null || this.kaF.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            str = "";
            AppMethodBeat.m2505o(87645);
            return str;
        } else if (this.kaG >= this.kaF.size()) {
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            mo22959Gk(this.kaE);
            str = "";
            AppMethodBeat.m2505o(87645);
            return str;
        } else {
            if (this.kaI >= this.kaF.size() - this.kaG) {
                C4990ab.m7416i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                mo22959Gk(this.kaE);
            }
            C4990ab.m7416i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.kaG + " request_count:" + this.kaI + " codes size:" + this.kaF.size());
            LinkedList linkedList = this.kaF;
            int i = this.kaG;
            this.kaG = i + 1;
            str = (String) linkedList.get(i);
            AppMethodBeat.m2505o(87645);
            return str;
        }
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(87646);
        if (this.kaF == null || this.kaF.size() == 0) {
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            AppMethodBeat.m2505o(87646);
            return true;
        } else if (this.kaG >= this.kaF.size()) {
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            AppMethodBeat.m2505o(87646);
            return true;
        } else {
            AppMethodBeat.m2505o(87646);
            return false;
        }
    }

    /* renamed from: Gk */
    public final void mo22959Gk(String str) {
        AppMethodBeat.m2504i(87647);
        if (this.kaL) {
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
            AppMethodBeat.m2505o(87647);
        } else if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
            AppMethodBeat.m2505o(87647);
        } else {
            C4990ab.m7416i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(str)));
            this.kaL = true;
            this.kaE = str;
            bak();
            AppMethodBeat.m2505o(87647);
        }
    }

    private void bak() {
        AppMethodBeat.m2504i(87648);
        C1720g.m3535RO().eJo.mo14541a(new C11285ac(this.kaE), 0);
        AppMethodBeat.m2505o(87648);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87649);
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C11285ac) {
                this.kaL = false;
                C4990ab.m7412e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.kaE);
                C11285ac c11285ac = (C11285ac) c1207m;
                this.kaH = c11285ac.kaH;
                this.kaI = c11285ac.kaI;
                this.kaJ = c11285ac.kaJ;
                if (c11285ac.kaF != null) {
                    this.kaF.clear();
                    this.kaF.addAll(c11285ac.kaF);
                    this.kaG = 0;
                }
                onSuccess();
                bal();
                if (this.kaJ != 0) {
                    ban();
                }
                AppMethodBeat.m2505o(87649);
                return;
            }
        } else if (c1207m instanceof C11285ac) {
            this.kaL = false;
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.kaE);
            m18987Gj(str);
        }
        AppMethodBeat.m2505o(87649);
    }

    public final void bal() {
        AppMethodBeat.m2504i(87650);
        bam();
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.kaH);
        if (this.kaH <= 0 || TextUtils.isEmpty(this.kaE)) {
            C4990ab.m7412e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            AppMethodBeat.m2505o(87650);
            return;
        }
        long j = (long) (this.kaH * 1000);
        this.kaM.mo16770ae(j, j);
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "start request code timer!");
        AppMethodBeat.m2505o(87650);
    }

    private void bam() {
        AppMethodBeat.m2504i(87651);
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.kaM.doT()) {
            this.kaM.stopTimer();
        }
        AppMethodBeat.m2505o(87651);
    }

    public final void ban() {
        AppMethodBeat.m2504i(87652);
        bao();
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.kaJ);
        long j;
        if (this.kaJ > 0) {
            j = (long) (this.kaJ * 1000);
            this.kaN.mo16770ae(j, j);
            C4990ab.m7416i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            AppMethodBeat.m2505o(87652);
            return;
        }
        j = (long) (this.kaK * 1000);
        this.kaN.mo16770ae(j, j);
        C4990ab.m7412e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
        AppMethodBeat.m2505o(87652);
    }

    public final void bao() {
        AppMethodBeat.m2504i(87653);
        C4990ab.m7416i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.kaN.doT()) {
            this.kaN.stopTimer();
        }
        AppMethodBeat.m2505o(87653);
    }

    public final void release() {
        AppMethodBeat.m2504i(87640);
        C1720g.m3535RO().eJo.mo14546b((int) C24699w.CTRL_INDEX, (C1202f) this);
        this.kaF.clear();
        this.kaL = false;
        this.kaE = "";
        this.kaG = 0;
        this.kaH = 0;
        this.kaI = 0;
        this.kaJ = 0;
        bam();
        bao();
        AppMethodBeat.m2505o(87640);
    }
}
