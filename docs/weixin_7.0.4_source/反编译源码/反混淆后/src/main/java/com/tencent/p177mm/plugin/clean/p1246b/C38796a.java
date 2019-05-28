package com.tencent.p177mm.plugin.clean.p1246b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.clean.p362c.C6826j;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.clean.b.a */
public final class C38796a implements Runnable {
    private static final Long clo = Long.valueOf(604800000);
    private static final Long kvU = Long.valueOf(7776000000L);
    private boolean isStop;
    private long kvV;
    private long kvW;
    private long kvX;
    private long kvY;
    private HashMap<String, Long> kvZ;
    private HashSet<String> kwa;
    private C20226c kwb;

    static {
        AppMethodBeat.m2504i(18659);
        AppMethodBeat.m2505o(18659);
    }

    public C38796a(C20226c c20226c) {
        AppMethodBeat.m2504i(18652);
        this.isStop = false;
        this.isStop = false;
        this.kwb = c20226c;
        this.kvZ = new HashMap();
        this.kwa = new HashSet();
        AppMethodBeat.m2505o(18652);
    }

    public final void stop() {
        this.isStop = true;
        this.kwb = null;
    }

    private String aZk() {
        AppMethodBeat.m2504i(18653);
        String str = hashCode();
        AppMethodBeat.m2505o(18653);
        return str;
    }

    public final void run() {
        AppMethodBeat.m2504i(18654);
        long yz = C5046bo.m7588yz();
        if (this.isStop) {
            C4990ab.m7417i("MicroMsg.CleanCalcLogic", "%s start run but stop", aZk());
            AppMethodBeat.m2505o(18654);
            return;
        }
        String str;
        long HP;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        m65840a(arrayList, hashSet);
        int size = arrayList.size();
        int i = 0;
        while (!this.isStop && i < size) {
            str = (String) arrayList.get(i);
            if (!C5046bo.isNullOrNil(str)) {
                if (str.endsWith("/sns/")) {
                    HP = m65838HP(str);
                } else if (str.endsWith("/music")) {
                    HP = m65839HQ(str);
                } else {
                    HP = m65837HO(str);
                }
                this.kvZ.put(str, Long.valueOf(HP));
                C4990ab.m7411d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", aZk(), str, Long.valueOf(HP));
                this.kvV += HP;
                if (hashSet.contains(str)) {
                    this.kvX = HP + this.kvX;
                }
                int i2 = i + 1;
                if (this.kwb != null) {
                    this.kwb.mo35471dN(i2, size);
                }
                i = i2;
            }
        }
        this.kvW = C45913b.aZc().aZd().aZn();
        this.kvV += this.kvW;
        if (this.kvV <= 0) {
            this.kvV = 1;
            C7060h.pYm.mo8378a(714, 60, 1, false);
        }
        C4990ab.m7417i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", aZk(), Long.valueOf(C5046bo.m7525az(yz)), Long.valueOf(this.kvV), Long.valueOf(this.kvW), Long.valueOf(this.kvX));
        HashSet hashSet2 = this.kwa;
        if (this.kwb != null) {
            this.kwb.mo35470a(this.kvV, this.kvW, this.kvX, hashSet2, this.kvZ);
        }
        C6826j.bgd();
        long bfL = C6826j.bfL();
        C6826j.bgd();
        HP = C6826j.bfM();
        int i3 = (int) ((this.kvV * 100) / bfL);
        int i4 = (int) ((this.kvW * 100) / this.kvV);
        size = (int) ((this.kvX * 100) / this.kvV);
        long j = (this.kvV - this.kvW) - this.kvX;
        int i5 = (int) ((100 * j) / this.kvV);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.kvY).append(",");
        stringBuffer.append(this.kvV).append(",");
        stringBuffer.append(i3).append(",");
        stringBuffer.append(bfL - HP).append(",");
        stringBuffer.append(HP).append(",");
        stringBuffer.append(bfL).append(",");
        stringBuffer.append(this.kvW).append(",");
        stringBuffer.append(i4).append(",");
        stringBuffer.append(this.kvX).append(",");
        stringBuffer.append(size).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(i5);
        C4990ab.m7417i("MicroMsg.CleanCalcLogic", "rpt content %s", stringBuffer.toString());
        C7060h.pYm.mo8374X(14762, str);
        stop();
        AppMethodBeat.m2505o(18654);
    }

    /* renamed from: HO */
    private long m65837HO(String str) {
        AppMethodBeat.m2504i(18655);
        C5728b c5728b = new C5728b(str);
        if (c5728b.isDirectory()) {
            String[] list = c5728b.list();
            if (list != null) {
                long j = 0;
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/".concat(String.valueOf(str22));
                    }
                    long HO = m65837HO(append.append(str22).toString());
                    if (HO == -1) {
                        AppMethodBeat.m2505o(18655);
                        return -1;
                    }
                    j += HO;
                }
                AppMethodBeat.m2505o(18655);
                return j;
            }
        }
        long length = c5728b.length();
        AppMethodBeat.m2505o(18655);
        return length;
    }

    /* renamed from: a */
    private int m65840a(List<String> list, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(18656);
        String str = C1720g.m3536RP().eJL;
        String str2 = C1720g.m3536RP().eJM;
        C4990ab.m7417i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", aZk(), str, str2);
        int i = 0;
        C5728b c5728b = new C5728b(str);
        if (c5728b.isDirectory()) {
            String[] list2 = c5728b.list();
            if (list2 != null) {
                int length = list2.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    String str3 = list2[i2];
                    String str4 = str + str3 + "/";
                    C4990ab.m7411d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", aZk(), str4, str3);
                    if (!new C5728b(str4).isDirectory()) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (str3.length() < 32) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (C5046bo.isEqual(str2, str4)) {
                        list.add(str2.endsWith("/") ? str2 + "music" : str2 + "/music");
                        C9638aw.m17190ZK();
                        list.add(C18628c.m29093Yb());
                        C9638aw.m17190ZK();
                        list.add(C18628c.getAccSnsPath());
                        C9638aw.m17190ZK();
                        list.add(C18628c.m29098Yg());
                        i3 = i;
                    } else {
                        hashSet.add(str4);
                        list.add(str4);
                        i3 = i + 1;
                        this.kwa.add(str3);
                    }
                    i2++;
                    i = i3;
                }
            }
        }
        AppMethodBeat.m2505o(18656);
        return i;
    }

    /* renamed from: HP */
    private long m65838HP(String str) {
        long j = 0;
        int i = 0;
        AppMethodBeat.m2504i(18657);
        C5728b c5728b = new C5728b(str);
        if (c5728b.isDirectory()) {
            String[] list = c5728b.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    j += m65838HP(str + "/" + list[i]);
                    i++;
                }
                AppMethodBeat.m2505o(18657);
                return j;
            }
        } else if (System.currentTimeMillis() - c5728b.lastModified() > clo.longValue()) {
            C4990ab.m7417i("MicroMsg.CleanCalcLogic", "Clean 7 days file in sns rootPath=%s", str);
            long asZ = C5730e.asZ(str);
            if (c5728b.delete()) {
                this.kvY += asZ;
            }
            AppMethodBeat.m2505o(18657);
            return 0;
        }
        j = C5730e.asZ(str);
        AppMethodBeat.m2505o(18657);
        return j;
    }

    /* renamed from: HQ */
    private long m65839HQ(String str) {
        long j = 0;
        int i = 0;
        AppMethodBeat.m2504i(18658);
        C5728b c5728b = new C5728b(str);
        if (c5728b.isDirectory()) {
            String[] list = c5728b.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    j += m65839HQ(str + "/" + list[i]);
                    i++;
                }
                AppMethodBeat.m2505o(18658);
                return j;
            }
        } else if (System.currentTimeMillis() - c5728b.lastModified() > kvU.longValue()) {
            C4990ab.m7417i("MicroMsg.CleanCalcLogic", "Clean 90 days file in music rootPath=%s", str);
            long asZ = C5730e.asZ(str);
            if (c5728b.delete()) {
                this.kvY += asZ;
            }
            AppMethodBeat.m2505o(18658);
            return 0;
        }
        j = C5730e.asZ(str);
        AppMethodBeat.m2505o(18658);
        return j;
    }
}
