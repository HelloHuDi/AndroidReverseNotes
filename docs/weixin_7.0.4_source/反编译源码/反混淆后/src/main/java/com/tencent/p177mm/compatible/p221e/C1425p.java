package com.tencent.p177mm.compatible.p221e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.compatible.e.p */
public final class C1425p {
    private RandomAccessFile esR;
    private RandomAccessFile esS;
    private C1424a esT;
    private ArrayList<C1424a> esU;
    private long pid = 0;

    /* renamed from: com.tencent.mm.compatible.e.p$a */
    public class C1424a {
        int esV;
        long esW;
        long esX;
        long esY;
        int esZ;
        long mLastIdle;

        public C1424a() {
            this.esV = 0;
            this.esW = 0;
            this.mLastIdle = 0;
            this.esX = 0;
            this.esY = 0;
            this.esZ = 0;
        }

        public C1424a(long j) {
            this.esX = j;
        }

        /* renamed from: i */
        public final void mo4871i(String[] strArr) {
            AppMethodBeat.m2504i(92957);
            long parseLong = Long.parseLong(strArr[4], 10);
            long j = 0;
            Object obj = 1;
            for (String str : strArr) {
                if (obj != null) {
                    obj = null;
                } else {
                    j += Long.parseLong(str, 10);
                }
            }
            long j2 = j - this.esW;
            this.esV = (int) ((((float) (j2 - (parseLong - this.mLastIdle))) / ((float) j2)) * 100.0f);
            this.esW = j;
            this.mLastIdle = parseLong;
            C4990ab.m7416i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j + "; idle=" + parseLong + "; usage=" + this.esV);
            AppMethodBeat.m2505o(92957);
        }
    }

    public C1425p(long j) {
        this.pid = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A:{SYNTHETIC, Splitter:B:7:0x0025} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: LG */
    private void m3022LG() {
        String readLine;
        AppMethodBeat.m2504i(92959);
        String str = null;
        if (this.esS != null) {
            try {
                this.esS.seek(0);
                readLine = this.esS.readLine();
            } catch (IOException e) {
                C4990ab.m7412e(" MicroMsg.CpuUsage", "Ops pidStatFile: ".concat(String.valueOf(e)));
            }
            if (this.esR != null) {
                try {
                    this.esR.seek(0);
                    int i = -1;
                    while (true) {
                        int i2 = i;
                        String readLine2 = this.esR.readLine();
                        if (readLine2 == null || readLine2.length() <= 0) {
                            C4990ab.m7413e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i2));
                        } else {
                            String[] split = readLine2.split("[ ]+");
                            if (split[0].indexOf("cpu") != -1) {
                                if (i2 == -1) {
                                    if (this.esT == null) {
                                        this.esT = new C1424a(this.pid);
                                    }
                                    C1424a c1424a = this.esT;
                                    if (c1424a.esX <= 0) {
                                        c1424a.mo4871i(split);
                                    } else {
                                        if (readLine != null) {
                                            if (readLine.length() > 0) {
                                                String[] split2 = readLine.split("[ ]+");
                                                if (split2 != null && split2.length > 0 && split2[0] != null && Long.parseLong(split2[0], 10) == c1424a.esX) {
                                                    long parseLong = Long.parseLong(split2[13], 10);
                                                    long parseLong2 = Long.parseLong(split2[14], 10);
                                                    long parseLong3 = ((parseLong + parseLong2) + Long.parseLong(split2[15], 10)) + Long.parseLong(split2[16], 10);
                                                    long parseLong4 = Long.parseLong(split[4], 10);
                                                    long j = 0;
                                                    Object obj = 1;
                                                    for (String str2 : split) {
                                                        if (obj != null) {
                                                            obj = null;
                                                        } else {
                                                            j += Long.parseLong(str2, 10);
                                                        }
                                                    }
                                                    long j2 = j - c1424a.esW;
                                                    long j3 = parseLong3 - c1424a.esY;
                                                    c1424a.esV = (int) ((((float) (j2 - (parseLong4 - c1424a.mLastIdle))) / ((float) j2)) * 100.0f);
                                                    c1424a.esZ = (int) ((((float) j3) / ((float) j2)) * 100.0f);
                                                    c1424a.esW = j;
                                                    c1424a.mLastIdle = parseLong4;
                                                    c1424a.esY = parseLong3;
                                                    C4990ab.m7417i(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", Integer.valueOf(c1424a.hashCode()), Long.valueOf(j), Long.valueOf(parseLong4), Integer.valueOf(c1424a.esV), Long.valueOf(c1424a.esX), Long.valueOf(parseLong3), Integer.valueOf(c1424a.esZ), Long.valueOf(parseLong), Long.valueOf(parseLong2), Long.valueOf(r16), Long.valueOf(r18), Long.valueOf(j2), Long.valueOf(r24), Long.valueOf(j3));
                                                }
                                            }
                                        }
                                        C4990ab.m7413e(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", Long.valueOf(c1424a.esX), readLine);
                                    }
                                } else {
                                    if (this.esU == null) {
                                        this.esU = new ArrayList();
                                    }
                                    if (i2 < this.esU.size()) {
                                        ((C1424a) this.esU.get(i2)).mo4871i(split);
                                    } else {
                                        C1424a c1424a2 = new C1424a();
                                        c1424a2.mo4871i(split);
                                        this.esU.add(c1424a2);
                                    }
                                }
                            }
                        }
                        i = i2 + 1;
                        if (readLine2 == null) {
                            AppMethodBeat.m2505o(92959);
                            return;
                        }
                    }
                } catch (IOException e2) {
                    C4990ab.m7412e(" MicroMsg.CpuUsage", "Ops statFile: ".concat(String.valueOf(e2)));
                }
            }
            AppMethodBeat.m2505o(92959);
        }
        readLine = str;
        if (this.esR != null) {
        }
        AppMethodBeat.m2505o(92959);
    }

    /* renamed from: LH */
    public final int mo4872LH() {
        AppMethodBeat.m2504i(92960);
        if (C5046bo.m7548ek(this.esU)) {
            AppMethodBeat.m2505o(92960);
            return 1;
        }
        int size = this.esU.size();
        AppMethodBeat.m2505o(92960);
        return size;
    }

    /* renamed from: LI */
    public final int mo4873LI() {
        AppMethodBeat.m2504i(92961);
        update();
        int i = 0;
        if (this.esT != null) {
            i = this.esT.esV;
        }
        AppMethodBeat.m2505o(92961);
        return i;
    }

    /* renamed from: LJ */
    public final int mo4874LJ() {
        AppMethodBeat.m2504i(92962);
        int i = 0;
        if (this.esT != null) {
            i = this.esT.esZ;
        }
        if (this.esU != null && this.esU.size() > 1) {
            i *= this.esU.size();
        }
        AppMethodBeat.m2505o(92962);
        return i;
    }

    public final String toString() {
        AppMethodBeat.m2504i(92963);
        update();
        StringBuffer stringBuffer = new StringBuffer();
        if (this.esT != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.esT.esV);
            stringBuffer.append("%");
            if (this.pid > 0) {
                stringBuffer.append("pid(");
                stringBuffer.append(this.pid + ") :");
                stringBuffer.append(this.esT.esZ);
                stringBuffer.append("%");
            }
        }
        if (this.esU != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.esU.size()) {
                    break;
                }
                C1424a c1424a = (C1424a) this.esU.get(i2);
                stringBuffer.append(" Cpu Core(" + i2 + ") : ");
                stringBuffer.append(c1424a.esV);
                stringBuffer.append("%");
                i = i2 + 1;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(92963);
        return stringBuffer2;
    }

    private void update() {
        AppMethodBeat.m2504i(92958);
        try {
            this.esR = new RandomAccessFile("/proc/stat", "r");
            if (this.pid > 0) {
                this.esS = new RandomAccessFile("/proc/" + this.pid + "/stat", "r");
            }
            m3022LG();
            if (this.esR != null) {
                this.esR.close();
            }
            if (this.esS != null) {
                this.esS.close();
            }
            AppMethodBeat.m2505o(92958);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(" MicroMsg.CpuUsage", e, "update e:", new Object[0]);
            if (this.esR != null) {
                try {
                    this.esR.close();
                } catch (Exception e2) {
                }
                this.esR = null;
            }
            if (this.esS != null) {
                try {
                    this.esS.close();
                } catch (Exception e3) {
                }
                this.esS = null;
            }
            AppMethodBeat.m2505o(92958);
        }
    }
}
