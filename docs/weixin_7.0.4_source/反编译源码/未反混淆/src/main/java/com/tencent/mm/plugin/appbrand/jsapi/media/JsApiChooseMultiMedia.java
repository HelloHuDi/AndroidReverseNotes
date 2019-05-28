package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMultiMedia extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 549;
    public static final String NAME = "chooseMultiMedia";
    public static final String hPC = ah.getResources().getString(R.string.vq);
    double hPD;
    double hPE;
    double hPF;
    double hPG;

    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new Creator<ChooseResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131226);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(131226);
                return chooseResult;
            }
        };
        int bFZ;
        String hPI;

        public final void k(Parcel parcel) {
            AppMethodBeat.i(131227);
            this.bFZ = parcel.readInt();
            this.hPI = parcel.readString();
            AppMethodBeat.o(131227);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131228);
            parcel.writeInt(this.bFZ);
            parcel.writeString(this.hPI);
            AppMethodBeat.o(131228);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(131229);
            AppMethodBeat.o(131229);
        }
    }

    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new Creator<ChooseRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131221);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(131221);
                return chooseRequest;
            }
        };
        String appId;
        int count;
        String eUu;
        double fNN;
        int gLP;
        boolean hOS;
        boolean hOT;
        double latitude;
        double longitude;

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return a.class;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(131222);
            parcel.writeString(this.appId);
            parcel.writeInt(this.count);
            parcel.writeDouble(this.longitude);
            parcel.writeDouble(this.latitude);
            parcel.writeString(this.eUu);
            parcel.writeDouble(this.fNN);
            if (this.hOS) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.hOT) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            parcel.writeInt(this.gLP);
            AppMethodBeat.o(131222);
        }

        public final void k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(131223);
            this.appId = parcel.readString();
            this.count = parcel.readInt();
            this.longitude = parcel.readDouble();
            this.latitude = parcel.readDouble();
            this.eUu = parcel.readString();
            this.fNN = parcel.readDouble();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOS = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.hOT = z2;
            this.gLP = parcel.readInt();
            AppMethodBeat.o(131223);
        }

        public final int describeContents() {
            return 0;
        }

        public final String aBZ() {
            return "GalleryChooseMultiMedia";
        }

        public final boolean aBY() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.i(131224);
            k(parcel);
            AppMethodBeat.o(131224);
        }

        static {
            AppMethodBeat.i(131225);
            AppMethodBeat.o(131225);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private p ejZ;
        int hOZ = 7;
        ChooseRequest hPJ;
        ChooseResult hPK = new ChooseResult();
        private OnCancelListener hPa;

        private a() {
            AppMethodBeat.i(131235);
            AppMethodBeat.o(131235);
        }

        static /* synthetic */ String Bw(String str) {
            AppMethodBeat.i(131250);
            String Bo = Bo(str);
            AppMethodBeat.o(131250);
            return Bo;
        }

        static /* synthetic */ String Bx(String str) {
            AppMethodBeat.i(131251);
            String Bn = Bn(str);
            AppMethodBeat.o(131251);
            return Bn;
        }

        static /* synthetic */ String By(String str) {
            AppMethodBeat.i(131254);
            String Bv = Bv(str);
            AppMethodBeat.o(131254);
            return Bv;
        }

        static /* synthetic */ AppBrandLocalVideoObject a(a aVar, String str, boolean z) {
            AppMethodBeat.i(131252);
            AppBrandLocalVideoObject aj = aVar.aj(str, z);
            AppMethodBeat.o(131252);
            return aj;
        }

        static /* synthetic */ LatLongData aEl() {
            AppMethodBeat.i(131257);
            LatLongData aEk = aEk();
            AppMethodBeat.o(131257);
            return aEk;
        }

        static /* synthetic */ String b(String str, long j, int i, int i2, int i3, String str2, String str3) {
            AppMethodBeat.i(131262);
            String a = a(str, j, i, i2, i3, str2, str3);
            AppMethodBeat.o(131262);
            return a;
        }

        static /* synthetic */ String b(String str, long j, int i, int i2, String str2, String str3) {
            AppMethodBeat.i(131258);
            String a = a(str, j, i, i2, str2, str3);
            AppMethodBeat.o(131258);
            return a;
        }

        static /* synthetic */ void b(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131256);
            aVar.a(processResult);
            AppMethodBeat.o(131256);
        }

        static /* synthetic */ void c(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131259);
            aVar.a(processResult);
            AppMethodBeat.o(131259);
        }

        static /* synthetic */ void d(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131260);
            aVar.a(processResult);
            AppMethodBeat.o(131260);
        }

        static /* synthetic */ void e(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131261);
            aVar.a(processResult);
            AppMethodBeat.o(131261);
        }

        static /* synthetic */ void f(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131263);
            aVar.a(processResult);
            AppMethodBeat.o(131263);
        }

        static /* synthetic */ void g(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131264);
            aVar.a(processResult);
            AppMethodBeat.o(131264);
        }

        static /* synthetic */ void h(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131265);
            aVar.a(processResult);
            AppMethodBeat.o(131265);
        }

        public final void a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.i(131236);
            this.hPJ = (ChooseRequest) processRequest;
            if (bo.gO(aBQ()) > 200) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                t.makeText(aBQ(), ah.getResources().getString(R.string.ha), 1).show();
            }
            aBQ().ifE = this;
            Intent aEj;
            if (this.hPJ.hOS && this.hPJ.hOT) {
                n.a(aBQ(), 1, this.hPJ.count, this.hOZ, aEj());
                AppMethodBeat.o(131236);
            } else if (this.hPJ.hOT) {
                aEj = aEj();
                aEj.putExtra("show_header_view", false);
                n.a(aBQ(), 1, this.hPJ.count, this.hOZ, aEj);
                AppMethodBeat.o(131236);
            } else if (this.hPJ.hOS) {
                aEj = new Intent();
                aEj.putExtra("album_business_bubble_media_by_coordinate_latitude", this.hPJ.latitude);
                aEj.putExtra("album_business_bubble_media_by_coordinate_longitude", this.hPJ.longitude);
                SightParams sightParams = new SightParams(7, 1);
                sightParams.mode = 0;
                sightParams.fcY.duration = this.hPJ.gLP;
                aEj.putExtra("KEY_SIGHT_PARAMS", sightParams);
                n.a(aBQ(), 2, aEj, 7, 0);
                AppMethodBeat.o(131236);
            } else {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
                this.hPK.bFZ = -2;
                a((ProcessResult) this.hPK);
                AppMethodBeat.o(131236);
            }
        }

        private Intent aEj() {
            AppMethodBeat.i(131237);
            Intent intent = new Intent();
            intent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
            intent.putExtra("album_video_max_duration", this.hPJ.gLP);
            intent.putExtra("album_business_bubble_media_by_coordinate_distance", this.hPJ.fNN);
            intent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.hPJ.latitude);
            intent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.hPJ.longitude);
            intent.putExtra("album_business_bubble_media_by_coordinate_posname", this.hPJ.eUu);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("send_btn_string", ah.getResources().getString(R.string.s1));
            AppMethodBeat.o(131237);
            return intent;
        }

        /* JADX WARNING: Missing block: B:24:0x00c6, code skipped:
            if (r0 == false) goto L_0x00dc;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c(int i, int i2, Intent intent) {
            double d = 91.0d;
            boolean z = true;
            AppMethodBeat.i(131238);
            if (i2 == 0) {
                this.hPK.bFZ = 0;
                a((ProcessResult) this.hPK);
                AppMethodBeat.o(131238);
                return;
            }
            if (intent != null) {
                d = intent.getDoubleExtra("longitude", 91.0d);
            }
            final double doubleExtra = intent != null ? intent.getDoubleExtra("latitude", 181.0d) : 181.0d;
            ab.d("MicroMsg.JsApiChooseMultiMedia", "longitude: %f, latitude: %f.", Double.valueOf(d), Double.valueOf(doubleExtra));
            ab.i("MicroMsg.JsApiChooseMultiMedia", "requestCode: %d.", Integer.valueOf(i));
            switch (i) {
                case 1:
                    ab.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_GALLERY");
                    if (intent == null) {
                        this.hPK.bFZ = 0;
                        a((ProcessResult) this.hPK);
                        AppMethodBeat.o(131238);
                        return;
                    }
                    final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                    final boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                    aEi();
                    if (!booleanExtra) {
                        boolean z2;
                        if (!bo.ek(stringArrayListExtra)) {
                            for (String fromFile : stringArrayListExtra) {
                                if (Exif.fromFile(fromFile).getOrientationInDegree() != 0) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        z2 = false;
                        break;
                    }
                    z = false;
                    m.aNS().aa(new Runnable() {
                        public final void run() {
                            String Bw;
                            long j;
                            String str;
                            long j2;
                            double d;
                            LatLongData ami;
                            String Bx;
                            JSONObject jSONObject;
                            AppMethodBeat.i(131230);
                            JSONArray jSONArray = new JSONArray();
                            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                                for (String Bw2 : stringArrayListExtra) {
                                    if (!bo.isNullOrNil(Bw2) && new File(Bw2).exists()) {
                                        boolean z;
                                        ab.i("MicroMsg.JsApiChooseMultiMedia", "local img file exist, success");
                                        j = 0;
                                        try {
                                            if (bo.isNullOrNil(Bw2)) {
                                                ab.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                                                str = null;
                                            } else if (e.ct(Bw2)) {
                                                str = Exif.fromFile(Bw2).dateTime;
                                            } else {
                                                ab.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", Bw2);
                                                str = null;
                                            }
                                            if (str != null) {
                                                j = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(str).getTime() / 1000;
                                                ab.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, imgPath: %s.", Long.valueOf(j), Bw2);
                                            }
                                            j2 = j;
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, imgPath: %s.", Bw2);
                                            j2 = 0;
                                        }
                                        d = -1.0d;
                                        if (com.tencent.mm.modelgeo.a.r(doubleExtra) && com.tencent.mm.modelgeo.a.q(d)) {
                                            ami = ExifHelper.ami(Bw2);
                                            if (ami != null) {
                                                d = TencentLocationUtils.distanceBetween((double) ami.cEB, (double) ami.fFz, doubleExtra, d);
                                            } else {
                                                ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. imgPath: %s.", Bw2);
                                            }
                                        } else {
                                            ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. imgPath: %s.", Bw2);
                                        }
                                        str = a.a(j2, d);
                                        if (booleanExtra) {
                                            Bw2 = a.Bw(Bw2);
                                            z = true;
                                        } else {
                                            if (z) {
                                                Bx = a.Bx(Bw2);
                                                if (!Bx.equals(Bw2)) {
                                                    z = true;
                                                    Bw2 = Bx;
                                                }
                                            }
                                            z = false;
                                        }
                                        b Bt = JsApiChooseMultiMedia.Bt(Bw2);
                                        AppBrandLocalMediaObject j3 = AppBrandLocalMediaObjectManager.j(a.this.hPJ.appId, Bw2, z);
                                        if (j3 != null) {
                                            try {
                                                jSONObject = new JSONObject();
                                                jSONObject.put("type", "image");
                                                jSONObject.put("tempFilePath", j3.czD);
                                                jSONObject.put("size", j3.gjQ);
                                                jSONObject.put("width", Bt.width);
                                                jSONObject.put("height", Bt.height);
                                                jSONObject.put("orientation", Bt.hfh);
                                                jSONObject.put("mark", str);
                                                jSONObject.put("scene", FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                                                jSONArray.put(jSONObject);
                                            } catch (Exception e2) {
                                                ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e2, "", new Object[0]);
                                            }
                                        } else {
                                            ab.e("MicroMsg.JsApiChooseMultiMedia", "handle chosen list from gallery, get null obj from path: %s", Bw2);
                                        }
                                    }
                                }
                            }
                            if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
                                for (String Bw22 : stringArrayListExtra2) {
                                    if (!bo.isNullOrNil(Bw22) && new File(Bw22).exists()) {
                                        ab.i("MicroMsg.JsApiChooseMultiMedia", "local video file exist, success");
                                        j = 0;
                                        try {
                                            str = BackwardSupportUtil.amh(Bw22);
                                            if (str != null) {
                                                long time = new SimpleDateFormat("yyyyMMdd'T'hhmmss.SSS'Z'").parse(str).getTime();
                                                Calendar instance = Calendar.getInstance(TimeZone.getDefault());
                                                int i = instance.get(15);
                                                int i2 = instance.get(16);
                                                Calendar instance2 = Calendar.getInstance();
                                                instance2.setTimeInMillis(time);
                                                instance2.add(14, i + i2);
                                                j = instance2.getTimeInMillis() / 1000;
                                                ab.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, videoPath: %s.", Long.valueOf(j), Bw22);
                                            }
                                            j2 = j;
                                        } catch (Exception e3) {
                                            ab.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, videoPath: %s.", Bw22);
                                            j2 = 0;
                                        }
                                        d = -1.0d;
                                        if (com.tencent.mm.modelgeo.a.r(doubleExtra) && com.tencent.mm.modelgeo.a.q(d)) {
                                            ami = BackwardSupportUtil.amg(Bw22);
                                            if (ami != null) {
                                                d = TencentLocationUtils.distanceBetween((double) ami.cEB, (double) ami.fFz, doubleExtra, d);
                                            } else {
                                                ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. videoPath: %s.", Bw22);
                                            }
                                        } else {
                                            ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. videoPath: %s.", Bw22);
                                        }
                                        Bx = a.a(j2, d);
                                        AppBrandLocalVideoObject a = a.a(a.this, Bw22, true);
                                        if (a == null) {
                                            ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail, mVideoFilePath is %s", Bw22);
                                            a.this.hPK.bFZ = -2;
                                            a.a(a.this, a.this.hPK);
                                            AppMethodBeat.o(131230);
                                            return;
                                        }
                                        String By = a.By(Bw22);
                                        Object obj = "";
                                        if (!bo.isNullOrNil(By)) {
                                            obj = a.a(a.this, By);
                                        }
                                        try {
                                            jSONObject = new JSONObject();
                                            jSONObject.put("type", "video");
                                            jSONObject.put("tempFilePath", a.czD);
                                            jSONObject.put("size", a.size);
                                            jSONObject.put("width", a.width);
                                            jSONObject.put("height", a.height);
                                            jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, a.duration);
                                            jSONObject.put("thumbTempFilePath", obj);
                                            jSONObject.put("mark", Bx);
                                            jSONObject.put("scene", FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                                            jSONArray.put(jSONObject);
                                        } catch (Exception e22) {
                                            ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e22, "", new Object[0]);
                                        }
                                    }
                                }
                            }
                            a.this.hPK.bFZ = -1;
                            a.this.hPK.hPI = jSONArray.toString();
                            a.b(a.this, a.this.hPK);
                            AppMethodBeat.o(131230);
                        }
                    });
                    AppMethodBeat.o(131238);
                    return;
                case 2:
                    ab.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                    if (intent == null) {
                        this.hPK.bFZ = 0;
                        a((ProcessResult) this.hPK);
                        AppMethodBeat.o(131238);
                        return;
                    }
                    ab.i("MicroMsg.JsApiChooseMultiMedia", "data is valid!");
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    final String str;
                    if (sightCaptureResult == null) {
                        ab.e("MicroMsg.JsApiChooseMultiMedia", "sight capture result is null!");
                        this.hPK.bFZ = -2;
                        a((ProcessResult) this.hPK);
                        AppMethodBeat.o(131238);
                        return;
                    } else if (sightCaptureResult.osA) {
                        str = sightCaptureResult.osI;
                        if (bo.isNullOrNil(str) || !new File(str).exists()) {
                            ab.e("MicroMsg.JsApiChooseMultiMedia", "picture_picturePath file is not exist! path:%s", str);
                            this.hPK.bFZ = -2;
                            a((ProcessResult) this.hPK);
                            AppMethodBeat.o(131238);
                            return;
                        }
                        ab.i("MicroMsg.JsApiChooseMultiMedia", "filePath:%s", str);
                        final boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", false);
                        aEi();
                        m.aNS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(131231);
                                String Bw = booleanExtra2 ? a.Bw(str) : str;
                                b Bt = JsApiChooseMultiMedia.Bt(Bw);
                                AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.j(a.this.hPJ.appId, Bw, booleanExtra2 | 1);
                                if (j != null) {
                                    long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                                    double d = -1.0d;
                                    if (com.tencent.mm.modelgeo.a.r(doubleExtra) && com.tencent.mm.modelgeo.a.q(d)) {
                                        LatLongData aEl = a.aEl();
                                        if (aEl != null) {
                                            d = TencentLocationUtils.distanceBetween((double) aEl.cEB, (double) aEl.fFz, doubleExtra, d);
                                        } else {
                                            ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. pic_Path: %s.", str);
                                        }
                                    } else {
                                        ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. pic_Path: %s.", str);
                                    }
                                    String a = a.a(timeInMillis, d);
                                    ab.i("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight is done.");
                                    a.this.hPK.bFZ = -1;
                                    a.this.hPK.hPI = a.b(j.czD, j.gjQ, Bt.width, Bt.height, Bt.hfh, a);
                                    a.c(a.this, a.this.hPK);
                                    AppMethodBeat.o(131231);
                                    return;
                                }
                                ab.e("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight camera, get null obj from path: %s", str);
                                a.this.hPK.bFZ = -2;
                                a.d(a.this, a.this.hPK);
                                AppMethodBeat.o(131231);
                            }
                        });
                        AppMethodBeat.o(131238);
                        return;
                    } else {
                        str = sightCaptureResult.osC;
                        if (bo.isNullOrNil(str)) {
                            ab.e("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath is null");
                            this.hPK.bFZ = -2;
                            a((ProcessResult) this.hPK);
                            AppMethodBeat.o(131238);
                            return;
                        }
                        ab.i("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath:%s", str);
                        aEi();
                        m.aNS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(131232);
                                if (new File(str).exists()) {
                                    ab.i("MicroMsg.JsApiChooseMultiMedia", "take media camera, the mVideoFilePath file exist, success");
                                    a.this.hPK.bFZ = -1;
                                    AppBrandLocalVideoObject a = a.a(a.this, str, false);
                                    if (a == null) {
                                        ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail ,mVideoFilePath is %s", str);
                                        a.this.hPK.bFZ = -2;
                                        a.e(a.this, a.this.hPK);
                                        AppMethodBeat.o(131232);
                                        return;
                                    }
                                    String str;
                                    String By = a.By(str);
                                    String str2 = "";
                                    if (bo.isNullOrNil(By)) {
                                        str = str2;
                                    } else {
                                        str = a.a(a.this, By);
                                    }
                                    long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                                    double d = -1.0d;
                                    if (com.tencent.mm.modelgeo.a.r(doubleExtra) && com.tencent.mm.modelgeo.a.q(d)) {
                                        LatLongData aEl = a.aEl();
                                        if (aEl != null) {
                                            d = TencentLocationUtils.distanceBetween((double) aEl.cEB, (double) aEl.fFz, doubleExtra, d);
                                        } else {
                                            ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. video_Path: %s.", str);
                                        }
                                    } else {
                                        ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. video_Path: %s.", str);
                                    }
                                    String a2 = a.a(timeInMillis, d);
                                    a.this.hPK.hPI = a.b(a.czD, (long) a.size, a.width, a.height, a.duration, str, a2);
                                    a.f(a.this, a.this.hPK);
                                    AppMethodBeat.o(131232);
                                    return;
                                }
                                ab.e("MicroMsg.JsApiChooseMultiMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", str);
                                a.this.hPK.bFZ = -2;
                                a.g(a.this, a.this.hPK);
                                AppMethodBeat.o(131232);
                            }
                        });
                        AppMethodBeat.o(131238);
                        return;
                    }
                default:
                    this.hPK.bFZ = -2;
                    a((ProcessResult) this.hPK);
                    AppMethodBeat.o(131238);
                    return;
            }
        }

        private static LatLongData aEk() {
            LatLongData latLongData;
            AppMethodBeat.i(131239);
            String string = ah.getContext().getSharedPreferences(ah.doA() + "_locCache", 0).getString("locStr", null);
            if (string != null) {
                String[] split = string.split(",");
                ab.d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", string, Float.valueOf(((float) Integer.valueOf(split[0]).intValue()) / 1000000.0f), Float.valueOf(((float) Integer.valueOf(split[1]).intValue()) / 1000000.0f));
                latLongData = new LatLongData(r2, r1);
            } else {
                string = (String) g.RP().Ry().get(67591, null);
                if (string != null) {
                    try {
                        String[] split2 = string.split(",");
                        int intValue = Integer.valueOf(split2[0]).intValue();
                        string = 1 == Integer.valueOf(split2[1]).intValue() ? TencentLocation.NETWORK_PROVIDER : "gps";
                        ab.d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", Integer.valueOf(intValue), string, Float.valueOf(((float) Integer.valueOf(split2[2]).intValue()) / 1000000.0f), Float.valueOf(((float) Integer.valueOf(split2[3]).intValue()) / 1000000.0f));
                        latLongData = new LatLongData(r4, r2);
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", e);
                        latLongData = null;
                    }
                } else {
                    ab.i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
                    latLongData = null;
                }
            }
            AppMethodBeat.o(131239);
            return latLongData;
        }

        private void aEi() {
            AppMethodBeat.i(131240);
            this.hPa = new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(131233);
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
                    a.this.hPK.bFZ = 0;
                    a.h(a.this, a.this.hPK);
                    AppMethodBeat.o(131233);
                }
            };
            Context aBQ = aBQ();
            ah.getResources().getString(R.string.tz);
            this.ejZ = h.b(aBQ, ah.getResources().getString(R.string.hc), true, this.hPa);
            AppMethodBeat.o(131240);
        }

        public final void aBX() {
            AppMethodBeat.i(131241);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            AppMethodBeat.o(131241);
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x01c5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static String Bu(String str) {
            Throwable th;
            AppMethodBeat.i(131242);
            int[] iArr = new int[2];
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                Point point;
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                iArr[0] = i;
                iArr[1] = i2;
                VideoTransPara afK = d.afF().afK();
                int i3 = afK.width;
                int i4 = afK.height;
                ab.d("MicroMsg.JsApiChooseMultiMedia", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
                if (i > i3 || i2 > i4) {
                    try {
                        int max = Math.max(i, i2);
                        int min = Math.min(i, i2);
                        int max2 = Math.max(i3, i4);
                        int min2 = Math.min(i3, i4);
                        if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                            max /= 2;
                            min /= 2;
                            if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                                point = new Point();
                                if (i < i2) {
                                    i3 = Math.min(i3, i4);
                                    i4 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) i3)));
                                } else {
                                    i4 = Math.min(i3, i4);
                                    i3 = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i4)));
                                }
                                if (i4 % 2 != 0) {
                                    i4++;
                                }
                                if (i3 % 2 != 0) {
                                    i3++;
                                }
                                ab.i("MicroMsg.JsApiChooseMultiMedia", "calc scale, outputsize: %s %s", Integer.valueOf(i3), Integer.valueOf(i4));
                                point.x = i3;
                                point.y = i4;
                            } else {
                                ab.i("MicroMsg.JsApiChooseMultiMedia", "calc scale, double ratio divide by 16");
                                i3 = i / 2;
                                max = i2 / 2;
                                if (i3 % 2 != 0) {
                                    i4 = i3 + 1;
                                } else {
                                    i4 = i3;
                                }
                                if (max % 2 != 0) {
                                    i3 = max + 1;
                                } else {
                                    i3 = max;
                                }
                                point = new Point(i4, i3);
                            }
                        } else {
                            ab.i("MicroMsg.JsApiChooseMultiMedia", "calc scale, same len divide by 16, no need scale");
                            point = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        AppMethodBeat.o(131242);
                        throw th;
                    }
                }
                ab.i("MicroMsg.JsApiChooseMultiMedia", "calc scale, small or equal to spec size");
                point = null;
                if (point != null) {
                    iArr[0] = point.x;
                    iArr[1] = point.y;
                }
                ab.d("MicroMsg.JsApiChooseMultiMedia", "r.w: %d r.h: %d para.width: %d para.height: %d out.w: %d out.h: %d.", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(afK.width), Integer.valueOf(afK.height), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                mediaMetadataRetriever.release();
                i4 = iArr[0];
                int i5 = iArr[1];
                String str2 = com.tencent.mm.compatible.util.e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                VideoTransPara afK2 = d.afF().afK();
                ab.d("MicroMsg.JsApiChooseMultiMedia", "para.videoBitrate: %d.", Integer.valueOf(afK2.videoBitrate));
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                c.eXz.a(str, str2, i4, i5, afK2.videoBitrate, afK2.fps, new com.tencent.mm.media.g.c.b() {
                    public final void lW(String str) {
                        AppMethodBeat.i(131234);
                        ab.d("MicroMsg.JsApiChooseMultiMedia", "remux onFinish.");
                        countDownLatch.countDown();
                        AppMethodBeat.o(131234);
                    }
                }).Va();
                try {
                    ab.d("MicroMsg.JsApiChooseMultiMedia", "latch await ");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "latch await exception, %s.", e.getMessage());
                }
                AppMethodBeat.o(131242);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                }
                AppMethodBeat.o(131242);
                throw th;
            }
        }

        private AppBrandLocalVideoObject aj(String str, boolean z) {
            MediaMetadataRetriever mediaMetadataRetriever;
            AppMethodBeat.i(131243);
            if (z) {
                try {
                    str = Bu(str);
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", bo.l(e));
                }
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                mediaMetadataRetriever2.setDataSource(str);
                mediaMetadataRetriever = mediaMetadataRetriever2;
            } catch (Exception e2) {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
                AppMethodBeat.o(131243);
                return null;
            }
            int i;
            int i2;
            int i3 = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            int i4 = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            int i5 = bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            if (!"90".equals(mediaMetadataRetriever.extractMetadata(24)) || i3 <= i4) {
                i = i4;
                i2 = i3;
            } else {
                i = i3;
                i2 = i4;
            }
            mediaMetadataRetriever.release();
            AppBrandLocalVideoObject bs = AppBrandLocalMediaObjectManager.bs(this.hPJ.appId, str);
            if (bs == null) {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
                AppMethodBeat.o(131243);
                return null;
            }
            bs.duration = (i5 + 500) / 1000;
            bs.width = i2;
            bs.height = i;
            bs.size = com.tencent.mm.a.e.cs(str);
            ab.i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", bs);
            AppMethodBeat.o(131243);
            return bs;
        }

        private static String Bv(String str) {
            AppMethodBeat.i(131244);
            String str2 = "";
            if (!bo.isNullOrNil(str)) {
                File file = new File(str);
                if (file.exists()) {
                    String name = file.getName();
                    CharSequence charSequence = null;
                    if (!TextUtils.isEmpty(name) && name.contains(".")) {
                        charSequence = name.substring(0, name.lastIndexOf("."));
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        str2 = com.tencent.mm.compatible.util.e.euR + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
                    } else if (com.tencent.mm.compatible.util.e.euR == null || !com.tencent.mm.compatible.util.e.euR.endsWith("/")) {
                        str2 = com.tencent.mm.compatible.util.e.euR + "/" + charSequence + System.currentTimeMillis() + ".jpeg";
                    } else {
                        str2 = com.tencent.mm.compatible.util.e.euR + charSequence + System.currentTimeMillis() + ".jpeg";
                    }
                    if (new File(str2).exists()) {
                        ab.i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", str2);
                    } else {
                        ab.i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", str2);
                        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
                        if (createVideoThumbnail == null) {
                            ab.e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", str2);
                            str2 = "";
                            AppMethodBeat.o(131244);
                            return str2;
                        }
                        try {
                            com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, 80, CompressFormat.JPEG, str2, true);
                        } catch (IOException e) {
                            ab.e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + e.getMessage());
                        }
                    }
                }
            }
            AppMethodBeat.o(131244);
            return str2;
        }

        private static String a(String str, long j, int i, int i2, String str2, String str3) {
            AppMethodBeat.i(131245);
            JSONArray jSONArray = new JSONArray();
            String str4;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "image");
                jSONObject.put("tempFilePath", str);
                jSONObject.put("size", j);
                jSONObject.put("width", i);
                jSONObject.put("height", i2);
                jSONObject.put("orientation", str2);
                jSONObject.put("mark", str3);
                jSONObject.put("scene", "camera");
                jSONArray.put(jSONObject);
                ab.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", jSONArray.toString());
                AppMethodBeat.o(131245);
                return str4;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e, "", new Object[0]);
                str4 = "";
                AppMethodBeat.o(131245);
                return str4;
            }
        }

        private static String a(String str, long j, int i, int i2, int i3, String str2, String str3) {
            AppMethodBeat.i(131246);
            ab.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
            JSONArray jSONArray = new JSONArray();
            String jSONArray2;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "video");
                jSONObject.put("tempFilePath", str);
                jSONObject.put("size", j);
                jSONObject.put("width", i);
                jSONObject.put("height", i2);
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, i3);
                jSONObject.put("thumbTempFilePath", str2);
                jSONObject.put("mark", str3);
                jSONObject.put("scene", "camera");
                jSONArray.put(jSONObject);
                jSONArray2 = jSONArray.toString();
                AppMethodBeat.o(131246);
                return jSONArray2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e, "", new Object[0]);
                jSONArray2 = "";
                AppMethodBeat.o(131246);
                return jSONArray2;
            }
        }

        private static String Bo(String str) {
            Bitmap decodeFile;
            AppMethodBeat.i(131247);
            String str2 = com.tencent.mm.compatible.util.e.euR + "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            try {
                decodeFile = MMBitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e) {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(e3)));
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (Exception e32) {
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(e32)));
                    decodeFile = null;
                }
            } catch (Exception e322) {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(e322)));
                decodeFile = null;
            }
            if (decodeFile == null) {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
                AppMethodBeat.o(131247);
                return null;
            }
            long anU = bo.anU();
            ab.i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", Boolean.valueOf(com.tencent.mm.plugin.appbrand.s.c.cU(str2, str)), Long.valueOf(bo.anU() - anU), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length()));
            if (com.tencent.mm.plugin.appbrand.s.c.cU(str2, str)) {
                AppMethodBeat.o(131247);
                return str2;
            }
            AppMethodBeat.o(131247);
            return str;
        }

        private static String Bn(String str) {
            AppMethodBeat.i(131248);
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree != 0) {
                orientationInDegree %= v2helper.VOIP_ENC_HEIGHT_LV1;
                try {
                    Options options = new Options();
                    Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                    if (decodeFile == null) {
                        ab.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
                        AppMethodBeat.o(131248);
                        return str;
                    }
                    Bitmap b = com.tencent.mm.sdk.platformtools.d.b(decodeFile, (float) orientationInDegree);
                    String str2 = com.tencent.mm.compatible.util.e.euR + "microMsg.tmp." + System.currentTimeMillis() + (com.tencent.mm.plugin.appbrand.s.c.e(options) ? FileUtils.PIC_POSTFIX_JPEG : ".png");
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(b, 80, com.tencent.mm.plugin.appbrand.s.c.e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                        if (com.tencent.mm.plugin.appbrand.s.c.e(options)) {
                            com.tencent.mm.plugin.appbrand.g.b.bY(str, str2);
                        }
                        AppMethodBeat.o(131248);
                        return str2;
                    } catch (Exception e) {
                        ab.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", e);
                        com.tencent.mm.a.e.deleteFile(str2);
                        AppMethodBeat.o(131248);
                        return str;
                    }
                } catch (OutOfMemoryError e2) {
                    AppMethodBeat.o(131248);
                    return str;
                } catch (NullPointerException e3) {
                    AppMethodBeat.o(131248);
                    return str;
                }
            }
            AppMethodBeat.o(131248);
            return str;
        }
    }

    static final class b {
        public int height;
        public String hfh;
        public int width;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(131268);
        AppMethodBeat.o(131268);
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131266);
        if (com.tencent.mm.plugin.appbrand.n.xa(cVar.getAppId()).gPk) {
            cVar.M(i, j("cancel", null));
            AppMethodBeat.o(131266);
            return;
        }
        final Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131266);
        } else if (jSONObject == null) {
            ab.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(131266);
        } else {
            int optInt = jSONObject.optInt("maxDuration", 10);
            ab.i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", Integer.valueOf(optInt));
            if (optInt <= 0 || optInt > 30) {
                ab.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
                cVar.M(i, j("fail:invalid maxDuration parameter", null));
                AppMethodBeat.o(131266);
                return;
            }
            boolean z;
            boolean z2;
            boolean contains;
            final com.tencent.mm.plugin.appbrand.jsapi.c cVar2;
            context.getSharedPreferences(ah.doA() + "_locCache", 0).edit().putString("locStr", null).apply();
            ((com.tencent.mm.plugin.appbrand.s.b.a) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).b("wgs84", new com.tencent.mm.plugin.appbrand.s.b.a.b() {
                public final void a(int i, String str, com.tencent.mm.plugin.appbrand.s.b.a.a aVar) {
                    AppMethodBeat.i(131217);
                    if (i == 0) {
                        int i2 = (int) (aVar.latitude * 1000000.0d);
                        int i3 = (int) (aVar.longitude * 1000000.0d);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(i2);
                        stringBuilder.append(",");
                        stringBuilder.append(i3);
                        context.getSharedPreferences(ah.doA() + "_locCache", 0).edit().putString("locStr", stringBuilder.toString()).apply();
                        ab.d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude), stringBuilder);
                        ((com.tencent.mm.plugin.appbrand.s.b.a) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).c("wgs84", this, null);
                        AppMethodBeat.o(131217);
                        return;
                    }
                    ab.e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", Integer.valueOf(i));
                    AppMethodBeat.o(131217);
                }
            }, null);
            int optInt2 = jSONObject.optInt("count", 9);
            double optDouble = jSONObject.optJSONObject(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION).optDouble("longitude", 91.0d);
            double optDouble2 = jSONObject.optJSONObject(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION).optDouble("latitude", 181.0d);
            String optString = jSONObject.optString("poiName", hPC);
            double optDouble3 = jSONObject.optDouble("locationRadius", 50.0d);
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                z = true;
                z2 = true;
            } else {
                contains = optJSONArray.toString().contains("camera");
                z = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                z2 = contains;
            }
            if (z2) {
                cVar2 = cVar;
                final JSONObject jSONObject2 = jSONObject;
                final int i2 = i;
                com.tencent.mm.plugin.appbrand.permission.n.b(cVar.getAppId(), new android.support.v4.app.a.a() {
                    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                        AppMethodBeat.i(131220);
                        if (i != 113) {
                            AppMethodBeat.o(131220);
                        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            cVar2.M(i2, JsApiChooseMultiMedia.this.j("fail:system permission denied", null));
                            AppMethodBeat.o(131220);
                        } else {
                            JsApiChooseMultiMedia.this.a(cVar2, jSONObject2, i2);
                            AppMethodBeat.o(131220);
                        }
                    }
                });
                Context context2 = cVar.getContext();
                if (context2 == null || !(context2 instanceof Activity)) {
                    cVar.M(i, j("fail", null));
                    contains = false;
                } else {
                    contains = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.CAMERA", 113, "", "");
                    if (contains) {
                        com.tencent.mm.plugin.appbrand.permission.n.Dr(cVar.getAppId());
                    }
                }
                if (!contains) {
                    AppMethodBeat.o(131266);
                    return;
                }
            }
            com.tencent.mm.plugin.appbrand.n.xb(cVar.getAppId()).gPk = true;
            cVar2 = cVar;
            com.tencent.mm.plugin.appbrand.g.a(cVar.getAppId(), new com.tencent.mm.plugin.appbrand.g.c() {
                public final void onResume() {
                    AppMethodBeat.i(131218);
                    com.tencent.mm.plugin.appbrand.n.xb(cVar2.getAppId()).gPk = false;
                    com.tencent.mm.plugin.appbrand.g.b(cVar2.getAppId(), this);
                    AppMethodBeat.o(131218);
                }
            });
            ChooseRequest chooseRequest = new ChooseRequest();
            chooseRequest.appId = cVar.getAppId();
            chooseRequest.count = optInt2;
            double[] f = com.tencent.mm.modelgeo.a.a.f(optDouble, optDouble2);
            this.hPE = optDouble;
            this.hPD = optDouble2;
            this.hPG = f[0];
            this.hPF = f[1];
            chooseRequest.longitude = this.hPG;
            chooseRequest.latitude = this.hPF;
            chooseRequest.eUu = optString;
            chooseRequest.fNN = optDouble3;
            chooseRequest.hOS = z2;
            chooseRequest.hOT = z;
            chooseRequest.gLP = optInt;
            cVar2 = cVar;
            final int i3 = i;
            com.tencent.mm.plugin.appbrand.ipc.a.a(context, chooseRequest, new com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b<ChooseResult>() {
                public final /* synthetic */ void c(ProcessResult processResult) {
                    AppMethodBeat.i(131219);
                    ChooseResult chooseResult = (ChooseResult) processResult;
                    if (chooseResult == null) {
                        cVar2.M(i3, JsApiChooseMultiMedia.this.j("fail", null));
                        AppMethodBeat.o(131219);
                        return;
                    }
                    switch (chooseResult.bFZ) {
                        case -1:
                            HashMap hashMap = new HashMap();
                            try {
                                hashMap.put("tempFiles", new JSONArray(chooseResult.hPI));
                            } catch (Exception e) {
                                ab.e("MicroMsg.JsApiChooseMultiMedia", "err tempFiles json object create");
                            }
                            cVar2.M(i3, JsApiChooseMultiMedia.this.j("ok", hashMap));
                            AppMethodBeat.o(131219);
                            return;
                        case 0:
                            cVar2.M(i3, JsApiChooseMultiMedia.this.j("cancel", null));
                            AppMethodBeat.o(131219);
                            return;
                        default:
                            cVar2.M(i3, JsApiChooseMultiMedia.this.j("fail", null));
                            AppMethodBeat.o(131219);
                            return;
                    }
                }
            });
            AppMethodBeat.o(131266);
        }
    }

    static /* synthetic */ b Bt(String str) {
        AppMethodBeat.i(131267);
        b bVar = new b();
        if (!bo.isNullOrNil(str)) {
            File file = new File(str);
            if (file.exists()) {
                String fO;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                bVar.width = options.outWidth;
                bVar.height = options.outHeight;
                if (com.tencent.mm.plugin.appbrand.s.c.e(options)) {
                    fO = com.tencent.luggage.e.a.a.fO(com.tencent.luggage.e.a.a.bJ(file.getAbsolutePath()));
                } else {
                    fO = "up";
                }
                bVar.hfh = fO;
            }
        }
        AppMethodBeat.o(131267);
        return bVar;
    }
}
