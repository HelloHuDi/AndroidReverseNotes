package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutTimelineUI */
public class SettingsAboutTimelineUI extends MMPreference {
    private String ecX = "";
    private C15541f ehK;
    private boolean qmv = false;
    private boolean qmw = false;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutTimelineUI$1 */
    class C217581 implements OnMenuItemClickListener {
        C217581() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127136);
            SettingsAboutTimelineUI.this.aqX();
            SettingsAboutTimelineUI.this.finish();
            AppMethodBeat.m2505o(127136);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8539bn;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127137);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127137);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127138);
        super.onResume();
        ccl ccl = new ccl();
        if (C21877n.qFy != null) {
            ccl = C21877n.qFy.mo47111WX(this.ecX);
        }
        if (ccl == null) {
            C4990ab.m7412e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
        } else {
            int i = ccl.xbQ;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("timeline_stranger_show");
            if (checkBoxPreference != null) {
                this.qmw = (i & 1) > 0;
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                if (this.qmw) {
                    checkBoxPreference.uOT = false;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
                } else {
                    checkBoxPreference.uOT = true;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
                }
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127138);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127140);
        super.onDestroy();
        if (this.qmv && C21877n.qFy != null) {
            ccl bi = C21877n.qFy.mo47117bi(this.ecX, this.qmw);
            if (bi == null) {
                AppMethodBeat.m2505o(127140);
                return;
            } else {
                C4990ab.m7410d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + bi.toString());
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(51, bi));
            }
        }
        AppMethodBeat.m2505o(127140);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        Intent intent;
        AppMethodBeat.m2504i(127139);
        String str = preference.mKey;
        if (str.equals("timline_outside_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            C25985d.m41467b((Context) this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            intent.putExtra("k_sns_from_settings_about_sns", 2);
            C25985d.m41467b((Context) this, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("timeline_stranger_show")) {
            boolean z;
            if (this.qmw) {
                z = false;
            } else {
                z = true;
            }
            this.qmw = z;
            if (C21877n.qFy != null) {
                C21877n.qFy.mo47116bh(this.ecX, this.qmw);
            }
            this.qmv = true;
        }
        AppMethodBeat.m2505o(127139);
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127141);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.e9z);
        setBackBtn(new C217581());
        this.ecX = C1853r.m3846Yz();
        AppMethodBeat.m2505o(127141);
    }
}
