package com.tencent.mm.plugin.sns.a.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bt.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i implements f {
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

    public i() {
        AppMethodBeat.i(35755);
        AppMethodBeat.o(35755);
    }

    public final void e(final int i, final Object... objArr) {
        AppMethodBeat.i(35757);
        af.cns().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35750);
                axc axc = new axc();
                axc.wBd = i;
                axc.wBl = (int) (System.currentTimeMillis() / 1000);
                axc.jBv = 1;
                String s = i.s(objArr);
                axc.wBe = new b(s.getBytes());
                i.this.qED.vDW.add(axc);
                ab.i("MicroMsg.SnsLogMgr", "snsadlog " + i + " " + s);
                if (i.this.qEC == 0) {
                    i.this.qEC = System.currentTimeMillis();
                }
                AppMethodBeat.o(35750);
            }
        });
        if (this.qEE) {
            AppMethodBeat.o(35757);
            return;
        }
        this.qEE = true;
        af.cns().p(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35751);
                i.this.qEE = false;
                i.this.cmh();
                AppMethodBeat.o(35751);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(35757);
    }

    public final void cmh() {
        AppMethodBeat.i(35758);
        if (af.qKD) {
            g.RQ();
            int intValue = ((Integer) g.RP().Ry().get(a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf(0))).intValue();
            g.RQ();
            int intValue2 = ((Integer) g.RP().Ry().get(a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, Integer.valueOf(-1))).intValue();
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
                ab.d("MicroMsg.SnsLogMgr", "pass report ");
                AppMethodBeat.o(35758);
                return;
            }
            q cny = af.cny();
            String str = "select rowid from SnsReportKv order by rowid desc  limit 1";
            ab.i("MicroMsg.SnsKvReportStg", " getLast ".concat(String.valueOf(str)));
            Cursor a = cny.fni.a(str, null, 2);
            if (a.moveToFirst()) {
                intValue2 = a.getInt(0);
            } else {
                intValue2 = 0;
            }
            a.close();
            this.qEv = intValue2;
            cmj();
            cmi();
            AppMethodBeat.o(35758);
            return;
        }
        AppMethodBeat.o(35758);
    }

    private void cmi() {
        AppMethodBeat.i(35759);
        af.cns().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35752);
                if (System.currentTimeMillis() - i.this.qEC >= 60000 || i.this.qED.vDW.size() > 1000) {
                    if (i.this.qED != null && i.this.qED.vDW.size() > 0) {
                        i.d(i.this);
                    }
                    i.this.qEC = 0;
                }
                AppMethodBeat.o(35752);
            }
        });
        AppMethodBeat.o(35759);
    }

    private void cmj() {
        AppMethodBeat.i(35760);
        af.cns().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35753);
                i.e(i.this);
                AppMethodBeat.o(35753);
            }
        });
        AppMethodBeat.o(35760);
    }

    public static String s(Object... objArr) {
        String str;
        AppMethodBeat.i(35761);
        if (objArr == null || objArr.length <= 0) {
            ab.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
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
        AppMethodBeat.o(35761);
        return str;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(35762);
        if (mVar.getType() == 1802 && (mVar instanceof e)) {
            e eVar = (e) mVar;
            if (i == 0 && i2 == 0) {
                g.RQ();
                g.RP().Ry().set(a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                cmj();
                AppMethodBeat.o(35762);
                return;
            }
            List<axc> list = eVar.iKa;
            q cny = af.cny();
            cbd cbd = new cbd();
            for (axc add : list) {
                cbd.vDW.add(add);
            }
            cny.a(cbd);
        }
        AppMethodBeat.o(35762);
    }

    public final void start() {
        AppMethodBeat.i(35756);
        qEw = com.tencent.mm.m.g.Nu().getInt("MMUxAdLog2GSendSize", 20480);
        qEx = com.tencent.mm.m.g.Nu().getInt("MMUxAdLog3GSendSize", 30720);
        qEy = com.tencent.mm.m.g.Nu().getInt("MMUxAdLogWifiSendSize", VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
        qEz = com.tencent.mm.m.g.Nu().getInt("MMUxAdLogMinRandTime", 60);
        qEA = com.tencent.mm.m.g.Nu().getInt("MMUxAdLogMaxRandTime", 1800);
        qEB = com.tencent.mm.m.g.Nu().getInt("MMUxAdLogMaxExceptionTime", 43200);
        ab.i("MicroMsg.SnsLogMgr", "init " + qEw + ";" + qEx + ";" + qEy + ";" + qEz + ";" + qEA + ";" + qEB);
        if (qEA - qEz < 0) {
            qEA = qEz;
        }
        g.RQ();
        g.RO().eJo.a(1802, (f) this);
        AppMethodBeat.o(35756);
    }

    static /* synthetic */ void d(i iVar) {
        AppMethodBeat.i(35763);
        if (iVar.qED.vDW.size() > 0) {
            ab.i("MicroMsg.SnsLogMgr", "trigerSave " + iVar.qED.vDW.size());
            af.cny().a(iVar.qED);
            iVar.qED.vDW.clear();
        }
        AppMethodBeat.o(35763);
    }

    static /* synthetic */ void e(i iVar) {
        int i;
        String str;
        int i2;
        AppMethodBeat.i(35764);
        if (bo.az(iVar.qEF) >= 100 || iVar.qEG <= 0) {
            iVar.qEG = qEw;
            if (at.isWifi(ah.getContext())) {
                iVar.qEG = qEy;
            }
            if (at.is3G(ah.getContext()) || at.is4G(ah.getContext())) {
                iVar.qEG = qEx;
            }
            if (at.is2G(ah.getContext())) {
                iVar.qEG = qEw;
            }
            iVar.qEF = SystemClock.elapsedRealtime();
            i = iVar.qEG;
        } else {
            i = iVar.qEG;
        }
        LinkedList linkedList = new LinkedList();
        cbd fr = af.cny().fr(i, iVar.qEv);
        axc axc;
        if (fr.vDW.size() == 0) {
            str = "read from memery";
            i2 = 0;
            while (iVar.qED.vDW.size() > 0) {
                axc = (axc) iVar.qED.vDW.remove();
                if (axc.wBe.wR.length + i2 >= i) {
                    break;
                }
                i2 += axc.wBe.wR.length;
                linkedList.add(axc);
            }
        } else {
            str = "read from db";
            i2 = 0;
            while (fr.vDW.size() > 0) {
                axc = (axc) fr.vDW.remove();
                linkedList.add(axc);
                i2 = axc.wBe.wR.length + i2;
            }
        }
        String str2 = str;
        if (linkedList.size() == 0) {
            ab.i("MicroMsg.SnsLogMgr", "nothing for report");
            AppMethodBeat.o(35764);
            return;
        }
        ab.i("MicroMsg.SnsLogMgr", "size " + i2 + " " + linkedList.size() + " " + i + " logItemList.LogList.size  " + iVar.qED.vDW.size() + " label:  " + str2);
        m eVar = new e(linkedList);
        g.RQ();
        g.RO().eJo.a(eVar, 0);
        AppMethodBeat.o(35764);
    }
}
