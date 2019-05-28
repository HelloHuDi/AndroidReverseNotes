package com.tencent.p177mm.plugin.account.p275ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelsimple.C26472s;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p182ah.C37439m;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.bind.p271ui.FindMContactAlertUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.FindMContactIntroUI;
import com.tencent.p177mm.plugin.account.model.C32978j;
import com.tencent.p177mm.plugin.account.model.C32978j.C32982a;
import com.tencent.p177mm.plugin.account.p275ui.C10004g.C10008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileVerifyUI.C7703b;
import com.tencent.p177mm.plugin.account.p275ui.MobileVerifyUI.C7711a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.ui.o */
public final class C26672o implements C1202f, C7703b {
    String elr;
    C42085ba gBm = new C42085ba();
    C10004g gDu = null;
    MobileVerifyUI gEE;
    String gEK;
    private boolean gEL = true;

    /* renamed from: com.tencent.mm.plugin.account.ui.o$10 */
    class C203810 implements OnClickListener {
        C203810() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.o$3 */
    class C100213 implements OnDismissListener {
        C100213() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C26672o.this.gEE.gue = null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.o$14 */
    class C2667414 implements OnClickListener {
        C2667414() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.o$16 */
    class C2668116 implements OnClickListener {
        C2668116() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.o$9 */
    class C266839 implements OnClickListener {
        C266839() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125258);
            C26672o.this.gEE.finish();
            C32978j.m53917a(C32982a.NONE);
            AppMethodBeat.m2505o(125258);
        }
    }

    public C26672o() {
        AppMethodBeat.m2504i(125263);
        AppMethodBeat.m2505o(125263);
    }

    /* renamed from: a */
    public final void mo17520a(MobileVerifyUI mobileVerifyUI) {
        this.gEE = mobileVerifyUI;
    }

    public final void start() {
        AppMethodBeat.m2504i(125264);
        C1720g.m3540Rg().mo14539a(126, (C1202f) this);
        AppMethodBeat.m2505o(125264);
    }

    public final void stop() {
        AppMethodBeat.m2504i(125265);
        C1720g.m3540Rg().mo14546b(126, (C1202f) this);
        AppMethodBeat.m2505o(125265);
    }

    /* renamed from: a */
    public final boolean mo17521a(C7711a c7711a) {
        AppMethodBeat.m2504i(125266);
        final C1207m c32815a;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (c7711a) {
            case GoBack:
                C30379h.m48466d(this.gEE, this.gEE.getString(C25738R.string.d0q), "", this.gEE.getString(C25738R.string.d0r), this.gEE.getString(C25738R.string.d0s), new C266839(), new C203810());
                AppMethodBeat.m2505o(125266);
                return true;
            case GoNext:
                C1720g.m3540Rg().mo14539a(145, (C1202f) this);
                c32815a = new C32815a(this.gEE.cFl, 15, this.gEE.grL.getText().toString().trim(), 0, "");
                c32815a.mo53386rV(this.gEE.gDy);
                C1720g.m3540Rg().mo14541a(c32815a, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(C25738R.string.f9238tz);
                mobileVerifyUI.ehJ = C30379h.m48458b(context, this.gEE.getString(C25738R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125259);
                        C1720g.m3540Rg().mo14547c(c32815a);
                        C1720g.m3540Rg().mo14546b(145, C26672o.this);
                        AppMethodBeat.m2505o(125259);
                    }
                });
                break;
            case DoSend:
                C1720g.m3540Rg().mo14539a(145, (C1202f) this);
                c32815a = new C32815a(this.gEE.cFl, 14, "", 0, "");
                c32815a.mo53386rV(this.gEE.gDy);
                C1720g.m3540Rg().mo14541a(c32815a, 0);
                C32978j.m53917a(C32982a.SENT);
                break;
            case DoProcessSMS:
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_350_auto,");
                C1720g.m3534RN();
                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_350_auto")).append(",1").toString());
                C1720g.m3540Rg().mo14539a(145, (C1202f) this);
                c32815a = new C32815a(this.gEE.cFl, 15, this.gEE.grL.getText().toString().trim(), 0, "");
                c32815a.mo53386rV(this.gEE.gDy);
                C1720g.m3540Rg().mo14541a(c32815a, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(C25738R.string.f9238tz);
                mobileVerifyUI.ehJ = C30379h.m48458b(context, this.gEE.getString(C25738R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125250);
                        C1720g.m3540Rg().mo14547c(c32815a);
                        C1720g.m3540Rg().mo14546b(145, C26672o.this);
                        AppMethodBeat.m2505o(125250);
                    }
                });
                break;
        }
        AppMethodBeat.m2505o(125266);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:95:0x064c  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x05a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125267);
        C4990ab.m7416i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gEE.ehJ != null) {
            this.gEE.ehJ.dismiss();
            this.gEE.ehJ = null;
        }
        final C1207m c9706r;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        if (c1207m.getType() == 255) {
            C1720g.m3540Rg().mo14546b(255, (C1202f) this);
            if (i2 == -3 && i == 4) {
                this.gEE.mo17510dq(this.gEL);
            }
            AppMethodBeat.m2505o(125267);
        } else if ((c1207m.getType() == 701 || c1207m.getType() == 701) && this.gDu != null) {
            C1720g.m3540Rg().mo14546b(701, (C1202f) this);
            C1720g.m3540Rg().mo14546b(252, (C1202f) this);
            this.gDu.mo21363a(this.gEE, i, i2, str, c1207m);
            if (i == 0 && i2 == 0) {
                if (c1207m instanceof C6686q) {
                    this.gEL = ((C6686q) c1207m).ajv();
                }
                C1720g.m3540Rg().mo14539a(255, (C1202f) this);
                c9706r = new C9706r(1);
                C1720g.m3540Rg().mo14541a(c9706r, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(C25738R.string.f9238tz);
                mobileVerifyUI.ehJ = C30379h.m48458b(context, this.gEE.getString(C25738R.string.f9160rd), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125260);
                        C1720g.m3540Rg().mo14547c(c9706r);
                        AppMethodBeat.m2505o(125260);
                    }
                });
            }
            AppMethodBeat.m2505o(125267);
        } else {
            C42124a jY;
            int Ah;
            Intent intent;
            if (c1207m.getType() == 145) {
                C1720g.m3540Rg().mo14546b(145, (C1202f) this);
                Ah = ((C32815a) c1207m).mo53366Ah();
                if (Ah != 15) {
                    AppMethodBeat.m2505o(125267);
                    return;
                } else if (i == 0 && i2 == 0) {
                    if (Ah == 15) {
                        if (this.gEE.gEs == 1) {
                            this.gEK = ((C32815a) c1207m).agg();
                            C1720g.m3540Rg().mo14539a(126, (C1202f) this);
                            c9706r = new C26472s("", this.gEE.gEk, this.gEE.bCu, 0, "", this.gEE.cFl, "", "", this.gEK, this.gEE.fPA, "", "", "", true, this.gEE.gFf.booleanValue());
                            c9706r.mo44236ts(this.gEE.gDy);
                            c9706r.mo44237tt(this.gEE.gFm);
                            C1720g.m3540Rg().mo14541a(c9706r, 0);
                            mobileVerifyUI = this.gEE;
                            context = this.gEE;
                            this.gEE.getString(C25738R.string.f9238tz);
                            mobileVerifyUI.ehJ = C30379h.m48458b(context, this.gEE.getString(C25738R.string.dmm), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(125256);
                                    C1720g.m3540Rg().mo14547c(c9706r);
                                    C1720g.m3540Rg().mo14546b(126, C26672o.this);
                                    AppMethodBeat.m2505o(125256);
                                }
                            });
                            AppMethodBeat.m2505o(125267);
                            return;
                        }
                        intent = new Intent();
                        intent.putExtra("regsetinfo_ticket", ((C32815a) c1207m).agg());
                        intent.putExtra("regsetinfo_user", this.gEE.cFl);
                        intent.putExtra("regsession_id", this.gEE.gDy);
                        intent.putExtra("reg_3d_app_ticket", this.gEE.gFm);
                        intent.putExtra("reg_3d_app_type", this.gEE.gEu);
                        intent.putExtra("regsetinfo_ismobile", 4);
                        intent.putExtra("regsetinfo_NextControl", ((C32815a) c1207m).agm());
                        intent.putExtra("key_reg_style", this.gEE.gEs);
                        intent.setClass(this.gEE, RegSetInfoUI.class);
                        this.gEE.startActivity(intent);
                        C32978j.m53917a(C32982a.VERIFIED);
                    }
                    AppMethodBeat.m2505o(125267);
                    return;
                } else if (i2 == -35) {
                    jY = C42124a.m74268jY(str);
                    this.gBm.daR = (long) this.gEE.gEu;
                    this.gBm.cVS = 7;
                    this.gBm.ajK();
                    final C1207m c1207m2;
                    if (jY != null) {
                        c1207m2 = c1207m;
                        jY.mo67668a(this.gEE, new OnClickListener() {

                            /* renamed from: com.tencent.mm.plugin.account.ui.o$13$1 */
                            class C189681 implements C10008a {
                                C189681() {
                                }

                                /* renamed from: a */
                                public final void mo17503a(ProgressDialog progressDialog) {
                                    C26672o.this.gEE.ehJ = progressDialog;
                                }
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(125261);
                                C1720g.m3540Rg().mo14539a(701, C26672o.this);
                                C1720g.m3540Rg().mo14539a(252, C26672o.this);
                                C26672o.this.gDu = new C10004g(new C189681(), ((C32815a) c1207m2).getUsername(), ((C32815a) c1207m2).agf(), C26672o.this.gEE.cFl);
                                C26672o.this.gDu.mo21362a(C26672o.this.gEE);
                                C26672o.this.gBm.daR = (long) C26672o.this.gEE.gEu;
                                C26672o.this.gBm.cVS = 8;
                                C26672o.this.gBm.ajK();
                                AppMethodBeat.m2505o(125261);
                            }
                        }, new C2667414());
                        AppMethodBeat.m2505o(125267);
                        return;
                    }
                    c1207m2 = c1207m;
                    C30379h.m48440a(this.gEE, this.gEE.getString(C25738R.string.a63), null, new OnClickListener() {

                        /* renamed from: com.tencent.mm.plugin.account.ui.o$15$1 */
                        class C266771 implements C10008a {
                            C266771() {
                            }

                            /* renamed from: a */
                            public final void mo17503a(ProgressDialog progressDialog) {
                                C26672o.this.gEE.ehJ = progressDialog;
                            }
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(125262);
                            C1720g.m3540Rg().mo14539a(701, C26672o.this);
                            C1720g.m3540Rg().mo14539a(252, C26672o.this);
                            C26672o.this.gDu = new C10004g(new C266771(), ((C32815a) c1207m2).getUsername(), ((C32815a) c1207m2).agf(), C26672o.this.gEE.cFl);
                            C26672o.this.gDu.mo21362a(C26672o.this.gEE);
                            C26672o.this.gBm.daR = (long) C26672o.this.gEE.gEu;
                            C26672o.this.gBm.cVS = 8;
                            C26672o.this.gBm.ajK();
                            AppMethodBeat.m2505o(125262);
                        }
                    }, new C2668116());
                    AppMethodBeat.m2505o(125267);
                    return;
                } else if (i2 == -212) {
                    intent = new Intent(this.gEE, MobileLoginOrForceReg.class);
                    intent.putExtra("ticket", ((C32815a) c1207m).agg());
                    intent.putExtra("moble", this.gEE.cFl);
                    intent.putExtra("regsession_id", this.gEE.gDy);
                    intent.putExtra("reg_3d_app_ticket", this.gEE.gFm);
                    intent.putExtra("reg_3d_app_type", this.gEE.gEu);
                    intent.putExtra("next_controll", ((C32815a) c1207m).agm());
                    intent.putExtra("username", ((C32815a) c1207m).getUsername());
                    intent.putExtra("password", ((C32815a) c1207m).agf());
                    intent.putExtra("nickname", ((C32815a) c1207m).ags());
                    intent.putExtra("avatar_url", ((C32815a) c1207m).agr());
                    intent.putExtra("key_reg_style", this.gEE.gEs);
                    if (this.gEE.gEs == 1) {
                        intent.putExtra("kintent_nickname", this.gEE.bCu);
                        intent.putExtra("kintent_password", this.gEE.gEk);
                        intent.putExtra("kintent_hasavatar", this.gEE.gFf);
                    }
                    this.gEE.startActivity(intent);
                    AppMethodBeat.m2505o(125267);
                    return;
                } else if (i2 == -51) {
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this.gEE, null, null);
                        AppMethodBeat.m2505o(125267);
                        return;
                    }
                    C30379h.m48467g(this.gEE, C25738R.string.a7s, C25738R.string.a7y);
                    AppMethodBeat.m2505o(125267);
                    return;
                }
            } else if (c1207m.getType() == 126) {
                final String str2;
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean bool = this.gEE.gFf;
                    final String str3 = this.gEE.gEk;
                    str2 = this.gEE.bCu;
                    if (this.gEE.gue == null) {
                        final C1207m c1207m3 = c1207m;
                        final String str4 = str3;
                        final String str5 = str2;
                        final C1207m c1207m4 = c1207m;
                        final Boolean bool2 = bool;
                        this.gEE.gue = C15492a.m23811a(this.gEE, 0, ((C26472s) c1207m).ajo(), ((C26472s) c1207m).ajn(), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(125252);
                                C1720g.m3540Rg().mo14539a(126, C26672o.this);
                                final C1207m c26472s = new C26472s("", str3, str2, 0, "", C26672o.this.gEE.cFl, "", "", C26672o.this.gEK, C26672o.this.gEE.fPA, "", ((C26472s) c1207m3).ajn(), C26672o.this.gEE.gue.getSecImgCode(), true, bool.booleanValue());
                                c26472s.mo44236ts(C26672o.this.gEE.gDy);
                                c26472s.mo44237tt(C26672o.this.gEE.gFm);
                                C1720g.m3540Rg().mo14541a(c26472s, 0);
                                MobileVerifyUI mobileVerifyUI = C26672o.this.gEE;
                                Context context = C26672o.this.gEE;
                                C26672o.this.gEE.getString(C25738R.string.f9238tz);
                                mobileVerifyUI.ehJ = C30379h.m48458b(context, C26672o.this.gEE.getString(C25738R.string.dmm), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(125251);
                                        C1720g.m3540Rg().mo14547c(c26472s);
                                        C1720g.m3540Rg().mo14546b(126, C26672o.this);
                                        AppMethodBeat.m2505o(125251);
                                    }
                                });
                                AppMethodBeat.m2505o(125252);
                            }
                        }, null, new C100213(), new C15494b() {
                            public final void apw() {
                                AppMethodBeat.m2504i(125253);
                                C26672o.this.gEE.aqX();
                                C1720g.m3540Rg().mo14539a(126, C26672o.this);
                                C1207m c26472s = new C26472s("", str4, str5, 0, "", C26672o.this.gEE.cFl, "", "", C26672o.this.gEK, C26672o.this.gEE.fPA, "", ((C26472s) c1207m4).ajn(), "", true, bool2.booleanValue());
                                c26472s.mo44236ts(C26672o.this.gEE.gDy);
                                c26472s.mo44237tt(C26672o.this.gEE.gFm);
                                C1720g.m3540Rg().mo14541a(c26472s, 0);
                                AppMethodBeat.m2505o(125253);
                            }
                        });
                        AppMethodBeat.m2505o(125267);
                        return;
                    }
                    this.gEE.gue.mo27573b(0, ((C26472s) c1207m).ajo(), ((C26472s) c1207m).ajn(), "");
                    AppMethodBeat.m2505o(125267);
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
                    int ajx = ((C26472s) c1207m).ajx();
                    final String ajy = ((C26472s) c1207m).ajy();
                    final int ajz = ((C26472s) c1207m).ajz();
                    String str9 = null;
                    String str10 = null;
                    boolean z = false;
                    Map z2 = C5049br.m7595z(((C26472s) c1207m).ajA(), "wording");
                    if (z2 != null) {
                        String str11 = (String) z2.get(".wording.switch");
                        if (C5046bo.isNullOrNil(str11)) {
                            z = true;
                        } else {
                            Ah = C5046bo.ank(str11);
                            if (Ah == 0) {
                                z = false;
                            } else if (Ah == 1) {
                                z = true;
                            }
                        }
                        if (z) {
                            str11 = (String) z2.get(".wording.title");
                            if (!C5046bo.isNullOrNil(str11)) {
                                str9 = str11;
                            }
                            str11 = (String) z2.get(".wording.desc");
                            if (C5046bo.isNullOrNil(str11)) {
                                str6 = str9;
                            } else {
                                str10 = str11;
                                str6 = str9;
                            }
                            C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                            C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(ajx));
                            C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", ajy);
                            C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(ajz));
                            C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str7);
                            C1668a.unhold();
                            C1668a.m3401cm(true);
                            if (bool3.booleanValue()) {
                                Intent intent2;
                                this.elr = ((C26472s) c1207m).ajw();
                                C6665av.fly.mo14897ak("login_user_name", str8);
                                if (ajy != null) {
                                    if (ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        C42756a.m75796wA("R300_100_phone");
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
                                        intent = C24679a.gkE.mo38909bh(this.gEE);
                                        intent.addFlags(67108864);
                                        intent.putExtra("LauncherUI.enter_from_reg", true);
                                        MMWizardActivity.m23792b(this.gEE, intent2, intent);
                                        this.gEE.finish();
                                    }
                                }
                                intent2 = C24679a.gkE.mo38909bh(this.gEE);
                                intent2.addFlags(67108864);
                                intent2.putExtra("LauncherUI.enter_from_reg", true);
                                this.gEE.startActivity(intent2);
                                StringBuilder stringBuilder = new StringBuilder();
                                C1720g.m3534RN();
                                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(this.gEE.getClass().getName()).append(",R200_900_phone,");
                                C1720g.m3534RN();
                                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",4").toString());
                                this.gEE.finish();
                            } else {
                                String str12 = C6457e.euY + "temp.avatar";
                                str11 = C6457e.euY + "temp.avatar.hd";
                                C5730e.m8623aQ(str12, str11);
                                C5730e.deleteFile(str12);
                                C5056d.m7656c(str11, 96, 96, CompressFormat.JPEG, 90, str12);
                                final C1207m c1207m5 = c1207m;
                                str2 = str8;
                                str7 = ajy;
                                final boolean z3 = z;
                                final C1207m c1207m6 = c1207m;
                                final String str13 = str6;
                                final String str14 = str10;
                                final int i3 = ajz;
                                new C37439m(this.gEE, C6457e.euY + "temp.avatar").mo60329a(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(125254);
                                        C26672o.this.elr = ((C26472s) c1207m5).ajw();
                                        C6665av.fly.mo14897ak("login_user_name", str2);
                                        C5730e.deleteFile(C6457e.euY + "temp.avatar");
                                        Intent bh;
                                        if (str7 == null || !str7.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                            bh = C24679a.gkE.mo38909bh(C26672o.this.gEE);
                                            bh.addFlags(67108864);
                                            C26672o.this.gEE.startActivity(bh);
                                            StringBuilder stringBuilder = new StringBuilder();
                                            C1720g.m3534RN();
                                            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(C26672o.this.gEE.getClass().getName()).append(",R200_900_phone,");
                                            C1720g.m3534RN();
                                            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",4").toString());
                                            C26672o.this.gEE.finish();
                                            AppMethodBeat.m2505o(125254);
                                            return;
                                        }
                                        C42756a.m75796wA("R300_100_phone");
                                        if (z3) {
                                            bh = new Intent(C26672o.this.gEE, FindMContactAlertUI.class);
                                            bh.putExtra("alert_title", str6);
                                            bh.putExtra("alert_message", str10);
                                        } else {
                                            bh = new Intent(C26672o.this.gEE, FindMContactIntroUI.class);
                                        }
                                        bh.addFlags(67108864);
                                        bh.putExtra("regsetinfo_ticket", C26672o.this.elr);
                                        bh.putExtra("regsetinfo_NextStep", str7);
                                        bh.putExtra("regsetinfo_NextStyle", ajz);
                                        Intent bh2 = C24679a.gkE.mo38909bh(C26672o.this.gEE);
                                        bh2.addFlags(67108864);
                                        MMWizardActivity.m23792b(C26672o.this.gEE, bh, bh2);
                                        C26672o.this.gEE.finish();
                                        AppMethodBeat.m2505o(125254);
                                    }
                                }, new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(125255);
                                        C26672o.this.elr = ((C26472s) c1207m6).ajw();
                                        C6665av.fly.mo14897ak("login_user_name", str8);
                                        Intent bh;
                                        if (ajy == null || !ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                            bh = C24679a.gkE.mo38909bh(C26672o.this.gEE);
                                            bh.addFlags(67108864);
                                            C26672o.this.gEE.startActivity(bh);
                                            StringBuilder stringBuilder = new StringBuilder();
                                            C1720g.m3534RN();
                                            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(C26672o.this.gEE.getClass().getName()).append(",R200_900_phone,");
                                            C1720g.m3534RN();
                                            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",4").toString());
                                            C26672o.this.gEE.finish();
                                            AppMethodBeat.m2505o(125255);
                                            return;
                                        }
                                        C42756a.m75796wA("R300_100_phone");
                                        if (z) {
                                            bh = new Intent(C26672o.this.gEE, FindMContactAlertUI.class);
                                            bh.putExtra("alert_title", str13);
                                            bh.putExtra("alert_message", str14);
                                        } else {
                                            bh = new Intent(C26672o.this.gEE, FindMContactIntroUI.class);
                                        }
                                        bh.addFlags(67108864);
                                        bh.putExtra("regsetinfo_ticket", C26672o.this.elr);
                                        bh.putExtra("regsetinfo_NextStep", ajy);
                                        bh.putExtra("regsetinfo_NextStyle", i3);
                                        Intent bh2 = C24679a.gkE.mo38909bh(C26672o.this.gEE);
                                        bh2.addFlags(67108864);
                                        MMWizardActivity.m23792b(C26672o.this.gEE, bh, bh2);
                                        C26672o.this.gEE.finish();
                                        AppMethodBeat.m2505o(125255);
                                    }
                                });
                            }
                        }
                    }
                    str6 = null;
                    C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                    C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(ajx));
                    C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", ajy);
                    C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(ajz));
                    C4990ab.m7417i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str7);
                    C1668a.unhold();
                    C1668a.m3401cm(true);
                    if (bool3.booleanValue()) {
                    }
                }
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this.gEE, null, null);
                    AppMethodBeat.m2505o(125267);
                    return;
                }
            }
            if (this.gEE.mo17511j(i, i2, str)) {
                AppMethodBeat.m2505o(125267);
                return;
            }
            if (c1207m.getType() == 252 || c1207m.getType() == 701) {
                jY = C42124a.m74268jY(str);
                if (jY != null && jY.mo67668a(this.gEE, null, null)) {
                    AppMethodBeat.m2505o(125267);
                    return;
                }
            }
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this.gEE, this.gEE.getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.m2505o(125267);
        }
    }
}
