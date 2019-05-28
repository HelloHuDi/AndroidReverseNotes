package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.pluginsdk.model.C44066p;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import org.apache.commons.p1431a.C36638b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument */
public final class JsApiOpenDocument extends C10296a {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";
    private static long hJO = -1;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument$OpenResult */
    static final class OpenResult extends ProcessResult {
        public static final Creator<OpenResult> CREATOR = new C103841();
        public int ret;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument$OpenResult$1 */
        static class C103841 implements Creator<OpenResult> {
            C103841() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                OpenResult openResult = new OpenResult(parcel);
                AppMethodBeat.m2505o(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                return openResult;
            }
        }

        /* renamed from: k */
        public final void mo6045k(Parcel parcel) {
            AppMethodBeat.m2504i(131073);
            this.ret = parcel.readInt();
            AppMethodBeat.m2505o(131073);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131074);
            parcel.writeInt(this.ret);
            AppMethodBeat.m2505o(131074);
        }

        OpenResult() {
        }

        OpenResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.m2504i(131075);
            AppMethodBeat.m2505o(131075);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument$OpenRequest */
    static final class OpenRequest extends ProcessRequest {
        public static final Creator<OpenRequest> CREATOR = new C166651();
        public String eov;
        public String filePath;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument$OpenRequest$1 */
        static class C166651 implements Creator<OpenRequest> {
            C166651() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131068);
                OpenRequest openRequest = new OpenRequest(parcel);
                AppMethodBeat.m2505o(131068);
                return openRequest;
            }
        }

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return C38292a.class;
        }

        public final String aBZ() {
            return "QbDocumentReader";
        }

        /* renamed from: k */
        public final void mo6049k(Parcel parcel) {
            AppMethodBeat.m2504i(131069);
            super.mo6049k(parcel);
            this.filePath = parcel.readString();
            this.eov = parcel.readString();
            AppMethodBeat.m2505o(131069);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131070);
            super.writeToParcel(parcel, i);
            parcel.writeString(this.filePath);
            parcel.writeString(this.eov);
            AppMethodBeat.m2505o(131070);
        }

        OpenRequest() {
        }

        OpenRequest(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.m2504i(131071);
            AppMethodBeat.m2505o(131071);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument$a */
    static final class C38292a extends AppBrandProxyUIProcessTask {
        private static final int hJQ = (C38292a.class.hashCode() & CdnLogic.kBizGeneric);

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument$a$2 */
        class C382912 implements ValueCallback<String> {
            C382912() {
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.m2504i(131060);
                C4990ab.m7417i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, receiveValue = %s", (String) obj);
                if ("fileReaderClosed".equals((String) obj) && !C38292a.m64793a(C38292a.this)) {
                    C38292a.m64794b(C38292a.this);
                }
                AppMethodBeat.m2505o(131060);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument$a$1 */
        class C382931 implements Runnable {
            C382931() {
            }

            public final void run() {
                AppMethodBeat.m2504i(131059);
                Toast.makeText(C4996ah.getContext(), C25738R.string.f8941k4, 0).show();
                AppMethodBeat.m2505o(131059);
            }
        }

        private C38292a() {
        }

        /* renamed from: b */
        static /* synthetic */ void m64794b(C38292a c38292a) {
            AppMethodBeat.m2504i(131066);
            c38292a.mo34449a(null);
            AppMethodBeat.m2505o(131066);
        }

        static {
            AppMethodBeat.m2504i(131067);
            AppMethodBeat.m2505o(131067);
        }

        /* renamed from: cf */
        private void m64795cf(String str, String str2) {
            AppMethodBeat.m2504i(131061);
            String anI = C44216b.anI(str2);
            OpenResult openResult = new OpenResult();
            try {
                Intent intent = new Intent();
                intent.setPackage(null);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(str)), anI);
                intent.addFlags(268435456);
                int i = VERSION.SDK_INT;
                intent.addFlags(SQLiteGlobal.journalSizeLimit);
                aBQ().startActivity(intent);
                openResult.ret = 0;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.JsApiOpenDocument", "start outer view with mime(%s), e = %s", anI, e);
                openResult.ret = 2147483646;
                C5004al.m7441d(new C382931());
            }
            mo34449a((ProcessResult) openResult);
            AppMethodBeat.m2505o(131061);
        }

        /* renamed from: a */
        public final void mo6047a(ProcessRequest processRequest) {
            AppMethodBeat.m2504i(131062);
            String str = ((OpenRequest) processRequest).filePath;
            String str2 = ((OpenRequest) processRequest).eov;
            String num = Integer.toString(aBQ().hashCode());
            if (C5059g.dnY()) {
                m64795cf(str, str2);
                AppMethodBeat.m2505o(131062);
                return;
            }
            int a = C44066p.m79209a(aBQ(), str, str2, num, new C382912());
            C4990ab.m7417i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, ret = %d", Integer.valueOf(a));
            if (a == ZipJNI.UNZ_PARAMERROR) {
                try {
                    m64795cf(str, str2);
                    AppMethodBeat.m2505o(131062);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiOpenDocument", e, " openOuterAppDirectly exp = %s ", e);
                }
            }
            OpenResult openResult = new OpenResult();
            openResult.ret = a;
            if (openResult.ret != 0) {
                mo34449a((ProcessResult) openResult);
                AppMethodBeat.m2505o(131062);
                return;
            }
            if (this.hvt != null) {
                this.hvt.mo21715b(openResult);
            }
            AppMethodBeat.m2505o(131062);
        }

        public final void aBX() {
            AppMethodBeat.m2504i(131063);
            super.aBX();
            aBQ().getWindow().setBackgroundDrawableResource(C25738R.color.a3p);
            AppMethodBeat.m2505o(131063);
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(131064);
            if (hJQ == i) {
                OpenResult openResult = new OpenResult();
                if (-1 == i2) {
                    openResult.ret = 0;
                } else {
                    openResult.ret = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                mo34449a((ProcessResult) openResult);
                AppMethodBeat.m2505o(131064);
                return;
            }
            mo34449a(null);
            AppMethodBeat.m2505o(131064);
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131076);
        long anU = C5046bo.anU();
        if (anU - hJO < 1000) {
            c2241c.mo6107M(i, mo73394j("fail:document viewer already starting", null));
            AppMethodBeat.m2505o(131076);
            return;
        }
        hJO = anU;
        Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131076);
            return;
        }
        String optString = jSONObject.optString("filePath");
        if (C5046bo.isNullOrNil(optString)) {
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131076);
            return;
        }
        File yg = c2241c.asE().mo34314yg(optString);
        if (yg == null) {
            c2241c.mo6107M(i, mo73394j("fail:file doesn't exist", null));
            AppMethodBeat.m2505o(131076);
            return;
        }
        OpenRequest openRequest = new OpenRequest();
        openRequest.filePath = yg.getAbsolutePath();
        openRequest.eov = C36638b.awJ(optString);
        optString = jSONObject.optString("fileType");
        if (!C5046bo.isNullOrNil(optString)) {
            openRequest.eov = optString;
        }
        C26907a.m42843b(context, openRequest, new C19247b<OpenResult>() {
            /* renamed from: c */
            public final /* synthetic */ void mo6053c(ProcessResult processResult) {
                AppMethodBeat.m2504i(131058);
                OpenResult openResult = (OpenResult) processResult;
                if (c2241c.isRunning()) {
                    String str;
                    if (openResult != null && openResult.ret != 2147483645) {
                        switch (openResult.ret) {
                            case 0:
                                str = "ok";
                                break;
                            case 2147483646:
                                str = "fail no third apps supported";
                                break;
                            case BaseClientBuilder.API_PRIORITY_OTHER /*2147483647*/:
                                str = "fail user cancel";
                                break;
                            default:
                                str = "fail file type not supported " + openResult.ret;
                                break;
                        }
                    }
                    str = "fail env error";
                    c2241c.mo6107M(i, JsApiOpenDocument.this.mo73394j(str, null));
                }
                AppMethodBeat.m2505o(131058);
            }
        });
        AppMethodBeat.m2505o(131076);
    }
}
