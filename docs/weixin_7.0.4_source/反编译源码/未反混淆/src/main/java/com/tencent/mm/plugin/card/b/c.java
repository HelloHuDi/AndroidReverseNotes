package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements f {
    List<WeakReference<a>> kaD = new ArrayList();
    String kaE = "";
    public LinkedList<String> kaF = new LinkedList();
    public int kaG;
    private int kaH;
    private int kaI;
    private int kaJ;
    private int kaK = 60;
    private boolean kaL = false;
    private ap kaM = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(87637);
            ab.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
            c.this.Gk(c.this.kaE);
            c.this.bal();
            AppMethodBeat.o(87637);
            return true;
        }
    }, false);
    private ap kaN = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(87638);
            ab.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
            c cVar = c.this;
            ab.i("MicroMsg.CardCodeMgr", "onCodeChange()");
            if (cVar.kaD != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= cVar.kaD.size()) {
                        break;
                    }
                    WeakReference weakReference = (WeakReference) cVar.kaD.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.bap();
                        }
                    }
                    i = i2 + 1;
                }
            }
            c.this.ban();
            AppMethodBeat.o(87638);
            return true;
        }
    }, false);

    public interface a {
        void Gj(String str);

        void bap();

        void onSuccess();
    }

    public c() {
        AppMethodBeat.i(87639);
        AppMethodBeat.o(87639);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(87641);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(aVar));
        AppMethodBeat.o(87641);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(87642);
        if (this.kaD == null) {
            AppMethodBeat.o(87642);
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
                        AppMethodBeat.o(87642);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87642);
                return;
            }
        }
    }

    private void onSuccess() {
        AppMethodBeat.i(87643);
        ab.i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.kaD == null) {
            AppMethodBeat.o(87643);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.onSuccess();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87643);
                return;
            }
        }
    }

    private void Gj(String str) {
        AppMethodBeat.i(87644);
        ab.i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.kaD == null) {
            AppMethodBeat.o(87644);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.Gj(str);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87644);
                return;
            }
        }
    }

    public final String getCode() {
        AppMethodBeat.i(87645);
        String str;
        if (this.kaF == null || this.kaF.size() == 0) {
            ab.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            str = "";
            AppMethodBeat.o(87645);
            return str;
        } else if (this.kaG >= this.kaF.size()) {
            ab.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            Gk(this.kaE);
            str = "";
            AppMethodBeat.o(87645);
            return str;
        } else {
            if (this.kaI >= this.kaF.size() - this.kaG) {
                ab.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                Gk(this.kaE);
            }
            ab.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.kaG + " request_count:" + this.kaI + " codes size:" + this.kaF.size());
            LinkedList linkedList = this.kaF;
            int i = this.kaG;
            this.kaG = i + 1;
            str = (String) linkedList.get(i);
            AppMethodBeat.o(87645);
            return str;
        }
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(87646);
        if (this.kaF == null || this.kaF.size() == 0) {
            ab.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            AppMethodBeat.o(87646);
            return true;
        } else if (this.kaG >= this.kaF.size()) {
            ab.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            AppMethodBeat.o(87646);
            return true;
        } else {
            AppMethodBeat.o(87646);
            return false;
        }
    }

    public final void Gk(String str) {
        AppMethodBeat.i(87647);
        if (this.kaL) {
            ab.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
            AppMethodBeat.o(87647);
        } else if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
            AppMethodBeat.o(87647);
        } else {
            ab.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(str)));
            this.kaL = true;
            this.kaE = str;
            bak();
            AppMethodBeat.o(87647);
        }
    }

    private void bak() {
        AppMethodBeat.i(87648);
        g.RO().eJo.a(new ac(this.kaE), 0);
        AppMethodBeat.o(87648);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87649);
        ab.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof ac) {
                this.kaL = false;
                ab.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.kaE);
                ac acVar = (ac) mVar;
                this.kaH = acVar.kaH;
                this.kaI = acVar.kaI;
                this.kaJ = acVar.kaJ;
                if (acVar.kaF != null) {
                    this.kaF.clear();
                    this.kaF.addAll(acVar.kaF);
                    this.kaG = 0;
                }
                onSuccess();
                bal();
                if (this.kaJ != 0) {
                    ban();
                }
                AppMethodBeat.o(87649);
                return;
            }
        } else if (mVar instanceof ac) {
            this.kaL = false;
            ab.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.kaE);
            Gj(str);
        }
        AppMethodBeat.o(87649);
    }

    public final void bal() {
        AppMethodBeat.i(87650);
        bam();
        ab.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.kaH);
        if (this.kaH <= 0 || TextUtils.isEmpty(this.kaE)) {
            ab.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            AppMethodBeat.o(87650);
            return;
        }
        long j = (long) (this.kaH * 1000);
        this.kaM.ae(j, j);
        ab.i("MicroMsg.CardCodeMgr", "start request code timer!");
        AppMethodBeat.o(87650);
    }

    private void bam() {
        AppMethodBeat.i(87651);
        ab.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.kaM.doT()) {
            this.kaM.stopTimer();
        }
        AppMethodBeat.o(87651);
    }

    public final void ban() {
        AppMethodBeat.i(87652);
        bao();
        ab.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.kaJ);
        long j;
        if (this.kaJ > 0) {
            j = (long) (this.kaJ * 1000);
            this.kaN.ae(j, j);
            ab.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            AppMethodBeat.o(87652);
            return;
        }
        j = (long) (this.kaK * 1000);
        this.kaN.ae(j, j);
        ab.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
        AppMethodBeat.o(87652);
    }

    public final void bao() {
        AppMethodBeat.i(87653);
        ab.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.kaN.doT()) {
            this.kaN.stopTimer();
        }
        AppMethodBeat.o(87653);
    }

    public final void release() {
        AppMethodBeat.i(87640);
        g.RO().eJo.b((int) w.CTRL_INDEX, (f) this);
        this.kaF.clear();
        this.kaL = false;
        this.kaE = "";
        this.kaG = 0;
        this.kaH = 0;
        this.kaI = 0;
        this.kaJ = 0;
        bam();
        bao();
        AppMethodBeat.o(87640);
    }
}
