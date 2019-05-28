package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.Exif.C1440a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.modelgeo.C18657c;
import com.tencent.p177mm.modelgeo.C18657c.C18660a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18686e;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C44072t;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.axw;
import com.tencent.p177mm.protocal.protobuf.ayt;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C46614bq;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.sns.ui.LocationWidget */
public class LocationWidget extends LinearLayout {
    private float bEJ;
    private int dtW;
    private String dud;
    private String eUu;
    private boolean fBD;
    private float fBr;
    private float fBs;
    private Activity gNy;
    private C18660a nJD;
    private C18657c nOO;
    private String nQB;
    private C26443d oRD;
    private float oRJ;
    private C42206a oRX;
    private axw oSn;
    private ImageView rhd;
    private TextView rii;
    private View rjZ;
    private View rka;
    private int[] rkb;
    private ImageView[] rkc;
    private int rkd;
    private TextView rke;
    private byte[] rkf;
    private String rkg;
    private String rkh;
    private int rki;
    private float rkj;
    private int rkk;
    private C3965a rkl;
    private boolean rkm;
    private C3963b rkn;
    private int score;

    /* renamed from: com.tencent.mm.plugin.sns.ui.LocationWidget$2 */
    class C39602 implements OnClickListener {
        C39602() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38286);
            if (!C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                C4990ab.m7417i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")));
                if (!C35805b.m58707a(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                    AppMethodBeat.m2505o(38286);
                    return;
                }
            } else if (!C35805b.m58714o(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION")) {
                if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    C35805b.m58709b(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION", 64);
                    AppMethodBeat.m2505o(38286);
                    return;
                }
                C32921a.m53856b(LocationWidget.this.gNy, LocationWidget.this.getResources().getString(C25738R.string.g7p, new Object[]{C4988aa.dor()}), 30764, true);
                AppMethodBeat.m2505o(38286);
                return;
            }
            LocationWidget.this.crS();
            AppMethodBeat.m2505o(38286);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.LocationWidget$4 */
    class C39624 implements C42206a {
        C39624() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(38288);
            if (z) {
                boolean z2;
                C4990ab.m7411d("MicroMsg.LocationWidget", "get location %f %f", Float.valueOf(f2), Float.valueOf(f));
                C18686e akf = C18686e.akf();
                boolean z3 = i != 0;
                if (LocationWidget.this.oRD == null) {
                    z2 = false;
                } else {
                    z2 = LocationWidget.this.oRD.fBD;
                }
                akf.mo33956a(2003, z3, z2, f, f2, (int) d2);
                C18698o.m29222a(2003, f, f2, 0);
                if (LocationWidget.this.rkm) {
                    if (LocationWidget.this.fBr == -1000.0f || LocationWidget.this.fBs == -1000.0f) {
                        LocationWidget.this.fBr = f2;
                        LocationWidget.this.fBs = f;
                    }
                    AppMethodBeat.m2505o(38288);
                    return false;
                }
                AppMethodBeat.m2505o(38288);
                return false;
            }
            AppMethodBeat.m2505o(38288);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.LocationWidget$b */
    class C3963b {
        String hlm = "";
        int index;
        int nPQ = 0;
        long oRM = -1;
        long oRN = -1;
        long oRO = -1;
        int oRP = 0;

        C3963b() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.LocationWidget$3 */
    class C39643 implements C18660a {
        C39643() {
        }

        /* renamed from: b */
        public final void mo8746b(Addr addr) {
            AppMethodBeat.m2504i(38287);
            C4990ab.m7417i("MicroMsg.LocationWidget", "get info %s", addr.toString());
            if (LocationWidget.this.rkm) {
                LocationWidget.m6326f(LocationWidget.this);
                if (C5046bo.isNullOrNil(LocationWidget.this.dud)) {
                    LocationWidget.this.dud = addr.fBi;
                    LocationWidget.m6326f(LocationWidget.this);
                    AppMethodBeat.m2505o(38287);
                    return;
                }
                AppMethodBeat.m2505o(38287);
                return;
            }
            AppMethodBeat.m2505o(38287);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.LocationWidget$a */
    public interface C3965a {
        ArrayList<C1440a> crV();

        boolean crW();
    }

    /* renamed from: c */
    static /* synthetic */ void m6323c(LocationWidget locationWidget) {
        AppMethodBeat.m2504i(38302);
        locationWidget.crR();
        AppMethodBeat.m2505o(38302);
    }

    /* renamed from: f */
    static /* synthetic */ void m6326f(LocationWidget locationWidget) {
        AppMethodBeat.m2504i(38303);
        locationWidget.crT();
        AppMethodBeat.m2505o(38303);
    }

    public LocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38289);
        this.rkb = new int[]{2131825283, 2131825284, 2131825285, 2131825286, 2131825287};
        this.rkc = new ImageView[5];
        this.fBr = -1000.0f;
        this.fBs = -1000.0f;
        this.rki = 0;
        this.oSn = null;
        this.dtW = 0;
        this.rkj = 0.0f;
        this.oRJ = 0.0f;
        this.bEJ = 0.0f;
        this.rkk = -1;
        this.fBD = true;
        this.oRD = C26443d.agz();
        this.rkl = null;
        this.rkm = false;
        this.nJD = new C39643();
        this.oRX = new C39624();
        this.rkn = null;
        m6331j((MMActivity) context);
        AppMethodBeat.m2505o(38289);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38290);
        this.rkb = new int[]{2131825283, 2131825284, 2131825285, 2131825286, 2131825287};
        this.rkc = new ImageView[5];
        this.fBr = -1000.0f;
        this.fBs = -1000.0f;
        this.rki = 0;
        this.oSn = null;
        this.dtW = 0;
        this.rkj = 0.0f;
        this.oRJ = 0.0f;
        this.bEJ = 0.0f;
        this.rkk = -1;
        this.fBD = true;
        this.oRD = C26443d.agz();
        this.rkl = null;
        this.rkm = false;
        this.nJD = new C39643();
        this.oRX = new C39624();
        this.rkn = null;
        m6331j((MMActivity) context);
        AppMethodBeat.m2505o(38290);
    }

    /* renamed from: j */
    private void m6331j(MMActivity mMActivity) {
        AppMethodBeat.m2504i(38291);
        this.gNy = mMActivity;
        View inflate = View.inflate(mMActivity, getLayoutResource(), this);
        this.rjZ = inflate.findViewById(2131825277);
        this.rke = (TextView) this.rjZ.findViewById(2131825276);
        this.rii = (TextView) this.rjZ.findViewById(2131825279);
        this.rhd = (ImageView) this.rjZ.findViewById(2131825278);
        this.rka = inflate.findViewById(2131825280);
        for (int i = 0; i < 5; i++) {
            this.rkc[i] = (ImageView) this.rka.findViewById(this.rkb[i]);
            this.rkc[i].setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(38285);
                    if (LocationWidget.this.score == i + 1) {
                        LocationWidget.this.score = LocationWidget.this.score - 1;
                    } else {
                        LocationWidget.this.score = i + 1;
                    }
                    LocationWidget.m6323c(LocationWidget.this);
                    AppMethodBeat.m2505o(38285);
                }
            });
        }
        this.nOO = C18657c.agw();
        this.rjZ.setOnClickListener(new C39602());
        this.rkh = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!C5046bo.isNullOrNil(this.rkh)) {
            this.fBr = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.fBs = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.eUu = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.rkg = mMActivity.getIntent().getStringExtra("Kpoi_address");
            crT();
        }
        if (C1720g.m3534RN().mo5161QY()) {
            this.rkd = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsPostPOICommentSwitch"), 0);
        } else {
            this.rkd = 0;
        }
        crR();
        AppMethodBeat.m2505o(38291);
    }

    private void crR() {
        int i = 0;
        AppMethodBeat.m2504i(38292);
        C4990ab.m7417i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", Integer.valueOf(this.rkd), this.rkh, Integer.valueOf(this.rki), Integer.valueOf(this.dtW), Boolean.valueOf(C46614bq.dpN()));
        if (C46614bq.dpN() || this.rkd == 0 || C5046bo.isNullOrNil(this.rkh) || this.rki == 1 || (this.dtW & 1) == 0) {
            this.rka.setVisibility(8);
            AppMethodBeat.m2505o(38292);
            return;
        }
        this.rka.setVisibility(0);
        while (i < this.score) {
            this.rkc[i].setImageResource(getSelectedStarImageResource());
            i++;
        }
        for (i = this.score; i < 5; i++) {
            this.rkc[i].setImageResource(getNormalStarImageResource());
        }
        AppMethodBeat.m2505o(38292);
    }

    public final void crS() {
        AppMethodBeat.m2504i(38293);
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.oSn.toByteArray());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
        }
        if (!C5046bo.isNullOrNil(this.rkh)) {
            intent.putExtra("get_poi_classify_id", this.rkh);
        } else if (!C5046bo.isNullOrNil(this.dud)) {
            intent.putExtra("get_city", this.dud);
        }
        intent.putExtra("get_lat", this.fBr);
        intent.putExtra("get_lng", this.fBs);
        intent.putExtra("request_id", this.nQB);
        if (this.rkl != null) {
            ArrayList crV = this.rkl.crV();
            if (crV != null) {
                m6315R(crV);
                ArrayList arrayList = new ArrayList();
                Iterator it = crV.iterator();
                while (it.hasNext()) {
                    C1440a c1440a = (C1440a) it.next();
                    arrayList.add(String.format("%f\n%f", new Object[]{Double.valueOf(c1440a.latitude), Double.valueOf(c1440a.longitude)}));
                }
            }
        }
        C25985d.m41468b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
        AppMethodBeat.m2505o(38293);
    }

    /* renamed from: R */
    private void m6315R(ArrayList<C1440a> arrayList) {
        AppMethodBeat.m2504i(38294);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.m2505o(38294);
            return;
        }
        C1440a c1440a;
        C7060h.pYm.mo8374X(11139, "1");
        if (((double) Math.abs(-1000.0f - this.fBr)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.fBs)) > 1.0E-6d) {
            c1440a = (C1440a) arrayList.get(arrayList.size() - 1);
            if (LocationWidget.m6322b(c1440a.latitude, c1440a.longitude, (double) this.fBr, (double) this.fBs)) {
                C7060h.pYm.mo8374X(11139, "2");
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj;
            int i2 = i + 1;
            while (true) {
                int i3 = i2;
                if (i3 >= arrayList.size()) {
                    i2 = 1;
                    break;
                }
                c1440a = (C1440a) arrayList.get(i);
                C1440a c1440a2 = (C1440a) arrayList.get(i3);
                if (LocationWidget.m6322b(c1440a.latitude, c1440a.longitude, c1440a2.latitude, c1440a2.longitude)) {
                    C7060h.pYm.mo8374X(11139, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                    obj = null;
                    break;
                }
                i2 = i3 + 1;
            }
            if (obj == null) {
                break;
            }
        }
        AppMethodBeat.m2505o(38294);
    }

    /* renamed from: b */
    private static boolean m6322b(double d, double d2, double d3, double d4) {
        AppMethodBeat.m2504i(38295);
        if (C44072t.m79222c(d, d2, d3, d4) > 1000.0d) {
            AppMethodBeat.m2505o(38295);
            return true;
        }
        AppMethodBeat.m2505o(38295);
        return false;
    }

    public final void stop() {
        AppMethodBeat.m2504i(38296);
        if (this.oRD != null) {
            this.oRD.mo44208c(this.oRX);
        }
        if (this.nOO != null) {
            this.nOO.mo33925a(this.nJD);
        }
        AppMethodBeat.m2505o(38296);
    }

    /* renamed from: ao */
    public final boolean mo8732ao(Intent intent) {
        AppMethodBeat.m2504i(38297);
        if (intent == null) {
            AppMethodBeat.m2505o(38297);
        } else {
            this.rki = intent.getIntExtra("get_poi_classify_type", 0);
            this.dtW = intent.getIntExtra("get_poi_showflag", 0);
            C4990ab.m7411d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", Integer.valueOf(this.rki));
            this.eUu = C5046bo.m7532bc(intent.getStringExtra("get_poi_name"), "");
            this.dud = C5046bo.m7532bc(intent.getStringExtra("get_city"), "");
            this.fBr = intent.getFloatExtra("get_lat", -1000.0f);
            this.fBs = intent.getFloatExtra("get_lng", -1000.0f);
            C4990ab.m7416i("MicroMsg.LocationWidget", "check cur lat " + this.rkj + " " + this.oRJ);
            this.rkj = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.oRJ = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.rkk = intent.getIntExtra("get_loctype", -1);
            this.bEJ = intent.getFloatExtra("get_accuracy", 0.0f);
            this.fBD = intent.getBooleanExtra("get_is_mars", true);
            this.nQB = intent.getStringExtra("request_id");
            C18686e.akf().mo33956a(2003, this.rkk != 0, this.fBD, this.fBs, this.fBr, (int) this.bEJ);
            this.rkf = intent.getByteArrayExtra("location_ctx");
            if (!C5046bo.isNullOrNil(this.eUu)) {
                this.rkg = C5046bo.m7532bc(intent.getStringExtra("get_poi_address"), "");
                this.rkh = C5046bo.m7532bc(intent.getStringExtra("get_poi_classify_id"), "");
                this.oSn = new axw();
                try {
                    this.oSn = (axw) this.oSn.parseFrom(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
                    this.oSn = null;
                }
                if (!C5046bo.isNullOrNil(this.rkh)) {
                    this.oSn = new axw();
                    this.oSn.oQU = this.rkh;
                    this.oSn.jCt = this.rki;
                    this.oSn.Title = this.eUu;
                    this.oSn.oQZ.add(new bts().alV(this.rkg));
                }
            } else if (C5046bo.isNullOrNil(this.dud)) {
                this.fBr = -1000.0f;
                this.fBs = -1000.0f;
                this.eUu = "";
                this.rkg = "";
                this.dud = "";
                this.rkh = "";
                this.oSn = null;
            } else {
                this.eUu = "";
                this.rkg = "";
                this.rkh = "";
                this.oSn = null;
            }
            C4990ab.m7411d("MicroMsg.LocationWidget", "label %s poiname %s", this.rkg, this.eUu);
            crT();
            crR();
            this.rkn = new C3963b();
            C3963b c3963b = this.rkn;
            if (intent != null) {
                c3963b.index = intent.getIntExtra("report_index", -1);
                c3963b.oRM = intent.getLongExtra("first_start_time", 0);
                c3963b.oRN = intent.getLongExtra("lastSuccStamp", 0);
                c3963b.oRO = intent.getLongExtra("firstSuccStamp", 0);
                c3963b.oRP = intent.getIntExtra("reqLoadCnt", 0);
                c3963b.nPQ = intent.getIntExtra("entry_time", 0);
                c3963b.hlm = intent.getStringExtra("search_id");
            }
            AppMethodBeat.m2505o(38297);
        }
        return true;
    }

    private void crT() {
        AppMethodBeat.m2504i(38298);
        if (!(this.rke == null || this.rii == null)) {
            if (!C5046bo.isNullOrNil(this.eUu)) {
                this.rke.setText(this.eUu);
                this.rke.setTextColor(getResources().getColor(C25738R.color.f12069r8));
                this.rii.setVisibility(8);
            } else if (C5046bo.isNullOrNil(this.dud)) {
                this.rke.setText(C25738R.string.em8);
                this.rke.setTextColor(getResources().getColor(C25738R.color.f12212w4));
                this.rii.setVisibility(8);
            } else {
                this.rke.setText(this.dud);
                this.rke.setTextColor(getResources().getColor(C25738R.color.f12069r8));
                this.rii.setVisibility(8);
            }
        }
        if (C5046bo.isNullOrNil(this.eUu) && C5046bo.isNullOrNil(this.dud)) {
            this.rhd.setImageDrawable(C5225ah.m7962f(this.gNy, C1318a.album_location_icon_normal, WebView.NIGHT_MODE_COLOR));
            AppMethodBeat.m2505o(38298);
            return;
        }
        this.rhd.setImageDrawable(C5225ah.m7962f(this.gNy, C1318a.album_location_icon_pressed, getContext().getResources().getColor(C25738R.color.a61)));
        AppMethodBeat.m2505o(38298);
    }

    /* Access modifiers changed, original: protected */
    public int getNormalStateImageResource() {
        return C1318a.album_location_icon_normal;
    }

    /* Access modifiers changed, original: protected */
    public int getSelectedStateImageResource() {
        return C1318a.album_location_icon_pressed;
    }

    /* Access modifiers changed, original: protected */
    public int getNormalStarImageResource() {
        return C1318a.sns_shoot_star_normal;
    }

    /* Access modifiers changed, original: protected */
    public int getSelectedStarImageResource() {
        return C1318a.sns_shoot_star_selected;
    }

    public ayt getLocation() {
        AppMethodBeat.m2504i(38299);
        ayt ayt = new ayt();
        ayt.vRq = this.fBr;
        ayt.vRp = this.fBs;
        ayt.wCF = 0;
        ayt.score = this.score;
        if (this.rkf != null) {
            ayt.wCG = new C1332b(this.rkf);
        }
        if (!C5046bo.isNullOrNil(this.eUu)) {
            ayt.rkg = this.rkg;
            ayt.eUu = this.eUu;
            ayt.wCC = this.rkh;
            ayt.guP = this.dud;
            if (this.rki == 0 || this.rki != 1) {
                ayt.rki = 1;
            } else {
                ayt.rki = 2;
            }
            C4990ab.m7411d("MicroMsg.LocationWidget", "getlocation type %d", Integer.valueOf(ayt.rki));
        } else if (!C5046bo.isNullOrNil(this.dud)) {
            ayt.guP = this.dud;
        }
        if (this.rkn != null) {
            String format = String.format("%f/%f", new Object[]{Float.valueOf(ayt.vRq), Float.valueOf(ayt.vRp)});
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("index " + this.rkn.index);
            stringBuffer.append("firstStartStamp " + this.rkn.oRM);
            stringBuffer.append("lastSuccStamp " + this.rkn.oRO);
            stringBuffer.append("firstSuccStamp " + this.rkn.oRN);
            stringBuffer.append("reqLoadCnt " + this.rkn.oRP);
            stringBuffer.append("classifyId " + this.rkh);
            stringBuffer.append("entryTime " + this.rkn.nPQ);
            stringBuffer.append("searchId" + this.rkn.hlm);
            C4990ab.m7411d("MicroMsg.LocationWidget", "report %s", stringBuffer.toString());
            C7060h.pYm.mo8381e(11135, Integer.valueOf(5), Integer.valueOf(this.rkn.index + 1), Long.valueOf(this.rkn.oRM), Long.valueOf(this.rkn.oRO), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.rkn.oRN), Integer.valueOf(this.rkn.oRP), format, this.rkh, Integer.valueOf(this.rkn.nPQ), this.rkn.hlm, C1427q.m3026LK());
        }
        crU();
        AppMethodBeat.m2505o(38299);
        return ayt;
    }

    public int getShowFlag() {
        return this.dtW;
    }

    public ayt getCurLocation() {
        AppMethodBeat.m2504i(38300);
        ayt ayt = new ayt();
        ayt.vRq = this.rkj;
        ayt.vRp = this.oRJ;
        ayt.bEJ = this.bEJ;
        ayt.rkk = this.rkk;
        AppMethodBeat.m2505o(38300);
        return ayt;
    }

    private void crU() {
        AppMethodBeat.m2504i(38301);
        if (this.rkl != null) {
            boolean crW = this.rkl.crW();
            ArrayList crV = this.rkl.crV();
            if (crV == null || crV.size() == 0) {
                AppMethodBeat.m2505o(38301);
                return;
            }
            Iterator it = crV.iterator();
            while (it.hasNext()) {
                int i;
                C1440a c1440a = (C1440a) it.next();
                C4990ab.m7411d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", Double.valueOf(c1440a.latitude), Double.valueOf(c1440a.longitude));
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf((int) (c1440a.latitude * 1000000.0d));
                objArr[1] = Integer.valueOf((int) (c1440a.longitude * 1000000.0d));
                if (crW) {
                    i = 1;
                } else {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(2);
                c7060h.mo8381e(11345, objArr);
            }
        }
        AppMethodBeat.m2505o(38301);
    }

    public void setLocationWidgetListener(C3965a c3965a) {
        this.rkl = c3965a;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return 2130969948;
    }
}
