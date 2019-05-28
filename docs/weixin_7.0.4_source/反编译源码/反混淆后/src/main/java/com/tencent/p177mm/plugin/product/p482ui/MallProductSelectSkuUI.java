package com.tencent.p177mm.plugin.product.p482ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p481b.C12807b;
import com.tencent.p177mm.plugin.product.p481b.C12808c;
import com.tencent.p177mm.plugin.product.p481b.C12812m;
import com.tencent.p177mm.plugin.product.p481b.C34681j;
import com.tencent.p177mm.plugin.product.p481b.C3595e;
import com.tencent.p177mm.plugin.product.p482ui.C39496f.C39497a;
import com.tencent.p177mm.plugin.product.p482ui.MallProductSelectAmountView.C21442a;
import com.tencent.p177mm.plugin.product.p737c.C34682m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI */
public class MallProductSelectSkuUI extends MallBaseUI implements C18765a {
    private TextView iDT;
    private C12812m pgO;
    private C3595e phd;
    private C12808c piK;
    private ImageView pjm;
    private TextView pjn;
    private TextView pjo;
    private Button pjp;
    private ListView pjq;
    private MallProductSelectAmountView pjr = null;
    private C28678i pjs = null;
    private C39496f pjt;

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI$4 */
    class C128214 implements OnClickListener {
        C128214() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44109);
            C39496f d = MallProductSelectSkuUI.this.pjt;
            if (d.piI) {
                C23639t.makeText(d.gNy, C25738R.string.cxd, 1).show();
                AppMethodBeat.m2505o(44109);
            } else if (!d.piK.bZQ()) {
                String str;
                C12808c c12808c = d.piK;
                if (c12808c.pha != null && c12808c.pha.size() < c12808c.pgY && c12808c.pgY > 0) {
                    Iterator it = c12808c.pgO.phs.phM.iterator();
                    while (it.hasNext()) {
                        C34682m c34682m = (C34682m) it.next();
                        if (!c12808c.pha.containsKey(c34682m.phX)) {
                            str = c34682m.phY;
                            break;
                        }
                    }
                }
                str = null;
                if (!C5046bo.isNullOrNil(str)) {
                    C23639t.makeText(d.gNy, d.gNy.getString(C25738R.string.cxm, new Object[]{str}), 0).show();
                }
                AppMethodBeat.m2505o(44109);
            } else if (d.piK.pgU != null) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C34681j(d.piK.bZS(), C39496f.gOW), 0);
                AppMethodBeat.m2505o(44109);
            } else {
                C25985d.m41471c(d.gNy, "address", ".ui.WalletAddAddressUI", 2);
                AppMethodBeat.m2505o(44109);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI$1 */
    class C346841 implements C39497a {
        C346841() {
        }

        /* renamed from: t */
        public final void mo8191t(int i, int i2, String str) {
            AppMethodBeat.m2504i(44105);
            if (i == 0 && i2 == 0) {
                MallProductSelectSkuUI.m89383a(MallProductSelectSkuUI.this);
                AppMethodBeat.m2505o(44105);
                return;
            }
            MallProductSelectSkuUI.this.mo46815UJ(str);
            AppMethodBeat.m2505o(44105);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI$2 */
    class C346852 implements OnItemClickListener {
        C346852() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3595e c3595e = null;
            AppMethodBeat.m2504i(44106);
            Pair pair = (Pair) view.getTag();
            MallProductSelectSkuUI mallProductSelectSkuUI = MallProductSelectSkuUI.this;
            C12808c b = MallProductSelectSkuUI.this.piK;
            String str = (String) pair.first;
            String str2 = (String) pair.second;
            C4990ab.m7410d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
            if (b.pha.containsKey(str) && ((String) b.pha.get(str)).equals(str2)) {
                C3595e c3595e2;
                b.pha.remove(str);
                b.pgS = C12808c.m20801V(b.pha);
                if (b.pgZ != null) {
                    c3595e2 = (C3595e) b.pgZ.get(b.pgS);
                } else {
                    c3595e2 = null;
                }
                b.phd = c3595e2;
            } else {
                b.pha.put(str, str2);
                b.pgS = C12808c.m20801V(b.pha);
                C4990ab.m7410d("MicroMsg.MallProductManager", "getSkuInfoId (" + b.pgS + ")");
                if (b.pgZ != null) {
                    b.phd = (C3595e) b.pgZ.get(b.pgS);
                }
                mallProductSelectSkuUI.phd = c3595e;
                MallProductSelectSkuUI.m89383a(MallProductSelectSkuUI.this);
                AppMethodBeat.m2505o(44106);
            }
            b.bZU();
            c3595e = b.phd;
            mallProductSelectSkuUI.phd = c3595e;
            MallProductSelectSkuUI.m89383a(MallProductSelectSkuUI.this);
            AppMethodBeat.m2505o(44106);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI$3 */
    class C394913 implements C21442a {
        C394913() {
        }

        /* renamed from: gF */
        public final void mo36912gF(int i) {
            AppMethodBeat.m2504i(44107);
            MallProductSelectSkuUI.this.piK.mCount = i;
            MallProductSelectSkuUI.this.pjo.setVisibility(8);
            AppMethodBeat.m2505o(44107);
        }

        /* renamed from: eZ */
        public final void mo36911eZ(int i, int i2) {
            AppMethodBeat.m2504i(44108);
            switch (i2) {
                case 1:
                    MallProductSelectSkuUI.this.pjo.setText(C25738R.string.cxj);
                    MallProductSelectSkuUI.this.pjo.setVisibility(0);
                    AppMethodBeat.m2505o(44108);
                    return;
                case 3:
                    MallProductSelectSkuUI.this.pjo.setText(MallProductSelectSkuUI.this.getString(C25738R.string.cxk, new Object[]{Integer.valueOf(i)}));
                    MallProductSelectSkuUI.this.pjo.setVisibility(0);
                    break;
            }
            AppMethodBeat.m2505o(44108);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m89383a(MallProductSelectSkuUI mallProductSelectSkuUI) {
        AppMethodBeat.m2504i(44118);
        mallProductSelectSkuUI.m89386cu();
        AppMethodBeat.m2505o(44118);
    }

    public final int getLayoutId() {
        return 2130970397;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44111);
        super.onCreate(bundle);
        this.pjt = new C39496f(this.mController.ylL, new C346841());
        C34676a.bZC();
        this.piK = C34676a.bZD();
        this.pgO = this.piK.pgO;
        initView();
        m89386cu();
        AppMethodBeat.m2505o(44111);
    }

    public void onStart() {
        AppMethodBeat.m2504i(44112);
        this.pjt.onStart();
        super.onStart();
        AppMethodBeat.m2505o(44112);
    }

    public void onStop() {
        AppMethodBeat.m2504i(44113);
        this.pjt.onStop();
        super.onStop();
        AppMethodBeat.m2505o(44113);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44114);
        setMMTitle((int) C25738R.string.cxo);
        this.pjm = (ImageView) findViewById(2131826608);
        this.iDT = (TextView) findViewById(2131826609);
        this.pjn = (TextView) findViewById(2131826610);
        this.pjo = (TextView) findViewById(2131826613);
        this.pjp = (Button) findViewById(2131826614);
        this.pjq = (ListView) findViewById(2131826611);
        this.pjr = (MallProductSelectAmountView) findViewById(2131826612);
        this.pjr.setAmount(this.piK.mCount);
        this.pjs = new C28678i(this);
        if (this.pgO == null || this.pgO.phs == null || this.pgO.phs.phM == null) {
            C4990ab.m7412e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.pjs.pjv = this.pgO.phs.phM;
        }
        this.pjs.pjw = new C346852();
        this.pjq.setAdapter(this.pjs);
        this.pjr.setOnAmountChangeListener(new C394913());
        this.pjp.setOnClickListener(new C128214());
        this.pjm.setFocusable(true);
        this.pjm.setFocusableInTouchMode(true);
        this.pjm.requestFocus();
        AppMethodBeat.m2505o(44114);
    }

    /* renamed from: cu */
    private void m89386cu() {
        AppMethodBeat.m2504i(44115);
        if (this.pgO != null) {
            if (this.phd == null || this.pgO.phs == null) {
                this.pjn.setText(C12807b.m20799s(this.pgO.phs.phE, this.pgO.phs.phF, this.pgO.phs.pcl));
            } else {
                this.pjn.setText(C12807b.m20799s(this.phd.phh, this.phd.phi, this.pgO.phs.pcl));
            }
            if (this.pgO.phs != null) {
                this.iDT.setText(this.pgO.phs.name);
            }
        }
        if (!C5046bo.isNullOrNil(this.piK.bZG())) {
            this.pjm.setImageBitmap(C18764x.m29325a(new C39492c(this.piK.bZG())));
            C18764x.m29326a((C18765a) this);
        }
        this.pjo.setVisibility(8);
        this.pjr.mo36905eY(this.piK.bZO(), this.piK.pgO.phr);
        this.pjs.notifyDataSetChanged();
        AppMethodBeat.m2505o(44115);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(44116);
        super.onActivityResult(i, i2, intent);
        this.pjt.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(44116);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(44117);
        C4990ab.m7410d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (C5046bo.isNullOrNil(this.piK.bZG())) {
            AppMethodBeat.m2505o(44117);
            return;
        }
        this.pjm.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(44110);
                MallProductSelectSkuUI.this.pjm.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(44110);
            }
        });
        AppMethodBeat.m2505o(44117);
    }
}
