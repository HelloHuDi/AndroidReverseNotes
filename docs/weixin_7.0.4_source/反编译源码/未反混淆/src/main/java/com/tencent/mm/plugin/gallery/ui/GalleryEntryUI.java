package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(7)
public final class GalleryEntryUI extends AppCompatActivity {
    private boolean iIq = false;
    private boolean mInit = false;
    private int mPB;
    private int mQk;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(21452);
        ab.i("MicroMsg.GalleryEntryUI", "on create");
        super.onCreate(bundle);
        ab.i("MicroMsg.GalleryEntryUI", "checktask onCreate:%s#0x%x task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), bo.gU(this));
        e.initialize();
        this.mPB = getIntent().getIntExtra("query_source_type", 3);
        this.mQk = getIntent().getIntExtra("query_media_type", 1);
        ab.i("MicroMsg.GalleryEntryUI", "query souce: " + this.mPB + ", queryType: " + this.mQk);
        e.bBZ().wq(this.mQk);
        e.bBZ().hOZ = this.mPB;
        AppMethodBeat.o(21452);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(21453);
        ab.d("MicroMsg.GalleryEntryUI", "onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        this.mInit = true;
        AppMethodBeat.o(21453);
    }

    public final void onResume() {
        AppMethodBeat.i(21454);
        ab.i("MicroMsg.GalleryEntryUI", "on resume, init %B", Boolean.valueOf(this.mInit));
        super.onResume();
        if (!this.mInit) {
            ab.e("MicroMsg.GalleryEntryUI", "doRedirect %s", bo.dpG());
            Intent intent = getIntent();
            if (intent.getBooleanExtra("preview_image", false)) {
                ab.d("MicroMsg.GalleryEntryUI", "jump to preview ui directly");
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                Intent intent2 = new Intent(this, ImagePreviewUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("max_select_count", intent.getIntExtra("max_select_count", 9));
                intent2.putExtra("query_source_type", this.mPB);
                intent2.putExtra("isPreviewPhoto", intent.getBooleanExtra("isPreviewPhoto", false));
                intent2.putExtra("preview_image", intent.getBooleanExtra("preview_image", false));
                String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
                String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
                if (!bo.isNullOrNil(stringExtra)) {
                    intent2.putExtra("GalleryUI_FromUser", stringExtra);
                }
                if (!bo.isNullOrNil(stringExtra2)) {
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
        AppMethodBeat.o(21454);
    }

    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(21455);
        super.onNewIntent(intent);
        ab.d("MicroMsg.GalleryEntryUI", "on new intent, #0x%x", Integer.valueOf(hashCode()));
        AppMethodBeat.o(21455);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(21456);
        String str = "MicroMsg.GalleryEntryUI";
        String str2 = "on activity result, requestCode %d resultCode %d, data:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = intent == null ? "" : intent.toString();
        ab.i(str, str2, objArr);
        this.iIq = true;
        switch (i2) {
            case -1:
                if (intent != null) {
                    setResult(-1, intent);
                    break;
                } else {
                    AppMethodBeat.o(21456);
                    return;
                }
            case 0:
                ab.d("MicroMsg.GalleryEntryUI", "user choose canceld");
                setResult(0);
                break;
            case 1:
                setResult(1);
                break;
        }
        if (this.iIq) {
            finish();
        }
        AppMethodBeat.o(21456);
    }

    public final void onDestroy() {
        AppMethodBeat.i(21457);
        super.onDestroy();
        ab.i("MicroMsg.GalleryEntryUI", "onDestroy %B", Boolean.valueOf(this.iIq));
        e.release(this.iIq);
        ab.i("MicroMsg.GalleryEntryUI", "checktask onDestroy:%s#0x%x task:%s ", getClass().getSimpleName(), Integer.valueOf(hashCode()), bo.gU(this));
        AppMethodBeat.o(21457);
    }
}
