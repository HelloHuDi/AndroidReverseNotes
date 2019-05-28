package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebViewJSSDKVideoItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKVideoItem> CREATOR = new Creator<WebViewJSSDKVideoItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKVideoItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(6727);
            WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem(parcel);
            AppMethodBeat.o(6727);
            return webViewJSSDKVideoItem;
        }
    };
    public int duration;
    public int height;
    public int size;
    public int width;

    public WebViewJSSDKVideoItem() {
        this.cyQ = 4;
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.i(6728);
        this.czD = ap.aeB(this.heo);
        AppMethodBeat.o(6728);
        return this;
    }

    public final String cXJ() {
        return "mp4";
    }

    public final String cXK() {
        return "video";
    }

    protected WebViewJSSDKVideoItem(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(6729);
        this.cyQ = parcel.readInt();
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        AppMethodBeat.o(6729);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(6730);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.cyQ);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        AppMethodBeat.o(6730);
    }

    static {
        AppMethodBeat.i(6731);
        AppMethodBeat.o(6731);
    }
}
