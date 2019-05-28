package com.tencent.p177mm.plugin.sns.p514a.p515b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p514a.p515b.p1501a.C34926a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.a.b.h */
public final class C3863h {
    public String TAG = "MicroMsg.SnsAdVideoStatistic";
    public long fQd = 0;
    public long fQe = 0;
    public int qEk = 0;
    public int qEl = 0;
    public long qEm = 0;
    public int qEn = 0;
    public int qEo = 0;
    public int qEp = 0;
    public int qEq = 0;
    public boolean qEr = false;
    public C34926a qEs = new C34926a();
    public LinkedList<C34926a> qEt = new LinkedList();
    public long qEu = 0;

    public C3863h() {
        AppMethodBeat.m2504i(35744);
        AppMethodBeat.m2505o(35744);
    }

    public C3863h(String str) {
        AppMethodBeat.m2504i(35745);
        this.TAG = "MicroMsg.SnsAdVideoStatistic:".concat(String.valueOf(str));
        AppMethodBeat.m2505o(35745);
    }

    public final void setDuration(int i) {
        this.qEu = (long) i;
        this.qEs.qFr = i;
    }

    /* renamed from: CI */
    public final void mo8566CI(int i) {
        AppMethodBeat.m2504i(35746);
        if (this.qEs.qFq <= 0) {
            this.qEs.qFq = this.qEs.qFu == 0 ? 0 : (int) C5046bo.m7525az(this.qEs.qFu);
        }
        if (i != 0) {
            this.qEs.qFr = i;
            this.qEu = (long) i;
        }
        C4990ab.m7416i(this.TAG, "pushplayitem duration " + this.qEs.qFq + " " + this.qEs.qFt);
        this.qEt.add(this.qEs);
        this.qEs = new C34926a();
        AppMethodBeat.m2505o(35746);
    }

    public final String cmf() {
        int i;
        LinkedList linkedList;
        C34926a c34926a;
        AppMethodBeat.m2504i(35747);
        if (this.qEm == 0) {
            i = 0;
        } else {
            i = (int) C5046bo.m7525az(this.qEm);
        }
        this.qEl = i;
        C4990ab.m7410d(this.TAG, "__staytotaltime " + this.qEm + " " + this.qEl + " clock: " + SystemClock.elapsedRealtime());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<viewinfo>");
        stringBuffer.append("<downloadstatus>");
        stringBuffer.append(this.qEk);
        stringBuffer.append("</downloadstatus>");
        stringBuffer.append("<staytotaltime>");
        stringBuffer.append(this.qEl);
        stringBuffer.append("</staytotaltime>");
        if (this.qEn > 0) {
            stringBuffer.append("<masktotaltime>");
            stringBuffer.append(this.qEn);
            stringBuffer.append("</masktotaltime>");
        }
        LinkedList linkedList2 = this.qEt;
        if (!this.qEr || this.qEt.size() <= 1) {
            linkedList = linkedList2;
        } else {
            C34926a c34926a2 = new C34926a();
            for (int i2 = 0; i2 < this.qEt.size(); i2++) {
                c34926a = (C34926a) this.qEt.get(i2);
                if (i2 == 0) {
                    c34926a2.qFr = c34926a.qFr;
                    c34926a2.qFs = c34926a.qFs;
                    c34926a2.qFt = c34926a.qFt;
                }
                c34926a2.qFp += c34926a.qFp;
                c34926a2.qFq = c34926a.qFq + c34926a2.qFq;
            }
            linkedList2 = new LinkedList();
            linkedList2.add(c34926a2);
            linkedList = linkedList2;
        }
        stringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[]{Integer.valueOf(linkedList.size())}));
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            c34926a = (C34926a) linkedList.get(i3);
            stringBuffer.append("<playitem>");
            stringBuffer.append(String.format("<playcount>%d</playcount>", new Object[]{Integer.valueOf(c34926a.qFp)}));
            stringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[]{Integer.valueOf(c34926a.qFq)}));
            stringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[]{Integer.valueOf(c34926a.qFr * 1000)}));
            stringBuffer.append(String.format("<playmode>%d</playmode>", new Object[]{Integer.valueOf(c34926a.qFs)}));
            stringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[]{Integer.valueOf(c34926a.qFt)}));
            stringBuffer.append("</playitem>");
        }
        stringBuffer.append("</playitemlist>");
        stringBuffer.append("</viewinfo>");
        String stringBuffer2 = stringBuffer.toString();
        C4990ab.m7416i(this.TAG, "xml ".concat(String.valueOf(stringBuffer2)));
        AppMethodBeat.m2505o(35747);
        return stringBuffer2;
    }

    public final void cmg() {
        AppMethodBeat.m2504i(35748);
        this.qEo = 0;
        this.qEp = 0;
        this.qEq = 0;
        Iterator it = this.qEt.iterator();
        while (it.hasNext()) {
            C34926a c34926a = (C34926a) it.next();
            this.qEo += c34926a.qFo;
            this.qEp += c34926a.qFp;
            this.qEq = c34926a.qFq + this.qEq;
        }
        if (!(this.qEs == null || this.qEt.contains(this.qEs))) {
            this.qEo += this.qEs.qFo;
            this.qEp += this.qEs.qFp;
            this.qEq += this.qEs.qFq;
        }
        AppMethodBeat.m2505o(35748);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(35749);
        if (this.fQd == 0) {
            AppMethodBeat.m2505o(35749);
            return;
        }
        long az = C5046bo.m7525az(this.fQd);
        this.fQe += az;
        this.fQd = 0;
        if (this.qEs != null) {
            C34926a c34926a = this.qEs;
            c34926a.qFv = az + c34926a.qFv;
        }
        AppMethodBeat.m2505o(35749);
    }
}
