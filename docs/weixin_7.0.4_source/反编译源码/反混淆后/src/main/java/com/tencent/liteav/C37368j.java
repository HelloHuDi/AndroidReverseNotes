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

/* renamed from: com.tencent.liteav.j */
public class C37368j {
    /* renamed from: a */
    private String f15972a = "";
    /* renamed from: b */
    private String f15973b = "";
    /* renamed from: c */
    private String f15974c = "";
    /* renamed from: d */
    private String f15975d = "";
    /* renamed from: e */
    private long f15976e = 0;
    /* renamed from: f */
    private long f15977f = 0;
    /* renamed from: g */
    private long f15978g = 0;

    /* renamed from: com.tencent.liteav.j$a */
    public interface C0963a {
        void onLiveTime(long j);
    }

    /* renamed from: d */
    static /* synthetic */ String m62891d(C37368j c37368j, String str) {
        AppMethodBeat.m2504i(67094);
        String a = c37368j.m62883a(str);
        AppMethodBeat.m2505o(67094);
        return a;
    }

    public C37368j(Context context) {
    }

    /* renamed from: a */
    public long mo60179a() {
        AppMethodBeat.m2504i(67090);
        this.f15978g = System.currentTimeMillis() - this.f15976e;
        long j = this.f15978g;
        AppMethodBeat.m2505o(67090);
        return j;
    }

    /* renamed from: a */
    public String mo60180a(long j) {
        AppMethodBeat.m2504i(67091);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.f15976e + (1000 * j)));
        format = String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[]{this.f15972a, this.f15974c, this.f15973b, format, this.f15975d});
        AppMethodBeat.m2505o(67091);
        return format;
    }

    /* renamed from: a */
    public int mo60178a(String str, String str2, int i, C0963a c0963a) {
        AppMethodBeat.m2504i(67092);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(67092);
            return -1;
        }
        this.f15975d = TXCCommonUtil.getAppID();
        if (TextUtils.isEmpty(this.f15975d)) {
            AppMethodBeat.m2505o(67092);
            return -2;
        }
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final C0963a c0963a2 = c0963a;
        AsyncTask.execute(new Runnable() {

            /* renamed from: com.tencent.liteav.j$1$1 */
            class C321691 implements Runnable {
                C321691() {
                }

                public void run() {
                    AppMethodBeat.m2504i(67706);
                    c0963a2.onLiveTime(C37368j.this.f15978g);
                    AppMethodBeat.m2505o(67706);
                }
            }

            public void run() {
                AppMethodBeat.m2504i(67448);
                C37368j.this.f15977f = 0;
                C37368j.this.f15976e = 0;
                C37368j.this.f15978g = 0;
                C37368j.this.f15973b = "";
                C37368j.this.f15974c = "";
                if (i2 > 0) {
                    C37368j.this.f15974c = String.valueOf(i2);
                }
                C37368j.this.f15972a = str3;
                C37368j.this.f15973b = TXCCommonUtil.getStreamIDByStreamUrl(str4);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[]{C37368j.this.f15972a, C37368j.this.f15974c, C37368j.this.f15973b, C37368j.this.f15975d})).openConnection();
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
                    TXCLog.m15676e("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = ".concat(String.valueOf(str)));
                    str = C37368j.m62891d(C37368j.this, str);
                    long parseLong = Long.parseLong(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    TXCLog.m15677i("TXCTimeShiftUtil", "time:" + str + ",currentTime:" + currentTimeMillis + ",diff:" + (currentTimeMillis - parseLong));
                    C37368j.this.f15976e = parseLong * 1000;
                    C37368j.this.f15978g = currentTimeMillis - C37368j.this.f15976e;
                    if (c0963a2 != null) {
                        new Handler(Looper.getMainLooper()).post(new C321691());
                    }
                    AppMethodBeat.m2505o(67448);
                } catch (Exception e) {
                    C37368j.this.f15976e = 0;
                    AppMethodBeat.m2505o(67448);
                }
            }
        });
        AppMethodBeat.m2505o(67092);
        return 0;
    }

    /* renamed from: a */
    private String m62883a(String str) {
        AppMethodBeat.m2504i(67093);
        if (str.contains("#EXT-TX-TS-START-TIME")) {
            int indexOf = str.indexOf("#EXT-TX-TS-START-TIME:") + 22;
            if (indexOf > 0) {
                String substring = str.substring(indexOf);
                int indexOf2 = substring.indexOf("#");
                if (indexOf2 > 0) {
                    substring = substring.substring(0, indexOf2).replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "");
                    AppMethodBeat.m2505o(67093);
                    return substring;
                }
            }
        }
        AppMethodBeat.m2505o(67093);
        return null;
    }
}
