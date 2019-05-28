package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p210ca.C18121b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5510e.C5496c;
import com.tencent.p177mm.p612ui.C5510e.C5505l;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.LanguagePreference;
import com.tencent.p177mm.plugin.account.p275ui.LanguagePreference.C26617a;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.setting.p505ui.widget.FontSelectorView;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5040bk;
import com.tencent.p177mm.sdk.platformtools.C5070z;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI */
public class SettingsLanguageUI extends MMPreference {
    private static final String[] qno = C5070z.qno;
    private C15541f ehK;
    private String gGN;
    private List<C26617a> qnp;
    private boolean qnq = false;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI$1 */
    class C348711 implements OnMenuItemClickListener {
        C348711() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127237);
            SettingsLanguageUI.this.aqX();
            SettingsLanguageUI.this.finish();
            AppMethodBeat.m2505o(127237);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI$2 */
    class C348722 implements OnMenuItemClickListener {
        C348722() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127238);
            SettingsLanguageUI.m67810a(SettingsLanguageUI.this, SettingsLanguageUI.this.gGN, SettingsLanguageUI.this.qnq);
            SettingsLanguageUI.this.finish();
            AppMethodBeat.m2505o(127238);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI$3 */
    class C396723 implements C1835a {
        C396723() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(127239);
            if (c1902e == null) {
                AppMethodBeat.m2505o(127239);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(127239);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127240);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.m2505o(127240);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127241);
        super.onDestroy();
        AppMethodBeat.m2505o(127241);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127242);
        setMMTitle((int) C25738R.string.e7t);
        setBackBtn(new C348711());
        mo17379a(0, getString(C25738R.string.e7s), (OnMenuItemClickListener) new C348722(), C5535b.GREEN);
        this.qnq = getIntent().getBooleanExtra("not_auth_setting", false);
        ciP();
        AppMethodBeat.m2505o(127242);
    }

    private void ciP() {
        int i = 0;
        AppMethodBeat.m2504i(127243);
        this.ehK.removeAll();
        String[] stringArray = getResources().getStringArray(C25738R.array.f12616q);
        this.gGN = C4988aa.m7405h(getSharedPreferences(C4996ah.doA(), 0));
        this.qnp = new ArrayList();
        while (i < qno.length) {
            String str = qno[i];
            this.qnp.add(new C26617a(stringArray[i], "", str, this.gGN.equalsIgnoreCase(str)));
            i++;
        }
        for (C26617a c26617a : this.qnp) {
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.mo44386a(c26617a);
            this.ehK.mo27713b(languagePreference);
        }
        this.ehK.mo27713b(new PreferenceCategory(this));
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127243);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127244);
        if (preference instanceof LanguagePreference) {
            C26617a c26617a = ((LanguagePreference) preference).gBB;
            if (c26617a == null) {
                AppMethodBeat.m2505o(127244);
                return false;
            }
            this.gGN = c26617a.gBE;
            for (C26617a c26617a2 : this.qnp) {
                c26617a2.gBF = false;
            }
            c26617a.gBF = true;
            c15541f.notifyDataSetChanged();
            AppMethodBeat.m2505o(127244);
            return true;
        }
        AppMethodBeat.m2505o(127244);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m67810a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        AppMethodBeat.m2504i(127245);
        Locale amw = C4988aa.amw(str);
        if ("language_default".equalsIgnoreCase(str)) {
            if (VERSION.SDK_INT >= 24) {
                amw = C4988aa.xyO;
                Locale.setDefault(amw);
            } else {
                amw = Locale.getDefault();
            }
        }
        C4988aa.m7401c(settingsLanguageUI.getSharedPreferences(C4996ah.doA(), 0), str);
        C4988aa.m7399a(settingsLanguageUI, amw);
        C5040bk.setProperty("system_property_key_locale", str);
        C4996ah.m7431f(C18121b.m28547a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            C24824b.gkE.mo38931p(new Intent().putExtra("Intro_Need_Clear_Top ", true), settingsLanguageUI);
            AppMethodBeat.m2505o(127245);
            return;
        }
        C1720g.m3540Rg().mo14541a(new C6668bk(new C396723()), 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_RELOAD_RESOURCES");
        intent.putExtra("tools_language", str);
        C4996ah.getContext().sendBroadcast(intent);
        if (C25985d.m41450Qb()) {
            intent.setComponent(new ComponentName(C5505l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
            C4996ah.getContext().sendBroadcast(intent);
        }
        intent = new Intent();
        intent.setComponent(new ComponentName(C5496c.yfU, "com.tencent.mm.booter.MMReceivers$ExdeviceProcessReceiver"));
        intent.putExtra("exdevice_process_action_code_key", "action_reload_resources");
        intent.putExtra("exdevice_language", str);
        C4996ah.getContext().sendBroadcast(intent);
        FontSelectorView.cjr();
        C26373g.m41965Nv().evV.clear();
        intent = new Intent();
        intent.putExtra("Intro_Need_Clear_Top ", true);
        C24824b.gkE.mo38931p(intent, settingsLanguageUI);
        AppMethodBeat.m2505o(127245);
    }
}
