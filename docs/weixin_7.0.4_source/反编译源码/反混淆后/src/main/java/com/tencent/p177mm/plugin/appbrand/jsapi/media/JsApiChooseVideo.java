package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.C6184a.C0315a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo */
public final class JsApiChooseVideo extends C10296a {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    private static volatile boolean hPP = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo$a */
    static final class C19435a extends AppBrandProxyUIProcessTask {
        private C44275p ejZ;
        private ChooseResult hPT = new ChooseResult();
        private ChooseRequest hPU;
        private OnCancelListener hPa;
        private String mVideoFilePath;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo$a$1 */
        class C194361 implements OnCancelListener {
            C194361() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(131282);
                C19435a.this.hPT.bFZ = 0;
                C19435a.m30108a(C19435a.this, C19435a.this.hPT);
                AppMethodBeat.m2505o(131282);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo$a$2 */
        class C194382 implements Runnable {
            C194382() {
            }

            public final void run() {
                AppMethodBeat.m2504i(131283);
                if (new File(C19435a.this.mVideoFilePath).exists()) {
                    C19435a.this.hPT.bFZ = -1;
                    C19435a.this.hPT.hPS = C19435a.m30106a(C19435a.this, C19435a.this.mVideoFilePath, C19435a.this.hPU.hPR);
                    C19435a.m30111b(C19435a.this, C19435a.this.hPT);
                    AppMethodBeat.m2505o(131283);
                    return;
                }
                C19435a.this.hPT.bFZ = -2;
                C19435a.m30113c(C19435a.this, C19435a.this.hPT);
                AppMethodBeat.m2505o(131283);
            }
        }

        private C19435a() {
            AppMethodBeat.m2504i(131285);
            AppMethodBeat.m2505o(131285);
        }

        /* renamed from: a */
        static /* synthetic */ AppBrandLocalVideoObject m30106a(C19435a c19435a, String str, boolean z) {
            AppMethodBeat.m2504i(131292);
            AppBrandLocalVideoObject aj = c19435a.m30109aj(str, z);
            AppMethodBeat.m2505o(131292);
            return aj;
        }

        /* renamed from: a */
        static /* synthetic */ void m30108a(C19435a c19435a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131291);
            c19435a.mo34449a(processResult);
            AppMethodBeat.m2505o(131291);
        }

        /* renamed from: b */
        static /* synthetic */ void m30111b(C19435a c19435a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131293);
            c19435a.mo34449a(processResult);
            AppMethodBeat.m2505o(131293);
        }

        /* renamed from: c */
        static /* synthetic */ void m30113c(C19435a c19435a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131294);
            c19435a.mo34449a(processResult);
            AppMethodBeat.m2505o(131294);
        }

        /* renamed from: d */
        static /* synthetic */ void m30114d(C19435a c19435a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131295);
            c19435a.mo34449a(processResult);
            AppMethodBeat.m2505o(131295);
        }

        /* renamed from: a */
        public final void mo6047a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.m2504i(131286);
            this.hPU = (ChooseRequest) processRequest;
            this.hPU.maxDuration = Math.min(Math.max(this.hPU.maxDuration, 60), 0);
            if (C5046bo.m7553gO(aBQ()) > 200) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                C23639t.makeText(aBQ(), C4996ah.getResources().getString(C25738R.string.f8859hc), 1).show();
            }
            aBQ().ifE = this;
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", false);
            intent.putExtra("query_media_type", 2);
            intent.putExtra("GalleryUI_SkipVideoSizeLimit", true);
            if (this.hPU.hOS && this.hPU.hOT) {
                this.mVideoFilePath = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", 1);
                intent.putExtra("record_video_time_limit", this.hPU.maxDuration);
                intent.putExtra("video_full_path", this.mVideoFilePath);
                C14987n.m23315e(aBQ(), 1, 7, intent);
                AppMethodBeat.m2505o(131286);
            } else if (this.hPU.hOS) {
                this.mVideoFilePath = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                C14987n.m23297a(aBQ(), this.mVideoFilePath, 5, this.hPU.maxDuration, 1, false);
                AppMethodBeat.m2505o(131286);
            } else if (this.hPU.hOT) {
                intent.putExtra("show_header_view", false);
                C14987n.m23315e(aBQ(), 1, 7, intent);
                AppMethodBeat.m2505o(131286);
            } else {
                this.hPT.bFZ = -2;
                mo34449a((ProcessResult) this.hPT);
                AppMethodBeat.m2505o(131286);
            }
        }

        public final void aBX() {
            AppMethodBeat.m2504i(131287);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            AppMethodBeat.m2505o(131287);
        }

        private void aEi() {
            AppMethodBeat.m2504i(131288);
            this.hPa = new C194361();
            Context aBQ = aBQ();
            C4996ah.getResources().getString(C25738R.string.f9238tz);
            this.ejZ = C30379h.m48458b(aBQ, C4996ah.getResources().getString(C25738R.string.f8859hc), true, this.hPa);
            AppMethodBeat.m2505o(131288);
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(131289);
            if (i2 == 0) {
                this.hPT.bFZ = 0;
                mo34449a((ProcessResult) this.hPT);
                AppMethodBeat.m2505o(131289);
            } else if (-1 != i2) {
                this.hPT.bFZ = -2;
                mo34449a((ProcessResult) this.hPT);
                AppMethodBeat.m2505o(131289);
            } else {
                switch (i) {
                    case 4:
                        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (!C5046bo.m7548ek(stringArrayListExtra)) {
                            final String str = (String) stringArrayListExtra.get(0);
                            aEi();
                            C42677e.aNS().mo10302aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(131284);
                                    C19435a.this.hPT.bFZ = -1;
                                    C19435a.this.hPT.hPS = C19435a.m30106a(C19435a.this, str, C19435a.this.hPU.hPR);
                                    C19435a.m30114d(C19435a.this, C19435a.this.hPT);
                                    AppMethodBeat.m2505o(131284);
                                }
                            });
                            AppMethodBeat.m2505o(131289);
                            return;
                        }
                        break;
                    case 5:
                        if (!C5046bo.isNullOrNil(this.mVideoFilePath)) {
                            aEi();
                            C42677e.aNS().mo10302aa(new C194382());
                            AppMethodBeat.m2505o(131289);
                            return;
                        }
                        break;
                }
                this.hPT.bFZ = -2;
                mo34449a((ProcessResult) this.hPT);
                AppMethodBeat.m2505o(131289);
            }
        }

        /* renamed from: aj */
        private AppBrandLocalVideoObject m30109aj(String str, boolean z) {
            int i;
            int i2;
            MediaMetadataRetriever mediaMetadataRetriever;
            AppMethodBeat.m2504i(131290);
            if (z) {
                try {
                    boolean vC = C42258c.m74643vC(str);
                    C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", Boolean.valueOf(vC));
                    int i3 = -10000;
                    if (vC) {
                        i3 = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, 1000000);
                        C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", Integer.valueOf(i3));
                    }
                    if (i3 == -1 || !vC) {
                        C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "fileLength = %d", Integer.valueOf(C1173e.m2560cs(str)));
                        if (C1173e.m2560cs(str) > 26214400) {
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
                            C4990ab.m7412e("MicroMsg.JsApiChooseVideo", "unknown check type");
                            i3 = -50001;
                            break;
                    }
                    if (i3 == -50006) {
                        int[] iArr = new int[2];
                        C30076j.m47631c(str, iArr);
                        i = iArr[0];
                        i2 = iArr[1];
                        String str2 = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                        i3 = SightVideoJNI.remuxing(str, str2, i, i2, C29014b.qwZ, C29014b.qwY, 8, 2, 25.0f, C29014b.qxa, null, 0, false);
                        C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                        str = str2;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", C5046bo.m7574l(e));
                }
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                C4990ab.m7412e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
                AppMethodBeat.m2505o(131290);
                return null;
            }
            int i4 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            mediaMetadataRetriever.release();
            AppBrandLocalVideoObject bs = AppBrandLocalMediaObjectManager.m29646bs(this.hPU.appId, str);
            if (bs == null) {
                AppMethodBeat.m2505o(131290);
                return null;
            }
            bs.duration = (i2 + 500) / 1000;
            bs.width = i4;
            bs.height = i;
            bs.size = C1173e.m2560cs(str);
            C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", bs);
            AppMethodBeat.m2505o(131290);
            return bs;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo$ChooseRequest */
    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new C104751();
        String appId;
        boolean hOS;
        boolean hOT;
        boolean hPR;
        int maxDuration;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo$ChooseRequest$1 */
        static class C104751 implements Creator<ChooseRequest> {
            C104751() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131272);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.m2505o(131272);
                return chooseRequest;
            }
        }

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return C19435a.class;
        }

        public final String aBZ() {
            return "GalleryChooseVideo";
        }

        /* renamed from: k */
        public final void mo6049k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(131273);
            this.appId = parcel.readString();
            this.maxDuration = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOS = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOT = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.hPR = z2;
            AppMethodBeat.m2505o(131273);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(131274);
            parcel.writeString(this.appId);
            parcel.writeInt(this.maxDuration);
            if (this.hOS) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.hOT) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.hPR) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            AppMethodBeat.m2505o(131274);
        }

        public final boolean aBY() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.m2504i(131275);
            mo6049k(parcel);
            AppMethodBeat.m2505o(131275);
        }

        static {
            AppMethodBeat.m2504i(131276);
            AppMethodBeat.m2505o(131276);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo$ChooseResult */
    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new C194391();
        int bFZ;
        AppBrandLocalVideoObject hPS;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo$ChooseResult$1 */
        static class C194391 implements Creator<ChooseResult> {
            C194391() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131277);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.m2505o(131277);
                return chooseResult;
            }
        }

        /* renamed from: k */
        public final void mo6045k(Parcel parcel) {
            AppMethodBeat.m2504i(131278);
            this.bFZ = parcel.readInt();
            this.hPS = (AppBrandLocalVideoObject) parcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader());
            AppMethodBeat.m2505o(131278);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131279);
            parcel.writeInt(this.bFZ);
            parcel.writeParcelable(this.hPS, i);
            AppMethodBeat.m2505o(131279);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            AppMethodBeat.m2504i(131280);
            mo6045k(parcel);
            AppMethodBeat.m2505o(131280);
        }

        static {
            AppMethodBeat.m2504i(131281);
            AppMethodBeat.m2505o(131281);
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131296);
        if (hPP) {
            c2241c.mo6107M(i, mo73394j("cancel", null));
            AppMethodBeat.m2505o(131296);
            return;
        }
        Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131296);
            return;
        }
        ChooseRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        C4990ab.m7417i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", optJSONArray, jSONObject.optString("maxDuration"));
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.hOS = true;
            chooseRequest.hOT = true;
        } else {
            chooseRequest.hOS = optJSONArray.toString().contains("camera");
            chooseRequest.hOT = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        chooseRequest.hPR = jSONObject.optBoolean("compressed", true);
        if (chooseRequest.hOS) {
            boolean z;
            C19663n.m30462a(c2241c.getAppId(), new C0315a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    AppMethodBeat.m2504i(131271);
                    if (i != 115) {
                        AppMethodBeat.m2505o(131271);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        c2241c.mo6107M(i, JsApiChooseVideo.this.mo73394j("fail:system permission denied", null));
                        AppMethodBeat.m2505o(131271);
                    } else {
                        JsApiChooseVideo.this.mo5994a(c2241c, jSONObject, i);
                        AppMethodBeat.m2505o(131271);
                    }
                }
            });
            Context context2 = c2241c.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                c2241c.mo6107M(i, mo73394j("fail", null));
                z = false;
            } else {
                z = C35805b.m58707a((Activity) context2, "android.permission.CAMERA", 115, "", "");
                if (z) {
                    C19663n.m30460Dr(c2241c.getAppId());
                }
            }
            if (!z) {
                AppMethodBeat.m2505o(131296);
                return;
            }
        }
        hPP = true;
        C33183g.m54274a(c2241c.getAppId(), new C33186c() {
            public final void onResume() {
                AppMethodBeat.m2504i(131269);
                JsApiChooseVideo.hPP = false;
                C33183g.m54276b(c2241c.getAppId(), this);
                AppMethodBeat.m2505o(131269);
            }
        });
        chooseRequest.maxDuration = C5046bo.getInt(r4, 60);
        chooseRequest.appId = c2241c.getAppId();
        C26907a.m42843b(context, chooseRequest, new C19247b<ChooseResult>() {
            /* renamed from: c */
            public final /* synthetic */ void mo6053c(ProcessResult processResult) {
                AppMethodBeat.m2504i(131270);
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.bFZ) {
                        case -1:
                            AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult.hPS;
                            if (appBrandLocalVideoObject == null) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                                break;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempFilePath", appBrandLocalVideoObject.czD);
                            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(appBrandLocalVideoObject.duration));
                            hashMap.put("size", Integer.valueOf(appBrandLocalVideoObject.size));
                            hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                            hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                            c2241c.mo6107M(i, JsApiChooseVideo.this.mo73394j("ok", hashMap));
                            AppMethodBeat.m2505o(131270);
                            return;
                        case 0:
                            c2241c.mo6107M(i, JsApiChooseVideo.this.mo73394j("cancel", null));
                            AppMethodBeat.m2505o(131270);
                            return;
                    }
                }
                c2241c.mo6107M(i, JsApiChooseVideo.this.mo73394j("fail", null));
                AppMethodBeat.m2505o(131270);
            }
        });
        AppMethodBeat.m2505o(131296);
    }
}
