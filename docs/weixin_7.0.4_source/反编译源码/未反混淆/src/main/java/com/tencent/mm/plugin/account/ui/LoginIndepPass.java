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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class LoginIndepPass extends MMActivity implements f {
    private String account;
    private String cOG;
    private ProgressDialog ehJ = null;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(124967);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(124967);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(124968);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(124968);
                return false;
            }
            ab.i("MicroMsg.LoginIndepPass", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(124968);
            return true;
        }
    };
    private f gBT = new f();
    private String gBV;
    private String gBW;
    private EditText gCB;
    private String gCC;
    private Button gCD;
    private String gsF;
    private p guc;
    private SecurityImage gue = null;
    private String gzO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginIndepPass() {
        AppMethodBeat.i(124985);
        AppMethodBeat.o(124985);
    }

    static /* synthetic */ void a(LoginIndepPass loginIndepPass) {
        AppMethodBeat.i(124995);
        loginIndepPass.aqU();
        AppMethodBeat.o(124995);
    }

    public final int getLayoutId() {
        return R.layout.a_c;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124986);
        super.onCreate(bundle);
        String string = getString(R.string.cok);
        if (d.vxr) {
            string = getString(R.string.ru) + getString(R.string.fk);
        }
        setMMTitle(string);
        this.gCC = getIntent().getStringExtra("bindmcontact_mobile");
        if (this.gCC != null) {
            this.account = av.amN(this.gCC);
        }
        a.gkF.BV();
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        AppMethodBeat.o(124986);
    }

    public void onResume() {
        AppMethodBeat.i(124987);
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L200_200,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L200_200")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("L200_200");
        AppMethodBeat.o(124987);
    }

    public void onPause() {
        AppMethodBeat.i(124988);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L200_200,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("L200_200")).append(",2").toString());
        AppMethodBeat.o(124988);
    }

    public void onDestroy() {
        AppMethodBeat.i(124989);
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        super.onDestroy();
        AppMethodBeat.o(124989);
    }

    public final void initView() {
        AppMethodBeat.i(124990);
        this.gCB = (EditText) findViewById(R.id.cqy);
        this.gCD = (Button) findViewById(R.id.cqz);
        enableOptionMenu(false);
        addTextOptionMenu(0, getString(R.string.com), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124975);
                LoginIndepPass.a(LoginIndepPass.this);
                AppMethodBeat.o(124975);
                return true;
            }
        });
        this.gCB.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(124976);
                LoginIndepPass.b(LoginIndepPass.this);
                AppMethodBeat.o(124976);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.gCB.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(124977);
                if (i == 6 || i == 5) {
                    LoginIndepPass.a(LoginIndepPass.this);
                    AppMethodBeat.o(124977);
                    return true;
                }
                AppMethodBeat.o(124977);
                return false;
            }
        });
        this.gCB.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(124978);
                if (66 == i && keyEvent.getAction() == 0) {
                    LoginIndepPass.a(LoginIndepPass.this);
                    AppMethodBeat.o(124978);
                    return true;
                }
                AppMethodBeat.o(124978);
                return false;
            }
        });
        this.gCD.setText(getString(R.string.cor));
        this.gCD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(124981);
                h.a(LoginIndepPass.this, LoginIndepPass.this.getString(R.string.dm4) + LoginIndepPass.this.gCC, LoginIndepPass.this.getString(R.string.dm5), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(124980);
                        g.Rg().a(145, LoginIndepPass.this);
                        final m aVar = new com.tencent.mm.modelfriend.a(LoginIndepPass.this.account, 16, "", 0, "");
                        g.Rg().a(aVar, 0);
                        LoginIndepPass loginIndepPass = LoginIndepPass.this;
                        Context context = LoginIndepPass.this;
                        LoginIndepPass.this.getString(R.string.tz);
                        loginIndepPass.guc = h.b(context, LoginIndepPass.this.getString(R.string.rd), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(124979);
                                g.Rg().c(aVar);
                                g.Rg().b(701, LoginIndepPass.this);
                                g.Rg().b(252, LoginIndepPass.this);
                                AppMethodBeat.o(124979);
                            }
                        });
                        AppMethodBeat.o(124980);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(124981);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124982);
                com.tencent.mm.plugin.b.a.wA("L200_100");
                Intent intent = new Intent(LoginIndepPass.this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.addFlags(67108864);
                LoginIndepPass.this.startActivity(intent);
                LoginIndepPass.this.finish();
                AppMethodBeat.o(124982);
                return true;
            }
        });
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!bo.isNullOrNil(this.gzO)) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(124983);
                    LoginIndepPass.a(LoginIndepPass.this, f.ara(), f.arb());
                    AppMethodBeat.o(124983);
                }
            }, 500);
        }
        AppMethodBeat.o(124990);
    }

    private void aqU() {
        AppMethodBeat.i(124991);
        String obj = this.gCB.getText().toString();
        if (bo.isNullOrNil(this.account)) {
            h.g(this, R.string.f0w, R.string.cog);
            AppMethodBeat.o(124991);
        } else if (obj.equals("")) {
            h.g(this, R.string.f0s, R.string.cog);
            AppMethodBeat.o(124991);
        } else {
            aqX();
            g.Rg().a(701, (f) this);
            g.Rg().a(252, (f) this);
            final m qVar = new q(this.account, obj, null, 1);
            g.Rg().a(qVar, 0);
            getString(R.string.tz);
            this.ehJ = h.b((Context) this, getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(124984);
                    g.Rg().c(qVar);
                    AppMethodBeat.o(124984);
                }
            });
            AppMethodBeat.o(124991);
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124992);
        ab.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.guc != null) {
            this.guc.dismiss();
            this.guc = null;
        }
        if (mVar.getType() == 252 || mVar.getType() == 701) {
            this.cOG = ((q) mVar).ajm();
            g.Rg().b(701, (f) this);
            g.Rg().b(252, (f) this);
            this.gBT.guh = ((q) mVar).ajn();
            this.gBT.gug = ((q) mVar).ajo();
            this.gBT.gui = ((q) mVar).ajp();
            this.gBT.gCL = ((q) mVar).getSecCodeType();
            this.gBT.account = this.account;
            this.gBT.guf = this.gCB.getText().toString();
            if (i2 == -75) {
                z.cu(this.mController.ylL);
                AppMethodBeat.o(124992);
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                z.f(this, str, 0);
                AppMethodBeat.o(124992);
            } else if (i2 == -217) {
                z.a(this, e.a((q) mVar), i2);
                AppMethodBeat.o(124992);
            } else if (i2 == -205) {
                this.gzO = ((q) mVar).agh();
                this.gBV = ((q) mVar).ajq();
                this.gBW = ((q) mVar).ajt();
                ab.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bo.anv(this.gzO), this.gBW);
                f.a(this.gBT);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.gzO);
                intent.putExtra("binded_mobile", this.gBV);
                intent.putExtra("close_safe_device_style", this.gBW);
                intent.putExtra("from_source", 5);
                a.gkE.g((Context) this, intent);
                AppMethodBeat.o(124992);
            } else if (i2 == -140) {
                if (!bo.isNullOrNil(this.cOG)) {
                    z.o(this, str, this.cOG);
                }
                AppMethodBeat.o(124992);
            } else {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    g.Rg().a(new bk(new bk.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            AppMethodBeat.i(124970);
                            if (eVar == null) {
                                AppMethodBeat.o(124970);
                                return;
                            }
                            com.tencent.mm.network.c adg = eVar.adg();
                            byte[] bArr = new byte[0];
                            byte[] bArr2 = new byte[0];
                            byte[] bArr3 = new byte[0];
                            g.RN();
                            adg.a(bArr, bArr2, bArr3, com.tencent.mm.kernel.a.QF());
                            AppMethodBeat.o(124970);
                        }
                    }), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    g.Rg().a(701, (f) this);
                    g.Rg().a(252, (f) this);
                    if (this.gue == null) {
                        this.gue = SecurityImage.a.a(this.mController.ylL, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(124972);
                                ab.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.this.gBT.guh + " img len" + LoginIndepPass.this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                                final m qVar = new q(LoginIndepPass.this.gBT.account, LoginIndepPass.this.gBT.guf, LoginIndepPass.this.gBT.gCL, LoginIndepPass.this.gue.getSecImgCode(), LoginIndepPass.this.gue.getSecImgSid(), LoginIndepPass.this.gue.getSecImgEncryptKey(), 1, "", false, false);
                                g.Rg().a(qVar, 0);
                                LoginIndepPass loginIndepPass = LoginIndepPass.this;
                                Context context = LoginIndepPass.this;
                                LoginIndepPass.this.getString(R.string.tz);
                                loginIndepPass.ehJ = h.b(context, LoginIndepPass.this.getString(R.string.cou), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(124971);
                                        g.Rg().c(qVar);
                                        g.Rg().b(701, LoginIndepPass.this);
                                        g.Rg().b(252, LoginIndepPass.this);
                                        AppMethodBeat.o(124971);
                                    }
                                });
                                AppMethodBeat.o(124972);
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(124973);
                                LoginIndepPass.this.gue = null;
                                AppMethodBeat.o(124973);
                            }
                        }, this.gBT);
                        AppMethodBeat.o(124992);
                        return;
                    }
                    ab.d("MicroMsg.LoginIndepPass", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                    this.gue.b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                    AppMethodBeat.o(124992);
                } else if (z || (i == 0 && i2 == 0)) {
                    com.tencent.mm.kernel.a.unhold();
                    l.apX();
                    z.vx(this.gBT.account);
                    w.cm(this);
                    z.showAddrBookUploadConfirm(this, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(124974);
                            ab.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
                            Intent bh = a.gkE.bh(LoginIndepPass.this);
                            bh.addFlags(67108864);
                            LoginIndepPass.this.startActivity(bh);
                            LoginIndepPass.this.finish();
                            AppMethodBeat.o(124974);
                        }
                    }, false, 2);
                    AppMethodBeat.o(124992);
                } else if (j(i, i2, str)) {
                    AppMethodBeat.o(124992);
                } else {
                    if (mVar.getType() == 252 || mVar.getType() == 701) {
                        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                        if (jY != null && jY.a(this, null, null)) {
                            AppMethodBeat.o(124992);
                            return;
                        }
                    }
                    Toast.makeText(this, getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.o(124992);
                }
            }
        } else if (mVar.getType() == 145) {
            g.Rg().b(145, (f) this);
            String agi = ((com.tencent.mm.modelfriend.a) mVar).agi();
            if (i2 == -41) {
                h.g(this, R.string.dl6, R.string.dl7);
                AppMethodBeat.o(124992);
            } else if (i2 == -75) {
                h.b((Context) this, getString(R.string.fm), "", true);
                AppMethodBeat.o(124992);
            } else {
                com.tencent.mm.plugin.b.a.wA("L3");
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L3,");
                g.RN();
                com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L3")).append(",1").toString());
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.gCC);
                intent2.putExtra("bindmcontact_shortmobile", agi);
                intent2.putExtra("mobile_verify_purpose", 1);
                intent2.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) mVar).agn());
                intent2.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) mVar).ago());
                intent2.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) mVar).agp());
                a(MobileVerifyUI.class, intent2);
                AppMethodBeat.o(124992);
            }
        } else if (j(i, i2, str)) {
            AppMethodBeat.o(124992);
        } else {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.o(124992);
        }
    }

    private boolean j(int i, int i2, String str) {
        AppMethodBeat.i(124993);
        if (a.gkF.a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(124993);
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -140:
                    if (!bo.isNullOrNil(this.cOG)) {
                        z.o(this.mController.ylL, str, this.cOG);
                    }
                    AppMethodBeat.o(124993);
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
                    h.a(context, an, this.mController.ylL.getString(R.string.tz), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(124993);
                    return true;
                case -9:
                    h.g(this, R.string.cof, R.string.cog);
                    AppMethodBeat.o(124993);
                    return true;
                case -4:
                case -3:
                    h.g(this, R.string.be9, R.string.cog);
                    AppMethodBeat.o(124993);
                    return true;
                case -1:
                    if (g.Rg().acS() == 5) {
                        h.g(this, R.string.d5n, R.string.d5m);
                        AppMethodBeat.o(124993);
                        return true;
                    }
                    AppMethodBeat.o(124993);
                    return false;
            }
        }
        AppMethodBeat.o(124993);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(124994);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginIndepPass";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginIndepPass";
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
                aqU();
                AppMethodBeat.o(124994);
                return;
            }
        }
        AppMethodBeat.o(124994);
    }

    static /* synthetic */ void b(LoginIndepPass loginIndepPass) {
        AppMethodBeat.i(124996);
        if (bo.isNullOrNil(loginIndepPass.gCB.getText().toString().trim())) {
            loginIndepPass.enableOptionMenu(false);
            AppMethodBeat.o(124996);
            return;
        }
        loginIndepPass.enableOptionMenu(true);
        AppMethodBeat.o(124996);
    }

    static /* synthetic */ void a(LoginIndepPass loginIndepPass, String str, String str2) {
        AppMethodBeat.i(124997);
        if (bo.isNullOrNil(str)) {
            h.g(loginIndepPass, R.string.f0w, R.string.cog);
            AppMethodBeat.o(124997);
        } else if (bo.isNullOrNil(str2)) {
            h.g(loginIndepPass, R.string.f0s, R.string.cog);
            AppMethodBeat.o(124997);
        } else {
            loginIndepPass.gCB.setText(str2);
            loginIndepPass.aqX();
            g.Rg().a(701, (f) loginIndepPass);
            g.Rg().a(252, (f) loginIndepPass);
            final m qVar = new q(str, str2, null, 1);
            g.Rg().a(qVar, 0);
            loginIndepPass.getString(R.string.tz);
            loginIndepPass.ehJ = h.b((Context) loginIndepPass, loginIndepPass.getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(124969);
                    g.Rg().c(qVar);
                    AppMethodBeat.o(124969);
                }
            });
            AppMethodBeat.o(124997);
        }
    }
}
