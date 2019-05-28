package com.tencent.mm.plugin.scanner.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.scanner.a.c;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI extends MMPreference implements f, com.tencent.mm.platformtools.x.a {
    private long cvx;
    private d ecr;
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(81079);
            if (z) {
                ab.i("MicroMsg.scanner.ProductUI", "getLocation suc");
                if (ProductUI.this.qdc != null) {
                    ab.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + f + ", lat=" + f2);
                    g.Rg().a(new c(ProductUI.this.kWz, l.cU(ProductUI.this.qdc.qiL), ProductUI.this.gOW, ProductUI.this.qdk, (double) f, (double) f2), 0);
                }
                if (ProductUI.this.ecr != null) {
                    ProductUI.this.ecr.c(ProductUI.this.ecy);
                }
                if (!ProductUI.this.fwx) {
                    ProductUI.this.fwx = true;
                    o.a(2011, f, f2, (int) d2);
                }
                AppMethodBeat.o(81079);
                return false;
            }
            if (!(ProductUI.this.nPX || d.agA())) {
                ProductUI.this.nPX = true;
                h.a(ProductUI.this, ProductUI.this.getString(R.string.c9z), ProductUI.this.getString(R.string.tz), ProductUI.this.getString(R.string.ckr), ProductUI.this.getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(81078);
                        d.bX(ProductUI.this);
                        AppMethodBeat.o(81078);
                    }
                }, null);
            }
            ab.w("MicroMsg.scanner.ProductUI", "getLocation fail");
            AppMethodBeat.o(81079);
            return false;
        }
    };
    protected ProgressDialog ehJ = null;
    protected com.tencent.mm.ui.base.preference.f ehK;
    private boolean fwx = false;
    private int gOW;
    private TextView gne;
    private TextView gsS;
    private com.tencent.mm.sdk.b.c hAA = new com.tencent.mm.sdk.b.c<ke>() {
        {
            AppMethodBeat.i(81083);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(81083);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(81084);
            switch (((ke) bVar).cFH.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    if (ProductUI.this.ehK != null) {
                        ProductUI.q(ProductUI.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(81084);
            return false;
        }
    };
    private String kWz;
    private long mStartTime;
    private boolean nPX;
    private List<MusicPreference> oMb;
    private ImageView qcU;
    private ImageView qcV;
    private View qcW;
    private TextView qcX;
    private ImageView qcY;
    private View qcZ;
    private LinearLayout qda;
    private ImageView qdb;
    private com.tencent.mm.plugin.scanner.util.o.a qdc;
    private View qdd;
    private int qde = 0;
    private int qdf;
    private a qdg;
    private boolean qdh = false;
    private HashMap<String, Boolean> qdi;
    private com.tencent.mm.plugin.scanner.ui.e.a qdj;
    private String qdk;
    private boolean qdl = false;
    private String qdm;
    private boolean qdn = false;
    private boolean qdo = false;
    private boolean qdp = false;
    private com.tencent.mm.plugin.scanner.history.a.a qdq;
    private com.tencent.mm.model.bz.a qdr = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(81090);
            String a = aa.a(aVar.eAB.vED);
            ab.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
            com.tencent.mm.plugin.scanner.util.o.a a2 = ProductUI.this.qdc;
            if (!(a2 == null || bo.isNullOrNil(a))) {
                Map z = br.z(a, "sysmsg");
                a = (String) z.get(".sysmsg.scanproductinfo.product.id");
                if (bo.isNullOrNil(a2.field_productid) || !a2.field_productid.equals(a)) {
                    ab.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bo.nullAsNil(a) + ", target=" + a2.field_productid);
                } else {
                    LinkedList l = com.tencent.mm.plugin.scanner.a.a.l(z, ".sysmsg.scanproductinfo.product");
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < l.size(); i++) {
                        LinkedList linkedList = ((com.tencent.mm.plugin.scanner.a.a) l.get(i)).fPL;
                        if (linkedList != null) {
                            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) linkedList.get(i2);
                                if (aVar2 != null) {
                                    hashMap.put(aVar2.key, aVar2);
                                }
                            }
                        }
                    }
                    ab.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + hashMap.size());
                    l.b(a2.qiL, hashMap);
                }
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(81089);
                    ProductUI.a(ProductUI.this, ProductUI.this.qdc);
                    AppMethodBeat.o(81089);
                }
            });
            AppMethodBeat.o(81090);
        }
    };
    private com.tencent.mm.plugin.scanner.ui.MusicPreference.a qds = new com.tencent.mm.plugin.scanner.ui.MusicPreference.a() {
        public final void d(MusicPreference musicPreference) {
            AppMethodBeat.i(81082);
            if (musicPreference == null) {
                ab.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
                AppMethodBeat.o(81082);
            } else if (bo.isNullOrNil(musicPreference.pZl) && bo.isNullOrNil(musicPreference.pZm)) {
                ab.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
                if (!bo.isNullOrNil(musicPreference.pZn)) {
                    ProductUI.a(ProductUI.this, musicPreference.pZn);
                }
                AppMethodBeat.o(81082);
            } else {
                if (ProductUI.Wm(String.format("%s_cd_%s", new Object[]{musicPreference.pZl, musicPreference.mKey}))) {
                    com.tencent.mm.aw.a.aic();
                    ab.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", r1);
                } else if (musicPreference.getTitle() == null) {
                    ab.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
                    AppMethodBeat.o(81082);
                    return;
                } else {
                    String str;
                    int i = -1;
                    if (ProductUI.this.qdg == null) {
                        str = null;
                    } else {
                        str = ProductUI.this.qdg.anJ();
                    }
                    String format = String.format("%s_cd_%s", new Object[]{musicPreference.pZl, musicPreference.mKey});
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (MusicPreference musicPreference2 : ProductUI.this.oMb) {
                        int i3;
                        String format2 = String.format("%s_cd_%s", new Object[]{musicPreference2.pZl, musicPreference2.mKey});
                        if (format.equals(format2)) {
                            i3 = i2;
                        } else {
                            i3 = i;
                        }
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(com.tencent.mm.aw.f.a(5, str, musicPreference2.getTitle().toString(), "", musicPreference2.pZn, musicPreference2.pZm, musicPreference2.pZl, format2, g.RP().eJM, str, "", "wx482a4001c37e2b74"));
                        i2++;
                        i = i3;
                    }
                    if (i < 0) {
                        AppMethodBeat.o(81082);
                        return;
                    }
                    al.d(new com.tencent.mm.aw.a.AnonymousClass7(arrayList, i));
                }
                ProductUI.q(ProductUI.this);
                AppMethodBeat.o(81082);
            }
        }
    };
    private boolean qdt = true;

    public static final class a implements v {
        private com.tencent.mm.plugin.scanner.util.o.a qdc;

        public a(com.tencent.mm.plugin.scanner.util.o.a aVar) {
            this.qdc = aVar;
        }

        public final String anJ() {
            AppMethodBeat.i(81100);
            String fQ = e.cgy().fQ(this.qdc.field_thumburl, "@S");
            AppMethodBeat.o(81100);
            return fQ;
        }

        public final String anK() {
            if (this.qdc == null) {
                return "";
            }
            return this.qdc.field_thumburl;
        }

        public final String anL() {
            if (this.qdc == null) {
                return "";
            }
            return this.qdc.field_thumburl;
        }

        public final String getCacheKey() {
            if (this.qdc == null) {
                return "";
            }
            return this.qdc.field_thumburl;
        }

        public final boolean anM() {
            return false;
        }

        public final boolean anN() {
            return false;
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.v.a aVar, String str) {
            AppMethodBeat.i(81101);
            if (com.tencent.mm.platformtools.v.a.NET == aVar) {
                try {
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, anJ(), false);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(81101);
            return bitmap;
        }

        public final void anP() {
        }

        public final void V(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.v.a aVar, String str) {
        }

        public final Bitmap anO() {
            AppMethodBeat.i(81102);
            if (ah.getContext() == null) {
                AppMethodBeat.o(81102);
                return null;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
            AppMethodBeat.o(81102);
            return decodeResource;
        }

        public final com.tencent.mm.platformtools.v.b anI() {
            return null;
        }
    }

    final class b {
        int acV;
        ProductScrollView qdA = ((ProductScrollView) ProductUI.this.findViewById(R.id.do1));
        boolean qdB;
        private com.tencent.mm.plugin.scanner.ui.ProductScrollView.a qdC = new com.tencent.mm.plugin.scanner.ui.ProductScrollView.a() {
            public final void bpT() {
                float f;
                float f2 = 1.0f;
                AppMethodBeat.i(81103);
                b bVar = b.this;
                int scrollY = bVar.qdA.getScrollY();
                if (scrollY < 0) {
                    f = -1.0f;
                } else if (scrollY >= ProductUI.this.qdf - bVar.acV || ((float) ProductUI.this.qdf) == 0.0f) {
                    f = 1.0f;
                } else {
                    f = (((float) scrollY) * 1.37f) / ((float) ProductUI.this.qdf);
                }
                ab.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=".concat(String.valueOf(f)));
                if (f == 1.0f) {
                    if (!bVar.qdB) {
                        bVar.qdB = true;
                    }
                    AppMethodBeat.o(81103);
                }
                bVar.qdB = false;
                if (ProductUI.this.qda != null) {
                    float f3 = (1.0f - f) - 0.2f;
                    if (f3 <= 0.0f) {
                        f3 = 0.0f;
                    }
                    if (f == 0.0f) {
                        f3 = 1.0f;
                    }
                    ProductUI.p(ProductUI.this.qda, f3);
                }
                if (ProductUI.this.qdd != null) {
                    if (f == 0.0f) {
                        f2 = 0.0f;
                    } else if (f >= 0.0f) {
                        f += 0.2f;
                        if (f <= 1.0f) {
                            f2 = f;
                        }
                    }
                    ProductUI.p(ProductUI.this.qdd, f2);
                }
                AppMethodBeat.o(81103);
            }
        };

        public b() {
            AppMethodBeat.i(81104);
            this.qdA.setOnScrollListener(this.qdC);
            this.acV = ProductUI.w(ProductUI.this);
            AppMethodBeat.o(81104);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProductUI() {
        AppMethodBeat.i(81105);
        AppMethodBeat.o(81105);
    }

    static /* synthetic */ boolean Wm(String str) {
        AppMethodBeat.i(81137);
        boolean Wi = Wi(str);
        AppMethodBeat.o(81137);
        return Wi;
    }

    static /* synthetic */ void a(ProductUI productUI, int i, String str) {
        AppMethodBeat.i(81132);
        productUI.bb(i, str);
        AppMethodBeat.o(81132);
    }

    static /* synthetic */ int m(ProductUI productUI) {
        AppMethodBeat.i(81134);
        int aGu = productUI.aGu();
        AppMethodBeat.o(81134);
        return aGu;
    }

    static /* synthetic */ void p(View view, float f) {
        AppMethodBeat.i(81142);
        o(view, f);
        AppMethodBeat.o(81142);
    }

    static /* synthetic */ void q(ProductUI productUI) {
        AppMethodBeat.i(81138);
        productUI.cho();
        AppMethodBeat.o(81138);
    }

    static /* synthetic */ void t(ProductUI productUI) {
        AppMethodBeat.i(81140);
        productUI.chn();
        AppMethodBeat.o(81140);
    }

    public final int getLayoutId() {
        return R.layout.akx;
    }

    public final int JC() {
        return R.xml.b_;
    }

    public final int aWi() {
        return R.layout.al4;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(81106);
        super.onCreate(bundle);
        this.mStartTime = bo.anT();
        this.gOW = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
        x.b((com.tencent.mm.platformtools.x.a) this);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("scanproductinfo", this.qdr, true);
        initView();
        AppMethodBeat.o(81106);
    }

    public void onResume() {
        AppMethodBeat.i(81107);
        super.onResume();
        g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_BAIXIANG, (f) this);
        g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_HUANGDAN, (f) this);
        AppMethodBeat.o(81107);
    }

    public void onPause() {
        AppMethodBeat.i(81108);
        g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_BAIXIANG, (f) this);
        g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_HUANGDAN, (f) this);
        super.onPause();
        AppMethodBeat.o(81108);
    }

    public void onDestroy() {
        AppMethodBeat.i(81109);
        x.c((com.tencent.mm.platformtools.x.a) this);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("scanproductinfo", this.qdr, true);
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        if (this.ecr != null) {
            this.ecr.c(this.ecy);
        }
        bb(10100, (bo.anT() - this.mStartTime));
        super.onDestroy();
        AppMethodBeat.o(81109);
    }

    public final void initView() {
        AppMethodBeat.i(81110);
        setMMTitle((int) R.string.dyh);
        this.ehK = this.yCw;
        chq();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(81091);
                if (ProductUI.this.gOW == 4) {
                    ProductUI.this.setResult(0);
                }
                ProductUI.this.finish();
                AppMethodBeat.o(81091);
                return true;
            }
        });
        this.gne = (TextView) findViewById(R.id.doh);
        this.qcV = (ImageView) findViewById(R.id.do_);
        this.qcW = findViewById(R.id.doa);
        this.qcY = (ImageView) findViewById(R.id.doj);
        this.qdd = findViewById(R.id.do3);
        this.qda = (LinearLayout) findViewById(R.id.dob);
        this.qdb = (ImageView) findViewById(R.id.dom);
        this.qcZ = findViewById(R.id.doi);
        o(this.qdd, 0.0f);
        if (com.tencent.mm.bz.a.ga(this.mController.ylL)) {
            this.gne.setTextSize(0, ((float) this.mController.ylL.getResources().getDimensionPixelSize(R.dimen.fr)) * 1.25f);
        } else {
            this.gne.setTextSize(0, (float) com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.fr));
        }
        this.qcX = (TextView) findViewById(R.id.dok);
        this.gsS = (TextView) findViewById(R.id.do2);
        this.qdi = new HashMap();
        this.qdj = new com.tencent.mm.plugin.scanner.ui.e.a() {
            public final void a(String str, Boolean bool) {
                AppMethodBeat.i(81092);
                if (str != null && str.length() > 0) {
                    ProductUI.this.qdi.put(str, bool);
                }
                AppMethodBeat.o(81092);
            }

            public final Boolean Wg(String str) {
                AppMethodBeat.i(81093);
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(81093);
                    return null;
                }
                Boolean bool = (Boolean) ProductUI.this.qdi.get(str);
                AppMethodBeat.o(81093);
                return bool;
            }

            public final void chl() {
                AppMethodBeat.i(81094);
                if (ProductUI.this.ehK != null) {
                    ProductUI.this.ehK.notifyDataSetChanged();
                }
                AppMethodBeat.o(81094);
            }
        };
        this.qdq = new com.tencent.mm.plugin.scanner.history.a.a();
        this.qdq.field_ScanTime = System.currentTimeMillis();
        this.qdq.field_scene = this.gOW;
        String stringExtra;
        String Wj;
        if (this.gOW == 5) {
            this.qdn = true;
            stringExtra = getIntent().getStringExtra("key_Qrcode_Url");
            Wj = Wj(stringExtra);
            this.qdq.field_qrcodeUrl = stringExtra;
            this.qdq.field_productId = Wj;
            u(Wj, stringExtra, false);
        } else if (this.gOW == 4) {
            stringExtra = getIntent().getStringExtra("key_product_id");
            Wj = getIntent().getStringExtra("key_Qrcode_Url");
            if (bo.isNullOrNil(stringExtra)) {
                ab.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
                finish();
                AppMethodBeat.o(81110);
                return;
            }
            u(stringExtra, Wj, false);
        } else {
            this.qdp = getIntent().getBooleanExtra("key_is_from_barcode", false);
            this.qdn = getIntent().getBooleanExtra("key_need_add_to_history", false);
            stringExtra = getIntent().getStringExtra("key_Product_xml");
            if (bo.isNullOrNil(stringExtra)) {
                stringExtra = getIntent().getStringExtra("key_Product_ID");
                if (bo.isNullOrNil(stringExtra)) {
                    ab.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
                    finish();
                    AppMethodBeat.o(81110);
                    return;
                }
                u(stringExtra, null, false);
            } else {
                int intExtra = getIntent().getIntExtra("key_Product_funcType", 0);
                this.qdc = j.cV(stringExtra, intExtra);
                if (this.qdc == null) {
                    ab.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
                    finish();
                    AppMethodBeat.o(81110);
                    return;
                }
                this.kWz = this.qdc.field_productid;
                this.qdk = this.qdc.field_extinfo;
                if (!this.qdn || TextUtils.isEmpty(this.kWz)) {
                    ab.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.qdn + " mProductId:" + this.kWz);
                } else {
                    this.qdq.field_xmlContent = stringExtra;
                    this.qdq.field_qrcodeUrl = this.qdk;
                    this.qdq.field_productId = this.kWz;
                    this.qdq.field_funcType = intExtra;
                    chs();
                }
                com.tencent.mm.plugin.scanner.util.o.a aVar = this.qdc;
                getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
                a(aVar);
                if (intExtra != 0 || bo.isNullOrNil(this.qdc.field_productid)) {
                    chr();
                } else {
                    u(this.qdc.field_productid, this.qdc.field_extinfo, true);
                }
            }
        }
        findViewById(R.id.do8).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81095);
                ProductUI.l(ProductUI.this);
                AppMethodBeat.o(81095);
            }
        });
        findViewById(R.id.dol).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81096);
                ProductUI.l(ProductUI.this);
                AppMethodBeat.o(81096);
            }
        });
        this.qcZ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(81097);
                if (!(ProductUI.this.qdc == null || bo.isNullOrNil(ProductUI.this.qdc.field_certificationurl))) {
                    ProductUI.a(ProductUI.this, 10002, ProductUI.this.qdc.field_certificationurl);
                    ProductUI.a(ProductUI.this, ProductUI.this.qdc.field_certificationurl);
                }
                AppMethodBeat.o(81097);
            }
        });
        b bVar = new b();
        AppMethodBeat.o(81110);
    }

    private void a(final com.tencent.mm.plugin.scanner.util.o.a aVar) {
        AppMethodBeat.i(81112);
        if (aVar == null) {
            ab.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
            finish();
            AppMethodBeat.o(81112);
            return;
        }
        if (!bo.isNullOrNil(aVar.field_thumburl)) {
            this.qdg = new a(aVar);
        }
        chm();
        if (bo.isNullOrNil(aVar.field_introtitle) || bo.isNullOrNil(aVar.field_introlink)) {
            this.gsS.setVisibility(8);
        } else {
            this.gsS.setText(aVar.field_introtitle);
            this.gsS.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(81098);
                    ProductUI.a(ProductUI.this, 10003, aVar.field_introlink);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar.field_introlink);
                    intent.putExtra("geta8key_scene", ProductUI.m(ProductUI.this));
                    com.tencent.mm.bp.d.b(ProductUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(81098);
                }
            });
            this.gsS.setVisibility(0);
        }
        this.qde = this.qdc.field_functionType;
        if (aVar.field_xmlType == 3) {
            this.gne.setText(aVar.field_title);
            if (bo.isNullOrNil(aVar.field_certification)) {
                this.qcX.setText(aVar.field_source);
                this.qcY.setVisibility(8);
                this.qcZ.setOnClickListener(null);
                this.qcZ.setBackgroundDrawable(null);
                this.qcZ.setFocusable(false);
            } else {
                this.qcX.setText(aVar.field_certification);
                this.qcY.setVisibility(0);
            }
            if (aVar.field_type == 1 || aVar.field_type == 2) {
                this.qcU = (ImageView) findViewById(R.id.dod);
                findViewById(R.id.dod).setVisibility(0);
                findViewById(R.id.doe).setVisibility(8);
            } else {
                this.qcU = (ImageView) findViewById(R.id.doe);
                findViewById(R.id.doe).setVisibility(0);
                findViewById(R.id.dod).setVisibility(8);
            }
            if (!bo.isNullOrNil(aVar.field_playurl)) {
                ImageView imageView = (ImageView) findViewById(R.id.dof);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(81099);
                        Intent intent = new Intent("android.intent.action.VIEW");
                        k.a(ProductUI.this.mController.ylL, intent, Uri.parse(aVar.field_playurl), "video/*");
                        ProductUI.this.startActivity(intent);
                        AppMethodBeat.o(81099);
                    }
                });
            }
            addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(81080);
                    ProductUI.n(ProductUI.this);
                    AppMethodBeat.o(81080);
                    return true;
                }
            });
        } else if (aVar.field_xmlType == 4) {
            this.qcU = (ImageView) findViewById(R.id.doe);
            findViewById(R.id.doe).setVisibility(0);
            findViewById(R.id.dod).setVisibility(8);
            this.qcU.setImageResource(R.raw.scan_without_commodity_icon);
            this.qcU.setBackgroundResource(R.raw.scan_without_commodity_icon);
            this.gne.setText(R.string.dxv);
            this.qcX.setText(null);
        }
        ab.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(81081);
                ProductUI.a(ProductUI.this, aVar);
                ProductUI.b(ProductUI.this, aVar);
                AppMethodBeat.o(81081);
            }
        });
        AppMethodBeat.o(81112);
    }

    private void chn() {
        AppMethodBeat.i(81113);
        this.cvx = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0);
        if (this.cvx > 0 && g.RK()) {
            bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(this.cvx);
            if (jf.field_msgId > 0) {
                jf.jv(this.qdg.anJ());
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(this.cvx, jf);
            }
        }
        AppMethodBeat.o(81113);
    }

    private void b(com.tencent.mm.plugin.scanner.util.o.a aVar) {
        AppMethodBeat.i(81114);
        if (aVar == null || aVar.qiL == null || aVar.qiL.size() == 0 || this.ehK == null) {
            AppMethodBeat.o(81114);
            return;
        }
        this.ehK.removeAll();
        for (int i = 0; i < aVar.qiL.size(); i++) {
            com.tencent.mm.plugin.scanner.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a) aVar.qiL.get(i);
            if (!(aVar2 == null || aVar2.fPL == null || aVar2.fPL.size() == 0 || aVar2.pZh == 1 || !aVar2.pZj)) {
                if (i != 0) {
                    Preference preference = new Preference(this);
                    preference.setLayoutResource(R.layout.akv);
                    this.ehK.b(preference);
                }
                if (!bo.isNullOrNil(aVar2.title) && (aVar2.type == 6 || aVar2.type == 7)) {
                    CategoryWithTitlePreference categoryWithTitlePreference = new CategoryWithTitlePreference(this);
                    categoryWithTitlePreference.setTitle(aVar2.title);
                    this.ehK.b(categoryWithTitlePreference);
                }
                int i2;
                com.tencent.mm.plugin.scanner.a.a.a aVar3;
                if (aVar2.type == 6) {
                    ArrayList arrayList = new ArrayList();
                    for (i2 = 0; i2 < aVar2.fPL.size(); i2++) {
                        aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.fPL.get(i2);
                        if (aVar3.type == 10) {
                            arrayList.add(aVar3);
                        }
                    }
                    if (arrayList.size() > 0) {
                        h hVar = new h(this);
                        hVar.setKey((i * 100));
                        hVar.pil = arrayList;
                        this.ehK.b(hVar);
                    }
                } else {
                    i2 = 0;
                    while (i2 < aVar2.fPL.size()) {
                        String str = ((i * 100) + i2);
                        aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.fPL.get(i2);
                        if (aVar3.type == 11) {
                            this.qdl = true;
                            this.qdm = aVar3.name;
                        }
                        if (aVar3.showType != 2) {
                            if (aVar3.showType != 1) {
                                if (aVar3.type == 5) {
                                    MusicPreference musicPreference = new MusicPreference(this);
                                    musicPreference.setKey(str);
                                    musicPreference.setTitle((CharSequence) aVar3.name);
                                    musicPreference.pZl = aVar3.pZl;
                                    musicPreference.pZm = aVar3.pZm;
                                    musicPreference.pZn = aVar3.pZn;
                                    if (Wi(String.format("%s_cd_%s", new Object[]{aVar3.pZl, str}))) {
                                        musicPreference.kk(true);
                                    } else {
                                        musicPreference.kk(false);
                                    }
                                    musicPreference.qcA = this.qds;
                                    this.ehK.b(musicPreference);
                                    com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
                                    if (this.oMb == null) {
                                        this.oMb = new ArrayList();
                                    }
                                    if (this.qdt) {
                                        this.oMb.add(musicPreference);
                                    }
                                } else if (aVar3.type == 6) {
                                    e eVar = new e(this);
                                    eVar.setKey(str);
                                    eVar.mTitle = aVar3.name;
                                    eVar.setSummary((CharSequence) aVar3.desc);
                                    this.ehK.b(eVar);
                                    eVar.qcp = this.qdj;
                                } else if (aVar3.type == 12) {
                                    f fVar = new f(this);
                                    fVar.setKey(str);
                                    fVar.kXM = aVar3.thumburl;
                                    fVar.ehK = this.ehK;
                                    this.ehK.b(fVar);
                                } else if (aVar3.type == 2) {
                                    CharSequence charSequence = Wk(aVar3.username) ? aVar3.pZt : aVar3.pZs;
                                    a aVar4 = new a(this);
                                    aVar4.setKey(str);
                                    aVar4.setTitle(charSequence);
                                    aVar4.setSummary((CharSequence) aVar3.desc);
                                    aVar4.qaJ = aVar3.fjz;
                                    this.ehK.b(aVar4);
                                } else if (aVar3.type == 22) {
                                    d dVar = new d(this);
                                    dVar.setKey(str);
                                    if (!bo.isNullOrNil(aVar3.nickname)) {
                                        dVar.kux = aVar3.nickname + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                                    }
                                    dVar.mXp = aVar3.content;
                                    dVar.qcd = aVar3.thumburl;
                                    this.ehK.b(dVar);
                                } else {
                                    a aVar5 = new a(this);
                                    aVar5.setKey(str);
                                    aVar5.setTitle((CharSequence) aVar3.name);
                                    aVar5.setSummary((CharSequence) aVar3.desc);
                                    aVar5.qaJ = aVar3.fjz;
                                    aVar5.kWC = aVar3.iconUrl;
                                    this.ehK.b(aVar5);
                                }
                                if (!(i2 >= aVar2.fPL.size() - 1 || aVar3.type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.fPL.get(i2 + 1)).type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.fPL.get(i2 + 1)).showType == 1 || !c(i2, aVar2.fPL))) {
                                    this.ehK.b(new g(this));
                                }
                            } else if (!bo.isNullOrNil(aVar3.image)) {
                                b bVar = new b(this);
                                bVar.setKey(str);
                                bVar.kXM = aVar3.image;
                                bVar.ehK = this.ehK;
                                this.ehK.b(bVar);
                            }
                        }
                        i2++;
                    }
                }
            }
        }
        this.ehK.notifyDataSetChanged();
        ab.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
        if (this.oMb != null) {
            this.qdt = false;
        }
        AppMethodBeat.o(81114);
    }

    private static boolean c(int i, LinkedList<com.tencent.mm.plugin.scanner.a.a.a> linkedList) {
        AppMethodBeat.i(81115);
        if (linkedList != null) {
            int i2 = i + 1;
            while (true) {
                int i3 = i2;
                if (i3 >= linkedList.size()) {
                    break;
                } else if (((com.tencent.mm.plugin.scanner.a.a.a) linkedList.get(i3)).showType != 2) {
                    AppMethodBeat.o(81115);
                    return true;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        AppMethodBeat.o(81115);
        return false;
    }

    private void cho() {
        AppMethodBeat.i(81116);
        if (this.qdc == null || this.qdc.qiL == null || this.qdc.qiL.size() == 0 || this.ehK == null) {
            AppMethodBeat.o(81116);
            return;
        }
        for (int i = 0; i < this.qdc.qiL.size(); i++) {
            com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.qdc.qiL.get(i);
            if (!(aVar == null || aVar.fPL == null || aVar.fPL.size() == 0)) {
                for (int i2 = 0; i2 < aVar.fPL.size(); i2++) {
                    if (((com.tencent.mm.plugin.scanner.a.a.a) aVar.fPL.get(i2)).type == 5) {
                        MusicPreference musicPreference = (MusicPreference) this.ehK.aqO(((i * 100) + i2));
                        if (musicPreference != null) {
                            if (Wi(String.format("%s_cd_%s", new Object[]{r1.pZl, r6}))) {
                                musicPreference.kk(true);
                            } else {
                                musicPreference.kk(false);
                            }
                        }
                    }
                }
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(81116);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(81117);
        ab.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", preference.mKey);
        if (this.qdc == null || this.qdc.qiL == null) {
            ab.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
            AppMethodBeat.o(81117);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            ab.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2));
            if (i < 0 || i >= this.qdc.qiL.size()) {
                ab.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", Integer.valueOf(i), Integer.valueOf(this.qdc.qiL.size()));
                AppMethodBeat.o(81117);
                return false;
            }
            com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.qdc.qiL.get(i);
            if (aVar == null) {
                ab.w("MicroMsg.scanner.ProductUI", "actionList == null");
                AppMethodBeat.o(81117);
                return false;
            }
            if (i2 >= 0) {
                if (i2 < aVar.fPL.size()) {
                    com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) aVar.fPL.get(i2);
                    if (aVar2 == null) {
                        ab.w("MicroMsg.scanner.ProductUI", "action == null");
                        AppMethodBeat.o(81117);
                        return false;
                    }
                    ab.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", Integer.valueOf(aVar2.type));
                    String str = null;
                    Intent intent = new Intent();
                    switch (aVar2.type) {
                        case 1:
                        case 3:
                        case 22:
                            str = aVar2.link;
                            if (!bo.isNullOrNil(aVar2.link)) {
                                Wl(aVar2.link);
                                break;
                            }
                            break;
                        case 2:
                        case 4:
                            str = aVar2.username;
                            if (!bo.isNullOrNil(aVar2.username)) {
                                String str2 = aVar2.username;
                                Intent intent2;
                                if (!Wk(str2)) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        intent2 = new Intent();
                                        intent2.putExtra("Contact_User", str2);
                                        intent2.putExtra("force_get_contact", true);
                                        intent2.putExtra("Contact_Scene", chp());
                                        com.tencent.mm.plugin.scanner.c.gkE.c(intent2, this);
                                        break;
                                    }
                                    ab.v("MicroMsg.scanner.ProductUI", "username is null");
                                    break;
                                }
                                intent2 = new Intent();
                                intent2.putExtra("Chat_User", str2);
                                intent2.putExtra("finish_direct", true);
                                intent2.putExtra("add_scene", chp());
                                com.tencent.mm.plugin.scanner.c.gkE.d(intent2, this.mController.ylL);
                                break;
                            }
                            break;
                        case 5:
                            str = aVar2.pZn;
                            intent.putExtra("rawUrl", aVar2.pZn);
                            intent.putExtra("geta8key_scene", aGu());
                            com.tencent.mm.plugin.scanner.c.gkE.i(intent, this);
                            com.tencent.mm.aw.a.aic();
                            cho();
                            break;
                        case 6:
                        case 7:
                        case 10:
                            break;
                        case 8:
                            str = aVar2.pZp;
                            intent.putExtra("key_card_id", aVar2.pZr);
                            intent.putExtra("key_card_ext", aVar2.pZq);
                            intent.putExtra("key_from_scene", 9);
                            com.tencent.mm.bp.d.b((Context) this, "card", ".ui.CardDetailUI", intent);
                            break;
                        case 9:
                            str = aVar2.pZp;
                            if (!bo.isNullOrNil(aVar2.pZp)) {
                                intent.putExtra("key_product_id", aVar2.pZp);
                                intent.putExtra("key_product_scene", 12);
                                com.tencent.mm.bp.d.b((Context) this, "product", ".ui.MallProductUI", intent);
                                break;
                            }
                            break;
                        case 11:
                            intent.setClass(this, ProductFurtherInfoUI.class);
                            intent.putExtra("key_Product_xml", this.qdc.field_xml);
                            intent.putExtra("key_title", aVar2.name);
                            startActivity(intent);
                            break;
                        case 12:
                            str = aVar2.link;
                            if (!bo.isNullOrNil(aVar2.link)) {
                                Wl(aVar2.link);
                                break;
                            }
                            break;
                        case 21:
                            str = aVar2.pZi;
                            intent.setClass(this, ProductPurchaseAreaUI.class);
                            intent.putExtra("key_Product_xml", this.qdc.field_xml);
                            intent.putExtra("referkey", aVar2.pZi);
                            intent.putExtra("key_Product_funcType", this.qde);
                            startActivity(intent);
                            break;
                        default:
                            ab.d("MicroMsg.scanner.ProductUI", "Default go url:" + aVar2.link);
                            if (!bo.isNullOrNil(aVar2.link)) {
                                Wl(aVar2.link);
                                break;
                            }
                            break;
                    }
                    g.Rg().a(new i(this.qdc.field_productid, aVar2.pZo, aVar2.type, str, aVar.fPL.size(), aVar2.showType), 0);
                    AppMethodBeat.o(81117);
                    return true;
                }
            }
            ab.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", Integer.valueOf(i2), Integer.valueOf(aVar.fPL.size()));
            AppMethodBeat.o(81117);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", e.getMessage());
            ab.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
            AppMethodBeat.o(81117);
            return false;
        }
    }

    private static boolean Wi(String str) {
        AppMethodBeat.i(81118);
        com.tencent.mm.aw.e aih = com.tencent.mm.aw.a.aih();
        if (aih != null && aih.fJS == 5 && str.equals(aih.fJU) && com.tencent.mm.aw.a.aie()) {
            AppMethodBeat.o(81118);
            return true;
        }
        AppMethodBeat.o(81118);
        return false;
    }

    private void bb(int i, String str) {
        AppMethodBeat.i(81119);
        if (this.qdc == null) {
            AppMethodBeat.o(81119);
            return;
        }
        g.Rg().a(new i(this.qdc.field_productid, "", i, str, 0, 0), 0);
        AppMethodBeat.o(81119);
    }

    public final void m(final String str, final Bitmap bitmap) {
        AppMethodBeat.i(81120);
        if (!(bo.isNullOrNil(str) || this.qdc == null || bitmap == null || bitmap.isRecycled())) {
            ab.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=".concat(String.valueOf(str)));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(81087);
                    if (str.equals(ProductUI.this.qdc.field_thumburl) && ProductUI.this.qcU != null) {
                        ab.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
                        try {
                            ProductUI.this.qcU.setImageBitmap(bitmap);
                            ProductUI.this.qcU.setBackgroundDrawable(null);
                            ProductUI.this.qcU.setBackgroundColor(-1);
                            ProductUI.t(ProductUI.this);
                            ProductUI.this.qdh = true;
                        } catch (Exception e) {
                            ab.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", e.getLocalizedMessage());
                        }
                    }
                    if (str.equals(ProductUI.this.qdc.field_headerbackgroundurl) && ProductUI.this.qcV != null) {
                        ProductUI.this.qcV.setImageBitmap(bitmap);
                    }
                    AppMethodBeat.o(81087);
                }
            });
        }
        AppMethodBeat.o(81120);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81121);
        if (mVar == null) {
            ab.w("MicroMsg.scanner.ProductUI", "scene == null");
            AppMethodBeat.o(81121);
        } else if (mVar.getType() != FilterEnum4Shaka.MIC_WEISHI_BAIXIANG) {
            if (mVar.getType() == FilterEnum4Shaka.MIC_WEISHI_HUANGDAN && i == 0 && i2 == 0) {
                LinkedList linkedList = ((ko) ((c) mVar).ehh.fsH.fsP).vNJ;
                if (this.qdc != null && l.b(this.qdc.qiL, l.cV(linkedList))) {
                    b(this.qdc);
                }
            }
            AppMethodBeat.o(81121);
        } else if (i == 0 && i2 == 0) {
            kq kqVar;
            com.tencent.mm.plugin.scanner.a.d dVar = (com.tencent.mm.plugin.scanner.a.d) mVar;
            if (dVar.ehh == null || dVar.ehh.fsH.fsP == null) {
                kqVar = null;
            } else {
                kqVar = (kq) dVar.ehh.fsH.fsP;
            }
            if (kqVar == null) {
                ab.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
                AppMethodBeat.o(81121);
                return;
            }
            if (kqVar.vNK != null) {
                ab.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
                com.tencent.mm.plugin.scanner.util.o.a cV = j.cV(kqVar.vNK, this.qde);
                if (this.qdc != null && this.qdc.field_xml != null && cV != null && cV.field_xml != null && !this.qdc.field_xml.equals(cV.field_xml)) {
                    this.qdc = cV;
                    a(this.qdc);
                } else if (!(cV == null || cV.field_xml == null)) {
                    this.qdc = cV;
                    a(this.qdc);
                }
                if (this.ehJ != null && this.ehJ.isShowing()) {
                    this.ehJ.dismiss();
                }
                chr();
                if (!this.qdn || this.qdo || TextUtils.isEmpty(this.kWz)) {
                    ab.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.qdn + " mProductId:" + this.kWz + "  hasAddToHistory:" + this.qdo);
                } else {
                    this.qdq.field_xmlContent = kqVar.vNK;
                    this.qdq.field_funcType = this.qde;
                    chs();
                    AppMethodBeat.o(81121);
                    return;
                }
            }
            AppMethodBeat.o(81121);
        } else {
            ab.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(81121);
        }
    }

    private static String Wj(String str) {
        String str2 = null;
        AppMethodBeat.i(81122);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(81122);
        } else {
            try {
                str2 = Uri.parse(str).getQueryParameter("p");
                AppMethodBeat.o(81122);
            } catch (Exception e) {
                ab.w("MicroMsg.scanner.ProductUI", str + ";" + e.getLocalizedMessage());
                AppMethodBeat.o(81122);
            }
        }
        return str2;
    }

    private void u(String str, String str2, boolean z) {
        AppMethodBeat.i(81123);
        this.kWz = str;
        this.qdk = str2;
        final m dVar = new com.tencent.mm.plugin.scanner.a.d(str, this.gOW, str2);
        g.Rg().a(dVar, 0);
        if (!z) {
            AppCompatActivity appCompatActivity = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(appCompatActivity, getString(R.string.dy4), new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(81088);
                    ab.d("MicroMsg.scanner.ProductUI", "User cancel");
                    g.Rg().c(dVar);
                    AppMethodBeat.o(81088);
                }
            });
        }
        AppMethodBeat.o(81123);
    }

    private static boolean Wk(String str) {
        AppMethodBeat.i(81124);
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0 || !com.tencent.mm.n.a.jh(aoO.field_type)) {
            AppMethodBeat.o(81124);
            return false;
        }
        AppMethodBeat.o(81124);
        return true;
    }

    private int aGu() {
        if (this.qde == 4) {
            return 11;
        }
        if (this.qde == 3) {
            return 12;
        }
        return 0;
    }

    private void Wl(String str) {
        AppMethodBeat.i(81125);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", j.BT(this.qde));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        intent.putExtra("geta8key_scene", aGu());
        com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(81125);
    }

    private int chp() {
        if (this.qde == 3) {
            return 47;
        }
        return 49;
    }

    @TargetApi(11)
    private void chq() {
        AppMethodBeat.i(81126);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(null);
            getSupportActionBar();
        }
        AppMethodBeat.o(81126);
    }

    private void chr() {
        AppMethodBeat.i(81127);
        if (this.qdc != null) {
            ab.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.qdc.field_getaction);
            if ((this.qdc.field_getaction & 2) > 0) {
                this.ecr = d.agz();
                if (this.ecr != null) {
                    this.ecr.b(this.ecy);
                    AppMethodBeat.o(81127);
                    return;
                }
            } else if ((this.qdc.field_getaction & 1) > 0) {
                g.Rg().a(new c(this.kWz, l.cU(this.qdc.qiL), this.gOW, this.qdk, 0.0d, 0.0d), 0);
            }
        }
        AppMethodBeat.o(81127);
    }

    private static void o(View view, float f) {
        AppMethodBeat.i(81128);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
        AppMethodBeat.o(81128);
    }

    private void chs() {
        AppMethodBeat.i(81129);
        if (com.tencent.mm.plugin.scanner.util.i.cig()) {
            boolean c;
            com.tencent.mm.plugin.scanner.history.a.a aVar = new com.tencent.mm.plugin.scanner.history.a.a();
            aVar.field_productId = this.kWz;
            if (e.cgy().cgC().b((com.tencent.mm.sdk.e.c) aVar, new String[0])) {
                c = e.cgy().cgC().c(this.qdq, new String[0]);
            } else {
                c = e.cgy().cgC().b((com.tencent.mm.sdk.e.c) this.qdq);
            }
            if (c) {
                ab.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
                this.qdo = true;
                AppMethodBeat.o(81129);
                return;
            }
            ab.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
            AppMethodBeat.o(81129);
            return;
        }
        ab.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
        AppMethodBeat.o(81129);
    }

    private void chm() {
        AppMethodBeat.i(81111);
        this.qdf = this.mController.ylL.getResources().getDimensionPixelSize(R.dimen.a7c);
        if (this.qdc != null && (this.qdc.field_type == 1 || this.qdc.field_type == 2)) {
            this.qdf = this.mController.ylL.getResources().getDimensionPixelSize(R.dimen.a7d);
            LayoutParams layoutParams = this.qcV.getLayoutParams();
            layoutParams.height = this.qdf;
            this.qcV.setLayoutParams(layoutParams);
            layoutParams = this.qcW.getLayoutParams();
            layoutParams.height = this.qdf;
            this.qda.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.do9);
            LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            layoutParams2.height = this.qdf;
            relativeLayout.setLayoutParams(layoutParams2);
            layoutParams = this.qda.getLayoutParams();
            layoutParams.height = this.qdf;
            this.qda.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(81111);
    }

    static /* synthetic */ void l(ProductUI productUI) {
        AppMethodBeat.i(81131);
        if (productUI.qdc != null) {
            if (!bo.isNullOrNil(productUI.qdc.field_detailurl)) {
                productUI.bb(Downloads.MIN_WAIT_FOR_NETWORK, productUI.qdc.field_detailurl);
                productUI.Wl(productUI.qdc.field_detailurl);
                AppMethodBeat.o(81131);
                return;
            } else if (!bo.isNullOrNil(productUI.qdc.field_xml) && productUI.qdl) {
                productUI.bb(10001, "");
                Intent intent = new Intent();
                intent.setClass(productUI, ProductFurtherInfoUI.class);
                intent.putExtra("key_Product_xml", productUI.qdc.field_xml);
                intent.putExtra("key_title", productUI.qdm);
                productUI.startActivity(intent);
            }
        }
        AppMethodBeat.o(81131);
    }

    static /* synthetic */ void n(ProductUI productUI) {
        AppMethodBeat.i(81135);
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(productUI.getString(R.string.g24));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(productUI.getString(R.string.g23));
        linkedList2.add(Integer.valueOf(1));
        if (!productUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(productUI.getString(R.string.dcq));
            linkedList2.add(Integer.valueOf(2));
        } else if (productUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = productUI.getString(R.string.p4);
            linkedList.add(productUI.getString(R.string.d2));
            linkedList2.add(Integer.valueOf(3));
        } else {
            str = "";
        }
        if (!(productUI.qdc == null || TextUtils.isEmpty(productUI.qdc.field_exposeurl))) {
            linkedList.add(productUI.getString(R.string.avr));
            linkedList2.add(Integer.valueOf(4));
        }
        h.a((Context) productUI, "", linkedList, linkedList2, str, false, new h.d() {
            public final void bV(int i, int i2) {
                AppMethodBeat.i(81086);
                if (ProductUI.this.qdc == null) {
                    AppMethodBeat.o(81086);
                    return;
                }
                Intent intent;
                switch (i2) {
                    case -1:
                        h.a(ProductUI.this.mController.ylL, ProductUI.this.mController.ylL.getString(R.string.p5), null, null, ProductUI.this.mController.ylL.getString(R.string.p4), new h.d() {
                            public final void bV(int i, int i2) {
                                AppMethodBeat.i(81085);
                                switch (i2) {
                                    case -1:
                                        cg cgVar = new cg();
                                        cgVar.cvt.cvv = ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1);
                                        com.tencent.mm.sdk.b.a.xxA.m(cgVar);
                                        ab.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", Long.valueOf(cgVar.cvt.cvv), Boolean.valueOf(cgVar.cvu.cvi));
                                        if (cgVar.cvu.cvi) {
                                            ProductUI.this.finish();
                                            AppMethodBeat.o(81085);
                                            return;
                                        }
                                        break;
                                    default:
                                        ab.d("MicroMsg.scanner.ProductUI", "do del cancel");
                                        break;
                                }
                                AppMethodBeat.o(81085);
                            }
                        });
                        AppMethodBeat.o(81086);
                        return;
                    case 0:
                        com.tencent.mm.plugin.report.service.h.pYm.e(11446, ProductUI.this.qdc.field_productid, Integer.valueOf(2));
                        if (ProductUI.this.gOW == 3) {
                            com.tencent.mm.plugin.fav.a.h.j(ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1), 1, 0);
                            com.tencent.mm.plugin.report.service.h.pYm.e(10651, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0));
                        }
                        intent = new Intent();
                        intent.putExtra("KContentObjDesc", ProductUI.this.qdc.field_subtitle);
                        intent.putExtra("Ksnsupload_title", ProductUI.this.qdc.field_title);
                        intent.putExtra("Ksnsupload_link", ProductUI.this.qdc.field_shareurl);
                        intent.putExtra("Ksnsupload_appname", com.tencent.mm.plugin.scanner.util.o.T(ProductUI.this, ProductUI.this.qdc.field_type));
                        intent.putExtra("Ksnsupload_appid", j.BT(ProductUI.this.qdc.field_functionType));
                        intent.putExtra("Ksnsupload_imgurl", ProductUI.this.qdc.field_thumburl);
                        ab.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + ProductUI.this.qdc.field_thumburl);
                        if (ProductUI.this.qdg != null) {
                            intent.putExtra("KsnsUpload_imgPath", ProductUI.this.qdg.anJ());
                        } else {
                            ab.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                        }
                        intent.putExtra("Ksnsupload_type", 3);
                        intent.putExtra("KUploadProduct_UserData", com.tencent.mm.plugin.scanner.util.o.c(ProductUI.this.qdc));
                        intent.putExtra("KUploadProduct_subType", ProductUI.this.qdc.field_type);
                        String nW = com.tencent.mm.model.v.nW("scan_product");
                        com.tencent.mm.model.v.Zp().y(nW, true).j("prePublishId", "scan_product");
                        intent.putExtra("reportSessionId", nW);
                        com.tencent.mm.bp.d.b(ProductUI.this, "sns", ".ui.SnsUploadUI", intent);
                        AppMethodBeat.o(81086);
                        return;
                    case 1:
                        com.tencent.mm.plugin.report.service.h.pYm.e(11446, ProductUI.this.qdc.field_productid, Integer.valueOf(1));
                        String a = j.a(ProductUI.this.mController.ylL, ProductUI.this.qdc);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_Msg_content", a);
                        intent2.putExtra("Retr_Msg_Type", 2);
                        if (ProductUI.this.qdg != null) {
                            intent2.putExtra("Retr_Msg_thumb_path", ProductUI.this.qdg.anJ());
                        } else {
                            ab.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                        }
                        intent2.putExtra("Retr_go_to_chattingUI", false);
                        intent2.putExtra("Retr_show_success_tips", true);
                        com.tencent.mm.plugin.scanner.c.gkE.k(intent2, ProductUI.this);
                        if (ProductUI.this.gOW == 3) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(10651, Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(0));
                            AppMethodBeat.o(81086);
                            return;
                        }
                        break;
                    case 2:
                        com.tencent.mm.plugin.report.service.h.pYm.e(11446, ProductUI.this.qdc.field_productid, Integer.valueOf(3));
                        ProductUI.r(ProductUI.this);
                        AppMethodBeat.o(81086);
                        return;
                    case 3:
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", ProductUI.this.getIntent().getLongExtra("key_favorite_local_id", -1));
                        com.tencent.mm.plugin.fav.a.b.b(ProductUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                        AppMethodBeat.o(81086);
                        return;
                    case 4:
                        intent = new Intent();
                        intent.putExtra("rawUrl", ProductUI.this.qdc.field_exposeurl);
                        com.tencent.mm.bp.d.b(ProductUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                        break;
                }
                AppMethodBeat.o(81086);
            }
        });
        AppMethodBeat.o(81135);
    }

    static /* synthetic */ void b(ProductUI productUI, com.tencent.mm.plugin.scanner.util.o.a aVar) {
        AppMethodBeat.i(81136);
        if (aVar == null || bo.isNullOrNil(aVar.field_thumburl)) {
            ab.e("MicroMsg.scanner.ProductUI", "product == null || Util.isNullOrNil(product.field_thumburl)");
            AppMethodBeat.o(81136);
            return;
        }
        try {
            productUI.qcW.setBackgroundColor(Color.parseColor(aVar.field_headermask));
            if (!bo.isNullOrNil(aVar.field_headermask) && aVar.field_headermask.length() == 9) {
                productUI.qdd.setBackgroundColor(Color.parseColor("#" + aVar.field_headermask.substring(3, 9)));
            }
        } catch (Exception e) {
            ab.w("MicroMsg.scanner.ProductUI", "parse maskColor wrong");
        }
        ab.e("MicroMsg.scanner.ProductUI", "begin to get the url " + aVar.field_thumburl);
        Bitmap a = x.a(productUI.qdg);
        if (a != null) {
            productUI.qcU.setImageBitmap(a);
            productUI.qcU.setBackgroundDrawable(null);
            productUI.qcU.setBackgroundColor(-1);
            productUI.qdh = true;
            productUI.chn();
        } else {
            productUI.qcU.setImageBitmap(null);
        }
        if (!bo.isNullOrNil(aVar.field_headerbackgroundurl)) {
            a = x.a(new q(aVar.field_headerbackgroundurl));
            if (!(a == null || a.isRecycled())) {
                productUI.qcV.setImageBitmap(a);
            }
        }
        AppMethodBeat.o(81136);
    }

    static /* synthetic */ void r(ProductUI productUI) {
        AppMethodBeat.i(81139);
        if (productUI.qdc == null) {
            ab.w("MicroMsg.scanner.ProductUI", "do favorite, but product is null");
            AppMethodBeat.o(81139);
            return;
        }
        cl clVar = new cl();
        abf abf = new abf();
        abl abl = new abl();
        abe abe = new abe();
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        abl.LN(8);
        abl.ml(bo.anU());
        abl.alJ(j.BT(productUI.qdc.field_functionType));
        abe.alw(productUI.qdc.field_title);
        abe.alx(productUI.qdc.field_subtitle);
        abe.LK(productUI.qdc.field_type);
        abe.alz(com.tencent.mm.plugin.scanner.util.o.c(productUI.qdc));
        abe.aly(productUI.qdc.field_thumburl);
        clVar.cvA.title = productUI.qdc.field_title;
        clVar.cvA.desc = productUI.qdc.field_subtitle;
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 10;
        abf.a(abl);
        abf.b(abe);
        clVar.cvA.cvH = 11;
        clVar.cvA.activity = productUI;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        AppMethodBeat.o(81139);
    }

    static /* synthetic */ int w(ProductUI productUI) {
        AppMethodBeat.i(81141);
        int i = 0;
        TypedValue typedValue = new TypedValue();
        if (productUI.getTheme().resolveAttribute(R.attr.dx, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, productUI.getResources().getDisplayMetrics());
        }
        AppMethodBeat.o(81141);
        return i;
    }
}
