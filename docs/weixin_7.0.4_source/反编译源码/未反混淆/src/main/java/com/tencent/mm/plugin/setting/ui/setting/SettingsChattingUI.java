package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SettingsChattingUI extends MMPreference {
    private f ehK;
    private boolean isDeleteCancel = false;
    private ProgressDialog qlZ = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127216);
        super.onCreate(bundle);
        if (g.RN().QY()) {
            initView();
            AppMethodBeat.o(127216);
            return;
        }
        finish();
        AppMethodBeat.o(127216);
    }

    public final void initView() {
        AppMethodBeat.i(127217);
        setMMTitle((int) R.string.e69);
        this.ehK = this.yCw;
        if (g.RP().Ry().getInt(89, 0) != 2) {
            this.ehK.aqP("settings_recovery");
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127209);
                SettingsChattingUI.this.aqX();
                SettingsChattingUI.this.finish();
                AppMethodBeat.o(127209);
                return true;
            }
        });
        AppMethodBeat.o(127217);
    }

    public void onResume() {
        AppMethodBeat.i(127218);
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) g.RP().Ry().get(26, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) g.RP().Ry().get(66832, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        Preference aqO = this.ehK.aqO("settings_text_size");
        if (aqO != null) {
            aqO.setSummary(getString(SetTextSizeUI.eN(this)));
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127218);
    }

    public final int JC() {
        return R.xml.bx;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(127219);
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
                boolean booleanValue = ((Boolean) g.RP().Ry().get(26, Boolean.FALSE)).booleanValue();
                String str2 = "MicroMsg.SettingsChattingUI";
                String str3 = "set voice mode from %B to %B";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(booleanValue);
                objArr[1] = Boolean.valueOf(!booleanValue);
                ab.d(str2, str3, objArr);
                z Ry = g.RP().Ry();
                if (!booleanValue) {
                    z = true;
                }
                Ry.set(26, Boolean.valueOf(z));
                AppMethodBeat.o(127219);
                return true;
            case true:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
                if (checkBoxPreference != null) {
                    ab.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", Boolean.valueOf(checkBoxPreference.isChecked()));
                    g.RP().Ry().set(66832, Boolean.valueOf(z2));
                }
                AppMethodBeat.o(127219);
                return true;
            case true:
                MMWizardActivity.J(this.mController.ylL, new Intent().setClassName(this.mController.ylL, "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI"));
                AppMethodBeat.o(127219);
                return true;
            case true:
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(127219);
                return true;
            case true:
                intent = new Intent();
                intent.putExtra("10931", 2);
                d.b(this.mController.ylL, "emoji", ".ui.EmojiMineUI", intent);
                AppMethodBeat.o(127219);
                return true;
            case true:
                h.d(this.mController.ylL, getResources().getString(R.string.e_y), "", getString(R.string.ou), getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ArrayList arrayList;
                        AppMethodBeat.i(127213);
                        com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(5), Integer.valueOf(2), "");
                        com.tencent.mm.plugin.report.service.h.pYm.a(324, 0, 1, false);
                        SettingsChattingUI.this.isDeleteCancel = false;
                        SettingsChattingUI settingsChattingUI = SettingsChattingUI.this;
                        Context context = SettingsChattingUI.this;
                        SettingsChattingUI.this.getString(R.string.tz);
                        settingsChattingUI.qlZ = h.b(context, SettingsChattingUI.this.getString(R.string.un), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(127210);
                                SettingsChattingUI.this.isDeleteCancel = true;
                                AppMethodBeat.o(127210);
                            }
                        });
                        List<bi> bOH = ((j) g.K(j.class)).bOr().bOH();
                        if (bOH != null) {
                            ab.i("MicroMsg.WalletConvDelCheckLogic", "checkGetUnProcessorWalletConversation, msgInfoList size: %s", Integer.valueOf(bOH.size()));
                            HashSet hashSet = new HashSet();
                            for (bi biVar : bOH) {
                                if (!(hashSet.contains(biVar.field_talker) || ((j) g.K(j.class)).XR().aoZ(biVar.field_talker) == null || !e.am(biVar))) {
                                    hashSet.add(biVar.field_talker);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(hashSet);
                            arrayList = arrayList2;
                        } else {
                            arrayList = null;
                        }
                        if (arrayList == null || arrayList.size() <= 0) {
                            SettingsChattingUI.b(SettingsChattingUI.this);
                            AppMethodBeat.o(127213);
                            return;
                        }
                        SettingsChattingUI.this.qlZ.dismiss();
                        h.a(SettingsChattingUI.this, false, SettingsChattingUI.this.getString(R.string.fdm, new Object[]{Integer.valueOf(arrayList.size())}), null, SettingsChattingUI.this.getString(R.string.c9y), SettingsChattingUI.this.getString(R.string.ar2), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(127211);
                                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(5), Integer.valueOf(4), "");
                                SettingsChattingUI.this.isDeleteCancel = true;
                                if (arrayList.size() <= 1) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Chat_User", (String) arrayList.get(0));
                                    intent.addFlags(67108864);
                                    d.f(SettingsChattingUI.this, ".ui.chatting.ChattingUI", intent);
                                    AppMethodBeat.o(127211);
                                    return;
                                }
                                Intent intent2 = new Intent();
                                intent2.putStringArrayListExtra("key_conversation_list", arrayList);
                                d.f(SettingsChattingUI.this, ".ui.conversation.SettingCheckUnProcessWalletConvUI", intent2);
                                AppMethodBeat.o(127211);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(127212);
                                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(5), Integer.valueOf(3), "");
                                SettingsChattingUI.this.qlZ.show();
                                SettingsChattingUI.this.isDeleteCancel = false;
                                SettingsChattingUI.b(SettingsChattingUI.this);
                                AppMethodBeat.o(127212);
                            }
                        }, -1, R.color.ei);
                        AppMethodBeat.o(127213);
                    }
                }, null);
                AppMethodBeat.o(127219);
                return true;
            case true:
                intent = new Intent().setClassName(this.mController.ylL, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
                intent.putExtra("scene", 1);
                this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(127219);
                return true;
            default:
                AppMethodBeat.o(127219);
                return false;
        }
    }

    static /* synthetic */ void b(SettingsChattingUI settingsChattingUI) {
        AppMethodBeat.i(127220);
        List dsO = ((j) g.K(j.class)).XR().dsO();
        if (dsO.size() > 0) {
            List S = m.S(dsO);
            if (S != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= S.size()) {
                        break;
                    }
                    if (((Boolean) S.get(i2)).booleanValue()) {
                        b.gkF.dl((String) dsO.get(i2));
                    }
                    i = i2 + 1;
                }
            }
        }
        bf.a(new a() {
            public final boolean JU() {
                AppMethodBeat.i(127214);
                boolean c = SettingsChattingUI.this.isDeleteCancel;
                AppMethodBeat.o(127214);
                return c;
            }

            public final void JV() {
                AppMethodBeat.i(127215);
                if (SettingsChattingUI.this.qlZ != null) {
                    SettingsChattingUI.this.qlZ.dismiss();
                    SettingsChattingUI.this.qlZ = null;
                }
                com.tencent.mm.sdk.b.a.xxA.m(new pa());
                AppMethodBeat.o(127215);
            }
        });
        AppMethodBeat.o(127220);
    }
}
