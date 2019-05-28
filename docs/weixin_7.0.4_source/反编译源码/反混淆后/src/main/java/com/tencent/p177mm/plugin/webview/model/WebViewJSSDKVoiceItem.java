package com.tencent.p177mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C32850q;

/* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKVoiceItem */
public class WebViewJSSDKVoiceItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKVoiceItem> CREATOR = new C402511();

    /* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKVoiceItem$1 */
    static class C402511 implements Creator<WebViewJSSDKVoiceItem> {
        C402511() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKVoiceItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(6732);
            WebViewJSSDKVoiceItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem(parcel);
            AppMethodBeat.m2505o(6732);
            return webViewJSSDKVoiceItem;
        }
    }

    public WebViewJSSDKVoiceItem() {
        this.cyQ = 2;
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.m2504i(6733);
        this.heo = C32850q.getFullPath(this.fileName);
        this.czD = C43914ap.aeB(this.heo);
        AppMethodBeat.m2505o(6733);
        return this;
    }

    public final String cXJ() {
        return "speex";
    }

    public final String cXK() {
        return "voice";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(6734);
        super.writeToParcel(parcel, i);
        AppMethodBeat.m2505o(6734);
    }

    protected WebViewJSSDKVoiceItem(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.m2504i(6735);
        AppMethodBeat.m2505o(6735);
    }
}
