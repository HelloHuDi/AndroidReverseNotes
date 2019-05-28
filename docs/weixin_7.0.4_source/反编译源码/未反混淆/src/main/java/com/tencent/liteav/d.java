package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class d {
    private static String a = "TXCDataReport";
    private static HashMap<String, a> w = new HashMap();
    private HashMap b = new HashMap(100);
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Context h;
    private String i;
    private long j;
    private int k;
    private long l;
    private boolean m;
    private long n;
    private int o;
    private boolean p = false;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private String v;
    private String x = "";

    enum a {
        PENDING,
        CONFIRM,
        NEGATIVE;

        static {
            AppMethodBeat.o(65999);
        }
    }

    static {
        AppMethodBeat.i(67704);
        AppMethodBeat.o(67704);
    }

    public d(Context context) {
        AppMethodBeat.i(67681);
        this.h = context.getApplicationContext();
        this.i = TXCCommonUtil.getAppVersion();
        this.o = 5000;
        this.u = 0;
        AppMethodBeat.o(67681);
    }

    public void a() {
        AppMethodBeat.i(67682);
        r();
        this.l = -1;
        this.q = System.currentTimeMillis();
        AppMethodBeat.o(67682);
    }

    public void b() {
        AppMethodBeat.i(67683);
        if (this.m) {
            p();
            AppMethodBeat.o(67683);
            return;
        }
        TXCLog.e(a, "push " + this.c + " failed!");
        n();
        AppMethodBeat.o(67683);
    }

    public void c() {
        AppMethodBeat.i(67684);
        if (!this.m) {
            TXCLog.e(a, "play " + this.c + " failed");
            if (this.p) {
                b(false);
            } else {
                j();
            }
        } else if (this.p) {
            s();
        } else {
            k();
        }
        if (this.p) {
            m();
        }
        AppMethodBeat.o(67684);
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void a(String str) {
        AppMethodBeat.i(67685);
        this.c = str;
        b(str);
        AppMethodBeat.o(67685);
    }

    public void b(String str) {
        if (str != null) {
            this.v = str;
        }
    }

    /* Access modifiers changed, original: protected */
    public a d() {
        AppMethodBeat.i(67686);
        Uri parse = Uri.parse(this.v);
        a aVar;
        if (parse == null) {
            aVar = a.PENDING;
            AppMethodBeat.o(67686);
            return aVar;
        }
        final String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            aVar = a.PENDING;
            AppMethodBeat.o(67686);
            return aVar;
        }
        String scheme = parse.getScheme();
        if (scheme == null) {
            aVar = a.PENDING;
            AppMethodBeat.o(67686);
            return aVar;
        } else if (scheme.equals("rtmp") || scheme.equals("http") || scheme.equals("https")) {
            try {
                if (c(host)) {
                    aVar = a.CONFIRM;
                    AppMethodBeat.o(67686);
                    return aVar;
                }
                Set queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && (queryParameterNames.contains("bizid") || queryParameterNames.contains("txTime") || queryParameterNames.contains("txSecret"))) {
                    aVar = a.CONFIRM;
                    AppMethodBeat.o(67686);
                    return aVar;
                } else if (w.containsKey(host)) {
                    aVar = (a) w.get(host);
                    AppMethodBeat.o(67686);
                    return aVar;
                } else {
                    w.put(host, a.PENDING);
                    new Thread(new Runnable() {
                        public void run() {
                            boolean z = false;
                            AppMethodBeat.i(66802);
                            try {
                                for (e eVar : com.tencent.liteav.network.a.a.a.c().a(new b(host, true), null)) {
                                    if (eVar.a() && d.c(eVar.a)) {
                                        z = true;
                                        break;
                                    }
                                }
                                d.w.put(host, z ? a.CONFIRM : a.NEGATIVE);
                                TXCLog.d(d.a, host + " isTencent " + z);
                                AppMethodBeat.o(66802);
                            } catch (Exception e) {
                                AppMethodBeat.o(66802);
                            }
                        }
                    }).start();
                    aVar = a.PENDING;
                    AppMethodBeat.o(67686);
                    return aVar;
                }
            } catch (Exception e) {
            }
        } else {
            aVar = a.PENDING;
            AppMethodBeat.o(67686);
            return aVar;
        }
    }

    protected static boolean c(String str) {
        AppMethodBeat.i(67687);
        if (str == null || !str.contains("myqcloud")) {
            boolean a = com.tencent.liteav.basic.f.b.a().a(str);
            AppMethodBeat.o(67687);
            return a;
        }
        AppMethodBeat.o(67687);
        return true;
    }

    public void d(String str) {
        this.x = str;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void a(int i) {
        this.f = i;
    }

    public void b(int i) {
        this.g = i;
    }

    public void e() {
        AppMethodBeat.i(67688);
        if (!(this.m || TextUtils.isEmpty(TXCStatus.c(this.x, 7012)))) {
            o();
            this.m = true;
        }
        if (this.n <= 0) {
            this.n = TXCTimeUtil.getTimeTick();
        }
        if (this.m && TXCTimeUtil.getTimeTick() - this.n > 5000) {
            q();
            this.n = TXCTimeUtil.getTimeTick();
        }
        AppMethodBeat.o(67688);
    }

    public void f() {
        AppMethodBeat.i(67689);
        if (!this.m) {
            long b = TXCStatus.b(this.x, 6001);
            long b2 = TXCStatus.b(this.x, 7104);
            if (!(b == 0 && b2 == 0)) {
                if (this.p) {
                    b(true);
                } else {
                    i();
                }
                this.o = 5000;
                this.m = true;
            }
            String c = TXCStatus.c(this.x, 7119);
            if (c != null) {
                b(c);
            }
        }
        if (this.n <= 0) {
            this.n = TXCTimeUtil.getTimeTick();
        }
        if (this.m && TXCTimeUtil.getTimeTick() > this.n + ((long) this.o)) {
            if (this.p) {
                t();
                this.o = 5000;
            } else if (d() == a.NEGATIVE) {
                AppMethodBeat.o(67689);
                return;
            } else {
                l();
                this.o = TXCDRApi.getStatusReportInterval();
                if (this.o < 5000) {
                    this.o = 5000;
                }
                if (this.o > 300000) {
                    this.o = 300000;
                }
            }
            this.l = TXCStatus.b(this.x, 6004);
            this.n = TXCTimeUtil.getTimeTick();
        }
        AppMethodBeat.o(67689);
    }

    private void i() {
        AppMethodBeat.i(67690);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.Z, com.tencent.liteav.basic.datareport.a.ar, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_network_type", (long) e("u32_network_type"));
        long b = TXCStatus.b(this.x, 7107);
        long b2 = TXCStatus.b(this.x, 7108);
        if (b2 != -1) {
            b2 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_dns_time", b2);
        String c = TXCStatus.c(this.x, 7110);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_server_ip", c);
        long b3 = TXCStatus.b(this.x, 7109);
        if (b3 != -1) {
            b3 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_connect_server_time", b3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_stream_begin", -1);
        this.j = TXCStatus.b(this.x, 6001) - b;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_first_i_frame", this.j);
        b = TXCStatus.b(this.x, 7103) - b;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_first_frame_down", b);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Z);
        TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + utcTimeTick + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=" + b2 + " u32_server_ip=" + c + " u32_connect_server_time=" + b3 + " u32_stream_begin=-1 u32_first_i_frame=" + this.j + " u32_first_frame_down=" + b + " str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u32_isp2p=" + this.k);
        AppMethodBeat.o(67690);
    }

    private void j() {
        AppMethodBeat.i(67691);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.Z, com.tencent.liteav.basic.datareport.a.ar, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_dns_time", -1);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_stream_begin", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_first_i_frame", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_first_frame_down", -1);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Z);
        TXCLog.d(a, "report evt 40101: token=" + str + " u64_timestamp=" + utcTimeTick + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=-1 u32_server_ip= u32_connect_server_time=-1 u32_stream_begin=-1 u32_first_i_frame=-1 u32_first_frame_down=-1 str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u32_isp2p=" + this.k);
        AppMethodBeat.o(67691);
    }

    private void k() {
        AppMethodBeat.i(67692);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.ab, com.tencent.liteav.basic.datareport.a.ar, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u64_timestamp", utcTimeTick);
        long timeTick = (TXCTimeUtil.getTimeTick() - TXCStatus.b(this.x, 7107)) / 1000;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_result", timeTick);
        long b = TXCStatus.b(this.x, 6003);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_avg_block_time", b);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ab, "str_app_version", this.i);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_isp2p", (long) this.k);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_avg_load", TXCStatus.b(this.x, 2001));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_load_cnt", TXCStatus.b(this.x, 2002));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_max_load", TXCStatus.b(this.x, 2003));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_first_i_frame", this.j);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_speed_cnt", TXCStatus.b(this.x, 2004));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_nodata_cnt", TXCStatus.b(this.x, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_avg_cache_time", TXCStatus.b(this.x, TXLiveConstants.PLAY_EVT_PLAY_LOADING));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ab, "u32_is_real_time", TXCStatus.b(this.x, 2008));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.ab);
        TXCLog.d(a, "report evt 40102: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " u32_result=" + timeTick + " u32_avg_block_time=" + b + " str_app_version=" + this.i + " u32_isp2p=" + this.k + " u32_avg_load=" + TXCStatus.b(this.x, 2001) + " u32_load_cnt=" + TXCStatus.b(this.x, 2002) + " u32_max_load=" + TXCStatus.b(this.x, 2003) + " u32_first_i_frame=" + this.j + " u32_speed_cnt=" + TXCStatus.b(this.x, 2004) + " u32_nodata_cnt=" + TXCStatus.b(this.x, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) + " u32_avg_cache_time=" + TXCStatus.b(this.x, TXLiveConstants.PLAY_EVT_PLAY_LOADING) + " u32_is_real_time=" + TXCStatus.b(this.x, 2008));
        AppMethodBeat.o(67692);
    }

    private void l() {
        AppMethodBeat.i(67693);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.aa, com.tencent.liteav.basic.datareport.a.ar, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_avg_net_speed", (long) (TXCStatus.d(this.x, 7102) + TXCStatus.d(this.x, 7101)));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_fps", (long) ((int) TXCStatus.e(this.x, 6002)));
        long b = TXCStatus.b(this.x, 6004);
        if (this.l == -1 || b < this.l) {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_avg_block_count", 0);
        } else {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_avg_block_count", b - this.l);
        }
        this.l = b;
        int[] a = com.tencent.liteav.basic.util.b.a();
        int b2 = com.tencent.liteav.basic.util.b.b();
        long b3 = TXCStatus.b(this.x, TXLiveConstants.PLAY_EVT_PLAY_END);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_avg_cache_count", b3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_cpu_usage", (long) a[1]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_app_cpu_usage", (long) a[0]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_app_mem_usage", (long) b2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.aa, "str_app_version", this.i);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.aa, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.aa);
        if (this.p) {
            this.t++;
            this.s += b3;
            if (b3 > this.r) {
                this.r = b3;
            }
        }
        AppMethodBeat.o(67693);
    }

    private void m() {
        AppMethodBeat.i(67694);
        HashMap hashMap = new HashMap();
        String c = TXCStatus.c(this.x, 7113);
        String c2 = TXCStatus.c(this.x, 7114);
        String c3 = TXCStatus.c(this.x, 7115);
        int d = TXCStatus.d(this.x, 7105);
        String c4 = TXCStatus.c(this.x, 7106);
        int d2 = TXCStatus.d(this.x, 7111);
        hashMap.put("stream_url", c);
        hashMap.put("stream_id", c2);
        hashMap.put("bizid", c3);
        hashMap.put("err_code", String.valueOf(d));
        hashMap.put("err_info", c4);
        hashMap.put("channel_type", String.valueOf(d2));
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.q;
        hashMap.put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.q)));
        hashMap.put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(currentTimeMillis)));
        hashMap.put("total_time", String.valueOf(j));
        j = TXCStatus.b(this.x, 6003);
        currentTimeMillis = TXCStatus.b(this.x, 6006);
        long b = TXCStatus.b(this.x, 6005);
        if (j != 0) {
            currentTimeMillis /= j;
        } else {
            currentTimeMillis = 0;
        }
        hashMap.put("block_count", String.valueOf(j));
        hashMap.put("block_duration_max", String.valueOf(b));
        hashMap.put("block_duration_avg", String.valueOf(currentTimeMillis));
        if (this.t != 0) {
            currentTimeMillis = this.s / this.t;
        } else {
            currentTimeMillis = 0;
        }
        hashMap.put("jitter_cache_max", String.valueOf(this.r));
        hashMap.put("jitter_cache_avg", String.valueOf(currentTimeMillis));
        c3 = TXCDRApi.txCreateToken();
        d = com.tencent.liteav.basic.datareport.a.ak;
        int i = com.tencent.liteav.basic.datareport.a.aq;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.h, c3, d, i, tXCDRExtInfo);
        TXCLog.d(a, "report evt 40402: token=".concat(String.valueOf(c3)));
        for (Entry entry : hashMap.entrySet()) {
            c2 = (String) entry.getKey();
            c = (String) entry.getValue();
            TXCLog.e(a, "RealTimePlayStatisticInfo: " + c2 + " = " + c);
            if (!(c2 == null || c2.length() <= 0 || c == null)) {
                TXCDRApi.txSetEventValue(c3, d, c2, c);
            }
        }
        TXCDRApi.nativeReportEvent(c3, d);
        this.p = false;
        this.q = 0;
        this.t = 0;
        this.s = 0;
        this.r = 0;
        AppMethodBeat.o(67694);
    }

    private void n() {
        AppMethodBeat.i(67695);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.c;
        long b = TXCStatus.b(this.x, 7013);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.U, com.tencent.liteav.basic.datareport.a.aq, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_dns_time", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_video_resolution", (long) ((this.d << 16) | this.e));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_audio_samplerate", (long) this.g);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_video_bitrate", (long) this.f);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_channel_type", b);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.U);
        TXCLog.d(a, "report evt 40001: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=-1 u32_connect_server_time=-1 u32_server_ip= u32_video_resolution=" + ((this.d << 16) | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + b + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + e("u32_max_load"));
        AppMethodBeat.o(67695);
    }

    private void o() {
        long j;
        AppMethodBeat.i(67696);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.c;
        String c = TXCStatus.c(this.x, 7012);
        long b = TXCStatus.b(this.x, 7009);
        long b2 = TXCStatus.b(this.x, 7010);
        if (b2 != -1) {
            j = b2 - b;
        } else {
            j = b2;
        }
        b2 = TXCStatus.b(this.x, 7011);
        if (b2 != -1) {
            b = b2 - b;
        } else {
            b = b2;
        }
        long b3 = TXCStatus.b(this.x, 7013);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.U, com.tencent.liteav.basic.datareport.a.aq, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_dns_time", j);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_connect_server_time", b);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_server_ip", c);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_video_resolution", (long) ((this.d << 16) | this.e));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_audio_samplerate", (long) this.g);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_video_bitrate", (long) this.f);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_channel_type", b3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_nearest_ip_list", TXCStatus.c(this.x, 7019));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.U);
        TXCLog.d(a, "report evt 40001: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.b.get("str_device_type") + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=" + j + " u32_connect_server_time=" + b + " u32_server_ip=" + c + " u32_video_resolution=" + ((this.d << 16) | this.e) + " u32_audio_samplerate=" + this.g + " u32_video_bitrate=" + this.f + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + b3 + " str_app_version=" + this.b.get("dev_uuid") + " dev_uuid=" + e("u32_max_load"));
        AppMethodBeat.o(67696);
    }

    private void p() {
        AppMethodBeat.i(67697);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.c;
        long b = TXCStatus.b(this.x, 7009);
        long b2 = TXCStatus.b(this.x, 7013);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.W, com.tencent.liteav.basic.datareport.a.aq, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u64_timestamp", utcTimeTick);
        b = (TXCTimeUtil.getTimeTick() - b) / 1000;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_result", b);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_channel_type", b2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "dev_uuid", (String) this.b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_ip_count_quic", String.valueOf(TXCStatus.d(this.x, 7016)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_connect_count_quic", String.valueOf(TXCStatus.d(this.x, 7017)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_connect_count_tcp", String.valueOf(TXCStatus.d(this.x, 7018)));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.W);
        TXCLog.d(a, "report evt 40002: token=" + str + " str_stream_url=" + this.c + " u64_timestamp=" + utcTimeTick + " u32_result=" + b + " str_user_id=" + this.b.get("str_user_id") + " str_package_name=" + this.b.get("str_package_name") + " u32_channel_type=" + b2 + " str_app_version=" + this.i + " dev_uuid=" + this.b.get("dev_uuid"));
        AppMethodBeat.o(67697);
    }

    private void q() {
        AppMethodBeat.i(67698);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        tXCDRExtInfo.url = this.c;
        int[] a = com.tencent.liteav.basic.util.b.a();
        int i = a[0];
        int i2 = a[1];
        int b = com.tencent.liteav.basic.util.b.b();
        long b2 = TXCStatus.b(this.x, 7013);
        int d = TXCStatus.d(this.x, 7004);
        int d2 = TXCStatus.d(this.x, 7003);
        double e = TXCStatus.e(this.x, WearableStatusCodes.DUPLICATE_LISTENER);
        int d3 = TXCStatus.d(this.x, 7005);
        int d4 = TXCStatus.d(this.x, 7002);
        int d5 = TXCStatus.d(this.x, 7001);
        int d6 = TXCStatus.d(this.x, WearableStatusCodes.INVALID_TARGET_NODE);
        String c = TXCStatus.c(this.x, 7012);
        String c2 = TXCStatus.c(this.x, 7014);
        String c3 = TXCStatus.c(this.x, 7015);
        String c4 = TXCStatus.c(this.x, 3001);
        long b3 = TXCStatus.b(this.x, 3002);
        double e2 = TXCStatus.e(this.x, 3003);
        int d7 = TXCStatus.d(this.x, 7020);
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.V, com.tencent.liteav.basic.datareport.a.aq, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_audio_bitrate", (long) d4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_video_bitrate", (long) d5);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_net_speed", (long) (d + d2));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_fps", (long) ((int) e));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_cache_size", (long) d3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_cpu_usage", (long) i2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_app_cpu_usage", (long) i);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_app_mem_usage", (long) b);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_channel_type", b2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_hw_enc", (long) d6);
        try {
            if (this.h != null && com.tencent.liteav.basic.util.b.c(this.h) == 1) {
                WifiManager wifiManager = (WifiManager) this.h.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_wifi_ssid", connectionInfo.getSSID());
                        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "str_wifi_signal_strength", (long) WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 32));
                        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "str_wifi_link_speed", (long) connectionInfo.getLinkSpeed());
                    }
                }
            }
        } catch (Exception e3) {
        }
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_server_ip", c);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_quic_connection_id", c2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_quic_connection_stats", c3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_beauty_stats", c4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_send_strategy", (long) d7);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_preprocess_timecost", b3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_preprocess_fps_out", (long) ((int) e2));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.V);
        AppMethodBeat.o(67698);
    }

    private int e(String str) {
        AppMethodBeat.i(67699);
        Number number = (Number) this.b.get(str);
        if (number != null) {
            int intValue = number.intValue();
            AppMethodBeat.o(67699);
            return intValue;
        }
        AppMethodBeat.o(67699);
        return 0;
    }

    private void r() {
        AppMethodBeat.i(67700);
        this.m = false;
        this.n = 0;
        this.b.put("str_user_id", com.tencent.liteav.basic.util.b.a(this.h));
        this.b.put("str_device_type", com.tencent.liteav.basic.util.b.c());
        this.b.put("str_device_type", com.tencent.liteav.basic.util.b.c());
        this.b.put("u32_network_type", Integer.valueOf(com.tencent.liteav.basic.util.b.c(this.h)));
        this.b.put("token", com.tencent.liteav.basic.util.b.d());
        this.b.put("str_package_name", com.tencent.liteav.basic.util.b.b(this.h));
        this.b.put("dev_uuid", com.tencent.liteav.basic.util.b.d(this.h));
        AppMethodBeat.o(67700);
    }

    private void b(boolean z) {
        AppMethodBeat.i(67701);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.ac, com.tencent.liteav.basic.datareport.a.ar, tXCDRExtInfo);
        this.u = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "u64_timestamp", String.valueOf(this.u));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_network_type", (long) e("u32_network_type"));
        long b = TXCStatus.b(this.x, 7107);
        long b2 = TXCStatus.b(this.x, 7108);
        if (b2 != -1) {
            b2 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_dns_time", z ? b2 : -1);
        String c = TXCStatus.c(this.x, 7110);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_server_ip", z ? c : "");
        long b3 = TXCStatus.b(this.x, 7109);
        if (b3 != -1) {
            b3 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_connect_server_time", z ? b3 : -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_stream_begin", -1);
        this.j = TXCStatus.b(this.x, 6001) - b;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_first_i_frame", this.j);
        long b4 = TXCStatus.b(this.x, 7103) - b;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_first_frame_down", b4);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "dev_uuid", (String) this.b.get("dev_uuid"));
        int d = TXCStatus.d(this.x, 2013);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_max_cache_time", String.valueOf(d));
        int d2 = TXCStatus.d(this.x, 2012);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_min_cache_time", String.valueOf(d2));
        int d3 = TXCStatus.d(this.x, 7105);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "u64_err_code", String.valueOf(d3));
        String c2 = TXCStatus.c(this.x, 7106);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "str_err_info", c2);
        int d4 = TXCStatus.d(this.x, 7112);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_link_type", String.valueOf(d4));
        int d5 = TXCStatus.d(this.x, 7111);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ac, "u32_channel_type", String.valueOf(d5));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.ac);
        TXCLog.d(a, "report evt 40501: token=" + str + " u64_timestamp=" + this.u + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + e("u32_network_type") + " u32_dns_time=" + b2 + " u32_server_ip=" + c + " u32_connect_server_time=" + b3 + " u32_stream_begin=-1 u32_first_i_frame=" + this.j + " u32_first_frame_down=" + b4 + " str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u32_max_cache_time=" + d + " u32_min_cache_time=" + d2 + " u64_err_code=" + d3 + " str_err_info=" + c2 + " u32_link_type=" + d4 + " u32_channel_type=" + d5);
        AppMethodBeat.o(67701);
    }

    private void s() {
        AppMethodBeat.i(67702);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.ae, com.tencent.liteav.basic.datareport.a.ar, tXCDRExtInfo);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_begin_timestamp", String.valueOf(this.u));
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_end_timestamp", utcTimeTick);
        long j = (utcTimeTick - this.u) / 1000;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_playtime", j);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "str_device_type", (String) this.b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_network_type", (long) e("u32_network_type"));
        String c = TXCStatus.c(this.x, 7110);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_server_ip", c);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "str_user_id", (String) this.b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "str_package_name", (String) this.b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "dev_uuid", (String) this.b.get("dev_uuid"));
        long b = TXCStatus.b(this.x, 6003);
        long b2 = TXCStatus.b(this.x, 6005);
        long b3 = TXCStatus.b(this.x, 6006);
        long j2 = 0;
        if (b > 0) {
            j2 = b3 / b;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_block_count", b);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_block_duration_max", b2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_block_duration_avg", j2);
        b3 = TXCStatus.b(this.x, 6009);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_jitter_cache_max", b3);
        long b4 = TXCStatus.b(this.x, 6008);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_jitter_cache_avg", b4);
        long b5 = TXCStatus.b(this.x, TXLiveConstants.PLAY_EVT_PLAY_LOADING);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ae, "u64_audio_cache_avg", b5);
        int d = TXCStatus.d(this.x, 7112);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_link_type", String.valueOf(d));
        long d2 = (long) TXCStatus.d(this.x, 2001);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_avg_load", String.valueOf(d2));
        long d3 = (long) TXCStatus.d(this.x, 2002);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_load_cnt", String.valueOf(d3));
        long d4 = (long) TXCStatus.d(this.x, 2003);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_max_load", String.valueOf(d4));
        int d5 = TXCStatus.d(this.x, 7111);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_channel_type", String.valueOf(d5));
        int d6 = TXCStatus.d(this.x, 7116);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_ip_count_quic", String.valueOf(d6));
        d6 = TXCStatus.d(this.x, 7117);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_connect_count_quic", String.valueOf(d6));
        d6 = TXCStatus.d(this.x, 7118);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ae, "u32_connect_count_tcp", String.valueOf(d6));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.ae);
        String str2 = a;
        TXCLog.d(str2, "report evt 40502: token=" + str + " str_stream_url=" + this.c + " u64_begin_timestamp=" + this.u + " u64_end_timestamp=" + utcTimeTick + " u64_playtime=" + j + " str_device_type=" + ((String) this.b.get("str_device_type")) + " u32_network_type=" + e("u32_network_type") + " u32_server_ip=" + c + " str_user_id=" + ((String) this.b.get("str_user_id")) + " str_package_name=" + ((String) this.b.get("str_package_name")) + " str_app_version=" + this.i + " dev_uuid=" + ((String) this.b.get("dev_uuid")) + " u64_block_count=" + b + " u64_block_duration_max=" + b2 + " u64_block_duration_avg=" + j2 + " u64_jitter_cache_max=" + b3 + " u64_jitter_cache_avg=" + b4 + " u64_audio_cache_avg=" + b5 + " u32_link_type=" + d + " u32_avg_load=" + d2 + " u32_load_cnt=" + d3 + " u32_max_load=" + d4 + " u32_channel_type=" + d5);
        AppMethodBeat.o(67702);
    }

    private void t() {
        int i;
        int i2 = 2;
        AppMethodBeat.i(67703);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.ad, com.tencent.liteav.basic.datareport.a.ar, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_net_speed", (long) (TXCStatus.d(this.x, 7102) + TXCStatus.d(this.x, 7101)));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_fps", (long) ((int) TXCStatus.e(this.x, 6002)));
        long b = TXCStatus.b(this.x, 6004);
        if (this.l == -1 || b < this.l) {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_video_block_count", 0);
        } else {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_video_block_count", b - this.l);
        }
        this.l = b;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_video_cache_count", TXCStatus.b(this.x, TXLiveConstants.PLAY_EVT_PLAY_END));
        int[] a = com.tencent.liteav.basic.util.b.a();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_cpu_usage", (long) a[1]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_app_cpu_usage", (long) a[0]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_app_mem_usage", (long) com.tencent.liteav.basic.util.b.b());
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ad, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ad, "str_device_type", (String) this.b.get("str_device_type"));
        if (TXCStatus.d(this.x, ReaderCallback.SHOW_BAR) == 0) {
            i = 2;
        } else {
            i = 1;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_video_decode_type", (long) i);
        if (TXCStatus.d(this.x, 2015) != 0) {
            i2 = 1;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_audio_decode_type", (long) i2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_video_cache_time", (long) TXCStatus.d(this.x, 6007));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_audio_cache_time", (long) TXCStatus.d(this.x, 2010));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_audio_jitter", (long) TXCStatus.d(this.x, 2011));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_audio_drop", (long) TXCStatus.d(this.x, 2014));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ad, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.u) / 1000));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_link_type", String.valueOf(TXCStatus.d(this.x, 7112)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.ad, "u32_channel_type", String.valueOf(TXCStatus.d(this.x, 7111)));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.ad);
        AppMethodBeat.o(67703);
    }
}
