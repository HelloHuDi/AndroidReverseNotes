package com.tencent.p177mm.plugin.wear.model.p1320a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.wear.model.a.b */
public interface C22726b {

    /* renamed from: com.tencent.mm.plugin.wear.model.a.b$a */
    public static class C22727a {
        public String aIm;
        public int code;

        C22727a() {
            this.code = 0;
        }

        C22727a(byte b) {
            this.code = 0;
            this.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
    }

    /* renamed from: B */
    C22727a mo38298B(String str, byte[] bArr);

    /* renamed from: C */
    C22727a mo38299C(String str, byte[] bArr);

    /* renamed from: a */
    byte[] mo38300a(Asset asset);

    void cUv();

    GoogleApiClient cUw();

    HashSet<String> cUx();

    boolean cUy();

    void cUz();

    void finish();

    boolean isAvailable();

    /* renamed from: q */
    boolean mo38308q(Uri uri);
}
