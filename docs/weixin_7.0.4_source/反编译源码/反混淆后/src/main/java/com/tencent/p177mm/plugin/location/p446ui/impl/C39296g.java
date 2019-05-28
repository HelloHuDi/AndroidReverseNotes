package com.tencent.p177mm.plugin.location.p446ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26982f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27057d;
import com.tencent.p177mm.plugin.location.model.C28358f;
import com.tencent.p177mm.plugin.location.model.C28366o;
import com.tencent.p177mm.plugin.location.model.C28366o.C28367a;
import com.tencent.p177mm.plugin.location.model.C28366o.C28369b;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.plugin.location.model.C46045d;
import com.tencent.p177mm.plugin.location.model.LocationInfo;
import com.tencent.p177mm.plugin.location.model.p1278a.C21169b;
import com.tencent.p177mm.plugin.location.p446ui.C12403n;
import com.tencent.p177mm.plugin.location.p446ui.C28389m;
import com.tencent.p177mm.plugin.location.p446ui.C28389m.C12402a;
import com.tencent.p177mm.plugin.location.p446ui.C39302l;
import com.tencent.p177mm.plugin.location.p446ui.C39302l.C211865;
import com.tencent.p177mm.plugin.location.p446ui.C39302l.C3357a;
import com.tencent.p177mm.plugin.location.p446ui.C39302l.C393013;
import com.tencent.p177mm.plugin.location.p446ui.C39302l.C393044;
import com.tencent.p177mm.plugin.location.p446ui.C46048i;
import com.tencent.p177mm.plugin.location.p446ui.C46048i.C43244a;
import com.tencent.p177mm.plugin.location.p446ui.C46054k;
import com.tencent.p177mm.plugin.location.p446ui.MyLocationButton;
import com.tencent.p177mm.plugin.location.p446ui.ShareHeader;
import com.tencent.p177mm.plugin.location.p446ui.TipSayingWidget;
import com.tencent.p177mm.plugin.location.p446ui.VolumeMeter;
import com.tencent.p177mm.plugin.location.p734a.C6958a;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.awl;
import com.tencent.p177mm.protocal.protobuf.bku;
import com.tencent.p177mm.protocal.protobuf.bqu;
import com.tencent.p177mm.protocal.protobuf.cie;
import com.tencent.p177mm.protocal.protobuf.cmj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.location.ui.impl.g */
public final class C39296g extends C21182i implements C3357a {
    private C42206a ecy = new C392984();
    private View nMJ;
    private C12402a nOe = new C167771();
    private Button nQD;
    MyLocationButton nQE;
    private TipSayingWidget nQF;
    C28389m nQG;
    C28366o nQH = C39287l.bJy();
    C39302l nQI;
    C46054k nQJ;
    private C46048i nQK;
    private C26443d nQL = C26443d.agz();
    private ShareHeader nQM;
    private String nQN;
    private long nQO = 0;
    private long nQP = 0;
    private C28369b nQQ = new C392992();
    private C28367a nQR = new C392973();
    private HashMap<String, cmj> nQS = new HashMap();
    private WakeLock wakeLock;

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$1 */
    class C167771 implements C12402a {
        C167771() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$8 */
    class C211808 implements OnClickListener {
        C211808() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113677);
            C7060h.pYm.mo8381e(10997, "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            C39296g.this.nQI.bKc();
            AppMethodBeat.m2505o(113677);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$9 */
    class C211819 implements DialogInterface.OnClickListener {
        C211819() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(113678);
            C39296g.this.nQG.mo46370iE(false);
            C39296g.this.nQH.stop();
            C39296g.this.nQH.mo46328xC(2);
            C46054k.bKb();
            C39296g.this.activity.finish();
            AppMethodBeat.m2505o(113678);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$6 */
    class C283796 implements C43244a {
        C283796() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x004b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: PX */
        public final void mo46358PX(String str) {
            AppMethodBeat.m2504i(113675);
            TrackPoint trackPoint = (TrackPoint) C39296g.this.nOL.nLY.getViewByItag(str);
            if (trackPoint != null) {
                C46045d c46045d;
                trackPoint.set2Top();
                C39296g.this.nOL.nLY.invalidate();
                C28389m c28389m = C39296g.this.nQG;
                if (!C5046bo.isNullOrNil(str)) {
                    if (c28389m.nKI == null || !str.equals(c28389m.nKI.vHl)) {
                        if (c28389m.nNM != null && c28389m.nNM.size() > 0) {
                            for (cmj cmj : c28389m.nNM) {
                                if (cmj.vHl.equals(str)) {
                                    c46045d = new C46045d(cmj.xkm.vNH, cmj.xkm.vNI);
                                    break;
                                }
                            }
                        }
                    }
                    c46045d = new C46045d(c28389m.nKI.xkm.vNH, c28389m.nKI.xkm.vNI);
                    if (c46045d != null) {
                        C39296g.this.nOL.nLY.getIController().animateTo(c46045d.nJu, c46045d.nJv);
                    }
                }
                c46045d = null;
                if (c46045d != null) {
                }
            }
            AppMethodBeat.m2505o(113675);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$7 */
    class C283807 implements OnClickListener {
        C283807() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113676);
            C39302l c39302l = C39296g.this.nQI;
            C30379h.m48466d(c39302l.mContext, c39302l.mResources.getString(C25738R.string.cns), "", c39302l.mResources.getString(C25738R.string.f9106pn), c39302l.mResources.getString(C25738R.string.f9076or), new C393013(), new C393044());
            AppMethodBeat.m2505o(113676);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$5 */
    class C392955 implements OnClickListener {
        C392955() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(113674);
            C39296g.this.nQE.bJN();
            C39296g.this.nQG.nNX = true;
            C39296g.this.nQG.mo46365a(C39296g.this.nOL.nLY);
            C39296g.this.nQG.mo46369iD(false);
            C7060h.pYm.mo8381e(10997, "6", "", Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(113674);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$3 */
    class C392973 implements C28367a {
        C392973() {
        }

        public final void ayR() {
            AppMethodBeat.m2504i(113672);
            C39296g c39296g = C39296g.this;
            C5652a c5652a = new C5652a(c39296g.activity);
            c5652a.mo11450PZ(C25738R.string.exx);
            c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(new C211819());
            c5652a.aMb().show();
            AppMethodBeat.m2505o(113672);
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$4 */
    class C392984 implements C42206a {
        C392984() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113673);
            if (z) {
                C4990ab.m7411d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d));
                if (C28358f.m44997x(d) && !C39296g.this.nQG.nNU) {
                    C4990ab.m7410d("MicroMsg.ShareMapUI", "set driving mode");
                    C39296g.this.nQG.nNX = false;
                    C39296g.this.nQG.mo46369iD(true);
                    C39296g.this.nQE.bJO();
                }
                AppMethodBeat.m2505o(113673);
                return true;
            }
            AppMethodBeat.m2505o(113673);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.impl.g$2 */
    class C392992 implements C28369b {
        C392992() {
        }

        public final void bJJ() {
            AppMethodBeat.m2504i(113668);
            C4990ab.m7416i("MicroMsg.ShareMapUI", "onJoinSucess");
            C28366o c28366o = C39296g.this.nQH;
            c28366o.nKK = true;
            c28366o.bJG();
            c28366o.bJH();
            C39296g.this.nQG.mo46370iE(true);
            if (C39296g.this.nQJ != null) {
                C39296g.this.nQJ.bJY();
            }
            AppMethodBeat.m2505o(113668);
        }

        /* renamed from: a */
        public final void mo46330a(bqu bqu) {
            AppMethodBeat.m2504i(113669);
            C39296g.m66975a(C39296g.this, bqu);
            AppMethodBeat.m2505o(113669);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(113670);
            C4990ab.m7419v("MicroMsg.ShareMapUI", "onError type %d msg %s", Integer.valueOf(i), str);
            C7060h.pYm.mo8381e(10997, "7", "", Integer.valueOf(0), Integer.valueOf(0));
            C39302l c39302l = C39296g.this.nQI;
            C4990ab.m7411d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", str);
            Context context = C4996ah.getContext();
            String str2 = null;
            if (!C5046bo.isNullOrNil(str)) {
                str2 = str;
            } else if (i == 0) {
                str2 = context.getString(C25738R.string.cnd);
            } else if (i == 1) {
                str2 = context.getString(C25738R.string.cni);
            } else if (i == 2) {
                str2 = context.getString(C25738R.string.cnj);
            }
            C30379h.m48447a(c39302l.mContext, str2, "", c39302l.mResources.getString(C25738R.string.f9187s6), false, new C211865(i));
            AppMethodBeat.m2505o(113670);
        }

        public final void bJK() {
            AppMethodBeat.m2504i(113671);
            C39296g.this.nQG.mo46370iE(false);
            C39296g.this.nQH.stop();
            C39296g.this.nQH.mo46328xC(3);
            C46054k.bKb();
            C39296g.this.activity.finish();
            C39296g.this.activity.overridePendingTransition(C25738R.anim.f8374cf, C25738R.anim.f8376ch);
            AppMethodBeat.m2505o(113671);
        }
    }

    public final boolean bKn() {
        return true;
    }

    public C39296g(Activity activity) {
        super(activity);
        AppMethodBeat.m2504i(113679);
        AppMethodBeat.m2505o(113679);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(113680);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.ShareMapUI", "onCreate");
        this.nQO = System.currentTimeMillis();
        AppMethodBeat.m2505o(113680);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0281  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bKm() {
        AppMethodBeat.m2504i(113681);
        super.bKm();
        this.wakeLock = ((PowerManager) this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
        if (this.nRp != null) {
            C12403n c12403n = this.nRp;
            c12403n.nOA.setVisibility(4);
            c12403n.isVisible = false;
        }
        findViewById(2131825945).setVisibility(8);
        this.nQE = (MyLocationButton) findViewById(2131824674);
        this.nQE.setProgressBar(this.nOL.nLY);
        this.nQE.bJN();
        this.nQE.setOnClickListener(new C392955());
        this.nMJ = findViewById(2131827536);
        this.nQM = (ShareHeader) findViewById(2131824684);
        this.nQM.setVisibility(0);
        this.nQK = new C46048i(this.activity, this.nQM.getHeaderBar(), this.nMJ, this.nKN, this.nOL.nLY);
        this.nQK.nMP = new C283796();
        this.nQH.nKP = this.nQR;
        if (this.nQG == null) {
            this.nQG = new C28389m(this.activity, this.nOL.nLY, true);
        }
        this.nQG.nOe = this.nOe;
        this.nQG.nNS = false;
        this.nQI = new C39302l(this.activity, this);
        this.nQF = (TipSayingWidget) findViewById(2131824680);
        this.nQD = (Button) findViewById(2131828360);
        this.nQD.setVisibility(0);
        this.nQJ = new C46054k(this.activity, this.nQD);
        this.nQJ.nNB = this.nQK;
        this.nQM.setOnLeftClickListener(new C283807());
        this.nQM.setOnRightClickListener(new C211808());
        ((LocationManager) this.activity.getSystemService(C8741b.LOCATION)).isProviderEnabled("gps");
        C1202f c1202f = this.nQH;
        LocationInfo locationInfo = this.nOJ;
        c1202f.nKS = System.currentTimeMillis();
        c1202f.fwu = C26443d.agz();
        c1202f.fwu.mo44207b(c1202f.ecy, true);
        if (c1202f.nKF == null) {
            c1202f.nKF = C39287l.bJA();
        }
        c1202f.nKF.mo46315a(c1202f.nKU);
        if (locationInfo != null) {
            c1202f.nKJ = locationInfo;
        }
        if (c1202f.cFy) {
            C4990ab.m7416i("MicorMsg.TrackRefreshManager", "start location " + c1202f.nKJ.nJu + " " + c1202f.nKJ.nJv);
        } else {
            c1202f.nKH = 1;
            c1202f.nKI = new cmj();
            c1202f.nKI.xkm = new bku();
            c1202f.nKI.xkm.vNI = -1000.0d;
            c1202f.nKI.xkm.vNH = -1000.0d;
            C4990ab.m7416i("MicorMsg.TrackRefreshManager", "start location imp " + c1202f.nKJ.nJu + " " + c1202f.nKJ.nJv);
            C1720g.m3540Rg().mo14539a((int) C26982f.CTRL_INDEX, c1202f);
            C1720g.m3540Rg().mo14539a(490, c1202f);
            C1720g.m3540Rg().mo14539a((int) C27057d.CTRL_INDEX, c1202f);
            c1202f.chh = false;
            c1202f.cFy = true;
        }
        C28366o c28366o = this.nQH;
        C28369b c28369b = this.nQQ;
        Iterator it = c28366o.nKG.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C28369b) weakReference.get()).equals(c28369b)) {
                break;
            }
        }
        c28366o.nKG.add(new WeakReference(c28369b));
        this.nQN = this.activity.getIntent().getStringExtra("fromWhereShare");
        C4990ab.m7411d("MicroMsg.ShareMapUI", "fromWhere=%s", this.nQN);
        if (this.nQH.bJC()) {
            C4990ab.m7416i("MicroMsg.ShareMapUI", "has join");
            this.nQG.mo46370iE(true);
            this.nQJ.bJY();
            AppMethodBeat.m2505o(113681);
            return;
        }
        int i;
        String Yz;
        C1207m c21169b;
        C28366o c28366o2 = this.nQH;
        String str = this.nKN;
        if (!C5046bo.isNullOrNil(this.nQN)) {
            if (this.nQN.equals("fromBanner")) {
                i = 0;
            } else if (!this.nQN.equals("fromPluginLocation")) {
                if (this.nQN.equals("fromPluginTalk")) {
                    i = 2;
                } else if (this.nQN.equals("fromTrackButton")) {
                    i = 3;
                } else if (this.nQN.equals("fromMessage")) {
                    i = 4;
                }
            }
            C4990ab.m7417i("MicorMsg.TrackRefreshManager", "track join %s", str);
            c28366o2.nKN = str;
            Yz = C1853r.m3846Yz();
            if (!str.contains("@chatroom")) {
                Yz = str;
            } else if (Yz.compareTo(str) > 0) {
                Yz = str + Yz;
            } else {
                Yz = Yz + str;
            }
            c21169b = new C21169b(Yz);
            ((awl) c21169b.ehh.fsG.fsP).Scene = i;
            C1720g.m3540Rg().mo14541a(c21169b, 0);
            AppMethodBeat.m2505o(113681);
        }
        i = 1;
        C4990ab.m7417i("MicorMsg.TrackRefreshManager", "track join %s", str);
        c28366o2.nKN = str;
        Yz = C1853r.m3846Yz();
        if (!str.contains("@chatroom")) {
        }
        c21169b = new C21169b(Yz);
        ((awl) c21169b.ehh.fsG.fsP).Scene = i;
        C1720g.m3540Rg().mo14541a(c21169b, 0);
        AppMethodBeat.m2505o(113681);
    }

    public final void onResume() {
        int i;
        AppMethodBeat.m2504i(113682);
        C4990ab.m7416i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        C28366o c28366o = this.nQH;
        C4990ab.m7410d("MicorMsg.TrackRefreshManager", "resume isPuase:" + c28366o.nKL);
        if (c28366o.nKL) {
            c28366o.nKS = System.currentTimeMillis();
            c28366o.fwu.mo44203a(c28366o.ecy);
            c28366o.nKF.mo46315a(c28366o.nKU);
        }
        c28366o.nKL = false;
        c28366o.bJE();
        c28366o = this.nQH;
        C28354d c28354d = this.nOL.nLY;
        c28366o.nKH = c28366o.nKM;
        C4990ab.m7411d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + c28366o.nKH + " %f %f %d ", Double.valueOf(c28366o.nJu), Double.valueOf(c28366o.nJv), Integer.valueOf(c28366o.nJw));
        if (c28366o.nJu == -1000.0d || c28366o.nJv == -1000.0d || c28366o.nJw == -1) {
            boolean i2 = false;
        } else {
            c28354d.getIController().setCenter(c28366o.nJu, c28366o.nJv);
            c28354d.getIController().setZoom(c28366o.nJw);
            i2 = 1;
        }
        if (i2 != 0) {
            this.nQE.setAnimToSelf(false);
            this.nQE.bJO();
            this.nQG.nNX = false;
            this.nQG.nNR = true;
        }
        c28366o = this.nQH;
        C28354d c28354d2 = this.nOL.nLY;
        if (c28366o.nKQ != -1) {
            c28354d2.getIController().setZoom(c28366o.nKQ);
        }
        if (this.nQL != null) {
            this.nQL.mo44203a(this.ecy);
        }
        if (this.nQG != null) {
            this.nQG.onResume();
        }
        AppMethodBeat.m2505o(113682);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(113683);
        C4990ab.m7416i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        C28366o c28366o = this.nQH;
        C4990ab.m7410d("MicorMsg.TrackRefreshManager", "pause isShared:" + c28366o.nKK);
        if (!c28366o.nKK) {
            c28366o.fwu.mo44208c(c28366o.ecy);
            c28366o.nKF.mo46316b(c28366o.nKU);
            c28366o.nKL = true;
            c28366o.nKR = true;
        }
        c28366o = this.nQH;
        C28354d c28354d = this.nOL.nLY;
        c28366o.nKM = c28366o.nKH;
        c28366o.nKH = 0;
        C4990ab.m7410d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + c28366o.nKM);
        if (c28366o.bJI()) {
            c28366o.nJu = (((double) c28354d.getMapCenterX()) * 1.0d) / 1000000.0d;
            c28366o.nJv = (((double) c28354d.getMapCenterY()) * 1.0d) / 1000000.0d;
            c28366o.nJw = c28354d.getZoom();
        }
        C7060h.pYm.mo8381e(10997, "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.nQO));
        this.nQO = System.currentTimeMillis();
        if (this.nQL != null) {
            this.nQL.mo44208c(this.ecy);
        }
        if (this.nQG != null) {
            this.nQG.onPause();
        }
        AppMethodBeat.m2505o(113683);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(113684);
        super.onDestroy();
        C28366o c28366o = this.nQH;
        C28369b c28369b = this.nQQ;
        Iterator it = c28366o.nKG.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C28369b) weakReference.get()).equals(c28369b)) {
                c28366o.nKG.remove(weakReference);
                break;
            }
        }
        this.nQH.nKP = null;
        if (this.nQJ != null) {
            C46054k c46054k = this.nQJ;
            c46054k.nNA.mo4634b(c46054k);
            VolumeMeter volumeMeter = c46054k.nNn;
            volumeMeter.nOg = true;
            volumeMeter.fAA = false;
            if (volumeMeter.nOk != null) {
                volumeMeter.nOk.getLooper().quit();
                volumeMeter.nOk = null;
            }
        }
        if (this.nQG != null) {
            this.nQG.destroy();
        }
        if (this.nQE != null) {
            C26443d.agz().mo44208c(this.nQE.ecy);
        }
        C4990ab.m7416i("MicroMsg.ShareMapUI", "onDestory");
        AppMethodBeat.m2505o(113684);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKl() {
        AppMethodBeat.m2504i(113685);
        super.bKl();
        AppMethodBeat.m2505o(113685);
    }

    public final void bKd() {
        AppMethodBeat.m2504i(113686);
        this.nQH.nKQ = this.nOL.nLY.getZoom();
        this.activity.finish();
        AppMethodBeat.m2505o(113686);
    }

    private void bKz() {
        AppMethodBeat.m2504i(113687);
        aqX();
        this.nQG.mo46370iE(false);
        this.nQH.stop();
        this.nQH.mo46328xC(3);
        C46054k.bKb();
        this.nQH.nKQ = this.nOL.nLY.getZoom();
        this.activity.finish();
        AppMethodBeat.m2505o(113687);
    }

    public final void bKe() {
        AppMethodBeat.m2504i(113688);
        this.nQG.mo46370iE(false);
        this.nQH.stop();
        this.nQH.mo46328xC(0);
        C46054k.bKb();
        this.activity.finish();
        AppMethodBeat.m2505o(113688);
    }

    /* renamed from: xD */
    public final void mo7765xD(int i) {
        AppMethodBeat.m2504i(113689);
        if (i == 0) {
            C7060h.pYm.mo8381e(10997, "8", "", Integer.valueOf(0), Integer.valueOf(0));
            bKz();
            AppMethodBeat.m2505o(113689);
        } else if (i == 1) {
            C7060h.pYm.mo8381e(10997, "8", "", Integer.valueOf(0), Integer.valueOf(0));
            bKz();
            AppMethodBeat.m2505o(113689);
        } else {
            if (i == 2) {
                bKz();
            }
            AppMethodBeat.m2505o(113689);
        }
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(113690);
        C7060h.pYm.mo8381e(10997, "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        this.nQI.bKc();
        AppMethodBeat.m2505o(113690);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(113691);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(113691);
        return dispatchKeyEvent;
    }

    public final void bKA() {
        AppMethodBeat.m2504i(113692);
        super.bKA();
        if (this.nQG != null) {
            this.nQG.nNX = false;
            this.nQG.mo46369iD(false);
            this.nQE.bJO();
        }
        AppMethodBeat.m2505o(113692);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKB() {
        AppMethodBeat.m2504i(113693);
        super.bKB();
        C7060h.pYm.mo8381e(10997, "1", "", Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.m2505o(113693);
    }

    /* renamed from: a */
    static /* synthetic */ void m66975a(C39296g c39296g, bqu bqu) {
        C6958a c6958a;
        cmj cmj;
        AppMethodBeat.m2504i(113694);
        C4990ab.m7411d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", Boolean.valueOf(c39296g.nQH.chh));
        LinkedList<cmj> linkedList = bqu.wTh;
        LinkedList<cmj> linkedList2 = new LinkedList();
        C6958a PQ = C39287l.bJz().mo36494PQ(c39296g.nKN);
        if (PQ == null) {
            PQ = new C6958a();
            PQ.latitude = -1000.0d;
            PQ.longitude = -1000.0d;
            c6958a = PQ;
        } else {
            c6958a = PQ;
        }
        LinkedList linkedList3 = new LinkedList();
        for (cmj cmj2 : linkedList) {
            linkedList3.add(cmj2.vHl);
        }
        if (!linkedList3.contains(C1853r.m3846Yz())) {
            linkedList3.add(C1853r.m3846Yz());
        }
        C39287l.bJz().mo20559a(c39296g.nKN, linkedList3, c6958a.latitude, c6958a.longitude, c6958a.nJq, "", "");
        for (cmj cmj22 : linkedList) {
            if (Math.abs(cmj22.xkm.vNH) > 180.0d || Math.abs(cmj22.xkm.vNI) > 90.0d) {
                cmj cmj3 = (cmj) c39296g.nQS.get(cmj22.vHl);
                if (cmj3 != null) {
                    linkedList2.add(cmj3);
                    C4990ab.m7417i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", cmj22.vHl, Double.valueOf(cmj22.xkm.vNI), Double.valueOf(cmj22.xkm.vNH), Double.valueOf(cmj3.xkm.vNI), Double.valueOf(cmj3.xkm.vNH));
                } else {
                    C4990ab.m7417i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", cmj22.vHl, Double.valueOf(cmj22.xkm.vNI), Double.valueOf(cmj22.xkm.vNH));
                }
            } else {
                linkedList2.add(cmj22);
            }
        }
        c39296g.nQS.clear();
        for (cmj cmj222 : linkedList2) {
            c39296g.nQS.put(cmj222.vHl, cmj222);
        }
        int size = linkedList2.size();
        ArrayList arrayList = new ArrayList();
        arrayList.add(C1853r.m3846Yz());
        if (size >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("refreshSuccess, count =  ".concat(String.valueOf(size)));
            size = 0;
            while (true) {
                int i = size;
                if (i >= linkedList2.size()) {
                    break;
                }
                cmj222 = (cmj) linkedList2.get(i);
                stringBuilder.append("[" + cmj222.vHl + " ] ");
                stringBuilder.append(cmj222.xkm.wNP + " ");
                stringBuilder.append(cmj222.xkm.vNI + " ");
                stringBuilder.append(cmj222.xkm.vNH + " ");
                arrayList.add(cmj222.vHl);
                size = i + 1;
            }
            C4990ab.m7418v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + stringBuilder.toString());
            if (c39296g.nQG != null) {
                c39296g.nQG.mo46367ci(linkedList2);
            }
        }
        if (c39296g.nQG.nNT) {
            C28389m c28389m = c39296g.nQG;
            cie cie = bqu.wTi;
            if (c28389m.nNW == null) {
                c28389m.nNW = new cie();
            }
            if (cie != null) {
                C4990ab.m7410d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + cie.vNI + " " + cie.vNH);
                c28389m.nNW.wKW = cie.wKW;
                c28389m.nNW.vNI = cie.vNI;
                c28389m.nNW.vNH = cie.vNH;
            }
        }
        c39296g.nQK.mo73942H(arrayList);
        AppMethodBeat.m2505o(113694);
    }
}
