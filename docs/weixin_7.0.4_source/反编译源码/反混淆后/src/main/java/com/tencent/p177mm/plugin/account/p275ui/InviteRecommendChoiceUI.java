package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.account.friend.p273ui.RecommendFriendUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.InviteRecommendChoiceUI */
public class InviteRecommendChoiceUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteRecommendChoiceUI$1 */
    class C99241 implements OnMenuItemClickListener {
        C99241() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124901);
            InviteRecommendChoiceUI.this.aqX();
            InviteRecommendChoiceUI.this.finish();
            AppMethodBeat.m2505o(124901);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final boolean aqT() {
        return false;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8513ay;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124902);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(124902);
    }

    public final void initView() {
        AppMethodBeat.m2504i(124904);
        setMMTitle((int) C25738R.string.e35);
        this.ehK = this.yCw;
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_invite_facebook_friends");
        C17950b.ahN();
        this.ehK.mo27716d(iconPreference);
        iconPreference = (IconPreference) this.ehK.aqO("settings_invite_qq_friends");
        if (C1853r.m3845Yy() == 0) {
            this.ehK.mo27716d(iconPreference);
        }
        iconPreference = (IconPreference) this.ehK.aqO("settings_recommend_by_mail");
        if (C1853r.m3845Yy() == 0) {
            this.ehK.mo27716d(iconPreference);
        }
        iconPreference = (IconPreference) this.ehK.aqO("settings_recommend_by_mb");
        if (((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com") == null) {
            this.ehK.mo27716d(iconPreference);
        }
        setBackBtn(new C99241());
        AppMethodBeat.m2505o(124904);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(124903);
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
            intent.putExtra("sms_body", getString(C25738R.string.ceq, new Object[]{C1720g.m3536RP().mo5239Ry().get(2, null)}));
            intent.setType("vnd.android-dir/mms-sms");
            if (C5046bo.m7572k((Context) this, intent)) {
                startActivity(intent);
            } else {
                Toast.makeText(this, C25738R.string.e2a, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            startActivity(new Intent(this, InviteFacebookFriendsUI.class));
        }
        AppMethodBeat.m2505o(124903);
        return false;
    }
}
