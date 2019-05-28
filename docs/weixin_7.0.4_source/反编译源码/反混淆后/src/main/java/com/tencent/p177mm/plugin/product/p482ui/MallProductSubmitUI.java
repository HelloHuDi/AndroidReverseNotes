package com.tencent.p177mm.plugin.product.p482ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p481b.C12807b;
import com.tencent.p177mm.plugin.product.p481b.C12808c;
import com.tencent.p177mm.plugin.product.p481b.C12811k;
import com.tencent.p177mm.plugin.product.p481b.C12812m;
import com.tencent.p177mm.plugin.product.p481b.C3595e;
import com.tencent.p177mm.plugin.product.p481b.C7016l;
import com.tencent.p177mm.plugin.product.p482ui.C39493d.C12827a;
import com.tencent.p177mm.plugin.product.p482ui.C39493d.C394941;
import com.tencent.p177mm.plugin.product.p482ui.C39496f.C39497a;
import com.tencent.p177mm.protocal.protobuf.C35968ze;
import com.tencent.p177mm.protocal.protobuf.bpz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI */
public class MallProductSubmitUI extends MallBaseUI implements C18765a {
    private Button gHn;
    private TextView iDT;
    private C3595e phd;
    private C12808c piK;
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
    private C12826a pjT;
    private ImageView pjm;
    private TextView pjn;
    private C39496f pjt;

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI$6 */
    class C36056 implements OnClickListener {
        C36056() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44144);
            C39496f d = MallProductSubmitUI.this.pjt;
            d.gNy.startActivityForResult(new Intent(d.gNy, MallProductReceiptUI.class), 4);
            AppMethodBeat.m2505o(44144);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI$8 */
    class C128248 implements OnItemClickListener {
        C128248() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44146);
            MallProductSubmitUI.this.dismissDialog(1);
            MallProductSubmitUI.this.piK.mo24808AL(i);
            MallProductSubmitUI.m32892a(MallProductSubmitUI.this);
            AppMethodBeat.m2505o(44146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI$5 */
    class C214435 implements OnClickListener {
        C214435() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44143);
            MallProductSubmitUI.this.showDialog(1);
            AppMethodBeat.m2505o(44143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI$1 */
    class C214441 implements C39497a {
        C214441() {
        }

        /* renamed from: t */
        public final void mo8191t(int i, int i2, String str) {
            AppMethodBeat.m2504i(44139);
            if (i == 0 && i2 == 0) {
                MallProductSubmitUI.m32892a(MallProductSubmitUI.this);
                AppMethodBeat.m2505o(44139);
                return;
            }
            MallProductSubmitUI.this.mo46815UJ(str);
            AppMethodBeat.m2505o(44139);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI$3 */
    class C214453 implements OnClickListener {
        C214453() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44141);
            C39496f d = MallProductSubmitUI.this.pjt;
            if (d.piK.bZR()) {
                int i;
                if (d.piK.bZI() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C12811k(d.piK.bZT()), 0);
                    AppMethodBeat.m2505o(44141);
                    return;
                }
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C7016l(d.piK.bZT(), d.piK.getAppId()), 0);
            }
            AppMethodBeat.m2505o(44141);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI$2 */
    class C214462 implements OnItemClickListener {
        C214462() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44140);
            C46134b c46134b = (C46134b) view.getTag();
            switch (c46134b.type) {
                case 1:
                    if (c46134b.pis instanceof String) {
                        MallProductSubmitUI.this.piK.pgX = (String) c46134b.pis;
                        break;
                    }
                    break;
                case 2:
                    C12812m c12812m = MallProductSubmitUI.this.piK.pgO;
                    if (c12812m.phs.phG != null && c12812m.phs.phG.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = c12812m.phs.phG.iterator();
                        while (it.hasNext()) {
                            arrayList.add((String) it.next());
                        }
                        c46134b.pis = arrayList;
                        break;
                    }
            }
            MallProductSubmitUI.this.pjT.mo24845a(MallProductSubmitUI.this, view, i);
            AppMethodBeat.m2505o(44140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductSubmitUI$4 */
    class C214474 implements OnClickListener {
        C214474() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44142);
            C39496f d = MallProductSubmitUI.this.pjt;
            Intent intent = new Intent();
            intent.putExtra("launch_from_webview", true);
            C25985d.m41453a(d.gNy, "address", ".ui.WalletSelectAddrUI", intent, 1, false);
            AppMethodBeat.m2505o(44142);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m32892a(MallProductSubmitUI mallProductSubmitUI) {
        AppMethodBeat.m2504i(44155);
        mallProductSubmitUI.m32895cu();
        AppMethodBeat.m2505o(44155);
    }

    public final int getLayoutId() {
        return 2130970400;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44147);
        super.onCreate(bundle);
        this.pjt = new C39496f(this.mController.ylL, new C214441());
        C34676a.bZC();
        this.piK = C34676a.bZD();
        this.phd = this.piK.phd;
        initView();
        m32895cu();
        AppMethodBeat.m2505o(44147);
    }

    public void onStart() {
        AppMethodBeat.m2504i(44148);
        this.pjt.onStart();
        super.onStart();
        AppMethodBeat.m2505o(44148);
    }

    public void onStop() {
        AppMethodBeat.m2504i(44149);
        this.pjt.onStop();
        super.onStop();
        AppMethodBeat.m2505o(44149);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44150);
        setMMTitle((int) C25738R.string.cy7);
        this.pjJ = (RelativeLayout) findViewById(2131826619);
        this.pjK = (TextView) findViewById(2131826621);
        this.pjL = (TextView) findViewById(2131826622);
        this.pjM = (MallProductItemView) findViewById(2131826623);
        this.pjN = (MallProductItemView) findViewById(2131826624);
        this.pjm = (ImageView) findViewById(2131826625);
        this.iDT = (TextView) findViewById(2131826626);
        this.pjO = (TextView) findViewById(2131826627);
        this.pjn = (TextView) findViewById(2131826628);
        this.pjP = (TextView) findViewById(2131826632);
        this.pjQ = (TextView) findViewById(2131826631);
        this.pjR = (TextView) findViewById(2131826630);
        this.pjS = (ListView) findViewById(2131826629);
        this.pjT = new C12826a(this);
        this.pjS.setAdapter(this.pjT);
        this.pjS.setOnItemClickListener(new C214462());
        this.gHn = (Button) findViewById(2131826633);
        this.gHn.setOnClickListener(new C214453());
        this.pjJ.setOnClickListener(new C214474());
        this.pjM.setOnClickListener(new C214435());
        this.pjN.setOnClickListener(new C36056());
        this.pjN.setVisibility(this.piK.bZF().cac() ? 0 : 8);
        if (this.piK.bZF().cab()) {
            this.pjM.setEnabled(false);
            this.pjM.setClickable(false);
            this.pjM.setSummary(getString(C25738R.string.cy5));
        }
        AppMethodBeat.m2505o(44150);
    }

    /* renamed from: cu */
    private void m32895cu() {
        AppMethodBeat.m2504i(44151);
        C12812m c12812m = this.piK.pgO;
        if (this.phd != null) {
            this.pjn.setText(C12807b.m20799s(this.phd.phh, this.phd.phh, c12812m.phs.pcl) + " x " + this.piK.mCount);
        } else {
            this.pjn.setText(C12807b.m20799s(c12812m.phs.phE, c12812m.phs.phF, c12812m.phs.pcl));
        }
        if (!C5046bo.isNullOrNil(this.piK.bZG())) {
            this.pjm.setImageBitmap(C18764x.m29325a(new C39492c(this.piK.bZG())));
            C18764x.m29326a((C18765a) this);
        }
        this.iDT.setText(c12812m.phs.name);
        this.pjO.setText(this.piK.bZH());
        bpz bZK = this.piK.bZK();
        if (bZK == null || C5046bo.isNullOrNil(bZK.naq)) {
            this.pjN.setSummary("");
        } else {
            this.pjN.setSummary(bZK.naq);
        }
        String str = "";
        if (!this.piK.bZF().cab()) {
            C35968ze c35968ze = this.piK.pgT;
            if (c35968ze != null) {
                this.pjM.setEnabled(true);
                this.pjM.setClickable(true);
                this.pjM.setSummary(C12807b.m20797a(this, c35968ze));
                str = getString(C25738R.string.cy3, new Object[]{C12807b.m20798d((double) c35968ze.vQt, c35968ze.PriceType)});
                this.pjL.setVisibility(8);
            } else {
                this.pjM.setEnabled(false);
                this.pjM.setClickable(false);
                this.pjM.setSummary(getString(C25738R.string.cy4));
                this.pjL.setVisibility(0);
            }
        }
        String str2 = "";
        if (this.piK.bZJ() > 0) {
            C5046bo.isNullOrNil(str);
            str2 = getString(C25738R.string.cy2, new Object[]{C12807b.m20798d((double) r3, c12812m.phs.pcl)});
        }
        LinkedList X = this.piK.mo24809X(this);
        if (X.size() > 0) {
            this.pjS.setVisibility(0);
            this.pjT.mo24846cz(X);
            this.pjT.notifyDataSetChanged();
        } else {
            this.pjS.setVisibility(8);
        }
        if (this.piK.pgU != null) {
            this.pjK.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", new Object[]{r3.jBB, r3.vEV, r3.guO, r3.guP, r3.naq})));
        }
        if (C5046bo.isNullOrNil(str + str2)) {
            this.pjQ.setVisibility(0);
            this.pjP.setVisibility(8);
        } else {
            this.pjP.setText(getString(C25738R.string.cy1, new Object[]{str + str2}));
            this.pjQ.setVisibility(8);
            this.pjP.setVisibility(0);
        }
        this.pjR.setText(C12807b.m20798d((double) this.piK.bZI(), c12812m.phs.pcl));
        this.gHn.setEnabled(this.piK.bZR());
        AppMethodBeat.m2505o(44151);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(44152);
        super.onActivityResult(i, i2, intent);
        this.pjt.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(44152);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(44153);
        C4990ab.m7410d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (C5046bo.isNullOrNil(this.piK.bZG())) {
            AppMethodBeat.m2505o(44153);
            return;
        }
        this.pjm.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(44145);
                MallProductSubmitUI.this.pjm.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(44145);
            }
        });
        AppMethodBeat.m2505o(44153);
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        Dialog aMb;
        AppMethodBeat.m2504i(44154);
        switch (i) {
            case 1:
                LinkedList<C35968ze> linkedList = this.piK.phb;
                if (linkedList != null) {
                    ArrayList arrayList = new ArrayList();
                    for (C35968ze a : linkedList) {
                        arrayList.add(C12807b.m20797a(this, a));
                    }
                    String string = getString(C25738R.string.cxw);
                    C128248 c128248 = new C128248();
                    C12827a c12827a = new C12827a(this);
                    ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this, 2130970120, null);
                    listViewInScrollView.setOnItemClickListener(new C394941(c128248, c12827a));
                    c12827a.aEB = arrayList;
                    c12827a.piC = 0;
                    listViewInScrollView.setAdapter(c12827a);
                    C5652a c5652a = new C5652a(this);
                    c5652a.asD(string);
                    c5652a.mo11479fn(listViewInScrollView);
                    c5652a.mo11478f(null);
                    aMb = c5652a.aMb();
                    aMb.show();
                    AppMethodBeat.m2505o(44154);
                    return aMb;
                }
                break;
        }
        aMb = super.onCreateDialog(i);
        AppMethodBeat.m2505o(44154);
        return aMb;
    }
}
