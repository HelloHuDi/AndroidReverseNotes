package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;

public class SettingSnsBackgroundUI extends MMPreference {
    private f ehK;
    private SharedPreferences ehZ;
    protected String filePath;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingSnsBackgroundUI settingSnsBackgroundUI, int i, Intent intent) {
        AppMethodBeat.i(38569);
        settingSnsBackgroundUI.g(i, intent);
        AppMethodBeat.o(38569);
    }

    public final int JC() {
        return R.xml.c9;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38559);
        ab.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
        super.onCreate(bundle);
        this.ehK = this.yCw;
        this.ehZ = getSharedPreferences(ah.doA(), 0);
        initView();
        AppMethodBeat.o(38559);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(38560);
        ab.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        setResult(-1);
        finish();
        AppMethodBeat.o(38560);
    }

    public void onDestroy() {
        AppMethodBeat.i(38561);
        super.onDestroy();
        ab.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
        AppMethodBeat.o(38561);
    }

    public void onResume() {
        AppMethodBeat.i(38562);
        super.onResume();
        if (this.ehK != null) {
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.o(38562);
    }

    private void g(int i, Intent intent) {
        AppMethodBeat.i(38563);
        String str;
        switch (i) {
            case 2:
                ab.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
                this.filePath = n.h(getApplicationContext(), intent, af.getAccSnsTmpPath());
                if (this.filePath == null) {
                    AppMethodBeat.o(38563);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_ImgPath", this.filePath);
                str = "CropImage_OutputPath";
                intent2.putExtra(str, af.getAccSnsTmpPath() + g.x((this.filePath + System.currentTimeMillis()).getBytes()));
                a.gkE.a((Activity) this, intent2, 6);
                AppMethodBeat.o(38563);
                return;
            case 5:
                ab.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                if (intent == null) {
                    AppMethodBeat.o(38563);
                    return;
                }
                this.filePath = n.h(getApplicationContext(), intent, af.getAccSnsTmpPath());
                if (this.filePath == null) {
                    AppMethodBeat.o(38563);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_ImgPath", this.filePath);
                a.gkE.a((Activity) this, intent, intent3, af.getAccSnsTmpPath(), 6, new com.tencent.mm.ui.tools.a.a() {
                    public final String ZB(String str) {
                        AppMethodBeat.i(38553);
                        String str2 = af.getAccSnsTmpPath() + g.x((SettingSnsBackgroundUI.this.filePath + System.currentTimeMillis()).getBytes());
                        AppMethodBeat.o(38553);
                        return str2;
                    }
                });
                AppMethodBeat.o(38563);
                return;
            case 6:
                ab.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38554);
                        a.gkF.BU();
                        AppMethodBeat.o(38554);
                    }
                });
                if (intent == null) {
                    AppMethodBeat.o(38563);
                    return;
                }
                this.filePath = intent.getStringExtra("CropImage_OutputPath");
                if (this.filePath == null) {
                    AppMethodBeat.o(38563);
                    return;
                }
                ab.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
                aw cnB = af.cnB();
                String str2 = this.filePath;
                new LinkedList().add(new h(str2, 2));
                if (!(cnB.cnk() == null || cnB.cnk().equals(""))) {
                    str = an.fZ(af.getAccSnsPath(), cnB.cnk());
                    e.tf(str);
                    e.deleteFile(str + cnB.cnk() + "bg_");
                    e.y(str2, str + cnB.cnk() + "bg_");
                    m cnJ = af.cnJ();
                    l YX = cnJ.YX(cnB.cnk());
                    YX.field_bgId = "";
                    cnJ.c(YX);
                }
                cnB.con();
                cnB.cnk();
                ax axVar = new ax(7);
                axVar.ge(str2, "");
                axVar.De(1);
                axVar.commit();
                setResult(-1);
                finish();
                AppMethodBeat.o(38563);
                return;
            default:
                ab.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
                AppMethodBeat.o(38563);
                return;
        }
    }

    public void onActivityResult(final int i, final int i2, final Intent intent) {
        AppMethodBeat.i(38564);
        ab.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + i + " " + i2);
        if (i2 != -1) {
            if (i == 2 || i == 5 || i == 6) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(38555);
                        a.gkF.BU();
                        AppMethodBeat.o(38555);
                    }
                });
            }
            AppMethodBeat.o(38564);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("result ok ");
        com.tencent.mm.kernel.g.RQ();
        ab.d("MicroMsg.SettingSnsBackgroundUI", stringBuilder.append(com.tencent.mm.kernel.g.RN().QY()).toString());
        if (af.cnn()) {
            new ak(Looper.myLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38556);
                    SettingSnsBackgroundUI.a(SettingSnsBackgroundUI.this, i, intent);
                    AppMethodBeat.o(38556);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.o(38564);
            return;
        }
        ab.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
        g(i, intent);
        AppMethodBeat.o(38564);
    }

    public final void initView() {
        AppMethodBeat.i(38565);
        setMMTitle((int) R.string.eat);
        SnsArtistPreference snsArtistPreference = (SnsArtistPreference) this.ehK.aqO("settings_sns_bg_select_bg");
        if (snsArtistPreference != null) {
            String string = this.ehZ.getString("artist_name", "");
            ab.d("MicroMsg.SettingSnsBackgroundUI", "artistName".concat(String.valueOf(string)));
            snsArtistPreference.ZE(string);
            this.ehK.notifyDataSetChanged();
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38557);
                SettingSnsBackgroundUI.this.finish();
                AppMethodBeat.o(38557);
                return true;
            }
        });
        AppMethodBeat.o(38565);
    }

    private void bCz() {
        AppMethodBeat.i(38567);
        if (!n.c(this, com.tencent.mm.compatible.util.e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2)) {
            Toast.makeText(this, getString(R.string.e29), 1).show();
        }
        AppMethodBeat.o(38567);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(38568);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(38568);
            return;
        }
        ab.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(38558);
                            SettingSnsBackgroundUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(38558);
                        }
                    }, null);
                    break;
                }
                bCz();
                AppMethodBeat.o(38568);
                return;
        }
        AppMethodBeat.o(38568);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(38566);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingSnsBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_sns_bg_select_from_album")) {
            com.tencent.mm.kernel.g.RQ();
            if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                n.a((Activity) this, 5, null);
                AppMethodBeat.o(38566);
                return true;
            }
            t.hO(this);
            AppMethodBeat.o(38566);
            return false;
        } else if (str.equals("settings_sns_bg_take_photo")) {
            com.tencent.mm.kernel.g.RQ();
            if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                ab.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(b.a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")), bo.dpG(), this.mController.ylL);
                if (b.a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                    bCz();
                    AppMethodBeat.o(38566);
                    return true;
                }
                AppMethodBeat.o(38566);
                return false;
            }
            t.hO(this);
            AppMethodBeat.o(38566);
            return false;
        } else if (str.equals("settings_sns_bg_select_bg")) {
            startActivity(new Intent(this, ArtistUI.class));
            AppMethodBeat.o(38566);
            return true;
        } else {
            AppMethodBeat.o(38566);
            return false;
        }
    }
}
