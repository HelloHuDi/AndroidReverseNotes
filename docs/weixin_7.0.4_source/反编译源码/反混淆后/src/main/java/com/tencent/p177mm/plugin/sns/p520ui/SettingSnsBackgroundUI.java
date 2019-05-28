package com.tencent.p177mm.plugin.sns.p520ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.tools.C36338a.C15946a;
import com.tencent.p177mm.plugin.sns.data.C21881h;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29050aw;
import com.tencent.p177mm.plugin.sns.model.C29054ax;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C43573m;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI */
public class SettingSnsBackgroundUI extends MMPreference {
    private C15541f ehK;
    private SharedPreferences ehZ;
    protected String filePath;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI$3 */
    class C134953 implements Runnable {
        C134953() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38555);
            C24826a.gkF.mo38845BU();
            AppMethodBeat.m2505o(38555);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI$5 */
    class C134965 implements OnMenuItemClickListener {
        C134965() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(38557);
            SettingSnsBackgroundUI.this.finish();
            AppMethodBeat.m2505o(38557);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI$6 */
    class C134976 implements OnClickListener {
        C134976() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(38558);
            SettingSnsBackgroundUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(38558);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI$1 */
    class C397941 implements C15946a {
        C397941() {
        }

        /* renamed from: ZB */
        public final String mo25777ZB(String str) {
            AppMethodBeat.m2504i(38553);
            String str2 = C13373af.getAccSnsTmpPath() + C1178g.m2591x((SettingSnsBackgroundUI.this.filePath + System.currentTimeMillis()).getBytes());
            AppMethodBeat.m2505o(38553);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI$2 */
    class C447662 implements Runnable {
        C447662() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38554);
            C24826a.gkF.mo38845BU();
            AppMethodBeat.m2505o(38554);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m81662a(SettingSnsBackgroundUI settingSnsBackgroundUI, int i, Intent intent) {
        AppMethodBeat.m2504i(38569);
        settingSnsBackgroundUI.m81663g(i, intent);
        AppMethodBeat.m2505o(38569);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8560c9;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(38559);
        C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
        super.onCreate(bundle);
        this.ehK = this.yCw;
        this.ehZ = getSharedPreferences(C4996ah.doA(), 0);
        initView();
        AppMethodBeat.m2505o(38559);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(38560);
        C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        setResult(-1);
        finish();
        AppMethodBeat.m2505o(38560);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(38561);
        super.onDestroy();
        C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
        AppMethodBeat.m2505o(38561);
    }

    public void onResume() {
        AppMethodBeat.m2504i(38562);
        super.onResume();
        if (this.ehK != null) {
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(38562);
    }

    /* renamed from: g */
    private void m81663g(int i, Intent intent) {
        AppMethodBeat.m2504i(38563);
        String str;
        switch (i) {
            case 2:
                C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
                this.filePath = C14987n.m23320h(getApplicationContext(), intent, C13373af.getAccSnsTmpPath());
                if (this.filePath == null) {
                    AppMethodBeat.m2505o(38563);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_ImgPath", this.filePath);
                str = "CropImage_OutputPath";
                intent2.putExtra(str, C13373af.getAccSnsTmpPath() + C1178g.m2591x((this.filePath + System.currentTimeMillis()).getBytes()));
                C24826a.gkE.mo38890a((Activity) this, intent2, 6);
                AppMethodBeat.m2505o(38563);
                return;
            case 5:
                C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                if (intent == null) {
                    AppMethodBeat.m2505o(38563);
                    return;
                }
                this.filePath = C14987n.m23320h(getApplicationContext(), intent, C13373af.getAccSnsTmpPath());
                if (this.filePath == null) {
                    AppMethodBeat.m2505o(38563);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_ImgPath", this.filePath);
                C24826a.gkE.mo38891a((Activity) this, intent, intent3, C13373af.getAccSnsTmpPath(), 6, new C397941());
                AppMethodBeat.m2505o(38563);
                return;
            case 6:
                C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                new C7306ak(Looper.getMainLooper()).post(new C447662());
                if (intent == null) {
                    AppMethodBeat.m2505o(38563);
                    return;
                }
                this.filePath = intent.getStringExtra("CropImage_OutputPath");
                if (this.filePath == null) {
                    AppMethodBeat.m2505o(38563);
                    return;
                }
                C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
                C29050aw cnB = C13373af.cnB();
                String str2 = this.filePath;
                new LinkedList().add(new C21881h(str2, 2));
                if (!(cnB.cnk() == null || cnB.cnk().equals(""))) {
                    str = C3892an.m6198fZ(C13373af.getAccSnsPath(), cnB.cnk());
                    C5730e.m8643tf(str);
                    C5730e.deleteFile(str + cnB.cnk() + "bg_");
                    C5730e.m8644y(str2, str + cnB.cnk() + "bg_");
                    C43573m cnJ = C13373af.cnJ();
                    C29097l YX = cnJ.mo69179YX(cnB.cnk());
                    YX.field_bgId = "";
                    cnJ.mo69182c(YX);
                }
                cnB.con();
                cnB.cnk();
                C29054ax c29054ax = new C29054ax(7);
                c29054ax.mo47166ge(str2, "");
                c29054ax.mo47139De(1);
                c29054ax.commit();
                setResult(-1);
                finish();
                AppMethodBeat.m2505o(38563);
                return;
            default:
                C4990ab.m7412e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
                AppMethodBeat.m2505o(38563);
                return;
        }
    }

    public void onActivityResult(final int i, final int i2, final Intent intent) {
        AppMethodBeat.m2504i(38564);
        C4990ab.m7416i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + i + " " + i2);
        if (i2 != -1) {
            if (i == 2 || i == 5 || i == 6) {
                new C7306ak(Looper.getMainLooper()).post(new C134953());
            }
            AppMethodBeat.m2505o(38564);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("result ok ");
        C1720g.m3537RQ();
        C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", stringBuilder.append(C1720g.m3534RN().mo5161QY()).toString());
        if (C13373af.cnn()) {
            new C7306ak(Looper.myLooper()).postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38556);
                    SettingSnsBackgroundUI.m81662a(SettingSnsBackgroundUI.this, i, intent);
                    AppMethodBeat.m2505o(38556);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(38564);
            return;
        }
        C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
        m81663g(i, intent);
        AppMethodBeat.m2505o(38564);
    }

    public final void initView() {
        AppMethodBeat.m2504i(38565);
        setMMTitle((int) C25738R.string.eat);
        SnsArtistPreference snsArtistPreference = (SnsArtistPreference) this.ehK.aqO("settings_sns_bg_select_bg");
        if (snsArtistPreference != null) {
            String string = this.ehZ.getString("artist_name", "");
            C4990ab.m7410d("MicroMsg.SettingSnsBackgroundUI", "artistName".concat(String.valueOf(string)));
            snsArtistPreference.mo47258ZE(string);
            this.ehK.notifyDataSetChanged();
        }
        setBackBtn(new C134965());
        AppMethodBeat.m2505o(38565);
    }

    private void bCz() {
        AppMethodBeat.m2504i(38567);
        if (!C14987n.m23311c(this, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2)) {
            Toast.makeText(this, getString(C25738R.string.e29), 1).show();
        }
        AppMethodBeat.m2505o(38567);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(38568);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(38568);
            return;
        }
        C4990ab.m7417i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C134976(), null);
                    break;
                }
                bCz();
                AppMethodBeat.m2505o(38568);
                return;
        }
        AppMethodBeat.m2505o(38568);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(38566);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingSnsBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_sns_bg_select_from_album")) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().isSDCardAvailable()) {
                C14987n.m23301a((Activity) this, 5, null);
                AppMethodBeat.m2505o(38566);
                return true;
            }
            C23639t.m36492hO(this);
            AppMethodBeat.m2505o(38566);
            return false;
        } else if (str.equals("settings_sns_bg_take_photo")) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().isSDCardAvailable()) {
                C4990ab.m7417i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")), C5046bo.dpG(), this.mController.ylL);
                if (C35805b.m58707a(this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                    bCz();
                    AppMethodBeat.m2505o(38566);
                    return true;
                }
                AppMethodBeat.m2505o(38566);
                return false;
            }
            C23639t.m36492hO(this);
            AppMethodBeat.m2505o(38566);
            return false;
        } else if (str.equals("settings_sns_bg_select_bg")) {
            startActivity(new Intent(this, ArtistUI.class));
            AppMethodBeat.m2505o(38566);
            return true;
        } else {
            AppMethodBeat.m2505o(38566);
            return false;
        }
    }
}
