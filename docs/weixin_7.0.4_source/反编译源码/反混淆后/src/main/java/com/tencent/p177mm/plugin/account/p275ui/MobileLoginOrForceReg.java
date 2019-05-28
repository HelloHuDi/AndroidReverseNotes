package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelsimple.C26472s;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p182ah.C37439m;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.platformtools.C45475ag;
import com.tencent.p177mm.platformtools.C45476c;
import com.tencent.p177mm.plugin.account.p275ui.C10004g.C10008a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg */
public class MobileLoginOrForceReg extends MMActivity implements C1202f {
    private String cFl;
    private String cOG;
    private String cxb;
    protected ProgressDialog ehJ = null;
    private ImageView ejo;
    private TextView ejp;
    private int fPA;
    private C4884c gAY = new C769012();
    private C31280f gBT = null;
    private C42085ba gBm = new C42085ba();
    private C45476c gCd;
    private C10004g gDu = null;
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
    private C7306ak handler = new C76881();
    private String nickname;
    private String username;

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$16 */
    class C767516 implements OnMenuItemClickListener {
        C767516() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125217);
            MobileLoginOrForceReg.m13719p(MobileLoginOrForceReg.this);
            AppMethodBeat.m2505o(125217);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$18 */
    class C767618 implements OnDismissListener {
        C767618() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125220);
            MobileLoginOrForceReg.this.gue = null;
            AppMethodBeat.m2505o(125220);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$10 */
    class C767810 implements OnCancelListener {
        C767810() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$17 */
    class C767917 implements OnClickListener {
        C767917() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125219);
            C4990ab.m7410d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.this.gBT.guh + " img len" + MobileLoginOrForceReg.this.gBT.gug.length + " " + C1447g.m3075Mq());
            final C1207m c6686q = new C6686q(MobileLoginOrForceReg.this.gBT.account, MobileLoginOrForceReg.this.gBT.gCK, MobileLoginOrForceReg.this.gBT.gCL, MobileLoginOrForceReg.this.gue.getSecImgCode(), MobileLoginOrForceReg.this.gue.getSecImgSid(), MobileLoginOrForceReg.this.gue.getSecImgEncryptKey(), 1, "", false, true);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            Context context = MobileLoginOrForceReg.this;
            MobileLoginOrForceReg.this.getString(C25738R.string.f9238tz);
            C30379h.m48458b(context, MobileLoginOrForceReg.this.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125218);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    AppMethodBeat.m2505o(125218);
                }
            });
            AppMethodBeat.m2505o(125219);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$3 */
    class C76833 implements OnDismissListener {
        C76833() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125206);
            MobileLoginOrForceReg.this.gue = null;
            AppMethodBeat.m2505o(125206);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$14 */
    class C768614 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$14$1 */
        class C76871 implements C10008a {
            C76871() {
            }

            /* renamed from: a */
            public final void mo17503a(ProgressDialog progressDialog) {
                MobileLoginOrForceReg.this.ehJ = progressDialog;
            }
        }

        C768614() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125215);
            MobileLoginOrForceReg.this.gDu = new C10004g(new C76871(), MobileLoginOrForceReg.this.username, MobileLoginOrForceReg.this.gEk, MobileLoginOrForceReg.this.cFl);
            MobileLoginOrForceReg.this.gDu.mo21362a(MobileLoginOrForceReg.this);
            AppMethodBeat.m2505o(125215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$1 */
    class C76881 extends C7306ak {
        C76881() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(125203);
            if (message.obj != null) {
                MobileLoginOrForceReg.this.ejo.setImageBitmap((Bitmap) message.obj);
            }
            AppMethodBeat.m2505o(125203);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$8 */
    class C76898 implements OnClickListener {
        C76898() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$12 */
    class C769012 extends C4884c<C37745jk> {
        C769012() {
            AppMethodBeat.m2504i(125211);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(125211);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(125212);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(125212);
                return false;
            }
            C4990ab.m7417i("MicorMsg.MobileLoginOrForceReg", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(125212);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$9 */
    class C76919 implements OnClickListener {
        C76919() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$15 */
    class C769315 implements View.OnClickListener {
        C769315() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125216);
            if (C5046bo.isNullOrNil(MobileLoginOrForceReg.this.gEq)) {
                Intent intent = new Intent();
                C42756a.m75796wA("R200_900_phone");
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
                AppMethodBeat.m2505o(125216);
                return;
            }
            MobileLoginOrForceReg.m13718o(MobileLoginOrForceReg.this);
            AppMethodBeat.m2505o(125216);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg$7 */
    class C76947 implements OnClickListener {
        C76947() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MobileLoginOrForceReg() {
        AppMethodBeat.m2504i(125222);
        AppMethodBeat.m2505o(125222);
    }

    /* renamed from: p */
    static /* synthetic */ void m13719p(MobileLoginOrForceReg mobileLoginOrForceReg) {
        AppMethodBeat.m2504i(125233);
        mobileLoginOrForceReg.goBack();
        AppMethodBeat.m2505o(125233);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125223);
        super.onCreate(bundle);
        this.gEn = C42756a.m75794FP();
        C1720g.m3540Rg().mo14539a(701, (C1202f) this);
        C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        C1720g.m3540Rg().mo14539a(126, (C1202f) this);
        C1720g.m3540Rg().mo14539a(255, (C1202f) this);
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
        this.gCd = new C45476c();
        AppMethodBeat.m2505o(125223);
    }

    /* renamed from: wu */
    private void m13724wu(final String str) {
        AppMethodBeat.m2504i(125224);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(125213);
                Object obj = null;
                try {
                    obj = C5056d.decodeStream(C1897b.m4022p(str, Downloads.MIN_WAIT_FOR_NETWORK, C1625i.sHCENCODEVIDEOTIMEOUT));
                } catch (Exception e) {
                    C4990ab.m7412e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
                    C4990ab.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", e, "", new Object[0]);
                }
                MobileLoginOrForceReg.this.handler.sendMessage(MobileLoginOrForceReg.this.handler.obtainMessage(0, obj));
                AppMethodBeat.m2505o(125213);
            }

            public final String toString() {
                AppMethodBeat.m2504i(125214);
                String str = super.toString() + "|loadBitmap";
                AppMethodBeat.m2505o(125214);
                return str;
            }
        });
        AppMethodBeat.m2505o(125224);
    }

    public final void initView() {
        CharSequence charSequence;
        AppMethodBeat.m2504i(125225);
        this.gEf = (Button) findViewById(2131826128);
        this.gEg = (Button) findViewById(2131826129);
        this.gEh = (LinearLayout) findViewById(2131826127);
        this.gEi = (LinearLayout) findViewById(2131826126);
        this.ejo = (ImageView) findViewById(2131821183);
        this.ejp = (TextView) findViewById(2131823149);
        this.grM = (TextView) findViewById(2131821769);
        C5025av c5025av = new C5025av();
        if (this.cFl.startsWith("+")) {
            String Ps = C5025av.m7481Ps(this.cFl);
            if (C5046bo.isNullOrNil(Ps)) {
                charSequence = this.cFl;
            } else {
                charSequence = "+" + Ps + " " + C5025av.formatNumber(Ps, this.cFl.substring(Ps.length() + 1));
            }
        } else {
            charSequence = "+86 " + C5025av.formatNumber("86", this.cFl);
        }
        this.grM.setText(charSequence);
        if (C5046bo.isNullOrNil(this.nickname) && C5046bo.isNullOrNil(this.gEl)) {
            this.gEi.setVisibility(0);
            this.gEh.setVisibility(8);
        } else {
            this.gEi.setVisibility(8);
            this.gEh.setVisibility(0);
            if (C5046bo.isNullOrNil(this.nickname)) {
                this.ejp.setVisibility(8);
            } else {
                this.ejp.setText(this.nickname);
            }
            Bitmap AZ = C40460b.diS().mo8229AZ();
            if (AZ != null) {
                this.ejo.setImageBitmap(AZ);
            }
            if (!C5046bo.isNullOrNil(this.gEl)) {
                m13724wu(this.gEl);
            }
        }
        this.gEf.setOnClickListener(new C768614());
        this.gEg.setOnClickListener(new C769315());
        setMMTitle((int) C25738R.string.d0d);
        setBackBtn(new C767516());
        AppMethodBeat.m2505o(125225);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125226);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
        C1720g.m3534RN();
        C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_600")).append(",1").toString());
        C42756a.m75798wz("R200_600");
        AppMethodBeat.m2505o(125226);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125227);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        AppMethodBeat.m2505o(125227);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125228);
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        C1720g.m3540Rg().mo14546b(126, (C1202f) this);
        C1720g.m3540Rg().mo14546b(255, (C1202f) this);
        if (this.gCd != null) {
            this.gCd.close();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(125228);
    }

    public final int getLayoutId() {
        return 2130970238;
    }

    private void goBack() {
        Intent intent;
        AppMethodBeat.m2504i(125229);
        C42756a.m75796wA("R200_100");
        if (this.gEs == 1) {
            intent = new Intent(this, RegByMobileRegAIOUI.class);
        } else {
            intent = new Intent(this, MobileInputUI.class);
        }
        intent.putExtra("mobile_input_purpose", 2);
        intent.addFlags(67108864);
        startActivity(intent);
        C42756a.m75798wz(this.gEn);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R200_600")).append(",2").toString());
        finish();
        AppMethodBeat.m2505o(125229);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125230);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(125230);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125230);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125231);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.gBT == null) {
            this.gBT = new C31280f();
        }
        if (c1207m.getType() == 255) {
            if (i2 == -3 && i == 4) {
                boolean z = this.gEo;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(C25738R.string.e8s));
                intent.putExtra("kintent_cancelable", z);
                startActivityForResult(intent, 0);
            }
            AppMethodBeat.m2505o(125231);
        } else if ((c1207m.getType() != 252 && c1207m.getType() != 701) || this.gDu == null) {
            String str2;
            C42124a jY;
            Object obj;
            if (c1207m.getType() == 126) {
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean valueOf = Boolean.valueOf(this.gEp);
                    final String str3 = this.gEr;
                    final String str4 = this.gEq;
                    if (this.gue == null) {
                        final C1207m c1207m2 = c1207m;
                        final String str5 = str3;
                        final String str6 = str4;
                        final C1207m c1207m3 = c1207m;
                        final Boolean bool = valueOf;
                        this.gue = C15492a.m23811a(this, 0, ((C26472s) c1207m).ajo(), ((C26472s) c1207m).ajn(), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(125205);
                                final C1207m c26472s = new C26472s("", str3, str4, 0, "", MobileLoginOrForceReg.this.cFl, "", "", MobileLoginOrForceReg.this.cxb, MobileLoginOrForceReg.this.fPA, "", ((C26472s) c1207m2).ajn(), MobileLoginOrForceReg.this.gue.getSecImgCode(), true, valueOf.booleanValue());
                                c26472s.mo44236ts(MobileLoginOrForceReg.this.gDy);
                                c26472s.mo44237tt(MobileLoginOrForceReg.this.gEt);
                                c26472s.mo44235lX(MobileLoginOrForceReg.this.gEm);
                                C1720g.m3540Rg().mo14541a(c26472s, 0);
                                MobileLoginOrForceReg mobileLoginOrForceReg = MobileLoginOrForceReg.this;
                                Context context = MobileLoginOrForceReg.this.mController.ylL;
                                MobileLoginOrForceReg.this.getString(C25738R.string.f9238tz);
                                mobileLoginOrForceReg.ehJ = C30379h.m48458b(context, MobileLoginOrForceReg.this.getString(C25738R.string.dmm), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(125204);
                                        C1720g.m3540Rg().mo14547c(c26472s);
                                        AppMethodBeat.m2505o(125204);
                                    }
                                });
                                AppMethodBeat.m2505o(125205);
                            }
                        }, null, new C76833(), new C15494b() {
                            public final void apw() {
                                AppMethodBeat.m2504i(125207);
                                MobileLoginOrForceReg.this.aqX();
                                C1207m c26472s = new C26472s("", str5, str6, 0, "", MobileLoginOrForceReg.this.cFl, "", "", MobileLoginOrForceReg.this.cxb, MobileLoginOrForceReg.this.fPA, "", ((C26472s) c1207m3).ajn(), "", true, bool.booleanValue());
                                c26472s.mo44236ts(MobileLoginOrForceReg.this.gDy);
                                c26472s.mo44237tt(MobileLoginOrForceReg.this.gEt);
                                c26472s.mo44235lX(MobileLoginOrForceReg.this.gEm);
                                C1720g.m3540Rg().mo14541a(c26472s, 0);
                                AppMethodBeat.m2505o(125207);
                            }
                        });
                        AppMethodBeat.m2505o(125231);
                        return;
                    }
                    this.gue.mo27573b(0, ((C26472s) c1207m).ajo(), ((C26472s) c1207m).ajn(), "");
                    AppMethodBeat.m2505o(125231);
                    return;
                }
                if (i == 0 && i2 == 0) {
                    final String str7 = this.cFl;
                    Boolean valueOf2 = Boolean.valueOf(this.gEp);
                    this.gBm.daR = (long) this.gEu;
                    this.gBm.cVS = 6;
                    this.gBm.ajK();
                    C1720g.m3534RN();
                    C1668a.unhold();
                    C1668a.m3401cm(true);
                    if (valueOf2.booleanValue()) {
                        String str8 = C6457e.euY + "temp.avatar";
                        str2 = C6457e.euY + "temp.avatar.hd";
                        C5730e.m8623aQ(str8, str2);
                        C5730e.deleteFile(str8);
                        C5056d.m7656c(str2, 96, 96, CompressFormat.JPEG, 90, str8);
                        C37439m c37439m = new C37439m(this, C6457e.euY + "temp.avatar");
                        final C1207m c1207m4 = c1207m;
                        C76845 c76845 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(125208);
                                MobileLoginOrForceReg.this.cxb = ((C26472s) c1207m4).ajw();
                                C6665av.fly.mo14897ak("login_user_name", str7);
                                C5730e.deleteFile(C6457e.euY + "temp.avatar");
                                Intent bh = C24679a.gkE.mo38909bh(MobileLoginOrForceReg.this);
                                bh.addFlags(67108864);
                                MobileLoginOrForceReg.this.startActivity(bh);
                                StringBuilder stringBuilder = new StringBuilder();
                                C1720g.m3534RN();
                                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                                C1720g.m3534RN();
                                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_600")).append(",4").toString());
                                MobileLoginOrForceReg.this.finish();
                                AppMethodBeat.m2505o(125208);
                            }
                        };
                        c1207m4 = c1207m;
                        c37439m.mo60329a(c76845, new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(125209);
                                MobileLoginOrForceReg.this.cxb = ((C26472s) c1207m4).ajw();
                                C6665av.fly.mo14897ak("login_user_name", str7);
                                Intent bh = C24679a.gkE.mo38909bh(MobileLoginOrForceReg.this);
                                bh.addFlags(67108864);
                                MobileLoginOrForceReg.this.startActivity(bh);
                                StringBuilder stringBuilder = new StringBuilder();
                                C1720g.m3534RN();
                                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                                C1720g.m3534RN();
                                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_600")).append(",4").toString());
                                MobileLoginOrForceReg.this.finish();
                                AppMethodBeat.m2505o(125209);
                            }
                        });
                    } else {
                        this.cxb = ((C26472s) c1207m).ajw();
                        C6665av.fly.mo14897ak("login_user_name", str7);
                        Intent bh = C24679a.gkE.mo38909bh(this);
                        bh.addFlags(67108864);
                        bh.putExtra("LauncherUI.enter_from_reg", true);
                        startActivity(bh);
                        finish();
                        C42756a.m75796wA("RE900_100");
                        StringBuilder stringBuilder = new StringBuilder();
                        C1720g.m3534RN();
                        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                        C1720g.m3534RN();
                        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R200_600")).append(",4").toString());
                    }
                }
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this, null, null);
                    AppMethodBeat.m2505o(125231);
                    return;
                }
            }
            if (!this.gCd.mo73273a(this, new C45475ag(i, i2, str))) {
                obj = null;
                switch (i2) {
                    case -140:
                        if (!C5046bo.isNullOrNil(this.cOG)) {
                            C42257z.m74636o(this.mController.ylL, str, this.cOG);
                        }
                        obj = 1;
                        break;
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                        C1720g.m3534RN();
                        C1668a.hold();
                        Context context = this.mController.ylL;
                        C1720g.m3534RN();
                        if (TextUtils.isEmpty(C1668a.m3385QH())) {
                            str2 = C1338a.m2858an(this.mController.ylL, C25738R.string.cvw);
                        } else {
                            C1720g.m3534RN();
                            str2 = C1668a.m3385QH();
                        }
                        C30379h.m48439a(context, str2, this.mController.ylL.getString(C25738R.string.f9238tz), new C76919(), new C767810());
                        obj = 1;
                        break;
                    case -75:
                        C30379h.m48467g(this, C25738R.string.f8810fn, C25738R.string.djw);
                        obj = 1;
                        break;
                    case -43:
                        Toast.makeText(this, C25738R.string.a6h, 0).show();
                        obj = 1;
                        break;
                    case -41:
                        Toast.makeText(this, C25738R.string.a6j, 0).show();
                        obj = 1;
                        break;
                    case -36:
                        Toast.makeText(this, C25738R.string.a6m, 0).show();
                        obj = 1;
                        break;
                    case -34:
                        Toast.makeText(this, C25738R.string.a6k, 0).show();
                        obj = 1;
                        break;
                    case -33:
                        C30379h.m48431a((Context) this, (int) C25738R.string.a7s, (int) C25738R.string.a7y, new C76898());
                        obj = 1;
                        break;
                    case -32:
                        C30379h.m48438a(this, getString(C25738R.string.a7u), "", new C76947());
                        obj = 1;
                        break;
                }
            }
            obj = 1;
            if (obj != null) {
                AppMethodBeat.m2505o(125231);
                return;
            }
            if (c1207m.getType() == 252 || c1207m.getType() == 701) {
                jY = C42124a.m74268jY(str);
                if (jY != null && jY.mo67668a(this.mController.ylL, null, null)) {
                    AppMethodBeat.m2505o(125231);
                    return;
                }
            }
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this.mController.ylL, getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.m2505o(125231);
        } else if (i2 == -6 || i2 == -311 || i2 == -310) {
            this.gBT.account = this.username;
            this.gBT.gCK = this.gEr;
            this.gBT.guh = ((C6686q) c1207m).ajn();
            this.gBT.gug = ((C6686q) c1207m).ajo();
            this.gBT.gui = ((C6686q) c1207m).ajp();
            this.gBT.gCL = ((C6686q) c1207m).getSecCodeType();
            if (this.gue == null) {
                this.gue = C15492a.m23811a(this, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new C767917(), null, new C767618(), this.gBT);
                AppMethodBeat.m2505o(125231);
                return;
            }
            this.gue.mo27573b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
            AppMethodBeat.m2505o(125231);
        } else {
            this.cOG = ((C6686q) c1207m).ajm();
            this.gDu.mo21363a(this, i, i2, str, c1207m);
            if (c1207m instanceof C6686q) {
                this.gEo = ((C6686q) c1207m).ajv();
            }
            if (i == 0 && i2 == 0) {
                final C1207m c9706r = new C9706r(1);
                C1720g.m3540Rg().mo14541a(c9706r, 0);
                getString(C25738R.string.f9238tz);
                this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9160rd), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125221);
                        C1720g.m3540Rg().mo14547c(c9706r);
                        AppMethodBeat.m2505o(125221);
                    }
                });
                if (!C5046bo.isNullOrNil(this.gEt)) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LOGIN_SHOW_BIND_THIRD_ADD_TYPE_INT, Integer.valueOf(this.gEu));
                }
            }
            AppMethodBeat.m2505o(125231);
        }
    }

    /* renamed from: o */
    static /* synthetic */ void m13718o(MobileLoginOrForceReg mobileLoginOrForceReg) {
        AppMethodBeat.m2504i(125232);
        final C1207m c26472s = new C26472s("", mobileLoginOrForceReg.gEr, mobileLoginOrForceReg.gEq, 0, "", mobileLoginOrForceReg.cFl, "", "", mobileLoginOrForceReg.cxb, mobileLoginOrForceReg.fPA, "", "", "", true, mobileLoginOrForceReg.gEp);
        c26472s.mo44236ts(mobileLoginOrForceReg.gDy);
        c26472s.mo44237tt(mobileLoginOrForceReg.gEt);
        c26472s.mo44235lX(mobileLoginOrForceReg.gEm);
        C1720g.m3540Rg().mo14541a(c26472s, 0);
        Context context = mobileLoginOrForceReg.mController.ylL;
        mobileLoginOrForceReg.getString(C25738R.string.f9238tz);
        mobileLoginOrForceReg.ehJ = C30379h.m48458b(context, mobileLoginOrForceReg.getString(C25738R.string.dmm), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(125210);
                C1720g.m3540Rg().mo14547c(c26472s);
                AppMethodBeat.m2505o(125210);
            }
        });
        AppMethodBeat.m2505o(125232);
    }
}
