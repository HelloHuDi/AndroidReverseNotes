package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.p230g.p231a.C45330h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask */
public final class JsApiAddNativeDownloadTask extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 428;
    private static final String NAME = "addNativeDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask */
    static class AddNativeDownloadTaskTask extends MainProcessTask {
        public static final Creator<AddNativeDownloadTaskTask> CREATOR = new C102852();
        public int bJt = 0;
        public long crZ = 0;
        private C4884c hwv;
        Runnable hww;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$1 */
        class C102841 extends C4884c<C45330h> {
            C102841() {
                AppMethodBeat.m2504i(130379);
                this.xxI = C45330h.class.getName().hashCode();
                AppMethodBeat.m2505o(130379);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(130380);
                C45330h c45330h = (C45330h) c4883b;
                if (!(c45330h instanceof C45330h)) {
                    C4990ab.m7420w("MicroMsg.JsApiAddNativeDownloadTask", "mismatched event");
                    AppMethodBeat.m2505o(130380);
                    return false;
                } else if (c45330h.crX.scene != 1) {
                    C4990ab.m7416i("MicroMsg.JsApiAddNativeDownloadTask", "not jsapi api callback");
                    AppMethodBeat.m2505o(130380);
                    return false;
                } else {
                    if (c45330h.crX.crY) {
                        C4990ab.m7416i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, cancel");
                        AddNativeDownloadTaskTask.this.bJt = 0;
                        AddNativeDownloadTaskTask.m17944a(AddNativeDownloadTaskTask.this);
                    } else if (c45330h.crX.crZ > 0) {
                        new HashMap().put("download_id", Long.valueOf(c45330h.crX.crZ));
                        AddNativeDownloadTaskTask.this.crZ = c45330h.crX.crZ;
                        C4990ab.m7417i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, ok downloadId:%s", Long.valueOf(AddNativeDownloadTaskTask.this.crZ));
                        AddNativeDownloadTaskTask.this.bJt = 2;
                        AddNativeDownloadTaskTask.m17945b(AddNativeDownloadTaskTask.this);
                    } else {
                        C4990ab.m7416i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, failed");
                        AddNativeDownloadTaskTask.this.bJt = 1;
                        AddNativeDownloadTaskTask.m17946c(AddNativeDownloadTaskTask.this);
                    }
                    C4879a.xxA.mo10053d(AddNativeDownloadTaskTask.this.hwv);
                    AppMethodBeat.m2505o(130380);
                    return true;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$2 */
        static class C102852 implements Creator<AddNativeDownloadTaskTask> {
            C102852() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddNativeDownloadTaskTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130381);
                AddNativeDownloadTaskTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
                addNativeDownloadTaskTask.mo6032g(parcel);
                AppMethodBeat.m2505o(130381);
                return addNativeDownloadTaskTask;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m17944a(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.m2504i(130386);
            boolean aCb = addNativeDownloadTaskTask.aCb();
            AppMethodBeat.m2505o(130386);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m17945b(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.m2504i(130387);
            boolean aCb = addNativeDownloadTaskTask.aCb();
            AppMethodBeat.m2505o(130387);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m17946c(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.m2504i(130388);
            boolean aCb = addNativeDownloadTaskTask.aCb();
            AppMethodBeat.m2505o(130388);
            return aCb;
        }

        public final void asP() {
            AppMethodBeat.m2504i(130382);
            C4990ab.m7417i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", Integer.valueOf(this.bJt));
            this.hwv = new C102841();
            C4879a.xxA.mo10051b(this.hwv);
            AppMethodBeat.m2505o(130382);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130383);
            if (this.hww != null) {
                this.hww.run();
            }
            AppMethodBeat.m2505o(130383);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130384);
            this.bJt = parcel.readInt();
            this.crZ = parcel.readLong();
            AppMethodBeat.m2505o(130384);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130385);
            parcel.writeInt(this.bJt);
            parcel.writeLong(this.crZ);
            AppMethodBeat.m2505o(130385);
        }

        static {
            AppMethodBeat.m2504i(130389);
            AppMethodBeat.m2505o(130389);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130390);
        C38492q c38492q = (C38492q) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddNativeDownloadTask", "data is null");
            c38492q.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(130390);
            return;
        }
        String optString = jSONObject.optString("taskName");
        String optString2 = jSONObject.optString("taskUrl");
        long j = C5046bo.getLong(jSONObject.optString("taskSize"), 0);
        String optString3 = jSONObject.optString("fileMD5");
        String optString4 = jSONObject.optString("thumbUrl");
        String optString5 = jSONObject.optString("title");
        final Context context = c38492q.getContext();
        C4990ab.m7417i("MicroMsg.JsApiAddNativeDownloadTask", "taskUrl : %s, taskSize : %s, fileMD5:[%s], title : %s, thumbUrl : %s", optString2, Long.valueOf(j), optString3, optString5, optString4);
        if (!C5023at.isNetworkConnected(context)) {
            c38492q.mo6107M(i, mo73394j("fail:fail network not connected", null));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(130375);
                    Toast.makeText(context, context.getString(C25738R.string.c5d), 0).show();
                    AppMethodBeat.m2505o(130375);
                }
            });
            C4990ab.m7416i("MicroMsg.JsApiAddNativeDownloadTask", "fail, network not ready");
            AppMethodBeat.m2505o(130390);
        } else if (!C1445f.m3070Mn()) {
            c38492q.mo6107M(i, mo73394j("fail:fail sdcard not ready", null));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(130376);
                    Toast.makeText(context, context.getString(C25738R.string.c5h), 0).show();
                    AppMethodBeat.m2505o(130376);
                }
            });
            C4990ab.m7416i("MicroMsg.JsApiAddNativeDownloadTask", "fail, sdcard not ready");
            AppMethodBeat.m2505o(130390);
        } else if (j > 0 && !C1445f.m3072eW(j)) {
            c38492q.mo6107M(i, mo73394j("fail:fail sdcard has not enough space", null));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(130377);
                    Toast.makeText(context, context.getString(C25738R.string.c5e), 0).show();
                    AppMethodBeat.m2505o(130377);
                }
            });
            C4990ab.m7416i("MicroMsg.JsApiAddNativeDownloadTask", "fail, not enough space, require size = ".concat(String.valueOf(j)));
            AppMethodBeat.m2505o(130390);
        } else if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiAddNativeDownloadTask", "doAddDownloadTask fail, url is null");
            c38492q.mo6107M(i, mo73394j("fail:taskUrl is null or nil", null));
            AppMethodBeat.m2505o(130390);
        } else {
            Intent intent = new Intent();
            intent.putExtra("task_name", optString);
            intent.putExtra("task_url", optString2);
            intent.putExtra("task_size", j);
            intent.putExtra("file_md5", optString3);
            intent.putExtra("appid", c38492q.getAppId());
            intent.putExtra("thumb_url", optString4);
            intent.putExtra("title", optString5);
            C44709u currentPageView = c38492q.getCurrentPageView();
            if (currentPageView != null) {
                intent.putExtra("page_url", currentPageView.getURL());
            } else {
                C4990ab.m7412e("MicroMsg.JsApiAddNativeDownloadTask", "getCurrentPageView is null");
            }
            intent.putExtra("page_scene", 1);
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
            final MainProcessTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
            final C38492q c38492q2 = c38492q;
            final int i2 = i;
            addNativeDownloadTaskTask.hww = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(130378);
                    addNativeDownloadTaskTask.aBW();
                    HashMap hashMap = new HashMap();
                    switch (addNativeDownloadTaskTask.bJt) {
                        case 0:
                            c38492q2.mo6107M(i2, JsApiAddNativeDownloadTask.this.mo73394j("fail:cancel", null));
                            AppMethodBeat.m2505o(130378);
                            return;
                        case 1:
                            c38492q2.mo6107M(i2, JsApiAddNativeDownloadTask.this.mo73394j("fail:download fail", null));
                            AppMethodBeat.m2505o(130378);
                            return;
                        case 2:
                            hashMap.put("download_id", Long.valueOf(addNativeDownloadTaskTask.crZ));
                            c38492q2.mo6107M(i2, JsApiAddNativeDownloadTask.this.mo73394j("ok", hashMap));
                            break;
                    }
                    AppMethodBeat.m2505o(130378);
                }
            };
            addNativeDownloadTaskTask.aBV();
            AppBrandMainProcessService.m54349a(addNativeDownloadTaskTask);
            AppMethodBeat.m2505o(130390);
        }
    }
}
