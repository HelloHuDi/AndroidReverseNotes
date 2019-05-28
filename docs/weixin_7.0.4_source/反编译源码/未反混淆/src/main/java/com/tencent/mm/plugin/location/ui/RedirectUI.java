package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.c;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;

@a(23)
public class RedirectUI extends Activity {
    private static long ecD = 86400000;
    private boolean cFy = false;
    private long cvx;
    private final ak handler = new ak();
    private String info = "";
    private int klY;
    private double nJu = 0.0d;
    private double nJv = 0.0d;
    private int nJw = 0;
    private boolean nLD = true;
    private String nMk = "";
    private String nMl = "";
    private int nMm;
    private final int nMn = 1;
    private boolean nMo = false;
    private final int nMp = 0;
    private final int nMq = 1;
    private final int nMr = 0;
    private final int nMs = 1;
    private int type = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RedirectUI() {
        AppMethodBeat.i(113474);
        AppMethodBeat.o(113474);
    }

    static /* synthetic */ void a(RedirectUI redirectUI, Intent intent, double d, double d2) {
        AppMethodBeat.i(113482);
        redirectUI.a(intent, d, d2);
        AppMethodBeat.o(113482);
    }

    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.i(113475);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(j.INVALID_ID);
            getWindow().setStatusBarColor(0);
        }
        if (bo.fp(bo.c((Long) g.RP().Ry().get(81938, null))) * 1000 > ecD) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            c.aiq().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.cvx = getIntent().getLongExtra("kMsgId", -1);
        this.nMl = getIntent().getStringExtra("map_talker_name");
        ab.d("MicroMsg.RedirectUI", "tofutest type: %s", Integer.valueOf(this.type));
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.nMk = getIntent().getStringExtra("map_sender_name");
                this.klY = getIntent().getIntExtra("view_type_key", 1);
                this.nMm = getIntent().getIntExtra("key_get_location_type", 0);
                k(-85.0d, -1000.0d);
                break;
            case 1:
            case 2:
            case 7:
            case 9:
                this.nJu = getIntent().getDoubleExtra("kwebmap_slat", -85.0d);
                this.nJv = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.nJw = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                k(this.nJu, this.nJv);
                AppMethodBeat.o(113475);
                return;
            case 6:
                com.tencent.mm.plugin.location.a.a PQ = l.bJz().PQ(this.nMl);
                ab.i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (PQ != null));
                if (PQ != null) {
                    this.nJu = PQ.latitude;
                    this.nJv = PQ.longitude;
                    this.info = PQ.nJq;
                    ab.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", Double.valueOf(this.nJu), Double.valueOf(this.nJv), this.info, Integer.valueOf(PQ.cGh.size()));
                    this.nJw = 0;
                    k(this.nJu, this.nJv);
                    AppMethodBeat.o(113475);
                    return;
                }
                k(-1000.0d, -1000.0d);
                AppMethodBeat.o(113475);
                return;
        }
        AppMethodBeat.o(113475);
    }

    private void k(double d, double d2) {
        AppMethodBeat.i(113476);
        this.cFy = true;
        final Intent bJP = bJP();
        switch (this.type) {
            case 0:
                bJP.putExtra("location_scene", 1);
                break;
        }
        if (ae.ghX) {
            final double d3 = d;
            final double d4 = d2;
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(113473);
                    RedirectUI.a(RedirectUI.this, bJP, d3, d4);
                    AppMethodBeat.o(113473);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.o(113476);
            return;
        }
        a(bJP, d, d2);
        AppMethodBeat.o(113476);
    }

    private Intent bJP() {
        AppMethodBeat.i(113477);
        Intent P = d.P(this);
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                ab.d("MicroMsg.RedirectUI", "view poi      isHidePoiOversea : " + com.tencent.mm.m.g.Nv().Nh());
                P.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
                ab.d("MicroMsg.RedirectUI", "view normal");
                P.putExtra("intent_map_key", 4);
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                ab.d("MicroMsg.RedirectUI", "location resume");
                P.putExtra("intent_map_key", 5);
                if (!bo.isNullOrNil(stringExtra)) {
                    P.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case 9:
                P.putExtra("intent_map_key", 4);
                break;
            default:
                ab.d("MicroMsg.RedirectUI", "view type error");
                P = null;
                break;
        }
        AppMethodBeat.o(113477);
        return P;
    }

    private void a(Intent intent, double d, double d2) {
        AppMethodBeat.i(113478);
        if (intent != null) {
            intent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
            intent.putExtra("kimg_path", com.tencent.mm.plugin.i.c.XW());
            intent.putExtra("kPoi_url", bo.bc(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d);
            intent.putExtra("kwebmap_lng", d2);
            intent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", bo.bc(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.nMl);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            ta taVar = new ta();
            taVar.cPk.cPl = true;
            com.tencent.mm.sdk.b.a.xxA.m(taVar);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.nJw > 0) {
                    intent.putExtra("kwebmap_scale", this.nJw);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                AppMethodBeat.o(113478);
                return;
            } else if (this.type == 1 || this.type == 2 || this.type == 7 || this.type == 9) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                intent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
                if (this.nJw > 0) {
                    intent.putExtra("kwebmap_scale", this.nJw);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                AppMethodBeat.o(113478);
                return;
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                AppMethodBeat.o(113478);
                return;
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                AppMethodBeat.o(113478);
                return;
            } else {
                if (this.type == 8) {
                    startActivityForResult(intent, 6);
                }
                AppMethodBeat.o(113478);
                return;
            }
        }
        finish();
        AppMethodBeat.o(113478);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(113479);
        ab.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            finish();
            AppMethodBeat.o(113479);
        } else if (intent == null) {
            finish();
            AppMethodBeat.o(113479);
        } else {
            LocationIntent locationIntent;
            String str;
            switch (i) {
                case 2:
                    String str2 = this.nMl;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    ab.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.SY());
                    mu muVar = new mu();
                    muVar.cII.bJt = this.nMm;
                    muVar.cII.lat = locationIntent.lat;
                    muVar.cII.lng = locationIntent.lng;
                    muVar.cII.cED = locationIntent.cED;
                    muVar.cII.label = locationIntent.label;
                    muVar.cII.cIK = locationIntent.eUu;
                    com.tencent.mm.sdk.b.a.xxA.m(muVar);
                    double d = locationIntent.lat;
                    double d2 = locationIntent.lng;
                    int i3 = locationIntent.cED;
                    String str3 = locationIntent.label;
                    str = locationIntent.eUu;
                    String str4 = locationIntent.vaO;
                    String str5 = locationIntent.nJB;
                    if (str == null) {
                        str = "";
                    }
                    str = "<msg><location x=\"" + d + "\" y=\"" + d2 + "\" scale=\"" + i3 + "\" label=\"" + bo.ani(str3) + "\" poiname=\"" + bo.ani(str) + "\" infourl=\"" + bo.ani(str4) + "\" maptype=\"0\" poiid=\"" + str5 + "\" /></msg>";
                    ab.d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(str)));
                    qb qbVar = new qb();
                    qbVar.cMq.cMr = str2;
                    qbVar.cMq.content = str;
                    qbVar.cMq.type = 48;
                    qbVar.cMq.flags = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                    o.a(2004, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    String str6;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    ab.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.SY());
                    if (locationIntent.vaP == 3) {
                        h.pYm.e(10822, Integer.valueOf(1), locationIntent.nJz, Integer.valueOf(1));
                    } else {
                        h.pYm.e(10822, Integer.valueOf(1), locationIntent.nJz, Integer.valueOf(0));
                    }
                    intent.putExtra("kwebmap_slat", locationIntent.lat);
                    intent.putExtra("kwebmap_lng", locationIntent.lng);
                    intent.putExtra("kwebmap_scale", locationIntent.cED);
                    intent.putExtra("Kwebmap_locaion", locationIntent.label);
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("kTags");
                    intent.putExtra("kTags", stringArrayListExtra);
                    str = "kPoiName";
                    if (locationIntent.eUu.equals("")) {
                        str6 = "";
                    } else {
                        str6 = locationIntent.eUu;
                    }
                    intent.putExtra(str, str6);
                    break;
                case 6:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    ab.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.SY());
                    if (locationIntent.fBB != null) {
                        ab.d("MicroMsg.RedirectUI", "addr: " + locationIntent.fBB.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent.fBB);
                    break;
            }
            setResult(i2, intent);
            finish();
            AppMethodBeat.o(113479);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(113480);
        this.nLD = false;
        super.onDestroy();
        AppMethodBeat.o(113480);
    }

    public void finish() {
        AppMethodBeat.i(113481);
        super.finish();
        AppMethodBeat.o(113481);
    }
}
