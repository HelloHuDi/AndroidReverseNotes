package com.tencent.p177mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem */
public class WebViewJSSDKImageItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKImageItem> CREATOR = new C356071();

    /* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem$1 */
    static class C356071 implements Creator<WebViewJSSDKImageItem> {
        C356071() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKImageItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(6718);
            WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem(parcel);
            AppMethodBeat.m2505o(6718);
            return webViewJSSDKImageItem;
        }
    }

    public WebViewJSSDKImageItem() {
        this.cyQ = 1;
    }

    public final void cXL() {
        AppMethodBeat.m2504i(6719);
        if (new File(this.heo).exists()) {
            this.hGG = C43914ap.aez(System.currentTimeMillis());
            Bitmap d = C5056d.m7659d(this.heo, 640, 640, false);
            if (d != null) {
                C4990ab.m7416i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
                d = C5056d.m7648b(d, (float) ExifHelper.m7368bJ(this.heo));
                if (d != null) {
                    try {
                        C5056d.m7625a(d, 100, CompressFormat.JPEG, this.hGG, true);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", e.getMessage());
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", this.hGG);
            AppMethodBeat.m2505o(6719);
            return;
        }
        C4990ab.m7416i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
        AppMethodBeat.m2505o(6719);
    }

    public final WebViewJSSDKFileItem bCq() {
        AppMethodBeat.m2504i(6720);
        this.czD = C43914ap.aeB(this.heo);
        cXL();
        AppMethodBeat.m2505o(6720);
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
        AppMethodBeat.m2504i(6721);
        super.writeToParcel(parcel, i);
        AppMethodBeat.m2505o(6721);
    }

    protected WebViewJSSDKImageItem(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.m2504i(6722);
        AppMethodBeat.m2505o(6722);
    }
}
