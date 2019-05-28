package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p230g.p231a.C18288hy;
import com.tencent.p177mm.p230g.p231a.C32647tt;
import com.tencent.p177mm.p230g.p231a.C6494hz;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6726a;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C6727b;
import com.tencent.p177mm.plugin.account.friend.p273ui.C6725i.C67302;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI */
public class BindMContactVerifyUI extends MMWizardActivity {
    private String cFl;
    private SharedPreferences ehZ;
    private int fromScene = 0;
    private boolean gqB = false;
    private EditText grL;
    private TextView grM;
    private Button grN;
    private C6725i grO;
    private int status;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI$2 */
    class C188012 implements OnClickListener {
        C188012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13480);
            String trim = BindMContactVerifyUI.this.grL.getText().toString().trim();
            if (C5046bo.isNullOrNil(trim)) {
                C30379h.m48467g(BindMContactVerifyUI.this, C25738R.string.a7z, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(13480);
                return;
            }
            BindMContactVerifyUI.this.aqX();
            BindMContactVerifyUI.m64328a(BindMContactVerifyUI.this, trim);
            AppMethodBeat.m2505o(13480);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI$1 */
    class C265511 implements InputFilter {
        C265511() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(13479);
            CharSequence ad = C5046bo.m7520ad(charSequence);
            AppMethodBeat.m2505o(13479);
            return ad;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI$3 */
    class C380213 implements OnMenuItemClickListener {
        C380213() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13481);
            BindMContactVerifyUI.m64329b(BindMContactVerifyUI.this);
            AppMethodBeat.m2505o(13481);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI$4 */
    class C380224 implements OnClickListener {
        C380224() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13482);
            BindMContactVerifyUI.this.aqX();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("bindmcontact_mobile", BindMContactVerifyUI.this.cFl);
            bundle.putInt("voice_verify_type", 4);
            intent.putExtras(bundle);
            C24679a.gkE.mo38918f(BindMContactVerifyUI.this, intent);
            AppMethodBeat.m2505o(13482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI$5 */
    class C380235 implements C6726a {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI$5$2 */
        class C19702 implements DialogInterface.OnClickListener {
            C19702() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13484);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("exit_and_restart", true);
                C24679a.gkE.mo38931p(intent, BindMContactVerifyUI.this);
                AppMethodBeat.m2505o(13484);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI$5$1 */
        class C329391 implements DialogInterface.OnClickListener {
            C329391() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(13483);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("exit_and_restart", true);
                C24679a.gkE.mo38931p(intent, BindMContactVerifyUI.this);
                AppMethodBeat.m2505o(13483);
            }
        }

        C380235() {
        }

        /* renamed from: e */
        public final void mo14957e(int i, Bundle bundle) {
            AppMethodBeat.m2504i(13485);
            if (i == 2) {
                Intent intent;
                switch (BindMContactVerifyUI.this.fromScene) {
                    case 1:
                        C4990ab.m7416i("MicroMsg.BindMContactVerifyUI", "to startMySafedeviceListUI");
                        if (!C1853r.m3826YH()) {
                            C32647tt c32647tt = new C32647tt();
                            c32647tt.cPS.cPT = true;
                            c32647tt.cPS.cPU = true;
                            C4879a.xxA.mo10055m(c32647tt);
                        }
                        BindMContactVerifyUI.m64332e(BindMContactVerifyUI.this);
                        intent = new Intent();
                        intent.addFlags(67108864);
                        C24679a.gkE.mo38916e(BindMContactVerifyUI.this, intent);
                        AppMethodBeat.m2505o(13485);
                        return;
                    case 3:
                        C4990ab.m7416i("MicroMsg.BindMContactVerifyUI", "to BindMContactStatusUI for change mobile");
                        if (bundle.getBoolean("restart_wechat", false)) {
                            C4990ab.m7416i("MicroMsg.BindMContactVerifyUI", "restart after change mobile!");
                            C30379h.m48448a(BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(C25738R.string.g6c), BindMContactVerifyUI.this.getString(C25738R.string.f9238tz), false, new C329391());
                            AppMethodBeat.m2505o(13485);
                            return;
                        }
                        C30379h.m48465bQ(BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(C25738R.string.f9142qt));
                        MMWizardActivity.m23791J(BindMContactVerifyUI.this, new Intent(BindMContactVerifyUI.this, BindMContactStatusUI.class));
                        AppMethodBeat.m2505o(13485);
                        return;
                    case 4:
                        C4990ab.m7416i("MicroMsg.BindMContactVerifyUI", "to RegByMobileSetPwdUI for reset pwd");
                        BindMContactVerifyUI.this.finish();
                        intent = new Intent();
                        intent.addFlags(603979776);
                        intent.putExtra("setpwd_ticket", bundle.getString("setpwd_ticket", ""));
                        C25985d.m41467b(BindMContactVerifyUI.this, "account", ".ui.RegByMobileSetPwdUI", intent);
                        AppMethodBeat.m2505o(13485);
                        return;
                    case 5:
                        C4990ab.m7416i("MicroMsg.BindMContactVerifyUI", "to finish  finishWizard for get phone number");
                        BindMContactVerifyUI.m64333f(BindMContactVerifyUI.this);
                        AppMethodBeat.m2505o(13485);
                        return;
                    default:
                        if (BindMContactVerifyUI.this.gqB) {
                            if (BindMContactVerifyUI.this.fromScene == 2) {
                                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                            } else {
                                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                            }
                        }
                        if (BindMContactVerifyUI.this.fromScene != 0 || !bundle.getBoolean("restart_wechat", false)) {
                            MMWizardActivity.m23791J(BindMContactVerifyUI.this, new Intent(BindMContactVerifyUI.this, BindMContactStatusUI.class));
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.BindMContactVerifyUI", "restart after bind mobile!");
                        C30379h.m48448a(BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(C25738R.string.g6c), BindMContactVerifyUI.this.getString(C25738R.string.f9238tz), false, new C19702());
                        AppMethodBeat.m2505o(13485);
                        return;
                }
            }
            AppMethodBeat.m2505o(13485);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m64329b(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.m2504i(13492);
        bindMContactVerifyUI.goBack();
        AppMethodBeat.m2505o(13492);
    }

    /* renamed from: f */
    static /* synthetic */ void m64333f(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.m2504i(13494);
        bindMContactVerifyUI.mo27541Ni(-1);
        AppMethodBeat.m2505o(13494);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13486);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.a7b);
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = C1853r.m3822YD();
        initView();
        AppMethodBeat.m2505o(13486);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13487);
        super.onDestroy();
        AppMethodBeat.m2505o(13487);
    }

    public final int getLayoutId() {
        return 2130968844;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13488);
        this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(4097, null);
        this.grL = (EditText) findViewById(2131821771);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Button button = (Button) findViewById(2131821772);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        }
        this.grL.setFilters(new InputFilter[]{new C265511()});
        this.grN = (Button) findViewById(2131821735);
        this.grM = (TextView) findViewById(2131821769);
        this.grM.setText(getString(C25738R.string.a6y, new Object[]{this.cFl}));
        button.setOnClickListener(new C188012());
        setBackBtn(new C380213());
        this.grN.setVisibility(C17950b.m28214sM(this.cFl) ? 0 : 8);
        this.grN.setOnClickListener(new C380224());
        AppMethodBeat.m2505o(13488);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(13489);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.m2505o(13489);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(13489);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(13490);
        if (this.grO != null) {
            this.grO.recycle();
        }
        mo27541Ni(1);
        AppMethodBeat.m2505o(13490);
    }

    /* renamed from: a */
    static /* synthetic */ void m64328a(BindMContactVerifyUI bindMContactVerifyUI, String str) {
        boolean z;
        AppMethodBeat.m2504i(13491);
        C6727b c6727b = C6727b.BINDMOBILE;
        if (bindMContactVerifyUI.fromScene == 3) {
            c6727b = C6727b.CHANGEMOBILE;
        }
        bindMContactVerifyUI.grO = new C6725i(c6727b, bindMContactVerifyUI, new C380235());
        C6725i c6725i = bindMContactVerifyUI.grO;
        if (bindMContactVerifyUI.fromScene == 0 || bindMContactVerifyUI.fromScene == 3) {
            z = true;
        } else {
            z = false;
        }
        c6725i.gys = z;
        C1202f c1202f = bindMContactVerifyUI.grO;
        if (c1202f.tipDialog != null) {
            c1202f.tipDialog.setCancelable(true);
        }
        if (c1202f.gyt == C6727b.BINDMOBILE || c1202f.gyt == C6727b.CHANGEMOBILE) {
            C1720g.m3540Rg().mo14539a(132, c1202f);
            C18288hy c18288hy = new C18288hy();
            c18288hy.cCS.context = c1202f.mContext;
            C4879a.xxA.mo10055m(c18288hy);
            String str2 = c18288hy.cCT.cCU;
            C6494hz c6494hz = new C6494hz();
            C4879a.xxA.mo10055m(c6494hz);
            String str3 = c6494hz.cCV.cCW;
            int i = 2;
            if (c1202f.gyt == C6727b.CHANGEMOBILE) {
                i = 19;
            }
            c1202f.eVT = false;
            c1202f.gyq = new C38037x(c1202f.cFl, i, str, "", str2, str3);
            C1720g.m3540Rg().mo14541a(c1202f.gyq, 0);
            if (c1202f.tipDialog != null) {
                c1202f.tipDialog.dismiss();
            }
            c1202f.tipDialog = C30379h.m48458b(c1202f.mContext, c1202f.mContext.getString(C25738R.string.a7n), true, new C67302());
        }
        AppMethodBeat.m2505o(13491);
    }

    /* renamed from: e */
    static /* synthetic */ void m64332e(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.m2504i(13493);
        bindMContactVerifyUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13493);
    }
}
