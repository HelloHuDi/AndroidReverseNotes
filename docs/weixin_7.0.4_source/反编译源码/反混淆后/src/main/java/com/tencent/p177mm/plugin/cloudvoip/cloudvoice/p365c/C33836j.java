package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p1480b.C33829a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C27667c.C276682;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C27673l.C27675a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C2818e.C2819a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33830f.C33831a;
import com.tencent.p177mm.plugin.voip.model.C29496c;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.protocal.protobuf.C15385tv;
import com.tencent.p177mm.protocal.protobuf.C30228tu;
import com.tencent.p177mm.protocal.protobuf.C46587ts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.VError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j */
public enum C33836j {
    ;
    
    private String hRT;
    private final C5004al kAa;
    C33841d kAb;
    private C33839a kAc;
    private String kAd;
    private C45814a<C33839a> kAe;
    private C45814a<ArrayList<C33829a>> kAf;
    private C45814a<ArrayList<C33829a>> kAg;
    private C33831a kAh;
    private C33831a kAi;
    private C33831a kAj;
    private C33831a kAk;
    private C33831a kAl;
    private C33831a kAm;
    private C33831a kAn;
    private C33831a kAo;
    private boolean kAp;
    private boolean kAq;
    private C45814a<String> kAr;
    public long kAs;
    private PhoneStateListener kAt;
    private boolean kAu;
    private boolean kAv;
    private boolean kAw;
    private final int kAx;
    public Runnable kAy;
    private final C27673l kzX;
    private final C33830f kzY;
    private final C27667c kzZ;
    private final C2818e kzd;
    private boolean mIsInit;

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$3 */
    class C202603 implements C33831a<String, String> {

        /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$3$1 */
        class C28271 implements Runnable {
            C28271() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135514);
                if (C33836j.this.kAc != C33839a.kBf) {
                    C33836j.this.kAc = C33839a.kBe;
                }
                AppMethodBeat.m2505o(135514);
            }
        }

        C202603() {
        }

        /* renamed from: i */
        public final /* synthetic */ Object mo35501i(int i, Object obj) {
            AppMethodBeat.m2504i(135515);
            String str = (String) obj;
            C4990ab.m7421w("MicroMsg.OpenVoice.OpenVoiceService", "hy: call broken! %d, %s", Integer.valueOf(i), str);
            C33836j.this.mo54393R(new C28271());
            String str2 = "";
            AppMethodBeat.m2505o(135515);
            return str2;
        }

        public final boolean bgp() {
            return false;
        }

        /* renamed from: bP */
        public final /* bridge */ /* synthetic */ byte[] mo35499bP(Object obj) {
            return new byte[0];
        }

        /* renamed from: az */
        public final /* bridge */ /* synthetic */ Object mo35498az(byte[] bArr) {
            return "";
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$4 */
    class C202614 implements C33831a<String, C46587ts> {
        C202614() {
        }

        /* renamed from: az */
        public final /* bridge */ /* synthetic */ Object mo35498az(byte[] bArr) {
            return null;
        }

        /* renamed from: bP */
        public final /* synthetic */ byte[] mo35499bP(Object obj) {
            AppMethodBeat.m2504i(135519);
            byte[] a = C202614.m31332a((C46587ts) obj);
            AppMethodBeat.m2505o(135519);
            return a;
        }

        /* renamed from: a */
        private static byte[] m31332a(C46587ts c46587ts) {
            byte[] toByteArray;
            AppMethodBeat.m2504i(135517);
            if (c46587ts != null) {
                try {
                    toByteArray = c46587ts.toByteArray();
                    AppMethodBeat.m2505o(135517);
                    return toByteArray;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", e, "hy: error when convert to byte array", new Object[0]);
                }
            }
            toByteArray = new byte[0];
            AppMethodBeat.m2505o(135517);
            return toByteArray;
        }

        public final boolean bgp() {
            return true;
        }

        /* renamed from: i */
        public final /* synthetic */ Object mo35501i(final int i, Object obj) {
            int cIt;
            int i2 = 0;
            AppMethodBeat.m2504i(135518);
            C33836j.this.kzZ;
            C38803i.kzQ = C1407g.m2946KK().eoY.getMode();
            C38803i.kzR = C33836j.this.kzZ.kzb.cpu;
            C6828d c6828d = C33836j.this.kzZ.kza;
            if (c6828d.kzq != null) {
                cIt = c6828d.kzq.cIt();
            } else {
                cIt = -1;
            }
            C38803i.kzS = cIt;
            if (C33836j.this.kzZ.kza.kzx) {
                cIt = 1;
            } else {
                cIt = 0;
            }
            C38803i.kzT = cIt;
            C38803i.kzU = C33836j.this.kzZ.kzb.mo4594EO();
            c6828d = C33836j.this.kzZ.kza;
            if (c6828d.kzq != null) {
                C29496c c29496c = c6828d.kzq;
                AudioManager audioManager = (AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (!(audioManager == null || c29496c.aQf == null)) {
                    i2 = audioManager.getStreamVolume(c29496c.aQf.getStreamType());
                }
            } else {
                i2 = -1;
            }
            C38803i.kzV = i2;
            C46587ts c46587ts = new C46587ts();
            c46587ts.kzN = C38803i.kzN;
            c46587ts.kzO = C38803i.kzO;
            c46587ts.kzP = C38803i.kzP;
            c46587ts.kzU = C38803i.kzU;
            c46587ts.kzT = C38803i.kzT;
            c46587ts.kzR = C38803i.kzR;
            c46587ts.kzQ = C38803i.kzQ;
            c46587ts.kzS = C38803i.kzS;
            c46587ts.kzV = C38803i.kzV;
            C33836j.this.mo54393R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(135516);
                    if (C33836j.this.kAb != C33841d.kBo) {
                        C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current not in room");
                        C33836j.this.kAs = -1;
                        C33836j.m55378o(C33836j.this);
                        AppMethodBeat.m2505o(135516);
                        return;
                    }
                    if (C33836j.this.kAe != null && C33836j.this.kAb == C33841d.kBo) {
                        C33836j.this.kAe.mo6170a(-10087, i, "call end", C33836j.this.kAc);
                    }
                    C33836j.this.kAs = -1;
                    C33836j.this.kAb = C33841d.kBm;
                    C33836j.m55378o(C33836j.this);
                    AppMethodBeat.m2505o(135516);
                }
            });
            AppMethodBeat.m2505o(135518);
            return c46587ts;
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$2 */
    class C276722 implements C33831a<C15385tv, String> {
        C276722() {
        }

        /* renamed from: az */
        public final /* synthetic */ Object mo35498az(byte[] bArr) {
            AppMethodBeat.m2504i(135513);
            C15385tv aA = C276722.m43984aA(bArr);
            AppMethodBeat.m2505o(135513);
            return aA;
        }

        /* renamed from: i */
        public final /* synthetic */ Object mo35501i(final int i, Object obj) {
            AppMethodBeat.m2504i(135512);
            final C15385tv c15385tv = (C15385tv) obj;
            C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceService", "hy: on member changed");
            C33836j.this.mo54393R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(135510);
                    C2818e l = C33836j.this.kzd;
                    C15385tv c15385tv = c15385tv;
                    if (c15385tv == null || c15385tv.vEN == null || c15385tv.vEN.size() == 0) {
                        l.kzy.clear();
                    } else {
                        LinkedList linkedList = c15385tv.vEN;
                        l.kzy.clear();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            C30228tu c30228tu = (C30228tu) it.next();
                            C33829a c33829a = new C33829a();
                            c33829a.kyZ = c30228tu.wbi;
                            c33829a.openId = c30228tu.vGs;
                            l.kzy.add(c33829a);
                        }
                    }
                    if (C33836j.this.kAb != C33841d.kBo) {
                        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room. do not notify");
                        AppMethodBeat.m2505o(135510);
                    } else if (i == 0) {
                        C33836j.this.kAf.mo6170a(0, 0, "ok", C33836j.this.kzd.kzy);
                        AppMethodBeat.m2505o(135510);
                    } else {
                        C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceService", "hy: invalid member list change. will ignore");
                        C33836j.this.kAf.mo6170a(-10087, i, "error in member change", null);
                        AppMethodBeat.m2505o(135510);
                    }
                }
            });
            String str = "";
            AppMethodBeat.m2505o(135512);
            return str;
        }

        /* renamed from: aA */
        private static C15385tv m43984aA(byte[] bArr) {
            AppMethodBeat.m2504i(135511);
            C15385tv c15385tv = new C15385tv();
            try {
                c15385tv.parseFrom(bArr);
                AppMethodBeat.m2505o(135511);
                return c15385tv;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", e, "hy: unable to parse from data", new Object[0]);
                AppMethodBeat.m2505o(135511);
                return null;
            }
        }

        public final boolean bgp() {
            return true;
        }

        /* renamed from: bP */
        public final /* bridge */ /* synthetic */ byte[] mo35499bP(Object obj) {
            return new byte[0];
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$5 */
    class C313465 implements C2819a {
        C313465() {
        }

        /* renamed from: v */
        public final void mo6938v(final ArrayList<C33829a> arrayList) {
            AppMethodBeat.m2504i(135521);
            C4990ab.m7419v("MicroMsg.OpenVoice.OpenVoiceService", "hy: current talking members are %s", arrayList);
            C33836j.this.mo54393R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(135520);
                    if (C33836j.this.kAb != C33841d.kBo) {
                        C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: onSpeakerListChanged but not in room!");
                        AppMethodBeat.m2505o(135520);
                        return;
                    }
                    if (C33836j.this.kAg != null) {
                        C33836j.this.kAg.mo6170a(0, 0, "on talklist change", arrayList);
                    }
                    AppMethodBeat.m2505o(135520);
                }
            });
            AppMethodBeat.m2505o(135521);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$a */
    public enum C33839a {
        public static final C33839a kBe = null;
        public static final C33839a kBf = null;
        public static final C33839a kBg = null;
        public static final C33839a kBh = null;
        public static final C33839a kBi = null;
        public static final C33839a kBj = null;
        public static final C33839a kBk = null;
        private static final /* synthetic */ C33839a[] kBl = null;
        public final int bTx;

        public static C33839a valueOf(String str) {
            AppMethodBeat.m2504i(135547);
            C33839a c33839a = (C33839a) Enum.valueOf(C33839a.class, str);
            AppMethodBeat.m2505o(135547);
            return c33839a;
        }

        public static C33839a[] values() {
            AppMethodBeat.m2504i(135546);
            C33839a[] c33839aArr = (C33839a[]) kBl.clone();
            AppMethodBeat.m2505o(135546);
            return c33839aArr;
        }

        static {
            AppMethodBeat.m2504i(135548);
            kBe = new C33839a("ReasonInterrupted", 0, 0);
            kBf = new C33839a("ReasonManual", 1, 1);
            kBg = new C33839a("ReasonDevice", 2, 2);
            kBh = new C33839a("ReasonInCommingCall", 3, 3);
            kBi = new C33839a("ReasonSessionUpdateFailed", 4, 4);
            kBj = new C33839a("ReasonWeappEnterBackground", 5, 5);
            kBk = new C33839a("ReasonUnknown", 6, 100);
            kBl = new C33839a[]{kBe, kBf, kBg, kBh, kBi, kBj, kBk};
            AppMethodBeat.m2505o(135548);
        }

        private C33839a(String str, int i, int i2) {
            this.bTx = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$b */
    static class C33840b implements C45413i<Bundle, Bundle> {
        private C33840b() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(135549);
            Bundle bundle = new Bundle();
            bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, C1720g.m3536RP().mo5240Rz().dur());
            AppMethodBeat.m2505o(135549);
            return bundle;
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$d */
    enum C33841d {
        public static final C33841d kBm = null;
        public static final C33841d kBn = null;
        public static final C33841d kBo = null;
        private static final /* synthetic */ C33841d[] kBp = null;

        private C33841d(String str, int i) {
        }

        public static C33841d valueOf(String str) {
            AppMethodBeat.m2504i(135552);
            C33841d c33841d = (C33841d) Enum.valueOf(C33841d.class, str);
            AppMethodBeat.m2505o(135552);
            return c33841d;
        }

        public static C33841d[] values() {
            AppMethodBeat.m2504i(135551);
            C33841d[] c33841dArr = (C33841d[]) kBp.clone();
            AppMethodBeat.m2505o(135551);
            return c33841dArr;
        }

        static {
            AppMethodBeat.m2504i(135553);
            kBm = new C33841d("NotInRoom", 0);
            kBn = new C33841d("SdkInRoom", 1);
            kBo = new C33841d("InRoom", 2);
            kBp = new C33841d[]{kBm, kBn, kBo};
            AppMethodBeat.m2505o(135553);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$11 */
    class C3384211 extends PhoneStateListener {

        /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$11$1 */
        class C338341 implements Runnable {
            C338341() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135527);
                C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                C33836j.m55346a(C33836j.this, C33839a.kBh);
                AppMethodBeat.m2505o(135527);
            }
        }

        C3384211() {
        }

        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.m2504i(135528);
            super.onCallStateChanged(i, str);
            switch (i) {
                case 1:
                    C33836j.this.mo54393R(new C338341());
                    break;
            }
            AppMethodBeat.m2505o(135528);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$1 */
    public class C338441 implements Runnable {
        final /* synthetic */ String hxh;
        final /* synthetic */ String kAA;
        final /* synthetic */ String kAB;
        final /* synthetic */ String kAC;
        final /* synthetic */ int kAD;
        final /* synthetic */ String kAE;
        final /* synthetic */ C45814a kAF;
        final /* synthetic */ C45814a kAG;
        final /* synthetic */ C45814a kAH;
        final /* synthetic */ C45814a kAI;

        public C338441(String str, String str2, String str3, String str4, int i, String str5, C45814a c45814a, C45814a c45814a2, C45814a c45814a3, C45814a c45814a4) {
            this.hxh = str;
            this.kAA = str2;
            this.kAB = str3;
            this.kAC = str4;
            this.kAD = i;
            this.kAE = str5;
            this.kAF = c45814a;
            this.kAG = c45814a2;
            this.kAH = c45814a3;
            this.kAI = c45814a4;
        }

        public final void run() {
            AppMethodBeat.m2504i(135509);
            C33836j.m55356a(C33836j.this, this.hxh, this.kAA, this.kAB, this.kAC, this.kAD, this.kAE, this.kAF, this.kAG, this.kAH, this.kAI);
            AppMethodBeat.m2505o(135509);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$13 */
    class C3384713 implements C33831a<String, String> {

        /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$13$1 */
        class C276701 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$13$1$1 */
            class C276711 implements C27675a {
                C276711() {
                }

                /* renamed from: a */
                public final void mo45520a(int i, int i2, String str, C11413k c11413k, boolean z) {
                    AppMethodBeat.m2504i(135531);
                    if (i == 0 && i2 == 0 && c11413k != null && c11413k.isValid()) {
                        C33832g.m55331HX(c11413k.kBq);
                        AppMethodBeat.m2505o(135531);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: refresh session key error!");
                    C33836j.m55346a(C33836j.this, C33839a.kBi);
                    AppMethodBeat.m2505o(135531);
                }
            }

            C276701() {
            }

            public final void run() {
                AppMethodBeat.m2504i(135532);
                if (C5046bo.isNullOrNil(C33836j.this.hRT) || C33836j.this.kAb == C33841d.kBm) {
                    C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room now");
                    AppMethodBeat.m2505o(135532);
                    return;
                }
                C33836j.this.kzX.reset(C33836j.this.hRT);
                C33836j.this.kzX.mo45521a(C33836j.this.hRT, new C276711());
                AppMethodBeat.m2505o(135532);
            }
        }

        C3384713() {
        }

        public final boolean bgp() {
            return true;
        }

        /* renamed from: i */
        public final /* synthetic */ Object mo35501i(int i, Object obj) {
            AppMethodBeat.m2504i(135533);
            C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: session key expired!! reset session key");
            C33836j.this.mo54393R(new C276701());
            String str = "";
            AppMethodBeat.m2505o(135533);
            return str;
        }

        /* renamed from: bP */
        public final /* bridge */ /* synthetic */ byte[] mo35499bP(Object obj) {
            return new byte[0];
        }

        /* renamed from: az */
        public final /* synthetic */ Object mo35498az(byte[] bArr) {
            AppMethodBeat.m2504i(135534);
            String str = new String(bArr);
            AppMethodBeat.m2505o(135534);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$7 */
    class C338487 implements Runnable {
        C338487() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135523);
            if (C33836j.this.kAb == C33841d.kBm && !C33836j.this.kAp) {
                C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", Long.valueOf(180000));
                C33836j.m55381r(C33836j.this);
            }
            AppMethodBeat.m2505o(135523);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$c */
    static class C33850c implements C45413i<Bundle, Bundle> {
        private C33850c() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(135550);
            Bundle bundle = new Bundle();
            boolean z = C35973a.m59176Oo() || C29488d.cLw() || C29488d.cLx() || C29488d.cLy();
            bundle.putBoolean("is_in_voip", z);
            AppMethodBeat.m2505o(135550);
            return bundle;
        }
    }

    static {
        AppMethodBeat.m2505o(135586);
    }

    private C33836j(String str) {
        AppMethodBeat.m2504i(135556);
        this.kAs = -1;
        this.kAt = new C3384211();
        this.kAu = false;
        this.kAv = false;
        this.kAw = false;
        this.kAx = -9999;
        this.kAy = new C338487();
        this.kzX = new C27673l();
        this.kzY = new C33830f();
        this.kzd = new C2818e();
        this.kzZ = new C27667c(this.kzd);
        this.kAa = new C5004al("openvoice_voip_worker");
        this.kAb = C33841d.kBm;
        this.hRT = null;
        Bundle bundle = (Bundle) C9549f.m17010a("com.tencent.mm", null, C33840b.class);
        if (bundle != null) {
            C4990ab.m7419v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", bundle.getString(DeviceRequestsHelper.DEVICE_INFO_PARAM, ""));
            C1427q.m3050ku(r0);
        } else {
            C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
        }
        this.kAp = false;
        this.mIsInit = false;
        this.kAq = false;
        this.kAr = null;
        AppMethodBeat.m2505o(135556);
    }

    /* renamed from: a */
    private void m55351a(C45814a<ArrayList<C33829a>> c45814a, int i, int i2, String str) {
        AppMethodBeat.m2504i(135557);
        this.kAp = false;
        if (i == 0 && i2 == 0) {
            this.kAb = C33841d.kBo;
        }
        synchronized (this.kzY) {
            try {
                this.kzY.mo54389b(1, this.kAl);
                this.kzY.mo54389b(2, this.kAm);
                this.kzY.mo54389b(4, this.kAn);
                this.kzY.mo54389b(5, this.kAo);
                this.kAl = null;
                this.kAm = null;
                this.kAn = null;
                this.kAo = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(135557);
                }
            }
        }
        ArrayList arrayList = this.kzd.kzy;
        if (c45814a != null) {
            c45814a.mo6170a(i, i2, str, arrayList);
        }
        AppMethodBeat.m2505o(135557);
    }

    /* renamed from: HY */
    private int m55342HY(String str) {
        AppMethodBeat.m2504i(135558);
        int a = C33832g.m55333a(this.kAd, this.hRT, str, this.kzY.mo54390fT(true));
        this.kAk = new C3384713();
        this.kzY.mo54388a(8, this.kAk);
        AppMethodBeat.m2505o(135558);
        return a;
    }

    private void bgs() {
        this.kAu = false;
        this.kAv = false;
        this.kAw = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m55350a(C45814a<ArrayList<C33829a>> c45814a) {
        int i = 1;
        AppMethodBeat.m2504i(135559);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", Boolean.valueOf(this.kAu), Boolean.valueOf(this.kAv), Boolean.valueOf(this.kAw));
        if (this.kAu && this.kAw && this.kAv) {
            int b;
            if (this.kAq) {
                C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
                m55351a(c45814a, -10086, -9, "interrupted because already cancelled or entered background");
                b = m55359b(this.kAc);
                if (this.kAr != null) {
                    if (b == 0) {
                        this.kAr.mo6170a(0, 0, "ok", "");
                    } else {
                        this.kAr.mo6170a(-10086, -17, "exit failed", "");
                    }
                }
                this.kAq = false;
                this.kAr = null;
                AppMethodBeat.m2505o(135559);
                return;
            }
            boolean z;
            TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
            Bundle bundle = (Bundle) C9549f.m17010a("com.tencent.mm", null, C33850c.class);
            if (bundle != null) {
                z = bundle.getBoolean("is_in_voip");
            } else {
                z = false;
            }
            if (z || telephonyManager.getCallState() == 2 || telephonyManager.getCallState() == 1) {
                b = 1;
            } else {
                b = 0;
            }
            if (b != 0) {
                m55362b((C45814a) c45814a);
                AppMethodBeat.m2505o(135559);
                return;
            }
            int cIs;
            C27667c c27667c = this.kzZ;
            if (c27667c.kzf != 2) {
                C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
                b = 0;
            } else if (c27667c.kza.mo15103a(new C276682(), c27667c.mSampleRate, c27667c.mChannels, c27667c.kzn) <= 0) {
                c27667c.kzj = 1;
                b = 0;
            } else {
                b = 1;
            }
            boolean EL = this.kzZ.mo45517EL();
            if (b != 0 && EL) {
                i = 0;
            }
            C38803i.kzN = i;
            if (b == 0) {
                C6828d c6828d = this.kzZ.kza;
                if (c6828d.kzq != null) {
                    cIs = c6828d.kzq.cIs();
                    C38803i.kzP = cIs;
                    if (EL) {
                        cIs = this.kzZ.kzb.cpq;
                    } else {
                        cIs = 0;
                    }
                    C38803i.kzO = cIs;
                    if (b == 0 && EL) {
                        m55351a(c45814a, 0, 0, "ok");
                        AppMethodBeat.m2505o(135559);
                        return;
                    }
                    m55362b((C45814a) c45814a);
                }
            }
            cIs = 0;
            C38803i.kzP = cIs;
            if (EL) {
            }
            C38803i.kzO = cIs;
            if (b == 0) {
            }
            m55362b((C45814a) c45814a);
        }
        AppMethodBeat.m2505o(135559);
    }

    /* renamed from: b */
    private void m55362b(C45814a<ArrayList<C33829a>> c45814a) {
        AppMethodBeat.m2504i(135560);
        m55351a(c45814a, -10086, -7, "start audio device failed");
        m55359b(C33839a.kBg);
        AppMethodBeat.m2505o(135560);
    }

    private void bgt() {
        AppMethodBeat.m2504i(135561);
        this.kzd.kzy.clear();
        C2818e c2818e = this.kzd;
        synchronized (c2818e.kzA) {
            try {
                c2818e.kzA.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(135561);
            }
        }
        if (c2818e.kzB != null) {
            c2818e.kzB.cancel();
        }
        C27667c c27667c = this.kzZ;
        if (c27667c.kza != null) {
            C6828d c6828d = c27667c.kza;
            synchronized (c6828d.kzr) {
                try {
                    C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlay, isStart: %s %s", Boolean.valueOf(c6828d.cFy), Integer.valueOf(c6828d.hashCode()));
                    if (c6828d.cFy) {
                        C29496c c29496c = c6828d.kzq;
                        if (c29496c != null) {
                            c6828d.kzw.evE = SystemClock.elapsedRealtime();
                            c29496c.cIr();
                            C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlaying cost: " + c6828d.kzw.mo4908Mr());
                            c29496c.cIo();
                            c6828d.cFy = false;
                            c6828d.kzq = null;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(135561);
                    }
                }
            }
        }
        c27667c.kzm = false;
        if (c27667c.kzb != null) {
            c27667c.kzb.mo4590EB();
            c27667c.kzb = null;
            C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "finish pauseRecord");
        }
        c27667c.kzf = C27667c.kze;
        C1406a c1406a = c27667c.kza;
        C1407g.m2946KK().mo4825La();
        C1407g.m2946KK().setMode(0);
        c1406a.kzs.mo26277fa(C4996ah.getContext());
        C1407g.m2946KK().mo4818KN();
        C1407g.m2946KK().mo4829b(c1406a);
        c1406a.gar.mo73178Mm();
        this.kAe = null;
        this.kAf = null;
        this.kAg = null;
        synchronized (this.kzY) {
            try {
                this.kzY.mo54389b(6, this.kAh);
                this.kzY.mo54389b(7, this.kAi);
                this.kzY.mo54389b(3, this.kAj);
                this.kzY.mo54389b(8, this.kAk);
                this.kAh = null;
                this.kAi = null;
                this.kAj = null;
                this.kAk = null;
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.m2505o(135561);
                }
            }
        }
    }

    /* renamed from: R */
    public final void mo54393R(Runnable runnable) {
        AppMethodBeat.m2504i(135562);
        if (Thread.currentThread() == this.kAa.oAl.getLooper().getThread()) {
            runnable.run();
            AppMethodBeat.m2505o(135562);
            return;
        }
        this.kAa.mo10302aa(runnable);
        AppMethodBeat.m2505o(135562);
    }

    /* renamed from: S */
    private void m55344S(Runnable runnable) {
        AppMethodBeat.m2504i(135563);
        this.kAa.mo10310m(runnable, 180000);
        AppMethodBeat.m2505o(135563);
    }

    /* renamed from: a */
    public final void mo54394a(final C45814a<String> c45814a, final C33839a c33839a) {
        AppMethodBeat.m2504i(135564);
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
        mo54393R(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(135522);
                int a = C33836j.m55346a(C33836j.this, c33839a);
                if (a == -9999) {
                    C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
                    C33836j.this.kAr = c45814a;
                    AppMethodBeat.m2505o(135522);
                    return;
                }
                if (c45814a != null) {
                    if (a == 0) {
                        c45814a.mo6170a(0, 0, "", "");
                        AppMethodBeat.m2505o(135522);
                        return;
                    }
                    c45814a.mo6170a(-10086, -17, "exit failed", "");
                }
                AppMethodBeat.m2505o(135522);
            }
        });
        AppMethodBeat.m2505o(135564);
    }

    /* renamed from: a */
    private static int m55345a(C33839a c33839a) {
        AppMethodBeat.m2504i(135565);
        switch (c33839a) {
            case kBi:
            case kBk:
            case kBe:
                AppMethodBeat.m2505o(135565);
                return 0;
            case kBf:
                AppMethodBeat.m2505o(135565);
                return 1;
            case kBh:
                AppMethodBeat.m2505o(135565);
                return 6;
            case kBg:
                AppMethodBeat.m2505o(135565);
                return 8;
            case kBj:
                AppMethodBeat.m2505o(135565);
                return 7;
            default:
                AppMethodBeat.m2505o(135565);
                return 0;
        }
    }

    /* renamed from: b */
    private int m55359b(C33839a c33839a) {
        AppMethodBeat.m2504i(135566);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", c33839a);
        this.kAc = c33839a;
        if (this.kAp) {
            C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
            this.kAq = true;
            AppMethodBeat.m2505o(135566);
            return -9999;
        } else if (this.kAb == C33841d.kBm) {
            C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
            AppMethodBeat.m2505o(135566);
            return 0;
        } else {
            int tB = C33832g.m55338tB(C33836j.m55345a(c33839a));
            bgu();
            AppMethodBeat.m2505o(135566);
            return tB;
        }
    }

    private void bgu() {
        AppMethodBeat.m2504i(135567);
        m55344S(this.kAy);
        AppMethodBeat.m2505o(135567);
    }

    /* renamed from: fU */
    private int m55369fU(boolean z) {
        AppMethodBeat.m2504i(135568);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", Boolean.valueOf(z));
        this.kzX.reset(this.hRT);
        C38803i.kzN = 0;
        C38803i.kzO = 0;
        C38803i.kzP = 0;
        C38803i.kzQ = 0;
        C38803i.kzR = 0;
        C38803i.kzS = 0;
        C38803i.kzT = 0;
        C38803i.kzU = 0;
        C38803i.kzV = 0;
        this.hRT = null;
        this.kAd = null;
        bgt();
        this.mIsInit = false;
        C33833h c33833h = C33833h.kzJ;
        C33833h.bgr();
        if (z) {
            int bgq = C33832g.bgq();
            AppMethodBeat.m2505o(135568);
            return bgq;
        }
        this.kzY.mo54390fT(false);
        TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(this.kAt, 0);
        }
        AppMethodBeat.m2505o(135568);
        return 0;
    }

    /* renamed from: a */
    public final void mo54395a(final boolean z, final C45814a<String> c45814a) {
        AppMethodBeat.m2504i(135569);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", Boolean.valueOf(z));
        mo54393R(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(135524);
                if (C33836j.this.kAb != C33841d.kBo) {
                    C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
                    if (c45814a != null) {
                        c45814a.mo6170a(-10086, VError.ERROR_FACE_TXT_INIT, "not in room", "");
                        AppMethodBeat.m2505o(135524);
                        return;
                    }
                }
                C33836j.this.kzZ.kzm = z;
                if (c45814a != null) {
                    c45814a.mo6170a(0, 0, "ok", "");
                }
                AppMethodBeat.m2505o(135524);
            }
        });
        AppMethodBeat.m2505o(135569);
    }

    /* renamed from: b */
    public final void mo54396b(final boolean z, final C45814a<String> c45814a) {
        AppMethodBeat.m2504i(135570);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", Boolean.valueOf(z));
        mo54393R(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.m2504i(135525);
                if (C33836j.this.kAb != C33841d.kBo) {
                    C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
                    if (c45814a != null) {
                        c45814a.mo6170a(-10086, VError.ERROR_FACE_TXT_INIT, "not in room", "");
                        AppMethodBeat.m2505o(135525);
                        return;
                    }
                }
                C27667c k = C33836j.this.kzZ;
                boolean z = z;
                if (k.kzb != null) {
                    k.kzb.mo4597bs(z);
                    i = 1;
                } else {
                    i = 0;
                }
                if (c45814a != null) {
                    if (i != 0) {
                        c45814a.mo6170a(0, 0, "ok", "");
                        AppMethodBeat.m2505o(135525);
                        return;
                    }
                    c45814a.mo6170a(-10086, -15, "set mute failed", "");
                }
                AppMethodBeat.m2505o(135525);
            }
        });
        AppMethodBeat.m2505o(135570);
    }

    /* renamed from: a */
    static boolean m55357a(C33829a c33829a) {
        AppMethodBeat.m2504i(135571);
        if (C33832g.m55337tA(c33829a.kyZ) == 1) {
            AppMethodBeat.m2505o(135571);
            return true;
        }
        AppMethodBeat.m2505o(135571);
        return false;
    }

    /* renamed from: t */
    static void m55382t(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(135572);
        C33832g.m55336s(bArr, i, i2);
        AppMethodBeat.m2505o(135572);
    }

    /* renamed from: f */
    static int m55367f(int i, byte[] bArr, int i2) {
        AppMethodBeat.m2504i(135573);
        int e = C33832g.m55334e(i, bArr, i2);
        AppMethodBeat.m2505o(135573);
        return e;
    }

    /* renamed from: P */
    static int m55343P(byte[] bArr, int i) {
        AppMethodBeat.m2504i(135574);
        int O = C33832g.m55332O(bArr, i);
        AppMethodBeat.m2505o(135574);
        return O;
    }

    /* renamed from: tF */
    static void m55383tF(int i) {
        AppMethodBeat.m2504i(135575);
        C33832g.m55339tC(i);
        AppMethodBeat.m2505o(135575);
    }
}
