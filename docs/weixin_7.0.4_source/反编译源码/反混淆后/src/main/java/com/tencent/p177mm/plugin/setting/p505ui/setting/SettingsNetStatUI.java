package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelstat.C31275m;
import com.tencent.p177mm.modelstat.C42223k;
import com.tencent.p177mm.modelstat.C42225q;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C15422bb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI */
public class SettingsNetStatUI extends MMPreference {
    private C15541f ehK;
    private long period;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI$1 */
    class C217741 implements OnMenuItemClickListener {
        C217741() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127341);
            SettingsNetStatUI.this.aqX();
            SettingsNetStatUI.this.finish();
            AppMethodBeat.m2505o(127341);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI$2 */
    class C289552 implements OnMenuItemClickListener {
        C289552() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127342);
            SettingsNetStatUI.m45965a(SettingsNetStatUI.this);
            AppMethodBeat.m2505o(127342);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI$3 */
    class C289563 implements OnClickListener {
        C289563() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127343);
            C31275m aks = C42225q.aks();
            int dpB = (int) (C5046bo.dpB() / 86400000);
            C15422bb c15422bb = aks.fTM;
            synchronized (c15422bb) {
                try {
                    c15422bb.exy.trimToSize(-1);
                    c15422bb.xBc.clear();
                    c15422bb.che.stopTimer();
                    c15422bb.xBe.stopTimer();
                    c15422bb.chh = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(127343);
                }
            }
            aks.fni.delete("netstat", null, null);
            C42223k c42223k = new C42223k();
            c42223k.fSZ = dpB;
            c42223k.f17169id = -1;
            aks.mo51240b(c42223k);
            SettingsNetStatUI.m45966b(SettingsNetStatUI.this);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI$4 */
    class C289574 implements OnClickListener {
        C289574() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m45966b(SettingsNetStatUI settingsNetStatUI) {
        AppMethodBeat.m2504i(127350);
        settingsNetStatUI.ciX();
        AppMethodBeat.m2505o(127350);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8552c0;
    }

    public final boolean aqT() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127344);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127344);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127345);
        super.onResume();
        ciX();
        AppMethodBeat.m2505o(127345);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127346);
        setMMTitle((int) C25738R.string.ebw);
        C42225q.aks().akk();
        this.ehK = this.yCw;
        this.period = C42225q.aks().akl();
        Preference aqO = this.ehK.aqO("settings_netstat_info");
        String format = new SimpleDateFormat(getString(C25738R.string.bxe), Locale.US).format(new Date(this.period));
        aqO.setTitle(getString(C25738R.string.ebu, new Object[]{format}));
        C4990ab.m7416i("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(format)));
        C4990ab.m7410d("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(format)));
        setBackBtn(new C217741());
        addTextOptionMenu(0, getString(C25738R.string.ebx), new C289552());
        AppMethodBeat.m2505o(127346);
    }

    private void ciX() {
        AppMethodBeat.m2504i(127347);
        C42223k me = C42225q.aks().mo51242me((int) (this.period / 86400000));
        if (me == null) {
            me = new C42223k();
        }
        this.period = C42225q.aks().akl();
        Object[] objArr = new Object[]{""};
        this.ehK.aqO("settings_netstat_info").setTitle(getString(C25738R.string.ebu, new Object[]{DateFormat.format(getString(C25738R.string.bxe, objArr), this.period).toString()}));
        Preference aqO = this.ehK.aqO("settings_netstat_mobile");
        C4990ab.m7417i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", Integer.valueOf(me.fTu), Integer.valueOf(me.fTi));
        aqO.setSummary(SettingsNetStatUI.m45967k(this, ((long) me.fTu) + ((long) me.fTi)));
        aqO.mo39406NW(8);
        aqO = this.ehK.aqO("settings_netstat_wifi");
        C4990ab.m7417i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", Integer.valueOf(me.fTv), Integer.valueOf(me.fTj));
        aqO.setSummary(SettingsNetStatUI.m45967k(this, ((long) me.fTv) + ((long) me.fTj)));
        aqO.mo39406NW(8);
        ((NetStatPreference) this.ehK.aqO("settings_netstat_mobile_detail")).qkW = false;
        ((NetStatPreference) this.ehK.aqO("settings_netstat_wifi_detail")).qkW = true;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127347);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }

    /* renamed from: k */
    private static String m45967k(Context context, long j) {
        AppMethodBeat.m2504i(127348);
        String string = context.getString(C25738R.string.ebt, new Object[]{C5046bo.m7565ga(j)});
        AppMethodBeat.m2505o(127348);
        return string;
    }

    /* renamed from: a */
    static /* synthetic */ void m45965a(SettingsNetStatUI settingsNetStatUI) {
        AppMethodBeat.m2504i(127349);
        C30379h.m48432a(settingsNetStatUI.mController.ylL, (int) C25738R.string.eby, (int) C25738R.string.ebz, new C289563(), new C289574());
        AppMethodBeat.m2505o(127349);
    }
}
