package com.tencent.p177mm.lib.riskscanner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p1164a.C17722c;
import com.tencent.p127d.p1164a.C17722c.C17723a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider */
public class RiskScannerReqBufferProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider");

    static {
        AppMethodBeat.m2504i(114462);
        AppMethodBeat.m2505o(114462);
    }

    public boolean onCreate() {
        AppMethodBeat.m2504i(114459);
        C4990ab.m7416i("MicroMsg.RiskScannerReqBufferProvider", "onCreate called.");
        AppMethodBeat.m2505o(114459);
        return true;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(114460);
        Bundle[] bundleArr = new Bundle[]{null};
        Bundle bN;
        if ("prepareReqBuffer".equals(str)) {
            C4990ab.m7417i("MicroMsg.RiskScannerReqBufferProvider", "invoke method: %s, with arg: %s, extras: %s", str, str2, bundle);
            bN = m63919bN(getContext());
            AppMethodBeat.m2505o(114460);
            return bN;
        }
        C4990ab.m7421w("MicroMsg.RiskScannerReqBufferProvider", "unknown method: %s", str);
        bN = bundleArr[0];
        AppMethodBeat.m2505o(114460);
        return bN;
    }

    /* renamed from: bN */
    private Bundle m63919bN(Context context) {
        AppMethodBeat.m2504i(114461);
        final Bundle[] bundleArr = new Bundle[]{null};
        try {
            C18528a.m28834SZ();
            C17722c.m27645a(context, new C17723a() {
                /* renamed from: f */
                public final void mo32829f(int i, byte[] bArr) {
                    AppMethodBeat.m2504i(114458);
                    C18528a.m28836jX(i);
                    Bundle[] bundleArr = bundleArr;
                    Bundle bundle = new Bundle();
                    bundleArr[0] = bundle;
                    if (i == 0 && bArr != null) {
                        bundle.putInt("errCode", i);
                        bundle.putByteArray("reqBufferBase64", bArr);
                    }
                    AppMethodBeat.m2505o(114458);
                }
            });
        } catch (Throwable th) {
            C18528a.m28835g(th);
        }
        Bundle bundle = bundleArr[0];
        AppMethodBeat.m2505o(114461);
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
