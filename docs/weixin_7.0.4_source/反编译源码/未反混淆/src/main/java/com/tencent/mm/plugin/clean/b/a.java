package com.tencent.mm.plugin.clean.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class a implements Runnable {
    private static final Long clo = Long.valueOf(604800000);
    private static final Long kvU = Long.valueOf(7776000000L);
    private boolean isStop;
    private long kvV;
    private long kvW;
    private long kvX;
    private long kvY;
    private HashMap<String, Long> kvZ;
    private HashSet<String> kwa;
    private c kwb;

    static {
        AppMethodBeat.i(18659);
        AppMethodBeat.o(18659);
    }

    public a(c cVar) {
        AppMethodBeat.i(18652);
        this.isStop = false;
        this.isStop = false;
        this.kwb = cVar;
        this.kvZ = new HashMap();
        this.kwa = new HashSet();
        AppMethodBeat.o(18652);
    }

    public final void stop() {
        this.isStop = true;
        this.kwb = null;
    }

    private String aZk() {
        AppMethodBeat.i(18653);
        String str = hashCode();
        AppMethodBeat.o(18653);
        return str;
    }

    public final void run() {
        AppMethodBeat.i(18654);
        long yz = bo.yz();
        if (this.isStop) {
            ab.i("MicroMsg.CleanCalcLogic", "%s start run but stop", aZk());
            AppMethodBeat.o(18654);
            return;
        }
        String str;
        long HP;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        a(arrayList, hashSet);
        int size = arrayList.size();
        int i = 0;
        while (!this.isStop && i < size) {
            str = (String) arrayList.get(i);
            if (!bo.isNullOrNil(str)) {
                if (str.endsWith("/sns/")) {
                    HP = HP(str);
                } else if (str.endsWith("/music")) {
                    HP = HQ(str);
                } else {
                    HP = HO(str);
                }
                this.kvZ.put(str, Long.valueOf(HP));
                ab.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", aZk(), str, Long.valueOf(HP));
                this.kvV += HP;
                if (hashSet.contains(str)) {
                    this.kvX = HP + this.kvX;
                }
                int i2 = i + 1;
                if (this.kwb != null) {
                    this.kwb.dN(i2, size);
                }
                i = i2;
            }
        }
        this.kvW = b.aZc().aZd().aZn();
        this.kvV += this.kvW;
        if (this.kvV <= 0) {
            this.kvV = 1;
            h.pYm.a(714, 60, 1, false);
        }
        ab.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", aZk(), Long.valueOf(bo.az(yz)), Long.valueOf(this.kvV), Long.valueOf(this.kvW), Long.valueOf(this.kvX));
        HashSet hashSet2 = this.kwa;
        if (this.kwb != null) {
            this.kwb.a(this.kvV, this.kvW, this.kvX, hashSet2, this.kvZ);
        }
        j.bgd();
        long bfL = j.bfL();
        j.bgd();
        HP = j.bfM();
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
        ab.i("MicroMsg.CleanCalcLogic", "rpt content %s", stringBuffer.toString());
        h.pYm.X(14762, str);
        stop();
        AppMethodBeat.o(18654);
    }

    private long HO(String str) {
        AppMethodBeat.i(18655);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (bVar.isDirectory()) {
            String[] list = bVar.list();
            if (list != null) {
                long j = 0;
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/".concat(String.valueOf(str22));
                    }
                    long HO = HO(append.append(str22).toString());
                    if (HO == -1) {
                        AppMethodBeat.o(18655);
                        return -1;
                    }
                    j += HO;
                }
                AppMethodBeat.o(18655);
                return j;
            }
        }
        long length = bVar.length();
        AppMethodBeat.o(18655);
        return length;
    }

    private int a(List<String> list, HashSet<String> hashSet) {
        AppMethodBeat.i(18656);
        String str = g.RP().eJL;
        String str2 = g.RP().eJM;
        ab.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", aZk(), str, str2);
        int i = 0;
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (bVar.isDirectory()) {
            String[] list2 = bVar.list();
            if (list2 != null) {
                int length = list2.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    String str3 = list2[i2];
                    String str4 = str + str3 + "/";
                    ab.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", aZk(), str4, str3);
                    if (!new com.tencent.mm.vfs.b(str4).isDirectory()) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (str3.length() < 32) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (bo.isEqual(str2, str4)) {
                        list.add(str2.endsWith("/") ? str2 + "music" : str2 + "/music");
                        aw.ZK();
                        list.add(c.Yb());
                        aw.ZK();
                        list.add(c.getAccSnsPath());
                        aw.ZK();
                        list.add(c.Yg());
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
        AppMethodBeat.o(18656);
        return i;
    }

    private long HP(String str) {
        long j = 0;
        int i = 0;
        AppMethodBeat.i(18657);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (bVar.isDirectory()) {
            String[] list = bVar.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    j += HP(str + "/" + list[i]);
                    i++;
                }
                AppMethodBeat.o(18657);
                return j;
            }
        } else if (System.currentTimeMillis() - bVar.lastModified() > clo.longValue()) {
            ab.i("MicroMsg.CleanCalcLogic", "Clean 7 days file in sns rootPath=%s", str);
            long asZ = e.asZ(str);
            if (bVar.delete()) {
                this.kvY += asZ;
            }
            AppMethodBeat.o(18657);
            return 0;
        }
        j = e.asZ(str);
        AppMethodBeat.o(18657);
        return j;
    }

    private long HQ(String str) {
        long j = 0;
        int i = 0;
        AppMethodBeat.i(18658);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (bVar.isDirectory()) {
            String[] list = bVar.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    j += HQ(str + "/" + list[i]);
                    i++;
                }
                AppMethodBeat.o(18658);
                return j;
            }
        } else if (System.currentTimeMillis() - bVar.lastModified() > kvU.longValue()) {
            ab.i("MicroMsg.CleanCalcLogic", "Clean 90 days file in music rootPath=%s", str);
            long asZ = e.asZ(str);
            if (bVar.delete()) {
                this.kvY += asZ;
            }
            AppMethodBeat.o(18658);
            return 0;
        }
        j = e.asZ(str);
        AppMethodBeat.o(18658);
        return j;
    }
}
