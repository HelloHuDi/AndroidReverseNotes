package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashSet;

public interface b {

    public static class a {
        public String aIm;
        public int code;

        a() {
            this.code = 0;
        }

        a(byte b) {
            this.code = 0;
            this.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
    }

    a B(String str, byte[] bArr);

    a C(String str, byte[] bArr);

    byte[] a(Asset asset);

    void cUv();

    GoogleApiClient cUw();

    HashSet<String> cUx();

    boolean cUy();

    void cUz();

    void finish();

    boolean isAvailable();

    boolean q(Uri uri);
}
