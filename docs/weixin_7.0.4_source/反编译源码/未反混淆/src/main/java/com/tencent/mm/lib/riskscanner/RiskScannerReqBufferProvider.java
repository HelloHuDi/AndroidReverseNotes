package com.tencent.mm.lib.riskscanner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.d.a.c;
import com.tencent.d.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class RiskScannerReqBufferProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider");

    static {
        AppMethodBeat.i(114462);
        AppMethodBeat.o(114462);
    }

    public boolean onCreate() {
        AppMethodBeat.i(114459);
        ab.i("MicroMsg.RiskScannerReqBufferProvider", "onCreate called.");
        AppMethodBeat.o(114459);
        return true;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(114460);
        Bundle[] bundleArr = new Bundle[]{null};
        Bundle bN;
        if ("prepareReqBuffer".equals(str)) {
            ab.i("MicroMsg.RiskScannerReqBufferProvider", "invoke method: %s, with arg: %s, extras: %s", str, str2, bundle);
            bN = bN(getContext());
            AppMethodBeat.o(114460);
            return bN;
        }
        ab.w("MicroMsg.RiskScannerReqBufferProvider", "unknown method: %s", str);
        bN = bundleArr[0];
        AppMethodBeat.o(114460);
        return bN;
    }

    private Bundle bN(Context context) {
        AppMethodBeat.i(114461);
        final Bundle[] bundleArr = new Bundle[]{null};
        try {
            a.SZ();
            c.a(context, new a() {
                public final void f(int i, byte[] bArr) {
                    AppMethodBeat.i(114458);
                    a.jX(i);
                    Bundle[] bundleArr = bundleArr;
                    Bundle bundle = new Bundle();
                    bundleArr[0] = bundle;
                    if (i == 0 && bArr != null) {
                        bundle.putInt("errCode", i);
                        bundle.putByteArray("reqBufferBase64", bArr);
                    }
                    AppMethodBeat.o(114458);
                }
            });
        } catch (Throwable th) {
            a.g(th);
        }
        Bundle bundle = bundleArr[0];
        AppMethodBeat.o(114461);
        return bundle;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
