package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 194;
    public static final String NAME = "uploadEncryptedFileToCDN";

    static final class a extends p {
        private static final int CTRL_INDEX = 196;
        private static final String NAME = "onUploadEncryptedFileToCDNProgress";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class JsApiUploadEncryptedMediaFileTask extends MainProcessTask {
        public static final Creator<JsApiUploadEncryptedMediaFileTask> CREATOR = new Creator<JsApiUploadEncryptedMediaFileTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiUploadEncryptedMediaFileTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131310);
                JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask(parcel);
                AppMethodBeat.o(131310);
                return jsApiUploadEncryptedMediaFileTask;
            }
        };
        public String appId;
        public String czD;
        private ProgressDialog ehJ = null;
        public String eyr;
        public String fileId;
        public String fileUrl;
        public int gUm;
        public boolean hQq;
        public int hQr = 0;
        public int hQs = 0;
        public int hQt = 0;
        Activity hQu;
        com.tencent.mm.plugin.appbrand.c.d.a hQv;
        b hQw;
        public Runnable hww;
        c hxS;
        public String mimeType;

        static /* synthetic */ boolean a(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
            AppMethodBeat.i(131316);
            boolean aCb = jsApiUploadEncryptedMediaFileTask.aCb();
            AppMethodBeat.o(131316);
            return aCb;
        }

        static /* synthetic */ boolean b(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
            AppMethodBeat.i(131317);
            boolean aCb = jsApiUploadEncryptedMediaFileTask.aCb();
            AppMethodBeat.o(131317);
            return aCb;
        }

        public JsApiUploadEncryptedMediaFileTask(Parcel parcel) {
            AppMethodBeat.i(131311);
            g(parcel);
            AppMethodBeat.o(131311);
        }

        public final void asP() {
            AppMethodBeat.i(131312);
            ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", Integer.valueOf(this.hQs), Integer.valueOf(this.hQt));
            if (this.hQs == 1) {
                ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
                f.auY().a(this.hQv);
                f.auY().a(this.hQw);
                f.auY();
                com.tencent.mm.plugin.appbrand.c.b.yC(this.czD);
                this.hQs = 0;
                this.hQt = 1;
                aCb();
                AppMethodBeat.o(131312);
                return;
            }
            final AppBrandLocalMediaObject bt = AppBrandLocalMediaObjectManager.bt(this.appId, this.czD);
            if (bt == null) {
                ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
                this.hQt = 1;
                aCb();
                AppMethodBeat.o(131312);
                return;
            }
            boolean z;
            com.tencent.mm.plugin.appbrand.c.a aVar = new com.tencent.mm.plugin.appbrand.c.a();
            aVar.czD = bt.czD;
            aVar.heo = bt.fnQ;
            aVar.gjQ = bt.gjQ;
            String str = this.czD;
            aVar.cHr = com.tencent.mm.al.c.a("appbrandmediafile", bo.anU(), str, str);
            f.auX().a(aVar);
            this.hQv = new com.tencent.mm.plugin.appbrand.c.d.a() {
                public final void J(int i, String str) {
                    AppMethodBeat.i(131304);
                    ab.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", Integer.valueOf(i), str);
                    JsApiUploadEncryptedMediaFileTask.this.hQr = i;
                    JsApiUploadEncryptedMediaFileTask.this.hQt = 3;
                    JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedMediaFileTask.this);
                    AppMethodBeat.o(131304);
                }
            };
            this.hQw = new b() {
                public final void b(boolean z, String str, String str2, String str3) {
                    AppMethodBeat.i(131305);
                    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                    if (!bo.isNullOrNil(str) && str.equals(bt.czD)) {
                        f.auY().a(JsApiUploadEncryptedMediaFileTask.this.hQv);
                        f.auY().a(JsApiUploadEncryptedMediaFileTask.this.hQw);
                        f.auY();
                        com.tencent.mm.plugin.appbrand.c.b.yC(bt.czD);
                        if (z) {
                            JsApiUploadEncryptedMediaFileTask.this.fileId = str2;
                            ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
                        } else {
                            ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
                        }
                        com.tencent.mm.plugin.appbrand.c.c auX = f.auX();
                        String str4 = JsApiUploadEncryptedMediaFileTask.this.fileId;
                        if (!bo.isNullOrNil(str4)) {
                            for (com.tencent.mm.plugin.appbrand.c.a aVar : auX.hez.values()) {
                                if (bo.nullAsNil(aVar.hep).equals(str4)) {
                                    break;
                                }
                            }
                        }
                        ab.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
                        com.tencent.mm.plugin.appbrand.c.a aVar2 = null;
                        if (aVar2 == null || aVar2.heq == null) {
                            ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
                        } else {
                            ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
                            JsApiUploadEncryptedMediaFileTask.this.eyr = aVar2.heq.field_aesKey;
                            JsApiUploadEncryptedMediaFileTask.this.fileId = aVar2.heq.field_fileId;
                            JsApiUploadEncryptedMediaFileTask.this.fileUrl = aVar2.heq.field_fileUrl;
                            JsApiUploadEncryptedMediaFileTask.this.gUm = aVar2.heq.field_fileLength;
                            ab.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", JsApiUploadEncryptedMediaFileTask.this.eyr, Integer.valueOf(JsApiUploadEncryptedMediaFileTask.this.gUm));
                        }
                        JsApiUploadEncryptedMediaFileTask.this.hQt = 1;
                        JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedMediaFileTask.this);
                    }
                    AppMethodBeat.o(131305);
                }
            };
            com.tencent.mm.plugin.appbrand.c.b auY = f.auY();
            com.tencent.mm.plugin.appbrand.c.d.a aVar2 = this.hQv;
            if (!(auY.hev == null || aVar2 == null || auY.hev.contains(aVar2))) {
                auY.hev.add(aVar2);
            }
            auY = f.auY();
            str = this.appId;
            String str2 = bt.czD;
            int i = com.tencent.mm.i.a.efH;
            b bVar = this.hQw;
            com.tencent.mm.plugin.appbrand.c.a yE = f.auX().yE(str2);
            if (yE == null) {
                ab.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", str2);
                z = false;
            } else {
                yE.appId = str;
                if (!(bVar == null || auY.heu == null || bVar == null || auY.heu.contains(bVar))) {
                    auY.heu.add(bVar);
                }
                yE.her = true;
                g gVar = new g();
                gVar.egl = auY.fFk;
                gVar.cRY = true;
                gVar.field_mediaId = yE.cHr;
                gVar.field_fullpath = yE.heo;
                gVar.field_fileType = i;
                gVar.field_talker = "weixin";
                gVar.field_priority = com.tencent.mm.i.a.efC;
                if (i == com.tencent.mm.i.a.efH) {
                    gVar.field_needStorage = true;
                } else {
                    gVar.field_needStorage = false;
                }
                gVar.field_isStreamMedia = false;
                gVar.field_appType = 0;
                gVar.field_bzScene = 0;
                gVar.field_force_aeskeycdn = true;
                gVar.field_trysafecdn = false;
                z = com.tencent.mm.al.f.afx().e(gVar);
                ab.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", Boolean.valueOf(z), Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), str2);
            }
            ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", Boolean.valueOf(z));
            if (z) {
                if (this.hQq) {
                    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
                    this.hQt = 2;
                    aCb();
                }
                AppMethodBeat.o(131312);
                return;
            }
            ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
            this.hQt = 1;
            f.auY().a(this.hQv);
            f.auY().a(this.hQw);
            f.auY();
            com.tencent.mm.plugin.appbrand.c.b.yC(bt.czD);
            aCb();
            AppMethodBeat.o(131312);
        }

        public final void asQ() {
            AppMethodBeat.i(131313);
            if (this.hQt == 0) {
                ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
                AppMethodBeat.o(131313);
                return;
            }
            if (this.hQt == 1) {
                ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (this.hww != null) {
                    this.hww.run();
                    AppMethodBeat.o(131313);
                    return;
                }
            } else if (this.hQt == 2) {
                ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
                Context context = this.hQu;
                this.hQu.getString(R.string.tz);
                this.ehJ = h.b(context, this.hQu.getString(R.string.vo), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(131306);
                        ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
                        dialogInterface.dismiss();
                        JsApiUploadEncryptedMediaFileTask.this.hQs = 1;
                        JsApiUploadEncryptedMediaFileTask.this.hQt = 1;
                        AppBrandMainProcessService.a(JsApiUploadEncryptedMediaFileTask.this);
                        AppMethodBeat.o(131306);
                    }
                });
                this.ehJ.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(131309);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            Object string;
                            if (TextUtils.isEmpty(JsApiUploadEncryptedMediaFileTask.this.mimeType) || !JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video")) {
                                String string2 = JsApiUploadEncryptedMediaFileTask.this.hQu.getString(R.string.vj);
                            } else {
                                string2 = JsApiUploadEncryptedMediaFileTask.this.hQu.getString(R.string.vp);
                            }
                            h.a(JsApiUploadEncryptedMediaFileTask.this.hQu, true, JsApiUploadEncryptedMediaFileTask.this.hQu.getString(R.string.vk, new Object[]{string2}), "", JsApiUploadEncryptedMediaFileTask.this.hQu.getString(R.string.vm), JsApiUploadEncryptedMediaFileTask.this.hQu.getString(R.string.vn), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(131307);
                                    ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                                    JsApiUploadEncryptedMediaFileTask.this.ehJ.cancel();
                                    JsApiUploadEncryptedMediaFileTask.this.hQs = 1;
                                    JsApiUploadEncryptedMediaFileTask.this.hQt = 1;
                                    AppBrandMainProcessService.a(JsApiUploadEncryptedMediaFileTask.this);
                                    AppMethodBeat.o(131307);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(131308);
                                    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
                                    AppMethodBeat.o(131308);
                                }
                            });
                            AppMethodBeat.o(131309);
                            return true;
                        }
                        AppMethodBeat.o(131309);
                        return false;
                    }
                });
                AppMethodBeat.o(131313);
                return;
            } else if (this.hQt == 3) {
                ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", this.czD);
                hashMap.put("percent", Integer.valueOf(this.hQr));
                new a().i(this.hxS).AL(new JSONObject(hashMap).toString()).aCj();
            }
            AppMethodBeat.o(131313);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(131314);
            this.appId = parcel.readString();
            this.czD = parcel.readString();
            this.fileId = parcel.readString();
            this.eyr = parcel.readString();
            this.fileUrl = parcel.readString();
            this.gUm = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hQq = z;
            this.hQr = parcel.readInt();
            this.hQt = parcel.readInt();
            this.hQs = parcel.readInt();
            this.mimeType = parcel.readString();
            AppMethodBeat.o(131314);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131315);
            parcel.writeString(this.appId);
            parcel.writeString(this.czD);
            parcel.writeString(this.fileId);
            parcel.writeString(this.eyr);
            parcel.writeString(this.fileUrl);
            parcel.writeInt(this.gUm);
            parcel.writeInt(this.hQq ? 1 : 0);
            parcel.writeInt(this.hQr);
            parcel.writeInt(this.hQt);
            parcel.writeInt(this.hQs);
            parcel.writeString(this.mimeType);
            AppMethodBeat.o(131315);
        }

        static {
            AppMethodBeat.i(131318);
            AppMethodBeat.o(131318);
        }
    }

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131319);
        Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131319);
        } else if (jSONObject == null) {
            ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(131319);
        } else {
            String appId = cVar.getAppId();
            String optString = jSONObject.optString("tempFilePath");
            boolean optBoolean = jSONObject.optBoolean("isShowProgressTips", false);
            ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", appId, jSONObject.toString());
            if (bo.isNullOrNil(optString)) {
                ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
                cVar.M(i, j("fail:tempFilePath is null", null));
                AppMethodBeat.o(131319);
                return;
            }
            AppBrandLocalMediaObject bt = AppBrandLocalMediaObjectManager.bt(appId, optString);
            if (bt == null) {
                ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
                cVar.M(i, j("fail:file doesn't exist", null));
                AppMethodBeat.o(131319);
            } else if (TextUtils.isEmpty(bt.fnQ)) {
                ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
                cVar.M(i, j("fail:fileFullPath is null", null));
                AppMethodBeat.o(131319);
            } else {
                final MainProcessTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
                jsApiUploadEncryptedMediaFileTask.appId = appId;
                jsApiUploadEncryptedMediaFileTask.czD = optString;
                jsApiUploadEncryptedMediaFileTask.hQq = optBoolean;
                jsApiUploadEncryptedMediaFileTask.hQu = (Activity) context;
                jsApiUploadEncryptedMediaFileTask.hxS = cVar;
                jsApiUploadEncryptedMediaFileTask.mimeType = bt.mimeType;
                jsApiUploadEncryptedMediaFileTask.hww = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(131301);
                        HashMap hashMap = new HashMap();
                        hashMap.put("fileId", jsApiUploadEncryptedMediaFileTask.fileId);
                        hashMap.put("aesKey", jsApiUploadEncryptedMediaFileTask.eyr);
                        hashMap.put("fileUrl", jsApiUploadEncryptedMediaFileTask.fileUrl);
                        hashMap.put("fileLength", jsApiUploadEncryptedMediaFileTask.gUm);
                        ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", jsApiUploadEncryptedMediaFileTask.fileId);
                        if (bo.isNullOrNil(jsApiUploadEncryptedMediaFileTask.fileId)) {
                            ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
                            cVar.M(i, JsApiUploadEncryptedFileToCDN.this.j("fail", null));
                        } else {
                            ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
                            cVar.M(i, JsApiUploadEncryptedFileToCDN.this.j("ok", hashMap));
                        }
                        jsApiUploadEncryptedMediaFileTask.aBW();
                        AppMethodBeat.o(131301);
                    }
                };
                if (com.tencent.mm.network.ab.ch(context)) {
                    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
                    jsApiUploadEncryptedMediaFileTask.aBV();
                    AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                    AppMethodBeat.o(131319);
                    return;
                }
                ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
                if (TextUtils.isEmpty(bt.mimeType) || !bt.mimeType.contains("video")) {
                    appId = context.getString(R.string.vj);
                } else {
                    appId = context.getString(R.string.vp);
                }
                optString = bo.my((long) e.cs(bt.fnQ));
                h.a(context, context.getString(R.string.vl, new Object[]{appId, optString}), context.getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(131302);
                        ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
                        jsApiUploadEncryptedMediaFileTask.aBV();
                        AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                        AppMethodBeat.o(131302);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(131303);
                        ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                        cVar.M(i, JsApiUploadEncryptedFileToCDN.this.j("cancel", null));
                        jsApiUploadEncryptedMediaFileTask.aBW();
                        AppMethodBeat.o(131303);
                    }
                });
                AppMethodBeat.o(131319);
            }
        }
    }
}
