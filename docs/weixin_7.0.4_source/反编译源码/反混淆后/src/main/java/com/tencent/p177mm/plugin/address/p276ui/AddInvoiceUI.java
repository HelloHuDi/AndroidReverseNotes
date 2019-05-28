package com.tencent.p177mm.plugin.address.p276ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.address.model.C18974b;
import com.tencent.p177mm.plugin.address.model.C18976i;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.address.p276ui.InvoiceEditView.C26694c;
import com.tencent.p177mm.plugin.p984j.p985a.C12328b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.asa;
import com.tencent.p177mm.protocal.protobuf.btz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.address.ui.AddInvoiceUI */
public class AddInvoiceUI extends MMActivity implements C1202f, C26694c {
    /* renamed from: Zb */
    private int f17880Zb = 0;
    private String cJo = "";
    private TextView exj;
    private Dialog gII = null;
    private int gJi = 0;
    private Button gJj = null;
    private Button gJk = null;
    private TextView gJl;
    private TextView gJm;
    private TextView gJn = null;
    private InvoiceEditView gJo;
    private InvoiceEditView gJp;
    private InvoiceEditView gJq;
    private InvoiceEditView gJr;
    private InvoiceEditView gJs;
    private InvoiceEditView gJt;
    private InvoiceEditView gJu;
    private InvoiceEditView gJv;
    private C12328b gJw = null;
    private C12328b gJx = new C12328b();
    private boolean gJy = false;
    private boolean gJz = false;

    /* renamed from: com.tencent.mm.plugin.address.ui.AddInvoiceUI$4 */
    class C20404 implements OnMenuItemClickListener {
        C20404() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16790);
            if (AddInvoiceUI.this.gJi == 0) {
                C7060h.pYm.mo8381e(14199, Integer.valueOf(3));
            } else {
                C7060h.pYm.mo8381e(14199, Integer.valueOf(4));
            }
            if (AddInvoiceUI.this.gJk != null && AddInvoiceUI.this.gJk.isActivated() && AddInvoiceUI.this.gJp.getText().length() == 0) {
                AddInvoiceUI.this.arZ();
                AppMethodBeat.m2505o(16790);
                return false;
            } else if (AddInvoiceUI.this.gJj != null && AddInvoiceUI.this.gJj.isActivated() && AddInvoiceUI.this.gJq.getText().length() == 0) {
                AddInvoiceUI.this.arZ();
                AppMethodBeat.m2505o(16790);
                return false;
            } else if (AddInvoiceUI.this.gJi != 0 && AddInvoiceUI.this.gJq.getText().length() == 0 && AddInvoiceUI.this.gJp.getText().length() == 0) {
                AddInvoiceUI.this.arZ();
                AppMethodBeat.m2505o(16790);
                return false;
            } else if (AddInvoiceUI.this.gJr.getText().length() > 100) {
                Context context = AddInvoiceUI.this;
                C30379h.m48448a(context, context.getString(C25738R.string.cf9), context.getString(C25738R.string.f9238tz), false, null);
                AppMethodBeat.m2505o(16790);
                return false;
            } else if (AddInvoiceUI.m83878d(AddInvoiceUI.this)) {
                if (AddInvoiceUI.this.gJk.isActivated()) {
                    AddInvoiceUI.this.gJx.type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } else if (AddInvoiceUI.this.gJj.isActivated()) {
                    AddInvoiceUI.this.gJx.type = "1";
                }
                if (AddInvoiceUI.this.gJw != null) {
                    AddInvoiceUI.this.gJx.type = AddInvoiceUI.this.gJw.type;
                }
                AddInvoiceUI.this.gJx.title = AddInvoiceUI.this.gJp.getText();
                AddInvoiceUI.this.gJx.nuI = AddInvoiceUI.this.gJq.getText();
                AddInvoiceUI.this.gJx.nuJ = AddInvoiceUI.this.gJr.getText();
                AddInvoiceUI.this.gJx.nuH = AddInvoiceUI.this.gJi;
                AddInvoiceUI.this.gJx.nuN = AddInvoiceUI.this.gJt.getText();
                AddInvoiceUI.this.gJx.nuL = AddInvoiceUI.this.gJu.getText();
                AddInvoiceUI.this.gJx.nuK = AddInvoiceUI.this.gJv.getText();
                AddInvoiceUI.this.gJx.nuP = AddInvoiceUI.this.gJs.getText();
                AddInvoiceUI.m83889o(AddInvoiceUI.this);
                AppMethodBeat.m2505o(16790);
                return true;
            } else {
                if ((AddInvoiceUI.this.gJk != null && AddInvoiceUI.this.gJk.isActivated()) || !(AddInvoiceUI.this.gJw == null || AddInvoiceUI.this.gJw.type == null || !AddInvoiceUI.this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                    Context context2;
                    if (!AddInvoiceUI.this.gJt.asa()) {
                        context2 = AddInvoiceUI.this;
                        C30379h.m48448a(context2, context2.getString(C25738R.string.cfj), context2.getString(C25738R.string.f9238tz), false, null);
                    }
                    if (!AddInvoiceUI.this.gJv.asa()) {
                        context2 = AddInvoiceUI.this;
                        C30379h.m48448a(context2, context2.getString(C25738R.string.cf6), context2.getString(C25738R.string.f9238tz), false, null);
                    }
                }
                AppMethodBeat.m2505o(16790);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddInvoiceUI$2 */
    class C100232 implements OnTouchListener {
        C100232() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(16788);
            if (motionEvent.getAction() == 0) {
                AppMethodBeat.m2505o(16788);
                return true;
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.m2505o(16788);
                return false;
            } else {
                if (!AddInvoiceUI.this.gJj.isActivated()) {
                    AddInvoiceUI.this.gJj.setActivated(true);
                }
                if (AddInvoiceUI.this.gJj.isActivated()) {
                    AddInvoiceUI.this.gJk.setActivated(false);
                    AddInvoiceUI.this.gJx.type = "1";
                }
                AddInvoiceUI.m83878d(AddInvoiceUI.this);
                AppMethodBeat.m2505o(16788);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddInvoiceUI$3 */
    class C100243 implements OnMenuItemClickListener {
        C100243() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16789);
            AddInvoiceUI.m83879e(AddInvoiceUI.this);
            AppMethodBeat.m2505o(16789);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddInvoiceUI$5 */
    class C100255 implements OnClickListener {
        C100255() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16791);
            AddInvoiceUI.this.setResult(0);
            AddInvoiceUI.this.finish();
            AppMethodBeat.m2505o(16791);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddInvoiceUI$1 */
    class C455061 implements OnTouchListener {
        C455061() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(16787);
            if (motionEvent.getAction() == 0) {
                AppMethodBeat.m2505o(16787);
                return true;
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.m2505o(16787);
                return false;
            } else {
                if (!AddInvoiceUI.this.gJk.isActivated()) {
                    AddInvoiceUI.this.gJk.setActivated(true);
                }
                if (AddInvoiceUI.this.gJk.isActivated()) {
                    AddInvoiceUI.this.gJj.setActivated(false);
                    AddInvoiceUI.this.gJx.type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                AddInvoiceUI.m83878d(AddInvoiceUI.this);
                AppMethodBeat.m2505o(16787);
                return true;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AddInvoiceUI() {
        AppMethodBeat.m2504i(16792);
        AppMethodBeat.m2505o(16792);
    }

    /* renamed from: d */
    static /* synthetic */ boolean m83878d(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.m2504i(16804);
        boolean arW = addInvoiceUI.arW();
        AppMethodBeat.m2505o(16804);
        return arW;
    }

    /* renamed from: e */
    static /* synthetic */ void m83879e(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.m2504i(16805);
        addInvoiceUI.arY();
        AppMethodBeat.m2505o(16805);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(16793);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.gJy = intent.getBooleanExtra("launch_from_webview", false);
        this.gJz = intent.getBooleanExtra("launch_from_invoicelist_webview", false);
        C9638aw.m17182Rg().mo14539a(1191, (C1202f) this);
        C4990ab.m7410d("MicroMsg.AddInvoiceUI", "index Oncreate");
        this.gJx = new C12328b();
        this.gJi = getIntent().getIntExtra("invoice_id", 0);
        if (this.gJi == 0) {
            setMMTitle((int) C25738R.string.e5i);
        } else {
            setMMTitle((int) C25738R.string.e8k);
        }
        initView();
        AppMethodBeat.m2505o(16793);
    }

    public final void initView() {
        AppMethodBeat.m2504i(16794);
        this.f17880Zb = 0;
        MMScrollView mMScrollView = (MMScrollView) findViewById(2131825955);
        if (mMScrollView != null) {
            mMScrollView.mo67850a(mMScrollView, mMScrollView);
        }
        this.gJj = (Button) findViewById(2131825958);
        if (this.gJj != null) {
            this.gJj.setVisibility(0);
        }
        this.gJk = (Button) findViewById(2131825959);
        if (this.gJk != null) {
            this.gJk.setVisibility(0);
        }
        if (this.gJi == 0 && this.gJk != null) {
            this.gJk.setActivated(true);
        }
        if (this.gJk != null) {
            this.gJk.setOnTouchListener(new C455061());
        }
        if (this.gJj != null) {
            this.gJj.setOnTouchListener(new C100232());
        }
        this.gJo = (InvoiceEditView) findViewById(2131825960);
        this.gJp = (InvoiceEditView) findViewById(2131822290);
        this.gJq = (InvoiceEditView) findViewById(2131825961);
        this.gJr = (InvoiceEditView) findViewById(2131825962);
        this.gJs = (InvoiceEditView) findViewById(2131825963);
        this.gJt = (InvoiceEditView) findViewById(2131825964);
        this.gJu = (InvoiceEditView) findViewById(2131825965);
        this.gJv = (InvoiceEditView) findViewById(2131825966);
        this.gJr.gJU = true;
        this.gJr.gJN = true;
        this.gJr.setOnInputValidChangeListener(this);
        this.gJo.setOnInputValidChangeListener(this);
        this.gJp.setOnInputValidChangeListener(this);
        this.gJq.setOnInputValidChangeListener(this);
        this.gJs.setOnInputValidChangeListener(this);
        this.gJt.setOnInputValidChangeListener(this);
        this.gJu.setOnInputValidChangeListener(this);
        this.gJv.setOnInputValidChangeListener(this);
        if (this.gJi != 0) {
            this.exj = (TextView) findViewById(2131821051);
            this.exj.setVisibility(8);
            this.gJm = (TextView) findViewById(2131825957);
            this.gJw = C33045a.arR().mo44443nd(this.gJi);
            if (this.gJw != null && this.gJw.type != null && this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.gJm.setText(getString(C25738R.string.cfc));
            } else if (!(this.gJw == null || this.gJw.type == null || !this.gJw.type.equals("1"))) {
                this.gJm.setText(getString(C25738R.string.cfi));
            }
            this.gJm.setVisibility(0);
            this.gJk.setVisibility(8);
            this.gJj.setVisibility(8);
            if (this.gJw != null) {
                this.gJo.setValStr(this.gJw.type);
                this.gJp.setValStr(this.gJw.title);
                this.gJq.setValStr(this.gJw.nuI);
                this.gJr.setValStr(this.gJw.nuJ);
                this.gJs.setValStr(this.gJw.nuP);
                this.gJt.setValStr(this.gJw.nuN);
                this.gJu.setValStr(this.gJw.nuL);
                this.gJv.setValStr(this.gJw.nuK);
            }
        }
        if (this.gJz || this.gJy) {
            this.gJn = (TextView) findViewById(2131825032);
            if (this.gJn != null) {
                this.gJn.setVisibility(0);
            }
        } else {
            this.gJn = (TextView) findViewById(2131825032);
            if (this.gJn != null) {
                this.gJn.setVisibility(8);
            }
        }
        setBackBtn(new C100243());
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C20404(), C5535b.GREEN);
        enableOptionMenu(false);
        arW();
        AppMethodBeat.m2505o(16794);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(16795);
        C9638aw.m17182Rg().mo14546b(1180, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1191, (C1202f) this);
        getWindow().setSoftInputMode(3);
        super.onDestroy();
        AppMethodBeat.m2505o(16795);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(16796);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4990ab.m7410d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.gJt.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        C4990ab.m7410d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(stringExtra)));
                        this.gJt.setValStr(stringExtra);
                    }
                    this.cJo = intent.getStringExtra("kwcode");
                    AppMethodBeat.m2505o(16796);
                    return;
                }
                break;
            case 3:
                if (i2 != -1) {
                    C4990ab.m7416i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(16796);
    }

    public final int getLayoutId() {
        return 2130970088;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        Intent intent = null;
        AppMethodBeat.m2504i(16797);
        C4990ab.m7416i("MicroMsg.AddInvoiceUI", "errType " + i + ",errCode " + i2 + ",errMsg " + str);
        if (this.gII != null) {
            this.gII.dismiss();
        }
        if (i != 0 || i2 != 0) {
            C30379h.m48448a((Context) this, getString(C25738R.string.cfo), getString(C25738R.string.f9238tz), false, null);
        } else if (c1207m.getType() == 1180) {
            btz btz = ((C18976i) c1207m).gIL;
            if (!(btz == null || btz.wVS == null || btz.wVS.size() <= 0 || btz.wVS.get(0) == null)) {
                this.f17880Zb = ((asa) btz.wVS.get(0)).wcR;
            }
            C9638aw.m17182Rg().mo14546b(1180, (C1202f) this);
            C9638aw.m17182Rg().mo14541a(new C18974b(), 0);
            AppMethodBeat.m2505o(16797);
            return;
        } else if (c1207m.getType() == 1191) {
            C9638aw.m17182Rg().mo14546b(1191, (C1202f) this);
            if (this.gJy) {
                C4990ab.m7416i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
                C12328b c12328b = this.gJx;
                if (c12328b == null) {
                    C4990ab.m7412e("MicroMsg.InvoiceUtil", "invoiceObj == null");
                } else {
                    intent = new Intent();
                    intent.putExtra("type", c12328b.type);
                    if (c12328b.type == null || !c12328b.type.equals("1")) {
                        intent.putExtra("title", c12328b.title);
                        intent.putExtra("tax_number", c12328b.nuJ);
                        intent.putExtra("company_address", c12328b.nuP);
                        intent.putExtra("telephone", c12328b.nuN);
                        intent.putExtra("bank_name", c12328b.nuL);
                        intent.putExtra("bank_account", c12328b.nuK);
                    } else {
                        intent.putExtra("title", c12328b.nuI);
                    }
                }
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(16797);
                return;
            }
            if (this.gJi == 0 && this.f17880Zb != 0) {
                intent = new Intent();
                intent.setClass(this, QrcodeInvoiceUI.class);
                intent.putExtra("invoice_id", this.f17880Zb);
                startActivity(intent);
                this.f17880Zb = 0;
            }
            finish();
            AppMethodBeat.m2505o(16797);
            return;
        }
        AppMethodBeat.m2505o(16797);
    }

    private boolean arW() {
        boolean z = false;
        AppMethodBeat.m2504i(16798);
        boolean z2 = true;
        if ((this.gJk != null && this.gJk.isActivated()) || (this.gJw != null && this.gJw.type != null && this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            boolean z3;
            this.gJr.setVisibility(0);
            this.gJs.setVisibility(0);
            this.gJt.setVisibility(0);
            this.gJu.setVisibility(0);
            this.gJv.setVisibility(0);
            this.gJp.setVisibility(0);
            this.gJq.setVisibility(8);
            if (!(this.gJk.isActivated() || this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                z2 = false;
            }
            if (!this.gJp.asa()) {
                if (this.gJp.getText().length() > 100) {
                    m83875al(getString(C25738R.string.cfu), 100);
                }
                z2 = false;
            }
            if (this.gJk != null && this.gJk.isActivated() && this.gJp.getText().length() == 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            enableOptionMenu(z3);
            if (this.gJr.asa()) {
                if (this.gJl != null) {
                    this.gJl.setVisibility(8);
                }
            } else if (this.gJr.getText().length() > 0) {
                ViewStub viewStub = (ViewStub) findViewById(2131825956);
                if (viewStub != null) {
                    viewStub.inflate();
                    this.gJl = (TextView) findViewById(2131828440);
                }
                if (this.gJl != null) {
                    this.gJl.setVisibility(0);
                }
            }
            if (!this.gJs.asa()) {
                if (this.gJs.getText().length() > 100) {
                    m83875al(getString(C25738R.string.cf_), 100);
                }
                z3 = false;
            }
            if (!this.gJt.asa()) {
                if (this.gJt.getText().length() > 100) {
                    m83875al(getString(C25738R.string.cfk), 100);
                }
                z3 = false;
            }
            if (!this.gJu.asa()) {
                if (this.gJu.getText().length() > 100) {
                    m83875al(getString(C25738R.string.cf3), 100);
                }
                z3 = false;
            }
            if (this.gJv.asa()) {
                z = z3;
            } else if (this.gJv.getText().length() > 48) {
                m83875al(getString(C25738R.string.cf5), 39);
            }
        } else if ((this.gJj == null || !this.gJj.isActivated()) && (this.gJw == null || this.gJw.type == null || !this.gJw.type.equals("1"))) {
            this.gJr.setVisibility(0);
            this.gJs.setVisibility(0);
            this.gJt.setVisibility(0);
            this.gJu.setVisibility(0);
            this.gJv.setVisibility(0);
            this.gJq.setVisibility(8);
            this.gJp.setVisibility(0);
            this.gJq.setVisibility(8);
            if (!(this.gJj == null || this.gJj.isActivated() || this.gJk == null || this.gJk.isActivated())) {
                z2 = false;
            }
            if (!this.gJp.asa()) {
                z2 = false;
            }
            if (!this.gJr.asa()) {
                z2 = false;
            }
            if (!this.gJs.asa()) {
                z2 = false;
            }
            if (!this.gJt.asa()) {
                z2 = false;
            }
            if (!this.gJu.asa()) {
                z2 = false;
            }
            if (this.gJv.asa()) {
                z = z2;
            }
        } else {
            this.gJr.setVisibility(8);
            this.gJs.setVisibility(8);
            this.gJt.setVisibility(8);
            this.gJu.setVisibility(8);
            this.gJv.setVisibility(8);
            this.gJp.setVisibility(8);
            this.gJq.setVisibility(0);
            if (!(this.gJj.isActivated() || this.gJw.type.equals("1"))) {
                z2 = false;
            }
            if (!this.gJq.asa()) {
                if (this.gJq.getText().length() > 100) {
                    m83875al(getString(C25738R.string.cfu), 100);
                }
                z2 = false;
            }
            if (this.gJj != null && this.gJj.isActivated() && this.gJq.getText().length() == 0) {
                z2 = false;
            }
            enableOptionMenu(z2);
            z = z2;
        }
        AppMethodBeat.m2505o(16798);
        return z;
    }

    public final void arX() {
        AppMethodBeat.m2504i(16799);
        arW();
        AppMethodBeat.m2505o(16799);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(16800);
        if (i == 4) {
            arY();
            AppMethodBeat.m2505o(16800);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(16800);
        return onKeyUp;
    }

    private void arY() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(16801);
        if ((this.gJi == 0 || this.gJw == null || this.gJx.type == null || this.gJx.type.equals("") || this.gJx.type.equals(this.gJw.type)) && (this.gJi != 0 || this.gJx.type == null || this.gJx.type.equals(""))) {
            z = false;
        } else {
            z = true;
        }
        if (!(this.gJj == null || this.gJk == null || this.gJj.isActivated() || this.gJk.isActivated() || this.gJw != null)) {
            z = true;
        }
        if (this.gJp.asb()) {
            z = true;
        }
        if (this.gJq.asb()) {
            z = true;
        }
        if (this.gJr.asb()) {
            z = true;
        }
        if (this.gJs.asb()) {
            z = true;
        }
        if (this.gJt.asb()) {
            z = true;
        }
        if (this.gJu.asb()) {
            z = true;
        }
        if (!this.gJv.asb()) {
            z2 = z;
        }
        if (z2) {
            C30379h.m48453a((Context) this, false, this.mController.ylL.getString(C25738R.string.cf2), "", this.mController.ylL.getString(C25738R.string.cf1), this.mController.ylL.getString(C25738R.string.cf0), new C100255(), null);
            AppMethodBeat.m2505o(16801);
            return;
        }
        setResult(0);
        finish();
        AppMethodBeat.m2505o(16801);
    }

    /* renamed from: al */
    private void m83875al(String str, int i) {
        AppMethodBeat.m2504i(16802);
        C30379h.m48448a((Context) this, getString(C25738R.string.cf8, new Object[]{str, Integer.valueOf(i)}), getString(C25738R.string.f9238tz), false, null);
        AppMethodBeat.m2505o(16802);
    }

    public final void arZ() {
        AppMethodBeat.m2504i(16803);
        C30379h.m48448a((Context) this, getString(C25738R.string.cfv), getString(C25738R.string.f9238tz), false, null);
        AppMethodBeat.m2505o(16803);
    }

    /* renamed from: o */
    static /* synthetic */ void m83889o(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.m2504i(16806);
        C9638aw.m17182Rg().mo14541a(new C18976i(addInvoiceUI.gJx), 0);
        C9638aw.m17182Rg().mo14539a(1180, (C1202f) addInvoiceUI);
        if (addInvoiceUI.gJi != 0) {
            C4990ab.m7416i("MicroMsg.AddInvoiceUI", "modify save invoice " + addInvoiceUI.gJx.toString());
        }
        addInvoiceUI.gII = C30379h.m48458b((Context) addInvoiceUI, "", true, null);
        AppMethodBeat.m2505o(16806);
    }
}
