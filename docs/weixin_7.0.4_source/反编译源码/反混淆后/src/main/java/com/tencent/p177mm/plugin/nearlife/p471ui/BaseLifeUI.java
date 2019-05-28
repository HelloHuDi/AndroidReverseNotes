package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView.C36055a;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.nearlife.p1494b.C39461c;
import com.tencent.p177mm.plugin.nearlife.p471ui.LogoImageView.C39462a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C44072t;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.axx;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI */
public abstract class BaseLifeUI extends MMActivity implements C1202f {
    boolean eVT = false;
    boolean ecu = false;
    private C5601o elS;
    protected boolean fBD = true;
    boolean gxV = false;
    protected String hlm = "";
    private int nJK = 1;
    public int nPQ = -1;
    private boolean nPX;
    MMLoadMoreListView nPi;
    protected String nQB = "";
    private boolean oQo = false;
    private View oRA;
    private TextView oRB;
    private TextView oRC;
    private C26443d oRD = C26443d.agz();
    private C39461c oRE;
    private int oRF;
    private List<axx> oRG;
    protected axx oRH = null;
    protected float oRI = 0.0f;
    protected float oRJ = 0.0f;
    protected int oRK = 0;
    protected float oRL = 0.0f;
    protected long oRM = -1;
    protected long oRN = -1;
    protected long oRO = -1;
    protected int oRP = 0;
    protected boolean oRQ = false;
    protected int oRR = -1;
    protected boolean oRS = false;
    boolean oRT = false;
    protected boolean oRU = true;
    private OnClickListener oRV = new C213751();
    private OnClickListener oRW = new C286062();
    private C42206a oRX = new C213767();
    private String oRi = "";
    private View oRw;
    private NearLifeErrorContent oRx;
    private C46112a oRy;
    private C46112a oRz;
    int sceneType = 0;

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$1 */
    class C213751 implements OnClickListener {
        C213751() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22936);
            BaseLifeUI.m45415a(BaseLifeUI.this);
            AppMethodBeat.m2505o(22936);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$7 */
    class C213767 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$7$1 */
        class C213771 implements DialogInterface.OnClickListener {
            C213771() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(22947);
                C26443d.m42103bX(BaseLifeUI.this);
                AppMethodBeat.m2505o(22947);
            }
        }

        C213767() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(22948);
            if (BaseLifeUI.this.eVT) {
                AppMethodBeat.m2505o(22948);
                return false;
            } else if (BaseLifeUI.this.ecu) {
                AppMethodBeat.m2505o(22948);
                return false;
            } else if (z) {
                boolean z2;
                C18698o.m29222a(2003, f, f2, (int) d2);
                BaseLifeUI.this.ecu = true;
                C4990ab.m7417i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), Float.valueOf(f2), Float.valueOf(f));
                BaseLifeUI.this.oRH = new axx();
                BaseLifeUI.this.oRH.wfI = "";
                BaseLifeUI.this.oRH.wfJ = 0;
                BaseLifeUI.this.oRH.vRq = f2;
                BaseLifeUI.this.oRH.vRp = f;
                BaseLifeUI.this.oRH.wfH = "";
                BaseLifeUI.this.oRH.wfG = (int) d2;
                BaseLifeUI.this.oRI = f2;
                BaseLifeUI.this.oRJ = f;
                BaseLifeUI.this.oRK = i;
                BaseLifeUI.this.oRL = (float) d2;
                BaseLifeUI baseLifeUI = BaseLifeUI.this;
                if (BaseLifeUI.this.oRD == null) {
                    z2 = false;
                } else {
                    z2 = BaseLifeUI.this.oRD.fBD;
                }
                baseLifeUI.fBD = z2;
                ArrayList arrayList = BaseLifeUI.this.oRy.oRp;
                if (arrayList == null || arrayList.size() <= 0) {
                    BaseLifeUI.this.mo46734p((double) f2, (double) f);
                } else {
                    LatLongData latLongData = (LatLongData) arrayList.get(arrayList.size() - 1);
                    BaseLifeUI.this.mo46734p((double) latLongData.cEB, (double) latLongData.fFz);
                    BaseLifeUI.this.oRS = BaseLifeUI.m45426h(latLongData.cEB, latLongData.fFz, f2, f);
                }
                BaseLifeUI.this.oRy.oRt = new LatLongData(BaseLifeUI.this.oRH.vRq, BaseLifeUI.this.oRH.vRp);
                BaseLifeUI.this.oRz.oRt = new LatLongData(BaseLifeUI.this.oRH.vRq, BaseLifeUI.this.oRH.vRp);
                BaseLifeUI.m45416a(BaseLifeUI.this, BaseLifeUI.this.gxV ? BaseLifeUI.this.oRz : BaseLifeUI.this.oRy);
                BaseLifeUI.this.m45429jB(false);
                BaseLifeUI.this.mo17380a(BaseLifeUI.this.elS);
                AppMethodBeat.m2505o(22948);
                return false;
            } else {
                if (!(BaseLifeUI.this.nPX || C26443d.agA())) {
                    BaseLifeUI.this.nPX = true;
                    C30379h.m48445a(BaseLifeUI.this, BaseLifeUI.this.getString(C25738R.string.c9z), BaseLifeUI.this.getString(C25738R.string.f9238tz), BaseLifeUI.this.getString(C25738R.string.ckr), BaseLifeUI.this.getString(C25738R.string.f9076or), false, new C213771(), null);
                }
                AppMethodBeat.m2505o(22948);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$6 */
    class C286016 implements C36055a {
        C286016() {
        }

        /* renamed from: KB */
        public final void mo8166KB() {
            AppMethodBeat.m2504i(22946);
            BaseLifeUI.m45415a(BaseLifeUI.this);
            AppMethodBeat.m2505o(22946);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$3 */
    class C286023 implements OnMenuItemClickListener {
        C286023() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22938);
            BaseLifeUI.this.mo46730a(-1, false, "", BaseLifeUI.this.oRT);
            BaseLifeUI.this.finish();
            AppMethodBeat.m2505o(22938);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$4 */
    class C286034 implements OnClickListener {
        C286034() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22939);
            C4978c.m7375a(BaseLifeUI.this.nPi);
            AppMethodBeat.m2505o(22939);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$5 */
    class C286045 implements C5600b {

        /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$5$1 */
        class C286051 implements OnTouchListener {
            C286051() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(22940);
                BaseLifeUI.this.aqX();
                AppMethodBeat.m2505o(22940);
                return false;
            }
        }

        C286045() {
        }

        public final void apq() {
            AppMethodBeat.m2504i(22941);
            C4990ab.m7410d("MicroMsg.BaseLifeUI", "click clear");
            if (BaseLifeUI.this.oRE != null) {
                C9638aw.m17182Rg().mo14547c(BaseLifeUI.this.oRE);
                BaseLifeUI.this.oRE = null;
            }
            BaseLifeUI.this.oRz.bVj();
            BaseLifeUI.this.m45414Ae(8);
            AppMethodBeat.m2505o(22941);
        }

        public final void apr() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(22942);
            C4990ab.m7411d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", str);
            if (C5046bo.isNullOrNil(str)) {
                apq();
                AppMethodBeat.m2505o(22942);
                return;
            }
            BaseLifeUI.m45417a(BaseLifeUI.this, str);
            AppMethodBeat.m2505o(22942);
        }

        public final void apo() {
            AppMethodBeat.m2504i(22943);
            C4990ab.m7410d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
            BaseLifeUI.this.gxV = false;
            BaseLifeUI.this.nPi.setAdapter(BaseLifeUI.this.oRy);
            BaseLifeUI.this.oRy.notifyDataSetChanged();
            BaseLifeUI.this.oRx.mo8077Af(BaseLifeUI.this.oRy.oRv);
            if (!(BaseLifeUI.this.oRy.bVl() || BaseLifeUI.this.oRw == null)) {
                BaseLifeUI.this.oRw.setVisibility(0);
            }
            BaseLifeUI.this.nPi.setOnTouchListener(null);
            BaseLifeUI.this.m45414Ae(8);
            BaseLifeUI.m45416a(BaseLifeUI.this, BaseLifeUI.this.oRy);
            AppMethodBeat.m2505o(22943);
        }

        public final void app() {
            AppMethodBeat.m2504i(22944);
            C4990ab.m7410d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
            BaseLifeUI.this.oRQ = true;
            BaseLifeUI.this.elS.setHint(BaseLifeUI.this.getString(C25738R.string.d4f));
            BaseLifeUI.this.gxV = true;
            BaseLifeUI.this.oRz.bVj();
            BaseLifeUI.this.nPi.setAdapter(BaseLifeUI.this.oRz);
            BaseLifeUI.this.oRz.notifyDataSetChanged();
            BaseLifeUI.this.nPi.dzO();
            BaseLifeUI.this.oRx.mo8077Af(BaseLifeUI.this.oRz.oRv);
            if (BaseLifeUI.this.oRw != null) {
                BaseLifeUI.this.oRw.setVisibility(8);
            }
            BaseLifeUI.this.nPi.setOnTouchListener(new C286051());
            BaseLifeUI.m45416a(BaseLifeUI.this, BaseLifeUI.this.oRz);
            AppMethodBeat.m2505o(22944);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            AppMethodBeat.m2504i(22945);
            C4990ab.m7410d("MicroMsg.BaseLifeUI", "search key click");
            BaseLifeUI.m45419b(BaseLifeUI.this, str);
            AppMethodBeat.m2505o(22945);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearlife.ui.BaseLifeUI$2 */
    class C286062 implements OnClickListener {
        C286062() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22937);
            if (BaseLifeUI.this.oRH == null) {
                C4990ab.m7412e("MicroMsg.BaseLifeUI", "Location is null");
                AppMethodBeat.m2505o(22937);
                return;
            }
            C7060h.pYm.mo8381e(11138, "1", Integer.valueOf(BaseLifeUI.this.oRz.getCount() + 1), BaseLifeUI.this.hlm);
            Intent intent = new Intent();
            intent.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
            intent.putExtra("get_lat", BaseLifeUI.this.oRH.vRq);
            intent.putExtra("get_lng", BaseLifeUI.this.oRH.vRp);
            intent.putExtra("get_preci", BaseLifeUI.this.oRH.wfG);
            intent.putExtra("get_poi_name", BaseLifeUI.this.oRz.bVk());
            intent.putExtra("get_cur_lat", BaseLifeUI.this.oRI);
            intent.putExtra("get_cur_lng", BaseLifeUI.this.oRJ);
            intent.putExtra("get_accuracy", BaseLifeUI.this.oRL);
            intent.putExtra("get_loctype", BaseLifeUI.this.oRK);
            intent.putExtra("search_id", BaseLifeUI.this.hlm);
            intent.putExtra("get_is_mars", BaseLifeUI.this.fBD);
            BaseLifeUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(22937);
        }
    }

    public abstract C46112a bVm();

    public abstract C46112a bVn();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: p */
    public abstract void mo46734p(double d, double d2);

    public void bVo() {
        C4990ab.m7410d("MicroMsg.BaseLifeUI", "init header");
        this.oRA = View.inflate(this, 2130969252, null);
        this.oRB = (TextView) this.oRA.findViewById(2131823167);
        this.oRC = (TextView) this.oRA.findViewById(2131823166);
        this.oRA.setOnClickListener(this.oRW);
        this.oRw = View.inflate(this, 2130970372, null);
        this.nPi.addFooterView(this.oRw);
        this.oRw.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oRU = getIntent().getBooleanExtra("poi_show_none", true);
        this.nPQ = (int) (System.currentTimeMillis() / 1000);
        C39461c.clear();
        C9638aw.m17182Rg().mo14539a(603, (C1202f) this);
        this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
        this.nQB = getIntent().getStringExtra("request_id");
        this.oRG = new ArrayList();
        initView();
    }

    public final void initView() {
        this.nPi = (MMLoadMoreListView) findViewById(2131826292);
        this.nPi.setFooterTips(getString(C25738R.string.d4g));
        this.oRx = (NearLifeErrorContent) findViewById(2131826293);
        bVo();
        this.oRy = bVm();
        this.oRz = bVn();
        this.nPi.setAdapter(this.oRy);
        this.oRx.setListView(this.nPi);
        this.oRy.notifyDataSetChanged();
        setBackBtn(new C286023());
        C286034 c286034 = new C286034();
        this.elS = new C5601o((byte) 0);
        this.elS.zHa = new C286045();
        this.nPi.setOnLoadMoreListener(new C286016());
        this.nPi.dzN();
    }

    public void onResume() {
        super.onResume();
        this.oRy.notifyDataSetChanged();
        this.nPi.dzP();
        if (this.oRD != null) {
            this.oRD.mo44204a(this.oRX, true);
        }
        this.eVT = false;
    }

    public void onDestroy() {
        C9638aw.m17182Rg().mo14546b(603, (C1202f) this);
        super.onDestroy();
        if (this.oRD != null) {
            this.oRD.mo44208c(this.oRX);
        }
    }

    public void onPause() {
        super.onPause();
        this.oRD.mo44208c(this.oRX);
    }

    public int getLayoutId() {
        return 2130970285;
    }

    /* renamed from: jB */
    private boolean m45429jB(boolean z) {
        while (this.oRE == null) {
            if (this.oRG.size() - 1 <= this.oRF) {
                this.oRF = -1;
                C4990ab.m7416i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            int b;
            this.oRF++;
            axx axx = (axx) this.oRG.get(this.oRF);
            if (this.oRF == 0) {
                this.oRP++;
            }
            if (this.gxV) {
                b = this.oRz.mo74050b(new LatLongData(axx.vRq, axx.vRp));
                continue;
            } else {
                b = this.oRy.mo74050b(new LatLongData(axx.vRq, axx.vRp));
                continue;
            }
            if (b > 0) {
                SKBuiltinBuffer_t a;
                if (this.gxV) {
                    a = this.oRz.mo74046a(new LatLongData(axx.vRq, axx.vRp));
                } else {
                    a = this.oRy.mo74046a(new LatLongData(axx.vRq, axx.vRp));
                }
                int i = this.gxV ? 1 : 0;
                if (C39461c.m67433Ab(i)) {
                    if (-1 == this.oRM) {
                        this.oRM = System.currentTimeMillis();
                    }
                    this.oRE = new C39461c(i, this.sceneType, axx.vRp, axx.vRq, axx.wfG, axx.wfJ, axx.wfH, axx.wfI, a, this.gxV ? this.oRz.bVk() : "", this.nPQ, z, false);
                    C9638aw.m17182Rg().mo14541a(this.oRE, 0);
                    C4990ab.m7417i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", Integer.valueOf(this.oRF), Float.valueOf(axx.vRq), Float.valueOf(axx.vRp));
                    return true;
                }
                this.oRF = -1;
                return false;
            }
        }
        C4990ab.m7410d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        if (c1207m.getType() == 603) {
            this.nPi.dzO();
            C39461c c39461c = (C39461c) c1207m;
            if (!C5046bo.isNullOrNil(c39461c.oRi)) {
                this.oRi = c39461c.oRi;
                LogoImageView logoImageView = (LogoImageView) this.oRw.findViewById(2131826563);
                String str2 = this.oRi;
                C9638aw.m17190ZK();
                logoImageView.imagePath = C18628c.m29089XX();
                logoImageView.url = str2;
                logoImageView.eTi = 0;
                logoImageView.eTj = 0;
                Bitmap decodeFile;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    decodeFile = BitmapFactory.decodeFile(logoImageView.imagePath + C1178g.m2591x(str2.getBytes()));
                    if (decodeFile != null) {
                        if (logoImageView.eTi > 0 && logoImageView.eTj > 0) {
                            decodeFile = C5056d.m7615a(decodeFile, logoImageView.eTi, logoImageView.eTj, true, false);
                        }
                        logoImageView.setImageBitmap(decodeFile);
                    } else {
                        C7305d.post(new C39462a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (C1173e.m2561ct(str2)) {
                    if (logoImageView.eTi <= 0 || logoImageView.eTj <= 0) {
                        decodeFile = C5056d.aml(str2);
                    } else {
                        decodeFile = C5056d.m7659d(str2, logoImageView.eTi, logoImageView.eTj, true);
                    }
                    if (decodeFile == null) {
                        logoImageView.setVisibility(8);
                    } else {
                        logoImageView.setImageBitmap(decodeFile);
                    }
                } else {
                    logoImageView.setVisibility(8);
                }
            }
            this.hlm = c39461c.hlm;
            this.nJK = c39461c.nJK;
            C39461c.m67434Ac(((C39461c) c1207m).czE);
            if (this.oRE == null) {
                C4990ab.m7410d("MicroMsg.BaseLifeUI", "scene is null");
                return;
            }
            C4990ab.m7417i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", Integer.valueOf(this.oRF), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r1));
            boolean z = i2 == 0 || i2 == 101;
            C46112a c46112a;
            if (i == 0 || z) {
                if (-1 == this.oRN) {
                    this.oRN = System.currentTimeMillis();
                }
                this.oRO = System.currentTimeMillis();
                List list = c39461c.oRj;
                axx axx = (axx) this.oRG.get(this.oRF);
                LatLongData latLongData = new LatLongData(axx.vRq, axx.vRp);
                if (this.gxV && !this.oRE.oRk) {
                    this.oRz.bVj();
                }
                if (this.gxV) {
                    this.oRz.mo74048a(latLongData, c39461c.bVi(), c39461c.bVh());
                } else {
                    this.oRy.mo74048a(latLongData, c39461c.bVi(), c39461c.bVh());
                }
                if (list == null || list.size() == 0) {
                    if (this.gxV) {
                        c46112a = this.oRz;
                    } else {
                        c46112a = this.oRy;
                    }
                    if (this.oRG.size() - 1 == this.oRF) {
                        if (c46112a.getCount() == 0) {
                            this.oRx.mo8077Af(c46112a.oRv);
                        }
                        this.nPi.dzO();
                        if (!(c46112a.bVl() || i2 == 101)) {
                            bVp();
                        }
                    }
                } else {
                    if (this.gxV) {
                        c46112a = this.oRz;
                    } else {
                        c46112a = this.oRy;
                    }
                    this.nPi.setVisibility(0);
                    c46112a.oRv = 0;
                    this.oRx.mo8077Af(this.oRz.oRv);
                    c46112a.mo74049a(latLongData, list);
                    c46112a.notifyDataSetChanged();
                    if (this.oRG.size() - 1 == this.oRF && !c46112a.bVl()) {
                        this.nPi.dzO();
                        bVp();
                    }
                }
                if (!(this.oRy.bVl() || this.oRw == null || this.gxV)) {
                    this.oRw.setVisibility(0);
                }
                if (this.oRw != null && !this.gxV) {
                    this.oRw.setVisibility(0);
                } else if (this.oRw != null) {
                    this.oRw.setVisibility(8);
                }
            } else {
                C4990ab.m7410d("MicroMsg.BaseLifeUI", "error");
                if (this.gxV) {
                    c46112a = this.oRz;
                } else {
                    c46112a = this.oRy;
                }
                if (this.oRG.size() - 1 == this.oRF && c46112a.getCount() == 0) {
                    c46112a.oRv = 1;
                    this.oRx.mo8077Af(c46112a.oRv);
                }
            }
            this.oRE = null;
            m45429jB(false);
        }
    }

    private void bVp() {
        if (this.gxV) {
            try {
                C4990ab.m7417i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", Integer.valueOf(Integer.valueOf(C26373g.m41964Nu().getValue("POICreateForbiden")).intValue()));
                if (Integer.valueOf(C26373g.m41964Nu().getValue("POICreateForbiden")).intValue() == 1) {
                    return;
                }
            } catch (Exception e) {
            }
            if (this.oRz.mo74044TD(this.oRz.bVk())) {
                m45414Ae(8);
                return;
            }
            this.oRB.setText(String.format(getResources().getString(C25738R.string.d74), new Object[]{this.oRz.bVk()}));
            m45414Ae(0);
            return;
        }
        C4990ab.m7416i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C4990ab.m7411d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo46730a(int i, boolean z, String str, boolean z2) {
        int i2;
        String str2;
        if (str != null && str.startsWith("mm_")) {
            str = "";
        }
        String str3 = "";
        String str4 = "";
        if (i >= 0) {
            i2 = z ? z2 ? 43 : 3 : z2 ? 41 : 1;
            if (this.oRS) {
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(z ? 5 : 4);
                c7060h.mo8381e(11139, objArr);
            }
            if (z) {
                str3 = this.oRz.getItem(i).nQA;
                if (this.oRz.getCount() > 0) {
                    str2 = this.oRz.getItem(1).nQB;
                }
                str2 = str4;
            } else {
                str3 = this.oRy.getItem(i).nQA;
                if (this.oRy.getCount() > 0) {
                    str2 = this.oRy.getItem(1).nQB;
                }
                str2 = str4;
            }
            if (C5046bo.isNullOrNil(str2)) {
                str2 = this.nQB;
            }
        } else {
            i2 = this.oRQ ? z2 ? 44 : 4 : z2 ? 42 : 2;
            str2 = str4;
        }
        if (this.oRH == null) {
            str4 = "null/null";
        } else {
            str4 = String.format("%f/%f", new Object[]{Float.valueOf(this.oRH.vRq), Float.valueOf(this.oRH.vRp)});
        }
        C4990ab.m7411d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", Integer.valueOf(i + 1), str, Integer.valueOf(i), str3, str2);
        C7060h.pYm.mo8381e(11135, Integer.valueOf(i2), Integer.valueOf(i + 1), Long.valueOf(this.oRM), Long.valueOf(this.oRO), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.oRN), Integer.valueOf(this.oRP), str4, str, Integer.valueOf(this.nPQ), str3, C1427q.m3026LK(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str2);
    }

    /* renamed from: Ae */
    private void m45414Ae(int i) {
        this.nPi.removeFooterView(this.oRw);
        this.nPi.removeFooterView(this.oRA);
        this.nPi.dzQ();
        this.oRA.setVisibility(i);
        this.oRB.setVisibility(i);
        this.oRC.setVisibility(i);
        if (i == 0) {
            this.nPi.addFooterView(this.oRA);
            return;
        }
        this.nPi.dzM();
        this.nPi.addFooterView(this.oRw);
    }

    /* renamed from: a */
    static /* synthetic */ void m45415a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.oRF != -1 || baseLifeUI.oRE != null) {
            C4990ab.m7416i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.m45429jB(true)) {
            baseLifeUI.nPi.dzP();
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m45419b(BaseLifeUI baseLifeUI, String str) {
        if (!C5046bo.isNullOrNil(str)) {
            if (baseLifeUI.oRE == null || !str.equals(baseLifeUI.oRE.oRh)) {
                baseLifeUI.m45414Ae(8);
                if (baseLifeUI.oRE != null) {
                    C9638aw.m17182Rg().mo14547c(baseLifeUI.oRE);
                }
                if (baseLifeUI.oRH != null) {
                    baseLifeUI.oRz.bVj();
                    baseLifeUI.oRz.mo74042TB(str);
                    baseLifeUI.m45429jB(false);
                    baseLifeUI.nPi.dzP();
                }
            }
        }
    }

    /* renamed from: h */
    static /* synthetic */ boolean m45426h(float f, float f2, float f3, float f4) {
        return C44072t.m79222c((double) f, (double) f2, (double) f3, (double) f4) > 1000.0d;
    }
}
