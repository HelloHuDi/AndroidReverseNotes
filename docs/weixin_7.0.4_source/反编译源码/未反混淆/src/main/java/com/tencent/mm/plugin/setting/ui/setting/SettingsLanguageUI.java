package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsLanguageUI extends MMPreference {
    private static final String[] qno = z.qno;
    private f ehK;
    private String gGN;
    private List<a> qnp;
    private boolean qnq = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127240);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.o(127240);
    }

    public void onDestroy() {
        AppMethodBeat.i(127241);
        super.onDestroy();
        AppMethodBeat.o(127241);
    }

    public final int JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.i(127242);
        setMMTitle((int) R.string.e7t);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127237);
                SettingsLanguageUI.this.aqX();
                SettingsLanguageUI.this.finish();
                AppMethodBeat.o(127237);
                return true;
            }
        });
        a(0, getString(R.string.e7s), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127238);
                SettingsLanguageUI.a(SettingsLanguageUI.this, SettingsLanguageUI.this.gGN, SettingsLanguageUI.this.qnq);
                SettingsLanguageUI.this.finish();
                AppMethodBeat.o(127238);
                return true;
            }
        }, b.GREEN);
        this.qnq = getIntent().getBooleanExtra("not_auth_setting", false);
        ciP();
        AppMethodBeat.o(127242);
    }

    private void ciP() {
        int i = 0;
        AppMethodBeat.i(127243);
        this.ehK.removeAll();
        String[] stringArray = getResources().getStringArray(R.array.q);
        this.gGN = aa.h(getSharedPreferences(ah.doA(), 0));
        this.qnp = new ArrayList();
        while (i < qno.length) {
            String str = qno[i];
            this.qnp.add(new a(stringArray[i], "", str, this.gGN.equalsIgnoreCase(str)));
            i++;
        }
        for (a aVar : this.qnp) {
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            this.ehK.b(languagePreference);
        }
        this.ehK.b(new PreferenceCategory(this));
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127243);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127244);
        if (preference instanceof LanguagePreference) {
            a aVar = ((LanguagePreference) preference).gBB;
            if (aVar == null) {
                AppMethodBeat.o(127244);
                return false;
            }
            this.gGN = aVar.gBE;
            for (a aVar2 : this.qnp) {
                aVar2.gBF = false;
            }
            aVar.gBF = true;
            fVar.notifyDataSetChanged();
            AppMethodBeat.o(127244);
            return true;
        }
        AppMethodBeat.o(127244);
        return false;
    }

    static /* synthetic */ void a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        AppMethodBeat.i(127245);
        Locale amw = aa.amw(str);
        if ("language_default".equalsIgnoreCase(str)) {
            if (VERSION.SDK_INT >= 24) {
                amw = aa.xyO;
                Locale.setDefault(amw);
            } else {
                amw = Locale.getDefault();
            }
        }
        aa.c(settingsLanguageUI.getSharedPreferences(ah.doA(), 0), str);
        aa.a(settingsLanguageUI, amw);
        bk.setProperty("system_property_key_locale", str);
        ah.f(com.tencent.mm.ca.b.a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            com.tencent.mm.plugin.setting.b.gkE.p(new Intent().putExtra("Intro_Need_Clear_Top ", true), settingsLanguageUI);
            AppMethodBeat.o(127245);
            return;
        }
        g.Rg().a(new com.tencent.mm.model.bk(new com.tencent.mm.model.bk.a() {
            public final void a(e eVar) {
                AppMethodBeat.i(127239);
                if (eVar == null) {
                    AppMethodBeat.o(127239);
                    return;
                }
                c adg = eVar.adg();
                byte[] bArr = new byte[0];
                byte[] bArr2 = new byte[0];
                byte[] bArr3 = new byte[0];
                g.RN();
                adg.a(bArr, bArr2, bArr3, com.tencent.mm.kernel.a.QF());
                AppMethodBeat.o(127239);
            }
        }), 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_RELOAD_RESOURCES");
        intent.putExtra("tools_language", str);
        ah.getContext().sendBroadcast(intent);
        if (d.Qb()) {
            intent.setComponent(new ComponentName(l.iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
            ah.getContext().sendBroadcast(intent);
        }
        intent = new Intent();
        intent.setComponent(new ComponentName(com.tencent.mm.ui.e.c.yfU, "com.tencent.mm.booter.MMReceivers$ExdeviceProcessReceiver"));
        intent.putExtra("exdevice_process_action_code_key", "action_reload_resources");
        intent.putExtra("exdevice_language", str);
        ah.getContext().sendBroadcast(intent);
        FontSelectorView.cjr();
        com.tencent.mm.m.g.Nv().evV.clear();
        intent = new Intent();
        intent.putExtra("Intro_Need_Clear_Top ", true);
        com.tencent.mm.plugin.setting.b.gkE.p(intent, settingsLanguageUI);
        AppMethodBeat.o(127245);
    }
}
