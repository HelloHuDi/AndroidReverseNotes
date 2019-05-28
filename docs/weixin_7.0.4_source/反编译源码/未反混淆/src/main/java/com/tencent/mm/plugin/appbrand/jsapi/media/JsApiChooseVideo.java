package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    private static volatile boolean hPP = false;

    static final class a extends AppBrandProxyUIProcessTask {
        private p ejZ;
        private ChooseResult hPT = new ChooseResult();
        private ChooseRequest hPU;
        private OnCancelListener hPa;
        private String mVideoFilePath;

        private a() {
            AppMethodBeat.i(131285);
            AppMethodBeat.o(131285);
        }

        static /* synthetic */ AppBrandLocalVideoObject a(a aVar, String str, boolean z) {
            AppMethodBeat.i(131292);
            AppBrandLocalVideoObject aj = aVar.aj(str, z);
            AppMethodBeat.o(131292);
            return aj;
        }

        static /* synthetic */ void a(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131291);
            aVar.a(processResult);
            AppMethodBeat.o(131291);
        }

        static /* synthetic */ void b(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131293);
            aVar.a(processResult);
            AppMethodBeat.o(131293);
        }

        static /* synthetic */ void c(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131294);
            aVar.a(processResult);
            AppMethodBeat.o(131294);
        }

        static /* synthetic */ void d(a aVar, ProcessResult processResult) {
            AppMethodBeat.i(131295);
            aVar.a(processResult);
            AppMethodBeat.o(131295);
        }

        public final void a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.i(131286);
            this.hPU = (ChooseRequest) processRequest;
            this.hPU.maxDuration = Math.min(Math.max(this.hPU.maxDuration, 60), 0);
            if (bo.gO(aBQ()) > 200) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                t.makeText(aBQ(), ah.getResources().getString(R.string.hc), 1).show();
            }
            aBQ().ifE = this;
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", false);
            intent.putExtra("query_media_type", 2);
            intent.putExtra("GalleryUI_SkipVideoSizeLimit", true);
            if (this.hPU.hOS && this.hPU.hOT) {
                this.mVideoFilePath = e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", 1);
                intent.putExtra("record_video_time_limit", this.hPU.maxDuration);
                intent.putExtra("video_full_path", this.mVideoFilePath);
                n.e(aBQ(), 1, 7, intent);
                AppMethodBeat.o(131286);
            } else if (this.hPU.hOS) {
                this.mVideoFilePath = e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                n.a(aBQ(), this.mVideoFilePath, 5, this.hPU.maxDuration, 1, false);
                AppMethodBeat.o(131286);
            } else if (this.hPU.hOT) {
                intent.putExtra("show_header_view", false);
                n.e(aBQ(), 1, 7, intent);
                AppMethodBeat.o(131286);
            } else {
                this.hPT.bFZ = -2;
                a((ProcessResult) this.hPT);
                AppMethodBeat.o(131286);
            }
        }

        public final void aBX() {
            AppMethodBeat.i(131287);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            AppMethodBeat.o(131287);
        }

        private void aEi() {
            AppMethodBeat.i(131288);
            this.hPa = new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(131282);
                    a.this.hPT.bFZ = 0;
                    a.a(a.this, a.this.hPT);
                    AppMethodBeat.o(131282);
                }
            };
            Context aBQ = aBQ();
            ah.getResources().getString(R.string.tz);
            this.ejZ = h.b(aBQ, ah.getResources().getString(R.string.hc), true, this.hPa);
            AppMethodBeat.o(131288);
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(131289);
            if (i2 == 0) {
                this.hPT.bFZ = 0;
                a((ProcessResult) this.hPT);
                AppMethodBeat.o(131289);
            } else if (-1 != i2) {
                this.hPT.bFZ = -2;
                a((ProcessResult) this.hPT);
                AppMethodBeat.o(131289);
            } else {
                switch (i) {
                    case 4:
                        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (!bo.ek(stringArrayListExtra)) {
                            final String str = (String) stringArrayListExtra.get(0);
                            aEi();
                            com.tencent.mm.plugin.appbrand.s.e.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131284);
                                    a.this.hPT.bFZ = -1;
                                    a.this.hPT.hPS = a.a(a.this, str, a.this.hPU.hPR);
                                    a.d(a.this, a.this.hPT);
                                    AppMethodBeat.o(131284);
                                }
                            });
                            AppMethodBeat.o(131289);
                            return;
                        }
                        break;
                    case 5:
                        if (!bo.isNullOrNil(this.mVideoFilePath)) {
                            aEi();
                            com.tencent.mm.plugin.appbrand.s.e.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131283);
                                    if (new File(a.this.mVideoFilePath).exists()) {
                                        a.this.hPT.bFZ = -1;
                                        a.this.hPT.hPS = a.a(a.this, a.this.mVideoFilePath, a.this.hPU.hPR);
                                        a.b(a.this, a.this.hPT);
                                        AppMethodBeat.o(131283);
                                        return;
                                    }
                                    a.this.hPT.bFZ = -2;
                                    a.c(a.this, a.this.hPT);
                                    AppMethodBeat.o(131283);
                                }
                            });
                            AppMethodBeat.o(131289);
                            return;
                        }
                        break;
                }
                this.hPT.bFZ = -2;
                a((ProcessResult) this.hPT);
                AppMethodBeat.o(131289);
            }
        }

        private AppBrandLocalVideoObject aj(String str, boolean z) {
            int i;
            int i2;
            MediaMetadataRetriever mediaMetadataRetriever;
            AppMethodBeat.i(131290);
            if (z) {
                try {
                    boolean vC = c.vC(str);
                    ab.i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", Boolean.valueOf(vC));
                    int i3 = -10000;
                    if (vC) {
                        i3 = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, 1000000);
                        ab.i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", Integer.valueOf(i3));
                    }
                    if (i3 == -1 || !vC) {
                        ab.i("MicroMsg.JsApiChooseVideo", "fileLength = %d", Integer.valueOf(com.tencent.mm.a.e.cs(str)));
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
                            ab.e("MicroMsg.JsApiChooseVideo", "unknown check type");
                            i3 = -50001;
                            break;
                    }
                    if (i3 == -50006) {
                        int[] iArr = new int[2];
                        j.c(str, iArr);
                        i = iArr[0];
                        i2 = iArr[1];
                        String str2 = e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                        i3 = SightVideoJNI.remuxing(str, str2, i, i2, b.qwZ, b.qwY, 8, 2, 25.0f, b.qxa, null, 0, false);
                        ab.i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                        str = str2;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", bo.l(e));
                }
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                ab.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                ab.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
                AppMethodBeat.o(131290);
                return null;
            }
            int i4 = bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i = bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            mediaMetadataRetriever.release();
            AppBrandLocalVideoObject bs = AppBrandLocalMediaObjectManager.bs(this.hPU.appId, str);
            if (bs == null) {
                AppMethodBeat.o(131290);
                return null;
            }
            bs.duration = (i2 + 500) / 1000;
            bs.width = i4;
            bs.height = i;
            bs.size = com.tencent.mm.a.e.cs(str);
            ab.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", bs);
            AppMethodBeat.o(131290);
            return bs;
        }
    }

    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new Creator<ChooseRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131272);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(131272);
                return chooseRequest;
            }
        };
        String appId;
        boolean hOS;
        boolean hOT;
        boolean hPR;
        int maxDuration;

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return a.class;
        }

        public final String aBZ() {
            return "GalleryChooseVideo";
        }

        public final void k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(131273);
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
            AppMethodBeat.o(131273);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(131274);
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
            AppMethodBeat.o(131274);
        }

        public final boolean aBY() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.i(131275);
            k(parcel);
            AppMethodBeat.o(131275);
        }

        static {
            AppMethodBeat.i(131276);
            AppMethodBeat.o(131276);
        }
    }

    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new Creator<ChooseResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131277);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(131277);
                return chooseResult;
            }
        };
        int bFZ;
        AppBrandLocalVideoObject hPS;

        public final void k(Parcel parcel) {
            AppMethodBeat.i(131278);
            this.bFZ = parcel.readInt();
            this.hPS = (AppBrandLocalVideoObject) parcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader());
            AppMethodBeat.o(131278);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131279);
            parcel.writeInt(this.bFZ);
            parcel.writeParcelable(this.hPS, i);
            AppMethodBeat.o(131279);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            AppMethodBeat.i(131280);
            k(parcel);
            AppMethodBeat.o(131280);
        }

        static {
            AppMethodBeat.i(131281);
            AppMethodBeat.o(131281);
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131296);
        if (hPP) {
            cVar.M(i, j("cancel", null));
            AppMethodBeat.o(131296);
            return;
        }
        Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131296);
            return;
        }
        ChooseRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", optJSONArray, jSONObject.optString("maxDuration"));
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
            com.tencent.mm.plugin.appbrand.permission.n.a(cVar.getAppId(), new android.support.v4.app.a.a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    AppMethodBeat.i(131271);
                    if (i != 115) {
                        AppMethodBeat.o(131271);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        cVar.M(i, JsApiChooseVideo.this.j("fail:system permission denied", null));
                        AppMethodBeat.o(131271);
                    } else {
                        JsApiChooseVideo.this.a(cVar, jSONObject, i);
                        AppMethodBeat.o(131271);
                    }
                }
            });
            Context context2 = cVar.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                cVar.M(i, j("fail", null));
                z = false;
            } else {
                z = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.CAMERA", 115, "", "");
                if (z) {
                    com.tencent.mm.plugin.appbrand.permission.n.Dr(cVar.getAppId());
                }
            }
            if (!z) {
                AppMethodBeat.o(131296);
                return;
            }
        }
        hPP = true;
        g.a(cVar.getAppId(), new g.c() {
            public final void onResume() {
                AppMethodBeat.i(131269);
                JsApiChooseVideo.hPP = false;
                g.b(cVar.getAppId(), this);
                AppMethodBeat.o(131269);
            }
        });
        chooseRequest.maxDuration = bo.getInt(r4, 60);
        chooseRequest.appId = cVar.getAppId();
        com.tencent.mm.plugin.appbrand.ipc.a.b(context, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
            public final /* synthetic */ void c(ProcessResult processResult) {
                AppMethodBeat.i(131270);
                ChooseResult chooseResult = (ChooseResult) processResult;
                if (chooseResult != null) {
                    switch (chooseResult.bFZ) {
                        case -1:
                            AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult.hPS;
                            if (appBrandLocalVideoObject == null) {
                                ab.e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                                break;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempFilePath", appBrandLocalVideoObject.czD);
                            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(appBrandLocalVideoObject.duration));
                            hashMap.put("size", Integer.valueOf(appBrandLocalVideoObject.size));
                            hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                            hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                            cVar.M(i, JsApiChooseVideo.this.j("ok", hashMap));
                            AppMethodBeat.o(131270);
                            return;
                        case 0:
                            cVar.M(i, JsApiChooseVideo.this.j("cancel", null));
                            AppMethodBeat.o(131270);
                            return;
                    }
                }
                cVar.M(i, JsApiChooseVideo.this.j("fail", null));
                AppMethodBeat.o(131270);
            }
        });
        AppMethodBeat.o(131296);
    }
}
