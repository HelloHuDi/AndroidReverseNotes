package com.tenpay.ndk;

import android.content.Context;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.MessageDigest;

public class CertUtil {
    public static final String TAG = CertUtil.class.getSimpleName();
    private static CertUtil instance = null;
    private String cert_dir;
    private String cert_id = null;
    private byte[] certid_buf = null;
    private byte[] cipher_buf = null;
    private byte[] csr_buf = null;
    private String deskey = null;
    private String iccid = null;
    private String imei = null;
    private String imsi = null;
    private String login_ip = null;
    private Context mContext = null;
    private String mac = null;
    private String plain_buf = null;
    private byte[] plain_buf2 = null;
    private String priv_dir;
    private String publ_dir;
    private String qq_id = null;
    private byte[] sig_buf = null;
    private String sig_raw_buf = null;
    private String sm4Key = null;
    private String softid = null;
    private String svr_cert = null;
    private String token = null;
    private byte[] token_buf = null;
    private String token_dir;
    private int token_len = 0;
    private int useSM4 = 0;

    private native boolean encrypt();

    private native boolean genCertApplyCsr();

    private native boolean genCertApplyCsrNew(int i);

    private native boolean genQrcode();

    private native boolean getCertid();

    private native boolean getToken();

    private native int getTokenCount();

    private native boolean importCert();

    private native boolean isCertExist();

    private native boolean setToken();

    private native boolean usrSig();

    public native int getLastError();

    static {
        AppMethodBeat.i(49565);
        AppMethodBeat.o(49565);
    }

    private CertUtil() {
    }

    public static CertUtil getInstance() {
        AppMethodBeat.i(49539);
        if (instance == null) {
            synchronized (CertUtil.class) {
                try {
                    instance = new CertUtil();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(49539);
                    }
                }
            }
        }
        CertUtil certUtil = instance;
        AppMethodBeat.o(49539);
        return certUtil;
    }

    public void init(Context context) {
        AppMethodBeat.i(49540);
        this.mContext = context.getApplicationContext();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            this.imsi = telephonyManager.getSubscriberId();
            this.iccid = telephonyManager.getSimSerialNumber();
            this.imei = telephonyManager.getDeviceId();
            this.softid = System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        this.deskey = this.imei;
        AppMethodBeat.o(49540);
    }

    private String getCertDir() {
        AppMethodBeat.i(49541);
        String str = this.mContext.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
        AppMethodBeat.o(49541);
        return str;
    }

    private void setAndCheckDir(String str) {
        AppMethodBeat.i(49542);
        String certDir = getCertDir();
        String str2 = certDir + "/" + hexdigest(str + this.imei);
        this.cert_dir = str2 + "/cert";
        this.priv_dir = str2 + "/priv";
        this.publ_dir = str2 + "/publ";
        this.token_dir = str2 + "/auth";
        checkDir(certDir);
        checkDir(this.token_dir);
        AppMethodBeat.o(49542);
    }

    private void setDir(String str) {
        AppMethodBeat.i(49543);
        String str2 = getCertDir() + "/" + hexdigest(str + this.imei);
        this.cert_dir = str2 + "/cert";
        this.priv_dir = str2 + "/priv";
        this.publ_dir = str2 + "/publ";
        this.token_dir = str2 + "/auth";
        AppMethodBeat.o(49543);
    }

    private void checkDir(String str) {
        AppMethodBeat.i(49544);
        File file = new File(str);
        if (file.exists()) {
            if (!file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
            AppMethodBeat.o(49544);
            return;
        }
        file.mkdirs();
        AppMethodBeat.o(49544);
    }

    private boolean create_dir(String str) {
        boolean z;
        AppMethodBeat.i(49545);
        try {
            File file = new File(str);
            if (file.exists()) {
                z = true;
            } else {
                z = file.mkdirs();
                if (!z) {
                }
            }
        } catch (Exception e) {
            z = false;
        }
        AppMethodBeat.o(49545);
        return z;
    }

    private boolean del_all_files(String str) {
        boolean z = false;
        AppMethodBeat.i(49546);
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(49546);
            return false;
        } else if (file.isDirectory()) {
            String[] list = file.list();
            int i = 0;
            while (true) {
                boolean z2 = z;
                if (i < list.length) {
                    File file2;
                    if (str.endsWith(File.separator)) {
                        file2 = new File(str + list[i]);
                    } else {
                        file2 = new File(str + File.separator + list[i]);
                    }
                    if (file2.isFile()) {
                        file2.delete();
                        z = z2;
                    } else if (file2.isDirectory()) {
                        del_all_files(str + File.separator + list[i]);
                        del_dir(str + File.separator + list[i], true);
                        z = true;
                    } else {
                        z = z2;
                    }
                    i++;
                } else {
                    AppMethodBeat.o(49546);
                    return z2;
                }
            }
        } else {
            AppMethodBeat.o(49546);
            return false;
        }
    }

    private void del_dir(String str, boolean z) {
        AppMethodBeat.i(49547);
        try {
            del_all_files(str);
            if (z) {
                new File(str.toString()).delete();
            }
            AppMethodBeat.o(49547);
        } catch (Exception e) {
            AppMethodBeat.o(49547);
        }
    }

    private boolean isNotEmptyDir(String str) {
        AppMethodBeat.i(49548);
        boolean z = true;
        File file = new File(str);
        if (!(file.exists() && file.isDirectory() && file.listFiles() != null)) {
            z = false;
        }
        AppMethodBeat.o(49548);
        return z;
    }

    private boolean isValidDir(String str) {
        AppMethodBeat.i(49549);
        boolean z = true;
        File file = new File(str);
        if (!(file.exists() && file.isDirectory())) {
            z = false;
        }
        AppMethodBeat.o(49549);
        return z;
    }

    private String hexdigest(String str) {
        AppMethodBeat.i(49550);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(49550);
            return str2;
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i4;
            }
            str2 = new String(cArr2);
        } catch (Exception e) {
            str2 = null;
        }
        AppMethodBeat.o(49550);
        return str2;
    }

    private boolean isNullOrEmpty(String str) {
        AppMethodBeat.i(49551);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(49551);
            return true;
        }
        AppMethodBeat.o(49551);
        return false;
    }

    public synchronized String getCertApplyCSR(String str) {
        String str2 = null;
        synchronized (this) {
            AppMethodBeat.i(49552);
            this.qq_id = str;
            this.csr_buf = null;
            if (genCertApplyCsr() && this.csr_buf != null) {
                try {
                    str2 = new String(this.csr_buf, "ASCII");
                } catch (Exception e) {
                    AppMethodBeat.o(49552);
                }
            }
            AppMethodBeat.o(49552);
        }
        return str2;
    }

    public synchronized String getCertApplyCSR(String str, int i) {
        String str2 = null;
        synchronized (this) {
            AppMethodBeat.i(49553);
            this.qq_id = str;
            this.csr_buf = null;
            if (genCertApplyCsrNew(i) && this.csr_buf != null) {
                try {
                    str2 = new String(this.csr_buf, "ASCII");
                } catch (Exception e) {
                    AppMethodBeat.o(49553);
                }
            }
            AppMethodBeat.o(49553);
        }
        return str2;
    }

    public synchronized boolean importCert(String str, String str2) {
        boolean z;
        AppMethodBeat.i(49554);
        if (str2.length() <= 0) {
            z = false;
            AppMethodBeat.o(49554);
        } else {
            try {
                this.svr_cert = new String(str2.getBytes(), "ASCII");
            } catch (Exception e) {
            }
            clearCert(str);
            setAndCheckDir(str);
            create_dir(this.cert_dir);
            create_dir(this.priv_dir);
            create_dir(this.publ_dir);
            z = importCert();
            AppMethodBeat.o(49554);
        }
        return z;
    }

    public synchronized boolean isCertExist(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(49555);
            if (isNullOrEmpty(str)) {
                AppMethodBeat.o(49555);
            } else {
                setDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    this.cert_id = str;
                    z = isCertExist();
                    AppMethodBeat.o(49555);
                } else {
                    AppMethodBeat.o(49555);
                }
            }
        }
        return z;
    }

    public synchronized void clearAllCert() {
        AppMethodBeat.i(49556);
        del_dir(getCertDir(), true);
        AppMethodBeat.o(49556);
    }

    public synchronized void clearCert(String str) {
        AppMethodBeat.i(49557);
        del_dir(getCertDir() + "/" + hexdigest(str + this.imei), true);
        AppMethodBeat.o(49557);
    }

    public synchronized String encrypt(String str, String str2) {
        String str3 = null;
        synchronized (this) {
            AppMethodBeat.i(49558);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
                AppMethodBeat.o(49558);
            } else {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    this.cert_id = str;
                    this.plain_buf = str2;
                    this.cipher_buf = null;
                    if (encrypt() && this.cipher_buf != null) {
                        try {
                            str3 = new String(this.cipher_buf, "UTF-8");
                        } catch (Exception e) {
                            AppMethodBeat.o(49558);
                        }
                    }
                    AppMethodBeat.o(49558);
                } else {
                    AppMethodBeat.o(49558);
                }
            }
        }
        return str3;
    }

    public synchronized String genUserSig(String str, String str2) {
        String str3 = null;
        synchronized (this) {
            AppMethodBeat.i(49559);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
                AppMethodBeat.o(49559);
            } else {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    if (!(str == null || str2 == null)) {
                        if (str.length() > 0 && str2.length() > 0) {
                            this.cert_id = str;
                            this.sig_raw_buf = str2;
                            this.sig_buf = null;
                            if (usrSig() && this.sig_buf != null) {
                                try {
                                    str3 = new String(this.sig_buf, "UTF-8");
                                } catch (Exception e) {
                                    AppMethodBeat.o(49559);
                                }
                            }
                            AppMethodBeat.o(49559);
                        }
                    }
                    AppMethodBeat.o(49559);
                } else {
                    AppMethodBeat.o(49559);
                }
            }
        }
        return str3;
    }

    public synchronized byte[] genQrcode(String str, byte[] bArr, String str2) {
        byte[] bArr2 = null;
        synchronized (this) {
            AppMethodBeat.i(49560);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2) || bArr == null || bArr.length == 0) {
                AppMethodBeat.o(49560);
            } else {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.cert_dir) && isNotEmptyDir(this.publ_dir) && isNotEmptyDir(this.priv_dir)) {
                    this.cert_id = str;
                    this.plain_buf2 = bArr;
                    this.cipher_buf = null;
                    this.token = str2;
                    if (genQrcode() && this.cipher_buf != null) {
                        try {
                            bArr2 = this.cipher_buf;
                        } catch (Exception e) {
                            AppMethodBeat.o(49560);
                        }
                    }
                    AppMethodBeat.o(49560);
                } else {
                    AppMethodBeat.o(49560);
                }
            }
        }
        return bArr2;
    }

    public synchronized boolean setTokens(String str, String str2, boolean z, String str3) {
        boolean token;
        int i = false;
        synchronized (this) {
            AppMethodBeat.i(49561);
            if (isNullOrEmpty(str) || isNullOrEmpty(str2)) {
                AppMethodBeat.o(49561);
            } else {
                if (z && str3 != null) {
                    if (str3.length() != 16) {
                        AppMethodBeat.o(49561);
                    }
                }
                setAndCheckDir(str);
                if (!isValidDir(this.cert_dir)) {
                    AppMethodBeat.o(49561);
                } else if (isValidDir(this.token_dir)) {
                    if (z) {
                        i = 1;
                    }
                    this.useSM4 = i;
                    this.sm4Key = str3;
                    this.cert_id = str;
                    this.token = str2;
                    this.token_len = this.token.length();
                    token = setToken();
                    AppMethodBeat.o(49561);
                } else {
                    AppMethodBeat.o(49561);
                }
            }
        }
        return token;
    }

    public synchronized String getToken(String str) {
        String str2 = null;
        synchronized (this) {
            AppMethodBeat.i(49562);
            if (isNullOrEmpty(str)) {
                AppMethodBeat.o(49562);
            } else {
                setAndCheckDir(str);
                if (isNotEmptyDir(this.token_dir)) {
                    this.cert_id = str;
                    if (getToken() && this.token_buf != null) {
                        try {
                            str2 = new String(this.token_buf, "UTF-8");
                        } catch (Exception e) {
                            AppMethodBeat.o(49562);
                        }
                    }
                    AppMethodBeat.o(49562);
                } else {
                    AppMethodBeat.o(49562);
                }
            }
        }
        return str2;
    }

    public synchronized void clearToken(String str) {
        AppMethodBeat.i(49563);
        if (isNullOrEmpty(str)) {
            AppMethodBeat.o(49563);
        } else {
            setDir(str);
            del_dir(this.token_dir, true);
            AppMethodBeat.o(49563);
        }
    }

    public synchronized int getTokenCount(String str) {
        int i;
        AppMethodBeat.i(49564);
        if (isNullOrEmpty(str)) {
            i = 0;
            AppMethodBeat.o(49564);
        } else {
            setDir(str);
            this.cert_id = str;
            i = getTokenCount();
            AppMethodBeat.o(49564);
        }
        return i;
    }
}
