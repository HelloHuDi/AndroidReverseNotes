package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.transmit.ShareImageSelectorUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.ArrayList;

@C5271a(7)
/* renamed from: com.tencent.mm.ui.tools.ShareImageRedirectUI */
public class ShareImageRedirectUI extends MMBaseActivity {
    private String imagePath;

    /* renamed from: com.tencent.mm.ui.tools.ShareImageRedirectUI$1 */
    class C55771 implements OnTouchListener {
        C55771() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(34928);
            Toast.makeText(ShareImageRedirectUI.this, C25738R.string.eh9, 1).show();
            ShareImageRedirectUI.this.finish();
            AppMethodBeat.m2505o(34928);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImageRedirectUI$3 */
    class C170633 implements OnClickListener {
        C170633() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34930);
            ShareImageRedirectUI.this.finish();
            AppMethodBeat.m2505o(34930);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImageRedirectUI$2 */
    class C170642 implements OnClickListener {
        C170642() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34929);
            ShareImageRedirectUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            ShareImageRedirectUI.this.finish();
            AppMethodBeat.m2505o(34929);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34931);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 16, "", "")), C5046bo.dpG(), this);
        if (C35805b.m58707a(this, "android.permission.CAMERA", 16, "", "")) {
            bCz();
            AppMethodBeat.m2505o(34931);
            return;
        }
        AppMethodBeat.m2505o(34931);
    }

    private void bCz() {
        AppMethodBeat.m2504i(34932);
        C14987n.m23311c(this, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 0);
        getWindow().getDecorView().setOnTouchListener(new C55771());
        AppMethodBeat.m2505o(34932);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(34933);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(34933);
            return;
        }
        C4990ab.m7417i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C170642(), new C170633());
                    break;
                }
                bCz();
                AppMethodBeat.m2505o(34933);
                return;
        }
        AppMethodBeat.m2505o(34933);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        AppMethodBeat.m2504i(34934);
        getWindow().getDecorView().setOnTouchListener(null);
        if (i2 != -1) {
            finish();
            AppMethodBeat.m2505o(34934);
            return;
        }
        Intent intent2;
        switch (i) {
            case 0:
                Context applicationContext = getApplicationContext();
                C9638aw.m17190ZK();
                this.imagePath = C14987n.m23320h(applicationContext, intent, C18628c.m29088XW());
                if (this.imagePath == null) {
                    AppMethodBeat.m2505o(34934);
                    return;
                }
                intent2 = new Intent(this, ShareImageSelectorUI.class);
                intent2.putExtra("intent_extra_image_path", this.imagePath);
                startActivityForResult(intent2, 2);
                AppMethodBeat.m2505o(34934);
                return;
            case 2:
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("Select_Contact");
                }
                if (arrayList != null && arrayList.size() == 1) {
                    Intent intent3 = new Intent(this, ChattingUI.class);
                    intent3.putExtra("Chat_User", (String) arrayList.get(0));
                    startActivity(intent3);
                    finish();
                    AppMethodBeat.m2505o(34934);
                    return;
                } else if (arrayList == null || arrayList.size() <= 1) {
                    intent2 = new Intent();
                    intent2.putExtra("Ksnsupload_type", 0);
                    intent2.putExtra("sns_kemdia_path", this.imagePath);
                    C25985d.m41467b((Context) this, "sns", ".ui.SnsUploadUI", intent2);
                    finish();
                    AppMethodBeat.m2505o(34934);
                    return;
                } else {
                    finish();
                    AppMethodBeat.m2505o(34934);
                    return;
                }
            default:
                AppMethodBeat.m2505o(34934);
                return;
        }
    }
}
