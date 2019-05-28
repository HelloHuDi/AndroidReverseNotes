package com.tencent.p177mm.plugin.setting.p505ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.C32829v;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5622c;
import com.tencent.p177mm.plugin.account.model.C26603h;
import com.tencent.p177mm.plugin.account.model.C9908i;
import com.tencent.p177mm.plugin.account.p275ui.FacebookAuthUI;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI */
public class ShareToQQUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private EditText pwu;
    private TextView qkx;
    private int qky;
    private boolean qkz = false;

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI$3 */
    class C217423 implements OnClickListener {
        C217423() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(126921);
            Intent intent = new Intent(ShareToQQUI.this.mController.ylL, FacebookAuthUI.class);
            intent.putExtra("is_force_unbind", true);
            ShareToQQUI.this.mController.ylL.startActivity(intent);
            ShareToQQUI.this.aqX();
            ShareToQQUI.this.finish();
            AppMethodBeat.m2505o(126921);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI$4 */
    class C217434 implements OnDismissListener {
        C217434() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(126922);
            ShareToQQUI.this.finish();
            AppMethodBeat.m2505o(126922);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI$5 */
    class C217445 extends C9908i {
        C217445() {
        }

        /* renamed from: p */
        public final void mo21265p(Bundle bundle) {
            AppMethodBeat.m2504i(126923);
            super.mo21265p(bundle);
            AppMethodBeat.m2505o(126923);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(126924);
            super.onError(i, str);
            if (i == 3) {
                ShareToQQUI.m67776d(ShareToQQUI.this);
            }
            AppMethodBeat.m2505o(126924);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI$6 */
    class C289346 implements OnClickListener {
        C289346() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(126925);
            Intent intent = new Intent(ShareToQQUI.this.mController.ylL, FacebookAuthUI.class);
            intent.putExtra("is_force_unbind", true);
            ShareToQQUI.this.mController.ylL.startActivityForResult(intent, 8);
            AppMethodBeat.m2505o(126925);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI$1 */
    class C396541 implements OnMenuItemClickListener {
        C396541() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126916);
            ShareToQQUI.this.aqX();
            ShareToQQUI.this.finish();
            AppMethodBeat.m2505o(126916);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI$2 */
    class C396552 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI$2$1 */
        class C396561 extends C9908i {
            C396561() {
            }

            /* renamed from: p */
            public final void mo21265p(Bundle bundle) {
                AppMethodBeat.m2504i(126917);
                super.mo21265p(bundle);
                AppMethodBeat.m2505o(126917);
            }

            public final void onError(int i, String str) {
                AppMethodBeat.m2504i(126918);
                super.onError(i, str);
                AppMethodBeat.m2505o(126918);
            }
        }

        C396552() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            C1207m c32829v;
            AppMethodBeat.m2504i(126920);
            ShareToQQUI.this.qkz = true;
            if (ShareToQQUI.this.qky == 2 || ShareToQQUI.this.qky == 1) {
                boolean z;
                boolean z2;
                String obj = ShareToQQUI.this.pwu.getText().toString();
                if (ShareToQQUI.this.qky == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (ShareToQQUI.this.qky == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c32829v = new C32829v(obj, z, z2);
            } else if (ShareToQQUI.this.qky == 4) {
                long c = C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(65831, null));
                String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(65830, null));
                if (C5046bo.m7566gb(c) > 86400000 && nullAsNil.length() > 0) {
                    C30704c c30704c = new C30704c(ShareToQQUI.this.getString(C25738R.string.g7d));
                    c30704c.arX(nullAsNil);
                    new C26603h(c30704c, new C396561()).apm();
                }
                c32829v = new C32829v(ShareToQQUI.this.pwu.getText().toString());
            } else {
                C30379h.m48467g(ShareToQQUI.this.mController.ylL, C25738R.string.egs, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(126920);
                return true;
            }
            C1720g.m3540Rg().mo14541a(c32829v, 0);
            ShareToQQUI shareToQQUI = ShareToQQUI.this;
            Context context = ShareToQQUI.this.mController.ylL;
            ShareToQQUI.this.getString(C25738R.string.f9238tz);
            shareToQQUI.ehJ = C30379h.m48458b(context, ShareToQQUI.this.getString(C25738R.string.f9222th), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(126919);
                    C1720g.m3540Rg().mo14547c(c32829v);
                    AppMethodBeat.m2505o(126919);
                }
            });
            AppMethodBeat.m2505o(126920);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130969317;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126926);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(26, (C1202f) this);
        initView();
        if (C1853r.m3847Za()) {
            C30704c c30704c = new C30704c(getString(C25738R.string.g7d));
            c30704c.arX(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(65830, null)));
            new C26603h(c30704c, new C217445()).apm();
        }
        AppMethodBeat.m2505o(126926);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(126927);
        C1720g.m3540Rg().mo14546b(26, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(126927);
    }

    public final void initView() {
        AppMethodBeat.m2504i(126928);
        setMMTitle((int) C25738R.string.e3f);
        this.pwu = (EditText) findViewById(2131821019);
        this.qkx = (TextView) findViewById(2131823129);
        this.pwu.addTextChangedListener(new C5622c(this.pwu, this.qkx, C31128d.MIC_PTU_TRANS_XINXIAN));
        this.qky = getIntent().getIntExtra("show_to", 2);
        if (this.qky == 4) {
            this.pwu.setText(C25738R.string.e2q);
        } else {
            this.pwu.setText(C25738R.string.e2s);
        }
        setBackBtn(new C396541());
        addTextOptionMenu(0, getString(C25738R.string.f9226tl), new C396552());
        AppMethodBeat.m2505o(126928);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(126929);
        C4990ab.m7416i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() != 26) {
            AppMethodBeat.m2505o(126929);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -68) {
            if (C5046bo.isNullOrNil(str)) {
                str = "error";
            }
            C30379h.m48440a((Context) this, str, getString(C25738R.string.f9238tz), new C217423(), null);
            AppMethodBeat.m2505o(126929);
        } else if (i == 0 && i2 == 0) {
            aqX();
            String string = getString(C25738R.string.egv);
            C217434 c217434 = new C217434();
            C30379h.m48465bQ(this, string);
            AppMethodBeat.m2505o(126929);
        } else {
            this.qkz = false;
            if (C24824b.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
                AppMethodBeat.m2505o(126929);
                return;
            }
            Toast.makeText(this, getString(C25738R.string.egu, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(126929);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m67776d(ShareToQQUI shareToQQUI) {
        AppMethodBeat.m2504i(126930);
        C4990ab.m7412e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.qkz) {
            String string = shareToQQUI.mController.ylL.getString(C25738R.string.f9238tz);
            C30379h.m48440a(shareToQQUI.mController.ylL, shareToQQUI.mController.ylL.getString(C25738R.string.bmb), string, new C289346(), null);
        }
        AppMethodBeat.m2505o(126930);
    }
}
