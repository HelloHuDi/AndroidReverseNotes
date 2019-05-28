package com.tencent.p177mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem */
public class WebViewJSSDKUpFileItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKUpFileItem> CREATOR = new C356081();
    public int fileType;
    public String jVi;

    /* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem$1 */
    static class C356081 implements Creator<WebViewJSSDKUpFileItem> {
        C356081() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKUpFileItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(6723);
            WebViewJSSDKUpFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
            AppMethodBeat.m2505o(6723);
            return webViewJSSDKUpFileItem;
        }
    }

    public WebViewJSSDKUpFileItem() {
        this.fileType = -1;
        this.cyQ = 3;
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.m2504i(6724);
        this.czD = C43914ap.aeB(this.heo);
        AppMethodBeat.m2505o(6724);
        return this;
    }

    /* renamed from: c */
    public final void mo26740c(C9545d c9545d) {
        AppMethodBeat.m2504i(6725);
        super.mo26740c(c9545d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fileType);
        arrayList.add(this.jVi);
        arrayList.add(c9545d.field_fileId);
        arrayList.add(c9545d.field_aesKey);
        arrayList.add(c9545d.field_fileLength);
        Context context = C4996ah.getContext();
        if (C5023at.isWifi(context)) {
            arrayList.add("1");
        } else if (C5023at.is3G(context)) {
            arrayList.add("4");
        } else if (C5023at.is4G(context)) {
            arrayList.add("5");
        } else if (C5023at.is2G(context)) {
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (C5023at.isWap(context)) {
            arrayList.add("2");
        } else {
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        C4990ab.m7411d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", Integer.valueOf(this.fileType), this.jVi, c9545d.field_fileId);
        C7060h c7060h = C7060h.pYm;
        C7060h.m11802g(12018, arrayList);
        String str = this.heo;
        if (!C5046bo.isNullOrNil(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        AppMethodBeat.m2505o(6725);
    }

    public final String cXJ() {
        return "file";
    }

    public final String cXK() {
        return "nomal";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    private WebViewJSSDKUpFileItem(byte b) {
        this.fileType = -1;
    }

    static {
        AppMethodBeat.m2504i(6726);
        AppMethodBeat.m2505o(6726);
    }
}
