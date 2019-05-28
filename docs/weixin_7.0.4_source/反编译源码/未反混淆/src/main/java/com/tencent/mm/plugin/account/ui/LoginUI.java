package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class LoginUI extends MMActivity implements f {
    private TextWatcher arx = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(125026);
            LoginUI.a(LoginUI.this);
            AppMethodBeat.o(125026);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String cOG = "";
    private String cxb = null;
    private ProgressDialog ehJ = null;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(125038);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(125038);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(125039);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(125039);
                return false;
            }
            ab.i("MicroMsg.LoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(125039);
            return true;
        }
    };
    protected Button gBP;
    protected Button gBQ;
    private View gBR;
    protected Button gBS;
    private f gBT = new f();
    private String gBV;
    private String gBW;
    private MMClearEditText gCS;
    private MMClearEditText gCT;
    private MMFormInputView gCU;
    private MMFormInputView gCV;
    private Button gCW;
    private Button gCX;
    protected View gCY;
    private String gCZ;
    private ResizeLayout gCa;
    private com.tencent.mm.platformtools.c gCd;
    private Button gCj;
    private boolean gDa;
    private MMKeyboardUperView gDb;
    private boolean gDc = false;
    private final int gDd = 128;
    private String gsF;
    private SecurityImage gue = null;
    private String gzO;
    private int sceneType = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginUI() {
        AppMethodBeat.i(125052);
        AppMethodBeat.o(125052);
    }

    static /* synthetic */ void S(Context context, String str) {
        AppMethodBeat.i(125068);
        R(context, str);
        AppMethodBeat.o(125068);
    }

    static /* synthetic */ void d(LoginUI loginUI) {
        AppMethodBeat.i(125070);
        loginUI.goBack();
        AppMethodBeat.o(125070);
    }

    static /* synthetic */ void e(LoginUI loginUI) {
        AppMethodBeat.i(125071);
        loginUI.aqU();
        AppMethodBeat.o(125071);
    }

    public final int getLayoutId() {
        return R.layout.a_a;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125053);
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(this.mController.ylL.getResources().getColor(R.color.vz));
        String str = "";
        if (d.vxr) {
            str = getString(R.string.ru) + getString(R.string.fk);
        }
        this.sceneType = getIntent().getIntExtra("login_type", 0);
        setMMTitle(str);
        xE(getResources().getColor(R.color.vy));
        dyb();
        a.gkF.BV();
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        this.gCd = new com.tencent.mm.platformtools.c();
        this.gDa = getIntent().getBooleanExtra("from_switch_account", false);
        this.gCZ = av.fly.T("login_weixin_username", "");
        if (getIntent().getIntArrayExtra("kv_report_login_method_data") != null) {
            h.pYm.e(14262, Integer.valueOf(r0[0]), Integer.valueOf(r0[1]), Integer.valueOf(r0[2]), Integer.valueOf(r0[3]), Integer.valueOf(r0[4]));
        }
        AppMethodBeat.o(125053);
    }

    public void onResume() {
        AppMethodBeat.i(125054);
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder;
        if (this.sceneType == 0) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L100_100_logout")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("L100_100_logout");
            AppMethodBeat.o(125054);
            return;
        }
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L400_100_login,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L400_100_login")).append(",1").toString());
            com.tencent.mm.plugin.b.a.wz("L400_100_login");
        }
        AppMethodBeat.o(125054);
    }

    public void onPause() {
        AppMethodBeat.i(125055);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        StringBuilder stringBuilder;
        if (this.sceneType == 0) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("L100_100_logout")).append(",2").toString());
            AppMethodBeat.o(125055);
            return;
        }
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            g.RN();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L400_100_login,");
            g.RN();
            com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("L400_100_login")).append(",2").toString());
        }
        AppMethodBeat.o(125055);
    }

    public void onDestroy() {
        AppMethodBeat.i(125056);
        if (this.gCd != null) {
            this.gCd.close();
        }
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        super.onDestroy();
        AppMethodBeat.o(125056);
    }

    public final void initView() {
        AppMethodBeat.i(125057);
        this.gCU = (MMFormInputView) findViewById(R.id.cq_);
        this.gCV = (MMFormInputView) findViewById(R.id.cqa);
        this.gCS = (MMClearEditText) this.gCU.getContentEditText();
        this.gCT = (MMClearEditText) this.gCV.getContentEditText();
        com.tencent.mm.ui.tools.b.c.d(this.gCT).PM(16).a(null);
        this.gCW = (Button) findViewById(R.id.cqc);
        this.gCW.setEnabled(false);
        this.gCX = (Button) findViewById(R.id.cqb);
        this.gCj = (Button) findViewById(R.id.cqd);
        this.gCY = findViewById(R.id.cqe);
        this.gCY.setVisibility(0);
        this.gBP = (Button) findViewById(R.id.cqf);
        this.gBR = findViewById(R.id.cqg);
        this.gBQ = (Button) findViewById(R.id.cqh);
        this.gBS = (Button) findViewById(R.id.cqi);
        this.gCa = (ResizeLayout) findViewById(R.id.cq9);
        this.gDb = (MMKeyboardUperView) findViewById(R.id.jh);
        this.gCa.setOnSizeChanged(new ResizeLayout.a() {
            public final void aqZ() {
                AppMethodBeat.i(125046);
                LoginUI.b(LoginUI.this);
                AppMethodBeat.o(125046);
            }
        });
        this.gBP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125047);
                LoginUI.S(LoginUI.this, LoginUI.this.getString(R.string.g7t) + aa.dor());
                AppMethodBeat.o(125047);
            }
        });
        this.gBQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125048);
                LoginUI.S(LoginUI.this, LoginUI.this.getString(R.string.g7k, new Object[]{aa.dor()}));
                AppMethodBeat.o(125048);
            }
        });
        final com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(this, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(125049);
                if (lVar.dzR()) {
                    lVar.hi(ReaderCallback.HIDDEN_BAR, R.string.g0m);
                    lVar.hi(ReaderCallback.SHOW_BAR, R.string.g0k);
                }
                AppMethodBeat.o(125049);
            }
        };
        dVar.zQf = new com.tencent.mm.ui.widget.a.d.a() {
            public final void onDismiss() {
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(125050);
                switch (menuItem.getItemId()) {
                    case ReaderCallback.HIDDEN_BAR /*5001*/:
                        LoginUI.c(LoginUI.this);
                        AppMethodBeat.o(125050);
                        return;
                    case ReaderCallback.SHOW_BAR /*5002*/:
                        LoginUI.S(LoginUI.this, LoginUI.this.getString(R.string.gb3) + aa.dor());
                        break;
                }
                AppMethodBeat.o(125050);
            }
        };
        if (aa.doo()) {
            this.gBS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125051);
                    LoginUI.c(LoginUI.this);
                    AppMethodBeat.o(125051);
                }
            });
        } else {
            this.gBR.setVisibility(8);
            this.gBS.setText(R.string.co6);
            this.gBS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125027);
                    dVar.cpD();
                    AppMethodBeat.o(125027);
                }
            });
        }
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125028);
                LoginUI.d(LoginUI.this);
                AppMethodBeat.o(125028);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        this.gCW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125029);
                LoginUI.e(LoginUI.this);
                AppMethodBeat.o(125029);
            }
        });
        this.gCX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125030);
                Intent intent = new Intent(LoginUI.this, MobileInputUI.class);
                int[] iArr = new int[5];
                iArr[0] = 2;
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("kv_report_login_method_data", iArr);
                intent.putExtra("from_switch_account", LoginUI.this.gDa);
                LoginUI.this.startActivity(intent);
                LoginUI.this.finish();
                AppMethodBeat.o(125030);
            }
        });
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!bo.isNullOrNil(this.gzO)) {
            this.gCS.setText(bo.nullAsNil(f.ara()));
            this.gCT.setText(bo.nullAsNil(f.arb()));
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125031);
                    LoginUI.e(LoginUI.this);
                    AppMethodBeat.o(125031);
                }
            }, 500);
        }
        this.gCS.addTextChangedListener(this.arx);
        this.gCT.addTextChangedListener(this.arx);
        this.gCT.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125032);
                if (i == 6 || i == 5) {
                    LoginUI.e(LoginUI.this);
                    AppMethodBeat.o(125032);
                    return true;
                }
                AppMethodBeat.o(125032);
                return false;
            }
        });
        this.gCT.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125033);
                if (66 == i && keyEvent.getAction() == 0) {
                    LoginUI.e(LoginUI.this);
                    AppMethodBeat.o(125033);
                    return true;
                }
                AppMethodBeat.o(125033);
                return false;
            }
        });
        if (com.tencent.mm.sdk.platformtools.g.xyf) {
            a.gkF.p(this);
        }
        String stringExtra = getIntent().getStringExtra("login_username");
        this.gDc = getIntent().getBooleanExtra("from_deep_link", false);
        if (!bo.isNullOrNil(stringExtra)) {
            this.gCS.setText(stringExtra);
        }
        if (com.tencent.mm.sdk.platformtools.f.EX_DEVICE_LOGIN) {
            this.gCj.setVisibility(0);
            this.gCj.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125034);
                    com.tencent.mm.bp.d.H(LoginUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
                    LoginUI.this.overridePendingTransition(R.anim.cd, R.anim.s);
                    AppMethodBeat.o(125034);
                }
            });
        }
        AppMethodBeat.o(125057);
    }

    private static void R(Context context, String str) {
        AppMethodBeat.i(125058);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        com.tencent.mm.bp.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(125058);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125059);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(125059);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125059);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(125060);
        aqX();
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        p.dhH();
        finish();
        AppMethodBeat.o(125060);
    }

    private boolean j(int i, int i2, String str) {
        AppMethodBeat.i(125061);
        if (a.gkF.a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(125061);
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    g.Rg().a(701, (f) this);
                    g.Rg().a(252, (f) this);
                    if (this.gue == null) {
                        this.gue = SecurityImage.a.a(this, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125037);
                                if (LoginUI.this.gue == null) {
                                    ab.e("MicroMsg.LoginUI", "secimg is null!");
                                    AppMethodBeat.o(125037);
                                    return;
                                }
                                ab.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.this.gBT.guh + " img len" + LoginUI.this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                                final m qVar = new q(LoginUI.this.gBT.account, LoginUI.this.gBT.guf, LoginUI.this.gBT.gCL, LoginUI.this.gue.getSecImgCode(), LoginUI.this.gue.getSecImgSid(), LoginUI.this.gue.getSecImgEncryptKey(), 2, "", false, false);
                                g.Rg().a(qVar, 0);
                                LoginUI loginUI = LoginUI.this;
                                Context context = LoginUI.this;
                                LoginUI.this.getString(R.string.tz);
                                loginUI.ehJ = com.tencent.mm.ui.base.h.b(context, LoginUI.this.getString(R.string.cou), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(125036);
                                        g.Rg().c(qVar);
                                        g.Rg().b(701, LoginUI.this);
                                        g.Rg().b(252, LoginUI.this);
                                        AppMethodBeat.o(125036);
                                    }
                                });
                                AppMethodBeat.o(125037);
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(125040);
                                LoginUI.this.gue = null;
                                AppMethodBeat.o(125040);
                            }
                        }, this.gBT);
                    } else {
                        ab.d("MicroMsg.LoginUI", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                        this.gue.b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                    }
                    AppMethodBeat.o(125061);
                    return true;
                case -205:
                    ab.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bo.anv(this.gzO), this.gBW);
                    f.a(this.gBT);
                    com.tencent.mm.plugin.b.a.wA("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.gzO);
                    intent.putExtra("binded_mobile", this.gBV);
                    intent.putExtra("close_safe_device_style", this.gBW);
                    intent.putExtra("from_source", 1);
                    a.gkE.g((Context) this, intent);
                    AppMethodBeat.o(125061);
                    return true;
                case -140:
                    if (!bo.isNullOrNil(this.cOG)) {
                        z.o(this, str, this.cOG);
                    }
                    AppMethodBeat.o(125061);
                    return true;
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
                    com.tencent.mm.ui.base.h.a(context, an, this.mController.ylL.getString(R.string.tz), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125041);
                            LoginUI.k(LoginUI.this);
                            AppMethodBeat.o(125041);
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125042);
                            LoginUI.k(LoginUI.this);
                            AppMethodBeat.o(125042);
                        }
                    });
                    AppMethodBeat.o(125061);
                    return true;
                case -75:
                    z.cu(this.mController.ylL);
                    AppMethodBeat.o(125061);
                    return true;
                case -72:
                    com.tencent.mm.ui.base.h.g(this.mController.ylL, R.string.dmb, R.string.tz);
                    AppMethodBeat.o(125061);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.h.g(this, R.string.cof, R.string.cog);
                    AppMethodBeat.o(125061);
                    return true;
                case -3:
                    com.tencent.mm.ui.base.h.g(this, R.string.be9, R.string.cog);
                    AppMethodBeat.o(125061);
                    return true;
                case -1:
                    if (g.Rg().acS() == 5) {
                        com.tencent.mm.ui.base.h.g(this, R.string.d5n, R.string.d5m);
                        AppMethodBeat.o(125061);
                        return true;
                    }
                    AppMethodBeat.o(125061);
                    return false;
            }
        }
        boolean a = this.gCd.a(this, new ag(i, i2, str));
        AppMethodBeat.o(125061);
        return a;
    }

    public void onSceneEnd(int i, int i2, String str, final m mVar) {
        AppMethodBeat.i(125062);
        ab.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar.getType() == 252 || mVar.getType() == 701) {
            int i3;
            g.Rg().b(252, (f) this);
            g.Rg().b(701, (f) this);
            this.cOG = ((q) mVar).ajm();
            this.gBT.guh = ((q) mVar).ajn();
            this.gBT.gug = ((q) mVar).ajo();
            this.gBT.gui = ((q) mVar).ajp();
            this.gBT.gCL = ((q) mVar).getSecCodeType();
            this.gBT.account = ((q) mVar).account;
            if (i2 == -205) {
                this.gzO = ((q) mVar).agh();
                this.gBV = ((q) mVar).ajq();
                this.gBW = ((q) mVar).ajt();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                g.Rg().a(new bk(new bk.a() {
                    public final void a(e eVar) {
                        AppMethodBeat.i(125043);
                        if (eVar == null) {
                            AppMethodBeat.o(125043);
                            return;
                        }
                        com.tencent.mm.network.c adg = eVar.adg();
                        byte[] bArr = new byte[0];
                        byte[] bArr2 = new byte[0];
                        byte[] bArr3 = new byte[0];
                        g.RN();
                        adg.a(bArr, bArr2, bArr3, com.tencent.mm.kernel.a.QF());
                        AppMethodBeat.o(125043);
                    }
                }), 0);
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0 || (i == 0 && i2 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.plugin.account.friend.a.l.apX();
                z.vx(this.gBT.account);
                String T = av.fly.T("login_weixin_username", "");
                w.cm(this);
                if (this.gDa) {
                    bx.fnB.an(this.gCZ, T);
                    bx.fnB.g(r.Yz(), r.Zg());
                    h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(9), bx.fnB.aau());
                }
                z.showAddrBookUploadConfirm(this, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(125044);
                        ab.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
                        Intent bh = a.gkE.bh(LoginUI.this);
                        bh.addFlags(67108864);
                        bh.putExtra("kstyle_show_bind_mobile_afterauth", ((q) mVar).ajr());
                        bh.putExtra("kstyle_bind_wording", ((q) mVar).ajs());
                        bh.putExtra("kstyle_bind_recommend_show", ((q) mVar).aju());
                        LoginUI.this.startActivity(bh);
                        LoginUI.this.finish();
                        AppMethodBeat.o(125044);
                    }
                }, false, 2);
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                g.RN();
                com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",4").toString());
                if (this.gDc) {
                    T = ah.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.h.Mu()).getString("randomID", "");
                    h.pYm.e(11930, T, Integer.valueOf(4));
                }
                AppMethodBeat.o(125062);
                return;
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                z.f(this, str, 32644);
                AppMethodBeat.o(125062);
                return;
            } else if (i2 == -217) {
                z.a(this, com.tencent.mm.platformtools.e.a((q) mVar), i2);
                AppMethodBeat.o(125062);
                return;
            } else if (j(i, i2, str)) {
                AppMethodBeat.o(125062);
                return;
            } else if (i2 == -5) {
                Toast.makeText(this, getString(R.string.cp3), 0).show();
                AppMethodBeat.o(125062);
                return;
            } else {
                com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                if (jY == null || !jY.a(this, null, null)) {
                    Toast.makeText(this, getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.o(125062);
                    return;
                }
                AppMethodBeat.o(125062);
                return;
            }
        }
        AppMethodBeat.o(125062);
    }

    private void aqU() {
        AppMethodBeat.i(125063);
        this.gBT.account = this.gCS.getText().toString().trim();
        this.gBT.guf = this.gCT.getText().toString();
        if (this.gBT.account.equals("")) {
            com.tencent.mm.ui.base.h.g(this, R.string.f0w, R.string.cog);
            AppMethodBeat.o(125063);
        } else if (this.gBT.guf.equals("")) {
            com.tencent.mm.ui.base.h.g(this, R.string.f0s, R.string.cog);
            AppMethodBeat.o(125063);
        } else {
            aqX();
            g.Rg().a(252, (f) this);
            g.Rg().a(701, (f) this);
            final m qVar = new q(this.gBT.account, this.gBT.guf, this.gzO, 2);
            g.Rg().a(qVar, 0);
            getString(R.string.tz);
            this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125045);
                    g.Rg().c(qVar);
                    g.Rg().b(252, LoginUI.this);
                    g.Rg().b(701, LoginUI.this);
                    AppMethodBeat.o(125045);
                }
            });
            AppMethodBeat.o(125063);
        }
    }

    public void finish() {
        AppMethodBeat.i(125064);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(125064);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(125065);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.d(str, str2, objArr);
        if (i2 == -1) {
            if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                str2 = "MicroMsg.LoginUI";
                String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                Object[] objArr2 = new Object[3];
                objArr2[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
                if (!bo.isNullOrNil(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr2[1] = Integer.valueOf(i3);
                objArr2[2] = Integer.valueOf(intExtra);
                ab.d(str2, str3, objArr2);
                if (intExtra == -217) {
                    this.gBT.guf = stringExtra;
                    aqU();
                    AppMethodBeat.o(125065);
                    return;
                }
                AppMethodBeat.o(125065);
                return;
            } else if (i == 32644 && intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                    aqU();
                }
            }
        }
        AppMethodBeat.o(125065);
    }

    static /* synthetic */ void a(LoginUI loginUI) {
        AppMethodBeat.i(125066);
        if (bo.isNullOrNil(loginUI.gCS.getText().toString()) || bo.isNullOrNil(loginUI.gCT.getText().toString())) {
            loginUI.gCW.setEnabled(false);
            AppMethodBeat.o(125066);
            return;
        }
        loginUI.gCW.setEnabled(true);
        AppMethodBeat.o(125066);
    }

    static /* synthetic */ void b(LoginUI loginUI) {
        AppMethodBeat.i(125067);
        View currentFocus = loginUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - loginUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                loginUI.gDb.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(125035);
                        LoginUI.this.gDb.smoothScrollBy(0, height);
                        AppMethodBeat.o(125035);
                    }
                });
            }
        }
        AppMethodBeat.o(125067);
    }

    static /* synthetic */ void c(LoginUI loginUI) {
        AppMethodBeat.i(125069);
        R(loginUI, loginUI.getString(R.string.g0n) + aa.dor());
        AppMethodBeat.o(125069);
    }

    static /* synthetic */ void k(LoginUI loginUI) {
        AppMethodBeat.i(125072);
        g.RQ().lL("");
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        a.gkE.p(intent, loginUI);
        AppMethodBeat.o(125072);
    }
}
