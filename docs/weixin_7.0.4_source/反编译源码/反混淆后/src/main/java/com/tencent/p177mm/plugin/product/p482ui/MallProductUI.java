package com.tencent.p177mm.plugin.product.p482ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p230g.p231a.C9421nd;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p481b.C12807b;
import com.tencent.p177mm.plugin.product.p481b.C12808c;
import com.tencent.p177mm.plugin.product.p481b.C12812m;
import com.tencent.p177mm.plugin.product.p481b.C12813n.C3596a;
import com.tencent.p177mm.plugin.product.p481b.C34677f;
import com.tencent.p177mm.plugin.product.p482ui.C39496f.C286762;
import com.tencent.p177mm.plugin.product.p482ui.C39496f.C394951;
import com.tencent.p177mm.plugin.product.p482ui.C39496f.C39497a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI */
public class MallProductUI extends MallBaseUI implements C18765a {
    private Button gHn;
    private TextView kEq;
    protected C12808c piK;
    private HtmlTextView pir;
    private ListView pjS;
    private C12826a pjT;
    private LinearLayout pjV;
    private LinearLayout pjW;
    private ImageView pjX;
    private TextView pjY;
    private HtmlTextView pjZ;
    private TextView pjn;
    private C39496f pjt;
    private RelativeLayout pka;
    private ListView pkb;
    private C43376k pkc = null;
    private Button pkd;

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$1 */
    class C36061 implements C39497a {

        /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$1$1 */
        class C36071 implements Runnable {
            C36071() {
            }

            public final void run() {
                AppMethodBeat.m2504i(44156);
                ScrollView scrollView = (ScrollView) MallProductUI.this.findViewById(2131826635);
                if (scrollView != null) {
                    scrollView.pageScroll(33);
                }
                AppMethodBeat.m2505o(44156);
            }
        }

        C36061() {
        }

        /* renamed from: t */
        public final void mo8191t(int i, int i2, String str) {
            AppMethodBeat.m2504i(44157);
            if (i == 0 && i2 == 0) {
                MallProductUI.this.mo51318cu();
                if (MallProductUI.this.gHn != null) {
                    MallProductUI.this.gHn.postDelayed(new C36071(), 200);
                    AppMethodBeat.m2505o(44157);
                    return;
                }
            } else if (i2 == -10010003) {
                MallProductUI.this.mo9439AM(0);
                MallProductUI.this.pjV.setVisibility(8);
                MallProductUI.this.pjW.setVisibility(0);
                MallProductUI.m50724d(MallProductUI.this);
                AppMethodBeat.m2505o(44157);
                return;
            } else {
                MallProductUI.this.mo46815UJ(str);
            }
            AppMethodBeat.m2505o(44157);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$3 */
    class C36083 implements OnItemClickListener {
        C36083() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44159);
            C46134b c46134b = (C46134b) view.getTag();
            switch (c46134b.type) {
                case 2:
                    C12812m c12812m = MallProductUI.this.piK.pgO;
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
            MallProductUI.this.pjT.mo24845a(MallProductUI.this, view, i);
            AppMethodBeat.m2505o(44159);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$4 */
    class C36094 implements OnClickListener {
        C36094() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44160);
            C39496f e = MallProductUI.this.pjt;
            C36391e.m59992af(e.gNy, e.piK.bZL());
            AppMethodBeat.m2505o(44160);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$2 */
    class C128252 implements OnMenuItemClickListener {
        C128252() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44158);
            C39496f e = MallProductUI.this.pjt;
            if (!C5046bo.isNullOrNil(e.piK.pgQ)) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C34677f(e.piK.bZS(), e.piK.pgQ), 0);
            }
            e.piK.clear();
            MallProductUI.this.finish();
            AppMethodBeat.m2505o(44158);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$6 */
    class C313816 implements OnClickListener {
        C313816() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44162);
            C39496f e = MallProductUI.this.pjt;
            if (e.piK.bZP()) {
                e.gNy.startActivity(new Intent(e.gNy, MallProductSelectSkuUI.class));
                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START, e.piK.bZL(), e.piK.pgO.pho, Integer.valueOf(C39496f.gOW), Integer.valueOf(1));
                AppMethodBeat.m2505o(44162);
                return;
            }
            C23639t.makeText(e.gNy, C25738R.string.cxd, 1).show();
            AppMethodBeat.m2505o(44162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$5 */
    class C313825 implements OnItemClickListener {
        C313825() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44161);
            C43379m c43379m = (C43379m) view.getTag();
            C39496f e = MallProductUI.this.pjt;
            if (!(c43379m == null || c43379m.pjH == null)) {
                C3596a c3596a = c43379m.pjH;
                C4990ab.m7416i("MicroMsg.MallProductUI", "goProductUI type : " + c3596a.type);
                Intent intent;
                switch (c3596a.type) {
                    case 0:
                        intent = new Intent();
                        intent.putExtra("rawUrl", c3596a.url);
                        C25985d.m41467b(e.gNy, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        AppMethodBeat.m2505o(44161);
                        return;
                    case 1:
                        String replace = c3596a.data.replace("product_id=", "");
                        intent = new Intent();
                        intent.putExtra("key_product_id", replace);
                        intent.putExtra("key_product_scene", 6);
                        C25985d.m41467b(e.gNy, "mall", ".product.ui.MallProductUI", intent);
                        e.gNy.finish();
                        break;
                }
            }
            AppMethodBeat.m2505o(44161);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$7 */
    class C313837 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.product.ui.MallProductUI$7$1 */
        class C313841 implements C30391c {
            C313841() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(44163);
                C39496f e;
                String bZV;
                Intent intent;
                switch (i) {
                    case 0:
                        e = MallProductUI.this.pjt;
                        bZV = e.piK.bZV();
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", bZV);
                        intent.putExtra("Retr_Msg_Type", 2);
                        if (!C5046bo.isNullOrNil(e.piK.pgO.bZY())) {
                            intent.putExtra("Retr_Msg_thumb_path", e.piK.bZM());
                        }
                        intent.putExtra("Retr_go_to_chattingUI", false);
                        intent.putExtra("Retr_show_success_tips", true);
                        intent.putExtra("Retr_Msg_Type", 2);
                        C25985d.m41473f(e.gNy, ".ui.transmit.MsgRetransmitUI", intent);
                        if (C39496f.gOW == 4) {
                            C7060h.pYm.mo8381e(10651, Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0));
                        }
                        AppMethodBeat.m2505o(44163);
                        return;
                    case 1:
                        e = MallProductUI.this.pjt;
                        C12812m c12812m = e.piK.pgO;
                        intent = new Intent();
                        intent.putExtra("KContentObjDesc", e.piK.bZW());
                        intent.putExtra("Ksnsupload_title", c12812m.phs.name);
                        intent.putExtra("Ksnsupload_link", e.piK.bZN());
                        intent.putExtra("Ksnsupload_imgurl", e.piK.pgO.bZY());
                        if (!C5046bo.isNullOrNil(e.piK.pgO.bZY())) {
                            intent.putExtra("KsnsUpload_imgPath", e.piK.bZM());
                        }
                        intent.putExtra("Ksnsupload_type", 6);
                        intent.putExtra("KUploadProduct_UserData", e.piK.mo24810a(c12812m));
                        intent.putExtra("KUploadProduct_subType", c12812m.php);
                        bZV = C37922v.m64078nW("scan_product");
                        C37922v.m64076Zp().mo60676y(bZV, true).mo53356j("prePublishId", "scan_product");
                        intent.putExtra("reportSessionId", bZV);
                        C25985d.m41467b(e.gNy, "sns", ".ui.SnsUploadUI", intent);
                        if (C39496f.gOW == 4) {
                            C7060h.pYm.mo8381e(10651, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0));
                        }
                        AppMethodBeat.m2505o(44163);
                        return;
                    case 2:
                        MallProductUI.this.pjt.cad();
                        AppMethodBeat.m2505o(44163);
                        return;
                    case 3:
                        e = MallProductUI.this.pjt;
                        C36391e.m59991ae(e.gNy, e.piK.bZL());
                        break;
                }
                AppMethodBeat.m2505o(44163);
            }
        }

        C313837() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44164);
            String[] stringArray = MallProductUI.this.getResources().getStringArray(C25738R.array.f12620a1);
            ArrayList arrayList = new ArrayList();
            for (Object add : stringArray) {
                arrayList.add(add);
            }
            boolean z = (MallProductUI.this.piK.bZF().piG & 1) > 0;
            C4990ab.m7410d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(z)));
            if (z) {
                arrayList.add(MallProductUI.this.getString(C25738R.string.cxq));
            }
            C30379h.m48424a(MallProductUI.this.mController.ylL, null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, false, new C313841());
            AppMethodBeat.m2505o(44164);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970402;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44166);
        super.onCreate(bundle);
        mo9439AM(8);
        boolean booleanExtra = getIntent().getBooleanExtra("key_go_finish", false);
        setResult(-1);
        if (booleanExtra) {
            finish();
            AppMethodBeat.m2505o(44166);
            return;
        }
        initView();
        C34676a.bZC();
        this.piK = C34676a.bZD();
        this.pjt = new C39496f(this.mController.ylL, new C36061());
        C39496f c39496f = this.pjt;
        C1720g.m3539RS().mo10300a(new C394951(getIntent(), new C12812m()));
        c39496f.piI = true;
        C4883b c9421nd = new C9421nd();
        c9421nd.cJm.errCode = -1;
        c9421nd.callback = new C286762(c9421nd);
        C4879a.xxA.mo10048a(c9421nd, Looper.getMainLooper());
        AppMethodBeat.m2505o(44166);
    }

    public void onResume() {
        AppMethodBeat.m2504i(44167);
        super.onResume();
        this.pjt.onStart();
        AppMethodBeat.m2505o(44167);
    }

    public void onPause() {
        AppMethodBeat.m2504i(44168);
        this.pjt.onStop();
        super.onPause();
        AppMethodBeat.m2505o(44168);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44169);
        setMMTitle((int) C25738R.string.cy8);
        setBackBtn(new C128252());
        this.pjV = (LinearLayout) findViewById(2131826636);
        this.pjW = (LinearLayout) findViewById(2131826647);
        this.pjX = (ImageView) findViewById(2131826637);
        this.kEq = (TextView) findViewById(2131826638);
        this.pjn = (TextView) findViewById(2131826639);
        this.pjY = (TextView) findViewById(2131826640);
        this.pjY.getPaint().setFlags(16);
        this.pka = (RelativeLayout) findViewById(2131826644);
        this.pir = (HtmlTextView) findViewById(2131826645);
        this.pjZ = (HtmlTextView) findViewById(2131826642);
        this.pjS = (ListView) findViewById(2131826646);
        this.pjT = new C12826a(this);
        this.pjS.setAdapter(this.pjT);
        this.pjS.setOnItemClickListener(new C36083());
        this.pkd = (Button) findViewById(2131826641);
        this.pkd.setOnClickListener(new C36094());
        this.pkb = (ListView) findViewById(2131826648);
        this.pkc = new C43376k(this);
        this.pkc.pjw = new C313825();
        this.pkb.setAdapter(this.pkc);
        this.gHn = (Button) findViewById(2131826643);
        this.gHn.setOnClickListener(new C313816());
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C313837());
        showOptionMenu(false);
        this.pjX.setFocusable(true);
        this.pjX.setFocusableInTouchMode(true);
        this.pjX.requestFocus();
        AppMethodBeat.m2505o(44169);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(44170);
        super.onNewIntent(intent);
        C4990ab.m7418v("MicroMsg.MallProductUI", "onNewIntent");
        setIntent(intent);
        AppMethodBeat.m2505o(44170);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cu */
    public final void mo51318cu() {
        AppMethodBeat.m2504i(44171);
        C12812m c12812m = this.piK.pgO;
        if (c12812m == null) {
            showOptionMenu(false);
            AppMethodBeat.m2505o(44171);
            return;
        }
        showOptionMenu(true);
        mo9439AM(0);
        this.pjV.setVisibility(0);
        this.pjW.setVisibility(8);
        if (c12812m.phs != null) {
            this.kEq.setText(c12812m.phs.name);
            this.pjn.setText(C12807b.m20799s(c12812m.phs.phE, c12812m.phs.phF, c12812m.phs.pcl));
            this.pjY.setText(C12807b.m20798d((double) c12812m.phs.phD, c12812m.phs.pcl));
        }
        if (this.piK.bZO() <= 0) {
            this.gHn.setEnabled(false);
            this.gHn.setText(C25738R.string.cxs);
        } else if (this.piK.pgO.phr <= 0) {
            this.gHn.setEnabled(false);
            this.gHn.setText(C25738R.string.cxr);
        } else {
            this.gHn.setEnabled(true);
            if (C5046bo.isNullOrNil(c12812m.phx)) {
                this.gHn.setText(C25738R.string.cxf);
            } else {
                this.gHn.setText(c12812m.phx);
            }
        }
        if (c12812m.phs == null || c12812m.phs.phN == null || c12812m.phs.phN.size() <= 0) {
            this.pjS.setVisibility(8);
        } else {
            this.pjS.setVisibility(0);
            this.pjT.mo24846cz(c12812m.phs.phN);
            this.pjT.notifyDataSetChanged();
        }
        if (c12812m.phs == null || C5046bo.isNullOrNil(c12812m.phs.detail)) {
            this.pka.setVisibility(8);
            this.pir.setVisibility(8);
        } else {
            this.pka.setVisibility(0);
            this.pir.setVisibility(0);
            this.pir.setText(c12812m.phs.detail);
        }
        if (C5046bo.isNullOrNil(c12812m.phy)) {
            this.pjZ.setVisibility(8);
        } else {
            this.pjZ.setVisibility(0);
            this.pjZ.setText(c12812m.phy);
        }
        showOptionMenu(true);
        if (!C5046bo.isNullOrNil(this.piK.pgW)) {
            this.pjX.setImageBitmap(C18764x.m29325a(new C39492c(this.piK.pgW)));
            C18764x.m29326a((C18765a) this);
        }
        AppMethodBeat.m2505o(44171);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(44172);
        if (str != null && str.equals(this.piK.pgW)) {
            this.pjX.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(44165);
                    MallProductUI.this.pjX.setImageBitmap(bitmap);
                    AppMethodBeat.m2505o(44165);
                }
            });
        }
        AppMethodBeat.m2505o(44172);
    }

    /* renamed from: d */
    static /* synthetic */ void m50724d(MallProductUI mallProductUI) {
        AppMethodBeat.m2504i(44173);
        List list = mallProductUI.piK.pgP;
        if (list != null && list.size() > 0) {
            mallProductUI.pkc.pjD = list;
        }
        AppMethodBeat.m2505o(44173);
    }
}
