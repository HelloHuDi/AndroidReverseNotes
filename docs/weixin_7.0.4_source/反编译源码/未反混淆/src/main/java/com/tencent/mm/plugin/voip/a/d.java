package com.tencent.mm.plugin.voip.a;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.app.v.c;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.m.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class d {
    private static final String SYS_INFO;
    public static Context sZj = null;
    private static final Uri sZk = Uri.parse("content://com.lbe.security.miui.permmgr/active");

    static {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_NORMAL);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
        stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
        stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
        stringBuilder.append("] BOARD:[" + Build.BOARD);
        stringBuilder.append("] DEVICE:[" + Build.DEVICE);
        stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
        stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        stringBuilder.append("] HOST:[" + Build.HOST);
        stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        stringBuilder.append("] MODEL:[" + Build.MODEL);
        stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
        stringBuilder.append("] TAGS:[" + Build.TAGS);
        stringBuilder.append("] TYPE:[" + Build.TYPE);
        stringBuilder.append("] USER:[" + Build.USER + "]");
        SYS_INFO = stringBuilder.toString();
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_NORMAL);
    }

    public static boolean cLt() {
        return true;
    }

    public static int cLu() {
        return VERSION.SDK_INT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A:{SYNTHETIC, Splitter:B:15:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A:{Splitter:B:3:0x001d, PHI: r1 , ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:22:0x0061, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:23:0x0062, code skipped:
            r2 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean cLv() {
        InputStream inputStream = null;
        boolean z = false;
        AppMethodBeat.i(5007);
        InputStream fileInputStream;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("ro.miui.ui.version.name", null);
                if (property != null && property.equals("V6")) {
                    z = true;
                }
                e.p(fileInputStream);
            } catch (IOException e) {
                if (fileInputStream != null) {
                }
                e.p(fileInputStream);
                ab.d("VoipUtil", "isMIUIv6 ".concat(String.valueOf(z)));
                AppMethodBeat.o(5007);
                return z;
            } catch (Throwable th) {
            }
        } catch (IOException e2) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            e.p(fileInputStream);
            ab.d("VoipUtil", "isMIUIv6 ".concat(String.valueOf(z)));
            AppMethodBeat.o(5007);
            return z;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            e.p(inputStream);
            AppMethodBeat.o(5007);
            throw th3;
        }
        ab.d("VoipUtil", "isMIUIv6 ".concat(String.valueOf(z)));
        AppMethodBeat.o(5007);
        return z;
    }

    public static boolean fd(Context context) {
        AppMethodBeat.i(ReaderCallback.READER_PDF_LIST);
        boolean z = false;
        if (cLv()) {
            z = fg(context);
        }
        ab.d("VoipUtil", "isLbePermissionEnable ret:".concat(String.valueOf(z)));
        AppMethodBeat.o(ReaderCallback.READER_PDF_LIST);
        return z;
    }

    public static boolean fe(Context context) {
        AppMethodBeat.i(ReaderCallback.READER_PPT_PLAY_MODEL);
        boolean z = false;
        if (cLv()) {
            z = ff(context);
        }
        ab.d("VoipUtil", "setLbePermissionEnable ret:".concat(String.valueOf(z)));
        AppMethodBeat.o(ReaderCallback.READER_PPT_PLAY_MODEL);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d6 A:{Splitter:B:1:0x000c, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:32:0x00d6, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:33:0x00d7, code skipped:
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:45:0x0105, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:46:0x0106, code skipped:
            r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean ff(Context context) {
        int i;
        int i2;
        int i3;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(ReaderCallback.READER_TXT_READING_MODEL);
        ContentResolver contentResolver;
        Cursor query;
        try {
            contentResolver = context.getContentResolver();
            query = contentResolver.query(sZk, new String[]{"userAccept"}, "pkgName='com.tencent.mm'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToLast()) {
                        i = query.getInt(0);
                        if (query != null) {
                            query.close();
                        }
                        ab.d("VoipUtil", "setLbePermissionEnable query ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                        i2 = -1;
                        if (i != -1 || contentResolver == null) {
                            i3 = -1;
                        } else {
                            i |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("userAccept", Integer.valueOf(i));
                                i3 = contentResolver.update(sZk, contentValues, "pkgName='com.tencent.mm'", null);
                                try {
                                    ab.d("VoipUtil", "serLbePermissionEnable update ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), " ret: ", Integer.valueOf(i3));
                                } catch (Throwable th3) {
                                    th = th3;
                                    i2 = i3;
                                    ab.w("VoipUtil", "isLbePermissionEnable update ", th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                                    if (i2 <= 0) {
                                    }
                                }
                            } catch (Throwable th22) {
                                th = th22;
                            }
                        }
                        i2 = i3;
                        if (i2 <= 0) {
                            AppMethodBeat.o(ReaderCallback.READER_TXT_READING_MODEL);
                            return true;
                        }
                        AppMethodBeat.o(ReaderCallback.READER_TXT_READING_MODEL);
                        return false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        ab.w("VoipUtil", "isLbePermissionEnable query ", th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                        if (query != null) {
                            query.close();
                            i = -1;
                        } else {
                            i = -1;
                        }
                        ab.d("VoipUtil", "setLbePermissionEnable query ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                        i2 = -1;
                        if (i != -1) {
                        }
                        i3 = -1;
                        i2 = i3;
                        if (i2 <= 0) {
                        }
                    } catch (Throwable th5) {
                        th22 = th5;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(ReaderCallback.READER_TXT_READING_MODEL);
                        throw th22;
                    }
                }
            }
            i = -1;
            if (query != null) {
            }
        } catch (Throwable th6) {
        }
        ab.d("VoipUtil", "setLbePermissionEnable query ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        i2 = -1;
        if (i != -1) {
        }
        i3 = -1;
        i2 = i3;
        if (i2 <= 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean fg(Context context) {
        Throwable th;
        AppMethodBeat.i(ReaderCallback.INSTALL_QB);
        Cursor query;
        try {
            query = context.getContentResolver().query(sZk, new String[]{"suggestAccept", "userAccept", "userPrompt", "userReject"}, "pkgName='com.tencent.mm'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToLast()) {
                        boolean z = ((query.getInt(0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT && (query.getInt(2) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0 && (query.getInt(3) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) || (query.getInt(1) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(ReaderCallback.INSTALL_QB);
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ab.w("gray", "isLbePermissionEnable", th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(ReaderCallback.INSTALL_QB);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(ReaderCallback.INSTALL_QB);
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(ReaderCallback.INSTALL_QB);
            throw th;
        }
        AppMethodBeat.o(ReaderCallback.INSTALL_QB);
        return false;
    }

    public static void fh(Context context) {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_STATUS);
        Toast.makeText(context, R.string.f5u, 0).show();
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_STATUS);
    }

    public static int vn(String str) {
        int i = 0;
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_CANLOAD);
        try {
            i = bo.getInt(g.Nu().getValue(str), 0);
        } catch (Exception e) {
            ab.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_CANLOAD);
        return i;
    }

    public static boolean cLw() {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_DOWNLOADING);
        ba baVar = new ba();
        a.xxA.m(baVar);
        boolean z = baVar.cuj.aFV;
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_DOWNLOADING);
        return z;
    }

    public static boolean cLx() {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_FIXSCREEN);
        ui uiVar = new ui();
        uiVar.cQx.cAd = 2;
        a.xxA.m(uiVar);
        boolean z = uiVar.cQy.cQz;
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_FIXSCREEN);
        return z;
    }

    public static boolean cLy() {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_NORMAL);
        bj bjVar = new bj();
        a.xxA.m(bjVar);
        boolean z = bjVar.cuD.aFV;
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_NORMAL);
        return z;
    }

    public static boolean cLz() {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_PRESS);
        ay ayVar = new ay();
        a.xxA.m(ayVar);
        boolean z = ayVar.cue.cuf;
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_PRESS);
        return z;
    }

    public static Notification c(c cVar) {
        AppMethodBeat.i(ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN);
        Notification build;
        if (com.tencent.mm.compatible.util.d.fP(16)) {
            build = cVar.build();
            AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN);
            return build;
        }
        build = cVar.build();
        AppMethodBeat.o(ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN);
        return build;
    }
}
