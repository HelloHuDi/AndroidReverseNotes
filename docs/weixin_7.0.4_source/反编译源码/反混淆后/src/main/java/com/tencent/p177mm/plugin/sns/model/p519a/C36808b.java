package com.tencent.p177mm.plugin.sns.model.p519a;

import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1897b.C1896b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C34943a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13417av;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c.C34949a;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.model.a.b */
public abstract class C36808b extends C34950c {
    private static HashSet<String> qOr = new HashSet();
    protected bau cNr = null;
    private long dnsCostTime = -1;
    private int ezu = 0;
    private int gcI = -1;
    private String host = "";
    protected C34949a qNY;
    protected C45434n qNZ = null;
    protected C46216a qOa = null;
    private String qOb = "";
    private String qOc = "";
    private String qOd = "";
    private int qOe = 0;
    protected int qOf = 0;
    private long qOg = -1;
    protected long qOh = -1;
    protected long qOi = -1;
    protected long qOj = -1;
    protected String qOk = "";
    protected PString qOl = new PString();
    protected int qOm;
    protected long qOn;
    protected long qOo;
    protected long qOp;
    protected int qOq = 0;
    private Map<String, List<String>> qOs;
    int qOt = 0;
    private int retCode = -1;

    /* renamed from: E */
    public abstract boolean mo8600E(InputStream inputStream);

    public abstract boolean cor();

    public abstract int cos();

    public C36808b(C34949a c34949a, C46216a c46216a) {
        super(c34949a, c46216a);
        this.qNY = c34949a;
        this.qOa = c46216a;
        if (c46216a != null) {
            this.cNr = c46216a.qJh;
            qOr.add(c46216a.qJg);
            c46216a.mo74230EK();
        }
    }

    public boolean coq() {
        return true;
    }

    /* renamed from: Yx */
    public String mo8601Yx(String str) {
        return str;
    }

    /* renamed from: b */
    public C1936u mo8602b(C1936u c1936u) {
        return c1936u;
    }

    /* renamed from: a */
    protected static boolean m61164a(int i, long j, PString pString) {
        if (System.currentTimeMillis() - j < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", new Object[]{Long.valueOf(r2 / 1000), Integer.valueOf(i)});
        return true;
    }

    private void cot() {
        String str;
        int i;
        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", this.qOl.value);
        int cos = cos();
        String str2 = "";
        switch (cos) {
            case 1:
                str = "100105";
                break;
            case 2:
                str = "100106";
                break;
            case 3:
                str = "100100";
                break;
            default:
                return;
        }
        C5141c ll = C18624c.abi().mo17131ll(str);
        if (ll.isValid()) {
            i = C5046bo.getInt((String) ll.dru().get("needUploadData"), 1);
            str2 = ll.field_expId;
        } else {
            i = 0;
        }
        if (i != 0) {
            C32831d c32831d = new C32831d();
            c32831d.mo53400l("20ImgSize", this.qOt + ",");
            c32831d.mo53400l("21NetType", (C5023at.isWifi(C4996ah.getContext()) ? 1 : 0) + ",");
            c32831d.mo53400l("22DelayTime", (this.qOg - this.qOh) + ",");
            c32831d.mo53400l("23RetCode", this.retCode + ",");
            c32831d.mo53400l("24DnsCostTime", this.dnsCostTime + ",");
            c32831d.mo53400l("25ConnectCostTime", this.qOh + ",");
            c32831d.mo53400l("26SendCostTime", ",");
            c32831d.mo53400l("27WaitResponseCostTime", this.qOo + ",");
            c32831d.mo53400l("28ReceiveCostTime", this.qOi + ",");
            c32831d.mo53400l("29ClientAddrIP", this.qOc + ",");
            c32831d.mo53400l("30ServerAddrIP", this.qOd + ",");
            c32831d.mo53400l("31dnstype", this.gcI + ",");
            c32831d.mo53400l("32signal", C5023at.getStrength(C4996ah.getContext()) + ",");
            c32831d.mo53400l("33host", this.host + ",");
            c32831d.mo53400l("34MediaType", cos + ",");
            c32831d.mo53400l("35X_Errno", this.qOe + ",");
            c32831d.mo53400l("36MaxPackageSize", this.qOm + ",");
            c32831d.mo53400l("37MaxPackageTimeStamp", this.qOn + ",");
            c32831d.mo53400l("38PackageRecordList", this.qOl.value + ",");
            c32831d.mo53400l("39ExpLayerId", str + ",");
            c32831d.mo53400l("40ExpId", str2 + ",");
            c32831d.mo53400l("41FeedId", ",");
            C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + c32831d.mo53398Fk());
            C7060h.pYm.mo8381e(13480, c32831d);
            if (this.retCode != 200) {
                C7060h.pYm.mo8381e(14071, c32831d);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo55536a(C44222az c44222az, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (c44222az == null || str2 == null || str2.indexOf(url.getHost()) == -1 || c44222az.oyB == 0 || C5046bo.m7549fp((long) c44222az.oyB) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    /* renamed from: cou */
    public final Integer mo38879dv() {
        C1720g.m3537RQ();
        if (!C1720g.m3536RP().isSDCardAvailable() || this.qOa == null) {
            m61166bW(false);
            return Integer.valueOf(2);
        }
        boolean z;
        if (coq()) {
            C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.qOa.qJc + this.qOa.cop());
            C5730e.deleteFile(r0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.qOj = System.currentTimeMillis();
        C4990ab.m7410d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.qOa.cHr + " " + this.qOa.qNT + " type " + this.qOa.qNV);
        C5730e.m8643tf(this.qOa.getPath());
        C44222az c44222az = this.qOa.qNW;
        String str = "";
        if (c44222az == null) {
            str = "";
            c44222az = C44222az.xYU;
        } else if (c44222az.equals(C44222az.xYN)) {
            str = "album_friend";
        } else if (c44222az.equals(C44222az.xYO)) {
            str = "album_self";
        } else if (c44222az.equals(C44222az.xYP)) {
            str = "album_stranger";
        } else if (c44222az.equals(C44222az.xYQ)) {
            str = "profile_friend";
        } else if (c44222az.equals(C44222az.xYR)) {
            str = "profile_stranger";
        } else if (c44222az.equals(C44222az.xYS)) {
            str = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (c44222az.equals(C44222az.xYM)) {
            str = "timeline";
        }
        if (!C5046bo.isNullOrNil(str)) {
            str = "&scene=".concat(String.valueOf(str));
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(C7243d.vxo), C1183p.getString(C13373af.cnl()), Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext())), Integer.valueOf(C5023at.getStrength(C4996ah.getContext())), str});
        this.qOa.url = mo8601Yx(this.qOa.url);
        this.dnsCostTime = C5046bo.anU();
        long j = (long) C26373g.m41964Nu().getInt(this.qOa.qNU ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.qOa.qNU), Boolean.valueOf(this.qOa.qNT), C26373g.m41964Nu().getValue(this.qOa.qNU ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        C1896b c1896b = new C1896b(this.qOa.url, mo55536a(c44222az, this.qOa.url, j, r6));
        this.dnsCostTime = C5046bo.m7566gb(this.dnsCostTime);
        try {
            if (C5046bo.isNullOrNil(c1896b.f1239ip)) {
                str = InetAddress.getByName(c1896b.host).getHostAddress();
            } else {
                str = c1896b.f1239ip;
            }
        } catch (Exception e) {
            str = "-";
        }
        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", format, this.qOa.url, this.qOa.cHr, Integer.valueOf(c1896b.gcI), str, this.qOa.url, Integer.valueOf(this.qOa.qNV), Boolean.valueOf(r1), c44222az.toString());
        this.qOf = 1;
        C1936u a = m61163a(c1896b, format);
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s";
        Object[] objArr = new Object[5];
        objArr[0] = c1896b.f1239ip;
        if (a != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.qOf);
        objArr[3] = Boolean.valueOf(c1896b.gcL);
        objArr[4] = c1896b.gcK;
        C4990ab.m7417i(str2, str3, objArr);
        int i = 2;
        if (a != null) {
            i = m61167c(a);
        }
        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", Long.valueOf(C5046bo.m7566gb(currentTimeMillis)), Long.valueOf(this.qOg), this.qOa.cHr, this.qOa.url, Integer.valueOf(this.qOt));
        return Integer.valueOf(i);
    }

    /* renamed from: a */
    private C1936u m61163a(C1896b c1896b, String str) {
        String message;
        try {
            this.qOd = c1896b.f1239ip;
            this.gcI = c1896b.gcI;
            this.qOh = C5046bo.anU();
            C1936u a = C1897b.m4020a(this.qOa.url, c1896b);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str);
            if (C5046bo.getInt(C26373g.m41964Nu().getValue("SnsDownloadHttpKeep"), 0) > 0) {
                C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
                a.setRequestProperty("Connection", "close");
            }
            a.setConnectTimeout(25000);
            a.setReadTimeout(25000);
            C1936u b = mo8602b(a);
            this.qOs = b.getHeaderFields();
            List list = (List) this.qOs.get("X-ClientIp");
            if (list != null && list.size() > 0) {
                this.qOc = (String) list.get(0);
            }
            list = (List) this.qOs.get("X-ServerIp");
            if (list != null && list.size() > 0) {
                this.qOb = (String) list.get(0);
            }
            list = (List) this.qOs.get("X-ErrNo");
            if (list != null && list.size() > 0) {
                this.qOe = C5046bo.ank((String) list.get(0));
            }
            list = (List) this.qOs.get("X-RtFlag");
            if (list != null && list.size() > 0) {
                this.qOf = C5046bo.ank((String) list.get(0));
            }
            try {
                this.retCode = b.getResponseCode();
                this.host = b.url.getHost();
                if (this.retCode == 200 || this.retCode == 206) {
                    C36808b.m61165ac(b.getHeaderFields());
                    if (C36808b.m61168d(b)) {
                        this.qOh = C5046bo.m7566gb(this.qOh);
                        list = (List) this.qOs.get("Content-Length");
                        if (list != null && list.size() > 0) {
                            this.qOq = C5046bo.ank((String) list.get(0));
                        }
                        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", this.qOa.url, this.qOc, this.qOb, Integer.valueOf(this.qOq), Integer.valueOf(this.qOe));
                        return b;
                    }
                    C7060h.pYm.mo8378a(22, 62, 1, true);
                    C4990ab.m7412e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.qOa.cHr);
                    m61166bW(false);
                    return null;
                }
                C36808b.m61165ac(b.getHeaderFields());
                if (this.qOa.qNU) {
                    if (this.retCode >= 400 && this.retCode < 500) {
                        C7060h.pYm.mo8378a(22, 78, 1, true);
                    } else if (this.retCode >= 500 && this.retCode < 600) {
                        C7060h.pYm.mo8378a(22, 79, 1, true);
                    }
                } else if (this.retCode >= 400 && this.retCode < 500) {
                    C7060h.pYm.mo8378a(22, 56, 1, true);
                } else if (this.retCode >= 500 && this.retCode < 600) {
                    C7060h.pYm.mo8378a(22, 57, 1, true);
                }
                if (this.qOa.qNT) {
                    C7060h.pYm.mo8378a(150, 14, 1, true);
                }
                C4990ab.m7412e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.qOa.cHr + " " + this.qOa.url + " " + this.retCode);
                m61166bW(false);
                return null;
            } catch (SocketTimeoutException e) {
                this.retCode = 1;
                m61166bW(false);
                message = e.getMessage();
                if (this.qOa.qNU) {
                    C7060h.pYm.mo8378a(22, 77, 1, true);
                } else {
                    C7060h.pYm.mo8378a(22, 55, 1, true);
                }
                if (this.qOa.qNT) {
                    C7060h.pYm.mo8378a(150, 14, 1, true);
                }
                C4990ab.m7412e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.qOa.cHr + " " + this.qOa.url + " msg:" + message);
                return null;
            } catch (Exception e2) {
                m61166bW(false);
                message = e2.getMessage();
                if (this.qOa.qNT) {
                    C7060h.pYm.mo8378a(150, 14, 1, true);
                }
                C4990ab.m7412e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.qOa.cHr + " " + this.qOa.url + " msg:" + message);
                return null;
            }
        } catch (Exception e22) {
            C4990ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e22, "connect fail : " + e22.getMessage(), new Object[0]);
            this.retCode = 2;
            m61166bW(false);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6 A:{SYNTHETIC, Splitter:B:35:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6 A:{SYNTHETIC, Splitter:B:35:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private int m61167c(C1936u c1936u) {
        Exception e;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            this.qOp = C5046bo.anU();
            InputStream inputStream3 = c1936u.getInputStream();
            try {
                this.qOi = C5046bo.anU();
                boolean E = mo8600E(inputStream3);
                inputStream3.close();
                C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "reportResult ret : ".concat(String.valueOf(E)));
                if (E) {
                    this.qOi = C5046bo.m7566gb(this.qOi);
                    this.qOg = C5046bo.m7566gb(this.qOj);
                    boolean cor = cor();
                    C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "processData ret : ".concat(String.valueOf(cor)));
                    if (cor) {
                        if (c1936u != null) {
                            c1936u.connection.disconnect();
                        }
                        m61166bW(true);
                        if (this.qOa.qNT) {
                            return 3;
                        }
                        return 1;
                    }
                    this.retCode = 3;
                    m61166bW(false);
                    if (c1936u == null) {
                        return 2;
                    }
                    c1936u.connection.disconnect();
                    return 2;
                }
                m61166bW(false);
                if (c1936u == null) {
                    return 2;
                }
                c1936u.connection.disconnect();
                return 2;
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "snscdndownload fail : " + e.getMessage(), new Object[0]);
                    this.retCode = 4;
                    m61166bW(false);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "", new Object[0]);
                        }
                    }
                    if (c1936u == null) {
                        return 2;
                    }
                    c1936u.connection.disconnect();
                    return 2;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e32) {
                            C4990ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "", new Object[0]);
                        }
                    }
                    if (c1936u != null) {
                        c1936u.connection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream3;
                if (inputStream2 != null) {
                }
                if (c1936u != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            if (inputStream2 != null) {
            }
            if (c1936u != null) {
            }
            throw th;
        }
    }

    /* renamed from: ac */
    private static void m61165ac(Map<String, List<String>> map) {
        if (map != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    List<String> list = (List) map.get(str);
                    if (list != null) {
                        stringBuffer.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        for (String str2 : list) {
                            stringBuffer.append(str2 + "|");
                        }
                        stringBuffer.append(";");
                    }
                }
                C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "header respone %s", stringBuffer.toString());
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: d */
    private static boolean m61168d(C1936u c1936u) {
        try {
            List list = (List) c1936u.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (C5046bo.isNullOrNil(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            if (list.toString().contains("no-cache")) {
                return false;
            }
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            return false;
        }
    }

    /* renamed from: Yy */
    private static long m61162Yy(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return j;
        }
        try {
            String[] split = str.split("\\.");
            return C5046bo.getLong(split[3], 0) + (((16777216 * C5046bo.getLong(split[0], 0)) + (65536 * C5046bo.getLong(split[1], 0))) + (256 * C5046bo.getLong(split[2], 0)));
        } catch (Exception e) {
            return j;
        }
    }

    /* renamed from: bW */
    private void m61166bW(boolean z) {
        if (this.qOa == null || !this.qOa.qNU) {
            if (z) {
                C7060h.pYm.mo8378a(22, 53, this.qOg, true);
            } else {
                C7060h.pYm.mo8378a(22, 52, 1, true);
            }
            C7060h.pYm.mo8378a(22, 51, 1, true);
        } else {
            if (z) {
                C7060h.pYm.mo8378a(22, 75, this.qOg, true);
            } else {
                C7060h.pYm.mo8378a(22, 74, 1, true);
            }
            C7060h.pYm.mo8378a(22, 73, 1, true);
        }
        if (!(this.qOa == null || !this.qOa.qNT || z || C29036i.m46101b(this.qNZ))) {
            C7060h.pYm.mo8378a(150, 66, 1, true);
        }
        this.ezu = this.qOt;
        int i = C5023at.isWifi(C4996ah.getContext()) ? 1 : 0;
        int strength = C5023at.getStrength(C4996ah.getContext());
        String str = "MicroMsg.SnsCdnDownloadBase";
        String str2 = "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]";
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(this.gcI);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(strength);
        objArr[3] = Long.valueOf(this.dnsCostTime);
        objArr[4] = Long.valueOf(this.qOh);
        objArr[5] = Long.valueOf(this.qOi);
        objArr[6] = Long.valueOf(this.qOg);
        objArr[7] = this.qOb;
        objArr[8] = this.qOd;
        objArr[9] = this.qOc;
        objArr[10] = this.qOa == null ? "" : this.qOa.url;
        C4990ab.m7419v(str, str2, objArr);
        int netType = C5023at.getNetType(C4996ah.getContext());
        int i2 = 0;
        if (this.qOa != null) {
            i2 = this.qOa.qNV == 4 ? 1 : 0;
        }
        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", Integer.valueOf(this.retCode), Integer.valueOf(this.ezu), Integer.valueOf(netType), Integer.valueOf(i2), Integer.valueOf(this.qOe));
        C7060h c7060h = C7060h.pYm;
        Object[] objArr2 = new Object[19];
        objArr2[0] = this.qOa == null ? "" : this.qOa.url;
        objArr2[1] = Long.valueOf(C36808b.m61162Yy(this.qOd));
        objArr2[2] = Long.valueOf(z ? this.qOg : 0);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.qOh);
        objArr2[7] = Integer.valueOf(0);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Long.valueOf(this.qOi);
        objArr2[10] = Long.valueOf(C36808b.m61162Yy(this.qOc));
        objArr2[11] = Long.valueOf(C36808b.m61162Yy(this.qOb));
        objArr2[12] = Integer.valueOf(this.gcI);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.retCode);
        objArr2[15] = Integer.valueOf(this.ezu);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i2);
        objArr2[18] = Integer.valueOf(this.qOe);
        c7060h.mo8381e(10736, objArr2);
        boolean isConnected = C5023at.isConnected(C4996ah.getContext());
        C4990ab.m7410d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.qOk);
        if (!(z || C5046bo.isNullOrNil(this.qOk) || !isConnected)) {
            C1897b.reportFailIp(this.qOk);
        }
        cot();
    }

    public final void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.qOa != null) {
            C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", num, this.qOa.url, this.qOa.cHr, Integer.valueOf(this.ezu), Integer.valueOf(qOr.size()));
            qOr.remove(this.qOa.qJg);
            if (this.qOa.qNT && num.intValue() != 2) {
                C13417av.m21559Yj(this.qOa.cHr);
                cov();
            } else if (!this.qOa.qNT && this.qOa.qNV == 4) {
                C13373af.cnC().mo37463fX(this.qOa.cHr, this.qOa.getPath() + C29036i.m46116j(this.cNr));
            }
            this.qNY.mo55533a(num.intValue(), this.cNr, this.qOa.qNV, this.qOa.qNT, this.qOa.qJg, this.ezu, -1, true);
        }
    }

    public final void cov() {
        int i = 0;
        if (!C13373af.cnn()) {
            System.currentTimeMillis();
            if (this.qOa.qFJ.qFQ == 4) {
                C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.qNZ = C34943a.m57363fV(this.qOa.getPath() + C29036i.m46108e(this.cNr), this.qOa.getPath() + C29036i.m46111g(this.cNr));
                C13373af.cnC().mo37451a(this.qOa.cHr, this.qNZ, this.qOa.qFJ.qFQ);
            } else if (this.qOa.qFJ.qFQ == 5) {
                C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.qNZ = C34943a.m57363fV(this.qOa.getPath() + C29036i.m46108e(this.cNr), this.qOa.getPath() + C29036i.m46112h(this.cNr));
                C13373af.cnC().mo37451a(this.qOa.cHr, this.qNZ, this.qOa.qFJ.qFQ);
            } else if (this.qOa.qFJ.list.size() <= 1) {
                C13373af.cnC().mo37451a(this.qOa.cHr, this.qNZ, this.qOa.qFJ.qFQ);
            } else {
                C13373af.cnC().mo37451a(this.qOa.cHr, this.qNZ, 0);
                LinkedList linkedList = new LinkedList();
                while (true) {
                    int i2 = i;
                    if (i2 >= this.qOa.qFJ.list.size() || i2 >= 4) {
                        this.qNZ = C45434n.m83680w(C29036i.m46125p(linkedList, C13373af.cnN()));
                        C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.qOa.qFJ.nQB + " " + this.qNZ);
                        C13373af.cnC().mo37451a(this.qOa.qFJ.nQB, this.qNZ, this.qOa.qFJ.qFQ);
                    } else {
                        bau bau = (bau) this.qOa.qFJ.list.get(i2);
                        C45434n XN = C13373af.cnC().mo37432XN(bau.f17915Id);
                        if (C29036i.m46101b(XN)) {
                            linkedList.add(XN);
                            C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + XN + " " + bau.f17915Id);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
                this.qNZ = C45434n.m83680w(C29036i.m46125p(linkedList, C13373af.cnN()));
                C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.qOa.qFJ.nQB + " " + this.qNZ);
                C13373af.cnC().mo37451a(this.qOa.qFJ.nQB, this.qNZ, this.qOa.qFJ.qFQ);
            }
            String str = null;
            if (this.qOa.qFJ.qFQ == 0) {
                str = "0-" + this.qOa.qFJ.nQB;
            } else if (this.qOa.qFJ.qFQ == 1) {
                str = "1-" + this.qOa.qFJ.nQB;
            } else if (this.qOa.qFJ.qFQ == 4) {
                str = "4-" + this.qOa.qFJ.nQB;
            } else if (this.qOa.qFJ.qFQ == 5) {
                str = "5-" + this.qOa.qFJ.nQB;
            }
            C13373af.cnC().mo37431XM(str);
        }
    }

    public final C4946a cin() {
        return C13373af.cnp();
    }
}
