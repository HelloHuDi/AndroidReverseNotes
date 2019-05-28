package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;

public class WebViewJSSDKImageItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKImageItem> CREATOR = new Creator<WebViewJSSDKImageItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKImageItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(6718);
            WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem(parcel);
            AppMethodBeat.o(6718);
            return webViewJSSDKImageItem;
        }
    };

    public WebViewJSSDKImageItem() {
        this.cyQ = 1;
    }

    public final void cXL() {
        AppMethodBeat.i(6719);
        if (new File(this.heo).exists()) {
            this.hGG = ap.aez(System.currentTimeMillis());
            Bitmap d = d.d(this.heo, 640, 640, false);
            if (d != null) {
                ab.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
                d = d.b(d, (float) ExifHelper.bJ(this.heo));
                if (d != null) {
                    try {
                        d.a(d, 100, CompressFormat.JPEG, this.hGG, true);
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", e.getMessage());
                    }
                }
            }
            ab.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", this.hGG);
            AppMethodBeat.o(6719);
            return;
        }
        ab.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
        AppMethodBeat.o(6719);
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.i(6720);
        this.czD = ap.aeB(this.heo);
        cXL();
        AppMethodBeat.o(6720);
        return this;
    }

    public final String cXJ() {
        return "jpeg";
    }

    public final String cXK() {
        return "image";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(6721);
        super.writeToParcel(parcel, i);
        AppMethodBeat.o(6721);
    }

    protected WebViewJSSDKImageItem(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(6722);
        AppMethodBeat.o(6722);
    }
}
