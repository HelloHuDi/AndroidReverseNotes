package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.f;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MallProductUI extends MallBaseUI implements x.a {
    private Button gHn;
    private TextView kEq;
    protected c piK;
    private HtmlTextView pir;
    private ListView pjS;
    private a pjT;
    private LinearLayout pjV;
    private LinearLayout pjW;
    private ImageView pjX;
    private TextView pjY;
    private HtmlTextView pjZ;
    private TextView pjn;
    private f pjt;
    private RelativeLayout pka;
    private ListView pkb;
    private k pkc = null;
    private Button pkd;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.ali;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44166);
        super.onCreate(bundle);
        AM(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            AppMethodBeat.o(44166);
            return;
        }
        initView();
        com.tencent.mm.plugin.product.a.a.bZC();
        this.piK = com.tencent.mm.plugin.product.a.a.bZD();
        this.pjt = new f(this.mController.ylL, new f.a() {
            public final void t(int i, int i2, String str) {
                AppMethodBeat.i(44157);
                if (i == 0 && i2 == 0) {
                    MallProductUI.this.cu();
                    if (MallProductUI.this.gHn != null) {
                        MallProductUI.this.gHn.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(44156);
                                ScrollView scrollView = (ScrollView) MallProductUI.this.findViewById(R.id.dpn);
                                if (scrollView != null) {
                                    scrollView.pageScroll(33);
                                }
                                AppMethodBeat.o(44156);
                            }
                        }, 200);
                        AppMethodBeat.o(44157);
                        return;
                    }
                } else if (i2 == -10010003) {
                    MallProductUI.this.AM(0);
                    MallProductUI.this.pjV.setVisibility(8);
                    MallProductUI.this.pjW.setVisibility(0);
                    MallProductUI.d(MallProductUI.this);
                    AppMethodBeat.o(44157);
                    return;
                } else {
                    MallProductUI.this.UJ(str);
                }
                AppMethodBeat.o(44157);
            }
        });
        f fVar = this.pjt;
        g.RS().a(new com.tencent.mm.plugin.product.ui.f.AnonymousClass1(getIntent(), new m()));
        fVar.piI = true;
        b ndVar = new nd();
        ndVar.cJm.errCode = -1;
        ndVar.callback = new com.tencent.mm.plugin.product.ui.f.AnonymousClass2(ndVar);
        com.tencent.mm.sdk.b.a.xxA.a(ndVar, Looper.getMainLooper());
        AppMethodBeat.o(44166);
    }

    public void onResume() {
        AppMethodBeat.i(44167);
        super.onResume();
        this.pjt.onStart();
        AppMethodBeat.o(44167);
    }

    public void onPause() {
        AppMethodBeat.i(44168);
        this.pjt.onStop();
        super.onPause();
        AppMethodBeat.o(44168);
    }

    public final void initView() {
        AppMethodBeat.i(44169);
        setMMTitle((int) R.string.cy8);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44158);
                f e = MallProductUI.this.pjt;
                if (!bo.isNullOrNil(e.piK.pgQ)) {
                    g.RQ();
                    g.RO().eJo.a(new f(e.piK.bZS(), e.piK.pgQ), 0);
                }
                e.piK.clear();
                MallProductUI.this.finish();
                AppMethodBeat.o(44158);
                return true;
            }
        });
        this.pjV = (LinearLayout) findViewById(R.id.dpo);
        this.pjW = (LinearLayout) findViewById(R.id.dpz);
        this.pjX = (ImageView) findViewById(R.id.dpp);
        this.kEq = (TextView) findViewById(R.id.dpq);
        this.pjn = (TextView) findViewById(R.id.dpr);
        this.pjY = (TextView) findViewById(R.id.dps);
        this.pjY.getPaint().setFlags(16);
        this.pka = (RelativeLayout) findViewById(R.id.dpw);
        this.pir = (HtmlTextView) findViewById(R.id.dpx);
        this.pjZ = (HtmlTextView) findViewById(R.id.dpu);
        this.pjS = (ListView) findViewById(R.id.dpy);
        this.pjT = new a(this);
        this.pjS.setAdapter(this.pjT);
        this.pjS.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44159);
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 2:
                        m mVar = MallProductUI.this.piK.pgO;
                        if (mVar.phs.phG != null && mVar.phs.phG.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = mVar.phs.phG.iterator();
                            while (it.hasNext()) {
                                arrayList.add((String) it.next());
                            }
                            bVar.pis = arrayList;
                            break;
                        }
                }
                MallProductUI.this.pjT.a(MallProductUI.this, view, i);
                AppMethodBeat.o(44159);
            }
        });
        this.pkd = (Button) findViewById(R.id.dpt);
        this.pkd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44160);
                f e = MallProductUI.this.pjt;
                e.af(e.gNy, e.piK.bZL());
                AppMethodBeat.o(44160);
            }
        });
        this.pkb = (ListView) findViewById(R.id.dq0);
        this.pkc = new k(this);
        this.pkc.pjw = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44161);
                m mVar = (m) view.getTag();
                f e = MallProductUI.this.pjt;
                if (!(mVar == null || mVar.pjH == null)) {
                    n.a aVar = mVar.pjH;
                    ab.i("MicroMsg.MallProductUI", "goProductUI type : " + aVar.type);
                    Intent intent;
                    switch (aVar.type) {
                        case 0:
                            intent = new Intent();
                            intent.putExtra("rawUrl", aVar.url);
                            d.b(e.gNy, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(44161);
                            return;
                        case 1:
                            String replace = aVar.data.replace("product_id=", "");
                            intent = new Intent();
                            intent.putExtra("key_product_id", replace);
                            intent.putExtra("key_product_scene", 6);
                            d.b(e.gNy, "mall", ".product.ui.MallProductUI", intent);
                            e.gNy.finish();
                            break;
                    }
                }
                AppMethodBeat.o(44161);
            }
        };
        this.pkb.setAdapter(this.pkc);
        this.gHn = (Button) findViewById(R.id.dpv);
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44162);
                f e = MallProductUI.this.pjt;
                if (e.piK.bZP()) {
                    e.gNy.startActivity(new Intent(e.gNy, MallProductSelectSkuUI.class));
                    h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START, e.piK.bZL(), e.piK.pgO.pho, Integer.valueOf(f.gOW), Integer.valueOf(1));
                    AppMethodBeat.o(44162);
                    return;
                }
                t.makeText(e.gNy, R.string.cxd, 1).show();
                AppMethodBeat.o(44162);
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44164);
                String[] stringArray = MallProductUI.this.getResources().getStringArray(R.array.a1);
                ArrayList arrayList = new ArrayList();
                for (Object add : stringArray) {
                    arrayList.add(add);
                }
                boolean z = (MallProductUI.this.piK.bZF().piG & 1) > 0;
                ab.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(z)));
                if (z) {
                    arrayList.add(MallProductUI.this.getString(R.string.cxq));
                }
                com.tencent.mm.ui.base.h.a(MallProductUI.this.mController.ylL, null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, false, new com.tencent.mm.ui.base.h.c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(44163);
                        f e;
                        String bZV;
                        Intent intent;
                        switch (i) {
                            case 0:
                                e = MallProductUI.this.pjt;
                                bZV = e.piK.bZV();
                                intent = new Intent();
                                intent.putExtra("Retr_Msg_content", bZV);
                                intent.putExtra("Retr_Msg_Type", 2);
                                if (!bo.isNullOrNil(e.piK.pgO.bZY())) {
                                    intent.putExtra("Retr_Msg_thumb_path", e.piK.bZM());
                                }
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                intent.putExtra("Retr_Msg_Type", 2);
                                d.f(e.gNy, ".ui.transmit.MsgRetransmitUI", intent);
                                if (f.gOW == 4) {
                                    h.pYm.e(10651, Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0));
                                }
                                AppMethodBeat.o(44163);
                                return;
                            case 1:
                                e = MallProductUI.this.pjt;
                                m mVar = e.piK.pgO;
                                intent = new Intent();
                                intent.putExtra("KContentObjDesc", e.piK.bZW());
                                intent.putExtra("Ksnsupload_title", mVar.phs.name);
                                intent.putExtra("Ksnsupload_link", e.piK.bZN());
                                intent.putExtra("Ksnsupload_imgurl", e.piK.pgO.bZY());
                                if (!bo.isNullOrNil(e.piK.pgO.bZY())) {
                                    intent.putExtra("KsnsUpload_imgPath", e.piK.bZM());
                                }
                                intent.putExtra("Ksnsupload_type", 6);
                                intent.putExtra("KUploadProduct_UserData", e.piK.a(mVar));
                                intent.putExtra("KUploadProduct_subType", mVar.php);
                                bZV = v.nW("scan_product");
                                v.Zp().y(bZV, true).j("prePublishId", "scan_product");
                                intent.putExtra("reportSessionId", bZV);
                                d.b(e.gNy, "sns", ".ui.SnsUploadUI", intent);
                                if (f.gOW == 4) {
                                    h.pYm.e(10651, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0));
                                }
                                AppMethodBeat.o(44163);
                                return;
                            case 2:
                                MallProductUI.this.pjt.cad();
                                AppMethodBeat.o(44163);
                                return;
                            case 3:
                                e = MallProductUI.this.pjt;
                                e.ae(e.gNy, e.piK.bZL());
                                break;
                        }
                        AppMethodBeat.o(44163);
                    }
                });
                AppMethodBeat.o(44164);
                return true;
            }
        });
        showOptionMenu(false);
        this.pjX.setFocusable(true);
        this.pjX.setFocusableInTouchMode(true);
        this.pjX.requestFocus();
        AppMethodBeat.o(44169);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(44170);
        super.onNewIntent(intent);
        ab.v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
        AppMethodBeat.o(44170);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cu() {
        AppMethodBeat.i(44171);
        m mVar = this.piK.pgO;
        if (mVar == null) {
            showOptionMenu(false);
            AppMethodBeat.o(44171);
            return;
        }
        showOptionMenu(true);
        AM(0);
        this.pjV.setVisibility(0);
        this.pjW.setVisibility(8);
        if (mVar.phs != null) {
            this.kEq.setText(mVar.phs.name);
            this.pjn.setText(com.tencent.mm.plugin.product.b.b.s(mVar.phs.phE, mVar.phs.phF, mVar.phs.pcl));
            this.pjY.setText(com.tencent.mm.plugin.product.b.b.d((double) mVar.phs.phD, mVar.phs.pcl));
        }
        if (this.piK.bZO() <= 0) {
            this.gHn.setEnabled(false);
            this.gHn.setText(R.string.cxs);
        } else if (this.piK.pgO.phr <= 0) {
            this.gHn.setEnabled(false);
            this.gHn.setText(R.string.cxr);
        } else {
            this.gHn.setEnabled(true);
            if (bo.isNullOrNil(mVar.phx)) {
                this.gHn.setText(R.string.cxf);
            } else {
                this.gHn.setText(mVar.phx);
            }
        }
        if (mVar.phs == null || mVar.phs.phN == null || mVar.phs.phN.size() <= 0) {
            this.pjS.setVisibility(8);
        } else {
            this.pjS.setVisibility(0);
            this.pjT.cz(mVar.phs.phN);
            this.pjT.notifyDataSetChanged();
        }
        if (mVar.phs == null || bo.isNullOrNil(mVar.phs.detail)) {
            this.pka.setVisibility(8);
            this.pir.setVisibility(8);
        } else {
            this.pka.setVisibility(0);
            this.pir.setVisibility(0);
            this.pir.setText(mVar.phs.detail);
        }
        if (bo.isNullOrNil(mVar.phy)) {
            this.pjZ.setVisibility(8);
        } else {
            this.pjZ.setVisibility(0);
            this.pjZ.setText(mVar.phy);
        }
        showOptionMenu(true);
        if (!bo.isNullOrNil(this.piK.pgW)) {
            this.pjX.setImageBitmap(x.a(new c(this.piK.pgW)));
            x.a((x.a) this);
        }
        AppMethodBeat.o(44171);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(44172);
        if (str != null && str.equals(this.piK.pgW)) {
            this.pjX.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(44165);
                    MallProductUI.this.pjX.setImageBitmap(bitmap);
                    AppMethodBeat.o(44165);
                }
            });
        }
        AppMethodBeat.o(44172);
    }

    static /* synthetic */ void d(MallProductUI mallProductUI) {
        AppMethodBeat.i(44173);
        List list = mallProductUI.piK.pgP;
        if (list != null && list.size() > 0) {
            mallProductUI.pkc.pjD = list;
        }
        AppMethodBeat.o(44173);
    }
}
