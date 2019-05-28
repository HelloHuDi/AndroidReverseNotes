package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.File;
import java.util.ArrayList;

public class WebViewJSSDKUpFileItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKUpFileItem> CREATOR = new Creator<WebViewJSSDKUpFileItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKUpFileItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(6723);
            WebViewJSSDKUpFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
            AppMethodBeat.o(6723);
            return webViewJSSDKUpFileItem;
        }
    };
    public int fileType;
    public String jVi;

    public WebViewJSSDKUpFileItem() {
        this.fileType = -1;
        this.cyQ = 3;
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.i(6724);
        this.czD = ap.aeB(this.heo);
        AppMethodBeat.o(6724);
        return this;
    }

    public final void c(d dVar) {
        AppMethodBeat.i(6725);
        super.c(dVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fileType);
        arrayList.add(this.jVi);
        arrayList.add(dVar.field_fileId);
        arrayList.add(dVar.field_aesKey);
        arrayList.add(dVar.field_fileLength);
        Context context = ah.getContext();
        if (at.isWifi(context)) {
            arrayList.add("1");
        } else if (at.is3G(context)) {
            arrayList.add("4");
        } else if (at.is4G(context)) {
            arrayList.add("5");
        } else if (at.is2G(context)) {
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (at.isWap(context)) {
            arrayList.add("2");
        } else {
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        ab.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", Integer.valueOf(this.fileType), this.jVi, dVar.field_fileId);
        h hVar = h.pYm;
        h.g(12018, arrayList);
        String str = this.heo;
        if (!bo.isNullOrNil(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        AppMethodBeat.o(6725);
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
        AppMethodBeat.i(6726);
        AppMethodBeat.o(6726);
    }
}
