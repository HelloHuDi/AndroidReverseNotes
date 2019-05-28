package com.tencent.p177mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.p177mm.plugin.extqlauncher.C45910b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher */
public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final String[] lPA = new String[]{"retCode"};
    private static final UriMatcher lQc;
    private static final String[] lRU = new String[]{"id", "count"};
    private Context context;
    private String[] lPN;
    private int lRV = -1;

    static {
        AppMethodBeat.m2504i(20492);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        lQc.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        lQc.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
        AppMethodBeat.m2505o(20492);
    }

    public ExtControlProviderQLauncher(String[] strArr, int i, Context context) {
        this.lPN = strArr;
        this.lRV = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(20490);
        C4990ab.m7410d("MicroMsg.ExtControlProviderQLauncher", "query()");
        mo61883a(uri, this.context, this.lRV, this.lPN);
        Cursor cursor;
        if (uri == null) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20490);
            return null;
        } else if (C5046bo.isNullOrNil(this.lPW) || C5046bo.isNullOrNil(brL())) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20490);
            return null;
        } else if (!aVl()) {
            mo61890vf(1);
            cursor = this.jDN;
            AppMethodBeat.m2505o(20490);
            return cursor;
        } else if (mo61888dJ(this.context)) {
            switch (this.lRV) {
                case 18:
                    C4990ab.m7410d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        mo61890vf(4);
                        AppMethodBeat.m2505o(20490);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    C25985d.m41467b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    cursor = new MatrixCursor(lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(1)});
                    mo61890vf(0);
                    AppMethodBeat.m2505o(20490);
                    return cursor;
                case 19:
                    C4990ab.m7410d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        mo61890vf(4);
                        AppMethodBeat.m2505o(20490);
                        return null;
                    }
                    C25985d.m41467b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    cursor = new MatrixCursor(lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(1)});
                    mo61890vf(0);
                    AppMethodBeat.m2505o(20490);
                    return cursor;
                case 20:
                    cursor = m76410A(strArr2);
                    AppMethodBeat.m2505o(20490);
                    return cursor;
                default:
                    mo61890vf(3);
                    AppMethodBeat.m2505o(20490);
                    return null;
            }
        } else {
            C4990ab.m7420w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            mo61890vf(2);
            AppMethodBeat.m2505o(20490);
            return null;
        }
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

    /* renamed from: A */
    private Cursor m76410A(String[] strArr) {
        AppMethodBeat.m2504i(20491);
        C4990ab.m7410d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            mo61890vf(4);
            AppMethodBeat.m2505o(20491);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20491);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(lRU);
            int i = 0;
            while (i < strArr.length && i < 10) {
                try {
                    if (!C5046bo.isNullOrNil(strArr[i])) {
                        if (strArr[i].equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = strArr[i];
                            C45910b.bsa();
                            objArr[1] = Integer.valueOf(C45910b.bsb());
                            matrixCursor.addRow(objArr);
                        } else {
                            String Fs = C42781b.m75855Fs(strArr[i]);
                            if (!C5046bo.isNullOrNil(Fs)) {
                                C9638aw.m17190ZK();
                                if (C18628c.m29083XR().aoZ(Fs) != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(C18628c.m29083XR().aoZ(Fs).field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(0)});
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", e.getMessage());
                    mo61890vf(4);
                    matrixCursor.close();
                    AppMethodBeat.m2505o(20491);
                    return null;
                }
            }
            mo61890vf(0);
            AppMethodBeat.m2505o(20491);
            return matrixCursor;
        }
    }
}
