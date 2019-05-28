package com.tencent.mm.plugin.nearlife.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.nearlife.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLifeUI extends MMActivity implements f {
    boolean eVT = false;
    boolean ecu = false;
    private o elS;
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
    private d oRD = d.agz();
    private c oRE;
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
    private OnClickListener oRV = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22936);
            BaseLifeUI.a(BaseLifeUI.this);
            AppMethodBeat.o(22936);
        }
    };
    private OnClickListener oRW = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22937);
            if (BaseLifeUI.this.oRH == null) {
                ab.e("MicroMsg.BaseLifeUI", "Location is null");
                AppMethodBeat.o(22937);
                return;
            }
            h.pYm.e(11138, "1", Integer.valueOf(BaseLifeUI.this.oRz.getCount() + 1), BaseLifeUI.this.hlm);
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
            AppMethodBeat.o(22937);
        }
    };
    private a oRX = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(22948);
            if (BaseLifeUI.this.eVT) {
                AppMethodBeat.o(22948);
                return false;
            } else if (BaseLifeUI.this.ecu) {
                AppMethodBeat.o(22948);
                return false;
            } else if (z) {
                boolean z2;
                com.tencent.mm.modelstat.o.a(2003, f, f2, (int) d2);
                BaseLifeUI.this.ecu = true;
                ab.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), Float.valueOf(f2), Float.valueOf(f));
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
                    BaseLifeUI.this.p((double) f2, (double) f);
                } else {
                    LatLongData latLongData = (LatLongData) arrayList.get(arrayList.size() - 1);
                    BaseLifeUI.this.p((double) latLongData.cEB, (double) latLongData.fFz);
                    BaseLifeUI.this.oRS = BaseLifeUI.h(latLongData.cEB, latLongData.fFz, f2, f);
                }
                BaseLifeUI.this.oRy.oRt = new LatLongData(BaseLifeUI.this.oRH.vRq, BaseLifeUI.this.oRH.vRp);
                BaseLifeUI.this.oRz.oRt = new LatLongData(BaseLifeUI.this.oRH.vRq, BaseLifeUI.this.oRH.vRp);
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.gxV ? BaseLifeUI.this.oRz : BaseLifeUI.this.oRy);
                BaseLifeUI.this.jB(false);
                BaseLifeUI.this.a(BaseLifeUI.this.elS);
                AppMethodBeat.o(22948);
                return false;
            } else {
                if (!(BaseLifeUI.this.nPX || d.agA())) {
                    BaseLifeUI.this.nPX = true;
                    com.tencent.mm.ui.base.h.a(BaseLifeUI.this, BaseLifeUI.this.getString(R.string.c9z), BaseLifeUI.this.getString(R.string.tz), BaseLifeUI.this.getString(R.string.ckr), BaseLifeUI.this.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22947);
                            d.bX(BaseLifeUI.this);
                            AppMethodBeat.o(22947);
                        }
                    }, null);
                }
                AppMethodBeat.o(22948);
                return true;
            }
        }
    };
    private String oRi = "";
    private View oRw;
    private NearLifeErrorContent oRx;
    private a oRy;
    private a oRz;
    int sceneType = 0;

    public abstract a bVm();

    public abstract a bVn();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public abstract void p(double d, double d2);

    public void bVo() {
        ab.d("MicroMsg.BaseLifeUI", "init header");
        this.oRA = View.inflate(this, R.layout.ri, null);
        this.oRB = (TextView) this.oRA.findViewById(R.id.b6w);
        this.oRC = (TextView) this.oRA.findViewById(R.id.b6v);
        this.oRA.setOnClickListener(this.oRW);
        this.oRw = View.inflate(this, R.layout.akp, null);
        this.nPi.addFooterView(this.oRw);
        this.oRw.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oRU = getIntent().getBooleanExtra("poi_show_none", true);
        this.nPQ = (int) (System.currentTimeMillis() / 1000);
        c.clear();
        aw.Rg().a(603, (f) this);
        this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
        this.nQB = getIntent().getStringExtra("request_id");
        this.oRG = new ArrayList();
        initView();
    }

    public final void initView() {
        this.nPi = (MMLoadMoreListView) findViewById(R.id.dgd);
        this.nPi.setFooterTips(getString(R.string.d4g));
        this.oRx = (NearLifeErrorContent) findViewById(R.id.dge);
        bVo();
        this.oRy = bVm();
        this.oRz = bVn();
        this.nPi.setAdapter(this.oRy);
        this.oRx.setListView(this.nPi);
        this.oRy.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22938);
                BaseLifeUI.this.a(-1, false, "", BaseLifeUI.this.oRT);
                BaseLifeUI.this.finish();
                AppMethodBeat.o(22938);
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22939);
                BackwardSupportUtil.c.a(BaseLifeUI.this.nPi);
                AppMethodBeat.o(22939);
            }
        };
        this.elS = new o((byte) 0);
        this.elS.zHa = new b() {
            public final void apq() {
                AppMethodBeat.i(22941);
                ab.d("MicroMsg.BaseLifeUI", "click clear");
                if (BaseLifeUI.this.oRE != null) {
                    aw.Rg().c(BaseLifeUI.this.oRE);
                    BaseLifeUI.this.oRE = null;
                }
                BaseLifeUI.this.oRz.bVj();
                BaseLifeUI.this.Ae(8);
                AppMethodBeat.o(22941);
            }

            public final void apr() {
            }

            public final void vO(String str) {
                AppMethodBeat.i(22942);
                ab.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", str);
                if (bo.isNullOrNil(str)) {
                    apq();
                    AppMethodBeat.o(22942);
                    return;
                }
                BaseLifeUI.a(BaseLifeUI.this, str);
                AppMethodBeat.o(22942);
            }

            public final void apo() {
                AppMethodBeat.i(22943);
                ab.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
                BaseLifeUI.this.gxV = false;
                BaseLifeUI.this.nPi.setAdapter(BaseLifeUI.this.oRy);
                BaseLifeUI.this.oRy.notifyDataSetChanged();
                BaseLifeUI.this.oRx.Af(BaseLifeUI.this.oRy.oRv);
                if (!(BaseLifeUI.this.oRy.bVl() || BaseLifeUI.this.oRw == null)) {
                    BaseLifeUI.this.oRw.setVisibility(0);
                }
                BaseLifeUI.this.nPi.setOnTouchListener(null);
                BaseLifeUI.this.Ae(8);
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.oRy);
                AppMethodBeat.o(22943);
            }

            public final void app() {
                AppMethodBeat.i(22944);
                ab.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
                BaseLifeUI.this.oRQ = true;
                BaseLifeUI.this.elS.setHint(BaseLifeUI.this.getString(R.string.d4f));
                BaseLifeUI.this.gxV = true;
                BaseLifeUI.this.oRz.bVj();
                BaseLifeUI.this.nPi.setAdapter(BaseLifeUI.this.oRz);
                BaseLifeUI.this.oRz.notifyDataSetChanged();
                BaseLifeUI.this.nPi.dzO();
                BaseLifeUI.this.oRx.Af(BaseLifeUI.this.oRz.oRv);
                if (BaseLifeUI.this.oRw != null) {
                    BaseLifeUI.this.oRw.setVisibility(8);
                }
                BaseLifeUI.this.nPi.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(22940);
                        BaseLifeUI.this.aqX();
                        AppMethodBeat.o(22940);
                        return false;
                    }
                });
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.oRz);
                AppMethodBeat.o(22944);
            }

            public final boolean vN(String str) {
                AppMethodBeat.i(22945);
                ab.d("MicroMsg.BaseLifeUI", "search key click");
                BaseLifeUI.b(BaseLifeUI.this, str);
                AppMethodBeat.o(22945);
                return false;
            }
        };
        this.nPi.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            public final void KB() {
                AppMethodBeat.i(22946);
                BaseLifeUI.a(BaseLifeUI.this);
                AppMethodBeat.o(22946);
            }
        });
        this.nPi.dzN();
    }

    public void onResume() {
        super.onResume();
        this.oRy.notifyDataSetChanged();
        this.nPi.dzP();
        if (this.oRD != null) {
            this.oRD.a(this.oRX, true);
        }
        this.eVT = false;
    }

    public void onDestroy() {
        aw.Rg().b(603, (f) this);
        super.onDestroy();
        if (this.oRD != null) {
            this.oRD.c(this.oRX);
        }
    }

    public void onPause() {
        super.onPause();
        this.oRD.c(this.oRX);
    }

    public int getLayoutId() {
        return R.layout.aid;
    }

    private boolean jB(boolean z) {
        while (this.oRE == null) {
            if (this.oRG.size() - 1 <= this.oRF) {
                this.oRF = -1;
                ab.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            int b;
            this.oRF++;
            axx axx = (axx) this.oRG.get(this.oRF);
            if (this.oRF == 0) {
                this.oRP++;
            }
            if (this.gxV) {
                b = this.oRz.b(new LatLongData(axx.vRq, axx.vRp));
                continue;
            } else {
                b = this.oRy.b(new LatLongData(axx.vRq, axx.vRp));
                continue;
            }
            if (b > 0) {
                SKBuiltinBuffer_t a;
                if (this.gxV) {
                    a = this.oRz.a(new LatLongData(axx.vRq, axx.vRp));
                } else {
                    a = this.oRy.a(new LatLongData(axx.vRq, axx.vRp));
                }
                int i = this.gxV ? 1 : 0;
                if (c.Ab(i)) {
                    if (-1 == this.oRM) {
                        this.oRM = System.currentTimeMillis();
                    }
                    this.oRE = new c(i, this.sceneType, axx.vRp, axx.vRq, axx.wfG, axx.wfJ, axx.wfH, axx.wfI, a, this.gxV ? this.oRz.bVk() : "", this.nPQ, z, false);
                    aw.Rg().a(this.oRE, 0);
                    ab.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", Integer.valueOf(this.oRF), Float.valueOf(axx.vRq), Float.valueOf(axx.vRp));
                    return true;
                }
                this.oRF = -1;
                return false;
            }
        }
        ab.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        if (mVar.getType() == 603) {
            this.nPi.dzO();
            c cVar = (c) mVar;
            if (!bo.isNullOrNil(cVar.oRi)) {
                this.oRi = cVar.oRi;
                LogoImageView logoImageView = (LogoImageView) this.oRw.findViewById(R.id.dnp);
                String str2 = this.oRi;
                aw.ZK();
                logoImageView.imagePath = com.tencent.mm.model.c.XX();
                logoImageView.url = str2;
                logoImageView.eTi = 0;
                logoImageView.eTj = 0;
                Bitmap decodeFile;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    decodeFile = BitmapFactory.decodeFile(logoImageView.imagePath + g.x(str2.getBytes()));
                    if (decodeFile != null) {
                        if (logoImageView.eTi > 0 && logoImageView.eTj > 0) {
                            decodeFile = com.tencent.mm.sdk.platformtools.d.a(decodeFile, logoImageView.eTi, logoImageView.eTj, true, false);
                        }
                        logoImageView.setImageBitmap(decodeFile);
                    } else {
                        com.tencent.mm.sdk.g.d.post(new a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (e.ct(str2)) {
                    if (logoImageView.eTi <= 0 || logoImageView.eTj <= 0) {
                        decodeFile = com.tencent.mm.sdk.platformtools.d.aml(str2);
                    } else {
                        decodeFile = com.tencent.mm.sdk.platformtools.d.d(str2, logoImageView.eTi, logoImageView.eTj, true);
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
            this.hlm = cVar.hlm;
            this.nJK = cVar.nJK;
            c.Ac(((c) mVar).czE);
            if (this.oRE == null) {
                ab.d("MicroMsg.BaseLifeUI", "scene is null");
                return;
            }
            ab.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", Integer.valueOf(this.oRF), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r1));
            boolean z = i2 == 0 || i2 == 101;
            a aVar;
            if (i == 0 || z) {
                if (-1 == this.oRN) {
                    this.oRN = System.currentTimeMillis();
                }
                this.oRO = System.currentTimeMillis();
                List list = cVar.oRj;
                axx axx = (axx) this.oRG.get(this.oRF);
                LatLongData latLongData = new LatLongData(axx.vRq, axx.vRp);
                if (this.gxV && !this.oRE.oRk) {
                    this.oRz.bVj();
                }
                if (this.gxV) {
                    this.oRz.a(latLongData, cVar.bVi(), cVar.bVh());
                } else {
                    this.oRy.a(latLongData, cVar.bVi(), cVar.bVh());
                }
                if (list == null || list.size() == 0) {
                    if (this.gxV) {
                        aVar = this.oRz;
                    } else {
                        aVar = this.oRy;
                    }
                    if (this.oRG.size() - 1 == this.oRF) {
                        if (aVar.getCount() == 0) {
                            this.oRx.Af(aVar.oRv);
                        }
                        this.nPi.dzO();
                        if (!(aVar.bVl() || i2 == 101)) {
                            bVp();
                        }
                    }
                } else {
                    if (this.gxV) {
                        aVar = this.oRz;
                    } else {
                        aVar = this.oRy;
                    }
                    this.nPi.setVisibility(0);
                    aVar.oRv = 0;
                    this.oRx.Af(this.oRz.oRv);
                    aVar.a(latLongData, list);
                    aVar.notifyDataSetChanged();
                    if (this.oRG.size() - 1 == this.oRF && !aVar.bVl()) {
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
                ab.d("MicroMsg.BaseLifeUI", "error");
                if (this.gxV) {
                    aVar = this.oRz;
                } else {
                    aVar = this.oRy;
                }
                if (this.oRG.size() - 1 == this.oRF && aVar.getCount() == 0) {
                    aVar.oRv = 1;
                    this.oRx.Af(aVar.oRv);
                }
            }
            this.oRE = null;
            jB(false);
        }
    }

    private void bVp() {
        if (this.gxV) {
            try {
                ab.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", Integer.valueOf(Integer.valueOf(com.tencent.mm.m.g.Nu().getValue("POICreateForbiden")).intValue()));
                if (Integer.valueOf(com.tencent.mm.m.g.Nu().getValue("POICreateForbiden")).intValue() == 1) {
                    return;
                }
            } catch (Exception e) {
            }
            if (this.oRz.TD(this.oRz.bVk())) {
                Ae(8);
                return;
            }
            this.oRB.setText(String.format(getResources().getString(R.string.d74), new Object[]{this.oRz.bVk()}));
            Ae(0);
            return;
        }
        ab.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ab.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", Integer.valueOf(i), Integer.valueOf(i2));
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
    public final void a(int i, boolean z, String str, boolean z2) {
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
                h hVar = h.pYm;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(z ? 5 : 4);
                hVar.e(11139, objArr);
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
            if (bo.isNullOrNil(str2)) {
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
        ab.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", Integer.valueOf(i + 1), str, Integer.valueOf(i), str3, str2);
        h.pYm.e(11135, Integer.valueOf(i2), Integer.valueOf(i + 1), Long.valueOf(this.oRM), Long.valueOf(this.oRO), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.oRN), Integer.valueOf(this.oRP), str4, str, Integer.valueOf(this.nPQ), str3, q.LK(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str2);
    }

    private void Ae(int i) {
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

    static /* synthetic */ void a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.oRF != -1 || baseLifeUI.oRE != null) {
            ab.i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.jB(true)) {
            baseLifeUI.nPi.dzP();
        }
    }

    static /* synthetic */ void b(BaseLifeUI baseLifeUI, String str) {
        if (!bo.isNullOrNil(str)) {
            if (baseLifeUI.oRE == null || !str.equals(baseLifeUI.oRE.oRh)) {
                baseLifeUI.Ae(8);
                if (baseLifeUI.oRE != null) {
                    aw.Rg().c(baseLifeUI.oRE);
                }
                if (baseLifeUI.oRH != null) {
                    baseLifeUI.oRz.bVj();
                    baseLifeUI.oRz.TB(str);
                    baseLifeUI.jB(false);
                    baseLifeUI.nPi.dzP();
                }
            }
        }
    }

    static /* synthetic */ boolean h(float f, float f2, float f3, float f4) {
        return t.c((double) f, (double) f2, (double) f3, (double) f4) > 1000.0d;
    }
}
