package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.internal.Utility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p199ax.C6328d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.PluginTextPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI */
public class SettingsPluginsUI extends MMPreference {
    private static int qok = 1;
    private static HashMap<String, Integer> qol = new C132211();
    private C15541f ehK;
    private boolean qom;
    private boolean qon;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI$1 */
    static class C132211 extends HashMap<String, Integer> {
        C132211() {
            AppMethodBeat.m2504i(127398);
            put("qqmail", Integer.valueOf(3));
            put("newsapp", Integer.valueOf(8));
            put("masssendapp", Integer.valueOf(9));
            put("feedsapp", Integer.valueOf(10));
            put("linkedinplugin", Integer.valueOf(13));
            put("facebookapp", Integer.valueOf(16));
            put("gh_43f2581f6fd6", Integer.valueOf(18));
            put("downloaderapp", Integer.valueOf(19));
            AppMethodBeat.m2505o(127398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI$2 */
    class C132222 implements OnMenuItemClickListener {
        C132222() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127399);
            SettingsPluginsUI.this.aqX();
            SettingsPluginsUI.this.finish();
            AppMethodBeat.m2505o(127399);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(127406);
        AppMethodBeat.m2505o(127406);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8558c6;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127400);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        C7060h.pYm.mo8381e(14098, Integer.valueOf(5));
        C7060h.pYm.mo8381e(12846, Integer.valueOf(qok));
        C26417a.flu.mo20967ai("gh_43f2581f6fd6", "");
        AppMethodBeat.m2505o(127400);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127401);
        super.onDestroy();
        AppMethodBeat.m2505o(127401);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127402);
        setMMTitle((int) C25738R.string.e_5);
        setBackBtn(new C132222());
        AppMethodBeat.m2505o(127402);
    }

    public void onResume() {
        PluginPreference pluginPreference;
        int i = 0;
        AppMethodBeat.m2504i(127403);
        super.onResume();
        this.ehK.removeAll();
        this.ehK.mo27713b(new PreferenceSmallCategory(this));
        ArrayList<Preference> arrayList = new ArrayList();
        ArrayList<Preference> arrayList2 = new ArrayList();
        boolean Ze = C1853r.m3851Ze();
        if (!Ze) {
            Ze = C5046bo.getInt(C26373g.m41964Nu().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Ze) {
            C4990ab.m7416i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
        }
        if (Ze && C25985d.afj("qqmail")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.mo41693Ww("qqmail")) {
                pluginPreference.setTitle((CharSequence) pluginPreference.qld);
                if (((C1853r.m3829YK() & 1) == 0 ? 1 : 0) != 0) {
                    arrayList.add(pluginPreference);
                } else if (C17950b.ahM()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (C25985d.afj("readerapp")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.mo41693Ww("newsapp")) {
                pluginPreference.setTitle((CharSequence) pluginPreference.qld);
                if (((C1853r.m3829YK() & SQLiteGlobal.journalSizeLimit) == 0 ? 1 : 0) != 0) {
                    arrayList.add(pluginPreference);
                } else if (C17950b.ahM()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        if (pluginPreference.mo41693Ww("facebookapp")) {
            pluginPreference.setTitle((CharSequence) pluginPreference.qld);
            if (((C1853r.m3829YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? 1 : 0) != 0) {
                arrayList.add(pluginPreference);
            } else if (C17950b.ahL()) {
                arrayList2.add(pluginPreference);
            }
        }
        if (C25985d.afj("masssend")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.mo41693Ww("masssendapp")) {
                pluginPreference.setTitle((CharSequence) pluginPreference.qld);
                if (((C1853r.m3829YK() & 65536) == 0 ? 1 : 0) != 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        String string = getString(C25738R.string.bij);
        pluginPreference.qlc = "gh_43f2581f6fd6";
        pluginPreference.qld = string;
        pluginPreference.setKey("settings_plugins_list_#" + pluginPreference.qlc);
        pluginPreference.setTitle((CharSequence) pluginPreference.qld);
        if (((C39858b) C1720g.m3528K(C39858b.class)).cvY()) {
            arrayList.add(pluginPreference);
        } else {
            arrayList2.add(pluginPreference);
        }
        C16841a.bVv();
        this.qon = C1301c.m2776lQ(C32321b.fKD);
        pluginPreference.qlg = this.qon;
        String value = C26373g.m41964Nu().getValue("LinkedinPluginClose");
        if (C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0) {
            PluginPreference pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.mo41693Ww("linkedinplugin")) {
                pluginPreference2.setTitle((CharSequence) pluginPreference2.qld);
                int i2 = (C1853r.m3829YK() & 16777216) == 0 ? 1 : 0;
                if (!C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(286721, null))) {
                    i = 1;
                }
                if (!(i2 == 0 || i == 0)) {
                    arrayList.add(pluginPreference2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            PluginTextPreference pluginTextPreference = new PluginTextPreference(this);
            pluginTextPreference.yCV = C1318a.setting_plugin_install;
            pluginTextPreference.mo48780NV(C25738R.string.e_b);
            this.ehK.mo27713b(pluginTextPreference);
        }
        value = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
        Preference preference = null;
        for (Preference preference2 : arrayList) {
            preference2.lXY = 255;
            if (value.contains(preference2.qlc)) {
                preference2.qlg = true;
                if (preference == null) {
                    preference = preference2;
                }
            }
            this.ehK.mo27713b(preference2);
        }
        this.ehK.mo27713b(new PreferenceSmallCategory(this));
        PluginTextPreference pluginTextPreference2 = new PluginTextPreference(this);
        pluginTextPreference2.yCV = C1318a.setting_plugin_uninstall;
        pluginTextPreference2.mo48780NV(C25738R.string.e_j);
        this.ehK.mo27713b(pluginTextPreference2);
        if (arrayList2.isEmpty()) {
            this.ehK.mo27713b(new PluginEmptyTextPreference(this));
        }
        for (Preference preference22 : arrayList2) {
            preference22.lXY = C19395n.CTRL_INDEX;
            if (value.contains(preference22.qlc)) {
                preference22.qlg = true;
                if (preference == null) {
                    preference = preference22;
                }
            }
            this.ehK.mo27713b(preference22);
        }
        this.ehK.mo27713b(new PreferenceSmallCategory(this));
        if (preference != null) {
            setSelection(this.ehK.aqQ(preference.mKey));
        }
        AppMethodBeat.m2505o(127403);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127404);
        super.onPause();
        AppMethodBeat.m2505o(127404);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127405);
        String str = preference.mKey;
        if (str != null && str.equals("display_in_addr_book")) {
            C1720g.m3536RP().mo5239Ry().set(35, Boolean.valueOf(((CheckBoxPreference) c15541f.aqO(str)).isChecked()));
            AppMethodBeat.m2505o(127405);
            return true;
        } else if (preference instanceof PluginPreference) {
            str = ((PluginPreference) preference).qlc;
            if ("feedsapp".equals(str) && this.qom) {
                C1720g.m3536RP().mo5239Ry().set(-2046825369, Boolean.FALSE);
            }
            Intent intent = new Intent();
            if ("gh_43f2581f6fd6".equals(str) && this.qon) {
                C16841a.bVt();
                C6328d.m10412lR(C32321b.fKD);
                intent.putExtra("key_from_wesport_plugin_newtips", true);
            }
            intent.putExtra("Contact_User", str);
            C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            C7060h.pYm.mo8381e(12846, qol.get(str));
            C4990ab.m7417i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", str, qol.get(str));
            AppMethodBeat.m2505o(127405);
            return true;
        } else {
            AppMethodBeat.m2505o(127405);
            return false;
        }
    }
}
