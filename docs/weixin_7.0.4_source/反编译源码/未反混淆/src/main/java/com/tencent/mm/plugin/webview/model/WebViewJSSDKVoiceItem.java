package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.q;

public class WebViewJSSDKVoiceItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKVoiceItem> CREATOR = new Creator<WebViewJSSDKVoiceItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKVoiceItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(6732);
            WebViewJSSDKVoiceItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem(parcel);
            AppMethodBeat.o(6732);
            return webViewJSSDKVoiceItem;
        }
    };

    public WebViewJSSDKVoiceItem() {
        this.cyQ = 2;
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.i(6733);
        this.heo = q.getFullPath(this.fileName);
        this.czD = ap.aeB(this.heo);
        AppMethodBeat.o(6733);
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
        AppMethodBeat.i(6734);
        super.writeToParcel(parcel, i);
        AppMethodBeat.o(6734);
    }

    protected WebViewJSSDKVoiceItem(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(6735);
        AppMethodBeat.o(6735);
    }
}
