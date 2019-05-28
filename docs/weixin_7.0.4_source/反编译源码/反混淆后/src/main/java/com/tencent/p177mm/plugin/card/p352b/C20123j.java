package com.tencent.p177mm.plugin.card.p352b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.card.sharecard.model.C42857f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.b.j */
public final class C20123j implements C1202f {
    private List<WeakReference<C20124a>> kaD = new ArrayList();
    public ArrayList<String> kbA = new ArrayList();
    public C7306ak kbB = new C7306ak();
    public HashMap<String, Runnable> kbC = new LinkedHashMap();
    public ArrayList<String> kbz = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.card.b.j$a */
    public interface C20124a {
        /* renamed from: Gp */
        void mo35374Gp(String str);

        /* renamed from: b */
        void mo35375b(String str, C20125b c20125b);

        /* renamed from: dl */
        void mo35376dl(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.card.b.j$b */
    public static class C20125b {
        public String kbH;
        public int kbI = 0;
        public String kbJ;
        public int kbK;
        public String kbL;
    }

    public C20123j() {
        AppMethodBeat.m2504i(87728);
        C1720g.m3535RO().eJo.mo14539a(907, (C1202f) this);
        this.kbz.clear();
        this.kbA.clear();
        this.kbC.clear();
        AppMethodBeat.m2505o(87728);
    }

    /* renamed from: a */
    public final void mo35371a(C20124a c20124a) {
        AppMethodBeat.m2504i(87729);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(c20124a));
        AppMethodBeat.m2505o(87729);
    }

    /* renamed from: b */
    public final void mo35372b(C20124a c20124a) {
        AppMethodBeat.m2504i(87730);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87730);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C20124a c20124a2 = (C20124a) weakReference.get();
                    if (c20124a2 != null && c20124a2.equals(c20124a)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.m2505o(87730);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87730);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m31124a(String str, C20125b c20125b) {
        AppMethodBeat.m2504i(87731);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87731);
        } else if (this.kbz.contains(str) || this.kbA.contains(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kaD.size()) {
                    WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                    if (weakReference != null) {
                        C20124a c20124a = (C20124a) weakReference.get();
                        if (c20124a != null) {
                            if (this.kbz.contains(str)) {
                                c20124a.mo35375b(str, c20125b);
                            } else if (this.kbA.contains(str)) {
                                c20124a.mo35374Gp(str);
                            }
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(87731);
                    return;
                }
            }
        } else {
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
            AppMethodBeat.m2505o(87731);
        }
    }

    /* renamed from: dk */
    private void m31125dk(String str, String str2) {
        AppMethodBeat.m2504i(87732);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87732);
        } else if (!this.kbz.contains(str) || this.kbA.contains(str)) {
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
            AppMethodBeat.m2505o(87732);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kaD.size()) {
                    WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                    if (weakReference != null) {
                        C20124a c20124a = (C20124a) weakReference.get();
                        if (c20124a != null) {
                            c20124a.mo35376dl(str, str2);
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(87732);
                    return;
                }
            }
        }
    }

    /* renamed from: Gn */
    private void m31122Gn(String str) {
        AppMethodBeat.m2504i(87733);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.kbz.contains(str) && !this.kbA.contains(str)) {
            this.kbz.remove(str);
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(str)));
        }
        if (!this.kbz.contains(str) && this.kbA.contains(str)) {
            this.kbA.remove(str);
            Runnable runnable = (Runnable) this.kbC.get(str);
            this.kbC.remove(str);
            this.kbB.removeCallbacks(runnable);
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(str)));
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(87733);
    }

    /* renamed from: Go */
    private void m31123Go(String str) {
        AppMethodBeat.m2504i(87734);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.kbA.contains(str)) {
            this.kbA.remove(str);
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(str)));
        }
        if (this.kbC.containsKey(str)) {
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(str)));
            Runnable runnable = (Runnable) this.kbC.get(str);
            this.kbC.remove(str);
            this.kbB.removeCallbacks(runnable);
        }
        AppMethodBeat.m2505o(87734);
    }

    /* renamed from: M */
    public final void mo35370M(String str, int i, int i2) {
        AppMethodBeat.m2504i(87735);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        m31123Go(str);
        if (!this.kbz.contains(str)) {
            this.kbz.add(str);
        }
        C20123j.m31126i(str, i, 1, i2);
        AppMethodBeat.m2505o(87735);
    }

    /* renamed from: bM */
    public final void mo35373bM(final String str, final int i) {
        AppMethodBeat.m2504i(87736);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        m31123Go(str);
        this.kbA.add(str);
        C201221 c201221 = new Runnable() {
            final /* synthetic */ int kbE = 0;
            final /* synthetic */ int kbF = 0;

            public final void run() {
                AppMethodBeat.m2504i(87727);
                C20123j.m31126i(str, this.kbE, this.kbF, i);
                C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + str + " system.time:" + System.currentTimeMillis());
                AppMethodBeat.m2505o(87727);
            }
        };
        this.kbB.postDelayed(c201221, (long) (C5046bo.getInt(C26373g.m41965Nv().mo5301O("ShareCard", "UnMarkDelay"), 0) * 1000));
        this.kbC.put(str, c201221);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
        AppMethodBeat.m2505o(87736);
    }

    /* renamed from: i */
    static void m31126i(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(87737);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            AppMethodBeat.m2505o(87737);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        C1720g.m3535RO().eJo.mo14541a(new C42857f(str, i, i2, i3), 0);
        AppMethodBeat.m2505o(87737);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87738);
        C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        C42857f c42857f;
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C42857f) {
                c42857f = (C42857f) c1207m;
                C20125b c20125b = new C20125b();
                c20125b.kbH = c42857f.kbH;
                c20125b.kbI = c42857f.kbI;
                c20125b.kbJ = c42857f.kbJ;
                c20125b.kbK = c42857f.kbK;
                c20125b.kbL = c42857f.kbL;
                C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + c42857f.kfB);
                C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "mark_user:" + c20125b.kbH + " mark_succ:" + c20125b.kbI + " mark_card_id:" + c20125b.kbJ + " expire_time:" + c20125b.kbK + " pay_qrcode_wording:" + c20125b.kbL);
                m31124a(c42857f.kfB, c20125b);
                m31122Gn(c42857f.kfB);
                AppMethodBeat.m2505o(87738);
                return;
            }
        } else if (c1207m instanceof C42857f) {
            c42857f = (C42857f) c1207m;
            C4990ab.m7416i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + c42857f.kfB);
            m31125dk(c42857f.kfB, str);
            m31122Gn(c42857f.kfB);
        }
        AppMethodBeat.m2505o(87738);
    }
}
