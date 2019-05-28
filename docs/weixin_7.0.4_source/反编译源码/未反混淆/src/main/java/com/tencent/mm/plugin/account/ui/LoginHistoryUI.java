package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bx;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;

@a(19)
public class LoginHistoryUI extends MMActivity implements f {
    private String cOG = "";
    protected ProgressDialog ehJ = null;
    private SharedPreferences ehZ;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(124913);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(124913);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(124914);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(124914);
                return false;
            }
            ab.i("MicroMsg.LoginHistoryUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(124914);
            return true;
        }
    };
    protected TextView gBI;
    protected EditText gBJ;
    protected Button gBK;
    protected Button gBL;
    protected View gBM;
    protected View gBN;
    protected View gBO;
    protected Button gBP;
    protected Button gBQ;
    private View gBR;
    protected Button gBS;
    protected f gBT = new f();
    protected String gBU;
    protected String gBV;
    private String gBW;
    private String gBX;
    private ImageView gBY;
    private MMKeyboardUperView gBZ;
    private ResizeLayout gCa;
    protected String gCb;
    private String gCc;
    private com.tencent.mm.platformtools.c gCd;
    protected LinearLayout gCe;
    protected LinearLayout gCf;
    protected LinearLayout gCg;
    protected MMFormInputView gCh;
    protected MMFormVerifyCodeInputView gCi;
    private Button gCj;
    protected String gCk = "";
    protected boolean gCl = false;
    protected boolean gCm;
    private int gCn;
    private int gCo;
    private boolean gCp = false;
    private String gCq;
    protected int[] gCr = new int[5];
    private int gCs;
    private String gCt;
    private int gCu = 0;
    private SecurityImage gue = null;
    protected int gwX;
    protected String gzO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginHistoryUI() {
        AppMethodBeat.i(124940);
        AppMethodBeat.o(124940);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124941);
        super.onCreate(bundle);
        ab.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", com.tencent.mm.plugin.account.a.a.gkF);
        com.tencent.mm.plugin.account.a.a.gkF.BV();
        this.ehZ = ah.getContext().getSharedPreferences(ah.doA(), 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.gCp = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
            this.gCp = this.gCp;
            if (this.gCp) {
                this.gCq = intent.getStringExtra("bind_login_fingerprint_info");
            }
        }
        initView();
        this.gCd = new com.tencent.mm.platformtools.c();
        AppMethodBeat.o(124941);
    }

    public void onDestroy() {
        AppMethodBeat.i(124942);
        ab.i("MicroMsg.LoginHistoryUI", "onDestroy");
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        if (this.gCd != null) {
            this.gCd.close();
        }
        h.pYm.e(14262, Integer.valueOf(this.gCr[0]), Integer.valueOf(this.gCr[1]), Integer.valueOf(this.gCr[2]), Integer.valueOf(this.gCr[3]), Integer.valueOf(this.gCr[4]));
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        super.onDestroy();
        AppMethodBeat.o(124942);
    }

    public void onResume() {
        m mVar;
        AppMethodBeat.i(124943);
        super.onResume();
        final ArrayList arrayList = new ArrayList();
        if (!(!aqY() || this.gwX == 1 || (this.gCn & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0)) {
            mVar = new m(this, 7001, 0);
            mVar.setTitle((int) R.string.cos);
            arrayList.add(mVar);
        }
        if (!(this.gwX == 5 || (this.gCn & 262144) == 0)) {
            mVar = new m(this, 7005, 0);
            mVar.setTitle((int) R.string.cop);
            arrayList.add(mVar);
        }
        if (!bo.isNullOrNil(this.gCb)) {
            if (this.gwX != 2) {
                mVar = new m(this, 7007, 0);
                mVar.setTitle(getString(R.string.coq));
                arrayList.add(mVar);
            }
            if (!(bo.isNullOrNil(this.gBV) || this.gwX == 3)) {
                mVar = new m(this, 7008, 0);
                mVar.setTitle(getString(R.string.cor));
                arrayList.add(mVar);
            }
            if (this.gCb.equalsIgnoreCase(this.gBU)) {
                this.gBJ.setHint(getString(R.string.dmh));
            }
        }
        if (arrayList.size() > 1) {
            final d dVar = new d(this, 1, false);
            dVar.rBl = new n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(124927);
                    if (lVar.size() == 0) {
                        for (m i : arrayList) {
                            lVar.i(i);
                        }
                    }
                    AppMethodBeat.o(124927);
                }
            };
            dVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(124928);
                    LoginHistoryUI.a(LoginHistoryUI.this, menuItem.getItemId());
                    AppMethodBeat.o(124928);
                }
            };
            dVar.zQf = new d.a() {
                public final void onDismiss() {
                }
            };
            this.gBL.setVisibility(0);
            this.gBL.setText(R.string.co_);
            this.gBL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(124930);
                    LoginHistoryUI.this.aqX();
                    dVar.cpD();
                    AppMethodBeat.o(124930);
                }
            });
        } else if (arrayList.size() > 0) {
            this.gBL.setVisibility(0);
            this.gBL.setText(((m) arrayList.get(0)).getTitle());
            this.gBL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(124931);
                    LoginHistoryUI.a(LoginHistoryUI.this, ((m) arrayList.get(0)).getItemId());
                    AppMethodBeat.o(124931);
                }
            });
        } else {
            this.gBL.setVisibility(8);
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        g.RN();
        com.tencent.mm.kernel.a.Rc();
        if (!g.RK() || !g.RN().eJb || this.gCb.equals("")) {
            if (com.tencent.mm.q.a.On() == 2) {
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.PV(R.string.apa);
                aVar.asE(getString(R.string.ap_));
                aVar.rc(false);
                aVar.Qc(R.string.ap8).a(new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(124929);
                        ab.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
                        LoginHistoryUI.a(LoginHistoryUI.this);
                        AppMethodBeat.o(124929);
                    }
                });
                aVar.aMb().show();
                com.tencent.mm.q.a.b(this, System.currentTimeMillis());
            }
            AppMethodBeat.o(124943);
        } else if (this.ehJ == null || !this.ehJ.isShowing()) {
            b(null);
            AppMethodBeat.o(124943);
        } else {
            AppMethodBeat.o(124943);
        }
    }

    public void onPause() {
        AppMethodBeat.i(124944);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        AppMethodBeat.o(124944);
    }

    private void goBack() {
        AppMethodBeat.i(124945);
        Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
        bh.addFlags(67108864);
        if (bo.isNullOrNil(this.gBX)) {
            bh.putExtra("can_finish", true);
        }
        startActivity(bh);
        finish();
        com.tencent.mm.ui.base.b.hM(this);
        AppMethodBeat.o(124945);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(124946);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(124946);
        return onKeyDown;
    }

    private static Bitmap D(Bitmap bitmap) {
        AppMethodBeat.i(124947);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 5, 5, bitmap.getWidth() - 10, bitmap.getHeight() - 10, null, false);
        AppMethodBeat.o(124947);
        return createBitmap;
    }

    public final void initView() {
        AppMethodBeat.i(124948);
        this.gCe = (LinearLayout) findViewById(R.id.cqm);
        this.gCg = (LinearLayout) findViewById(R.id.cqr);
        this.gCf = (LinearLayout) findViewById(R.id.cqv);
        this.gCh = (MMFormInputView) findViewById(R.id.cqk);
        this.gCi = (MMFormVerifyCodeInputView) findViewById(R.id.cql);
        this.gBX = getIntent().getStringExtra("switch_login_wx_id");
        if (bo.isNullOrNil(this.gBX)) {
            this.gCb = av.fly.T("login_user_name", "");
            this.gCc = av.fly.ZC();
            this.gCo = bo.ank(av.fly.T("last_bind_info", ""));
            if ((this.gCo & 1) != 0) {
                this.gBU = av.fly.T("last_login_bind_qq", "");
            }
            if ((this.gCo & 4) != 0) {
                this.gBV = av.fly.T("last_login_bind_mobile", "");
            }
            this.gCn = bo.ank(av.fly.T("last_login_use_voice", ""));
        } else {
            this.gCb = bx.fnB.getString(this.gBX, "login_user_name");
            this.gCc = bx.fnB.getString(this.gBX, "last_avatar_path");
            this.gCo = bo.ank(bx.fnB.getString(this.gBX, "last_bind_info"));
            if ((this.gCo & 1) != 0) {
                this.gBU = bx.fnB.getString(this.gBX, "last_login_bind_qq");
            }
            if ((this.gCo & 4) != 0) {
                this.gBV = bx.fnB.getString(this.gBX, "last_login_bind_mobile");
            }
            this.gCn = bo.ank(bx.fnB.getString(this.gBX, "last_login_use_voice"));
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(124933);
                    LoginHistoryUI.b(LoginHistoryUI.this);
                    AppMethodBeat.o(124933);
                    return true;
                }
            }, R.raw.actionbar_icon_close_black);
        }
        String stringExtra = getIntent().getStringExtra("email_address");
        if (!(bo.isNullOrNil(stringExtra) || stringExtra.equalsIgnoreCase(this.gCb))) {
            this.gCb = stringExtra;
        }
        this.gBY = (ImageView) findViewById(R.id.cqj);
        if (!bo.isNullOrNil(this.gCc)) {
            try {
                Bitmap qi = com.tencent.mm.ah.d.qi(this.gCc);
                if (qi != null && qi.getWidth() > 10) {
                    this.gBY.setImageBitmap(D(qi));
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.LoginHistoryUI", e, "get avatar error", new Object[0]);
            }
        }
        g.RN();
        if (!com.tencent.mm.kernel.a.QX() || this.gCb.equals("")) {
            this.gBZ = (MMKeyboardUperView) findViewById(R.id.jh);
            this.gBI = (TextView) findViewById(R.id.cq_);
            this.gBJ = this.gCh.getContentEditText();
            this.gBK = (Button) findViewById(R.id.cqc);
            this.gBM = findViewById(R.id.cqn);
            this.gBN = findViewById(R.id.cqs);
            this.gBO = (Button) findViewById(R.id.cqx);
            this.gBL = (Button) findViewById(R.id.cqq);
            this.gCj = (Button) findViewById(R.id.cqd);
            this.gBP = (Button) findViewById(R.id.cqf);
            this.gBQ = (Button) findViewById(R.id.cqh);
            this.gBR = findViewById(R.id.cqg);
            this.gBS = (Button) findViewById(R.id.cqi);
            this.gBP.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(124934);
                    LoginHistoryUI.R(LoginHistoryUI.this, LoginHistoryUI.this.getString(R.string.g7t) + aa.dor());
                    AppMethodBeat.o(124934);
                }
            });
            this.gBQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(124935);
                    LoginHistoryUI.R(LoginHistoryUI.this, LoginHistoryUI.this.getString(R.string.g7k, new Object[]{aa.dor()}));
                    AppMethodBeat.o(124935);
                }
            });
            if (!aa.doo()) {
                this.gBR.setVisibility(8);
            }
            this.gCh.setVisibility(8);
            this.gCe.setVisibility(8);
            this.gCg.setVisibility(8);
            this.gCf.setVisibility(8);
            this.gBK.setVisibility(8);
            this.gBM.setVisibility(8);
            this.gBN.setVisibility(8);
            this.gBO.setVisibility(8);
            this.gBL.setVisibility(8);
            com.tencent.mm.ui.tools.b.c.d(this.gBJ).hz(4, 16).a(null);
            this.gCa = (ResizeLayout) findViewById(R.id.cq9);
            if (!bo.ant(this.gCb).booleanValue() || this.gCb.equals(this.gBU)) {
                this.gCr[2] = 2;
                this.gBI.setText(this.gCb);
            } else {
                this.gCr[2] = 1;
                this.gBI.setText(ws(this.gCb));
            }
            this.gCa.setOnSizeChanged(new ResizeLayout.a() {
                public final void aqZ() {
                    AppMethodBeat.i(124937);
                    LoginHistoryUI.this.gBZ.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(124936);
                            LoginHistoryUI.this.gBZ.fullScroll(130);
                            AppMethodBeat.o(124936);
                        }
                    });
                    AppMethodBeat.o(124937);
                }
            });
            this.gBZ.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(124938);
                    LoginHistoryUI.this.aqX();
                    AppMethodBeat.o(124938);
                    return false;
                }
            });
            final d dVar = new d(this, 1, false);
            dVar.rBl = new n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(124939);
                    if (lVar.size() == 0) {
                        lVar.hi(7002, R.string.coa);
                        lVar.hi(7003, R.string.cdz);
                        lVar.hi(7004, R.string.g0m);
                        if (!aa.doo()) {
                            lVar.hi(7009, R.string.g0k);
                        }
                    }
                    AppMethodBeat.o(124939);
                }
            };
            dVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(124915);
                    switch (menuItem.getItemId()) {
                        case 7002:
                            LoginHistoryUI.d(LoginHistoryUI.this);
                            AppMethodBeat.o(124915);
                            return;
                        case 7003:
                            LoginHistoryUI.e(LoginHistoryUI.this);
                            AppMethodBeat.o(124915);
                            return;
                        case 7004:
                            LoginHistoryUI.f(LoginHistoryUI.this);
                            AppMethodBeat.o(124915);
                            return;
                        case 7009:
                            LoginHistoryUI.R(LoginHistoryUI.this, LoginHistoryUI.this.getString(R.string.gb3) + aa.dor());
                            break;
                    }
                    AppMethodBeat.o(124915);
                }
            };
            dVar.zQf = new d.a() {
                public final void onDismiss() {
                }
            };
            if (bo.isNullOrNil(this.gBX)) {
                this.gBS.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(124916);
                        LoginHistoryUI.this.aqX();
                        dVar.cpD();
                        AppMethodBeat.o(124916);
                    }
                });
            } else if (aa.doo()) {
                this.gBS.setText(R.string.g0m);
                this.gBS.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(124918);
                        LoginHistoryUI.f(LoginHistoryUI.this);
                        AppMethodBeat.o(124918);
                    }
                });
            } else {
                this.gBS.setText(R.string.g0k);
                this.gBS.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(124917);
                        LoginHistoryUI.R(LoginHistoryUI.this, LoginHistoryUI.this.getString(R.string.gb3) + aa.dor());
                        AppMethodBeat.o(124917);
                    }
                });
            }
            setMMTitle("");
            xE(getResources().getColor(R.color.vy));
            dyb();
            pP(false);
            if (com.tencent.mm.sdk.platformtools.g.xyf) {
                com.tencent.mm.plugin.account.a.a.gkF.p(this);
            }
            if (com.tencent.mm.sdk.platformtools.f.EX_DEVICE_LOGIN) {
                this.gCj.setVisibility(0);
                this.gCj.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(124919);
                        com.tencent.mm.bp.d.H(LoginHistoryUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
                        LoginHistoryUI.this.overridePendingTransition(R.anim.cd, R.anim.s);
                        AppMethodBeat.o(124919);
                    }
                });
            }
            AppMethodBeat.o(124948);
            return;
        }
        this.gCl = true;
        b(null);
        AppMethodBeat.o(124948);
    }

    /* Access modifiers changed, original: protected|final */
    public final String ws(String str) {
        AppMethodBeat.i(124949);
        com.tencent.mm.sdk.platformtools.av avVar = new com.tencent.mm.sdk.platformtools.av();
        String str2 = "86";
        if (this.gCb.startsWith("+")) {
            str = str.replace("+", "");
            str2 = com.tencent.mm.sdk.platformtools.av.Ps(str);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        str2 = com.tencent.mm.sdk.platformtools.av.formatNumber(str2, str);
        AppMethodBeat.o(124949);
        return str2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqV() {
        AppMethodBeat.i(124950);
        g.Rg().a(701, (f) this);
        g.Rg().a(252, (f) this);
        AppMethodBeat.o(124950);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqW() {
        AppMethodBeat.i(124951);
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        AppMethodBeat.o(124951);
    }

    /* Access modifiers changed, original: protected */
    public void aqU() {
        AppMethodBeat.i(124952);
        this.gBT.account = this.gCb.trim();
        AppMethodBeat.o(124952);
    }

    public final void aqX() {
        AppMethodBeat.i(124953);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(124953);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(124953);
            return;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(124953);
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        AppMethodBeat.o(124953);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(124954);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginHistoryUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.d(str, str2, objArr);
        String stringExtra;
        if (i != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || intent == null) {
            if (i != 1025 || intent == null) {
                if (i == 31685 && intent != null && i2 == -1) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                        aqU();
                    }
                }
            } else if (i2 == 2) {
                stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                str = "MicroMsg.LoginHistoryUI";
                str2 = "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
                if (!bo.isNullOrNil(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                ab.i(str, str2, objArr);
                wt(stringExtra);
                AppMethodBeat.o(124954);
                return;
            }
        } else if (i2 == -1) {
            stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginHistoryUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
            if (!bo.isNullOrNil(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            ab.d(str2, str3, objArr2);
            wt(stringExtra);
            AppMethodBeat.o(124954);
            return;
        }
        AppMethodBeat.o(124954);
    }

    private void wt(String str) {
        AppMethodBeat.i(124955);
        this.gCk = str;
        aqU();
        AppMethodBeat.o(124955);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(124956);
        ab.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        ab.d("MicroMsg.LoginHistoryUI", "Scene Type " + mVar.getType());
        com.tencent.mm.h.a jY;
        boolean z;
        if (mVar.getType() == 145) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            int Ah = ((com.tencent.mm.modelfriend.a) mVar).Ah();
            if (Ah == 16) {
                if (i2 == -41) {
                    com.tencent.mm.ui.base.h.g(this, R.string.dl6, R.string.dl7);
                    this.gCi.reset();
                    AppMethodBeat.o(124956);
                    return;
                } else if (i2 == -75) {
                    com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.fm), "", true);
                    this.gCi.reset();
                    AppMethodBeat.o(124956);
                    return;
                } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                    z.f(this, str, 32045);
                    this.gCi.reset();
                    AppMethodBeat.o(124956);
                    return;
                }
            } else if (Ah == 17) {
                this.gCs = i2;
                this.gCt = str;
                if (i == 0 && i2 == 0) {
                    new g(new g.a() {
                        public final void a(ProgressDialog progressDialog) {
                            LoginHistoryUI.this.ehJ = progressDialog;
                        }
                    }, ((com.tencent.mm.modelfriend.a) mVar).getUsername(), ((com.tencent.mm.modelfriend.a) mVar).agf(), this.gBV).a(this);
                    AppMethodBeat.o(124956);
                    return;
                } else if (j(i, i2, str)) {
                    AppMethodBeat.o(124956);
                    return;
                } else {
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, null, null);
                    }
                }
            }
        } else if (mVar.getType() == 252 || mVar.getType() == 701) {
            this.cOG = ((q) mVar).ajm();
            ab.e("MicroMsg.LoginHistoryUI", "url " + this.cOG);
            g.Rg().b(701, (f) this);
            g.Rg().b(252, (f) this);
            this.gBT.gCL = ((q) mVar).getSecCodeType();
            this.gBT.guh = ((q) mVar).ajn();
            this.gBT.gug = ((q) mVar).ajo();
            this.gBT.gui = ((q) mVar).ajp();
            if (i2 == -205) {
                this.gzO = ((q) mVar).agh();
                this.gBV = ((q) mVar).ajq();
                this.gBW = ((q) mVar).ajt();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                g.Rg().a(new bk(new bk.a() {
                    public final void a(e eVar) {
                        AppMethodBeat.i(124920);
                        if (eVar == null) {
                            AppMethodBeat.o(124920);
                            return;
                        }
                        com.tencent.mm.network.c adg = eVar.adg();
                        byte[] bArr = new byte[0];
                        byte[] bArr2 = new byte[0];
                        byte[] bArr3 = new byte[0];
                        g.RN();
                        adg.a(bArr, bArr2, bArr3, com.tencent.mm.kernel.a.QF());
                        AppMethodBeat.o(124920);
                    }
                }), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.plugin.account.friend.a.l.apX();
                w.cm(this);
                z.vx(this.gBT.account);
                if (this.ehJ != null && this.ehJ.isShowing()) {
                    this.ehJ.setMessage(getString(R.string.rd));
                }
                b((q) mVar);
                if (this.gwX == 3) {
                    this.gCm = ((q) mVar).ajv();
                    g.Rg().a(255, (f) this);
                    final com.tencent.mm.ai.m rVar = new r(1);
                    g.Rg().a(rVar, 0);
                    getString(R.string.tz);
                    this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.rd), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(124921);
                            g.Rg().c(rVar);
                            g.Rg().b(255, LoginHistoryUI.this);
                            AppMethodBeat.o(124921);
                        }
                    });
                }
                AppMethodBeat.o(124956);
                return;
            }
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                z.f(this, str, 31685);
                AppMethodBeat.o(124956);
                return;
            } else if (i2 == -217) {
                z.a(this, com.tencent.mm.platformtools.e.a((q) mVar), i2);
                AppMethodBeat.o(124956);
                return;
            } else if (j(i, i2, str)) {
                AppMethodBeat.o(124956);
                return;
            } else {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY == null || !jY.a(this, null, null)) {
                    Toast.makeText(this, getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    AppMethodBeat.o(124956);
                    return;
                }
            }
        } else if (mVar.getType() == 255) {
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            g.Rg().b(255, (f) this);
            if (i2 == -3 && i == 4) {
                z = this.gCm;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(R.string.e8s));
                intent.putExtra("kintent_cancelable", z);
                startActivity(intent);
            }
            AppMethodBeat.o(124956);
            return;
        }
        if (j(i, i2, str)) {
            AppMethodBeat.o(124956);
        } else {
            AppMethodBeat.o(124956);
        }
    }

    private void b(q qVar) {
        AppMethodBeat.i(124957);
        ab.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", Integer.valueOf(hashCode()), bo.dpG());
        Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
        bh.addFlags(67108864);
        if (qVar != null) {
            bh.putExtra("kstyle_show_bind_mobile_afterauth", qVar.ajr());
            bh.putExtra("kstyle_bind_recommend_show", qVar.aju());
            bh.putExtra("kstyle_bind_wording", qVar.ajs());
        }
        startActivity(bh);
        finish();
        AppMethodBeat.o(124957);
    }

    /* JADX WARNING: Missing block: B:17:0x0080, code skipped:
            com.tencent.mm.ui.base.h.g(r11, com.tencent.mm.R.string.cof, com.tencent.mm.R.string.cog);
            com.tencent.matrix.trace.core.AppMethodBeat.o(124958);
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j(final int i, int i2, String str) {
        AppMethodBeat.i(124958);
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
                                int i2 = -1;
                                AppMethodBeat.i(124925);
                                ab.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.gBT.guh + " img len" + LoginHistoryUI.this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                                String str = "MicroMsg.LoginHistoryUI";
                                String str2 = "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = Integer.valueOf(i);
                                objArr[1] = Integer.valueOf(LoginHistoryUI.this.gCk == null ? -1 : LoginHistoryUI.this.gCk.length());
                                objArr[2] = bo.anv(LoginHistoryUI.this.gCk);
                                if (LoginHistoryUI.this.gBT.guf != null) {
                                    i2 = LoginHistoryUI.this.gBT.guf.length();
                                }
                                objArr[3] = Integer.valueOf(i2);
                                objArr[4] = bo.anv(LoginHistoryUI.this.gBT.guf);
                                ab.d(str, str2, objArr);
                                final com.tencent.mm.ai.m qVar = new q(LoginHistoryUI.this.gBT.account, LoginHistoryUI.this.gBT.guf, LoginHistoryUI.this.gBT.gCL, LoginHistoryUI.this.gue.getSecImgCode(), LoginHistoryUI.this.gue.getSecImgSid(), LoginHistoryUI.this.gue.getSecImgEncryptKey(), 0, "", false, false);
                                if (bo.isNullOrNil(LoginHistoryUI.this.gBT.guf) && !bo.isNullOrNil(LoginHistoryUI.this.gCk)) {
                                    ab.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", bo.anv(LoginHistoryUI.this.gCk));
                                    qVar.tr(LoginHistoryUI.this.gCk);
                                }
                                g.Rg().a(qVar, 0);
                                LoginHistoryUI loginHistoryUI = LoginHistoryUI.this;
                                Context context = LoginHistoryUI.this;
                                LoginHistoryUI.this.getString(R.string.tz);
                                loginHistoryUI.ehJ = com.tencent.mm.ui.base.h.b(context, LoginHistoryUI.this.getString(R.string.cou), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(124924);
                                        g.Rg().c(qVar);
                                        g.Rg().b(701, LoginHistoryUI.this);
                                        g.Rg().b(252, LoginHistoryUI.this);
                                        AppMethodBeat.o(124924);
                                    }
                                });
                                AppMethodBeat.o(124925);
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(124926);
                                LoginHistoryUI.this.gue = null;
                                AppMethodBeat.o(124926);
                            }
                        }, this.gBT);
                    } else {
                        ab.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                        this.gue.b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                    }
                    AppMethodBeat.o(124958);
                    return true;
                case -205:
                    ab.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bo.anv(this.gzO), this.gBW);
                    f.a(this.gBT);
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.gzO);
                    intent.putExtra("binded_mobile", this.gBV);
                    intent.putExtra("close_safe_device_style", this.gBW);
                    intent.putExtra("from_source", 2);
                    com.tencent.mm.plugin.account.a.a.gkE.g((Context) this, intent);
                    AppMethodBeat.o(124958);
                    return true;
                case -140:
                    if (!bo.isNullOrNil(this.cOG)) {
                        z.o(this, str, this.cOG);
                    }
                    AppMethodBeat.o(124958);
                    return true;
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    String an;
                    com.tencent.mm.kernel.a.hold();
                    g.RN();
                    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QH())) {
                        an = com.tencent.mm.bz.a.an(this, R.string.cvw);
                    } else {
                        g.RN();
                        an = com.tencent.mm.kernel.a.QH();
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, an, getString(R.string.tz), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(124958);
                    return true;
                case -75:
                    z.cu(this);
                    AppMethodBeat.o(124958);
                    return true;
                case -72:
                    com.tencent.mm.ui.base.h.g(this, R.string.dmb, R.string.tz);
                    AppMethodBeat.o(124958);
                    return true;
                case -33:
                    com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.a7s, (int) R.string.a7y, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(124958);
                    return true;
                case -32:
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a7u), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(124958);
                    return true;
                case -9:
                    break;
                case -3:
                    if (this.gCu <= 0) {
                        com.tencent.mm.ui.base.h.g(this, R.string.be9, R.string.cog);
                        this.gCu++;
                    } else {
                        com.tencent.mm.ui.base.h.d(this, getString(R.string.be_), getString(R.string.cog), getString(R.string.bea), getString(R.string.or), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(124922);
                                LoginHistoryUI.g(LoginHistoryUI.this);
                                AppMethodBeat.o(124922);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(124923);
                                LoginHistoryUI.this.gCu = LoginHistoryUI.this.gCu + 1;
                                AppMethodBeat.o(124923);
                            }
                        });
                    }
                    AppMethodBeat.o(124958);
                    return true;
                case -1:
                    if (g.Rg().acS() == 5) {
                        com.tencent.mm.ui.base.h.g(this, R.string.d5n, R.string.d5m);
                        AppMethodBeat.o(124958);
                        return true;
                    }
                    break;
            }
        }
        if (com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
            if (this.gue != null) {
                this.gue.dismiss();
            }
            AppMethodBeat.o(124958);
            return true;
        }
        boolean a = this.gCd.a(this, new ag(i, i2, str));
        AppMethodBeat.o(124958);
        return a;
    }

    public final int getLayoutId() {
        return R.layout.a_b;
    }

    public void setRequestedOrientation(int i) {
    }

    public static void R(Context context, String str) {
        AppMethodBeat.i(124959);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        com.tencent.mm.bp.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(124959);
    }

    public boolean aqY() {
        return true;
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(124960);
        aj.amB("welcome_page_show");
        com.tencent.mm.kernel.l.m(loginHistoryUI, true);
        com.tencent.mm.g.a.z zVar = new com.tencent.mm.g.a.z();
        zVar.csU.csV = false;
        com.tencent.mm.sdk.b.a.xxA.m(zVar);
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().BV();
        loginHistoryUI.finish();
        AppCompatActivity appCompatActivity = loginHistoryUI.mController.ylL;
        ab.dot();
        MMNativeJpeg.Destroy();
        Intent intent = null;
        try {
            intent = new Intent().setClass(appCompatActivity, Class.forName(ah.doy()));
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.LoginHistoryUI", e, "", new Object[0]);
        }
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        if (!(appCompatActivity instanceof Activity)) {
            intent.addFlags(268435456);
        }
        appCompatActivity.startActivity(intent);
        AppMethodBeat.o(124960);
    }

    static /* synthetic */ void d(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(124962);
        loginHistoryUI.gCr[4] = 1;
        Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        int[] iArr = new int[5];
        iArr[4] = 1;
        intent.putExtra("kv_report_login_method_data", iArr);
        loginHistoryUI.startActivity(intent);
        AppMethodBeat.o(124962);
    }

    static /* synthetic */ void e(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(124963);
        if (com.tencent.mm.protocal.d.vxr) {
            String string = loginHistoryUI.getString(R.string.b3m, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.vxo), aa.dor()});
            ab.e("MicroMsg.LoginHistoryUI", "url ".concat(String.valueOf(string)));
            R(loginHistoryUI.mController.ylL, string);
            AppMethodBeat.o(124963);
            return;
        }
        loginHistoryUI.startActivity(new Intent(loginHistoryUI, RegByMobileRegAIOUI.class));
        AppMethodBeat.o(124963);
    }

    static /* synthetic */ void f(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(124964);
        R(loginHistoryUI.mController.ylL, loginHistoryUI.getString(R.string.g0n) + aa.dor());
        AppMethodBeat.o(124964);
    }

    static /* synthetic */ void g(LoginHistoryUI loginHistoryUI) {
        AppMethodBeat.i(124965);
        int i = 0;
        if (loginHistoryUI.gCo != 0) {
            if (!((loginHistoryUI.gCo & 2) == 0 && (loginHistoryUI.gCo & 4) == 0)) {
                i = 2;
            }
            if ((loginHistoryUI.gCo & 4) != 0) {
                i |= 4;
            }
            if ((loginHistoryUI.gCo & 1) != 0) {
                i |= 1;
            }
        } else if (com.tencent.mm.au.b.ahP()) {
            i = 6;
        } else {
            i = 7;
        }
        i |= 8;
        j jVar = new j(loginHistoryUI);
        jVar.rBl = new com.tencent.mm.plugin.account.ui.e.AnonymousClass1(i, loginHistoryUI);
        jVar.rBm = new com.tencent.mm.plugin.account.ui.e.AnonymousClass2(loginHistoryUI);
        jVar.cuu();
        AppMethodBeat.o(124965);
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI, int i) {
        AppMethodBeat.i(124966);
        Intent intent = null;
        loginHistoryUI.gCr[3] = 1;
        switch (i) {
            case 7001:
                intent = new Intent(loginHistoryUI, LoginVoiceUI.class);
                break;
            case 7006:
                intent = new Intent(loginHistoryUI, LoginFaceUI.class);
                break;
            case 7007:
                intent = new Intent(loginHistoryUI, LoginPasswordUI.class);
                break;
            case 7008:
                intent = new Intent(loginHistoryUI, LoginSmsUI.class);
                break;
        }
        if (intent != null) {
            intent.putExtra("switch_login_wx_id", loginHistoryUI.gBX);
            loginHistoryUI.startActivity(intent);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(124932);
                    LoginHistoryUI.this.finish();
                    LoginHistoryUI.this.overridePendingTransition(-1, -1);
                    AppMethodBeat.o(124932);
                }
            }, 300);
            com.tencent.mm.ui.base.b.hN(loginHistoryUI);
        }
        AppMethodBeat.o(124966);
    }
}
