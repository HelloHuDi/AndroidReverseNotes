package com.tencent.p177mm.plugin.appbrand.jsapi.media;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.p884c.C19127a;
import com.tencent.p177mm.plugin.appbrand.p884c.C19128c;
import com.tencent.p177mm.plugin.appbrand.p884c.C19129d.C19130b;
import com.tencent.p177mm.plugin.appbrand.p884c.C19129d.C19132a;
import com.tencent.p177mm.plugin.appbrand.p884c.C26799b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN */
public final class JsApiUploadEncryptedFileToCDN extends C10296a {
    public static final int CTRL_INDEX = 194;
    public static final String NAME = "uploadEncryptedFileToCDN";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$a */
    static final class C19441a extends C38369p {
        private static final int CTRL_INDEX = 196;
        private static final String NAME = "onUploadEncryptedFileToCDNProgress";

        private C19441a() {
        }

        /* synthetic */ C19441a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask */
    public static class JsApiUploadEncryptedMediaFileTask extends MainProcessTask {
        public static final Creator<JsApiUploadEncryptedMediaFileTask> CREATOR = new C270345();
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
        C19132a hQv;
        C19130b hQw;
        public Runnable hww;
        C2241c hxS;
        public String mimeType;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4 */
        class C194404 implements OnKeyListener {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$1 */
            class C104761 implements OnClickListener {
                C104761() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(131307);
                    C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                    JsApiUploadEncryptedMediaFileTask.this.ehJ.cancel();
                    JsApiUploadEncryptedMediaFileTask.this.hQs = 1;
                    JsApiUploadEncryptedMediaFileTask.this.hQt = 1;
                    AppBrandMainProcessService.m54349a(JsApiUploadEncryptedMediaFileTask.this);
                    AppMethodBeat.m2505o(131307);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$2 */
            class C104772 implements OnClickListener {
                C104772() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(131308);
                    C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
                    AppMethodBeat.m2505o(131308);
                }
            }

            C194404() {
            }

            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                AppMethodBeat.m2504i(131309);
                if (i == 4 && keyEvent.getAction() == 1) {
                    Object string;
                    if (TextUtils.isEmpty(JsApiUploadEncryptedMediaFileTask.this.mimeType) || !JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video")) {
                        String string2 = JsApiUploadEncryptedMediaFileTask.this.hQu.getString(C25738R.string.f9285vj);
                    } else {
                        string2 = JsApiUploadEncryptedMediaFileTask.this.hQu.getString(C25738R.string.f9291vp);
                    }
                    C30379h.m48453a(JsApiUploadEncryptedMediaFileTask.this.hQu, true, JsApiUploadEncryptedMediaFileTask.this.hQu.getString(C25738R.string.f9286vk, new Object[]{string2}), "", JsApiUploadEncryptedMediaFileTask.this.hQu.getString(C25738R.string.f9288vm), JsApiUploadEncryptedMediaFileTask.this.hQu.getString(C25738R.string.f9289vn), new C104761(), new C104772());
                    AppMethodBeat.m2505o(131309);
                    return true;
                }
                AppMethodBeat.m2505o(131309);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$5 */
        static class C270345 implements Creator<JsApiUploadEncryptedMediaFileTask> {
            C270345() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new JsApiUploadEncryptedMediaFileTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131310);
                JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask(parcel);
                AppMethodBeat.m2505o(131310);
                return jsApiUploadEncryptedMediaFileTask;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$3 */
        class C333653 implements OnCancelListener {
            C333653() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(131306);
                C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
                dialogInterface.dismiss();
                JsApiUploadEncryptedMediaFileTask.this.hQs = 1;
                JsApiUploadEncryptedMediaFileTask.this.hQt = 1;
                AppBrandMainProcessService.m54349a(JsApiUploadEncryptedMediaFileTask.this);
                AppMethodBeat.m2505o(131306);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1 */
        class C333681 implements C19132a {
            C333681() {
            }

            /* renamed from: J */
            public final void mo34346J(int i, String str) {
                AppMethodBeat.m2504i(131304);
                C4990ab.m7411d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", Integer.valueOf(i), str);
                JsApiUploadEncryptedMediaFileTask.this.hQr = i;
                JsApiUploadEncryptedMediaFileTask.this.hQt = 3;
                JsApiUploadEncryptedMediaFileTask.m54557a(JsApiUploadEncryptedMediaFileTask.this);
                AppMethodBeat.m2505o(131304);
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m54557a(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
            AppMethodBeat.m2504i(131316);
            boolean aCb = jsApiUploadEncryptedMediaFileTask.aCb();
            AppMethodBeat.m2505o(131316);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m54558b(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
            AppMethodBeat.m2504i(131317);
            boolean aCb = jsApiUploadEncryptedMediaFileTask.aCb();
            AppMethodBeat.m2505o(131317);
            return aCb;
        }

        public JsApiUploadEncryptedMediaFileTask(Parcel parcel) {
            AppMethodBeat.m2504i(131311);
            mo6032g(parcel);
            AppMethodBeat.m2505o(131311);
        }

        public final void asP() {
            AppMethodBeat.m2504i(131312);
            C4990ab.m7417i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", Integer.valueOf(this.hQs), Integer.valueOf(this.hQt));
            if (this.hQs == 1) {
                C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
                C42340f.auY().mo44564a(this.hQv);
                C42340f.auY().mo44565a(this.hQw);
                C42340f.auY();
                C26799b.m42655yC(this.czD);
                this.hQs = 0;
                this.hQt = 1;
                aCb();
                AppMethodBeat.m2505o(131312);
                return;
            }
            final AppBrandLocalMediaObject bt = AppBrandLocalMediaObjectManager.m29647bt(this.appId, this.czD);
            if (bt == null) {
                C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
                this.hQt = 1;
                aCb();
                AppMethodBeat.m2505o(131312);
                return;
            }
            boolean z;
            C19127a c19127a = new C19127a();
            c19127a.czD = bt.czD;
            c19127a.heo = bt.fnQ;
            c19127a.gjQ = bt.gjQ;
            String str = this.czD;
            c19127a.cHr = C37458c.m63162a("appbrandmediafile", C5046bo.anU(), str, str);
            C42340f.auX().mo34339a(c19127a);
            this.hQv = new C333681();
            this.hQw = new C19130b() {
                /* renamed from: b */
                public final void mo34341b(boolean z, String str, String str2, String str3) {
                    AppMethodBeat.m2504i(131305);
                    C4990ab.m7417i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                    if (!C5046bo.isNullOrNil(str) && str.equals(bt.czD)) {
                        C42340f.auY().mo44564a(JsApiUploadEncryptedMediaFileTask.this.hQv);
                        C42340f.auY().mo44565a(JsApiUploadEncryptedMediaFileTask.this.hQw);
                        C42340f.auY();
                        C26799b.m42655yC(bt.czD);
                        if (z) {
                            JsApiUploadEncryptedMediaFileTask.this.fileId = str2;
                            C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
                        } else {
                            C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
                        }
                        C19128c auX = C42340f.auX();
                        String str4 = JsApiUploadEncryptedMediaFileTask.this.fileId;
                        if (!C5046bo.isNullOrNil(str4)) {
                            for (C19127a c19127a : auX.hez.values()) {
                                if (C5046bo.nullAsNil(c19127a.hep).equals(str4)) {
                                    break;
                                }
                            }
                        }
                        C4990ab.m7412e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
                        C19127a c19127a2 = null;
                        if (c19127a2 == null || c19127a2.heq == null) {
                            C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
                        } else {
                            C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
                            JsApiUploadEncryptedMediaFileTask.this.eyr = c19127a2.heq.field_aesKey;
                            JsApiUploadEncryptedMediaFileTask.this.fileId = c19127a2.heq.field_fileId;
                            JsApiUploadEncryptedMediaFileTask.this.fileUrl = c19127a2.heq.field_fileUrl;
                            JsApiUploadEncryptedMediaFileTask.this.gUm = c19127a2.heq.field_fileLength;
                            C4990ab.m7411d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", JsApiUploadEncryptedMediaFileTask.this.eyr, Integer.valueOf(JsApiUploadEncryptedMediaFileTask.this.gUm));
                        }
                        JsApiUploadEncryptedMediaFileTask.this.hQt = 1;
                        JsApiUploadEncryptedMediaFileTask.m54558b(JsApiUploadEncryptedMediaFileTask.this);
                    }
                    AppMethodBeat.m2505o(131305);
                }
            };
            C26799b auY = C42340f.auY();
            C19132a c19132a = this.hQv;
            if (!(auY.hev == null || c19132a == null || auY.hev.contains(c19132a))) {
                auY.hev.add(c19132a);
            }
            auY = C42340f.auY();
            str = this.appId;
            String str2 = bt.czD;
            int i = C42129a.efH;
            C19130b c19130b = this.hQw;
            C19127a yE = C42340f.auX().mo34340yE(str2);
            if (yE == null) {
                C4990ab.m7413e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", str2);
                z = false;
            } else {
                yE.appId = str;
                if (!(c19130b == null || auY.heu == null || c19130b == null || auY.heu.contains(c19130b))) {
                    auY.heu.add(c19130b);
                }
                yE.her = true;
                C42130g c42130g = new C42130g();
                c42130g.egl = auY.fFk;
                c42130g.cRY = true;
                c42130g.field_mediaId = yE.cHr;
                c42130g.field_fullpath = yE.heo;
                c42130g.field_fileType = i;
                c42130g.field_talker = "weixin";
                c42130g.field_priority = C42129a.efC;
                if (i == C42129a.efH) {
                    c42130g.field_needStorage = true;
                } else {
                    c42130g.field_needStorage = false;
                }
                c42130g.field_isStreamMedia = false;
                c42130g.field_appType = 0;
                c42130g.field_bzScene = 0;
                c42130g.field_force_aeskeycdn = true;
                c42130g.field_trysafecdn = false;
                z = C37461f.afx().mo51225e(c42130g);
                C4990ab.m7417i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", Boolean.valueOf(z), Boolean.valueOf(c42130g.field_force_aeskeycdn), Boolean.valueOf(c42130g.field_trysafecdn), str2);
            }
            C4990ab.m7417i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", Boolean.valueOf(z));
            if (z) {
                if (this.hQq) {
                    C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
                    this.hQt = 2;
                    aCb();
                }
                AppMethodBeat.m2505o(131312);
                return;
            }
            C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
            this.hQt = 1;
            C42340f.auY().mo44564a(this.hQv);
            C42340f.auY().mo44565a(this.hQw);
            C42340f.auY();
            C26799b.m42655yC(bt.czD);
            aCb();
            AppMethodBeat.m2505o(131312);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(131313);
            if (this.hQt == 0) {
                C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
                AppMethodBeat.m2505o(131313);
                return;
            }
            if (this.hQt == 1) {
                C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (this.hww != null) {
                    this.hww.run();
                    AppMethodBeat.m2505o(131313);
                    return;
                }
            } else if (this.hQt == 2) {
                C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
                Context context = this.hQu;
                this.hQu.getString(C25738R.string.f9238tz);
                this.ehJ = C30379h.m48458b(context, this.hQu.getString(C25738R.string.f9290vo), true, new C333653());
                this.ehJ.setOnKeyListener(new C194404());
                AppMethodBeat.m2505o(131313);
                return;
            } else if (this.hQt == 3) {
                C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", this.czD);
                hashMap.put("percent", Integer.valueOf(this.hQr));
                new C19441a().mo61031i(this.hxS).mo61027AL(new JSONObject(hashMap).toString()).aCj();
            }
            AppMethodBeat.m2505o(131313);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(131314);
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
            AppMethodBeat.m2505o(131314);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131315);
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
            AppMethodBeat.m2505o(131315);
        }

        static {
            AppMethodBeat.m2504i(131318);
            AppMethodBeat.m2505o(131318);
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131319);
        Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131319);
        } else if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(131319);
        } else {
            String appId = c2241c.getAppId();
            String optString = jSONObject.optString("tempFilePath");
            boolean optBoolean = jSONObject.optBoolean("isShowProgressTips", false);
            C4990ab.m7417i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", appId, jSONObject.toString());
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
                c2241c.mo6107M(i, mo73394j("fail:tempFilePath is null", null));
                AppMethodBeat.m2505o(131319);
                return;
            }
            AppBrandLocalMediaObject bt = AppBrandLocalMediaObjectManager.m29647bt(appId, optString);
            if (bt == null) {
                C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
                c2241c.mo6107M(i, mo73394j("fail:file doesn't exist", null));
                AppMethodBeat.m2505o(131319);
            } else if (TextUtils.isEmpty(bt.fnQ)) {
                C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
                c2241c.mo6107M(i, mo73394j("fail:fileFullPath is null", null));
                AppMethodBeat.m2505o(131319);
            } else {
                final MainProcessTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
                jsApiUploadEncryptedMediaFileTask.appId = appId;
                jsApiUploadEncryptedMediaFileTask.czD = optString;
                jsApiUploadEncryptedMediaFileTask.hQq = optBoolean;
                jsApiUploadEncryptedMediaFileTask.hQu = (Activity) context;
                jsApiUploadEncryptedMediaFileTask.hxS = c2241c;
                jsApiUploadEncryptedMediaFileTask.mimeType = bt.mimeType;
                jsApiUploadEncryptedMediaFileTask.hww = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(131301);
                        HashMap hashMap = new HashMap();
                        hashMap.put("fileId", jsApiUploadEncryptedMediaFileTask.fileId);
                        hashMap.put("aesKey", jsApiUploadEncryptedMediaFileTask.eyr);
                        hashMap.put("fileUrl", jsApiUploadEncryptedMediaFileTask.fileUrl);
                        hashMap.put("fileLength", jsApiUploadEncryptedMediaFileTask.gUm);
                        C4990ab.m7417i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", jsApiUploadEncryptedMediaFileTask.fileId);
                        if (C5046bo.isNullOrNil(jsApiUploadEncryptedMediaFileTask.fileId)) {
                            C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
                            c2241c.mo6107M(i, JsApiUploadEncryptedFileToCDN.this.mo73394j("fail", null));
                        } else {
                            C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
                            c2241c.mo6107M(i, JsApiUploadEncryptedFileToCDN.this.mo73394j("ok", hashMap));
                        }
                        jsApiUploadEncryptedMediaFileTask.aBW();
                        AppMethodBeat.m2505o(131301);
                    }
                };
                if (C32856ab.m53750ch(context)) {
                    C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
                    jsApiUploadEncryptedMediaFileTask.aBV();
                    AppBrandMainProcessService.m54349a(jsApiUploadEncryptedMediaFileTask);
                    AppMethodBeat.m2505o(131319);
                    return;
                }
                C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
                if (TextUtils.isEmpty(bt.mimeType) || !bt.mimeType.contains("video")) {
                    appId = context.getString(C25738R.string.f9285vj);
                } else {
                    appId = context.getString(C25738R.string.f9291vp);
                }
                optString = C5046bo.m7580my((long) C1173e.m2560cs(bt.fnQ));
                C30379h.m48440a(context, context.getString(C25738R.string.f9287vl, new Object[]{appId, optString}), context.getString(C25738R.string.f9238tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(131302);
                        C4990ab.m7416i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
                        jsApiUploadEncryptedMediaFileTask.aBV();
                        AppBrandMainProcessService.m54349a(jsApiUploadEncryptedMediaFileTask);
                        AppMethodBeat.m2505o(131302);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(131303);
                        C4990ab.m7412e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                        c2241c.mo6107M(i, JsApiUploadEncryptedFileToCDN.this.mo73394j("cancel", null));
                        jsApiUploadEncryptedMediaFileTask.aBW();
                        AppMethodBeat.m2505o(131303);
                    }
                });
                AppMethodBeat.m2505o(131319);
            }
        }
    }
}
