package com.tencent.p177mm.plugin.appbrand.report;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45513b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.brr;
import com.tencent.p177mm.protocal.protobuf.cwo;
import com.tencent.p177mm.protocal.protobuf.cwp;
import com.tencent.p177mm.protocal.protobuf.cwt;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport */
public final class AppBrandIDKeyBatchReport {
    private static volatile IDKeyBatchReportTask izC;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport$a */
    static final class C19684a {
        private static final byte[] izD = new byte[0];

        /* renamed from: b */
        static /* synthetic */ void m30481b(cwt cwt) {
            AppMethodBeat.m2504i(132513);
            synchronized (izD) {
                try {
                    AppBrandIDKeyBatchReport.aKW().izI = cwt;
                    AppBrandIDKeyBatchReport.aKW().izE = 3;
                    AppBrandMainProcessService.m54349a(AppBrandIDKeyBatchReport.aKW());
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(132513);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport$IDKeyBatchReportTask */
    public static final class IDKeyBatchReportTask extends MainProcessTask {
        public static final Creator<IDKeyBatchReportTask> CREATOR = new C196831();
        public int izE;
        int izF;
        public String izG;
        public int izH;
        cwt izI;

        /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport$IDKeyBatchReportTask$1 */
        static class C196831 implements Creator<IDKeyBatchReportTask> {
            C196831() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IDKeyBatchReportTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132514);
                IDKeyBatchReportTask iDKeyBatchReportTask = new IDKeyBatchReportTask(parcel);
                AppMethodBeat.m2505o(132514);
                return iDKeyBatchReportTask;
            }
        }

        IDKeyBatchReportTask() {
        }

        IDKeyBatchReportTask(Parcel parcel) {
            AppMethodBeat.m2504i(132515);
            mo6032g(parcel);
            AppMethodBeat.m2505o(132515);
        }

        public final void asP() {
            AppMethodBeat.m2504i(132516);
            if (1 == this.izE) {
                if (!C5046bo.isNullOrNil(this.izG) && C1720g.m3534RN().eJb) {
                    Pair y = ((C45513b) C42340f.m74878E(C45513b.class)).mo73326y(this.izG, 5, this.izH);
                    if (((Boolean) y.first).booleanValue()) {
                        C4990ab.m7417i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", this.izG, Integer.valueOf(this.izH));
                        C19050a c19050a = C19050a.gWl;
                        C19050a.m29623z((long) ((Integer) y.second).intValue(), 167);
                        AppMethodBeat.m2505o(132516);
                        return;
                    }
                }
                C19685b.m30490kN(0);
                C19685b.m30485BL();
                AppMethodBeat.m2505o(132516);
            } else if (2 == this.izE) {
                C19685b.m30486BM();
                AppMethodBeat.m2505o(132516);
            } else {
                if (3 == this.izE) {
                    C19685b.m30487c(this.izI);
                }
                AppMethodBeat.m2505o(132516);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(132517);
            this.izE = parcel.readInt();
            this.izF = parcel.readInt();
            this.izG = parcel.readString();
            this.izH = parcel.readInt();
            if (3 == this.izE) {
                try {
                    this.izI = new cwt();
                    this.izI.parseFrom(parcel.createByteArray());
                    AppMethodBeat.m2505o(132517);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", e);
                    this.izI = null;
                }
            }
            AppMethodBeat.m2505o(132517);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(132518);
            parcel.writeInt(this.izE);
            parcel.writeInt(this.izF);
            parcel.writeString(this.izG);
            parcel.writeInt(this.izH);
            if (3 == this.izE) {
                try {
                    parcel.writeByteArray(this.izI.toByteArray());
                    AppMethodBeat.m2505o(132518);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", e);
                }
            }
            AppMethodBeat.m2505o(132518);
        }

        static {
            AppMethodBeat.m2504i(132519);
            AppMethodBeat.m2505o(132519);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport$b */
    static final class C19685b {
        private static final ReentrantReadWriteLock izJ = new ReentrantReadWriteLock();
        private static volatile C7564ap izK = null;
        private static volatile C7564ap izL = null;
        private static volatile int izM;

        /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport$b$2 */
        static class C107092 implements C5015a {
            C107092() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(132521);
                C4990ab.m7410d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
                C19685b.m30485BL();
                AppMethodBeat.m2505o(132521);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport$b$1 */
        static class C196871 implements C5015a {
            C196871() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(132520);
                C19685b.m30486BM();
                C4990ab.m7410d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
                AppMethodBeat.m2505o(132520);
                return true;
            }
        }

        /* renamed from: BM */
        static /* synthetic */ void m30486BM() {
            AppMethodBeat.m2504i(132530);
            C19685b.aKY();
            AppMethodBeat.m2505o(132530);
        }

        static {
            AppMethodBeat.m2504i(132532);
            AppMethodBeat.m2505o(132532);
        }

        private static void aKY() {
            AppMethodBeat.m2504i(132524);
            if (izK != null) {
                izK.stopTimer();
                izK = null;
            }
            AppMethodBeat.m2505o(132524);
        }

        private static LinkedList<cwt> aKZ() {
            ReadLock readLock = null;
            int i = 0;
            AppMethodBeat.m2504i(132525);
            izJ.readLock().lock();
            try {
                File file = new File(AppBrandIDKeyBatchReport.access$800());
                if (file.exists()) {
                    LinkedList<cwt> linkedList = new LinkedList();
                    long length = file.length();
                    while (true) {
                        int i2 = i;
                        byte[] e = C1173e.m2569e(AppBrandIDKeyBatchReport.access$800(), i2, 4);
                        if (e != null) {
                            int readInt = new DataInputStream(new ByteArrayInputStream(e)).readInt();
                            e = C1173e.m2569e(AppBrandIDKeyBatchReport.access$800(), i2 + 4, readInt);
                            if (C5046bo.m7540cb(e)) {
                                break;
                            }
                            linkedList.add((cwt) new cwt().parseFrom(e));
                            i = (readInt + 4) + i2;
                            if (((long) i) >= length) {
                                break;
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
                            izJ.readLock().unlock();
                            C19685b.aLa();
                            AppMethodBeat.m2505o(132525);
                            return null;
                        }
                    }
                    izJ.readLock().unlock();
                    C19685b.aLa();
                    AppMethodBeat.m2505o(132525);
                    return linkedList;
                }
                C4990ab.m7410d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
                return readLock;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", e2.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e2, "readReportData()", new Object[0]);
                return readLock;
            } finally {
                readLock = izJ.readLock();
                readLock.unlock();
                C19685b.aLa();
                AppMethodBeat.m2505o(132525);
            }
        }

        private static void aLa() {
            AppMethodBeat.m2504i(132526);
            izJ.writeLock().lock();
            try {
                C1173e.deleteFile(AppBrandIDKeyBatchReport.access$800());
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "removeFile()", new Object[0]);
            }
            izJ.writeLock().unlock();
            AppMethodBeat.m2505o(132526);
        }

        /* renamed from: c */
        static /* synthetic */ void m30487c(final cwt cwt) {
            AppMethodBeat.m2504i(132527);
            if (cwt == null) {
                AppMethodBeat.m2505o(132527);
                return;
            }
            C42677e.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(132523);
                    C19685b.m30488d(cwt);
                    AppMethodBeat.m2505o(132523);
                }
            });
            AppMethodBeat.m2505o(132527);
        }

        /* renamed from: kN */
        static /* synthetic */ void m30490kN(int i) {
            int i2 = 60000;
            AppMethodBeat.m2504i(132528);
            if (i > 0) {
                i2 = 60000 * i;
            }
            C19685b.aKY();
            C7564ap c7564ap = new C7564ap(new C107092(), true);
            izK = c7564ap;
            long j = (long) i2;
            c7564ap.mo16770ae(j, j);
            AppMethodBeat.m2505o(132528);
        }

        /* renamed from: BL */
        static /* synthetic */ void m30485BL() {
            boolean z;
            AppMethodBeat.m2504i(132529);
            final LinkedList aKZ = C19685b.aKZ();
            if (C5046bo.m7548ek(aKZ)) {
                z = false;
            } else {
                C1196a c1196a = new C1196a();
                c1196a.fsJ = new cwo();
                c1196a.fsK = new cwp();
                c1196a.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
                c1196a.fsI = 1009;
                c1196a.fsL = 0;
                c1196a.fsM = 0;
                C7472b acD = c1196a.acD();
                brr brr = new brr();
                brr.jCg = Build.MANUFACTURER;
                brr.wTR = 2;
                brr.vOz = C7243d.vxj;
                brr.vOA = C7243d.vxi;
                brr.qBF = C4996ah.getResources().getDisplayMetrics().widthPixels;
                brr.wTS = C4996ah.getResources().getDisplayMetrics().heightPixels;
                brr.vOB = C7243d.vxl;
                brr.vOC = C7243d.vxm;
                brr.wTT = C4996ah.getResources().getConfiguration().locale.getLanguage();
                ((cwo) acD.fsG.fsP).xsl = brr;
                ((cwo) acD.fsG.fsP).xsk = aKZ;
                C1226w.m2655a(acD, new C1224a() {
                    /* renamed from: a */
                    public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                        AppMethodBeat.m2504i(132522);
                        if (i == 0 && i2 == 0) {
                            C19685b.izM = ((cwp) c7472b.fsH.fsP).xsm;
                            C19685b.m30490kN(C19685b.izM);
                        } else {
                            Iterator it = aKZ.iterator();
                            while (it.hasNext()) {
                                C19685b.m30488d((cwt) it.next());
                            }
                        }
                        AppMethodBeat.m2505o(132522);
                        return 0;
                    }
                }, true);
                z = true;
            }
            if (z) {
                int i = izM;
                if (i <= 0) {
                    i = 300000;
                } else {
                    i = (i + 5) * 60000;
                }
                if (izL != null) {
                    izL.stopTimer();
                    izL = null;
                }
                C7564ap c7564ap = new C7564ap(new C196871(), false);
                izL = c7564ap;
                long j = (long) i;
                c7564ap.mo16770ae(j, j);
            }
            AppMethodBeat.m2505o(132529);
        }

        /* renamed from: d */
        static /* synthetic */ void m30488d(cwt cwt) {
            AppMethodBeat.m2504i(132531);
            izJ.writeLock().lock();
            try {
                byte[] toByteArray = cwt.toByteArray();
                File file = new File(AppBrandIDKeyBatchReport.aKX());
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(AppBrandIDKeyBatchReport.access$800());
                if (!file.exists()) {
                    file.createNewFile();
                }
                int length = toByteArray.length;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new DataOutputStream(byteArrayOutputStream).writeInt(length);
                C1173e.m2568e(AppBrandIDKeyBatchReport.access$800(), byteArrayOutputStream.toByteArray());
                C1173e.m2568e(AppBrandIDKeyBatchReport.access$800(), toByteArray);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
            } finally {
                izJ.writeLock().unlock();
                AppMethodBeat.m2505o(132531);
            }
        }
    }

    public static IDKeyBatchReportTask aKW() {
        AppMethodBeat.m2504i(132533);
        if (izC == null) {
            izC = new IDKeyBatchReportTask();
        }
        IDKeyBatchReportTask iDKeyBatchReportTask = izC;
        AppMethodBeat.m2505o(132533);
        return iDKeyBatchReportTask;
    }

    static String aKX() {
        AppMethodBeat.m2504i(132534);
        if (C1720g.m3531RK()) {
            String str = C1720g.m3536RP().cachePath;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            str = str + "appbrand/report/";
            C15428j.aih(str);
            AppMethodBeat.m2505o(132534);
            return str;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(132534);
        throw c1819b;
    }

    /* renamed from: a */
    public static void m30482a(cwt cwt) {
        AppMethodBeat.m2504i(132535);
        if (C4996ah.bqo()) {
            C19685b.m30487c(cwt);
            AppMethodBeat.m2505o(132535);
            return;
        }
        C19684a.m30481b(cwt);
        AppMethodBeat.m2505o(132535);
    }

    static /* synthetic */ String access$800() {
        AppMethodBeat.m2504i(132536);
        String str = AppBrandIDKeyBatchReport.aKX() + "WxaAppRecord";
        AppMethodBeat.m2505o(132536);
        return str;
    }
}
