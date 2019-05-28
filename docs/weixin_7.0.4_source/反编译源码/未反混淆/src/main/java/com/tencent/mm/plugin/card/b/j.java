package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j implements f {
    private List<WeakReference<a>> kaD = new ArrayList();
    public ArrayList<String> kbA = new ArrayList();
    public ak kbB = new ak();
    public HashMap<String, Runnable> kbC = new LinkedHashMap();
    public ArrayList<String> kbz = new ArrayList();

    public interface a {
        void Gp(String str);

        void b(String str, b bVar);

        void dl(String str, String str2);
    }

    public static class b {
        public String kbH;
        public int kbI = 0;
        public String kbJ;
        public int kbK;
        public String kbL;
    }

    public j() {
        AppMethodBeat.i(87728);
        g.RO().eJo.a(907, (f) this);
        this.kbz.clear();
        this.kbA.clear();
        this.kbC.clear();
        AppMethodBeat.o(87728);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(87729);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(aVar));
        AppMethodBeat.o(87729);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(87730);
        if (this.kaD == null) {
            AppMethodBeat.o(87730);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.o(87730);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87730);
                return;
            }
        }
    }

    private void a(String str, b bVar) {
        AppMethodBeat.i(87731);
        ab.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.kaD == null) {
            AppMethodBeat.o(87731);
        } else if (this.kbz.contains(str) || this.kbA.contains(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kaD.size()) {
                    WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            if (this.kbz.contains(str)) {
                                aVar.b(str, bVar);
                            } else if (this.kbA.contains(str)) {
                                aVar.Gp(str);
                            }
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(87731);
                    return;
                }
            }
        } else {
            ab.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
            AppMethodBeat.o(87731);
        }
    }

    private void dk(String str, String str2) {
        AppMethodBeat.i(87732);
        ab.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.kaD == null) {
            AppMethodBeat.o(87732);
        } else if (!this.kbz.contains(str) || this.kbA.contains(str)) {
            ab.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
            AppMethodBeat.o(87732);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kaD.size()) {
                    WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.dl(str, str2);
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(87732);
                    return;
                }
            }
        }
    }

    private void Gn(String str) {
        AppMethodBeat.i(87733);
        ab.i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.kbz.contains(str) && !this.kbA.contains(str)) {
            this.kbz.remove(str);
            ab.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(str)));
        }
        if (!this.kbz.contains(str) && this.kbA.contains(str)) {
            this.kbA.remove(str);
            Runnable runnable = (Runnable) this.kbC.get(str);
            this.kbC.remove(str);
            this.kbB.removeCallbacks(runnable);
            ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(str)));
            ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(87733);
    }

    private void Go(String str) {
        AppMethodBeat.i(87734);
        ab.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.kbA.contains(str)) {
            this.kbA.remove(str);
            ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(str)));
        }
        if (this.kbC.containsKey(str)) {
            ab.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(str)));
            Runnable runnable = (Runnable) this.kbC.get(str);
            this.kbC.remove(str);
            this.kbB.removeCallbacks(runnable);
        }
        AppMethodBeat.o(87734);
    }

    public final void M(String str, int i, int i2) {
        AppMethodBeat.i(87735);
        ab.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        Go(str);
        if (!this.kbz.contains(str)) {
            this.kbz.add(str);
        }
        i(str, i, 1, i2);
        AppMethodBeat.o(87735);
    }

    public final void bM(final String str, final int i) {
        AppMethodBeat.i(87736);
        ab.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        Go(str);
        this.kbA.add(str);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            final /* synthetic */ int kbE = 0;
            final /* synthetic */ int kbF = 0;

            public final void run() {
                AppMethodBeat.i(87727);
                j.i(str, this.kbE, this.kbF, i);
                ab.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + str + " system.time:" + System.currentTimeMillis());
                AppMethodBeat.o(87727);
            }
        };
        this.kbB.postDelayed(anonymousClass1, (long) (bo.getInt(com.tencent.mm.m.g.Nv().O("ShareCard", "UnMarkDelay"), 0) * 1000));
        this.kbC.put(str, anonymousClass1);
        ab.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
        AppMethodBeat.o(87736);
    }

    static void i(String str, int i, int i2, int i3) {
        AppMethodBeat.i(87737);
        if (TextUtils.isEmpty(str)) {
            ab.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            AppMethodBeat.o(87737);
            return;
        }
        ab.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.f(str, i, i2, i3), 0);
        AppMethodBeat.o(87737);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87738);
        ab.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        com.tencent.mm.plugin.card.sharecard.model.f fVar;
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.f) {
                fVar = (com.tencent.mm.plugin.card.sharecard.model.f) mVar;
                b bVar = new b();
                bVar.kbH = fVar.kbH;
                bVar.kbI = fVar.kbI;
                bVar.kbJ = fVar.kbJ;
                bVar.kbK = fVar.kbK;
                bVar.kbL = fVar.kbL;
                ab.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + fVar.kfB);
                ab.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + bVar.kbH + " mark_succ:" + bVar.kbI + " mark_card_id:" + bVar.kbJ + " expire_time:" + bVar.kbK + " pay_qrcode_wording:" + bVar.kbL);
                a(fVar.kfB, bVar);
                Gn(fVar.kfB);
                AppMethodBeat.o(87738);
                return;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.f) {
            fVar = (com.tencent.mm.plugin.card.sharecard.model.f) mVar;
            ab.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + fVar.kfB);
            dk(fVar.kfB, str);
            Gn(fVar.kfB);
        }
        AppMethodBeat.o(87738);
    }
}
