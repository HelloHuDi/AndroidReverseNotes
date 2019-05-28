package com.tencent.p177mm.plugin.gallery.p427ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.gallery.ui.GalleryEntryUI */
public final class GalleryEntryUI extends AppCompatActivity {
    private boolean iIq = false;
    private boolean mInit = false;
    private int mPB;
    private int mQk;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21452);
        C4990ab.m7416i("MicroMsg.GalleryEntryUI", "on create");
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.GalleryEntryUI", "checktask onCreate:%s#0x%x task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), C5046bo.m7559gU(this));
        C34237e.initialize();
        this.mPB = getIntent().getIntExtra("query_source_type", 3);
        this.mQk = getIntent().getIntExtra("query_media_type", 1);
        C4990ab.m7416i("MicroMsg.GalleryEntryUI", "query souce: " + this.mPB + ", queryType: " + this.mQk);
        C34237e.bBZ().mo73865wq(this.mQk);
        C34237e.bBZ().hOZ = this.mPB;
        AppMethodBeat.m2505o(21452);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(21453);
        C4990ab.m7410d("MicroMsg.GalleryEntryUI", "onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        this.mInit = true;
        AppMethodBeat.m2505o(21453);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(21454);
        C4990ab.m7417i("MicroMsg.GalleryEntryUI", "on resume, init %B", Boolean.valueOf(this.mInit));
        super.onResume();
        if (!this.mInit) {
            C4990ab.m7413e("MicroMsg.GalleryEntryUI", "doRedirect %s", C5046bo.dpG());
            Intent intent = getIntent();
            if (intent.getBooleanExtra("preview_image", false)) {
                C4990ab.m7410d("MicroMsg.GalleryEntryUI", "jump to preview ui directly");
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                Intent intent2 = new Intent(this, ImagePreviewUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("max_select_count", intent.getIntExtra("max_select_count", 9));
                intent2.putExtra("query_source_type", this.mPB);
                intent2.putExtra("isPreviewPhoto", intent.getBooleanExtra("isPreviewPhoto", false));
                intent2.putExtra("preview_image", intent.getBooleanExtra("preview_image", false));
                String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
                String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    intent2.putExtra("GalleryUI_FromUser", stringExtra);
                }
                if (!C5046bo.isNullOrNil(stringExtra2)) {
                    intent2.putExtra("GalleryUI_ToUser", stringExtra2);
                }
                intent2.putStringArrayListExtra("preview_image_list", stringArrayListExtra);
                startActivityForResult(intent2, 1);
            } else {
                intent.setClass(this, AlbumPreviewUI.class);
                intent.addFlags(67108864);
                intent.putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
                intent.putExtra("send_btn_string", getIntent().getStringExtra("send_btn_string"));
                intent.putExtra("max_select_count", getIntent().getIntExtra("max_select_count", 9));
                intent.putExtra("GalleryUI_FromUser", getIntent().getStringExtra("GalleryUI_FromUser"));
                intent.putExtra("GalleryUI_ToUser", getIntent().getStringExtra("GalleryUI_ToUser"));
                intent.putExtra("key_send_raw_image", getIntent().getBooleanExtra("key_send_raw_image", false));
                intent.putExtra("GalleryUI_SkipVideoSizeLimit", getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false));
                startActivityForResult(intent, 0);
            }
            this.mInit = true;
        }
        AppMethodBeat.m2505o(21454);
    }

    public final void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(21455);
        super.onNewIntent(intent);
        C4990ab.m7411d("MicroMsg.GalleryEntryUI", "on new intent, #0x%x", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(21455);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(21456);
        String str = "MicroMsg.GalleryEntryUI";
        String str2 = "on activity result, requestCode %d resultCode %d, data:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = intent == null ? "" : intent.toString();
        C4990ab.m7417i(str, str2, objArr);
        this.iIq = true;
        switch (i2) {
            case -1:
                if (intent != null) {
                    setResult(-1, intent);
                    break;
                } else {
                    AppMethodBeat.m2505o(21456);
                    return;
                }
            case 0:
                C4990ab.m7410d("MicroMsg.GalleryEntryUI", "user choose canceld");
                setResult(0);
                break;
            case 1:
                setResult(1);
                break;
        }
        if (this.iIq) {
            finish();
        }
        AppMethodBeat.m2505o(21456);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(21457);
        super.onDestroy();
        C4990ab.m7417i("MicroMsg.GalleryEntryUI", "onDestroy %B", Boolean.valueOf(this.iIq));
        C34237e.release(this.iIq);
        C4990ab.m7417i("MicroMsg.GalleryEntryUI", "checktask onDestroy:%s#0x%x task:%s ", getClass().getSimpleName(), Integer.valueOf(hashCode()), C5046bo.m7559gU(this));
        AppMethodBeat.m2505o(21457);
    }
}
