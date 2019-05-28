package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationWidget extends LinearLayout {
    private float bEJ;
    private int dtW;
    private String dud;
    private String eUu;
    private boolean fBD;
    private float fBr;
    private float fBs;
    private Activity gNy;
    private com.tencent.mm.modelgeo.c.a nJD;
    private c nOO;
    private String nQB;
    private d oRD;
    private float oRJ;
    private com.tencent.mm.modelgeo.b.a oRX;
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
    private a rkl;
    private boolean rkm;
    private b rkn;
    private int score;

    class b {
        String hlm = "";
        int index;
        int nPQ = 0;
        long oRM = -1;
        long oRN = -1;
        long oRO = -1;
        int oRP = 0;

        b() {
        }
    }

    public interface a {
        ArrayList<com.tencent.mm.compatible.util.Exif.a> crV();

        boolean crW();
    }

    static /* synthetic */ void c(LocationWidget locationWidget) {
        AppMethodBeat.i(38302);
        locationWidget.crR();
        AppMethodBeat.o(38302);
    }

    static /* synthetic */ void f(LocationWidget locationWidget) {
        AppMethodBeat.i(38303);
        locationWidget.crT();
        AppMethodBeat.o(38303);
    }

    public LocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38289);
        this.rkb = new int[]{R.id.cq4, R.id.cq5, R.id.cq6, R.id.cq7, R.id.cq8};
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
        this.oRD = d.agz();
        this.rkl = null;
        this.rkm = false;
        this.nJD = new com.tencent.mm.modelgeo.c.a() {
            public final void b(Addr addr) {
                AppMethodBeat.i(38287);
                ab.i("MicroMsg.LocationWidget", "get info %s", addr.toString());
                if (LocationWidget.this.rkm) {
                    LocationWidget.f(LocationWidget.this);
                    if (bo.isNullOrNil(LocationWidget.this.dud)) {
                        LocationWidget.this.dud = addr.fBi;
                        LocationWidget.f(LocationWidget.this);
                        AppMethodBeat.o(38287);
                        return;
                    }
                    AppMethodBeat.o(38287);
                    return;
                }
                AppMethodBeat.o(38287);
            }
        };
        this.oRX = new com.tencent.mm.modelgeo.b.a() {
            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                AppMethodBeat.i(38288);
                if (z) {
                    boolean z2;
                    ab.d("MicroMsg.LocationWidget", "get location %f %f", Float.valueOf(f2), Float.valueOf(f));
                    e akf = e.akf();
                    boolean z3 = i != 0;
                    if (LocationWidget.this.oRD == null) {
                        z2 = false;
                    } else {
                        z2 = LocationWidget.this.oRD.fBD;
                    }
                    akf.a(2003, z3, z2, f, f2, (int) d2);
                    o.a(2003, f, f2, 0);
                    if (LocationWidget.this.rkm) {
                        if (LocationWidget.this.fBr == -1000.0f || LocationWidget.this.fBs == -1000.0f) {
                            LocationWidget.this.fBr = f2;
                            LocationWidget.this.fBs = f;
                        }
                        AppMethodBeat.o(38288);
                        return false;
                    }
                    AppMethodBeat.o(38288);
                    return false;
                }
                AppMethodBeat.o(38288);
                return true;
            }
        };
        this.rkn = null;
        j((MMActivity) context);
        AppMethodBeat.o(38289);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38290);
        this.rkb = new int[]{R.id.cq4, R.id.cq5, R.id.cq6, R.id.cq7, R.id.cq8};
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
        this.oRD = d.agz();
        this.rkl = null;
        this.rkm = false;
        this.nJD = /* anonymous class already generated */;
        this.oRX = /* anonymous class already generated */;
        this.rkn = null;
        j((MMActivity) context);
        AppMethodBeat.o(38290);
    }

    private void j(MMActivity mMActivity) {
        AppMethodBeat.i(38291);
        this.gNy = mMActivity;
        View inflate = View.inflate(mMActivity, getLayoutResource(), this);
        this.rjZ = inflate.findViewById(R.id.cpy);
        this.rke = (TextView) this.rjZ.findViewById(R.id.cpx);
        this.rii = (TextView) this.rjZ.findViewById(R.id.cq0);
        this.rhd = (ImageView) this.rjZ.findViewById(R.id.cpz);
        this.rka = inflate.findViewById(R.id.cq1);
        for (int i = 0; i < 5; i++) {
            this.rkc[i] = (ImageView) this.rka.findViewById(this.rkb[i]);
            this.rkc[i].setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(38285);
                    if (LocationWidget.this.score == i + 1) {
                        LocationWidget.this.score = LocationWidget.this.score - 1;
                    } else {
                        LocationWidget.this.score = i + 1;
                    }
                    LocationWidget.c(LocationWidget.this);
                    AppMethodBeat.o(38285);
                }
            });
        }
        this.nOO = c.agw();
        this.rjZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38286);
                if (!com.tencent.mm.au.b.sO((String) g.RP().Ry().get(274436, null))) {
                    ab.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")));
                    if (!com.tencent.mm.pluginsdk.permission.b.a(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                        AppMethodBeat.o(38286);
                        return;
                    }
                } else if (!com.tencent.mm.pluginsdk.permission.b.o(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION")) {
                    if (((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                        com.tencent.mm.pluginsdk.permission.b.b(LocationWidget.this.gNy, "android.permission.ACCESS_COARSE_LOCATION", 64);
                        AppMethodBeat.o(38286);
                        return;
                    }
                    com.tencent.mm.plugin.account.a.b.a.b(LocationWidget.this.gNy, LocationWidget.this.getResources().getString(R.string.g7p, new Object[]{aa.dor()}), 30764, true);
                    AppMethodBeat.o(38286);
                    return;
                }
                LocationWidget.this.crS();
                AppMethodBeat.o(38286);
            }
        });
        this.rkh = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!bo.isNullOrNil(this.rkh)) {
            this.fBr = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.fBs = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.eUu = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.rkg = mMActivity.getIntent().getStringExtra("Kpoi_address");
            crT();
        }
        if (g.RN().QY()) {
            this.rkd = bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsPostPOICommentSwitch"), 0);
        } else {
            this.rkd = 0;
        }
        crR();
        AppMethodBeat.o(38291);
    }

    private void crR() {
        int i = 0;
        AppMethodBeat.i(38292);
        ab.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", Integer.valueOf(this.rkd), this.rkh, Integer.valueOf(this.rki), Integer.valueOf(this.dtW), Boolean.valueOf(bq.dpN()));
        if (bq.dpN() || this.rkd == 0 || bo.isNullOrNil(this.rkh) || this.rki == 1 || (this.dtW & 1) == 0) {
            this.rka.setVisibility(8);
            AppMethodBeat.o(38292);
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
        AppMethodBeat.o(38292);
    }

    public final void crS() {
        AppMethodBeat.i(38293);
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.oSn.toByteArray());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
        }
        if (!bo.isNullOrNil(this.rkh)) {
            intent.putExtra("get_poi_classify_id", this.rkh);
        } else if (!bo.isNullOrNil(this.dud)) {
            intent.putExtra("get_city", this.dud);
        }
        intent.putExtra("get_lat", this.fBr);
        intent.putExtra("get_lng", this.fBs);
        intent.putExtra("request_id", this.nQB);
        if (this.rkl != null) {
            ArrayList crV = this.rkl.crV();
            if (crV != null) {
                R(crV);
                ArrayList arrayList = new ArrayList();
                Iterator it = crV.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                    arrayList.add(String.format("%f\n%f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)}));
                }
            }
        }
        com.tencent.mm.bp.d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
        AppMethodBeat.o(38293);
    }

    private void R(ArrayList<com.tencent.mm.compatible.util.Exif.a> arrayList) {
        AppMethodBeat.i(38294);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(38294);
            return;
        }
        com.tencent.mm.compatible.util.Exif.a aVar;
        h.pYm.X(11139, "1");
        if (((double) Math.abs(-1000.0f - this.fBr)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.fBs)) > 1.0E-6d) {
            aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(arrayList.size() - 1);
            if (b(aVar.latitude, aVar.longitude, (double) this.fBr, (double) this.fBs)) {
                h.pYm.X(11139, "2");
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
                aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i);
                com.tencent.mm.compatible.util.Exif.a aVar2 = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i3);
                if (b(aVar.latitude, aVar.longitude, aVar2.latitude, aVar2.longitude)) {
                    h.pYm.X(11139, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                    obj = null;
                    break;
                }
                i2 = i3 + 1;
            }
            if (obj == null) {
                break;
            }
        }
        AppMethodBeat.o(38294);
    }

    private static boolean b(double d, double d2, double d3, double d4) {
        AppMethodBeat.i(38295);
        if (t.c(d, d2, d3, d4) > 1000.0d) {
            AppMethodBeat.o(38295);
            return true;
        }
        AppMethodBeat.o(38295);
        return false;
    }

    public final void stop() {
        AppMethodBeat.i(38296);
        if (this.oRD != null) {
            this.oRD.c(this.oRX);
        }
        if (this.nOO != null) {
            this.nOO.a(this.nJD);
        }
        AppMethodBeat.o(38296);
    }

    public final boolean ao(Intent intent) {
        AppMethodBeat.i(38297);
        if (intent == null) {
            AppMethodBeat.o(38297);
        } else {
            this.rki = intent.getIntExtra("get_poi_classify_type", 0);
            this.dtW = intent.getIntExtra("get_poi_showflag", 0);
            ab.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", Integer.valueOf(this.rki));
            this.eUu = bo.bc(intent.getStringExtra("get_poi_name"), "");
            this.dud = bo.bc(intent.getStringExtra("get_city"), "");
            this.fBr = intent.getFloatExtra("get_lat", -1000.0f);
            this.fBs = intent.getFloatExtra("get_lng", -1000.0f);
            ab.i("MicroMsg.LocationWidget", "check cur lat " + this.rkj + " " + this.oRJ);
            this.rkj = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.oRJ = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.rkk = intent.getIntExtra("get_loctype", -1);
            this.bEJ = intent.getFloatExtra("get_accuracy", 0.0f);
            this.fBD = intent.getBooleanExtra("get_is_mars", true);
            this.nQB = intent.getStringExtra("request_id");
            e.akf().a(2003, this.rkk != 0, this.fBD, this.fBs, this.fBr, (int) this.bEJ);
            this.rkf = intent.getByteArrayExtra("location_ctx");
            if (!bo.isNullOrNil(this.eUu)) {
                this.rkg = bo.bc(intent.getStringExtra("get_poi_address"), "");
                this.rkh = bo.bc(intent.getStringExtra("get_poi_classify_id"), "");
                this.oSn = new axw();
                try {
                    this.oSn = (axw) this.oSn.parseFrom(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
                    this.oSn = null;
                }
                if (!bo.isNullOrNil(this.rkh)) {
                    this.oSn = new axw();
                    this.oSn.oQU = this.rkh;
                    this.oSn.jCt = this.rki;
                    this.oSn.Title = this.eUu;
                    this.oSn.oQZ.add(new bts().alV(this.rkg));
                }
            } else if (bo.isNullOrNil(this.dud)) {
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
            ab.d("MicroMsg.LocationWidget", "label %s poiname %s", this.rkg, this.eUu);
            crT();
            crR();
            this.rkn = new b();
            b bVar = this.rkn;
            if (intent != null) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.oRM = intent.getLongExtra("first_start_time", 0);
                bVar.oRN = intent.getLongExtra("lastSuccStamp", 0);
                bVar.oRO = intent.getLongExtra("firstSuccStamp", 0);
                bVar.oRP = intent.getIntExtra("reqLoadCnt", 0);
                bVar.nPQ = intent.getIntExtra("entry_time", 0);
                bVar.hlm = intent.getStringExtra("search_id");
            }
            AppMethodBeat.o(38297);
        }
        return true;
    }

    private void crT() {
        AppMethodBeat.i(38298);
        if (!(this.rke == null || this.rii == null)) {
            if (!bo.isNullOrNil(this.eUu)) {
                this.rke.setText(this.eUu);
                this.rke.setTextColor(getResources().getColor(R.color.r8));
                this.rii.setVisibility(8);
            } else if (bo.isNullOrNil(this.dud)) {
                this.rke.setText(R.string.em8);
                this.rke.setTextColor(getResources().getColor(R.color.w4));
                this.rii.setVisibility(8);
            } else {
                this.rke.setText(this.dud);
                this.rke.setTextColor(getResources().getColor(R.color.r8));
                this.rii.setVisibility(8);
            }
        }
        if (bo.isNullOrNil(this.eUu) && bo.isNullOrNil(this.dud)) {
            this.rhd.setImageDrawable(ah.f(this.gNy, R.raw.album_location_icon_normal, WebView.NIGHT_MODE_COLOR));
            AppMethodBeat.o(38298);
            return;
        }
        this.rhd.setImageDrawable(ah.f(this.gNy, R.raw.album_location_icon_pressed, getContext().getResources().getColor(R.color.a61)));
        AppMethodBeat.o(38298);
    }

    /* Access modifiers changed, original: protected */
    public int getNormalStateImageResource() {
        return R.raw.album_location_icon_normal;
    }

    /* Access modifiers changed, original: protected */
    public int getSelectedStateImageResource() {
        return R.raw.album_location_icon_pressed;
    }

    /* Access modifiers changed, original: protected */
    public int getNormalStarImageResource() {
        return R.raw.sns_shoot_star_normal;
    }

    /* Access modifiers changed, original: protected */
    public int getSelectedStarImageResource() {
        return R.raw.sns_shoot_star_selected;
    }

    public ayt getLocation() {
        AppMethodBeat.i(38299);
        ayt ayt = new ayt();
        ayt.vRq = this.fBr;
        ayt.vRp = this.fBs;
        ayt.wCF = 0;
        ayt.score = this.score;
        if (this.rkf != null) {
            ayt.wCG = new com.tencent.mm.bt.b(this.rkf);
        }
        if (!bo.isNullOrNil(this.eUu)) {
            ayt.rkg = this.rkg;
            ayt.eUu = this.eUu;
            ayt.wCC = this.rkh;
            ayt.guP = this.dud;
            if (this.rki == 0 || this.rki != 1) {
                ayt.rki = 1;
            } else {
                ayt.rki = 2;
            }
            ab.d("MicroMsg.LocationWidget", "getlocation type %d", Integer.valueOf(ayt.rki));
        } else if (!bo.isNullOrNil(this.dud)) {
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
            ab.d("MicroMsg.LocationWidget", "report %s", stringBuffer.toString());
            h.pYm.e(11135, Integer.valueOf(5), Integer.valueOf(this.rkn.index + 1), Long.valueOf(this.rkn.oRM), Long.valueOf(this.rkn.oRO), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.rkn.oRN), Integer.valueOf(this.rkn.oRP), format, this.rkh, Integer.valueOf(this.rkn.nPQ), this.rkn.hlm, q.LK());
        }
        crU();
        AppMethodBeat.o(38299);
        return ayt;
    }

    public int getShowFlag() {
        return this.dtW;
    }

    public ayt getCurLocation() {
        AppMethodBeat.i(38300);
        ayt ayt = new ayt();
        ayt.vRq = this.rkj;
        ayt.vRp = this.oRJ;
        ayt.bEJ = this.bEJ;
        ayt.rkk = this.rkk;
        AppMethodBeat.o(38300);
        return ayt;
    }

    private void crU() {
        AppMethodBeat.i(38301);
        if (this.rkl != null) {
            boolean crW = this.rkl.crW();
            ArrayList crV = this.rkl.crV();
            if (crV == null || crV.size() == 0) {
                AppMethodBeat.o(38301);
                return;
            }
            Iterator it = crV.iterator();
            while (it.hasNext()) {
                int i;
                com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                ab.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude));
                h hVar = h.pYm;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf((int) (aVar.latitude * 1000000.0d));
                objArr[1] = Integer.valueOf((int) (aVar.longitude * 1000000.0d));
                if (crW) {
                    i = 1;
                } else {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(2);
                hVar.e(11345, objArr);
            }
        }
        AppMethodBeat.o(38301);
    }

    public void setLocationWidgetListener(a aVar) {
        this.rkl = aVar;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return R.layout.a__;
    }
}
