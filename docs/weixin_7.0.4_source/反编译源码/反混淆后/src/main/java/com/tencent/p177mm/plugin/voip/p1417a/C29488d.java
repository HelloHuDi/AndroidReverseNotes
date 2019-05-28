package com.tencent.p177mm.plugin.voip.p1417a;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.p057v4.app.C0363v.C0358c;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C18229ba;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C6460bj;
import com.tencent.p177mm.p230g.p231a.C9295ay;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* renamed from: com.tencent.mm.plugin.voip.a.d */
public final class C29488d {
    private static final String SYS_INFO;
    public static Context sZj = null;
    private static final Uri sZk = Uri.parse("content://com.lbe.security.miui.permmgr/active");

    static {
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_NORMAL);
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
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_NORMAL);
    }

    public static boolean cLt() {
        return true;
    }

    public static int cLu() {
        return VERSION.SDK_INT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A:{SYNTHETIC, Splitter:B:15:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A:{PHI: r1 , Splitter:B:3:0x001d, ExcHandler: all (th java.lang.Throwable)} */
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
        AppMethodBeat.m2504i(5007);
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
                C1173e.m2573p(fileInputStream);
            } catch (IOException e) {
                if (fileInputStream != null) {
                }
                C1173e.m2573p(fileInputStream);
                C4990ab.m7410d("VoipUtil", "isMIUIv6 ".concat(String.valueOf(z)));
                AppMethodBeat.m2505o(5007);
                return z;
            } catch (Throwable th) {
            }
        } catch (IOException e2) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            C1173e.m2573p(fileInputStream);
            C4990ab.m7410d("VoipUtil", "isMIUIv6 ".concat(String.valueOf(z)));
            AppMethodBeat.m2505o(5007);
            return z;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            C1173e.m2573p(inputStream);
            AppMethodBeat.m2505o(5007);
            throw th3;
        }
        C4990ab.m7410d("VoipUtil", "isMIUIv6 ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(5007);
        return z;
    }

    /* renamed from: fd */
    public static boolean m46801fd(Context context) {
        AppMethodBeat.m2504i(ReaderCallback.READER_PDF_LIST);
        boolean z = false;
        if (C29488d.cLv()) {
            z = C29488d.m46804fg(context);
        }
        C4990ab.m7410d("VoipUtil", "isLbePermissionEnable ret:".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(ReaderCallback.READER_PDF_LIST);
        return z;
    }

    /* renamed from: fe */
    public static boolean m46802fe(Context context) {
        AppMethodBeat.m2504i(ReaderCallback.READER_PPT_PLAY_MODEL);
        boolean z = false;
        if (C29488d.cLv()) {
            z = C29488d.m46803ff(context);
        }
        C4990ab.m7410d("VoipUtil", "setLbePermissionEnable ret:".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(ReaderCallback.READER_PPT_PLAY_MODEL);
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
    /* renamed from: ff */
    private static boolean m46803ff(Context context) {
        int i;
        int i2;
        int i3;
        Throwable th;
        Throwable th2;
        AppMethodBeat.m2504i(ReaderCallback.READER_TXT_READING_MODEL);
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
                        C4990ab.m7411d("VoipUtil", "setLbePermissionEnable query ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
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
                                    C4990ab.m7411d("VoipUtil", "serLbePermissionEnable update ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), " ret: ", Integer.valueOf(i3));
                                } catch (Throwable th3) {
                                    th = th3;
                                    i2 = i3;
                                    C4990ab.m7421w("VoipUtil", "isLbePermissionEnable update ", th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                                    if (i2 <= 0) {
                                    }
                                }
                            } catch (Throwable th22) {
                                th = th22;
                            }
                        }
                        i2 = i3;
                        if (i2 <= 0) {
                            AppMethodBeat.m2505o(ReaderCallback.READER_TXT_READING_MODEL);
                            return true;
                        }
                        AppMethodBeat.m2505o(ReaderCallback.READER_TXT_READING_MODEL);
                        return false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        C4990ab.m7421w("VoipUtil", "isLbePermissionEnable query ", th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                        if (query != null) {
                            query.close();
                            i = -1;
                        } else {
                            i = -1;
                        }
                        C4990ab.m7411d("VoipUtil", "setLbePermissionEnable query ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
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
                        AppMethodBeat.m2505o(ReaderCallback.READER_TXT_READING_MODEL);
                        throw th22;
                    }
                }
            }
            i = -1;
            if (query != null) {
            }
        } catch (Throwable th6) {
        }
        C4990ab.m7411d("VoipUtil", "setLbePermissionEnable query ua: ", Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
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
    /* renamed from: fg */
    private static boolean m46804fg(Context context) {
        Throwable th;
        AppMethodBeat.m2504i(ReaderCallback.INSTALL_QB);
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
                        AppMethodBeat.m2505o(ReaderCallback.INSTALL_QB);
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C4990ab.m7421w("gray", "isLbePermissionEnable", th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(ReaderCallback.INSTALL_QB);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(ReaderCallback.INSTALL_QB);
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
            AppMethodBeat.m2505o(ReaderCallback.INSTALL_QB);
            throw th;
        }
        AppMethodBeat.m2505o(ReaderCallback.INSTALL_QB);
        return false;
    }

    /* renamed from: fh */
    public static void m46805fh(Context context) {
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_STATUS);
        Toast.makeText(context, C25738R.string.f5u, 0).show();
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_STATUS);
    }

    /* renamed from: vn */
    public static int m46806vn(String str) {
        int i = 0;
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_CANLOAD);
        try {
            i = C5046bo.getInt(C26373g.m41964Nu().getValue(str), 0);
        } catch (Exception e) {
            C4990ab.m7412e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_CANLOAD);
        return i;
    }

    public static boolean cLw() {
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_DOWNLOADING);
        C18229ba c18229ba = new C18229ba();
        C4879a.xxA.mo10055m(c18229ba);
        boolean z = c18229ba.cuj.aFV;
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_DOWNLOADING);
        return z;
    }

    public static boolean cLx() {
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_COMMAND_FIXSCREEN);
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 2;
        C4879a.xxA.mo10055m(c26250ui);
        boolean z = c26250ui.cQy.cQz;
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_COMMAND_FIXSCREEN);
        return z;
    }

    public static boolean cLy() {
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_NORMAL);
        C6460bj c6460bj = new C6460bj();
        C4879a.xxA.mo10055m(c6460bj);
        boolean z = c6460bj.cuD.aFV;
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_NORMAL);
        return z;
    }

    public static boolean cLz() {
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_PRESS);
        C9295ay c9295ay = new C9295ay();
        C4879a.xxA.mo10055m(c9295ay);
        boolean z = c9295ay.cue.cuf;
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_PRESS);
        return z;
    }

    /* renamed from: c */
    public static Notification m46800c(C0358c c0358c) {
        AppMethodBeat.m2504i(ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN);
        Notification build;
        if (C1443d.m3067fP(16)) {
            build = c0358c.build();
            AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN);
            return build;
        }
        build = c0358c.build();
        AppMethodBeat.m2505o(ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN);
        return build;
    }
}
