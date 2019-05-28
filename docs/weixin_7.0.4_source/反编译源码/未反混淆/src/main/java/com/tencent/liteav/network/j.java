package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.regex.Pattern;

public class j {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private long g;
    private String h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private boolean w = true;

    public j(Context context) {
        AppMethodBeat.i(67573);
        this.a = context.getApplicationContext();
        this.b = b.a(this.a);
        this.d = "Android";
        i.a().a(this.a);
        a();
        AppMethodBeat.o(67573);
    }

    public void a() {
        this.c = "";
        this.f = 0;
        this.g = -1;
        this.h = "";
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.e = "";
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = true;
    }

    private void e() {
        AppMethodBeat.i(67574);
        long j = this.p;
        long j2 = this.q;
        a();
        this.n = j;
        this.o = j2;
        AppMethodBeat.o(67574);
    }

    public void b() {
        AppMethodBeat.i(67575);
        this.f = System.currentTimeMillis();
        this.c = i.a().b();
        AppMethodBeat.o(67575);
    }

    public void c() {
        AppMethodBeat.i(67576);
        f();
        e();
        AppMethodBeat.o(67576);
    }

    public void a(boolean z) {
        this.l = z ? 2 : 1;
        if (z) {
            this.w = false;
        }
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(boolean z, String str) {
        int i = 0;
        AppMethodBeat.i(67577);
        this.h = str;
        if (z) {
            this.g = 1;
            AppMethodBeat.o(67577);
            return;
        }
        if (str != null) {
            int indexOf = str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str != null) {
                String[] split = str.split("[.]");
                int length = split.length;
                while (i < length) {
                    if (c(split[i])) {
                        i++;
                    } else {
                        this.g = 3;
                        AppMethodBeat.o(67577);
                        return;
                    }
                }
                this.g = 2;
            }
        }
        AppMethodBeat.o(67577);
    }

    public void a(long j, long j2, long j3) {
        this.i = j;
        this.j = j2;
        this.k = j3;
    }

    public void d() {
        this.m++;
    }

    public void a(long j, long j2) {
        this.p = j;
        this.q = j2;
    }

    public void b(long j, long j2) {
        this.v++;
        this.r += j;
        this.s += j2;
        if (j > this.t) {
            this.t = j;
        }
        if (j2 > this.u) {
            this.u = j2;
        }
    }

    private void f() {
        AppMethodBeat.i(67578);
        if (this.f != 0) {
            if (!b(this.b)) {
                if (!b(this.e)) {
                    float f;
                    String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(this.e);
                    long currentTimeMillis = System.currentTimeMillis() - this.f;
                    long j = 0;
                    long j2 = 0;
                    if (this.p > this.n) {
                        j = this.p - this.n;
                    }
                    if (this.q > this.o) {
                        j2 = this.q - this.o;
                    }
                    long j3 = 0;
                    long j4 = 0;
                    if (this.v > 0) {
                        j3 = this.r / this.v;
                        j4 = this.s / this.v;
                    }
                    String txCreateToken = TXCDRApi.txCreateToken();
                    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
                    tXCDRExtInfo.report_common = false;
                    tXCDRExtInfo.report_status = false;
                    tXCDRExtInfo.url = this.e;
                    TXCDRApi.InitEvent(this.a, txCreateToken, a.Y, a.aq, tXCDRExtInfo);
                    TXCDRApi.txSetEventValue(txCreateToken, a.Y, "str_user_id", this.b);
                    TXCDRApi.txSetEventValue(txCreateToken, a.Y, "str_stream_id", streamIDByStreamUrl);
                    TXCDRApi.txSetEventValue(txCreateToken, a.Y, "str_access_id", this.c);
                    TXCDRApi.txSetEventValue(txCreateToken, a.Y, "str_platform", this.d);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_server_type", this.g);
                    TXCDRApi.txSetEventValue(txCreateToken, a.Y, "str_server_addr", this.h);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_dns_timecost", this.i);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_connect_timecost", this.j);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_handshake_timecost", this.k);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_push_type", this.l);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_totaltime", currentTimeMillis);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_block_count", this.m);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_video_drop", j);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_audio_drop", j2);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_video_que_avg", j3);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_audio_que_avg", j4);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_video_que_max", this.t);
                    TXCDRApi.txSetEventIntValue(txCreateToken, a.Y, "u32_audio_que_max", this.u);
                    TXCDRApi.nativeReportEvent(txCreateToken, a.Y);
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    if (currentTimeMillis > 0) {
                        if (this.m == 0) {
                            f2 = 0.0f;
                        } else {
                            f2 = (((float) this.m) * 60000.0f) / ((float) currentTimeMillis);
                        }
                    }
                    if (this.v > 0) {
                        float f4;
                        if (this.r == 0) {
                            f4 = 0.0f;
                        } else {
                            f4 = ((float) this.r) / ((float) this.v);
                        }
                        if (this.s == 0) {
                            f3 = 0.0f;
                            f = f4;
                        } else {
                            f3 = ((float) this.s) / ((float) this.v);
                            f = f4;
                        }
                    } else {
                        f = 0.0f;
                    }
                    if (this.w) {
                        if (!(b(this.c) || this.k == -1)) {
                            i.a().a(this.c, this.g, currentTimeMillis, this.k, f2, f, f3);
                        }
                    }
                    AppMethodBeat.o(67578);
                    return;
                }
            }
        }
        AppMethodBeat.o(67578);
    }

    private boolean b(String str) {
        AppMethodBeat.i(67579);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(67579);
            return true;
        }
        AppMethodBeat.o(67579);
        return false;
    }

    private boolean c(String str) {
        AppMethodBeat.i(67580);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(67580);
        return matches;
    }
}
