package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1380j.C45291a;
import com.tencent.p177mm.compatible.p1380j.C45291a.C41941a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.webview.model.C43914ap;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI */
public class OpenFileChooserUI extends MMActivity {
    private int count;
    private ProgressDialog ehJ = null;
    private String hGF;
    private String hGG;
    private int mPB;
    private int mQk;
    private int rDQ;
    private boolean usa;
    private int usb;
    private int usc;
    private boolean usd = false;
    private OnCancelListener use = null;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$2 */
    class C298582 implements OnCancelListener {
        C298582() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7443);
            OpenFileChooserUI.this.setResult(0);
            OpenFileChooserUI.this.finish();
            AppMethodBeat.m2505o(7443);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$3 */
    class C298593 implements OnClickListener {
        C298593() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(7444);
            OpenFileChooserUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(7444);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$5 */
    class C298605 implements OnCancelListener {
        C298605() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(7446);
            OpenFileChooserUI.this.setResult(0);
            OpenFileChooserUI.this.finish();
            AppMethodBeat.m2505o(7446);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$1 */
    class C356301 implements C30391c {
        C356301() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(7442);
            C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(OpenFileChooserUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), C5046bo.dpG(), OpenFileChooserUI.this.mController.ylL);
            if (C35805b.m58707a(OpenFileChooserUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                C14987n.m23311c(OpenFileChooserUI.this.mController.ylL, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2);
                AppMethodBeat.m2505o(7442);
                return;
            }
            AppMethodBeat.m2505o(7442);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ int m58477a(OpenFileChooserUI openFileChooserUI, String str) {
        AppMethodBeat.m2504i(7465);
        int afw = openFileChooserUI.afw(str);
        AppMethodBeat.m2505o(7465);
        return afw;
    }

    /* renamed from: c */
    static /* synthetic */ String m58482c(OpenFileChooserUI openFileChooserUI, String str) {
        AppMethodBeat.m2504i(7469);
        String afv = openFileChooserUI.afv(str);
        AppMethodBeat.m2505o(7469);
        return afv;
    }

    public final int getLayoutId() {
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:98:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        int intExtra;
        int i = 3;
        AppMethodBeat.m2504i(7455);
        super.onCreate(bundle);
        this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
        if (this.count <= 0 || this.count > 9) {
            this.count = 9;
        }
        this.rDQ = this.count;
        this.mPB = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
        this.mQk = getIntent().getIntExtra("query_media_type", 1);
        this.usa = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
        this.usb = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
        this.usc = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
        if ((this.mPB == 7 && this.mQk == 2) || this.mQk == 3) {
            if (!cZC()) {
                C23639t.makeText(this, getString(C25738R.string.fz1), 1).show();
                this.usd = true;
            }
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", this.usa);
            intent.putExtra("query_media_type", this.mQk);
            int intExtra2;
            if (this.usc == 1) {
                if (this.usb != 4096 && (this.usb & 4096) > 0) {
                    intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                    intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                    intent.putExtra("KEY_SIGHT_PARAMS", m58484os(1));
                    intent.putExtra("record_video_force_sys_camera", false);
                    intent.putExtra("show_header_view", true);
                    intent.putExtra("record_video_is_sight_capture", true);
                    intent.putExtra("record_video_quality", intExtra);
                    intent.putExtra("record_video_time_limit", intExtra2);
                    intent.putExtra("video_full_path", this.hGF);
                    C14987n.m23315e(this, this.rDQ, this.mPB, intent);
                } else if (this.usb == 16 || this.usb == 256) {
                    intent.putExtra("KEY_SIGHT_PARAMS", m58484os(1));
                    C14987n.m23302a((Context) this, 6, intent, 3, 1);
                } else if (this.usb == 4096) {
                    intent.putExtra("show_header_view", false);
                    C14987n.m23315e(this, this.rDQ, this.mPB, intent);
                }
            } else if (this.usc == 2) {
                String nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("key_pick_local_media_sight_type"));
                if (this.usb != 4096 && (this.usb & 4096) > 0) {
                    C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                    setResult(1);
                    finish();
                } else if (this.usb == 16 || this.usb == 256) {
                    if (nullAsNil.contains("video") && nullAsNil.contains("image")) {
                        intExtra = 0;
                    } else if (nullAsNil.contains("video")) {
                        intExtra = 1;
                    } else if (nullAsNil.contains("image")) {
                        intExtra = 2;
                    } else {
                        intExtra = 0;
                    }
                    intent.putExtra("KEY_SIGHT_PARAMS", m58484os(intExtra));
                    C14987n.m23302a((Context) this, 7, intent, 3, intExtra);
                } else if (this.usb == 4096) {
                    if (!(nullAsNil.contains("image") && nullAsNil.contains("video"))) {
                        if (nullAsNil.contains("image")) {
                            i = 1;
                        } else if (nullAsNil.contains("video")) {
                            i = 2;
                        }
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_can_select_video_and_pic", true);
                    intent2.putExtra("key_send_raw_image", this.usa);
                    C14987n.m23295a((Activity) this, 8, this.rDQ, this.mPB, i, intent2);
                }
            } else if (this.usb != 4096 && (this.usb & 4096) > 0) {
                this.hGF = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", intExtra);
                intent.putExtra("record_video_time_limit", intExtra2);
                intent.putExtra("video_full_path", this.hGF);
                C14987n.m23315e(this, this.rDQ, this.mPB, intent);
            } else if (this.usb == 16 || this.usb == 256) {
                this.hGF = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                C14987n.m23297a((Activity) this, this.hGF, 5, getIntent().getIntExtra("key_pick_local_media_duration", 60), i, this.usb == 16);
            } else if (this.usb == 4096) {
                intent.putExtra("show_header_view", false);
                C14987n.m23315e(this, this.rDQ, this.mPB, intent);
            }
            if (this.usb != 4096 && (this.usb & 4096) > 0) {
                intExtra = 1;
                if (intExtra == 0) {
                }
            } else if (this.usb == 16 || this.usb == 256) {
                intExtra = 1;
                if (intExtra == 0) {
                    AppMethodBeat.m2505o(7455);
                    return;
                }
                if (!cZC()) {
                    C23639t.makeText(this, getString(C25738R.string.fz1), 1).show();
                    this.usd = true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.usa);
                intent3.putExtra("query_media_type", this.mQk);
                switch (this.usb) {
                    case 1:
                        intent3.putExtra("show_header_view", false);
                        C14987n.m23296a((Activity) this, 1, this.rDQ, this.mPB, intent3);
                        AppMethodBeat.m2505o(7455);
                        return;
                    case 2:
                        C30379h.m48425a((Context) this, "", new String[]{getString(C25738R.string.fyr)}, "", true, new C356301(), new C298582());
                        AppMethodBeat.m2505o(7455);
                        return;
                    case 3:
                        C14987n.m23296a((Activity) this, 1, this.count, this.mPB, intent3);
                        AppMethodBeat.m2505o(7455);
                        return;
                    default:
                        C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                        setResult(0);
                        finish();
                        AppMethodBeat.m2505o(7455);
                        return;
                }
            } else if (this.usb == 4096) {
                intExtra = 1;
                if (intExtra == 0) {
                }
            }
        }
        intExtra = 0;
        if (intExtra == 0) {
        }
    }

    private boolean cZC() {
        AppMethodBeat.m2504i(7456);
        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", Long.valueOf(C5046bo.m7553gO(this)));
        if (C5046bo.m7553gO(this) <= 200) {
            AppMethodBeat.m2505o(7456);
            return false;
        }
        AppMethodBeat.m2505o(7456);
        return true;
    }

    /* renamed from: os */
    private SightParams m58484os(int i) {
        AppMethodBeat.m2504i(7457);
        String str = "microMsg_" + System.currentTimeMillis();
        this.hGF = C6457e.euR + str + VideoMaterialUtil.MP4_SUFFIX;
        this.hGG = C6457e.euR + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.osJ = this.usb == 16 ? 1 : 2;
        sightParams.mode = i;
        if (sightParams.fcY == null) {
            sightParams.fcY = new VideoTransPara();
        }
        sightParams.fcY.duration = intExtra;
        sightParams.mo36644q(str, this.hGF, this.hGG, C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        AppMethodBeat.m2505o(7457);
        return sightParams;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(7458);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(7458);
            return;
        }
        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C298593(), null);
                    break;
                }
                C14987n.m23311c(this.mController.ylL, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2);
                AppMethodBeat.m2505o(7458);
                return;
        }
        AppMethodBeat.m2505o(7458);
    }

    public void onActivityResult(int i, final int i2, final Intent intent) {
        File file = null;
        AppMethodBeat.m2504i(7459);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.usd);
            setResult(i2, intent2);
            finish();
            AppMethodBeat.m2505o(7459);
            return;
        }
        String h;
        Intent intent3;
        ArrayList arrayList;
        ArrayList stringArrayListExtra;
        SightCaptureResult sightCaptureResult;
        switch (i) {
            case 1:
            case 3:
                C40211a.m68966R(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7445);
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                        ArrayList arrayList = new ArrayList();
                        for (String aeu : stringArrayListExtra) {
                            WebViewJSSDKFileItem aeu2 = WebViewJSSDKFileItem.aeu(aeu);
                            String str = aeu2.czD;
                            aeu2.hes = booleanExtra2;
                            C29833g.cYF().mo48046b(aeu2);
                            C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", aeu, str);
                            arrayList.add(str);
                        }
                        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", C43914ap.m78767ab(arrayList));
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_pic_callback_local_ids", aeu);
                        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                        intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.this.usd);
                        OpenFileChooserUI.this.setResult(i2, intent);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.m2505o(7445);
                    }
                });
                AppMethodBeat.m2505o(7459);
                return;
            case 2:
                h = C14987n.m23320h(this.mController.ylL.getApplicationContext(), intent, C6457e.euR);
                if (C5046bo.isNullOrNil(h)) {
                    C4990ab.m7420w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    finish();
                    AppMethodBeat.m2505o(7459);
                    return;
                }
                C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", h);
                intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.usa);
                intent3.putExtra("max_select_count", this.rDQ);
                intent3.putExtra("query_source_type", this.mPB);
                arrayList = new ArrayList(1);
                arrayList.add(h);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                C25985d.m41468b((Context) this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                AppMethodBeat.m2505o(7459);
                return;
            case 4:
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    finish();
                    AppMethodBeat.m2505o(7459);
                    return;
                }
                C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", stringArrayListExtra.get(0));
                if (this.usc == 1 && !OpenFileChooserUI.m58476Bs(this.hGG)) {
                    C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                afu((String) stringArrayListExtra.get(0));
                AppMethodBeat.m2505o(7459);
                return;
            case 5:
                if (new File(this.hGF).exists()) {
                    afu(this.hGF);
                    AppMethodBeat.m2505o(7459);
                    return;
                }
                C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", this.hGF);
                setResult(1);
                finish();
                AppMethodBeat.m2505o(7459);
                return;
            case 6:
                C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        AppMethodBeat.m2505o(7459);
                        return;
                    }
                    this.hGF = sightCaptureResult.osC;
                    C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.hGF);
                    if (!OpenFileChooserUI.m58476Bs(this.hGG) && OpenFileChooserUI.m58476Bs(sightCaptureResult.osD)) {
                        this.hGG = sightCaptureResult.osD;
                    }
                    if (!TextUtils.isEmpty(this.hGF)) {
                        file = new File(this.hGF);
                    }
                    if (file == null || !file.exists()) {
                        C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.hGF);
                    } else {
                        C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.hGF);
                        afu(this.hGF);
                        AppMethodBeat.m2505o(7459);
                        return;
                    }
                }
                C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                AppMethodBeat.m2505o(7459);
                return;
            case 7:
                C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                if (intent != null) {
                    C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        AppMethodBeat.m2505o(7459);
                        return;
                    } else if (sightCaptureResult.osA) {
                        h = sightCaptureResult.osI;
                        if (C5046bo.isNullOrNil(h)) {
                            C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", h);
                            setResult(1);
                            finish();
                            AppMethodBeat.m2505o(7459);
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        WebViewJSSDKFileItem aeu = WebViewJSSDKFileItem.aeu(h);
                        aeu.hes = true;
                        aeu.cyQ = 1;
                        C29833g.cYF().mo48046b(aeu);
                        arrayList2.add(aeu.czD);
                        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", h, aeu.czD);
                        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", C43914ap.m78768ac(arrayList2));
                        intent3 = new Intent();
                        intent3.putExtra("key_pick_local_media_local_ids", h);
                        intent3.putExtra("key_pick_local_media_callback_type", 2);
                        setResult(i2, intent3);
                        finish();
                        AppMethodBeat.m2505o(7459);
                        return;
                    } else {
                        File file2;
                        this.hGF = sightCaptureResult.osC;
                        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.hGF);
                        if (!OpenFileChooserUI.m58476Bs(this.hGG) && OpenFileChooserUI.m58476Bs(sightCaptureResult.osD)) {
                            this.hGG = sightCaptureResult.osD;
                        }
                        if (TextUtils.isEmpty(this.hGF)) {
                            file2 = null;
                        } else {
                            file2 = new File(this.hGF);
                        }
                        if (file2 == null || !file2.exists()) {
                            C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.hGF);
                        } else {
                            C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.hGF);
                            afu(this.hGF);
                            AppMethodBeat.m2505o(7459);
                            return;
                        }
                    }
                }
                C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                AppMethodBeat.m2505o(7459);
                return;
            case 8:
                C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (stringArrayListExtra2 == null) {
                        C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "chosen is null");
                        setResult(1);
                        finish();
                        AppMethodBeat.m2505o(7459);
                        return;
                    }
                    arrayList = new ArrayList();
                    for (String h2 : stringArrayListExtra2) {
                        WebViewJSSDKFileItem aeu2 = WebViewJSSDKFileItem.aeu(h2);
                        String str = aeu2.czD;
                        aeu2.hes = booleanExtra;
                        C29833g.cYF().mo48046b(aeu2);
                        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", h2, str);
                        arrayList.add(str);
                    }
                    C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", C43914ap.m78768ac(arrayList));
                    intent3 = new Intent();
                    intent3.putExtra("key_pick_local_media_local_ids", h2);
                    intent3.putExtra("key_pick_local_media_show_memory_warning", this.usd);
                    intent3.putExtra("key_pick_local_media_callback_type", 2);
                    setResult(i2, intent3);
                    finish();
                    AppMethodBeat.m2505o(7459);
                    return;
                }
                afu((String) stringArrayListExtra.get(0));
                AppMethodBeat.m2505o(7459);
                return;
            default:
                C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", Integer.valueOf(i));
                setResult(1);
                finish();
                AppMethodBeat.m2505o(7459);
                return;
        }
    }

    private void afu(final String str) {
        AppMethodBeat.m2504i(7460);
        this.use = new C298605();
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.fyk), true, this.use);
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$6$1 */
            class C45731 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$6$1$1 */
                class C45741 implements OnClickListener {
                    C45741() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7447);
                        OpenFileChooserUI.this.setResult(1);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.m2505o(7447);
                    }
                }

                C45731() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(7448);
                    if (OpenFileChooserUI.this.mPB == 7 && OpenFileChooserUI.this.mQk == 2) {
                        C30379h.m48447a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(C25738R.string.fyl), OpenFileChooserUI.this.getString(C25738R.string.f9238tz), OpenFileChooserUI.this.getString(C25738R.string.f9151r4), false, new C45741());
                        AppMethodBeat.m2505o(7448);
                        return;
                    }
                    Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(C25738R.string.f16), 0).show();
                    OpenFileChooserUI.this.setResult(1);
                    OpenFileChooserUI.this.finish();
                    AppMethodBeat.m2505o(7448);
                }
            }

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$6$2 */
            class C45752 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$6$2$1 */
                class C45761 implements OnClickListener {
                    C45761() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(7449);
                        OpenFileChooserUI.this.setResult(1);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.m2505o(7449);
                    }
                }

                C45752() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(7450);
                    C30379h.m48447a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(C25738R.string.fym), OpenFileChooserUI.this.getString(C25738R.string.f9238tz), OpenFileChooserUI.this.getString(C25738R.string.f9151r4), false, new C45761());
                    AppMethodBeat.m2505o(7450);
                }
            }

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$6$3 */
            class C145563 implements Runnable {
                C145563() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(7451);
                    OpenFileChooserUI.this.setResult(1);
                    OpenFileChooserUI.this.finish();
                    AppMethodBeat.m2505o(7451);
                }
            }

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI$6$5 */
            class C145575 implements Runnable {
                C145575() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(7453);
                    OpenFileChooserUI.this.setResult(1);
                    OpenFileChooserUI.this.finish();
                    AppMethodBeat.m2505o(7453);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(7454);
                ArrayList arrayList = new ArrayList();
                int a = OpenFileChooserUI.m58477a(OpenFileChooserUI.this, str);
                if (a == -50002) {
                    C5004al.m7441d(new C45731());
                    AppMethodBeat.m2505o(7454);
                    return;
                }
                String s;
                String d;
                if (a == -50006) {
                    s = OpenFileChooserUI.m58485s(str, arrayList);
                    OpenFileChooserUI.m58480b(OpenFileChooserUI.this, str);
                    d = OpenFileChooserUI.m58483d(OpenFileChooserUI.this);
                } else if (a == 1) {
                    s = OpenFileChooserUI.m58482c(OpenFileChooserUI.this, str);
                    OpenFileChooserUI.m58480b(OpenFileChooserUI.this, str);
                    d = OpenFileChooserUI.m58483d(OpenFileChooserUI.this);
                    if (C5046bo.isNullOrNil(s) && OpenFileChooserUI.this.mPB == 7 && OpenFileChooserUI.this.mQk == 2) {
                        C5004al.m7441d(new C45752());
                        AppMethodBeat.m2505o(7454);
                        return;
                    }
                } else {
                    C5004al.m7441d(new C145563());
                    AppMethodBeat.m2505o(7454);
                    return;
                }
                if (C5046bo.isNullOrNil(s)) {
                    C5004al.m7441d(new C145575());
                    AppMethodBeat.m2505o(7454);
                    return;
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(7452);
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_media_callback_type", 1);
                        intent.putExtra("key_pick_local_media_local_id", s);
                        intent.putExtra("key_pick_local_media_thumb_local_id", d);
                        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", d);
                        OpenFileChooserUI.this.setResult(-1, intent);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.m2505o(7452);
                    }
                });
                AppMethodBeat.m2505o(7454);
            }
        });
        AppMethodBeat.m2505o(7460);
    }

    private String afv(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        AppMethodBeat.m2504i(7461);
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e);
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            AppMethodBeat.m2505o(7461);
            return null;
        }
        int i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        int i3 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        mediaMetadataRetriever.release();
        WebViewJSSDKVideoItem aew = WebViewJSSDKFileItem.aew(str);
        aew.duration = (i3 + 500) / 1000;
        aew.width = i;
        aew.height = i2;
        aew.size = C1173e.m2560cs(str);
        if (this.usc == 1) {
            aew.hGG = this.hGG;
        }
        C29833g.cYF().mo48046b(aew);
        String str2 = aew.czD;
        AppMethodBeat.m2505o(7461);
        return str2;
    }

    private int afw(String str) {
        C41941a j;
        AppMethodBeat.m2504i(7462);
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://".concat(String.valueOf(str))));
        C41941a c41941a = null;
        C5023at.is2G(this);
        try {
            j = C45291a.m83515j(this, intent);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.OpenFileChooserUI", e, "", new Object[0]);
            j = c41941a;
        }
        if (j == null) {
            C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            AppMethodBeat.m2505o(7462);
            return -50005;
        }
        int i;
        String str2 = j.filename;
        boolean vC = C42258c.m74643vC(str2);
        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", Boolean.valueOf(vC));
        int i2 = -10000;
        if (vC) {
            i2 = SightVideoJNI.shouldRemuxing(str2, 660, 500, 26214400, 300000.0d, 1000000);
            C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", Integer.valueOf(i2));
        }
        if (i2 == -1 || !vC) {
            C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", Integer.valueOf(C1173e.m2560cs(str2)));
            if (C1173e.m2560cs(str2) > 26214400) {
                i2 = -1;
            } else {
                i2 = 1;
            }
        }
        switch (i2) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                AppMethodBeat.m2505o(7462);
                return -50002;
            case 0:
                i = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i = 0;
                i2 = 1;
                break;
            default:
                C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "unknown check type");
                AppMethodBeat.m2505o(7462);
                return -50001;
        }
        if (i != 0) {
            i2 = -50006;
        }
        i = j.duration / 1000;
        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", str2, Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.m2505o(7462);
        return i2;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7463);
        super.onDestroy();
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(7463);
    }

    /* renamed from: Bs */
    private static boolean m58476Bs(String str) {
        AppMethodBeat.m2504i(7464);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
            AppMethodBeat.m2505o(7464);
            return false;
        }
        File file = new File(str);
        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", str);
        if (file.exists()) {
            C4990ab.m7416i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
            AppMethodBeat.m2505o(7464);
            return true;
        }
        C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
        AppMethodBeat.m2505o(7464);
        return false;
    }

    /* renamed from: s */
    static /* synthetic */ String m58485s(String str, List list) {
        AppMethodBeat.m2504i(7466);
        int[] iArr = new int[2];
        C30076j.m47631c(str, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        C21846d.m33389a(str, pInt, pInt2, pInt3, pInt4, new PInt());
        String str2 = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(SightVideoJNI.remuxing(str, str2, i, i2, C29014b.qwZ, C29014b.qwY, 8, 2, 25.0f, (float) pInt4.value, null, 0, false)), Integer.valueOf(i), Integer.valueOf(i2));
        WebViewJSSDKVideoItem aew = WebViewJSSDKFileItem.aew(str2);
        aew.width = i;
        aew.height = i2;
        aew.duration = r2;
        aew.size = C1173e.m2560cs(str2);
        list.add(aew.czD);
        C29833g.cYF().mo48046b(aew);
        String str3 = aew.czD;
        AppMethodBeat.m2505o(7466);
        return str3;
    }

    /* renamed from: b */
    static /* synthetic */ void m58480b(OpenFileChooserUI openFileChooserUI, String str) {
        CharSequence charSequence = null;
        AppMethodBeat.m2504i(7467);
        if (openFileChooserUI.usc == 0) {
            C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            AppMethodBeat.m2505o(7467);
            return;
        }
        File file;
        if (TextUtils.isEmpty(openFileChooserUI.hGG)) {
            C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            file = null;
        } else {
            file = new File(openFileChooserUI.hGG);
        }
        if (file == null || !file.exists()) {
            C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", openFileChooserUI.hGG);
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                charSequence = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(charSequence)) {
                openFileChooserUI.hGG = C6457e.euR + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (C6457e.euR == null || !C6457e.euR.endsWith("/")) {
                openFileChooserUI.hGG = C6457e.euR + "/" + charSequence + ".jpeg";
            } else {
                openFileChooserUI.hGG = C6457e.euR + charSequence + ".jpeg";
            }
            if (new File(openFileChooserUI.hGG).exists()) {
                C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", openFileChooserUI.hGG);
                AppMethodBeat.m2505o(7467);
                return;
            }
            C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", openFileChooserUI.hGG);
            C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", openFileChooserUI.hGG);
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                C4990ab.m7413e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", openFileChooserUI.hGG);
                AppMethodBeat.m2505o(7467);
                return;
            }
            try {
                C5056d.m7625a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, openFileChooserUI.hGG, true);
                AppMethodBeat.m2505o(7467);
                return;
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e.getMessage());
                AppMethodBeat.m2505o(7467);
                return;
            }
        }
        C4990ab.m7417i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", openFileChooserUI.hGG);
        AppMethodBeat.m2505o(7467);
    }

    /* renamed from: d */
    static /* synthetic */ String m58483d(OpenFileChooserUI openFileChooserUI) {
        AppMethodBeat.m2504i(7468);
        String str;
        if (TextUtils.isEmpty(openFileChooserUI.hGG)) {
            str = "";
            AppMethodBeat.m2505o(7468);
            return str;
        }
        WebViewJSSDKFileItem aeu = WebViewJSSDKFileItem.aeu(openFileChooserUI.hGG);
        aeu.hGG = openFileChooserUI.hGG;
        aeu.hes = true;
        aeu.cyQ = 1;
        C29833g.cYF().mo48046b(aeu);
        str = aeu.czD;
        AppMethodBeat.m2505o(7468);
        return str;
    }
}
