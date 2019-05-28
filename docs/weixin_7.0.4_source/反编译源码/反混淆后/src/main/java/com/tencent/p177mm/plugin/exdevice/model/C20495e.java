package com.tencent.p177mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16536b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18235dh;
import com.tencent.p177mm.p230g.p231a.C18238di;
import com.tencent.p177mm.p230g.p231a.C18241dj;
import com.tencent.p177mm.p230g.p231a.C18245ds;
import com.tencent.p177mm.p230g.p231a.C18247ed;
import com.tencent.p177mm.p230g.p231a.C18251em;
import com.tencent.p177mm.p230g.p231a.C18253en;
import com.tencent.p177mm.p230g.p231a.C18256eo;
import com.tencent.p177mm.p230g.p231a.C18259et;
import com.tencent.p177mm.p230g.p231a.C18261ev;
import com.tencent.p177mm.p230g.p231a.C18394st;
import com.tencent.p177mm.p230g.p231a.C26114dk;
import com.tencent.p177mm.p230g.p231a.C26119ec;
import com.tencent.p177mm.p230g.p231a.C26124el;
import com.tencent.p177mm.p230g.p231a.C26129ew;
import com.tencent.p177mm.p230g.p231a.C26131ex;
import com.tencent.p177mm.p230g.p231a.C26172jn;
import com.tencent.p177mm.p230g.p231a.C26174jo;
import com.tencent.p177mm.p230g.p231a.C32540ea;
import com.tencent.p177mm.p230g.p231a.C32541eb;
import com.tencent.p177mm.p230g.p231a.C32542ee;
import com.tencent.p177mm.p230g.p231a.C32547eu;
import com.tencent.p177mm.p230g.p231a.C32593ln;
import com.tencent.p177mm.p230g.p231a.C32596lq;
import com.tencent.p177mm.p230g.p231a.C37702dl;
import com.tencent.p177mm.p230g.p231a.C37704dn;
import com.tencent.p177mm.p230g.p231a.C37708eh;
import com.tencent.p177mm.p230g.p231a.C41976df;
import com.tencent.p177mm.p230g.p231a.C41976df.C41977b;
import com.tencent.p177mm.p230g.p231a.C41980dg;
import com.tencent.p177mm.p230g.p231a.C41980dg.C41979b;
import com.tencent.p177mm.p230g.p231a.C41981do;
import com.tencent.p177mm.p230g.p231a.C41983dp;
import com.tencent.p177mm.p230g.p231a.C41985ei;
import com.tencent.p177mm.p230g.p231a.C41987ej;
import com.tencent.p177mm.p230g.p231a.C41987ej.C18249b;
import com.tencent.p177mm.p230g.p231a.C41988ep;
import com.tencent.p177mm.p230g.p231a.C41991er;
import com.tencent.p177mm.p230g.p231a.C41993es;
import com.tencent.p177mm.p230g.p231a.C45318dd;
import com.tencent.p177mm.p230g.p231a.C45319dm;
import com.tencent.p177mm.p230g.p231a.C45333id;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p230g.p231a.C6473dy;
import com.tencent.p177mm.p230g.p231a.C9315dc;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p230g.p231a.C9329ef;
import com.tencent.p177mm.p230g.p231a.C9411lk;
import com.tencent.p177mm.p230g.p231a.C9472sl;
import com.tencent.p177mm.p230g.p231a.C9473sm;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.exdevice.model.C20528g.C205298;
import com.tencent.p177mm.plugin.exdevice.model.C20528g.C205317;
import com.tencent.p177mm.plugin.exdevice.model.C27842aa.C27843a;
import com.tencent.p177mm.plugin.exdevice.model.C2971d.C29725;
import com.tencent.p177mm.plugin.exdevice.model.C2971d.C298311;
import com.tencent.p177mm.plugin.exdevice.model.C38954i.C34037a;
import com.tencent.p177mm.plugin.exdevice.model.C46907h.C2986a;
import com.tencent.p177mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.C204775;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p952b.C11635k;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.p956h.C27837c;
import com.tencent.p177mm.plugin.exdevice.p957i.C11651i;
import com.tencent.p177mm.plugin.exdevice.p957i.C27839g;
import com.tencent.p177mm.plugin.exdevice.p957i.C27840j;
import com.tencent.p177mm.plugin.exdevice.p957i.C41266k;
import com.tencent.p177mm.plugin.exdevice.service.C11656d;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27859f.C27860a;
import com.tencent.p177mm.plugin.exdevice.service.C34050c;
import com.tencent.p177mm.plugin.exdevice.service.C43000j;
import com.tencent.p177mm.plugin.exdevice.service.C43005t.C43006a;
import com.tencent.p177mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.p177mm.plugin.p369d.p370a.p1606e.C42904a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C20287a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C24737f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.pluginsdk.C44068p.C30089e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.ajn;
import com.tencent.p177mm.protocal.protobuf.ajp;
import com.tencent.p177mm.protocal.protobuf.ajq;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.atr;
import com.tencent.p177mm.protocal.protobuf.ats;
import com.tencent.p177mm.protocal.protobuf.atu;
import com.tencent.p177mm.protocal.protobuf.atv;
import com.tencent.p177mm.protocal.protobuf.atw;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.exdevice.model.e */
public final class C20495e {
    private final long bYn = 300000;
    public C4884c jDf = new C2048421();
    public C4884c lrA = new C2049823();
    public C4884c lrB = new C2048734();
    public C4884c lrC = new C2049242();
    public C4884c lrD = new C2052643();
    public C4884c lrE = new C2050344();
    public C4884c lrF = new C2050445();
    public C4884c lrG = new C2050546();
    public C4884c lrH = new C205102();
    public C4884c lrI = new C204993();
    public C4884c lrJ = new C205014();
    public C4884c lrK = new C204935();
    public C4884c lrL = new C205026();
    public C4884c lrM = new C116557();
    public C4884c lrN = new C205278();
    public C4884c lrO = new C205139();
    public C4884c lrP = new C2049610();
    public C4884c lrQ = new C2050711();
    public C4884c lrR = new C2051913();
    public C4884c lrS = new C2050914();
    public C4884c lrT = new C2052015();
    public C4884c lrU = new C1165316();
    public C4884c lrV = new C2049717();
    public C4884c lrW = new C685118();
    public C4884c lrX = new C685219();
    public C4884c lrY = new C2051420();
    public C4884c lrZ = new C2048522();
    List<C20494b> lrw = new LinkedList();
    Map<String, C20494b> lrx = new HashMap();
    public C4884c lry = new C205211();
    public C4884c lrz = new C2050812();
    public C4884c lsa = new C2048624();
    public C4884c lsb = new C2051525();
    public C4884c lsc = new C2052226();
    public C4884c lsd = new C2051627();
    public C4884c lse = new C2052328();
    public C4884c lsg = new C1165429();
    public C4884c lsh = new C2052430();
    public C4884c lsi = new C2051131();
    public C4884c lsj = new C2052532();
    public C4884c lsk = new C2051233();
    public C4884c lsl = new C2048835();
    ExdeviceWCLanSDKUtil lsm;
    C20528g lsn;
    private boolean lso = false;
    private C20518c lsp;
    C7306ak mHandler;

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$18 */
    class C685118 extends C4884c<C41976df> {
        C685118() {
            AppMethodBeat.m2504i(19159);
            this.xxI = C41976df.class.getName().hashCode();
            AppMethodBeat.m2505o(19159);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19160);
            C41976df c41976df = (C41976df) c4883b;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", c41976df.cwq.cws, c41976df.cwq.ceI);
            if (c41976df.cwq.cws == null || c41976df.cwq.ceI == null) {
                c41976df.cwr.cwt = false;
            } else {
                C11648b dT = C45891ad.boW().mo45707dT(c41976df.cwq.cws, c41976df.cwq.ceI);
                if (dT != null) {
                    String str = dT.dFr;
                    C41977b c41977b = c41976df.cwr;
                    C45891ad.boW();
                    c41977b.cwt = C27837c.m44247Kw(str);
                } else {
                    c41976df.cwr.cwt = false;
                }
            }
            AppMethodBeat.m2505o(19160);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$19 */
    class C685219 extends C4884c<C37702dl> {
        C685219() {
            AppMethodBeat.m2504i(19161);
            this.xxI = C37702dl.class.getName().hashCode();
            AppMethodBeat.m2505o(19161);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19162);
            C37702dl c37702dl = (C37702dl) c4883b;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", Boolean.valueOf(c37702dl.cwJ.cwA));
            if (c37702dl.cwJ.cwA) {
                String gE = C5023at.m7474gE(C4996ah.getContext());
                if (!C5046bo.isNullOrNil(gE)) {
                    c37702dl.cwK.cwB = true;
                    c37702dl.cwK.cwL = gE.replaceAll("\"", "");
                    AppMethodBeat.m2505o(19162);
                    return true;
                }
            }
            c37702dl.cwK.cwB = false;
            c37702dl.cwK.cwL = null;
            AppMethodBeat.m2505o(19162);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$40 */
    class C685340 implements C2986a {
        C685340() {
        }

        /* renamed from: a */
        public final void mo7190a(long j, int i, int i2, int i3, long j2) {
            LinkedList<C20494b> linkedList;
            AppMethodBeat.m2504i(19199);
            C4990ab.m7411d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
            C20495e c20495e = C20495e.this;
            String ie = C42992b.m76358ie(j);
            synchronized (c20495e.lrw) {
                try {
                    linkedList = new LinkedList(c20495e.lrw);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(19199);
                }
            }
            for (C20494b c : linkedList) {
                c.mo23422c(ie, i2, j2);
            }
            linkedList.clear();
            for (C20494b c2 : c20495e.lrx.values()) {
                c2.mo23422c(ie, i2, j2);
            }
            C4883b c41988ep = new C41988ep();
            c41988ep.cyg.mac = ie;
            c41988ep.cyg.cxs = i2;
            c41988ep.cyg.cyd = j2;
            C4879a.xxA.mo10048a(c41988ep, Looper.getMainLooper());
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$16 */
    class C1165316 extends C4884c<C32547eu> {
        C1165316() {
            AppMethodBeat.m2504i(19155);
            this.xxI = C32547eu.class.getName().hashCode();
            AppMethodBeat.m2505o(19155);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19156);
            C32547eu c32547eu = (C32547eu) c4883b;
            if (c32547eu == null || !(c32547eu instanceof C32547eu)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                AppMethodBeat.m2505o(19156);
                return false;
            }
            c32547eu = c32547eu;
            if (C20495e.m31664c(c32547eu.cyn.mac, c32547eu.cyn.cwz, c32547eu.cyn.data)) {
                c32547eu.cyo.cwB = true;
            } else {
                c32547eu.cyo.cwB = false;
            }
            AppMethodBeat.m2505o(19156);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$29 */
    class C1165429 extends C4884c<C45318dd> {
        C1165429() {
            AppMethodBeat.m2504i(19181);
            this.xxI = C45318dd.class.getName().hashCode();
            AppMethodBeat.m2505o(19181);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19182);
            C45318dd c45318dd = (C45318dd) c4883b;
            C20495e c20495e = C20495e.this;
            String str = c45318dd.cwo.ceI;
            C20528g c20528g = c20495e.lsn;
            c20528g.lsG.remove(str);
            if (c20528g.lsM.get(str) != null) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + c20528g.lsM.get(str));
                Java2CExDevice.cancelWCLanDeviceTask(((Integer) c20528g.lsM.get(str)).intValue());
            }
            AppMethodBeat.m2505o(19182);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$7 */
    class C116557 extends C4884c<C37708eh> {
        C116557() {
            AppMethodBeat.m2504i(19137);
            this.xxI = C37708eh.class.getName().hashCode();
            AppMethodBeat.m2505o(19137);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19138);
            boolean e = C20495e.m31668e((C37708eh) c4883b);
            AppMethodBeat.m2505o(19138);
            return e;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$21 */
    class C2048421 extends C4884c<C45382z> {
        C2048421() {
            AppMethodBeat.m2504i(19165);
            this.xxI = C45382z.class.getName().hashCode();
            AppMethodBeat.m2505o(19165);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19166);
            boolean boK = C20495e.boK();
            AppMethodBeat.m2505o(19166);
            return boK;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$22 */
    class C2048522 extends C4884c<C32593ln> {
        C2048522() {
            AppMethodBeat.m2504i(19167);
            this.xxI = C32593ln.class.getName().hashCode();
            AppMethodBeat.m2505o(19167);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19168);
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", C4996ah.getProcessName());
            if (C4996ah.doH()) {
                AppMethodBeat.m2505o(19168);
                return false;
            }
            AppMethodBeat.m2505o(19168);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$24 */
    class C2048624 extends C4884c<C9321dq> {
        C2048624() {
            AppMethodBeat.m2504i(19171);
            this.xxI = C9321dq.class.getName().hashCode();
            AppMethodBeat.m2505o(19171);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19172);
            C9321dq c9321dq = (C9321dq) c4883b;
            long j = c9321dq.cxc.cvx;
            String str = c9321dq.cxc.cwT;
            List<C11648b> bpA = C45891ad.boW().bpA();
            if (bpA.size() > 0) {
                boolean z;
                if (j == -1 || j == Long.MIN_VALUE) {
                    z = false;
                } else {
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf(j);
                    if (jf.field_msgId == 0) {
                        z = false;
                    } else {
                        int type = jf.getType();
                        String str2 = jf.field_content;
                        String str3;
                        if (jf.bAA()) {
                            C8910b me = C8910b.m16064me(str2);
                            if (me == null) {
                                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                                z = false;
                            } else if (me.type == 3) {
                                for (C11648b c11648b : bpA) {
                                    str3 = c11648b.dFr;
                                    if (str3 != null && str3.contains("wxmsg_music")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (me.type == 4) {
                                z = false;
                            } else if (me.type == 6) {
                                for (C11648b c11648b2 : bpA) {
                                    str3 = c11648b2.dFr;
                                    if (str3 != null && str3.contains("wxmsg_file")) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            } else if (me.type == 5) {
                                z = C20495e.m31669i(me.url, bpA);
                            } else {
                                if (me.type == 2) {
                                    for (C11648b c11648b22 : bpA) {
                                        str3 = c11648b22.dFr;
                                        if (str3 != null && str3.contains("wxmsg_image")) {
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                }
                                z = false;
                            }
                        } else if (type == 3) {
                            for (C11648b c11648b222 : bpA) {
                                str3 = c11648b222.dFr;
                                if (str3 != null && str3.contains("wxmsg_image")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else if (type == 48) {
                            for (C11648b c11648b2222 : bpA) {
                                str3 = c11648b2222.dFr;
                                if (str3 != null && str3.contains("wxmsg_poi")) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else {
                            if (type == 62) {
                                for (C11648b c11648b22222 : bpA) {
                                    str3 = c11648b22222.dFr;
                                    if (str3 != null && str3.contains("wxmsg_video")) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                        }
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + type);
                    }
                }
                if (z || C20495e.m31670j(str, bpA)) {
                    c9321dq.cxd.cwB = true;
                    AppMethodBeat.m2505o(19172);
                    return true;
                }
            }
            c9321dq.cxd.cwB = false;
            AppMethodBeat.m2505o(19172);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$34 */
    class C2048734 extends C4884c<C9315dc> {
        C2048734() {
            AppMethodBeat.m2504i(19191);
            this.xxI = C9315dc.class.getName().hashCode();
            AppMethodBeat.m2505o(19191);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19192);
            C9315dc c9315dc = (C9315dc) c4883b;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
            c9315dc = c9315dc;
            int i = c9315dc.cwj.opType;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", Integer.valueOf(i), Integer.valueOf(c9315dc.cwj.cwm));
            if (i == 1) {
                C1207m c38957l = new C38957l(c9315dc.cwj.cwl, r1);
                C9638aw.m17182Rg().mo14541a(c38957l, 0);
                c9315dc.cwk.cwn = c38957l;
            } else if (i == 2 && c9315dc.cwj.cwn != null) {
                C9638aw.m17182Rg().mo14547c((C38957l) c9315dc.cwj.cwn);
            }
            AppMethodBeat.m2505o(19192);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$35 */
    class C2048835 extends C4884c<C37704dn> {
        C2048835() {
            AppMethodBeat.m2504i(19193);
            this.xxI = C37704dn.class.getName().hashCode();
            AppMethodBeat.m2505o(19193);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19194);
            boolean c = C20495e.this.mo35804c((C37704dn) c4883b);
            AppMethodBeat.m2505o(19194);
            return c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$37 */
    class C2049037 implements C27843a {
        C2049037() {
        }

        /* renamed from: a */
        public final void mo35798a(String str, byte[] bArr, boolean z) {
            AppMethodBeat.m2504i(19196);
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", str);
            if (bArr == null) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", str, Boolean.valueOf(z));
            } else {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z));
            }
            C4883b c26119ec = new C26119ec();
            c26119ec.cxD.cxv = bArr;
            c26119ec.cxD.ceI = str;
            c26119ec.cxD.bcU = z;
            C4879a.xxA.mo10048a(c26119ec, Looper.getMainLooper());
            AppMethodBeat.m2505o(19196);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$38 */
    class C2049138 implements C34037a {
        C2049138() {
        }

        /* renamed from: gM */
        public final void mo35799gM(boolean z) {
            AppMethodBeat.m2504i(19197);
            C20495e.boG();
            AppMethodBeat.m2505o(19197);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$42 */
    class C2049242 extends C4884c<C26131ex> {
        C2049242() {
            AppMethodBeat.m2504i(19201);
            this.xxI = C26131ex.class.getName().hashCode();
            AppMethodBeat.m2505o(19201);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19202);
            C26131ex c26131ex = (C26131ex) c4883b;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
            C45891ad.bpd().mo7182uI(0);
            c26131ex = c26131ex;
            if (C5046bo.isNullOrNil(c26131ex.cyr.cwz)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
                AppMethodBeat.m2505o(19202);
                return false;
            }
            asq asq = new asq();
            asq.jBE = "";
            asq.vIk = c26131ex.cyr.cwz;
            C9638aw.m17182Rg().mo14541a(new C20540x(asq, 1), 0);
            AppMethodBeat.m2505o(19202);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$5 */
    class C204935 extends C4884c<C18235dh> {
        C204935() {
            AppMethodBeat.m2504i(19133);
            this.xxI = C18235dh.class.getName().hashCode();
            AppMethodBeat.m2505o(19133);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = false;
            AppMethodBeat.m2504i(19134);
            C18235dh c18235dh = (C18235dh) c4883b;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", c18235dh.cwx.cwz, c18235dh.cwx.ceI, Boolean.valueOf(c18235dh.cwx.cwA));
            String str = c18235dh.cwx.cwz;
            String str2 = c18235dh.cwx.ceI;
            boolean z2 = c18235dh.cwx.cwA;
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", str, str2, Boolean.valueOf(z2));
            } else {
                C11648b Kv = C45891ad.boW().mo45701Kv(str2);
                if (Kv == null) {
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", str2);
                } else if (!Kv.field_brandName.equals(str)) {
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", Kv.field_brandName, str);
                } else if (C5046bo.nullAsNil(Kv.field_connProto).contains("4")) {
                    C20495e.m31663b(str, Kv.field_url, -1, Kv.field_deviceType);
                    C20495e.m31665cc(str, -1);
                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
                } else if (C42904a.aVH()) {
                    C20495e.m31665cc(str, -1);
                    int a = C20495e.m31659a(Kv);
                    if (a == 1) {
                        if (!C42904a.aVF()) {
                            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                        }
                    } else if (a == 0 && !C42904a.m76178dv(C4996ah.getContext())) {
                        C20495e.m31665cc(str, 1);
                        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                    }
                    if (z2) {
                        if (C27842aa.boT().lsZ) {
                            C27842aa.boT().mo45714uK(a);
                        }
                        C2971d bpd = C45891ad.bpd();
                        if (!(bpd.lrg == null || bpd.lrg.size() == 0)) {
                            bpd.lrg.clear();
                        }
                        C45891ad.bpd().mo7179b(Kv.field_brandName, Kv.field_mac, a);
                    } else {
                        C45891ad.bpd();
                        C2971d.m5266hH(Kv.field_mac);
                    }
                    z = true;
                } else {
                    C4990ab.m7420w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                    C20495e.m31665cc(str, 0);
                }
            }
            c18235dh.cwy.cwB = z;
            AppMethodBeat.m2505o(19134);
            return z;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$b */
    public interface C20494b {
        /* renamed from: b */
        void mo23421b(String str, byte[] bArr, boolean z);

        /* renamed from: c */
        void mo23422c(String str, int i, long j);

        /* renamed from: p */
        void mo23423p(String str, String str2, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$10 */
    class C2049610 extends C4884c<C26124el> {
        C2049610() {
            AppMethodBeat.m2504i(19143);
            this.xxI = C26124el.class.getName().hashCode();
            AppMethodBeat.m2505o(19143);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19144);
            C26124el c26124el = (C26124el) c4883b;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", c26124el.cxX.ceI, Integer.valueOf(c26124el.cxX.direction), Boolean.valueOf(c26124el.cxX.clear));
            if (c26124el.cxX.clear) {
                C11635k.bow().lqJ.clear();
                c26124el.cxY.cwB = true;
            } else if (C5046bo.isNullOrNil(c26124el.cxX.ceI)) {
                c26124el.cxY.cwB = false;
            } else {
                C11635k bow = C11635k.bow();
                String str = c26124el.cxX.ceI;
                int i = c26124el.cxX.direction;
                if (!C5046bo.isNullOrNil(str)) {
                    bow.lqJ.put(str, Integer.valueOf(i));
                }
                c26124el.cxY.cwB = true;
            }
            AppMethodBeat.m2505o(19144);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$17 */
    class C2049717 extends C4884c<C41980dg> {
        C2049717() {
            AppMethodBeat.m2504i(19157);
            this.xxI = C41980dg.class.getName().hashCode();
            AppMethodBeat.m2505o(19157);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C41979b c41979b;
            boolean z = false;
            AppMethodBeat.m2504i(19158);
            C41980dg c41980dg = (C41980dg) c4883b;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", c41980dg.cwu.cws, c41980dg.cwu.ceI);
            if (c41980dg.cwu.cws == null || c41980dg.cwu.ceI == null) {
                c41979b = c41980dg.cwv;
            } else {
                C11648b dS = C45891ad.boW().mo45706dS(c41980dg.cwu.ceI, c41980dg.cwu.cws);
                c41979b = c41980dg.cwv;
                if (dS != null) {
                    z = true;
                }
            }
            c41979b.cww = z;
            AppMethodBeat.m2505o(19158);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$23 */
    class C2049823 extends C4884c<C18247ed> {
        C2049823() {
            AppMethodBeat.m2504i(19169);
            this.xxI = C18247ed.class.getName().hashCode();
            AppMethodBeat.m2505o(19169);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19170);
            C18247ed c18247ed = (C18247ed) c4883b;
            C20495e c20495e = C20495e.this;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
            c18247ed = c18247ed;
            if (C5046bo.isNullOrNil(c18247ed.cxE.userName)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
                AppMethodBeat.m2505o(19170);
                return false;
            }
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
            C20495e.m31665cc(c18247ed.cxE.userName, -1);
            if ((c18247ed.cxE.f4320op == 0 || c18247ed.cxE.f4320op == 3) && C38954i.lto.mo61834gN(false)) {
                C38954i.lto.mo61833a(c18247ed.cxE.context, new C2051739(c18247ed));
                AppMethodBeat.m2505o(19170);
                return true;
            }
            boolean at = c20495e.mo35802at(c18247ed.cxE.f4320op, c18247ed.cxE.userName);
            AppMethodBeat.m2505o(19170);
            return at;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$3 */
    class C204993 extends C4884c<C9329ef> {
        C204993() {
            AppMethodBeat.m2504i(19129);
            this.xxI = C9329ef.class.getName().hashCode();
            AppMethodBeat.m2505o(19129);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19130);
            boolean g = C20495e.this.mo35806g((C9329ef) c4883b);
            AppMethodBeat.m2505o(19130);
            return g;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$41 */
    class C2050041 extends C43006a {
        C2050041() {
        }

        /* renamed from: b */
        public final void mo35810b(long j, int i, int i2, String str) {
            boolean z;
            AppMethodBeat.m2504i(19200);
            String str2 = "MicroMsg.exdevice.ExdeviceEventManager";
            String str3 = "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s";
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(j);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            if (str == null) {
                str = BuildConfig.COMMAND;
            }
            objArr[3] = str;
            C4990ab.m7411d(str2, str3, objArr);
            C20495e c20495e = C20495e.this;
            String ie = C42992b.m76358ie(j);
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7411d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", ie, Boolean.valueOf(z));
            if (!z) {
                LinkedList<C20494b> linkedList;
                synchronized (c20495e.lrw) {
                    try {
                        linkedList = new LinkedList(c20495e.lrw);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(19200);
                        }
                    }
                }
                for (C20494b b : linkedList) {
                    b.mo23421b(ie, null, false);
                }
                linkedList.clear();
                for (C20494b b2 : c20495e.lrx.values()) {
                    b2.mo23421b(ie, null, false);
                }
            }
            AppMethodBeat.m2505o(19200);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$4 */
    class C205014 extends C4884c<C41983dp> {
        C205014() {
            AppMethodBeat.m2504i(19131);
            this.xxI = C41983dp.class.getName().hashCode();
            AppMethodBeat.m2505o(19131);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19132);
            boolean f = C20495e.this.mo35805f((C41983dp) c4883b);
            AppMethodBeat.m2505o(19132);
            return f;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$6 */
    class C205026 extends C4884c<C18241dj> {
        C205026() {
            AppMethodBeat.m2504i(19135);
            this.xxI = C18241dj.class.getName().hashCode();
            AppMethodBeat.m2505o(19135);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19136);
            C18241dj c18241dj = (C18241dj) c4883b;
            C11648b dT = C45891ad.boW().mo45707dT(c18241dj.cwE.cwG, c18241dj.cwE.ceI);
            if (dT == null || (dT.field_connStrategy & 16) != 0) {
                c18241dj.cwF.cwB = false;
            } else {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", c18241dj.cwE.cwG, c18241dj.cwE.ceI);
                c18241dj.cwF.cwB = true;
            }
            AppMethodBeat.m2505o(19136);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$44 */
    class C2050344 extends C4884c<C9473sm> {
        C2050344() {
            AppMethodBeat.m2504i(19205);
            this.xxI = C9473sm.class.getName().hashCode();
            AppMethodBeat.m2505o(19205);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19206);
            C9473sm c9473sm = (C9473sm) c4883b;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
            c9473sm = c9473sm;
            C45891ad.bpd();
            C2971d.m5265gL(c9473sm.cOL.cOM);
            AppMethodBeat.m2505o(19206);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$45 */
    class C2050445 extends C4884c<C18394st> {
        C2050445() {
            AppMethodBeat.m2504i(19207);
            this.xxI = C18394st.class.getName().hashCode();
            AppMethodBeat.m2505o(19207);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19208);
            C20495e c20495e = C20495e.this;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
            int acS = C9638aw.m17182Rg().acS();
            if (acS == 4 || acS == 6) {
                boolean z;
                String value = C26373g.m41964Nu().getValue("DeviceAutoSyncClose");
                C4990ab.m7417i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", value);
                if (C5046bo.isNullOrNil(value) || !value.equalsIgnoreCase("1")) {
                    z = true;
                } else {
                    C4990ab.m7416i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                    z = false;
                }
                if (!z) {
                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                    AppMethodBeat.m2505o(19208);
                    return false;
                } else if (!C42904a.m76178dv(C4996ah.getContext())) {
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
                    AppMethodBeat.m2505o(19208);
                    return false;
                } else if (C42904a.aVH()) {
                    C45891ad.bpd();
                    if (C2971d.boE() == 1) {
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                        AppMethodBeat.m2505o(19208);
                        return false;
                    } else if (C38954i.lto.mo61834gN(false)) {
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                        C38954i.lto.mo61833a(null, new C2049138());
                        AppMethodBeat.m2505o(19208);
                        return true;
                    } else {
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                        boolean boG = C20495e.boG();
                        AppMethodBeat.m2505o(19208);
                        return boG;
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                    AppMethodBeat.m2505o(19208);
                    return false;
                }
            }
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", Integer.valueOf(acS));
            AppMethodBeat.m2505o(19208);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$46 */
    class C2050546 extends C4884c<C26114dk> {
        C2050546() {
            AppMethodBeat.m2504i(19209);
            this.xxI = C26114dk.class.getName().hashCode();
            AppMethodBeat.m2505o(19209);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19210);
            boolean z = ((C26114dk) c4883b).cwH.cwI;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
            if (C38954i.lto.mo61834gN(z)) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
                C38954i.lto.mo61833a(null, null);
            }
            AppMethodBeat.m2505o(19210);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$a */
    public class C20506a implements C20494b {
        private String cbq;
        private String lst;
        private String lsu;
        private String mURL;

        public C20506a(String str, String str2, String str3, String str4) {
            AppMethodBeat.m2504i(19211);
            this.lst = str;
            this.cbq = str2;
            this.mURL = str3;
            this.lsu = str4;
            C4990ab.m7411d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", str, str2);
            AppMethodBeat.m2505o(19211);
        }

        /* renamed from: p */
        public final void mo23423p(String str, String str2, boolean z) {
            AppMethodBeat.m2504i(19212);
            if (this.cbq == null || !this.cbq.equals(str2)) {
                C4990ab.m7411d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", this.cbq, str2, Boolean.valueOf(z));
                AppMethodBeat.m2505o(19212);
                return;
            }
            AppMethodBeat.m2505o(19212);
        }

        /* renamed from: b */
        public final void mo23421b(String str, byte[] bArr, boolean z) {
            AppMethodBeat.m2504i(19213);
            if (this.cbq == null || !this.cbq.equals(str)) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", this.cbq, str, Boolean.valueOf(z));
                AppMethodBeat.m2505o(19213);
                return;
            }
            if (z && bArr != null) {
                try {
                    C45891ad.bph();
                    if (C20495e.m31664c(this.cbq, this.lst, bArr)) {
                        AppMethodBeat.m2505o(19213);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                    AppMethodBeat.m2505o(19213);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
                }
            }
            AppMethodBeat.m2505o(19213);
        }

        /* renamed from: c */
        public final void mo23422c(String str, int i, long j) {
            AppMethodBeat.m2504i(19214);
            if (this.cbq == null || !this.cbq.equals(str)) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", this.cbq, str, Integer.valueOf(i), Long.valueOf(j));
                AppMethodBeat.m2505o(19214);
                return;
            }
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", str, Integer.valueOf(i), Long.valueOf(j));
            switch (i) {
                case 0:
                    C20495e.m31663b(this.lst, this.mURL, 0, this.lsu);
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", str);
                    AppMethodBeat.m2505o(19214);
                    return;
                case 1:
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", str);
                    C20495e.m31663b(this.lst, this.mURL, 1, this.lsu);
                    AppMethodBeat.m2505o(19214);
                    return;
                case 2:
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", str);
                    C20495e.m31663b(this.lst, this.mURL, 2, this.lsu);
                    C24737f c24737f = new C24737f();
                    c24737f.jHc = C24737f.jIf;
                    c24737f.jHd = 2;
                    C45891ad.bph().mo35809u(this.cbq, C42992b.m76353bQ(c24737f));
                    AppMethodBeat.m2505o(19214);
                    return;
                case 4:
                    C20495e.m31663b(this.lst, this.mURL, 4, this.lsu);
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", str);
                    AppMethodBeat.m2505o(19214);
                    return;
                default:
                    C4990ab.m7411d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", str, Integer.valueOf(i), Long.valueOf(j));
                    C20495e.m31663b(this.lst, this.mURL, -1, this.lsu);
                    AppMethodBeat.m2505o(19214);
                    return;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$11 */
    class C2050711 extends C4884c<C41993es> {
        C2050711() {
            AppMethodBeat.m2504i(19145);
            this.xxI = C41993es.class.getName().hashCode();
            AppMethodBeat.m2505o(19145);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19146);
            C41993es c41993es = (C41993es) c4883b;
            if (c41993es == null || !(c41993es instanceof C41993es)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
                AppMethodBeat.m2505o(19146);
                return false;
            }
            c41993es = c41993es;
            if (C20495e.boJ()) {
                c41993es.cyk.cwB = true;
            } else {
                c41993es.cyk.cwB = false;
            }
            AppMethodBeat.m2505o(19146);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$12 */
    class C2050812 extends C4884c<C26172jn> {
        C2050812() {
            AppMethodBeat.m2504i(19147);
            this.xxI = C26172jn.class.getName().hashCode();
            AppMethodBeat.m2505o(19147);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19148);
            C20548u.bpy().mo54568a(new C11651i(((C26172jn) c4883b).cEL.opType));
            AppMethodBeat.m2505o(19148);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$14 */
    class C2050914 extends C4884c<C18259et> {
        C2050914() {
            AppMethodBeat.m2504i(19151);
            this.xxI = C18259et.class.getName().hashCode();
            AppMethodBeat.m2505o(19151);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19152);
            C18259et c18259et = (C18259et) c4883b;
            C20495e c20495e = C20495e.this;
            if (c18259et == null || !(c18259et instanceof C18259et)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
                AppMethodBeat.m2505o(19152);
                return false;
            }
            c18259et = c18259et;
            if (c20495e.mo35809u(c18259et.cyl.mac, c18259et.cyl.data)) {
                c18259et.cym.cwB = true;
            } else {
                c18259et.cym.cwB = false;
            }
            AppMethodBeat.m2505o(19152);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$2 */
    class C205102 extends C4884c<C18245ds> {
        C205102() {
            AppMethodBeat.m2504i(19127);
            this.xxI = C18245ds.class.getName().hashCode();
            AppMethodBeat.m2505o(19127);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19128);
            C18245ds c18245ds = (C18245ds) c4883b;
            if (c18245ds != null && (c18245ds instanceof C18245ds)) {
                c18245ds = c18245ds;
                String str = c18245ds.cxg.cxi;
                boolean z = c18245ds.cxg.cxf;
                C2971d bpd = C45891ad.bpd();
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
                C7305d.xDH.mo10140a(new C29725(str, z), "MicroMsg.exdevice.ExdeviceConnectManager|ranging");
            }
            AppMethodBeat.m2505o(19128);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$31 */
    class C2051131 extends C4884c<C18261ev> {
        C2051131() {
            AppMethodBeat.m2504i(19185);
            this.xxI = C18261ev.class.getName().hashCode();
            AppMethodBeat.m2505o(19185);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19186);
            if (((C18261ev) c4883b).cyp.cwA) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "startScanWCLanDevice...");
                Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            } else {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "stopScanWCLanDevice...");
                Java2CExDevice.stopScanWCLanDevice();
            }
            AppMethodBeat.m2505o(19186);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$33 */
    class C2051233 extends C4884c<C41985ei> {
        C2051233() {
            AppMethodBeat.m2504i(19189);
            this.xxI = C41985ei.class.getName().hashCode();
            AppMethodBeat.m2505o(19189);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19190);
            C41985ei c41985ei = (C41985ei) c4883b;
            C20495e c20495e = C20495e.this;
            c41985ei = c41985ei;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", c41985ei.cxN.cwz, c41985ei.cxN.ceI);
            if (!C20495e.m31657Ke(c41985ei.cxN.cwz) || C5046bo.isNullOrNil(c41985ei.cxN.data)) {
                c41985ei.cxO.cwB = false;
                AppMethodBeat.m2505o(19190);
                return false;
            } else if (C45891ad.boW().mo45701Kv(c41985ei.cxN.ceI) == null) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                c41985ei.cxO.cwB = false;
                AppMethodBeat.m2505o(19190);
                return false;
            } else {
                c41985ei.cxO.cwB = c20495e.lsm.mo35793dR(c41985ei.cxN.ceI, c41985ei.cxN.data);
                AppMethodBeat.m2505o(19190);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$9 */
    class C205139 extends C4884c<C45319dm> {
        C205139() {
            AppMethodBeat.m2504i(19141);
            this.xxI = C45319dm.class.getName().hashCode();
            AppMethodBeat.m2505o(19141);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19142);
            boolean d = C20495e.m31667d((C45319dm) c4883b);
            AppMethodBeat.m2505o(19142);
            return d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$20 */
    class C2051420 extends C4884c<C9411lk> {
        C2051420() {
            AppMethodBeat.m2504i(19163);
            this.xxI = C9411lk.class.getName().hashCode();
            AppMethodBeat.m2505o(19163);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19164);
            if (((C9411lk) c4883b) == null) {
                C4990ab.m7420w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
                AppMethodBeat.m2505o(19164);
            } else {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
                AppMethodBeat.m2505o(19164);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$25 */
    class C2051525 extends C4884c<C41981do> {
        C2051525() {
            AppMethodBeat.m2504i(19173);
            this.xxI = C41981do.class.getName().hashCode();
            AppMethodBeat.m2505o(19173);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19174);
            C41981do c41981do = (C41981do) c4883b;
            C20495e c20495e = C20495e.this;
            c41981do = c41981do;
            c20495e.lsn = new C20528g();
            C20528g c20528g = c20495e.lsn;
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
            c20528g.lsv = false;
            new C7564ap(new C205317(), false).mo16770ae(3000, 3000);
            C20528g c20528g2 = c20495e.lsn;
            long j = c41981do.cwR.cvx;
            String str = c41981do.cwR.cwT;
            String str2 = c41981do.cwR.cwU;
            int i = c41981do.cwR.cwV;
            ArrayList arrayList = new ArrayList();
            c20528g2.edW = j;
            c20528g2.lsy = str;
            c20528g2.lsz = str2;
            c20528g2.lsA = i;
            int size = c20528g2.lsK.size();
            for (int i2 = 0; i2 < size; i2++) {
                HashMap hashMap = new HashMap();
                hashMap.put("deviceType", ((C11648b) c20528g2.lsK.get(i2)).field_deviceType);
                hashMap.put("deviceID", ((C11648b) c20528g2.lsK.get(i2)).field_deviceID);
                hashMap.put("displayName", C20528g.m31718c((C11648b) c20528g2.lsK.get(i2)));
                hashMap.put("iconUrl", ((C11648b) c20528g2.lsK.get(i2)).iconUrl);
                hashMap.put("ability", ((C11648b) c20528g2.lsK.get(i2)).dFr);
                hashMap.put("abilityInf", ((C11648b) c20528g2.lsK.get(i2)).dFs);
                arrayList.add(hashMap);
            }
            if (arrayList.size() > 0) {
                c41981do.cwS.cwW = arrayList;
                c41981do.cwS.cwB = true;
            } else {
                c41981do.cwS.cwB = false;
            }
            AppMethodBeat.m2505o(19174);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$27 */
    class C2051627 extends C4884c<C26129ew> {
        C2051627() {
            AppMethodBeat.m2504i(19177);
            this.xxI = C26129ew.class.getName().hashCode();
            AppMethodBeat.m2505o(19177);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19178);
            C26129ew c26129ew = (C26129ew) c4883b;
            C1202f c1202f = C20495e.this.lsn;
            if (!c1202f.lsv) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
                Java2CExDevice.stopScanWCLanDevice();
                c1202f.lsv = true;
            }
            C9638aw.m17180RS().mo10302aa(new C205298());
            C9638aw.m17182Rg().mo14546b(1717, c1202f);
            C38956j.boN().mo61837b(14, c1202f.lsO);
            C38956j.boN().mo61837b(12, c1202f.lsP);
            C38956j.boN().mo61837b(13, c1202f.lsQ);
            C38956j.boN().mo61837b(15, c1202f.lsR);
            c26129ew.cyq.cxT = true;
            AppMethodBeat.m2505o(19178);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$39 */
    class C2051739 implements C34037a {
        final /* synthetic */ C18247ed lss;

        C2051739(C18247ed c18247ed) {
            this.lss = c18247ed;
        }

        /* renamed from: gM */
        public final void mo35799gM(boolean z) {
            AppMethodBeat.m2504i(19198);
            if (z) {
                C20495e.this.mo35802at(this.lss.cxE.f4320op, this.lss.cxE.userName);
            }
            AppMethodBeat.m2505o(19198);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$c */
    class C20518c implements Runnable {
        List<C11648b> foD;

        public C20518c(List<C11648b> list) {
            this.foD = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(19215);
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
            if (this.foD != null && this.foD.size() > 0) {
                for (C11648b c11648b : this.foD) {
                    C20548u.bpy().mo54568a(new C41266k(c11648b.field_brandName, c11648b.field_deviceType, c11648b.field_deviceID, 1));
                }
                C20495e.this.mHandler.postDelayed(this, 300000);
            }
            AppMethodBeat.m2505o(19215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$13 */
    class C2051913 extends C4884c<C18256eo> {
        C2051913() {
            AppMethodBeat.m2504i(19149);
            this.xxI = C18256eo.class.getName().hashCode();
            AppMethodBeat.m2505o(19149);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19150);
            C18256eo c18256eo = (C18256eo) c4883b;
            C20495e c20495e = C20495e.this;
            if (c18256eo == null || !(c18256eo instanceof C18256eo)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
                AppMethodBeat.m2505o(19150);
                return false;
            }
            boolean Kg;
            c18256eo = c18256eo;
            if (c18256eo.cye.cwA) {
                Kg = c20495e.mo35800Kg(c18256eo.cye.mac);
            } else {
                Kg = C20495e.m31658Kf(c18256eo.cye.mac);
            }
            if (Kg) {
                c18256eo.cyf.cwB = true;
            } else {
                c18256eo.cyf.cwB = false;
            }
            AppMethodBeat.m2505o(19150);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$15 */
    class C2052015 extends C4884c<C18253en> {
        C2052015() {
            AppMethodBeat.m2504i(19153);
            this.xxI = C18253en.class.getName().hashCode();
            AppMethodBeat.m2505o(19153);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19154);
            C18253en c18253en = (C18253en) c4883b;
            if (c18253en == null || !(c18253en instanceof C18253en)) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
                AppMethodBeat.m2505o(19154);
                return false;
            }
            c18253en = c18253en;
            if (C45891ad.boW().mo45710id(C42992b.m76346KK(c18253en.cya.mac)) != null) {
                C4990ab.m7410d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + c18253en.cya.mac + ") has been binded");
                c18253en.cyb.cwB = true;
            } else {
                boolean z;
                String str = c18253en.cya.mac;
                String str2 = c18253en.cya.cyc;
                long j = c18253en.cya.cyd;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                    z = false;
                } else {
                    String str3;
                    String str4 = "MicroMsg.exdevice.ExdeviceEventManager";
                    String str5 = "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    if (str2 == null) {
                        str3 = BuildConfig.COMMAND;
                    } else {
                        str3 = str2;
                    }
                    objArr[1] = str3;
                    objArr[2] = Long.valueOf(j);
                    C4990ab.m7411d(str4, str5, objArr);
                    int acS = C9638aw.m17182Rg().acS();
                    if (acS == 4 || acS == 6) {
                        if (C9638aw.m17182Rg().mo14541a(new C27853m(C42992b.m76346KK(str), str2, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, j), 0)) {
                            z = true;
                        } else {
                            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                            z = false;
                        }
                    } else {
                        C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", Integer.valueOf(acS));
                        z = false;
                    }
                }
                if (z) {
                    c18253en.cyb.cwB = true;
                } else {
                    c18253en.cyb.cwB = false;
                }
            }
            AppMethodBeat.m2505o(19154);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$1 */
    class C205211 extends C4884c<C26174jo> {
        C205211() {
            AppMethodBeat.m2504i(19125);
            this.xxI = C26174jo.class.getName().hashCode();
            AppMethodBeat.m2505o(19125);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C11648b c11648b;
            AppMethodBeat.m2504i(19126);
            C26174jo c26174jo = (C26174jo) c4883b;
            C20495e c20495e = C20495e.this;
            int i = c26174jo.cEM.opType;
            int i2 = c26174jo.cEM.cEO;
            String str = c26174jo.cEM.cEN;
            if (i == 1) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
                C32596lq c32596lq = new C32596lq();
                c32596lq.cHu.f15019op = 3;
                c32596lq.cHu.cEN = c26174jo.cEM.cEN;
                C4879a.xxA.mo10055m(c32596lq);
            }
            LinkedList Kx = C45891ad.boW().mo45702Kx(str);
            C16527d qX = C17903f.m28104qX(str);
            if (qX != null) {
                C16529b cJ = qX.mo30481cJ(false);
                if (cJ != null) {
                    C16536b aej = cJ.aej();
                    if (aej != null && aej.aes() && aej.fvJ == 1) {
                        LinkedList<C11648b> bpC = C45891ad.boW().bpC();
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                        if (bpC.size() != 0) {
                            for (C11648b c11648b2 : bpC) {
                                if (0 != (c11648b2.dFq & 1)) {
                                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", Long.valueOf(c11648b2.field_mac), c11648b2.field_deviceID, c11648b2.field_deviceType, Long.valueOf(c11648b2.dFq), c11648b2.field_connProto);
                                    Kx.add(c11648b2);
                                }
                            }
                        }
                    }
                }
            }
            if (Kx == null) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", str);
                AppMethodBeat.m2505o(19126);
                return false;
            } else if (Kx.size() == 0) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", str);
                AppMethodBeat.m2505o(19126);
                return true;
            } else {
                if (i == 2) {
                    C4990ab.m7410d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                    c20495e.lrx.clear();
                }
                LinkedList linkedList = new LinkedList();
                Iterator it = Kx.iterator();
                Object obj = null;
                while (it.hasNext()) {
                    c11648b2 = (C11648b) it.next();
                    if (c11648b2 == null || C5046bo.isNullOrNil(c11648b2.field_brandName)) {
                        AppMethodBeat.m2505o(19126);
                        return false;
                    }
                    String nullAsNil = C5046bo.nullAsNil(c11648b2.field_connProto);
                    if (nullAsNil.contains("4")) {
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                        linkedList.add(c11648b2);
                    } else {
                        if (nullAsNil.contains("1") || nullAsNil.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || nullAsNil.contains("5") || nullAsNil.length() == 0) {
                            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                            if (C42904a.aVH()) {
                                obj = null;
                                C20495e.m31661a(c11648b2, i, i2);
                            } else {
                                C4990ab.m7420w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                                obj = 1;
                            }
                        }
                        obj = obj;
                    }
                }
                i2 = linkedList.size();
                if (i2 > 0) {
                    c20495e.mo35807k(linkedList, i);
                    c11648b2 = (C11648b) linkedList.get(i2 - 1);
                    if (i2 == Kx.size()) {
                        C20495e.m31663b(c11648b2.field_brandName, c11648b2.field_url, 0, c11648b2.field_deviceID);
                    }
                }
                C20495e.m31665cc(str, obj != null ? 0 : -1);
                AppMethodBeat.m2505o(19126);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$26 */
    class C2052226 extends C4884c<C41987ej> {
        C2052226() {
            AppMethodBeat.m2504i(19175);
            this.xxI = C41987ej.class.getName().hashCode();
            AppMethodBeat.m2505o(19175);
        }

        /* JADX WARNING: Removed duplicated region for block: B:108:0x04bb  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x03d8  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x04d2  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x03d8  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x04bb  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x04d2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19176);
            C41987ej c41987ej = (C41987ej) c4883b;
            C20495e c20495e = C20495e.this;
            c41987ej = c41987ej;
            if (C5046bo.isNullOrNil(c41987ej.cxP.cws) || C5046bo.isNullOrNil(c41987ej.cxP.ceI)) {
                c41987ej.cxQ.cxT = false;
            } else {
                String str;
                Boolean bool;
                int i;
                C18249b c18249b = c41987ej.cxQ;
                C20528g c20528g = c20495e.lsn;
                String str2 = c41987ej.cxP.cws;
                String str3 = c41987ej.cxP.ceI;
                String str4 = c41987ej.cxP.cxR;
                long j = c41987ej.cxP.cvx;
                String str5 = c41987ej.cxP.cwT;
                boolean z = c41987ej.cxP.cxS;
                c20528g.edW = j;
                c20528g.lsw = false;
                c20528g.lsx = z;
                C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "deviceType: %s, deviceId: %s", str2, str3);
                int i2 = 0;
                if (str4 == null || !str4.contains("wechat_to_device") || c20528g.lsL.get(str3) == null) {
                    if (str4 != null && str4.contains("internet_to_device")) {
                        i2 = 1;
                        if (!z && (C20528g.m31721hJ(j).booleanValue() || C20528g.m31720hI(j).booleanValue() || C20528g.m31723hL(j).booleanValue() || C20528g.m31722hK(j).booleanValue())) {
                            str4 = "MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice";
                            str5 = "mDeviceMsgForUseCdn %s deviceId %s deviceType %s";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(c20528g.lsH == null);
                            objArr[1] = str3;
                            objArr[2] = str2;
                            C4990ab.m7411d(str4, str5, objArr);
                            if (c20528g.lsH != null) {
                                C9638aw.m17182Rg().mo14541a(new C20535n(c20528g.lsH, str2, str3, 1), 0);
                            } else {
                                c20528g.lsG.put(str3, str2);
                                if (!c20528g.lsF) {
                                    Object obj;
                                    str4 = "";
                                    str = "";
                                    c20528g.lsE = true;
                                    C9638aw.m17190ZK();
                                    C7620bi jf = C18628c.m29080XO().mo15340jf(j);
                                    Object[] objArr2;
                                    C42130g c42130g;
                                    if (C20528g.m31721hJ(j).booleanValue()) {
                                        C25822e w = C32291o.ahl().mo73124w(jf);
                                        str4 = C32291o.ahl().mo73118q(w.fDz, "", "");
                                        str = C32291o.ahl().mo73118q(w.fDB, "", "");
                                        c20528g.eFm = w.fDy;
                                        if (C5046bo.isNullOrNil(c20528g.fFa)) {
                                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(jf.field_createTime), jf.field_talker, Long.valueOf(jf.field_msgId), Long.valueOf(c20528g.eFm), Integer.valueOf(0));
                                            c20528g.fFa = C37458c.m63162a("upimg", jf.field_createTime, jf.field_talker, jf.field_msgId + "_" + c20528g.eFm + "_0");
                                        }
                                        C37461f.afx();
                                        if (!C31259b.m50439lg(1) && C5046bo.isNullOrNil(w.fDK)) {
                                            objArr2 = new Object[2];
                                            C37461f.afx();
                                            objArr2[0] = Boolean.valueOf(C31259b.m50439lg(1));
                                            objArr2[1] = w.fDK;
                                            C4990ab.m7421w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%s", objArr2);
                                            obj = null;
                                        }
                                        if (C20528g.m31721hJ(j).booleanValue() || C20528g.m31722hK(j).booleanValue()) {
                                            c20528g.lsI = new Random().nextLong();
                                            str4 = C20528g.m31714B(str4, c20528g.lsI);
                                            str = C20528g.m31714B(str, c20528g.lsI);
                                        }
                                        c42130g = new C42130g();
                                        c42130g.egl = c20528g.fFk;
                                        c42130g.field_mediaId = c20528g.fFa;
                                        c42130g.field_fullpath = str4;
                                        c42130g.field_thumbpath = str;
                                        c42130g.field_fileType = C42129a.efM;
                                        c42130g.field_talker = jf.field_talker;
                                        c42130g.field_priority = C42129a.efB;
                                        c42130g.field_needStorage = false;
                                        c42130g.field_isStreamMedia = false;
                                        c42130g.field_appType = 202;
                                        c42130g.field_bzScene = 2;
                                        if (C20528g.m31720hI(j).booleanValue()) {
                                            c42130g.field_fileType = C42129a.efM;
                                            c42130g.field_appType = 202;
                                        } else if (C20528g.m31723hL(j).booleanValue()) {
                                            c42130g.field_appType = 102;
                                            c42130g.field_fileType = C42129a.efI;
                                            c42130g.field_bzScene = 1;
                                        }
                                        if (C37461f.afx().mo51225e(c42130g)) {
                                            obj = 1;
                                        } else {
                                            C7060h.pYm.mo8378a(111, 205, 1, false);
                                            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", c20528g.fFa);
                                            c20528g.fFa = "";
                                            obj = null;
                                        }
                                    } else if (C20528g.m31720hI(j).booleanValue() || C20528g.m31722hK(j).booleanValue()) {
                                        C30065b aiE = C14877am.aUq().aiE(C8910b.m16064me(jf.field_content).csD);
                                        if (aiE != null) {
                                            str4 = aiE.field_fileFullPath;
                                            C37461f.afx();
                                            if (C31259b.m50439lg(4) || aiE.field_isUseCdn == 1) {
                                                if (!C5046bo.isNullOrNil(jf.field_imgPath)) {
                                                    str = C32291o.ahl().mo73119sj(jf.field_imgPath);
                                                }
                                                long asZ = C5730e.asZ(str);
                                                long asZ2 = C5730e.asZ(aiE.field_fileFullPath);
                                                if (asZ >= ((long) C42129a.efW)) {
                                                    C4990ab.m7421w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Long.valueOf(asZ));
                                                    obj = null;
                                                } else {
                                                    c20528g.fFa = C37458c.m63162a("upattach", aiE.field_createTime, jf.field_talker, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                                    if (C5046bo.isNullOrNil(c20528g.fFa)) {
                                                        C4990ab.m7421w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn compressType:%d", Integer.valueOf(0));
                                                        obj = null;
                                                    } else {
                                                        C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", Long.valueOf(aiE.field_msgInfoId), aiE.field_fileFullPath, Long.valueOf(asZ2), str, Long.valueOf(asZ));
                                                        c20528g.lsI = new Random().nextLong();
                                                        str4 = C20528g.m31714B(str4, c20528g.lsI);
                                                        str = C20528g.m31714B(str, c20528g.lsI);
                                                        c42130g = new C42130g();
                                                        c42130g.egl = c20528g.fFk;
                                                        c42130g.field_mediaId = c20528g.fFa;
                                                        c42130g.field_fullpath = str4;
                                                        c42130g.field_thumbpath = str;
                                                        c42130g.field_fileType = C42129a.efM;
                                                        c42130g.field_talker = jf.field_talker;
                                                        c42130g.field_priority = C42129a.efB;
                                                        c42130g.field_needStorage = false;
                                                        c42130g.field_isStreamMedia = false;
                                                        c42130g.field_appType = 202;
                                                        c42130g.field_bzScene = 2;
                                                        if (C20528g.m31720hI(j).booleanValue()) {
                                                        }
                                                        if (C37461f.afx().mo51225e(c42130g)) {
                                                        }
                                                    }
                                                }
                                            } else {
                                                objArr2 = new Object[2];
                                                C37461f.afx();
                                                objArr2[0] = Boolean.valueOf(C31259b.m50439lg(4));
                                                objArr2[1] = Integer.valueOf(aiE.field_isUseCdn);
                                                C4990ab.m7421w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", objArr2);
                                                obj = null;
                                            }
                                        } else {
                                            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                                            obj = null;
                                        }
                                    } else {
                                        if (C20528g.m31723hL(j).booleanValue()) {
                                            C26493s uf = C37961o.all().mo21063uf(jf.field_imgPath);
                                            if (uf == null) {
                                                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Get info Failed file:" + jf.field_imgPath);
                                                obj = null;
                                            } else {
                                                C37461f.afx();
                                                if (C31259b.m50439lg(2) || uf.fXi == 1) {
                                                    c20528g.fFa = C37458c.m63162a("upvideo", uf.createTime, uf.getUser(), uf.getFileName());
                                                    if (C5046bo.isNullOrNil(c20528g.fFa)) {
                                                        C4990ab.m7421w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn file:%s", uf.getFileName());
                                                        obj = null;
                                                    } else {
                                                        C37961o.all();
                                                        str = C9720t.m17304ui(jf.field_imgPath);
                                                        C37961o.all();
                                                        str4 = C9720t.m17303uh(jf.field_imgPath);
                                                    }
                                                } else {
                                                    r7 = new Object[2];
                                                    C37461f.afx();
                                                    r7[0] = Boolean.valueOf(C31259b.m50439lg(2));
                                                    r7[1] = Integer.valueOf(uf.fXi);
                                                    C4990ab.m7421w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", r7);
                                                    obj = null;
                                                }
                                            }
                                        }
                                        c20528g.lsI = new Random().nextLong();
                                        str4 = C20528g.m31714B(str4, c20528g.lsI);
                                        str = C20528g.m31714B(str, c20528g.lsI);
                                        c42130g = new C42130g();
                                        c42130g.egl = c20528g.fFk;
                                        c42130g.field_mediaId = c20528g.fFa;
                                        c42130g.field_fullpath = str4;
                                        c42130g.field_thumbpath = str;
                                        c42130g.field_fileType = C42129a.efM;
                                        c42130g.field_talker = jf.field_talker;
                                        c42130g.field_priority = C42129a.efB;
                                        c42130g.field_needStorage = false;
                                        c42130g.field_isStreamMedia = false;
                                        c42130g.field_appType = 202;
                                        c42130g.field_bzScene = 2;
                                        if (C20528g.m31720hI(j).booleanValue()) {
                                        }
                                        if (C37461f.afx().mo51225e(c42130g)) {
                                        }
                                    }
                                    if (obj == null) {
                                        C20528g.m31719dQ(str3, c20528g.lsC);
                                        c20528g.lsF = false;
                                    } else {
                                        c20528g.lsF = true;
                                    }
                                }
                            }
                            bool = Boolean.TRUE;
                            c18249b.cxT = bool.booleanValue();
                        }
                    }
                    i = i2;
                } else {
                    i = 0;
                }
                atr atr = new atr();
                bau bau;
                if (!z) {
                    c20528g.mo35812a(atr, c20528g.edW);
                } else if (c20528g.boL().xfI.wbJ != 1 || i != 0 || c20528g.lsz != null) {
                    if (str5 != null) {
                        TimeLineObject boL = c20528g.boL();
                        switch (boL.xfI.wbJ) {
                            case 1:
                                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns photo!");
                                int i3 = -1;
                                String str6 = null;
                                String str7 = null;
                                str = null;
                                String str8 = c20528g.lsz;
                                if (str8 != null && str8.length() > 0) {
                                    C5728b c5728b = new C5728b(str8);
                                    str7 = c5728b.getName();
                                    i3 = (int) c5728b.length();
                                    str = str7.substring(str7.lastIndexOf(".") + 1, str7.length());
                                    str6 = C5730e.atg(str8);
                                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "dataSnsInit filePath %s, fileSize %s, fileMd5 %s", str8, Integer.valueOf(i3), str6);
                                }
                                ats ats = new ats();
                                ats.Type = str;
                                ats.Name = str7;
                                ats.jCo = i3;
                                ats.Md5 = str6;
                                if (i == 1) {
                                    bau = (bau) boL.xfI.wbK.get(c20528g.lsA);
                                    if (bau == null) {
                                        C4990ab.m7420w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                                        break;
                                    }
                                    ats.Url = bau.Url;
                                    ats.wxO = bau.wEY;
                                    if (!C5046bo.isNullOrNil(ats.wxO)) {
                                        ats.Url += "?idx=" + bau.wEX + "&token=" + bau.wEW;
                                    }
                                }
                                atr.wxK = ats;
                                atr.wxH = 3;
                                break;
                            case 3:
                                bau = (bau) boL.xfI.wbK.get(0);
                                if (bau != null) {
                                    c20528g.lsw = true;
                                    atv atv = new atv();
                                    atv.Url = bau.Url;
                                    atv.Title = bau.Title;
                                    atv.wxR = bau.Desc;
                                    atr.wxM = atv;
                                    atr.wxH = 5;
                                    break;
                                }
                                C4990ab.m7420w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObUrl is null");
                                break;
                            case 4:
                                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns music!");
                                bau = (bau) boL.xfI.wbK.get(0);
                                if (bau != null) {
                                    c20528g.lsw = true;
                                    atu atu = new atu();
                                    atu.Title = bau.Title;
                                    atu.wxR = bau.Desc;
                                    atu.Url = boL.xfI.Url;
                                    atu.vYK = bau.Url;
                                    atu.wxT = bau.wEL;
                                    atu.ncH = boL.xfH.ncH;
                                    atr.wxI = atu;
                                    atr.wxH = 1;
                                    break;
                                }
                                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObj is null");
                                break;
                            case 15:
                                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns sight!");
                                bau = (bau) boL.xfI.wbK.get(0);
                                if (bau != null) {
                                    c20528g.lsw = true;
                                    atw atw = new atw();
                                    atw.Url = bau.Url;
                                    C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "videoMsg.url = %s", atw.Url);
                                    atr.wxN = atw;
                                    atr.wxH = 6;
                                    break;
                                }
                                C4990ab.m7420w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjSight is null");
                                break;
                        }
                    }
                } else {
                    c20528g.lsT = atr;
                    c20528g.lsU = str2;
                    c20528g.lsV = str3;
                    c20528g.lsW = 0;
                    bau = (bau) c20528g.boL().xfI.wbK.get(c20528g.lsA);
                    if (bau == null) {
                        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                        C20528g.m31719dQ(str3, c20528g.lsC);
                    } else {
                        c20528g.cEZ = bau.Url;
                        C7305d.post(c20528g.lsS, "ExdeviceDownloadImage");
                    }
                    bool = Boolean.TRUE;
                    c18249b.cxT = bool.booleanValue();
                }
                C9638aw.m17182Rg().mo14541a(new C20535n(atr, str2, str3, i), 0);
                bool = Boolean.TRUE;
                c18249b.cxT = bool.booleanValue();
            }
            AppMethodBeat.m2505o(19176);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$28 */
    class C2052328 extends C4884c<C18251em> {
        C2052328() {
            AppMethodBeat.m2504i(19179);
            this.xxI = C18251em.class.getName().hashCode();
            AppMethodBeat.m2505o(19179);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19180);
            C18251em c18251em = (C18251em) c4883b;
            if (C45891ad.boW().bpB().size() > 0) {
                c18251em.cxZ.cwB = true;
            } else {
                c18251em.cxZ.cwB = false;
            }
            AppMethodBeat.m2505o(19180);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$30 */
    class C2052430 extends C4884c<C32542ee> {
        C2052430() {
            AppMethodBeat.m2504i(19183);
            this.xxI = C32542ee.class.getName().hashCode();
            AppMethodBeat.m2505o(19183);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19184);
            C32542ee c32542ee = (C32542ee) c4883b;
            C20495e c20495e = C20495e.this;
            c32542ee = c32542ee;
            if (c20495e.lsm == null) {
                c20495e.lsm = new ExdeviceWCLanSDKUtil();
            }
            ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = c20495e.lsm;
            if (c32542ee.cxF.cwA) {
                C4990ab.m7416i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
                Java2CExDevice.initWCLanDeviceLib();
                C38956j.boN().mo61836a(14, exdeviceWCLanSDKUtil.lsO);
                C38956j.boN().mo61836a(10, exdeviceWCLanSDKUtil.ltg);
                C38956j.boN().mo61836a(13, exdeviceWCLanSDKUtil.lsQ);
                C38956j.boN().mo61836a(16, exdeviceWCLanSDKUtil.lth);
            } else {
                C9638aw.m17180RS().mo10302aa(new C204775());
                C4990ab.m7410d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "unregisterReceiver...");
                if (exdeviceWCLanSDKUtil.jIA != null) {
                    exdeviceWCLanSDKUtil.mContext.unregisterReceiver(exdeviceWCLanSDKUtil.jIA);
                    exdeviceWCLanSDKUtil.jIA = null;
                }
                C38956j.boN().mo61837b(14, exdeviceWCLanSDKUtil.lsO);
                C38956j.boN().mo61837b(10, exdeviceWCLanSDKUtil.ltg);
                C38956j.boN().mo61837b(13, exdeviceWCLanSDKUtil.lsQ);
                C38956j.boN().mo61837b(16, exdeviceWCLanSDKUtil.lth);
            }
            AppMethodBeat.m2505o(19184);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$32 */
    class C2052532 extends C4884c<C18238di> {
        C2052532() {
            AppMethodBeat.m2504i(19187);
            this.xxI = C18238di.class.getName().hashCode();
            AppMethodBeat.m2505o(19187);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19188);
            C18238di c18238di = (C18238di) c4883b;
            C20495e c20495e = C20495e.this;
            c18238di = c18238di;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", c18238di.cwC.cwz, c18238di.cwC.ceI, Boolean.valueOf(c18238di.cwC.cwA));
            if (C20495e.m31657Ke(c18238di.cwC.cwz)) {
                C11648b Kv = C45891ad.boW().mo45701Kv(c18238di.cwC.ceI);
                if (Kv == null) {
                    c18238di.cwD.cwB = false;
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", c18238di.cwC.ceI);
                    AppMethodBeat.m2505o(19188);
                    return false;
                } else if (Kv.field_brandName.equals(c18238di.cwC.cwz)) {
                    boolean ax = c20495e.lsm.mo35792ax(c18238di.cwC.ceI, c18238di.cwC.cwA);
                    c18238di.cwD.cwB = ax;
                    AppMethodBeat.m2505o(19188);
                    return ax;
                } else {
                    c18238di.cwD.cwB = false;
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", Kv.field_brandName, c18238di.cwC.cwz);
                    AppMethodBeat.m2505o(19188);
                    return false;
                }
            }
            c18238di.cwD.cwB = false;
            AppMethodBeat.m2505o(19188);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$43 */
    class C2052643 extends C4884c<C9472sl> {
        C2052643() {
            AppMethodBeat.m2504i(19203);
            this.xxI = C9472sl.class.getName().hashCode();
            AppMethodBeat.m2505o(19203);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19204);
            boolean boH = C20495e.boH();
            AppMethodBeat.m2505o(19204);
            return boH;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$8 */
    class C205278 extends C4884c<C6473dy> {
        C205278() {
            AppMethodBeat.m2504i(19139);
            this.xxI = C6473dy.class.getName().hashCode();
            AppMethodBeat.m2505o(19139);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(19140);
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", Integer.valueOf(((C6473dy) c4883b).cxy.f1965op));
            if (((C6473dy) c4883b).cxy.f1965op == 1) {
                C2971d bpd = C45891ad.bpd();
                if (bpd.lrc == null) {
                    bpd.lrc = new C34050c();
                    bpd.lrc.lwE = new C298311();
                    bpd.lrc.mo54583dH(C4996ah.getContext());
                }
            }
            AppMethodBeat.m2505o(19140);
            return true;
        }
    }

    public C20495e() {
        AppMethodBeat.m2504i(19216);
        HandlerThread anM = C7305d.anM("wifi_device_heart_beat");
        anM.start();
        this.mHandler = new C7306ak(anM.getLooper());
        AppMethodBeat.m2505o(19216);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final boolean mo35804c(C4883b c4883b) {
        AppMethodBeat.m2504i(19217);
        C37704dn c37704dn = (C37704dn) c4883b;
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", c37704dn.cwP.cwz, c37704dn.cwP.context);
        if (C20495e.m31657Ke(c37704dn.cwP.cwz)) {
            LinkedList Kx = C45891ad.boW().mo45702Kx(c37704dn.cwP.cwz);
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = Kx.iterator();
                while (it.hasNext()) {
                    C11648b c11648b = (C11648b) it.next();
                    if (!Kx.isEmpty() && C5046bo.nullAsNil(c11648b.field_connProto).contains("4")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", c11648b.field_deviceID);
                        if (this.lsm.mo35791Ki(c11648b.field_deviceID)) {
                            jSONObject.put("state", "connected");
                        } else {
                            jSONObject.put("state", "disconnected");
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e.getMessage());
            }
            c37704dn.cwQ.cwO = jSONArray;
            c37704dn.cwQ.cwB = true;
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
            AppMethodBeat.m2505o(19217);
        } else {
            c37704dn.cwQ.cwO = null;
            c37704dn.cwQ.cwB = false;
            AppMethodBeat.m2505o(19217);
        }
        return true;
    }

    /* renamed from: i */
    static boolean m31669i(String str, List<C11648b> list) {
        AppMethodBeat.m2504i(19218);
        String host = Uri.parse(str).getHost();
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
        JSONArray jSONArray = null;
        boolean z = false;
        for (C11648b c11648b : list) {
            String str2 = c11648b.dFr;
            String str3 = c11648b.dFs;
            if (str3 != null && str3.length() > 0 && str2 != null && str2.contains("wxmsg_url")) {
                JSONArray jSONArray2;
                try {
                    jSONArray2 = new JSONObject(str3).getJSONArray("wxmsg_url");
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e, "", new Object[0]);
                    jSONArray2 = jSONArray;
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        if (jSONArray2.getString(i).equals(host)) {
                            z = true;
                            break;
                        }
                        i++;
                    } catch (JSONException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                    }
                }
                if (z) {
                    break;
                }
                jSONArray = jSONArray2;
            }
        }
        AppMethodBeat.m2505o(19218);
        return z;
    }

    /* renamed from: j */
    static boolean m31670j(String str, List<C11648b> list) {
        AppMethodBeat.m2504i(19219);
        if (str == null) {
            AppMethodBeat.m2505o(19219);
            return false;
        }
        boolean z;
        C45333id c45333id = new C45333id();
        c45333id.cDc.cwT = str;
        C4879a.xxA.mo10055m(c45333id);
        TimeLineObject timeLineObject = c45333id.cDd.cDe;
        int i = timeLineObject.xfI.wbJ;
        String str2;
        if (i == 1) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
            for (C11648b c11648b : list) {
                str2 = c11648b.dFr;
                if (str2 != null && str2.contains("wxmsg_image")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 4) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
            for (C11648b c11648b2 : list) {
                str2 = c11648b2.dFr;
                if (str2 != null && str2.contains("wxmsg_music")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 15) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
            for (C11648b c11648b22 : list) {
                str2 = c11648b22.dFr;
                if (str2 != null && str2.contains("wxmsg_video")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = i == 3 ? C20495e.m31669i(timeLineObject.xfI.Url, list) : false;
        }
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
        AppMethodBeat.m2505o(19219);
        return z;
    }

    /* renamed from: d */
    static boolean m31667d(C4883b c4883b) {
        AppMethodBeat.m2504i(19220);
        C45319dm c45319dm = (C45319dm) c4883b;
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", c45319dm.cwM.cwz, c45319dm.cwM.context);
        LinkedList Kx = C45891ad.boW().mo45702Kx(c45319dm.cwM.cwz);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = Kx.iterator();
            while (it.hasNext()) {
                C11648b c11648b = (C11648b) it.next();
                if (!Kx.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", c11648b.field_deviceID);
                    if (C20548u.bpx().mo45719hR(c11648b.field_mac)) {
                        jSONObject.put("state", "connected");
                    } else {
                        jSONObject.put("state", "disconnected");
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e.getMessage());
        }
        c45319dm.cwN.cwO = jSONArray;
        c45319dm.cwN.cwB = true;
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
        AppMethodBeat.m2505o(19220);
        return true;
    }

    /* renamed from: e */
    static boolean m31668e(C4883b c4883b) {
        AppMethodBeat.m2504i(19221);
        C37708eh c37708eh = (C37708eh) c4883b;
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", c37708eh.cxL.cwz, c37708eh.cxL.ceI);
        if (C5046bo.m7540cb(c37708eh.cxL.data)) {
            c37708eh.cxM.cwB = false;
            AppMethodBeat.m2505o(19221);
            return false;
        }
        C11648b Kv = C45891ad.boW().mo45701Kv(c37708eh.cxL.ceI);
        if (Kv == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            c37708eh.cxM.cwB = false;
            AppMethodBeat.m2505o(19221);
            return false;
        } else if (!C20548u.bpx().mo45719hR(Kv.field_mac)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
            c37708eh.cxM.cwB = false;
            AppMethodBeat.m2505o(19221);
            return false;
        } else if (C20548u.bpx().mo45725hX(Kv.field_mac)) {
            if (C27842aa.boT().lsZ) {
                C27842aa.boT().mo45714uK(C20495e.m31659a(Kv));
            }
            C20548u.bpy().mo54568a(new C27839g(c37708eh.cxL.data, 10001, Kv.field_mac));
            c37708eh.cxM.cwB = true;
            AppMethodBeat.m2505o(19221);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
            c37708eh.cxM.cwB = false;
            AppMethodBeat.m2505o(19221);
            return false;
        }
    }

    /* renamed from: a */
    static int m31659a(C11648b c11648b) {
        AppMethodBeat.m2504i(19222);
        int i = -1;
        if (C5046bo.nullAsNil(c11648b.field_connProto).contains("1")) {
            i = 1;
        } else if (C5046bo.nullAsNil(c11648b.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            i = 0;
        }
        AppMethodBeat.m2505o(19222);
        return i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final boolean mo35805f(C4883b c4883b) {
        AppMethodBeat.m2504i(19223);
        final C41983dp c41983dp = (C41983dp) c4883b;
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", c41983dp.cwX.cwz, c41983dp.cwX.ceI, Integer.valueOf(c41983dp.cwX.type));
        ajn ajn = new ajn();
        ajn.wpk = c41983dp.cwX.type;
        ajn.wpl = 0;
        ajn.vKM = new asq();
        ajn.vKM.jBE = c41983dp.cwX.ceI;
        ajn.vKM.vIk = c41983dp.cwX.cwz;
        LinkedList linkedList = new LinkedList();
        linkedList.add(ajn);
        C1202f c2048936 = new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(19195);
                if (c1207m == null || c1207m.getType() != 543) {
                    c41983dp.cwY.cxa = true;
                    c41983dp.cwY.cxb = null;
                    if (c41983dp.callback != null) {
                        c41983dp.callback.run();
                    }
                    AppMethodBeat.m2505o(19195);
                    return;
                }
                C9638aw.m17182Rg().mo14546b(543, (C1202f) this);
                if (i == 0 && i2 == 0) {
                    ajp ajp;
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                    C42999z c42999z = (C42999z) c1207m;
                    if (c42999z.lty == null || c42999z.lty.fsH.fsP == null) {
                        ajp = null;
                    } else {
                        ajp = (ajp) c42999z.lty.fsH.fsP;
                    }
                    Iterator it = ajp.wpo.iterator();
                    Object obj = null;
                    while (it.hasNext()) {
                        ajq ajq = (ajq) it.next();
                        if (ajq != null) {
                            String str2 = null;
                            String str3 = null;
                            if (ajq.vKM != null) {
                                str2 = ajq.vKM.jBE;
                                str3 = ajq.vKM.vIk;
                            }
                            if (ajq.Ret != 0 || C5046bo.isNullOrNil(ajq.wdB)) {
                                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", str2, Integer.valueOf(ajq.Ret), ajq.wdB);
                            } else {
                                Object obj2;
                                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", str2, str3, ajq.wdB, Integer.valueOf(ajq.wpk));
                                c41983dp.cwY.cxa = true;
                                c41983dp.cwY.cxb = ajq.wdB;
                                if (c41983dp.callback != null) {
                                    c41983dp.callback.run();
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                obj = obj2;
                            }
                        }
                    }
                    if (obj == null) {
                        c41983dp.cwY.cxa = true;
                        c41983dp.cwY.cxb = null;
                        if (c41983dp.callback != null) {
                            c41983dp.callback.run();
                        }
                    }
                    AppMethodBeat.m2505o(19195);
                    return;
                }
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                c41983dp.cwY.cxa = true;
                c41983dp.cwY.cxb = null;
                if (c41983dp.callback != null) {
                    c41983dp.callback.run();
                }
                AppMethodBeat.m2505o(19195);
            }
        };
        C1207m c42999z = new C42999z(linkedList, c41983dp.cwX.cwz, c41983dp.cwX.cwZ);
        C9638aw.m17182Rg().mo14539a(543, c2048936);
        if (C9638aw.m17182Rg().mo14541a(c42999z, 0)) {
            AppMethodBeat.m2505o(19223);
            return false;
        }
        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
        C9638aw.m17182Rg().mo14546b(543, c2048936);
        c41983dp.cwY.cxa = true;
        c41983dp.cwY.cxb = null;
        if (c41983dp.callback != null) {
            c41983dp.callback.run();
        }
        AppMethodBeat.m2505o(19223);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final boolean mo35806g(C4883b c4883b) {
        AppMethodBeat.m2504i(19224);
        C9329ef c9329ef = (C9329ef) c4883b;
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", c9329ef.cxG.cwz, Boolean.valueOf(c9329ef.cxG.cwA), Integer.valueOf(c9329ef.cxG.cxI));
        int i = c9329ef.cxG.cxI;
        if (!(i == 0 || i == 1)) {
            if (C42904a.m76178dv(C4996ah.getContext())) {
                C4990ab.m7421w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", Integer.valueOf(i));
                i = 0;
            } else {
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", Integer.valueOf(i));
                c9329ef.cxH.cwB = false;
                AppMethodBeat.m2505o(19224);
                return false;
            }
        }
        if (c9329ef.cxG.cwA) {
            C43000j boT = C27842aa.boT();
            String str = c9329ef.cxG.cwz;
            C2049037 c2049037 = new C2049037();
            C4990ab.m7417i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", str);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
            } else {
                boT.lst = str;
                boT.ltN = c2049037;
                boT.ltO.clear();
                Iterator it = boT.ltP.iterator();
                while (it.hasNext()) {
                    C1207m c1207m = (C1207m) it.next();
                    if (c1207m != null) {
                        C9638aw.m17182Rg().mo14547c(c1207m);
                    }
                }
                boT.ltP.clear();
                synchronized (C27842aa.cli) {
                    try {
                        C27842aa.ltQ.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(19224);
                        }
                    }
                }
                if (boT.lsZ) {
                    C4990ab.m7420w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                } else {
                    boT.lsZ = true;
                    C9638aw.m17182Rg().mo14539a(542, (C1202f) boT);
                    C45891ad.bpd().mo7176a(i, boT);
                    C4990ab.m7416i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                    boT.gGo.mo16770ae(12000, 12000);
                }
            }
        } else {
            C27842aa.boT().mo45714uK(i);
        }
        c9329ef.cxH.cwB = true;
        AppMethodBeat.m2505o(19224);
        return true;
    }

    /* renamed from: Ke */
    static boolean m31657Ke(String str) {
        AppMethodBeat.m2504i(19225);
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            AppMethodBeat.m2505o(19225);
            return false;
        }
        C16529b cJ = qX.mo30481cJ(false);
        if (cJ == null || cJ.aej() == null || !cJ.aej().aes()) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
            AppMethodBeat.m2505o(19225);
            return false;
        }
        AppMethodBeat.m2505o(19225);
        return true;
    }

    /* renamed from: a */
    static boolean m31661a(C11648b c11648b, int i, int i2) {
        AppMethodBeat.m2504i(19226);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
        if (c11648b == null) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
            AppMethodBeat.m2505o(19226);
            return false;
        }
        String str = c11648b.field_brandName;
        C27860a hT = C20548u.bpx().mo45721hT(c11648b.field_mac);
        if (hT == null) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            AppMethodBeat.m2505o(19226);
            return false;
        }
        if (hT.cxs == 2) {
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", str);
            C20548u.bpy().mo54568a(new C27840j(i, i2, c11648b.field_mac));
        }
        C45891ad.bpd().mo7182uI(i == 1 ? 1 : 0);
        if (i == 2) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
            C7564ap c7564ap = (C7564ap) C45891ad.bpd().lre.remove(Long.valueOf(c11648b.field_mac));
            if (c7564ap != null) {
                c7564ap.stopTimer();
            }
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", Integer.valueOf(c11648b.field_closeStrategy));
            if (!((c11648b.field_closeStrategy & 1) == 0 && C20548u.bpx().mo45725hX(hT.lwK) && (2 == hT.cxs || hT.cxs == 0))) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", Integer.valueOf(hT.cxs), str);
                if (C20548u.bpy().lqX != null) {
                    C20548u.bpy().lqX.mo45761hZ(hT.lwK);
                }
            }
            if (C27852f.m44279b(c11648b)) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", Long.valueOf(c11648b.field_mac));
                C20495e.m31658Kf(C42992b.m76358ie(c11648b.field_mac));
            }
            AppMethodBeat.m2505o(19226);
            return true;
        } else if (2 == hT.cxs || C30089e.vaw == null || !C30089e.vaw.cUr()) {
            AppMethodBeat.m2505o(19226);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
            AppMethodBeat.m2505o(19226);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: k */
    public final boolean mo35807k(List<C11648b> list, int i) {
        AppMethodBeat.m2504i(19227);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
        if (list.size() == 0) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
            AppMethodBeat.m2505o(19227);
            return false;
        }
        int i2 = -1;
        switch (i) {
            case 1:
                if (this.lso) {
                    this.mHandler.removeCallbacks(this.lsp);
                }
                this.lsp = new C20518c(list);
                this.mHandler.postDelayed(this.lsp, 300000);
                this.lso = true;
                i2 = 2;
                break;
            case 2:
                if (this.lso) {
                    this.mHandler.removeCallbacks(this.lsp);
                    this.lso = false;
                }
                i2 = 0;
                break;
        }
        for (C11648b c11648b : list) {
            C20548u.bpy().mo54568a(new C41266k(c11648b.field_brandName, c11648b.field_deviceType, c11648b.field_deviceID, i2));
        }
        AppMethodBeat.m2505o(19227);
        return true;
    }

    static boolean boG() {
        AppMethodBeat.m2504i(19228);
        LinkedList bpC = C45891ad.boW().bpC();
        if (bpC.isEmpty()) {
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
            AppMethodBeat.m2505o(19228);
            return false;
        }
        C45891ad.bpd().mo7182uI(2);
        Iterator it = bpC.iterator();
        while (it.hasNext()) {
            C11648b c11648b = (C11648b) it.next();
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(c11648b.field_brandName);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", c11648b.field_brandName);
            } else if ((c11648b.field_connStrategy & 4) == 0) {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", Integer.valueOf(c11648b.field_connStrategy));
            } else {
                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", c11648b.field_brandName);
                C45891ad.bpd().mo7178a(c11648b.field_brandName, c11648b.field_mac, 0, true);
            }
        }
        AppMethodBeat.m2505o(19228);
        return true;
    }

    static boolean boH() {
        AppMethodBeat.m2504i(19229);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
        C45891ad.bpd();
        C2971d.m5265gL(false);
        C45891ad.bpd().boF();
        AppMethodBeat.m2505o(19229);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: at */
    public final boolean mo35802at(int i, String str) {
        AppMethodBeat.m2504i(19230);
        C4990ab.m7418v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            AppMethodBeat.m2505o(19230);
            return false;
        }
        C16529b cJ = qX.mo30481cJ(false);
        if (cJ != null) {
            C16536b aej = cJ.aej();
            if (aej != null && aej.aes()) {
                LinkedList<C11648b> Kx = C45891ad.boW().mo45702Kx(str);
                if (aej.fvJ == 1) {
                    LinkedList<C11648b> bpC = C45891ad.boW().bpC();
                    if (bpC.size() != 0) {
                        for (C11648b c11648b : bpC) {
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", Long.valueOf(c11648b.field_mac), c11648b.field_deviceID, c11648b.field_deviceType, Long.valueOf(c11648b.dFq));
                            if (0 != (c11648b.dFq & 1)) {
                                Kx.add(c11648b);
                            }
                        }
                    }
                }
                if (Kx == null) {
                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                    AppMethodBeat.m2505o(19230);
                    return false;
                } else if (Kx.size() == 0) {
                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                    AppMethodBeat.m2505o(19230);
                    return true;
                } else {
                    int i2 = 0;
                    int i3 = 0;
                    for (C11648b c11648b2 : Kx) {
                        if (c11648b2 == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                        } else if (C5046bo.nullAsNil(c11648b2.field_connProto).contains("4")) {
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", c11648b2.field_brandName);
                        } else if ((c11648b2.field_connStrategy & 16) != 0) {
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", c11648b2.field_brandName, Integer.valueOf(c11648b2.field_connStrategy));
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            int i7;
                            if (C5046bo.nullAsNil(c11648b2.field_connProto).contains("1")) {
                                i7 = i2 + 1;
                                if (C42904a.aVF()) {
                                    i4 = 1;
                                    i5 = i3;
                                    i6 = i7;
                                } else {
                                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", c11648b2.field_brandName);
                                    i2 = i7;
                                }
                            } else if (C5046bo.nullAsNil(c11648b2.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                i7 = i3 + 1;
                                if (C42904a.m76178dv(C4996ah.getContext())) {
                                    i4 = 0;
                                    i5 = i7;
                                    i6 = i2;
                                } else {
                                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                    i3 = i7;
                                }
                            } else {
                                i4 = -1;
                                i5 = i3;
                                i6 = i2;
                            }
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", Integer.valueOf(i), c11648b2.field_brandName, c11648b2.field_connProto);
                            if (i == 0) {
                                C2971d bpd = C45891ad.bpd();
                                long j = c11648b2.field_mac;
                                C4990ab.m7417i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", Long.valueOf(j));
                                if (bpd.lrf.containsKey(Long.valueOf(j))) {
                                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                    C7564ap c7564ap = (C7564ap) bpd.lrf.remove(Long.valueOf(j));
                                    if (c7564ap != null) {
                                        c7564ap.stopTimer();
                                    } else {
                                        C4990ab.m7413e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", Long.valueOf(j));
                                    }
                                }
                                if (C20548u.bpx().mo45719hR(c11648b2.field_mac)) {
                                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", c11648b2.field_brandName, Long.valueOf(c11648b2.field_mac));
                                    if (C20548u.bpx().mo45725hX(c11648b2.field_mac)) {
                                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                        C20495e.m31663b(c11648b2.field_brandName, c11648b2.field_url, 2, c11648b2.field_deviceID);
                                        i3 = i5;
                                        i2 = i6;
                                    } else {
                                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                        i3 = i5;
                                        i2 = i6;
                                    }
                                } else if (!C11656d.m19470dI(C4996ah.getContext())) {
                                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                    i3 = i5;
                                    i2 = i6;
                                } else if (C27852f.m44279b(c11648b2)) {
                                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", C42992b.m76358ie(c11648b2.field_mac), c11648b2.field_brandName);
                                    m31660a(c11648b2.field_brandName + c11648b2.field_mac, new C20506a(c11648b2.field_brandName, C42992b.m76358ie(c11648b2.field_mac), c11648b2.field_url, c11648b2.field_deviceID));
                                    mo35800Kg(C42992b.m76358ie(c11648b2.field_mac));
                                    i3 = i5;
                                    i2 = i6;
                                } else {
                                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", C42992b.m76358ie(c11648b2.field_mac), c11648b2.field_brandName);
                                    C45891ad.bpd().mo7182uI(1);
                                    C45891ad.bpd().mo7177a(Long.valueOf(c11648b2.field_mac), c11648b2.field_connStrategy);
                                    C45891ad.bpd().mo7179b(c11648b2.field_brandName, c11648b2.field_mac, i4);
                                    i3 = i5;
                                    i2 = i6;
                                }
                            } else if (i != 1) {
                                if (i == 2) {
                                    if (C27852f.m44279b(c11648b2)) {
                                        C20495e.m31658Kf(C42992b.m76358ie(c11648b2.field_mac));
                                        i3 = i5;
                                        i2 = i6;
                                    } else {
                                        C45891ad.bpd();
                                        C2971d.m5266hH(c11648b2.field_mac);
                                    }
                                }
                                i3 = i5;
                                i2 = i6;
                            } else if (C27852f.m44279b(c11648b2)) {
                                m31660a(c11648b2.field_brandName + c11648b2.field_mac, new C20506a(c11648b2.field_brandName, C42992b.m76358ie(c11648b2.field_mac), c11648b2.field_url, c11648b2.field_deviceID));
                                mo35800Kg(C42992b.m76358ie(c11648b2.field_mac));
                                i3 = i5;
                                i2 = i6;
                            } else {
                                C45891ad.bpd().mo7177a(Long.valueOf(c11648b2.field_mac), c11648b2.field_connStrategy);
                                C45891ad.bpd().mo7179b(c11648b2.field_brandName, c11648b2.field_mac, i4);
                                i3 = i5;
                                i2 = i6;
                            }
                        }
                    }
                    if (i2 + i3 <= 0) {
                        C20495e.m31665cc(str, -1);
                    } else if (!C42904a.aVH()) {
                        C4990ab.m7420w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        C20495e.m31665cc(str, 0);
                    } else if (i3 > 0 && i2 == 0 && !C42904a.m76178dv(C4996ah.getContext())) {
                        C20495e.m31665cc(str, 1);
                    }
                    AppMethodBeat.m2505o(19230);
                    return true;
                }
            }
        }
        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        AppMethodBeat.m2505o(19230);
        return false;
    }

    private static boolean boI() {
        AppMethodBeat.m2504i(19231);
        if (!C42904a.m76178dv(C4996ah.getContext())) {
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.m2505o(19231);
            return false;
        } else if (C42904a.aVH()) {
            AppMethodBeat.m2505o(19231);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
            AppMethodBeat.m2505o(19231);
            return false;
        }
    }

    public static boolean boJ() {
        AppMethodBeat.m2504i(19232);
        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
        if (C20495e.boI()) {
            C45891ad.bpi().boM();
            AppMethodBeat.m2505o(19232);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
        AppMethodBeat.m2505o(19232);
        return false;
    }

    /* renamed from: Kf */
    public static boolean m31658Kf(String str) {
        AppMethodBeat.m2504i(19233);
        C4990ab.m7411d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", str);
        if (!C20495e.boI()) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            AppMethodBeat.m2505o(19233);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            AppMethodBeat.m2505o(19233);
            return false;
        } else {
            C45891ad.bpi();
            C46907h.m89277hH(C42992b.m76346KK(str));
            AppMethodBeat.m2505o(19233);
            return true;
        }
    }

    /* renamed from: Kg */
    public final boolean mo35800Kg(String str) {
        AppMethodBeat.m2504i(19234);
        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
        if (!C20495e.boI()) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            AppMethodBeat.m2505o(19234);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            AppMethodBeat.m2505o(19234);
            return false;
        } else {
            C45891ad.bpi().mo76110a(C42992b.m76346KK(str), new C685340());
            AppMethodBeat.m2505o(19234);
            return true;
        }
    }

    /* renamed from: u */
    public final boolean mo35809u(String str, byte[] bArr) {
        AppMethodBeat.m2504i(19235);
        String str2;
        String str3;
        Object[] objArr;
        if (C5046bo.isNullOrNil(str) || C5046bo.m7540cb(bArr)) {
            str2 = "MicroMsg.exdevice.ExdeviceEventManager";
            str3 = "input error. mac = %s, dataLen = %d";
            objArr = new Object[2];
            objArr[0] = C5046bo.isNullOrNil(str) ? BuildConfig.COMMAND : "mac";
            objArr[1] = Integer.valueOf(C5046bo.m7540cb(bArr) ? 0 : bArr.length);
            C4990ab.m7413e(str2, str3, objArr);
            AppMethodBeat.m2505o(19235);
            return false;
        }
        str2 = "MicroMsg.exdevice.ExdeviceEventManager";
        str3 = "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d";
        objArr = new Object[2];
        objArr[0] = C5046bo.isNullOrNil(str) ? BuildConfig.COMMAND : str;
        objArr[1] = Integer.valueOf(C5046bo.m7540cb(bArr) ? 0 : bArr.length);
        C4990ab.m7413e(str2, str3, objArr);
        long KK = C42992b.m76346KK(str);
        C27860a hU = C45891ad.bpi().lta.mo45722hU(KK);
        if (hU == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            AppMethodBeat.m2505o(19235);
            return false;
        } else if (hU.cxs != 2) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
            AppMethodBeat.m2505o(19235);
            return false;
        } else {
            C45891ad.bpi();
            boolean a = C46907h.m89276a(KK, bArr, new C2050041());
            AppMethodBeat.m2505o(19235);
            return a;
        }
    }

    /* renamed from: c */
    public static boolean m31664c(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(19236);
        String str3;
        String str4;
        Object[] objArr;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.m7540cb(bArr)) {
            str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            str4 = "input error. mac = %s, brandName = %s, dataLen = %d";
            objArr = new Object[3];
            if (C5046bo.isNullOrNil(str)) {
                str = BuildConfig.COMMAND;
            }
            objArr[0] = str;
            if (C5046bo.isNullOrNil(str2)) {
                str2 = BuildConfig.COMMAND;
            }
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(C5046bo.m7540cb(bArr) ? 0 : bArr.length);
            C4990ab.m7413e(str3, str4, objArr);
            AppMethodBeat.m2505o(19236);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d";
        objArr = new Object[3];
        objArr[0] = C5046bo.isNullOrNil(str) ? BuildConfig.COMMAND : str;
        objArr[1] = C5046bo.isNullOrNil(str2) ? BuildConfig.COMMAND : str2;
        objArr[2] = Integer.valueOf(C5046bo.m7540cb(bArr) ? 0 : bArr.length);
        C4990ab.m7411d(str3, str4, objArr);
        C11648b id = C45891ad.boW().mo45710id(C42992b.m76346KK(str));
        if (id == null) {
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", str, str2);
            AppMethodBeat.m2505o(19236);
            return false;
        }
        C20287a at = C20287a.m31370at(bArr);
        if (1 != at.jGw) {
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", Long.valueOf(1), Long.valueOf(at.jGw));
            AppMethodBeat.m2505o(19236);
            return false;
        }
        C24737f c24737f = (C24737f) at;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((C39858b) C1720g.m3528K(C39858b.class)).mo63049b(id.field_deviceID, id.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), c24737f.jIh, "");
        AppMethodBeat.m2505o(19236);
        return true;
    }

    /* renamed from: o */
    public final void mo35808o(String str, String str2, boolean z) {
        LinkedList<C20494b> linkedList;
        AppMethodBeat.m2504i(19237);
        synchronized (this.lrw) {
            try {
                linkedList = new LinkedList(this.lrw);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(19237);
            }
        }
        for (C20494b p : linkedList) {
            p.mo23423p(str, str2, z);
        }
        linkedList.clear();
        for (C20494b p2 : this.lrx.values()) {
            p2.mo23423p(str, str2, z);
        }
        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
        C4883b c41991er = new C41991er();
        c41991er.cyi.cyc = str;
        c41991er.cyi.mac = str2;
        c41991er.cyi.bcU = z;
        C4879a.xxA.mo10048a(c41991er, Looper.getMainLooper());
    }

    /* renamed from: b */
    public static void m31663b(String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(19238);
        C4883b c32596lq = new C32596lq();
        c32596lq.cHu.f15019op = 2;
        c32596lq.cHu.cEN = str;
        c32596lq.cHu.cxs = i;
        c32596lq.cHu.url = str2;
        c32596lq.cHu.ceI = str3;
        C4879a.xxA.mo10048a(c32596lq, Looper.getMainLooper());
        AppMethodBeat.m2505o(19238);
    }

    /* renamed from: cc */
    public static void m31665cc(String str, int i) {
        AppMethodBeat.m2504i(19239);
        C4883b c32596lq = new C32596lq();
        c32596lq.cHu.f15019op = 1;
        c32596lq.cHu.cEN = str;
        c32596lq.cHu.boZ = i;
        C4879a.xxA.mo10048a(c32596lq, Looper.getMainLooper());
        AppMethodBeat.m2505o(19239);
    }

    /* renamed from: d */
    public static void m31666d(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(19240);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", str, str2);
        C4883b c32541eb = new C32541eb();
        c32541eb.cxC.ceI = str;
        c32541eb.cxC.cwz = str2;
        c32541eb.cxC.data = bArr;
        C4879a.xxA.mo10048a(c32541eb, Looper.getMainLooper());
        AppMethodBeat.m2505o(19240);
    }

    /* renamed from: aw */
    public static void m31662aw(String str, boolean z) {
        AppMethodBeat.m2504i(19241);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", str, Boolean.valueOf(z));
        C4883b c32540ea = new C32540ea();
        c32540ea.cxB.ceI = str;
        c32540ea.cxB.cww = z;
        C4879a.xxA.mo10048a(c32540ea, Looper.getMainLooper());
        AppMethodBeat.m2505o(19241);
    }

    /* renamed from: a */
    public final boolean mo35801a(C20494b c20494b) {
        AppMethodBeat.m2504i(19242);
        if (this.lrw.contains(c20494b)) {
            AppMethodBeat.m2505o(19242);
            return false;
        }
        boolean add = this.lrw.add(c20494b);
        AppMethodBeat.m2505o(19242);
        return add;
    }

    /* renamed from: b */
    public final boolean mo35803b(C20494b c20494b) {
        AppMethodBeat.m2504i(19243);
        if (this.lrw.remove(c20494b)) {
            AppMethodBeat.m2505o(19243);
            return true;
        }
        AppMethodBeat.m2505o(19243);
        return false;
    }

    /* renamed from: a */
    private C20494b m31660a(String str, C20494b c20494b) {
        AppMethodBeat.m2504i(19244);
        C20494b c20494b2 = (C20494b) this.lrx.put(str, c20494b);
        AppMethodBeat.m2505o(19244);
        return c20494b2;
    }

    static boolean boK() {
        AppMethodBeat.m2504i(19245);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
        Context context = C4996ah.getContext();
        try {
            C45891ad.bpd().boF();
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", e, "", new Object[0]);
        }
        C25985d.m41479l(new Intent(context, ExDeviceService.class), "exdevice");
        AppMethodBeat.m2505o(19245);
        return true;
    }
}
