package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.Build;
import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.p;
import com.tencent.mm.a.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    static final HashMap<String, Integer> ewT;

    static {
        HashMap hashMap = new HashMap(16);
        ewT = hashMap;
        hashMap.put("exception", Integer.valueOf(10001));
        ewT.put("anr", Integer.valueOf(10002));
        ewT.put("handler", Integer.valueOf(10003));
        ewT.put(SharePluginInfo.ISSUE_KEY_SQL, Integer.valueOf(10004));
        ewT.put("permission", Integer.valueOf(10005));
        ewT.put("main_thread_watch", Integer.valueOf(10006));
    }

    public static int dnc() {
        File file = new File(ac.eSj + "crash/");
        if (!file.exists()) {
            ab.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
            return -1;
        } else if (file.isFile()) {
            file.delete();
            ab.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
            return -1;
        } else {
            String[] list = file.list(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str.endsWith(".crashlog");
                }
            });
            if (list == null || list.length == 0) {
                return -1;
            }
            Pattern compile = Pattern.compile(".");
            for (CharSequence split : list) {
                String[] split2 = compile.split(split);
                if (split2 != null && split2.length > 0) {
                    hO(split2[0], split2.length >= 2 ? split2[1] : "");
                }
            }
            return 1;
        }
    }

    private static int hO(String str, String str2) {
        String str3 = ac.eSj + "crash/" + str + "." + str2 + ".crashini";
        long c = bo.c(com.tencent.mm.sdk.e.a.hW(str3, "count"));
        long anU = bo.anU() - bo.c(com.tencent.mm.sdk.e.a.hW(str3, "lasttime"));
        String str4 = ac.eSj + "crash/" + str + "." + str2 + ".crashlog";
        int cs = e.cs(str4);
        ab.d("MicroMsg.CrashUpload", "dkcrash count:" + c + " t:" + anU + " len:" + cs);
        if (cs < 5242880) {
            az(str, str2, str4);
        }
        e.deleteFile(str4);
        com.tencent.mm.sdk.e.a.hX(str3, "count");
        com.tencent.mm.sdk.e.a.p(str3, "lasttime", bo.anU());
        return 1;
    }

    private static void az(String str, String str2, String str3) {
        byte[] f = e.f(str3, 0, -1);
        if (!bo.cb(f)) {
            final int length = f.length;
            final String toLowerCase = g.x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.vxo), Integer.valueOf(length)}).getBytes()).toLowerCase();
            f = r.compress(f);
            final PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, f, toLowerCase.getBytes());
            final String str4 = str2;
            final String str5 = str;
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    StringBuilder append = new StringBuilder().append("http://" + ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com")).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.vxo)).append("&devicetype=").append(d.eSg).append("&filelength=").append(length).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=").append(bo.h((Integer) a.ewT.get(str4)));
                    if (!(str5 == null || str5.equals(""))) {
                        append.append("&username=").append(str5);
                    }
                    ab.d("MicroMsg.CrashUpload", "dkcrash sb:" + append.toString());
                    a.E(append.toString(), pByteArray.value);
                }
            }, "CrashUpload_upload");
        }
    }

    public static int a(String str, String str2, a aVar) {
        if (bo.isNullOrNil(aVar.toString())) {
            return -1;
        }
        File file = new File(ac.eSj + "crash/");
        if (!file.exists()) {
            file.mkdir();
        }
        String str3 = ac.eSj + "crash/" + str + "." + str2 + ".crashini";
        com.tencent.mm.sdk.e.a.p(str3, "count", bo.c(com.tencent.mm.sdk.e.a.hW(str3, "count")) + 1);
        if (bo.c(com.tencent.mm.sdk.e.a.hW(str3, "lasttime")) == 0) {
            com.tencent.mm.sdk.e.a.p(str3, "lasttime", bo.anU());
        }
        ab.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", ac.eSj + "crash/" + str + "." + str2 + ".crashlog", Integer.valueOf(aVar.toString().length()));
        a(aVar);
        a(str3, aVar);
        return hO(str, str2);
    }

    private static void a(a aVar) {
        if (aVar.xvn) {
            File file = new File(com.tencent.mm.compatible.util.e.eSo);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (bo.gb(file2.lastModified()) > 604800000) {
                        ab.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", file2.getPath());
                        file2.delete();
                    }
                }
            }
            ab.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", com.tencent.mm.compatible.util.e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt");
            a(r0, aVar);
        }
    }

    private static void a(String str, a aVar) {
        if (!new File(str).exists()) {
            int i = ah.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                String gN = bo.gN(ah.getContext());
                if (bo.isNullOrNil(gN)) {
                    stringBuilder.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
                } else {
                    stringBuilder.append("uin[" + gN + "] ");
                }
            } else {
                stringBuilder.append("uin[" + p.getString(i) + "] ");
            }
            stringBuilder.append(ab.getSysInfo());
            stringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
            String[] LT = q.LT();
            stringBuilder.append("c1[" + LT[0] + "] ");
            stringBuilder.append("c2[" + LT[1] + "] ");
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            e.e(str, stringBuilder.toString().getBytes());
        }
        if (e.cs(str) > 10485760) {
            e.deleteFile(str);
        }
        e.e(str, (aVar.toString() + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
    }

    static /* synthetic */ void E(String str, byte[] bArr) {
        ab.e("MicroMsg.CrashUpload", "doPost : url = " + str + ", data.length = " + bArr.length);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(str);
        try {
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            String convertStreamToString = bo.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent());
            if (convertStreamToString != null && convertStreamToString.length() > 0) {
                final Map z = br.z(convertStreamToString, "Response");
                if (!(z == null || !"-1000".equalsIgnoreCase((String) z.get(".Response.retCode")) || z.get(".Response.url") == null)) {
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            Intent intent = new Intent(ah.getContext(), AppUpdaterUI.class);
                            intent.addFlags(268435456);
                            intent.putExtra("intent_extra_desc", (String) z.get(".Response.desc"));
                            intent.putExtra("intent_update_type", 999);
                            intent.putExtra("intent_extra_download_url", new String[]{(String) z.get(".Response.url")});
                            ah.getContext().startActivity(intent);
                        }
                    }, 500);
                }
            }
            ab.d("MicroMsg.CrashUpload", convertStreamToString);
            ab.e("MicroMsg.CrashUpload", "doPost: returnConnection = %s", convertStreamToString);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CrashUpload", e, "", new Object[0]);
            ab.e("MicroMsg.CrashUpload", "doPost e type: %s, msg: %s", e.getClass().getSimpleName(), e.getMessage());
        }
    }
}
