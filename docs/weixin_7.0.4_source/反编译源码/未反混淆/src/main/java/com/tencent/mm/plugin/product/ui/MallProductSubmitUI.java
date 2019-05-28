package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MallProductSubmitUI extends MallBaseUI implements a {
    private Button gHn;
    private TextView iDT;
    private e phd;
    private c piK;
    private RelativeLayout pjJ;
    private TextView pjK;
    private TextView pjL;
    private MallProductItemView pjM;
    private MallProductItemView pjN;
    private TextView pjO;
    private TextView pjP;
    private TextView pjQ;
    private TextView pjR;
    private ListView pjS;
    private a pjT;
    private ImageView pjm;
    private TextView pjn;
    private f pjt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MallProductSubmitUI mallProductSubmitUI) {
        AppMethodBeat.i(44155);
        mallProductSubmitUI.cu();
        AppMethodBeat.o(44155);
    }

    public final int getLayoutId() {
        return R.layout.alg;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44147);
        super.onCreate(bundle);
        this.pjt = new f(this.mController.ylL, new f.a() {
            public final void t(int i, int i2, String str) {
                AppMethodBeat.i(44139);
                if (i == 0 && i2 == 0) {
                    MallProductSubmitUI.a(MallProductSubmitUI.this);
                    AppMethodBeat.o(44139);
                    return;
                }
                MallProductSubmitUI.this.UJ(str);
                AppMethodBeat.o(44139);
            }
        });
        com.tencent.mm.plugin.product.a.a.bZC();
        this.piK = com.tencent.mm.plugin.product.a.a.bZD();
        this.phd = this.piK.phd;
        initView();
        cu();
        AppMethodBeat.o(44147);
    }

    public void onStart() {
        AppMethodBeat.i(44148);
        this.pjt.onStart();
        super.onStart();
        AppMethodBeat.o(44148);
    }

    public void onStop() {
        AppMethodBeat.i(44149);
        this.pjt.onStop();
        super.onStop();
        AppMethodBeat.o(44149);
    }

    public final void initView() {
        AppMethodBeat.i(44150);
        setMMTitle((int) R.string.cy7);
        this.pjJ = (RelativeLayout) findViewById(R.id.dp8);
        this.pjK = (TextView) findViewById(R.id.dp_);
        this.pjL = (TextView) findViewById(R.id.dpa);
        this.pjM = (MallProductItemView) findViewById(R.id.dpb);
        this.pjN = (MallProductItemView) findViewById(R.id.dpc);
        this.pjm = (ImageView) findViewById(R.id.dpd);
        this.iDT = (TextView) findViewById(R.id.dpe);
        this.pjO = (TextView) findViewById(R.id.dpf);
        this.pjn = (TextView) findViewById(R.id.dpg);
        this.pjP = (TextView) findViewById(R.id.dpk);
        this.pjQ = (TextView) findViewById(R.id.dpj);
        this.pjR = (TextView) findViewById(R.id.dpi);
        this.pjS = (ListView) findViewById(R.id.dph);
        this.pjT = new a(this);
        this.pjS.setAdapter(this.pjT);
        this.pjS.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44140);
                b bVar = (b) view.getTag();
                switch (bVar.type) {
                    case 1:
                        if (bVar.pis instanceof String) {
                            MallProductSubmitUI.this.piK.pgX = (String) bVar.pis;
                            break;
                        }
                        break;
                    case 2:
                        m mVar = MallProductSubmitUI.this.piK.pgO;
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
                MallProductSubmitUI.this.pjT.a(MallProductSubmitUI.this, view, i);
                AppMethodBeat.o(44140);
            }
        });
        this.gHn = (Button) findViewById(R.id.dpl);
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44141);
                f d = MallProductSubmitUI.this.pjt;
                if (d.piK.bZR()) {
                    int i;
                    if (d.piK.bZI() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        g.RQ();
                        g.RO().eJo.a(new k(d.piK.bZT()), 0);
                        AppMethodBeat.o(44141);
                        return;
                    }
                    g.RQ();
                    g.RO().eJo.a(new l(d.piK.bZT(), d.piK.getAppId()), 0);
                }
                AppMethodBeat.o(44141);
            }
        });
        this.pjJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44142);
                f d = MallProductSubmitUI.this.pjt;
                Intent intent = new Intent();
                intent.putExtra("launch_from_webview", true);
                d.a(d.gNy, "address", ".ui.WalletSelectAddrUI", intent, 1, false);
                AppMethodBeat.o(44142);
            }
        });
        this.pjM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44143);
                MallProductSubmitUI.this.showDialog(1);
                AppMethodBeat.o(44143);
            }
        });
        this.pjN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44144);
                f d = MallProductSubmitUI.this.pjt;
                d.gNy.startActivityForResult(new Intent(d.gNy, MallProductReceiptUI.class), 4);
                AppMethodBeat.o(44144);
            }
        });
        this.pjN.setVisibility(this.piK.bZF().cac() ? 0 : 8);
        if (this.piK.bZF().cab()) {
            this.pjM.setEnabled(false);
            this.pjM.setClickable(false);
            this.pjM.setSummary(getString(R.string.cy5));
        }
        AppMethodBeat.o(44150);
    }

    private void cu() {
        AppMethodBeat.i(44151);
        m mVar = this.piK.pgO;
        if (this.phd != null) {
            this.pjn.setText(b.s(this.phd.phh, this.phd.phh, mVar.phs.pcl) + " x " + this.piK.mCount);
        } else {
            this.pjn.setText(b.s(mVar.phs.phE, mVar.phs.phF, mVar.phs.pcl));
        }
        if (!bo.isNullOrNil(this.piK.bZG())) {
            this.pjm.setImageBitmap(x.a(new c(this.piK.bZG())));
            x.a((a) this);
        }
        this.iDT.setText(mVar.phs.name);
        this.pjO.setText(this.piK.bZH());
        bpz bZK = this.piK.bZK();
        if (bZK == null || bo.isNullOrNil(bZK.naq)) {
            this.pjN.setSummary("");
        } else {
            this.pjN.setSummary(bZK.naq);
        }
        String str = "";
        if (!this.piK.bZF().cab()) {
            ze zeVar = this.piK.pgT;
            if (zeVar != null) {
                this.pjM.setEnabled(true);
                this.pjM.setClickable(true);
                this.pjM.setSummary(b.a(this, zeVar));
                str = getString(R.string.cy3, new Object[]{b.d((double) zeVar.vQt, zeVar.PriceType)});
                this.pjL.setVisibility(8);
            } else {
                this.pjM.setEnabled(false);
                this.pjM.setClickable(false);
                this.pjM.setSummary(getString(R.string.cy4));
                this.pjL.setVisibility(0);
            }
        }
        String str2 = "";
        if (this.piK.bZJ() > 0) {
            bo.isNullOrNil(str);
            str2 = getString(R.string.cy2, new Object[]{b.d((double) r3, mVar.phs.pcl)});
        }
        LinkedList X = this.piK.X(this);
        if (X.size() > 0) {
            this.pjS.setVisibility(0);
            this.pjT.cz(X);
            this.pjT.notifyDataSetChanged();
        } else {
            this.pjS.setVisibility(8);
        }
        if (this.piK.pgU != null) {
            this.pjK.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[]{r3.jBB, r3.vEV, r3.guO, r3.guP, r3.naq})));
        }
        if (bo.isNullOrNil(str + str2)) {
            this.pjQ.setVisibility(0);
            this.pjP.setVisibility(8);
        } else {
            this.pjP.setText(getString(R.string.cy1, new Object[]{str + str2}));
            this.pjQ.setVisibility(8);
            this.pjP.setVisibility(0);
        }
        this.pjR.setText(b.d((double) this.piK.bZI(), mVar.phs.pcl));
        this.gHn.setEnabled(this.piK.bZR());
        AppMethodBeat.o(44151);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(44152);
        super.onActivityResult(i, i2, intent);
        this.pjt.onActivityResult(i, i2, intent);
        AppMethodBeat.o(44152);
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(44153);
        ab.d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (bo.isNullOrNil(this.piK.bZG())) {
            AppMethodBeat.o(44153);
            return;
        }
        this.pjm.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(44145);
                MallProductSubmitUI.this.pjm.setImageBitmap(bitmap);
                AppMethodBeat.o(44145);
            }
        });
        AppMethodBeat.o(44153);
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        Dialog aMb;
        AppMethodBeat.i(44154);
        switch (i) {
            case 1:
                LinkedList<ze> linkedList = this.piK.phb;
                if (linkedList != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ze a : linkedList) {
                        arrayList.add(b.a(this, a));
                    }
                    String string = getString(R.string.cxw);
                    AnonymousClass8 anonymousClass8 = new OnItemClickListener() {
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            AppMethodBeat.i(44146);
                            MallProductSubmitUI.this.dismissDialog(1);
                            MallProductSubmitUI.this.piK.AL(i);
                            MallProductSubmitUI.a(MallProductSubmitUI.this);
                            AppMethodBeat.o(44146);
                        }
                    };
                    a aVar = new a(this);
                    ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this, R.layout.adx, null);
                    listViewInScrollView.setOnItemClickListener(new com.tencent.mm.plugin.product.ui.d.AnonymousClass1(anonymousClass8, aVar));
                    aVar.aEB = arrayList;
                    aVar.piC = 0;
                    listViewInScrollView.setAdapter(aVar);
                    com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(this);
                    aVar2.asD(string);
                    aVar2.fn(listViewInScrollView);
                    aVar2.f(null);
                    aMb = aVar2.aMb();
                    aMb.show();
                    AppMethodBeat.o(44154);
                    return aMb;
                }
                break;
        }
        aMb = super.onCreateDialog(i);
        AppMethodBeat.o(44154);
        return aMb;
    }
}
