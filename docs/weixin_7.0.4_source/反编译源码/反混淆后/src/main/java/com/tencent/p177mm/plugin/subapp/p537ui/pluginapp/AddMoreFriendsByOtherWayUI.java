package com.tencent.p177mm.plugin.subapp.p537ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindGoogleContactUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.GoogleFriendUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.MobileFriendUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsByOtherWayUI */
public class AddMoreFriendsByOtherWayUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsByOtherWayUI$1 */
    class C223521 implements OnMenuItemClickListener {
        C223521() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25498);
            AddMoreFriendsByOtherWayUI.this.finish();
            AppMethodBeat.m2505o(25498);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8465c;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25499);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(25499);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25500);
        super.onResume();
        if (((IconPreference) this.ehK.aqO("find_friends_by_google_account")) != null) {
            if (((C1853r.m3829YK() & 8388608) == 0 ? 1 : null) == null || !C5046bo.m7558gT(this)) {
                this.ehK.aqP("find_friends_by_google_account");
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(25500);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        int i = 0;
        AppMethodBeat.m2504i(25501);
        C4990ab.m7411d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", preference.mKey);
        Intent intent;
        if ("find_friends_by_mobile".equals(preference.mKey)) {
            if (C38033l.apS() != C38034a.SUCC) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.m23791J(this, intent);
                AppMethodBeat.m2505o(25501);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            AppMethodBeat.m2505o(25501);
            return true;
        } else if ("find_friends_by_google_account".equals(preference.mKey)) {
            if (!TextUtils.isEmpty((String) C1720g.m3536RP().mo5239Ry().get(208903, null))) {
                i = 1;
            }
            if (i == 0) {
                intent = new Intent(this, BindGoogleContactUI.class);
                intent.putExtra("enter_scene", 1);
                MMWizardActivity.m23791J(this, intent);
                AppMethodBeat.m2505o(25501);
                return true;
            }
            intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", 1);
            startActivity(intent);
            AppMethodBeat.m2505o(25501);
            return true;
        } else {
            AppMethodBeat.m2505o(25501);
            return false;
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(25502);
        setMMTitle((int) C25738R.string.f8711cs);
        this.ehK = this.yCw;
        setBackBtn(new C223521());
        AppMethodBeat.m2505o(25502);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(25503);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(25503);
        return onKeyDown;
    }
}
