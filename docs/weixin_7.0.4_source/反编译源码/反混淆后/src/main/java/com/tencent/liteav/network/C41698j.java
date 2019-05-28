package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.regex.Pattern;

/* renamed from: com.tencent.liteav.network.j */
public class C41698j {
    /* renamed from: a */
    private Context f17079a;
    /* renamed from: b */
    private String f17080b;
    /* renamed from: c */
    private String f17081c;
    /* renamed from: d */
    private String f17082d;
    /* renamed from: e */
    private String f17083e;
    /* renamed from: f */
    private long f17084f;
    /* renamed from: g */
    private long f17085g;
    /* renamed from: h */
    private String f17086h;
    /* renamed from: i */
    private long f17087i;
    /* renamed from: j */
    private long f17088j;
    /* renamed from: k */
    private long f17089k;
    /* renamed from: l */
    private long f17090l;
    /* renamed from: m */
    private long f17091m;
    /* renamed from: n */
    private long f17092n;
    /* renamed from: o */
    private long f17093o;
    /* renamed from: p */
    private long f17094p;
    /* renamed from: q */
    private long f17095q;
    /* renamed from: r */
    private long f17096r;
    /* renamed from: s */
    private long f17097s;
    /* renamed from: t */
    private long f17098t;
    /* renamed from: u */
    private long f17099u;
    /* renamed from: v */
    private long f17100v;
    /* renamed from: w */
    private boolean f17101w = true;

    public C41698j(Context context) {
        AppMethodBeat.m2504i(67573);
        this.f17079a = context.getApplicationContext();
        this.f17080b = C17778b.m27739a(this.f17079a);
        this.f17082d = "Android";
        C17801i.m27844a().mo32953a(this.f17079a);
        mo67339a();
        AppMethodBeat.m2505o(67573);
    }

    /* renamed from: a */
    public void mo67339a() {
        this.f17081c = "";
        this.f17084f = 0;
        this.f17085g = -1;
        this.f17086h = "";
        this.f17087i = -1;
        this.f17088j = -1;
        this.f17089k = -1;
        this.f17090l = -1;
        this.f17083e = "";
        this.f17091m = 0;
        this.f17092n = 0;
        this.f17093o = 0;
        this.f17094p = 0;
        this.f17095q = 0;
        this.f17096r = 0;
        this.f17097s = 0;
        this.f17098t = 0;
        this.f17099u = 0;
        this.f17100v = 0;
        this.f17101w = true;
    }

    /* renamed from: e */
    private void m73328e() {
        AppMethodBeat.m2504i(67574);
        long j = this.f17094p;
        long j2 = this.f17095q;
        mo67339a();
        this.f17092n = j;
        this.f17093o = j2;
        AppMethodBeat.m2505o(67574);
    }

    /* renamed from: b */
    public void mo67345b() {
        AppMethodBeat.m2504i(67575);
        this.f17084f = System.currentTimeMillis();
        this.f17081c = C17801i.m27844a().mo32956b();
        AppMethodBeat.m2505o(67575);
    }

    /* renamed from: c */
    public void mo67347c() {
        AppMethodBeat.m2504i(67576);
        m73329f();
        m73328e();
        AppMethodBeat.m2505o(67576);
    }

    /* renamed from: a */
    public void mo67343a(boolean z) {
        this.f17090l = z ? 2 : 1;
        if (z) {
            this.f17101w = false;
        }
    }

    /* renamed from: a */
    public void mo67342a(String str) {
        this.f17083e = str;
    }

    /* renamed from: a */
    public void mo67344a(boolean z, String str) {
        int i = 0;
        AppMethodBeat.m2504i(67577);
        this.f17086h = str;
        if (z) {
            this.f17085g = 1;
            AppMethodBeat.m2505o(67577);
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
                    if (m73327c(split[i])) {
                        i++;
                    } else {
                        this.f17085g = 3;
                        AppMethodBeat.m2505o(67577);
                        return;
                    }
                }
                this.f17085g = 2;
            }
        }
        AppMethodBeat.m2505o(67577);
    }

    /* renamed from: a */
    public void mo67341a(long j, long j2, long j3) {
        this.f17087i = j;
        this.f17088j = j2;
        this.f17089k = j3;
    }

    /* renamed from: d */
    public void mo67348d() {
        this.f17091m++;
    }

    /* renamed from: a */
    public void mo67340a(long j, long j2) {
        this.f17094p = j;
        this.f17095q = j2;
    }

    /* renamed from: b */
    public void mo67346b(long j, long j2) {
        this.f17100v++;
        this.f17096r += j;
        this.f17097s += j2;
        if (j > this.f17098t) {
            this.f17098t = j;
        }
        if (j2 > this.f17099u) {
            this.f17099u = j2;
        }
    }

    /* renamed from: f */
    private void m73329f() {
        AppMethodBeat.m2504i(67578);
        if (this.f17084f != 0) {
            if (!m73326b(this.f17080b)) {
                if (!m73326b(this.f17083e)) {
                    float f;
                    String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(this.f17083e);
                    long currentTimeMillis = System.currentTimeMillis() - this.f17084f;
                    long j = 0;
                    long j2 = 0;
                    if (this.f17094p > this.f17092n) {
                        j = this.f17094p - this.f17092n;
                    }
                    if (this.f17095q > this.f17093o) {
                        j2 = this.f17095q - this.f17093o;
                    }
                    long j3 = 0;
                    long j4 = 0;
                    if (this.f17100v > 0) {
                        j3 = this.f17096r / this.f17100v;
                        j4 = this.f17097s / this.f17100v;
                    }
                    String txCreateToken = TXCDRApi.txCreateToken();
                    TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
                    tXCDRExtInfo.report_common = false;
                    tXCDRExtInfo.report_status = false;
                    tXCDRExtInfo.url = this.f17083e;
                    TXCDRApi.InitEvent(this.f17079a, txCreateToken, C8795a.f2499Y, C8795a.f2544aq, tXCDRExtInfo);
                    TXCDRApi.txSetEventValue(txCreateToken, C8795a.f2499Y, "str_user_id", this.f17080b);
                    TXCDRApi.txSetEventValue(txCreateToken, C8795a.f2499Y, "str_stream_id", streamIDByStreamUrl);
                    TXCDRApi.txSetEventValue(txCreateToken, C8795a.f2499Y, "str_access_id", this.f17081c);
                    TXCDRApi.txSetEventValue(txCreateToken, C8795a.f2499Y, "str_platform", this.f17082d);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_server_type", this.f17085g);
                    TXCDRApi.txSetEventValue(txCreateToken, C8795a.f2499Y, "str_server_addr", this.f17086h);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_dns_timecost", this.f17087i);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_connect_timecost", this.f17088j);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_handshake_timecost", this.f17089k);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_push_type", this.f17090l);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_totaltime", currentTimeMillis);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_block_count", this.f17091m);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_video_drop", j);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_audio_drop", j2);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_video_que_avg", j3);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_audio_que_avg", j4);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_video_que_max", this.f17098t);
                    TXCDRApi.txSetEventIntValue(txCreateToken, C8795a.f2499Y, "u32_audio_que_max", this.f17099u);
                    TXCDRApi.nativeReportEvent(txCreateToken, C8795a.f2499Y);
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    if (currentTimeMillis > 0) {
                        if (this.f17091m == 0) {
                            f2 = 0.0f;
                        } else {
                            f2 = (((float) this.f17091m) * 60000.0f) / ((float) currentTimeMillis);
                        }
                    }
                    if (this.f17100v > 0) {
                        float f4;
                        if (this.f17096r == 0) {
                            f4 = 0.0f;
                        } else {
                            f4 = ((float) this.f17096r) / ((float) this.f17100v);
                        }
                        if (this.f17097s == 0) {
                            f3 = 0.0f;
                            f = f4;
                        } else {
                            f3 = ((float) this.f17097s) / ((float) this.f17100v);
                            f = f4;
                        }
                    } else {
                        f = 0.0f;
                    }
                    if (this.f17101w) {
                        if (!(m73326b(this.f17081c) || this.f17089k == -1)) {
                            C17801i.m27844a().mo32955a(this.f17081c, this.f17085g, currentTimeMillis, this.f17089k, f2, f, f3);
                        }
                    }
                    AppMethodBeat.m2505o(67578);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(67578);
    }

    /* renamed from: b */
    private boolean m73326b(String str) {
        AppMethodBeat.m2504i(67579);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(67579);
            return true;
        }
        AppMethodBeat.m2505o(67579);
        return false;
    }

    /* renamed from: c */
    private boolean m73327c(String str) {
        AppMethodBeat.m2504i(67580);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.m2505o(67580);
        return matches;
    }
}
