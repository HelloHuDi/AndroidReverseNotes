package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.p230g.p231a.C18363pa;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.wallet.C40492e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI */
public class SettingsChattingUI extends MMPreference {
    private C15541f ehK;
    private boolean isDeleteCancel = false;
    private ProgressDialog qlZ = null;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI$1 */
    class C217601 implements OnMenuItemClickListener {
        C217601() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127209);
            SettingsChattingUI.this.aqX();
            SettingsChattingUI.this.finish();
            AppMethodBeat.m2505o(127209);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI$2 */
    class C396692 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI$2$1 */
        class C348681 implements OnCancelListener {
            C348681() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127210);
                SettingsChattingUI.this.isDeleteCancel = true;
                AppMethodBeat.m2505o(127210);
            }
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI$2$3 */
        class C348703 implements OnClickListener {
            C348703() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(127212);
                C7060h.pYm.mo8381e(14553, Integer.valueOf(5), Integer.valueOf(3), "");
                SettingsChattingUI.this.qlZ.show();
                SettingsChattingUI.this.isDeleteCancel = false;
                SettingsChattingUI.m67795b(SettingsChattingUI.this);
                AppMethodBeat.m2505o(127212);
            }
        }

        C396692() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ArrayList arrayList;
            AppMethodBeat.m2504i(127213);
            C7060h.pYm.mo8381e(14553, Integer.valueOf(5), Integer.valueOf(2), "");
            C7060h.pYm.mo8378a(324, 0, 1, false);
            SettingsChattingUI.this.isDeleteCancel = false;
            SettingsChattingUI settingsChattingUI = SettingsChattingUI.this;
            Context context = SettingsChattingUI.this;
            SettingsChattingUI.this.getString(C25738R.string.f9238tz);
            settingsChattingUI.qlZ = C30379h.m48458b(context, SettingsChattingUI.this.getString(C25738R.string.f9260un), true, new C348681());
            List<C7620bi> bOH = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().bOH();
            if (bOH != null) {
                C4990ab.m7417i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", Integer.valueOf(bOH.size()));
                HashSet hashSet = new HashSet();
                for (C7620bi c7620bi : bOH) {
                    if (!(hashSet.contains(c7620bi.field_talker) || ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c7620bi.field_talker) == null || !C40492e.m69624am(c7620bi))) {
                        hashSet.add(c7620bi.field_talker);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(hashSet);
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                SettingsChattingUI.m67795b(SettingsChattingUI.this);
                AppMethodBeat.m2505o(127213);
                return;
            }
            SettingsChattingUI.this.qlZ.dismiss();
            C30379h.m48454a(SettingsChattingUI.this, false, SettingsChattingUI.this.getString(C25738R.string.fdm, new Object[]{Integer.valueOf(arrayList.size())}), null, SettingsChattingUI.this.getString(C25738R.string.c9y), SettingsChattingUI.this.getString(C25738R.string.ar2), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(127211);
                    C7060h.pYm.mo8381e(14553, Integer.valueOf(5), Integer.valueOf(4), "");
                    SettingsChattingUI.this.isDeleteCancel = true;
                    if (arrayList.size() <= 1) {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", (String) arrayList.get(0));
                        intent.addFlags(67108864);
                        C25985d.m41473f(SettingsChattingUI.this, ".ui.chatting.ChattingUI", intent);
                        AppMethodBeat.m2505o(127211);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putStringArrayListExtra("key_conversation_list", arrayList);
                    C25985d.m41473f(SettingsChattingUI.this, ".ui.conversation.SettingCheckUnProcessWalletConvUI", intent2);
                    AppMethodBeat.m2505o(127211);
                }
            }, new C348703(), -1, C25738R.color.f11717ei);
            AppMethodBeat.m2505o(127213);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI$3 */
    class C396703 implements C1827a {
        C396703() {
        }

        /* renamed from: JU */
        public final boolean mo5405JU() {
            AppMethodBeat.m2504i(127214);
            boolean c = SettingsChattingUI.this.isDeleteCancel;
            AppMethodBeat.m2505o(127214);
            return c;
        }

        /* renamed from: JV */
        public final void mo5406JV() {
            AppMethodBeat.m2504i(127215);
            if (SettingsChattingUI.this.qlZ != null) {
                SettingsChattingUI.this.qlZ.dismiss();
                SettingsChattingUI.this.qlZ = null;
            }
            C4879a.xxA.mo10055m(new C18363pa());
            AppMethodBeat.m2505o(127215);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127216);
        super.onCreate(bundle);
        if (C1720g.m3534RN().mo5161QY()) {
            initView();
            AppMethodBeat.m2505o(127216);
            return;
        }
        finish();
        AppMethodBeat.m2505o(127216);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127217);
        setMMTitle((int) C25738R.string.e69);
        this.ehK = this.yCw;
        if (C1720g.m3536RP().mo5239Ry().getInt(89, 0) != 2) {
            this.ehK.aqP("settings_recovery");
        }
        setBackBtn(new C217601());
        AppMethodBeat.m2505o(127217);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127218);
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) C1720g.m3536RP().mo5239Ry().get(26, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) C1720g.m3536RP().mo5239Ry().get(66832, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        Preference aqO = this.ehK.aqO("settings_text_size");
        if (aqO != null) {
            aqO.setSummary(getString(SetTextSizeUI.m57245eN(this)));
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127218);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8549bx;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = false;
        AppMethodBeat.m2504i(127219);
        String str = preference.mKey;
        boolean z2 = true;
        switch (str.hashCode()) {
            case -1776646462:
                if (str.equals("settings_chatting_bg")) {
                    z2 = true;
                    break;
                }
                break;
            case -1565531065:
                if (str.equals("settings_bak_chat")) {
                    z2 = true;
                    break;
                }
                break;
            case -1550690765:
                if (str.equals("settings_reset")) {
                    z2 = true;
                    break;
                }
                break;
            case -1439483675:
                if (str.equals("settings_voice_play_mode")) {
                    z2 = false;
                    break;
                }
                break;
            case -409015247:
                if (str.equals("settings_recovery")) {
                    z2 = true;
                    break;
                }
                break;
            case 624882802:
                if (str.equals("settings_enter_button_send")) {
                    z2 = true;
                    break;
                }
                break;
            case 1789437336:
                if (str.equals("settings_emoji_manager")) {
                    z2 = true;
                    break;
                }
                break;
        }
        Intent intent;
        switch (z2) {
            case false:
                boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(26, Boolean.FALSE)).booleanValue();
                String str2 = "MicroMsg.SettingsChattingUI";
                String str3 = "set voice mode from %B to %B";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(booleanValue);
                objArr[1] = Boolean.valueOf(!booleanValue);
                C4990ab.m7411d(str2, str3, objArr);
                C7580z Ry = C1720g.m3536RP().mo5239Ry();
                if (!booleanValue) {
                    z = true;
                }
                Ry.set(26, Boolean.valueOf(z));
                AppMethodBeat.m2505o(127219);
                return true;
            case true:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
                if (checkBoxPreference != null) {
                    C4990ab.m7411d("MicroMsg.SettingsChattingUI", "set enter button send : %s", Boolean.valueOf(checkBoxPreference.isChecked()));
                    C1720g.m3536RP().mo5239Ry().set(66832, Boolean.valueOf(z2));
                }
                AppMethodBeat.m2505o(127219);
                return true;
            case true:
                MMWizardActivity.m23791J(this.mController.ylL, new Intent().setClassName(this.mController.ylL, "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI"));
                AppMethodBeat.m2505o(127219);
                return true;
            case true:
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.ylL.startActivity(intent);
                AppMethodBeat.m2505o(127219);
                return true;
            case true:
                intent = new Intent();
                intent.putExtra("10931", 2);
                C25985d.m41467b(this.mController.ylL, "emoji", ".ui.EmojiMineUI", intent);
                AppMethodBeat.m2505o(127219);
                return true;
            case true:
                C30379h.m48466d(this.mController.ylL, getResources().getString(C25738R.string.e_y), "", getString(C25738R.string.f9078ou), getString(C25738R.string.f9076or), new C396692(), null);
                AppMethodBeat.m2505o(127219);
                return true;
            case true:
                intent = new Intent().setClassName(this.mController.ylL, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
                intent.putExtra("scene", 1);
                this.mController.ylL.startActivity(intent);
                AppMethodBeat.m2505o(127219);
                return true;
            default:
                AppMethodBeat.m2505o(127219);
                return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m67795b(SettingsChattingUI settingsChattingUI) {
        AppMethodBeat.m2504i(127220);
        List dsO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().dsO();
        if (dsO.size() > 0) {
            List S = C32794m.m53571S(dsO);
            if (S != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= S.size()) {
                        break;
                    }
                    if (((Boolean) S.get(i2)).booleanValue()) {
                        C24824b.gkF.mo38867dl((String) dsO.get(i2));
                    }
                    i = i2 + 1;
                }
            }
        }
        C1829bf.m3742a(new C396703());
        AppMethodBeat.m2505o(127220);
    }
}
