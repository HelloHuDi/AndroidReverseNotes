package com.tencent.p177mm.plugin.account.p275ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelsimple.C26472s;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p182ah.C37439m;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.p275ui.C10004g.C10008a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44090k;
import com.tencent.p177mm.protocal.C30167n.C7244a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI */
public class RegByMobileSendSmsUI extends MMActivity implements C1202f {
    private String bCu;
    private int countDown = 15;
    private String cxb;
    private String gAN = "";
    private C42085ba gBm = new C42085ba();
    private String gDC;
    private C10004g gDu;
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
    private C7564ap gGo;
    private SecurityImage gGp;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$10 */
    class C998210 implements OnMenuItemClickListener {
        C998210() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125407);
            RegByMobileSendSmsUI.m42488d(RegByMobileSendSmsUI.this);
            AppMethodBeat.m2505o(125407);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$1 */
    class C99841 implements OnClickListener {
        C99841() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125398);
            RegByMobileSendSmsUI.m42484a(RegByMobileSendSmsUI.this);
            AppMethodBeat.m2505o(125398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$2 */
    class C99852 implements OnDismissListener {
        C99852() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125399);
            RegByMobileSendSmsUI.this.gGp = null;
            AppMethodBeat.m2505o(125399);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$7 */
    class C266257 implements C5015a {
        C266257() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(125404);
            if (RegByMobileSendSmsUI.this.countDown > 0) {
                RegByMobileSendSmsUI.this.gGn.setText(RegByMobileSendSmsUI.this.getString(C25738R.string.dlh, new Object[]{Integer.valueOf(RegByMobileSendSmsUI.this.countDown)}));
                RegByMobileSendSmsUI.this.countDown = RegByMobileSendSmsUI.this.countDown - 1;
                if (RegByMobileSendSmsUI.this.countDown % 4 == 0) {
                    RegByMobileSendSmsUI.m42503s(RegByMobileSendSmsUI.this);
                }
                AppMethodBeat.m2505o(125404);
                return true;
            }
            RegByMobileSendSmsUI.this.gGn.setText(C25738R.string.dl8);
            RegByMobileSendSmsUI.this.gGn.setEnabled(true);
            AppMethodBeat.m2505o(125404);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$8 */
    class C266268 implements DialogInterface.OnClickListener {
        C266268() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125405);
            RegByMobileSendSmsUI.m42504t(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.this.finish();
            AppMethodBeat.m2505o(125405);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$9 */
    class C266279 implements OnClickListener {
        C266279() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125406);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.this.gGj));
            intent.putExtra("sms_body", RegByMobileSendSmsUI.this.gAN);
            try {
                RegByMobileSendSmsUI.this.startActivity(intent);
                RegByMobileSendSmsUI.this.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                AppMethodBeat.m2505o(125406);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.RegByMobileSendSmsUI", e.getMessage());
                AppMethodBeat.m2505o(125406);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$13 */
    class C2662913 implements DialogInterface.OnClickListener {
        C2662913() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$15 */
    class C2663015 implements DialogInterface.OnClickListener {
        C2663015() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI$6 */
    class C266316 implements C10008a {
        C266316() {
        }

        /* renamed from: a */
        public final void mo17503a(ProgressDialog progressDialog) {
            AppMethodBeat.m2504i(125403);
            RegByMobileSendSmsUI.this.gGk = progressDialog;
            AppMethodBeat.m2505o(125403);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RegByMobileSendSmsUI() {
        AppMethodBeat.m2504i(125413);
        AppMethodBeat.m2505o(125413);
    }

    /* renamed from: d */
    static /* synthetic */ void m42488d(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.m2504i(125424);
        regByMobileSendSmsUI.goBack();
        AppMethodBeat.m2505o(125424);
    }

    /* renamed from: t */
    static /* synthetic */ void m42504t(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.m2504i(125427);
        regByMobileSendSmsUI.stopTimer();
        AppMethodBeat.m2505o(125427);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125414);
        super.onCreate(bundle);
        this.gEs = getIntent().getIntExtra("key_reg_style", 1);
        this.gGi = C5046bo.nullAsNil(getIntent().getStringExtra("from_mobile"));
        this.gGj = C5046bo.nullAsNil(getIntent().getStringExtra("to_mobile"));
        this.gAN = C5046bo.nullAsNil(getIntent().getStringExtra("verify_code"));
        this.gDy = C5046bo.nullAsNil(getIntent().getStringExtra("regsession_id"));
        this.gFm = C5046bo.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
        this.bCu = C5046bo.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
        this.gDC = C5046bo.nullAsNil(getIntent().getStringExtra("kintent_password"));
        this.gFM = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        initView();
        AppMethodBeat.m2505o(125414);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125415);
        super.initView();
        ((TextView) findViewById(2131826935)).setText(getString(C25738R.string.dld, new Object[]{this.gGi}));
        ((TextView) findViewById(2131826936)).setText(m42505ww(getString(C25738R.string.dlc, new Object[]{this.gAN})));
        ((TextView) findViewById(2131826937)).setText(m42505ww(getString(C25738R.string.dlf, new Object[]{this.gGj})));
        this.gGm = (Button) findViewById(2131826939);
        this.gGn = (Button) findViewById(2131826940);
        if (C5046bo.m7510Q(this.gGi, this.gGj, this.gAN)) {
            this.gGm.setEnabled(false);
            this.gGn.setEnabled(false);
        } else {
            this.gGn.setOnClickListener(new C99841());
        }
        if (C5046bo.isNullOrNil(C1427q.getSimCountryIso())) {
            this.gGm.setVisibility(8);
        } else {
            this.gGm.setOnClickListener(new C266279());
        }
        setMMTitle((int) C25738R.string.dle);
        setBackBtn(new C998210());
        AppMethodBeat.m2505o(125415);
    }

    /* renamed from: ww */
    private C44090k m42505ww(String str) {
        AppMethodBeat.m2504i(125416);
        C44090k c44090k = new C44090k(str);
        C4990ab.m7411d("MicroMsg.RegByMobileSendSmsUI", "content: %s", str);
        int indexOf = str.indexOf(32) + 1;
        c44090k.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(C25738R.dimen.f9939ku)), indexOf, str.length(), 33);
        c44090k.setSpan(new ForegroundColorSpan(getResources().getColor(C25738R.color.f12069r8)), indexOf, str.length(), 33);
        AppMethodBeat.m2505o(125416);
        return c44090k;
    }

    public final int getLayoutId() {
        return 2130970497;
    }

    public void onResume() {
        AppMethodBeat.m2504i(125417);
        super.onResume();
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        AppMethodBeat.m2505o(125417);
    }

    public void onStop() {
        AppMethodBeat.m2504i(125418);
        super.onStop();
        stopTimer();
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        AppMethodBeat.m2505o(125418);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125419);
        C4990ab.m7417i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gGk != null) {
            this.gGk.dismiss();
        }
        Intent intent;
        C42124a jY;
        if (c1207m.getType() == 145 && ((C32815a) c1207m).mo53366Ah() == 15) {
            C32815a c32815a = (C32815a) c1207m;
            this.cxb = c32815a.agg();
            if (i2 == 0) {
                stopTimer();
                if (this.gEs == 1) {
                    C1720g.m3540Rg().mo14539a(126, (C1202f) this);
                    final C1207m c26472s = new C26472s("", this.gDC, this.bCu, 0, "", this.gGi, "", "", this.cxb, 1, "", "", "", true, this.gFM);
                    c26472s.mo44236ts(this.gDy);
                    c26472s.mo44237tt(this.gFm);
                    c26472s.mo44235lX(1);
                    C1720g.m3540Rg().mo14541a(c26472s, 0);
                    getString(C25738R.string.f9238tz);
                    this.gGk = C30379h.m48458b((Context) this, getString(C25738R.string.dmm), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(125408);
                            C1720g.m3540Rg().mo14547c(c26472s);
                            C1720g.m3540Rg().mo14546b(126, RegByMobileSendSmsUI.this);
                            AppMethodBeat.m2505o(125408);
                        }
                    });
                    AppMethodBeat.m2505o(125419);
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
                intent.putExtra("regsetinfo_NextControl", c32815a.agm());
                intent.putExtra("key_reg_style", this.gEs);
                intent.setClass(this, RegSetInfoUI.class);
                startActivity(intent);
                AppMethodBeat.m2505o(125419);
                return;
            } else if (i2 == -35) {
                stopTimer();
                jY = C42124a.m74268jY(str);
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 7;
                this.gBm.ajK();
                final C32815a c32815a2;
                if (jY != null) {
                    c32815a2 = c32815a;
                    jY.mo67668a(this, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(125409);
                            C1720g.m3540Rg().mo14539a(701, RegByMobileSendSmsUI.this);
                            C1720g.m3540Rg().mo14539a(252, RegByMobileSendSmsUI.this);
                            RegByMobileSendSmsUI.m42485a(RegByMobileSendSmsUI.this, c32815a2.getUsername(), c32815a2.agf());
                            RegByMobileSendSmsUI.this.gBm.daR = (long) RegByMobileSendSmsUI.this.gEu;
                            RegByMobileSendSmsUI.this.gBm.cVS = 8;
                            RegByMobileSendSmsUI.this.gBm.ajK();
                            AppMethodBeat.m2505o(125409);
                        }
                    }, new C2662913());
                    AppMethodBeat.m2505o(125419);
                    return;
                }
                c32815a2 = c32815a;
                C30379h.m48440a((Context) this, getString(C25738R.string.a63), null, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(125410);
                        RegByMobileSendSmsUI.m42485a(RegByMobileSendSmsUI.this, c32815a2.getUsername(), c32815a2.agf());
                        RegByMobileSendSmsUI.this.gBm.daR = (long) RegByMobileSendSmsUI.this.gEu;
                        RegByMobileSendSmsUI.this.gBm.cVS = 8;
                        RegByMobileSendSmsUI.this.gBm.ajK();
                        AppMethodBeat.m2505o(125410);
                    }
                }, new C2663015());
                AppMethodBeat.m2505o(125419);
                return;
            } else if (i2 == -212) {
                stopTimer();
                intent = new Intent(this, MobileLoginOrForceReg.class);
                intent.putExtra("ticket", this.cxb);
                intent.putExtra("moble", this.gGi);
                intent.putExtra("regsession_id", this.gDy);
                intent.putExtra("reg_3d_app_ticket", this.gFm);
                intent.putExtra("reg_3d_app_type", this.gEu);
                intent.putExtra("next_controll", c32815a.agm());
                intent.putExtra("username", c32815a.getUsername());
                intent.putExtra("password", c32815a.agf());
                intent.putExtra("nickname", c32815a.ags());
                intent.putExtra("avatar_url", c32815a.agr());
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("kintent_hasavatar", this.gFM);
                intent.putExtra("kintent_nickname", this.bCu);
                intent.putExtra("kintent_password", this.gDC);
                intent.putExtra("key_reg_style", this.gEs);
                startActivity(intent);
                AppMethodBeat.m2505o(125419);
                return;
            } else {
                if (!C5046bo.isNullOrNil(str) && this.gGl >= 4) {
                    jY = C42124a.m74268jY(str);
                    if (jY != null && jY.mo67668a(this, null, null)) {
                        AppMethodBeat.m2505o(125419);
                        return;
                    }
                }
                AppMethodBeat.m2505o(125419);
                return;
            }
        }
        if (c1207m.getType() == 126) {
            final C26472s c26472s2 = (C26472s) c1207m;
            if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.gGp == null) {
                    this.gGp = C15492a.m23811a(this, 0, c26472s2.ajo(), c26472s2.ajn(), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(125412);
                            final C1207m c26472s = new C26472s("", RegByMobileSendSmsUI.this.gDC, RegByMobileSendSmsUI.this.bCu, 0, "", RegByMobileSendSmsUI.this.gGi, "", "", RegByMobileSendSmsUI.this.cxb, 1, "", c26472s2.ajn(), RegByMobileSendSmsUI.this.gGp.getSecImgCode(), true, RegByMobileSendSmsUI.this.gFM);
                            c26472s.mo44236ts(RegByMobileSendSmsUI.this.gDy);
                            c26472s.mo44237tt(RegByMobileSendSmsUI.this.gFm);
                            c26472s.mo44235lX(1);
                            C1720g.m3540Rg().mo14541a(c26472s, 0);
                            RegByMobileSendSmsUI regByMobileSendSmsUI = RegByMobileSendSmsUI.this;
                            Context context = RegByMobileSendSmsUI.this.mController.ylL;
                            RegByMobileSendSmsUI.this.getString(C25738R.string.f9238tz);
                            regByMobileSendSmsUI.gGk = C30379h.m48458b(context, RegByMobileSendSmsUI.this.getString(C25738R.string.dmm), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(125411);
                                    C1720g.m3540Rg().mo14547c(c26472s);
                                    AppMethodBeat.m2505o(125411);
                                }
                            });
                            AppMethodBeat.m2505o(125412);
                        }
                    }, null, new C99852(), new C15494b() {
                        public final void apw() {
                            AppMethodBeat.m2504i(125400);
                            RegByMobileSendSmsUI.this.aqX();
                            C1207m c26472s = new C26472s("", RegByMobileSendSmsUI.this.gDC, RegByMobileSendSmsUI.this.bCu, 0, "", RegByMobileSendSmsUI.this.gGi, "", "", RegByMobileSendSmsUI.this.cxb, 1, "", c26472s2.ajn(), RegByMobileSendSmsUI.this.gGp.getSecImgCode(), true, RegByMobileSendSmsUI.this.gFM);
                            c26472s.mo44236ts(RegByMobileSendSmsUI.this.gDy);
                            c26472s.mo44237tt(RegByMobileSendSmsUI.this.gFm);
                            c26472s.mo44235lX(1);
                            C1720g.m3540Rg().mo14541a(c26472s, 0);
                            AppMethodBeat.m2505o(125400);
                        }
                    });
                    AppMethodBeat.m2505o(125419);
                    return;
                }
                this.gGp.mo27573b(0, ((C26472s) c1207m).ajo(), ((C26472s) c1207m).ajn(), "");
                AppMethodBeat.m2505o(125419);
                return;
            } else if (i == 0 && i2 == 0) {
                final String str2 = this.gGi;
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 6;
                this.gBm.ajK();
                C1668a.unhold();
                C1668a.m3401cm(true);
                if (this.gFM) {
                    String str3 = C6457e.euY + "temp.avatar";
                    String str4 = C6457e.euY + "temp.avatar.hd";
                    C5730e.m8623aQ(str3, str4);
                    C5730e.deleteFile(str3);
                    C5056d.m7656c(str4, 96, 96, CompressFormat.JPEG, 90, str3);
                    new C37439m(this, C6457e.euY + "temp.avatar").mo60329a(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(125401);
                            RegByMobileSendSmsUI.this.cxb = c26472s2.ajw();
                            C6665av.fly.mo14897ak("login_user_name", str2);
                            C5730e.deleteFile(C6457e.euY + "temp.avatar");
                            Intent bh = C24679a.gkE.mo38909bh(RegByMobileSendSmsUI.this);
                            bh.addFlags(67108864);
                            RegByMobileSendSmsUI.this.startActivity(bh);
                            StringBuilder stringBuilder = new StringBuilder();
                            C1720g.m3534RN();
                            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                            C1720g.m3534RN();
                            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_600")).append(",4").toString());
                            RegByMobileSendSmsUI.this.finish();
                            AppMethodBeat.m2505o(125401);
                        }
                    }, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(125402);
                            RegByMobileSendSmsUI.this.cxb = c26472s2.ajw();
                            C6665av.fly.mo14897ak("login_user_name", str2);
                            Intent bh = C24679a.gkE.mo38909bh(RegByMobileSendSmsUI.this);
                            bh.addFlags(67108864);
                            RegByMobileSendSmsUI.this.startActivity(bh);
                            StringBuilder stringBuilder = new StringBuilder();
                            C1720g.m3534RN();
                            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                            C1720g.m3534RN();
                            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_600")).append(",4").toString());
                            RegByMobileSendSmsUI.this.finish();
                            AppMethodBeat.m2505o(125402);
                        }
                    });
                    AppMethodBeat.m2505o(125419);
                    return;
                }
                this.cxb = c26472s2.ajw();
                C6665av.fly.mo14897ak("login_user_name", str2);
                intent = C24679a.gkE.mo38909bh(this);
                intent.addFlags(67108864);
                intent.putExtra("LauncherUI.enter_from_reg", true);
                startActivity(intent);
                finish();
                C42756a.m75796wA("RE900_100");
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_600,");
                C1720g.m3534RN();
                C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R200_600")).append(",4").toString());
                AppMethodBeat.m2505o(125419);
                return;
            } else {
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this, null, null);
                    AppMethodBeat.m2505o(125419);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(125419);
    }

    private void stopTimer() {
        AppMethodBeat.m2504i(125420);
        if (this.gGo != null) {
            this.gGo.stopTimer();
        }
        this.gGn.setText(C25738R.string.dl8);
        this.gGn.setEnabled(true);
        AppMethodBeat.m2505o(125420);
    }

    private void goBack() {
        AppMethodBeat.m2504i(125421);
        C30379h.m48440a((Context) this, getString(C25738R.string.dl_), "", new C266268(), null);
        AppMethodBeat.m2505o(125421);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125422);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(125422);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125422);
        return onKeyDown;
    }

    /* renamed from: a */
    static /* synthetic */ void m42484a(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.m2504i(125423);
        regByMobileSendSmsUI.gGn.setEnabled(false);
        if (regByMobileSendSmsUI.gGo != null) {
            regByMobileSendSmsUI.gGo.stopTimer();
            regByMobileSendSmsUI.countDown = 15;
            regByMobileSendSmsUI.gGl = 0;
            regByMobileSendSmsUI.gGo.mo16770ae(0, 1000);
            AppMethodBeat.m2505o(125423);
            return;
        }
        regByMobileSendSmsUI.gGo = new C7564ap(new C266257(), true);
        regByMobileSendSmsUI.gGo.mo16770ae(0, 1000);
        AppMethodBeat.m2505o(125423);
    }

    /* renamed from: a */
    static /* synthetic */ void m42485a(RegByMobileSendSmsUI regByMobileSendSmsUI, String str, String str2) {
        AppMethodBeat.m2504i(125425);
        C1720g.m3540Rg().mo14539a(701, (C1202f) regByMobileSendSmsUI);
        C1720g.m3540Rg().mo14539a(252, (C1202f) regByMobileSendSmsUI);
        regByMobileSendSmsUI.gDu = new C10004g(new C266316(), str, str2, regByMobileSendSmsUI.gGi);
        regByMobileSendSmsUI.gDu.mo21362a(regByMobileSendSmsUI);
        AppMethodBeat.m2505o(125425);
    }

    /* renamed from: s */
    static /* synthetic */ void m42503s(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        AppMethodBeat.m2504i(125426);
        regByMobileSendSmsUI.gGl++;
        if (regByMobileSendSmsUI.gGl <= 4) {
            C1207m c32815a = new C32815a(regByMobileSendSmsUI.gGi, 15, "", 0, "");
            ((C7244a) c32815a.ftU.acF()).vyq.vLC = 1;
            C1720g.m3540Rg().mo14541a(c32815a, 0);
        }
        AppMethodBeat.m2505o(125426);
    }
}
