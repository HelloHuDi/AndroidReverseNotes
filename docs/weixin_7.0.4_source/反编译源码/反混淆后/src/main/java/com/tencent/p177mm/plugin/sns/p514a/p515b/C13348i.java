package com.tencent.p177mm.plugin.sns.p514a.p515b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C13477q;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.protocal.protobuf.cbd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.sns.a.b.i */
public final class C13348i implements C1202f {
    public static int qEA = 1800;
    public static int qEB = 43200;
    public static int qEw = 20480;
    public static int qEx = 30720;
    public static int qEy = VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB;
    public static int qEz = 60;
    private long qEC = 0;
    private cbd qED = new cbd();
    private boolean qEE = false;
    private long qEF = 0;
    private int qEG = 0;
    private int qEv = 0;
    private Random random = new Random(System.currentTimeMillis());

    /* renamed from: com.tencent.mm.plugin.sns.a.b.i$5 */
    public class C133495 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(35754);
            C13348i.m21466d(C13348i.this);
            AppMethodBeat.m2505o(35754);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.a.b.i$2 */
    class C133502 implements Runnable {
        C133502() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35751);
            C13348i.this.qEE = false;
            C13348i.this.cmh();
            AppMethodBeat.m2505o(35751);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.a.b.i$3 */
    class C133523 implements Runnable {
        C133523() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35752);
            if (System.currentTimeMillis() - C13348i.this.qEC >= 60000 || C13348i.this.qED.vDW.size() > 1000) {
                if (C13348i.this.qED != null && C13348i.this.qED.vDW.size() > 0) {
                    C13348i.m21466d(C13348i.this);
                }
                C13348i.this.qEC = 0;
            }
            AppMethodBeat.m2505o(35752);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.a.b.i$4 */
    class C133534 implements Runnable {
        C133534() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35753);
            C13348i.m21467e(C13348i.this);
            AppMethodBeat.m2505o(35753);
        }
    }

    public C13348i() {
        AppMethodBeat.m2504i(35755);
        AppMethodBeat.m2505o(35755);
    }

    /* renamed from: e */
    public final void mo25454e(final int i, final Object... objArr) {
        AppMethodBeat.m2504i(35757);
        C13373af.cns().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35750);
                axc axc = new axc();
                axc.wBd = i;
                axc.wBl = (int) (System.currentTimeMillis() / 1000);
                axc.jBv = 1;
                String s = C13348i.m21468s(objArr);
                axc.wBe = new C1332b(s.getBytes());
                C13348i.this.qED.vDW.add(axc);
                C4990ab.m7416i("MicroMsg.SnsLogMgr", "snsadlog " + i + " " + s);
                if (C13348i.this.qEC == 0) {
                    C13348i.this.qEC = System.currentTimeMillis();
                }
                AppMethodBeat.m2505o(35750);
            }
        });
        if (this.qEE) {
            AppMethodBeat.m2505o(35757);
            return;
        }
        this.qEE = true;
        C13373af.cns().mo10173p(new C133502(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(35757);
    }

    public final void cmh() {
        AppMethodBeat.m2504i(35758);
        if (C13373af.qKD) {
            C1720g.m3537RQ();
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf(0))).intValue();
            C1720g.m3537RQ();
            int intValue2 = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, Integer.valueOf(-1))).intValue();
            if (intValue2 > qEB || intValue2 < 0) {
                intValue2 = this.random.nextInt((qEA - qEz) + 1) + qEz;
            }
            if ((System.currentTimeMillis() / 1000) - ((long) intValue) > ((long) intValue2)) {
                intValue2 = 1;
            } else {
                intValue2 = 0;
            }
            if (intValue2 == 0) {
                cmi();
                C4990ab.m7410d("MicroMsg.SnsLogMgr", "pass report ");
                AppMethodBeat.m2505o(35758);
                return;
            }
            C13477q cny = C13373af.cny();
            String str = "select rowid from SnsReportKv order by rowid desc  limit 1";
            C4990ab.m7416i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf(str)));
            Cursor a = cny.fni.mo10104a(str, null, 2);
            if (a.moveToFirst()) {
                intValue2 = a.getInt(0);
            } else {
                intValue2 = 0;
            }
            a.close();
            this.qEv = intValue2;
            cmj();
            cmi();
            AppMethodBeat.m2505o(35758);
            return;
        }
        AppMethodBeat.m2505o(35758);
    }

    private void cmi() {
        AppMethodBeat.m2504i(35759);
        C13373af.cns().execute(new C133523());
        AppMethodBeat.m2505o(35759);
    }

    private void cmj() {
        AppMethodBeat.m2504i(35760);
        C13373af.cns().execute(new C133534());
        AppMethodBeat.m2505o(35760);
    }

    /* renamed from: s */
    public static String m21468s(Object... objArr) {
        String str;
        AppMethodBeat.m2504i(35761);
        if (objArr == null || objArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(String.valueOf(objArr[i])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        AppMethodBeat.m2505o(35761);
        return str;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(35762);
        if (c1207m.getType() == 1802 && (c1207m instanceof C46209e)) {
            C46209e c46209e = (C46209e) c1207m;
            if (i == 0 && i2 == 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                cmj();
                AppMethodBeat.m2505o(35762);
                return;
            }
            List<axc> list = c46209e.iKa;
            C13477q cny = C13373af.cny();
            cbd cbd = new cbd();
            for (axc add : list) {
                cbd.vDW.add(add);
            }
            cny.mo25628a(cbd);
        }
        AppMethodBeat.m2505o(35762);
    }

    public final void start() {
        AppMethodBeat.m2504i(35756);
        qEw = C26373g.m41964Nu().getInt("MMUxAdLog2GSendSize", 20480);
        qEx = C26373g.m41964Nu().getInt("MMUxAdLog3GSendSize", 30720);
        qEy = C26373g.m41964Nu().getInt("MMUxAdLogWifiSendSize", VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
        qEz = C26373g.m41964Nu().getInt("MMUxAdLogMinRandTime", 60);
        qEA = C26373g.m41964Nu().getInt("MMUxAdLogMaxRandTime", 1800);
        qEB = C26373g.m41964Nu().getInt("MMUxAdLogMaxExceptionTime", 43200);
        C4990ab.m7416i("MicroMsg.SnsLogMgr", "init " + qEw + ";" + qEx + ";" + qEy + ";" + qEz + ";" + qEA + ";" + qEB);
        if (qEA - qEz < 0) {
            qEA = qEz;
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1802, (C1202f) this);
        AppMethodBeat.m2505o(35756);
    }

    /* renamed from: d */
    static /* synthetic */ void m21466d(C13348i c13348i) {
        AppMethodBeat.m2504i(35763);
        if (c13348i.qED.vDW.size() > 0) {
            C4990ab.m7416i("MicroMsg.SnsLogMgr", "trigerSave " + c13348i.qED.vDW.size());
            C13373af.cny().mo25628a(c13348i.qED);
            c13348i.qED.vDW.clear();
        }
        AppMethodBeat.m2505o(35763);
    }

    /* renamed from: e */
    static /* synthetic */ void m21467e(C13348i c13348i) {
        int i;
        String str;
        int i2;
        AppMethodBeat.m2504i(35764);
        if (C5046bo.m7525az(c13348i.qEF) >= 100 || c13348i.qEG <= 0) {
            c13348i.qEG = qEw;
            if (C5023at.isWifi(C4996ah.getContext())) {
                c13348i.qEG = qEy;
            }
            if (C5023at.is3G(C4996ah.getContext()) || C5023at.is4G(C4996ah.getContext())) {
                c13348i.qEG = qEx;
            }
            if (C5023at.is2G(C4996ah.getContext())) {
                c13348i.qEG = qEw;
            }
            c13348i.qEF = SystemClock.elapsedRealtime();
            i = c13348i.qEG;
        } else {
            i = c13348i.qEG;
        }
        LinkedList linkedList = new LinkedList();
        cbd fr = C13373af.cny().mo25629fr(i, c13348i.qEv);
        axc axc;
        if (fr.vDW.size() == 0) {
            str = "read from memery";
            i2 = 0;
            while (c13348i.qED.vDW.size() > 0) {
                axc = (axc) c13348i.qED.vDW.remove();
                if (axc.wBe.f1226wR.length + i2 >= i) {
                    break;
                }
                i2 += axc.wBe.f1226wR.length;
                linkedList.add(axc);
            }
        } else {
            str = "read from db";
            i2 = 0;
            while (fr.vDW.size() > 0) {
                axc = (axc) fr.vDW.remove();
                linkedList.add(axc);
                i2 = axc.wBe.f1226wR.length + i2;
            }
        }
        String str2 = str;
        if (linkedList.size() == 0) {
            C4990ab.m7416i("MicroMsg.SnsLogMgr", "nothing for report");
            AppMethodBeat.m2505o(35764);
            return;
        }
        C4990ab.m7416i("MicroMsg.SnsLogMgr", "size " + i2 + " " + linkedList.size() + " " + i + " logItemList.LogList.size  " + c13348i.qED.vDW.size() + " label:  " + str2);
        C1207m c46209e = new C46209e(linkedList);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c46209e, 0);
        AppMethodBeat.m2505o(35764);
    }
}
