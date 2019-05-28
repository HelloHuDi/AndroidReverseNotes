package com.tencent.mm.plugin.appbrand.report;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.cwp;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public final class AppBrandIDKeyBatchReport {
    private static volatile IDKeyBatchReportTask izC;

    static final class a {
        private static final byte[] izD = new byte[0];

        static /* synthetic */ void b(cwt cwt) {
            AppMethodBeat.i(132513);
            synchronized (izD) {
                try {
                    AppBrandIDKeyBatchReport.aKW().izI = cwt;
                    AppBrandIDKeyBatchReport.aKW().izE = 3;
                    AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.aKW());
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(132513);
                }
            }
        }
    }

    public static final class IDKeyBatchReportTask extends MainProcessTask {
        public static final Creator<IDKeyBatchReportTask> CREATOR = new Creator<IDKeyBatchReportTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IDKeyBatchReportTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132514);
                IDKeyBatchReportTask iDKeyBatchReportTask = new IDKeyBatchReportTask(parcel);
                AppMethodBeat.o(132514);
                return iDKeyBatchReportTask;
            }
        };
        public int izE;
        int izF;
        public String izG;
        public int izH;
        cwt izI;

        IDKeyBatchReportTask() {
        }

        IDKeyBatchReportTask(Parcel parcel) {
            AppMethodBeat.i(132515);
            g(parcel);
            AppMethodBeat.o(132515);
        }

        public final void asP() {
            AppMethodBeat.i(132516);
            if (1 == this.izE) {
                if (!bo.isNullOrNil(this.izG) && g.RN().eJb) {
                    Pair y = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b) f.E(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).y(this.izG, 5, this.izH);
                    if (((Boolean) y.first).booleanValue()) {
                        ab.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", this.izG, Integer.valueOf(this.izH));
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) ((Integer) y.second).intValue(), 167);
                        AppMethodBeat.o(132516);
                        return;
                    }
                }
                b.kN(0);
                b.BL();
                AppMethodBeat.o(132516);
            } else if (2 == this.izE) {
                b.BM();
                AppMethodBeat.o(132516);
            } else {
                if (3 == this.izE) {
                    b.c(this.izI);
                }
                AppMethodBeat.o(132516);
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(132517);
            this.izE = parcel.readInt();
            this.izF = parcel.readInt();
            this.izG = parcel.readString();
            this.izH = parcel.readInt();
            if (3 == this.izE) {
                try {
                    this.izI = new cwt();
                    this.izI.parseFrom(parcel.createByteArray());
                    AppMethodBeat.o(132517);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", e);
                    this.izI = null;
                }
            }
            AppMethodBeat.o(132517);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(132518);
            parcel.writeInt(this.izE);
            parcel.writeInt(this.izF);
            parcel.writeString(this.izG);
            parcel.writeInt(this.izH);
            if (3 == this.izE) {
                try {
                    parcel.writeByteArray(this.izI.toByteArray());
                    AppMethodBeat.o(132518);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", e);
                }
            }
            AppMethodBeat.o(132518);
        }

        static {
            AppMethodBeat.i(132519);
            AppMethodBeat.o(132519);
        }
    }

    static final class b {
        private static final ReentrantReadWriteLock izJ = new ReentrantReadWriteLock();
        private static volatile ap izK = null;
        private static volatile ap izL = null;
        private static volatile int izM;

        static /* synthetic */ void BM() {
            AppMethodBeat.i(132530);
            aKY();
            AppMethodBeat.o(132530);
        }

        static {
            AppMethodBeat.i(132532);
            AppMethodBeat.o(132532);
        }

        private static void aKY() {
            AppMethodBeat.i(132524);
            if (izK != null) {
                izK.stopTimer();
                izK = null;
            }
            AppMethodBeat.o(132524);
        }

        private static LinkedList<cwt> aKZ() {
            ReadLock readLock = null;
            int i = 0;
            AppMethodBeat.i(132525);
            izJ.readLock().lock();
            try {
                File file = new File(AppBrandIDKeyBatchReport.access$800());
                if (file.exists()) {
                    LinkedList<cwt> linkedList = new LinkedList();
                    long length = file.length();
                    while (true) {
                        int i2 = i;
                        byte[] e = e.e(AppBrandIDKeyBatchReport.access$800(), i2, 4);
                        if (e != null) {
                            int readInt = new DataInputStream(new ByteArrayInputStream(e)).readInt();
                            e = e.e(AppBrandIDKeyBatchReport.access$800(), i2 + 4, readInt);
                            if (bo.cb(e)) {
                                break;
                            }
                            linkedList.add((cwt) new cwt().parseFrom(e));
                            i = (readInt + 4) + i2;
                            if (((long) i) >= length) {
                                break;
                            }
                        } else {
                            ab.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
                            izJ.readLock().unlock();
                            aLa();
                            AppMethodBeat.o(132525);
                            return null;
                        }
                    }
                    izJ.readLock().unlock();
                    aLa();
                    AppMethodBeat.o(132525);
                    return linkedList;
                }
                ab.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
                return readLock;
            } catch (Exception e2) {
                ab.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", e2.getMessage());
                ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e2, "readReportData()", new Object[0]);
                return readLock;
            } finally {
                readLock = izJ.readLock();
                readLock.unlock();
                aLa();
                AppMethodBeat.o(132525);
            }
        }

        private static void aLa() {
            AppMethodBeat.i(132526);
            izJ.writeLock().lock();
            try {
                e.deleteFile(AppBrandIDKeyBatchReport.access$800());
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "removeFile()", new Object[0]);
            }
            izJ.writeLock().unlock();
            AppMethodBeat.o(132526);
        }

        static /* synthetic */ void c(final cwt cwt) {
            AppMethodBeat.i(132527);
            if (cwt == null) {
                AppMethodBeat.o(132527);
                return;
            }
            com.tencent.mm.plugin.appbrand.s.e.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132523);
                    b.d(cwt);
                    AppMethodBeat.o(132523);
                }
            });
            AppMethodBeat.o(132527);
        }

        static /* synthetic */ void kN(int i) {
            int i2 = 60000;
            AppMethodBeat.i(132528);
            if (i > 0) {
                i2 = 60000 * i;
            }
            aKY();
            ap apVar = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(132521);
                    ab.d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
                    b.BL();
                    AppMethodBeat.o(132521);
                    return true;
                }
            }, true);
            izK = apVar;
            long j = (long) i2;
            apVar.ae(j, j);
            AppMethodBeat.o(132528);
        }

        static /* synthetic */ void BL() {
            boolean z;
            AppMethodBeat.i(132529);
            final LinkedList aKZ = aKZ();
            if (bo.ek(aKZ)) {
                z = false;
            } else {
                com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                aVar.fsJ = new cwo();
                aVar.fsK = new cwp();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
                aVar.fsI = 1009;
                aVar.fsL = 0;
                aVar.fsM = 0;
                com.tencent.mm.ai.b acD = aVar.acD();
                brr brr = new brr();
                brr.jCg = Build.MANUFACTURER;
                brr.wTR = 2;
                brr.vOz = d.vxj;
                brr.vOA = d.vxi;
                brr.qBF = ah.getResources().getDisplayMetrics().widthPixels;
                brr.wTS = ah.getResources().getDisplayMetrics().heightPixels;
                brr.vOB = d.vxl;
                brr.vOC = d.vxm;
                brr.wTT = ah.getResources().getConfiguration().locale.getLanguage();
                ((cwo) acD.fsG.fsP).xsl = brr;
                ((cwo) acD.fsG.fsP).xsk = aKZ;
                w.a(acD, new com.tencent.mm.ai.w.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                        AppMethodBeat.i(132522);
                        if (i == 0 && i2 == 0) {
                            b.izM = ((cwp) bVar.fsH.fsP).xsm;
                            b.kN(b.izM);
                        } else {
                            Iterator it = aKZ.iterator();
                            while (it.hasNext()) {
                                b.d((cwt) it.next());
                            }
                        }
                        AppMethodBeat.o(132522);
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
                ap apVar = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(132520);
                        b.BM();
                        ab.d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
                        AppMethodBeat.o(132520);
                        return true;
                    }
                }, false);
                izL = apVar;
                long j = (long) i;
                apVar.ae(j, j);
            }
            AppMethodBeat.o(132529);
        }

        static /* synthetic */ void d(cwt cwt) {
            AppMethodBeat.i(132531);
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
                e.e(AppBrandIDKeyBatchReport.access$800(), byteArrayOutputStream.toByteArray());
                e.e(AppBrandIDKeyBatchReport.access$800(), toByteArray);
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
            } finally {
                izJ.writeLock().unlock();
                AppMethodBeat.o(132531);
            }
        }
    }

    public static IDKeyBatchReportTask aKW() {
        AppMethodBeat.i(132533);
        if (izC == null) {
            izC = new IDKeyBatchReportTask();
        }
        IDKeyBatchReportTask iDKeyBatchReportTask = izC;
        AppMethodBeat.o(132533);
        return iDKeyBatchReportTask;
    }

    static String aKX() {
        AppMethodBeat.i(132534);
        if (g.RK()) {
            String str = g.RP().cachePath;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            str = str + "appbrand/report/";
            j.aih(str);
            AppMethodBeat.o(132534);
            return str;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(132534);
        throw bVar;
    }

    public static void a(cwt cwt) {
        AppMethodBeat.i(132535);
        if (ah.bqo()) {
            b.c(cwt);
            AppMethodBeat.o(132535);
            return;
        }
        a.b(cwt);
        AppMethodBeat.o(132535);
    }

    static /* synthetic */ String access$800() {
        AppMethodBeat.i(132536);
        String str = aKX() + "WxaAppRecord";
        AppMethodBeat.o(132536);
        return str;
    }
}
