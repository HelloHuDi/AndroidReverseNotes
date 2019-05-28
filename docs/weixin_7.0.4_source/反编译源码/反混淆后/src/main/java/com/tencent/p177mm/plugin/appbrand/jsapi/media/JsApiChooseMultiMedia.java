package com.tencent.p177mm.plugin.appbrand.jsapi.media;

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
import android.support.p057v4.app.C6184a.C0315a;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p1589e.p1590a.C41710a;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.media.p254g.C37894c;
import com.tencent.p177mm.media.p254g.C37894c.C37895b;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelgeo.C42205a;
import com.tencent.p177mm.modelgeo.C42205a.C18656a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p290g.C2154b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C38507c;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C19712a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C2459b;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia */
public final class JsApiChooseMultiMedia extends C10296a {
    public static final int CTRL_INDEX = 549;
    public static final String NAME = "chooseMultiMedia";
    public static final String hPC = C4996ah.getResources().getString(C25738R.string.f9292vq);
    double hPD;
    double hPE;
    double hPF;
    double hPG;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia$ChooseResult */
    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new C270321();
        int bFZ;
        String hPI;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia$ChooseResult$1 */
        static class C270321 implements Creator<ChooseResult> {
            C270321() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131226);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.m2505o(131226);
                return chooseResult;
            }
        }

        /* renamed from: k */
        public final void mo6045k(Parcel parcel) {
            AppMethodBeat.m2504i(131227);
            this.bFZ = parcel.readInt();
            this.hPI = parcel.readString();
            AppMethodBeat.m2505o(131227);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131228);
            parcel.writeInt(this.bFZ);
            parcel.writeString(this.hPI);
            AppMethodBeat.m2505o(131228);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.m2504i(131229);
            AppMethodBeat.m2505o(131229);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia$ChooseRequest */
    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new C333591();
        String appId;
        int count;
        String eUu;
        double fNN;
        int gLP;
        boolean hOS;
        boolean hOT;
        double latitude;
        double longitude;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia$ChooseRequest$1 */
        static class C333591 implements Creator<ChooseRequest> {
            C333591() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131221);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.m2505o(131221);
                return chooseRequest;
            }
        }

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return C33360a.class;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(131222);
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
            AppMethodBeat.m2505o(131222);
        }

        /* renamed from: k */
        public final void mo6049k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(131223);
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
            AppMethodBeat.m2505o(131223);
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
            AppMethodBeat.m2504i(131224);
            mo6049k(parcel);
            AppMethodBeat.m2505o(131224);
        }

        static {
            AppMethodBeat.m2504i(131225);
            AppMethodBeat.m2505o(131225);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia$a */
    static final class C33360a extends AppBrandProxyUIProcessTask {
        private C44275p ejZ;
        int hOZ = 7;
        ChooseRequest hPJ;
        ChooseResult hPK = new ChooseResult();
        private OnCancelListener hPa;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia$a$4 */
        class C270334 implements OnCancelListener {
            C270334() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(131233);
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
                C33360a.this.hPK.bFZ = 0;
                C33360a.m54553h(C33360a.this, C33360a.this.hPK);
                AppMethodBeat.m2505o(131233);
            }
        }

        private C33360a() {
            AppMethodBeat.m2504i(131235);
            AppMethodBeat.m2505o(131235);
        }

        /* renamed from: Bw */
        static /* synthetic */ String m54535Bw(String str) {
            AppMethodBeat.m2504i(131250);
            String Bo = C33360a.m54532Bo(str);
            AppMethodBeat.m2505o(131250);
            return Bo;
        }

        /* renamed from: Bx */
        static /* synthetic */ String m54536Bx(String str) {
            AppMethodBeat.m2504i(131251);
            String Bn = C33360a.m54531Bn(str);
            AppMethodBeat.m2505o(131251);
            return Bn;
        }

        /* renamed from: By */
        static /* synthetic */ String m54537By(String str) {
            AppMethodBeat.m2504i(131254);
            String Bv = C33360a.m54534Bv(str);
            AppMethodBeat.m2505o(131254);
            return Bv;
        }

        /* renamed from: a */
        static /* synthetic */ AppBrandLocalVideoObject m54538a(C33360a c33360a, String str, boolean z) {
            AppMethodBeat.m2504i(131252);
            AppBrandLocalVideoObject aj = c33360a.m54544aj(str, z);
            AppMethodBeat.m2505o(131252);
            return aj;
        }

        static /* synthetic */ LatLongData aEl() {
            AppMethodBeat.m2504i(131257);
            LatLongData aEk = C33360a.aEk();
            AppMethodBeat.m2505o(131257);
            return aEk;
        }

        /* renamed from: b */
        static /* synthetic */ String m54545b(String str, long j, int i, int i2, int i3, String str2, String str3) {
            AppMethodBeat.m2504i(131262);
            String a = C33360a.m54541a(str, j, i, i2, i3, str2, str3);
            AppMethodBeat.m2505o(131262);
            return a;
        }

        /* renamed from: b */
        static /* synthetic */ String m54546b(String str, long j, int i, int i2, String str2, String str3) {
            AppMethodBeat.m2504i(131258);
            String a = C33360a.m54542a(str, j, i, i2, str2, str3);
            AppMethodBeat.m2505o(131258);
            return a;
        }

        /* renamed from: b */
        static /* synthetic */ void m54547b(C33360a c33360a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131256);
            c33360a.mo34449a(processResult);
            AppMethodBeat.m2505o(131256);
        }

        /* renamed from: c */
        static /* synthetic */ void m54548c(C33360a c33360a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131259);
            c33360a.mo34449a(processResult);
            AppMethodBeat.m2505o(131259);
        }

        /* renamed from: d */
        static /* synthetic */ void m54549d(C33360a c33360a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131260);
            c33360a.mo34449a(processResult);
            AppMethodBeat.m2505o(131260);
        }

        /* renamed from: e */
        static /* synthetic */ void m54550e(C33360a c33360a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131261);
            c33360a.mo34449a(processResult);
            AppMethodBeat.m2505o(131261);
        }

        /* renamed from: f */
        static /* synthetic */ void m54551f(C33360a c33360a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131263);
            c33360a.mo34449a(processResult);
            AppMethodBeat.m2505o(131263);
        }

        /* renamed from: g */
        static /* synthetic */ void m54552g(C33360a c33360a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131264);
            c33360a.mo34449a(processResult);
            AppMethodBeat.m2505o(131264);
        }

        /* renamed from: h */
        static /* synthetic */ void m54553h(C33360a c33360a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131265);
            c33360a.mo34449a(processResult);
            AppMethodBeat.m2505o(131265);
        }

        /* renamed from: a */
        public final void mo6047a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.m2504i(131236);
            this.hPJ = (ChooseRequest) processRequest;
            if (C5046bo.m7553gO(aBQ()) > 200) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                C23639t.makeText(aBQ(), C4996ah.getResources().getString(C25738R.string.f8857ha), 1).show();
            }
            aBQ().ifE = this;
            Intent aEj;
            if (this.hPJ.hOS && this.hPJ.hOT) {
                C14987n.m23296a(aBQ(), 1, this.hPJ.count, this.hOZ, aEj());
                AppMethodBeat.m2505o(131236);
            } else if (this.hPJ.hOT) {
                aEj = aEj();
                aEj.putExtra("show_header_view", false);
                C14987n.m23296a(aBQ(), 1, this.hPJ.count, this.hOZ, aEj);
                AppMethodBeat.m2505o(131236);
            } else if (this.hPJ.hOS) {
                aEj = new Intent();
                aEj.putExtra("album_business_bubble_media_by_coordinate_latitude", this.hPJ.latitude);
                aEj.putExtra("album_business_bubble_media_by_coordinate_longitude", this.hPJ.longitude);
                SightParams sightParams = new SightParams(7, 1);
                sightParams.mode = 0;
                sightParams.fcY.duration = this.hPJ.gLP;
                aEj.putExtra("KEY_SIGHT_PARAMS", sightParams);
                C14987n.m23302a(aBQ(), 2, aEj, 7, 0);
                AppMethodBeat.m2505o(131236);
            } else {
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
                this.hPK.bFZ = -2;
                mo34449a((ProcessResult) this.hPK);
                AppMethodBeat.m2505o(131236);
            }
        }

        private Intent aEj() {
            AppMethodBeat.m2504i(131237);
            Intent intent = new Intent();
            intent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
            intent.putExtra("album_video_max_duration", this.hPJ.gLP);
            intent.putExtra("album_business_bubble_media_by_coordinate_distance", this.hPJ.fNN);
            intent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.hPJ.latitude);
            intent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.hPJ.longitude);
            intent.putExtra("album_business_bubble_media_by_coordinate_posname", this.hPJ.eUu);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("send_btn_string", C4996ah.getResources().getString(C25738R.string.f9182s1));
            AppMethodBeat.m2505o(131237);
            return intent;
        }

        /* JADX WARNING: Missing block: B:24:0x00c6, code skipped:
            if (r0 == false) goto L_0x00dc;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            double d = 91.0d;
            boolean z = true;
            AppMethodBeat.m2504i(131238);
            if (i2 == 0) {
                this.hPK.bFZ = 0;
                mo34449a((ProcessResult) this.hPK);
                AppMethodBeat.m2505o(131238);
                return;
            }
            if (intent != null) {
                d = intent.getDoubleExtra("longitude", 91.0d);
            }
            final double doubleExtra = intent != null ? intent.getDoubleExtra("latitude", 181.0d) : 181.0d;
            C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "longitude: %f, latitude: %f.", Double.valueOf(d), Double.valueOf(doubleExtra));
            C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "requestCode: %d.", Integer.valueOf(i));
            switch (i) {
                case 1:
                    C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_GALLERY");
                    if (intent == null) {
                        this.hPK.bFZ = 0;
                        mo34449a((ProcessResult) this.hPK);
                        AppMethodBeat.m2505o(131238);
                        return;
                    }
                    final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                    final boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                    aEi();
                    if (!booleanExtra) {
                        boolean z2;
                        if (!C5046bo.m7548ek(stringArrayListExtra)) {
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
                    C45673m.aNS().mo10302aa(new Runnable() {
                        public final void run() {
                            String Bw;
                            long j;
                            String str;
                            long j2;
                            double d;
                            LatLongData ami;
                            String Bx;
                            JSONObject jSONObject;
                            AppMethodBeat.m2504i(131230);
                            JSONArray jSONArray = new JSONArray();
                            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                                for (String Bw2 : stringArrayListExtra) {
                                    if (!C5046bo.isNullOrNil(Bw2) && new File(Bw2).exists()) {
                                        boolean z;
                                        C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "local img file exist, success");
                                        j = 0;
                                        try {
                                            if (C5046bo.isNullOrNil(Bw2)) {
                                                C4990ab.m7410d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                                                str = null;
                                            } else if (C5730e.m8628ct(Bw2)) {
                                                str = Exif.fromFile(Bw2).dateTime;
                                            } else {
                                                C4990ab.m7411d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", Bw2);
                                                str = null;
                                            }
                                            if (str != null) {
                                                j = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(str).getTime() / 1000;
                                                C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, imgPath: %s.", Long.valueOf(j), Bw2);
                                            }
                                            j2 = j;
                                        } catch (Exception e) {
                                            C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, imgPath: %s.", Bw2);
                                            j2 = 0;
                                        }
                                        d = -1.0d;
                                        if (C42205a.m74464r(doubleExtra) && C42205a.m74463q(d)) {
                                            ami = ExifHelper.ami(Bw2);
                                            if (ami != null) {
                                                d = TencentLocationUtils.distanceBetween((double) ami.cEB, (double) ami.fFz, doubleExtra, d);
                                            } else {
                                                C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. imgPath: %s.", Bw2);
                                            }
                                        } else {
                                            C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. imgPath: %s.", Bw2);
                                        }
                                        str = C33360a.m54539a(j2, d);
                                        if (booleanExtra) {
                                            Bw2 = C33360a.m54535Bw(Bw2);
                                            z = true;
                                        } else {
                                            if (z) {
                                                Bx = C33360a.m54536Bx(Bw2);
                                                if (!Bx.equals(Bw2)) {
                                                    z = true;
                                                    Bw2 = Bx;
                                                }
                                            }
                                            z = false;
                                        }
                                        C33364b Bt = JsApiChooseMultiMedia.m54528Bt(Bw2);
                                        AppBrandLocalMediaObject j3 = AppBrandLocalMediaObjectManager.m29651j(C33360a.this.hPJ.appId, Bw2, z);
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
                                                C4990ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e2, "", new Object[0]);
                                            }
                                        } else {
                                            C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "handle chosen list from gallery, get null obj from path: %s", Bw2);
                                        }
                                    }
                                }
                            }
                            if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
                                for (String Bw22 : stringArrayListExtra2) {
                                    if (!C5046bo.isNullOrNil(Bw22) && new File(Bw22).exists()) {
                                        C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "local video file exist, success");
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
                                                C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, videoPath: %s.", Long.valueOf(j), Bw22);
                                            }
                                            j2 = j;
                                        } catch (Exception e3) {
                                            C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, videoPath: %s.", Bw22);
                                            j2 = 0;
                                        }
                                        d = -1.0d;
                                        if (C42205a.m74464r(doubleExtra) && C42205a.m74463q(d)) {
                                            ami = BackwardSupportUtil.amg(Bw22);
                                            if (ami != null) {
                                                d = TencentLocationUtils.distanceBetween((double) ami.cEB, (double) ami.fFz, doubleExtra, d);
                                            } else {
                                                C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. videoPath: %s.", Bw22);
                                            }
                                        } else {
                                            C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. videoPath: %s.", Bw22);
                                        }
                                        Bx = C33360a.m54539a(j2, d);
                                        AppBrandLocalVideoObject a = C33360a.m54538a(C33360a.this, Bw22, true);
                                        if (a == null) {
                                            C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail, mVideoFilePath is %s", Bw22);
                                            C33360a.this.hPK.bFZ = -2;
                                            C33360a.m54543a(C33360a.this, C33360a.this.hPK);
                                            AppMethodBeat.m2505o(131230);
                                            return;
                                        }
                                        String By = C33360a.m54537By(Bw22);
                                        Object obj = "";
                                        if (!C5046bo.isNullOrNil(By)) {
                                            obj = C33360a.m54540a(C33360a.this, By);
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
                                            C4990ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e22, "", new Object[0]);
                                        }
                                    }
                                }
                            }
                            C33360a.this.hPK.bFZ = -1;
                            C33360a.this.hPK.hPI = jSONArray.toString();
                            C33360a.m54547b(C33360a.this, C33360a.this.hPK);
                            AppMethodBeat.m2505o(131230);
                        }
                    });
                    AppMethodBeat.m2505o(131238);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                    if (intent == null) {
                        this.hPK.bFZ = 0;
                        mo34449a((ProcessResult) this.hPK);
                        AppMethodBeat.m2505o(131238);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "data is valid!");
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    final String str;
                    if (sightCaptureResult == null) {
                        C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "sight capture result is null!");
                        this.hPK.bFZ = -2;
                        mo34449a((ProcessResult) this.hPK);
                        AppMethodBeat.m2505o(131238);
                        return;
                    } else if (sightCaptureResult.osA) {
                        str = sightCaptureResult.osI;
                        if (C5046bo.isNullOrNil(str) || !new File(str).exists()) {
                            C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "picture_picturePath file is not exist! path:%s", str);
                            this.hPK.bFZ = -2;
                            mo34449a((ProcessResult) this.hPK);
                            AppMethodBeat.m2505o(131238);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "filePath:%s", str);
                        final boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", false);
                        aEi();
                        C45673m.aNS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(131231);
                                String Bw = booleanExtra2 ? C33360a.m54535Bw(str) : str;
                                C33364b Bt = JsApiChooseMultiMedia.m54528Bt(Bw);
                                AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.m29651j(C33360a.this.hPJ.appId, Bw, booleanExtra2 | 1);
                                if (j != null) {
                                    long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                                    double d = -1.0d;
                                    if (C42205a.m74464r(doubleExtra) && C42205a.m74463q(d)) {
                                        LatLongData aEl = C33360a.aEl();
                                        if (aEl != null) {
                                            d = TencentLocationUtils.distanceBetween((double) aEl.cEB, (double) aEl.fFz, doubleExtra, d);
                                        } else {
                                            C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. pic_Path: %s.", str);
                                        }
                                    } else {
                                        C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. pic_Path: %s.", str);
                                    }
                                    String a = C33360a.m54539a(timeInMillis, d);
                                    C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight is done.");
                                    C33360a.this.hPK.bFZ = -1;
                                    C33360a.this.hPK.hPI = C33360a.m54546b(j.czD, j.gjQ, Bt.width, Bt.height, Bt.hfh, a);
                                    C33360a.m54548c(C33360a.this, C33360a.this.hPK);
                                    AppMethodBeat.m2505o(131231);
                                    return;
                                }
                                C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight camera, get null obj from path: %s", str);
                                C33360a.this.hPK.bFZ = -2;
                                C33360a.m54549d(C33360a.this, C33360a.this.hPK);
                                AppMethodBeat.m2505o(131231);
                            }
                        });
                        AppMethodBeat.m2505o(131238);
                        return;
                    } else {
                        str = sightCaptureResult.osC;
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath is null");
                            this.hPK.bFZ = -2;
                            mo34449a((ProcessResult) this.hPK);
                            AppMethodBeat.m2505o(131238);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath:%s", str);
                        aEi();
                        C45673m.aNS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(131232);
                                if (new File(str).exists()) {
                                    C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "take media camera, the mVideoFilePath file exist, success");
                                    C33360a.this.hPK.bFZ = -1;
                                    AppBrandLocalVideoObject a = C33360a.m54538a(C33360a.this, str, false);
                                    if (a == null) {
                                        C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail ,mVideoFilePath is %s", str);
                                        C33360a.this.hPK.bFZ = -2;
                                        C33360a.m54550e(C33360a.this, C33360a.this.hPK);
                                        AppMethodBeat.m2505o(131232);
                                        return;
                                    }
                                    String str;
                                    String By = C33360a.m54537By(str);
                                    String str2 = "";
                                    if (C5046bo.isNullOrNil(By)) {
                                        str = str2;
                                    } else {
                                        str = C33360a.m54540a(C33360a.this, By);
                                    }
                                    long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                                    double d = -1.0d;
                                    if (C42205a.m74464r(doubleExtra) && C42205a.m74463q(d)) {
                                        LatLongData aEl = C33360a.aEl();
                                        if (aEl != null) {
                                            d = TencentLocationUtils.distanceBetween((double) aEl.cEB, (double) aEl.fFz, doubleExtra, d);
                                        } else {
                                            C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. video_Path: %s.", str);
                                        }
                                    } else {
                                        C4990ab.m7421w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. video_Path: %s.", str);
                                    }
                                    String a2 = C33360a.m54539a(timeInMillis, d);
                                    C33360a.this.hPK.hPI = C33360a.m54545b(a.czD, (long) a.size, a.width, a.height, a.duration, str, a2);
                                    C33360a.m54551f(C33360a.this, C33360a.this.hPK);
                                    AppMethodBeat.m2505o(131232);
                                    return;
                                }
                                C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", str);
                                C33360a.this.hPK.bFZ = -2;
                                C33360a.m54552g(C33360a.this, C33360a.this.hPK);
                                AppMethodBeat.m2505o(131232);
                            }
                        });
                        AppMethodBeat.m2505o(131238);
                        return;
                    }
                default:
                    this.hPK.bFZ = -2;
                    mo34449a((ProcessResult) this.hPK);
                    AppMethodBeat.m2505o(131238);
                    return;
            }
        }

        private static LatLongData aEk() {
            LatLongData latLongData;
            AppMethodBeat.m2504i(131239);
            String string = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_locCache", 0).getString("locStr", null);
            if (string != null) {
                String[] split = string.split(",");
                C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", string, Float.valueOf(((float) Integer.valueOf(split[0]).intValue()) / 1000000.0f), Float.valueOf(((float) Integer.valueOf(split[1]).intValue()) / 1000000.0f));
                latLongData = new LatLongData(r2, r1);
            } else {
                string = (String) C1720g.m3536RP().mo5239Ry().get(67591, null);
                if (string != null) {
                    try {
                        String[] split2 = string.split(",");
                        int intValue = Integer.valueOf(split2[0]).intValue();
                        string = 1 == Integer.valueOf(split2[1]).intValue() ? TencentLocation.NETWORK_PROVIDER : "gps";
                        C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", Integer.valueOf(intValue), string, Float.valueOf(((float) Integer.valueOf(split2[2]).intValue()) / 1000000.0f), Float.valueOf(((float) Integer.valueOf(split2[3]).intValue()) / 1000000.0f));
                        latLongData = new LatLongData(r4, r2);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", e);
                        latLongData = null;
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
                    C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
                    latLongData = null;
                }
            }
            AppMethodBeat.m2505o(131239);
            return latLongData;
        }

        private void aEi() {
            AppMethodBeat.m2504i(131240);
            this.hPa = new C270334();
            Context aBQ = aBQ();
            C4996ah.getResources().getString(C25738R.string.f9238tz);
            this.ejZ = C30379h.m48458b(aBQ, C4996ah.getResources().getString(C25738R.string.f8859hc), true, this.hPa);
            AppMethodBeat.m2505o(131240);
        }

        public final void aBX() {
            AppMethodBeat.m2504i(131241);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            AppMethodBeat.m2505o(131241);
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x01c5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: Bu */
        private static String m54533Bu(String str) {
            Throwable th;
            AppMethodBeat.m2504i(131242);
            int[] iArr = new int[2];
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                Point point;
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                iArr[0] = i;
                iArr[1] = i2;
                VideoTransPara afK = C42204d.afF().afK();
                int i3 = afK.width;
                int i4 = afK.height;
                C4990ab.m7410d("MicroMsg.JsApiChooseMultiMedia", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
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
                                C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "calc scale, outputsize: %s %s", Integer.valueOf(i3), Integer.valueOf(i4));
                                point.x = i3;
                                point.y = i4;
                            } else {
                                C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "calc scale, double ratio divide by 16");
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
                            C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "calc scale, same len divide by 16, no need scale");
                            point = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        AppMethodBeat.m2505o(131242);
                        throw th;
                    }
                }
                C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "calc scale, small or equal to spec size");
                point = null;
                if (point != null) {
                    iArr[0] = point.x;
                    iArr[1] = point.y;
                }
                C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "r.w: %d r.h: %d para.width: %d para.height: %d out.w: %d out.h: %d.", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(afK.width), Integer.valueOf(afK.height), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                mediaMetadataRetriever.release();
                i4 = iArr[0];
                int i5 = iArr[1];
                String str2 = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                VideoTransPara afK2 = C42204d.afF().afK();
                C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "para.videoBitrate: %d.", Integer.valueOf(afK2.videoBitrate));
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                C37894c.eXz.mo20921a(str, str2, i4, i5, afK2.videoBitrate, afK2.fps, new C37895b() {
                    /* renamed from: lW */
                    public final void mo21981lW(String str) {
                        AppMethodBeat.m2504i(131234);
                        C4990ab.m7410d("MicroMsg.JsApiChooseMultiMedia", "remux onFinish.");
                        countDownLatch.countDown();
                        AppMethodBeat.m2505o(131234);
                    }
                }).mo53305Va();
                try {
                    C4990ab.m7410d("MicroMsg.JsApiChooseMultiMedia", "latch await ");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "latch await exception, %s.", e.getMessage());
                }
                AppMethodBeat.m2505o(131242);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                }
                AppMethodBeat.m2505o(131242);
                throw th;
            }
        }

        /* renamed from: aj */
        private AppBrandLocalVideoObject m54544aj(String str, boolean z) {
            MediaMetadataRetriever mediaMetadataRetriever;
            AppMethodBeat.m2504i(131243);
            if (z) {
                try {
                    str = C33360a.m54533Bu(str);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", C5046bo.m7574l(e));
                }
            }
            try {
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                mediaMetadataRetriever2.setDataSource(str);
                mediaMetadataRetriever = mediaMetadataRetriever2;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
                AppMethodBeat.m2505o(131243);
                return null;
            }
            int i;
            int i2;
            int i3 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            int i4 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            int i5 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            if (!"90".equals(mediaMetadataRetriever.extractMetadata(24)) || i3 <= i4) {
                i = i4;
                i2 = i3;
            } else {
                i = i3;
                i2 = i4;
            }
            mediaMetadataRetriever.release();
            AppBrandLocalVideoObject bs = AppBrandLocalMediaObjectManager.m29646bs(this.hPJ.appId, str);
            if (bs == null) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
                AppMethodBeat.m2505o(131243);
                return null;
            }
            bs.duration = (i5 + 500) / 1000;
            bs.width = i2;
            bs.height = i;
            bs.size = C1173e.m2560cs(str);
            C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", bs);
            AppMethodBeat.m2505o(131243);
            return bs;
        }

        /* renamed from: Bv */
        private static String m54534Bv(String str) {
            AppMethodBeat.m2504i(131244);
            String str2 = "";
            if (!C5046bo.isNullOrNil(str)) {
                File file = new File(str);
                if (file.exists()) {
                    String name = file.getName();
                    CharSequence charSequence = null;
                    if (!TextUtils.isEmpty(name) && name.contains(".")) {
                        charSequence = name.substring(0, name.lastIndexOf("."));
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        str2 = C6457e.euR + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
                    } else if (C6457e.euR == null || !C6457e.euR.endsWith("/")) {
                        str2 = C6457e.euR + "/" + charSequence + System.currentTimeMillis() + ".jpeg";
                    } else {
                        str2 = C6457e.euR + charSequence + System.currentTimeMillis() + ".jpeg";
                    }
                    if (new File(str2).exists()) {
                        C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", str2);
                    } else {
                        C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", str2);
                        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
                        if (createVideoThumbnail == null) {
                            C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", str2);
                            str2 = "";
                            AppMethodBeat.m2505o(131244);
                            return str2;
                        }
                        try {
                            C5056d.m7625a(createVideoThumbnail, 80, CompressFormat.JPEG, str2, true);
                        } catch (IOException e) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + e.getMessage());
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(131244);
            return str2;
        }

        /* renamed from: a */
        private static String m54542a(String str, long j, int i, int i2, String str2, String str3) {
            AppMethodBeat.m2504i(131245);
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
                C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", jSONArray.toString());
                AppMethodBeat.m2505o(131245);
                return str4;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e, "", new Object[0]);
                str4 = "";
                AppMethodBeat.m2505o(131245);
                return str4;
            }
        }

        /* renamed from: a */
        private static String m54541a(String str, long j, int i, int i2, int i3, String str2, String str3) {
            AppMethodBeat.m2504i(131246);
            C4990ab.m7416i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
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
                AppMethodBeat.m2505o(131246);
                return jSONArray2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e, "", new Object[0]);
                jSONArray2 = "";
                AppMethodBeat.m2505o(131246);
                return jSONArray2;
            }
        }

        /* renamed from: Bo */
        private static String m54532Bo(String str) {
            Bitmap decodeFile;
            AppMethodBeat.m2504i(131247);
            String str2 = C6457e.euR + "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            try {
                decodeFile = MMBitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = C5056d.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(e3)));
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = C5056d.decodeFile(str, null);
                } catch (Exception e32) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(e32)));
                    decodeFile = null;
                }
            } catch (Exception e322) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(e322)));
                decodeFile = null;
            }
            if (decodeFile == null) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
                AppMethodBeat.m2505o(131247);
                return null;
            }
            long anU = C5046bo.anU();
            C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", Boolean.valueOf(C38507c.m65172cU(str2, str)), Long.valueOf(C5046bo.anU() - anU), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length()));
            if (C38507c.m65172cU(str2, str)) {
                AppMethodBeat.m2505o(131247);
                return str2;
            }
            AppMethodBeat.m2505o(131247);
            return str;
        }

        /* renamed from: Bn */
        private static String m54531Bn(String str) {
            AppMethodBeat.m2504i(131248);
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree != 0) {
                orientationInDegree %= v2helper.VOIP_ENC_HEIGHT_LV1;
                try {
                    Options options = new Options();
                    Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                    if (decodeFile == null) {
                        C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
                        AppMethodBeat.m2505o(131248);
                        return str;
                    }
                    Bitmap b = C5056d.m7648b(decodeFile, (float) orientationInDegree);
                    String str2 = C6457e.euR + "microMsg.tmp." + System.currentTimeMillis() + (C38507c.m65173e(options) ? FileUtils.PIC_POSTFIX_JPEG : ".png");
                    try {
                        C5056d.m7625a(b, 80, C38507c.m65173e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                        if (C38507c.m65173e(options)) {
                            C2154b.m4366bY(str, str2);
                        }
                        AppMethodBeat.m2505o(131248);
                        return str2;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", e);
                        C1173e.deleteFile(str2);
                        AppMethodBeat.m2505o(131248);
                        return str;
                    }
                } catch (OutOfMemoryError e2) {
                    AppMethodBeat.m2505o(131248);
                    return str;
                } catch (NullPointerException e3) {
                    AppMethodBeat.m2505o(131248);
                    return str;
                }
            }
            AppMethodBeat.m2505o(131248);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia$b */
    static final class C33364b {
        public int height;
        public String hfh;
        public int width;

        private C33364b() {
        }

        /* synthetic */ C33364b(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(131268);
        AppMethodBeat.m2505o(131268);
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131266);
        if (C38450n.m65048xa(c2241c.getAppId()).gPk) {
            c2241c.mo6107M(i, mo73394j("cancel", null));
            AppMethodBeat.m2505o(131266);
            return;
        }
        final Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131266);
        } else if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(131266);
        } else {
            int optInt = jSONObject.optInt("maxDuration", 10);
            C4990ab.m7417i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", Integer.valueOf(optInt));
            if (optInt <= 0 || optInt > 30) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
                c2241c.mo6107M(i, mo73394j("fail:invalid maxDuration parameter", null));
                AppMethodBeat.m2505o(131266);
                return;
            }
            boolean z;
            boolean z2;
            boolean contains;
            final C2241c c2241c2;
            context.getSharedPreferences(C4996ah.doA() + "_locCache", 0).edit().putString("locStr", null).apply();
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20055b("wgs84", new C2459b() {
                /* renamed from: a */
                public final void mo6153a(int i, String str, C19712a c19712a) {
                    AppMethodBeat.m2504i(131217);
                    if (i == 0) {
                        int i2 = (int) (c19712a.latitude * 1000000.0d);
                        int i3 = (int) (c19712a.longitude * 1000000.0d);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(i2);
                        stringBuilder.append(",");
                        stringBuilder.append(i3);
                        context.getSharedPreferences(C4996ah.doA() + "_locCache", 0).edit().putString("locStr", stringBuilder.toString()).apply();
                        C4990ab.m7411d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", Double.valueOf(c19712a.latitude), Double.valueOf(c19712a.longitude), stringBuilder);
                        ((C33523a) C37384e.m62985B(C33523a.class)).mo20056c("wgs84", this, null);
                        AppMethodBeat.m2505o(131217);
                        return;
                    }
                    C4990ab.m7413e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", Integer.valueOf(i));
                    AppMethodBeat.m2505o(131217);
                }
            }, null);
            int optInt2 = jSONObject.optInt("count", 9);
            double optDouble = jSONObject.optJSONObject(C8741b.LOCATION).optDouble("longitude", 91.0d);
            double optDouble2 = jSONObject.optJSONObject(C8741b.LOCATION).optDouble("latitude", 181.0d);
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
                c2241c2 = c2241c;
                final JSONObject jSONObject2 = jSONObject;
                final int i2 = i;
                C19663n.m30463b(c2241c.getAppId(), new C0315a() {
                    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                        AppMethodBeat.m2504i(131220);
                        if (i != 113) {
                            AppMethodBeat.m2505o(131220);
                        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            c2241c2.mo6107M(i2, JsApiChooseMultiMedia.this.mo73394j("fail:system permission denied", null));
                            AppMethodBeat.m2505o(131220);
                        } else {
                            JsApiChooseMultiMedia.this.mo5994a(c2241c2, jSONObject2, i2);
                            AppMethodBeat.m2505o(131220);
                        }
                    }
                });
                Context context2 = c2241c.getContext();
                if (context2 == null || !(context2 instanceof Activity)) {
                    c2241c.mo6107M(i, mo73394j("fail", null));
                    contains = false;
                } else {
                    contains = C35805b.m58707a((Activity) context2, "android.permission.CAMERA", 113, "", "");
                    if (contains) {
                        C19663n.m30460Dr(c2241c.getAppId());
                    }
                }
                if (!contains) {
                    AppMethodBeat.m2505o(131266);
                    return;
                }
            }
            C38450n.m65049xb(c2241c.getAppId()).gPk = true;
            c2241c2 = c2241c;
            C33183g.m54274a(c2241c.getAppId(), new C33186c() {
                public final void onResume() {
                    AppMethodBeat.m2504i(131218);
                    C38450n.m65049xb(c2241c2.getAppId()).gPk = false;
                    C33183g.m54276b(c2241c2.getAppId(), this);
                    AppMethodBeat.m2505o(131218);
                }
            });
            ChooseRequest chooseRequest = new ChooseRequest();
            chooseRequest.appId = c2241c.getAppId();
            chooseRequest.count = optInt2;
            double[] f = C18656a.m29159f(optDouble, optDouble2);
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
            c2241c2 = c2241c;
            final int i3 = i;
            C26907a.m42840a(context, chooseRequest, new C19247b<ChooseResult>() {
                /* renamed from: c */
                public final /* synthetic */ void mo6053c(ProcessResult processResult) {
                    AppMethodBeat.m2504i(131219);
                    ChooseResult chooseResult = (ChooseResult) processResult;
                    if (chooseResult == null) {
                        c2241c2.mo6107M(i3, JsApiChooseMultiMedia.this.mo73394j("fail", null));
                        AppMethodBeat.m2505o(131219);
                        return;
                    }
                    switch (chooseResult.bFZ) {
                        case -1:
                            HashMap hashMap = new HashMap();
                            try {
                                hashMap.put("tempFiles", new JSONArray(chooseResult.hPI));
                            } catch (Exception e) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseMultiMedia", "err tempFiles json object create");
                            }
                            c2241c2.mo6107M(i3, JsApiChooseMultiMedia.this.mo73394j("ok", hashMap));
                            AppMethodBeat.m2505o(131219);
                            return;
                        case 0:
                            c2241c2.mo6107M(i3, JsApiChooseMultiMedia.this.mo73394j("cancel", null));
                            AppMethodBeat.m2505o(131219);
                            return;
                        default:
                            c2241c2.mo6107M(i3, JsApiChooseMultiMedia.this.mo73394j("fail", null));
                            AppMethodBeat.m2505o(131219);
                            return;
                    }
                }
            });
            AppMethodBeat.m2505o(131266);
        }
    }

    /* renamed from: Bt */
    static /* synthetic */ C33364b m54528Bt(String str) {
        AppMethodBeat.m2504i(131267);
        C33364b c33364b = new C33364b();
        if (!C5046bo.isNullOrNil(str)) {
            File file = new File(str);
            if (file.exists()) {
                String fO;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                c33364b.width = options.outWidth;
                c33364b.height = options.outHeight;
                if (C38507c.m65173e(options)) {
                    fO = C41710a.m73391fO(C41710a.m73388bJ(file.getAbsolutePath()));
                } else {
                    fO = "up";
                }
                c33364b.hfh = fO;
            }
        }
        AppMethodBeat.m2505o(131267);
        return c33364b;
    }
}
