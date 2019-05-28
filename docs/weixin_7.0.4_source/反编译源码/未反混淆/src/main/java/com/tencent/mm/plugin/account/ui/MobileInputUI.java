package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class MobileInputUI extends MMActivity {
    protected String countryCode = null;
    protected String fHE = null;
    protected int flQ;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(125159);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(125159);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(125160);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(125160);
                return false;
            }
            ab.i("MicroMsg.MobileInputUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(125160);
            return true;
        }
    };
    protected String gBE = null;
    protected EditText gBJ;
    protected Button gBP;
    protected Button gBQ;
    private View gBR;
    protected Button gBS;
    protected MMFormInputView gCV;
    private ResizeLayout gCa;
    private Button gCj;
    protected int[] gCr = new int[5];
    protected MMFormInputView gDH;
    protected EditText gDI;
    protected MMFormVerifyCodeInputView gDJ;
    protected View gDK;
    protected TextView gDL;
    protected Button gDM;
    protected Button gDN;
    protected TextView gDO;
    protected TextView gDP;
    protected TextView gDQ;
    protected Button gDR;
    protected View gDS;
    protected boolean gDT = true;
    protected String gDU = null;
    protected String gDV = null;
    private int gDW = 0;
    private b gDX;
    protected boolean gDY;
    protected boolean gDa;
    private MMKeyboardUperView gDb;
    protected boolean gDc = false;
    private final int gDd = 128;
    protected LinearLayout grF;
    protected TextView grH;
    protected String grJ = null;
    protected String gsF;
    protected p guc;

    protected enum a {
        GoBack,
        GoNext;

        static {
            AppMethodBeat.o(125182);
        }
    }

    public interface b {
        void a(a aVar);

        void a(MobileInputUI mobileInputUI);

        void start();

        void stop();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MobileInputUI() {
        AppMethodBeat.i(125183);
        AppMethodBeat.o(125183);
    }

    static /* synthetic */ void S(Context context, String str) {
        AppMethodBeat.i(125199);
        R(context, str);
        AppMethodBeat.o(125199);
    }

    static /* synthetic */ void b(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125197);
        mobileInputUI.goBack();
        AppMethodBeat.o(125197);
    }

    static /* synthetic */ void f(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125202);
        mobileInputUI.are();
        AppMethodBeat.o(125202);
    }

    public final int getLayoutId() {
        return R.layout.ah3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125184);
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(this.mController.ylL.getResources().getColor(R.color.vz));
        this.gDW = getIntent().getIntExtra("mobile_input_purpose", 0);
        this.flQ = getIntent().getIntExtra("mobile_auth_type", 0);
        this.gDY = getIntent().getBooleanExtra("can_finish", false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125172);
                MobileInputUI.b(MobileInputUI.this);
                AppMethodBeat.o(125172);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        xE(this.mController.ylL.getResources().getColor(R.color.vy));
        dyb();
        switch (this.gDW) {
            case -1:
                this.gDX = new l();
                break;
            case 1:
                if (!bo.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
                    this.gDX = new l();
                    break;
                }
                int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
                if (intArrayExtra != null) {
                    this.gCr = intArrayExtra;
                }
                this.gDX = new i();
                break;
            case 2:
                this.gDX = new k();
                break;
            case 3:
                this.gDX = new h();
                break;
            case 4:
                this.gDX = new j();
                break;
            default:
                ab.e("MicroMsg.MobileInputUI", "wrong purpose %s", Integer.valueOf(this.gDW));
                finish();
                AppMethodBeat.o(125184);
                return;
        }
        this.countryCode = av.amO(bo.bc(getIntent().getStringExtra("couttry_code"), ""));
        this.fHE = bo.bc(getIntent().getStringExtra("country_name"), "");
        this.gBE = bo.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.grJ = bo.bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.gDU = av.amP(this.countryCode);
        this.gDV = bo.bc(getIntent().getStringExtra("input_mobile_number"), "");
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        this.gDc = getIntent().getBooleanExtra("from_deep_link", false);
        if (!(!this.gDc || bo.isNullOrNil(this.gDU) || bo.isNullOrNil(this.gDV))) {
            this.gDH.setText(this.gDV);
        }
        this.gDX.a(this);
        if (f.EX_DEVICE_LOGIN) {
            this.gCj.setVisibility(0);
            this.gCj.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125174);
                    d.H(MobileInputUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
                    MobileInputUI.this.overridePendingTransition(R.anim.cd, R.anim.s);
                    AppMethodBeat.o(125174);
                }
            });
        }
        this.gDa = getIntent().getBooleanExtra("from_switch_account", false);
        AppMethodBeat.o(125184);
    }

    public void onResume() {
        AppMethodBeat.i(125185);
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        super.onResume();
        this.gDX.start();
        AppMethodBeat.o(125185);
    }

    public void onPause() {
        AppMethodBeat.i(125186);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        this.gDX.stop();
        AppMethodBeat.o(125186);
    }

    public void finish() {
        AppMethodBeat.i(125187);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        h.pYm.e(14262, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]));
        AppMethodBeat.o(125187);
    }

    public void onDestroy() {
        AppMethodBeat.i(125188);
        com.tencent.mm.plugin.normsg.a.b.oTO.TK("ie_reg_eu");
        this.gDJ.reset();
        super.onDestroy();
        AppMethodBeat.o(125188);
    }

    private void apc() {
        AppMethodBeat.i(125189);
        if (bo.isNullOrNil(this.fHE) || bo.isNullOrNil(this.countryCode)) {
            this.gBE = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            ab.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.gBE);
            if (bo.isNullOrNil(this.gBE)) {
                ab.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                AppMethodBeat.o(125189);
                return;
            }
            com.tencent.mm.au.b.a k = com.tencent.mm.au.b.k(this, this.gBE, getString(R.string.b3_));
            if (k == null) {
                ab.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                AppMethodBeat.o(125189);
                return;
            }
            this.countryCode = av.amO(k.fHD);
            this.fHE = k.fHE;
            AppMethodBeat.o(125189);
            return;
        }
        AppMethodBeat.o(125189);
    }

    public final void initView() {
        AppMethodBeat.i(125190);
        this.gCV = (MMFormInputView) findViewById(R.id.dbs);
        this.gBJ = this.gCV.getContentEditText();
        com.tencent.mm.ui.tools.b.c.d(this.gBJ).PM(16).a(null);
        this.gDH = (MMFormInputView) findViewById(R.id.dbr);
        this.gDH.setInputType(3);
        this.gDI = this.gDH.getContentEditText();
        this.gDJ = (MMFormVerifyCodeInputView) findViewById(R.id.cql);
        this.gDJ.setInputType(3);
        this.grF = (LinearLayout) findViewById(R.id.a4x);
        this.grH = (TextView) findViewById(R.id.a4z);
        this.gDK = findViewById(R.id.dbt);
        this.gDL = (TextView) findViewById(R.id.dbu);
        this.gDM = (Button) findViewById(R.id.daa);
        this.gDN = (Button) findViewById(R.id.ay8);
        this.gDO = (TextView) findViewById(R.id.dbp);
        this.gDP = (TextView) findViewById(R.id.p_);
        this.gDQ = (TextView) findViewById(R.id.dbq);
        this.gDR = (Button) findViewById(R.id.cqb);
        this.gCj = (Button) findViewById(R.id.cqd);
        this.gBP = (Button) findViewById(R.id.cqf);
        this.gBQ = (Button) findViewById(R.id.cqh);
        this.gBR = findViewById(R.id.cqg);
        this.gBS = (Button) findViewById(R.id.cqi);
        this.gDS = findViewById(R.id.dbv);
        this.gCa = (ResizeLayout) findViewById(R.id.cq9);
        this.gDb = (MMKeyboardUperView) findViewById(R.id.jh);
        this.grF.setVisibility(8);
        this.gCV.setVisibility(8);
        this.gDJ.setVisibility(8);
        this.gDH.setVisibility(8);
        this.gDO.setVisibility(8);
        this.gDP.setVisibility(8);
        this.gDN.setVisibility(8);
        this.gDK.setVisibility(8);
        this.gDR.setVisibility(8);
        this.gCa.setOnSizeChanged(new com.tencent.mm.plugin.account.ui.ResizeLayout.a() {
            public final void aqZ() {
                AppMethodBeat.i(125175);
                MobileInputUI.c(MobileInputUI.this);
                AppMethodBeat.o(125175);
            }
        });
        this.gBP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125176);
                MobileInputUI.S(MobileInputUI.this, MobileInputUI.this.getString(R.string.g7t) + aa.dor());
                AppMethodBeat.o(125176);
            }
        });
        this.gBQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125177);
                MobileInputUI.S(MobileInputUI.this, MobileInputUI.this.getString(R.string.g7k, new Object[]{aa.dor()}));
                AppMethodBeat.o(125177);
            }
        });
        final com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(125178);
                if (lVar.dzR()) {
                    lVar.hi(ReaderCallback.HIDDEN_BAR, R.string.g0m);
                    lVar.hi(ReaderCallback.SHOW_BAR, R.string.g0k);
                }
                AppMethodBeat.o(125178);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(125179);
                switch (menuItem.getItemId()) {
                    case ReaderCallback.HIDDEN_BAR /*5001*/:
                        MobileInputUI.d(MobileInputUI.this);
                        AppMethodBeat.o(125179);
                        return;
                    case ReaderCallback.SHOW_BAR /*5002*/:
                        MobileInputUI.S(MobileInputUI.this, MobileInputUI.this.getString(R.string.gb3) + aa.dor());
                        break;
                }
                AppMethodBeat.o(125179);
            }
        };
        dVar.zQf = new com.tencent.mm.ui.widget.a.d.a() {
            public final void onDismiss() {
            }
        };
        if (aa.doo()) {
            this.gBS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125161);
                    MobileInputUI.d(MobileInputUI.this);
                    AppMethodBeat.o(125161);
                }
            });
        } else {
            this.gBR.setVisibility(8);
            this.gBS.setText(R.string.co6);
            this.gBS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125162);
                    dVar.cpD();
                    AppMethodBeat.o(125162);
                }
            });
        }
        final boolean[] zArr = new boolean[]{true};
        this.gDI.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(125163);
                if (z) {
                    zArr[0] = true;
                    AppMethodBeat.o(125163);
                    return;
                }
                com.tencent.mm.plugin.normsg.a.b.oTO.TK("ie_reg_eu");
                AppMethodBeat.o(125163);
            }
        });
        this.gDI.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125164);
                MobileInputUI.this.gDN.setEnabled(MobileInputUI.e(MobileInputUI.this));
                AppMethodBeat.o(125164);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(125165);
                if (zArr[0]) {
                    zArr[0] = false;
                    com.tencent.mm.plugin.normsg.a.b.oTO.TI("ie_reg_eu");
                }
                com.tencent.mm.plugin.normsg.a.b.oTO.TJ("ie_reg_eu");
                AppMethodBeat.o(125165);
            }
        });
        this.gBJ.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125166);
                MobileInputUI.this.gDN.setEnabled(MobileInputUI.e(MobileInputUI.this));
                AppMethodBeat.o(125166);
            }
        });
        this.gDI.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125167);
                if (i == 6 || i == 5) {
                    boolean e = MobileInputUI.e(MobileInputUI.this);
                    AppMethodBeat.o(125167);
                    return e;
                }
                AppMethodBeat.o(125167);
                return false;
            }
        });
        this.gDI.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125168);
                if (66 == i && keyEvent.getAction() == 0) {
                    boolean e = MobileInputUI.e(MobileInputUI.this);
                    AppMethodBeat.o(125168);
                    return e;
                }
                AppMethodBeat.o(125168);
                return false;
            }
        });
        zArr = new boolean[]{false};
        this.gDN.setEnabled(false);
        this.gDN.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(125169);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr[0] = true;
                        com.tencent.mm.plugin.normsg.a.b.oTO.fu("ce_reg_eu", "<Reg>");
                        break;
                    case 1:
                    case 6:
                        com.tencent.mm.plugin.normsg.a.b.oTO.a("ce_reg_eu", motionEvent);
                        com.tencent.mm.plugin.normsg.a.b.oTO.TN("ce_reg_eu");
                        break;
                }
                AppMethodBeat.o(125169);
                return false;
            }
        });
        this.gDN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125170);
                if (zArr[0]) {
                    zArr[0] = false;
                } else {
                    com.tencent.mm.plugin.normsg.a.b.oTO.fu("ce_reg_eu", "<Reg>");
                    com.tencent.mm.plugin.normsg.a.b.oTO.a("ce_reg_eu", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, CdnLogic.kBizGeneric));
                    com.tencent.mm.plugin.normsg.a.b.oTO.TN("ce_reg_eu");
                }
                MobileInputUI.f(MobileInputUI.this);
                AppMethodBeat.o(125170);
            }
        });
        if (bo.isNullOrNil(this.countryCode)) {
            this.fHE = getString(R.string.b3b);
            this.countryCode = av.amO(getString(R.string.b3a));
        } else {
            this.fHE = com.tencent.mm.au.b.l(this, this.countryCode, getString(R.string.b3_));
        }
        apc();
        arf();
        if (bo.isNullOrNil(this.grJ)) {
            this.gDI.setText(this.grJ);
        }
        this.grF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125171);
                Intent intent = new Intent();
                intent.putExtra("country_name", MobileInputUI.this.fHE);
                intent.putExtra("couttry_code", MobileInputUI.this.countryCode);
                intent.putExtra("iso_code", MobileInputUI.this.gBE);
                com.tencent.mm.plugin.account.a.a.gkE.b(intent, MobileInputUI.this);
                AppMethodBeat.o(125171);
            }
        });
        String str = "";
        if (com.tencent.mm.protocal.d.vxr) {
            str = getString(R.string.ru) + getString(R.string.fk);
        }
        setMMTitle(str);
        xE(getResources().getColor(R.color.vy));
        dyb();
        AppMethodBeat.o(125190);
    }

    private void are() {
        AppMethodBeat.i(125191);
        aqX();
        this.gDX.a(a.GoNext);
        AppMethodBeat.o(125191);
    }

    private void goBack() {
        AppMethodBeat.i(125192);
        if (this.gDY) {
            aqX();
            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            com.tencent.mm.ui.base.b.hM(this);
            AppMethodBeat.o(125192);
            return;
        }
        this.gDX.a(a.GoBack);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        aqX();
        finish();
        AppMethodBeat.o(125192);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125193);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(125193);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125193);
        return onKeyDown;
    }

    private void arf() {
        AppMethodBeat.i(125194);
        if (bo.isNullOrNil(this.fHE) || bo.isNullOrNil(this.countryCode)) {
            this.grH.setText(getString(R.string.d03));
            AppMethodBeat.o(125194);
            return;
        }
        this.grH.setText(av.hS(this.fHE, this.countryCode));
        AppMethodBeat.o(125194);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundle = null;
        int i3 = false;
        AppMethodBeat.i(125195);
        super.onActivityResult(i, i2, intent);
        if (i == 32047) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                h.pYm.a(712, 1, 1, false);
                if (this.gDX instanceof k) {
                    ((k) this.gDX).gDz = 1;
                }
                AppMethodBeat.o(125195);
                return;
            }
            h.pYm.a(712, 2, 1, false);
            if (this.gDX instanceof k) {
                ((k) this.gDX).gDz = 0;
            }
            this.gDX.a(a.GoNext);
            AppMethodBeat.o(125195);
        } else if (i == 32046) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i2 == -1 && r0 != null && r0.getString("go_next", "").equals("get_reg_verify_code")) {
                if (this.gDX instanceof k) {
                    ((k) this.gDX).gDz = 2;
                }
                this.gDX.a(a.GoNext);
            }
            AppMethodBeat.o(125195);
        } else if (i == 32045) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i2 == -1 && bundle != null && bundle.getString("go_next", "").equals("auth_again") && (this.gDX instanceof l)) {
                this.gDX.a(a.GoNext);
            }
            AppMethodBeat.o(125195);
        } else {
            switch (i2) {
                case -1:
                    if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                        String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                        int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                        String str = "MicroMsg.MobileInputUI";
                        String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
                        if (!bo.isNullOrNil(stringExtra)) {
                            i3 = stringExtra.length();
                        }
                        objArr[1] = Integer.valueOf(i3);
                        objArr[2] = Integer.valueOf(intExtra);
                        ab.d(str, str2, objArr);
                        if (intExtra == -217) {
                            are();
                            AppMethodBeat.o(125195);
                            return;
                        }
                    }
                    break;
                case 100:
                    this.fHE = bo.bc(intent.getStringExtra("country_name"), "");
                    this.countryCode = bo.bc(intent.getStringExtra("couttry_code"), "");
                    this.gBE = bo.bc(intent.getStringExtra("iso_code"), "");
                    if (this.gDW != 2 || com.tencent.mm.au.b.sP(this.countryCode)) {
                        arf();
                        AppMethodBeat.o(125195);
                        return;
                    }
                    Intent intent2 = new Intent(this, RegByMobileRegAIOUI.class);
                    intent2.putExtra("couttry_code", this.countryCode);
                    intent2.putExtra("country_name", this.fHE);
                    intent2.putExtra("iso_code", this.gBE);
                    startActivity(intent2);
                    finish();
                    AppMethodBeat.o(125195);
                    return;
            }
            AppMethodBeat.o(125195);
        }
    }

    public void setRequestedOrientation(int i) {
    }

    private static void R(Context context, String str) {
        AppMethodBeat.i(125196);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(125196);
    }

    static /* synthetic */ void c(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125198);
        View currentFocus = mobileInputUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - mobileInputUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                mobileInputUI.gDb.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(125173);
                        MobileInputUI.this.gDb.smoothScrollBy(0, height);
                        AppMethodBeat.o(125173);
                    }
                });
            }
        }
        AppMethodBeat.o(125198);
    }

    static /* synthetic */ void d(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125200);
        R(mobileInputUI, mobileInputUI.getString(R.string.g0n) + aa.dor());
        AppMethodBeat.o(125200);
    }

    static /* synthetic */ boolean e(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125201);
        if (!(mobileInputUI.gDI.getText() == null || bo.isNullOrNil(mobileInputUI.gDI.getText().toString()) || !mobileInputUI.gDT)) {
            if (mobileInputUI.gDW != 2) {
                AppMethodBeat.o(125201);
                return true;
            } else if (!(mobileInputUI.gBJ.getText() == null || bo.isNullOrNil(mobileInputUI.gBJ.getText().toString()))) {
                AppMethodBeat.o(125201);
                return true;
            }
        }
        AppMethodBeat.o(125201);
        return false;
    }
}
