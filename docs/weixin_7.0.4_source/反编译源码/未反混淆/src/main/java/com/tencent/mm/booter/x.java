package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.y;
import java.util.HashSet;
import java.util.Locale;

public final class x {
    public static x ecN = new x();
    public y ecO = new y(ac.eSj + "staytime.cfg");
    public c ecP = new c<qf>() {
        {
            AppMethodBeat.i(15874);
            this.xxI = qf.class.getName().hashCode();
            AppMethodBeat.o(15874);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(15875);
            qf qfVar = (qf) bVar;
            if (qfVar instanceof qf) {
                bi biVar = qfVar.cMv.csG;
                x xVar = x.this;
                if (!(xVar.ecR == null || xVar.ecT.contains(Long.valueOf(biVar.field_msgId)) || !xVar.ecR.ede.equals(biVar.field_talker))) {
                    xVar.ecT.add(Long.valueOf(biVar.field_msgId));
                    a aVar = xVar.ecR;
                    aVar.edl++;
                    ab.i("MicroMsg.StayTimeReport", "sendMsg msgType:%d, SendCnt:%d", Integer.valueOf(biVar.getType()), Integer.valueOf(xVar.ecR.edl));
                }
            }
            AppMethodBeat.o(15875);
            return false;
        }
    };
    public c ecQ = new c<nk>() {
        {
            AppMethodBeat.i(15876);
            this.xxI = nk.class.getName().hashCode();
            AppMethodBeat.o(15876);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(15877);
            nk nkVar = (nk) bVar;
            if (nkVar instanceof nk) {
                bi biVar = nkVar.cJI.csG;
                x xVar = x.this;
                if (!(xVar.ecR == null || xVar.ecU.contains(Long.valueOf(biVar.field_msgSvrId)) || !xVar.ecR.ede.equals(biVar.field_talker))) {
                    xVar.ecU.add(Long.valueOf(biVar.field_msgSvrId));
                    a aVar = xVar.ecR;
                    aVar.edk++;
                    ab.i("MicroMsg.StayTimeReport", "receiveMsg msgType:%d, recvCnt:%d", Integer.valueOf(biVar.getType()), Integer.valueOf(xVar.ecR.edk));
                }
            }
            AppMethodBeat.o(15877);
            return false;
        }
    };
    public a ecR;
    public int ecS = 0;
    HashSet<Long> ecT = new HashSet();
    HashSet<Long> ecU = new HashSet();
    public long ecV;
    public long ecW;
    public String ecX;
    public long ecY = -1;
    public int ecZ = 20;
    public int eda = 24;
    public int edb = 30;
    public int edc = 10800;
    public boolean hasInit = false;

    public class a {
        public int csm;
        public String ede;
        public int edf;
        public int edg;
        public long edh;
        public int edi;
        public int edj = 0;
        int edk = 0;
        int edl = 0;
        public long time;
        public int type;

        public final String toString() {
            AppMethodBeat.i(15878);
            String format = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.edf), Integer.valueOf(this.csm), Integer.valueOf(this.edg), Long.valueOf(this.edh), Integer.valueOf(this.edi), this.ede, Integer.valueOf(this.edj), Integer.valueOf(this.edk), Integer.valueOf(this.edl)});
            AppMethodBeat.o(15878);
            return format;
        }
    }

    static {
        AppMethodBeat.i(15881);
        AppMethodBeat.o(15881);
    }

    private x() {
        AppMethodBeat.i(15879);
        AppMethodBeat.o(15879);
    }

    public final void jL(String str) {
        AppMethodBeat.i(15880);
        com.tencent.mm.sdk.b.a.xxA.d(this.ecP);
        com.tencent.mm.sdk.b.a.xxA.d(this.ecQ);
        this.ecU.clear();
        this.ecT.clear();
        if (str == null || this.ecR == null) {
            String str2 = "MicroMsg.StayTimeReport";
            String str3 = "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(this.ecR == null);
            ab.i(str2, str3, objArr);
            AppMethodBeat.o(15880);
        } else if (str.equals(this.ecR.ede)) {
            a aVar = this.ecR;
            aVar.time += ah.az(this.ecV) / 1000;
            this.ecO.set(5, ((String) this.ecO.get(5, "")) + this.ecR.toString());
            if (this.ecR != null) {
                long j = this.ecO.getLong(4, 0);
                int Ml = this.ecO.Ml(6) + 1;
                this.ecO.setInt(6, Ml);
                ab.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", this.ecR.ede, Integer.valueOf(this.ecR.type), Long.valueOf(this.ecR.time), Integer.valueOf(this.ecR.edi), Integer.valueOf(Ml));
                ab.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", Integer.valueOf(this.ecR.edj), Integer.valueOf(this.ecR.edk), Integer.valueOf(this.ecR.edl));
                Ml = (ah.fp(j) > ((long) this.edc) || Ml > this.edb) ? 1 : 0;
                if (Ml != 0) {
                    ab.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", Integer.valueOf(13062), ((String) this.ecO.get(5, "")) + "," + j + "," + ah.anT());
                    h.pYm.X(13062, r0);
                    this.ecO.setInt(6, 0);
                    this.ecO.set(5, "");
                }
            }
            AppMethodBeat.o(15880);
        } else {
            ab.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", str, this.ecR.ede);
            AppMethodBeat.o(15880);
        }
    }
}
