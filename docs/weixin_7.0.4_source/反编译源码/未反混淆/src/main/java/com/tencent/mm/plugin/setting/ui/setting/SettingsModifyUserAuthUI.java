package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.h;
import java.util.ArrayList;

public class SettingsModifyUserAuthUI extends MMPreference implements f {
    private String appId;
    private p eir;
    private h qnW;
    private int scene;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127319);
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
                    checkBoxPreference.setSummary((int) R.string.e5o);
                }
                checkBoxPreference.setKey(userAuthItemParcelable.scope);
                if (userAuthItemParcelable.state == 1) {
                    z = true;
                } else {
                    z = false;
                }
                checkBoxPreference.uOT = z;
                checkBoxPreference.yDf = false;
                this.qnW.a(checkBoxPreference, -1);
            }
        }
        setMMTitle(getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127317);
                SettingsModifyUserAuthUI.this.finish();
                AppMethodBeat.o(127317);
                return true;
            }
        });
        AppMethodBeat.o(127319);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(127320);
        ab.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", Integer.valueOf(i2), str);
        if (this.eir != null) {
            this.eir.dismiss();
        }
        if (i == 0 && i2 == 0) {
            String str2 = ((com.tencent.mm.plugin.setting.model.h) mVar).qjG;
            int i3 = ((com.tencent.mm.plugin.setting.model.h) mVar).qjH;
            if (!bo.isNullOrNil(str2)) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.qnW.aqO(str2);
                if (i3 != 1) {
                    z = false;
                }
                checkBoxPreference.uOT = z;
            }
            AppMethodBeat.o(127320);
            return;
        }
        com.tencent.mm.ui.base.h.bQ(this, str);
        AppMethodBeat.o(127320);
    }

    public void onResume() {
        AppMethodBeat.i(127321);
        super.onResume();
        g.Rg().a(1144, (f) this);
        AppMethodBeat.o(127321);
    }

    public void onPause() {
        AppMethodBeat.i(127322);
        super.onPause();
        g.Rg().b(1144, (f) this);
        AppMethodBeat.o(127322);
    }

    public final int JC() {
        return -1;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        int i;
        AppMethodBeat.i(127323);
        if (((CheckBoxPreference) preference).isChecked()) {
            i = 1;
        } else {
            i = 2;
        }
        final m hVar = new com.tencent.mm.plugin.setting.model.h(this.appId, preference.mKey, i, this.scene);
        g.Rg().a(hVar, 0);
        this.eir = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127318);
                g.Rg().c(hVar);
                AppMethodBeat.o(127318);
            }
        });
        AppMethodBeat.o(127323);
        return true;
    }
}
