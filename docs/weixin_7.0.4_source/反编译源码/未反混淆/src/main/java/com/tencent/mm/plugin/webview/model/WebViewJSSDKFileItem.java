package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.al.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

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
    public a uZU;

    public static class a {
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
        webViewJSSDKImageItem.cHr = c.a("jsupimg", bo.anU(), webViewJSSDKImageItem.czD, webViewJSSDKImageItem.czD);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem aev(String str) {
        WebViewJSSDKVoiceItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
        webViewJSSDKVoiceItem.fileName = str;
        webViewJSSDKVoiceItem.bCq();
        webViewJSSDKVoiceItem.cHr = c.a("jsupvoice", bo.anU(), webViewJSSDKVoiceItem.czD, webViewJSSDKVoiceItem.czD);
        return webViewJSSDKVoiceItem;
    }

    public static WebViewJSSDKFileItem I(int i, String str, String str2) {
        WebViewJSSDKUpFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
        webViewJSSDKUpFileItem.fileType = i;
        webViewJSSDKUpFileItem.jVi = str;
        webViewJSSDKUpFileItem.heo = str2;
        webViewJSSDKUpFileItem.bCq();
        webViewJSSDKUpFileItem.cHr = c.a("jsupfile", bo.anU(), webViewJSSDKUpFileItem.czD, webViewJSSDKUpFileItem.czD);
        ab.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", Integer.valueOf(i), str2, webViewJSSDKUpFileItem.czD);
        return webViewJSSDKUpFileItem;
    }

    public static WebViewJSSDKVideoItem aew(String str) {
        WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
        webViewJSSDKVideoItem.heo = str;
        webViewJSSDKVideoItem.bCq();
        webViewJSSDKVideoItem.cHr = c.a("jsvideofile", bo.anU(), webViewJSSDKVideoItem.czD, webViewJSSDKVideoItem.czD);
        ab.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", str, webViewJSSDKVideoItem.czD, webViewJSSDKVideoItem.cHr);
        return webViewJSSDKVideoItem;
    }

    public void c(d dVar) {
        if (this.uZU == null) {
            this.uZU = new a();
        }
        if (dVar == null) {
            ab.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.uZU.field_aesKey = dVar.field_aesKey;
        this.uZU.field_fileId = dVar.field_fileId;
        this.uZU.field_fileUrl = dVar.field_fileUrl;
        this.uZU.field_fileLength = dVar.field_fileLength;
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
