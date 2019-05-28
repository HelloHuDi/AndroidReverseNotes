package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiAddNativeDownloadTask extends a<q> {
    private static final int CTRL_INDEX = 428;
    private static final String NAME = "addNativeDownloadTask";

    static class AddNativeDownloadTaskTask extends MainProcessTask {
        public static final Creator<AddNativeDownloadTaskTask> CREATOR = new Creator<AddNativeDownloadTaskTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddNativeDownloadTaskTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130381);
                AddNativeDownloadTaskTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
                addNativeDownloadTaskTask.g(parcel);
                AppMethodBeat.o(130381);
                return addNativeDownloadTaskTask;
            }
        };
        public int bJt = 0;
        public long crZ = 0;
        private c hwv;
        Runnable hww;

        static /* synthetic */ boolean a(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.i(130386);
            boolean aCb = addNativeDownloadTaskTask.aCb();
            AppMethodBeat.o(130386);
            return aCb;
        }

        static /* synthetic */ boolean b(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.i(130387);
            boolean aCb = addNativeDownloadTaskTask.aCb();
            AppMethodBeat.o(130387);
            return aCb;
        }

        static /* synthetic */ boolean c(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
            AppMethodBeat.i(130388);
            boolean aCb = addNativeDownloadTaskTask.aCb();
            AppMethodBeat.o(130388);
            return aCb;
        }

        public final void asP() {
            AppMethodBeat.i(130382);
            ab.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", Integer.valueOf(this.bJt));
            this.hwv = new c<h>() {
                {
                    AppMethodBeat.i(130379);
                    this.xxI = h.class.getName().hashCode();
                    AppMethodBeat.o(130379);
                }

                public final /* synthetic */ boolean a(b bVar) {
                    AppMethodBeat.i(130380);
                    h hVar = (h) bVar;
                    if (!(hVar instanceof h)) {
                        ab.w("MicroMsg.JsApiAddNativeDownloadTask", "mismatched event");
                        AppMethodBeat.o(130380);
                        return false;
                    } else if (hVar.crX.scene != 1) {
                        ab.i("MicroMsg.JsApiAddNativeDownloadTask", "not jsapi api callback");
                        AppMethodBeat.o(130380);
                        return false;
                    } else {
                        if (hVar.crX.crY) {
                            ab.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, cancel");
                            AddNativeDownloadTaskTask.this.bJt = 0;
                            AddNativeDownloadTaskTask.a(AddNativeDownloadTaskTask.this);
                        } else if (hVar.crX.crZ > 0) {
                            new HashMap().put("download_id", Long.valueOf(hVar.crX.crZ));
                            AddNativeDownloadTaskTask.this.crZ = hVar.crX.crZ;
                            ab.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, ok downloadId:%s", Long.valueOf(AddNativeDownloadTaskTask.this.crZ));
                            AddNativeDownloadTaskTask.this.bJt = 2;
                            AddNativeDownloadTaskTask.b(AddNativeDownloadTaskTask.this);
                        } else {
                            ab.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, failed");
                            AddNativeDownloadTaskTask.this.bJt = 1;
                            AddNativeDownloadTaskTask.c(AddNativeDownloadTaskTask.this);
                        }
                        a.xxA.d(AddNativeDownloadTaskTask.this.hwv);
                        AppMethodBeat.o(130380);
                        return true;
                    }
                }
            };
            a.xxA.b(this.hwv);
            AppMethodBeat.o(130382);
        }

        public final void asQ() {
            AppMethodBeat.i(130383);
            if (this.hww != null) {
                this.hww.run();
            }
            AppMethodBeat.o(130383);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130384);
            this.bJt = parcel.readInt();
            this.crZ = parcel.readLong();
            AppMethodBeat.o(130384);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130385);
            parcel.writeInt(this.bJt);
            parcel.writeLong(this.crZ);
            AppMethodBeat.o(130385);
        }

        static {
            AppMethodBeat.i(130389);
            AppMethodBeat.o(130389);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130390);
        q qVar = (q) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiAddNativeDownloadTask", "data is null");
            qVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(130390);
            return;
        }
        String optString = jSONObject.optString("taskName");
        String optString2 = jSONObject.optString("taskUrl");
        long j = bo.getLong(jSONObject.optString("taskSize"), 0);
        String optString3 = jSONObject.optString("fileMD5");
        String optString4 = jSONObject.optString("thumbUrl");
        String optString5 = jSONObject.optString("title");
        final Context context = qVar.getContext();
        ab.i("MicroMsg.JsApiAddNativeDownloadTask", "taskUrl : %s, taskSize : %s, fileMD5:[%s], title : %s, thumbUrl : %s", optString2, Long.valueOf(j), optString3, optString5, optString4);
        if (!at.isNetworkConnected(context)) {
            qVar.M(i, j("fail:fail network not connected", null));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130375);
                    Toast.makeText(context, context.getString(R.string.c5d), 0).show();
                    AppMethodBeat.o(130375);
                }
            });
            ab.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, network not ready");
            AppMethodBeat.o(130390);
        } else if (!f.Mn()) {
            qVar.M(i, j("fail:fail sdcard not ready", null));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130376);
                    Toast.makeText(context, context.getString(R.string.c5h), 0).show();
                    AppMethodBeat.o(130376);
                }
            });
            ab.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, sdcard not ready");
            AppMethodBeat.o(130390);
        } else if (j > 0 && !f.eW(j)) {
            qVar.M(i, j("fail:fail sdcard has not enough space", null));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130377);
                    Toast.makeText(context, context.getString(R.string.c5e), 0).show();
                    AppMethodBeat.o(130377);
                }
            });
            ab.i("MicroMsg.JsApiAddNativeDownloadTask", "fail, not enough space, require size = ".concat(String.valueOf(j)));
            AppMethodBeat.o(130390);
        } else if (bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiAddNativeDownloadTask", "doAddDownloadTask fail, url is null");
            qVar.M(i, j("fail:taskUrl is null or nil", null));
            AppMethodBeat.o(130390);
        } else {
            Intent intent = new Intent();
            intent.putExtra("task_name", optString);
            intent.putExtra("task_url", optString2);
            intent.putExtra("task_size", j);
            intent.putExtra("file_md5", optString3);
            intent.putExtra("appid", qVar.getAppId());
            intent.putExtra("thumb_url", optString4);
            intent.putExtra("title", optString5);
            u currentPageView = qVar.getCurrentPageView();
            if (currentPageView != null) {
                intent.putExtra("page_url", currentPageView.getURL());
            } else {
                ab.e("MicroMsg.JsApiAddNativeDownloadTask", "getCurrentPageView is null");
            }
            intent.putExtra("page_scene", 1);
            d.b(context, "webview", ".ui.tools.WebViewDownloadUI", intent);
            final MainProcessTask addNativeDownloadTaskTask = new AddNativeDownloadTaskTask();
            final q qVar2 = qVar;
            final int i2 = i;
            addNativeDownloadTaskTask.hww = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130378);
                    addNativeDownloadTaskTask.aBW();
                    HashMap hashMap = new HashMap();
                    switch (addNativeDownloadTaskTask.bJt) {
                        case 0:
                            qVar2.M(i2, JsApiAddNativeDownloadTask.this.j("fail:cancel", null));
                            AppMethodBeat.o(130378);
                            return;
                        case 1:
                            qVar2.M(i2, JsApiAddNativeDownloadTask.this.j("fail:download fail", null));
                            AppMethodBeat.o(130378);
                            return;
                        case 2:
                            hashMap.put("download_id", Long.valueOf(addNativeDownloadTaskTask.crZ));
                            qVar2.M(i2, JsApiAddNativeDownloadTask.this.j("ok", hashMap));
                            break;
                    }
                    AppMethodBeat.o(130378);
                }
            };
            addNativeDownloadTaskTask.aBV();
            AppBrandMainProcessService.a(addNativeDownloadTaskTask);
            AppMethodBeat.o(130390);
        }
    }
}
