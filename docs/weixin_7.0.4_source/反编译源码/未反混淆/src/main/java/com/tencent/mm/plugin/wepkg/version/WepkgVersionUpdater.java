package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h.AnonymousClass6;
import com.tencent.mm.plugin.wepkg.model.h.AnonymousClass7;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class WepkgVersionUpdater {

    static final class WepkgNetSceneProcessTask extends BaseWepkgProcessTask {
        public static final Creator<WepkgNetSceneProcessTask> CREATOR = new Creator<WepkgNetSceneProcessTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WepkgNetSceneProcessTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(63669);
                WepkgNetSceneProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask(parcel, (byte) 0);
                AppMethodBeat.o(63669);
                return wepkgNetSceneProcessTask;
            }
        };
        private int cTb;
        private List<WepkgCheckReq> uYi;
        private boolean uYj;

        static class WepkgCheckReq implements Parcelable {
            public static final Creator<WepkgCheckReq> CREATOR = new Creator<WepkgCheckReq>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new WepkgCheckReq[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(63670);
                    WepkgCheckReq wepkgCheckReq = new WepkgCheckReq(parcel, (byte) 0);
                    AppMethodBeat.o(63670);
                    return wepkgCheckReq;
                }
            };
            private String eBS;
            private int scene;
            private String version;

            /* synthetic */ WepkgCheckReq(Parcel parcel, byte b) {
                this(parcel);
            }

            private WepkgCheckReq() {
            }

            private WepkgCheckReq(Parcel parcel) {
                AppMethodBeat.i(63671);
                this.eBS = parcel.readString();
                this.version = parcel.readString();
                this.scene = parcel.readInt();
                AppMethodBeat.o(63671);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.i(63672);
                parcel.writeString(this.eBS);
                parcel.writeString(this.version);
                parcel.writeInt(this.scene);
                AppMethodBeat.o(63672);
            }

            static {
                AppMethodBeat.i(63673);
                AppMethodBeat.o(63673);
            }
        }

        /* synthetic */ WepkgNetSceneProcessTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public WepkgNetSceneProcessTask() {
            AppMethodBeat.i(63674);
            this.uYi = new ArrayList();
            AppMethodBeat.o(63674);
        }

        private WepkgNetSceneProcessTask(Parcel parcel) {
            AppMethodBeat.i(63675);
            g(parcel);
            AppMethodBeat.o(63675);
        }

        public final void asP() {
            AppMethodBeat.i(63676);
            if (bo.ek(this.uYi)) {
                AppMethodBeat.o(63676);
                return;
            }
            a aVar = new a();
            aVar.fsI = 1313;
            aVar.fsL = 0;
            aVar.fsM = 0;
            aVar.uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
            sh shVar = new sh();
            for (WepkgCheckReq wepkgCheckReq : this.uYi) {
                ss ssVar = new ss();
                ssVar.mZV = wepkgCheckReq.eBS;
                ssVar.jCh = wepkgCheckReq.version;
                ssVar.Scene = wepkgCheckReq.scene;
                shVar.vZD.add(ssVar);
            }
            aVar.fsJ = shVar;
            aVar.fsK = new si();
            h.pYm.a(859, 15, 1, false);
            b acD = aVar.acD();
            AnonymousClass1 anonymousClass1 = new WepkgRunCgi.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    AppMethodBeat.i(63668);
                    if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                        try {
                            final si siVar = (si) bVar.fsH.fsP;
                            d.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(63667);
                                    si siVar = siVar;
                                    int b = WepkgNetSceneProcessTask.this.cTb;
                                    boolean c = WepkgNetSceneProcessTask.this.uYj;
                                    if (siVar != null) {
                                        if (bo.ek(siVar.vZE)) {
                                            ab.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                                            AppMethodBeat.o(63667);
                                            return;
                                        }
                                        bkj bkj;
                                        HashSet hashSet = new HashSet();
                                        ArrayList<bkj> arrayList = new ArrayList();
                                        Iterator it = siVar.vZE.iterator();
                                        while (it.hasNext()) {
                                            bkj = (bkj) it.next();
                                            if (bkj != null) {
                                                String str = bkj.mZV;
                                                cvr cvr = bkj.wNv;
                                                cvn cvn = bkj.wNx;
                                                if (!bo.isNullOrNil(str)) {
                                                    if (cvn != null) {
                                                        if (cvn.xrz) {
                                                            ab.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                                                            h.pYm.a(859, 17, 1, false);
                                                            if (bkj.wNw != null) {
                                                                ForceUpdateNotify.wy(bkj.mZV);
                                                            }
                                                        }
                                                        if (cvn.xry) {
                                                            com.tencent.mm.plugin.wepkg.model.b.dgz().dP(str, 2);
                                                        }
                                                    }
                                                    if (!(cvr == null || cvr.xrH == null)) {
                                                        if (bo.isNullOrNil(cvr.xrH.xrA)) {
                                                            WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                                            wepkgCrossProcessTask.Cn = 2004;
                                                            wepkgCrossProcessTask.uWY.eBS = str;
                                                            if (ah.bqo()) {
                                                                d.aNS().aa(new AnonymousClass6(wepkgCrossProcessTask));
                                                            } else {
                                                                wepkgCrossProcessTask.hww = new AnonymousClass7(wepkgCrossProcessTask);
                                                                wepkgCrossProcessTask.aBV();
                                                                WepkgMainProcessService.a(wepkgCrossProcessTask);
                                                            }
                                                            h.pYm.a(859, 18, 1, false);
                                                        } else {
                                                            boolean z = cvr.xrH.xrB;
                                                            long j = (long) cvr.xrH.xrC;
                                                            long j2 = (long) cvr.xrH.xrD;
                                                            WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                                                            wepkgCrossProcessTask2.Cn = 3004;
                                                            wepkgCrossProcessTask2.uWY.eBS = str;
                                                            wepkgCrossProcessTask2.uWY.uXG = z;
                                                            wepkgCrossProcessTask2.uWY.uXH = j;
                                                            wepkgCrossProcessTask2.uWY.uXI = j2;
                                                            if (ah.bqo()) {
                                                                wepkgCrossProcessTask2.asP();
                                                            } else {
                                                                WepkgMainProcessService.b(wepkgCrossProcessTask2);
                                                            }
                                                            WepkgCrossProcessTask wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                                                            wepkgCrossProcessTask3.Cn = 3009;
                                                            wepkgCrossProcessTask3.uWY.eBS = str;
                                                            if (ah.bqo()) {
                                                                wepkgCrossProcessTask3.asP();
                                                            } else {
                                                                WepkgMainProcessService.b(wepkgCrossProcessTask3);
                                                            }
                                                            wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                                                            wepkgCrossProcessTask3.Cn = WearableStatusCodes.DUPLICATE_CAPABILITY;
                                                            wepkgCrossProcessTask3.uXb.eBS = str;
                                                            if (ah.bqo()) {
                                                                wepkgCrossProcessTask3.asP();
                                                            } else {
                                                                WepkgMainProcessService.b(wepkgCrossProcessTask3);
                                                            }
                                                            if (c) {
                                                                List a = g.a(bkj);
                                                                if (!bo.ek(a)) {
                                                                    hashSet.addAll(a);
                                                                }
                                                            }
                                                            arrayList.add(bkj);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        ForceUpdateNotify.bny();
                                        com.tencent.mm.plugin.wepkg.c.a.a.uXR.l(hashSet);
                                        if (!bo.ek(arrayList)) {
                                            for (bkj bkj2 : arrayList) {
                                                i dgD = i.dgD();
                                                if (bkj2 == null || bkj2.wNw == null) {
                                                    ab.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                                                    if (bkj2 != null) {
                                                        dgD.bQ(bkj2.mZV, false);
                                                    }
                                                } else {
                                                    cvm cvm = bkj2.wNw.xrL;
                                                    cvt cvt = bkj2.wNw.xrM;
                                                    if (cvm != null || cvt != null) {
                                                        com.tencent.mm.plugin.wepkg.model.h.a(bkj2, b);
                                                        ab.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", Integer.valueOf(b));
                                                        switch (b) {
                                                            case -1:
                                                            case 0:
                                                                dgD.bQ(bkj2.mZV, false);
                                                                break;
                                                            case 1:
                                                                if (!d.eA(ah.getContext())) {
                                                                    break;
                                                                }
                                                                dgD.bQ(bkj2.mZV, false);
                                                                break;
                                                            case 2:
                                                                ho hoVar = new ho();
                                                                com.tencent.mm.sdk.b.a.xxA.m(hoVar);
                                                                if (!hoVar.cCs.cCt) {
                                                                    break;
                                                                }
                                                                dgD.bQ(bkj2.mZV, false);
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                    }
                                                    ab.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                                                    com.tencent.mm.plugin.wepkg.model.b.dgz().dP(bkj2.mZV, 2);
                                                }
                                            }
                                        }
                                    }
                                    AppMethodBeat.o(63667);
                                }
                            });
                            AppMethodBeat.o(63668);
                            return;
                        } catch (Exception e) {
                            ab.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
                            AppMethodBeat.o(63668);
                            return;
                        }
                    }
                    ab.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.fsH.fsP);
                    h.pYm.a(859, 16, 1, false);
                    AppMethodBeat.o(63668);
                }
            };
            if (ah.bqo()) {
                w.a(acD, new com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.AnonymousClass1(anonymousClass1));
                AppMethodBeat.o(63676);
                return;
            }
            WepkgMainProcessTask remoteCgiTask = new RemoteCgiTask();
            d.bB(remoteCgiTask);
            remoteCgiTask.uYe = acD;
            remoteCgiTask.uYf = anonymousClass1;
            remoteCgiTask.uYc = 1;
            WepkgMainProcessService.a(remoteCgiTask);
            AppMethodBeat.o(63676);
        }

        public final void asQ() {
        }

        public final void m(Parcel parcel) {
            AppMethodBeat.i(63677);
            if (this.uYi == null) {
                this.uYi = new ArrayList();
            }
            parcel.readList(this.uYi, WepkgCheckReq.class.getClassLoader());
            this.cTb = parcel.readInt();
            this.uYj = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(63677);
        }

        public final void a(Parcel parcel, int i) {
            AppMethodBeat.i(63678);
            parcel.writeList(this.uYi);
            parcel.writeInt(this.cTb);
            parcel.writeByte((byte) (this.uYj ? 1 : 0));
            AppMethodBeat.o(63678);
        }

        static {
            AppMethodBeat.i(63679);
            AppMethodBeat.o(63679);
        }
    }

    public static void r(List<String> list, int i) {
        AppMethodBeat.i(63680);
        if (bo.ek(list)) {
            AppMethodBeat.o(63680);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(list);
        a(hashSet, i, false);
        AppMethodBeat.o(63680);
    }

    public static void a(Set<String> set, int i, boolean z) {
        AppMethodBeat.i(63681);
        a(set, i, -1, z);
        AppMethodBeat.o(63681);
    }

    public static void a(Set<String> set, int i, int i2, boolean z) {
        AppMethodBeat.i(63682);
        if (set == null) {
            AppMethodBeat.o(63682);
            return;
        }
        LinkedList linkedList = new LinkedList();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (String str : set) {
            if (!bo.isNullOrNil(str)) {
                stringBuffer.append(str);
                stringBuffer.append(";");
                ss ssVar = new ss();
                ssVar.mZV = str;
                ssVar.Scene = i;
                WepkgVersion ahW = com.tencent.mm.plugin.wepkg.model.h.ahW(str);
                if (ahW == null) {
                    ssVar.jCh = "";
                    linkedList.add(ssVar);
                } else {
                    ssVar.jCh = ahW.version;
                    if (d.aNY() >= ahW.uXL) {
                        linkedList.add(ssVar);
                        com.tencent.mm.plugin.wepkg.model.h.ahZ(str);
                    } else {
                        stringBuffer2.append(str);
                        stringBuffer2.append(";");
                    }
                }
            }
        }
        ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", stringBuffer.toString(), stringBuffer2.toString(), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        if (!bo.ek(linkedList)) {
            b(linkedList, i2, z);
        }
        AppMethodBeat.o(63682);
    }

    private static void b(LinkedList<ss> linkedList, int i, boolean z) {
        AppMethodBeat.i(63683);
        if (linkedList.size() == 0) {
            AppMethodBeat.o(63683);
            return;
        }
        final WepkgMainProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
        wepkgNetSceneProcessTask.cTb = i;
        wepkgNetSceneProcessTask.uYj = z;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ss ssVar = (ss) it.next();
            WepkgCheckReq wepkgCheckReq = new WepkgCheckReq();
            wepkgCheckReq.eBS = ssVar.mZV;
            wepkgCheckReq.version = ssVar.jCh;
            wepkgCheckReq.scene = ssVar.Scene;
            wepkgNetSceneProcessTask.uYi.add(wepkgCheckReq);
        }
        if (ah.bqo()) {
            d.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(63666);
                    wepkgNetSceneProcessTask.asP();
                    AppMethodBeat.o(63666);
                }
            });
            AppMethodBeat.o(63683);
            return;
        }
        WepkgMainProcessService.a(wepkgNetSceneProcessTask);
        AppMethodBeat.o(63683);
    }
}
