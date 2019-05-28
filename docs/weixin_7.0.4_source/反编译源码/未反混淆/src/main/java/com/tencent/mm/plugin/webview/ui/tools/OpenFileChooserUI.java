package com.tencent.mm.plugin.webview.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@a(3)
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ int a(OpenFileChooserUI openFileChooserUI, String str) {
        AppMethodBeat.i(7465);
        int afw = openFileChooserUI.afw(str);
        AppMethodBeat.o(7465);
        return afw;
    }

    static /* synthetic */ String c(OpenFileChooserUI openFileChooserUI, String str) {
        AppMethodBeat.i(7469);
        String afv = openFileChooserUI.afv(str);
        AppMethodBeat.o(7469);
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
        AppMethodBeat.i(7455);
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
                t.makeText(this, getString(R.string.fz1), 1).show();
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
                    intent.putExtra("KEY_SIGHT_PARAMS", os(1));
                    intent.putExtra("record_video_force_sys_camera", false);
                    intent.putExtra("show_header_view", true);
                    intent.putExtra("record_video_is_sight_capture", true);
                    intent.putExtra("record_video_quality", intExtra);
                    intent.putExtra("record_video_time_limit", intExtra2);
                    intent.putExtra("video_full_path", this.hGF);
                    n.e(this, this.rDQ, this.mPB, intent);
                } else if (this.usb == 16 || this.usb == 256) {
                    intent.putExtra("KEY_SIGHT_PARAMS", os(1));
                    n.a((Context) this, 6, intent, 3, 1);
                } else if (this.usb == 4096) {
                    intent.putExtra("show_header_view", false);
                    n.e(this, this.rDQ, this.mPB, intent);
                }
            } else if (this.usc == 2) {
                String nullAsNil = bo.nullAsNil(getIntent().getStringExtra("key_pick_local_media_sight_type"));
                if (this.usb != 4096 && (this.usb & 4096) > 0) {
                    ab.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
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
                    intent.putExtra("KEY_SIGHT_PARAMS", os(intExtra));
                    n.a((Context) this, 7, intent, 3, intExtra);
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
                    n.a((Activity) this, 8, this.rDQ, this.mPB, i, intent2);
                }
            } else if (this.usb != 4096 && (this.usb & 4096) > 0) {
                this.hGF = e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", intExtra);
                intent.putExtra("record_video_time_limit", intExtra2);
                intent.putExtra("video_full_path", this.hGF);
                n.e(this, this.rDQ, this.mPB, intent);
            } else if (this.usb == 16 || this.usb == 256) {
                this.hGF = e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                n.a((Activity) this, this.hGF, 5, getIntent().getIntExtra("key_pick_local_media_duration", 60), i, this.usb == 16);
            } else if (this.usb == 4096) {
                intent.putExtra("show_header_view", false);
                n.e(this, this.rDQ, this.mPB, intent);
            }
            if (this.usb != 4096 && (this.usb & 4096) > 0) {
                intExtra = 1;
                if (intExtra == 0) {
                }
            } else if (this.usb == 16 || this.usb == 256) {
                intExtra = 1;
                if (intExtra == 0) {
                    AppMethodBeat.o(7455);
                    return;
                }
                if (!cZC()) {
                    t.makeText(this, getString(R.string.fz1), 1).show();
                    this.usd = true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.usa);
                intent3.putExtra("query_media_type", this.mQk);
                switch (this.usb) {
                    case 1:
                        intent3.putExtra("show_header_view", false);
                        n.a((Activity) this, 1, this.rDQ, this.mPB, intent3);
                        AppMethodBeat.o(7455);
                        return;
                    case 2:
                        h.a((Context) this, "", new String[]{getString(R.string.fyr)}, "", true, new c() {
                            public final void iE(int i) {
                                AppMethodBeat.i(7442);
                                ab.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(b.a(OpenFileChooserUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), bo.dpG(), OpenFileChooserUI.this.mController.ylL);
                                if (b.a(OpenFileChooserUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                                    n.c(OpenFileChooserUI.this.mController.ylL, e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2);
                                    AppMethodBeat.o(7442);
                                    return;
                                }
                                AppMethodBeat.o(7442);
                            }
                        }, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(7443);
                                OpenFileChooserUI.this.setResult(0);
                                OpenFileChooserUI.this.finish();
                                AppMethodBeat.o(7443);
                            }
                        });
                        AppMethodBeat.o(7455);
                        return;
                    case 3:
                        n.a((Activity) this, 1, this.count, this.mPB, intent3);
                        AppMethodBeat.o(7455);
                        return;
                    default:
                        ab.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                        setResult(0);
                        finish();
                        AppMethodBeat.o(7455);
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
        AppMethodBeat.i(7456);
        ab.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", Long.valueOf(bo.gO(this)));
        if (bo.gO(this) <= 200) {
            AppMethodBeat.o(7456);
            return false;
        }
        AppMethodBeat.o(7456);
        return true;
    }

    private SightParams os(int i) {
        AppMethodBeat.i(7457);
        String str = "microMsg_" + System.currentTimeMillis();
        this.hGF = e.euR + str + VideoMaterialUtil.MP4_SUFFIX;
        this.hGG = e.euR + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.osJ = this.usb == 16 ? 1 : 2;
        sightParams.mode = i;
        if (sightParams.fcY == null) {
            sightParams.fcY = new VideoTransPara();
        }
        sightParams.fcY.duration = intExtra;
        sightParams.q(str, this.hGF, this.hGG, e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        AppMethodBeat.o(7457);
        return sightParams;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(7458);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(7458);
            return;
        }
        ab.i("MicroMsg.OpenFileChooserUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(7444);
                            OpenFileChooserUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(7444);
                        }
                    }, null);
                    break;
                }
                n.c(this.mController.ylL, e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2);
                AppMethodBeat.o(7458);
                return;
        }
        AppMethodBeat.o(7458);
    }

    public void onActivityResult(int i, final int i2, final Intent intent) {
        File file = null;
        AppMethodBeat.i(7459);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.usd);
            setResult(i2, intent2);
            finish();
            AppMethodBeat.o(7459);
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
                com.tencent.mm.plugin.webview.a.a.R(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7445);
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                        ArrayList arrayList = new ArrayList();
                        for (String aeu : stringArrayListExtra) {
                            WebViewJSSDKFileItem aeu2 = WebViewJSSDKFileItem.aeu(aeu);
                            String str = aeu2.czD;
                            aeu2.hes = booleanExtra2;
                            g.cYF().b(aeu2);
                            ab.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", aeu, str);
                            arrayList.add(str);
                        }
                        ab.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ap.ab(arrayList));
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_pic_callback_local_ids", aeu);
                        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                        intent.putExtra("key_pick_local_media_show_memory_warning", OpenFileChooserUI.this.usd);
                        OpenFileChooserUI.this.setResult(i2, intent);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.o(7445);
                    }
                });
                AppMethodBeat.o(7459);
                return;
            case 2:
                h = n.h(this.mController.ylL.getApplicationContext(), intent, e.euR);
                if (bo.isNullOrNil(h)) {
                    ab.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    finish();
                    AppMethodBeat.o(7459);
                    return;
                }
                ab.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", h);
                intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.usa);
                intent3.putExtra("max_select_count", this.rDQ);
                intent3.putExtra("query_source_type", this.mPB);
                arrayList = new ArrayList(1);
                arrayList.add(h);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                d.b((Context) this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                AppMethodBeat.o(7459);
                return;
            case 4:
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    ab.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    finish();
                    AppMethodBeat.o(7459);
                    return;
                }
                ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                ab.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", stringArrayListExtra.get(0));
                if (this.usc == 1 && !Bs(this.hGG)) {
                    ab.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                afu((String) stringArrayListExtra.get(0));
                AppMethodBeat.o(7459);
                return;
            case 5:
                if (new File(this.hGF).exists()) {
                    afu(this.hGF);
                    AppMethodBeat.o(7459);
                    return;
                }
                ab.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", this.hGF);
                setResult(1);
                finish();
                AppMethodBeat.o(7459);
                return;
            case 6:
                ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    ab.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        ab.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        AppMethodBeat.o(7459);
                        return;
                    }
                    this.hGF = sightCaptureResult.osC;
                    ab.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.hGF);
                    if (!Bs(this.hGG) && Bs(sightCaptureResult.osD)) {
                        this.hGG = sightCaptureResult.osD;
                    }
                    if (!TextUtils.isEmpty(this.hGF)) {
                        file = new File(this.hGF);
                    }
                    if (file == null || !file.exists()) {
                        ab.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.hGF);
                    } else {
                        ab.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.hGF);
                        afu(this.hGF);
                        AppMethodBeat.o(7459);
                        return;
                    }
                }
                ab.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                AppMethodBeat.o(7459);
                return;
            case 7:
                ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                if (intent != null) {
                    ab.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        ab.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        AppMethodBeat.o(7459);
                        return;
                    } else if (sightCaptureResult.osA) {
                        h = sightCaptureResult.osI;
                        if (bo.isNullOrNil(h)) {
                            ab.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", h);
                            setResult(1);
                            finish();
                            AppMethodBeat.o(7459);
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        WebViewJSSDKFileItem aeu = WebViewJSSDKFileItem.aeu(h);
                        aeu.hes = true;
                        aeu.cyQ = 1;
                        g.cYF().b(aeu);
                        arrayList2.add(aeu.czD);
                        ab.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", h, aeu.czD);
                        ab.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ap.ac(arrayList2));
                        intent3 = new Intent();
                        intent3.putExtra("key_pick_local_media_local_ids", h);
                        intent3.putExtra("key_pick_local_media_callback_type", 2);
                        setResult(i2, intent3);
                        finish();
                        AppMethodBeat.o(7459);
                        return;
                    } else {
                        File file2;
                        this.hGF = sightCaptureResult.osC;
                        ab.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.hGF);
                        if (!Bs(this.hGG) && Bs(sightCaptureResult.osD)) {
                            this.hGG = sightCaptureResult.osD;
                        }
                        if (TextUtils.isEmpty(this.hGF)) {
                            file2 = null;
                        } else {
                            file2 = new File(this.hGF);
                        }
                        if (file2 == null || !file2.exists()) {
                            ab.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.hGF);
                        } else {
                            ab.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.hGF);
                            afu(this.hGF);
                            AppMethodBeat.o(7459);
                            return;
                        }
                    }
                }
                ab.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                AppMethodBeat.o(7459);
                return;
            case 8:
                ab.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (stringArrayListExtra2 == null) {
                        ab.e("MicroMsg.OpenFileChooserUI", "chosen is null");
                        setResult(1);
                        finish();
                        AppMethodBeat.o(7459);
                        return;
                    }
                    arrayList = new ArrayList();
                    for (String h2 : stringArrayListExtra2) {
                        WebViewJSSDKFileItem aeu2 = WebViewJSSDKFileItem.aeu(h2);
                        String str = aeu2.czD;
                        aeu2.hes = booleanExtra;
                        g.cYF().b(aeu2);
                        ab.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", h2, str);
                        arrayList.add(str);
                    }
                    ab.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ap.ac(arrayList));
                    intent3 = new Intent();
                    intent3.putExtra("key_pick_local_media_local_ids", h2);
                    intent3.putExtra("key_pick_local_media_show_memory_warning", this.usd);
                    intent3.putExtra("key_pick_local_media_callback_type", 2);
                    setResult(i2, intent3);
                    finish();
                    AppMethodBeat.o(7459);
                    return;
                }
                afu((String) stringArrayListExtra.get(0));
                AppMethodBeat.o(7459);
                return;
            default:
                ab.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", Integer.valueOf(i));
                setResult(1);
                finish();
                AppMethodBeat.o(7459);
                return;
        }
    }

    private void afu(final String str) {
        AppMethodBeat.i(7460);
        this.use = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(7446);
                OpenFileChooserUI.this.setResult(0);
                OpenFileChooserUI.this.finish();
                AppMethodBeat.o(7446);
            }
        };
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.fyk), true, this.use);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(7454);
                ArrayList arrayList = new ArrayList();
                int a = OpenFileChooserUI.a(OpenFileChooserUI.this, str);
                if (a == -50002) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(7448);
                            if (OpenFileChooserUI.this.mPB == 7 && OpenFileChooserUI.this.mQk == 2) {
                                h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.string.fyl), OpenFileChooserUI.this.getString(R.string.tz), OpenFileChooserUI.this.getString(R.string.r4), false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(7447);
                                        OpenFileChooserUI.this.setResult(1);
                                        OpenFileChooserUI.this.finish();
                                        AppMethodBeat.o(7447);
                                    }
                                });
                                AppMethodBeat.o(7448);
                                return;
                            }
                            Toast.makeText(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.string.f16), 0).show();
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                            AppMethodBeat.o(7448);
                        }
                    });
                    AppMethodBeat.o(7454);
                    return;
                }
                String s;
                String d;
                if (a == -50006) {
                    s = OpenFileChooserUI.s(str, arrayList);
                    OpenFileChooserUI.b(OpenFileChooserUI.this, str);
                    d = OpenFileChooserUI.d(OpenFileChooserUI.this);
                } else if (a == 1) {
                    s = OpenFileChooserUI.c(OpenFileChooserUI.this, str);
                    OpenFileChooserUI.b(OpenFileChooserUI.this, str);
                    d = OpenFileChooserUI.d(OpenFileChooserUI.this);
                    if (bo.isNullOrNil(s) && OpenFileChooserUI.this.mPB == 7 && OpenFileChooserUI.this.mQk == 2) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(7450);
                                h.a(OpenFileChooserUI.this, OpenFileChooserUI.this.getString(R.string.fym), OpenFileChooserUI.this.getString(R.string.tz), OpenFileChooserUI.this.getString(R.string.r4), false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(7449);
                                        OpenFileChooserUI.this.setResult(1);
                                        OpenFileChooserUI.this.finish();
                                        AppMethodBeat.o(7449);
                                    }
                                });
                                AppMethodBeat.o(7450);
                            }
                        });
                        AppMethodBeat.o(7454);
                        return;
                    }
                } else {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(7451);
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                            AppMethodBeat.o(7451);
                        }
                    });
                    AppMethodBeat.o(7454);
                    return;
                }
                if (bo.isNullOrNil(s)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(7453);
                            OpenFileChooserUI.this.setResult(1);
                            OpenFileChooserUI.this.finish();
                            AppMethodBeat.o(7453);
                        }
                    });
                    AppMethodBeat.o(7454);
                    return;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(7452);
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_media_callback_type", 1);
                        intent.putExtra("key_pick_local_media_local_id", s);
                        intent.putExtra("key_pick_local_media_thumb_local_id", d);
                        ab.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", d);
                        OpenFileChooserUI.this.setResult(-1, intent);
                        OpenFileChooserUI.this.finish();
                        AppMethodBeat.o(7452);
                    }
                });
                AppMethodBeat.o(7454);
            }
        });
        AppMethodBeat.o(7460);
    }

    private String afv(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        AppMethodBeat.i(7461);
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
            ab.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e);
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            AppMethodBeat.o(7461);
            return null;
        }
        int i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        int i3 = bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        mediaMetadataRetriever.release();
        WebViewJSSDKVideoItem aew = WebViewJSSDKFileItem.aew(str);
        aew.duration = (i3 + 500) / 1000;
        aew.width = i;
        aew.height = i2;
        aew.size = com.tencent.mm.a.e.cs(str);
        if (this.usc == 1) {
            aew.hGG = this.hGG;
        }
        g.cYF().b(aew);
        String str2 = aew.czD;
        AppMethodBeat.o(7461);
        return str2;
    }

    private int afw(String str) {
        com.tencent.mm.compatible.j.a.a j;
        AppMethodBeat.i(7462);
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://".concat(String.valueOf(str))));
        com.tencent.mm.compatible.j.a.a aVar = null;
        at.is2G(this);
        try {
            j = com.tencent.mm.compatible.j.a.j(this, intent);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.OpenFileChooserUI", e, "", new Object[0]);
            j = aVar;
        }
        if (j == null) {
            ab.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            AppMethodBeat.o(7462);
            return -50005;
        }
        int i;
        String str2 = j.filename;
        boolean vC = com.tencent.mm.plugin.a.c.vC(str2);
        ab.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", Boolean.valueOf(vC));
        int i2 = -10000;
        if (vC) {
            i2 = SightVideoJNI.shouldRemuxing(str2, 660, 500, 26214400, 300000.0d, 1000000);
            ab.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", Integer.valueOf(i2));
        }
        if (i2 == -1 || !vC) {
            ab.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", Integer.valueOf(com.tencent.mm.a.e.cs(str2)));
            if (com.tencent.mm.a.e.cs(str2) > 26214400) {
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
                AppMethodBeat.o(7462);
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
                ab.e("MicroMsg.OpenFileChooserUI", "unknown check type");
                AppMethodBeat.o(7462);
                return -50001;
        }
        if (i != 0) {
            i2 = -50006;
        }
        i = j.duration / 1000;
        ab.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", str2, Integer.valueOf(i2), Integer.valueOf(i));
        AppMethodBeat.o(7462);
        return i2;
    }

    public void onDestroy() {
        AppMethodBeat.i(7463);
        super.onDestroy();
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(7463);
    }

    private static boolean Bs(String str) {
        AppMethodBeat.i(7464);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
            AppMethodBeat.o(7464);
            return false;
        }
        File file = new File(str);
        ab.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", str);
        if (file.exists()) {
            ab.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
            AppMethodBeat.o(7464);
            return true;
        }
        ab.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
        AppMethodBeat.o(7464);
        return false;
    }

    static /* synthetic */ String s(String str, List list) {
        AppMethodBeat.i(7466);
        int[] iArr = new int[2];
        j.c(str, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        com.tencent.mm.plugin.sight.base.d.a(str, pInt, pInt2, pInt3, pInt4, new PInt());
        String str2 = e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
        ab.i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(SightVideoJNI.remuxing(str, str2, i, i2, com.tencent.mm.plugin.sight.base.b.qwZ, com.tencent.mm.plugin.sight.base.b.qwY, 8, 2, 25.0f, (float) pInt4.value, null, 0, false)), Integer.valueOf(i), Integer.valueOf(i2));
        WebViewJSSDKVideoItem aew = WebViewJSSDKFileItem.aew(str2);
        aew.width = i;
        aew.height = i2;
        aew.duration = r2;
        aew.size = com.tencent.mm.a.e.cs(str2);
        list.add(aew.czD);
        g.cYF().b(aew);
        String str3 = aew.czD;
        AppMethodBeat.o(7466);
        return str3;
    }

    static /* synthetic */ void b(OpenFileChooserUI openFileChooserUI, String str) {
        CharSequence charSequence = null;
        AppMethodBeat.i(7467);
        if (openFileChooserUI.usc == 0) {
            ab.e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            AppMethodBeat.o(7467);
            return;
        }
        File file;
        if (TextUtils.isEmpty(openFileChooserUI.hGG)) {
            ab.e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            file = null;
        } else {
            file = new File(openFileChooserUI.hGG);
        }
        if (file == null || !file.exists()) {
            ab.e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", openFileChooserUI.hGG);
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                charSequence = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(charSequence)) {
                openFileChooserUI.hGG = e.euR + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (e.euR == null || !e.euR.endsWith("/")) {
                openFileChooserUI.hGG = e.euR + "/" + charSequence + ".jpeg";
            } else {
                openFileChooserUI.hGG = e.euR + charSequence + ".jpeg";
            }
            if (new File(openFileChooserUI.hGG).exists()) {
                ab.i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", openFileChooserUI.hGG);
                AppMethodBeat.o(7467);
                return;
            }
            ab.i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", openFileChooserUI.hGG);
            ab.i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", openFileChooserUI.hGG);
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                ab.e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", openFileChooserUI.hGG);
                AppMethodBeat.o(7467);
                return;
            }
            try {
                com.tencent.mm.sdk.platformtools.d.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, openFileChooserUI.hGG, true);
                AppMethodBeat.o(7467);
                return;
            } catch (IOException e) {
                ab.e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e.getMessage());
                AppMethodBeat.o(7467);
                return;
            }
        }
        ab.i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", openFileChooserUI.hGG);
        AppMethodBeat.o(7467);
    }

    static /* synthetic */ String d(OpenFileChooserUI openFileChooserUI) {
        AppMethodBeat.i(7468);
        String str;
        if (TextUtils.isEmpty(openFileChooserUI.hGG)) {
            str = "";
            AppMethodBeat.o(7468);
            return str;
        }
        WebViewJSSDKFileItem aeu = WebViewJSSDKFileItem.aeu(openFileChooserUI.hGG);
        aeu.hGG = openFileChooserUI.hGG;
        aeu.hes = true;
        aeu.cyQ = 1;
        g.cYF().b(aeu);
        str = aeu.czD;
        AppMethodBeat.o(7468);
        return str;
    }
}
