package com.tencent.p177mm.console;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Debug;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C42010ip;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.tencent.mm.console.Shell */
public final class Shell {
    private static HashMap<String, C37659a> eww = new HashMap();
    public static IntentFilter ewx = new IntentFilter();
    private static Runnable ewy = new C14544();
    public Receiver ewv = null;

    /* renamed from: com.tencent.mm.console.Shell$12 */
    static class C145112 implements C37659a {
        C145112() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16120);
            C42010ip c42010ip = new C42010ip();
            c42010ip.cDI.cDN = intent.getExtras().getString("path", "/data/local/tmp/test.apk");
            C4990ab.m7421w("MicroMsg.Shell", "hotpatch test [%s]", c42010ip.cDI.cDN);
            C4879a.xxA.mo10055m(c42010ip);
            AppMethodBeat.m2505o(16120);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$1 */
    static class C14521 implements C37659a {
        C14521() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16107);
            int intExtra = intent.getIntExtra("type", BaseClientBuilder.API_PRIORITY_OTHER);
            int intExtra2 = intent.getIntExtra("error", 0);
            if (intExtra == BaseClientBuilder.API_PRIORITY_OTHER || intExtra2 == 0) {
                AppMethodBeat.m2505o(16107);
                return;
            }
            C4990ab.m7421w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
            C1947ae.m4156cH(intExtra, intExtra2);
            AppMethodBeat.m2505o(16107);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$3 */
    static class C14533 implements C37659a {
        C14533() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16111);
            if (C5047bp.dpL() || C5047bp.dnM()) {
                String stringExtra = intent.getStringExtra("process_suffix");
                if (C5046bo.isNullOrNil(stringExtra)) {
                    if (!C4996ah.bqo()) {
                        AppMethodBeat.m2505o(16111);
                        return;
                    }
                } else if (!stringExtra.startsWith(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                    C4990ab.m7413e("MicroMsg.Shell", "bad process suffix: %s", stringExtra);
                    AppMethodBeat.m2505o(16111);
                    return;
                } else if (!C4996ah.getProcessName().endsWith(stringExtra)) {
                    AppMethodBeat.m2505o(16111);
                    return;
                }
                File file = new File(Environment.getExternalStorageDirectory(), "tencent/MicroMsg/hprofs");
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    Debug.dumpHprofData(new File(file, C4996ah.getProcessName().replace(".", "_").replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "_") + "_" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()) + ".hprof").getAbsolutePath());
                    Toast.makeText(C4996ah.getContext(), "Done.", 1).show();
                    AppMethodBeat.m2505o(16111);
                    return;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.Shell", e, "dump hprof failed.", new Object[0]);
                    Toast.makeText(C4996ah.getContext(), "Failure.", 1).show();
                    AppMethodBeat.m2505o(16111);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.Shell", "not coolassist or monkey env, disable hprof dump cmd.");
            AppMethodBeat.m2505o(16111);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$4 */
    static class C14544 implements Runnable {
        C14544() {
        }

        public final void run() {
            AppMethodBeat.m2504i(16112);
            C4990ab.m7411d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
            Object[] objArr = new Object[1];
            String str = null;
            objArr[0] = Integer.valueOf(str.length());
            C4990ab.m7411d("MicroMsg.Shell", "%d ", objArr);
            AppMethodBeat.m2505o(16112);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$10 */
    static class C924410 implements C37659a {
        C924410() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16118);
            C1947ae.giD = intent.getStringExtra("acc");
            C1947ae.giE = intent.getStringExtra("pass");
            C4990ab.m7421w("MicroMsg.Shell", "dkwt shell [%s %s]", C1947ae.giD, C1947ae.giE);
            AppMethodBeat.m2505o(16118);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$11 */
    static class C924511 implements C37659a {
        C924511() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16119);
            C1947ae.gjf = intent.getIntExtra("flag", 0);
            C4990ab.m7421w("MicroMsg.Shell", "dkwt shell [%d]", Integer.valueOf(C1947ae.gjf));
            AppMethodBeat.m2505o(16119);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$2 */
    static class C92462 implements C37659a {
        C92462() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16110);
            if (C4996ah.bqo()) {
                final String stringExtra = intent.getStringExtra(SharePluginInfo.ISSUE_KEY_SQL);
                final String stringExtra2 = intent.getStringExtra("file");
                if (stringExtra == null || stringExtra.length() <= 0) {
                    if (stringExtra2 != null && stringExtra2.length() > 0) {
                        C1720g.m3539RS().mo10302aa(new Runnable() {
                            /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb A:{SYNTHETIC, Splitter:B:38:0x00cb} */
                            /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4  */
                            /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb A:{SYNTHETIC, Splitter:B:38:0x00cb} */
                            /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4  */
                            /* JADX WARNING: Removed duplicated region for block: B:13:0x005d A:{SYNTHETIC, Splitter:B:13:0x005d} */
                            /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
                            /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6 A:{SYNTHETIC, Splitter:B:30:0x00b6} */
                            /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void run() {
                                Throwable th;
                                BufferedReader bufferedReader;
                                AppMethodBeat.m2504i(16109);
                                SQLiteDatabase dvx = C1720g.m3536RP().eJN.dvx();
                                BufferedReader bufferedReader2;
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    bufferedReader2 = new BufferedReader(new FileReader(stringExtra2));
                                    try {
                                        C4990ab.m7416i("MicroMsg.Shell", "Executing SQL from file: " + stringExtra2);
                                        while (true) {
                                            String readLine = bufferedReader2.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            dvx.execSQL(readLine);
                                        }
                                        C4990ab.m7417i("MicroMsg.Shell", "Finish executing SQL in %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e) {
                                        }
                                        if (dvx.inTransaction()) {
                                            dvx.endTransaction();
                                            AppMethodBeat.m2505o(16109);
                                            return;
                                        }
                                    } catch (FileNotFoundException e2) {
                                        try {
                                            C4990ab.m7412e("MicroMsg.Shell", "Cannot find file to execute: " + stringExtra2);
                                            if (bufferedReader2 != null) {
                                            }
                                            if (dvx.inTransaction()) {
                                            }
                                            AppMethodBeat.m2505o(16109);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            bufferedReader = bufferedReader2;
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (IOException e3) {
                                                }
                                            }
                                            if (dvx.inTransaction()) {
                                                dvx.endTransaction();
                                            }
                                            AppMethodBeat.m2505o(16109);
                                            throw th;
                                        }
                                    } catch (Exception th22) {
                                        th = th22;
                                        bufferedReader = bufferedReader2;
                                        try {
                                            C4990ab.printErrStackTrace("MicroMsg.Shell", th, "Failed to execute file: " + stringExtra2, new Object[0]);
                                            if (bufferedReader != null) {
                                            }
                                            if (dvx.inTransaction()) {
                                            }
                                            AppMethodBeat.m2505o(16109);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (bufferedReader != null) {
                                            }
                                            if (dvx.inTransaction()) {
                                            }
                                            AppMethodBeat.m2505o(16109);
                                            throw th;
                                        }
                                    }
                                } catch (FileNotFoundException e4) {
                                    bufferedReader2 = null;
                                    C4990ab.m7412e("MicroMsg.Shell", "Cannot find file to execute: " + stringExtra2);
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    if (dvx.inTransaction()) {
                                        dvx.endTransaction();
                                        AppMethodBeat.m2505o(16109);
                                        return;
                                    }
                                    AppMethodBeat.m2505o(16109);
                                } catch (Exception th32) {
                                    th = th32;
                                    bufferedReader = null;
                                    C4990ab.printErrStackTrace("MicroMsg.Shell", th, "Failed to execute file: " + stringExtra2, new Object[0]);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    if (dvx.inTransaction()) {
                                        dvx.endTransaction();
                                        AppMethodBeat.m2505o(16109);
                                        return;
                                    }
                                    AppMethodBeat.m2505o(16109);
                                } catch (Throwable th322) {
                                    th = th322;
                                    bufferedReader = null;
                                    if (bufferedReader != null) {
                                    }
                                    if (dvx.inTransaction()) {
                                    }
                                    AppMethodBeat.m2505o(16109);
                                    throw th;
                                }
                                AppMethodBeat.m2505o(16109);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(16110);
                    return;
                }
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        Cursor cursor = null;
                        AppMethodBeat.m2504i(16108);
                        SQLiteDatabase dvx = C1720g.m3536RP().eJN.dvx();
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            cursor = dvx.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, stringExtra, null, null);
                            String[] columnNames = cursor.getColumnNames();
                            int length = columnNames == null ? 0 : columnNames.length;
                            C4990ab.m7416i("MicroMsg.Shell", "Executing SQL from shell: " + stringExtra);
                            if (length > 0) {
                                C4990ab.m7416i("MicroMsg.Shell", " > " + TextUtils.join(" | ", columnNames));
                            }
                            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                            while (cursor.moveToNext()) {
                                stringBuilder.setLength(0);
                                stringBuilder.append(" > ");
                                for (int i = 0; i < length; i++) {
                                    switch (cursor.getType(i)) {
                                        case 0:
                                            stringBuilder.append("(null)");
                                            break;
                                        case 4:
                                            stringBuilder.append("(blob)");
                                            break;
                                        default:
                                            stringBuilder.append(cursor.getString(i));
                                            break;
                                    }
                                    stringBuilder.append(" | ");
                                }
                                C4990ab.m7416i("MicroMsg.Shell", stringBuilder.toString());
                            }
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            C4990ab.m7417i("MicroMsg.Shell", "Finish executing SQL in %d ms: %s", Long.valueOf(currentTimeMillis2), stringExtra);
                            if (cursor != null) {
                                cursor.close();
                                AppMethodBeat.m2505o(16108);
                                return;
                            }
                        } catch (RuntimeException e) {
                            C4990ab.m7413e("MicroMsg.Shell", "Failed to execute SQL '%s': %s", stringExtra, e.getMessage());
                            if (cursor != null) {
                                cursor.close();
                                AppMethodBeat.m2505o(16108);
                                return;
                            }
                        } catch (Throwable th) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            AppMethodBeat.m2505o(16108);
                        }
                        AppMethodBeat.m2505o(16108);
                    }
                });
                AppMethodBeat.m2505o(16110);
                return;
            }
            AppMethodBeat.m2505o(16110);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$9 */
    static class C260549 implements C37659a {
        C260549() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16117);
            C1947ae.giC = intent.getStringExtra("errmsg");
            C4990ab.m7421w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", C1947ae.giC);
            AppMethodBeat.m2505o(16117);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$a */
    public interface C37659a {
        /* renamed from: s */
        void mo4910s(Intent intent);
    }

    /* renamed from: com.tencent.mm.console.Shell$6 */
    static class C412076 implements C37659a {
        C412076() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16114);
            C1947ae.git = intent.getBooleanExtra("value", false);
            C4990ab.m7421w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", Boolean.valueOf(C1947ae.git));
            AppMethodBeat.m2505o(16114);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$8 */
    static class C412088 implements C37659a {
        C412088() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16116);
            C1947ae.giy = intent.getIntExtra("value", 0);
            C4990ab.m7421w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", Integer.toBinaryString(C1947ae.giy));
            AppMethodBeat.m2505o(16116);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$Receiver */
    public static class Receiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(16121);
            C37659a c37659a = (C37659a) Shell.eww.get(intent.getAction());
            if (c37659a == null) {
                C4990ab.m7413e("MicroMsg.Shell", "no action found for %s", r1);
                AppMethodBeat.m2505o(16121);
                return;
            }
            C4990ab.m7413e("MicroMsg.Shell", "shell action %s", r1);
            c37659a.mo4910s(intent);
            AppMethodBeat.m2505o(16121);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$5 */
    static class C452945 implements C37659a {
        C452945() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16113);
            int intExtra = intent.getIntExtra("level", 0);
            C4990ab.m7421w("MicroMsg.Shell", "kiro set Log.level=%d", Integer.valueOf(C4990ab.getLogLevel()));
            C4990ab.m7406LZ(intExtra);
            AppMethodBeat.m2505o(16113);
        }
    }

    /* renamed from: com.tencent.mm.console.Shell$7 */
    static class C452957 implements C37659a {
        C452957() {
        }

        /* renamed from: s */
        public final void mo4910s(Intent intent) {
            AppMethodBeat.m2504i(16115);
            C1947ae.giz = intent.getIntExtra("key", 0);
            C1947ae.giA = intent.getIntExtra("val", 0);
            C1947ae.giB = intent.getStringExtra("str");
            C4990ab.m7421w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", Integer.valueOf(C1947ae.giz), Integer.valueOf(C1947ae.giA), C1947ae.giB);
            if (10009 == C1947ae.giz) {
                int i = C1947ae.giA;
                Shell.m83521Nw();
                AppMethodBeat.m2505o(16115);
            } else if (10014 == C1947ae.giz && C4996ah.bqo()) {
                C18668n.ahW().mo44214a(7, 1, "");
                AppMethodBeat.m2505o(16115);
            } else {
                if (10015 == C1947ae.giz) {
                    C4996ah.doE();
                }
                AppMethodBeat.m2505o(16115);
            }
        }
    }

    /* renamed from: Nw */
    static /* synthetic */ void m83521Nw() {
    }

    static {
        AppMethodBeat.m2504i(16123);
        Shell.m83523a("wechat.shell.SET_NEXTRET", new C14521());
        Shell.m83523a("wechat.shell.SET_LOGLEVEL", new C452945());
        Shell.m83523a("wechat.shell.SET_CDNTRANS", new C412076());
        Shell.m83523a("wechat.shell.SET_DKTEST", new C452957());
        Shell.m83523a("wechat.shell.NET_DNS_TEST", new C412088());
        Shell.m83523a("wechat.shell.IDC_ERROR", new C260549());
        Shell.m83523a("wechat.shell.SET_DK_WT_TEST", new C924410());
        Shell.m83523a("wechat.shell.SET_MUTE_ROOM_TEST", new C924511());
        Shell.m83523a("wechat.shell.HOTPATCH_TEST", new C145112());
        Shell.m83523a("wechat.shell.EXEC_SQL", new C92462());
        Shell.m83523a("wechat.shell.DUMP_HPROF", new C14533());
        AppMethodBeat.m2505o(16123);
    }

    /* renamed from: a */
    private static void m83523a(String str, C37659a c37659a) {
        AppMethodBeat.m2504i(16122);
        ewx.addAction(str);
        eww.put(str, c37659a);
        AppMethodBeat.m2505o(16122);
    }
}
