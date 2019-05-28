package com.tencent.mm.plugin.appbrand.jsapi.file;

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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import org.json.JSONObject;

public final class JsApiOpenDocument extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";
    private static long hJO = -1;

    static final class OpenResult extends ProcessResult {
        public static final Creator<OpenResult> CREATOR = new Creator<OpenResult>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                OpenResult openResult = new OpenResult(parcel);
                AppMethodBeat.o(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                return openResult;
            }
        };
        public int ret;

        public final void k(Parcel parcel) {
            AppMethodBeat.i(131073);
            this.ret = parcel.readInt();
            AppMethodBeat.o(131073);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131074);
            parcel.writeInt(this.ret);
            AppMethodBeat.o(131074);
        }

        OpenResult() {
        }

        OpenResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(131075);
            AppMethodBeat.o(131075);
        }
    }

    static final class OpenRequest extends ProcessRequest {
        public static final Creator<OpenRequest> CREATOR = new Creator<OpenRequest>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131068);
                OpenRequest openRequest = new OpenRequest(parcel);
                AppMethodBeat.o(131068);
                return openRequest;
            }
        };
        public String eov;
        public String filePath;

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return a.class;
        }

        public final String aBZ() {
            return "QbDocumentReader";
        }

        public final void k(Parcel parcel) {
            AppMethodBeat.i(131069);
            super.k(parcel);
            this.filePath = parcel.readString();
            this.eov = parcel.readString();
            AppMethodBeat.o(131069);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131070);
            super.writeToParcel(parcel, i);
            parcel.writeString(this.filePath);
            parcel.writeString(this.eov);
            AppMethodBeat.o(131070);
        }

        OpenRequest() {
        }

        OpenRequest(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(131071);
            AppMethodBeat.o(131071);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private static final int hJQ = (a.class.hashCode() & CdnLogic.kBizGeneric);

        private a() {
        }

        static /* synthetic */ void b(a aVar) {
            AppMethodBeat.i(131066);
            aVar.a(null);
            AppMethodBeat.o(131066);
        }

        static {
            AppMethodBeat.i(131067);
            AppMethodBeat.o(131067);
        }

        private void cf(String str, String str2) {
            AppMethodBeat.i(131061);
            String anI = b.anI(str2);
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
                ab.e("MicroMsg.AppBrand.JsApiOpenDocument", "start outer view with mime(%s), e = %s", anI, e);
                openResult.ret = 2147483646;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(131059);
                        Toast.makeText(ah.getContext(), R.string.k4, 0).show();
                        AppMethodBeat.o(131059);
                    }
                });
            }
            a((ProcessResult) openResult);
            AppMethodBeat.o(131061);
        }

        public final void a(ProcessRequest processRequest) {
            AppMethodBeat.i(131062);
            String str = ((OpenRequest) processRequest).filePath;
            String str2 = ((OpenRequest) processRequest).eov;
            String num = Integer.toString(aBQ().hashCode());
            if (g.dnY()) {
                cf(str, str2);
                AppMethodBeat.o(131062);
                return;
            }
            int a = p.a(aBQ(), str, str2, num, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(131060);
                    ab.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, receiveValue = %s", (String) obj);
                    if ("fileReaderClosed".equals((String) obj) && !a.a(a.this)) {
                        a.b(a.this);
                    }
                    AppMethodBeat.o(131060);
                }
            });
            ab.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, ret = %d", Integer.valueOf(a));
            if (a == ZipJNI.UNZ_PARAMERROR) {
                try {
                    cf(str, str2);
                    AppMethodBeat.o(131062);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiOpenDocument", e, " openOuterAppDirectly exp = %s ", e);
                }
            }
            OpenResult openResult = new OpenResult();
            openResult.ret = a;
            if (openResult.ret != 0) {
                a((ProcessResult) openResult);
                AppMethodBeat.o(131062);
                return;
            }
            if (this.hvt != null) {
                this.hvt.b(openResult);
            }
            AppMethodBeat.o(131062);
        }

        public final void aBX() {
            AppMethodBeat.i(131063);
            super.aBX();
            aBQ().getWindow().setBackgroundDrawableResource(R.color.a3p);
            AppMethodBeat.o(131063);
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(131064);
            if (hJQ == i) {
                OpenResult openResult = new OpenResult();
                if (-1 == i2) {
                    openResult.ret = 0;
                } else {
                    openResult.ret = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                a((ProcessResult) openResult);
                AppMethodBeat.o(131064);
                return;
            }
            a(null);
            AppMethodBeat.o(131064);
        }
    }

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131076);
        long anU = bo.anU();
        if (anU - hJO < 1000) {
            cVar.M(i, j("fail:document viewer already starting", null));
            AppMethodBeat.o(131076);
            return;
        }
        hJO = anU;
        Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131076);
            return;
        }
        String optString = jSONObject.optString("filePath");
        if (bo.isNullOrNil(optString)) {
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131076);
            return;
        }
        File yg = cVar.asE().yg(optString);
        if (yg == null) {
            cVar.M(i, j("fail:file doesn't exist", null));
            AppMethodBeat.o(131076);
            return;
        }
        OpenRequest openRequest = new OpenRequest();
        openRequest.filePath = yg.getAbsolutePath();
        openRequest.eov = org.apache.commons.a.b.awJ(optString);
        optString = jSONObject.optString("fileType");
        if (!bo.isNullOrNil(optString)) {
            openRequest.eov = optString;
        }
        com.tencent.mm.plugin.appbrand.ipc.a.b(context, openRequest, new AppBrandProxyUIProcessTask.b<OpenResult>() {
            public final /* synthetic */ void c(ProcessResult processResult) {
                AppMethodBeat.i(131058);
                OpenResult openResult = (OpenResult) processResult;
                if (cVar.isRunning()) {
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
                    cVar.M(i, JsApiOpenDocument.this.j(str, null));
                }
                AppMethodBeat.o(131058);
            }
        });
        AppMethodBeat.o(131076);
    }
}
