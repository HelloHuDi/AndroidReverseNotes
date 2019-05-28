package com.tencent.p177mm.plugin.subapp.p537ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceInfoCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.MobileFriendUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI */
public class AddMoreFriendsUI extends MMPreference {
    private C15541f ehK;
    private final int svd = 4;
    private final int sve = 9;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI$1 */
    class C352731 implements Runnable {
        C352731() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25504);
            Intent cVd = C46400aa.cVd();
            cVd.putExtra("KRightBtn", true);
            cVd.putExtra("ftsneedkeyboard", true);
            cVd.putExtra("key_load_js_without_delay", true);
            cVd.putExtra("ftsType", 1);
            cVd.putExtra("ftsbizscene", 9);
            Map d = C46400aa.m87334d(9, true, 0);
            String HP = C46400aa.m87299HP(C5046bo.ank((String) d.get("scene")));
            d.put("sessionId", HP);
            d.put("subSessionId", HP);
            cVd.putExtra("sessionId", HP);
            cVd.putExtra("subSessionId", HP);
            cVd.putExtra("rawUrl", C46400aa.m87298E(d));
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
            }
            C25985d.m41455a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
            AppMethodBeat.m2505o(25504);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI$2 */
    class C352742 implements OnMenuItemClickListener {
        C352742() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25505);
            AddMoreFriendsUI.this.finish();
            AppMethodBeat.m2505o(25505);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI$3 */
    class C352753 implements OnClickListener {
        C352753() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25506);
            Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
            }
            C3161d.m5411b(AddMoreFriendsUI.this.mController.ylL, ".ui.FTSAddFriendUI", putExtra, bundle);
            AppMethodBeat.m2505o(25506);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI$4 */
    class C352764 implements OnClickListener {
        C352764() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25507);
            C7060h.pYm.mo8381e(11264, Integer.valueOf(1));
            Intent intent = new Intent();
            intent.setClassName(AddMoreFriendsUI.this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
            AddMoreFriendsUI.this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(25507);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8464b;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25508);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(25508);
    }

    public void onResume() {
        CharSequence string;
        AppMethodBeat.m2504i(25509);
        super.onResume();
        if (C25985d.afj("brandservice")) {
            this.ehK.mo27715ce("find_friends_by_web", false);
        } else {
            this.ehK.mo27715ce("find_friends_by_web", true);
        }
        this.ehK.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.ehK.aqO("find_friends_by_input");
        addFriendSearchPreference.suV = getString(C25738R.string.b2f);
        addFriendSearchPreference.suX = new C352753();
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.ehK.aqO("find_friends_info");
        String Yz = C1853r.m3846Yz();
        String YA = C1853r.m3819YA();
        C9638aw.m17190ZK();
        String amN = C5025av.amN((String) C18628c.m29072Ry().get(6, null));
        if (!C5046bo.isNullOrNil(YA)) {
            string = getString(C25738R.string.btv, new Object[]{YA});
        } else if (!C7616ad.aoA(Yz)) {
            string = getString(C25738R.string.btv, new Object[]{Yz});
        } else if (C5046bo.isNullOrNil(amN)) {
            string = getString(C25738R.string.btx);
        } else {
            string = getString(C25738R.string.btw, new Object[]{C5025av.amM(amN)});
        }
        preferenceInfoCategory.setTitle(string);
        C352764 c352764 = new C352764();
        preferenceInfoCategory.yDo = c352764;
        preferenceInfoCategory.yDp = c352764;
        ((AddFriendItemPreference) this.ehK.aqO("find_friends_create_pwdgroup")).qlf = 8;
        C45287c.aNX();
        if (this.yCw != null) {
            Preference aqO = this.yCw.aqO("find_friends_by_web");
            if (aqO != null) {
                aqO.setEnabled(true);
            }
        }
        AppMethodBeat.m2505o(25509);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25510);
        super.onPause();
        AppMethodBeat.m2505o(25510);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25511);
        super.onDestroy();
        AppMethodBeat.m2505o(25511);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(25512);
        Intent intent;
        if ("find_friends_by_qrcode".equals(preference.mKey)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            C7060h.pYm.mo8381e(11265, Integer.valueOf(1));
            if (!(C35973a.m59178bI(this) || C17981e.akI())) {
                C25985d.m41467b((Context) this, "scanner", ".ui.BaseScanUI", intent);
            }
            AppMethodBeat.m2505o(25512);
            return true;
        } else if ("find_friends_by_other_way".equals(preference.mKey)) {
            if (C38033l.apS() != C38034a.SUCC) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.m23791J(this, intent);
                AppMethodBeat.m2505o(25512);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            AppMethodBeat.m2505o(25512);
            return true;
        } else if ("find_friends_by_web".equals(preference.mKey)) {
            if (C46400aa.m87304HU(0)) {
                ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(C4996ah.getContext(), new C352731());
                preference.setEnabled(false);
            } else {
                C4990ab.m7412e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            }
            AppMethodBeat.m2505o(25512);
            return true;
        } else if ("find_friends_by_radar".equals(preference.mKey)) {
            C25985d.m41448H(this, "radar", ".ui.RadarSearchUI");
            AppMethodBeat.m2505o(25512);
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.mKey)) {
            C7060h.pYm.mo8381e(11140, Integer.valueOf(1));
            C25985d.m41448H(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            AppMethodBeat.m2505o(25512);
            return true;
        } else if ("find_friends_by_invite".equals(preference.mKey)) {
            int intExtra = getIntent().getIntExtra("invite_friend_scene", 4);
            C7060h.pYm.mo8381e(14034, Integer.valueOf(intExtra));
            Intent intent2 = new Intent(this, InviteFriendsBy3rdUI.class);
            intent2.putExtra("Invite_friends", intExtra);
            startActivity(intent2);
            AppMethodBeat.m2505o(25512);
            return true;
        } else if ("find_friends_by_ww".equals(preference.mKey)) {
            Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            C3161d.m5411b(this.mController.ylL, ".ui.FTSAddWw", putExtra, bundle);
            AppMethodBeat.m2505o(25512);
            return true;
        } else {
            AppMethodBeat.m2505o(25512);
            return false;
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(25513);
        setMMTitle((int) C25738R.string.f8711cs);
        this.ehK = this.yCw;
        AddFriendItemPreference addFriendItemPreference = new AddFriendItemPreference(this.mController.ylL);
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle((int) C25738R.string.btf);
        addFriendItemPreference.mo39409fa();
        addFriendItemPreference.setSummary((int) C25738R.string.btg);
        if ((C5046bo.getInt(C26373g.m41964Nu().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.ehK.mo27708a(addFriendItemPreference, 4);
        }
        dyb();
        setBackBtn(new C352742());
        AppMethodBeat.m2505o(25513);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(25514);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(25514);
        return onKeyDown;
    }
}
