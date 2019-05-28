package com.tencent.p177mm.plugin.account.p275ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.p275ui.C10004g.C10008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C33008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C38070b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.account.ui.l */
public final class C42311l implements C1202f, C38070b {
    String account;
    private String cOG;
    private String gCZ;
    private boolean gCm = true;
    private String gDC;
    MobileInputUI gDo;
    SecurityImage gue = null;
    private String gzO;

    /* renamed from: com.tencent.mm.plugin.account.ui.l$1 */
    class C100181 implements Runnable {
        C100181() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125133);
            C42311l.m74828a(C42311l.this, C31280f.ara(), C31280f.arb());
            AppMethodBeat.m2505o(125133);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$11 */
    class C2666211 implements OnClickListener {
        C2666211() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125143);
            C42311l.this.gDo.gCr[1] = 1;
            C42311l.this.gDo.flQ = 6;
            C1720g.m3540Rg().mo14539a(145, C42311l.this);
            C42311l.m74826a(C42311l.this);
            AppMethodBeat.m2505o(125143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$7 */
    class C266667 implements OnCancelListener {
        C266667() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$9 */
    class C266679 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.ui.l$9$1 */
        class C189661 implements DialogInterface.OnClickListener {
            C189661() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(125139);
                C42311l.this.gDo.gDJ.dzH();
                C42311l.m74827a(C42311l.this, C42311l.this.account);
                AppMethodBeat.m2505o(125139);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.ui.l$9$2 */
        class C266682 implements DialogInterface.OnClickListener {
            C266682() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(125140);
                C42311l.this.gDo.gDJ.reset();
                AppMethodBeat.m2505o(125140);
            }
        }

        C266679() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125141);
            C30379h.m48445a(C42311l.this.gDo, C42311l.this.gDo.getString(C25738R.string.dm4) + C42311l.this.account, C42311l.this.gDo.getString(C25738R.string.dm5), C42311l.this.gDo.getString(C25738R.string.f9187s6), C42311l.this.gDo.getString(C25738R.string.f9076or), false, new C189661(), new C266682());
            AppMethodBeat.m2505o(125141);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$15 */
    class C3808315 implements C10008a {
        C3808315() {
        }

        /* renamed from: a */
        public final void mo17503a(ProgressDialog progressDialog) {
            C42311l.this.gDo.guc = (C44275p) progressDialog;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$3 */
    class C380853 implements OnDismissListener {
        C380853() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C42311l.this.gue = null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$4 */
    class C380864 implements Runnable {
        C380864() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125136);
            C4990ab.m7410d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Intent bh = C24679a.gkE.mo38909bh(C42311l.this.gDo);
            bh.addFlags(67108864);
            C42311l.this.gDo.startActivity(bh);
            C42311l.this.gDo.finish();
            AppMethodBeat.m2505o(125136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$6 */
    class C380876 implements DialogInterface.OnClickListener {
        C380876() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$10 */
    class C4231010 implements OnClickListener {
        C4231010() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125142);
            C42311l.this.gDo.gCr[1] = 2;
            C42311l.this.gDo.flQ = 7;
            C42311l.this.gDo.gDJ.reset();
            C1720g.m3540Rg().mo14546b(145, C42311l.this);
            C42311l.m74826a(C42311l.this);
            AppMethodBeat.m2505o(125142);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.l$16 */
    class C4231216 implements C1835a {
        C4231216() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(125147);
            if (c1902e == null) {
                AppMethodBeat.m2505o(125147);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(125147);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m74828a(C42311l c42311l, String str, String str2) {
        AppMethodBeat.m2504i(125156);
        c42311l.m74829bk(str, str2);
        AppMethodBeat.m2505o(125156);
    }

    /* renamed from: a */
    public final void mo21369a(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125148);
        this.gDo = mobileInputUI;
        mobileInputUI.gDP.setVisibility(0);
        this.account = mobileInputUI.getIntent().getStringExtra("binded_mobile");
        if (C5046bo.isNullOrNil(this.account)) {
            this.account = C5025av.amN(mobileInputUI.gDU + mobileInputUI.gDV);
        }
        mobileInputUI.gDI.setTextColor(mobileInputUI.getResources().getColor(C25738R.color.f12092s0));
        mobileInputUI.gDI.setEnabled(false);
        mobileInputUI.gDI.setFocusable(false);
        mobileInputUI.gDH.setFocusable(false);
        mobileInputUI.gDH.setText(C5025av.amN(this.account));
        mobileInputUI.gDH.setVisibility(0);
        ard();
        mobileInputUI.gDR.setVisibility(0);
        mobileInputUI.gDN.setText(C25738R.string.com);
        mobileInputUI.gDN.setVisibility(0);
        mobileInputUI.gDN.setEnabled(true);
        this.gCZ = C6665av.fly.mo5292T("login_weixin_username", "");
        this.gzO = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!C5046bo.isNullOrNil(this.gzO)) {
            new C7306ak().postDelayed(new C100181(), 500);
        }
        AppMethodBeat.m2505o(125148);
    }

    private void ard() {
        AppMethodBeat.m2504i(125149);
        if (this.gDo.flQ == 6) {
            this.gDo.gDJ.reset();
            this.gDo.gDR.setText(C25738R.string.coq);
            this.gDo.gCV.setVisibility(8);
            this.gDo.gDJ.setVisibility(0);
            this.gDo.gDJ.getContentEditText().requestFocus();
            this.gDo.gDJ.setSendSmsBtnClickListener(new C266679());
            this.gDo.gDR.setOnClickListener(new C4231010());
            AppMethodBeat.m2505o(125149);
            return;
        }
        if (this.gDo.flQ == 7) {
            this.gDo.gDR.setText(C25738R.string.cor);
            this.gDo.gCV.setVisibility(0);
            this.gDo.gBJ.requestFocus();
            this.gDo.gDJ.setVisibility(8);
            this.gDo.gDR.setOnClickListener(new C2666211());
        }
        AppMethodBeat.m2505o(125149);
    }

    public final void start() {
        AppMethodBeat.m2504i(125150);
        C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        C1720g.m3540Rg().mo14539a(701, (C1202f) this);
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L200_100")).append(",1").toString());
        C42756a.m75798wz("L200_100");
        AppMethodBeat.m2505o(125150);
    }

    public final void stop() {
        AppMethodBeat.m2504i(125151);
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L200_100")).append(",2").toString());
        AppMethodBeat.m2505o(125151);
    }

    /* renamed from: a */
    public final void mo21368a(C33008a c33008a) {
        AppMethodBeat.m2504i(125152);
        switch (c33008a) {
            case GoNext:
                this.gDo.aqX();
                this.gDo.gDU = C5025av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDI.getText().toString();
                if (!C5046bo.isNullOrNil(this.gDo.gDU) && !C5046bo.isNullOrNil(this.gDo.gDV)) {
                    if (this.gDo.flQ != 7) {
                        if (this.gDo.flQ == 6) {
                            String trim = this.gDo.gDJ.getText().toString().trim();
                            if (!C5046bo.isNullOrNil(trim)) {
                                this.gDo.aqX();
                                final C1207m c32815a = new C32815a(this.account, 17, trim, 0, "");
                                C1720g.m3540Rg().mo14541a(c32815a, 0);
                                MobileInputUI mobileInputUI = this.gDo;
                                Context context = this.gDo;
                                this.gDo.getString(C25738R.string.f9238tz);
                                mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.a7n), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(125144);
                                        C1720g.m3540Rg().mo14547c(c32815a);
                                        AppMethodBeat.m2505o(125144);
                                    }
                                });
                                break;
                            }
                            C30379h.m48467g(this.gDo, C25738R.string.f0v, C25738R.string.cog);
                            AppMethodBeat.m2505o(125152);
                            return;
                        }
                    } else if (C5046bo.isNullOrNil(this.gDC)) {
                        m74829bk(this.account, this.gDo.gBJ.getText().toString());
                        AppMethodBeat.m2505o(125152);
                        return;
                    } else {
                        m74829bk(this.account, this.gDC);
                        AppMethodBeat.m2505o(125152);
                        return;
                    }
                }
                AppMethodBeat.m2505o(125152);
                return;
                break;
        }
        AppMethodBeat.m2505o(125152);
    }

    /* renamed from: bk */
    private void m74829bk(String str, String str2) {
        AppMethodBeat.m2504i(125153);
        if (C5046bo.isNullOrNil(str)) {
            C30379h.m48467g(this.gDo, C25738R.string.f0w, C25738R.string.cog);
            AppMethodBeat.m2505o(125153);
        } else if (C5046bo.isNullOrNil(str2)) {
            C30379h.m48467g(this.gDo, C25738R.string.f0s, C25738R.string.cog);
            AppMethodBeat.m2505o(125153);
        } else {
            this.gDo.gBJ.setText(str2);
            this.gDo.aqX();
            final C1207m c6686q = new C6686q(str, str2, null, 1);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            MobileInputUI mobileInputUI = this.gDo;
            Context context = this.gDo;
            this.gDo.getString(C25738R.string.f9238tz);
            mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125146);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    AppMethodBeat.m2505o(125146);
                }
            });
            AppMethodBeat.m2505o(125153);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        C42124a jY;
        AppMethodBeat.m2504i(125154);
        C4990ab.m7416i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if (c1207m.getType() == 145) {
            int Ah = ((C32815a) c1207m).mo53366Ah();
            if (Ah == 16) {
                if (i2 == -41) {
                    this.gDo.gDJ.reset();
                    C30379h.m48467g(this.gDo, C25738R.string.dl6, C25738R.string.dl7);
                    AppMethodBeat.m2505o(125154);
                    return;
                } else if (i2 == -75) {
                    this.gDo.gDJ.reset();
                    C30379h.m48461b(this.gDo, this.gDo.getString(C25738R.string.f8809fm), "", true);
                    AppMethodBeat.m2505o(125154);
                    return;
                } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                    this.gDo.gDJ.reset();
                    C42257z.m74635f(this.gDo, str, 32045);
                    AppMethodBeat.m2505o(125154);
                    return;
                }
            } else if (Ah == 17) {
                if (i == 0 && i2 == 0) {
                    new C10004g(new C3808315(), ((C32815a) c1207m).getUsername(), ((C32815a) c1207m).agf(), this.account).mo21362a(this.gDo);
                    AppMethodBeat.m2505o(125154);
                    return;
                } else if (m74830j(i, i2, str)) {
                    AppMethodBeat.m2505o(125154);
                    return;
                } else {
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this.gDo, null, null);
                    }
                }
            }
        } else if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            this.cOG = ((C6686q) c1207m).ajm();
            final C31280f c31280f = new C31280f();
            c31280f.guh = ((C6686q) c1207m).ajn();
            c31280f.gug = ((C6686q) c1207m).ajo();
            c31280f.gui = ((C6686q) c1207m).ajp();
            c31280f.gCL = ((C6686q) c1207m).getSecCodeType();
            c31280f.account = ((C6686q) c1207m).account;
            c31280f.guf = this.gDo.gBJ.getText().toString();
            String ajq;
            if (i2 == -75) {
                C42257z.m74634cu(this.gDo);
                AppMethodBeat.m2505o(125154);
                return;
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                C42257z.m74635f(this.gDo, str, 32045);
                AppMethodBeat.m2505o(125154);
                return;
            } else if (i2 == -217) {
                C42257z.m74633a(this.gDo, C1948e.m4157a((C6686q) c1207m), i2);
                AppMethodBeat.m2505o(125154);
                return;
            } else if (i2 == -205) {
                this.gzO = ((C6686q) c1207m).agh();
                ajq = ((C6686q) c1207m).ajq();
                C4990ab.m7417i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", C5046bo.anv(this.gzO), ((C6686q) c1207m).ajt());
                C31280f.m50502a(c31280f);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.gzO);
                intent.putExtra("binded_mobile", ajq);
                intent.putExtra("close_safe_device_style", r3);
                intent.putExtra("from_source", 6);
                C24679a.gkE.mo38920g(this.gDo, intent);
                AppMethodBeat.m2505o(125154);
                return;
            } else if (i2 == -140) {
                if (!C5046bo.isNullOrNil(this.cOG)) {
                    C42257z.m74636o(this.gDo, str, this.cOG);
                }
                AppMethodBeat.m2505o(125154);
                return;
            } else {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    C1720g.m3540Rg().mo14541a(new C6668bk(new C4231216()), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    if (this.gue == null) {
                        this.gue = C15492a.m23811a(this.gDo, c31280f.gCL, c31280f.gug, c31280f.guh, c31280f.gui, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(125135);
                                C4990ab.m7410d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + c31280f.guh + " img len" + c31280f.gug.length + " " + C1447g.m3075Mq());
                                final C1207m c6686q = new C6686q(c31280f.account, c31280f.guf, c31280f.gCL, C42311l.this.gue.getSecImgCode(), C42311l.this.gue.getSecImgSid(), C42311l.this.gue.getSecImgEncryptKey(), 1, "", false, false);
                                C1720g.m3540Rg().mo14541a(c6686q, 0);
                                MobileInputUI mobileInputUI = C42311l.this.gDo;
                                Context context = C42311l.this.gDo;
                                C42311l.this.gDo.getString(C25738R.string.f9238tz);
                                mobileInputUI.guc = C30379h.m48458b(context, C42311l.this.gDo.getString(C25738R.string.cou), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(125134);
                                        C1720g.m3540Rg().mo14547c(c6686q);
                                        AppMethodBeat.m2505o(125134);
                                    }
                                });
                                AppMethodBeat.m2505o(125135);
                            }
                        }, null, new C380853(), c31280f);
                        AppMethodBeat.m2505o(125154);
                        return;
                    }
                    C4990ab.m7410d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + c31280f.guh + " img len" + c31280f.gug.length + " " + C1447g.m3075Mq());
                    this.gue.mo27573b(c31280f.gCL, c31280f.gug, c31280f.guh, c31280f.gui);
                    AppMethodBeat.m2505o(125154);
                    return;
                } else if (z || (i == 0 && i2 == 0)) {
                    C1720g.m3534RN();
                    C1668a.unhold();
                    C38033l.apX();
                    C4990ab.m7417i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", c31280f.account);
                    C42257z.m74637vx(c31280f.account);
                    ajq = C6665av.fly.mo5292T("login_weixin_username", "");
                    C26529w.m42356cm(this.gDo);
                    if (this.gDo.gDa) {
                        C37914bx.fnB.mo60665an(this.gCZ, ajq);
                        C37914bx.fnB.mo60666g(C1853r.m3846Yz(), C1853r.m3853Zg());
                        C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(9), C37914bx.fnB.aau());
                    }
                    C42257z.showAddrBookUploadConfirm(this.gDo, new C380864(), false, 2);
                    if (this.gDo.flQ == 6) {
                        this.gCm = ((C6686q) c1207m).ajv();
                        C1720g.m3540Rg().mo14539a(255, (C1202f) this);
                        final C1207m c9706r = new C9706r(1);
                        C1720g.m3540Rg().mo14541a(c9706r, 0);
                        MobileInputUI mobileInputUI = this.gDo;
                        Context context = this.gDo;
                        this.gDo.getString(C25738R.string.f9238tz);
                        mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.f9160rd), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(125137);
                                C1720g.m3540Rg().mo14547c(c9706r);
                                C1720g.m3540Rg().mo14546b(255, C42311l.this);
                                AppMethodBeat.m2505o(125137);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(125154);
                    return;
                } else if (m74830j(i, i2, str)) {
                    AppMethodBeat.m2505o(125154);
                    return;
                } else if (!(i == 0 && i2 == 0)) {
                    Toast.makeText(this.gDo, this.gDo.getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (c1207m.getType() == 255) {
            C1720g.m3540Rg().mo14546b(255, (C1202f) this);
            if (i2 == -3 && i == 4) {
                MobileInputUI mobileInputUI2 = this.gDo;
                boolean z2 = this.gCm;
                Intent intent2 = new Intent(mobileInputUI2, RegByMobileSetPwdUI.class);
                intent2.putExtra("kintent_hint", mobileInputUI2.getString(C25738R.string.e8s));
                intent2.putExtra("kintent_cancelable", z2);
                mobileInputUI2.startActivity(intent2);
            }
            AppMethodBeat.m2505o(125154);
            return;
        }
        jY = C42124a.m74268jY(str);
        if (jY == null || this.gDo == null || !jY.mo67668a(this.gDo, null, null)) {
            AppMethodBeat.m2505o(125154);
        } else {
            AppMethodBeat.m2505o(125154);
        }
    }

    /* renamed from: j */
    private boolean m74830j(int i, int i2, String str) {
        AppMethodBeat.m2504i(125155);
        if (C24679a.gkF.mo38859a(this.gDo, i, i2, str)) {
            AppMethodBeat.m2505o(125155);
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -140:
                    if (!C5046bo.isNullOrNil(this.cOG)) {
                        C42257z.m74636o(this.gDo, str, this.cOG);
                    }
                    AppMethodBeat.m2505o(125155);
                    return true;
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    String an;
                    C1720g.m3534RN();
                    C1668a.hold();
                    Context context = this.gDo;
                    C1720g.m3534RN();
                    if (TextUtils.isEmpty(C1668a.m3385QH())) {
                        an = C1338a.m2858an(this.gDo, C25738R.string.cvw);
                    } else {
                        C1720g.m3534RN();
                        an = C1668a.m3385QH();
                    }
                    C30379h.m48439a(context, an, this.gDo.getString(C25738R.string.f9238tz), new C380876(), new C266667());
                    AppMethodBeat.m2505o(125155);
                    return true;
                case -34:
                    Toast.makeText(this.gDo, C25738R.string.a6k, 0).show();
                    AppMethodBeat.m2505o(125155);
                    return true;
                case -33:
                    C30379h.m48431a(this.gDo, (int) C25738R.string.a7s, (int) C25738R.string.a7y, null);
                    AppMethodBeat.m2505o(125155);
                    return true;
                case -32:
                    C30379h.m48431a(this.gDo, (int) C25738R.string.a7u, (int) C25738R.string.a7y, null);
                    AppMethodBeat.m2505o(125155);
                    return true;
                case -9:
                    C30379h.m48467g(this.gDo, C25738R.string.cof, C25738R.string.cog);
                    AppMethodBeat.m2505o(125155);
                    return true;
                case -3:
                    C30379h.m48467g(this.gDo, C25738R.string.be9, C25738R.string.cog);
                    AppMethodBeat.m2505o(125155);
                    return true;
                case -1:
                    if (C1720g.m3540Rg().acS() == 5) {
                        C30379h.m48467g(this.gDo, C25738R.string.d5n, C25738R.string.d5m);
                        AppMethodBeat.m2505o(125155);
                        return true;
                    }
                    AppMethodBeat.m2505o(125155);
                    return false;
            }
        }
        AppMethodBeat.m2505o(125155);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m74827a(C42311l c42311l, String str) {
        AppMethodBeat.m2504i(125157);
        final C1207m c32815a = new C32815a(str, 16, "", 0, "");
        C1720g.m3540Rg().mo14541a(c32815a, 0);
        MobileInputUI mobileInputUI = c42311l.gDo;
        Context context = c42311l.gDo;
        c42311l.gDo.getString(C25738R.string.f9238tz);
        mobileInputUI.guc = C30379h.m48458b(context, c42311l.gDo.getString(C25738R.string.f9260un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(125145);
                C1720g.m3540Rg().mo14547c(c32815a);
                AppMethodBeat.m2505o(125145);
            }
        });
        AppMethodBeat.m2505o(125157);
    }
}
