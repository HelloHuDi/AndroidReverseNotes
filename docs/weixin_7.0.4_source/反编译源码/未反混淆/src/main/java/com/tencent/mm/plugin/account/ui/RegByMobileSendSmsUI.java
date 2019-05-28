package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.pluginsdk.ui.e.k;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;

public class RegByMobileSendSmsUI extends MMActivity implements f {
    private String bCu;
    private int countDown = 15;
    private String cxb;
    private String gAN = "";
    private ba gBm = new ba();
    private String gDC;
    private g gDu;
    private String gDy = "";
    private int gEs;
    private int gEu;
    private boolean gFM;
    private String gFm;
    private String gGi = "";
    private String gGj = "";
    private ProgressDialog gGk;
    private int gGl;
    private Button gGm;
    private Button gGn;
    private ap gGo;
    private SecurityImage gGp;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegByMobileSendSmsUI() {
        AppMethodBeat.i(125413);
        AppMethodBeat.o(125413);
    }

    static /* synthetic */ void d(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(125424);
        regByMobileSendSmsUI.goBack();
        AppMethodBeat.o(125424);
    }

    static /* synthetic */ void t(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(125427);
        regByMobileSendSmsUI.stopTimer();
        AppMethodBeat.o(125427);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125414);
        super.onCreate(bundle);
        this.gEs = getIntent().getIntExtra("key_reg_style", 1);
        this.gGi = bo.nullAsNil(getIntent().getStringExtra("from_mobile"));
        this.gGj = bo.nullAsNil(getIntent().getStringExtra("to_mobile"));
        this.gAN = bo.nullAsNil(getIntent().getStringExtra("verify_code"));
        this.gDy = bo.nullAsNil(getIntent().getStringExtra("regsession_id"));
        this.gFm = bo.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
        this.bCu = bo.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
        this.gDC = bo.nullAsNil(getIntent().getStringExtra("kintent_password"));
        this.gFM = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        initView();
        AppMethodBeat.o(125414);
    }

    public final void initView() {
        AppMethodBeat.i(125415);
        super.initView();
        ((TextView) findViewById(R.id.dxr)).setText(getString(R.string.dld, new Object[]{this.gGi}));
        ((TextView) findViewById(R.id.dxs)).setText(ww(getString(R.string.dlc, new Object[]{this.gAN})));
        ((TextView) findViewById(R.id.dxt)).setText(ww(getString(R.string.dlf, new Object[]{this.gGj})));
        this.gGm = (Button) findViewById(R.id.dxv);
        this.gGn = (Button) findViewById(R.id.dxw);
        if (bo.Q(this.gGi, this.gGj, this.gAN)) {
            this.gGm.setEnabled(false);
            this.gGn.setEnabled(false);
        } else {
            this.gGn.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125398);
                    RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this);
                    AppMethodBeat.o(125398);
                }
            });
        }
        if (bo.isNullOrNil(q.getSimCountryIso())) {
            this.gGm.setVisibility(8);
        } else {
            this.gGm.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125406);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.this.gGj));
                    intent.putExtra("sms_body", RegByMobileSendSmsUI.this.gAN);
                    try {
                        RegByMobileSendSmsUI.this.startActivity(intent);
                        RegByMobileSendSmsUI.this.overridePendingTransition(R.anim.df, R.anim.dc);
                        AppMethodBeat.o(125406);
                    } catch (Exception e) {
                        ab.e("MicroMsg.RegByMobileSendSmsUI", e.getMessage());
                        AppMethodBeat.o(125406);
                    }
                }
            });
        }
        setMMTitle((int) R.string.dle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125407);
                RegByMobileSendSmsUI.d(RegByMobileSendSmsUI.this);
                AppMethodBeat.o(125407);
                return true;
            }
        });
        AppMethodBeat.o(125415);
    }

    private k ww(String str) {
        AppMethodBeat.i(125416);
        k kVar = new k(str);
        ab.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", str);
        int indexOf = str.indexOf(32) + 1;
        kVar.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.ku)), indexOf, str.length(), 33);
        kVar.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.r8)), indexOf, str.length(), 33);
        AppMethodBeat.o(125416);
        return kVar;
    }

    public final int getLayoutId() {
        return R.layout.ao3;
    }

    public void onResume() {
        AppMethodBeat.i(125417);
        super.onResume();
        g.Rg().a(145, (f) this);
        AppMethodBeat.o(125417);
    }

    public void onStop() {
        AppMethodBeat.i(125418);
        super.onStop();
        stopTimer();
        g.Rg().b(145, (f) this);
        AppMethodBeat.o(125418);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125419);
        ab.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gGk != null) {
            this.gGk.dismiss();
        }
        Intent intent;
        a jY;
        if (mVar.getType() == 145 && ((com.tencent.mm.modelfriend.a) mVar).Ah() == 15) {
            com.tencent.mm.modelfriend.a aVar = (com.tencent.mm.modelfriend.a) mVar;
            this.cxb = aVar.agg();
            if (i2 == 0) {
                stopTimer();
                if (this.gEs == 1) {
                    g.Rg().a(126, (f) this);
                    final m sVar = new s("", this.gDC, this.bCu, 0, "", this.gGi, "", "", this.cxb, 1, "", "", "", true, this.gFM);
                    sVar.ts(this.gDy);
                    sVar.tt(this.gFm);
                    sVar.lX(1);
                    g.Rg().a(sVar, 0);
                    getString(R.string.tz);
                    this.gGk = h.b((Context) this, getString(R.string.dmm), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125408);
                            g.Rg().c(sVar);
                            g.Rg().b(126, RegByMobileSendSmsUI.this);
                            AppMethodBeat.o(125408);
                        }
                    });
                    AppMethodBeat.o(125419);
                    return;
                }
                intent = new Intent();
                intent.putExtra("regsetinfo_ticket", this.cxb);
                intent.putExtra("regsetinfo_user", this.gGi);
                intent.putExtra("regsession_id", this.gDy);
                intent.putExtra("reg_3d_app_ticket", this.gFm);
                intent.putExtra("reg_3d_app_type", this.gEu);
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("regsetinfo_ismobile", 4);
                intent.putExtra("regsetinfo_NextControl", aVar.agm());
                intent.putExtra("key_reg_style", this.gEs);
                intent.setClass(this, RegSetInfoUI.class);
                startActivity(intent);
                AppMethodBeat.o(125419);
                return;
            } else if (i2 == -35) {
                stopTimer();
                jY = a.jY(str);
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 7;
                this.gBm.ajK();
                final com.tencent.mm.modelfriend.a aVar2;
                if (jY != null) {
                    aVar2 = aVar;
                    jY.a(this, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125409);
                            g.Rg().a(701, RegByMobileSendSmsUI.this);
                            g.Rg().a(252, RegByMobileSendSmsUI.this);
                            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, aVar2.getUsername(), aVar2.agf());
                            RegByMobileSendSmsUI.this.gBm.daR = (long) RegByMobileSendSmsUI.this.gEu;
                            RegByMobileSendSmsUI.this.gBm.cVS = 8;
                            RegByMobileSendSmsUI.this.gBm.ajK();
                            AppMethodBeat.o(125409);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(125419);
                    return;
                }
                aVar2 = aVar;
                h.a((Context) this, getString(R.string.a63), null, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125410);
                        RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, aVar2.getUsername(), aVar2.agf());
                        RegByMobileSendSmsUI.this.gBm.daR = (long) RegByMobileSendSmsUI.this.gEu;
                        RegByMobileSendSmsUI.this.gBm.cVS = 8;
                        RegByMobileSendSmsUI.this.gBm.ajK();
                        AppMethodBeat.o(125410);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(125419);
                return;
            } else if (i2 == -212) {
                stopTimer();
                intent = new Intent(this, MobileLoginOrForceReg.class);
                intent.putExtra("ticket", this.cxb);
                intent.putExtra("moble", this.gGi);
                intent.putExtra("regsession_id", this.gDy);
                intent.putExtra("reg_3d_app_ticket", this.gFm);
                intent.putExtra("reg_3d_app_type", this.gEu);
                intent.putExtra("next_controll", aVar.agm());
                intent.putExtra("username", aVar.getUsername());
                intent.putExtra("password", aVar.agf());
                intent.putExtra("nickname", aVar.ags());
                intent.putExtra("avatar_url", aVar.agr());
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("kintent_hasavatar", this.gFM);
                intent.putExtra("kintent_nickname", this.bCu);
                intent.putExtra("kintent_password", this.gDC);
                intent.putExtra("key_reg_style", this.gEs);
                startActivity(intent);
                AppMethodBeat.o(125419);
                return;
            } else {
                if (!bo.isNullOrNil(str) && this.gGl >= 4) {
                    jY = a.jY(str);
                    if (jY != null && jY.a(this, null, null)) {
                        AppMethodBeat.o(125419);
                        return;
                    }
                }
                AppMethodBeat.o(125419);
                return;
            }
        }
        if (mVar.getType() == 126) {
            final s sVar2 = (s) mVar;
            if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.gGp == null) {
                    this.gGp = SecurityImage.a.a(this, 0, sVar2.ajo(), sVar2.ajn(), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125412);
                            final m sVar = new s("", RegByMobileSendSmsUI.this.gDC, RegByMobileSendSmsUI.this.bCu, 0, "", RegByMobileSendSmsUI.this.gGi, "", "", RegByMobileSendSmsUI.this.cxb, 1, "", sVar2.ajn(), RegByMobileSendSmsUI.this.gGp.getSecImgCode(), true, RegByMobileSendSmsUI.this.gFM);
                            sVar.ts(RegByMobileSendSmsUI.this.gDy);
                            sVar.tt(RegByMobileSendSmsUI.this.gFm);
                            sVar.lX(1);
                            g.Rg().a(sVar, 0);
                            RegByMobileSendSmsUI regByMobileSendSmsUI = RegByMobileSendSmsUI.this;
                            Context context = RegByMobileSendSmsUI.this.mController.ylL;
                            RegByMobileSendSmsUI.this.getString(R.string.tz);
                            regByMobileSendSmsUI.gGk = h.b(context, RegByMobileSendSmsUI.this.getString(R.string.dmm), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(125411);
                                    g.Rg().c(sVar);
                                    AppMethodBeat.o(125411);
                                }
                            });
                            AppMethodBeat.o(125412);
                        }
                    }, null, new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125399);
                            RegByMobileSendSmsUI.this.gGp = null;
                            AppMethodBeat.o(125399);
                        }
                    }, new b() {
                        public final void apw() {
                            AppMethodBeat.i(125400);
                            RegByMobileSendSmsUI.this.aqX();
                            m sVar = new s("", RegByMobileSendSmsUI.this.gDC, RegByMobileSendSmsUI.this.bCu, 0, "", RegByMobileSendSmsUI.this.gGi, "", "", RegByMobileSendSmsUI.this.cxb, 1, "", sVar2.ajn(), RegByMobileSendSmsUI.this.gGp.getSecImgCode(), true, RegByMobileSendSmsUI.this.gFM);
                            sVar.ts(RegByMobileSendSmsUI.this.gDy);
                            sVar.tt(RegByMobileSendSmsUI.this.gFm);
                            sVar.lX(1);
                            g.Rg().a(sVar, 0);
                            AppMethodBeat.o(125400);
                        }
                    });
                    AppMethodBeat.o(125419);
                    return;
                }
                this.gGp.b(0, ((s) mVar).ajo(), ((s) mVar).ajn(), "");
                AppMethodBeat.o(125419);
                return;
            } else if (i == 0 && i2 == 0) {
                final String str2 = this.gGi;
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 6;
                this.gBm.ajK();
                com.tencent.mm.kernel.a.unhold();
                com.tencent.mm.kernel.a.cm(true);
                if (this.gFM) {
                    String str3 = e.euY + "temp.avatar";
                    String str4 = e.euY + "temp.avatar.hd";
                    com.tencent.mm.vfs.e.aQ(str3, str4);
                    com.tencent.mm.vfs.e.deleteFile(str3);
                    d.c(str4, 96, 96, CompressFormat.JPEG, 90, str3);
                    new com.tencent.mm.ah.m(this, e.euY + "temp.avatar").a(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(125401);
                            RegByMobileSendSmsUI.this.cxb = sVar2.ajw();
                            av.fly.ak("login_user_name", str2);
                            com.tencent.mm.vfs.e.deleteFile(e.euY + "temp.avatar");
                            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(RegByMobileSendSmsUI.this);
                            bh.addFlags(67108864);
                            RegByMobileSendSmsUI.this.startActivity(bh);
                            StringBuilder stringBuilder = new StringBuilder();
                            g.RN();
                            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                            g.RN();
                            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",4").toString());
                            RegByMobileSendSmsUI.this.finish();
                            AppMethodBeat.o(125401);
                        }
                    }, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(125402);
                            RegByMobileSendSmsUI.this.cxb = sVar2.ajw();
                            av.fly.ak("login_user_name", str2);
                            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(RegByMobileSendSmsUI.this);
                            bh.addFlags(67108864);
                            RegByMobileSendSmsUI.this.startActivity(bh);
                            StringBuilder stringBuilder = new StringBuilder();
                            g.RN();
                            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                            g.RN();
                            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",4").toString());
                            RegByMobileSendSmsUI.this.finish();
                            AppMethodBeat.o(125402);
                        }
                    });
                    AppMethodBeat.o(125419);
                    return;
                }
                this.cxb = sVar2.ajw();
                av.fly.ak("login_user_name", str2);
                intent = com.tencent.mm.plugin.account.a.a.gkE.bh(this);
                intent.addFlags(67108864);
                intent.putExtra("LauncherUI.enter_from_reg", true);
                startActivity(intent);
                finish();
                com.tencent.mm.plugin.b.a.wA("RE900_100");
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                g.RN();
                com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_600")).append(",4").toString());
                AppMethodBeat.o(125419);
                return;
            } else {
                jY = a.jY(str);
                if (jY != null) {
                    jY.a(this, null, null);
                    AppMethodBeat.o(125419);
                    return;
                }
            }
        }
        AppMethodBeat.o(125419);
    }

    private void stopTimer() {
        AppMethodBeat.i(125420);
        if (this.gGo != null) {
            this.gGo.stopTimer();
        }
        this.gGn.setText(R.string.dl8);
        this.gGn.setEnabled(true);
        AppMethodBeat.o(125420);
    }

    private void goBack() {
        AppMethodBeat.i(125421);
        h.a((Context) this, getString(R.string.dl_), "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(125405);
                RegByMobileSendSmsUI.t(RegByMobileSendSmsUI.this);
                RegByMobileSendSmsUI.this.finish();
                AppMethodBeat.o(125405);
            }
        }, null);
        AppMethodBeat.o(125421);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125422);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(125422);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125422);
        return onKeyDown;
    }

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(125423);
        regByMobileSendSmsUI.gGn.setEnabled(false);
        if (regByMobileSendSmsUI.gGo != null) {
            regByMobileSendSmsUI.gGo.stopTimer();
            regByMobileSendSmsUI.countDown = 15;
            regByMobileSendSmsUI.gGl = 0;
            regByMobileSendSmsUI.gGo.ae(0, 1000);
            AppMethodBeat.o(125423);
            return;
        }
        regByMobileSendSmsUI.gGo = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(125404);
                if (RegByMobileSendSmsUI.this.countDown > 0) {
                    RegByMobileSendSmsUI.this.gGn.setText(RegByMobileSendSmsUI.this.getString(R.string.dlh, new Object[]{Integer.valueOf(RegByMobileSendSmsUI.this.countDown)}));
                    RegByMobileSendSmsUI.this.countDown = RegByMobileSendSmsUI.this.countDown - 1;
                    if (RegByMobileSendSmsUI.this.countDown % 4 == 0) {
                        RegByMobileSendSmsUI.s(RegByMobileSendSmsUI.this);
                    }
                    AppMethodBeat.o(125404);
                    return true;
                }
                RegByMobileSendSmsUI.this.gGn.setText(R.string.dl8);
                RegByMobileSendSmsUI.this.gGn.setEnabled(true);
                AppMethodBeat.o(125404);
                return false;
            }
        }, true);
        regByMobileSendSmsUI.gGo.ae(0, 1000);
        AppMethodBeat.o(125423);
    }

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI, String str, String str2) {
        AppMethodBeat.i(125425);
        g.Rg().a(701, (f) regByMobileSendSmsUI);
        g.Rg().a(252, (f) regByMobileSendSmsUI);
        regByMobileSendSmsUI.gDu = new g(new g.a() {
            public final void a(ProgressDialog progressDialog) {
                AppMethodBeat.i(125403);
                RegByMobileSendSmsUI.this.gGk = progressDialog;
                AppMethodBeat.o(125403);
            }
        }, str, str2, regByMobileSendSmsUI.gGi);
        regByMobileSendSmsUI.gDu.a(regByMobileSendSmsUI);
        AppMethodBeat.o(125425);
    }

    static /* synthetic */ void s(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.i(125426);
        regByMobileSendSmsUI.gGl++;
        if (regByMobileSendSmsUI.gGl <= 4) {
            m aVar = new com.tencent.mm.modelfriend.a(regByMobileSendSmsUI.gGi, 15, "", 0, "");
            ((n.a) aVar.ftU.acF()).vyq.vLC = 1;
            g.Rg().a(aVar, 0);
        }
        AppMethodBeat.o(125426);
    }
}
