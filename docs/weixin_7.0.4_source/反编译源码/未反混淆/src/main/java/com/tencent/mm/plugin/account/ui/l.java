package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class l implements f, b {
    String account;
    private String cOG;
    private String gCZ;
    private boolean gCm = true;
    private String gDC;
    MobileInputUI gDo;
    SecurityImage gue = null;
    private String gzO;

    static /* synthetic */ void a(l lVar, String str, String str2) {
        AppMethodBeat.i(125156);
        lVar.bk(str, str2);
        AppMethodBeat.o(125156);
    }

    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125148);
        this.gDo = mobileInputUI;
        mobileInputUI.gDP.setVisibility(0);
        this.account = mobileInputUI.getIntent().getStringExtra("binded_mobile");
        if (bo.isNullOrNil(this.account)) {
            this.account = av.amN(mobileInputUI.gDU + mobileInputUI.gDV);
        }
        mobileInputUI.gDI.setTextColor(mobileInputUI.getResources().getColor(R.color.s0));
        mobileInputUI.gDI.setEnabled(false);
        mobileInputUI.gDI.setFocusable(false);
        mobileInputUI.gDH.setFocusable(false);
        mobileInputUI.gDH.setText(av.amN(this.account));
        mobileInputUI.gDH.setVisibility(0);
        ard();
        mobileInputUI.gDR.setVisibility(0);
        mobileInputUI.gDN.setText(R.string.com);
        mobileInputUI.gDN.setVisibility(0);
        mobileInputUI.gDN.setEnabled(true);
        this.gCZ = com.tencent.mm.model.av.fly.T("login_weixin_username", "");
        this.gzO = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!bo.isNullOrNil(this.gzO)) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125133);
                    l.a(l.this, f.ara(), f.arb());
                    AppMethodBeat.o(125133);
                }
            }, 500);
        }
        AppMethodBeat.o(125148);
    }

    private void ard() {
        AppMethodBeat.i(125149);
        if (this.gDo.flQ == 6) {
            this.gDo.gDJ.reset();
            this.gDo.gDR.setText(R.string.coq);
            this.gDo.gCV.setVisibility(8);
            this.gDo.gDJ.setVisibility(0);
            this.gDo.gDJ.getContentEditText().requestFocus();
            this.gDo.gDJ.setSendSmsBtnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125141);
                    h.a(l.this.gDo, l.this.gDo.getString(R.string.dm4) + l.this.account, l.this.gDo.getString(R.string.dm5), l.this.gDo.getString(R.string.s6), l.this.gDo.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125139);
                            l.this.gDo.gDJ.dzH();
                            l.a(l.this, l.this.account);
                            AppMethodBeat.o(125139);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125140);
                            l.this.gDo.gDJ.reset();
                            AppMethodBeat.o(125140);
                        }
                    });
                    AppMethodBeat.o(125141);
                }
            });
            this.gDo.gDR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125142);
                    l.this.gDo.gCr[1] = 2;
                    l.this.gDo.flQ = 7;
                    l.this.gDo.gDJ.reset();
                    g.Rg().b(145, l.this);
                    l.a(l.this);
                    AppMethodBeat.o(125142);
                }
            });
            AppMethodBeat.o(125149);
            return;
        }
        if (this.gDo.flQ == 7) {
            this.gDo.gDR.setText(R.string.cor);
            this.gDo.gCV.setVisibility(0);
            this.gDo.gBJ.requestFocus();
            this.gDo.gDJ.setVisibility(8);
            this.gDo.gDR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125143);
                    l.this.gDo.gCr[1] = 1;
                    l.this.gDo.flQ = 6;
                    g.Rg().a(145, l.this);
                    l.a(l.this);
                    AppMethodBeat.o(125143);
                }
            });
        }
        AppMethodBeat.o(125149);
    }

    public final void start() {
        AppMethodBeat.i(125150);
        g.Rg().a(252, (f) this);
        g.Rg().a(701, (f) this);
        g.Rg().a(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("L200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("L200_100");
        AppMethodBeat.o(125150);
    }

    public final void stop() {
        AppMethodBeat.i(125151);
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        g.Rg().b(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(a.lF("L200_100")).append(",2").toString());
        AppMethodBeat.o(125151);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(125152);
        switch (aVar) {
            case GoNext:
                this.gDo.aqX();
                this.gDo.gDU = av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDI.getText().toString();
                if (!bo.isNullOrNil(this.gDo.gDU) && !bo.isNullOrNil(this.gDo.gDV)) {
                    if (this.gDo.flQ != 7) {
                        if (this.gDo.flQ == 6) {
                            String trim = this.gDo.gDJ.getText().toString().trim();
                            if (!bo.isNullOrNil(trim)) {
                                this.gDo.aqX();
                                final m aVar2 = new com.tencent.mm.modelfriend.a(this.account, 17, trim, 0, "");
                                g.Rg().a(aVar2, 0);
                                MobileInputUI mobileInputUI = this.gDo;
                                Context context = this.gDo;
                                this.gDo.getString(R.string.tz);
                                mobileInputUI.guc = h.b(context, this.gDo.getString(R.string.a7n), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(125144);
                                        g.Rg().c(aVar2);
                                        AppMethodBeat.o(125144);
                                    }
                                });
                                break;
                            }
                            h.g(this.gDo, R.string.f0v, R.string.cog);
                            AppMethodBeat.o(125152);
                            return;
                        }
                    } else if (bo.isNullOrNil(this.gDC)) {
                        bk(this.account, this.gDo.gBJ.getText().toString());
                        AppMethodBeat.o(125152);
                        return;
                    } else {
                        bk(this.account, this.gDC);
                        AppMethodBeat.o(125152);
                        return;
                    }
                }
                AppMethodBeat.o(125152);
                return;
                break;
        }
        AppMethodBeat.o(125152);
    }

    private void bk(String str, String str2) {
        AppMethodBeat.i(125153);
        if (bo.isNullOrNil(str)) {
            h.g(this.gDo, R.string.f0w, R.string.cog);
            AppMethodBeat.o(125153);
        } else if (bo.isNullOrNil(str2)) {
            h.g(this.gDo, R.string.f0s, R.string.cog);
            AppMethodBeat.o(125153);
        } else {
            this.gDo.gBJ.setText(str2);
            this.gDo.aqX();
            final m qVar = new q(str, str2, null, 1);
            g.Rg().a(qVar, 0);
            MobileInputUI mobileInputUI = this.gDo;
            Context context = this.gDo;
            this.gDo.getString(R.string.tz);
            mobileInputUI.guc = h.b(context, this.gDo.getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125146);
                    g.Rg().c(qVar);
                    AppMethodBeat.o(125146);
                }
            });
            AppMethodBeat.o(125153);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        com.tencent.mm.h.a jY;
        AppMethodBeat.i(125154);
        ab.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if (mVar.getType() == 145) {
            int Ah = ((com.tencent.mm.modelfriend.a) mVar).Ah();
            if (Ah == 16) {
                if (i2 == -41) {
                    this.gDo.gDJ.reset();
                    h.g(this.gDo, R.string.dl6, R.string.dl7);
                    AppMethodBeat.o(125154);
                    return;
                } else if (i2 == -75) {
                    this.gDo.gDJ.reset();
                    h.b(this.gDo, this.gDo.getString(R.string.fm), "", true);
                    AppMethodBeat.o(125154);
                    return;
                } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                    this.gDo.gDJ.reset();
                    z.f(this.gDo, str, 32045);
                    AppMethodBeat.o(125154);
                    return;
                }
            } else if (Ah == 17) {
                if (i == 0 && i2 == 0) {
                    new g(new g.a() {
                        public final void a(ProgressDialog progressDialog) {
                            l.this.gDo.guc = (p) progressDialog;
                        }
                    }, ((com.tencent.mm.modelfriend.a) mVar).getUsername(), ((com.tencent.mm.modelfriend.a) mVar).agf(), this.account).a(this.gDo);
                    AppMethodBeat.o(125154);
                    return;
                } else if (j(i, i2, str)) {
                    AppMethodBeat.o(125154);
                    return;
                } else {
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this.gDo, null, null);
                    }
                }
            }
        } else if (mVar.getType() == 252 || mVar.getType() == 701) {
            this.cOG = ((q) mVar).ajm();
            final f fVar = new f();
            fVar.guh = ((q) mVar).ajn();
            fVar.gug = ((q) mVar).ajo();
            fVar.gui = ((q) mVar).ajp();
            fVar.gCL = ((q) mVar).getSecCodeType();
            fVar.account = ((q) mVar).account;
            fVar.guf = this.gDo.gBJ.getText().toString();
            String ajq;
            if (i2 == -75) {
                z.cu(this.gDo);
                AppMethodBeat.o(125154);
                return;
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                z.f(this.gDo, str, 32045);
                AppMethodBeat.o(125154);
                return;
            } else if (i2 == -217) {
                z.a(this.gDo, e.a((q) mVar), i2);
                AppMethodBeat.o(125154);
                return;
            } else if (i2 == -205) {
                this.gzO = ((q) mVar).agh();
                ajq = ((q) mVar).ajq();
                ab.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bo.anv(this.gzO), ((q) mVar).ajt());
                f.a(fVar);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.gzO);
                intent.putExtra("binded_mobile", ajq);
                intent.putExtra("close_safe_device_style", r3);
                intent.putExtra("from_source", 6);
                com.tencent.mm.plugin.account.a.a.gkE.g(this.gDo, intent);
                AppMethodBeat.o(125154);
                return;
            } else if (i2 == -140) {
                if (!bo.isNullOrNil(this.cOG)) {
                    z.o(this.gDo, str, this.cOG);
                }
                AppMethodBeat.o(125154);
                return;
            } else {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    g.Rg().a(new bk(new bk.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            AppMethodBeat.i(125147);
                            if (eVar == null) {
                                AppMethodBeat.o(125147);
                                return;
                            }
                            c adg = eVar.adg();
                            byte[] bArr = new byte[0];
                            byte[] bArr2 = new byte[0];
                            byte[] bArr3 = new byte[0];
                            g.RN();
                            adg.a(bArr, bArr2, bArr3, a.QF());
                            AppMethodBeat.o(125147);
                        }
                    }), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    if (this.gue == null) {
                        this.gue = SecurityImage.a.a(this.gDo, fVar.gCL, fVar.gug, fVar.guh, fVar.gui, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125135);
                                ab.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.guh + " img len" + fVar.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                                final m qVar = new q(fVar.account, fVar.guf, fVar.gCL, l.this.gue.getSecImgCode(), l.this.gue.getSecImgSid(), l.this.gue.getSecImgEncryptKey(), 1, "", false, false);
                                g.Rg().a(qVar, 0);
                                MobileInputUI mobileInputUI = l.this.gDo;
                                Context context = l.this.gDo;
                                l.this.gDo.getString(R.string.tz);
                                mobileInputUI.guc = h.b(context, l.this.gDo.getString(R.string.cou), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(125134);
                                        g.Rg().c(qVar);
                                        AppMethodBeat.o(125134);
                                    }
                                });
                                AppMethodBeat.o(125135);
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                l.this.gue = null;
                            }
                        }, fVar);
                        AppMethodBeat.o(125154);
                        return;
                    }
                    ab.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.guh + " img len" + fVar.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                    this.gue.b(fVar.gCL, fVar.gug, fVar.guh, fVar.gui);
                    AppMethodBeat.o(125154);
                    return;
                } else if (z || (i == 0 && i2 == 0)) {
                    g.RN();
                    a.unhold();
                    com.tencent.mm.plugin.account.friend.a.l.apX();
                    ab.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", fVar.account);
                    z.vx(fVar.account);
                    ajq = com.tencent.mm.model.av.fly.T("login_weixin_username", "");
                    w.cm(this.gDo);
                    if (this.gDo.gDa) {
                        bx.fnB.an(this.gCZ, ajq);
                        bx.fnB.g(r.Yz(), r.Zg());
                        com.tencent.mm.plugin.report.service.h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(9), bx.fnB.aau());
                    }
                    z.showAddrBookUploadConfirm(this.gDo, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(125136);
                            ab.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
                            Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(l.this.gDo);
                            bh.addFlags(67108864);
                            l.this.gDo.startActivity(bh);
                            l.this.gDo.finish();
                            AppMethodBeat.o(125136);
                        }
                    }, false, 2);
                    if (this.gDo.flQ == 6) {
                        this.gCm = ((q) mVar).ajv();
                        g.Rg().a(255, (f) this);
                        final m rVar = new com.tencent.mm.modelsimple.r(1);
                        g.Rg().a(rVar, 0);
                        MobileInputUI mobileInputUI = this.gDo;
                        Context context = this.gDo;
                        this.gDo.getString(R.string.tz);
                        mobileInputUI.guc = h.b(context, this.gDo.getString(R.string.rd), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(125137);
                                g.Rg().c(rVar);
                                g.Rg().b(255, l.this);
                                AppMethodBeat.o(125137);
                            }
                        });
                    }
                    AppMethodBeat.o(125154);
                    return;
                } else if (j(i, i2, str)) {
                    AppMethodBeat.o(125154);
                    return;
                } else if (!(i == 0 && i2 == 0)) {
                    Toast.makeText(this.gDo, this.gDo.getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (mVar.getType() == 255) {
            g.Rg().b(255, (f) this);
            if (i2 == -3 && i == 4) {
                MobileInputUI mobileInputUI2 = this.gDo;
                boolean z2 = this.gCm;
                Intent intent2 = new Intent(mobileInputUI2, RegByMobileSetPwdUI.class);
                intent2.putExtra("kintent_hint", mobileInputUI2.getString(R.string.e8s));
                intent2.putExtra("kintent_cancelable", z2);
                mobileInputUI2.startActivity(intent2);
            }
            AppMethodBeat.o(125154);
            return;
        }
        jY = com.tencent.mm.h.a.jY(str);
        if (jY == null || this.gDo == null || !jY.a(this.gDo, null, null)) {
            AppMethodBeat.o(125154);
        } else {
            AppMethodBeat.o(125154);
        }
    }

    private boolean j(int i, int i2, String str) {
        AppMethodBeat.i(125155);
        if (com.tencent.mm.plugin.account.a.a.gkF.a(this.gDo, i, i2, str)) {
            AppMethodBeat.o(125155);
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -140:
                    if (!bo.isNullOrNil(this.cOG)) {
                        z.o(this.gDo, str, this.cOG);
                    }
                    AppMethodBeat.o(125155);
                    return true;
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    String an;
                    g.RN();
                    a.hold();
                    Context context = this.gDo;
                    g.RN();
                    if (TextUtils.isEmpty(a.QH())) {
                        an = com.tencent.mm.bz.a.an(this.gDo, R.string.cvw);
                    } else {
                        g.RN();
                        an = a.QH();
                    }
                    h.a(context, an, this.gDo.getString(R.string.tz), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(125155);
                    return true;
                case -34:
                    Toast.makeText(this.gDo, R.string.a6k, 0).show();
                    AppMethodBeat.o(125155);
                    return true;
                case -33:
                    h.a(this.gDo, (int) R.string.a7s, (int) R.string.a7y, null);
                    AppMethodBeat.o(125155);
                    return true;
                case -32:
                    h.a(this.gDo, (int) R.string.a7u, (int) R.string.a7y, null);
                    AppMethodBeat.o(125155);
                    return true;
                case -9:
                    h.g(this.gDo, R.string.cof, R.string.cog);
                    AppMethodBeat.o(125155);
                    return true;
                case -3:
                    h.g(this.gDo, R.string.be9, R.string.cog);
                    AppMethodBeat.o(125155);
                    return true;
                case -1:
                    if (g.Rg().acS() == 5) {
                        h.g(this.gDo, R.string.d5n, R.string.d5m);
                        AppMethodBeat.o(125155);
                        return true;
                    }
                    AppMethodBeat.o(125155);
                    return false;
            }
        }
        AppMethodBeat.o(125155);
        return false;
    }

    static /* synthetic */ void a(l lVar, String str) {
        AppMethodBeat.i(125157);
        final m aVar = new com.tencent.mm.modelfriend.a(str, 16, "", 0, "");
        g.Rg().a(aVar, 0);
        MobileInputUI mobileInputUI = lVar.gDo;
        Context context = lVar.gDo;
        lVar.gDo.getString(R.string.tz);
        mobileInputUI.guc = h.b(context, lVar.gDo.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(125145);
                g.Rg().c(aVar);
                AppMethodBeat.o(125145);
            }
        });
        AppMethodBeat.o(125157);
    }
}
