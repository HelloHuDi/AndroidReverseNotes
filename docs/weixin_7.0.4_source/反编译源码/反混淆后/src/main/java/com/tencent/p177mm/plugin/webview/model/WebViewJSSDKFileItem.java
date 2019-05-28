package com.tencent.p177mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem */
public abstract class WebViewJSSDKFileItem implements Parcelable {
    public String appId;
    public String cHr;
    public int cyQ;
    public String czD;
    public String fileName;
    public String hGG;
    public String heo;
    public String hep;
    public boolean her;
    public boolean hes = true;
    public boolean het = true;
    public C14505a uZU;

    /* renamed from: com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem$a */
    public static class C14505a {
        public String field_aesKey;
        public String field_fileId;
        public int field_fileLength;
        public String field_fileUrl;
    }

    public abstract WebViewJSSDKFileItem bCq();

    public abstract String cXJ();

    public abstract String cXK();

    public static WebViewJSSDKFileItem aeu(String str) {
        WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.heo = str;
        webViewJSSDKImageItem.bCq();
        webViewJSSDKImageItem.cHr = C37458c.m63162a("jsupimg", C5046bo.anU(), webViewJSSDKImageItem.czD, webViewJSSDKImageItem.czD);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem aev(String str) {
        WebViewJSSDKVoiceItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
        webViewJSSDKVoiceItem.fileName = str;
        webViewJSSDKVoiceItem.bCq();
        webViewJSSDKVoiceItem.cHr = C37458c.m63162a("jsupvoice", C5046bo.anU(), webViewJSSDKVoiceItem.czD, webViewJSSDKVoiceItem.czD);
        return webViewJSSDKVoiceItem;
    }

    /* renamed from: I */
    public static WebViewJSSDKFileItem m22709I(int i, String str, String str2) {
        WebViewJSSDKUpFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
        webViewJSSDKUpFileItem.fileType = i;
        webViewJSSDKUpFileItem.jVi = str;
        webViewJSSDKUpFileItem.heo = str2;
        webViewJSSDKUpFileItem.bCq();
        webViewJSSDKUpFileItem.cHr = C37458c.m63162a("jsupfile", C5046bo.anU(), webViewJSSDKUpFileItem.czD, webViewJSSDKUpFileItem.czD);
        C4990ab.m7411d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", Integer.valueOf(i), str2, webViewJSSDKUpFileItem.czD);
        return webViewJSSDKUpFileItem;
    }

    public static WebViewJSSDKVideoItem aew(String str) {
        WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
        webViewJSSDKVideoItem.heo = str;
        webViewJSSDKVideoItem.bCq();
        webViewJSSDKVideoItem.cHr = C37458c.m63162a("jsvideofile", C5046bo.anU(), webViewJSSDKVideoItem.czD, webViewJSSDKVideoItem.czD);
        C4990ab.m7411d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", str, webViewJSSDKVideoItem.czD, webViewJSSDKVideoItem.cHr);
        return webViewJSSDKVideoItem;
    }

    /* renamed from: c */
    public void mo26740c(C9545d c9545d) {
        if (this.uZU == null) {
            this.uZU = new C14505a();
        }
        if (c9545d == null) {
            C4990ab.m7412e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.uZU.field_aesKey = c9545d.field_aesKey;
        this.uZU.field_fileId = c9545d.field_fileId;
        this.uZU.field_fileUrl = c9545d.field_fileUrl;
        this.uZU.field_fileLength = c9545d.field_fileLength;
    }

    protected WebViewJSSDKFileItem(Parcel parcel) {
        this.appId = parcel.readString();
        this.czD = parcel.readString();
        this.hGG = parcel.readString();
        this.heo = parcel.readString();
        this.cyQ = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.czD);
        parcel.writeString(this.hGG);
        parcel.writeString(this.heo);
        parcel.writeInt(this.cyQ);
    }
}
