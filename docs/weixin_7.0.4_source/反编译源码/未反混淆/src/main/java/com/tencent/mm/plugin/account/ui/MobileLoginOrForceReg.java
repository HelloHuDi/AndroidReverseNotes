package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class MobileLoginOrForceReg extends MMActivity implements f {
    private String cFl;
    private String cOG;
    private String cxb;
    protected ProgressDialog ehJ = null;
    private ImageView ejo;
    private TextView ejp;
    private int fPA;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(125211);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(125211);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(125212);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(125212);
                return false;
            }
            ab.i("MicorMsg.MobileLoginOrForceReg", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(125212);
            return true;
        }
    };
    private f gBT = null;
    private ba gBm = new ba();
    private com.tencent.mm.platformtools.c gCd;
    private g gDu = null;
    private String gDy;
    private Button gEf;
    private Button gEg;
    private LinearLayout gEh;
    private LinearLayout gEi;
    private int gEj;
    private String gEk;
    private String gEl;
    private int gEm;
    private String gEn;
    private boolean gEo = true;
    private boolean gEp;
    private String gEq;
    private String gEr;
    private int gEs;
    private String gEt;
    private int gEu;
    private TextView grM;
    private SecurityImage gue = null;
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(125203);
            if (message.obj != null) {
                MobileLoginOrForceReg.this.ejo.setImageBitmap((Bitmap) message.obj);
            }
            AppMethodBeat.o(125203);
        }
    };
    private String nickname;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MobileLoginOrForceReg() {
        AppMethodBeat.i(125222);
        AppMethodBeat.o(125222);
    }

    static /* synthetic */ void p(MobileLoginOrForceReg mobileLoginOrForceReg) {
        AppMethodBeat.i(125233);
        mobileLoginOrForceReg.goBack();
        AppMethodBeat.o(125233);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125223);
        super.onCreate(bundle);
        this.gEn = a.FP();
        g.Rg().a(701, (f) this);
        g.Rg().a(252, (f) this);
        g.Rg().a(126, (f) this);
        g.Rg().a(255, (f) this);
        this.gEs = getIntent().getIntExtra("key_reg_style", 1);
        this.cxb = getIntent().getStringExtra("ticket");
        this.cFl = getIntent().getStringExtra("moble");
        this.gEj = getIntent().getIntExtra("next_controll", 0);
        this.username = getIntent().getStringExtra("username");
        this.gEk = getIntent().getStringExtra("password");
        this.nickname = getIntent().getStringExtra("nickname");
        this.gEl = getIntent().getStringExtra("avatar_url");
        this.gDy = getIntent().getStringExtra("regsession_id");
        this.gEt = getIntent().getStringExtra("reg_3d_app_ticket");
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        this.gEm = getIntent().getIntExtra("mobile_check_type", 0);
        this.gEp = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.gEq = getIntent().getStringExtra("kintent_nickname");
        this.gEr = getIntent().getStringExtra("kintent_password");
        if (this.gEr == null || this.gEr.length() < 8) {
            this.fPA = 4;
        } else {
            this.fPA = 1;
        }
        initView();
        this.gCd = new com.tencent.mm.platformtools.c();
        AppMethodBeat.o(125223);
    }

    private void wu(final String str) {
        AppMethodBeat.i(125224);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(125213);
                Object obj = null;
                try {
                    obj = d.decodeStream(com.tencent.mm.network.b.p(str, Downloads.MIN_WAIT_FOR_NETWORK, i.sHCENCODEVIDEOTIMEOUT));
                } catch (Exception e) {
                    ab.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
                    ab.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", e, "", new Object[0]);
                }
                MobileLoginOrForceReg.this.handler.sendMessage(MobileLoginOrForceReg.this.handler.obtainMessage(0, obj));
                AppMethodBeat.o(125213);
            }

            public final String toString() {
                AppMethodBeat.i(125214);
                String str = super.toString() + "|loadBitmap";
                AppMethodBeat.o(125214);
                return str;
            }
        });
        AppMethodBeat.o(125224);
    }

    public final void initView() {
        CharSequence charSequence;
        AppMethodBeat.i(125225);
        this.gEf = (Button) findViewById(R.id.dby);
        this.gEg = (Button) findViewById(R.id.dbz);
        this.gEh = (LinearLayout) findViewById(R.id.dbx);
        this.gEi = (LinearLayout) findViewById(R.id.dbw);
        this.ejo = (ImageView) findViewById(R.id.qk);
        this.ejp = (TextView) findViewById(R.id.b6e);
        this.grM = (TextView) findViewById(R.id.a63);
        av avVar = new av();
        if (this.cFl.startsWith("+")) {
            String Ps = av.Ps(this.cFl);
            if (bo.isNullOrNil(Ps)) {
                charSequence = this.cFl;
            } else {
                charSequence = "+" + Ps + " " + av.formatNumber(Ps, this.cFl.substring(Ps.length() + 1));
            }
        } else {
            charSequence = "+86 " + av.formatNumber("86", this.cFl);
        }
        this.grM.setText(charSequence);
        if (bo.isNullOrNil(this.nickname) && bo.isNullOrNil(this.gEl)) {
            this.gEi.setVisibility(0);
            this.gEh.setVisibility(8);
        } else {
            this.gEi.setVisibility(8);
            this.gEh.setVisibility(0);
            if (bo.isNullOrNil(this.nickname)) {
                this.ejp.setVisibility(8);
            } else {
                this.ejp.setText(this.nickname);
            }
            Bitmap AZ = com.tencent.mm.pluginsdk.ui.a.b.diS().AZ();
            if (AZ != null) {
                this.ejo.setImageBitmap(AZ);
            }
            if (!bo.isNullOrNil(this.gEl)) {
                wu(this.gEl);
            }
        }
        this.gEf.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125215);
                MobileLoginOrForceReg.this.gDu = new g(new g.a() {
                    public final void a(ProgressDialog progressDialog) {
                        MobileLoginOrForceReg.this.ehJ = progressDialog;
                    }
                }, MobileLoginOrForceReg.this.username, MobileLoginOrForceReg.this.gEk, MobileLoginOrForceReg.this.cFl);
                MobileLoginOrForceReg.this.gDu.a(MobileLoginOrForceReg.this);
                AppMethodBeat.o(125215);
            }
        });
        this.gEg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125216);
                if (bo.isNullOrNil(MobileLoginOrForceReg.this.gEq)) {
                    Intent intent = new Intent();
                    a.wA("R200_900_phone");
                    intent.putExtra("regsetinfo_ticket", MobileLoginOrForceReg.this.cxb);
                    intent.putExtra("regsetinfo_user", MobileLoginOrForceReg.this.cFl);
                    intent.putExtra("regsetinfo_pwd", MobileLoginOrForceReg.this.gEk);
                    intent.putExtra("regsetinfo_ismobile", 4);
                    intent.putExtra("regsetinfo_isForce", true);
                    intent.putExtra("regsession_id", MobileLoginOrForceReg.this.gDy);
                    intent.putExtra("reg_3d_app_ticket", MobileLoginOrForceReg.this.gEt);
                    intent.putExtra("reg_3d_app_type", MobileLoginOrForceReg.this.gEu);
                    intent.putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.this.gEj);
                    intent.putExtra("mobile_check_type", MobileLoginOrForceReg.this.gEm);
                    intent.putExtra("key_reg_style", MobileLoginOrForceReg.this.gEs);
                    intent.setClass(MobileLoginOrForceReg.this, RegSetInfoUI.class);
                    MobileLoginOrForceReg.this.startActivity(intent);
                    AppMethodBeat.o(125216);
                    return;
                }
                MobileLoginOrForceReg.o(MobileLoginOrForceReg.this);
                AppMethodBeat.o(125216);
            }
        });
        setMMTitle((int) R.string.d0d);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125217);
                MobileLoginOrForceReg.p(MobileLoginOrForceReg.this);
                AppMethodBeat.o(125217);
                return false;
            }
        });
        AppMethodBeat.o(125225);
    }

    public void onResume() {
        AppMethodBeat.i(125226);
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
        g.RN();
        a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",1").toString());
        a.wz("R200_600");
        AppMethodBeat.o(125226);
    }

    public void onPause() {
        AppMethodBeat.i(125227);
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        AppMethodBeat.o(125227);
    }

    public void onDestroy() {
        AppMethodBeat.i(125228);
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        g.Rg().b(126, (f) this);
        g.Rg().b(255, (f) this);
        if (this.gCd != null) {
            this.gCd.close();
        }
        super.onDestroy();
        AppMethodBeat.o(125228);
    }

    public final int getLayoutId() {
        return R.layout.ah4;
    }

    private void goBack() {
        Intent intent;
        AppMethodBeat.i(125229);
        a.wA("R200_100");
        if (this.gEs == 1) {
            intent = new Intent(this, RegByMobileRegAIOUI.class);
        } else {
            intent = new Intent(this, MobileInputUI.class);
        }
        intent.putExtra("mobile_input_purpose", 2);
        intent.addFlags(67108864);
        startActivity(intent);
        a.wz(this.gEn);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
        g.RN();
        a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",2").toString());
        finish();
        AppMethodBeat.o(125229);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125230);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(125230);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125230);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125231);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.gBT == null) {
            this.gBT = new f();
        }
        if (mVar.getType() == 255) {
            if (i2 == -3 && i == 4) {
                boolean z = this.gEo;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(R.string.e8s));
                intent.putExtra("kintent_cancelable", z);
                startActivityForResult(intent, 0);
            }
            AppMethodBeat.o(125231);
        } else if ((mVar.getType() != 252 && mVar.getType() != 701) || this.gDu == null) {
            String str2;
            com.tencent.mm.h.a jY;
            Object obj;
            if (mVar.getType() == 126) {
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean valueOf = Boolean.valueOf(this.gEp);
                    final String str3 = this.gEr;
                    final String str4 = this.gEq;
                    if (this.gue == null) {
                        final m mVar2 = mVar;
                        final String str5 = str3;
                        final String str6 = str4;
                        final m mVar3 = mVar;
                        final Boolean bool = valueOf;
                        this.gue = SecurityImage.a.a(this, 0, ((s) mVar).ajo(), ((s) mVar).ajn(), "", new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125205);
                                final m sVar = new s("", str3, str4, 0, "", MobileLoginOrForceReg.this.cFl, "", "", MobileLoginOrForceReg.this.cxb, MobileLoginOrForceReg.this.fPA, "", ((s) mVar2).ajn(), MobileLoginOrForceReg.this.gue.getSecImgCode(), true, valueOf.booleanValue());
                                sVar.ts(MobileLoginOrForceReg.this.gDy);
                                sVar.tt(MobileLoginOrForceReg.this.gEt);
                                sVar.lX(MobileLoginOrForceReg.this.gEm);
                                g.Rg().a(sVar, 0);
                                MobileLoginOrForceReg mobileLoginOrForceReg = MobileLoginOrForceReg.this;
                                Context context = MobileLoginOrForceReg.this.mController.ylL;
                                MobileLoginOrForceReg.this.getString(R.string.tz);
                                mobileLoginOrForceReg.ehJ = h.b(context, MobileLoginOrForceReg.this.getString(R.string.dmm), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(125204);
                                        g.Rg().c(sVar);
                                        AppMethodBeat.o(125204);
                                    }
                                });
                                AppMethodBeat.o(125205);
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(125206);
                                MobileLoginOrForceReg.this.gue = null;
                                AppMethodBeat.o(125206);
                            }
                        }, new SecurityImage.b() {
                            public final void apw() {
                                AppMethodBeat.i(125207);
                                MobileLoginOrForceReg.this.aqX();
                                m sVar = new s("", str5, str6, 0, "", MobileLoginOrForceReg.this.cFl, "", "", MobileLoginOrForceReg.this.cxb, MobileLoginOrForceReg.this.fPA, "", ((s) mVar3).ajn(), "", true, bool.booleanValue());
                                sVar.ts(MobileLoginOrForceReg.this.gDy);
                                sVar.tt(MobileLoginOrForceReg.this.gEt);
                                sVar.lX(MobileLoginOrForceReg.this.gEm);
                                g.Rg().a(sVar, 0);
                                AppMethodBeat.o(125207);
                            }
                        });
                        AppMethodBeat.o(125231);
                        return;
                    }
                    this.gue.b(0, ((s) mVar).ajo(), ((s) mVar).ajn(), "");
                    AppMethodBeat.o(125231);
                    return;
                }
                if (i == 0 && i2 == 0) {
                    final String str7 = this.cFl;
                    Boolean valueOf2 = Boolean.valueOf(this.gEp);
                    this.gBm.daR = (long) this.gEu;
                    this.gBm.cVS = 6;
                    this.gBm.ajK();
                    g.RN();
                    com.tencent.mm.kernel.a.unhold();
                    com.tencent.mm.kernel.a.cm(true);
                    if (valueOf2.booleanValue()) {
                        String str8 = e.euY + "temp.avatar";
                        str2 = e.euY + "temp.avatar.hd";
                        com.tencent.mm.vfs.e.aQ(str8, str2);
                        com.tencent.mm.vfs.e.deleteFile(str8);
                        d.c(str2, 96, 96, CompressFormat.JPEG, 90, str8);
                        com.tencent.mm.ah.m mVar4 = new com.tencent.mm.ah.m(this, e.euY + "temp.avatar");
                        final m mVar5 = mVar;
                        AnonymousClass5 anonymousClass5 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(125208);
                                MobileLoginOrForceReg.this.cxb = ((s) mVar5).ajw();
                                com.tencent.mm.model.av.fly.ak("login_user_name", str7);
                                com.tencent.mm.vfs.e.deleteFile(e.euY + "temp.avatar");
                                Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(MobileLoginOrForceReg.this);
                                bh.addFlags(67108864);
                                MobileLoginOrForceReg.this.startActivity(bh);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.RN();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                                g.RN();
                                a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",4").toString());
                                MobileLoginOrForceReg.this.finish();
                                AppMethodBeat.o(125208);
                            }
                        };
                        mVar5 = mVar;
                        mVar4.a(anonymousClass5, new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(125209);
                                MobileLoginOrForceReg.this.cxb = ((s) mVar5).ajw();
                                com.tencent.mm.model.av.fly.ak("login_user_name", str7);
                                Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(MobileLoginOrForceReg.this);
                                bh.addFlags(67108864);
                                MobileLoginOrForceReg.this.startActivity(bh);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.RN();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                                g.RN();
                                a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",4").toString());
                                MobileLoginOrForceReg.this.finish();
                                AppMethodBeat.o(125209);
                            }
                        });
                    } else {
                        this.cxb = ((s) mVar).ajw();
                        com.tencent.mm.model.av.fly.ak("login_user_name", str7);
                        Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
                        bh.addFlags(67108864);
                        bh.putExtra("LauncherUI.enter_from_reg", true);
                        startActivity(bh);
                        finish();
                        a.wA("RE900_100");
                        StringBuilder stringBuilder = new StringBuilder();
                        g.RN();
                        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                        g.RN();
                        a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",4").toString());
                    }
                }
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this, null, null);
                    AppMethodBeat.o(125231);
                    return;
                }
            }
            if (!this.gCd.a(this, new ag(i, i2, str))) {
                obj = null;
                switch (i2) {
                    case -140:
                        if (!bo.isNullOrNil(this.cOG)) {
                            z.o(this.mController.ylL, str, this.cOG);
                        }
                        obj = 1;
                        break;
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                        g.RN();
                        com.tencent.mm.kernel.a.hold();
                        Context context = this.mController.ylL;
                        g.RN();
                        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QH())) {
                            str2 = com.tencent.mm.bz.a.an(this.mController.ylL, R.string.cvw);
                        } else {
                            g.RN();
                            str2 = com.tencent.mm.kernel.a.QH();
                        }
                        h.a(context, str2, this.mController.ylL.getString(R.string.tz), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        obj = 1;
                        break;
                    case -75:
                        h.g(this, R.string.fn, R.string.djw);
                        obj = 1;
                        break;
                    case -43:
                        Toast.makeText(this, R.string.a6h, 0).show();
                        obj = 1;
                        break;
                    case -41:
                        Toast.makeText(this, R.string.a6j, 0).show();
                        obj = 1;
                        break;
                    case -36:
                        Toast.makeText(this, R.string.a6m, 0).show();
                        obj = 1;
                        break;
                    case -34:
                        Toast.makeText(this, R.string.a6k, 0).show();
                        obj = 1;
                        break;
                    case -33:
                        h.a((Context) this, (int) R.string.a7s, (int) R.string.a7y, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        obj = 1;
                        break;
                    case -32:
                        h.a(this, getString(R.string.a7u), "", new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        obj = 1;
                        break;
                }
            }
            obj = 1;
            if (obj != null) {
                AppMethodBeat.o(125231);
                return;
            }
            if (mVar.getType() == 252 || mVar.getType() == 701) {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null && jY.a(this.mController.ylL, null, null)) {
                    AppMethodBeat.o(125231);
                    return;
                }
            }
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this.mController.ylL, getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.o(125231);
        } else if (i2 == -6 || i2 == -311 || i2 == -310) {
            this.gBT.account = this.username;
            this.gBT.gCK = this.gEr;
            this.gBT.guh = ((q) mVar).ajn();
            this.gBT.gug = ((q) mVar).ajo();
            this.gBT.gui = ((q) mVar).ajp();
            this.gBT.gCL = ((q) mVar).getSecCodeType();
            if (this.gue == null) {
                this.gue = SecurityImage.a.a(this, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125219);
                        ab.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.this.gBT.guh + " img len" + MobileLoginOrForceReg.this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                        final m qVar = new q(MobileLoginOrForceReg.this.gBT.account, MobileLoginOrForceReg.this.gBT.gCK, MobileLoginOrForceReg.this.gBT.gCL, MobileLoginOrForceReg.this.gue.getSecImgCode(), MobileLoginOrForceReg.this.gue.getSecImgSid(), MobileLoginOrForceReg.this.gue.getSecImgEncryptKey(), 1, "", false, true);
                        g.Rg().a(qVar, 0);
                        Context context = MobileLoginOrForceReg.this;
                        MobileLoginOrForceReg.this.getString(R.string.tz);
                        h.b(context, MobileLoginOrForceReg.this.getString(R.string.cou), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(125218);
                                g.Rg().c(qVar);
                                AppMethodBeat.o(125218);
                            }
                        });
                        AppMethodBeat.o(125219);
                    }
                }, null, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125220);
                        MobileLoginOrForceReg.this.gue = null;
                        AppMethodBeat.o(125220);
                    }
                }, this.gBT);
                AppMethodBeat.o(125231);
                return;
            }
            this.gue.b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
            AppMethodBeat.o(125231);
        } else {
            this.cOG = ((q) mVar).ajm();
            this.gDu.a(this, i, i2, str, mVar);
            if (mVar instanceof q) {
                this.gEo = ((q) mVar).ajv();
            }
            if (i == 0 && i2 == 0) {
                final m rVar = new r(1);
                g.Rg().a(rVar, 0);
                getString(R.string.tz);
                this.ehJ = h.b((Context) this, getString(R.string.rd), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125221);
                        g.Rg().c(rVar);
                        AppMethodBeat.o(125221);
                    }
                });
                if (!bo.isNullOrNil(this.gEt)) {
                    g.RP().Ry().set(ac.a.USERINFO_LOGIN_SHOW_BIND_THIRD_ADD_TYPE_INT, Integer.valueOf(this.gEu));
                }
            }
            AppMethodBeat.o(125231);
        }
    }

    static /* synthetic */ void o(MobileLoginOrForceReg mobileLoginOrForceReg) {
        AppMethodBeat.i(125232);
        final m sVar = new s("", mobileLoginOrForceReg.gEr, mobileLoginOrForceReg.gEq, 0, "", mobileLoginOrForceReg.cFl, "", "", mobileLoginOrForceReg.cxb, mobileLoginOrForceReg.fPA, "", "", "", true, mobileLoginOrForceReg.gEp);
        sVar.ts(mobileLoginOrForceReg.gDy);
        sVar.tt(mobileLoginOrForceReg.gEt);
        sVar.lX(mobileLoginOrForceReg.gEm);
        g.Rg().a(sVar, 0);
        Context context = mobileLoginOrForceReg.mController.ylL;
        mobileLoginOrForceReg.getString(R.string.tz);
        mobileLoginOrForceReg.ehJ = h.b(context, mobileLoginOrForceReg.getString(R.string.dmm), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(125210);
                g.Rg().c(sVar);
                AppMethodBeat.o(125210);
            }
        });
        AppMethodBeat.o(125232);
    }
}
