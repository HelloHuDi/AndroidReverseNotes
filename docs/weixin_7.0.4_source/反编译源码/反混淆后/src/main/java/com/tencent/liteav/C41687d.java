package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.p812a.C17790b;
import com.tencent.liteav.network.p812a.C45111e;
import com.tencent.liteav.network.p812a.p813a.C8828a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.tencent.liteav.d */
public class C41687d {
    /* renamed from: a */
    private static String f16997a = "TXCDataReport";
    /* renamed from: w */
    private static HashMap<String, C41688a> f16998w = new HashMap();
    /* renamed from: b */
    private HashMap f16999b = new HashMap(100);
    /* renamed from: c */
    private String f17000c;
    /* renamed from: d */
    private int f17001d;
    /* renamed from: e */
    private int f17002e;
    /* renamed from: f */
    private int f17003f;
    /* renamed from: g */
    private int f17004g;
    /* renamed from: h */
    private Context f17005h;
    /* renamed from: i */
    private String f17006i;
    /* renamed from: j */
    private long f17007j;
    /* renamed from: k */
    private int f17008k;
    /* renamed from: l */
    private long f17009l;
    /* renamed from: m */
    private boolean f17010m;
    /* renamed from: n */
    private long f17011n;
    /* renamed from: o */
    private int f17012o;
    /* renamed from: p */
    private boolean f17013p = false;
    /* renamed from: q */
    private long f17014q = 0;
    /* renamed from: r */
    private long f17015r = 0;
    /* renamed from: s */
    private long f17016s = 0;
    /* renamed from: t */
    private long f17017t = 0;
    /* renamed from: u */
    private long f17018u = 0;
    /* renamed from: v */
    private String f17019v;
    /* renamed from: x */
    private String f17020x = "";

    /* renamed from: com.tencent.liteav.d$a */
    enum C41688a {
        PENDING,
        CONFIRM,
        NEGATIVE;

        static {
            AppMethodBeat.m2505o(65999);
        }
    }

    static {
        AppMethodBeat.m2504i(67704);
        AppMethodBeat.m2505o(67704);
    }

    public C41687d(Context context) {
        AppMethodBeat.m2504i(67681);
        this.f17005h = context.getApplicationContext();
        this.f17006i = TXCCommonUtil.getAppVersion();
        this.f17012o = 5000;
        this.f17018u = 0;
        AppMethodBeat.m2505o(67681);
    }

    /* renamed from: a */
    public void mo67290a() {
        AppMethodBeat.m2504i(67682);
        m73250r();
        this.f17009l = -1;
        this.f17014q = System.currentTimeMillis();
        AppMethodBeat.m2505o(67682);
    }

    /* renamed from: b */
    public void mo67295b() {
        AppMethodBeat.m2504i(67683);
        if (this.f17010m) {
            m73248p();
            AppMethodBeat.m2505o(67683);
            return;
        }
        TXCLog.m15676e(f16997a, "push " + this.f17000c + " failed!");
        m73246n();
        AppMethodBeat.m2505o(67683);
    }

    /* renamed from: c */
    public void mo67298c() {
        AppMethodBeat.m2504i(67684);
        if (!this.f17010m) {
            TXCLog.m15676e(f16997a, "play " + this.f17000c + " failed");
            if (this.f17013p) {
                m73236b(false);
            } else {
                m73242j();
            }
        } else if (this.f17013p) {
            m73251s();
        } else {
            m73243k();
        }
        if (this.f17013p) {
            m73245m();
        }
        AppMethodBeat.m2505o(67684);
    }

    /* renamed from: a */
    public void mo67294a(boolean z) {
        this.f17013p = z;
    }

    /* renamed from: a */
    public void mo67293a(String str) {
        AppMethodBeat.m2504i(67685);
        this.f17000c = str;
        mo67297b(str);
        AppMethodBeat.m2505o(67685);
    }

    /* renamed from: b */
    public void mo67297b(String str) {
        if (str != null) {
            this.f17019v = str;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public C41688a mo67299d() {
        AppMethodBeat.m2504i(67686);
        Uri parse = Uri.parse(this.f17019v);
        C41688a c41688a;
        if (parse == null) {
            c41688a = C41688a.PENDING;
            AppMethodBeat.m2505o(67686);
            return c41688a;
        }
        final String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            c41688a = C41688a.PENDING;
            AppMethodBeat.m2505o(67686);
            return c41688a;
        }
        String scheme = parse.getScheme();
        if (scheme == null) {
            c41688a = C41688a.PENDING;
            AppMethodBeat.m2505o(67686);
            return c41688a;
        } else if (scheme.equals("rtmp") || scheme.equals("http") || scheme.equals("https")) {
            try {
                if (C41687d.m73237c(host)) {
                    c41688a = C41688a.CONFIRM;
                    AppMethodBeat.m2505o(67686);
                    return c41688a;
                }
                Set queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && (queryParameterNames.contains("bizid") || queryParameterNames.contains("txTime") || queryParameterNames.contains("txSecret"))) {
                    c41688a = C41688a.CONFIRM;
                    AppMethodBeat.m2505o(67686);
                    return c41688a;
                } else if (f16998w.containsKey(host)) {
                    c41688a = (C41688a) f16998w.get(host);
                    AppMethodBeat.m2505o(67686);
                    return c41688a;
                } else {
                    f16998w.put(host, C41688a.PENDING);
                    new Thread(new Runnable() {
                        public void run() {
                            boolean z = false;
                            AppMethodBeat.m2504i(66802);
                            try {
                                for (C45111e c45111e : C8828a.m15727c().mo19951a(new C17790b(host, true), null)) {
                                    if (c45111e.mo72895a() && C41687d.m73237c(c45111e.f17796a)) {
                                        z = true;
                                        break;
                                    }
                                }
                                C41687d.f16998w.put(host, z ? C41688a.CONFIRM : C41688a.NEGATIVE);
                                TXCLog.m15675d(C41687d.f16997a, host + " isTencent " + z);
                                AppMethodBeat.m2505o(66802);
                            } catch (Exception e) {
                                AppMethodBeat.m2505o(66802);
                            }
                        }
                    }).start();
                    c41688a = C41688a.PENDING;
                    AppMethodBeat.m2505o(67686);
                    return c41688a;
                }
            } catch (Exception e) {
            }
        } else {
            c41688a = C41688a.PENDING;
            AppMethodBeat.m2505o(67686);
            return c41688a;
        }
    }

    /* renamed from: c */
    protected static boolean m73237c(String str) {
        AppMethodBeat.m2504i(67687);
        if (str == null || !str.contains("myqcloud")) {
            boolean a = C45104b.m82752a().mo72877a(str);
            AppMethodBeat.m2505o(67687);
            return a;
        }
        AppMethodBeat.m2505o(67687);
        return true;
    }

    /* renamed from: d */
    public void mo67300d(String str) {
        this.f17020x = str;
    }

    /* renamed from: a */
    public void mo67292a(int i, int i2) {
        this.f17001d = i;
        this.f17002e = i2;
    }

    /* renamed from: a */
    public void mo67291a(int i) {
        this.f17003f = i;
    }

    /* renamed from: b */
    public void mo67296b(int i) {
        this.f17004g = i;
    }

    /* renamed from: e */
    public void mo67301e() {
        AppMethodBeat.m2504i(67688);
        if (!(this.f17010m || TextUtils.isEmpty(TXCStatus.m40655c(this.f17020x, 7012)))) {
            m73247o();
            this.f17010m = true;
        }
        if (this.f17011n <= 0) {
            this.f17011n = TXCTimeUtil.getTimeTick();
        }
        if (this.f17010m && TXCTimeUtil.getTimeTick() - this.f17011n > 5000) {
            m73249q();
            this.f17011n = TXCTimeUtil.getTimeTick();
        }
        AppMethodBeat.m2505o(67688);
    }

    /* renamed from: f */
    public void mo67302f() {
        AppMethodBeat.m2504i(67689);
        if (!this.f17010m) {
            long b = TXCStatus.m40653b(this.f17020x, 6001);
            long b2 = TXCStatus.m40653b(this.f17020x, 7104);
            if (!(b == 0 && b2 == 0)) {
                if (this.f17013p) {
                    m73236b(true);
                } else {
                    m73241i();
                }
                this.f17012o = 5000;
                this.f17010m = true;
            }
            String c = TXCStatus.m40655c(this.f17020x, 7119);
            if (c != null) {
                mo67297b(c);
            }
        }
        if (this.f17011n <= 0) {
            this.f17011n = TXCTimeUtil.getTimeTick();
        }
        if (this.f17010m && TXCTimeUtil.getTimeTick() > this.f17011n + ((long) this.f17012o)) {
            if (this.f17013p) {
                m73252t();
                this.f17012o = 5000;
            } else if (mo67299d() == C41688a.NEGATIVE) {
                AppMethodBeat.m2505o(67689);
                return;
            } else {
                m73244l();
                this.f17012o = TXCDRApi.getStatusReportInterval();
                if (this.f17012o < 5000) {
                    this.f17012o = 5000;
                }
                if (this.f17012o > 300000) {
                    this.f17012o = 300000;
                }
            }
            this.f17009l = TXCStatus.m40653b(this.f17020x, 6004);
            this.f17011n = TXCTimeUtil.getTimeTick();
        }
        AppMethodBeat.m2505o(67689);
    }

    /* renamed from: i */
    private void m73241i() {
        AppMethodBeat.m2504i(67690);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f17000c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2500Z, C8795a.f2545ar, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_device_type", (String) this.f16999b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_network_type", (long) m73238e("u32_network_type"));
        long b = TXCStatus.m40653b(this.f17020x, 7107);
        long b2 = TXCStatus.m40653b(this.f17020x, 7108);
        if (b2 != -1) {
            b2 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_dns_time", b2);
        String c = TXCStatus.m40655c(this.f17020x, 7110);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "u32_server_ip", c);
        long b3 = TXCStatus.m40653b(this.f17020x, 7109);
        if (b3 != -1) {
            b3 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_connect_server_time", b3);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_stream_begin", -1);
        this.f17007j = TXCStatus.m40653b(this.f17020x, 6001) - b;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_first_i_frame", this.f17007j);
        b = TXCStatus.m40653b(this.f17020x, 7103) - b;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_first_frame_down", b);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_user_id", (String) this.f16999b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_package_name", (String) this.f16999b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "dev_uuid", (String) this.f16999b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_isp2p", (long) this.f17008k);
        TXCDRApi.nativeReportEvent(str, C8795a.f2500Z);
        TXCLog.m15675d(f16997a, "report evt 40101: token=" + str + " u64_timestamp=" + utcTimeTick + " str_device_type=" + ((String) this.f16999b.get("str_device_type")) + " u32_network_type=" + m73238e("u32_network_type") + " u32_dns_time=" + b2 + " u32_server_ip=" + c + " u32_connect_server_time=" + b3 + " u32_stream_begin=-1 u32_first_i_frame=" + this.f17007j + " u32_first_frame_down=" + b + " str_user_id=" + ((String) this.f16999b.get("str_user_id")) + " str_package_name=" + ((String) this.f16999b.get("str_package_name")) + " str_app_version=" + this.f17006i + " dev_uuid=" + ((String) this.f16999b.get("dev_uuid")) + " u32_isp2p=" + this.f17008k);
        AppMethodBeat.m2505o(67690);
    }

    /* renamed from: j */
    private void m73242j() {
        AppMethodBeat.m2504i(67691);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f17000c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2500Z, C8795a.f2545ar, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_device_type", (String) this.f16999b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_network_type", (long) m73238e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_dns_time", -1);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_stream_begin", -1);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_first_i_frame", -1);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_first_frame_down", -1);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_user_id", (String) this.f16999b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_package_name", (String) this.f16999b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2500Z, "dev_uuid", (String) this.f16999b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2500Z, "u32_isp2p", (long) this.f17008k);
        TXCDRApi.nativeReportEvent(str, C8795a.f2500Z);
        TXCLog.m15675d(f16997a, "report evt 40101: token=" + str + " u64_timestamp=" + utcTimeTick + " str_device_type=" + ((String) this.f16999b.get("str_device_type")) + " u32_network_type=" + m73238e("u32_network_type") + " u32_dns_time=-1 u32_server_ip= u32_connect_server_time=-1 u32_stream_begin=-1 u32_first_i_frame=-1 u32_first_frame_down=-1 str_user_id=" + ((String) this.f16999b.get("str_user_id")) + " str_package_name=" + ((String) this.f16999b.get("str_package_name")) + " str_app_version=" + this.f17006i + " dev_uuid=" + ((String) this.f16999b.get("dev_uuid")) + " u32_isp2p=" + this.f17008k);
        AppMethodBeat.m2505o(67691);
    }

    /* renamed from: k */
    private void m73243k() {
        AppMethodBeat.m2504i(67692);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f17000c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2529ab, C8795a.f2545ar, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u64_timestamp", utcTimeTick);
        long timeTick = (TXCTimeUtil.getTimeTick() - TXCStatus.m40653b(this.f17020x, 7107)) / 1000;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_result", timeTick);
        long b = TXCStatus.m40653b(this.f17020x, 6003);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_avg_block_time", b);
        TXCDRApi.txSetEventValue(str, C8795a.f2529ab, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_isp2p", (long) this.f17008k);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_avg_load", TXCStatus.m40653b(this.f17020x, 2001));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_load_cnt", TXCStatus.m40653b(this.f17020x, 2002));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_max_load", TXCStatus.m40653b(this.f17020x, 2003));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_first_i_frame", this.f17007j);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_speed_cnt", TXCStatus.m40653b(this.f17020x, 2004));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_nodata_cnt", TXCStatus.m40653b(this.f17020x, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_avg_cache_time", TXCStatus.m40653b(this.f17020x, TXLiveConstants.PLAY_EVT_PLAY_LOADING));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2529ab, "u32_is_real_time", TXCStatus.m40653b(this.f17020x, 2008));
        TXCDRApi.nativeReportEvent(str, C8795a.f2529ab);
        TXCLog.m15675d(f16997a, "report evt 40102: token=" + str + " str_stream_url=" + this.f17000c + " u64_timestamp=" + utcTimeTick + " u32_result=" + timeTick + " u32_avg_block_time=" + b + " str_app_version=" + this.f17006i + " u32_isp2p=" + this.f17008k + " u32_avg_load=" + TXCStatus.m40653b(this.f17020x, 2001) + " u32_load_cnt=" + TXCStatus.m40653b(this.f17020x, 2002) + " u32_max_load=" + TXCStatus.m40653b(this.f17020x, 2003) + " u32_first_i_frame=" + this.f17007j + " u32_speed_cnt=" + TXCStatus.m40653b(this.f17020x, 2004) + " u32_nodata_cnt=" + TXCStatus.m40653b(this.f17020x, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) + " u32_avg_cache_time=" + TXCStatus.m40653b(this.f17020x, TXLiveConstants.PLAY_EVT_PLAY_LOADING) + " u32_is_real_time=" + TXCStatus.m40653b(this.f17020x, 2008));
        AppMethodBeat.m2505o(67692);
    }

    /* renamed from: l */
    private void m73244l() {
        AppMethodBeat.m2504i(67693);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f17000c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2528aa, C8795a.f2545ar, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_avg_net_speed", (long) (TXCStatus.m40656d(this.f17020x, 7102) + TXCStatus.m40656d(this.f17020x, 7101)));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_fps", (long) ((int) TXCStatus.m40657e(this.f17020x, 6002)));
        long b = TXCStatus.m40653b(this.f17020x, 6004);
        if (this.f17009l == -1 || b < this.f17009l) {
            TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_avg_block_count", 0);
        } else {
            TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_avg_block_count", b - this.f17009l);
        }
        this.f17009l = b;
        int[] a = C17778b.m27747a();
        int b2 = C17778b.m27748b();
        long b3 = TXCStatus.m40653b(this.f17020x, TXLiveConstants.PLAY_EVT_PLAY_END);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_avg_cache_count", b3);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_cpu_usage", (long) a[1]);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_app_cpu_usage", (long) a[0]);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_app_mem_usage", (long) b2);
        TXCDRApi.txSetEventValue(str, C8795a.f2528aa, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2528aa, "u32_isp2p", (long) this.f17008k);
        TXCDRApi.nativeReportEvent(str, C8795a.f2528aa);
        if (this.f17013p) {
            this.f17017t++;
            this.f17016s += b3;
            if (b3 > this.f17015r) {
                this.f17015r = b3;
            }
        }
        AppMethodBeat.m2505o(67693);
    }

    /* renamed from: m */
    private void m73245m() {
        AppMethodBeat.m2504i(67694);
        HashMap hashMap = new HashMap();
        String c = TXCStatus.m40655c(this.f17020x, 7113);
        String c2 = TXCStatus.m40655c(this.f17020x, 7114);
        String c3 = TXCStatus.m40655c(this.f17020x, 7115);
        int d = TXCStatus.m40656d(this.f17020x, 7105);
        String c4 = TXCStatus.m40655c(this.f17020x, 7106);
        int d2 = TXCStatus.m40656d(this.f17020x, 7111);
        hashMap.put("stream_url", c);
        hashMap.put("stream_id", c2);
        hashMap.put("bizid", c3);
        hashMap.put("err_code", String.valueOf(d));
        hashMap.put("err_info", c4);
        hashMap.put("channel_type", String.valueOf(d2));
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f17014q;
        hashMap.put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.f17014q)));
        hashMap.put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(currentTimeMillis)));
        hashMap.put("total_time", String.valueOf(j));
        j = TXCStatus.m40653b(this.f17020x, 6003);
        currentTimeMillis = TXCStatus.m40653b(this.f17020x, 6006);
        long b = TXCStatus.m40653b(this.f17020x, 6005);
        if (j != 0) {
            currentTimeMillis /= j;
        } else {
            currentTimeMillis = 0;
        }
        hashMap.put("block_count", String.valueOf(j));
        hashMap.put("block_duration_max", String.valueOf(b));
        hashMap.put("block_duration_avg", String.valueOf(currentTimeMillis));
        if (this.f17017t != 0) {
            currentTimeMillis = this.f17016s / this.f17017t;
        } else {
            currentTimeMillis = 0;
        }
        hashMap.put("jitter_cache_max", String.valueOf(this.f17015r));
        hashMap.put("jitter_cache_avg", String.valueOf(currentTimeMillis));
        c3 = TXCDRApi.txCreateToken();
        d = C8795a.f2538ak;
        int i = C8795a.f2544aq;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.f17005h, c3, d, i, tXCDRExtInfo);
        TXCLog.m15675d(f16997a, "report evt 40402: token=".concat(String.valueOf(c3)));
        for (Entry entry : hashMap.entrySet()) {
            c2 = (String) entry.getKey();
            c = (String) entry.getValue();
            TXCLog.m15676e(f16997a, "RealTimePlayStatisticInfo: " + c2 + " = " + c);
            if (!(c2 == null || c2.length() <= 0 || c == null)) {
                TXCDRApi.txSetEventValue(c3, d, c2, c);
            }
        }
        TXCDRApi.nativeReportEvent(c3, d);
        this.f17013p = false;
        this.f17014q = 0;
        this.f17017t = 0;
        this.f17016s = 0;
        this.f17015r = 0;
        AppMethodBeat.m2505o(67694);
    }

    /* renamed from: n */
    private void m73246n() {
        AppMethodBeat.m2504i(67695);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f17000c;
        long b = TXCStatus.m40653b(this.f17020x, 7013);
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2495U, C8795a.f2544aq, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_device_type", (String) this.f16999b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_network_type", (long) m73238e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_dns_time", -1);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_video_resolution", (long) ((this.f17001d << 16) | this.f17002e));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_audio_samplerate", (long) this.f17004g);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_video_bitrate", (long) this.f17003f);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_user_id", (String) this.f16999b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_package_name", (String) this.f16999b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_channel_type", b);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "dev_uuid", (String) this.f16999b.get("dev_uuid"));
        TXCDRApi.nativeReportEvent(str, C8795a.f2495U);
        TXCLog.m15675d(f16997a, "report evt 40001: token=" + str + " str_stream_url=" + this.f17000c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.f16999b.get("str_device_type") + " u32_network_type=" + m73238e("u32_network_type") + " u32_dns_time=-1 u32_connect_server_time=-1 u32_server_ip= u32_video_resolution=" + ((this.f17001d << 16) | this.f17002e) + " u32_audio_samplerate=" + this.f17004g + " u32_video_bitrate=" + this.f17003f + " str_user_id=" + this.f16999b.get("str_user_id") + " str_package_name=" + this.f16999b.get("str_package_name") + " u32_channel_type=" + b + " str_app_version=" + this.f16999b.get("dev_uuid") + " dev_uuid=" + m73238e("u32_max_load"));
        AppMethodBeat.m2505o(67695);
    }

    /* renamed from: o */
    private void m73247o() {
        long j;
        AppMethodBeat.m2504i(67696);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f17000c;
        String c = TXCStatus.m40655c(this.f17020x, 7012);
        long b = TXCStatus.m40653b(this.f17020x, 7009);
        long b2 = TXCStatus.m40653b(this.f17020x, 7010);
        if (b2 != -1) {
            j = b2 - b;
        } else {
            j = b2;
        }
        b2 = TXCStatus.m40653b(this.f17020x, 7011);
        if (b2 != -1) {
            b = b2 - b;
        } else {
            b = b2;
        }
        long b3 = TXCStatus.m40653b(this.f17020x, 7013);
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2495U, C8795a.f2544aq, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_device_type", (String) this.f16999b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_network_type", (long) m73238e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_dns_time", j);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_connect_server_time", b);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "u32_server_ip", c);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_video_resolution", (long) ((this.f17001d << 16) | this.f17002e));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_audio_samplerate", (long) this.f17004g);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_video_bitrate", (long) this.f17003f);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_user_id", (String) this.f16999b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_package_name", (String) this.f16999b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2495U, "u32_channel_type", b3);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "dev_uuid", (String) this.f16999b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, C8795a.f2495U, "str_nearest_ip_list", TXCStatus.m40655c(this.f17020x, 7019));
        TXCDRApi.nativeReportEvent(str, C8795a.f2495U);
        TXCLog.m15675d(f16997a, "report evt 40001: token=" + str + " str_stream_url=" + this.f17000c + " u64_timestamp=" + utcTimeTick + " str_device_type=" + this.f16999b.get("str_device_type") + " u32_network_type=" + m73238e("u32_network_type") + " u32_dns_time=" + j + " u32_connect_server_time=" + b + " u32_server_ip=" + c + " u32_video_resolution=" + ((this.f17001d << 16) | this.f17002e) + " u32_audio_samplerate=" + this.f17004g + " u32_video_bitrate=" + this.f17003f + " str_user_id=" + this.f16999b.get("str_user_id") + " str_package_name=" + this.f16999b.get("str_package_name") + " u32_channel_type=" + b3 + " str_app_version=" + this.f16999b.get("dev_uuid") + " dev_uuid=" + m73238e("u32_max_load"));
        AppMethodBeat.m2505o(67696);
    }

    /* renamed from: p */
    private void m73248p() {
        AppMethodBeat.m2504i(67697);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f17000c;
        long b = TXCStatus.m40653b(this.f17020x, 7009);
        long b2 = TXCStatus.m40653b(this.f17020x, 7013);
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2497W, C8795a.f2544aq, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2497W, "u64_timestamp", utcTimeTick);
        b = (TXCTimeUtil.getTimeTick() - b) / 1000;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2497W, "u32_result", b);
        TXCDRApi.txSetEventValue(str, C8795a.f2497W, "str_user_id", (String) this.f16999b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, C8795a.f2497W, "str_package_name", (String) this.f16999b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2497W, "u32_channel_type", b2);
        TXCDRApi.txSetEventValue(str, C8795a.f2497W, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2497W, "dev_uuid", (String) this.f16999b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, C8795a.f2497W, "u32_ip_count_quic", String.valueOf(TXCStatus.m40656d(this.f17020x, 7016)));
        TXCDRApi.txSetEventValue(str, C8795a.f2497W, "u32_connect_count_quic", String.valueOf(TXCStatus.m40656d(this.f17020x, 7017)));
        TXCDRApi.txSetEventValue(str, C8795a.f2497W, "u32_connect_count_tcp", String.valueOf(TXCStatus.m40656d(this.f17020x, 7018)));
        TXCDRApi.nativeReportEvent(str, C8795a.f2497W);
        TXCLog.m15675d(f16997a, "report evt 40002: token=" + str + " str_stream_url=" + this.f17000c + " u64_timestamp=" + utcTimeTick + " u32_result=" + b + " str_user_id=" + this.f16999b.get("str_user_id") + " str_package_name=" + this.f16999b.get("str_package_name") + " u32_channel_type=" + b2 + " str_app_version=" + this.f17006i + " dev_uuid=" + this.f16999b.get("dev_uuid"));
        AppMethodBeat.m2505o(67697);
    }

    /* renamed from: q */
    private void m73249q() {
        AppMethodBeat.m2504i(67698);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        tXCDRExtInfo.url = this.f17000c;
        int[] a = C17778b.m27747a();
        int i = a[0];
        int i2 = a[1];
        int b = C17778b.m27748b();
        long b2 = TXCStatus.m40653b(this.f17020x, 7013);
        int d = TXCStatus.m40656d(this.f17020x, 7004);
        int d2 = TXCStatus.m40656d(this.f17020x, 7003);
        double e = TXCStatus.m40657e(this.f17020x, WearableStatusCodes.DUPLICATE_LISTENER);
        int d3 = TXCStatus.m40656d(this.f17020x, 7005);
        int d4 = TXCStatus.m40656d(this.f17020x, 7002);
        int d5 = TXCStatus.m40656d(this.f17020x, 7001);
        int d6 = TXCStatus.m40656d(this.f17020x, WearableStatusCodes.INVALID_TARGET_NODE);
        String c = TXCStatus.m40655c(this.f17020x, 7012);
        String c2 = TXCStatus.m40655c(this.f17020x, 7014);
        String c3 = TXCStatus.m40655c(this.f17020x, 7015);
        String c4 = TXCStatus.m40655c(this.f17020x, 3001);
        long b3 = TXCStatus.m40653b(this.f17020x, 3002);
        double e2 = TXCStatus.m40657e(this.f17020x, 3003);
        int d7 = TXCStatus.m40656d(this.f17020x, 7020);
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2496V, C8795a.f2544aq, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_avg_audio_bitrate", (long) d4);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_avg_video_bitrate", (long) d5);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_avg_net_speed", (long) (d + d2));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_fps", (long) ((int) e));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_avg_cache_size", (long) d3);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_cpu_usage", (long) i2);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_app_cpu_usage", (long) i);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_app_mem_usage", (long) b);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_channel_type", b2);
        TXCDRApi.txSetEventValue(str, C8795a.f2496V, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2496V, "str_device_type", (String) this.f16999b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_hw_enc", (long) d6);
        try {
            if (this.f17005h != null && C17778b.m27752c(this.f17005h) == 1) {
                WifiManager wifiManager = (WifiManager) this.f17005h.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        TXCDRApi.txSetEventValue(str, C8795a.f2496V, "str_wifi_ssid", connectionInfo.getSSID());
                        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "str_wifi_signal_strength", (long) WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 32));
                        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "str_wifi_link_speed", (long) connectionInfo.getLinkSpeed());
                    }
                }
            }
        } catch (Exception e3) {
        }
        TXCDRApi.txSetEventValue(str, C8795a.f2496V, "str_server_ip", c);
        TXCDRApi.txSetEventValue(str, C8795a.f2496V, "str_quic_connection_id", c2);
        TXCDRApi.txSetEventValue(str, C8795a.f2496V, "str_quic_connection_stats", c3);
        TXCDRApi.txSetEventValue(str, C8795a.f2496V, "str_beauty_stats", c4);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_send_strategy", (long) d7);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_preprocess_timecost", b3);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2496V, "u32_preprocess_fps_out", (long) ((int) e2));
        TXCDRApi.nativeReportEvent(str, C8795a.f2496V);
        AppMethodBeat.m2505o(67698);
    }

    /* renamed from: e */
    private int m73238e(String str) {
        AppMethodBeat.m2504i(67699);
        Number number = (Number) this.f16999b.get(str);
        if (number != null) {
            int intValue = number.intValue();
            AppMethodBeat.m2505o(67699);
            return intValue;
        }
        AppMethodBeat.m2505o(67699);
        return 0;
    }

    /* renamed from: r */
    private void m73250r() {
        AppMethodBeat.m2504i(67700);
        this.f17010m = false;
        this.f17011n = 0;
        this.f16999b.put("str_user_id", C17778b.m27739a(this.f17005h));
        this.f16999b.put("str_device_type", C17778b.m27753c());
        this.f16999b.put("str_device_type", C17778b.m27753c());
        this.f16999b.put("u32_network_type", Integer.valueOf(C17778b.m27752c(this.f17005h)));
        this.f16999b.put("token", C17778b.m27754d());
        this.f16999b.put("str_package_name", C17778b.m27749b(this.f17005h));
        this.f16999b.put("dev_uuid", C17778b.m27755d(this.f17005h));
        AppMethodBeat.m2505o(67700);
    }

    /* renamed from: b */
    private void m73236b(boolean z) {
        AppMethodBeat.m2504i(67701);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f17000c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2530ac, C8795a.f2545ar, tXCDRExtInfo);
        this.f17018u = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "u64_timestamp", String.valueOf(this.f17018u));
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "str_device_type", (String) this.f16999b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2530ac, "u32_network_type", (long) m73238e("u32_network_type"));
        long b = TXCStatus.m40653b(this.f17020x, 7107);
        long b2 = TXCStatus.m40653b(this.f17020x, 7108);
        if (b2 != -1) {
            b2 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, C8795a.f2530ac, "u32_dns_time", z ? b2 : -1);
        String c = TXCStatus.m40655c(this.f17020x, 7110);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "u32_server_ip", z ? c : "");
        long b3 = TXCStatus.m40653b(this.f17020x, 7109);
        if (b3 != -1) {
            b3 -= b;
        }
        TXCDRApi.txSetEventIntValue(str, C8795a.f2530ac, "u32_connect_server_time", z ? b3 : -1);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2530ac, "u32_stream_begin", -1);
        this.f17007j = TXCStatus.m40653b(this.f17020x, 6001) - b;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2530ac, "u32_first_i_frame", this.f17007j);
        long b4 = TXCStatus.m40653b(this.f17020x, 7103) - b;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2530ac, "u32_first_frame_down", b4);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "str_user_id", (String) this.f16999b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "str_package_name", (String) this.f16999b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "dev_uuid", (String) this.f16999b.get("dev_uuid"));
        int d = TXCStatus.m40656d(this.f17020x, 2013);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "u32_max_cache_time", String.valueOf(d));
        int d2 = TXCStatus.m40656d(this.f17020x, 2012);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "u32_min_cache_time", String.valueOf(d2));
        int d3 = TXCStatus.m40656d(this.f17020x, 7105);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "u64_err_code", String.valueOf(d3));
        String c2 = TXCStatus.m40655c(this.f17020x, 7106);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "str_err_info", c2);
        int d4 = TXCStatus.m40656d(this.f17020x, 7112);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "u32_link_type", String.valueOf(d4));
        int d5 = TXCStatus.m40656d(this.f17020x, 7111);
        TXCDRApi.txSetEventValue(str, C8795a.f2530ac, "u32_channel_type", String.valueOf(d5));
        TXCDRApi.nativeReportEvent(str, C8795a.f2530ac);
        TXCLog.m15675d(f16997a, "report evt 40501: token=" + str + " u64_timestamp=" + this.f17018u + " str_device_type=" + ((String) this.f16999b.get("str_device_type")) + " u32_network_type=" + m73238e("u32_network_type") + " u32_dns_time=" + b2 + " u32_server_ip=" + c + " u32_connect_server_time=" + b3 + " u32_stream_begin=-1 u32_first_i_frame=" + this.f17007j + " u32_first_frame_down=" + b4 + " str_user_id=" + ((String) this.f16999b.get("str_user_id")) + " str_package_name=" + ((String) this.f16999b.get("str_package_name")) + " str_app_version=" + this.f17006i + " dev_uuid=" + ((String) this.f16999b.get("dev_uuid")) + " u32_max_cache_time=" + d + " u32_min_cache_time=" + d2 + " u64_err_code=" + d3 + " str_err_info=" + c2 + " u32_link_type=" + d4 + " u32_channel_type=" + d5);
        AppMethodBeat.m2505o(67701);
    }

    /* renamed from: s */
    private void m73251s() {
        AppMethodBeat.m2504i(67702);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f17000c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2532ae, C8795a.f2545ar, tXCDRExtInfo);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u64_begin_timestamp", String.valueOf(this.f17018u));
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_end_timestamp", utcTimeTick);
        long j = (utcTimeTick - this.f17018u) / 1000;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_playtime", j);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "str_device_type", (String) this.f16999b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u32_network_type", (long) m73238e("u32_network_type"));
        String c = TXCStatus.m40655c(this.f17020x, 7110);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_server_ip", c);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "str_user_id", (String) this.f16999b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "str_package_name", (String) this.f16999b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "dev_uuid", (String) this.f16999b.get("dev_uuid"));
        long b = TXCStatus.m40653b(this.f17020x, 6003);
        long b2 = TXCStatus.m40653b(this.f17020x, 6005);
        long b3 = TXCStatus.m40653b(this.f17020x, 6006);
        long j2 = 0;
        if (b > 0) {
            j2 = b3 / b;
        }
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_block_count", b);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_block_duration_max", b2);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_block_duration_avg", j2);
        b3 = TXCStatus.m40653b(this.f17020x, 6009);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_jitter_cache_max", b3);
        long b4 = TXCStatus.m40653b(this.f17020x, 6008);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_jitter_cache_avg", b4);
        long b5 = TXCStatus.m40653b(this.f17020x, TXLiveConstants.PLAY_EVT_PLAY_LOADING);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2532ae, "u64_audio_cache_avg", b5);
        int d = TXCStatus.m40656d(this.f17020x, 7112);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_link_type", String.valueOf(d));
        long d2 = (long) TXCStatus.m40656d(this.f17020x, 2001);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_avg_load", String.valueOf(d2));
        long d3 = (long) TXCStatus.m40656d(this.f17020x, 2002);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_load_cnt", String.valueOf(d3));
        long d4 = (long) TXCStatus.m40656d(this.f17020x, 2003);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_max_load", String.valueOf(d4));
        int d5 = TXCStatus.m40656d(this.f17020x, 7111);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_channel_type", String.valueOf(d5));
        int d6 = TXCStatus.m40656d(this.f17020x, 7116);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_ip_count_quic", String.valueOf(d6));
        d6 = TXCStatus.m40656d(this.f17020x, 7117);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_connect_count_quic", String.valueOf(d6));
        d6 = TXCStatus.m40656d(this.f17020x, 7118);
        TXCDRApi.txSetEventValue(str, C8795a.f2532ae, "u32_connect_count_tcp", String.valueOf(d6));
        TXCDRApi.nativeReportEvent(str, C8795a.f2532ae);
        String str2 = f16997a;
        TXCLog.m15675d(str2, "report evt 40502: token=" + str + " str_stream_url=" + this.f17000c + " u64_begin_timestamp=" + this.f17018u + " u64_end_timestamp=" + utcTimeTick + " u64_playtime=" + j + " str_device_type=" + ((String) this.f16999b.get("str_device_type")) + " u32_network_type=" + m73238e("u32_network_type") + " u32_server_ip=" + c + " str_user_id=" + ((String) this.f16999b.get("str_user_id")) + " str_package_name=" + ((String) this.f16999b.get("str_package_name")) + " str_app_version=" + this.f17006i + " dev_uuid=" + ((String) this.f16999b.get("dev_uuid")) + " u64_block_count=" + b + " u64_block_duration_max=" + b2 + " u64_block_duration_avg=" + j2 + " u64_jitter_cache_max=" + b3 + " u64_jitter_cache_avg=" + b4 + " u64_audio_cache_avg=" + b5 + " u32_link_type=" + d + " u32_avg_load=" + d2 + " u32_load_cnt=" + d3 + " u32_max_load=" + d4 + " u32_channel_type=" + d5);
        AppMethodBeat.m2505o(67702);
    }

    /* renamed from: t */
    private void m73252t() {
        int i;
        int i2 = 2;
        AppMethodBeat.m2504i(67703);
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f17000c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.f16999b.get("token");
        TXCDRApi.InitEvent(this.f17005h, str, C8795a.f2531ad, C8795a.f2545ar, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_net_speed", (long) (TXCStatus.m40656d(this.f17020x, 7102) + TXCStatus.m40656d(this.f17020x, 7101)));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_fps", (long) ((int) TXCStatus.m40657e(this.f17020x, 6002)));
        long b = TXCStatus.m40653b(this.f17020x, 6004);
        if (this.f17009l == -1 || b < this.f17009l) {
            TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_video_block_count", 0);
        } else {
            TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_video_block_count", b - this.f17009l);
        }
        this.f17009l = b;
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_video_cache_count", TXCStatus.m40653b(this.f17020x, TXLiveConstants.PLAY_EVT_PLAY_END));
        int[] a = C17778b.m27747a();
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_cpu_usage", (long) a[1]);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_app_cpu_usage", (long) a[0]);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_app_mem_usage", (long) C17778b.m27748b());
        TXCDRApi.txSetEventValue(str, C8795a.f2531ad, "str_app_version", this.f17006i);
        TXCDRApi.txSetEventValue(str, C8795a.f2531ad, "str_device_type", (String) this.f16999b.get("str_device_type"));
        if (TXCStatus.m40656d(this.f17020x, ReaderCallback.SHOW_BAR) == 0) {
            i = 2;
        } else {
            i = 1;
        }
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_video_decode_type", (long) i);
        if (TXCStatus.m40656d(this.f17020x, 2015) != 0) {
            i2 = 1;
        }
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_audio_decode_type", (long) i2);
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_network_type", (long) m73238e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_video_cache_time", (long) TXCStatus.m40656d(this.f17020x, 6007));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_audio_cache_time", (long) TXCStatus.m40656d(this.f17020x, 2010));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_audio_jitter", (long) TXCStatus.m40656d(this.f17020x, 2011));
        TXCDRApi.txSetEventIntValue(str, C8795a.f2531ad, "u32_audio_drop", (long) TXCStatus.m40656d(this.f17020x, 2014));
        TXCDRApi.txSetEventValue(str, C8795a.f2531ad, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.f17018u) / 1000));
        TXCDRApi.txSetEventValue(str, C8795a.f2531ad, "u32_link_type", String.valueOf(TXCStatus.m40656d(this.f17020x, 7112)));
        TXCDRApi.txSetEventValue(str, C8795a.f2531ad, "u32_channel_type", String.valueOf(TXCStatus.m40656d(this.f17020x, 7111)));
        TXCDRApi.nativeReportEvent(str, C8795a.f2531ad);
        AppMethodBeat.m2505o(67703);
    }
}
