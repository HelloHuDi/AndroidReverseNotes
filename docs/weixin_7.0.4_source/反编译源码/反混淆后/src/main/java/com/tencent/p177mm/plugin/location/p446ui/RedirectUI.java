package com.tencent.p177mm.plugin.location.p446ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C37765mu;
import com.tencent.p177mm.p230g.p231a.C45369ta;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p707ba.C41785c;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.plugin.location.p446ui.impl.C39293d;
import com.tencent.p177mm.plugin.location.p734a.C6958a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.location.LocationIntent;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;

@C5271a(23)
/* renamed from: com.tencent.mm.plugin.location.ui.RedirectUI */
public class RedirectUI extends Activity {
    private static long ecD = 86400000;
    private boolean cFy = false;
    private long cvx;
    private final C7306ak handler = new C7306ak();
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
        AppMethodBeat.m2503at(this, z);
    }

    public RedirectUI() {
        AppMethodBeat.m2504i(113474);
        AppMethodBeat.m2505o(113474);
    }

    /* renamed from: a */
    static /* synthetic */ void m5637a(RedirectUI redirectUI, Intent intent, double d, double d2) {
        AppMethodBeat.m2504i(113482);
        redirectUI.m5636a(intent, d, d2);
        AppMethodBeat.m2505o(113482);
    }

    public void onCreate(Bundle bundle) {
        int i;
        AppMethodBeat.m2504i(113475);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(C8415j.INVALID_ID);
            getWindow().setStatusBarColor(0);
        }
        if (C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(81938, null))) * 1000 > ecD) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            C41785c.aiq().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.cvx = getIntent().getLongExtra("kMsgId", -1);
        this.nMl = getIntent().getStringExtra("map_talker_name");
        C4990ab.m7411d("MicroMsg.RedirectUI", "tofutest type: %s", Integer.valueOf(this.type));
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.nMk = getIntent().getStringExtra("map_sender_name");
                this.klY = getIntent().getIntExtra("view_type_key", 1);
                this.nMm = getIntent().getIntExtra("key_get_location_type", 0);
                m5638k(-85.0d, -1000.0d);
                break;
            case 1:
            case 2:
            case 7:
            case 9:
                this.nJu = getIntent().getDoubleExtra("kwebmap_slat", -85.0d);
                this.nJv = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.nJw = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                m5638k(this.nJu, this.nJv);
                AppMethodBeat.m2505o(113475);
                return;
            case 6:
                C6958a PQ = C39287l.bJz().mo36494PQ(this.nMl);
                C4990ab.m7416i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (PQ != null));
                if (PQ != null) {
                    this.nJu = PQ.latitude;
                    this.nJv = PQ.longitude;
                    this.info = PQ.nJq;
                    C4990ab.m7417i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", Double.valueOf(this.nJu), Double.valueOf(this.nJv), this.info, Integer.valueOf(PQ.cGh.size()));
                    this.nJw = 0;
                    m5638k(this.nJu, this.nJv);
                    AppMethodBeat.m2505o(113475);
                    return;
                }
                m5638k(-1000.0d, -1000.0d);
                AppMethodBeat.m2505o(113475);
                return;
        }
        AppMethodBeat.m2505o(113475);
    }

    /* renamed from: k */
    private void m5638k(double d, double d2) {
        AppMethodBeat.m2504i(113476);
        this.cFy = true;
        final Intent bJP = bJP();
        switch (this.type) {
            case 0:
                bJP.putExtra("location_scene", 1);
                break;
        }
        if (C1947ae.ghX) {
            final double d3 = d;
            final double d4 = d2;
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(113473);
                    RedirectUI.m5637a(RedirectUI.this, bJP, d3, d4);
                    AppMethodBeat.m2505o(113473);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(113476);
            return;
        }
        m5636a(bJP, d, d2);
        AppMethodBeat.m2505o(113476);
    }

    private Intent bJP() {
        AppMethodBeat.m2504i(113477);
        Intent P = C39293d.m66972P(this);
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                C4990ab.m7410d("MicroMsg.RedirectUI", "view poi      isHidePoiOversea : " + C26373g.m41965Nv().mo5295Nh());
                P.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
                C4990ab.m7410d("MicroMsg.RedirectUI", "view normal");
                P.putExtra("intent_map_key", 4);
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                C4990ab.m7410d("MicroMsg.RedirectUI", "location resume");
                P.putExtra("intent_map_key", 5);
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    P.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case 9:
                P.putExtra("intent_map_key", 4);
                break;
            default:
                C4990ab.m7410d("MicroMsg.RedirectUI", "view type error");
                P = null;
                break;
        }
        AppMethodBeat.m2505o(113477);
        return P;
    }

    /* renamed from: a */
    private void m5636a(Intent intent, double d, double d2) {
        AppMethodBeat.m2504i(113478);
        if (intent != null) {
            intent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
            intent.putExtra("kimg_path", C43217c.m76863XW());
            intent.putExtra("kPoi_url", C5046bo.m7532bc(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d);
            intent.putExtra("kwebmap_lng", d2);
            intent.putExtra("kPoiid", getIntent().getStringExtra("kPoiid"));
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", C5046bo.m7532bc(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.nMl);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            C45369ta c45369ta = new C45369ta();
            c45369ta.cPk.cPl = true;
            C4879a.xxA.mo10055m(c45369ta);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.nJw > 0) {
                    intent.putExtra("kwebmap_scale", this.nJw);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                AppMethodBeat.m2505o(113478);
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
                AppMethodBeat.m2505o(113478);
                return;
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                AppMethodBeat.m2505o(113478);
                return;
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                AppMethodBeat.m2505o(113478);
                return;
            } else {
                if (this.type == 8) {
                    startActivityForResult(intent, 6);
                }
                AppMethodBeat.m2505o(113478);
                return;
            }
        }
        finish();
        AppMethodBeat.m2505o(113478);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(113479);
        C4990ab.m7416i("MicroMsg.RedirectUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            finish();
            AppMethodBeat.m2505o(113479);
        } else if (intent == null) {
            finish();
            AppMethodBeat.m2505o(113479);
        } else {
            LocationIntent locationIntent;
            String str;
            switch (i) {
                case 2:
                    String str2 = this.nMl;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    C4990ab.m7416i("MicroMsg.RedirectUI", "locationintent " + locationIntent.mo69747SY());
                    C37765mu c37765mu = new C37765mu();
                    c37765mu.cII.bJt = this.nMm;
                    c37765mu.cII.lat = locationIntent.lat;
                    c37765mu.cII.lng = locationIntent.lng;
                    c37765mu.cII.cED = locationIntent.cED;
                    c37765mu.cII.label = locationIntent.label;
                    c37765mu.cII.cIK = locationIntent.eUu;
                    C4879a.xxA.mo10055m(c37765mu);
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
                    str = "<msg><location x=\"" + d + "\" y=\"" + d2 + "\" scale=\"" + i3 + "\" label=\"" + C5046bo.ani(str3) + "\" poiname=\"" + C5046bo.ani(str) + "\" infourl=\"" + C5046bo.ani(str4) + "\" maptype=\"0\" poiid=\"" + str5 + "\" /></msg>";
                    C4990ab.m7410d("MicroMsg.RedirectUI", "xml ".concat(String.valueOf(str)));
                    C18372qb c18372qb = new C18372qb();
                    c18372qb.cMq.cMr = str2;
                    c18372qb.cMq.content = str;
                    c18372qb.cMq.type = 48;
                    c18372qb.cMq.flags = 0;
                    C4879a.xxA.mo10055m(c18372qb);
                    C18698o.m29222a(2004, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    String str6;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    C4990ab.m7416i("MicroMsg.RedirectUI", "locationintent " + locationIntent.mo69747SY());
                    if (locationIntent.vaP == 3) {
                        C7060h.pYm.mo8381e(10822, Integer.valueOf(1), locationIntent.nJz, Integer.valueOf(1));
                    } else {
                        C7060h.pYm.mo8381e(10822, Integer.valueOf(1), locationIntent.nJz, Integer.valueOf(0));
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
                    C4990ab.m7416i("MicroMsg.RedirectUI", "locationintent " + locationIntent.mo69747SY());
                    if (locationIntent.fBB != null) {
                        C4990ab.m7410d("MicroMsg.RedirectUI", "addr: " + locationIntent.fBB.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent.fBB);
                    break;
            }
            setResult(i2, intent);
            finish();
            AppMethodBeat.m2505o(113479);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(113480);
        this.nLD = false;
        super.onDestroy();
        AppMethodBeat.m2505o(113480);
    }

    public void finish() {
        AppMethodBeat.m2504i(113481);
        super.finish();
        AppMethodBeat.m2505o(113481);
    }
}
