package com.tencent.p177mm.sandbox.monitor;

import android.content.Intent;
import android.os.Build;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1171c;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p178a.C1184r;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sandbox.monitor.C30273b.C30274a;
import com.tencent.p177mm.sandbox.updater.AppUpdaterUI;
import com.tencent.p177mm.sdk.p603e.C4894a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac;
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

/* renamed from: com.tencent.mm.sandbox.monitor.a */
public final class C30270a {
    static final HashMap<String, Integer> ewT;

    /* renamed from: com.tencent.mm.sandbox.monitor.a$1 */
    static class C302711 implements FilenameFilter {
        C302711() {
        }

        public final boolean accept(File file, String str) {
            return str.endsWith(".crashlog");
        }
    }

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
        File file = new File(C5128ac.eSj + "crash/");
        if (!file.exists()) {
            C4990ab.m7420w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
            return -1;
        } else if (file.isFile()) {
            file.delete();
            C4990ab.m7420w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
            return -1;
        } else {
            String[] list = file.list(new C302711());
            if (list == null || list.length == 0) {
                return -1;
            }
            Pattern compile = Pattern.compile(".");
            for (CharSequence split : list) {
                String[] split2 = compile.split(split);
                if (split2 != null && split2.length > 0) {
                    C30270a.m48153hO(split2[0], split2.length >= 2 ? split2[1] : "");
                }
            }
            return 1;
        }
    }

    /* renamed from: hO */
    private static int m48153hO(String str, String str2) {
        String str3 = C5128ac.eSj + "crash/" + str + "." + str2 + ".crashini";
        long c = C5046bo.m7534c(C4894a.m7287hW(str3, "count"));
        long anU = C5046bo.anU() - C5046bo.m7534c(C4894a.m7287hW(str3, "lasttime"));
        String str4 = C5128ac.eSj + "crash/" + str + "." + str2 + ".crashlog";
        int cs = C1173e.m2560cs(str4);
        C4990ab.m7410d("MicroMsg.CrashUpload", "dkcrash count:" + c + " t:" + anU + " len:" + cs);
        if (cs < 5242880) {
            C30270a.m48152az(str, str2, str4);
        }
        C1173e.deleteFile(str4);
        C4894a.m7288hX(str3, "count");
        C4894a.m7289p(str3, "lasttime", C5046bo.anU());
        return 1;
    }

    /* renamed from: az */
    private static void m48152az(String str, String str2, String str3) {
        byte[] f = C1173e.m2571f(str3, 0, -1);
        if (!C5046bo.m7540cb(f)) {
            final int length = f.length;
            final String toLowerCase = C1178g.m2591x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(C7243d.vxo), Integer.valueOf(length)}).getBytes()).toLowerCase();
            f = C1184r.compress(f);
            final PByteArray pByteArray = new PByteArray();
            C1171c.m2554a(pByteArray, f, toLowerCase.getBytes());
            final String str4 = str2;
            final String str5 = str;
            C7305d.post(new Runnable() {
                public final void run() {
                    StringBuilder append = new StringBuilder().append("http://" + C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com")).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(C7243d.vxo)).append("&devicetype=").append(C7243d.eSg).append("&filelength=").append(length).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=").append(C5046bo.m7567h((Integer) C30270a.ewT.get(str4)));
                    if (!(str5 == null || str5.equals(""))) {
                        append.append("&username=").append(str5);
                    }
                    C4990ab.m7410d("MicroMsg.CrashUpload", "dkcrash sb:" + append.toString());
                    C30270a.m48148E(append.toString(), pByteArray.value);
                }
            }, "CrashUpload_upload");
        }
    }

    /* renamed from: a */
    public static int m48149a(String str, String str2, C30274a c30274a) {
        if (C5046bo.isNullOrNil(c30274a.toString())) {
            return -1;
        }
        File file = new File(C5128ac.eSj + "crash/");
        if (!file.exists()) {
            file.mkdir();
        }
        String str3 = C5128ac.eSj + "crash/" + str + "." + str2 + ".crashini";
        C4894a.m7289p(str3, "count", C5046bo.m7534c(C4894a.m7287hW(str3, "count")) + 1);
        if (C5046bo.m7534c(C4894a.m7287hW(str3, "lasttime")) == 0) {
            C4894a.m7289p(str3, "lasttime", C5046bo.anU());
        }
        C4990ab.m7411d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", C5128ac.eSj + "crash/" + str + "." + str2 + ".crashlog", Integer.valueOf(c30274a.toString().length()));
        C30270a.m48150a(c30274a);
        C30270a.m48151a(str3, c30274a);
        return C30270a.m48153hO(str, str2);
    }

    /* renamed from: a */
    private static void m48150a(C30274a c30274a) {
        if (c30274a.xvn) {
            File file = new File(C6457e.eSo);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (C5046bo.m7566gb(file2.lastModified()) > 604800000) {
                        C4990ab.m7417i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", file2.getPath());
                        file2.delete();
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", C6457e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt");
            C30270a.m48151a(r0, c30274a);
        }
    }

    /* renamed from: a */
    private static void m48151a(String str, C30274a c30274a) {
        if (!new File(str).exists()) {
            int i = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                String gN = C5046bo.m7552gN(C4996ah.getContext());
                if (C5046bo.isNullOrNil(gN)) {
                    stringBuilder.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
                } else {
                    stringBuilder.append("uin[" + gN + "] ");
                }
            } else {
                stringBuilder.append("uin[" + C1183p.getString(i) + "] ");
            }
            stringBuilder.append(C4990ab.getSysInfo());
            stringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
            String[] LT = C1427q.m3035LT();
            stringBuilder.append("c1[" + LT[0] + "] ");
            stringBuilder.append("c2[" + LT[1] + "] ");
            stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            C1173e.m2568e(str, stringBuilder.toString().getBytes());
        }
        if (C1173e.m2560cs(str) > 10485760) {
            C1173e.deleteFile(str);
        }
        C1173e.m2568e(str, (c30274a.toString() + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
    }

    /* renamed from: E */
    static /* synthetic */ void m48148E(String str, byte[] bArr) {
        C4990ab.m7412e("MicroMsg.CrashUpload", "doPost : url = " + str + ", data.length = " + bArr.length);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(str);
        try {
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            String convertStreamToString = C5046bo.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent());
            if (convertStreamToString != null && convertStreamToString.length() > 0) {
                final Map z = C5049br.m7595z(convertStreamToString, "Response");
                if (!(z == null || !"-1000".equalsIgnoreCase((String) z.get(".Response.retCode")) || z.get(".Response.url") == null)) {
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            Intent intent = new Intent(C4996ah.getContext(), AppUpdaterUI.class);
                            intent.addFlags(268435456);
                            intent.putExtra("intent_extra_desc", (String) z.get(".Response.desc"));
                            intent.putExtra("intent_update_type", 999);
                            intent.putExtra("intent_extra_download_url", new String[]{(String) z.get(".Response.url")});
                            C4996ah.getContext().startActivity(intent);
                        }
                    }, 500);
                }
            }
            C4990ab.m7410d("MicroMsg.CrashUpload", convertStreamToString);
            C4990ab.m7413e("MicroMsg.CrashUpload", "doPost: returnConnection = %s", convertStreamToString);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CrashUpload", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.CrashUpload", "doPost e type: %s, msg: %s", e.getClass().getSimpleName(), e.getMessage());
        }
    }
}
