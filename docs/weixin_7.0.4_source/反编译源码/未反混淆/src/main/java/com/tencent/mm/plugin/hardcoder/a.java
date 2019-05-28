package com.tencent.mm.plugin.hardcoder;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.j;
import com.tencent.mm.hardcoder.k;
import com.tencent.mm.hardcoder.l;
import com.tencent.mm.hardcoder.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class a implements com.tencent.mm.hardcoder.e.a, com.tencent.mm.hardcoder.j.a {
    private static String nqc = null;
    private static Long nqd = null;
    public static boolean nqe = false;
    private static a nqf;
    private c mBC = new c<cc>() {
        {
            AppMethodBeat.i(60241);
            this.xxI = cc.class.getName().hashCode();
            AppMethodBeat.o(60241);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(60242);
            if (((cc) bVar) instanceof cc) {
                ArrayList arrayList;
                dead();
                if (!a.this.nqg.isEmpty()) {
                    arrayList = (ArrayList) a.this.nqg.clone();
                    a.this.nqg.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        h.pYm.e(((Integer) pair.first).intValue(), (Object[]) pair.second);
                    }
                }
                if (!a.this.nqh.isEmpty()) {
                    arrayList = (ArrayList) a.this.nqh.clone();
                    a.this.nqh.clear();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Object[] objArr = (Object[]) it2.next();
                        if (objArr.length >= 4) {
                            h.pYm.a(((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue());
                        }
                    }
                }
            }
            AppMethodBeat.o(60242);
            return false;
        }
    };
    private ArrayList<Pair<Integer, Object[]>> nqg = new ArrayList();
    private ArrayList<Object[]> nqh = new ArrayList();

    public a() {
        AppMethodBeat.i(60243);
        AppMethodBeat.o(60243);
    }

    public static a bFR() {
        AppMethodBeat.i(60244);
        if (nqf == null) {
            nqf = new a();
        }
        a aVar = nqf;
        AppMethodBeat.o(60244);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x03af A:{SYNTHETIC, Splitter:B:68:0x03af} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x03e1 A:{SYNTHETIC, Splitter:B:76:0x03e1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int[] iArr, int i, int i2, int i3, int i4, long j, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10, int i11, long j2, int[] iArr3, int[] iArr4) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(60245);
        if (ab.getLogLevel() <= 1 || WXHardCoderJNI.hcKVPerReport) {
            int i12;
            int i13 = WXHardCoderJNI.isHCEnable() ? 1 : 0;
            if (nqd == null) {
                if (ah.bqo()) {
                    g.RQ();
                    nqd = (Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0));
                } else {
                    nqd = Long.valueOf(0);
                }
            }
            if (nqc == null) {
                nqc = bo.gN(ah.getContext());
            }
            String str = nqc;
            int longValue = (int) nqd.longValue();
            StringBuilder stringBuilder = new StringBuilder();
            if (iArr2 != null) {
                for (int i14 : iArr2) {
                    stringBuilder.append(i14 + "#");
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            if (iArr3 != null) {
                for (int i122 : iArr3) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    if (i122 < 0) {
                        i122 = 0;
                    }
                    stringBuilder2.append(stringBuilder3.append(i122).append("#").toString());
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            if (iArr4 != null) {
                for (int i1222 : iArr4) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    if (i1222 < 0) {
                        i1222 = 0;
                    }
                    stringBuilder4.append(stringBuilder5.append(i1222).append("#").toString());
                }
            }
            String format = String.format("[oneliang]performance report,imei:%s,threadId:%s,enable:%s, heavy:%s,speedUp:%s,engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{str, Arrays.toString(iArr), Integer.valueOf(i), Integer.valueOf(longValue), Integer.valueOf(i13), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), stringBuilder.toString(), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder4.toString()});
            String format2 = String.format("time:%s,imei:%s,threadId:%s,enable:%s,heavy:%s,speedUp:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{Long.valueOf(System.currentTimeMillis()), str, Arrays.toString(iArr), Integer.valueOf(i), Integer.valueOf(longValue), Integer.valueOf(i13), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), stringBuilder.toString(), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder4.toString()});
            if (WXHardCoderJNI.getDebug()) {
                ab.i("MicroMsg.HardCoderReporterImpl", format);
            }
            Object[] objArr = new Object[21];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(longValue);
            objArr[2] = Integer.valueOf(i13);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Long.valueOf(j);
            objArr[6] = Integer.valueOf(i5);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = stringBuilder.toString();
            if (i7 < 0) {
                i7 = 0;
            }
            objArr[9] = Integer.valueOf(i7);
            objArr[10] = Integer.valueOf(i8);
            objArr[11] = Integer.valueOf(i9);
            objArr[12] = Integer.valueOf(i10);
            objArr[13] = Integer.valueOf(i11);
            objArr[14] = Long.valueOf(j2);
            objArr[15] = stringBuilder2.toString();
            objArr[16] = stringBuilder4.toString();
            objArr[17] = "";
            objArr[18] = Integer.valueOf(0);
            objArr[19] = Integer.valueOf(i2);
            objArr[20] = Integer.valueOf(i);
            e(14607, objArr);
            if (nqe) {
                StringBuilder stringBuilder6 = new StringBuilder();
                g.RQ();
                e.f(stringBuilder6.append(g.RP().eJL).append("/hcstat").toString());
                File file = new File(format, "data.txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e2) {
                        ab.i("MicroMsg.HardCoderReporterImpl", "create new file exception:" + e2.getMessage());
                    }
                }
                OutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file, true);
                    try {
                        fileOutputStream.write((format2 + IOUtils.LINE_SEPARATOR_UNIX).getBytes("UTF-8"));
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                            AppMethodBeat.o(60245);
                            return;
                        } catch (Exception e22) {
                            ab.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e22.getMessage());
                            AppMethodBeat.o(60245);
                            return;
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                        try {
                            ab.i("MicroMsg.HardCoderReporterImpl", "exception:" + e22.getMessage());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    AppMethodBeat.o(60245);
                                    return;
                                } catch (Exception e222) {
                                    ab.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e222.getMessage());
                                    AppMethodBeat.o(60245);
                                    return;
                                }
                            }
                            AppMethodBeat.o(60245);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.o(60245);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e222 = e4;
                    fileOutputStream = null;
                    ab.i("MicroMsg.HardCoderReporterImpl", "exception:" + e222.getMessage());
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(60245);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                            ab.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e5.getMessage());
                        }
                    }
                    AppMethodBeat.o(60245);
                    throw th;
                }
            }
            AppMethodBeat.o(60245);
            return;
        }
        AppMethodBeat.o(60245);
    }

    public final void reportInfo(j jVar) {
        AppMethodBeat.i(60246);
        long j;
        if (jVar instanceof l) {
            long j2;
            l lVar = (l) jVar;
            ab.i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", Boolean.valueOf(lVar.eEP), Integer.valueOf(lVar.key), Integer.valueOf(lVar.value), Boolean.valueOf(lVar.cNv));
            if (lVar.eEP) {
                j2 = 678;
            } else {
                j2 = 679;
            }
            long j3 = (long) lVar.key;
            j = (long) lVar.value;
            boolean z = lVar.cNv;
            if (!ah.bqo() || g.RN().eJb) {
                h.pYm.a(j2, j3, j, z);
                AppMethodBeat.o(60246);
                return;
            }
            ab.w("MicroMsg.HardCoderReporterImpl", "idkeyStat accountNotInitialReady!");
            this.mBC.dnU();
            this.nqh.add(new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j), Boolean.valueOf(z)});
            AppMethodBeat.o(60246);
        } else if (jVar instanceof k) {
            k kVar = (k) jVar;
            if (nqd == null) {
                g.RQ();
                nqd = (Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0));
            }
            if (nqc == null) {
                nqc = bo.gN(ah.getContext());
            }
            String str = nqc;
            int longValue = (int) nqd.longValue();
            int i = WXHardCoderJNI.isHCEnable() ? 1 : 0;
            int isRunning = WXHardCoderJNI.isRunning();
            int i2 = WXHardCoderJNI.getEnable() ? 1 : 0;
            if (kVar.type == 1) {
                j = (kVar.eEO * 100) / kVar.interval;
                e(15187, str, Integer.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(isRunning), Integer.valueOf(kVar.scene), Long.valueOf(kVar.eDJ), Integer.valueOf(kVar.type), Long.valueOf(kVar.eEO), Long.valueOf(kVar.interval), Long.valueOf(j), Integer.valueOf(i2));
                ab.i("MicroMsg.HardCoderReporterImpl", String.format("fpsReport imei:%s enable:%s, heavy:%s speedUp:%s, engineStatus:%s, scene:%s, action:%s, type:%s, totalDroppedFrames:%s, interval:%s, average:%s", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(isRunning), Integer.valueOf(kVar.scene), Long.valueOf(kVar.eDJ), Integer.valueOf(kVar.type), Long.valueOf(kVar.eEO), Long.valueOf(kVar.interval), Long.valueOf(j)}));
            }
            AppMethodBeat.o(60246);
        } else {
            if (jVar instanceof m) {
                e(16509, new Object[0]);
            }
            AppMethodBeat.o(60246);
        }
    }

    private void e(int i, Object... objArr) {
        AppMethodBeat.i(60247);
        if (!ah.bqo() || g.RN().eJb) {
            h.pYm.e(i, objArr);
            AppMethodBeat.o(60247);
            return;
        }
        ab.w("MicroMsg.HardCoderReporterImpl", "kvStat accountNotInitialReady!");
        this.mBC.dnU();
        this.nqg.add(new Pair(Integer.valueOf(i), objArr));
        AppMethodBeat.o(60247);
    }
}
