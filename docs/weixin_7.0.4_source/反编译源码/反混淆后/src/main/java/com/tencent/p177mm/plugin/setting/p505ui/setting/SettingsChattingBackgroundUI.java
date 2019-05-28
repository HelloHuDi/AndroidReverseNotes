package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p707ba.C37504a;
import com.tencent.p177mm.p707ba.C41787r;
import com.tencent.p177mm.p707ba.C45179b;
import com.tencent.p177mm.p707ba.C9067n;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.FileUtils;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI */
public class SettingsChattingBackgroundUI extends MMPreference {
    private C15541f ehK;
    private boolean qmZ;
    private String username;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI$3 */
    class C217593 implements OnClickListener {
        C217593() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127199);
            SettingsChattingBackgroundUI.ciN();
            AppMethodBeat.m2505o(127199);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI$1 */
    class C289421 implements OnMenuItemClickListener {
        C289421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127197);
            SettingsChattingBackgroundUI.this.aqX();
            SettingsChattingBackgroundUI.this.finish();
            AppMethodBeat.m2505o(127197);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI$2 */
    class C289432 implements OnClickListener {
        C289432() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127198);
            SettingsChattingBackgroundUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(127198);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8541bp;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127200);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127200);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127201);
        super.onDestroy();
        AppMethodBeat.m2505o(127201);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127202);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(127202);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 2);
                intent2.putExtra("CropImage_bg_vertical", m45959kq(true));
                intent2.putExtra("CropImage_bg_horizontal", m45959kq(false));
                C24824b.gkE.mo38891a((Activity) this, intent, intent2, C43217c.m76863XW(), 4, null);
                AppMethodBeat.m2505o(127202);
                return;
            case 2:
                String h = C14987n.m23320h(getApplicationContext(), intent, C43217c.m76863XW());
                if (h == null) {
                    AppMethodBeat.m2505o(127202);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 2);
                intent3.putExtra("CropImage_ImgPath", h);
                intent3.putExtra("CropImage_bg_vertical", m45959kq(true));
                intent3.putExtra("CropImage_bg_horizontal", m45959kq(false));
                C24824b.gkE.mo38890a((Activity) this, intent3, 4);
                AppMethodBeat.m2505o(127202);
                return;
            case 3:
                if (i2 != -1) {
                    AppMethodBeat.m2505o(127202);
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    C1720g.m3536RP().mo5239Ry().set(66820, Integer.valueOf(-1));
                    C7060h.pYm.mo8381e(10198, Integer.valueOf(-1));
                    C4990ab.m7417i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", Integer.valueOf(-1));
                    if (!this.qmZ) {
                        C45179b aiy = C41787r.aiy();
                        C37504a sU = aiy.mo73165sU(this.username);
                        if (sU != null) {
                            sU.fLV = -1;
                            aiy.mo73164b(sU);
                            break;
                        }
                        sU = new C37504a();
                        sU.username = this.username;
                        sU.fLV = -1;
                        aiy.mo73163a(sU);
                        break;
                    }
                    C1720g.m3536RP().mo5239Ry().set(12311, Integer.valueOf(-1));
                    C41787r.aix().mo20545lS(1);
                    break;
                }
                break;
        }
        if (!this.qmZ) {
            setResult(-1);
            finish();
        }
        AppMethodBeat.m2505o(127202);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127203);
        setMMTitle((int) C25738R.string.e6_);
        this.ehK = this.yCw;
        this.qmZ = getIntent().getBooleanExtra("isApplyToAll", true);
        if (!this.qmZ) {
            Preference aqO = this.ehK.aqO("settings_chatting_bg_apply_to_all");
            if (aqO != null) {
                this.ehK.mo27716d(aqO);
            }
        }
        this.username = getIntent().getStringExtra("username");
        setBackBtn(new C289421());
        AppMethodBeat.m2505o(127203);
    }

    private void bCz() {
        AppMethodBeat.m2504i(127205);
        if (!C14987n.m23311c(this, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2)) {
            Toast.makeText(this, getString(C25738R.string.e29), 1).show();
        }
        AppMethodBeat.m2505o(127205);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(127206);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(127206);
            return;
        }
        C4990ab.m7417i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C289432(), null);
                    break;
                }
                bCz();
                AppMethodBeat.m2505o(127206);
                return;
        }
        AppMethodBeat.m2505o(127206);
    }

    /* renamed from: kq */
    private String m45959kq(boolean z) {
        AppMethodBeat.m2504i(127207);
        C41787r.aix();
        String K;
        if (this.qmZ) {
            K = C9067n.m16437K("default", z);
            AppMethodBeat.m2505o(127207);
            return K;
        }
        K = C9067n.m16437K(this.username, z);
        AppMethodBeat.m2505o(127207);
        return K;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127204);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingsChattingBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_chatting_bg_select_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSelectBgUI.class);
            intent.putExtra("isApplyToAll", this.qmZ);
            intent.putExtra("username", this.username);
            startActivityForResult(intent, 3);
            AppMethodBeat.m2505o(127204);
            return true;
        } else if (str.equals("settings_chatting_bg_select_from_album")) {
            C14987n.m23301a((Activity) this, 1, null);
            AppMethodBeat.m2505o(127204);
            return true;
        } else if (str.equals("settings_chatting_bg_take_photo")) {
            C4990ab.m7417i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")), C5046bo.dpG(), this.mController.ylL);
            if (C35805b.m58707a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                bCz();
                AppMethodBeat.m2505o(127204);
                return true;
            }
            AppMethodBeat.m2505o(127204);
            return false;
        } else if (str.equals("settings_chatting_bg_apply_to_all")) {
            C30379h.m48440a(this.mController.ylL, getString(C25738R.string.e6a), "", new C217593(), null);
            AppMethodBeat.m2505o(127204);
            return true;
        } else {
            AppMethodBeat.m2505o(127204);
            return false;
        }
    }

    static /* synthetic */ void ciN() {
        AppMethodBeat.m2504i(127208);
        C45179b aiy = C41787r.aiy();
        Cursor a = aiy.fni.mo10104a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo  ", null, 0);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.SettingsChattingBackgroundUI", "applyToAll : cursor is null");
            AppMethodBeat.m2505o(127208);
            return;
        }
        C41787r.aix();
        if (a.moveToFirst()) {
            C37504a c37504a = new C37504a();
            while (!a.isAfterLast()) {
                c37504a.mo60439d(a);
                C1173e.deleteFile(C9067n.m16437K(c37504a.getUsername(), true));
                C1173e.deleteFile(C9067n.m16437K(c37504a.getUsername(), false));
                a.moveToNext();
            }
        }
        a.close();
        if (aiy.fni.delete("chattingbginfo", null, null) > 0) {
            aiy.doNotify();
        }
        AppMethodBeat.m2505o(127208);
    }
}
