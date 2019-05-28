package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.friend.p272a.C32970y;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI */
public class BindQQUI extends MMWizardActivity implements C1202f {
    private String grp = null;
    private String grq = null;
    C44275p tipDialog;
    private int type = 0;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$7 */
    class C98587 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$7$1 */
        class C98561 implements C36073c {
            C98561() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(13549);
                c44273l.setHeaderTitle((int) C25738R.string.a6z);
                c44273l.mo70072hi(0, C25738R.string.ey9);
                AppMethodBeat.m2505o(13549);
            }
        }

        /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$7$2 */
        class C98572 implements C5279d {
            C98572() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(13550);
                switch (menuItem.getItemId()) {
                    case 0:
                        Context context = BindQQUI.this;
                        C1720g.m3540Rg().mo14541a(new C32970y(C32970y.gvV), 0);
                        context.getString(C25738R.string.f9238tz);
                        context.tipDialog = C30379h.m48458b(context, context.getString(C25738R.string.f9160rd), true, new C265622());
                        break;
                }
                AppMethodBeat.m2505o(13550);
            }
        }

        C98587() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13551);
            C46696j c46696j = new C46696j(BindQQUI.this.mController.ylL);
            c46696j.rBl = new C98561();
            c46696j.rBm = new C98572();
            c46696j.cuu();
            AppMethodBeat.m2505o(13551);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$10 */
    class C1880410 implements OnClickListener {
        C1880410() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13553);
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", BindQQUI.this.getString(C25738R.string.ecb));
            intent.putExtra("from_unbind", true);
            C25985d.m41468b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
            AppMethodBeat.m2505o(13553);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$5 */
    class C188055 implements View.OnClickListener {
        C188055() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(13548);
            MMWizardActivity.m23791J(BindQQUI.this, new Intent(BindQQUI.this, VerifyQQUI.class));
            AppMethodBeat.m2505o(13548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$8 */
    class C265578 implements OnClickListener {
        C265578() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13552);
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", BindQQUI.this.getString(C25738R.string.ecb));
            intent.putExtra("from_unbind", true);
            C25985d.m41468b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
            AppMethodBeat.m2505o(13552);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$9 */
    class C265589 implements OnClickListener {
        C265589() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$6 */
    class C265596 implements View.OnClickListener {
        C265596() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$11 */
    class C2656011 implements OnClickListener {
        C2656011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$1 */
    class C265611 implements OnMenuItemClickListener {
        C265611() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13546);
            BindQQUI.m42404a(BindQQUI.this);
            AppMethodBeat.m2505o(13546);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$2 */
    class C265622 implements OnCancelListener {
        C265622() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$3 */
    class C265633 implements OnCancelListener {
        C265633() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.BindQQUI$4 */
    class C265644 implements OnMenuItemClickListener {
        C265644() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13547);
            BindQQUI.this.aqX();
            BindQQUI.this.finish();
            AppMethodBeat.m2505o(13547);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13554);
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        C1720g.m3540Rg().mo14539a(255, (C1202f) this);
        AppMethodBeat.m2505o(13554);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13555);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_ZIPAI_LIGHTRED, (C1202f) this);
        C1720g.m3540Rg().mo14546b(255, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(13555);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13556);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(13556);
    }

    public final int getLayoutId() {
        return 2130968847;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13557);
        long longValue = new C1183p(C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null))).longValue();
        if (longValue == 0) {
            apf();
        } else {
            m42405gd(longValue);
        }
        if (this.type == 1) {
            addTextOptionMenu(0, getString(C25738R.string.f9154r7), new C265611());
            AppMethodBeat.m2505o(13557);
            return;
        }
        setBackBtn(new C265644());
        AppMethodBeat.m2505o(13557);
    }

    private void apf() {
        AppMethodBeat.m2504i(13558);
        setMMTitle((int) C25738R.string.a8h);
        TextView textView = (TextView) findViewById(2131821780);
        textView.setVisibility(8);
        textView.setText(C25738R.string.a8f);
        ((TextView) findViewById(2131821779)).setVisibility(8);
        Button button = (Button) findViewById(2131821781);
        button.setVisibility(0);
        button.setText(C25738R.string.a8e);
        button.setOnClickListener(new C188055());
        removeOptionMenu(1);
        AppMethodBeat.m2505o(13558);
    }

    /* renamed from: gd */
    private void m42405gd(long j) {
        AppMethodBeat.m2504i(13559);
        setMMTitle((int) C25738R.string.a8d);
        TextView textView = (TextView) findViewById(2131821780);
        textView.setVisibility(8);
        textView.setText(C25738R.string.a8b);
        textView = (TextView) findViewById(2131821779);
        textView.setVisibility(0);
        textView.setText(getString(C25738R.string.a8c) + j);
        Button button = (Button) findViewById(2131821781);
        button.setVisibility(8);
        button.setText(C25738R.string.caq);
        button.setOnClickListener(new C265596());
        addIconOptionMenu(1, C25738R.drawable.f6899uu, new C98587());
        AppMethodBeat.m2505o(13559);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(13560);
        C4990ab.m7410d("MicroMsg.BindQQUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (c1207m.getType() == C31128d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (i == 0 && i2 == 0) {
                this.grp = ((C32970y) c1207m).aqd();
                if (this.grp != null && this.grp.length() > 0) {
                    C1720g.m3536RP().mo5239Ry().set(102407, this.grp);
                }
                if (C5046bo.isNullOrNil(this.grq)) {
                    C1720g.m3540Rg().mo14541a(new C9706r(2), 0);
                    AppMethodBeat.m2505o(13560);
                    return;
                }
                Intent intent = new Intent(this, StartUnbindQQ.class);
                intent.putExtra("notice", this.grq);
                MMWizardActivity.m23791J(this, intent);
                AppMethodBeat.m2505o(13560);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == -3) {
                C4990ab.m7410d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                C30379h.m48445a(this.mController.ylL, getString(C25738R.string.ecd), null, getString(C25738R.string.ece), getString(C25738R.string.ecc), true, new C265578(), new C265589());
                AppMethodBeat.m2505o(13560);
                return;
            } else if (i2 == -81) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4q, (int) C25738R.string.f9238tz, null);
                AppMethodBeat.m2505o(13560);
                return;
            } else if (i2 == -82) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4r, (int) C25738R.string.f9238tz, null);
                AppMethodBeat.m2505o(13560);
                return;
            } else if (i2 == -83) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4o, (int) C25738R.string.f9238tz, null);
                AppMethodBeat.m2505o(13560);
                return;
            } else if (i2 == -84) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4p, (int) C25738R.string.f9238tz, null);
                AppMethodBeat.m2505o(13560);
                return;
            } else if (i2 == -85) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4n, (int) C25738R.string.f9238tz, null);
                AppMethodBeat.m2505o(13560);
                return;
            } else if (i2 == -86) {
                C30379h.m48431a((Context) this, (int) C25738R.string.e4t, (int) C25738R.string.f9238tz, null);
                AppMethodBeat.m2505o(13560);
                return;
            }
        } else if (c1207m.getType() == 255) {
            if (i2 == 0) {
                MMWizardActivity.m23791J(this, new Intent(this, StartUnbindQQ.class));
                AppMethodBeat.m2505o(13560);
                return;
            }
            C30379h.m48445a(this.mController.ylL, getString(C25738R.string.ecd), null, getString(C25738R.string.ece), getString(C25738R.string.ecc), true, new C1880410(), new C2656011());
        }
        AppMethodBeat.m2505o(13560);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(13561);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7411d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    C4990ab.m7416i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    C1720g.m3540Rg().mo14541a(new C32970y(C32970y.gvV), 0);
                    getString(C25738R.string.f9238tz);
                    this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.f9160rd), true, new C265633());
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(13561);
    }

    /* renamed from: a */
    static /* synthetic */ void m42404a(BindQQUI bindQQUI) {
        AppMethodBeat.m2504i(13562);
        bindQQUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13562);
    }
}
