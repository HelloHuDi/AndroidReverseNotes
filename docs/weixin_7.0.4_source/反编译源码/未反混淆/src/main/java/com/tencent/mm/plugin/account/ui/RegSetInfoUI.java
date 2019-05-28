package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.t;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.vfs.b;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI extends MMActivity implements f {
    private String bCu;
    private ProgressDialog ehJ = null;
    private String elr;
    private ba gBm = new ba();
    private c gCd;
    private String gDy;
    private int gEm;
    private int gEs;
    private int gEu;
    private boolean gFM = false;
    private String gFm;
    private EditText gGu;
    private ProgressBar gHA;
    private String gHB = "";
    private ImageView gHC;
    private View gHD;
    private TextView gHE;
    private String gHF = null;
    private boolean gHG = false;
    private o gHH;
    private View gHI;
    private boolean gHJ = false;
    private String gHK;
    private ap gHL = new ap(Looper.myLooper(), new a() {
        public final boolean BI() {
            String str;
            AppMethodBeat.i(125507);
            String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
            String trim2 = RegSetInfoUI.this.gGu.getText().toString().trim();
            if (bo.isNullOrNil(trim) && !bo.isNullOrNil(trim2)) {
                trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
            }
            if (bo.isNullOrNil(trim) || !bo.isNullOrNil(trim2)) {
                str = trim2;
            } else {
                str = trim;
            }
            if (!bo.isNullOrNil(trim) && RegSetInfoUI.c(RegSetInfoUI.this) && RegSetInfoUI.d(RegSetInfoUI.this)) {
                int e = RegSetInfoUI.e(RegSetInfoUI.this);
                String f = RegSetInfoUI.f(RegSetInfoUI.this);
                g.Rg().a((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                g.Rg().a(new ad(f, RegSetInfoUI.this.elr, e, str, trim, "", ""), 0);
                RegSetInfoUI.this.gHA.setVisibility(0);
            }
            AppMethodBeat.o(125507);
            return false;
        }
    }, true);
    private EditText gHm;
    private Button gHn;
    private String gHo;
    private String gHp;
    private int gHq;
    private String gHr;
    private String gHs;
    private TextView gHt;
    private View gHu;
    private boolean gHv = false;
    private ImageView gHw;
    private int gHx = 3;
    private LinkedList<String> gHy = new LinkedList();
    private ImageView gHz;
    private SecurityImage gue = null;
    private int sceneType = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegSetInfoUI() {
        AppMethodBeat.i(125540);
        AppMethodBeat.o(125540);
    }

    static /* synthetic */ boolean c(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125556);
        boolean ary = regSetInfoUI.ary();
        AppMethodBeat.o(125556);
        return ary;
    }

    static /* synthetic */ boolean d(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125557);
        boolean arB = regSetInfoUI.arB();
        AppMethodBeat.o(125557);
        return arB;
    }

    static /* synthetic */ int e(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125558);
        int arH = regSetInfoUI.arH();
        AppMethodBeat.o(125558);
        return arH;
    }

    static /* synthetic */ String f(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125559);
        String arI = regSetInfoUI.arI();
        AppMethodBeat.o(125559);
        return arI;
    }

    static /* synthetic */ void n(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125560);
        regSetInfoUI.arz();
        AppMethodBeat.o(125560);
    }

    static /* synthetic */ void s(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125562);
        regSetInfoUI.o(false, false);
        AppMethodBeat.o(125562);
    }

    static /* synthetic */ void w(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125563);
        regSetInfoUI.aoZ();
        AppMethodBeat.o(125563);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125541);
        super.onCreate(bundle);
        String string = getString(R.string.dn6);
        if (d.vxr) {
            string = getString(R.string.ru) + getString(R.string.fk);
        }
        setMMTitle(string);
        com.tencent.mm.plugin.account.a.a.gkF.BV();
        this.gHo = getIntent().getStringExtra("regsetinfo_user");
        this.gHp = getIntent().getStringExtra("regsetinfo_bind_email");
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gHr = getIntent().getStringExtra("regsetinfo_pwd");
        this.gHs = getIntent().getStringExtra("regsetinfo_binduin");
        this.gEm = getIntent().getIntExtra("mobile_check_type", 0);
        if (!bo.isNullOrNil(this.gHs)) {
            this.gHq = p.cB(this.gHs);
        }
        this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.gHv = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.gHx = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        this.gDy = getIntent().getStringExtra("regsession_id");
        this.gFm = getIntent().getStringExtra("reg_3d_app_ticket");
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        this.gEs = getIntent().getIntExtra("key_reg_style", 1);
        initView();
        StringBuilder stringBuilder;
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("R200_900_phone");
        } else if (this.sceneType == 2) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R4_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R4_QQ")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("R4_QQ");
        } else if (this.sceneType == 3) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_900_email,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_email")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("R200_900_email");
        }
        this.gHJ = false;
        this.gCd = new c();
        AppMethodBeat.o(125541);
    }

    public void onResume() {
        AppMethodBeat.i(125542);
        super.onResume();
        this.gGu.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(125518);
                RegSetInfoUI.this.gHw.requestFocus();
                RegSetInfoUI.this.gGu.clearFocus();
                AppMethodBeat.o(125518);
            }
        }, 500);
        AppMethodBeat.o(125542);
    }

    public void onDestroy() {
        AppMethodBeat.i(125543);
        super.onDestroy();
        StringBuilder stringBuilder;
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",2").toString());
        } else if (this.sceneType == 2) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R4_QQ,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R4_QQ")).append(",2").toString());
        } else if (this.sceneType == 3) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_900_email,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_email")).append(",2").toString());
        }
        if (this.gCd != null) {
            this.gCd.close();
        }
        AppMethodBeat.o(125543);
    }

    public final void initView() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(125544);
        this.gHI = findViewById(R.id.dyc);
        this.gHD = findViewById(R.id.dxj);
        this.gHw = (ImageView) findViewById(R.id.dxk);
        this.gGu = (EditText) findViewById(R.id.dyb);
        this.gHE = (TextView) findViewById(R.id.dya);
        this.gHm = (EditText) findViewById(R.id.dye);
        this.gHt = (TextView) findViewById(R.id.dyg);
        this.gHu = findViewById(R.id.dyd);
        this.gHz = (ImageView) findViewById(R.id.dyf);
        this.gHA = (ProgressBar) findViewById(R.id.dx1);
        this.gHC = (ImageView) findViewById(R.id.dxl);
        this.gHn = (Button) findViewById(R.id.ay8);
        this.gHz.setVisibility(8);
        this.gHA.setVisibility(8);
        this.gHC.setVisibility(8);
        this.gFM = false;
        this.gHG = false;
        this.gHD.setVisibility(arA() ? 0 : 8);
        View view = this.gHu;
        if (arB()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        TextView textView = this.gHt;
        if (!arB()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (arA() && arB()) {
            this.gHE.setText(getString(R.string.dn3));
        } else if (arA() && !arB()) {
            this.gHE.setText(getString(R.string.dn1));
        } else if (arA() || !arB()) {
            this.gHE.setText(getString(R.string.dn0));
        } else {
            this.gHE.setText(getString(R.string.dn2));
        }
        g.RS().a(new al.a() {
            String gHT;
            Bitmap mBitmap;

            public final boolean acg() {
                AppMethodBeat.i(125528);
                if (!bo.isNullOrNil(this.gHT) && bo.isNullOrNil((RegSetInfoUI.this.gGu.getText()).trim())) {
                    RegSetInfoUI.this.gGu.setText(this.gHT);
                }
                if (com.tencent.mm.compatible.util.f.Mn()) {
                    if (!(this.mBitmap == null || this.mBitmap.isRecycled() || RegSetInfoUI.this.gFM)) {
                        RegSetInfoUI.this.gHw.setImageBitmap(this.mBitmap);
                        RegSetInfoUI.this.gFM = true;
                        RegSetInfoUI.this.gHC.setVisibility(0);
                    }
                    AppMethodBeat.o(125528);
                    return true;
                }
                ab.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
                AppMethodBeat.o(125528);
                return false;
            }

            public final boolean acf() {
                AppMethodBeat.i(125529);
                try {
                    this.gHT = i.cj(RegSetInfoUI.this);
                    this.mBitmap = i.ck(RegSetInfoUI.this);
                } catch (Exception e) {
                    ab.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + e.getMessage());
                }
                if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(this.mBitmap, 100, CompressFormat.PNG, e.euY + "temp.avatar", false);
                    } catch (Exception e2) {
                        ab.e("MiroMsg.RegSetInfoUI", "save avatar fail." + e2.getMessage());
                        ab.printErrStackTrace("MiroMsg.RegSetInfoUI", e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(125529);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(125530);
                String str = super.toString() + "|initView";
                AppMethodBeat.o(125530);
                return str;
            }
        });
        this.gGu.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125533);
                String trim = RegSetInfoUI.this.gGu.getText().toString().trim();
                if (trim == null || trim.length() <= 16) {
                    if (!RegSetInfoUI.this.gHL.doT()) {
                        RegSetInfoUI.this.gHL.stopTimer();
                    }
                    RegSetInfoUI.n(RegSetInfoUI.this);
                    if (!RegSetInfoUI.this.gHJ) {
                        RegSetInfoUI.this.gHm.setText(trim);
                    }
                    AppMethodBeat.o(125533);
                    return;
                }
                RegSetInfoUI.this.gGu.setText(trim.substring(0, 16));
                AppMethodBeat.o(125533);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125534);
                RegSetInfoUI.p(RegSetInfoUI.this);
                AppMethodBeat.o(125534);
            }
        });
        this.gHm.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(125535);
                if (z) {
                    RegSetInfoUI.this.gHJ = true;
                    RegSetInfoUI.this.gHL.ae(200, 200);
                }
                AppMethodBeat.o(125535);
            }
        });
        this.gHm.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125537);
                if (!RegSetInfoUI.this.gHL.doT()) {
                    RegSetInfoUI.this.gHL.stopTimer();
                }
                String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
                if (bo.isNullOrNil(trim)) {
                    RegSetInfoUI.this.gHt.setText(RegSetInfoUI.this.getString(R.string.dn5));
                    RegSetInfoUI.s(RegSetInfoUI.this);
                    if (RegSetInfoUI.this.gHH != null) {
                        RegSetInfoUI.this.gHH.dismiss();
                        RegSetInfoUI.this.gHH = null;
                    }
                    RegSetInfoUI.this.gHm.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(125536);
                            RegSetInfoUI.this.gHm.clearFocus();
                            RegSetInfoUI.this.gHm.requestFocus();
                            AppMethodBeat.o(125536);
                        }
                    }, 50);
                }
                if (!bo.isNullOrNil(trim) && (RegSetInfoUI.c(RegSetInfoUI.this) || !trim.equals(RegSetInfoUI.this.gHB))) {
                    RegSetInfoUI.s(RegSetInfoUI.this);
                    RegSetInfoUI.this.gHL.ae(500, 500);
                }
                RegSetInfoUI.this.gHB = trim;
                AppMethodBeat.o(125537);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125538);
                RegSetInfoUI.w(RegSetInfoUI.this);
                AppMethodBeat.o(125538);
                return true;
            }
        });
        this.gGu.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125539);
                if (i == 6 || i == 5) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    AppMethodBeat.o(125539);
                    return true;
                }
                AppMethodBeat.o(125539);
                return false;
            }
        });
        this.gGu.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125508);
                if (66 == i && keyEvent.getAction() == 0) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    AppMethodBeat.o(125508);
                    return true;
                }
                AppMethodBeat.o(125508);
                return false;
            }
        });
        this.gHm.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125509);
                if (i == 6 || i == 5) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    AppMethodBeat.o(125509);
                    return true;
                }
                AppMethodBeat.o(125509);
                return false;
            }
        });
        this.gHm.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125510);
                if (66 == i && keyEvent.getAction() == 0) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    AppMethodBeat.o(125510);
                    return true;
                }
                AppMethodBeat.o(125510);
                return false;
            }
        });
        this.gHw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125511);
                RegSetInfoUI.x(RegSetInfoUI.this);
                AppMethodBeat.o(125511);
            }
        });
        b bVar = new b(e.euY);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        arz();
        AppMethodBeat.o(125544);
    }

    private void arx() {
        m sVar;
        AppMethodBeat.i(125545);
        int arH = arH();
        g.Rg().a(126, (f) this);
        if (arB()) {
            int i;
            if (this.gHy == null || this.gHy.size() == 0) {
                i = 0;
            } else if (this.gHy.contains(this.gHK)) {
                i = 1;
            } else {
                i = 2;
            }
            sVar = new s("", this.gHr, this.bCu, this.gHq, this.gHp, this.gHo, "", "", this.elr, arH, this.gHK, "", "", this.gHv, this.gFM);
            ((v.a) sVar.ftU.acF()).vyI.wHX = i;
        } else {
            sVar = new s("", this.gHr, this.bCu, this.gHq, this.gHp, this.gHo, "", "", this.elr, arH, "", "", "", this.gHv, this.gFM);
        }
        sVar.ts(this.gDy);
        sVar.tt(this.gFm);
        sVar.lX(this.gEm);
        g.Rg().a(sVar, 0);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.dmm), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(125512);
                g.Rg().c(sVar);
                g.Rg().b(126, RegSetInfoUI.this);
                AppMethodBeat.o(125512);
            }
        });
        AppMethodBeat.o(125545);
    }

    private void o(boolean z, boolean z2) {
        boolean z3 = false;
        AppMethodBeat.i(125546);
        if (bo.isNullOrNil(this.gHm.getText().toString().trim())) {
            z = false;
        }
        this.gHz.setImageResource(z2 ? R.drawable.aon : R.drawable.aok);
        this.gHz.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.gHG = z3;
        AppMethodBeat.o(125546);
    }

    private boolean ary() {
        AppMethodBeat.i(125547);
        if (this.gHz.getVisibility() == 8 || this.gHG) {
            AppMethodBeat.o(125547);
            return true;
        }
        AppMethodBeat.o(125547);
        return false;
    }

    private void arz() {
        AppMethodBeat.i(125548);
        this.gHn.setEnabled(!bo.isNullOrNil(this.gGu.getText().toString().trim()));
        AppMethodBeat.o(125548);
    }

    private boolean arA() {
        return (this.gHx & 1) > 0;
    }

    private boolean arB() {
        return (this.gHx & 2) > 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(125549);
        ab.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null || i != 300) {
            Bitmap a = com.tencent.mm.plugin.account.a.a.gkF.a((Activity) this, i, i2, intent);
            if (a != null) {
                this.gHw.setImageBitmap(a);
                this.gFM = true;
                this.gHC.setVisibility(0);
            }
            AppMethodBeat.o(125549);
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("result_data");
        if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("birthdayComfirmOK")) {
            arx();
        }
        AppMethodBeat.o(125549);
    }

    public final int getLayoutId() {
        return R.layout.ao7;
    }

    private boolean arC() {
        return this.sceneType == 1;
    }

    private boolean arD() {
        return this.sceneType == 2;
    }

    private boolean arE() {
        return this.sceneType == 0;
    }

    private boolean arF() {
        return this.sceneType == 4;
    }

    private boolean arG() {
        return this.sceneType == 3;
    }

    private int arH() {
        AppMethodBeat.i(125550);
        if (arC()) {
            AppMethodBeat.o(125550);
            return 4;
        } else if (arD()) {
            AppMethodBeat.o(125550);
            return 2;
        } else if (arG()) {
            AppMethodBeat.o(125550);
            return 6;
        } else if (arF()) {
            AppMethodBeat.o(125550);
            return 1;
        } else {
            AppMethodBeat.o(125550);
            return 2;
        }
    }

    private String arI() {
        AppMethodBeat.i(125551);
        String str;
        if (arC() || arF()) {
            str = this.gHo;
            AppMethodBeat.o(125551);
            return str;
        } else if (arG()) {
            str = this.gHp;
            AppMethodBeat.o(125551);
            return str;
        } else {
            str = this.gHs;
            AppMethodBeat.o(125551);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        int ank;
        com.tencent.mm.h.a jY;
        final m mVar2;
        AppMethodBeat.i(125552);
        ab.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() == 126) {
            g.Rg().b(126, (f) this);
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i == 0 && i2 == 0) {
                String str2;
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 6;
                this.gBm.ajK();
                this.gHF = null;
                final String arI = arI();
                final String ajy = ((s) mVar).ajy();
                final int ajz = ((s) mVar).ajz();
                String str3 = null;
                String str4 = null;
                boolean z = false;
                Map z2 = br.z(((s) mVar).ajA(), "wording");
                if (z2 != null) {
                    String str5 = (String) z2.get(".wording.switch");
                    if (bo.isNullOrNil(str5)) {
                        z = true;
                    } else {
                        ank = bo.ank(str5);
                        if (ank == 0) {
                            z = false;
                        } else if (ank == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        str5 = (String) z2.get(".wording.title");
                        if (!bo.isNullOrNil(str5)) {
                            str3 = str5;
                        }
                        str5 = (String) z2.get(".wording.desc");
                        if (bo.isNullOrNil(str5)) {
                            str2 = str3;
                        } else {
                            str4 = str5;
                            str2 = str3;
                        }
                        ab.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                        com.tencent.mm.kernel.a.unhold();
                        com.tencent.mm.kernel.a.cm(true);
                        if (this.gFM) {
                            this.elr = ((s) mVar).ajw();
                            av.fly.ak("login_user_name", arI);
                            Intent bh;
                            if (ajy == null || !ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
                                bh.addFlags(67108864);
                                bh.putExtra("LauncherUI.enter_from_reg", true);
                                startActivity(bh);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.RN();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                                g.RN();
                                com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",4").toString());
                                finish();
                            } else {
                                com.tencent.mm.plugin.b.a.wA("R300_100_phone");
                                if (z) {
                                    bh = new Intent(this, FindMContactAlertUI.class);
                                    bh.putExtra("alert_title", str2);
                                    bh.putExtra("alert_message", str4);
                                } else {
                                    bh = new Intent(this, FindMContactIntroUI.class);
                                }
                                bh.addFlags(67108864);
                                bh.putExtra("regsetinfo_ticket", this.elr);
                                bh.putExtra("regsetinfo_NextStep", ajy);
                                bh.putExtra("regsetinfo_NextStyle", ajz);
                                Intent bh2 = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
                                bh2.addFlags(67108864);
                                bh2.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this, bh, bh2);
                                finish();
                            }
                        } else {
                            String str6 = e.euY + "temp.avatar";
                            str5 = e.euY + "temp.avatar.hd";
                            com.tencent.mm.vfs.e.aQ(str6, str5);
                            com.tencent.mm.vfs.e.deleteFile(str6);
                            com.tencent.mm.sdk.platformtools.d.c(str5, 96, 96, CompressFormat.JPEG, 90, str6);
                            final m mVar3 = mVar;
                            final String str7 = arI;
                            final String str8 = ajy;
                            final boolean z3 = z;
                            final m mVar4 = mVar;
                            final String str9 = str2;
                            final String str10 = str4;
                            final int i3 = ajz;
                            new com.tencent.mm.ah.m(this, e.euY + "temp.avatar").a(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(125513);
                                    RegSetInfoUI.this.elr = ((s) mVar3).ajw();
                                    av.fly.ak("login_user_name", str7);
                                    com.tencent.mm.vfs.e.deleteFile(e.euY + "temp.avatar");
                                    Intent bh;
                                    if (str8 == null || !str8.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        bh = com.tencent.mm.plugin.account.a.a.gkE.bh(RegSetInfoUI.this);
                                        bh.addFlags(67108864);
                                        RegSetInfoUI.this.startActivity(bh);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        g.RN();
                                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
                                        g.RN();
                                        com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",4").toString());
                                        RegSetInfoUI.this.finish();
                                        AppMethodBeat.o(125513);
                                        return;
                                    }
                                    com.tencent.mm.plugin.b.a.wA("R300_100_phone");
                                    if (z3) {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                                        bh.putExtra("alert_title", str2);
                                        bh.putExtra("alert_message", str4);
                                    } else {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
                                    }
                                    bh.addFlags(67108864);
                                    bh.putExtra("regsetinfo_ticket", RegSetInfoUI.this.elr);
                                    bh.putExtra("regsetinfo_NextStep", str8);
                                    bh.putExtra("regsetinfo_NextStyle", ajz);
                                    Intent bh2 = com.tencent.mm.plugin.account.a.a.gkE.bh(RegSetInfoUI.this);
                                    bh2.addFlags(67108864);
                                    MMWizardActivity.b(RegSetInfoUI.this, bh, bh2);
                                    RegSetInfoUI.this.finish();
                                    AppMethodBeat.o(125513);
                                }
                            }, new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(125514);
                                    RegSetInfoUI.this.elr = ((s) mVar4).ajw();
                                    av.fly.ak("login_user_name", arI);
                                    Intent bh;
                                    if (ajy == null || !ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        bh = com.tencent.mm.plugin.account.a.a.gkE.bh(RegSetInfoUI.this);
                                        bh.addFlags(67108864);
                                        RegSetInfoUI.this.startActivity(bh);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        g.RN();
                                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
                                        g.RN();
                                        com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",4").toString());
                                        RegSetInfoUI.this.finish();
                                        AppMethodBeat.o(125514);
                                        return;
                                    }
                                    com.tencent.mm.plugin.b.a.wA("R300_100_phone");
                                    if (z) {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                                        bh.putExtra("alert_title", str9);
                                        bh.putExtra("alert_message", str10);
                                    } else {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
                                    }
                                    bh.addFlags(67108864);
                                    bh.putExtra("regsetinfo_ticket", RegSetInfoUI.this.elr);
                                    bh.putExtra("regsetinfo_NextStep", ajy);
                                    bh.putExtra("regsetinfo_NextStyle", i3);
                                    Intent bh2 = com.tencent.mm.plugin.account.a.a.gkE.bh(RegSetInfoUI.this);
                                    bh2.addFlags(67108864);
                                    MMWizardActivity.b(RegSetInfoUI.this, bh, bh2);
                                    RegSetInfoUI.this.finish();
                                    AppMethodBeat.o(125514);
                                }
                            });
                        }
                    }
                }
                str2 = null;
                ab.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.kernel.a.cm(true);
                if (this.gFM) {
                }
            }
            if (i2 != -6 && i2 != -311 && i2 != -310) {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this, null, null);
                    AppMethodBeat.o(125552);
                    return;
                } else if (j(i, i2, str)) {
                    AppMethodBeat.o(125552);
                    return;
                }
            } else if (this.gue == null) {
                mVar2 = mVar;
                mVar2 = mVar;
                this.gue = SecurityImage.a.a(this.mController.ylL, 0, ((s) mVar).ajo(), ((s) mVar).ajn(), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125516);
                        String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.gGu.getText().toString().trim();
                        if (trim2 == null || trim2.length() <= 0) {
                            h.g(RegSetInfoUI.this, R.string.f0j, R.string.dln);
                            AppMethodBeat.o(125516);
                            return;
                        }
                        int e = RegSetInfoUI.e(RegSetInfoUI.this);
                        g.Rg().a(126, RegSetInfoUI.this);
                        final m sVar = new s("", RegSetInfoUI.this.gHr, trim2, RegSetInfoUI.this.gHq, RegSetInfoUI.this.gHp, RegSetInfoUI.this.gHo, "", "", RegSetInfoUI.this.elr, e, trim, ((s) mVar2).ajn(), RegSetInfoUI.this.gue.getSecImgCode(), RegSetInfoUI.this.gHv, RegSetInfoUI.this.gFM);
                        sVar.ts(RegSetInfoUI.this.gDy);
                        sVar.tt(RegSetInfoUI.this.gFm);
                        sVar.lX(RegSetInfoUI.this.gEm);
                        g.Rg().a(sVar, 0);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        Context context = RegSetInfoUI.this;
                        RegSetInfoUI.this.getString(R.string.tz);
                        regSetInfoUI.ehJ = h.b(context, RegSetInfoUI.this.getString(R.string.dmm), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(125515);
                                g.Rg().c(sVar);
                                g.Rg().b(126, RegSetInfoUI.this);
                                AppMethodBeat.o(125515);
                            }
                        });
                        AppMethodBeat.o(125516);
                    }
                }, null, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125517);
                        RegSetInfoUI.this.gue = null;
                        AppMethodBeat.o(125517);
                    }
                }, new SecurityImage.b() {
                    public final void apw() {
                        AppMethodBeat.i(125519);
                        RegSetInfoUI.this.aqX();
                        String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.gGu.getText().toString().trim();
                        int e = RegSetInfoUI.e(RegSetInfoUI.this);
                        g.Rg().a(126, RegSetInfoUI.this);
                        m sVar = new s("", RegSetInfoUI.this.gHr, trim2, RegSetInfoUI.this.gHq, RegSetInfoUI.this.gHp, RegSetInfoUI.this.gHo, "", "", RegSetInfoUI.this.elr, e, trim, ((s) mVar2).ajn(), "", RegSetInfoUI.this.gHv, RegSetInfoUI.this.gFM);
                        sVar.ts(RegSetInfoUI.this.gDy);
                        sVar.tt(RegSetInfoUI.this.gFm);
                        sVar.lX(RegSetInfoUI.this.gEm);
                        g.Rg().a(sVar, 0);
                        AppMethodBeat.o(125519);
                    }
                });
                AppMethodBeat.o(125552);
                return;
            } else {
                this.gue.b(0, ((s) mVar).ajo(), ((s) mVar).ajn(), "");
                AppMethodBeat.o(125552);
                return;
            }
        }
        if (mVar.getType() == v2helper.EMethodSetIosMicAbCheckOff) {
            g.Rg().b((int) v2helper.EMethodSetIosMicAbCheckOff, (f) this);
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            this.gHA.setVisibility(8);
            if (i == 0 && i2 == 0) {
                this.gHF = null;
                ank = ((t.b) ((ad) mVar).ftU.ZS()).gvJ.wsP;
                ab.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", Integer.valueOf(ank));
                if (ank == -14 || ank == -10 || ank == -7) {
                    LinkedList linkedList = ((t.b) ((ad) mVar).ftU.ZS()).gvJ.jBw;
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        this.gHt.setText(jY.desc);
                    }
                    this.gHy.clear();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size() > 3 ? 3 : linkedList.size();
                        final String[] strArr = new String[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            strArr[i4] = ((bts) linkedList.get(i4)).wVI;
                            this.gHy.add(strArr[i4]);
                        }
                        if (this.gHJ) {
                            if (this.gHH != null) {
                                this.gHH.dismiss();
                                this.gHH = null;
                            }
                            this.gHH = p.a(this, this.gHI, strArr, new OnItemClickListener() {
                                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                    AppMethodBeat.i(125526);
                                    if (RegSetInfoUI.this.gHH != null) {
                                        RegSetInfoUI.this.gHH.dismiss();
                                        RegSetInfoUI.this.gHH = null;
                                    }
                                    RegSetInfoUI.this.gHm.setText(strArr[i]);
                                    RegSetInfoUI.this.gHm.postDelayed(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(125525);
                                            RegSetInfoUI.this.gHm.clearFocus();
                                            RegSetInfoUI.this.gHm.requestFocus();
                                            AppMethodBeat.o(125525);
                                        }
                                    }, 50);
                                    RegSetInfoUI.this.gHt.setText(RegSetInfoUI.this.getString(R.string.dn5));
                                    AppMethodBeat.o(125526);
                                }
                            });
                        }
                    }
                    o(true, true);
                    AppMethodBeat.o(125552);
                    return;
                } else if (bo.isNullOrNil(this.gHm.getText().toString().trim())) {
                    o(false, false);
                    AppMethodBeat.o(125552);
                    return;
                } else {
                    o(true, false);
                    this.gHt.setText(getString(R.string.dn5));
                    if (this.gHH != null) {
                        this.gHH.dismiss();
                        this.gHH = null;
                    }
                    this.gHm.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(125520);
                            RegSetInfoUI.this.gHm.clearFocus();
                            RegSetInfoUI.this.gHm.requestFocus();
                            AppMethodBeat.o(125520);
                        }
                    }, 50);
                    AppMethodBeat.o(125552);
                    return;
                }
            } else if (i2 != -6 && i2 != -311 && i2 != -310) {
                o(true, true);
            } else if (this.gue == null) {
                mVar2 = mVar;
                mVar2 = mVar;
                this.gue = SecurityImage.a.a(this.mController.ylL, 0, ((ad) mVar).ajo(), ((ad) mVar).ajn(), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125522);
                        String trim = RegSetInfoUI.this.gGu.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.gHm.getText().toString().trim();
                        if (trim == null || trim.length() <= 0) {
                            h.g(RegSetInfoUI.this, R.string.f0j, R.string.dln);
                            AppMethodBeat.o(125522);
                            return;
                        }
                        RegSetInfoUI.this.aqX();
                        int e = RegSetInfoUI.e(RegSetInfoUI.this);
                        String f = RegSetInfoUI.f(RegSetInfoUI.this);
                        g.Rg().a((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                        final m adVar = new ad(f, RegSetInfoUI.this.elr, e, trim, trim2, ((ad) mVar2).ajn(), RegSetInfoUI.this.gue.getSecImgCode());
                        g.Rg().a(adVar, 0);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        Context context = RegSetInfoUI.this;
                        RegSetInfoUI.this.getString(R.string.tz);
                        regSetInfoUI.ehJ = h.b(context, RegSetInfoUI.this.getString(R.string.dmm), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(125521);
                                g.Rg().c(adVar);
                                g.Rg().b((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                                AppMethodBeat.o(125521);
                            }
                        });
                        AppMethodBeat.o(125522);
                    }
                }, null, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125523);
                        RegSetInfoUI.this.gue = null;
                        AppMethodBeat.o(125523);
                    }
                }, new SecurityImage.b() {
                    public final void apw() {
                        AppMethodBeat.i(125524);
                        RegSetInfoUI.this.aqX();
                        int e = RegSetInfoUI.e(RegSetInfoUI.this);
                        String f = RegSetInfoUI.f(RegSetInfoUI.this);
                        g.Rg().a((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                        g.Rg().a(new ad(f, RegSetInfoUI.this.elr, e, "", "", ((ad) mVar2).ajn(), ""), 0);
                        AppMethodBeat.o(125524);
                    }
                });
                AppMethodBeat.o(125552);
                return;
            } else {
                this.gue.b(0, ((ad) mVar).ajo(), ((ad) mVar).ajn(), "");
                AppMethodBeat.o(125552);
                return;
            }
        }
        if (j(i, i2, str)) {
            AppMethodBeat.o(125552);
        } else if (i == 8) {
            this.gHF = getString(R.string.bx8, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            Toast.makeText(this, this.gHF, 0).show();
            AppMethodBeat.o(125552);
        } else {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, getString(R.string.byf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.o(125552);
        }
    }

    private boolean j(int i, int i2, String str) {
        AppMethodBeat.i(125553);
        if (this.gCd.a(this, new ag(i, i2, str))) {
            AppMethodBeat.o(125553);
            return true;
        } else if (com.tencent.mm.plugin.account.a.a.gkF.a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(125553);
            return true;
        } else {
            switch (i2) {
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    String an;
                    com.tencent.mm.kernel.a.hold();
                    Context context = this.mController.ylL;
                    g.RN();
                    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QH())) {
                        an = com.tencent.mm.bz.a.an(this.mController.ylL, R.string.cvw);
                    } else {
                        g.RN();
                        an = com.tencent.mm.kernel.a.QH();
                    }
                    h.a(context, an, this.mController.ylL.getString(R.string.tz), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(125553);
                    return true;
                case -75:
                    h.g(this, R.string.fn, R.string.djw);
                    AppMethodBeat.o(125553);
                    return true;
                case -48:
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, null, null);
                    } else {
                        h.b((Context) this, getString(R.string.dn4), "", true);
                    }
                    AppMethodBeat.o(125553);
                    return true;
                case -10:
                case -7:
                    h.g(this, R.string.djv, R.string.djw);
                    AppMethodBeat.o(125553);
                    return true;
                default:
                    AppMethodBeat.o(125553);
                    return false;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125554);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.o(125554);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125554);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(125555);
        aqX();
        if (arC()) {
            h.a((Context) this, getString(R.string.dmy), "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent;
                    AppMethodBeat.i(125527);
                    if (RegSetInfoUI.this.gEs == 2) {
                        intent = new Intent(RegSetInfoUI.this, MobileInputUI.class);
                        intent.putExtra("mobile_input_purpose", 2);
                    } else {
                        intent = new Intent(RegSetInfoUI.this, RegByMobileRegAIOUI.class);
                    }
                    intent.addFlags(67108864);
                    RegSetInfoUI.this.startActivity(intent);
                    RegSetInfoUI.this.finish();
                    AppMethodBeat.o(125527);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(125555);
            return;
        }
        if (!arD()) {
            if (arE()) {
                h.a((Context) this, getString(R.string.dmx), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125531);
                        com.tencent.mm.plugin.b.a.wA("R400_100_signup");
                        Intent intent = new Intent(RegSetInfoUI.this, LoginUI.class);
                        intent.addFlags(67108864);
                        RegSetInfoUI.this.startActivity(intent);
                        RegSetInfoUI.this.finish();
                        AppMethodBeat.o(125531);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(125555);
                return;
            } else if (arG()) {
                h.a((Context) this, getString(R.string.dmx), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125532);
                        com.tencent.mm.plugin.b.a.wA("R500_100");
                        Intent intent = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
                        intent.addFlags(67108864);
                        RegSetInfoUI.this.startActivity(intent);
                        RegSetInfoUI.this.finish();
                        AppMethodBeat.o(125532);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(125555);
                return;
            } else {
                com.tencent.mm.plugin.b.a.wA("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
        AppMethodBeat.o(125555);
    }

    static /* synthetic */ void p(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125561);
        regSetInfoUI.bCu = regSetInfoUI.gGu.getText().toString().trim();
        regSetInfoUI.gHK = regSetInfoUI.gHm.getText().toString().trim();
        String charSequence;
        if (bo.isNullOrNil(regSetInfoUI.bCu)) {
            h.g(regSetInfoUI, R.string.f0j, R.string.dln);
            AppMethodBeat.o(125561);
        } else if (regSetInfoUI.gHA.getVisibility() == 0) {
            regSetInfoUI.getString(R.string.tz);
            regSetInfoUI.ehJ = h.b((Context) regSetInfoUI, regSetInfoUI.getString(R.string.dmm), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            AppMethodBeat.o(125561);
        } else if (regSetInfoUI.ary() && regSetInfoUI.arB() && !bo.isNullOrNil(regSetInfoUI.gHK)) {
            charSequence = regSetInfoUI.gHt.getText().toString();
            if (bo.isNullOrNil(charSequence) || charSequence.equals(regSetInfoUI.getString(R.string.dn5))) {
                if (bo.isNullOrNil(regSetInfoUI.gHF)) {
                    charSequence = regSetInfoUI.getString(R.string.dn8);
                } else {
                    charSequence = regSetInfoUI.gHF;
                }
            }
            h.b((Context) regSetInfoUI, charSequence, "", true);
            AppMethodBeat.o(125561);
        } else {
            boolean z;
            regSetInfoUI.aqX();
            charSequence = com.tencent.mm.sdk.platformtools.av.Ps(regSetInfoUI.gHo);
            ab.i("MiroMsg.RegSetInfoUI", "countryCode %s", charSequence);
            if (bo.isNullOrNil(charSequence) || !com.tencent.mm.au.b.sP(charSequence)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (bo.Q(regSetInfoUI.gHo, regSetInfoUI.gDy)) {
                    Intent intent = new Intent(regSetInfoUI, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 2);
                    intent.addFlags(67108864);
                    regSetInfoUI.startActivity(intent);
                    regSetInfoUI.finish();
                    AppMethodBeat.o(125561);
                    return;
                }
                com.tencent.mm.plugin.account.a.b.a.b(regSetInfoUI, regSetInfoUI.getString(R.string.g7m, new Object[]{regSetInfoUI.gHo, regSetInfoUI.gDy, aa.dor()}), 300, false);
                AppMethodBeat.o(125561);
                return;
            }
            regSetInfoUI.arx();
            AppMethodBeat.o(125561);
        }
    }

    static /* synthetic */ boolean x(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(125564);
        boolean o = com.tencent.mm.plugin.account.a.a.gkF.o(regSetInfoUI);
        AppMethodBeat.o(125564);
        return o;
    }
}
