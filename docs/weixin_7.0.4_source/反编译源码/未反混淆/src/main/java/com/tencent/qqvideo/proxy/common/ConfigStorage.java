package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigStorage {
    private static String Config_Version = "";
    private static final long GET_CONFIG_INTERVAL = 600000;
    private static long LastGetConfigTime = 0;
    private static final String PREFERENCE = "_httpproxy_preferences";
    public static final String PREF_DOWNPROXY_CONFIG = "DOWNPROXY_CONFIG";
    public static final String PREF_DOWNPROXY_CONFIG_VERSION = "DOWNPROXY_GUID_CONFIG_VERSION";
    private static String TAG = "TV_Httpproxy";
    private static final String TVHttpProxy_Version = "V1.0.186.0011";
    private static final String TVHttpProxy_Version_Code = "101860011";
    private static final String TVHttpProxy_channel_id = "186";
    private static final int[] connectTimeOut = new int[]{5000, 5000, Downloads.MIN_WAIT_FOR_NETWORK};
    private static String guid = "123";
    private static final String httpsCrtFileName = "videosdkcrt/sec.video.qq.com.crt";
    private static final String ipflag = "1";
    private static final String otype = "json";
    private static final String platform = "aphone";
    private static final int[] readTimeOut = new int[]{Downloads.MIN_WAIT_FOR_NETWORK, Downloads.MIN_WAIT_FOR_NETWORK, 15000};
    private static final int[] retryTimes = new int[]{3, 2};
    private static String sharedPreferencesName = null;
    private static final String url = "https://sec.video.qq.com/p/wxconf/getmfomat";
    private Thread thread = null;

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        AppMethodBeat.i(124457);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i);
        AppMethodBeat.o(124457);
        return sharedPreferences;
    }

    public static SharedPreferences getAppSharedPreferences(Context context) {
        AppMethodBeat.i(124458);
        if (sharedPreferencesName == null) {
            sharedPreferencesName = context.getPackageName() + PREFERENCE;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(context, sharedPreferencesName, 0);
        AppMethodBeat.o(124458);
        return sharedPreferences;
    }

    public static String getDownProxyConfig(Context context) {
        AppMethodBeat.i(124459);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(124459);
            return str;
        }
        Config_Version = getConfigVersionFromSharedPreference(context);
        str = getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG, "");
        AppMethodBeat.o(124459);
        return str;
    }

    public static void setDownProxyConfig(Context context, String str) {
        AppMethodBeat.i(124460);
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG, str).commit();
        AppMethodBeat.o(124460);
    }

    public static String getHttpProxyVersion() {
        return TVHttpProxy_Version;
    }

    public static String getHttpProxyVersionCode() {
        return TVHttpProxy_Version_Code;
    }

    public static String getConfigVersion() {
        return Config_Version;
    }

    private static String getConfigVersionFromSharedPreference(Context context) {
        AppMethodBeat.i(124461);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(124461);
            return str;
        }
        str = getAppSharedPreferences(context).getString(PREF_DOWNPROXY_CONFIG_VERSION, "");
        AppMethodBeat.o(124461);
        return str;
    }

    private static void setConfigVersionToSharedPreference(Context context, String str) {
        AppMethodBeat.i(124462);
        if (context == null || str == null) {
            AppMethodBeat.o(124462);
            return;
        }
        getAppSharedPreferences(context).edit().putString(PREF_DOWNPROXY_CONFIG_VERSION, str).commit();
        AppMethodBeat.o(124462);
    }

    public void synGetServerConfig(final Context context) {
        AppMethodBeat.i(124463);
        if (context == null) {
            HttpproxyFacade.print(6, TAG, "synGetServerConfig context is null");
            AppMethodBeat.o(124463);
            return;
        }
        try {
            this.thread = new Thread(new Runnable() {
                public void run() {
                    AppMethodBeat.i(124456);
                    ConfigStorage.access$0(ConfigStorage.this, context);
                    AppMethodBeat.o(124456);
                }
            });
            if (this.thread == null) {
                HttpproxyFacade.print(6, TAG, "thread create failed");
                AppMethodBeat.o(124463);
                return;
            }
            this.thread.start();
            AppMethodBeat.o(124463);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
            AppMethodBeat.o(124463);
        }
    }

    public void stopGetServerConfig() {
        AppMethodBeat.i(124464);
        try {
            if (this.thread != null) {
                this.thread.interrupt();
                AppMethodBeat.o(124464);
                return;
            }
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "thread create exception");
        }
        AppMethodBeat.o(124464);
    }

    private boolean needGetConfig() {
        AppMethodBeat.i(124465);
        if (LastGetConfigTime == 0) {
            LastGetConfigTime = System.currentTimeMillis();
            AppMethodBeat.o(124465);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - LastGetConfigTime > GET_CONFIG_INTERVAL || currentTimeMillis < LastGetConfigTime) {
            LastGetConfigTime = System.currentTimeMillis();
            AppMethodBeat.o(124465);
            return true;
        }
        AppMethodBeat.o(124465);
        return false;
    }

    static /* synthetic */ void access$0(ConfigStorage configStorage, Context context) {
        AppMethodBeat.i(124471);
        configStorage.synGetConfig(context);
        AppMethodBeat.o(124471);
    }

    private void synGetConfig(Context context) {
        AppMethodBeat.i(124466);
        if (needGetConfig()) {
            int i = -1;
            try {
                JSONObject jSONObject = new JSONObject(fetchTextFromUrl(makeGetServerConfigUrl(context), context));
                if (jSONObject.has("httpproxy_config")) {
                    i = 0;
                    HttpproxyFacade.print(3, TAG, "get httpproxy_config:" + jSONObject.getString("httpproxy_config"));
                    setDownProxyConfig(context, jSONObject.getString("httpproxy_config"));
                }
                if (jSONObject.has("config_ver")) {
                    setConfigVersionToSharedPreference(context, jSONObject.getString("config_ver"));
                }
            } catch (Throwable th) {
                HttpproxyFacade.print(6, TAG, "get config exception");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
                jSONObject2.put("report_type", 90);
                HttpproxyFacade.jsonReport(jSONObject2.toString());
                AppMethodBeat.o(124466);
                return;
            } catch (JSONException e) {
                AppMethodBeat.o(124466);
                return;
            }
        }
        HttpproxyFacade.print(4, TAG, "last get config time:" + System.currentTimeMillis() + ",so get config just return");
        AppMethodBeat.o(124466);
    }

    private String makeGetServerConfigUrl(Context context) {
        AppMethodBeat.i(124467);
        String format = String.format("%s?platform=%s&appver=%s&player_channel_id=%s&otype=%s&ipflag=%s&guid=%s", new Object[]{url, platform, TVHttpProxy_Version, TVHttpProxy_channel_id, otype, "1", guid});
        AppMethodBeat.o(124467);
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e A:{SYNTHETIC, Splitter:B:21:0x007e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SSLContext getHttpsSSLContext(Context context) {
        Throwable th;
        AppMethodBeat.i(124468);
        InputStream open;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            open = context.getAssets().open(httpsCrtFileName);
            try {
                Certificate generateCertificate = instance.generateCertificate(open);
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load(null, null);
                instance2.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                SSLContext instance4 = SSLContext.getInstance("TLS");
                instance4.init(null, instance3.getTrustManagers(), null);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e) {
                    }
                }
                AppMethodBeat.o(124468);
                return instance4;
            } catch (Throwable th2) {
                th = th2;
                try {
                    HttpproxyFacade.print(6, TAG, "getHttpsSSLContext unknow exception:" + Log.getStackTraceString(th));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.o(124468);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (open != null) {
                    }
                    AppMethodBeat.o(124468);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(124468);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0149 A:{SYNTHETIC, Splitter:B:60:0x0149} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014e A:{SYNTHETIC, Splitter:B:63:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013a A:{SYNTHETIC, Splitter:B:51:0x013a} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0128 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013f A:{SYNTHETIC, Splitter:B:54:0x013f} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0149 A:{SYNTHETIC, Splitter:B:60:0x0149} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014e A:{SYNTHETIC, Splitter:B:63:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0120 A:{SYNTHETIC, Splitter:B:40:0x0120} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0128 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0125 A:{SYNTHETIC, Splitter:B:43:0x0125} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013a A:{SYNTHETIC, Splitter:B:51:0x013a} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013f A:{SYNTHETIC, Splitter:B:54:0x013f} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0128 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private String fetchTextFromUrl(String str, Context context) {
        Throwable th;
        AppMethodBeat.i(124469);
        SSLContext httpsSSLContext = getHttpsSSLContext(context);
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        String str2;
        if (httpsSSLContext == null) {
            str2 = "";
            AppMethodBeat.o(124469);
            return str2;
        }
        int i = 0;
        while (i < 2) {
            String str3;
            if (i == 1) {
                str2 = getBkDomain(str);
                HttpproxyFacade.print(4, TAG, "请求备份域名:".concat(String.valueOf(str2)));
                str3 = str2;
            } else {
                str3 = str;
            }
            int i2 = 0;
            BufferedReader bufferedReader2 = bufferedReader;
            while (i2 < retryTimes[i]) {
                InputStream inputStream2;
                BufferedReader bufferedReader3;
                try {
                    HttpproxyFacade.print(4, TAG, " 第" + (i2 + 1) + " 次CGI请求:" + str3);
                    long currentTimeMillis = System.currentTimeMillis();
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str3).openConnection();
                    httpsURLConnection.setConnectTimeout(connectTimeOut[i2]);
                    httpsURLConnection.setReadTimeout(readTimeOut[i2]);
                    httpsURLConnection.setSSLSocketFactory(httpsSSLContext.getSocketFactory());
                    inputStream2 = httpsURLConnection.getInputStream();
                    try {
                        String readLine;
                        StringBuilder stringBuilder = new StringBuilder();
                        bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream2, ProtocolPackage.ServerEncoding));
                        while (true) {
                            try {
                                readLine = bufferedReader3.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuilder.append(readLine);
                            } catch (IOException e) {
                                try {
                                    HttpproxyFacade.print(6, TAG, "IO Exception" + System.err);
                                    if (inputStream2 != null) {
                                    }
                                    if (bufferedReader3 == null) {
                                    }
                                    i2++;
                                    bufferedReader2 = bufferedReader3;
                                    inputStream = inputStream2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader2 = bufferedReader3;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    AppMethodBeat.o(124469);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                HttpproxyFacade.print(6, TAG, "unknow exception");
                                if (inputStream2 != null) {
                                }
                                if (bufferedReader3 != null) {
                                }
                                i2++;
                                bufferedReader2 = bufferedReader3;
                                inputStream = inputStream2;
                            }
                        }
                        readLine = stringBuilder.toString();
                        HttpproxyFacade.print(4, TAG, "【connect】连接时间：" + (System.currentTimeMillis() - currentTimeMillis) + "返回数据：" + readLine);
                        if (TextUtils.isEmpty(readLine) || readLine.trim().isEmpty()) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e4) {
                                }
                            }
                            try {
                                bufferedReader3.close();
                            } catch (IOException e5) {
                            }
                            i2++;
                            bufferedReader2 = bufferedReader3;
                            inputStream = inputStream2;
                        } else {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e6) {
                                }
                            }
                            try {
                                bufferedReader3.close();
                            } catch (IOException e7) {
                            }
                            AppMethodBeat.o(124469);
                            return readLine;
                        }
                    } catch (IOException e8) {
                        bufferedReader3 = bufferedReader2;
                        HttpproxyFacade.print(6, TAG, "IO Exception" + System.err);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (bufferedReader3 == null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e10) {
                            }
                        }
                        i2++;
                        bufferedReader2 = bufferedReader3;
                        inputStream = inputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        if (inputStream2 != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        AppMethodBeat.o(124469);
                        throw th;
                    }
                } catch (IOException e11) {
                    bufferedReader3 = bufferedReader2;
                    inputStream2 = inputStream;
                } catch (Throwable th42) {
                    th = th42;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    AppMethodBeat.o(124469);
                    throw th;
                }
            }
            i++;
            bufferedReader = bufferedReader2;
        }
        str2 = "";
        AppMethodBeat.o(124469);
        return str2;
    }

    private String getBkDomain(String str) {
        AppMethodBeat.i(124470);
        if (TextUtils.isEmpty(str)) {
            str = "";
            AppMethodBeat.o(124470);
            return str;
        }
        AppMethodBeat.o(124470);
        return str;
    }
}
