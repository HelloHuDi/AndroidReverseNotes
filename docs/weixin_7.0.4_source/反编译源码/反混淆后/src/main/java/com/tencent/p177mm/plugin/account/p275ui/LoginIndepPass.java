package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass */
public class LoginIndepPass extends MMActivity implements C1202f {
    private String account;
    private String cOG;
    private ProgressDialog ehJ = null;
    private C4884c gAY = new C99351();
    private C31280f gBT = new C31280f();
    private String gBV;
    private String gBW;
    private EditText gCB;
    private String gCC;
    private Button gCD;
    private String gsF;
    private C44275p guc;
    private SecurityImage gue = null;
    private String gzO;

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$12 */
    class C993212 implements OnKeyListener {
        C993212() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(124978);
            if (66 == i && keyEvent.getAction() == 0) {
                LoginIndepPass.m17572a(LoginIndepPass.this);
                AppMethodBeat.m2505o(124978);
                return true;
            }
            AppMethodBeat.m2505o(124978);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$14 */
    class C993314 implements OnMenuItemClickListener {
        C993314() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124982);
            C42756a.m75796wA("L200_100");
            Intent intent = new Intent(LoginIndepPass.this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(67108864);
            LoginIndepPass.this.startActivity(intent);
            LoginIndepPass.this.finish();
            AppMethodBeat.m2505o(124982);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$15 */
    class C993415 implements Runnable {
        C993415() {
        }

        public final void run() {
            AppMethodBeat.m2504i(124983);
            LoginIndepPass.m17573a(LoginIndepPass.this, C31280f.ara(), C31280f.arb());
            AppMethodBeat.m2505o(124983);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$1 */
    class C99351 extends C4884c<C37745jk> {
        C99351() {
            AppMethodBeat.m2504i(124967);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(124967);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124968);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(124968);
                return false;
            }
            C4990ab.m7417i("MicroMsg.LoginIndepPass", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(124968);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$7 */
    class C99367 implements OnClickListener {
        C99367() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$13 */
    class C993713 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$13$2 */
        class C99382 implements OnClickListener {
            C99382() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$13$1 */
        class C99391 implements OnClickListener {
            C99391() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(124980);
                C1720g.m3540Rg().mo14539a(145, LoginIndepPass.this);
                final C1207m c32815a = new C32815a(LoginIndepPass.this.account, 16, "", 0, "");
                C1720g.m3540Rg().mo14541a(c32815a, 0);
                LoginIndepPass loginIndepPass = LoginIndepPass.this;
                Context context = LoginIndepPass.this;
                LoginIndepPass.this.getString(C25738R.string.f9238tz);
                loginIndepPass.guc = C30379h.m48458b(context, LoginIndepPass.this.getString(C25738R.string.f9160rd), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(124979);
                        C1720g.m3540Rg().mo14547c(c32815a);
                        C1720g.m3540Rg().mo14546b(701, LoginIndepPass.this);
                        C1720g.m3540Rg().mo14546b(252, LoginIndepPass.this);
                        AppMethodBeat.m2505o(124979);
                    }
                });
                AppMethodBeat.m2505o(124980);
            }
        }

        C993713() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124981);
            C30379h.m48440a(LoginIndepPass.this, LoginIndepPass.this.getString(C25738R.string.dm4) + LoginIndepPass.this.gCC, LoginIndepPass.this.getString(C25738R.string.dm5), new C99391(), new C99382());
            AppMethodBeat.m2505o(124981);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$6 */
    class C99426 implements Runnable {
        C99426() {
        }

        public final void run() {
            AppMethodBeat.m2504i(124974);
            C4990ab.m7410d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
            Intent bh = C24679a.gkE.mo38909bh(LoginIndepPass.this);
            bh.addFlags(67108864);
            LoginIndepPass.this.startActivity(bh);
            LoginIndepPass.this.finish();
            AppMethodBeat.m2505o(124974);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$8 */
    class C99438 implements OnCancelListener {
        C99438() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$9 */
    class C99449 implements OnMenuItemClickListener {
        C99449() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124975);
            LoginIndepPass.m17572a(LoginIndepPass.this);
            AppMethodBeat.m2505o(124975);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$10 */
    class C994510 implements TextWatcher {
        C994510() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(124976);
            LoginIndepPass.m17574b(LoginIndepPass.this);
            AppMethodBeat.m2505o(124976);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$3 */
    class C99463 implements C1835a {
        C99463() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(124970);
            if (c1902e == null) {
                AppMethodBeat.m2505o(124970);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(124970);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$5 */
    class C99475 implements OnDismissListener {
        C99475() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(124973);
            LoginIndepPass.this.gue = null;
            AppMethodBeat.m2505o(124973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$11 */
    class C994911 implements OnEditorActionListener {
        C994911() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(124977);
            if (i == 6 || i == 5) {
                LoginIndepPass.m17572a(LoginIndepPass.this);
                AppMethodBeat.m2505o(124977);
                return true;
            }
            AppMethodBeat.m2505o(124977);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.LoginIndepPass$4 */
    class C99504 implements OnClickListener {
        C99504() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124972);
            C4990ab.m7410d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.this.gBT.guh + " img len" + LoginIndepPass.this.gBT.gug.length + " " + C1447g.m3075Mq());
            final C1207m c6686q = new C6686q(LoginIndepPass.this.gBT.account, LoginIndepPass.this.gBT.guf, LoginIndepPass.this.gBT.gCL, LoginIndepPass.this.gue.getSecImgCode(), LoginIndepPass.this.gue.getSecImgSid(), LoginIndepPass.this.gue.getSecImgEncryptKey(), 1, "", false, false);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            LoginIndepPass loginIndepPass = LoginIndepPass.this;
            Context context = LoginIndepPass.this;
            LoginIndepPass.this.getString(C25738R.string.f9238tz);
            loginIndepPass.ehJ = C30379h.m48458b(context, LoginIndepPass.this.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(124971);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    C1720g.m3540Rg().mo14546b(701, LoginIndepPass.this);
                    C1720g.m3540Rg().mo14546b(252, LoginIndepPass.this);
                    AppMethodBeat.m2505o(124971);
                }
            });
            AppMethodBeat.m2505o(124972);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LoginIndepPass() {
        AppMethodBeat.m2504i(124985);
        AppMethodBeat.m2505o(124985);
    }

    /* renamed from: a */
    static /* synthetic */ void m17572a(LoginIndepPass loginIndepPass) {
        AppMethodBeat.m2504i(124995);
        loginIndepPass.aqU();
        AppMethodBeat.m2505o(124995);
    }

    public final int getLayoutId() {
        return 2130969951;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124986);
        super.onCreate(bundle);
        String string = getString(C25738R.string.cok);
        if (C7243d.vxr) {
            string = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        setMMTitle(string);
        this.gCC = getIntent().getStringExtra("bindmcontact_mobile");
        if (this.gCC != null) {
            this.account = C5025av.amN(this.gCC);
        }
        C24679a.gkF.mo38846BV();
        this.gsF = C42756a.m75794FP();
        initView();
        AppMethodBeat.m2505o(124986);
    }

    public void onResume() {
        AppMethodBeat.m2504i(124987);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L200_200,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L200_200")).append(",1").toString());
        C42756a.m75798wz("L200_200");
        AppMethodBeat.m2505o(124987);
    }

    public void onPause() {
        AppMethodBeat.m2504i(124988);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L200_200,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L200_200")).append(",2").toString());
        AppMethodBeat.m2505o(124988);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(124989);
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(124989);
    }

    public final void initView() {
        AppMethodBeat.m2504i(124990);
        this.gCB = (EditText) findViewById(2131825314);
        this.gCD = (Button) findViewById(2131825315);
        enableOptionMenu(false);
        addTextOptionMenu(0, getString(C25738R.string.com), new C99449());
        this.gCB.addTextChangedListener(new C994510());
        this.gCB.setOnEditorActionListener(new C994911());
        this.gCB.setOnKeyListener(new C993212());
        this.gCD.setText(getString(C25738R.string.cor));
        this.gCD.setOnClickListener(new C993713());
        setBackBtn(new C993314());
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!C5046bo.isNullOrNil(this.gzO)) {
            new C7306ak().postDelayed(new C993415(), 500);
        }
        AppMethodBeat.m2505o(124990);
    }

    private void aqU() {
        AppMethodBeat.m2504i(124991);
        String obj = this.gCB.getText().toString();
        if (C5046bo.isNullOrNil(this.account)) {
            C30379h.m48467g(this, C25738R.string.f0w, C25738R.string.cog);
            AppMethodBeat.m2505o(124991);
        } else if (obj.equals("")) {
            C30379h.m48467g(this, C25738R.string.f0s, C25738R.string.cog);
            AppMethodBeat.m2505o(124991);
        } else {
            aqX();
            C1720g.m3540Rg().mo14539a(701, (C1202f) this);
            C1720g.m3540Rg().mo14539a(252, (C1202f) this);
            final C1207m c6686q = new C6686q(this.account, obj, null, 1);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(124984);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    AppMethodBeat.m2505o(124984);
                }
            });
            AppMethodBeat.m2505o(124991);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124992);
        C4990ab.m7416i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.guc != null) {
            this.guc.dismiss();
            this.guc = null;
        }
        if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            this.cOG = ((C6686q) c1207m).ajm();
            C1720g.m3540Rg().mo14546b(701, (C1202f) this);
            C1720g.m3540Rg().mo14546b(252, (C1202f) this);
            this.gBT.guh = ((C6686q) c1207m).ajn();
            this.gBT.gug = ((C6686q) c1207m).ajo();
            this.gBT.gui = ((C6686q) c1207m).ajp();
            this.gBT.gCL = ((C6686q) c1207m).getSecCodeType();
            this.gBT.account = this.account;
            this.gBT.guf = this.gCB.getText().toString();
            if (i2 == -75) {
                C42257z.m74634cu(this.mController.ylL);
                AppMethodBeat.m2505o(124992);
            } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
                C42257z.m74635f(this, str, 0);
                AppMethodBeat.m2505o(124992);
            } else if (i2 == -217) {
                C42257z.m74633a(this, C1948e.m4157a((C6686q) c1207m), i2);
                AppMethodBeat.m2505o(124992);
            } else if (i2 == -205) {
                this.gzO = ((C6686q) c1207m).agh();
                this.gBV = ((C6686q) c1207m).ajq();
                this.gBW = ((C6686q) c1207m).ajt();
                C4990ab.m7417i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", C5046bo.anv(this.gzO), this.gBW);
                C31280f.m50502a(this.gBT);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.gzO);
                intent.putExtra("binded_mobile", this.gBV);
                intent.putExtra("close_safe_device_style", this.gBW);
                intent.putExtra("from_source", 5);
                C24679a.gkE.mo38920g((Context) this, intent);
                AppMethodBeat.m2505o(124992);
            } else if (i2 == -140) {
                if (!C5046bo.isNullOrNil(this.cOG)) {
                    C42257z.m74636o(this, str, this.cOG);
                }
                AppMethodBeat.m2505o(124992);
            } else {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    C1720g.m3540Rg().mo14541a(new C6668bk(new C99463()), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    C1720g.m3540Rg().mo14539a(701, (C1202f) this);
                    C1720g.m3540Rg().mo14539a(252, (C1202f) this);
                    if (this.gue == null) {
                        this.gue = C15492a.m23811a(this.mController.ylL, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new C99504(), null, new C99475(), this.gBT);
                        AppMethodBeat.m2505o(124992);
                        return;
                    }
                    C4990ab.m7410d("MicroMsg.LoginIndepPass", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + C1447g.m3075Mq());
                    this.gue.mo27573b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                    AppMethodBeat.m2505o(124992);
                } else if (z || (i == 0 && i2 == 0)) {
                    C1668a.unhold();
                    C38033l.apX();
                    C42257z.m74637vx(this.gBT.account);
                    C26529w.m42356cm(this);
                    C42257z.showAddrBookUploadConfirm(this, new C99426(), false, 2);
                    AppMethodBeat.m2505o(124992);
                } else if (m17580j(i, i2, str)) {
                    AppMethodBeat.m2505o(124992);
                } else {
                    if (c1207m.getType() == 252 || c1207m.getType() == 701) {
                        C42124a jY = C42124a.m74268jY(str);
                        if (jY != null && jY.mo67668a(this, null, null)) {
                            AppMethodBeat.m2505o(124992);
                            return;
                        }
                    }
                    Toast.makeText(this, getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.m2505o(124992);
                }
            }
        } else if (c1207m.getType() == 145) {
            C1720g.m3540Rg().mo14546b(145, (C1202f) this);
            String agi = ((C32815a) c1207m).agi();
            if (i2 == -41) {
                C30379h.m48467g(this, C25738R.string.dl6, C25738R.string.dl7);
                AppMethodBeat.m2505o(124992);
            } else if (i2 == -75) {
                C30379h.m48461b((Context) this, getString(C25738R.string.f8809fm), "", true);
                AppMethodBeat.m2505o(124992);
            } else {
                C42756a.m75796wA("L3");
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L3,");
                C1720g.m3534RN();
                C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L3")).append(",1").toString());
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.gCC);
                intent2.putExtra("bindmcontact_shortmobile", agi);
                intent2.putExtra("mobile_verify_purpose", 1);
                intent2.putExtra("mobileverify_countdownsec", ((C32815a) c1207m).agn());
                intent2.putExtra("mobileverify_countdownstyle", ((C32815a) c1207m).ago());
                intent2.putExtra("mobileverify_fb", ((C32815a) c1207m).agp());
                mo17381a(MobileVerifyUI.class, intent2);
                AppMethodBeat.m2505o(124992);
            }
        } else if (m17580j(i, i2, str)) {
            AppMethodBeat.m2505o(124992);
        } else {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.m2505o(124992);
        }
    }

    /* renamed from: j */
    private boolean m17580j(int i, int i2, String str) {
        AppMethodBeat.m2504i(124993);
        if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(124993);
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -140:
                    if (!C5046bo.isNullOrNil(this.cOG)) {
                        C42257z.m74636o(this.mController.ylL, str, this.cOG);
                    }
                    AppMethodBeat.m2505o(124993);
                    return true;
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    String an;
                    C1668a.hold();
                    Context context = this.mController.ylL;
                    C1720g.m3534RN();
                    if (TextUtils.isEmpty(C1668a.m3385QH())) {
                        an = C1338a.m2858an(this.mController.ylL, C25738R.string.cvw);
                    } else {
                        C1720g.m3534RN();
                        an = C1668a.m3385QH();
                    }
                    C30379h.m48439a(context, an, this.mController.ylL.getString(C25738R.string.f9238tz), new C99367(), new C99438());
                    AppMethodBeat.m2505o(124993);
                    return true;
                case -9:
                    C30379h.m48467g(this, C25738R.string.cof, C25738R.string.cog);
                    AppMethodBeat.m2505o(124993);
                    return true;
                case -4:
                case -3:
                    C30379h.m48467g(this, C25738R.string.be9, C25738R.string.cog);
                    AppMethodBeat.m2505o(124993);
                    return true;
                case -1:
                    if (C1720g.m3540Rg().acS() == 5) {
                        C30379h.m48467g(this, C25738R.string.d5n, C25738R.string.d5m);
                        AppMethodBeat.m2505o(124993);
                        return true;
                    }
                    AppMethodBeat.m2505o(124993);
                    return false;
            }
        }
        AppMethodBeat.m2505o(124993);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.m2504i(124994);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginIndepPass";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7411d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginIndepPass";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(C5046bo.isNullOrNil(stringExtra));
            if (!C5046bo.isNullOrNil(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            C4990ab.m7411d(str2, str3, objArr2);
            if (intExtra == -217) {
                aqU();
                AppMethodBeat.m2505o(124994);
                return;
            }
        }
        AppMethodBeat.m2505o(124994);
    }

    /* renamed from: b */
    static /* synthetic */ void m17574b(LoginIndepPass loginIndepPass) {
        AppMethodBeat.m2504i(124996);
        if (C5046bo.isNullOrNil(loginIndepPass.gCB.getText().toString().trim())) {
            loginIndepPass.enableOptionMenu(false);
            AppMethodBeat.m2505o(124996);
            return;
        }
        loginIndepPass.enableOptionMenu(true);
        AppMethodBeat.m2505o(124996);
    }

    /* renamed from: a */
    static /* synthetic */ void m17573a(LoginIndepPass loginIndepPass, String str, String str2) {
        AppMethodBeat.m2504i(124997);
        if (C5046bo.isNullOrNil(str)) {
            C30379h.m48467g(loginIndepPass, C25738R.string.f0w, C25738R.string.cog);
            AppMethodBeat.m2505o(124997);
        } else if (C5046bo.isNullOrNil(str2)) {
            C30379h.m48467g(loginIndepPass, C25738R.string.f0s, C25738R.string.cog);
            AppMethodBeat.m2505o(124997);
        } else {
            loginIndepPass.gCB.setText(str2);
            loginIndepPass.aqX();
            C1720g.m3540Rg().mo14539a(701, (C1202f) loginIndepPass);
            C1720g.m3540Rg().mo14539a(252, (C1202f) loginIndepPass);
            final C1207m c6686q = new C6686q(str, str2, null, 1);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            loginIndepPass.getString(C25738R.string.f9238tz);
            loginIndepPass.ehJ = C30379h.m48458b((Context) loginIndepPass, loginIndepPass.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(124969);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    AppMethodBeat.m2505o(124969);
                }
            });
            AppMethodBeat.m2505o(124997);
        }
    }
}
