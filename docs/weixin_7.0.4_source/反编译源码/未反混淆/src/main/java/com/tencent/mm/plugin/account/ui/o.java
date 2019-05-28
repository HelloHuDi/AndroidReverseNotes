package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.j.a;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class o implements f, b {
    String elr;
    ba gBm = new ba();
    g gDu = null;
    MobileVerifyUI gEE;
    String gEK;
    private boolean gEL = true;

    public o() {
        AppMethodBeat.i(125263);
        AppMethodBeat.o(125263);
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.gEE = mobileVerifyUI;
    }

    public final void start() {
        AppMethodBeat.i(125264);
        g.Rg().a(126, (f) this);
        AppMethodBeat.o(125264);
    }

    public final void stop() {
        AppMethodBeat.i(125265);
        g.Rg().b(126, (f) this);
        AppMethodBeat.o(125265);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(125266);
        final m aVar2;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (aVar) {
            case GoBack:
                h.d(this.gEE, this.gEE.getString(R.string.d0q), "", this.gEE.getString(R.string.d0r), this.gEE.getString(R.string.d0s), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(125258);
                        o.this.gEE.finish();
                        j.a(a.NONE);
                        AppMethodBeat.o(125258);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(125266);
                return true;
            case GoNext:
                g.Rg().a(145, (f) this);
                aVar2 = new com.tencent.mm.modelfriend.a(this.gEE.cFl, 15, this.gEE.grL.getText().toString().trim(), 0, "");
                aVar2.rV(this.gEE.gDy);
                g.Rg().a(aVar2, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(R.string.tz);
                mobileVerifyUI.ehJ = h.b(context, this.gEE.getString(R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125259);
                        g.Rg().c(aVar2);
                        g.Rg().b(145, o.this);
                        AppMethodBeat.o(125259);
                    }
                });
                break;
            case DoSend:
                g.Rg().a(145, (f) this);
                aVar2 = new com.tencent.mm.modelfriend.a(this.gEE.cFl, 14, "", 0, "");
                aVar2.rV(this.gEE.gDy);
                g.Rg().a(aVar2, 0);
                j.a(a.SENT);
                break;
            case DoProcessSMS:
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",R200_350_auto,");
                g.RN();
                com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_350_auto")).append(",1").toString());
                g.Rg().a(145, (f) this);
                aVar2 = new com.tencent.mm.modelfriend.a(this.gEE.cFl, 15, this.gEE.grL.getText().toString().trim(), 0, "");
                aVar2.rV(this.gEE.gDy);
                g.Rg().a(aVar2, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(R.string.tz);
                mobileVerifyUI.ehJ = h.b(context, this.gEE.getString(R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125250);
                        g.Rg().c(aVar2);
                        g.Rg().b(145, o.this);
                        AppMethodBeat.o(125250);
                    }
                });
                break;
        }
        AppMethodBeat.o(125266);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:95:0x064c  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x05a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125267);
        ab.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gEE.ehJ != null) {
            this.gEE.ehJ.dismiss();
            this.gEE.ehJ = null;
        }
        final m rVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        if (mVar.getType() == 255) {
            g.Rg().b(255, (f) this);
            if (i2 == -3 && i == 4) {
                this.gEE.dq(this.gEL);
            }
            AppMethodBeat.o(125267);
        } else if ((mVar.getType() == 701 || mVar.getType() == 701) && this.gDu != null) {
            g.Rg().b(701, (f) this);
            g.Rg().b(252, (f) this);
            this.gDu.a(this.gEE, i, i2, str, mVar);
            if (i == 0 && i2 == 0) {
                if (mVar instanceof q) {
                    this.gEL = ((q) mVar).ajv();
                }
                g.Rg().a(255, (f) this);
                rVar = new r(1);
                g.Rg().a(rVar, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(R.string.tz);
                mobileVerifyUI.ehJ = h.b(context, this.gEE.getString(R.string.rd), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125260);
                        g.Rg().c(rVar);
                        AppMethodBeat.o(125260);
                    }
                });
            }
            AppMethodBeat.o(125267);
        } else {
            com.tencent.mm.h.a jY;
            int Ah;
            Intent intent;
            if (mVar.getType() == 145) {
                g.Rg().b(145, (f) this);
                Ah = ((com.tencent.mm.modelfriend.a) mVar).Ah();
                if (Ah != 15) {
                    AppMethodBeat.o(125267);
                    return;
                } else if (i == 0 && i2 == 0) {
                    if (Ah == 15) {
                        if (this.gEE.gEs == 1) {
                            this.gEK = ((com.tencent.mm.modelfriend.a) mVar).agg();
                            g.Rg().a(126, (f) this);
                            rVar = new s("", this.gEE.gEk, this.gEE.bCu, 0, "", this.gEE.cFl, "", "", this.gEK, this.gEE.fPA, "", "", "", true, this.gEE.gFf.booleanValue());
                            rVar.ts(this.gEE.gDy);
                            rVar.tt(this.gEE.gFm);
                            g.Rg().a(rVar, 0);
                            mobileVerifyUI = this.gEE;
                            context = this.gEE;
                            this.gEE.getString(R.string.tz);
                            mobileVerifyUI.ehJ = h.b(context, this.gEE.getString(R.string.dmm), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(125256);
                                    g.Rg().c(rVar);
                                    g.Rg().b(126, o.this);
                                    AppMethodBeat.o(125256);
                                }
                            });
                            AppMethodBeat.o(125267);
                            return;
                        }
                        intent = new Intent();
                        intent.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a) mVar).agg());
                        intent.putExtra("regsetinfo_user", this.gEE.cFl);
                        intent.putExtra("regsession_id", this.gEE.gDy);
                        intent.putExtra("reg_3d_app_ticket", this.gEE.gFm);
                        intent.putExtra("reg_3d_app_type", this.gEE.gEu);
                        intent.putExtra("regsetinfo_ismobile", 4);
                        intent.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a) mVar).agm());
                        intent.putExtra("key_reg_style", this.gEE.gEs);
                        intent.setClass(this.gEE, RegSetInfoUI.class);
                        this.gEE.startActivity(intent);
                        j.a(a.VERIFIED);
                    }
                    AppMethodBeat.o(125267);
                    return;
                } else if (i2 == -35) {
                    jY = com.tencent.mm.h.a.jY(str);
                    this.gBm.daR = (long) this.gEE.gEu;
                    this.gBm.cVS = 7;
                    this.gBm.ajK();
                    final m mVar2;
                    if (jY != null) {
                        mVar2 = mVar;
                        jY.a(this.gEE, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125261);
                                g.Rg().a(701, o.this);
                                g.Rg().a(252, o.this);
                                o.this.gDu = new g(new g.a() {
                                    public final void a(ProgressDialog progressDialog) {
                                        o.this.gEE.ehJ = progressDialog;
                                    }
                                }, ((com.tencent.mm.modelfriend.a) mVar2).getUsername(), ((com.tencent.mm.modelfriend.a) mVar2).agf(), o.this.gEE.cFl);
                                o.this.gDu.a(o.this.gEE);
                                o.this.gBm.daR = (long) o.this.gEE.gEu;
                                o.this.gBm.cVS = 8;
                                o.this.gBm.ajK();
                                AppMethodBeat.o(125261);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(125267);
                        return;
                    }
                    mVar2 = mVar;
                    h.a(this.gEE, this.gEE.getString(R.string.a63), null, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125262);
                            g.Rg().a(701, o.this);
                            g.Rg().a(252, o.this);
                            o.this.gDu = new g(new g.a() {
                                public final void a(ProgressDialog progressDialog) {
                                    o.this.gEE.ehJ = progressDialog;
                                }
                            }, ((com.tencent.mm.modelfriend.a) mVar2).getUsername(), ((com.tencent.mm.modelfriend.a) mVar2).agf(), o.this.gEE.cFl);
                            o.this.gDu.a(o.this.gEE);
                            o.this.gBm.daR = (long) o.this.gEE.gEu;
                            o.this.gBm.cVS = 8;
                            o.this.gBm.ajK();
                            AppMethodBeat.o(125262);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(125267);
                    return;
                } else if (i2 == -212) {
                    intent = new Intent(this.gEE, MobileLoginOrForceReg.class);
                    intent.putExtra("ticket", ((com.tencent.mm.modelfriend.a) mVar).agg());
                    intent.putExtra("moble", this.gEE.cFl);
                    intent.putExtra("regsession_id", this.gEE.gDy);
                    intent.putExtra("reg_3d_app_ticket", this.gEE.gFm);
                    intent.putExtra("reg_3d_app_type", this.gEE.gEu);
                    intent.putExtra("next_controll", ((com.tencent.mm.modelfriend.a) mVar).agm());
                    intent.putExtra("username", ((com.tencent.mm.modelfriend.a) mVar).getUsername());
                    intent.putExtra("password", ((com.tencent.mm.modelfriend.a) mVar).agf());
                    intent.putExtra("nickname", ((com.tencent.mm.modelfriend.a) mVar).ags());
                    intent.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a) mVar).agr());
                    intent.putExtra("key_reg_style", this.gEE.gEs);
                    if (this.gEE.gEs == 1) {
                        intent.putExtra("kintent_nickname", this.gEE.bCu);
                        intent.putExtra("kintent_password", this.gEE.gEk);
                        intent.putExtra("kintent_hasavatar", this.gEE.gFf);
                    }
                    this.gEE.startActivity(intent);
                    AppMethodBeat.o(125267);
                    return;
                } else if (i2 == -51) {
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this.gEE, null, null);
                        AppMethodBeat.o(125267);
                        return;
                    }
                    h.g(this.gEE, R.string.a7s, R.string.a7y);
                    AppMethodBeat.o(125267);
                    return;
                }
            } else if (mVar.getType() == 126) {
                final String str2;
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean bool = this.gEE.gFf;
                    final String str3 = this.gEE.gEk;
                    str2 = this.gEE.bCu;
                    if (this.gEE.gue == null) {
                        final m mVar3 = mVar;
                        final String str4 = str3;
                        final String str5 = str2;
                        final m mVar4 = mVar;
                        final Boolean bool2 = bool;
                        this.gEE.gue = SecurityImage.a.a(this.gEE, 0, ((s) mVar).ajo(), ((s) mVar).ajn(), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125252);
                                g.Rg().a(126, o.this);
                                final m sVar = new s("", str3, str2, 0, "", o.this.gEE.cFl, "", "", o.this.gEK, o.this.gEE.fPA, "", ((s) mVar3).ajn(), o.this.gEE.gue.getSecImgCode(), true, bool.booleanValue());
                                sVar.ts(o.this.gEE.gDy);
                                sVar.tt(o.this.gEE.gFm);
                                g.Rg().a(sVar, 0);
                                MobileVerifyUI mobileVerifyUI = o.this.gEE;
                                Context context = o.this.gEE;
                                o.this.gEE.getString(R.string.tz);
                                mobileVerifyUI.ehJ = h.b(context, o.this.gEE.getString(R.string.dmm), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(125251);
                                        g.Rg().c(sVar);
                                        g.Rg().b(126, o.this);
                                        AppMethodBeat.o(125251);
                                    }
                                });
                                AppMethodBeat.o(125252);
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                o.this.gEE.gue = null;
                            }
                        }, new SecurityImage.b() {
                            public final void apw() {
                                AppMethodBeat.i(125253);
                                o.this.gEE.aqX();
                                g.Rg().a(126, o.this);
                                m sVar = new s("", str4, str5, 0, "", o.this.gEE.cFl, "", "", o.this.gEK, o.this.gEE.fPA, "", ((s) mVar4).ajn(), "", true, bool2.booleanValue());
                                sVar.ts(o.this.gEE.gDy);
                                sVar.tt(o.this.gEE.gFm);
                                g.Rg().a(sVar, 0);
                                AppMethodBeat.o(125253);
                            }
                        });
                        AppMethodBeat.o(125267);
                        return;
                    }
                    this.gEE.gue.b(0, ((s) mVar).ajo(), ((s) mVar).ajn(), "");
                    AppMethodBeat.o(125267);
                    return;
                }
                if (i == 0 && i2 == 0) {
                    String str6;
                    final String str7;
                    final String str8 = this.gEE.cFl;
                    Boolean bool3 = this.gEE.gFf;
                    this.gBm.daR = (long) this.gEE.gEu;
                    this.gBm.cVS = 6;
                    this.gBm.ajK();
                    int ajx = ((s) mVar).ajx();
                    final String ajy = ((s) mVar).ajy();
                    final int ajz = ((s) mVar).ajz();
                    String str9 = null;
                    String str10 = null;
                    boolean z = false;
                    Map z2 = br.z(((s) mVar).ajA(), "wording");
                    if (z2 != null) {
                        String str11 = (String) z2.get(".wording.switch");
                        if (bo.isNullOrNil(str11)) {
                            z = true;
                        } else {
                            Ah = bo.ank(str11);
                            if (Ah == 0) {
                                z = false;
                            } else if (Ah == 1) {
                                z = true;
                            }
                        }
                        if (z) {
                            str11 = (String) z2.get(".wording.title");
                            if (!bo.isNullOrNil(str11)) {
                                str9 = str11;
                            }
                            str11 = (String) z2.get(".wording.desc");
                            if (bo.isNullOrNil(str11)) {
                                str6 = str9;
                            } else {
                                str10 = str11;
                                str6 = str9;
                            }
                            ab.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                            ab.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(ajx));
                            ab.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", ajy);
                            ab.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(ajz));
                            ab.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str7);
                            com.tencent.mm.kernel.a.unhold();
                            com.tencent.mm.kernel.a.cm(true);
                            if (bool3.booleanValue()) {
                                Intent intent2;
                                this.elr = ((s) mVar).ajw();
                                av.fly.ak("login_user_name", str8);
                                if (ajy != null) {
                                    if (ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        com.tencent.mm.plugin.b.a.wA("R300_100_phone");
                                        if (z) {
                                            intent2 = new Intent(this.gEE, FindMContactAlertUI.class);
                                            intent2.putExtra("alert_title", str6);
                                            intent2.putExtra("alert_message", str10);
                                        } else {
                                            intent2 = new Intent(this.gEE, FindMContactIntroUI.class);
                                        }
                                        intent2.addFlags(67108864);
                                        intent2.putExtra("regsetinfo_ticket", this.elr);
                                        intent2.putExtra("regsetinfo_NextStep", ajy);
                                        intent2.putExtra("regsetinfo_NextStyle", ajz);
                                        intent = com.tencent.mm.plugin.account.a.a.gkE.bh(this.gEE);
                                        intent.addFlags(67108864);
                                        intent.putExtra("LauncherUI.enter_from_reg", true);
                                        MMWizardActivity.b(this.gEE, intent2, intent);
                                        this.gEE.finish();
                                    }
                                }
                                intent2 = com.tencent.mm.plugin.account.a.a.gkE.bh(this.gEE);
                                intent2.addFlags(67108864);
                                intent2.putExtra("LauncherUI.enter_from_reg", true);
                                this.gEE.startActivity(intent2);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.RN();
                                stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(this.gEE.getClass().getName()).append(",R200_900_phone,");
                                g.RN();
                                com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",4").toString());
                                this.gEE.finish();
                            } else {
                                String str12 = e.euY + "temp.avatar";
                                str11 = e.euY + "temp.avatar.hd";
                                com.tencent.mm.vfs.e.aQ(str12, str11);
                                com.tencent.mm.vfs.e.deleteFile(str12);
                                d.c(str11, 96, 96, CompressFormat.JPEG, 90, str12);
                                final m mVar5 = mVar;
                                str2 = str8;
                                str7 = ajy;
                                final boolean z3 = z;
                                final m mVar6 = mVar;
                                final String str13 = str6;
                                final String str14 = str10;
                                final int i3 = ajz;
                                new com.tencent.mm.ah.m(this.gEE, e.euY + "temp.avatar").a(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(125254);
                                        o.this.elr = ((s) mVar5).ajw();
                                        av.fly.ak("login_user_name", str2);
                                        com.tencent.mm.vfs.e.deleteFile(e.euY + "temp.avatar");
                                        Intent bh;
                                        if (str7 == null || !str7.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                            bh = com.tencent.mm.plugin.account.a.a.gkE.bh(o.this.gEE);
                                            bh.addFlags(67108864);
                                            o.this.gEE.startActivity(bh);
                                            StringBuilder stringBuilder = new StringBuilder();
                                            g.RN();
                                            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(o.this.gEE.getClass().getName()).append(",R200_900_phone,");
                                            g.RN();
                                            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",4").toString());
                                            o.this.gEE.finish();
                                            AppMethodBeat.o(125254);
                                            return;
                                        }
                                        com.tencent.mm.plugin.b.a.wA("R300_100_phone");
                                        if (z3) {
                                            bh = new Intent(o.this.gEE, FindMContactAlertUI.class);
                                            bh.putExtra("alert_title", str6);
                                            bh.putExtra("alert_message", str10);
                                        } else {
                                            bh = new Intent(o.this.gEE, FindMContactIntroUI.class);
                                        }
                                        bh.addFlags(67108864);
                                        bh.putExtra("regsetinfo_ticket", o.this.elr);
                                        bh.putExtra("regsetinfo_NextStep", str7);
                                        bh.putExtra("regsetinfo_NextStyle", ajz);
                                        Intent bh2 = com.tencent.mm.plugin.account.a.a.gkE.bh(o.this.gEE);
                                        bh2.addFlags(67108864);
                                        MMWizardActivity.b(o.this.gEE, bh, bh2);
                                        o.this.gEE.finish();
                                        AppMethodBeat.o(125254);
                                    }
                                }, new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(125255);
                                        o.this.elr = ((s) mVar6).ajw();
                                        av.fly.ak("login_user_name", str8);
                                        Intent bh;
                                        if (ajy == null || !ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                            bh = com.tencent.mm.plugin.account.a.a.gkE.bh(o.this.gEE);
                                            bh.addFlags(67108864);
                                            o.this.gEE.startActivity(bh);
                                            StringBuilder stringBuilder = new StringBuilder();
                                            g.RN();
                                            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(o.this.gEE.getClass().getName()).append(",R200_900_phone,");
                                            g.RN();
                                            com.tencent.mm.plugin.b.a.wB(stringBuilder.append(com.tencent.mm.kernel.a.lF("R200_900_phone")).append(",4").toString());
                                            o.this.gEE.finish();
                                            AppMethodBeat.o(125255);
                                            return;
                                        }
                                        com.tencent.mm.plugin.b.a.wA("R300_100_phone");
                                        if (z) {
                                            bh = new Intent(o.this.gEE, FindMContactAlertUI.class);
                                            bh.putExtra("alert_title", str13);
                                            bh.putExtra("alert_message", str14);
                                        } else {
                                            bh = new Intent(o.this.gEE, FindMContactIntroUI.class);
                                        }
                                        bh.addFlags(67108864);
                                        bh.putExtra("regsetinfo_ticket", o.this.elr);
                                        bh.putExtra("regsetinfo_NextStep", ajy);
                                        bh.putExtra("regsetinfo_NextStyle", i3);
                                        Intent bh2 = com.tencent.mm.plugin.account.a.a.gkE.bh(o.this.gEE);
                                        bh2.addFlags(67108864);
                                        MMWizardActivity.b(o.this.gEE, bh, bh2);
                                        o.this.gEE.finish();
                                        AppMethodBeat.o(125255);
                                    }
                                });
                            }
                        }
                    }
                    str6 = null;
                    ab.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                    ab.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(ajx));
                    ab.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", ajy);
                    ab.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(ajz));
                    ab.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str7);
                    com.tencent.mm.kernel.a.unhold();
                    com.tencent.mm.kernel.a.cm(true);
                    if (bool3.booleanValue()) {
                    }
                }
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this.gEE, null, null);
                    AppMethodBeat.o(125267);
                    return;
                }
            }
            if (this.gEE.j(i, i2, str)) {
                AppMethodBeat.o(125267);
                return;
            }
            if (mVar.getType() == 252 || mVar.getType() == 701) {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null && jY.a(this.gEE, null, null)) {
                    AppMethodBeat.o(125267);
                    return;
                }
            }
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this.gEE, this.gEE.getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.o(125267);
        }
    }
}
