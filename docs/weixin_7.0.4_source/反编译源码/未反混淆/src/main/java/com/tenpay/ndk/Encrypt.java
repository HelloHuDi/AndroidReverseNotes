package com.tenpay.ndk;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public class Encrypt {
    private static final String CHARSET = "UTF-8";
    private byte[] dec_buf;
    private byte[] enc_buf;
    private byte[] enc_passwd;
    private byte[] key_buf;
    private byte[] raw_buf;
    private byte[] raw_passwd;
    private String server_time_stamp = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private int time_stamp;

    private native boolean decrypt(byte[] bArr, byte[] bArr2);

    private native boolean encrypt(byte[] bArr, byte[] bArr2);

    private native boolean encryptPasswd(byte b, byte[] bArr);

    private native boolean encryptPasswdWithRSA2048(byte b, byte[] bArr, int i);

    private native boolean encryptVerifyCode(byte[] bArr);

    private native byte[] getRandom();

    public native byte[] sm4BCDDecryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] sm4BCDEncryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public String desedeEncode(String str) {
        String str2;
        AppMethodBeat.i(49566);
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                encrypt(null, this.raw_buf);
                if (this.enc_buf == null) {
                    AppMethodBeat.o(49566);
                    return null;
                }
                try {
                    str2 = new String(this.enc_buf, CHARSET);
                } catch (Exception e) {
                    AppMethodBeat.o(49566);
                    return null;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(49566);
                return null;
            }
        }
        AppMethodBeat.o(49566);
        return str2;
    }

    public String desedeVerifyCode(String str) {
        String str2;
        AppMethodBeat.i(49567);
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                encryptVerifyCode(this.raw_buf);
                if (this.enc_buf == null) {
                    AppMethodBeat.o(49567);
                    return null;
                }
                try {
                    str2 = new String(this.enc_buf, CHARSET);
                } catch (Exception e) {
                    AppMethodBeat.o(49567);
                    return null;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(49567);
                return null;
            }
        }
        AppMethodBeat.o(49567);
        return str2;
    }

    public String desedeEncode(String str, String str2) {
        String str3;
        AppMethodBeat.i(49568);
        if (str == null || str2 == null || str.length() <= 0) {
            str3 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                this.key_buf = str2.getBytes(CHARSET);
                encrypt(this.key_buf, this.raw_buf);
                if (this.enc_buf == null) {
                    AppMethodBeat.o(49568);
                    return null;
                }
                try {
                    str3 = new String(this.enc_buf, CHARSET);
                } catch (Exception e) {
                    AppMethodBeat.o(49568);
                    return null;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(49568);
                return null;
            }
        }
        AppMethodBeat.o(49568);
        return str3;
    }

    public String desedeDecode(String str, String str2) {
        String str3;
        AppMethodBeat.i(49569);
        if (str == null || str2 == null || str.length() <= 0) {
            str3 = null;
        } else {
            try {
                this.raw_buf = str.getBytes(CHARSET);
                this.key_buf = str2.getBytes(CHARSET);
                decrypt(this.key_buf, this.raw_buf);
                if (this.dec_buf == null) {
                    AppMethodBeat.o(49569);
                    return null;
                }
                try {
                    str3 = new String(this.dec_buf, CHARSET);
                } catch (Exception e) {
                    AppMethodBeat.o(49569);
                    return null;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(49569);
                return null;
            }
        }
        AppMethodBeat.o(49569);
        return str3;
    }

    public String getPasswdTimeStamp() {
        AppMethodBeat.i(49570);
        String valueOf = String.valueOf(this.time_stamp);
        AppMethodBeat.o(49570);
        return valueOf;
    }

    public void setTimeStamp(String str) {
        this.server_time_stamp = str;
    }

    public String encryptPasswdWithRSA2048(String str) {
        String str2 = null;
        AppMethodBeat.i(49571);
        if (str != null && str.length() > 0) {
            this.raw_passwd = str2;
            this.enc_passwd = str2;
            if (str.length() > 0) {
                try {
                    this.raw_passwd = str.getBytes(CHARSET);
                    if (!encryptPasswdWithRSA2048((byte) 2, this.raw_passwd, 1)) {
                        AppMethodBeat.o(49571);
                        return str2;
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(49571);
                }
            }
            if (this.enc_passwd == null) {
                AppMethodBeat.o(49571);
            } else {
                try {
                    str2 = "V01_" + new String(this.enc_passwd, CHARSET);
                } catch (Exception e2) {
                    AppMethodBeat.o(49571);
                }
            }
            return str2;
        }
        AppMethodBeat.o(49571);
        return str2;
    }

    public String encryptPasswd(String str) {
        String str2;
        AppMethodBeat.i(49572);
        if (str == null || str.length() <= 0) {
            str2 = null;
        } else {
            try {
                this.raw_passwd = str.getBytes(CHARSET);
                encryptPasswd((byte) 2, this.raw_passwd);
                if (this.enc_passwd == null) {
                    AppMethodBeat.o(49572);
                    return null;
                }
                try {
                    int length = this.enc_passwd.length / 2;
                    byte[] bArr = new byte[length];
                    System.arraycopy(this.enc_passwd, length, bArr, 0, length);
                    str2 = new String(bArr, CHARSET);
                } catch (Exception e) {
                    AppMethodBeat.o(49572);
                    return null;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(49572);
                return null;
            }
        }
        AppMethodBeat.o(49572);
        return str2;
    }

    public String getRandomKey() {
        String str;
        AppMethodBeat.i(49573);
        byte[] random = getRandom();
        if (random != null) {
            try {
                str = new String(random, CHARSET);
            } catch (UnsupportedEncodingException e) {
            }
            AppMethodBeat.o(49573);
            return str;
        }
        str = null;
        AppMethodBeat.o(49573);
        return str;
    }
}
