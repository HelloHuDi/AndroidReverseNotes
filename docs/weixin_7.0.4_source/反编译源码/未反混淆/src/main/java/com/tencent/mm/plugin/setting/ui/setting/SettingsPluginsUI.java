package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.internal.Utility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.ax.c;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;

public class SettingsPluginsUI extends MMPreference {
    private static int qok = 1;
    private static HashMap<String, Integer> qol = new HashMap<String, Integer>() {
        {
            AppMethodBeat.i(127398);
            put("qqmail", Integer.valueOf(3));
            put("newsapp", Integer.valueOf(8));
            put("masssendapp", Integer.valueOf(9));
            put("feedsapp", Integer.valueOf(10));
            put("linkedinplugin", Integer.valueOf(13));
            put("facebookapp", Integer.valueOf(16));
            put("gh_43f2581f6fd6", Integer.valueOf(18));
            put("downloaderapp", Integer.valueOf(19));
            AppMethodBeat.o(127398);
        }
    };
    private f ehK;
    private boolean qom;
    private boolean qon;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(127406);
        AppMethodBeat.o(127406);
    }

    public final int JC() {
        return R.xml.c6;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127400);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        h.pYm.e(14098, Integer.valueOf(5));
        h.pYm.e(12846, Integer.valueOf(qok));
        a.flu.ai("gh_43f2581f6fd6", "");
        AppMethodBeat.o(127400);
    }

    public void onDestroy() {
        AppMethodBeat.i(127401);
        super.onDestroy();
        AppMethodBeat.o(127401);
    }

    public final void initView() {
        AppMethodBeat.i(127402);
        setMMTitle((int) R.string.e_5);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127399);
                SettingsPluginsUI.this.aqX();
                SettingsPluginsUI.this.finish();
                AppMethodBeat.o(127399);
                return true;
            }
        });
        AppMethodBeat.o(127402);
    }

    public void onResume() {
        PluginPreference pluginPreference;
        int i = 0;
        AppMethodBeat.i(127403);
        super.onResume();
        this.ehK.removeAll();
        this.ehK.b(new PreferenceSmallCategory(this));
        ArrayList<Preference> arrayList = new ArrayList();
        ArrayList<Preference> arrayList2 = new ArrayList();
        boolean Ze = r.Ze();
        if (!Ze) {
            Ze = bo.getInt(g.Nu().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Ze) {
            ab.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
        }
        if (Ze && d.afj("qqmail")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Ww("qqmail")) {
                pluginPreference.setTitle((CharSequence) pluginPreference.qld);
                if (((r.YK() & 1) == 0 ? 1 : 0) != 0) {
                    arrayList.add(pluginPreference);
                } else if (b.ahM()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (d.afj("readerapp")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Ww("newsapp")) {
                pluginPreference.setTitle((CharSequence) pluginPreference.qld);
                if (((r.YK() & SQLiteGlobal.journalSizeLimit) == 0 ? 1 : 0) != 0) {
                    arrayList.add(pluginPreference);
                } else if (b.ahM()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        if (pluginPreference.Ww("facebookapp")) {
            pluginPreference.setTitle((CharSequence) pluginPreference.qld);
            if (((r.YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? 1 : 0) != 0) {
                arrayList.add(pluginPreference);
            } else if (b.ahL()) {
                arrayList2.add(pluginPreference);
            }
        }
        if (d.afj("masssend")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Ww("masssendapp")) {
                pluginPreference.setTitle((CharSequence) pluginPreference.qld);
                if (((r.YK() & 65536) == 0 ? 1 : 0) != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        String string = getString(R.string.bij);
        pluginPreference.qlc = "gh_43f2581f6fd6";
        pluginPreference.qld = string;
        pluginPreference.setKey("settings_plugins_list_#" + pluginPreference.qlc);
        pluginPreference.setTitle((CharSequence) pluginPreference.qld);
        if (((com.tencent.mm.plugin.sport.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sport.a.b.class)).cvY()) {
            arrayList.add(pluginPreference);
        } else {
            arrayList2.add(pluginPreference);
        }
        com.tencent.mm.plugin.r.a.bVv();
        this.qon = c.lQ(com.tencent.mm.ax.b.fKD);
        pluginPreference.qlg = this.qon;
        String value = g.Nu().getValue("LinkedinPluginClose");
        if (bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0) {
            PluginPreference pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.Ww("linkedinplugin")) {
                pluginPreference2.setTitle((CharSequence) pluginPreference2.qld);
                int i2 = (r.YK() & 16777216) == 0 ? 1 : 0;
                if (!bo.isNullOrNil((String) com.tencent.mm.kernel.g.RP().Ry().get(286721, null))) {
                    i = 1;
                }
                if (!(i2 == 0 || i == 0)) {
                    arrayList.add(pluginPreference2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            PluginTextPreference pluginTextPreference = new PluginTextPreference(this);
            pluginTextPreference.yCV = R.raw.setting_plugin_install;
            pluginTextPreference.NV(R.string.e_b);
            this.ehK.b(pluginTextPreference);
        }
        value = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
        Preference preference = null;
        for (Preference preference2 : arrayList) {
            preference2.lXY = 255;
            if (value.contains(preference2.qlc)) {
                preference2.qlg = true;
                if (preference == null) {
                    preference = preference2;
                }
            }
            this.ehK.b(preference2);
        }
        this.ehK.b(new PreferenceSmallCategory(this));
        PluginTextPreference pluginTextPreference2 = new PluginTextPreference(this);
        pluginTextPreference2.yCV = R.raw.setting_plugin_uninstall;
        pluginTextPreference2.NV(R.string.e_j);
        this.ehK.b(pluginTextPreference2);
        if (arrayList2.isEmpty()) {
            this.ehK.b(new PluginEmptyTextPreference(this));
        }
        for (Preference preference22 : arrayList2) {
            preference22.lXY = n.CTRL_INDEX;
            if (value.contains(preference22.qlc)) {
                preference22.qlg = true;
                if (preference == null) {
                    preference = preference22;
                }
            }
            this.ehK.b(preference22);
        }
        this.ehK.b(new PreferenceSmallCategory(this));
        if (preference != null) {
            setSelection(this.ehK.aqQ(preference.mKey));
        }
        AppMethodBeat.o(127403);
    }

    public void onPause() {
        AppMethodBeat.i(127404);
        super.onPause();
        AppMethodBeat.o(127404);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127405);
        String str = preference.mKey;
        if (str != null && str.equals("display_in_addr_book")) {
            com.tencent.mm.kernel.g.RP().Ry().set(35, Boolean.valueOf(((CheckBoxPreference) fVar.aqO(str)).isChecked()));
            AppMethodBeat.o(127405);
            return true;
        } else if (preference instanceof PluginPreference) {
            str = ((PluginPreference) preference).qlc;
            if ("feedsapp".equals(str) && this.qom) {
                com.tencent.mm.kernel.g.RP().Ry().set(-2046825369, Boolean.FALSE);
            }
            Intent intent = new Intent();
            if ("gh_43f2581f6fd6".equals(str) && this.qon) {
                com.tencent.mm.plugin.r.a.bVt();
                com.tencent.mm.ax.d.lR(com.tencent.mm.ax.b.fKD);
                intent.putExtra("key_from_wesport_plugin_newtips", true);
            }
            intent.putExtra("Contact_User", str);
            d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            h.pYm.e(12846, qol.get(str));
            ab.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", str, qol.get(str));
            AppMethodBeat.o(127405);
            return true;
        } else {
            AppMethodBeat.o(127405);
            return false;
        }
    }
}
