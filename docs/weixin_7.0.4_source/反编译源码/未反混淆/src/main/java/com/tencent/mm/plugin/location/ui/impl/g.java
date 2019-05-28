package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.a.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends i implements a {
    private b.a ecy = new b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113673);
            if (z) {
                ab.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d));
                if (f.x(d) && !g.this.nQG.nNU) {
                    ab.d("MicroMsg.ShareMapUI", "set driving mode");
                    g.this.nQG.nNX = false;
                    g.this.nQG.iD(true);
                    g.this.nQE.bJO();
                }
                AppMethodBeat.o(113673);
                return true;
            }
            AppMethodBeat.o(113673);
            return false;
        }
    };
    private View nMJ;
    private m.a nOe = new m.a() {
    };
    private Button nQD;
    MyLocationButton nQE;
    private TipSayingWidget nQF;
    m nQG;
    o nQH = l.bJy();
    com.tencent.mm.plugin.location.ui.l nQI;
    k nQJ;
    private i nQK;
    private d nQL = d.agz();
    private ShareHeader nQM;
    private String nQN;
    private long nQO = 0;
    private long nQP = 0;
    private o.b nQQ = new o.b() {
        public final void bJJ() {
            AppMethodBeat.i(113668);
            ab.i("MicroMsg.ShareMapUI", "onJoinSucess");
            o oVar = g.this.nQH;
            oVar.nKK = true;
            oVar.bJG();
            oVar.bJH();
            g.this.nQG.iE(true);
            if (g.this.nQJ != null) {
                g.this.nQJ.bJY();
            }
            AppMethodBeat.o(113668);
        }

        public final void a(bqu bqu) {
            AppMethodBeat.i(113669);
            g.a(g.this, bqu);
            AppMethodBeat.o(113669);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.i(113670);
            ab.v("MicroMsg.ShareMapUI", "onError type %d msg %s", Integer.valueOf(i), str);
            h.pYm.e(10997, "7", "", Integer.valueOf(0), Integer.valueOf(0));
            com.tencent.mm.plugin.location.ui.l lVar = g.this.nQI;
            ab.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", str);
            Context context = ah.getContext();
            String str2 = null;
            if (!bo.isNullOrNil(str)) {
                str2 = str;
            } else if (i == 0) {
                str2 = context.getString(R.string.cnd);
            } else if (i == 1) {
                str2 = context.getString(R.string.cni);
            } else if (i == 2) {
                str2 = context.getString(R.string.cnj);
            }
            com.tencent.mm.ui.base.h.a(lVar.mContext, str2, "", lVar.mResources.getString(R.string.s6), false, new com.tencent.mm.plugin.location.ui.l.AnonymousClass5(i));
            AppMethodBeat.o(113670);
        }

        public final void bJK() {
            AppMethodBeat.i(113671);
            g.this.nQG.iE(false);
            g.this.nQH.stop();
            g.this.nQH.xC(3);
            k.bKb();
            g.this.activity.finish();
            g.this.activity.overridePendingTransition(R.anim.cf, R.anim.ch);
            AppMethodBeat.o(113671);
        }
    };
    private o.a nQR = new o.a() {
        public final void ayR() {
            AppMethodBeat.i(113672);
            g gVar = g.this;
            c.a aVar = new c.a(gVar.activity);
            aVar.PZ(R.string.exx);
            aVar.Qc(R.string.s6).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(113678);
                    g.this.nQG.iE(false);
                    g.this.nQH.stop();
                    g.this.nQH.xC(2);
                    k.bKb();
                    g.this.activity.finish();
                    AppMethodBeat.o(113678);
                }
            });
            aVar.aMb().show();
            AppMethodBeat.o(113672);
        }
    };
    private HashMap<String, cmj> nQS = new HashMap();
    private WakeLock wakeLock;

    public final boolean bKn() {
        return true;
    }

    public g(Activity activity) {
        super(activity);
        AppMethodBeat.i(113679);
        AppMethodBeat.o(113679);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(113680);
        super.onCreate(bundle);
        ab.i("MicroMsg.ShareMapUI", "onCreate");
        this.nQO = System.currentTimeMillis();
        AppMethodBeat.o(113680);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0281  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bKm() {
        AppMethodBeat.i(113681);
        super.bKm();
        this.wakeLock = ((PowerManager) this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
        if (this.nRp != null) {
            n nVar = this.nRp;
            nVar.nOA.setVisibility(4);
            nVar.isVisible = false;
        }
        findViewById(R.id.d80).setVisibility(8);
        this.nQE = (MyLocationButton) findViewById(R.id.c_m);
        this.nQE.setProgressBar(this.nOL.nLY);
        this.nQE.bJN();
        this.nQE.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113674);
                g.this.nQE.bJN();
                g.this.nQG.nNX = true;
                g.this.nQG.a(g.this.nOL.nLY);
                g.this.nQG.iD(false);
                h.pYm.e(10997, "6", "", Integer.valueOf(0), Integer.valueOf(0));
                AppMethodBeat.o(113674);
            }
        });
        this.nMJ = findViewById(R.id.ed0);
        this.nQM = (ShareHeader) findViewById(R.id.c_w);
        this.nQM.setVisibility(0);
        this.nQK = new i(this.activity, this.nQM.getHeaderBar(), this.nMJ, this.nKN, this.nOL.nLY);
        this.nQK.nMP = new i.a() {
            /* JADX WARNING: Removed duplicated region for block: B:10:0x004b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void PX(String str) {
                AppMethodBeat.i(113675);
                TrackPoint trackPoint = (TrackPoint) g.this.nOL.nLY.getViewByItag(str);
                if (trackPoint != null) {
                    com.tencent.mm.plugin.location.model.d dVar;
                    trackPoint.set2Top();
                    g.this.nOL.nLY.invalidate();
                    m mVar = g.this.nQG;
                    if (!bo.isNullOrNil(str)) {
                        if (mVar.nKI == null || !str.equals(mVar.nKI.vHl)) {
                            if (mVar.nNM != null && mVar.nNM.size() > 0) {
                                for (cmj cmj : mVar.nNM) {
                                    if (cmj.vHl.equals(str)) {
                                        dVar = new com.tencent.mm.plugin.location.model.d(cmj.xkm.vNH, cmj.xkm.vNI);
                                        break;
                                    }
                                }
                            }
                        }
                        dVar = new com.tencent.mm.plugin.location.model.d(mVar.nKI.xkm.vNH, mVar.nKI.xkm.vNI);
                        if (dVar != null) {
                            g.this.nOL.nLY.getIController().animateTo(dVar.nJu, dVar.nJv);
                        }
                    }
                    dVar = null;
                    if (dVar != null) {
                    }
                }
                AppMethodBeat.o(113675);
            }
        };
        this.nQH.nKP = this.nQR;
        if (this.nQG == null) {
            this.nQG = new m(this.activity, this.nOL.nLY, true);
        }
        this.nQG.nOe = this.nOe;
        this.nQG.nNS = false;
        this.nQI = new com.tencent.mm.plugin.location.ui.l(this.activity, this);
        this.nQF = (TipSayingWidget) findViewById(R.id.c_s);
        this.nQD = (Button) findViewById(R.id.ez_);
        this.nQD.setVisibility(0);
        this.nQJ = new k(this.activity, this.nQD);
        this.nQJ.nNB = this.nQK;
        this.nQM.setOnLeftClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113676);
                com.tencent.mm.plugin.location.ui.l lVar = g.this.nQI;
                com.tencent.mm.ui.base.h.d(lVar.mContext, lVar.mResources.getString(R.string.cns), "", lVar.mResources.getString(R.string.pn), lVar.mResources.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(113555);
                        if (l.this.nNK != null) {
                            l.this.nNK.bKe();
                        }
                        AppMethodBeat.o(113555);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(113556);
                        h.pYm.e(10997, "18", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                        AppMethodBeat.o(113556);
                    }
                });
                AppMethodBeat.o(113676);
            }
        });
        this.nQM.setOnRightClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113677);
                h.pYm.e(10997, "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                g.this.nQI.bKc();
                AppMethodBeat.o(113677);
            }
        });
        ((LocationManager) this.activity.getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps");
        com.tencent.mm.ai.f fVar = this.nQH;
        LocationInfo locationInfo = this.nOJ;
        fVar.nKS = System.currentTimeMillis();
        fVar.fwu = d.agz();
        fVar.fwu.b(fVar.ecy, true);
        if (fVar.nKF == null) {
            fVar.nKF = l.bJA();
        }
        fVar.nKF.a(fVar.nKU);
        if (locationInfo != null) {
            fVar.nKJ = locationInfo;
        }
        if (fVar.cFy) {
            ab.i("MicorMsg.TrackRefreshManager", "start location " + fVar.nKJ.nJu + " " + fVar.nKJ.nJv);
        } else {
            fVar.nKH = 1;
            fVar.nKI = new cmj();
            fVar.nKI.xkm = new bku();
            fVar.nKI.xkm.vNI = -1000.0d;
            fVar.nKI.xkm.vNH = -1000.0d;
            ab.i("MicorMsg.TrackRefreshManager", "start location imp " + fVar.nKJ.nJu + " " + fVar.nKJ.nJv);
            com.tencent.mm.kernel.g.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX, fVar);
            com.tencent.mm.kernel.g.Rg().a(490, fVar);
            com.tencent.mm.kernel.g.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.p.d.CTRL_INDEX, fVar);
            fVar.chh = false;
            fVar.cFy = true;
        }
        o oVar = this.nQH;
        o.b bVar = this.nQQ;
        Iterator it = oVar.nKG.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((o.b) weakReference.get()).equals(bVar)) {
                break;
            }
        }
        oVar.nKG.add(new WeakReference(bVar));
        this.nQN = this.activity.getIntent().getStringExtra("fromWhereShare");
        ab.d("MicroMsg.ShareMapUI", "fromWhere=%s", this.nQN);
        if (this.nQH.bJC()) {
            ab.i("MicroMsg.ShareMapUI", "has join");
            this.nQG.iE(true);
            this.nQJ.bJY();
            AppMethodBeat.o(113681);
            return;
        }
        int i;
        String Yz;
        com.tencent.mm.ai.m bVar2;
        o oVar2 = this.nQH;
        String str = this.nKN;
        if (!bo.isNullOrNil(this.nQN)) {
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
            ab.i("MicorMsg.TrackRefreshManager", "track join %s", str);
            oVar2.nKN = str;
            Yz = r.Yz();
            if (!str.contains("@chatroom")) {
                Yz = str;
            } else if (Yz.compareTo(str) > 0) {
                Yz = str + Yz;
            } else {
                Yz = Yz + str;
            }
            bVar2 = new com.tencent.mm.plugin.location.model.a.b(Yz);
            ((awl) bVar2.ehh.fsG.fsP).Scene = i;
            com.tencent.mm.kernel.g.Rg().a(bVar2, 0);
            AppMethodBeat.o(113681);
        }
        i = 1;
        ab.i("MicorMsg.TrackRefreshManager", "track join %s", str);
        oVar2.nKN = str;
        Yz = r.Yz();
        if (!str.contains("@chatroom")) {
        }
        bVar2 = new com.tencent.mm.plugin.location.model.a.b(Yz);
        ((awl) bVar2.ehh.fsG.fsP).Scene = i;
        com.tencent.mm.kernel.g.Rg().a(bVar2, 0);
        AppMethodBeat.o(113681);
    }

    public final void onResume() {
        int i;
        AppMethodBeat.i(113682);
        ab.i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        o oVar = this.nQH;
        ab.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + oVar.nKL);
        if (oVar.nKL) {
            oVar.nKS = System.currentTimeMillis();
            oVar.fwu.a(oVar.ecy);
            oVar.nKF.a(oVar.nKU);
        }
        oVar.nKL = false;
        oVar.bJE();
        oVar = this.nQH;
        com.tencent.mm.plugin.k.d dVar = this.nOL.nLY;
        oVar.nKH = oVar.nKM;
        ab.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + oVar.nKH + " %f %f %d ", Double.valueOf(oVar.nJu), Double.valueOf(oVar.nJv), Integer.valueOf(oVar.nJw));
        if (oVar.nJu == -1000.0d || oVar.nJv == -1000.0d || oVar.nJw == -1) {
            boolean i2 = false;
        } else {
            dVar.getIController().setCenter(oVar.nJu, oVar.nJv);
            dVar.getIController().setZoom(oVar.nJw);
            i2 = 1;
        }
        if (i2 != 0) {
            this.nQE.setAnimToSelf(false);
            this.nQE.bJO();
            this.nQG.nNX = false;
            this.nQG.nNR = true;
        }
        oVar = this.nQH;
        com.tencent.mm.plugin.k.d dVar2 = this.nOL.nLY;
        if (oVar.nKQ != -1) {
            dVar2.getIController().setZoom(oVar.nKQ);
        }
        if (this.nQL != null) {
            this.nQL.a(this.ecy);
        }
        if (this.nQG != null) {
            this.nQG.onResume();
        }
        AppMethodBeat.o(113682);
    }

    public final void onPause() {
        AppMethodBeat.i(113683);
        ab.i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        o oVar = this.nQH;
        ab.d("MicorMsg.TrackRefreshManager", "pause isShared:" + oVar.nKK);
        if (!oVar.nKK) {
            oVar.fwu.c(oVar.ecy);
            oVar.nKF.b(oVar.nKU);
            oVar.nKL = true;
            oVar.nKR = true;
        }
        oVar = this.nQH;
        com.tencent.mm.plugin.k.d dVar = this.nOL.nLY;
        oVar.nKM = oVar.nKH;
        oVar.nKH = 0;
        ab.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + oVar.nKM);
        if (oVar.bJI()) {
            oVar.nJu = (((double) dVar.getMapCenterX()) * 1.0d) / 1000000.0d;
            oVar.nJv = (((double) dVar.getMapCenterY()) * 1.0d) / 1000000.0d;
            oVar.nJw = dVar.getZoom();
        }
        h.pYm.e(10997, "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.nQO));
        this.nQO = System.currentTimeMillis();
        if (this.nQL != null) {
            this.nQL.c(this.ecy);
        }
        if (this.nQG != null) {
            this.nQG.onPause();
        }
        AppMethodBeat.o(113683);
    }

    public final void onDestroy() {
        AppMethodBeat.i(113684);
        super.onDestroy();
        o oVar = this.nQH;
        o.b bVar = this.nQQ;
        Iterator it = oVar.nKG.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((o.b) weakReference.get()).equals(bVar)) {
                oVar.nKG.remove(weakReference);
                break;
            }
        }
        this.nQH.nKP = null;
        if (this.nQJ != null) {
            k kVar = this.nQJ;
            kVar.nNA.b(kVar);
            VolumeMeter volumeMeter = kVar.nNn;
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
            d.agz().c(this.nQE.ecy);
        }
        ab.i("MicroMsg.ShareMapUI", "onDestory");
        AppMethodBeat.o(113684);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKl() {
        AppMethodBeat.i(113685);
        super.bKl();
        AppMethodBeat.o(113685);
    }

    public final void bKd() {
        AppMethodBeat.i(113686);
        this.nQH.nKQ = this.nOL.nLY.getZoom();
        this.activity.finish();
        AppMethodBeat.o(113686);
    }

    private void bKz() {
        AppMethodBeat.i(113687);
        aqX();
        this.nQG.iE(false);
        this.nQH.stop();
        this.nQH.xC(3);
        k.bKb();
        this.nQH.nKQ = this.nOL.nLY.getZoom();
        this.activity.finish();
        AppMethodBeat.o(113687);
    }

    public final void bKe() {
        AppMethodBeat.i(113688);
        this.nQG.iE(false);
        this.nQH.stop();
        this.nQH.xC(0);
        k.bKb();
        this.activity.finish();
        AppMethodBeat.o(113688);
    }

    public final void xD(int i) {
        AppMethodBeat.i(113689);
        if (i == 0) {
            h.pYm.e(10997, "8", "", Integer.valueOf(0), Integer.valueOf(0));
            bKz();
            AppMethodBeat.o(113689);
        } else if (i == 1) {
            h.pYm.e(10997, "8", "", Integer.valueOf(0), Integer.valueOf(0));
            bKz();
            AppMethodBeat.o(113689);
        } else {
            if (i == 2) {
                bKz();
            }
            AppMethodBeat.o(113689);
        }
    }

    public final void onBackPressed() {
        AppMethodBeat.i(113690);
        h.pYm.e(10997, "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        this.nQI.bKc();
        AppMethodBeat.o(113690);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(113691);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(113691);
        return dispatchKeyEvent;
    }

    public final void bKA() {
        AppMethodBeat.i(113692);
        super.bKA();
        if (this.nQG != null) {
            this.nQG.nNX = false;
            this.nQG.iD(false);
            this.nQE.bJO();
        }
        AppMethodBeat.o(113692);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKB() {
        AppMethodBeat.i(113693);
        super.bKB();
        h.pYm.e(10997, "1", "", Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.o(113693);
    }

    static /* synthetic */ void a(g gVar, bqu bqu) {
        com.tencent.mm.plugin.location.a.a aVar;
        cmj cmj;
        AppMethodBeat.i(113694);
        ab.d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", Boolean.valueOf(gVar.nQH.chh));
        LinkedList<cmj> linkedList = bqu.wTh;
        LinkedList<cmj> linkedList2 = new LinkedList();
        com.tencent.mm.plugin.location.a.a PQ = l.bJz().PQ(gVar.nKN);
        if (PQ == null) {
            PQ = new com.tencent.mm.plugin.location.a.a();
            PQ.latitude = -1000.0d;
            PQ.longitude = -1000.0d;
            aVar = PQ;
        } else {
            aVar = PQ;
        }
        LinkedList linkedList3 = new LinkedList();
        for (cmj cmj2 : linkedList) {
            linkedList3.add(cmj2.vHl);
        }
        if (!linkedList3.contains(r.Yz())) {
            linkedList3.add(r.Yz());
        }
        l.bJz().a(gVar.nKN, linkedList3, aVar.latitude, aVar.longitude, aVar.nJq, "", "");
        for (cmj cmj22 : linkedList) {
            if (Math.abs(cmj22.xkm.vNH) > 180.0d || Math.abs(cmj22.xkm.vNI) > 90.0d) {
                cmj cmj3 = (cmj) gVar.nQS.get(cmj22.vHl);
                if (cmj3 != null) {
                    linkedList2.add(cmj3);
                    ab.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", cmj22.vHl, Double.valueOf(cmj22.xkm.vNI), Double.valueOf(cmj22.xkm.vNH), Double.valueOf(cmj3.xkm.vNI), Double.valueOf(cmj3.xkm.vNH));
                } else {
                    ab.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", cmj22.vHl, Double.valueOf(cmj22.xkm.vNI), Double.valueOf(cmj22.xkm.vNH));
                }
            } else {
                linkedList2.add(cmj22);
            }
        }
        gVar.nQS.clear();
        for (cmj cmj222 : linkedList2) {
            gVar.nQS.put(cmj222.vHl, cmj222);
        }
        int size = linkedList2.size();
        ArrayList arrayList = new ArrayList();
        arrayList.add(r.Yz());
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
            ab.v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + stringBuilder.toString());
            if (gVar.nQG != null) {
                gVar.nQG.ci(linkedList2);
            }
        }
        if (gVar.nQG.nNT) {
            m mVar = gVar.nQG;
            cie cie = bqu.wTi;
            if (mVar.nNW == null) {
                mVar.nNW = new cie();
            }
            if (cie != null) {
                ab.d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + cie.vNI + " " + cie.vNH);
                mVar.nNW.wKW = cie.wKW;
                mVar.nNW.vNI = cie.vNI;
                mVar.nNW.vNH = cie.vNH;
            }
        }
        gVar.nQK.H(arrayList);
        AppMethodBeat.o(113694);
    }
}
