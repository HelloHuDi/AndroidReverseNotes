package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI extends MMPreference {
    private f ehK;
    private long period;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(SettingsNetStatUI settingsNetStatUI) {
        AppMethodBeat.i(127350);
        settingsNetStatUI.ciX();
        AppMethodBeat.o(127350);
    }

    public final int JC() {
        return R.xml.c0;
    }

    public final boolean aqT() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127344);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127344);
    }

    public void onResume() {
        AppMethodBeat.i(127345);
        super.onResume();
        ciX();
        AppMethodBeat.o(127345);
    }

    public final void initView() {
        AppMethodBeat.i(127346);
        setMMTitle((int) R.string.ebw);
        q.aks().akk();
        this.ehK = this.yCw;
        this.period = q.aks().akl();
        Preference aqO = this.ehK.aqO("settings_netstat_info");
        String format = new SimpleDateFormat(getString(R.string.bxe), Locale.US).format(new Date(this.period));
        aqO.setTitle(getString(R.string.ebu, new Object[]{format}));
        ab.i("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(format)));
        ab.d("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(format)));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127341);
                SettingsNetStatUI.this.aqX();
                SettingsNetStatUI.this.finish();
                AppMethodBeat.o(127341);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.ebx), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127342);
                SettingsNetStatUI.a(SettingsNetStatUI.this);
                AppMethodBeat.o(127342);
                return true;
            }
        });
        AppMethodBeat.o(127346);
    }

    private void ciX() {
        AppMethodBeat.i(127347);
        k me = q.aks().me((int) (this.period / 86400000));
        if (me == null) {
            me = new k();
        }
        this.period = q.aks().akl();
        Object[] objArr = new Object[]{""};
        this.ehK.aqO("settings_netstat_info").setTitle(getString(R.string.ebu, new Object[]{DateFormat.format(getString(R.string.bxe, objArr), this.period).toString()}));
        Preference aqO = this.ehK.aqO("settings_netstat_mobile");
        ab.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", Integer.valueOf(me.fTu), Integer.valueOf(me.fTi));
        aqO.setSummary(k(this, ((long) me.fTu) + ((long) me.fTi)));
        aqO.NW(8);
        aqO = this.ehK.aqO("settings_netstat_wifi");
        ab.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", Integer.valueOf(me.fTv), Integer.valueOf(me.fTj));
        aqO.setSummary(k(this, ((long) me.fTv) + ((long) me.fTj)));
        aqO.NW(8);
        ((NetStatPreference) this.ehK.aqO("settings_netstat_mobile_detail")).qkW = false;
        ((NetStatPreference) this.ehK.aqO("settings_netstat_wifi_detail")).qkW = true;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127347);
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private static String k(Context context, long j) {
        AppMethodBeat.i(127348);
        String string = context.getString(R.string.ebt, new Object[]{bo.ga(j)});
        AppMethodBeat.o(127348);
        return string;
    }

    static /* synthetic */ void a(SettingsNetStatUI settingsNetStatUI) {
        AppMethodBeat.i(127349);
        h.a(settingsNetStatUI.mController.ylL, (int) R.string.eby, (int) R.string.ebz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(127343);
                m aks = q.aks();
                int dpB = (int) (bo.dpB() / 86400000);
                bb bbVar = aks.fTM;
                synchronized (bbVar) {
                    try {
                        bbVar.exy.trimToSize(-1);
                        bbVar.xBc.clear();
                        bbVar.che.stopTimer();
                        bbVar.xBe.stopTimer();
                        bbVar.chh = true;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(127343);
                    }
                }
                aks.fni.delete("netstat", null, null);
                k kVar = new k();
                kVar.fSZ = dpB;
                kVar.id = -1;
                aks.b(kVar);
                SettingsNetStatUI.b(SettingsNetStatUI.this);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(127349);
    }
}
