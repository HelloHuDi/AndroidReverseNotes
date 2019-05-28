package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.c;
import com.tencent.mm.vfs.e;
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

public abstract class b extends c {
    private static HashSet<String> qOr = new HashSet();
    protected bau cNr = null;
    private long dnsCostTime = -1;
    private int ezu = 0;
    private int gcI = -1;
    private String host = "";
    protected a qNY;
    protected n qNZ = null;
    protected a qOa = null;
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

    public abstract boolean E(InputStream inputStream);

    public abstract boolean cor();

    public abstract int cos();

    public b(a aVar, a aVar2) {
        super(aVar, aVar2);
        this.qNY = aVar;
        this.qOa = aVar2;
        if (aVar2 != null) {
            this.cNr = aVar2.qJh;
            qOr.add(aVar2.qJg);
            aVar2.EK();
        }
    }

    public boolean coq() {
        return true;
    }

    public String Yx(String str) {
        return str;
    }

    public u b(u uVar) {
        return uVar;
    }

    protected static boolean a(int i, long j, PString pString) {
        if (System.currentTimeMillis() - j < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", new Object[]{Long.valueOf(r2 / 1000), Integer.valueOf(i)});
        return true;
    }

    private void cot() {
        String str;
        int i;
        ab.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", this.qOl.value);
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
        c ll = com.tencent.mm.model.c.c.abi().ll(str);
        if (ll.isValid()) {
            i = bo.getInt((String) ll.dru().get("needUploadData"), 1);
            str2 = ll.field_expId;
        } else {
            i = 0;
        }
        if (i != 0) {
            d dVar = new d();
            dVar.l("20ImgSize", this.qOt + ",");
            dVar.l("21NetType", (at.isWifi(ah.getContext()) ? 1 : 0) + ",");
            dVar.l("22DelayTime", (this.qOg - this.qOh) + ",");
            dVar.l("23RetCode", this.retCode + ",");
            dVar.l("24DnsCostTime", this.dnsCostTime + ",");
            dVar.l("25ConnectCostTime", this.qOh + ",");
            dVar.l("26SendCostTime", ",");
            dVar.l("27WaitResponseCostTime", this.qOo + ",");
            dVar.l("28ReceiveCostTime", this.qOi + ",");
            dVar.l("29ClientAddrIP", this.qOc + ",");
            dVar.l("30ServerAddrIP", this.qOd + ",");
            dVar.l("31dnstype", this.gcI + ",");
            dVar.l("32signal", at.getStrength(ah.getContext()) + ",");
            dVar.l("33host", this.host + ",");
            dVar.l("34MediaType", cos + ",");
            dVar.l("35X_Errno", this.qOe + ",");
            dVar.l("36MaxPackageSize", this.qOm + ",");
            dVar.l("37MaxPackageTimeStamp", this.qOn + ",");
            dVar.l("38PackageRecordList", this.qOl.value + ",");
            dVar.l("39ExpLayerId", str + ",");
            dVar.l("40ExpId", str2 + ",");
            dVar.l("41FeedId", ",");
            ab.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.Fk());
            h.pYm.e(13480, dVar);
            if (this.retCode != 200) {
                h.pYm.e(14071, dVar);
            }
        }
    }

    public final boolean a(az azVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (azVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || azVar.oyB == 0 || bo.fp((long) azVar.oyB) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    /* renamed from: cou */
    public final Integer dv() {
        g.RQ();
        if (!g.RP().isSDCardAvailable() || this.qOa == null) {
            bW(false);
            return Integer.valueOf(2);
        }
        boolean z;
        if (coq()) {
            ab.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.qOa.qJc + this.qOa.cop());
            e.deleteFile(r0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.qOj = System.currentTimeMillis();
        ab.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.qOa.cHr + " " + this.qOa.qNT + " type " + this.qOa.qNV);
        e.tf(this.qOa.getPath());
        az azVar = this.qOa.qNW;
        String str = "";
        if (azVar == null) {
            str = "";
            azVar = az.xYU;
        } else if (azVar.equals(az.xYN)) {
            str = "album_friend";
        } else if (azVar.equals(az.xYO)) {
            str = "album_self";
        } else if (azVar.equals(az.xYP)) {
            str = "album_stranger";
        } else if (azVar.equals(az.xYQ)) {
            str = "profile_friend";
        } else if (azVar.equals(az.xYR)) {
            str = "profile_stranger";
        } else if (azVar.equals(az.xYS)) {
            str = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (azVar.equals(az.xYM)) {
            str = "timeline";
        }
        if (!bo.isNullOrNil(str)) {
            str = "&scene=".concat(String.valueOf(str));
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vxo), p.getString(af.cnl()), Integer.valueOf(at.getNetTypeForStat(ah.getContext())), Integer.valueOf(at.getStrength(ah.getContext())), str});
        this.qOa.url = Yx(this.qOa.url);
        this.dnsCostTime = bo.anU();
        long j = (long) com.tencent.mm.m.g.Nu().getInt(this.qOa.qNU ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        ab.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.qOa.qNU), Boolean.valueOf(this.qOa.qNT), com.tencent.mm.m.g.Nu().getValue(this.qOa.qNU ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(this.qOa.url, a(azVar, this.qOa.url, j, r6));
        this.dnsCostTime = bo.gb(this.dnsCostTime);
        try {
            if (bo.isNullOrNil(bVar.ip)) {
                str = InetAddress.getByName(bVar.host).getHostAddress();
            } else {
                str = bVar.ip;
            }
        } catch (Exception e) {
            str = "-";
        }
        ab.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", format, this.qOa.url, this.qOa.cHr, Integer.valueOf(bVar.gcI), str, this.qOa.url, Integer.valueOf(this.qOa.qNV), Boolean.valueOf(r1), azVar.toString());
        this.qOf = 1;
        u a = a(bVar, format);
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s";
        Object[] objArr = new Object[5];
        objArr[0] = bVar.ip;
        if (a != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.qOf);
        objArr[3] = Boolean.valueOf(bVar.gcL);
        objArr[4] = bVar.gcK;
        ab.i(str2, str3, objArr);
        int i = 2;
        if (a != null) {
            i = c(a);
        }
        ab.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", Long.valueOf(bo.gb(currentTimeMillis)), Long.valueOf(this.qOg), this.qOa.cHr, this.qOa.url, Integer.valueOf(this.qOt));
        return Integer.valueOf(i);
    }

    private u a(com.tencent.mm.network.b.b bVar, String str) {
        String message;
        try {
            this.qOd = bVar.ip;
            this.gcI = bVar.gcI;
            this.qOh = bo.anU();
            u a = com.tencent.mm.network.b.a(this.qOa.url, bVar);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str);
            if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsDownloadHttpKeep"), 0) > 0) {
                ab.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
                a.setRequestProperty("Connection", "close");
            }
            a.setConnectTimeout(25000);
            a.setReadTimeout(25000);
            u b = b(a);
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
                this.qOe = bo.ank((String) list.get(0));
            }
            list = (List) this.qOs.get("X-RtFlag");
            if (list != null && list.size() > 0) {
                this.qOf = bo.ank((String) list.get(0));
            }
            try {
                this.retCode = b.getResponseCode();
                this.host = b.url.getHost();
                if (this.retCode == 200 || this.retCode == 206) {
                    ac(b.getHeaderFields());
                    if (d(b)) {
                        this.qOh = bo.gb(this.qOh);
                        list = (List) this.qOs.get("Content-Length");
                        if (list != null && list.size() > 0) {
                            this.qOq = bo.ank((String) list.get(0));
                        }
                        ab.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", this.qOa.url, this.qOc, this.qOb, Integer.valueOf(this.qOq), Integer.valueOf(this.qOe));
                        return b;
                    }
                    h.pYm.a(22, 62, 1, true);
                    ab.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.qOa.cHr);
                    bW(false);
                    return null;
                }
                ac(b.getHeaderFields());
                if (this.qOa.qNU) {
                    if (this.retCode >= 400 && this.retCode < 500) {
                        h.pYm.a(22, 78, 1, true);
                    } else if (this.retCode >= 500 && this.retCode < 600) {
                        h.pYm.a(22, 79, 1, true);
                    }
                } else if (this.retCode >= 400 && this.retCode < 500) {
                    h.pYm.a(22, 56, 1, true);
                } else if (this.retCode >= 500 && this.retCode < 600) {
                    h.pYm.a(22, 57, 1, true);
                }
                if (this.qOa.qNT) {
                    h.pYm.a(150, 14, 1, true);
                }
                ab.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.qOa.cHr + " " + this.qOa.url + " " + this.retCode);
                bW(false);
                return null;
            } catch (SocketTimeoutException e) {
                this.retCode = 1;
                bW(false);
                message = e.getMessage();
                if (this.qOa.qNU) {
                    h.pYm.a(22, 77, 1, true);
                } else {
                    h.pYm.a(22, 55, 1, true);
                }
                if (this.qOa.qNT) {
                    h.pYm.a(150, 14, 1, true);
                }
                ab.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.qOa.cHr + " " + this.qOa.url + " msg:" + message);
                return null;
            } catch (Exception e2) {
                bW(false);
                message = e2.getMessage();
                if (this.qOa.qNT) {
                    h.pYm.a(150, 14, 1, true);
                }
                ab.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.qOa.cHr + " " + this.qOa.url + " msg:" + message);
                return null;
            }
        } catch (Exception e22) {
            ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e22, "connect fail : " + e22.getMessage(), new Object[0]);
            this.retCode = 2;
            bW(false);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6 A:{SYNTHETIC, Splitter:B:35:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6 A:{SYNTHETIC, Splitter:B:35:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int c(u uVar) {
        Exception e;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            this.qOp = bo.anU();
            InputStream inputStream3 = uVar.getInputStream();
            try {
                this.qOi = bo.anU();
                boolean E = E(inputStream3);
                inputStream3.close();
                ab.i("MicroMsg.SnsCdnDownloadBase", "reportResult ret : ".concat(String.valueOf(E)));
                if (E) {
                    this.qOi = bo.gb(this.qOi);
                    this.qOg = bo.gb(this.qOj);
                    boolean cor = cor();
                    ab.i("MicroMsg.SnsCdnDownloadBase", "processData ret : ".concat(String.valueOf(cor)));
                    if (cor) {
                        if (uVar != null) {
                            uVar.connection.disconnect();
                        }
                        bW(true);
                        if (this.qOa.qNT) {
                            return 3;
                        }
                        return 1;
                    }
                    this.retCode = 3;
                    bW(false);
                    if (uVar == null) {
                        return 2;
                    }
                    uVar.connection.disconnect();
                    return 2;
                }
                bW(false);
                if (uVar == null) {
                    return 2;
                }
                uVar.connection.disconnect();
                return 2;
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream3;
                try {
                    ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "snscdndownload fail : " + e.getMessage(), new Object[0]);
                    this.retCode = 4;
                    bW(false);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "", new Object[0]);
                        }
                    }
                    if (uVar == null) {
                        return 2;
                    }
                    uVar.connection.disconnect();
                    return 2;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e32) {
                            ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "", new Object[0]);
                        }
                    }
                    if (uVar != null) {
                        uVar.connection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream3;
                if (inputStream2 != null) {
                }
                if (uVar != null) {
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
            if (uVar != null) {
            }
            throw th;
        }
    }

    private static void ac(Map<String, List<String>> map) {
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
                ab.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", stringBuffer.toString());
            } catch (Exception e) {
            }
        }
    }

    private static boolean d(u uVar) {
        try {
            List list = (List) uVar.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (bo.isNullOrNil(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            if (list.toString().contains("no-cache")) {
                return false;
            }
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            return false;
        }
    }

    private static long Yy(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return j;
        }
        try {
            String[] split = str.split("\\.");
            return bo.getLong(split[3], 0) + (((16777216 * bo.getLong(split[0], 0)) + (65536 * bo.getLong(split[1], 0))) + (256 * bo.getLong(split[2], 0)));
        } catch (Exception e) {
            return j;
        }
    }

    private void bW(boolean z) {
        if (this.qOa == null || !this.qOa.qNU) {
            if (z) {
                h.pYm.a(22, 53, this.qOg, true);
            } else {
                h.pYm.a(22, 52, 1, true);
            }
            h.pYm.a(22, 51, 1, true);
        } else {
            if (z) {
                h.pYm.a(22, 75, this.qOg, true);
            } else {
                h.pYm.a(22, 74, 1, true);
            }
            h.pYm.a(22, 73, 1, true);
        }
        if (!(this.qOa == null || !this.qOa.qNT || z || i.b(this.qNZ))) {
            h.pYm.a(150, 66, 1, true);
        }
        this.ezu = this.qOt;
        int i = at.isWifi(ah.getContext()) ? 1 : 0;
        int strength = at.getStrength(ah.getContext());
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
        ab.v(str, str2, objArr);
        int netType = at.getNetType(ah.getContext());
        int i2 = 0;
        if (this.qOa != null) {
            i2 = this.qOa.qNV == 4 ? 1 : 0;
        }
        ab.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", Integer.valueOf(this.retCode), Integer.valueOf(this.ezu), Integer.valueOf(netType), Integer.valueOf(i2), Integer.valueOf(this.qOe));
        h hVar = h.pYm;
        Object[] objArr2 = new Object[19];
        objArr2[0] = this.qOa == null ? "" : this.qOa.url;
        objArr2[1] = Long.valueOf(Yy(this.qOd));
        objArr2[2] = Long.valueOf(z ? this.qOg : 0);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.qOh);
        objArr2[7] = Integer.valueOf(0);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Long.valueOf(this.qOi);
        objArr2[10] = Long.valueOf(Yy(this.qOc));
        objArr2[11] = Long.valueOf(Yy(this.qOb));
        objArr2[12] = Integer.valueOf(this.gcI);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.retCode);
        objArr2[15] = Integer.valueOf(this.ezu);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i2);
        objArr2[18] = Integer.valueOf(this.qOe);
        hVar.e(10736, objArr2);
        boolean isConnected = at.isConnected(ah.getContext());
        ab.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.qOk);
        if (!(z || bo.isNullOrNil(this.qOk) || !isConnected)) {
            com.tencent.mm.network.b.reportFailIp(this.qOk);
        }
        cot();
    }

    public final void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.qOa != null) {
            ab.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", num, this.qOa.url, this.qOa.cHr, Integer.valueOf(this.ezu), Integer.valueOf(qOr.size()));
            qOr.remove(this.qOa.qJg);
            if (this.qOa.qNT && num.intValue() != 2) {
                av.Yj(this.qOa.cHr);
                cov();
            } else if (!this.qOa.qNT && this.qOa.qNV == 4) {
                af.cnC().fX(this.qOa.cHr, this.qOa.getPath() + i.j(this.cNr));
            }
            this.qNY.a(num.intValue(), this.cNr, this.qOa.qNV, this.qOa.qNT, this.qOa.qJg, this.ezu, -1, true);
        }
    }

    public final void cov() {
        int i = 0;
        if (!af.cnn()) {
            System.currentTimeMillis();
            if (this.qOa.qFJ.qFQ == 4) {
                ab.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.qNZ = com.tencent.mm.plugin.sns.lucky.a.a.fV(this.qOa.getPath() + i.e(this.cNr), this.qOa.getPath() + i.g(this.cNr));
                af.cnC().a(this.qOa.cHr, this.qNZ, this.qOa.qFJ.qFQ);
            } else if (this.qOa.qFJ.qFQ == 5) {
                ab.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.qNZ = com.tencent.mm.plugin.sns.lucky.a.a.fV(this.qOa.getPath() + i.e(this.cNr), this.qOa.getPath() + i.h(this.cNr));
                af.cnC().a(this.qOa.cHr, this.qNZ, this.qOa.qFJ.qFQ);
            } else if (this.qOa.qFJ.list.size() <= 1) {
                af.cnC().a(this.qOa.cHr, this.qNZ, this.qOa.qFJ.qFQ);
            } else {
                af.cnC().a(this.qOa.cHr, this.qNZ, 0);
                LinkedList linkedList = new LinkedList();
                while (true) {
                    int i2 = i;
                    if (i2 >= this.qOa.qFJ.list.size() || i2 >= 4) {
                        this.qNZ = n.w(i.p(linkedList, af.cnN()));
                        ab.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.qOa.qFJ.nQB + " " + this.qNZ);
                        af.cnC().a(this.qOa.qFJ.nQB, this.qNZ, this.qOa.qFJ.qFQ);
                    } else {
                        bau bau = (bau) this.qOa.qFJ.list.get(i2);
                        n XN = af.cnC().XN(bau.Id);
                        if (i.b(XN)) {
                            linkedList.add(XN);
                            ab.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + XN + " " + bau.Id);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
                this.qNZ = n.w(i.p(linkedList, af.cnN()));
                ab.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.qOa.qFJ.nQB + " " + this.qNZ);
                af.cnC().a(this.qOa.qFJ.nQB, this.qNZ, this.qOa.qFJ.qFQ);
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
            af.cnC().XM(str);
        }
    }

    public final com.tencent.mm.sdk.g.b.a cin() {
        return af.cnp();
    }
}
