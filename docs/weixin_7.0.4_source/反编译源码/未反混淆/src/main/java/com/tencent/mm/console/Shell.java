package com.tencent.mm.console;

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
import com.tencent.mm.g.a.ip;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
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

public final class Shell {
    private static HashMap<String, a> eww = new HashMap();
    public static IntentFilter ewx = new IntentFilter();
    private static Runnable ewy = new Runnable() {
        public final void run() {
            AppMethodBeat.i(16112);
            ab.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
            Object[] objArr = new Object[1];
            String str = null;
            objArr[0] = Integer.valueOf(str.length());
            ab.d("MicroMsg.Shell", "%d ", objArr);
            AppMethodBeat.o(16112);
        }
    };
    public Receiver ewv = null;

    public interface a {
        void s(Intent intent);
    }

    public static class Receiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(16121);
            a aVar = (a) Shell.eww.get(intent.getAction());
            if (aVar == null) {
                ab.e("MicroMsg.Shell", "no action found for %s", r1);
                AppMethodBeat.o(16121);
                return;
            }
            ab.e("MicroMsg.Shell", "shell action %s", r1);
            aVar.s(intent);
            AppMethodBeat.o(16121);
        }
    }

    static /* synthetic */ void Nw() {
    }

    static {
        AppMethodBeat.i(16123);
        a("wechat.shell.SET_NEXTRET", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16107);
                int intExtra = intent.getIntExtra("type", BaseClientBuilder.API_PRIORITY_OTHER);
                int intExtra2 = intent.getIntExtra("error", 0);
                if (intExtra == BaseClientBuilder.API_PRIORITY_OTHER || intExtra2 == 0) {
                    AppMethodBeat.o(16107);
                    return;
                }
                ab.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                ae.cH(intExtra, intExtra2);
                AppMethodBeat.o(16107);
            }
        });
        a("wechat.shell.SET_LOGLEVEL", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16113);
                int intExtra = intent.getIntExtra("level", 0);
                ab.w("MicroMsg.Shell", "kiro set Log.level=%d", Integer.valueOf(ab.getLogLevel()));
                ab.LZ(intExtra);
                AppMethodBeat.o(16113);
            }
        });
        a("wechat.shell.SET_CDNTRANS", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16114);
                ae.git = intent.getBooleanExtra("value", false);
                ab.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", Boolean.valueOf(ae.git));
                AppMethodBeat.o(16114);
            }
        });
        a("wechat.shell.SET_DKTEST", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16115);
                ae.giz = intent.getIntExtra("key", 0);
                ae.giA = intent.getIntExtra("val", 0);
                ae.giB = intent.getStringExtra("str");
                ab.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", Integer.valueOf(ae.giz), Integer.valueOf(ae.giA), ae.giB);
                if (10009 == ae.giz) {
                    int i = ae.giA;
                    Shell.Nw();
                    AppMethodBeat.o(16115);
                } else if (10014 == ae.giz && ah.bqo()) {
                    n.ahW().a(7, 1, "");
                    AppMethodBeat.o(16115);
                } else {
                    if (10015 == ae.giz) {
                        ah.doE();
                    }
                    AppMethodBeat.o(16115);
                }
            }
        });
        a("wechat.shell.NET_DNS_TEST", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16116);
                ae.giy = intent.getIntExtra("value", 0);
                ab.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", Integer.toBinaryString(ae.giy));
                AppMethodBeat.o(16116);
            }
        });
        a("wechat.shell.IDC_ERROR", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16117);
                ae.giC = intent.getStringExtra("errmsg");
                ab.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", ae.giC);
                AppMethodBeat.o(16117);
            }
        });
        a("wechat.shell.SET_DK_WT_TEST", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16118);
                ae.giD = intent.getStringExtra("acc");
                ae.giE = intent.getStringExtra("pass");
                ab.w("MicroMsg.Shell", "dkwt shell [%s %s]", ae.giD, ae.giE);
                AppMethodBeat.o(16118);
            }
        });
        a("wechat.shell.SET_MUTE_ROOM_TEST", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16119);
                ae.gjf = intent.getIntExtra("flag", 0);
                ab.w("MicroMsg.Shell", "dkwt shell [%d]", Integer.valueOf(ae.gjf));
                AppMethodBeat.o(16119);
            }
        });
        a("wechat.shell.HOTPATCH_TEST", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16120);
                ip ipVar = new ip();
                ipVar.cDI.cDN = intent.getExtras().getString("path", "/data/local/tmp/test.apk");
                ab.w("MicroMsg.Shell", "hotpatch test [%s]", ipVar.cDI.cDN);
                com.tencent.mm.sdk.b.a.xxA.m(ipVar);
                AppMethodBeat.o(16120);
            }
        });
        a("wechat.shell.EXEC_SQL", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16110);
                if (ah.bqo()) {
                    final String stringExtra = intent.getStringExtra(SharePluginInfo.ISSUE_KEY_SQL);
                    final String stringExtra2 = intent.getStringExtra("file");
                    if (stringExtra == null || stringExtra.length() <= 0) {
                        if (stringExtra2 != null && stringExtra2.length() > 0) {
                            g.RS().aa(new Runnable() {
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
                                    AppMethodBeat.i(16109);
                                    SQLiteDatabase dvx = g.RP().eJN.dvx();
                                    BufferedReader bufferedReader2;
                                    try {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        bufferedReader2 = new BufferedReader(new FileReader(stringExtra2));
                                        try {
                                            ab.i("MicroMsg.Shell", "Executing SQL from file: " + stringExtra2);
                                            while (true) {
                                                String readLine = bufferedReader2.readLine();
                                                if (readLine == null) {
                                                    break;
                                                }
                                                dvx.execSQL(readLine);
                                            }
                                            ab.i("MicroMsg.Shell", "Finish executing SQL in %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            try {
                                                bufferedReader2.close();
                                            } catch (IOException e) {
                                            }
                                            if (dvx.inTransaction()) {
                                                dvx.endTransaction();
                                                AppMethodBeat.o(16109);
                                                return;
                                            }
                                        } catch (FileNotFoundException e2) {
                                            try {
                                                ab.e("MicroMsg.Shell", "Cannot find file to execute: " + stringExtra2);
                                                if (bufferedReader2 != null) {
                                                }
                                                if (dvx.inTransaction()) {
                                                }
                                                AppMethodBeat.o(16109);
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
                                                AppMethodBeat.o(16109);
                                                throw th;
                                            }
                                        } catch (Exception th22) {
                                            th = th22;
                                            bufferedReader = bufferedReader2;
                                            try {
                                                ab.printErrStackTrace("MicroMsg.Shell", th, "Failed to execute file: " + stringExtra2, new Object[0]);
                                                if (bufferedReader != null) {
                                                }
                                                if (dvx.inTransaction()) {
                                                }
                                                AppMethodBeat.o(16109);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (bufferedReader != null) {
                                                }
                                                if (dvx.inTransaction()) {
                                                }
                                                AppMethodBeat.o(16109);
                                                throw th;
                                            }
                                        }
                                    } catch (FileNotFoundException e4) {
                                        bufferedReader2 = null;
                                        ab.e("MicroMsg.Shell", "Cannot find file to execute: " + stringExtra2);
                                        if (bufferedReader2 != null) {
                                            try {
                                                bufferedReader2.close();
                                            } catch (IOException e5) {
                                            }
                                        }
                                        if (dvx.inTransaction()) {
                                            dvx.endTransaction();
                                            AppMethodBeat.o(16109);
                                            return;
                                        }
                                        AppMethodBeat.o(16109);
                                    } catch (Exception th32) {
                                        th = th32;
                                        bufferedReader = null;
                                        ab.printErrStackTrace("MicroMsg.Shell", th, "Failed to execute file: " + stringExtra2, new Object[0]);
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e6) {
                                            }
                                        }
                                        if (dvx.inTransaction()) {
                                            dvx.endTransaction();
                                            AppMethodBeat.o(16109);
                                            return;
                                        }
                                        AppMethodBeat.o(16109);
                                    } catch (Throwable th322) {
                                        th = th322;
                                        bufferedReader = null;
                                        if (bufferedReader != null) {
                                        }
                                        if (dvx.inTransaction()) {
                                        }
                                        AppMethodBeat.o(16109);
                                        throw th;
                                    }
                                    AppMethodBeat.o(16109);
                                }
                            });
                        }
                        AppMethodBeat.o(16110);
                        return;
                    }
                    g.RS().aa(new Runnable() {
                        public final void run() {
                            Cursor cursor = null;
                            AppMethodBeat.i(16108);
                            SQLiteDatabase dvx = g.RP().eJN.dvx();
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                cursor = dvx.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, stringExtra, null, null);
                                String[] columnNames = cursor.getColumnNames();
                                int length = columnNames == null ? 0 : columnNames.length;
                                ab.i("MicroMsg.Shell", "Executing SQL from shell: " + stringExtra);
                                if (length > 0) {
                                    ab.i("MicroMsg.Shell", " > " + TextUtils.join(" | ", columnNames));
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
                                    ab.i("MicroMsg.Shell", stringBuilder.toString());
                                }
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                ab.i("MicroMsg.Shell", "Finish executing SQL in %d ms: %s", Long.valueOf(currentTimeMillis2), stringExtra);
                                if (cursor != null) {
                                    cursor.close();
                                    AppMethodBeat.o(16108);
                                    return;
                                }
                            } catch (RuntimeException e) {
                                ab.e("MicroMsg.Shell", "Failed to execute SQL '%s': %s", stringExtra, e.getMessage());
                                if (cursor != null) {
                                    cursor.close();
                                    AppMethodBeat.o(16108);
                                    return;
                                }
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                AppMethodBeat.o(16108);
                            }
                            AppMethodBeat.o(16108);
                        }
                    });
                    AppMethodBeat.o(16110);
                    return;
                }
                AppMethodBeat.o(16110);
            }
        });
        a("wechat.shell.DUMP_HPROF", new a() {
            public final void s(Intent intent) {
                AppMethodBeat.i(16111);
                if (bp.dpL() || bp.dnM()) {
                    String stringExtra = intent.getStringExtra("process_suffix");
                    if (bo.isNullOrNil(stringExtra)) {
                        if (!ah.bqo()) {
                            AppMethodBeat.o(16111);
                            return;
                        }
                    } else if (!stringExtra.startsWith(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                        ab.e("MicroMsg.Shell", "bad process suffix: %s", stringExtra);
                        AppMethodBeat.o(16111);
                        return;
                    } else if (!ah.getProcessName().endsWith(stringExtra)) {
                        AppMethodBeat.o(16111);
                        return;
                    }
                    File file = new File(Environment.getExternalStorageDirectory(), "tencent/MicroMsg/hprofs");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    try {
                        Debug.dumpHprofData(new File(file, ah.getProcessName().replace(".", "_").replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "_") + "_" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()) + ".hprof").getAbsolutePath());
                        Toast.makeText(ah.getContext(), "Done.", 1).show();
                        AppMethodBeat.o(16111);
                        return;
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.Shell", e, "dump hprof failed.", new Object[0]);
                        Toast.makeText(ah.getContext(), "Failure.", 1).show();
                        AppMethodBeat.o(16111);
                        return;
                    }
                }
                ab.e("MicroMsg.Shell", "not coolassist or monkey env, disable hprof dump cmd.");
                AppMethodBeat.o(16111);
            }
        });
        AppMethodBeat.o(16123);
    }

    private static void a(String str, a aVar) {
        AppMethodBeat.i(16122);
        ewx.addAction(str);
        eww.put(str, aVar);
        AppMethodBeat.o(16122);
    }
}
