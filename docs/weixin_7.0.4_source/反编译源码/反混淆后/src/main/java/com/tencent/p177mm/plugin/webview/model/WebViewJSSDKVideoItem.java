package com.tencent.p177mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem */
public class WebViewJSSDKVideoItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKVideoItem> CREATOR = new C298111();
    public int duration;
    public int height;
    public int size;
    public int width;

    /* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem$1 */
    static class C298111 implements Creator<WebViewJSSDKVideoItem> {
        C298111() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKVideoItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(6727);
            WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem(parcel);
            AppMethodBeat.m2505o(6727);
            return webViewJSSDKVideoItem;
        }
    }

    public WebViewJSSDKVideoItem() {
        this.cyQ = 4;
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.m2504i(6728);
        this.czD = C43914ap.aeB(this.heo);
        AppMethodBeat.m2505o(6728);
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
        AppMethodBeat.m2504i(6729);
        this.cyQ = parcel.readInt();
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        AppMethodBeat.m2505o(6729);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(6730);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.cyQ);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        AppMethodBeat.m2505o(6730);
    }

    static {
        AppMethodBeat.m2504i(6731);
        AppMethodBeat.m2505o(6731);
    }
}
