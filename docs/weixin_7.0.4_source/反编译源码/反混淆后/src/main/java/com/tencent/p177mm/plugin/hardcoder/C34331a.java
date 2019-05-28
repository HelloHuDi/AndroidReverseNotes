package com.tencent.p177mm.plugin.hardcoder;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1618e.C1617a;
import com.tencent.p177mm.hardcoder.C1627j;
import com.tencent.p177mm.hardcoder.C1627j.C1626a;
import com.tencent.p177mm.hardcoder.C6589k;
import com.tencent.p177mm.hardcoder.C6590l;
import com.tencent.p177mm.hardcoder.C6591m;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C6464cc;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.hardcoder.a */
public final class C34331a implements C1617a, C1626a {
    private static String nqc = null;
    private static Long nqd = null;
    public static boolean nqe = false;
    private static C34331a nqf;
    private C4884c mBC = new C343321();
    private ArrayList<Pair<Integer, Object[]>> nqg = new ArrayList();
    private ArrayList<Object[]> nqh = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.hardcoder.a$1 */
    class C343321 extends C4884c<C6464cc> {
        C343321() {
            AppMethodBeat.m2504i(60241);
            this.xxI = C6464cc.class.getName().hashCode();
            AppMethodBeat.m2505o(60241);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(60242);
            if (((C6464cc) c4883b) instanceof C6464cc) {
                ArrayList arrayList;
                dead();
                if (!C34331a.this.nqg.isEmpty()) {
                    arrayList = (ArrayList) C34331a.this.nqg.clone();
                    C34331a.this.nqg.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        C7060h.pYm.mo8381e(((Integer) pair.first).intValue(), (Object[]) pair.second);
                    }
                }
                if (!C34331a.this.nqh.isEmpty()) {
                    arrayList = (ArrayList) C34331a.this.nqh.clone();
                    C34331a.this.nqh.clear();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Object[] objArr = (Object[]) it2.next();
                        if (objArr.length >= 4) {
                            C7060h.pYm.mo8378a(((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue());
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(60242);
            return false;
        }
    }

    public C34331a() {
        AppMethodBeat.m2504i(60243);
        AppMethodBeat.m2505o(60243);
    }

    public static C34331a bFR() {
        AppMethodBeat.m2504i(60244);
        if (nqf == null) {
            nqf = new C34331a();
        }
        C34331a c34331a = nqf;
        AppMethodBeat.m2505o(60244);
        return c34331a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x03af A:{SYNTHETIC, Splitter:B:68:0x03af} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x03e1 A:{SYNTHETIC, Splitter:B:76:0x03e1} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo5073a(int[] iArr, int i, int i2, int i3, int i4, long j, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10, int i11, long j2, int[] iArr3, int[] iArr4) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(60245);
        if (C4990ab.getLogLevel() <= 1 || WXHardCoderJNI.hcKVPerReport) {
            int i12;
            int i13 = WXHardCoderJNI.isHCEnable() ? 1 : 0;
            if (nqd == null) {
                if (C4996ah.bqo()) {
                    C1720g.m3537RQ();
                    nqd = (Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0));
                } else {
                    nqd = Long.valueOf(0);
                }
            }
            if (nqc == null) {
                nqc = C5046bo.m7552gN(C4996ah.getContext());
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
                C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", format);
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
            m56278e(14607, objArr);
            if (nqe) {
                StringBuilder stringBuilder6 = new StringBuilder();
                C1720g.m3537RQ();
                C1173e.m2570f(stringBuilder6.append(C1720g.m3536RP().eJL).append("/hcstat").toString());
                File file = new File(format, "data.txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e2) {
                        C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", "create new file exception:" + e2.getMessage());
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
                            AppMethodBeat.m2505o(60245);
                            return;
                        } catch (Exception e22) {
                            C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", "close exception:" + e22.getMessage());
                            AppMethodBeat.m2505o(60245);
                            return;
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                        try {
                            C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", "exception:" + e22.getMessage());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    AppMethodBeat.m2505o(60245);
                                    return;
                                } catch (Exception e222) {
                                    C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", "close exception:" + e222.getMessage());
                                    AppMethodBeat.m2505o(60245);
                                    return;
                                }
                            }
                            AppMethodBeat.m2505o(60245);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(60245);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e222 = e4;
                    fileOutputStream = null;
                    C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", "exception:" + e222.getMessage());
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(60245);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                            C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", "close exception:" + e5.getMessage());
                        }
                    }
                    AppMethodBeat.m2505o(60245);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(60245);
            return;
        }
        AppMethodBeat.m2505o(60245);
    }

    public final void reportInfo(C1627j c1627j) {
        AppMethodBeat.m2504i(60246);
        long j;
        if (c1627j instanceof C6590l) {
            long j2;
            C6590l c6590l = (C6590l) c1627j;
            C4990ab.m7417i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", Boolean.valueOf(c6590l.eEP), Integer.valueOf(c6590l.key), Integer.valueOf(c6590l.value), Boolean.valueOf(c6590l.cNv));
            if (c6590l.eEP) {
                j2 = 678;
            } else {
                j2 = 679;
            }
            long j3 = (long) c6590l.key;
            j = (long) c6590l.value;
            boolean z = c6590l.cNv;
            if (!C4996ah.bqo() || C1720g.m3534RN().eJb) {
                C7060h.pYm.mo8378a(j2, j3, j, z);
                AppMethodBeat.m2505o(60246);
                return;
            }
            C4990ab.m7420w("MicroMsg.HardCoderReporterImpl", "idkeyStat accountNotInitialReady!");
            this.mBC.dnU();
            this.nqh.add(new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j), Boolean.valueOf(z)});
            AppMethodBeat.m2505o(60246);
        } else if (c1627j instanceof C6589k) {
            C6589k c6589k = (C6589k) c1627j;
            if (nqd == null) {
                C1720g.m3537RQ();
                nqd = (Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0));
            }
            if (nqc == null) {
                nqc = C5046bo.m7552gN(C4996ah.getContext());
            }
            String str = nqc;
            int longValue = (int) nqd.longValue();
            int i = WXHardCoderJNI.isHCEnable() ? 1 : 0;
            int isRunning = WXHardCoderJNI.isRunning();
            int i2 = WXHardCoderJNI.getEnable() ? 1 : 0;
            if (c6589k.type == 1) {
                j = (c6589k.eEO * 100) / c6589k.interval;
                m56278e(15187, str, Integer.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(isRunning), Integer.valueOf(c6589k.scene), Long.valueOf(c6589k.eDJ), Integer.valueOf(c6589k.type), Long.valueOf(c6589k.eEO), Long.valueOf(c6589k.interval), Long.valueOf(j), Integer.valueOf(i2));
                C4990ab.m7416i("MicroMsg.HardCoderReporterImpl", String.format("fpsReport imei:%s enable:%s, heavy:%s speedUp:%s, engineStatus:%s, scene:%s, action:%s, type:%s, totalDroppedFrames:%s, interval:%s, average:%s", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(isRunning), Integer.valueOf(c6589k.scene), Long.valueOf(c6589k.eDJ), Integer.valueOf(c6589k.type), Long.valueOf(c6589k.eEO), Long.valueOf(c6589k.interval), Long.valueOf(j)}));
            }
            AppMethodBeat.m2505o(60246);
        } else {
            if (c1627j instanceof C6591m) {
                m56278e(16509, new Object[0]);
            }
            AppMethodBeat.m2505o(60246);
        }
    }

    /* renamed from: e */
    private void m56278e(int i, Object... objArr) {
        AppMethodBeat.m2504i(60247);
        if (!C4996ah.bqo() || C1720g.m3534RN().eJb) {
            C7060h.pYm.mo8381e(i, objArr);
            AppMethodBeat.m2505o(60247);
            return;
        }
        C4990ab.m7420w("MicroMsg.HardCoderReporterImpl", "kvStat accountNotInitialReady!");
        this.mBC.dnU();
        this.nqg.add(new Pair(Integer.valueOf(i), objArr));
        AppMethodBeat.m2505o(60247);
    }
}
