package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class InviteRecommendChoiceUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean aqT() {
        return false;
    }

    public final int JC() {
        return R.xml.ay;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(124902);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(124902);
    }

    public final void initView() {
        AppMethodBeat.i(124904);
        setMMTitle((int) R.string.e35);
        this.ehK = this.yCw;
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_invite_facebook_friends");
        b.ahN();
        this.ehK.d(iconPreference);
        iconPreference = (IconPreference) this.ehK.aqO("settings_invite_qq_friends");
        if (r.Yy() == 0) {
            this.ehK.d(iconPreference);
        }
        iconPreference = (IconPreference) this.ehK.aqO("settings_recommend_by_mail");
        if (r.Yy() == 0) {
            this.ehK.d(iconPreference);
        }
        iconPreference = (IconPreference) this.ehK.aqO("settings_recommend_by_mb");
        if (((j) g.K(j.class)).XU().RA("@t.qq.com") == null) {
            this.ehK.d(iconPreference);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(124901);
                InviteRecommendChoiceUI.this.aqX();
                InviteRecommendChoiceUI.this.finish();
                AppMethodBeat.o(124901);
                return true;
            }
        });
        AppMethodBeat.o(124904);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(124903);
        String str = preference.mKey;
        Intent intent;
        if (str.equals("settings_invite_qq_friends")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(0));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mail")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(2));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mb")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(1));
            startActivity(intent);
        } else if (str.equals("settings_invite_mobile_friends")) {
            intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("sms_body", getString(R.string.ceq, new Object[]{g.RP().Ry().get(2, null)}));
            intent.setType("vnd.android-dir/mms-sms");
            if (bo.k((Context) this, intent)) {
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.e2a, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            startActivity(new Intent(this, InviteFacebookFriendsUI.class));
        }
        AppMethodBeat.o(124903);
        return false;
    }
}
