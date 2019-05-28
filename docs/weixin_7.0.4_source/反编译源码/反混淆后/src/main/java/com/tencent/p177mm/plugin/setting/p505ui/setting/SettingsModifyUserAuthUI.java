package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.setting.model.C28931h;
import com.tencent.p177mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyUserAuthUI */
public class SettingsModifyUserAuthUI extends MMPreference implements C1202f {
    private String appId;
    private C44275p eir;
    private C40675h qnW;
    private int scene;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyUserAuthUI$1 */
    class C217701 implements OnMenuItemClickListener {
        C217701() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127317);
            SettingsModifyUserAuthUI.this.finish();
            AppMethodBeat.m2505o(127317);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127319);
        super.onCreate(bundle);
        this.qnW = this.yCw;
        ArrayList<UserAuthItemParcelable> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("app_auth_items");
        this.appId = getIntent().getStringExtra("app_id");
        this.scene = getIntent().getIntExtra("modify_scene", 1);
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            for (UserAuthItemParcelable userAuthItemParcelable : parcelableArrayListExtra) {
                boolean z;
                Preference checkBoxPreference = new CheckBoxPreference(this);
                checkBoxPreference.setTitle((CharSequence) userAuthItemParcelable.qkh);
                if (userAuthItemParcelable.scope.equals("snsapi_friend")) {
                    checkBoxPreference.setSummary((int) C25738R.string.e5o);
                }
                checkBoxPreference.setKey(userAuthItemParcelable.scope);
                if (userAuthItemParcelable.state == 1) {
                    z = true;
                } else {
                    z = false;
                }
                checkBoxPreference.uOT = z;
                checkBoxPreference.yDf = false;
                this.qnW.mo27708a(checkBoxPreference, -1);
            }
        }
        setMMTitle(getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        setBackBtn(new C217701());
        AppMethodBeat.m2505o(127319);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(127320);
        C4990ab.m7417i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", Integer.valueOf(i2), str);
        if (this.eir != null) {
            this.eir.dismiss();
        }
        if (i == 0 && i2 == 0) {
            String str2 = ((C28931h) c1207m).qjG;
            int i3 = ((C28931h) c1207m).qjH;
            if (!C5046bo.isNullOrNil(str2)) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.qnW.aqO(str2);
                if (i3 != 1) {
                    z = false;
                }
                checkBoxPreference.uOT = z;
            }
            AppMethodBeat.m2505o(127320);
            return;
        }
        C30379h.m48465bQ(this, str);
        AppMethodBeat.m2505o(127320);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127321);
        super.onResume();
        C1720g.m3540Rg().mo14539a(1144, (C1202f) this);
        AppMethodBeat.m2505o(127321);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127322);
        super.onPause();
        C1720g.m3540Rg().mo14546b(1144, (C1202f) this);
        AppMethodBeat.m2505o(127322);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        int i;
        AppMethodBeat.m2504i(127323);
        if (((CheckBoxPreference) preference).isChecked()) {
            i = 1;
        } else {
            i = 2;
        }
        final C1207m c28931h = new C28931h(this.appId, preference.mKey, i, this.scene);
        C1720g.m3540Rg().mo14541a(c28931h, 0);
        this.eir = C30379h.m48458b((Context) this, getString(C25738R.string.f9222th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127318);
                C1720g.m3540Rg().mo14547c(c28931h);
                AppMethodBeat.m2505o(127318);
            }
        });
        AppMethodBeat.m2505o(127323);
        return true;
    }
}
