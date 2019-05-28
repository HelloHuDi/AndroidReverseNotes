package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.C41341a;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI */
public class SettingsAddMeUI extends MMPreference {
    private C15541f ehK;
    private HashMap<Integer, Integer> gsc = new HashMap();
    private long kFU;
    private int qmL;
    private int status;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI$1 */
    class C132091 implements OnMenuItemClickListener {
        C132091() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127168);
            SettingsAddMeUI.this.aqX();
            SettingsAddMeUI.this.finish();
            AppMethodBeat.m2505o(127168);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsAddMeUI() {
        AppMethodBeat.m2504i(127169);
        AppMethodBeat.m2505o(127169);
    }

    /* renamed from: a */
    public final C40675h mo14627a(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(127170);
        C41341a c41341a = new C41341a(this, this.nDp, sharedPreferences);
        AppMethodBeat.m2505o(127170);
        return c41341a;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8540bo;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127171);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        this.qmL = C1853r.m3824YF();
        this.status = C1853r.m3822YD();
        this.kFU = C1853r.m3823YE();
        initView();
        AppMethodBeat.m2505o(127171);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127172);
        super.onPause();
        C4990ab.m7410d("MicroMsg.SettingsAddMeUI", "plug:" + this.qmL + ",status:" + this.status + ",extstatus:" + this.kFU);
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(this.status));
        C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(this.qmL));
        C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(this.kFU));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
            C4990ab.m7410d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        AppMethodBeat.m2505o(127172);
    }

    /* renamed from: e */
    private void m81625e(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(127174);
        C4990ab.m7410d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.m2505o(127174);
    }

    /* renamed from: f */
    private void m81626f(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(127175);
        C4990ab.m7410d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.kFU |= (long) i;
        } else {
            this.kFU &= (long) (i ^ -1);
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.m2505o(127175);
    }

    public final void initView() {
        boolean z;
        boolean z2;
        AppMethodBeat.m2504i(127176);
        setMMTitle((int) C25738R.string.e5m);
        setBackBtn(new C132091());
        C4990ab.m7410d("MicroMsg.SettingsAddMeUI", "plug:" + this.qmL + ",status:" + this.status + ",extstatus:" + this.kFU);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8540bo);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(9, null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_QQ");
        checkBoxPreference.yDf = false;
        if (num == null || num.intValue() == 0) {
            this.ehK.mo27716d(checkBoxPreference);
        } else {
            if (m81624Be(8) && m81624Be(16)) {
                z = false;
            } else {
                z = true;
            }
            checkBoxPreference.uOT = z;
        }
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_mobile");
        checkBoxPreference.yDf = false;
        if (str == null || str.length() <= 0) {
            this.ehK.mo27716d(checkBoxPreference);
        } else {
            if (m81624Be(512)) {
                z = false;
            } else {
                z = true;
            }
            checkBoxPreference.uOT = z;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_weixin");
        checkBoxPreference2.yDf = false;
        if ((this.qmL & 512) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_google");
        if (m81624Be(SQLiteGlobal.journalSizeLimit)) {
            z2 = false;
        } else {
            z2 = true;
        }
        checkBoxPreference2.uOT = z2;
        checkBoxPreference2.yDf = false;
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(208903, null);
        if (!C5046bo.m7558gT(this) || TextUtils.isEmpty(str2)) {
            this.ehK.mo27716d(checkBoxPreference2);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_add_me_by_chatroom");
        checkBoxPreference2.yDf = false;
        if ((this.kFU & 1) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_add_me_by_qrcode");
        checkBoxPreference2.yDf = false;
        if ((this.kFU & 2) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_add_me_by_namecard");
        checkBoxPreference2.yDf = false;
        if ((this.kFU & 4) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127176);
    }

    /* renamed from: Be */
    private boolean m81624Be(int i) {
        return (this.status & i) != 0;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = false;
        AppMethodBeat.m2504i(127173);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) c15541f.aqO("settings_find_me_by_QQ")).isChecked();
            m81625e(z2, 8, 2);
            m81625e(z2, 16, 3);
            AppMethodBeat.m2505o(127173);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            int i;
            if (!((CheckBoxPreference) c15541f.aqO("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            C4990ab.m7410d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.qmL |= 512;
            } else {
                this.qmL &= -513;
            }
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            this.gsc.put(Integer.valueOf(25), Integer.valueOf(i));
            AppMethodBeat.m2505o(127173);
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) c15541f.aqO("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            m81625e(z, 512, 8);
            AppMethodBeat.m2505o(127173);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) c15541f.aqO("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            m81625e(z, SQLiteGlobal.journalSizeLimit, 30);
            AppMethodBeat.m2505o(127173);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) c15541f.aqO("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            m81626f(z, 1, 38);
            AppMethodBeat.m2505o(127173);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) c15541f.aqO("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            m81626f(z, 2, 39);
            AppMethodBeat.m2505o(127173);
            return true;
        } else if (str.equals("settings_add_me_by_namecard")) {
            if (!((CheckBoxPreference) c15541f.aqO("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            m81626f(z, 4, 40);
            AppMethodBeat.m2505o(127173);
            return true;
        } else {
            AppMethodBeat.m2505o(127173);
            return false;
        }
    }
}
