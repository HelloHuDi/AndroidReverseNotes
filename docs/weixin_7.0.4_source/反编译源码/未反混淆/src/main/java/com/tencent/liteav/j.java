package com.tencent.liteav;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class j {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private long e = 0;
    private long f = 0;
    private long g = 0;

    public interface a {
        void onLiveTime(long j);
    }

    static /* synthetic */ String d(j jVar, String str) {
        AppMethodBeat.i(67094);
        String a = jVar.a(str);
        AppMethodBeat.o(67094);
        return a;
    }

    public j(Context context) {
    }

    public long a() {
        AppMethodBeat.i(67090);
        this.g = System.currentTimeMillis() - this.e;
        long j = this.g;
        AppMethodBeat.o(67090);
        return j;
    }

    public String a(long j) {
        AppMethodBeat.i(67091);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.e + (1000 * j)));
        format = String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[]{this.a, this.c, this.b, format, this.d});
        AppMethodBeat.o(67091);
        return format;
    }

    public int a(String str, String str2, int i, a aVar) {
        AppMethodBeat.i(67092);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(67092);
            return -1;
        }
        this.d = TXCCommonUtil.getAppID();
        if (TextUtils.isEmpty(this.d)) {
            AppMethodBeat.o(67092);
            return -2;
        }
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final a aVar2 = aVar;
        AsyncTask.execute(new Runnable() {
            public void run() {
                AppMethodBeat.i(67448);
                j.this.f = 0;
                j.this.e = 0;
                j.this.g = 0;
                j.this.b = "";
                j.this.c = "";
                if (i2 > 0) {
                    j.this.c = String.valueOf(i2);
                }
                j.this.a = str3;
                j.this.b = TXCCommonUtil.getStreamIDByStreamUrl(str4);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[]{j.this.a, j.this.c, j.this.b, j.this.d})).openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Charsert", "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "text/plain;");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    String str = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str = str + readLine;
                    }
                    TXCLog.e("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = ".concat(String.valueOf(str)));
                    str = j.d(j.this, str);
                    long parseLong = Long.parseLong(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    TXCLog.i("TXCTimeShiftUtil", "time:" + str + ",currentTime:" + currentTimeMillis + ",diff:" + (currentTimeMillis - parseLong));
                    j.this.e = parseLong * 1000;
                    j.this.g = currentTimeMillis - j.this.e;
                    if (aVar2 != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                AppMethodBeat.i(67706);
                                aVar2.onLiveTime(j.this.g);
                                AppMethodBeat.o(67706);
                            }
                        });
                    }
                    AppMethodBeat.o(67448);
                } catch (Exception e) {
                    j.this.e = 0;
                    AppMethodBeat.o(67448);
                }
            }
        });
        AppMethodBeat.o(67092);
        return 0;
    }

    private String a(String str) {
        AppMethodBeat.i(67093);
        if (str.contains("#EXT-TX-TS-START-TIME")) {
            int indexOf = str.indexOf("#EXT-TX-TS-START-TIME:") + 22;
            if (indexOf > 0) {
                String substring = str.substring(indexOf);
                int indexOf2 = substring.indexOf("#");
                if (indexOf2 > 0) {
                    substring = substring.substring(0, indexOf2).replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "");
                    AppMethodBeat.o(67093);
                    return substring;
                }
            }
        }
        AppMethodBeat.o(67093);
        return null;
    }
}
