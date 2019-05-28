package com.tencent.liteav.basic.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.a;
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

public class e {
    private static e l;
    private Context a;
    private String b;
    private String c;
    private String d = "TXUgcSDK.licence";
    private String e = "tmp.licence";
    private String f = "YTFaceSDK.licence";
    private String g = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
    private String h;
    private String i;
    private String j;
    private boolean k = false;
    private boolean m = false;
    private int n = -1;

    public static e a() {
        AppMethodBeat.i(66098);
        if (l == null) {
            l = new e();
        }
        e eVar = l;
        AppMethodBeat.o(66098);
        return eVar;
    }

    private e() {
    }

    public void a(Context context, String str, String str2) {
        AppMethodBeat.i(66099);
        this.a = context.getApplicationContext();
        this.b = str;
        this.c = str2;
        if (this.a != null && c()) {
            this.h = this.a.getExternalFilesDir(null).getAbsolutePath();
            if (!b(this.h + File.separator + this.d)) {
                TXCLog.d("LicenceCheck", "setLicense, sdcard file not exist, to download");
                b();
            }
        }
        AppMethodBeat.o(66099);
    }

    public void b() {
        AppMethodBeat.i(66100);
        if (TextUtils.isEmpty(this.b)) {
            TXCLog.e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
            AppMethodBeat.o(66100);
        } else if (this.k) {
            TXCLog.i("LicenceCheck", "downloadLicense, in downloading, ignore");
            AppMethodBeat.o(66100);
        } else {
            AnonymousClass1 anonymousClass1 = new b() {
                public void a(File file) {
                    AppMethodBeat.i(66126);
                    TXCLog.i("LicenceCheck", "downloadLicense, onSaveSuccess");
                    String a = e.a(e.this);
                    if (TextUtils.isEmpty(a)) {
                        TXCLog.e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
                        e.this.k = false;
                        AppMethodBeat.o(66126);
                        return;
                    }
                    if (e.a(e.this, a, null) == 0) {
                        e.b(e.this);
                    }
                    AppMethodBeat.o(66126);
                }

                public void a(File file, Exception exception) {
                    AppMethodBeat.i(66127);
                    TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
                    AppMethodBeat.o(66127);
                }

                public void a(int i) {
                    AppMethodBeat.i(66128);
                    TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
                    AppMethodBeat.o(66128);
                }

                public void a() {
                    AppMethodBeat.i(66129);
                    TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
                    e.this.k = false;
                    AppMethodBeat.o(66129);
                }
            };
            if (this.a == null) {
                TXCLog.e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
                AppMethodBeat.o(66100);
                return;
            }
            File externalFilesDir = this.a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                TXCLog.e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
                AppMethodBeat.o(66100);
                return;
            }
            this.h = externalFilesDir.getAbsolutePath();
            new Thread(new c(this.a, this.b, this.h, this.e, anonymousClass1, false)).start();
            this.k = true;
            AppMethodBeat.o(66100);
        }
    }

    public int a(f fVar, Context context) {
        AppMethodBeat.i(66101);
        int b = b(fVar, context);
        if (b != 0) {
            b();
        }
        AppMethodBeat.o(66101);
        return b;
    }

    private int b(f fVar, Context context) {
        AppMethodBeat.i(66102);
        if (this.m) {
            AppMethodBeat.o(66102);
            return 0;
        }
        if (this.a == null) {
            this.a = context;
        }
        if (b(fVar) == 0) {
            this.m = true;
            AppMethodBeat.o(66102);
            return 0;
        }
        int a = a(fVar);
        if (a == 0) {
            this.m = true;
            AppMethodBeat.o(66102);
            return 0;
        }
        AppMethodBeat.o(66102);
        return a;
    }

    private int a(f fVar) {
        AppMethodBeat.i(66103);
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalFilesDir = this.a.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
                AppMethodBeat.o(66103);
                return -10;
            }
            String str = externalFilesDir.getAbsolutePath() + File.separator + this.d;
            if (b(str)) {
                str = a.b(str);
                if (TextUtils.isEmpty(str)) {
                    TXCLog.e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
                    AppMethodBeat.o(66103);
                    return -8;
                }
                int a = a(str, fVar);
                AppMethodBeat.o(66103);
                return a;
            }
            AppMethodBeat.o(66103);
            return -7;
        }
        TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
        AppMethodBeat.o(66103);
        return -10;
    }

    private int b(f fVar) {
        AppMethodBeat.i(66104);
        if (d()) {
            String b = a.b(this.a, this.d);
            if (TextUtils.isEmpty(b)) {
                TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
                AppMethodBeat.o(66104);
                return -8;
            }
            int a = a(b, fVar);
            AppMethodBeat.o(66104);
            return a;
        }
        AppMethodBeat.o(66104);
        return -6;
    }

    public int a(String str, f fVar) {
        AppMethodBeat.i(66105);
        int b;
        try {
            JSONObject jSONObject = new JSONObject(str);
            b = b(str, fVar);
            AppMethodBeat.o(66105);
            return b;
        } catch (JSONException e) {
            b = c(str, fVar);
            AppMethodBeat.o(66105);
            return b;
        }
    }

    private boolean c() {
        AppMethodBeat.i(66106);
        if (!Environment.getExternalStorageState().equals("mounted")) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
            AppMethodBeat.o(66106);
            return false;
        } else if (this.a.getExternalFilesDir(null) == null) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            AppMethodBeat.o(66106);
            return false;
        } else {
            AppMethodBeat.o(66106);
            return true;
        }
    }

    private boolean d() {
        AppMethodBeat.i(66107);
        boolean a = a.a(this.a, this.d);
        AppMethodBeat.o(66107);
        return a;
    }

    private boolean b(String str) {
        AppMethodBeat.i(66108);
        boolean a = a.a(str);
        AppMethodBeat.o(66108);
        return a;
    }

    private void e() {
        AppMethodBeat.i(66109);
        File file = new File(this.a.getExternalFilesDir(null).getAbsolutePath() + File.separator + this.d);
        if (file.exists()) {
            TXCLog.i("LicenceCheck", "delete dst file:".concat(String.valueOf(file.delete())));
        }
        File file2 = new File(this.h + File.separator + this.e);
        if (file2.exists()) {
            TXCLog.i("LicenceCheck", "rename file:".concat(String.valueOf(file2.renameTo(file))));
        }
        this.m = true;
        AppMethodBeat.o(66109);
    }

    private static long c(String str) {
        AppMethodBeat.i(66110);
        try {
            long time = new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
            AppMethodBeat.o(66110);
            return time;
        } catch (Exception e) {
            AppMethodBeat.o(66110);
            return -1;
        }
    }

    public PublicKey a(String str) {
        AppMethodBeat.i(66111);
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        AppMethodBeat.o(66111);
        return generatePublic;
    }

    private String f() {
        AppMethodBeat.i(66112);
        String str;
        if (TextUtils.isEmpty(this.c)) {
            TXCLog.e("LicenceCheck", "decodeLicence, mKey is empty!!!");
            str = "";
            AppMethodBeat.o(66112);
            return str;
        }
        byte[] bytes = this.c.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < bytes.length && i < 16) {
            bArr[i] = bytes[i];
            i++;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        byte[] decode = Base64.decode(this.i, 0);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            str = new String(instance.doFinal(decode), "UTF-8");
            TXCLog.i("LicenceCheck", "decodeLicence : ".concat(String.valueOf(str)));
        } catch (Exception e) {
            str = null;
        }
        AppMethodBeat.o(66112);
        return str;
    }

    private int b(String str, f fVar) {
        AppMethodBeat.i(66113);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("appId");
            this.i = jSONObject.getString("encryptedLicense");
            this.j = jSONObject.getString("signature");
            TXCLog.i("LicenceCheck", "appid:".concat(String.valueOf(optInt)));
            TXCLog.i("LicenceCheck", "encryptedLicense:" + this.i);
            TXCLog.i("LicenceCheck", "signature:" + this.j);
            int c = c(fVar);
            AppMethodBeat.o(66113);
            return c;
        } catch (JSONException e) {
            this.i = null;
            this.j = null;
            a(-1);
            AppMethodBeat.o(66113);
            return -1;
        }
    }

    private int c(f fVar) {
        boolean a;
        AppMethodBeat.i(66114);
        try {
            a = a(Base64.decode(this.i, 0), Base64.decode(this.j, 0), a(this.g));
        } catch (Exception e) {
            TXCLog.e("LicenceCheck", "verifyLicence, exception is : ".concat(String.valueOf(e)));
            a = false;
        }
        if (a) {
            String f = f();
            if (TextUtils.isEmpty(f)) {
                a(-3);
                TXCLog.e("LicenceCheck", "verifyLicence, decodeValue is empty!");
                AppMethodBeat.o(66114);
                return -3;
            }
            if (fVar != null) {
                fVar.a = f;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                String string = jSONObject.getString("pituLicense");
                JSONArray optJSONArray = jSONObject.optJSONArray("appData");
                if (optJSONArray == null) {
                    TXCLog.e("LicenceCheck", "verifyLicence, appDataArray is null!");
                    a(-1);
                    AppMethodBeat.o(66114);
                    return -1;
                }
                int i;
                int i2 = 0;
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    f = jSONObject2.optString(DownloadInfoColumns.PACKAGENAME);
                    TXCLog.i("LicenceCheck", "verifyLicence, packageName:".concat(String.valueOf(f)));
                    if (f.equals(this.a.getPackageName())) {
                        i2 = 1;
                        if (!d(jSONObject2.optString("endDate"))) {
                            i = 1;
                            a(jSONObject2, string);
                            break;
                        }
                    } else {
                        TXCLog.e("LicenceCheck", "verifyLicence, packageName not match!");
                        i2 = 0;
                    }
                }
                i = 0;
                if (i2 == 0) {
                    a(-4);
                    AppMethodBeat.o(66114);
                    return -4;
                } else if (i == 0) {
                    a(-5);
                    AppMethodBeat.o(66114);
                    return -5;
                } else {
                    if (!TextUtils.isEmpty(string)) {
                        byte[] decode = Base64.decode(string, 0);
                        File file = new File(this.a.getExternalFilesDir(null).getAbsolutePath() + File.separator + this.f);
                        a.a(file.getAbsolutePath(), decode);
                        TXCCommonUtil.setPituLicencePath(file.getAbsolutePath());
                    }
                    TXCDRApi.txReportDAU(this.a, com.tencent.liteav.basic.datareport.a.aN);
                    AppMethodBeat.o(66114);
                    return 0;
                }
            } catch (JSONException e2) {
                TXCLog.e("LicenceCheck", "verifyLicence, json format error ! exception = ".concat(String.valueOf(e2)));
                a(-1);
                AppMethodBeat.o(66114);
                return -1;
            }
        }
        a(-2);
        TXCLog.e("LicenceCheck", "verifyLicence, signature not pass!");
        AppMethodBeat.o(66114);
        return -2;
    }

    private void a(JSONObject jSONObject, String str) {
        AppMethodBeat.i(66115);
        int optInt = jSONObject.optInt("feature");
        if (optInt <= 1) {
            if (TextUtils.isEmpty(str)) {
                this.n = 3;
            } else {
                this.n = 5;
            }
            TXCLog.i("LicenceCheck", "parseVersionType, licence is old, mLicenceVersionType = " + this.n);
            AppMethodBeat.o(66115);
            return;
        }
        this.n = optInt & 15;
        TXCLog.i("LicenceCheck", "parseVersionType, mLicenceVersionType = " + this.n);
        AppMethodBeat.o(66115);
    }

    private void a(int i) {
        AppMethodBeat.i(66116);
        TXCDRApi.txReportDAU(this.a, com.tencent.liteav.basic.datareport.a.aO, i, "");
        AppMethodBeat.o(66116);
    }

    private boolean d(String str) {
        AppMethodBeat.i(66117);
        long c = c(str);
        if (c < 0) {
            TXCLog.e("LicenceCheck", "checkEndDate, end date millis < 0!");
            AppMethodBeat.o(66117);
            return true;
        } else if (c < System.currentTimeMillis()) {
            TXCLog.e("LicenceCheck", "checkEndDate, end date expire!");
            AppMethodBeat.o(66117);
            return true;
        } else {
            AppMethodBeat.o(66117);
            return false;
        }
    }

    private int c(String str, f fVar) {
        AppMethodBeat.i(66118);
        String e = e(str);
        if (TextUtils.isEmpty(e)) {
            TXCLog.e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
            AppMethodBeat.o(66118);
            return -3;
        }
        if (fVar != null) {
            fVar.a = e;
        }
        try {
            JSONObject jSONObject = new JSONObject(e);
            if (!jSONObject.getString("packagename").equals(a(this.a))) {
                TXCLog.e("LicenceCheck", "packagename not match!");
                a(-4);
                AppMethodBeat.o(66118);
                return -4;
            } else if (d(jSONObject.getString("enddate"))) {
                AppMethodBeat.o(66118);
                return -5;
            } else {
                this.n = 5;
                TXCDRApi.txReportDAU(this.a, com.tencent.liteav.basic.datareport.a.aN);
                AppMethodBeat.o(66118);
                return 0;
            }
        } catch (JSONException e2) {
            TXCLog.e("LicenceCheck", "verifyOldLicence, json format error !");
            a(-1);
            AppMethodBeat.o(66118);
            return -1;
        }
    }

    private static String a(Context context) {
        String str;
        AppMethodBeat.i(66119);
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
                AppMethodBeat.o(66119);
                return str;
            }
        }
        str = "";
        AppMethodBeat.o(66119);
        return str;
    }

    private String e(String str) {
        String str2;
        AppMethodBeat.i(66120);
        try {
            str2 = new String(g.b(Base64.decode(str, 0), Base64.decode("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfMXaF6wx9lev2U\nIzkk6ydI2sdaSQAD2ZvDBLq+5Fm6nGwSSWawl03D4vHcWIUa3wnz6f19/y8wzrj4\nnTfcEnT94SPdB6GhGsqPwbwRp9MHAqd/2gWZxSb005il2yiOZafk6X4NGKCn2tGd\nyNaCF+m9rLykuLdZHB0Z53ivgseNAgMBAAECgYAvXI2pAH+Goxwd6uwuOu9svTGT\nRzaHnI6VWmxBUZQeh3+TOW4iYAG03291GN6bY0RFCOWouSGH7lzK9NFbbPCAQ/hx\ncO48PqioHoq7K8sqzd3XaYBv39HrRnM8JvZsqv0PLJwX/LGm2y/MRaKAC6bcHtse\npgh+NNmUxXNRcTMRAQJBANezmenBcR8HTcY5YaEk3SQRzOo+QhIXuuD4T/FESpVJ\nmVQGxJjLsEBua1j38WG2QuepE5JiVbkQ0jQSvhUiZK0CQQDHJa+vWu6l72lQAvIx\nwmRISorvLb/tnu5bH0Ele42oX+w4p/tm03awdVjhVANnpDjYS2H6EzrF/pfis7k9\nV2phAkB4E4gz47bYYhV+qsTZkw70HGCpab0YG1OyFylRkwW983nCl/3rXUChrZZe\nsbATCAZYtfuqOsmju2R5DpH4a+wFAkBmHlcWbmSNxlSUaM5U4b+WqlLQDv+qE6Na\nKo63b8HWI0n4S3tI4QqttZ7b/L66OKXFk/Ir0AyFVuX/o/VLFTZBAkAdSTEkGwE5\nGQmhxu95sKxmdlUY6Q0Gwwpi06C1BPBrj2VkGXpBP0twhPVAq/3xVjjb+2KXVTUW\nIpRLc06M4vhv", 0)));
        } catch (Exception e) {
            TXCLog.e("LicenceCheck", "decryptLicenceStr, exception is : ".concat(String.valueOf(e)));
            str2 = null;
        }
        AppMethodBeat.o(66120);
        return str2;
    }

    private String g() {
        AppMethodBeat.i(66121);
        String b = a.b(new File(this.h + File.separator + this.e).getAbsolutePath());
        AppMethodBeat.o(66121);
        return b;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, PublicKey publicKey) {
        AppMethodBeat.i(66122);
        Signature instance = Signature.getInstance("SHA256WithRSA");
        instance.initVerify(publicKey);
        instance.update(bArr);
        boolean verify = instance.verify(bArr2);
        AppMethodBeat.o(66122);
        return verify;
    }
}
