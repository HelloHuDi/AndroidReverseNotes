package com.tencent.mm.plugin.subapp.ui.pluginapp;

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
import com.tencent.mm.R;
import com.tencent.mm.bg.e;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Map;

public class AddMoreFriendsUI extends MMPreference {
    private f ehK;
    private final int svd = 4;
    private final int sve = 9;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.b;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25508);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(25508);
    }

    public void onResume() {
        CharSequence string;
        AppMethodBeat.i(25509);
        super.onResume();
        if (d.afj("brandservice")) {
            this.ehK.ce("find_friends_by_web", false);
        } else {
            this.ehK.ce("find_friends_by_web", true);
        }
        this.ehK.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.ehK.aqO("find_friends_by_input");
        addFriendSearchPreference.suV = getString(R.string.b2f);
        addFriendSearchPreference.suX = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25506);
                Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
                Bundle bundle = null;
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
                }
                com.tencent.mm.plugin.fts.a.d.b(AddMoreFriendsUI.this.mController.ylL, ".ui.FTSAddFriendUI", putExtra, bundle);
                AppMethodBeat.o(25506);
            }
        };
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.ehK.aqO("find_friends_info");
        String Yz = r.Yz();
        String YA = r.YA();
        aw.ZK();
        String amN = av.amN((String) c.Ry().get(6, null));
        if (!bo.isNullOrNil(YA)) {
            string = getString(R.string.btv, new Object[]{YA});
        } else if (!ad.aoA(Yz)) {
            string = getString(R.string.btv, new Object[]{Yz});
        } else if (bo.isNullOrNil(amN)) {
            string = getString(R.string.btx);
        } else {
            string = getString(R.string.btw, new Object[]{av.amM(amN)});
        }
        preferenceInfoCategory.setTitle(string);
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25507);
                h.pYm.e(11264, Integer.valueOf(1));
                Intent intent = new Intent();
                intent.setClassName(AddMoreFriendsUI.this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
                AddMoreFriendsUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(25507);
            }
        };
        preferenceInfoCategory.yDo = anonymousClass4;
        preferenceInfoCategory.yDp = anonymousClass4;
        ((AddFriendItemPreference) this.ehK.aqO("find_friends_create_pwdgroup")).qlf = 8;
        com.tencent.mm.cj.c.aNX();
        if (this.yCw != null) {
            Preference aqO = this.yCw.aqO("find_friends_by_web");
            if (aqO != null) {
                aqO.setEnabled(true);
            }
        }
        AppMethodBeat.o(25509);
    }

    public void onPause() {
        AppMethodBeat.i(25510);
        super.onPause();
        AppMethodBeat.o(25510);
    }

    public void onDestroy() {
        AppMethodBeat.i(25511);
        super.onDestroy();
        AppMethodBeat.o(25511);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(25512);
        Intent intent;
        if ("find_friends_by_qrcode".equals(preference.mKey)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            h.pYm.e(11265, Integer.valueOf(1));
            if (!(a.bI(this) || e.akI())) {
                d.b((Context) this, "scanner", ".ui.BaseScanUI", intent);
            }
            AppMethodBeat.o(25512);
            return true;
        } else if ("find_friends_by_other_way".equals(preference.mKey)) {
            if (l.apS() != l.a.SUCC) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.J(this, intent);
                AppMethodBeat.o(25512);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            AppMethodBeat.o(25512);
            return true;
        } else if ("find_friends_by_web".equals(preference.mKey)) {
            if (aa.HU(0)) {
                ((m) g.K(m.class)).a(ah.getContext(), new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(25504);
                        Intent cVd = aa.cVd();
                        cVd.putExtra("KRightBtn", true);
                        cVd.putExtra("ftsneedkeyboard", true);
                        cVd.putExtra("key_load_js_without_delay", true);
                        cVd.putExtra("ftsType", 1);
                        cVd.putExtra("ftsbizscene", 9);
                        Map d = aa.d(9, true, 0);
                        String HP = aa.HP(bo.ank((String) d.get("scene")));
                        d.put("sessionId", HP);
                        d.put("subSessionId", HP);
                        cVd.putExtra("sessionId", HP);
                        cVd.putExtra("subSessionId", HP);
                        cVd.putExtra("rawUrl", aa.E(d));
                        Bundle bundle = null;
                        if (VERSION.SDK_INT >= 21) {
                            bundle = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
                        }
                        d.a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", cVd, bundle);
                        AppMethodBeat.o(25504);
                    }
                });
                preference.setEnabled(false);
            } else {
                ab.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            }
            AppMethodBeat.o(25512);
            return true;
        } else if ("find_friends_by_radar".equals(preference.mKey)) {
            d.H(this, "radar", ".ui.RadarSearchUI");
            AppMethodBeat.o(25512);
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.mKey)) {
            h.pYm.e(11140, Integer.valueOf(1));
            d.H(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            AppMethodBeat.o(25512);
            return true;
        } else if ("find_friends_by_invite".equals(preference.mKey)) {
            int intExtra = getIntent().getIntExtra("invite_friend_scene", 4);
            h.pYm.e(14034, Integer.valueOf(intExtra));
            Intent intent2 = new Intent(this, InviteFriendsBy3rdUI.class);
            intent2.putExtra("Invite_friends", intExtra);
            startActivity(intent2);
            AppMethodBeat.o(25512);
            return true;
        } else if ("find_friends_by_ww".equals(preference.mKey)) {
            Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            com.tencent.mm.plugin.fts.a.d.b(this.mController.ylL, ".ui.FTSAddWw", putExtra, bundle);
            AppMethodBeat.o(25512);
            return true;
        } else {
            AppMethodBeat.o(25512);
            return false;
        }
    }

    public final void initView() {
        AppMethodBeat.i(25513);
        setMMTitle((int) R.string.cs);
        this.ehK = this.yCw;
        AddFriendItemPreference addFriendItemPreference = new AddFriendItemPreference(this.mController.ylL);
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle((int) R.string.btf);
        addFriendItemPreference.fa();
        addFriendItemPreference.setSummary((int) R.string.btg);
        if ((bo.getInt(com.tencent.mm.m.g.Nu().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.ehK.a(addFriendItemPreference, 4);
        }
        dyb();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25505);
                AddMoreFriendsUI.this.finish();
                AppMethodBeat.o(25505);
                return true;
            }
        });
        AppMethodBeat.o(25513);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(25514);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(25514);
        return onKeyDown;
    }
}
