package com.tencent.p177mm.plugin.account.security.p274ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5621b;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5622c;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.security.p880a.C18847c;
import com.tencent.p177mm.plugin.account.security.p880a.C18848d;
import com.tencent.p177mm.plugin.account.security.p880a.C45501g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI */
public class ModSafeDeviceNameUI extends MMActivity implements C1202f {
    private long createTime;
    private String cws;
    private ProgressDialog ehJ = null;
    private EditText gzq;
    private String gzr;
    private String gzs;
    private String gzt;

    /* renamed from: com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI$3 */
    class C67333 implements C5621b {
        C67333() {
        }

        public final void aqH() {
            AppMethodBeat.m2504i(69865);
            if (ModSafeDeviceNameUI.this.gzq.getText().toString().trim().length() > 0) {
                ModSafeDeviceNameUI.this.enableOptionMenu(true);
                AppMethodBeat.m2505o(69865);
                return;
            }
            ModSafeDeviceNameUI.this.enableOptionMenu(false);
            AppMethodBeat.m2505o(69865);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI$4 */
    class C188514 implements Runnable {
        C188514() {
        }

        public final void run() {
            AppMethodBeat.m2504i(69866);
            ModSafeDeviceNameUI.this.finish();
            AppMethodBeat.m2505o(69866);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI$1 */
    class C188521 implements OnMenuItemClickListener {
        C188521() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69862);
            ModSafeDeviceNameUI.this.finish();
            AppMethodBeat.m2505o(69862);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI$2 */
    class C188532 implements OnMenuItemClickListener {
        C188532() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(69864);
            ModSafeDeviceNameUI.this.gzs = ModSafeDeviceNameUI.this.gzq.getText().toString();
            if (C5046bo.isNullOrNil(ModSafeDeviceNameUI.this.gzs)) {
                AppMethodBeat.m2505o(69864);
            } else {
                ModSafeDeviceNameUI.this.aqX();
                final C1207m c18847c = new C18847c(ModSafeDeviceNameUI.this.gzt, ModSafeDeviceNameUI.this.gzs, ModSafeDeviceNameUI.this.cws);
                C1720g.m3540Rg().mo14541a(c18847c, 0);
                ModSafeDeviceNameUI.this.ehJ = C30379h.m48458b(ModSafeDeviceNameUI.this, C1338a.m2858an(ModSafeDeviceNameUI.this, C25738R.string.f9260un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(69863);
                        C1720g.m3540Rg().mo14547c(c18847c);
                        AppMethodBeat.m2505o(69863);
                    }
                });
                AppMethodBeat.m2505o(69864);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(69867);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(69867);
    }

    public void onResume() {
        AppMethodBeat.m2504i(69868);
        C1720g.m3540Rg().mo14539a(361, (C1202f) this);
        super.onResume();
        AppMethodBeat.m2505o(69868);
    }

    public void onPause() {
        AppMethodBeat.m2504i(69869);
        C1720g.m3540Rg().mo14546b(361, (C1202f) this);
        super.onPause();
        AppMethodBeat.m2505o(69869);
    }

    public final void initView() {
        AppMethodBeat.m2504i(69870);
        this.gzr = getIntent().getStringExtra("safe_device_name");
        this.gzt = getIntent().getStringExtra("safe_device_uid");
        this.cws = getIntent().getStringExtra("safe_device_type");
        setMMTitle(C1338a.m2858an(this, C25738R.string.dwb));
        setBackBtn(new C188521());
        addTextOptionMenu(0, getString(C25738R.string.f9218tc), new C188532());
        C67333 c67333 = new C67333();
        this.gzq = (EditText) findViewById(2131826142);
        C5622c c5622c = new C5622c(this.gzq, null, 32);
        c5622c.zMo = c67333;
        this.gzq.addTextChangedListener(c5622c);
        if (C5046bo.isNullOrNil(this.gzr)) {
            enableOptionMenu(false);
            AppMethodBeat.m2505o(69870);
            return;
        }
        this.gzq.setText(this.gzr);
        AppMethodBeat.m2505o(69870);
    }

    public final int getLayoutId() {
        return 2130970243;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(69871);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 0 && i2 == 0) {
            C18848d c18848d = new C18848d();
            c18848d.field_devicetype = this.cws;
            c18848d.field_name = this.gzs;
            c18848d.field_uid = this.gzt;
            c18848d.field_createtime = this.createTime;
            C45501g.aqG().mo10103c(c18848d, new String[0]);
            C30379h.m48465bQ(this, C1338a.m2858an(this, C25738R.string.dwf));
            new C7306ak().postDelayed(new C188514(), 1000);
            AppMethodBeat.m2505o(69871);
        } else if (C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
            AppMethodBeat.m2505o(69871);
        } else {
            AppMethodBeat.m2505o(69871);
        }
    }
}
