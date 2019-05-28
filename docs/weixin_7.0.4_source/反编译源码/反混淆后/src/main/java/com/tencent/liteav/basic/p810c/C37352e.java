package com.tencent.liteav.basic.p810c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C37356a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.liteav.basic.c.e */
public class C37352e {
    /* renamed from: l */
    private static C37352e f15872l;
    /* renamed from: a */
    private Context f15873a;
    /* renamed from: b */
    private String f15874b;
    /* renamed from: c */
    private String f15875c;
    /* renamed from: d */
    private String f15876d = "TXUgcSDK.licence";
    /* renamed from: e */
    private String f15877e = "tmp.licence";
    /* renamed from: f */
    private String f15878f = "YTFaceSDK.licence";
    /* renamed from: g */
    private String f15879g = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
    /* renamed from: h */
    private String f15880h;
    /* renamed from: i */
    private String f15881i;
    /* renamed from: j */
    private String f15882j;
    /* renamed from: k */
    private boolean f15883k = false;
    /* renamed from: m */
    private boolean f15884m = false;
    /* renamed from: n */
    private int f15885n = -1;

    /* renamed from: com.tencent.liteav.basic.c.e$1 */
    class C373511 implements C25646b {
        C373511() {
        }

        /* renamed from: a */
        public void mo43373a(File file) {
            AppMethodBeat.m2504i(66126);
            TXCLog.m15677i("LicenceCheck", "downloadLicense, onSaveSuccess");
            String a = C37352e.m62756a(C37352e.this);
            if (TextUtils.isEmpty(a)) {
                TXCLog.m15676e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
                C37352e.this.f15883k = false;
                AppMethodBeat.m2505o(66126);
                return;
            }
            if (C37352e.m62752a(C37352e.this, a, null) == 0) {
                C37352e.m62764b(C37352e.this);
            }
            AppMethodBeat.m2505o(66126);
        }

        /* renamed from: a */
        public void mo43374a(File file, Exception exception) {
            AppMethodBeat.m2504i(66127);
            TXCLog.m15677i("LicenceCheck", "downloadLicense, onSaveFailed");
            AppMethodBeat.m2505o(66127);
        }

        /* renamed from: a */
        public void mo43372a(int i) {
            AppMethodBeat.m2504i(66128);
            TXCLog.m15677i("LicenceCheck", "downloadLicense, onProgressUpdate");
            AppMethodBeat.m2505o(66128);
        }

        /* renamed from: a */
        public void mo43371a() {
            AppMethodBeat.m2504i(66129);
            TXCLog.m15677i("LicenceCheck", "downloadLicense, onProcessEnd");
            C37352e.this.f15883k = false;
            AppMethodBeat.m2505o(66129);
        }
    }

    /* renamed from: a */
    public static C37352e m62754a() {
        AppMethodBeat.m2504i(66098);
        if (f15872l == null) {
            f15872l = new C37352e();
        }
        C37352e c37352e = f15872l;
        AppMethodBeat.m2505o(66098);
        return c37352e;
    }

    private C37352e() {
    }

    /* renamed from: a */
    public void mo60121a(Context context, String str, String str2) {
        AppMethodBeat.m2504i(66099);
        this.f15873a = context.getApplicationContext();
        this.f15874b = str;
        this.f15875c = str2;
        if (this.f15873a != null && m62769c()) {
            this.f15880h = this.f15873a.getExternalFilesDir(null).getAbsolutePath();
            if (!m62765b(this.f15880h + File.separator + this.f15876d)) {
                TXCLog.m15675d("LicenceCheck", "setLicense, sdcard file not exist, to download");
                mo60122b();
            }
        }
        AppMethodBeat.m2505o(66099);
    }

    /* renamed from: b */
    public void mo60122b() {
        AppMethodBeat.m2504i(66100);
        if (TextUtils.isEmpty(this.f15874b)) {
            TXCLog.m15676e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
            AppMethodBeat.m2505o(66100);
        } else if (this.f15883k) {
            TXCLog.m15677i("LicenceCheck", "downloadLicense, in downloading, ignore");
            AppMethodBeat.m2505o(66100);
        } else {
            C373511 c373511 = new C373511();
            if (this.f15873a == null) {
                TXCLog.m15676e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
                AppMethodBeat.m2505o(66100);
                return;
            }
            File externalFilesDir = this.f15873a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                TXCLog.m15676e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
                AppMethodBeat.m2505o(66100);
                return;
            }
            this.f15880h = externalFilesDir.getAbsolutePath();
            new Thread(new C17776c(this.f15873a, this.f15874b, this.f15880h, this.f15877e, c373511, false)).start();
            this.f15883k = true;
            AppMethodBeat.m2505o(66100);
        }
    }

    /* renamed from: a */
    public int mo60118a(C41679f c41679f, Context context) {
        AppMethodBeat.m2504i(66101);
        int b = m62762b(c41679f, context);
        if (b != 0) {
            mo60122b();
        }
        AppMethodBeat.m2505o(66101);
        return b;
    }

    /* renamed from: b */
    private int m62762b(C41679f c41679f, Context context) {
        AppMethodBeat.m2504i(66102);
        if (this.f15884m) {
            AppMethodBeat.m2505o(66102);
            return 0;
        }
        if (this.f15873a == null) {
            this.f15873a = context;
        }
        if (m62761b(c41679f) == 0) {
            this.f15884m = true;
            AppMethodBeat.m2505o(66102);
            return 0;
        }
        int a = m62753a(c41679f);
        if (a == 0) {
            this.f15884m = true;
            AppMethodBeat.m2505o(66102);
            return 0;
        }
        AppMethodBeat.m2505o(66102);
        return a;
    }

    /* renamed from: a */
    private int m62753a(C41679f c41679f) {
        AppMethodBeat.m2504i(66103);
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalFilesDir = this.f15873a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                TXCLog.m15676e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
                AppMethodBeat.m2505o(66103);
                return -10;
            }
            String str = externalFilesDir.getAbsolutePath() + File.separator + this.f15876d;
            if (m62765b(str)) {
                str = C37356a.m62795b(str);
                if (TextUtils.isEmpty(str)) {
                    TXCLog.m15676e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
                    AppMethodBeat.m2505o(66103);
                    return -8;
                }
                int a = mo60119a(str, c41679f);
                AppMethodBeat.m2505o(66103);
                return a;
            }
            AppMethodBeat.m2505o(66103);
            return -7;
        }
        TXCLog.m15676e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
        AppMethodBeat.m2505o(66103);
        return -10;
    }

    /* renamed from: b */
    private int m62761b(C41679f c41679f) {
        AppMethodBeat.m2504i(66104);
        if (m62770d()) {
            String b = C37356a.m62794b(this.f15873a, this.f15876d);
            if (TextUtils.isEmpty(b)) {
                TXCLog.m15676e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
                AppMethodBeat.m2505o(66104);
                return -8;
            }
            int a = mo60119a(b, c41679f);
            AppMethodBeat.m2505o(66104);
            return a;
        }
        AppMethodBeat.m2505o(66104);
        return -6;
    }

    /* renamed from: a */
    public int mo60119a(String str, C41679f c41679f) {
        AppMethodBeat.m2504i(66105);
        int b;
        try {
            JSONObject jSONObject = new JSONObject(str);
            b = m62763b(str, c41679f);
            AppMethodBeat.m2505o(66105);
            return b;
        } catch (JSONException e) {
            b = m62767c(str, c41679f);
            AppMethodBeat.m2505o(66105);
            return b;
        }
    }

    /* renamed from: c */
    private boolean m62769c() {
        AppMethodBeat.m2504i(66106);
        if (!Environment.getExternalStorageState().equals("mounted")) {
            TXCLog.m15676e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
            AppMethodBeat.m2505o(66106);
            return false;
        } else if (this.f15873a.getExternalFilesDir(null) == null) {
            TXCLog.m15676e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            AppMethodBeat.m2505o(66106);
            return false;
        } else {
            AppMethodBeat.m2505o(66106);
            return true;
        }
    }

    /* renamed from: d */
    private boolean m62770d() {
        AppMethodBeat.m2504i(66107);
        boolean a = C37356a.m62792a(this.f15873a, this.f15876d);
        AppMethodBeat.m2505o(66107);
        return a;
    }

    /* renamed from: b */
    private boolean m62765b(String str) {
        AppMethodBeat.m2504i(66108);
        boolean a = C37356a.m62793a(str);
        AppMethodBeat.m2505o(66108);
        return a;
    }

    /* renamed from: e */
    private void m62773e() {
        AppMethodBeat.m2504i(66109);
        File file = new File(this.f15873a.getExternalFilesDir(null).getAbsolutePath() + File.separator + this.f15876d);
        if (file.exists()) {
            TXCLog.m15677i("LicenceCheck", "delete dst file:".concat(String.valueOf(file.delete())));
        }
        File file2 = new File(this.f15880h + File.separator + this.f15877e);
        if (file2.exists()) {
            TXCLog.m15677i("LicenceCheck", "rename file:".concat(String.valueOf(file2.renameTo(file))));
        }
        this.f15884m = true;
        AppMethodBeat.m2505o(66109);
    }

    /* renamed from: c */
    private static long m62768c(String str) {
        AppMethodBeat.m2504i(66110);
        try {
            long time = new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
            AppMethodBeat.m2505o(66110);
            return time;
        } catch (Exception e) {
            AppMethodBeat.m2505o(66110);
            return -1;
        }
    }

    /* renamed from: a */
    public PublicKey mo60120a(String str) {
        AppMethodBeat.m2504i(66111);
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        AppMethodBeat.m2505o(66111);
        return generatePublic;
    }

    /* renamed from: f */
    private String m62774f() {
        AppMethodBeat.m2504i(66112);
        String str;
        if (TextUtils.isEmpty(this.f15875c)) {
            TXCLog.m15676e("LicenceCheck", "decodeLicence, mKey is empty!!!");
            str = "";
            AppMethodBeat.m2505o(66112);
            return str;
        }
        byte[] bytes = this.f15875c.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < bytes.length && i < 16) {
            bArr[i] = bytes[i];
            i++;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        byte[] decode = Base64.decode(this.f15881i, 0);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            str = new String(instance.doFinal(decode), "UTF-8");
            TXCLog.m15677i("LicenceCheck", "decodeLicence : ".concat(String.valueOf(str)));
        } catch (Exception e) {
            str = null;
        }
        AppMethodBeat.m2505o(66112);
        return str;
    }

    /* renamed from: b */
    private int m62763b(String str, C41679f c41679f) {
        AppMethodBeat.m2504i(66113);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("appId");
            this.f15881i = jSONObject.getString("encryptedLicense");
            this.f15882j = jSONObject.getString("signature");
            TXCLog.m15677i("LicenceCheck", "appid:".concat(String.valueOf(optInt)));
            TXCLog.m15677i("LicenceCheck", "encryptedLicense:" + this.f15881i);
            TXCLog.m15677i("LicenceCheck", "signature:" + this.f15882j);
            int c = m62766c(c41679f);
            AppMethodBeat.m2505o(66113);
            return c;
        } catch (JSONException e) {
            this.f15881i = null;
            this.f15882j = null;
            m62757a(-1);
            AppMethodBeat.m2505o(66113);
            return -1;
        }
    }

    /* renamed from: c */
    private int m62766c(C41679f c41679f) {
        boolean a;
        AppMethodBeat.m2504i(66114);
        try {
            a = C37352e.m62760a(Base64.decode(this.f15881i, 0), Base64.decode(this.f15882j, 0), mo60120a(this.f15879g));
        } catch (Exception e) {
            TXCLog.m15676e("LicenceCheck", "verifyLicence, exception is : ".concat(String.valueOf(e)));
            a = false;
        }
        if (a) {
            String f = m62774f();
            if (TextUtils.isEmpty(f)) {
                m62757a(-3);
                TXCLog.m15676e("LicenceCheck", "verifyLicence, decodeValue is empty!");
                AppMethodBeat.m2505o(66114);
                return -3;
            }
            if (c41679f != null) {
                c41679f.f16936a = f;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                String string = jSONObject.getString("pituLicense");
                JSONArray optJSONArray = jSONObject.optJSONArray("appData");
                if (optJSONArray == null) {
                    TXCLog.m15676e("LicenceCheck", "verifyLicence, appDataArray is null!");
                    m62757a(-1);
                    AppMethodBeat.m2505o(66114);
                    return -1;
                }
                int i;
                int i2 = 0;
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    f = jSONObject2.optString(DownloadInfoColumns.PACKAGENAME);
                    TXCLog.m15677i("LicenceCheck", "verifyLicence, packageName:".concat(String.valueOf(f)));
                    if (f.equals(this.f15873a.getPackageName())) {
                        i2 = 1;
                        if (!m62771d(jSONObject2.optString("endDate"))) {
                            i = 1;
                            m62758a(jSONObject2, string);
                            break;
                        }
                    } else {
                        TXCLog.m15676e("LicenceCheck", "verifyLicence, packageName not match!");
                        i2 = 0;
                    }
                }
                i = 0;
                if (i2 == 0) {
                    m62757a(-4);
                    AppMethodBeat.m2505o(66114);
                    return -4;
                } else if (i == 0) {
                    m62757a(-5);
                    AppMethodBeat.m2505o(66114);
                    return -5;
                } else {
                    if (!TextUtils.isEmpty(string)) {
                        byte[] decode = Base64.decode(string, 0);
                        File file = new File(this.f15873a.getExternalFilesDir(null).getAbsolutePath() + File.separator + this.f15878f);
                        C37356a.m62789a(file.getAbsolutePath(), decode);
                        TXCCommonUtil.setPituLicencePath(file.getAbsolutePath());
                    }
                    TXCDRApi.txReportDAU(this.f15873a, C8795a.f2515aN);
                    AppMethodBeat.m2505o(66114);
                    return 0;
                }
            } catch (JSONException e2) {
                TXCLog.m15676e("LicenceCheck", "verifyLicence, json format error ! exception = ".concat(String.valueOf(e2)));
                m62757a(-1);
                AppMethodBeat.m2505o(66114);
                return -1;
            }
        }
        m62757a(-2);
        TXCLog.m15676e("LicenceCheck", "verifyLicence, signature not pass!");
        AppMethodBeat.m2505o(66114);
        return -2;
    }

    /* renamed from: a */
    private void m62758a(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(66115);
        int optInt = jSONObject.optInt("feature");
        if (optInt <= 1) {
            if (TextUtils.isEmpty(str)) {
                this.f15885n = 3;
            } else {
                this.f15885n = 5;
            }
            TXCLog.m15677i("LicenceCheck", "parseVersionType, licence is old, mLicenceVersionType = " + this.f15885n);
            AppMethodBeat.m2505o(66115);
            return;
        }
        this.f15885n = optInt & 15;
        TXCLog.m15677i("LicenceCheck", "parseVersionType, mLicenceVersionType = " + this.f15885n);
        AppMethodBeat.m2505o(66115);
    }

    /* renamed from: a */
    private void m62757a(int i) {
        AppMethodBeat.m2504i(66116);
        TXCDRApi.txReportDAU(this.f15873a, C8795a.f2516aO, i, "");
        AppMethodBeat.m2505o(66116);
    }

    /* renamed from: d */
    private boolean m62771d(String str) {
        AppMethodBeat.m2504i(66117);
        long c = C37352e.m62768c(str);
        if (c < 0) {
            TXCLog.m15676e("LicenceCheck", "checkEndDate, end date millis < 0!");
            AppMethodBeat.m2505o(66117);
            return true;
        } else if (c < System.currentTimeMillis()) {
            TXCLog.m15676e("LicenceCheck", "checkEndDate, end date expire!");
            AppMethodBeat.m2505o(66117);
            return true;
        } else {
            AppMethodBeat.m2505o(66117);
            return false;
        }
    }

    /* renamed from: c */
    private int m62767c(String str, C41679f c41679f) {
        AppMethodBeat.m2504i(66118);
        String e = m62772e(str);
        if (TextUtils.isEmpty(e)) {
            TXCLog.m15676e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
            AppMethodBeat.m2505o(66118);
            return -3;
        }
        if (c41679f != null) {
            c41679f.f16936a = e;
        }
        try {
            JSONObject jSONObject = new JSONObject(e);
            if (!jSONObject.getString("packagename").equals(C37352e.m62755a(this.f15873a))) {
                TXCLog.m15676e("LicenceCheck", "packagename not match!");
                m62757a(-4);
                AppMethodBeat.m2505o(66118);
                return -4;
            } else if (m62771d(jSONObject.getString("enddate"))) {
                AppMethodBeat.m2505o(66118);
                return -5;
            } else {
                this.f15885n = 5;
                TXCDRApi.txReportDAU(this.f15873a, C8795a.f2515aN);
                AppMethodBeat.m2505o(66118);
                return 0;
            }
        } catch (JSONException e2) {
            TXCLog.m15676e("LicenceCheck", "verifyOldLicence, json format error !");
            m62757a(-1);
            AppMethodBeat.m2505o(66118);
            return -1;
        }
    }

    /* renamed from: a */
    private static String m62755a(Context context) {
        String str;
        AppMethodBeat.m2504i(66119);
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
                AppMethodBeat.m2505o(66119);
                return str;
            }
        }
        str = "";
        AppMethodBeat.m2505o(66119);
        return str;
    }

    /* renamed from: e */
    private String m62772e(String str) {
        String str2;
        AppMethodBeat.m2504i(66120);
        try {
            str2 = new String(C41680g.m73100b(Base64.decode(str, 0), Base64.decode("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfMXaF6wx9lev2U\nIzkk6ydI2sdaSQAD2ZvDBLq+5Fm6nGwSSWawl03D4vHcWIUa3wnz6f19/y8wzrj4\nnTfcEnT94SPdB6GhGsqPwbwRp9MHAqd/2gWZxSb005il2yiOZafk6X4NGKCn2tGd\nyNaCF+m9rLykuLdZHB0Z53ivgseNAgMBAAECgYAvXI2pAH+Goxwd6uwuOu9svTGT\nRzaHnI6VWmxBUZQeh3+TOW4iYAG03291GN6bY0RFCOWouSGH7lzK9NFbbPCAQ/hx\ncO48PqioHoq7K8sqzd3XaYBv39HrRnM8JvZsqv0PLJwX/LGm2y/MRaKAC6bcHtse\npgh+NNmUxXNRcTMRAQJBANezmenBcR8HTcY5YaEk3SQRzOo+QhIXuuD4T/FESpVJ\nmVQGxJjLsEBua1j38WG2QuepE5JiVbkQ0jQSvhUiZK0CQQDHJa+vWu6l72lQAvIx\nwmRISorvLb/tnu5bH0Ele42oX+w4p/tm03awdVjhVANnpDjYS2H6EzrF/pfis7k9\nV2phAkB4E4gz47bYYhV+qsTZkw70HGCpab0YG1OyFylRkwW983nCl/3rXUChrZZe\nsbATCAZYtfuqOsmju2R5DpH4a+wFAkBmHlcWbmSNxlSUaM5U4b+WqlLQDv+qE6Na\nKo63b8HWI0n4S3tI4QqttZ7b/L66OKXFk/Ir0AyFVuX/o/VLFTZBAkAdSTEkGwE5\nGQmhxu95sKxmdlUY6Q0Gwwpi06C1BPBrj2VkGXpBP0twhPVAq/3xVjjb+2KXVTUW\nIpRLc06M4vhv", 0)));
        } catch (Exception e) {
            TXCLog.m15676e("LicenceCheck", "decryptLicenceStr, exception is : ".concat(String.valueOf(e)));
            str2 = null;
        }
        AppMethodBeat.m2505o(66120);
        return str2;
    }

    /* renamed from: g */
    private String m62775g() {
        AppMethodBeat.m2504i(66121);
        String b = C37356a.m62795b(new File(this.f15880h + File.separator + this.f15877e).getAbsolutePath());
        AppMethodBeat.m2505o(66121);
        return b;
    }

    /* renamed from: a */
    public static boolean m62760a(byte[] bArr, byte[] bArr2, PublicKey publicKey) {
        AppMethodBeat.m2504i(66122);
        Signature instance = Signature.getInstance("SHA256WithRSA");
        instance.initVerify(publicKey);
        instance.update(bArr);
        boolean verify = instance.verify(bArr2);
        AppMethodBeat.m2505o(66122);
        return verify;
    }
}
