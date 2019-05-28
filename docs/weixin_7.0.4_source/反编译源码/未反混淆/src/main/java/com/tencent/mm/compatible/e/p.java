package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p {
    private RandomAccessFile esR;
    private RandomAccessFile esS;
    private a esT;
    private ArrayList<a> esU;
    private long pid = 0;

    public class a {
        int esV;
        long esW;
        long esX;
        long esY;
        int esZ;
        long mLastIdle;

        public a() {
            this.esV = 0;
            this.esW = 0;
            this.mLastIdle = 0;
            this.esX = 0;
            this.esY = 0;
            this.esZ = 0;
        }

        public a(long j) {
            this.esX = j;
        }

        public final void i(String[] strArr) {
            AppMethodBeat.i(92957);
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
            ab.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j + "; idle=" + parseLong + "; usage=" + this.esV);
            AppMethodBeat.o(92957);
        }
    }

    public p(long j) {
        this.pid = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A:{SYNTHETIC, Splitter:B:7:0x0025} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void LG() {
        String readLine;
        AppMethodBeat.i(92959);
        String str = null;
        if (this.esS != null) {
            try {
                this.esS.seek(0);
                readLine = this.esS.readLine();
            } catch (IOException e) {
                ab.e(" MicroMsg.CpuUsage", "Ops pidStatFile: ".concat(String.valueOf(e)));
            }
            if (this.esR != null) {
                try {
                    this.esR.seek(0);
                    int i = -1;
                    while (true) {
                        int i2 = i;
                        String readLine2 = this.esR.readLine();
                        if (readLine2 == null || readLine2.length() <= 0) {
                            ab.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i2));
                        } else {
                            String[] split = readLine2.split("[ ]+");
                            if (split[0].indexOf("cpu") != -1) {
                                if (i2 == -1) {
                                    if (this.esT == null) {
                                        this.esT = new a(this.pid);
                                    }
                                    a aVar = this.esT;
                                    if (aVar.esX <= 0) {
                                        aVar.i(split);
                                    } else {
                                        if (readLine != null) {
                                            if (readLine.length() > 0) {
                                                String[] split2 = readLine.split("[ ]+");
                                                if (split2 != null && split2.length > 0 && split2[0] != null && Long.parseLong(split2[0], 10) == aVar.esX) {
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
                                                    long j2 = j - aVar.esW;
                                                    long j3 = parseLong3 - aVar.esY;
                                                    aVar.esV = (int) ((((float) (j2 - (parseLong4 - aVar.mLastIdle))) / ((float) j2)) * 100.0f);
                                                    aVar.esZ = (int) ((((float) j3) / ((float) j2)) * 100.0f);
                                                    aVar.esW = j;
                                                    aVar.mLastIdle = parseLong4;
                                                    aVar.esY = parseLong3;
                                                    ab.i(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", Integer.valueOf(aVar.hashCode()), Long.valueOf(j), Long.valueOf(parseLong4), Integer.valueOf(aVar.esV), Long.valueOf(aVar.esX), Long.valueOf(parseLong3), Integer.valueOf(aVar.esZ), Long.valueOf(parseLong), Long.valueOf(parseLong2), Long.valueOf(r16), Long.valueOf(r18), Long.valueOf(j2), Long.valueOf(r24), Long.valueOf(j3));
                                                }
                                            }
                                        }
                                        ab.e(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", Long.valueOf(aVar.esX), readLine);
                                    }
                                } else {
                                    if (this.esU == null) {
                                        this.esU = new ArrayList();
                                    }
                                    if (i2 < this.esU.size()) {
                                        ((a) this.esU.get(i2)).i(split);
                                    } else {
                                        a aVar2 = new a();
                                        aVar2.i(split);
                                        this.esU.add(aVar2);
                                    }
                                }
                            }
                        }
                        i = i2 + 1;
                        if (readLine2 == null) {
                            AppMethodBeat.o(92959);
                            return;
                        }
                    }
                } catch (IOException e2) {
                    ab.e(" MicroMsg.CpuUsage", "Ops statFile: ".concat(String.valueOf(e2)));
                }
            }
            AppMethodBeat.o(92959);
        }
        readLine = str;
        if (this.esR != null) {
        }
        AppMethodBeat.o(92959);
    }

    public final int LH() {
        AppMethodBeat.i(92960);
        if (bo.ek(this.esU)) {
            AppMethodBeat.o(92960);
            return 1;
        }
        int size = this.esU.size();
        AppMethodBeat.o(92960);
        return size;
    }

    public final int LI() {
        AppMethodBeat.i(92961);
        update();
        int i = 0;
        if (this.esT != null) {
            i = this.esT.esV;
        }
        AppMethodBeat.o(92961);
        return i;
    }

    public final int LJ() {
        AppMethodBeat.i(92962);
        int i = 0;
        if (this.esT != null) {
            i = this.esT.esZ;
        }
        if (this.esU != null && this.esU.size() > 1) {
            i *= this.esU.size();
        }
        AppMethodBeat.o(92962);
        return i;
    }

    public final String toString() {
        AppMethodBeat.i(92963);
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
                a aVar = (a) this.esU.get(i2);
                stringBuffer.append(" Cpu Core(" + i2 + ") : ");
                stringBuffer.append(aVar.esV);
                stringBuffer.append("%");
                i = i2 + 1;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(92963);
        return stringBuffer2;
    }

    private void update() {
        AppMethodBeat.i(92958);
        try {
            this.esR = new RandomAccessFile("/proc/stat", "r");
            if (this.pid > 0) {
                this.esS = new RandomAccessFile("/proc/" + this.pid + "/stat", "r");
            }
            LG();
            if (this.esR != null) {
                this.esR.close();
            }
            if (this.esS != null) {
                this.esS.close();
            }
            AppMethodBeat.o(92958);
        } catch (Exception e) {
            ab.printErrStackTrace(" MicroMsg.CpuUsage", e, "update e:", new Object[0]);
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
            AppMethodBeat.o(92958);
        }
    }
}
