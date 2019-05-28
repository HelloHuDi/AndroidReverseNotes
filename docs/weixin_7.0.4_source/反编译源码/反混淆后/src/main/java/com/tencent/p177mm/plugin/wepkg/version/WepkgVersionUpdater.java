package com.tencent.p177mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C26156ho;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.C30011b;
import com.tencent.p177mm.plugin.wepkg.model.C30020i;
import com.tencent.p177mm.plugin.wepkg.model.C40404h;
import com.tencent.p177mm.plugin.wepkg.model.C40404h.C404026;
import com.tencent.p177mm.plugin.wepkg.model.C40404h.C404067;
import com.tencent.p177mm.plugin.wepkg.model.C46476g;
import com.tencent.p177mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.p177mm.plugin.wepkg.p589c.C4693a.C4695a;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.WepkgRunCgi.C23208a;
import com.tencent.p177mm.plugin.wepkg.utils.WepkgRunCgi.C357641;
import com.tencent.p177mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.p177mm.protocal.protobuf.C15384sh;
import com.tencent.p177mm.protocal.protobuf.C23441ss;
import com.tencent.p177mm.protocal.protobuf.C30223si;
import com.tencent.p177mm.protocal.protobuf.bkj;
import com.tencent.p177mm.protocal.protobuf.cvm;
import com.tencent.p177mm.protocal.protobuf.cvn;
import com.tencent.p177mm.protocal.protobuf.cvr;
import com.tencent.p177mm.protocal.protobuf.cvt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater */
public final class WepkgVersionUpdater {

    /* renamed from: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater$WepkgNetSceneProcessTask */
    static final class WepkgNetSceneProcessTask extends BaseWepkgProcessTask {
        public static final Creator<WepkgNetSceneProcessTask> CREATOR = new C148142();
        private int cTb;
        private List<WepkgCheckReq> uYi;
        private boolean uYj;

        /* renamed from: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater$WepkgNetSceneProcessTask$1 */
        class C148121 implements C23208a {
            C148121() {
            }

            /* renamed from: a */
            public final void mo27119a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(63668);
                if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                    try {
                        final C30223si c30223si = (C30223si) c7472b.fsH.fsP;
                        C30022d.aNS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(63667);
                                C30223si c30223si = c30223si;
                                int b = WepkgNetSceneProcessTask.this.cTb;
                                boolean c = WepkgNetSceneProcessTask.this.uYj;
                                if (c30223si != null) {
                                    if (C5046bo.m7548ek(c30223si.vZE)) {
                                        C4990ab.m7412e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                                        AppMethodBeat.m2505o(63667);
                                        return;
                                    }
                                    bkj bkj;
                                    HashSet hashSet = new HashSet();
                                    ArrayList<bkj> arrayList = new ArrayList();
                                    Iterator it = c30223si.vZE.iterator();
                                    while (it.hasNext()) {
                                        bkj = (bkj) it.next();
                                        if (bkj != null) {
                                            String str = bkj.mZV;
                                            cvr cvr = bkj.wNv;
                                            cvn cvn = bkj.wNx;
                                            if (!C5046bo.isNullOrNil(str)) {
                                                if (cvn != null) {
                                                    if (cvn.xrz) {
                                                        C4990ab.m7416i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                                                        C7060h.pYm.mo8378a(859, 17, 1, false);
                                                        if (bkj.wNw != null) {
                                                            ForceUpdateNotify.m79020wy(bkj.mZV);
                                                        }
                                                    }
                                                    if (cvn.xry) {
                                                        C30011b.dgz().mo48248dP(str, 2);
                                                    }
                                                }
                                                if (!(cvr == null || cvr.xrH == null)) {
                                                    if (C5046bo.isNullOrNil(cvr.xrH.xrA)) {
                                                        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                                        wepkgCrossProcessTask.f2968Cn = 2004;
                                                        wepkgCrossProcessTask.uWY.eBS = str;
                                                        if (C4996ah.bqo()) {
                                                            C30022d.aNS().mo10302aa(new C404026(wepkgCrossProcessTask));
                                                        } else {
                                                            wepkgCrossProcessTask.hww = new C404067(wepkgCrossProcessTask);
                                                            wepkgCrossProcessTask.aBV();
                                                            WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
                                                        }
                                                        C7060h.pYm.mo8378a(859, 18, 1, false);
                                                    } else {
                                                        boolean z = cvr.xrH.xrB;
                                                        long j = (long) cvr.xrH.xrC;
                                                        long j2 = (long) cvr.xrH.xrD;
                                                        WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                                                        wepkgCrossProcessTask2.f2968Cn = 3004;
                                                        wepkgCrossProcessTask2.uWY.eBS = str;
                                                        wepkgCrossProcessTask2.uWY.uXG = z;
                                                        wepkgCrossProcessTask2.uWY.uXH = j;
                                                        wepkgCrossProcessTask2.uWY.uXI = j2;
                                                        if (C4996ah.bqo()) {
                                                            wepkgCrossProcessTask2.asP();
                                                        } else {
                                                            WepkgMainProcessService.m87660b(wepkgCrossProcessTask2);
                                                        }
                                                        WepkgCrossProcessTask wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                                                        wepkgCrossProcessTask3.f2968Cn = 3009;
                                                        wepkgCrossProcessTask3.uWY.eBS = str;
                                                        if (C4996ah.bqo()) {
                                                            wepkgCrossProcessTask3.asP();
                                                        } else {
                                                            WepkgMainProcessService.m87660b(wepkgCrossProcessTask3);
                                                        }
                                                        wepkgCrossProcessTask3 = new WepkgCrossProcessTask();
                                                        wepkgCrossProcessTask3.f2968Cn = WearableStatusCodes.DUPLICATE_CAPABILITY;
                                                        wepkgCrossProcessTask3.uXb.eBS = str;
                                                        if (C4996ah.bqo()) {
                                                            wepkgCrossProcessTask3.asP();
                                                        } else {
                                                            WepkgMainProcessService.m87660b(wepkgCrossProcessTask3);
                                                        }
                                                        if (c) {
                                                            List a = C46476g.m87671a(bkj);
                                                            if (!C5046bo.m7548ek(a)) {
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
                                    C4695a.uXR.mo9814l(hashSet);
                                    if (!C5046bo.m7548ek(arrayList)) {
                                        for (bkj bkj2 : arrayList) {
                                            C30020i dgD = C30020i.dgD();
                                            if (bkj2 == null || bkj2.wNw == null) {
                                                C4990ab.m7416i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
                                                if (bkj2 != null) {
                                                    dgD.mo48257bQ(bkj2.mZV, false);
                                                }
                                            } else {
                                                cvm cvm = bkj2.wNw.xrL;
                                                cvt cvt = bkj2.wNw.xrM;
                                                if (cvm != null || cvt != null) {
                                                    C40404h.m69307a(bkj2, b);
                                                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", Integer.valueOf(b));
                                                    switch (b) {
                                                        case -1:
                                                        case 0:
                                                            dgD.mo48257bQ(bkj2.mZV, false);
                                                            break;
                                                        case 1:
                                                            if (!C30022d.m47518eA(C4996ah.getContext())) {
                                                                break;
                                                            }
                                                            dgD.mo48257bQ(bkj2.mZV, false);
                                                            break;
                                                        case 2:
                                                            C26156ho c26156ho = new C26156ho();
                                                            C4879a.xxA.mo10055m(c26156ho);
                                                            if (!c26156ho.cCs.cCt) {
                                                                break;
                                                            }
                                                            dgD.mo48257bQ(bkj2.mZV, false);
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                }
                                                C4990ab.m7416i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
                                                C30011b.dgz().mo48248dP(bkj2.mZV, 2);
                                            }
                                        }
                                    }
                                }
                                AppMethodBeat.m2505o(63667);
                            }
                        });
                        AppMethodBeat.m2505o(63668);
                        return;
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
                        AppMethodBeat.m2505o(63668);
                        return;
                    }
                }
                C4990ab.m7413e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, c7472b.fsH.fsP);
                C7060h.pYm.mo8378a(859, 16, 1, false);
                AppMethodBeat.m2505o(63668);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater$WepkgNetSceneProcessTask$2 */
        static class C148142 implements Creator<WepkgNetSceneProcessTask> {
            C148142() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WepkgNetSceneProcessTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(63669);
                WepkgNetSceneProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask(parcel, (byte) 0);
                AppMethodBeat.m2505o(63669);
                return wepkgNetSceneProcessTask;
            }
        }

        /* renamed from: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater$WepkgNetSceneProcessTask$WepkgCheckReq */
        static class WepkgCheckReq implements Parcelable {
            public static final Creator<WepkgCheckReq> CREATOR = new C148151();
            private String eBS;
            private int scene;
            private String version;

            /* renamed from: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater$WepkgNetSceneProcessTask$WepkgCheckReq$1 */
            static class C148151 implements Creator<WepkgCheckReq> {
                C148151() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new WepkgCheckReq[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.m2504i(63670);
                    WepkgCheckReq wepkgCheckReq = new WepkgCheckReq(parcel, (byte) 0);
                    AppMethodBeat.m2505o(63670);
                    return wepkgCheckReq;
                }
            }

            /* synthetic */ WepkgCheckReq(Parcel parcel, byte b) {
                this(parcel);
            }

            private WepkgCheckReq() {
            }

            private WepkgCheckReq(Parcel parcel) {
                AppMethodBeat.m2504i(63671);
                this.eBS = parcel.readString();
                this.version = parcel.readString();
                this.scene = parcel.readInt();
                AppMethodBeat.m2505o(63671);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.m2504i(63672);
                parcel.writeString(this.eBS);
                parcel.writeString(this.version);
                parcel.writeInt(this.scene);
                AppMethodBeat.m2505o(63672);
            }

            static {
                AppMethodBeat.m2504i(63673);
                AppMethodBeat.m2505o(63673);
            }
        }

        /* synthetic */ WepkgNetSceneProcessTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public WepkgNetSceneProcessTask() {
            AppMethodBeat.m2504i(63674);
            this.uYi = new ArrayList();
            AppMethodBeat.m2505o(63674);
        }

        private WepkgNetSceneProcessTask(Parcel parcel) {
            AppMethodBeat.m2504i(63675);
            mo48259g(parcel);
            AppMethodBeat.m2505o(63675);
        }

        public final void asP() {
            AppMethodBeat.m2504i(63676);
            if (C5046bo.m7548ek(this.uYi)) {
                AppMethodBeat.m2505o(63676);
                return;
            }
            C1196a c1196a = new C1196a();
            c1196a.fsI = 1313;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            c1196a.uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
            C15384sh c15384sh = new C15384sh();
            for (WepkgCheckReq wepkgCheckReq : this.uYi) {
                C23441ss c23441ss = new C23441ss();
                c23441ss.mZV = wepkgCheckReq.eBS;
                c23441ss.jCh = wepkgCheckReq.version;
                c23441ss.Scene = wepkgCheckReq.scene;
                c15384sh.vZD.add(c23441ss);
            }
            c1196a.fsJ = c15384sh;
            c1196a.fsK = new C30223si();
            C7060h.pYm.mo8378a(859, 15, 1, false);
            C7472b acD = c1196a.acD();
            C148121 c148121 = new C148121();
            if (C4996ah.bqo()) {
                C1226w.m2654a(acD, new C357641(c148121));
                AppMethodBeat.m2505o(63676);
                return;
            }
            WepkgMainProcessTask remoteCgiTask = new RemoteCgiTask();
            C30022d.m47517bB(remoteCgiTask);
            remoteCgiTask.uYe = acD;
            remoteCgiTask.uYf = c148121;
            remoteCgiTask.uYc = 1;
            WepkgMainProcessService.m87655a(remoteCgiTask);
            AppMethodBeat.m2505o(63676);
        }

        public final void asQ() {
        }

        /* renamed from: m */
        public final void mo27112m(Parcel parcel) {
            AppMethodBeat.m2504i(63677);
            if (this.uYi == null) {
                this.uYi = new ArrayList();
            }
            parcel.readList(this.uYi, WepkgCheckReq.class.getClassLoader());
            this.cTb = parcel.readInt();
            this.uYj = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(63677);
        }

        /* renamed from: a */
        public final void mo27109a(Parcel parcel, int i) {
            AppMethodBeat.m2504i(63678);
            parcel.writeList(this.uYi);
            parcel.writeInt(this.cTb);
            parcel.writeByte((byte) (this.uYj ? 1 : 0));
            AppMethodBeat.m2505o(63678);
        }

        static {
            AppMethodBeat.m2504i(63679);
            AppMethodBeat.m2505o(63679);
        }
    }

    /* renamed from: r */
    public static void m23054r(List<String> list, int i) {
        AppMethodBeat.m2504i(63680);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(63680);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(list);
        WepkgVersionUpdater.m23052a(hashSet, i, false);
        AppMethodBeat.m2505o(63680);
    }

    /* renamed from: a */
    public static void m23052a(Set<String> set, int i, boolean z) {
        AppMethodBeat.m2504i(63681);
        WepkgVersionUpdater.m23051a(set, i, -1, z);
        AppMethodBeat.m2505o(63681);
    }

    /* renamed from: a */
    public static void m23051a(Set<String> set, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(63682);
        if (set == null) {
            AppMethodBeat.m2505o(63682);
            return;
        }
        LinkedList linkedList = new LinkedList();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (String str : set) {
            if (!C5046bo.isNullOrNil(str)) {
                stringBuffer.append(str);
                stringBuffer.append(";");
                C23441ss c23441ss = new C23441ss();
                c23441ss.mZV = str;
                c23441ss.Scene = i;
                WepkgVersion ahW = C40404h.ahW(str);
                if (ahW == null) {
                    c23441ss.jCh = "";
                    linkedList.add(c23441ss);
                } else {
                    c23441ss.jCh = ahW.version;
                    if (C30022d.aNY() >= ahW.uXL) {
                        linkedList.add(c23441ss);
                        C40404h.ahZ(str);
                    } else {
                        stringBuffer2.append(str);
                        stringBuffer2.append(";");
                    }
                }
            }
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", stringBuffer.toString(), stringBuffer2.toString(), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        if (!C5046bo.m7548ek(linkedList)) {
            WepkgVersionUpdater.m23053b(linkedList, i2, z);
        }
        AppMethodBeat.m2505o(63682);
    }

    /* renamed from: b */
    private static void m23053b(LinkedList<C23441ss> linkedList, int i, boolean z) {
        AppMethodBeat.m2504i(63683);
        if (linkedList.size() == 0) {
            AppMethodBeat.m2505o(63683);
            return;
        }
        final WepkgMainProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
        wepkgNetSceneProcessTask.cTb = i;
        wepkgNetSceneProcessTask.uYj = z;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C23441ss c23441ss = (C23441ss) it.next();
            WepkgCheckReq wepkgCheckReq = new WepkgCheckReq();
            wepkgCheckReq.eBS = c23441ss.mZV;
            wepkgCheckReq.version = c23441ss.jCh;
            wepkgCheckReq.scene = c23441ss.Scene;
            wepkgNetSceneProcessTask.uYi.add(wepkgCheckReq);
        }
        if (C4996ah.bqo()) {
            C30022d.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(63666);
                    wepkgNetSceneProcessTask.asP();
                    AppMethodBeat.m2505o(63666);
                }
            });
            AppMethodBeat.m2505o(63683);
            return;
        }
        WepkgMainProcessService.m87655a(wepkgNetSceneProcessTask);
        AppMethodBeat.m2505o(63683);
    }
}
