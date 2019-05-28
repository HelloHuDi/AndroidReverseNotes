package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddMoreFriendsByOtherWayUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.c;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25499);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(25499);
    }

    public void onResume() {
        AppMethodBeat.i(25500);
        super.onResume();
        if (((IconPreference) this.ehK.aqO("find_friends_by_google_account")) != null) {
            if (((r.YK() & 8388608) == 0 ? 1 : null) == null || !bo.gT(this)) {
                this.ehK.aqP("find_friends_by_google_account");
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(25500);
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 0;
        AppMethodBeat.i(25501);
        ab.d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", preference.mKey);
        Intent intent;
        if ("find_friends_by_mobile".equals(preference.mKey)) {
            if (l.apS() != a.SUCC) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.J(this, intent);
                AppMethodBeat.o(25501);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            AppMethodBeat.o(25501);
            return true;
        } else if ("find_friends_by_google_account".equals(preference.mKey)) {
            if (!TextUtils.isEmpty((String) g.RP().Ry().get(208903, null))) {
                i = 1;
            }
            if (i == 0) {
                intent = new Intent(this, BindGoogleContactUI.class);
                intent.putExtra("enter_scene", 1);
                MMWizardActivity.J(this, intent);
                AppMethodBeat.o(25501);
                return true;
            }
            intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", 1);
            startActivity(intent);
            AppMethodBeat.o(25501);
            return true;
        } else {
            AppMethodBeat.o(25501);
            return false;
        }
    }

    public final void initView() {
        AppMethodBeat.i(25502);
        setMMTitle((int) R.string.cs);
        this.ehK = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25498);
                AddMoreFriendsByOtherWayUI.this.finish();
                AppMethodBeat.o(25498);
                return true;
            }
        });
        AppMethodBeat.o(25502);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(25503);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(25503);
        return onKeyDown;
    }
}
