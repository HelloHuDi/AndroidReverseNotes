package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI extends MMPreference {
    private String ecX = "";
    private f ehK;
    private boolean qmv = false;
    private boolean qmw = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.bn;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127137);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127137);
    }

    public void onResume() {
        AppMethodBeat.i(127138);
        super.onResume();
        ccl ccl = new ccl();
        if (n.qFy != null) {
            ccl = n.qFy.WX(this.ecX);
        }
        if (ccl == null) {
            ab.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
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
        AppMethodBeat.o(127138);
    }

    public void onDestroy() {
        AppMethodBeat.i(127140);
        super.onDestroy();
        if (this.qmv && n.qFy != null) {
            ccl bi = n.qFy.bi(this.ecX, this.qmw);
            if (bi == null) {
                AppMethodBeat.o(127140);
                return;
            } else {
                ab.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + bi.toString());
                ((j) g.K(j.class)).XL().c(new a(51, bi));
            }
        }
        AppMethodBeat.o(127140);
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        AppMethodBeat.i(127139);
        String str = preference.mKey;
        if (str.equals("timline_outside_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            d.b((Context) this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            intent.putExtra("k_sns_from_settings_about_sns", 2);
            d.b((Context) this, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("timeline_stranger_show")) {
            boolean z;
            if (this.qmw) {
                z = false;
            } else {
                z = true;
            }
            this.qmw = z;
            if (n.qFy != null) {
                n.qFy.bh(this.ecX, this.qmw);
            }
            this.qmv = true;
        }
        AppMethodBeat.o(127139);
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(127141);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.e9z);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127136);
                SettingsAboutTimelineUI.this.aqX();
                SettingsAboutTimelineUI.this.finish();
                AppMethodBeat.o(127136);
                return true;
            }
        });
        this.ecX = r.Yz();
        AppMethodBeat.o(127141);
    }
}
