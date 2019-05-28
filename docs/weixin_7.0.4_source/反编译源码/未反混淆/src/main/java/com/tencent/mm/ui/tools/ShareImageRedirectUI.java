package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.ArrayList;

@a(7)
public class ShareImageRedirectUI extends MMBaseActivity {
    private String imagePath;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34931);
        super.onCreate(bundle);
        ab.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(b.a(this, "android.permission.CAMERA", 16, "", "")), bo.dpG(), this);
        if (b.a(this, "android.permission.CAMERA", 16, "", "")) {
            bCz();
            AppMethodBeat.o(34931);
            return;
        }
        AppMethodBeat.o(34931);
    }

    private void bCz() {
        AppMethodBeat.i(34932);
        n.c(this, e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 0);
        getWindow().getDecorView().setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(34928);
                Toast.makeText(ShareImageRedirectUI.this, R.string.eh9, 1).show();
                ShareImageRedirectUI.this.finish();
                AppMethodBeat.o(34928);
                return false;
            }
        });
        AppMethodBeat.o(34932);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(34933);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(34933);
            return;
        }
        ab.i("MicroMsg.ShareImageRedirectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(34929);
                            ShareImageRedirectUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            ShareImageRedirectUI.this.finish();
                            AppMethodBeat.o(34929);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(34930);
                            ShareImageRedirectUI.this.finish();
                            AppMethodBeat.o(34930);
                        }
                    });
                    break;
                }
                bCz();
                AppMethodBeat.o(34933);
                return;
        }
        AppMethodBeat.o(34933);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        AppMethodBeat.i(34934);
        getWindow().getDecorView().setOnTouchListener(null);
        if (i2 != -1) {
            finish();
            AppMethodBeat.o(34934);
            return;
        }
        Intent intent2;
        switch (i) {
            case 0:
                Context applicationContext = getApplicationContext();
                aw.ZK();
                this.imagePath = n.h(applicationContext, intent, c.XW());
                if (this.imagePath == null) {
                    AppMethodBeat.o(34934);
                    return;
                }
                intent2 = new Intent(this, ShareImageSelectorUI.class);
                intent2.putExtra("intent_extra_image_path", this.imagePath);
                startActivityForResult(intent2, 2);
                AppMethodBeat.o(34934);
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
                    AppMethodBeat.o(34934);
                    return;
                } else if (arrayList == null || arrayList.size() <= 1) {
                    intent2 = new Intent();
                    intent2.putExtra("Ksnsupload_type", 0);
                    intent2.putExtra("sns_kemdia_path", this.imagePath);
                    d.b((Context) this, "sns", ".ui.SnsUploadUI", intent2);
                    finish();
                    AppMethodBeat.o(34934);
                    return;
                } else {
                    finish();
                    AppMethodBeat.o(34934);
                    return;
                }
            default:
                AppMethodBeat.o(34934);
                return;
        }
    }
}
