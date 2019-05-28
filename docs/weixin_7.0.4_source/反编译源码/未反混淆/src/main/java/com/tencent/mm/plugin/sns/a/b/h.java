package com.tencent.mm.plugin.sns.a.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
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
    public a qEs = new a();
    public LinkedList<a> qEt = new LinkedList();
    public long qEu = 0;

    public h() {
        AppMethodBeat.i(35744);
        AppMethodBeat.o(35744);
    }

    public h(String str) {
        AppMethodBeat.i(35745);
        this.TAG = "MicroMsg.SnsAdVideoStatistic:".concat(String.valueOf(str));
        AppMethodBeat.o(35745);
    }

    public final void setDuration(int i) {
        this.qEu = (long) i;
        this.qEs.qFr = i;
    }

    public final void CI(int i) {
        AppMethodBeat.i(35746);
        if (this.qEs.qFq <= 0) {
            this.qEs.qFq = this.qEs.qFu == 0 ? 0 : (int) bo.az(this.qEs.qFu);
        }
        if (i != 0) {
            this.qEs.qFr = i;
            this.qEu = (long) i;
        }
        ab.i(this.TAG, "pushplayitem duration " + this.qEs.qFq + " " + this.qEs.qFt);
        this.qEt.add(this.qEs);
        this.qEs = new a();
        AppMethodBeat.o(35746);
    }

    public final String cmf() {
        int i;
        LinkedList linkedList;
        a aVar;
        AppMethodBeat.i(35747);
        if (this.qEm == 0) {
            i = 0;
        } else {
            i = (int) bo.az(this.qEm);
        }
        this.qEl = i;
        ab.d(this.TAG, "__staytotaltime " + this.qEm + " " + this.qEl + " clock: " + SystemClock.elapsedRealtime());
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
            a aVar2 = new a();
            for (int i2 = 0; i2 < this.qEt.size(); i2++) {
                aVar = (a) this.qEt.get(i2);
                if (i2 == 0) {
                    aVar2.qFr = aVar.qFr;
                    aVar2.qFs = aVar.qFs;
                    aVar2.qFt = aVar.qFt;
                }
                aVar2.qFp += aVar.qFp;
                aVar2.qFq = aVar.qFq + aVar2.qFq;
            }
            linkedList2 = new LinkedList();
            linkedList2.add(aVar2);
            linkedList = linkedList2;
        }
        stringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[]{Integer.valueOf(linkedList.size())}));
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            aVar = (a) linkedList.get(i3);
            stringBuffer.append("<playitem>");
            stringBuffer.append(String.format("<playcount>%d</playcount>", new Object[]{Integer.valueOf(aVar.qFp)}));
            stringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[]{Integer.valueOf(aVar.qFq)}));
            stringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[]{Integer.valueOf(aVar.qFr * 1000)}));
            stringBuffer.append(String.format("<playmode>%d</playmode>", new Object[]{Integer.valueOf(aVar.qFs)}));
            stringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[]{Integer.valueOf(aVar.qFt)}));
            stringBuffer.append("</playitem>");
        }
        stringBuffer.append("</playitemlist>");
        stringBuffer.append("</viewinfo>");
        String stringBuffer2 = stringBuffer.toString();
        ab.i(this.TAG, "xml ".concat(String.valueOf(stringBuffer2)));
        AppMethodBeat.o(35747);
        return stringBuffer2;
    }

    public final void cmg() {
        AppMethodBeat.i(35748);
        this.qEo = 0;
        this.qEp = 0;
        this.qEq = 0;
        Iterator it = this.qEt.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            this.qEo += aVar.qFo;
            this.qEp += aVar.qFp;
            this.qEq = aVar.qFq + this.qEq;
        }
        if (!(this.qEs == null || this.qEt.contains(this.qEs))) {
            this.qEo += this.qEs.qFo;
            this.qEp += this.qEs.qFp;
            this.qEq += this.qEs.qFq;
        }
        AppMethodBeat.o(35748);
    }

    public final void onResume() {
        AppMethodBeat.i(35749);
        if (this.fQd == 0) {
            AppMethodBeat.o(35749);
            return;
        }
        long az = bo.az(this.fQd);
        this.fQe += az;
        this.fQd = 0;
        if (this.qEs != null) {
            a aVar = this.qEs;
            aVar.qFv = az + aVar.qFv;
        }
        AppMethodBeat.o(35749);
    }
}
