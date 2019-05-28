package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final String[] lPA = new String[]{"retCode"};
    private static final UriMatcher lQc;
    private static final String[] lRU = new String[]{"id", "count"};
    private Context context;
    private String[] lPN;
    private int lRV = -1;

    static {
        AppMethodBeat.i(20492);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        lQc.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        lQc.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
        AppMethodBeat.o(20492);
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
        AppMethodBeat.i(20490);
        ab.d("MicroMsg.ExtControlProviderQLauncher", "query()");
        a(uri, this.context, this.lRV, this.lPN);
        Cursor cursor;
        if (uri == null) {
            vf(3);
            AppMethodBeat.o(20490);
            return null;
        } else if (bo.isNullOrNil(this.lPW) || bo.isNullOrNil(brL())) {
            vf(3);
            AppMethodBeat.o(20490);
            return null;
        } else if (!aVl()) {
            vf(1);
            cursor = this.jDN;
            AppMethodBeat.o(20490);
            return cursor;
        } else if (dJ(this.context)) {
            switch (this.lRV) {
                case 18:
                    ab.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        vf(4);
                        AppMethodBeat.o(20490);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    cursor = new MatrixCursor(lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(1)});
                    vf(0);
                    AppMethodBeat.o(20490);
                    return cursor;
                case 19:
                    ab.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        vf(4);
                        AppMethodBeat.o(20490);
                        return null;
                    }
                    d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    cursor = new MatrixCursor(lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(1)});
                    vf(0);
                    AppMethodBeat.o(20490);
                    return cursor;
                case 20:
                    cursor = A(strArr2);
                    AppMethodBeat.o(20490);
                    return cursor;
                default:
                    vf(3);
                    AppMethodBeat.o(20490);
                    return null;
            }
        } else {
            ab.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            vf(2);
            AppMethodBeat.o(20490);
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

    private Cursor A(String[] strArr) {
        AppMethodBeat.i(20491);
        ab.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            vf(4);
            AppMethodBeat.o(20491);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            ab.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            vf(3);
            AppMethodBeat.o(20491);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(lRU);
            int i = 0;
            while (i < strArr.length && i < 10) {
                try {
                    if (!bo.isNullOrNil(strArr[i])) {
                        if (strArr[i].equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = strArr[i];
                            b.bsa();
                            objArr[1] = Integer.valueOf(b.bsb());
                            matrixCursor.addRow(objArr);
                        } else {
                            String Fs = com.tencent.mm.plugin.base.model.b.Fs(strArr[i]);
                            if (!bo.isNullOrNil(Fs)) {
                                aw.ZK();
                                if (c.XR().aoZ(Fs) != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(c.XR().aoZ(Fs).field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(0)});
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    ab.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", e.getMessage());
                    vf(4);
                    matrixCursor.close();
                    AppMethodBeat.o(20491);
                    return null;
                }
            }
            vf(0);
            AppMethodBeat.o(20491);
            return matrixCursor;
        }
    }
}
