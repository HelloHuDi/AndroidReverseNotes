package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.i.d;
import com.tencent.mm.i.e;
import com.tencent.mm.i.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class c extends k<String, Integer, Integer> {
    private static HashSet<String> qOr = new HashSet();
    protected bau cNr = null;
    private long dnsCostTime = -1;
    private int gcI = -1;
    private String host = "";
    protected a qNY;
    protected n qNZ = null;
    protected a qOa = null;
    int qOt = 0;
    protected SparseArray<n> qOu = new SparseArray();

    public interface a {
        void a(int i, bau bau, int i2, boolean z, String str, int i3, int i4, boolean z2);
    }

    public abstract boolean cor();

    public abstract int cos();

    public static boolean Yz(String str) {
        if (qOr.contains(i.bd(1, str)) || qOr.contains(i.bd(5, str))) {
            return true;
        }
        return false;
    }

    public c(a aVar, a aVar2) {
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

    public String b(String str, bau bau) {
        return str;
    }

    public boolean Dj(int i) {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(d dVar) {
        String str;
        int i;
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
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll(str);
        if (ll.isValid()) {
            i = bo.getInt((String) ll.dru().get("needUploadData"), 1);
            str2 = ll.field_expId;
        } else {
            i = 0;
        }
        if (i != 0) {
            int i2;
            if (this.qOa.qNV == 8) {
                i = 1;
            } else if (this.qOa.qNV == 6 || this.qOa.qNV == 4) {
                i = 2;
            } else if (this.qOa.qNV == 5) {
                i = 4;
            } else if (this.qOa.qNV == 2 || this.qOa.qNV == 1 || this.qOa.qNV == 3) {
                i = 0;
            } else {
                i = 5;
            }
            com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
            dVar2.l("20ImgSize", dVar.field_fileLength + ",");
            String str3 = "21NetType";
            StringBuilder stringBuilder = new StringBuilder();
            if (at.isWifi(ah.getContext())) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            dVar2.l(str3, stringBuilder.append(i2).append(",").toString());
            dVar2.l("22DelayTime", dVar.field_delayTime + ",");
            dVar2.l("23RetCode", dVar.field_retCode + ",");
            dVar2.l("24DnsCostTime", dVar.field_dnsCostTime + ",");
            dVar2.l("25ConnectCostTime", dVar.field_connectCostTime + ",");
            dVar2.l("26SendCostTime", ",");
            dVar2.l("27WaitResponseCostTime", dVar.field_waitResponseCostTime + ",");
            dVar2.l("28ReceiveCostTime", dVar.field_receiveCostTime + ",");
            dVar2.l("29ClientAddrIP(uint)", dVar.field_clientHostIP + ",");
            dVar2.l("30ServerAddrIP(uint)", dVar.field_serverHostIP + ",");
            dVar2.l("31dnstype", this.gcI + ",");
            dVar2.l("32signal(int)", at.getStrength(ah.getContext()) + ",");
            dVar2.l("33host(string)", this.host + ",");
            dVar2.l("34MediaType", cos + ",");
            dVar2.l("35X_Errno(string)", dVar.field_xErrorNo + ",");
            dVar2.l("36MaxPackageSize", ",");
            dVar2.l("37MaxPackageTimeStamp", ",");
            dVar2.l("38PackageRecordList", ",");
            dVar2.l("39ExpLayerId", str + ",");
            dVar2.l("40ExpId", str2 + ",");
            dVar2.l("41FeedId", ",");
            dVar2.l("42BizType", i + ",");
            dVar2.l("43CSeqCheck(uint)", dVar.field_cSeqCheck + ",");
            dVar2.l("44isPrivate(uint)", (dVar.field_usePrivateProtocol ? 1 : 0) + ",");
            ab.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar2.Fk());
            h.pYm.e(13480, dVar2);
            if (dVar.field_retCode != 200 && dVar.field_retCode != 0) {
                h.pYm.e(14071, dVar2);
            }
        }
    }

    public boolean a(az azVar, String str, long j, String str2) {
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
    public Integer dv() {
        g.RQ();
        if (!g.RP().isSDCardAvailable() || this.qOa == null) {
            return Integer.valueOf(2);
        }
        int i;
        int i2;
        e eVar;
        if (coq()) {
            if (9 == this.qOa.qNV) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= this.qOa.qFU.size()) {
                        break;
                    }
                    bau bau = (bau) this.qOa.qFU.valueAt(i2);
                    com.tencent.mm.vfs.e.deleteFile(an.fZ(af.getAccSnsPath(), bau.Id) + i.n(bau));
                    i = i2 + 1;
                }
            } else {
                ab.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.qOa.qJc + this.qOa.cop());
                com.tencent.mm.vfs.e.deleteFile(r0);
            }
        }
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            com.tencent.mm.plugin.sns.model.b.c cVar;
            b cnA = af.cnA();
            String str = this.qOa.cHr;
            if (bo.isNullOrNil(str)) {
                cVar = null;
            } else {
                cVar = (com.tencent.mm.plugin.sns.model.b.c) cnA.qHN.get(str);
            }
            if (!(cVar == null || cVar.qHS)) {
                cVar.setStartTime(currentTimeMillis);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", e.getMessage());
        }
        i = 0;
        if (this.qOa.qFU != null) {
            i = this.qOa.qFU.size();
        }
        ab.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.qOa.cHr + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.qOa.cFc + " pack.isthumb: " + this.qOa.qNT + " type: " + this.qOa.qNV);
        az azVar = this.qOa.qNW;
        String str2 = "";
        if (azVar == null) {
            str2 = "";
        } else if (azVar.equals(az.xYN)) {
            str2 = "album_friend";
        } else if (azVar.equals(az.xYO)) {
            str2 = "album_self";
        } else if (azVar.equals(az.xYP)) {
            str2 = "album_stranger";
        } else if (azVar.equals(az.xYQ)) {
            str2 = "profile_friend";
        } else if (azVar.equals(az.xYR)) {
            str2 = "profile_stranger";
        } else if (azVar.equals(az.xYS)) {
            str2 = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (azVar.equals(az.xYM)) {
            str2 = "timeline";
        }
        if (!bo.isNullOrNil(str2)) {
            str2 = "&scene=".concat(String.valueOf(str2));
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vxo), p.getString(af.cnl()), Integer.valueOf(at.getNetTypeForStat(ah.getContext())), Integer.valueOf(at.getStrength(ah.getContext())), str2});
        if (9 == this.qOa.qNV) {
            this.qOa.url = b(this.qOa.url, (bau) this.qOa.qFU.get(0));
        } else {
            this.qOa.url = Yx(this.qOa.url);
        }
        this.dnsCostTime = bo.anU();
        long j = (long) com.tencent.mm.m.g.Nu().getInt(this.qOa.qNU ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        ab.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.qOa.qNU), Boolean.valueOf(this.qOa.qNT), com.tencent.mm.m.g.Nu().getValue(this.qOa.qNU ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        boolean a = a(azVar, this.qOa.url, j, r6);
        this.dnsCostTime = bo.gb(this.dnsCostTime);
        if (9 == this.qOa.qNV) {
            e fVar = new f();
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= this.qOa.qFU.size()) {
                    break;
                }
                com.tencent.mm.vfs.e.tf(an.fZ(af.getAccSnsPath(), ((bau) this.qOa.qFU.valueAt(i2)).Id));
                i = i2 + 1;
            }
            eVar = fVar;
        } else {
            com.tencent.mm.vfs.e.tf(this.qOa.getPath());
            eVar = new e();
        }
        if (a(eVar, a, format)) {
            eVar.egl = new com.tencent.mm.i.g.a() {
                public final int a(String str, int i, com.tencent.mm.i.c cVar, final d dVar, boolean z) {
                    AppMethodBeat.i(36746);
                    if (c.this.qOa == null) {
                        ab.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
                        AppMethodBeat.o(36746);
                        return 0;
                    }
                    int i2;
                    int i3;
                    if (dVar != null) {
                        int i4;
                        f fVar;
                        if (dVar.field_retCode != 0) {
                            ab.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", Integer.valueOf(dVar.field_retCode), Integer.valueOf(c.this.qOa.qNV));
                            com.tencent.mm.network.b.reportFailIp(dVar.field_serverIP);
                            if (9 == c.this.qOa.qNV) {
                                BatchSnsReqImageData[] batchSnsReqImageDataArr = dVar.egb;
                                if (batchSnsReqImageDataArr == null || batchSnsReqImageDataArr.length <= 0) {
                                    h.pYm.k(1040, 14, 1);
                                    ab.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
                                    fVar = (f) eVar;
                                    fVar.counter = fVar.egj;
                                    for (BatchSnsReqImageData batchSnsReqImageData : fVar.egb) {
                                        i3 = batchSnsReqImageData.picIndex;
                                        af.cnA().a((bau) c.this.qOa.qFU.get(i3), 1, (com.tencent.mm.plugin.sns.data.e) c.this.qOa.qFK.get(i3), c.this.qOa.qNW);
                                        ab.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i3));
                                    }
                                    i4 = 2;
                                } else {
                                    h.pYm.k(1040, 12, 1);
                                    fVar = (f) eVar;
                                    ab.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", Integer.valueOf(fVar.counter), Integer.valueOf(batchSnsReqImageDataArr.length), Integer.valueOf(fVar.egj));
                                    fVar.counter += batchSnsReqImageDataArr.length;
                                    for (BatchSnsReqImageData batchSnsReqImageData2 : batchSnsReqImageDataArr) {
                                        if (batchSnsReqImageData2.retry) {
                                            i2 = batchSnsReqImageData2.picIndex;
                                            af.cnA().a((bau) c.this.qOa.qFU.get(i2), 1, (com.tencent.mm.plugin.sns.data.e) c.this.qOa.qFK.get(i2), c.this.qOa.qNW);
                                            ab.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i2));
                                        }
                                    }
                                    i4 = 2;
                                }
                            } else {
                                i4 = 2;
                            }
                        } else {
                            boolean Dj;
                            ab.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", Integer.valueOf(c.this.qOa.qNV));
                            c.this.qOt = dVar.field_fileLength;
                            if (9 == c.this.qOa.qNV) {
                                fVar = (f) eVar;
                                fVar.counter++;
                                ab.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", Integer.valueOf(fVar.counter), Integer.valueOf(fVar.egj));
                                Dj = c.this.Dj(dVar.index);
                            } else {
                                Dj = c.this.cor();
                            }
                            i4 = !Dj ? 2 : c.this.qOa.qNT ? 3 : 1;
                        }
                        c.this.b(dVar);
                        af.bCo().post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(36745);
                                if (9 != c.this.qOa.qNV) {
                                    c.qOr.remove(c.this.qOa.qJg);
                                } else if (((f) eVar).Jo()) {
                                    c.qOr.remove(c.this.qOa.qJg);
                                }
                                ab.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", Integer.valueOf(i4), c.this.qOa.url, c.this.qOa.cHr, Integer.valueOf(dVar.field_fileLength), Integer.valueOf(c.qOr.size()));
                                if (!c.this.qOa.qNT || i4 == 2) {
                                    if (!c.this.qOa.qNT && (c.this.qOa.qNV == 4 || c.this.qOa.qNV == 6)) {
                                        af.cnC().fX(c.this.qOa.cHr, c.this.qOa.getPath() + i.j(c.this.cNr));
                                    }
                                } else if (9 == c.this.qOa.qNV) {
                                    av.Yj(((bau) c.this.qOa.qFU.get(dVar.index)).Id);
                                    c.this.Dk(dVar.index);
                                } else {
                                    av.Yj(c.this.qOa.cHr);
                                    c.this.cov();
                                }
                                long gb;
                                if (9 == c.this.qOa.qNV) {
                                    bau bau = (bau) c.this.qOa.qFU.get(dVar.index);
                                    f fVar = (f) eVar;
                                    if (fVar.Jo() && !fVar.egk) {
                                        fVar.egk = true;
                                        gb = bo.gb(currentTimeMillis);
                                        ab.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", Long.valueOf(gb));
                                        h.pYm.k(1040, 3, gb);
                                        h.pYm.k(1040, 4, 1);
                                        h.pYm.k(1040, 9, gb);
                                        h.pYm.k(1040, 10, (long) fVar.egj);
                                    }
                                    c.this.qNY.a(i4, bau, c.this.qOa.qNV, c.this.qOa.qNT, c.this.qOa.qJg, dVar.field_fileLength, dVar.index, fVar.Jo());
                                    AppMethodBeat.o(36745);
                                    return;
                                }
                                if (1 == c.this.qOa.qNV) {
                                    b cnA = af.cnA();
                                    if (cnA.qHO.remove(c.this.qOa.cHr)) {
                                        ab.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", Long.valueOf(bo.gb(currentTimeMillis)));
                                        h.pYm.k(1040, 6, gb);
                                        h.pYm.k(1040, 7, 1);
                                    }
                                }
                                c.this.qNY.a(i4, c.this.cNr, c.this.qOa.qNV, c.this.qOa.qNT, c.this.qOa.qJg, dVar.field_fileLength, -1, true);
                                AppMethodBeat.o(36745);
                            }
                        });
                    } else if (cVar != null) {
                        float f = ((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength);
                        if (c.this.qOa.qNX < f) {
                            c.this.qOa.qNX = f;
                            ab.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", Integer.valueOf(c.this.qOa.qNV), str, Float.valueOf(f), c.this.qOa.url);
                        }
                    }
                    if (i != 0) {
                        ab.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", Integer.valueOf(i), Integer.valueOf(c.this.qOa.qNV));
                        if (9 == c.this.qOa.qNV) {
                            h.pYm.k(1040, 13, 1);
                            c.qOr.remove(c.this.qOa.qJg);
                            c.this.qNY.a(2, null, c.this.qOa.qNV, c.this.qOa.qNT, c.this.qOa.qJg, -1, -1, true);
                            for (BatchSnsReqImageData batchSnsReqImageData22 : ((f) eVar).egb) {
                                i3 = batchSnsReqImageData22.picIndex;
                                af.cnA().a((bau) c.this.qOa.qFU.get(i3), 1, (com.tencent.mm.plugin.sns.data.e) c.this.qOa.qFK.get(i3), c.this.qOa.qNW);
                                ab.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i3));
                            }
                        }
                    }
                    AppMethodBeat.o(36746);
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (com.tencent.mm.al.f.afx().b(eVar, -1)) {
                ab.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
                i = 1;
                return Integer.valueOf(i);
            }
            ab.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
        }
        i = 2;
        return Integer.valueOf(i);
    }

    private boolean a(e eVar, boolean z, String str) {
        try {
            this.host = new URL(this.qOa.url).getHost();
            List arrayList = new ArrayList();
            this.gcI = com.tencent.mm.network.b.a(this.host, false, arrayList);
            List arrayList2 = new ArrayList();
            int a = com.tencent.mm.network.b.a(this.host, true, arrayList2);
            Random random = new Random();
            random.setSeed(bo.anU());
            Collections.shuffle(arrayList, random);
            Collections.shuffle(arrayList2, random);
            while (arrayList.size() > 2) {
                arrayList.remove(0);
            }
            while (arrayList2.size() > 2) {
                arrayList2.remove(0);
            }
            if (9 == this.qOa.qNV) {
                eVar.field_mediaId = this.qOa.cFc + "_" + this.qOa.qNV;
                if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    fVar.cFc = this.qOa.cFc;
                    fVar.gXe = this.qOa.size;
                    fVar.egj = this.qOa.qFU.size();
                    fVar.egb = new BatchSnsReqImageData[fVar.egj];
                    for (int i = 0; i < fVar.egj; i++) {
                        int keyAt = this.qOa.qFU.keyAt(i);
                        bau bau = (bau) this.qOa.qFU.get(keyAt);
                        BatchSnsReqImageData batchSnsReqImageData = new BatchSnsReqImageData();
                        String str2 = bau.wEH;
                        if (bo.isNullOrNil(str2) && bau.jCt == 2) {
                            str2 = bau.Url;
                        }
                        batchSnsReqImageData.url = b(str2, bau);
                        batchSnsReqImageData.picIndex = keyAt;
                        batchSnsReqImageData.totalFileSize = 0;
                        batchSnsReqImageData.decryptKey = bau.wFb;
                        batchSnsReqImageData.imageCachePath = an.fZ(af.getAccSnsPath(), bau.Id) + i.n(bau);
                        batchSnsReqImageData.fileKey = bau.Id + "_" + this.qOa.qNV;
                        fVar.egb[i] = batchSnsReqImageData;
                    }
                }
            } else {
                eVar.field_mediaId = this.qOa.cHr + "_" + this.qOa.qNV;
                eVar.egd = this.qOa.getPath() + this.qOa.cop();
                if (this.qOa.qJh != null) {
                    String str3;
                    if (this.qOa.qNT) {
                        str3 = this.qOa.qJh.wFb;
                    } else {
                        str3 = this.qOa.qJh.wEY;
                    }
                    eVar.snsCipherKey = str3;
                }
            }
            eVar.url = this.qOa.url;
            eVar.host = this.host;
            eVar.referer = str;
            eVar.ege = di(arrayList);
            eVar.egf = di(arrayList2);
            eVar.egg = this.gcI;
            eVar.egh = a;
            eVar.isColdSnsData = z;
            eVar.signalQuality = at.getStrength(ah.getContext());
            eVar.snsScene = this.qOa.qNW.tag;
            if (this.qOa.qNV == 8) {
                eVar.duk = 3;
                eVar.egi = 109;
                eVar.fileType = 20204;
            } else if (this.qOa.qNV == 6 || this.qOa.qNV == 4) {
                eVar.duk = 3;
                eVar.egi = 105;
                eVar.fileType = CdnLogic.kMediaTypeAdVideo;
            } else if (this.qOa.qNV == 5) {
                eVar.duk = 3;
                eVar.egi = 150;
                eVar.fileType = 20250;
            } else if (this.qOa.qNV == 2 || this.qOa.qNV == 1 || this.qOa.qNV == 3 || this.qOa.qNV == 9) {
                eVar.duk = 3;
                eVar.egi = 100;
                eVar.fileType = 20201;
            }
            ab.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", Integer.valueOf(this.qOa.qNV), eVar);
            return true;
        } catch (MalformedURLException e) {
            ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            ab.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(e)));
            return false;
        }
    }

    private static String[] di(List<String> list) {
        String[] strArr = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return strArr;
            }
            strArr[i2] = (String) list.get(i2);
            i = i2 + 1;
        }
    }

    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
    }

    public void cov() {
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
            } else if (this.qOa.qFJ.qFQ == 3) {
                str = i.bc(3, this.qOa.qFJ.nQB);
            }
            af.cnC().XM(str);
        }
    }

    public final void Dk(int i) {
        if (!af.cnn()) {
            String bc;
            com.tencent.mm.plugin.sns.data.e eVar = (com.tencent.mm.plugin.sns.data.e) this.qOa.qFK.get(i);
            bau bau = (bau) this.qOa.qFU.get(i);
            ab.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", Integer.valueOf(i), Integer.valueOf(eVar.qFQ));
            af.cnC().a(bau.Id, (n) this.qOu.get(i), eVar.qFQ);
            if (eVar.qFQ == 0) {
                bc = i.bc(0, eVar.nQB);
            } else {
                bc = null;
            }
            ab.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", bc);
            af.cnC().XM(bc);
        }
    }

    public com.tencent.mm.sdk.g.b.a cin() {
        return af.cnp();
    }
}
