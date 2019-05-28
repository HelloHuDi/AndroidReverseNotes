package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.ba.a;
import com.tencent.mm.ba.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.ttpic.baseutils.FileUtils;

public class SettingsChattingBackgroundUI extends MMPreference {
    private f ehK;
    private boolean qmZ;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.bp;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127200);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127200);
    }

    public void onDestroy() {
        AppMethodBeat.i(127201);
        super.onDestroy();
        AppMethodBeat.o(127201);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127202);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(127202);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 2);
                intent2.putExtra("CropImage_bg_vertical", kq(true));
                intent2.putExtra("CropImage_bg_horizontal", kq(false));
                b.gkE.a((Activity) this, intent, intent2, c.XW(), 4, null);
                AppMethodBeat.o(127202);
                return;
            case 2:
                String h = n.h(getApplicationContext(), intent, c.XW());
                if (h == null) {
                    AppMethodBeat.o(127202);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 2);
                intent3.putExtra("CropImage_ImgPath", h);
                intent3.putExtra("CropImage_bg_vertical", kq(true));
                intent3.putExtra("CropImage_bg_horizontal", kq(false));
                b.gkE.a((Activity) this, intent3, 4);
                AppMethodBeat.o(127202);
                return;
            case 3:
                if (i2 != -1) {
                    AppMethodBeat.o(127202);
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    g.RP().Ry().set(66820, Integer.valueOf(-1));
                    h.pYm.e(10198, Integer.valueOf(-1));
                    ab.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", Integer.valueOf(-1));
                    if (!this.qmZ) {
                        com.tencent.mm.ba.b aiy = r.aiy();
                        a sU = aiy.sU(this.username);
                        if (sU != null) {
                            sU.fLV = -1;
                            aiy.b(sU);
                            break;
                        }
                        sU = new a();
                        sU.username = this.username;
                        sU.fLV = -1;
                        aiy.a(sU);
                        break;
                    }
                    g.RP().Ry().set(12311, Integer.valueOf(-1));
                    r.aix().lS(1);
                    break;
                }
                break;
        }
        if (!this.qmZ) {
            setResult(-1);
            finish();
        }
        AppMethodBeat.o(127202);
    }

    public final void initView() {
        AppMethodBeat.i(127203);
        setMMTitle((int) R.string.e6_);
        this.ehK = this.yCw;
        this.qmZ = getIntent().getBooleanExtra("isApplyToAll", true);
        if (!this.qmZ) {
            Preference aqO = this.ehK.aqO("settings_chatting_bg_apply_to_all");
            if (aqO != null) {
                this.ehK.d(aqO);
            }
        }
        this.username = getIntent().getStringExtra("username");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127197);
                SettingsChattingBackgroundUI.this.aqX();
                SettingsChattingBackgroundUI.this.finish();
                AppMethodBeat.o(127197);
                return true;
            }
        });
        AppMethodBeat.o(127203);
    }

    private void bCz() {
        AppMethodBeat.i(127205);
        if (!n.c(this, e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2)) {
            Toast.makeText(this, getString(R.string.e29), 1).show();
        }
        AppMethodBeat.o(127205);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(127206);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(127206);
            return;
        }
        ab.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(127198);
                            SettingsChattingBackgroundUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(127198);
                        }
                    }, null);
                    break;
                }
                bCz();
                AppMethodBeat.o(127206);
                return;
        }
        AppMethodBeat.o(127206);
    }

    private String kq(boolean z) {
        AppMethodBeat.i(127207);
        r.aix();
        String K;
        if (this.qmZ) {
            K = com.tencent.mm.ba.n.K("default", z);
            AppMethodBeat.o(127207);
            return K;
        }
        K = com.tencent.mm.ba.n.K(this.username, z);
        AppMethodBeat.o(127207);
        return K;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127204);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingsChattingBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_chatting_bg_select_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSelectBgUI.class);
            intent.putExtra("isApplyToAll", this.qmZ);
            intent.putExtra("username", this.username);
            startActivityForResult(intent, 3);
            AppMethodBeat.o(127204);
            return true;
        } else if (str.equals("settings_chatting_bg_select_from_album")) {
            n.a((Activity) this, 1, null);
            AppMethodBeat.o(127204);
            return true;
        } else if (str.equals("settings_chatting_bg_take_photo")) {
            ab.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")), bo.dpG(), this.mController.ylL);
            if (com.tencent.mm.pluginsdk.permission.b.a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                bCz();
                AppMethodBeat.o(127204);
                return true;
            }
            AppMethodBeat.o(127204);
            return false;
        } else if (str.equals("settings_chatting_bg_apply_to_all")) {
            com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(R.string.e6a), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127199);
                    SettingsChattingBackgroundUI.ciN();
                    AppMethodBeat.o(127199);
                }
            }, null);
            AppMethodBeat.o(127204);
            return true;
        } else {
            AppMethodBeat.o(127204);
            return false;
        }
    }

    static /* synthetic */ void ciN() {
        AppMethodBeat.i(127208);
        com.tencent.mm.ba.b aiy = r.aiy();
        Cursor a = aiy.fni.a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo  ", null, 0);
        if (a == null) {
            ab.i("MicroMsg.SettingsChattingBackgroundUI", "applyToAll : cursor is null");
            AppMethodBeat.o(127208);
            return;
        }
        r.aix();
        if (a.moveToFirst()) {
            a aVar = new a();
            while (!a.isAfterLast()) {
                aVar.d(a);
                com.tencent.mm.a.e.deleteFile(com.tencent.mm.ba.n.K(aVar.getUsername(), true));
                com.tencent.mm.a.e.deleteFile(com.tencent.mm.ba.n.K(aVar.getUsername(), false));
                a.moveToNext();
            }
        }
        a.close();
        if (aiy.fni.delete("chattingbginfo", null, null) > 0) {
            aiy.doNotify();
        }
        AppMethodBeat.o(127208);
    }
}
