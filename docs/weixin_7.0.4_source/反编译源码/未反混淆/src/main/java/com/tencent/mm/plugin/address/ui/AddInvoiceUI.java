package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.plugin.address.ui.InvoiceEditView.c;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;

public class AddInvoiceUI extends MMActivity implements f, c {
    private int Zb = 0;
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
    private b gJw = null;
    private b gJx = new b();
    private boolean gJy = false;
    private boolean gJz = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AddInvoiceUI() {
        AppMethodBeat.i(16792);
        AppMethodBeat.o(16792);
    }

    static /* synthetic */ boolean d(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.i(16804);
        boolean arW = addInvoiceUI.arW();
        AppMethodBeat.o(16804);
        return arW;
    }

    static /* synthetic */ void e(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.i(16805);
        addInvoiceUI.arY();
        AppMethodBeat.o(16805);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(16793);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.gJy = intent.getBooleanExtra("launch_from_webview", false);
        this.gJz = intent.getBooleanExtra("launch_from_invoicelist_webview", false);
        aw.Rg().a(1191, (f) this);
        ab.d("MicroMsg.AddInvoiceUI", "index Oncreate");
        this.gJx = new b();
        this.gJi = getIntent().getIntExtra("invoice_id", 0);
        if (this.gJi == 0) {
            setMMTitle((int) R.string.e5i);
        } else {
            setMMTitle((int) R.string.e8k);
        }
        initView();
        AppMethodBeat.o(16793);
    }

    public final void initView() {
        AppMethodBeat.i(16794);
        this.Zb = 0;
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.d8_);
        if (mMScrollView != null) {
            mMScrollView.a(mMScrollView, mMScrollView);
        }
        this.gJj = (Button) findViewById(R.id.d8c);
        if (this.gJj != null) {
            this.gJj.setVisibility(0);
        }
        this.gJk = (Button) findViewById(R.id.d8d);
        if (this.gJk != null) {
            this.gJk.setVisibility(0);
        }
        if (this.gJi == 0 && this.gJk != null) {
            this.gJk.setActivated(true);
        }
        if (this.gJk != null) {
            this.gJk.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(16787);
                    if (motionEvent.getAction() == 0) {
                        AppMethodBeat.o(16787);
                        return true;
                    } else if (motionEvent.getAction() != 1) {
                        AppMethodBeat.o(16787);
                        return false;
                    } else {
                        if (!AddInvoiceUI.this.gJk.isActivated()) {
                            AddInvoiceUI.this.gJk.setActivated(true);
                        }
                        if (AddInvoiceUI.this.gJk.isActivated()) {
                            AddInvoiceUI.this.gJj.setActivated(false);
                            AddInvoiceUI.this.gJx.type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        AddInvoiceUI.d(AddInvoiceUI.this);
                        AppMethodBeat.o(16787);
                        return true;
                    }
                }
            });
        }
        if (this.gJj != null) {
            this.gJj.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(16788);
                    if (motionEvent.getAction() == 0) {
                        AppMethodBeat.o(16788);
                        return true;
                    } else if (motionEvent.getAction() != 1) {
                        AppMethodBeat.o(16788);
                        return false;
                    } else {
                        if (!AddInvoiceUI.this.gJj.isActivated()) {
                            AddInvoiceUI.this.gJj.setActivated(true);
                        }
                        if (AddInvoiceUI.this.gJj.isActivated()) {
                            AddInvoiceUI.this.gJk.setActivated(false);
                            AddInvoiceUI.this.gJx.type = "1";
                        }
                        AddInvoiceUI.d(AddInvoiceUI.this);
                        AppMethodBeat.o(16788);
                        return true;
                    }
                }
            });
        }
        this.gJo = (InvoiceEditView) findViewById(R.id.d8e);
        this.gJp = (InvoiceEditView) findViewById(R.id.aj6);
        this.gJq = (InvoiceEditView) findViewById(R.id.d8f);
        this.gJr = (InvoiceEditView) findViewById(R.id.d8g);
        this.gJs = (InvoiceEditView) findViewById(R.id.d8h);
        this.gJt = (InvoiceEditView) findViewById(R.id.d8i);
        this.gJu = (InvoiceEditView) findViewById(R.id.d8j);
        this.gJv = (InvoiceEditView) findViewById(R.id.d8k);
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
            this.exj = (TextView) findViewById(R.id.n0);
            this.exj.setVisibility(8);
            this.gJm = (TextView) findViewById(R.id.d8b);
            this.gJw = a.arR().nd(this.gJi);
            if (this.gJw != null && this.gJw.type != null && this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.gJm.setText(getString(R.string.cfc));
            } else if (!(this.gJw == null || this.gJw.type == null || !this.gJw.type.equals("1"))) {
                this.gJm.setText(getString(R.string.cfi));
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
            this.gJn = (TextView) findViewById(R.id.cja);
            if (this.gJn != null) {
                this.gJn.setVisibility(0);
            }
        } else {
            this.gJn = (TextView) findViewById(R.id.cja);
            if (this.gJn != null) {
                this.gJn.setVisibility(8);
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16789);
                AddInvoiceUI.e(AddInvoiceUI.this);
                AppMethodBeat.o(16789);
                return true;
            }
        });
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16790);
                if (AddInvoiceUI.this.gJi == 0) {
                    h.pYm.e(14199, Integer.valueOf(3));
                } else {
                    h.pYm.e(14199, Integer.valueOf(4));
                }
                if (AddInvoiceUI.this.gJk != null && AddInvoiceUI.this.gJk.isActivated() && AddInvoiceUI.this.gJp.getText().length() == 0) {
                    AddInvoiceUI.this.arZ();
                    AppMethodBeat.o(16790);
                    return false;
                } else if (AddInvoiceUI.this.gJj != null && AddInvoiceUI.this.gJj.isActivated() && AddInvoiceUI.this.gJq.getText().length() == 0) {
                    AddInvoiceUI.this.arZ();
                    AppMethodBeat.o(16790);
                    return false;
                } else if (AddInvoiceUI.this.gJi != 0 && AddInvoiceUI.this.gJq.getText().length() == 0 && AddInvoiceUI.this.gJp.getText().length() == 0) {
                    AddInvoiceUI.this.arZ();
                    AppMethodBeat.o(16790);
                    return false;
                } else if (AddInvoiceUI.this.gJr.getText().length() > 100) {
                    Context context = AddInvoiceUI.this;
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.string.cf9), context.getString(R.string.tz), false, null);
                    AppMethodBeat.o(16790);
                    return false;
                } else if (AddInvoiceUI.d(AddInvoiceUI.this)) {
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
                    AddInvoiceUI.o(AddInvoiceUI.this);
                    AppMethodBeat.o(16790);
                    return true;
                } else {
                    if ((AddInvoiceUI.this.gJk != null && AddInvoiceUI.this.gJk.isActivated()) || !(AddInvoiceUI.this.gJw == null || AddInvoiceUI.this.gJw.type == null || !AddInvoiceUI.this.gJw.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                        Context context2;
                        if (!AddInvoiceUI.this.gJt.asa()) {
                            context2 = AddInvoiceUI.this;
                            com.tencent.mm.ui.base.h.a(context2, context2.getString(R.string.cfj), context2.getString(R.string.tz), false, null);
                        }
                        if (!AddInvoiceUI.this.gJv.asa()) {
                            context2 = AddInvoiceUI.this;
                            com.tencent.mm.ui.base.h.a(context2, context2.getString(R.string.cf6), context2.getString(R.string.tz), false, null);
                        }
                    }
                    AppMethodBeat.o(16790);
                    return true;
                }
            }
        }, q.b.GREEN);
        enableOptionMenu(false);
        arW();
        AppMethodBeat.o(16794);
    }

    public void onDestroy() {
        AppMethodBeat.i(16795);
        aw.Rg().b(1180, (f) this);
        aw.Rg().b(1191, (f) this);
        getWindow().setSoftInputMode(3);
        super.onDestroy();
        AppMethodBeat.o(16795);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(16796);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bo.isNullOrNil(stringExtra)) {
                        ab.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.gJt.setValStr(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bo.isNullOrNil(stringExtra)) {
                        ab.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(stringExtra)));
                        this.gJt.setValStr(stringExtra);
                    }
                    this.cJo = intent.getStringExtra("kwcode");
                    AppMethodBeat.o(16796);
                    return;
                }
                break;
            case 3:
                if (i2 != -1) {
                    ab.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
                    break;
                }
                break;
        }
        AppMethodBeat.o(16796);
    }

    public final int getLayoutId() {
        return R.layout.ad2;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        Intent intent = null;
        AppMethodBeat.i(16797);
        ab.i("MicroMsg.AddInvoiceUI", "errType " + i + ",errCode " + i2 + ",errMsg " + str);
        if (this.gII != null) {
            this.gII.dismiss();
        }
        if (i != 0 || i2 != 0) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.cfo), getString(R.string.tz), false, null);
        } else if (mVar.getType() == 1180) {
            btz btz = ((i) mVar).gIL;
            if (!(btz == null || btz.wVS == null || btz.wVS.size() <= 0 || btz.wVS.get(0) == null)) {
                this.Zb = ((asa) btz.wVS.get(0)).wcR;
            }
            aw.Rg().b(1180, (f) this);
            aw.Rg().a(new com.tencent.mm.plugin.address.model.b(), 0);
            AppMethodBeat.o(16797);
            return;
        } else if (mVar.getType() == 1191) {
            aw.Rg().b(1191, (f) this);
            if (this.gJy) {
                ab.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
                b bVar = this.gJx;
                if (bVar == null) {
                    ab.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
                } else {
                    intent = new Intent();
                    intent.putExtra("type", bVar.type);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        intent.putExtra("title", bVar.title);
                        intent.putExtra("tax_number", bVar.nuJ);
                        intent.putExtra("company_address", bVar.nuP);
                        intent.putExtra("telephone", bVar.nuN);
                        intent.putExtra("bank_name", bVar.nuL);
                        intent.putExtra("bank_account", bVar.nuK);
                    } else {
                        intent.putExtra("title", bVar.nuI);
                    }
                }
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(16797);
                return;
            }
            if (this.gJi == 0 && this.Zb != 0) {
                intent = new Intent();
                intent.setClass(this, QrcodeInvoiceUI.class);
                intent.putExtra("invoice_id", this.Zb);
                startActivity(intent);
                this.Zb = 0;
            }
            finish();
            AppMethodBeat.o(16797);
            return;
        }
        AppMethodBeat.o(16797);
    }

    private boolean arW() {
        boolean z = false;
        AppMethodBeat.i(16798);
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
                    al(getString(R.string.cfu), 100);
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
                ViewStub viewStub = (ViewStub) findViewById(R.id.d8a);
                if (viewStub != null) {
                    viewStub.inflate();
                    this.gJl = (TextView) findViewById(R.id.f1f);
                }
                if (this.gJl != null) {
                    this.gJl.setVisibility(0);
                }
            }
            if (!this.gJs.asa()) {
                if (this.gJs.getText().length() > 100) {
                    al(getString(R.string.cf_), 100);
                }
                z3 = false;
            }
            if (!this.gJt.asa()) {
                if (this.gJt.getText().length() > 100) {
                    al(getString(R.string.cfk), 100);
                }
                z3 = false;
            }
            if (!this.gJu.asa()) {
                if (this.gJu.getText().length() > 100) {
                    al(getString(R.string.cf3), 100);
                }
                z3 = false;
            }
            if (this.gJv.asa()) {
                z = z3;
            } else if (this.gJv.getText().length() > 48) {
                al(getString(R.string.cf5), 39);
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
                    al(getString(R.string.cfu), 100);
                }
                z2 = false;
            }
            if (this.gJj != null && this.gJj.isActivated() && this.gJq.getText().length() == 0) {
                z2 = false;
            }
            enableOptionMenu(z2);
            z = z2;
        }
        AppMethodBeat.o(16798);
        return z;
    }

    public final void arX() {
        AppMethodBeat.i(16799);
        arW();
        AppMethodBeat.o(16799);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(16800);
        if (i == 4) {
            arY();
            AppMethodBeat.o(16800);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(16800);
        return onKeyUp;
    }

    private void arY() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(16801);
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
            com.tencent.mm.ui.base.h.a((Context) this, false, this.mController.ylL.getString(R.string.cf2), "", this.mController.ylL.getString(R.string.cf1), this.mController.ylL.getString(R.string.cf0), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(16791);
                    AddInvoiceUI.this.setResult(0);
                    AddInvoiceUI.this.finish();
                    AppMethodBeat.o(16791);
                }
            }, null);
            AppMethodBeat.o(16801);
            return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(16801);
    }

    private void al(String str, int i) {
        AppMethodBeat.i(16802);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.cf8, new Object[]{str, Integer.valueOf(i)}), getString(R.string.tz), false, null);
        AppMethodBeat.o(16802);
    }

    public final void arZ() {
        AppMethodBeat.i(16803);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.cfv), getString(R.string.tz), false, null);
        AppMethodBeat.o(16803);
    }

    static /* synthetic */ void o(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.i(16806);
        aw.Rg().a(new i(addInvoiceUI.gJx), 0);
        aw.Rg().a(1180, (f) addInvoiceUI);
        if (addInvoiceUI.gJi != 0) {
            ab.i("MicroMsg.AddInvoiceUI", "modify save invoice " + addInvoiceUI.gJx.toString());
        }
        addInvoiceUI.gII = com.tencent.mm.ui.base.h.b((Context) addInvoiceUI, "", true, null);
        AppMethodBeat.o(16806);
    }
}
