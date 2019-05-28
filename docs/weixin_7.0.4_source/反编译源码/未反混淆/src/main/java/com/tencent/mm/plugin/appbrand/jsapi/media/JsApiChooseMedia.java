package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.j;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class JsApiChooseMedia extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 193;
    public static final String NAME = "chooseMedia";
    private static volatile boolean hPi = false;

    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new Creator<ChooseResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131163);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(131163);
                return chooseResult;
            }
        };
        int bFZ;
        String hPo;
        String type;

        public final void k(Parcel parcel) {
            AppMethodBeat.i(131164);
            this.bFZ = parcel.readInt();
            this.type = parcel.readString();
            this.hPo = parcel.readString();
            AppMethodBeat.o(131164);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131165);
            parcel.writeInt(this.bFZ);
            parcel.writeString(this.type);
            parcel.writeString(this.hPo);
            AppMethodBeat.o(131165);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            AppMethodBeat.i(131166);
            k(parcel);
            AppMethodBeat.o(131166);
        }

        static {
            AppMethodBeat.i(131167);
            AppMethodBeat.o(131167);
        }
    }

    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new Creator<ChooseRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131158);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(131158);
                return chooseRequest;
            }
        };
        String appId;
        int count;
        boolean hOU;
        boolean hOV;
        boolean hPk;
        boolean hPl;
        boolean hPm;
        boolean hPn;
        boolean isFront;
        int maxDuration;

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return a.class;
        }

        public final String aBZ() {
            return "GalleryChooseMedia";
        }

        public final void k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(131159);
            this.appId = parcel.readString();
            this.hPk = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hPl = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hPm = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hPn = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.isFront = z;
            this.maxDuration = parcel.readInt();
            this.count = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOU = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.hOV = z2;
            AppMethodBeat.o(131159);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(131160);
            parcel.writeString(this.appId);
            parcel.writeByte(this.hPk ? (byte) 1 : (byte) 0);
            if (this.hPl) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.hPm) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.hPn) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.isFront) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeInt(this.maxDuration);
            parcel.writeInt(this.count);
            if (this.hOU) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.hOV) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            AppMethodBeat.o(131160);
        }

        public final boolean aBY() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.i(131161);
            k(parcel);
            AppMethodBeat.o(131161);
        }

        static {
            AppMethodBeat.i(131162);
            AppMethodBeat.o(131162);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private p ejZ;
        int hOZ;
        private OnCancelListener hPa;
        private ChooseResult hPp = new ChooseResult();
        private ChooseRequest hPq;
        private String hPr;
        private j hPs;
        private String mVideoFilePath;

        private a() {
            AppMethodBeat.i(131178);
            AppMethodBeat.o(131178);
        }

        static /* synthetic */ String access$1500(String str) {
            AppMethodBeat.i(131203);
            String Bo = Bo(str);
            AppMethodBeat.o(131203);
            return Bo;
        }

        static /* synthetic */ MMActivity b(a aVar) {
            AppMethodBeat.i(131192);
            MMActivity aBQ = aVar.aBQ();
            AppMethodBeat.o(131192);
            return aBQ;
        }

        static /* synthetic */ void c(a aVar) {
            AppMethodBeat.i(131193);
            aVar.aEg();
            AppMethodBeat.o(131193);
        }

        static /* synthetic */ String d(String str, String str2, int i, int i2, int i3, int i4) {
            AppMethodBeat.i(131200);
            String c = c(str, str2, i, i2, i3, i4);
            AppMethodBeat.o(131200);
            return c;
        }

        static /* synthetic */ void d(a aVar) {
            AppMethodBeat.i(131194);
            aVar.aEh();
            AppMethodBeat.o(131194);
        }

        static /* synthetic */ void d(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131202);
            aVar.a(processResult);
            AppMethodBeat.o(131202);
        }

        static /* synthetic */ void e(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131204);
            aVar.a(processResult);
            AppMethodBeat.o(131204);
        }

        static /* synthetic */ void f(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131206);
            aVar.a(processResult);
            AppMethodBeat.o(131206);
        }

        static /* synthetic */ void g(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131207);
            aVar.a(processResult);
            AppMethodBeat.o(131207);
        }

        static /* synthetic */ void h(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131208);
            aVar.a(processResult);
            AppMethodBeat.o(131208);
        }

        static /* synthetic */ void i(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131209);
            aVar.a(processResult);
            AppMethodBeat.o(131209);
        }

        static /* synthetic */ void j(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131210);
            aVar.a(processResult);
            AppMethodBeat.o(131210);
        }

        static /* synthetic */ void k(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131211);
            aVar.a(processResult);
            AppMethodBeat.o(131211);
        }

        static /* synthetic */ void l(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131212);
            aVar.a(processResult);
            AppMethodBeat.o(131212);
        }

        public final void a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.i(131179);
            this.hPq = (ChooseRequest) processRequest;
            if ((this.hPq.hOU & this.hPq.hOV) != 0) {
                i = 8;
            } else {
                i = 7;
            }
            this.hOZ = i;
            if (bo.gO(aBQ()) > 200) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                ab.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
                t.makeText(aBQ(), ah.getResources().getString(R.string.ha), 1).show();
            }
            ab.i("MicroMsg.JsApiChooseMedia", "goVideo");
            aBQ().ifE = this;
            if (this.hPq.hPk && this.hPq.hPl) {
                this.hPs = new j(aBQ());
                this.hPs.b(null, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(131168);
                        contextMenu.add(0, 1, 0, a.a(a.this).getString(R.string.q4));
                        contextMenu.add(0, 2, 1, a.b(a.this).getString(R.string.qa));
                        AppMethodBeat.o(131168);
                    }
                }, new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(131169);
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.c(a.this);
                                AppMethodBeat.o(131169);
                                return;
                            case 2:
                                a.d(a.this);
                                break;
                        }
                        AppMethodBeat.o(131169);
                    }
                });
                this.hPs.e(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(131170);
                        ab.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
                        a.this.hPp.bFZ = 0;
                        a.a(a.this, a.this.hPp);
                        AppMethodBeat.o(131170);
                    }
                });
                this.hPs.cuu();
                AppMethodBeat.o(131179);
            } else if (this.hPq.hPk) {
                aEh();
                AppMethodBeat.o(131179);
            } else if (this.hPq.hPl) {
                aEg();
                AppMethodBeat.o(131179);
            } else {
                this.hPp.bFZ = -2;
                ab.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
                a((ProcessResult) this.hPp);
                AppMethodBeat.o(131179);
            }
        }

        public final void aBX() {
            AppMethodBeat.i(131180);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            if (this.hPs != null) {
                this.hPs.dismiss();
                this.hPs = null;
            }
            AppMethodBeat.o(131180);
        }

        private void aEg() {
            int i = 0;
            AppMethodBeat.i(131181);
            ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
            if (!(this.hPq.hPn && this.hPq.hPm)) {
                if (this.hPq.hPn) {
                    i = 1;
                } else if (this.hPq.hPm) {
                    i = 2;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("KEY_SIGHT_PARAMS", os(i));
            n.a(aBQ(), 7, intent, 3, i);
            AppMethodBeat.o(131181);
        }

        private SightParams os(int i) {
            AppMethodBeat.i(131182);
            String str = "microMsg_" + System.currentTimeMillis();
            this.mVideoFilePath = e.euR + "microMsg." + str + VideoMaterialUtil.MP4_SUFFIX;
            this.hPr = e.euR + "microMsg." + str + ".jpeg";
            int i2 = this.hPq.maxDuration;
            SightParams sightParams = new SightParams(3, 1);
            sightParams.osJ = this.hPq.isFront ? 1 : 2;
            sightParams.mode = i;
            if (sightParams.fcY == null) {
                sightParams.fcY = new VideoTransPara();
            }
            sightParams.fcY.duration = i2;
            sightParams.osQ = false;
            sightParams.q(str, this.mVideoFilePath, this.hPr, e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            AppMethodBeat.o(131182);
            return sightParams;
        }

        private void aEh() {
            int i = 3;
            boolean z = true;
            AppMethodBeat.i(131183);
            ab.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
            if (!(this.hPq.hPm && this.hPq.hPn)) {
                if (this.hPq.hPm) {
                    i = 1;
                } else if (this.hPq.hPn) {
                    i = 2;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("key_can_select_video_and_pic", true);
            String str = "key_send_raw_image";
            if (this.hPq.hOU) {
                z = false;
            }
            intent.putExtra(str, z);
            n.a(aBQ(), 8, this.hPq.count, this.hOZ, i, intent);
            AppMethodBeat.o(131183);
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(131184);
            if (i2 == 0) {
                ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
                this.hPp.bFZ = 0;
                a((ProcessResult) this.hPp);
                AppMethodBeat.o(131184);
            } else if (-1 != i2) {
                ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
                this.hPp.bFZ = -2;
                a((ProcessResult) this.hPp);
                AppMethodBeat.o(131184);
            } else {
                boolean booleanExtra;
                boolean z;
                switch (i) {
                    case 7:
                        ab.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                        if (intent == null) {
                            ab.e("MicroMsg.JsApiChooseMedia", "data is null!");
                            break;
                        }
                        ab.i("MicroMsg.JsApiChooseMedia", "data is valid!");
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        if (sightCaptureResult == null) {
                            ab.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
                            this.hPp.bFZ = -2;
                            a((ProcessResult) this.hPp);
                            AppMethodBeat.o(131184);
                            return;
                        } else if (sightCaptureResult.osA) {
                            final String str = sightCaptureResult.osI;
                            if (bo.isNullOrNil(str)) {
                                ab.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", str);
                                this.hPp.bFZ = -2;
                                a((ProcessResult) this.hPp);
                                AppMethodBeat.o(131184);
                                return;
                            }
                            booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                            if (((!this.hPq.hOV ? 1 : 0) & this.hPq.hOU) == 0 && ((this.hPq.hOU & this.hPq.hOV) & booleanExtra) == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            ab.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.TRUE, Boolean.valueOf(this.hPq.hOU), Boolean.valueOf(this.hPq.hOV), Boolean.valueOf(booleanExtra), Boolean.valueOf(z));
                            if (z) {
                                aEi();
                            }
                            m.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131175);
                                    String access$1500 = z ? a.access$1500(str) : str;
                                    final ArrayList arrayList = new ArrayList();
                                    final ArrayList arrayList2 = new ArrayList();
                                    AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.j(a.this.hPq.appId, access$1500, z | 1);
                                    if (j != null) {
                                        arrayList.add(Long.valueOf(j.gjQ));
                                        arrayList2.add(j.czD);
                                        al.d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(131174);
                                                ab.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                                a.this.hPp.bFZ = -1;
                                                a.this.hPp.type = "image";
                                                a.this.hPp.hPo = a.c(arrayList2, arrayList);
                                                a.g(a.this, a.this.hPp);
                                                AppMethodBeat.o(131174);
                                            }
                                        });
                                        AppMethodBeat.o(131175);
                                        return;
                                    }
                                    ab.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", str);
                                    a.this.hPp.bFZ = -2;
                                    a.h(a.this, a.this.hPp);
                                    AppMethodBeat.o(131175);
                                }
                            });
                            AppMethodBeat.o(131184);
                            return;
                        } else {
                            this.mVideoFilePath = sightCaptureResult.osC;
                            if (bo.isNullOrNil(this.mVideoFilePath)) {
                                ab.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
                                break;
                            }
                            ab.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", this.mVideoFilePath);
                            if (!Bs(this.hPr) && Bs(sightCaptureResult.osD)) {
                                this.hPr = sightCaptureResult.osD;
                            }
                            aEi();
                            m.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131176);
                                    if (new File(a.this.mVideoFilePath).exists()) {
                                        ab.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                                        a.this.hPp.bFZ = -1;
                                        a.this.hPp.type = "video";
                                        AppBrandLocalVideoObject a = a.a(a.this, a.this.mVideoFilePath);
                                        if (a == null) {
                                            ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", a.this.mVideoFilePath);
                                            a.this.hPp.bFZ = -2;
                                            a.i(a.this, a.this.hPp);
                                            AppMethodBeat.o(131176);
                                            return;
                                        }
                                        a.b(a.this, a.this.mVideoFilePath);
                                        String g = a.g(a.this);
                                        a.this.hPp.hPo = a.d(a.czD, g, a.duration, a.height, a.width, a.size);
                                        a.j(a.this, a.this.hPp);
                                        AppMethodBeat.o(131176);
                                        return;
                                    }
                                    ab.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", a.this.mVideoFilePath);
                                    a.this.hPp.bFZ = -2;
                                    a.k(a.this, a.this.hPp);
                                    AppMethodBeat.o(131176);
                                }
                            });
                            AppMethodBeat.o(131184);
                            return;
                        }
                        break;
                    case 8:
                        ab.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                            final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                            if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                                ab.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
                                this.hPp.bFZ = -2;
                                a((ProcessResult) this.hPp);
                                AppMethodBeat.o(131184);
                                return;
                            }
                            booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                            if (((!this.hPq.hOV ? 1 : 0) & this.hPq.hOU) == 0 && ((this.hPq.hOU & this.hPq.hOV) & booleanExtra) == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            ab.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.FALSE, Boolean.valueOf(this.hPq.hOU), Boolean.valueOf(this.hPq.hOV), Boolean.valueOf(booleanExtra), Boolean.valueOf(z));
                            if (z) {
                                aEi();
                            }
                            m.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131173);
                                    final ArrayList arrayList = new ArrayList(stringArrayListExtra2.size());
                                    final ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                                    for (String str : stringArrayListExtra2) {
                                        String str2;
                                        if (z) {
                                            str2 = a.access$1500(str2);
                                        }
                                        AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.j(a.this.hPq.appId, str2, z | 0);
                                        if (j != null) {
                                            arrayList.add(Long.valueOf(j.gjQ));
                                            arrayList2.add(j.czD);
                                        } else {
                                            ab.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", str2);
                                        }
                                    }
                                    if (arrayList2.size() == 0) {
                                        ab.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                                        a.this.hPp.bFZ = -2;
                                        a.e(a.this, a.this.hPp);
                                        AppMethodBeat.o(131173);
                                        return;
                                    }
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(131172);
                                            ab.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                            a.this.hPp.bFZ = -1;
                                            a.this.hPp.type = "image";
                                            a.this.hPp.hPo = a.c(arrayList2, arrayList);
                                            a.f(a.this, a.this.hPp);
                                            AppMethodBeat.o(131172);
                                        }
                                    });
                                    AppMethodBeat.o(131173);
                                }
                            });
                            AppMethodBeat.o(131184);
                            return;
                        }
                        this.mVideoFilePath = (String) stringArrayListExtra.get(0);
                        if (bo.isNullOrNil(this.mVideoFilePath)) {
                            ab.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                            break;
                        }
                        aEi();
                        com.tencent.mm.plugin.appbrand.s.e.aNS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(131171);
                                if (new File(a.this.mVideoFilePath).exists()) {
                                    ab.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                                    a.this.hPp.bFZ = -1;
                                    a.this.hPp.type = "video";
                                    AppBrandLocalVideoObject a = a.a(a.this, a.this.mVideoFilePath);
                                    if (a == null) {
                                        ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", a.this.mVideoFilePath);
                                        a.this.hPp.bFZ = -2;
                                        a.b(a.this, a.this.hPp);
                                        AppMethodBeat.o(131171);
                                        return;
                                    }
                                    a.b(a.this, a.this.mVideoFilePath);
                                    String g = a.g(a.this);
                                    a.this.hPp.hPo = a.d(a.czD, g, a.duration, a.height, a.width, a.size);
                                    a.c(a.this, a.this.hPp);
                                    AppMethodBeat.o(131171);
                                    return;
                                }
                                ab.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", a.this.mVideoFilePath);
                                a.this.hPp.bFZ = -2;
                                a.d(a.this, a.this.hPp);
                                AppMethodBeat.o(131171);
                            }
                        });
                        AppMethodBeat.o(131184);
                        return;
                        break;
                }
                this.hPp.bFZ = -2;
                a((ProcessResult) this.hPp);
                AppMethodBeat.o(131184);
            }
        }

        private void aEi() {
            AppMethodBeat.i(131185);
            this.hPa = new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(131177);
                    ab.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
                    a.this.hPp.bFZ = 0;
                    a.l(a.this, a.this.hPp);
                    AppMethodBeat.o(131177);
                }
            };
            Context aBQ = aBQ();
            ah.getResources().getString(R.string.tz);
            this.ejZ = h.b(aBQ, ah.getResources().getString(R.string.hb), true, this.hPa);
            AppMethodBeat.o(131185);
        }

        private static String Bo(String str) {
            AppMethodBeat.i(131186);
            String str2 = e.euR + "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            try {
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    ab.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
                    AppMethodBeat.o(131186);
                    return null;
                }
                long anU = bo.anU();
                int b = q.b(decodeFile, 70, str2);
                ab.i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", Integer.valueOf(b), Long.valueOf(bo.anU() - anU), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length()));
                if (b == 1) {
                    try {
                        b.bY(str, str2);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiChooseMedia", "doCompressImage, duplicateExif e = %s", e);
                    }
                }
                if (b == 1) {
                    AppMethodBeat.o(131186);
                    return str2;
                }
                AppMethodBeat.o(131186);
                return str;
            } catch (OutOfMemoryError e2) {
                ab.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
                AppMethodBeat.o(131186);
                return null;
            }
        }

        private static boolean Bs(String str) {
            AppMethodBeat.i(131188);
            if (TextUtils.isEmpty(str)) {
                ab.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
                AppMethodBeat.o(131188);
                return false;
            }
            File file = new File(str);
            ab.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", str);
            if (file.exists()) {
                ab.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
                AppMethodBeat.o(131188);
                return true;
            }
            ab.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
            AppMethodBeat.o(131188);
            return false;
        }

        private static String b(ArrayList<String> arrayList, ArrayList<Long> arrayList2) {
            AppMethodBeat.i(131189);
            String str;
            if (arrayList == null || arrayList.size() == 0) {
                ab.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
                str = "";
                AppMethodBeat.o(131189);
                return str;
            }
            ab.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONStringer.object();
                    str = (String) arrayList.get(i);
                    Long l = (Long) arrayList2.get(i);
                    jSONStringer.key("tempFilePath");
                    jSONStringer.value(str);
                    jSONStringer.key("size");
                    jSONStringer.value(String.valueOf(l.longValue()));
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                str = jSONStringer.toString();
                AppMethodBeat.o(131189);
                return str;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
                str = "";
                AppMethodBeat.o(131189);
                return str;
            }
        }

        private static String c(String str, String str2, int i, int i2, int i3, int i4) {
            AppMethodBeat.i(131190);
            String str3;
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
                str3 = "";
                AppMethodBeat.o(131190);
                return str3;
            }
            ab.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                jSONStringer.object();
                jSONStringer.key("tempFilePath");
                jSONStringer.value(str);
                jSONStringer.key("thumbTempFilePath");
                jSONStringer.value(str2);
                jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                jSONStringer.value(String.valueOf(i));
                jSONStringer.key("height");
                jSONStringer.value(String.valueOf(i2));
                jSONStringer.key("width");
                jSONStringer.value(String.valueOf(i3));
                jSONStringer.key("size");
                jSONStringer.value(String.valueOf(i4));
                jSONStringer.endObject();
                jSONStringer.endArray();
                str3 = jSONStringer.toString();
                AppMethodBeat.o(131190);
                return str3;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
                str3 = "";
                AppMethodBeat.o(131190);
                return str3;
            }
        }

        private AppBrandLocalVideoObject Br(String str) {
            int i;
            int i2;
            MediaMetadataRetriever mediaMetadataRetriever;
            AppMethodBeat.i(131187);
            try {
                boolean vC = c.vC(str);
                ab.i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", Boolean.valueOf(vC));
                int i3 = -10000;
                if (vC) {
                    i3 = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, 1000000);
                    ab.i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", Integer.valueOf(i3));
                }
                if (i3 == -1 || !vC) {
                    ab.i("MicroMsg.JsApiChooseMedia", "fileLength = %d", Integer.valueOf(com.tencent.mm.a.e.cs(str)));
                    if (com.tencent.mm.a.e.cs(str) > 26214400) {
                        i3 = -1;
                    } else {
                        i3 = 1;
                    }
                }
                switch (i3) {
                    case -6:
                    case -5:
                    case -4:
                    case -3:
                    case -2:
                    case -1:
                        i3 = -50002;
                        break;
                    case 0:
                        i3 = -50006;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        i3 = 1;
                        break;
                    default:
                        ab.e("MicroMsg.JsApiChooseMedia", "unknown check type");
                        i3 = -50001;
                        break;
                }
                if (i3 == -50006) {
                    int[] iArr = new int[2];
                    com.tencent.mm.pluginsdk.model.j.c(str, iArr);
                    i = iArr[0];
                    i2 = iArr[1];
                    String str2 = e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                    i3 = SightVideoJNI.remuxing(str, str2, i, i2, com.tencent.mm.plugin.sight.base.b.qwZ, com.tencent.mm.plugin.sight.base.b.qwY, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qxa, null, 0, false);
                    ab.i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                    str = str2;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", bo.l(e));
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                ab.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
                AppMethodBeat.o(131187);
                return null;
            }
            int i4 = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            mediaMetadataRetriever.release();
            AppBrandLocalVideoObject bs = AppBrandLocalMediaObjectManager.bs(this.hPq.appId, str);
            if (bs == null) {
                ab.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
                AppMethodBeat.o(131187);
                return null;
            }
            bs.duration = (i2 + 500) / 1000;
            bs.width = i4;
            bs.height = i;
            bs.size = com.tencent.mm.a.e.cs(str);
            ab.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", bs);
            AppMethodBeat.o(131187);
            return bs;
        }

        static /* synthetic */ String g(a aVar) {
            String str;
            AppMethodBeat.i(131199);
            if (!TextUtils.isEmpty(aVar.hPr)) {
                AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.j(aVar.hPq.appId, aVar.hPr, true);
                if (j == null || bo.isNullOrNil(j.czD)) {
                    ab.e("MicroMsg.JsApiChooseMedia", "addThumbItem error, localId is null");
                } else {
                    str = j.czD;
                    AppMethodBeat.o(131199);
                    return str;
                }
            }
            str = "";
            AppMethodBeat.o(131199);
            return str;
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131213);
        if (hPi) {
            ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
            cVar.M(i, j("cancel", null));
            AppMethodBeat.o(131213);
            return;
        }
        Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
            cVar.M(i, j("fail:page context is null", null));
            AppMethodBeat.o(131213);
        } else if (jSONObject == null) {
            ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(131213);
        } else {
            String str;
            String str2;
            int i2;
            String str3;
            String str4;
            boolean z;
            ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + jSONObject.toString());
            String str5 = "";
            if (jSONObject.optJSONArray("sourceType") == null || jSONObject.optJSONArray("sourceType").length() <= 0) {
                ab.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
            } else {
                str5 = jSONObject.optJSONArray("sourceType").toString();
            }
            if (bo.isNullOrNil(str5)) {
                str = "camera|album";
            } else {
                str = str5;
            }
            str5 = "";
            if (jSONObject.optJSONArray("mediaType") == null || jSONObject.optJSONArray("mediaType").length() <= 0) {
                ab.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
            } else {
                str5 = jSONObject.optJSONArray("mediaType").toString();
            }
            if (bo.isNullOrNil(str5)) {
                str2 = "video|image";
            } else {
                str2 = str5;
            }
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            if (min < 3 || min > 10) {
                ab.e("MicroMsg.JsApiChooseMedia", "maxDuration is invalid");
                i2 = 10;
            } else {
                i2 = min;
            }
            str5 = jSONObject.optString("camera");
            if (bo.isNullOrNil(str5)) {
                str3 = "back";
            } else {
                str3 = str5;
            }
            int min2 = Math.min(jSONObject.optInt("count", 9), 9);
            str5 = "";
            if (jSONObject.optJSONArray("sizeType") == null || jSONObject.optJSONArray("sizeType").length() <= 0) {
                ab.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
            } else {
                str5 = jSONObject.optJSONArray("sizeType").toString();
            }
            if (bo.isNullOrNil(str5)) {
                str4 = "original|compressed";
            } else {
                str4 = str5;
            }
            ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", str, str2, Integer.valueOf(i2), str3, Integer.valueOf(min2), str4);
            com.tencent.mm.plugin.appbrand.permission.n.b(cVar.getAppId(), new android.support.v4.app.a.a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(131156);
                    if (i != 120) {
                        ab.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
                        AppMethodBeat.o(131156);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        ab.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
                        cVar.M(i, JsApiChooseMedia.this.j("fail:system permission denied", null));
                        AppMethodBeat.o(131156);
                    } else {
                        ab.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                        JsApiChooseMedia.this.a(cVar, jSONObject, i);
                        AppMethodBeat.o(131156);
                    }
                }
            });
            Context context2 = cVar.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                cVar.M(i, j("fail", null));
                z = false;
            } else {
                z = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.RECORD_AUDIO", 120, "", "");
                if (z) {
                    com.tencent.mm.plugin.appbrand.permission.n.Dr(cVar.getAppId());
                }
            }
            if (z) {
                com.tencent.mm.plugin.appbrand.permission.n.b(cVar.getAppId(), new android.support.v4.app.a.a() {
                    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                        AppMethodBeat.i(131157);
                        if (i != com.tencent.view.d.MIC_AVROUND_BLUR) {
                            ab.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                            AppMethodBeat.o(131157);
                        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            ab.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                            cVar.M(i, JsApiChooseMedia.this.j("fail:system permission denied", null));
                            AppMethodBeat.o(131157);
                        } else {
                            ab.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                            JsApiChooseMedia.this.a(cVar, jSONObject, i);
                            AppMethodBeat.o(131157);
                        }
                    }
                });
                context2 = cVar.getContext();
                if (context2 == null || !(context2 instanceof Activity)) {
                    ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                    cVar.M(i, j("fail", null));
                    z = false;
                } else {
                    z = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.CAMERA", com.tencent.view.d.MIC_AVROUND_BLUR, "", "");
                    if (z) {
                        com.tencent.mm.plugin.appbrand.permission.n.Dr(cVar.getAppId());
                    }
                }
                if (z) {
                    ab.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
                    hPi = true;
                    g.a(cVar.getAppId(), new g.c() {
                        public final void onResume() {
                            AppMethodBeat.i(131154);
                            ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                            JsApiChooseMedia.hPi = false;
                            g.b(cVar.getAppId(), this);
                            AppMethodBeat.o(131154);
                        }
                    });
                    ChooseRequest chooseRequest = new ChooseRequest();
                    chooseRequest.appId = cVar.getAppId();
                    chooseRequest.hPk = str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                    chooseRequest.hPl = str.contains("camera");
                    chooseRequest.hPm = str2.contains("image");
                    chooseRequest.hPn = str2.contains("video");
                    if (str3.contains("back") || !str3.contains("front")) {
                        chooseRequest.isFront = false;
                    } else {
                        chooseRequest.isFront = true;
                    }
                    chooseRequest.maxDuration = i2;
                    chooseRequest.count = min2;
                    chooseRequest.hOU = str4.contains("compressed");
                    chooseRequest.hOV = str4.contains("original");
                    com.tencent.mm.plugin.appbrand.ipc.a.a(context, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
                        public final /* synthetic */ void c(ProcessResult processResult) {
                            AppMethodBeat.i(131155);
                            ChooseResult chooseResult = (ChooseResult) processResult;
                            JsApiChooseMedia.hPi = false;
                            if (chooseResult == null) {
                                ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult result is null");
                                cVar.M(i, JsApiChooseMedia.this.j("fail", null));
                                AppMethodBeat.o(131155);
                                return;
                            }
                            switch (chooseResult.bFZ) {
                                case -1:
                                    String str = chooseResult.type;
                                    String str2 = chooseResult.hPo;
                                    if (bo.isNullOrNil(str2)) {
                                        ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult localIds is null");
                                        cVar.M(i, JsApiChooseMedia.this.j("fail", null));
                                        AppMethodBeat.o(131155);
                                        return;
                                    }
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("type", str);
                                    hashMap.put("tempFiles", str2);
                                    ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia ok, type:%s, localIds:%s", str, str2);
                                    cVar.M(i, JsApiChooseMedia.this.j("ok", hashMap));
                                    AppMethodBeat.o(131155);
                                    return;
                                case 0:
                                    ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult user cancel");
                                    cVar.M(i, JsApiChooseMedia.this.j("fail:cancel", null));
                                    AppMethodBeat.o(131155);
                                    return;
                                default:
                                    ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult");
                                    cVar.M(i, JsApiChooseMedia.this.j("fail", null));
                                    AppMethodBeat.o(131155);
                                    return;
                            }
                        }
                    });
                    AppMethodBeat.o(131213);
                    return;
                }
                ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                AppMethodBeat.o(131213);
                return;
            }
            ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
            AppMethodBeat.o(131213);
        }
    }
}
