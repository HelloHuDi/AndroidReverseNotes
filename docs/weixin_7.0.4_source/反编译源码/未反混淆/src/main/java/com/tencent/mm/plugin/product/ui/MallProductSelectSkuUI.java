package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;

public class MallProductSelectSkuUI extends MallBaseUI implements a {
    private TextView iDT;
    private m pgO;
    private e phd;
    private c piK;
    private ImageView pjm;
    private TextView pjn;
    private TextView pjo;
    private Button pjp;
    private ListView pjq;
    private MallProductSelectAmountView pjr = null;
    private i pjs = null;
    private f pjt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MallProductSelectSkuUI mallProductSelectSkuUI) {
        AppMethodBeat.i(44118);
        mallProductSelectSkuUI.cu();
        AppMethodBeat.o(44118);
    }

    public final int getLayoutId() {
        return R.layout.ald;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44111);
        super.onCreate(bundle);
        this.pjt = new f(this.mController.ylL, new f.a() {
            public final void t(int i, int i2, String str) {
                AppMethodBeat.i(44105);
                if (i == 0 && i2 == 0) {
                    MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
                    AppMethodBeat.o(44105);
                    return;
                }
                MallProductSelectSkuUI.this.UJ(str);
                AppMethodBeat.o(44105);
            }
        });
        com.tencent.mm.plugin.product.a.a.bZC();
        this.piK = com.tencent.mm.plugin.product.a.a.bZD();
        this.pgO = this.piK.pgO;
        initView();
        cu();
        AppMethodBeat.o(44111);
    }

    public void onStart() {
        AppMethodBeat.i(44112);
        this.pjt.onStart();
        super.onStart();
        AppMethodBeat.o(44112);
    }

    public void onStop() {
        AppMethodBeat.i(44113);
        this.pjt.onStop();
        super.onStop();
        AppMethodBeat.o(44113);
    }

    public final void initView() {
        AppMethodBeat.i(44114);
        setMMTitle((int) R.string.cxo);
        this.pjm = (ImageView) findViewById(R.id.dox);
        this.iDT = (TextView) findViewById(R.id.doy);
        this.pjn = (TextView) findViewById(R.id.doz);
        this.pjo = (TextView) findViewById(R.id.dp2);
        this.pjp = (Button) findViewById(R.id.dp3);
        this.pjq = (ListView) findViewById(R.id.dp0);
        this.pjr = (MallProductSelectAmountView) findViewById(R.id.dp1);
        this.pjr.setAmount(this.piK.mCount);
        this.pjs = new i(this);
        if (this.pgO == null || this.pgO.phs == null || this.pgO.phs.phM == null) {
            ab.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.pjs.pjv = this.pgO.phs.phM;
        }
        this.pjs.pjw = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                e eVar = null;
                AppMethodBeat.i(44106);
                Pair pair = (Pair) view.getTag();
                MallProductSelectSkuUI mallProductSelectSkuUI = MallProductSelectSkuUI.this;
                c b = MallProductSelectSkuUI.this.piK;
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                ab.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
                if (b.pha.containsKey(str) && ((String) b.pha.get(str)).equals(str2)) {
                    e eVar2;
                    b.pha.remove(str);
                    b.pgS = c.V(b.pha);
                    if (b.pgZ != null) {
                        eVar2 = (e) b.pgZ.get(b.pgS);
                    } else {
                        eVar2 = null;
                    }
                    b.phd = eVar2;
                } else {
                    b.pha.put(str, str2);
                    b.pgS = c.V(b.pha);
                    ab.d("MicroMsg.MallProductManager", "getSkuInfoId (" + b.pgS + ")");
                    if (b.pgZ != null) {
                        b.phd = (e) b.pgZ.get(b.pgS);
                    }
                    mallProductSelectSkuUI.phd = eVar;
                    MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
                    AppMethodBeat.o(44106);
                }
                b.bZU();
                eVar = b.phd;
                mallProductSelectSkuUI.phd = eVar;
                MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
                AppMethodBeat.o(44106);
            }
        };
        this.pjq.setAdapter(this.pjs);
        this.pjr.setOnAmountChangeListener(new MallProductSelectAmountView.a() {
            public final void gF(int i) {
                AppMethodBeat.i(44107);
                MallProductSelectSkuUI.this.piK.mCount = i;
                MallProductSelectSkuUI.this.pjo.setVisibility(8);
                AppMethodBeat.o(44107);
            }

            public final void eZ(int i, int i2) {
                AppMethodBeat.i(44108);
                switch (i2) {
                    case 1:
                        MallProductSelectSkuUI.this.pjo.setText(R.string.cxj);
                        MallProductSelectSkuUI.this.pjo.setVisibility(0);
                        AppMethodBeat.o(44108);
                        return;
                    case 3:
                        MallProductSelectSkuUI.this.pjo.setText(MallProductSelectSkuUI.this.getString(R.string.cxk, new Object[]{Integer.valueOf(i)}));
                        MallProductSelectSkuUI.this.pjo.setVisibility(0);
                        break;
                }
                AppMethodBeat.o(44108);
            }
        });
        this.pjp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44109);
                f d = MallProductSelectSkuUI.this.pjt;
                if (d.piI) {
                    t.makeText(d.gNy, R.string.cxd, 1).show();
                    AppMethodBeat.o(44109);
                } else if (!d.piK.bZQ()) {
                    String str;
                    c cVar = d.piK;
                    if (cVar.pha != null && cVar.pha.size() < cVar.pgY && cVar.pgY > 0) {
                        Iterator it = cVar.pgO.phs.phM.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.product.c.m mVar = (com.tencent.mm.plugin.product.c.m) it.next();
                            if (!cVar.pha.containsKey(mVar.phX)) {
                                str = mVar.phY;
                                break;
                            }
                        }
                    }
                    str = null;
                    if (!bo.isNullOrNil(str)) {
                        t.makeText(d.gNy, d.gNy.getString(R.string.cxm, new Object[]{str}), 0).show();
                    }
                    AppMethodBeat.o(44109);
                } else if (d.piK.pgU != null) {
                    g.RQ();
                    g.RO().eJo.a(new j(d.piK.bZS(), f.gOW), 0);
                    AppMethodBeat.o(44109);
                } else {
                    d.c(d.gNy, "address", ".ui.WalletAddAddressUI", 2);
                    AppMethodBeat.o(44109);
                }
            }
        });
        this.pjm.setFocusable(true);
        this.pjm.setFocusableInTouchMode(true);
        this.pjm.requestFocus();
        AppMethodBeat.o(44114);
    }

    private void cu() {
        AppMethodBeat.i(44115);
        if (this.pgO != null) {
            if (this.phd == null || this.pgO.phs == null) {
                this.pjn.setText(b.s(this.pgO.phs.phE, this.pgO.phs.phF, this.pgO.phs.pcl));
            } else {
                this.pjn.setText(b.s(this.phd.phh, this.phd.phi, this.pgO.phs.pcl));
            }
            if (this.pgO.phs != null) {
                this.iDT.setText(this.pgO.phs.name);
            }
        }
        if (!bo.isNullOrNil(this.piK.bZG())) {
            this.pjm.setImageBitmap(x.a(new c(this.piK.bZG())));
            x.a((a) this);
        }
        this.pjo.setVisibility(8);
        this.pjr.eY(this.piK.bZO(), this.piK.pgO.phr);
        this.pjs.notifyDataSetChanged();
        AppMethodBeat.o(44115);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(44116);
        super.onActivityResult(i, i2, intent);
        this.pjt.onActivityResult(i, i2, intent);
        AppMethodBeat.o(44116);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(44117);
        ab.d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (bo.isNullOrNil(this.piK.bZG())) {
            AppMethodBeat.o(44117);
            return;
        }
        this.pjm.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(44110);
                MallProductSelectSkuUI.this.pjm.setImageBitmap(bitmap);
                AppMethodBeat.o(44110);
            }
        });
        AppMethodBeat.o(44117);
    }
}
