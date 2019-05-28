package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C32970y;
import com.tencent.p177mm.plugin.account.friend.p272a.C38032aj;
import com.tencent.p177mm.plugin.account.model.C42285d;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileSetPwdUI;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI */
public class SettingsModifyEmailAddrUI extends MMActivity implements C1202f, C4937b {
    private ProgressDialog ehJ;
    private String grp = null;
    private String grq = null;
    private EditText qnH;
    private String qnI;
    private String qnJ;
    private TextView qnK;
    private TextView qnL;
    private boolean qnM;
    private boolean qnN;
    private boolean qnO;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$21 */
    class C1321821 implements OnCancelListener {
        C1321821() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$23 */
    class C1322023 implements InputFilter {
        C1322023() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(127285);
            CharSequence subSequence;
            if (charSequence.length() <= 0) {
                subSequence = spanned.subSequence(i3, i4);
                AppMethodBeat.m2505o(127285);
                return subSequence;
            }
            subSequence = "";
            AppMethodBeat.m2505o(127285);
            return subSequence;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$10 */
    class C2176310 implements OnClickListener {
        C2176310() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$15 */
    class C2176415 implements OnClickListener {
        C2176415() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$17 */
    class C2176517 implements OnClickListener {
        C2176517() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$1 */
    class C217661 implements OnMenuItemClickListener {
        C217661() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127281);
            SettingsModifyEmailAddrUI.m77740a(SettingsModifyEmailAddrUI.this);
            AppMethodBeat.m2505o(127281);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$2 */
    class C217672 implements OnClickListener {
        C217672() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$3 */
    class C217683 implements OnClickListener {
        C217683() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$16 */
    class C2894916 implements OnClickListener {
        C2894916() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$18 */
    class C2895018 implements OnClickListener {
        C2895018() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$22 */
    class C2895122 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$22$1 */
        class C132191 implements OnCancelListener {
            C132191() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }

        C2895122() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127284);
            C1720g.m3540Rg().mo14541a(new C32970y(C32970y.gvY), 0);
            SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
            Context context = SettingsModifyEmailAddrUI.this;
            SettingsModifyEmailAddrUI.this.getString(C25738R.string.f9238tz);
            settingsModifyEmailAddrUI.ehJ = C30379h.m48458b(context, SettingsModifyEmailAddrUI.this.getString(C25738R.string.ecf), true, new C132191());
            SettingsModifyEmailAddrUI.this.aqX();
            AppMethodBeat.m2505o(127284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$4 */
    class C289534 implements OnClickListener {
        C289534() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$20 */
    class C3487720 implements OnClickListener {
        C3487720() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$19 */
    class C3967319 implements OnClickListener {
        C3967319() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127283);
            Intent intent = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(C25738R.string.ecb));
            intent.putExtra("from_unbind", true);
            SettingsModifyEmailAddrUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(127283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$26 */
    class C3967426 implements InputFilter {
        C3967426() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$28 */
    class C3967528 implements OnClickListener {
        C3967528() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127291);
            Intent intent = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
            intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(C25738R.string.ecb));
            intent.putExtra("from_unbind", true);
            SettingsModifyEmailAddrUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(127291);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$5 */
    class C396765 implements OnClickListener {
        C396765() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$11 */
    class C4350911 implements OnClickListener {
        C4350911() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$12 */
    class C4351012 implements InputFilter {
        C4351012() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(127282);
            CharSequence subSequence;
            if (charSequence.length() <= 0) {
                subSequence = spanned.subSequence(i3, i4);
                AppMethodBeat.m2505o(127282);
                return subSequence;
            }
            subSequence = "";
            AppMethodBeat.m2505o(127282);
            return subSequence;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$13 */
    class C4351113 implements OnClickListener {
        C4351113() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$14 */
    class C4351214 implements OnClickListener {
        C4351214() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$24 */
    class C4351424 implements View.OnClickListener {
        C4351424() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127287);
            final C1207m c38032aj = new C38032aj((String) C1720g.m3536RP().mo5239Ry().get(2, null));
            C1720g.m3540Rg().mo14541a(c38032aj, 0);
            SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
            Context context = SettingsModifyEmailAddrUI.this.mController.ylL;
            SettingsModifyEmailAddrUI.this.getString(C25738R.string.f9238tz);
            settingsModifyEmailAddrUI.ehJ = C30379h.m48458b(context, SettingsModifyEmailAddrUI.this.getString(C25738R.string.e6g), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(127286);
                    C1720g.m3540Rg().mo14547c(c38032aj);
                    AppMethodBeat.m2505o(127286);
                }
            });
            SettingsModifyEmailAddrUI.this.aqX();
            AppMethodBeat.m2505o(127287);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$25 */
    class C4351525 implements OnMenuItemClickListener {
        C4351525() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127288);
            SettingsModifyEmailAddrUI.m77741b(SettingsModifyEmailAddrUI.this);
            AppMethodBeat.m2505o(127288);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$7 */
    class C435167 implements OnClickListener {
        C435167() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$8 */
    class C435178 implements OnClickListener {
        C435178() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$9 */
    class C435189 implements OnClickListener {
        C435189() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$27 */
    class C4351927 implements OnMenuItemClickListener {
        C4351927() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127290);
            SettingsModifyEmailAddrUI.this.qnJ = SettingsModifyEmailAddrUI.this.qnH.getText().toString().trim();
            if (C5046bo.amW(SettingsModifyEmailAddrUI.this.qnJ)) {
                Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(7, null);
                boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
                Boolean valueOf = Boolean.valueOf(z);
                if (SettingsModifyEmailAddrUI.this.qnJ.equals(SettingsModifyEmailAddrUI.this.qnI) && valueOf.booleanValue()) {
                    SettingsModifyEmailAddrUI.this.finish();
                } else {
                    final C1207m c42285d = new C42285d(C42285d.gyK, SettingsModifyEmailAddrUI.this.qnJ);
                    C1720g.m3540Rg().mo14541a(c42285d, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    Context context = SettingsModifyEmailAddrUI.this;
                    SettingsModifyEmailAddrUI.this.getString(C25738R.string.f9238tz);
                    settingsModifyEmailAddrUI.ehJ = C30379h.m48458b(context, SettingsModifyEmailAddrUI.this.getString(C25738R.string.e62), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(127289);
                            C1720g.m3540Rg().mo14547c(c42285d);
                            AppMethodBeat.m2505o(127289);
                        }
                    });
                    SettingsModifyEmailAddrUI.this.aqX();
                }
                AppMethodBeat.m2505o(127290);
            } else {
                C30379h.m48467g(SettingsModifyEmailAddrUI.this.mController.ylL, C25738R.string.f0o, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(127290);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI$6 */
    class C435206 implements OnClickListener {
        C435206() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m77740a(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        AppMethodBeat.m2504i(127302);
        settingsModifyEmailAddrUI.goBack();
        AppMethodBeat.m2505o(127302);
    }

    /* renamed from: b */
    static /* synthetic */ void m77741b(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        AppMethodBeat.m2504i(127303);
        settingsModifyEmailAddrUI.ciS();
        AppMethodBeat.m2505o(127303);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127292);
        super.onCreate(bundle);
        initView();
        C1720g.m3540Rg().mo14539a(138, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        C1720g.m3540Rg().mo14539a(256, (C1202f) this);
        C1720g.m3540Rg().mo14539a(108, (C1202f) this);
        C1720g.m3540Rg().mo14539a(255, (C1202f) this);
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        AppMethodBeat.m2505o(127292);
    }

    public final int getLayoutId() {
        return 2130970636;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127293);
        C1720g.m3540Rg().mo14546b(138, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        C1720g.m3540Rg().mo14546b(256, (C1202f) this);
        C1720g.m3540Rg().mo14546b(108, (C1202f) this);
        C1720g.m3540Rg().mo14546b(255, (C1202f) this);
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        super.onDestroy();
        AppMethodBeat.m2505o(127293);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(127294);
        C4990ab.m7411d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(C5046bo.m7550g(obj, 0)), c7298n);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || r0 <= 0) {
            C4990ab.m7413e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(r0), c7298n);
            AppMethodBeat.m2505o(127294);
            return;
        }
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(7, null);
        this.qnI = (String) C1720g.m3536RP().mo5239Ry().get(5, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.qnM = z;
        this.qnO = this.qnM;
        if (this.qnN) {
            ciR();
        }
        AppMethodBeat.m2505o(127294);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127295);
        setMMTitle((int) C25738R.string.e8i);
        this.qnH = (EditText) findViewById(2131827396);
        this.qnK = (TextView) findViewById(2131827398);
        this.qnL = (TextView) findViewById(2131827397);
        this.qnI = (String) C1720g.m3536RP().mo5239Ry().get(5, null);
        this.qnH.setText(this.qnI);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(7, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.qnM = z;
        setBackBtn(new C217661());
        this.qnN = true;
        ciR();
        AppMethodBeat.m2505o(127295);
    }

    private void ciR() {
        AppMethodBeat.m2504i(127296);
        if (this.qnM) {
            this.qnK.setVisibility(0);
            this.qnK.setText(getString(C25738R.string.eca));
            this.qnL.setText(getString(C25738R.string.e8j));
            this.qnL.setTextColor(getResources().getColor(C25738R.color.f11694ds));
            this.qnH.setEnabled(false);
            this.qnH.setFilters(new InputFilter[]{new C4351012()});
            this.qnK.setOnClickListener(new C2895122());
            hideVKB(this.qnH);
            AppMethodBeat.m2505o(127296);
        } else if (C5046bo.isNullOrNil(this.qnI)) {
            ciS();
            AppMethodBeat.m2505o(127296);
        } else {
            this.qnK.setVisibility(0);
            this.qnK.setText(getString(C25738R.string.e49));
            this.qnL.setText(getString(C25738R.string.e46));
            this.qnL.setTextColor(getResources().getColor(C25738R.color.f12266xy));
            this.qnH.setEnabled(false);
            this.qnH.setFilters(new InputFilter[]{new C1322023()});
            this.qnK.setOnClickListener(new C4351424());
            addTextOptionMenu(0, getString(C25738R.string.f9099pg), new C4351525());
            hideVKB(this.qnH);
            AppMethodBeat.m2505o(127296);
        }
    }

    private void ciS() {
        AppMethodBeat.m2504i(127297);
        this.qnK.setVisibility(8);
        this.qnK.setText(getString(C25738R.string.eca));
        this.qnL.setText(getString(C25738R.string.e8j));
        this.qnL.setTextColor(getResources().getColor(C25738R.color.f11694ds));
        this.qnH.setEnabled(true);
        this.qnH.setFilters(new InputFilter[]{new C3967426()});
        addTextOptionMenu(0, getString(C25738R.string.f9218tc), new C4351927());
        AppMethodBeat.m2505o(127297);
    }

    private void goBack() {
        AppMethodBeat.m2504i(127298);
        aqX();
        finish();
        if (this.qnO) {
            setResult(-1);
            AppMethodBeat.m2505o(127298);
            return;
        }
        setResult(0);
        AppMethodBeat.m2505o(127298);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127299);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(127299);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(127299);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127300);
        C4990ab.m7416i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + c1207m.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (C24824b.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(127300);
            return;
        }
        if (c1207m.getType() == C31128d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (i == 0 && i2 == 0) {
                this.grq = ((C32970y) c1207m).aqe().vZs;
                this.grp = ((C32970y) c1207m).aqd();
                if (C5046bo.isNullOrNil(this.grq)) {
                    C1720g.m3540Rg().mo14541a(new C9706r(2), 0);
                    AppMethodBeat.m2505o(127300);
                    return;
                }
                C1720g.m3540Rg().mo14541a(new C42285d(C42285d.gyL, this.qnH.getText().toString().trim()), 0);
                AppMethodBeat.m2505o(127300);
                return;
            }
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i2 == -3) {
                C4990ab.m7410d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                C30379h.m48445a(this.mController.ylL, getString(C25738R.string.ecd), null, getString(C25738R.string.ece), getString(C25738R.string.ecc), true, new C3967528(), new C217672());
                AppMethodBeat.m2505o(127300);
                return;
            } else if (i2 == -82) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4r, (int) C25738R.string.f9238tz, new C217683());
                AppMethodBeat.m2505o(127300);
                return;
            } else if (i2 == -83) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4o, (int) C25738R.string.f9238tz, new C289534());
                AppMethodBeat.m2505o(127300);
                return;
            } else if (i2 == -84) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4p, (int) C25738R.string.f9238tz, new C396765());
                AppMethodBeat.m2505o(127300);
                return;
            } else if (i2 == -85) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4i, (int) C25738R.string.f9238tz, new C435206());
                AppMethodBeat.m2505o(127300);
                return;
            }
        } else if (c1207m.getType() == 256) {
            C24824b.gkF.mo38844BS();
            if (((C42285d) c1207m).mo67805Ah() == C42285d.gyK) {
                if (i == 0 && i2 == 0) {
                    C30379h.m48431a(this.mController.ylL, (int) C25738R.string.e6f, (int) C25738R.string.f9238tz, new C435167());
                    AppMethodBeat.m2505o(127300);
                    return;
                }
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (i2 == -82) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4r, (int) C25738R.string.f9238tz, new C435178());
                    AppMethodBeat.m2505o(127300);
                    return;
                } else if (i2 == -83) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4o, (int) C25738R.string.f9238tz, new C435189());
                    AppMethodBeat.m2505o(127300);
                    return;
                } else if (i2 == -84) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4p, (int) C25738R.string.f9238tz, new C2176310());
                    AppMethodBeat.m2505o(127300);
                    return;
                } else if (i2 == -85) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4i, (int) C25738R.string.f9238tz, new C4350911());
                    AppMethodBeat.m2505o(127300);
                    return;
                } else if (i2 == -86) {
                    C30379h.m48431a((Context) this, (int) C25738R.string.e4t, (int) C25738R.string.f9238tz, new C4351113());
                    AppMethodBeat.m2505o(127300);
                    return;
                } else {
                    C30379h.m48438a(this.mController.ylL, getString(C25738R.string.e6e, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(C25738R.string.f9238tz), new C4351214());
                    AppMethodBeat.m2505o(127300);
                    return;
                }
            } else if (((C42285d) c1207m).mo67805Ah() == C42285d.gyL) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (i == 0 && i2 == 0) {
                    C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(7, null)).intValue() | 2));
                    if (C5046bo.isNullOrNil(this.grq)) {
                        C30379h.m48431a(this.mController.ylL, (int) C25738R.string.e4k, (int) C25738R.string.f9238tz, new C2894916());
                        AppMethodBeat.m2505o(127300);
                        return;
                    }
                    C30379h.m48443a(this.mController.ylL, this.grq, "", getString(C25738R.string.f9151r4), new C2176415());
                    AppMethodBeat.m2505o(127300);
                    return;
                }
            }
        } else if (c1207m.getType() != 138) {
            if (c1207m.getType() == 108) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (i == 0 && i2 == 0) {
                    C30379h.m48431a(this.mController.ylL, (int) C25738R.string.e6f, (int) C25738R.string.f9238tz, new C2176517());
                    AppMethodBeat.m2505o(127300);
                    return;
                }
                C30379h.m48438a(this.mController.ylL, getString(C25738R.string.e6e, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(C25738R.string.f9238tz), new C2895018());
                AppMethodBeat.m2505o(127300);
                return;
            } else if (c1207m.getType() == 255) {
                if (i2 == 0) {
                    C1720g.m3540Rg().mo14541a(new C42285d(C42285d.gyL, this.qnH.getText().toString().trim()), 0);
                    AppMethodBeat.m2505o(127300);
                    return;
                }
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                C30379h.m48445a(this.mController.ylL, getString(C25738R.string.ecd), null, getString(C25738R.string.ece), getString(C25738R.string.ecc), true, new C3967319(), new C3487720());
            }
        }
        AppMethodBeat.m2505o(127300);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127301);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7411d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    C4990ab.m7416i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.qnI + " newEmail: " + this.qnJ);
                    C1720g.m3540Rg().mo14541a(new C32970y(C32970y.gvY), 0);
                    getString(C25738R.string.f9238tz);
                    this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.e7z), true, new C1321821());
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(127301);
    }
}
