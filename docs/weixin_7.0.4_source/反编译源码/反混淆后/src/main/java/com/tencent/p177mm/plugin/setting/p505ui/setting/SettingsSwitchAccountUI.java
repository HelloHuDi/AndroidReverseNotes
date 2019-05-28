package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelsimple.C32822ab;
import com.tencent.p177mm.modelsimple.C32828p;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.modelstat.C37957c;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p230g.p231a.C6484gj;
import com.tencent.p177mm.p612ui.C5510e.C5497d;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.p275ui.LoginPasswordUI;
import com.tencent.p177mm.plugin.account.p275ui.LoginVoiceUI;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileSetPwdUI;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.expt.p394a.C43014c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView.C348896;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView.C34890b;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView.C38204;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView.C38215;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView.C3822a;
import com.tencent.p177mm.plugin.setting.p505ui.widget.SwitchAccountGridView.C39686c;
import com.tencent.p177mm.protocal.protobuf.ayx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI */
public class SettingsSwitchAccountUI extends MMActivity implements C1202f {
    private String gCZ;
    private TextView gqX;
    private SwitchAccountGridView qkN;
    private Map<String, SwitchAccountModel> qkR = new HashMap();
    private boolean qnu;
    private TextView qpa;
    private View qpb;
    private View qpc;
    private TextView qpd;
    private ValueAnimator qpe;
    private C7564ap qpf;
    private boolean qpg;
    private boolean qph;
    private int scene;
    private TextView titleView;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$10 */
    class C2178110 implements C3822a {
        C2178110() {
        }

        public final void cjg() {
            AppMethodBeat.m2504i(138711);
            SettingsSwitchAccountUI.this.qkN.setLastLoginWxUsername(C1853r.m3846Yz());
            SettingsSwitchAccountUI.this.qkN.setSwitchToWxUsername("");
            SettingsSwitchAccountUI.this.qkN.cjt();
            SettingsSwitchAccountUI.this.qpe.start();
            AppMethodBeat.m2505o(138711);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$1 */
    class C217821 implements C34890b {
        C217821() {
        }

        /* renamed from: Wy */
        public final void mo37250Wy(String str) {
            AppMethodBeat.m2504i(138704);
            if (C5046bo.isNullOrNil(str)) {
                C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
                if (SettingsSwitchAccountUI.this.scene == 0) {
                    SettingsSwitchAccountUI.cjf();
                    AppMethodBeat.m2505o(138704);
                    return;
                }
                Intent intent = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("from_switch_account", true);
                SettingsSwitchAccountUI.this.startActivity(intent);
                C5274b.m8052hK(SettingsSwitchAccountUI.this);
                AppMethodBeat.m2505o(138704);
            } else if (SettingsSwitchAccountUI.this.scene == 0) {
                SettingsSwitchAccountUI.m33323a(SettingsSwitchAccountUI.this, str);
                AppMethodBeat.m2505o(138704);
            } else {
                SettingsSwitchAccountUI.m33327b(SettingsSwitchAccountUI.this, str);
                AppMethodBeat.m2505o(138704);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$2 */
    class C217832 implements C5015a {
        C217832() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(138705);
            SettingsSwitchAccountUI.m33335i(SettingsSwitchAccountUI.this);
            AppMethodBeat.m2505o(138705);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$8 */
    class C217858 implements OnClickListener {
        C217858() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127506);
            SettingsSwitchAccountUI.this.qnu = false;
            SettingsSwitchAccountUI.this.qph = false;
            SettingsSwitchAccountUI.this.qkN.setDeleteState(false);
            SettingsSwitchAccountUI.this.qkN.cjt();
            SettingsSwitchAccountUI.m33331e(SettingsSwitchAccountUI.this);
            if (SettingsSwitchAccountUI.this.qkN.getAccountCount() == 0) {
                if (C37914bx.fnB.aat().size() > 1) {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(11), C37914bx.fnB.aau());
                } else {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(11), C37914bx.fnB.aau());
                }
                Intent bh = C24679a.gkE.mo38909bh(SettingsSwitchAccountUI.this);
                bh.addFlags(67108864);
                SettingsSwitchAccountUI.this.startActivity(bh);
                SettingsSwitchAccountUI.this.finish();
                C5274b.m8054hM(SettingsSwitchAccountUI.this);
                SettingsSwitchAccountUI.this.qpg = false;
            }
            AppMethodBeat.m2505o(127506);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$9 */
    class C217869 implements OnClickListener {
        C217869() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127507);
            SettingsSwitchAccountUI.this.qnu = false;
            SettingsSwitchAccountUI.this.qph = false;
            SettingsSwitchAccountUI.this.qkN.setDeleteState(false);
            SettingsSwitchAccountUI.this.qkN.cjt();
            SettingsSwitchAccountUI.m33331e(SettingsSwitchAccountUI.this);
            AppMethodBeat.m2505o(127507);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$3 */
    class C217873 implements OnClickListener {
        C217873() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138706);
            SettingsSwitchAccountUI.m33326b(SettingsSwitchAccountUI.this);
            AppMethodBeat.m2505o(138706);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$4 */
    class C217884 implements C39686c {
        C217884() {
        }

        /* renamed from: Wz */
        public final void mo37255Wz(final String str) {
            AppMethodBeat.m2504i(138707);
            C30379h.m48466d(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(C25738R.string.ebe, new Object[]{((SwitchAccountModel) SettingsSwitchAccountUI.this.qkR.get(str)).username}), SettingsSwitchAccountUI.this.getString(C25738R.string.f9238tz), SettingsSwitchAccountUI.this.getString(C25738R.string.f9262up), SettingsSwitchAccountUI.this.getString(C25738R.string.f9183s2), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(127502);
                    C4990ab.m7417i("MicroMsg.SettingsSwitchAccountUI", "delete %s", str);
                    SettingsSwitchAccountUI.this.qph = true;
                    C37914bx.fnB.mo60669oK(str);
                    SettingsSwitchAccountUI.this.qkR.remove(str);
                    SwitchAccountGridView d = SettingsSwitchAccountUI.this.qkN;
                    String str = str;
                    if (d.qrf.contains(str)) {
                        int indexOf = d.qrf.indexOf(str);
                        d.qrf.remove(str);
                        d.qrg.remove(indexOf);
                        d.qrh.remove(indexOf);
                    }
                    SettingsSwitchAccountUI.this.qkN.cjt();
                    SettingsSwitchAccountUI.m33331e(SettingsSwitchAccountUI.this);
                    if (SettingsSwitchAccountUI.this.scene == 0) {
                        if (C37914bx.fnB.aat().size() > 0) {
                            C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(4), C37914bx.fnB.aau());
                            AppMethodBeat.m2505o(127502);
                            return;
                        }
                        C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(4), C37914bx.fnB.aau());
                    }
                    AppMethodBeat.m2505o(127502);
                }
            }, null);
            AppMethodBeat.m2505o(138707);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$5 */
    class C217895 implements AnimatorUpdateListener {
        C217895() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(138708);
            SettingsSwitchAccountUI.this.qkN.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) SettingsSwitchAccountUI.this.qkN.getHeight()));
            AppMethodBeat.m2505o(138708);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$6 */
    class C217906 extends AnimatorListenerAdapter {
        C217906() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(138709);
            C4990ab.m7416i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
            Intent bh = C24679a.gkE.mo38909bh(SettingsSwitchAccountUI.this);
            bh.addFlags(67108864);
            SettingsSwitchAccountUI.this.startActivity(bh);
            SettingsSwitchAccountUI.this.finish();
            C5274b.m8054hM(SettingsSwitchAccountUI.this);
            AppMethodBeat.m2505o(138709);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI$7 */
    class C217917 implements OnClickListener {
        C217917() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(138710);
            if (!SettingsSwitchAccountUI.this.qnu) {
                SettingsSwitchAccountUI.this.qnu = true;
                SettingsSwitchAccountUI.this.qkN.setDeleteState(SettingsSwitchAccountUI.this.qnu);
                SettingsSwitchAccountUI.this.qkN.cjt();
                SettingsSwitchAccountUI.m33331e(SettingsSwitchAccountUI.this);
                if (C37914bx.fnB.aat().size() > 1) {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(3), C37914bx.fnB.aau());
                    AppMethodBeat.m2505o(138710);
                    return;
                }
                C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(3), C37914bx.fnB.aau());
            }
            AppMethodBeat.m2505o(138710);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsSwitchAccountUI() {
        AppMethodBeat.m2504i(127509);
        AppMethodBeat.m2505o(127509);
    }

    /* renamed from: b */
    static /* synthetic */ void m33326b(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.m2504i(138715);
        settingsSwitchAccountUI.goBack();
        AppMethodBeat.m2505o(138715);
    }

    static /* synthetic */ void cjf() {
        AppMethodBeat.m2504i(138714);
        SettingsSwitchAccountUI.logout();
        AppMethodBeat.m2505o(138714);
    }

    /* renamed from: e */
    static /* synthetic */ void m33331e(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.m2504i(138716);
        settingsSwitchAccountUI.cjc();
        AppMethodBeat.m2505o(138716);
    }

    /* renamed from: i */
    static /* synthetic */ void m33335i(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        AppMethodBeat.m2504i(138717);
        settingsSwitchAccountUI.cje();
        AppMethodBeat.m2505o(138717);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127510);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127510);
    }

    public final void initView() {
        Intent intent;
        AppMethodBeat.m2504i(127511);
        setMMTitle("");
        dyf();
        getSupportActionBar().hide();
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.qpb = findViewById(2131827429);
        this.qpc = findViewById(2131827428);
        this.titleView = (TextView) findViewById(2131827432);
        this.qpd = (TextView) findViewById(2131827431);
        this.qpa = (TextView) findViewById(2131827434);
        this.gqX = (TextView) findViewById(2131827427);
        this.qkN = (SwitchAccountGridView) findViewById(2131827433);
        this.qkN.setRowCount(1);
        this.qkN.setOnClickAvatarListener(new C217821());
        if (this.scene == 0) {
            this.gqX.setOnClickListener(new C217873());
        } else {
            this.gqX.setVisibility(8);
        }
        Set<String> aat = C37914bx.fnB.aat();
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            this.gCZ = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
        } else {
            this.gCZ = C6665av.fly.mo5292T("login_weixin_username", "");
        }
        C4990ab.m7417i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", Integer.valueOf(this.scene), this.gCZ);
        if (C5046bo.isNullOrNil(this.gCZ) || aat.contains(this.gCZ)) {
            if (!aat.isEmpty()) {
                for (String str : aat) {
                    this.qkR.put(str, new SwitchAccountModel(str, C37914bx.fnB.getString(str, "login_user_name"), C37914bx.fnB.getString(str, "last_avatar_path"), C37914bx.fnB.getString(str, "last_logout_no_pwd_ticket"), C5046bo.ank(C37914bx.fnB.getString(str, "last_login_use_voice"))));
                }
            }
        } else if (this.scene != 2 || C37914bx.fnB.mo60671oM(this.gCZ)) {
            this.qkR.put(this.gCZ, new SwitchAccountModel(this.gCZ, C6665av.fly.mo5292T("login_user_name", ""), C6665av.fly.mo14896ZC(), "", C5046bo.ank(C6665av.fly.mo5292T("last_login_use_voice", ""))));
        }
        if (this.qkR.size() == 0) {
            intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            intent.putExtra("can_finish", true);
            startActivity(intent);
            finish();
            C5274b.m8055hN(this);
        }
        SettingsSwitchAccountUI.m33325aa(this.qkR);
        this.qkN.mo69065ab(this.qkR);
        if (this.scene == 1) {
            String string = C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "");
            C4990ab.m7417i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", string);
            if (C5046bo.isNullOrNil(string)) {
                this.qpg = false;
                intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("from_switch_account", true);
                startActivity(intent);
                C5274b.m8052hK(this);
            } else {
                C1720g.m3534RN();
                if (C1668a.m3395QX()) {
                    C4990ab.m7420w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
                    finish();
                } else {
                    m33321Wx(string);
                }
            }
        } else if (this.scene == 0) {
            this.qkN.setLastLoginWxUsername(this.gCZ);
        }
        this.qkN.cjt();
        cjc();
        this.qkN.setOnDeleteAvatarListener(new C217884());
        cjb();
        AppMethodBeat.m2505o(127511);
    }

    private void cjb() {
        AppMethodBeat.m2504i(138712);
        this.qpe = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qpe.addUpdateListener(new C217895());
        this.qpe.addListener(new C217906());
        this.qpe.setDuration(500);
        AppMethodBeat.m2505o(138712);
    }

    /* renamed from: aa */
    private static void m33325aa(Map<String, SwitchAccountModel> map) {
        AppMethodBeat.m2504i(127512);
        if (map.size() == 2) {
            String[] strArr = new String[2];
            int i = 0;
            for (SwitchAccountModel switchAccountModel : map.values()) {
                int i2 = i + 1;
                strArr[i] = switchAccountModel.username;
                i = i2;
            }
            if (!C5046bo.m7510Q(strArr[0], strArr[1]) && strArr[0].equals(strArr[1])) {
                for (String oK : map.keySet()) {
                    C37914bx.fnB.mo60669oK(oK);
                }
                NullPointerException nullPointerException = new NullPointerException(String.format("tow accounts have the same username!!! , %s, %s", new Object[]{strArr[0], strArr[1]}));
                AppMethodBeat.m2505o(127512);
                throw nullPointerException;
            }
        }
        AppMethodBeat.m2505o(127512);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127513);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(127513);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(127513);
        return onKeyDown;
    }

    /* renamed from: Wx */
    private void m33321Wx(String str) {
        AppMethodBeat.m2504i(127514);
        SwitchAccountModel switchAccountModel = (SwitchAccountModel) this.qkR.get(str);
        if (!(switchAccountModel == null || this.qpg)) {
            this.qpg = true;
            C1720g.m3540Rg().mo14541a(new C6686q(str, switchAccountModel.username, switchAccountModel.qjL, ""), 0);
            this.qkN.setSwitchToWxUsername(str);
            this.qkN.cjt();
            cjc();
        }
        AppMethodBeat.m2505o(127514);
    }

    private void cjc() {
        AppMethodBeat.m2504i(127515);
        if (this.qpg) {
            this.qpa.setVisibility(8);
            AppMethodBeat.m2505o(127515);
        } else if (this.qkR.size() <= 1 && this.scene == 0) {
            this.qpa.setVisibility(8);
            this.qnu = false;
            this.qkN.setDeleteState(false);
            AppMethodBeat.m2505o(127515);
        } else if (this.qnu) {
            this.titleView.setText(C25738R.string.ebg);
            this.qpd.setVisibility(0);
            if (this.qph) {
                this.qpa.setText(getString(C25738R.string.f9142qt));
                this.qpa.setOnClickListener(new C217858());
                AppMethodBeat.m2505o(127515);
                return;
            }
            this.qpa.setText(getString(C25738R.string.f9076or));
            this.qpa.setOnClickListener(new C217869());
            AppMethodBeat.m2505o(127515);
        } else {
            this.titleView.setText(C25738R.string.ebi);
            this.qpd.setVisibility(8);
            this.qpa.setText(getString(C25738R.string.ebg));
            this.qpa.setOnClickListener(new C217917());
            AppMethodBeat.m2505o(127515);
        }
    }

    public void onResume() {
        AppMethodBeat.m2504i(127516);
        super.onResume();
        C4990ab.m7416i("MicroMsg.SettingsSwitchAccountUI", "onResume");
        if (this.scene == 1 || this.scene == 2) {
            C1720g.m3540Rg().mo14539a(701, (C1202f) this);
            C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        }
        if (this.scene == 0) {
            C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_TRANS_KONGCHENG, (C1202f) this);
            C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_BAIXI, (C1202f) this);
            C1720g.m3540Rg().mo14539a(255, (C1202f) this);
        }
        this.qkN.cjt();
        cjc();
        if ((this.scene == 1 || this.scene == 2) && C1720g.m3531RK() && C1720g.m3534RN().eJb) {
            C4990ab.m7416i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
            this.qpg = true;
            Intent bh = C24679a.gkE.mo38909bh(this);
            bh.addFlags(67108864);
            startActivity(bh);
            finish();
            C5274b.m8054hM(this);
        }
        AppMethodBeat.m2505o(127516);
    }

    public void onStop() {
        AppMethodBeat.m2504i(127517);
        super.onStop();
        C4990ab.m7416i("MicroMsg.SettingsSwitchAccountUI", "onStop");
        if (this.scene == 1) {
            SwitchAccountGridView switchAccountGridView = this.qkN;
            if (switchAccountGridView.qrd) {
                switchAccountGridView.qrd = false;
                if (switchAccountGridView.qre != null) {
                    switchAccountGridView.qre.end();
                }
            }
        }
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_BAIXI, (C1202f) this);
        C1720g.m3540Rg().mo14546b(255, (C1202f) this);
        AppMethodBeat.m2505o(127517);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        String str2;
        AppMethodBeat.m2504i(127518);
        C4990ab.m7417i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", Integer.valueOf(i2), str, c1207m, Integer.valueOf(c1207m.getType()), this);
        if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            if (i == 0 && i2 == 0) {
                this.qpb.setVisibility(4);
                this.qpc.setVisibility(4);
                SwitchAccountGridView switchAccountGridView = this.qkN;
                if (!switchAccountGridView.qrd) {
                    if (switchAccountGridView.qre == null && !C5046bo.isNullOrNil(switchAccountGridView.qrc)) {
                        int min = Math.min(2, switchAccountGridView.qrf.size());
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new C38204(min));
                        ofFloat.setDuration(200);
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new C38215(min));
                        ofFloat2.setDuration(300);
                        switchAccountGridView.qre = new AnimatorSet();
                        switchAccountGridView.qre.addListener(new C348896());
                        switchAccountGridView.qre.playSequentially(new Animator[]{ofFloat, ofFloat2});
                    }
                    if (switchAccountGridView.qre != null) {
                        switchAccountGridView.qrd = true;
                        switchAccountGridView.qre.start();
                    }
                }
                C1668a.unhold();
                C38033l.apX();
                C26529w.m42356cm(this);
                if (C37914bx.fnB.aat().size() > 1) {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(0), C37914bx.fnB.aau());
                } else {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(0), C37914bx.fnB.aau());
                }
                this.qkN.setOnAnimatorEndListener(new C2178110());
            } else {
                this.qkN.setSwitchToWxUsername("");
                this.qpg = false;
                C30379h.m48465bQ(this, getString(C25738R.string.ebh));
                str2 = ((C6686q) c1207m).fPk;
                if (!C5046bo.isNullOrNil(str2) && this.qkR.containsKey(str2)) {
                    Intent intent = new Intent();
                    C4990ab.m7417i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", str2, Integer.valueOf(((SwitchAccountModel) this.qkR.get(str2)).qjM));
                    if ((((SwitchAccountModel) this.qkR.get(str2)).qjM & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        intent.setClass(this, LoginVoiceUI.class);
                    } else {
                        intent.setClass(this, LoginPasswordUI.class);
                    }
                    intent.putExtra("switch_login_wx_id", str2);
                    startActivity(intent);
                    C5274b.m8055hN(this);
                }
                if (C37914bx.fnB.aat().size() > 1) {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(1), C37914bx.fnB.aau());
                } else {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(1), C37914bx.fnB.aau());
                }
            }
        }
        if (c1207m.getType() == 255) {
            if (((C9706r) c1207m).fPs == 2) {
                if (i == 0 && i2 == 0) {
                    cjd();
                    AppMethodBeat.m2505o(127518);
                    return;
                } else if (i2 == -3 && i == 4) {
                    if (C37914bx.fnB.aat().size() > 1) {
                        C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(7), C37914bx.fnB.aau());
                    } else {
                        C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(7), C37914bx.fnB.aau());
                    }
                    Intent intent2 = new Intent(this.mController.ylL, RegByMobileSetPwdUI.class);
                    intent2.putExtra("kintent_hint", getString(C25738R.string.dlz));
                    startActivityForResult(intent2, 701);
                    AppMethodBeat.m2505o(127518);
                    return;
                } else if (C24824b.gkF.mo38859a((Context) this, i, i2, str)) {
                    AppMethodBeat.m2505o(127518);
                    return;
                }
            }
        } else if (c1207m.getType() == C31128d.MIC_PTU_BAIXI) {
            C1720g.m3534RN();
            if (C1668a.m3395QX()) {
                str2 = ((ayx) ((C32828p) c1207m).ehh.fsH.fsP).wCM;
                String str3 = "MicroMsg.SettingsSwitchAccountUI";
                String str4 = "logout return noPwdTicket[%s]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(str2 == null ? -1 : str2.length());
                C4990ab.m7411d(str3, str4, objArr);
                if (C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7416i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
                }
                C4990ab.m7417i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", C1853r.m3846Yz());
                C37914bx.fnB.mo60668n(r0, "last_logout_no_pwd_ticket", str2);
                if (!(this.qpf == null || this.qpf.doT())) {
                    this.qpf.stopTimer();
                    cje();
                }
            }
        }
        AppMethodBeat.m2505o(127518);
    }

    private void goBack() {
        AppMethodBeat.m2504i(127519);
        C4990ab.m7416i("MicroMsg.SettingsSwitchAccountUI", "go back");
        if (this.scene == 2 || this.scene == 1) {
            Intent bh = C24679a.gkE.mo38909bh(this);
            bh.addFlags(67108864);
            bh.putExtra("can_finish", true);
            startActivity(bh);
            finish();
            C5274b.m8054hM(this);
            this.qpg = false;
            AppMethodBeat.m2505o(127519);
            return;
        }
        finish();
        AppMethodBeat.m2505o(127519);
    }

    public final int getLayoutId() {
        return 2130970644;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127521);
        super.onActivityResult(i, i2, intent);
        if (i == 701 && i2 == -1) {
            cjd();
        }
        AppMethodBeat.m2505o(127521);
    }

    private static void logout() {
        AppMethodBeat.m2504i(127522);
        if (!(C1720g.m3540Rg() == null || C1720g.m3540Rg().ftA == null)) {
            C1720g.m3540Rg().ftA.mo5532cG(false);
        }
        C4879a.xxA.mo10055m(new C6484gj());
        Object[] objArr = new Object[1];
        C1720g.m3534RN();
        objArr[0] = Integer.valueOf(C1668a.m3383QF());
        C4990ab.m7421w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        C37957c.akc().commitNow();
        ((C43014c) C1720g.m3528K(C43014c.class)).logout();
        C1207m c9706r = new C9706r(2);
        c9706r.fPr = 1;
        C1720g.m3540Rg().mo14541a(c9706r, 0);
        AppMethodBeat.m2505o(127522);
    }

    private void cjd() {
        AppMethodBeat.m2504i(127523);
        if (C1668a.m3404jP(C1720g.m3534RN().eIV)) {
            C1720g.m3540Rg().mo14541a(new C32822ab(2), 0);
        }
        C1720g.m3540Rg().mo14541a(new C32828p(), 0);
        this.qkN.setLogoutState(true);
        this.qkN.cjt();
        if (this.qpf == null) {
            this.qpf = new C7564ap(Looper.getMainLooper(), new C217832(), false);
            this.qpf.mo16770ae(8000, 8000);
        }
        AppMethodBeat.m2505o(127523);
    }

    private void cje() {
        AppMethodBeat.m2504i(127524);
        C4990ab.m7416i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
        C24824b.gkF.mo38849BY();
        this.gqX.setVisibility(8);
        this.qpa.setVisibility(8);
        C26171jl c26171jl = new C26171jl();
        c26171jl.cEK.status = 0;
        c26171jl.cEK.boZ = 0;
        C4879a.xxA.mo10055m(c26171jl);
        C45382z c45382z = new C45382z();
        c45382z.csU.csV = true;
        C4879a.xxA.mo10055m(c45382z);
        C4997aj.amB("show_whatsnew");
        C1737l.m3593m(this, true);
        C26529w.m42350I(this, null);
        if (C1720g.m3531RK()) {
            C6665av.fly.mo14899ou(C41730b.m73505pX(C1853r.m3846Yz()));
        }
        C4990ab.m7417i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", C6665av.fly.mo5292T("login_user_name", ""));
        Map Zg = C1853r.m3853Zg();
        if (C5046bo.isNullOrNil((String) Zg.get("login_user_name"))) {
            Zg.put("login_user_name", C6665av.fly.mo5292T("login_user_name", ""));
        }
        C37914bx.fnB.mo60666g(C1853r.m3846Yz(), Zg);
        C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
        try {
            Bitmap eA = C5056d.m7661eA(this.mController.ylv);
            C5730e.deleteFile(C5497d.yfV);
            if (eA != null) {
                C5056d.m7625a(eA, 80, CompressFormat.JPEG, C5497d.yfV, true);
            } else {
                C4990ab.m7412e("MicroMsg.SettingsSwitchAccountUI", "getBitmap from AccountGrid null!");
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SettingsSwitchAccountUI", "getBitmap from AccountGrid failed! %s", e.getMessage());
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        intent.putExtra("key_transit_to_switch_account", true);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.qkR.values());
        intent.putParcelableArrayListExtra("key_switch_account_users", arrayList);
        C24824b.gkE.mo38931p(intent, this);
        finish();
        C5274b.m8055hN(this);
        AppMethodBeat.m2505o(127524);
    }
}
