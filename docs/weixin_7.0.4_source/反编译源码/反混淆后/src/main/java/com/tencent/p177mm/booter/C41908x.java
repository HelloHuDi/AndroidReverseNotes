package com.tencent.p177mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18374qf;
import com.tencent.p177mm.p230g.p231a.C6527nk;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5144y;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: com.tencent.mm.booter.x */
public final class C41908x {
    public static C41908x ecN = new C41908x();
    public C5144y ecO = new C5144y(C5128ac.eSj + "staytime.cfg");
    public C4884c ecP = new C259811();
    public C4884c ecQ = new C181092();
    public C32426a ecR;
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

    /* renamed from: com.tencent.mm.booter.x$2 */
    class C181092 extends C4884c<C6527nk> {
        C181092() {
            AppMethodBeat.m2504i(15876);
            this.xxI = C6527nk.class.getName().hashCode();
            AppMethodBeat.m2505o(15876);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15877);
            C6527nk c6527nk = (C6527nk) c4883b;
            if (c6527nk instanceof C6527nk) {
                C7620bi c7620bi = c6527nk.cJI.csG;
                C41908x c41908x = C41908x.this;
                if (!(c41908x.ecR == null || c41908x.ecU.contains(Long.valueOf(c7620bi.field_msgSvrId)) || !c41908x.ecR.ede.equals(c7620bi.field_talker))) {
                    c41908x.ecU.add(Long.valueOf(c7620bi.field_msgSvrId));
                    C32426a c32426a = c41908x.ecR;
                    c32426a.edk++;
                    C4990ab.m7417i("MicroMsg.StayTimeReport", "receiveMsg msgType:%d, recvCnt:%d", Integer.valueOf(c7620bi.getType()), Integer.valueOf(c41908x.ecR.edk));
                }
            }
            AppMethodBeat.m2505o(15877);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.x$1 */
    class C259811 extends C4884c<C18374qf> {
        C259811() {
            AppMethodBeat.m2504i(15874);
            this.xxI = C18374qf.class.getName().hashCode();
            AppMethodBeat.m2505o(15874);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15875);
            C18374qf c18374qf = (C18374qf) c4883b;
            if (c18374qf instanceof C18374qf) {
                C7620bi c7620bi = c18374qf.cMv.csG;
                C41908x c41908x = C41908x.this;
                if (!(c41908x.ecR == null || c41908x.ecT.contains(Long.valueOf(c7620bi.field_msgId)) || !c41908x.ecR.ede.equals(c7620bi.field_talker))) {
                    c41908x.ecT.add(Long.valueOf(c7620bi.field_msgId));
                    C32426a c32426a = c41908x.ecR;
                    c32426a.edl++;
                    C4990ab.m7417i("MicroMsg.StayTimeReport", "sendMsg msgType:%d, SendCnt:%d", Integer.valueOf(c7620bi.getType()), Integer.valueOf(c41908x.ecR.edl));
                }
            }
            AppMethodBeat.m2505o(15875);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.x$a */
    public class C32426a {
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
            AppMethodBeat.m2504i(15878);
            String format = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.edf), Integer.valueOf(this.csm), Integer.valueOf(this.edg), Long.valueOf(this.edh), Integer.valueOf(this.edi), this.ede, Integer.valueOf(this.edj), Integer.valueOf(this.edk), Integer.valueOf(this.edl)});
            AppMethodBeat.m2505o(15878);
            return format;
        }
    }

    static {
        AppMethodBeat.m2504i(15881);
        AppMethodBeat.m2505o(15881);
    }

    private C41908x() {
        AppMethodBeat.m2504i(15879);
        AppMethodBeat.m2505o(15879);
    }

    /* renamed from: jL */
    public final void mo67553jL(String str) {
        AppMethodBeat.m2504i(15880);
        C4879a.xxA.mo10053d(this.ecP);
        C4879a.xxA.mo10053d(this.ecQ);
        this.ecU.clear();
        this.ecT.clear();
        if (str == null || this.ecR == null) {
            String str2 = "MicroMsg.StayTimeReport";
            String str3 = "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(this.ecR == null);
            C4990ab.m7417i(str2, str3, objArr);
            AppMethodBeat.m2505o(15880);
        } else if (str.equals(this.ecR.ede)) {
            C32426a c32426a = this.ecR;
            c32426a.time += C42252ah.m74606az(this.ecV) / 1000;
            this.ecO.set(5, ((String) this.ecO.get(5, "")) + this.ecR.toString());
            if (this.ecR != null) {
                long j = this.ecO.getLong(4, 0);
                int Ml = this.ecO.mo10573Ml(6) + 1;
                this.ecO.setInt(6, Ml);
                C4990ab.m7417i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", this.ecR.ede, Integer.valueOf(this.ecR.type), Long.valueOf(this.ecR.time), Integer.valueOf(this.ecR.edi), Integer.valueOf(Ml));
                C4990ab.m7417i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", Integer.valueOf(this.ecR.edj), Integer.valueOf(this.ecR.edk), Integer.valueOf(this.ecR.edl));
                Ml = (C42252ah.m74621fp(j) > ((long) this.edc) || Ml > this.edb) ? 1 : 0;
                if (Ml != 0) {
                    C4990ab.m7417i("MicroMsg.StayTimeReport", "report （13062） %d: %s", Integer.valueOf(13062), ((String) this.ecO.get(5, "")) + "," + j + "," + C42252ah.anT());
                    C7060h.pYm.mo8374X(13062, r0);
                    this.ecO.setInt(6, 0);
                    this.ecO.set(5, "");
                }
            }
            AppMethodBeat.m2505o(15880);
        } else {
            C4990ab.m7417i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", str, this.ecR.ede);
            AppMethodBeat.m2505o(15880);
        }
    }
}
