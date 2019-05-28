package com.tencent.p177mm.plugin.sns.model.p519a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C18497f;
import com.tencent.p177mm.p235i.C26325e;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C34943a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13417av;
import com.tencent.p177mm.plugin.sns.model.C3892an;
import com.tencent.p177mm.plugin.sns.model.C43558b;
import com.tencent.p177mm.plugin.sns.model.C43558b.C39758c;
import com.tencent.p177mm.pluginsdk.model.C23251k;
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
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.sns.model.a.c */
public abstract class C34950c extends C23251k<String, Integer, Integer> {
    private static HashSet<String> qOr = new HashSet();
    protected bau cNr = null;
    private long dnsCostTime = -1;
    private int gcI = -1;
    private String host = "";
    protected C34949a qNY;
    protected C45434n qNZ = null;
    protected C46216a qOa = null;
    int qOt = 0;
    protected SparseArray<C45434n> qOu = new SparseArray();

    /* renamed from: com.tencent.mm.plugin.sns.model.a.c$a */
    public interface C34949a {
        /* renamed from: a */
        void mo55533a(int i, bau bau, int i2, boolean z, String str, int i3, int i4, boolean z2);
    }

    public abstract boolean cor();

    public abstract int cos();

    /* renamed from: Yz */
    public static boolean m57375Yz(String str) {
        if (qOr.contains(C29036i.m46103bd(1, str)) || qOr.contains(C29036i.m46103bd(5, str))) {
            return true;
        }
        return false;
    }

    public C34950c(C34949a c34949a, C46216a c46216a) {
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
    public String mo25482b(String str, bau bau) {
        return str;
    }

    /* renamed from: Dj */
    public boolean mo55534Dj(int i) {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo55537b(C9545d c9545d) {
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
        C5141c ll = C18624c.abi().mo17131ll(str);
        if (ll.isValid()) {
            i = C5046bo.getInt((String) ll.dru().get("needUploadData"), 1);
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
            C32831d c32831d = new C32831d();
            c32831d.mo53400l("20ImgSize", c9545d.field_fileLength + ",");
            String str3 = "21NetType";
            StringBuilder stringBuilder = new StringBuilder();
            if (C5023at.isWifi(C4996ah.getContext())) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c32831d.mo53400l(str3, stringBuilder.append(i2).append(",").toString());
            c32831d.mo53400l("22DelayTime", c9545d.field_delayTime + ",");
            c32831d.mo53400l("23RetCode", c9545d.field_retCode + ",");
            c32831d.mo53400l("24DnsCostTime", c9545d.field_dnsCostTime + ",");
            c32831d.mo53400l("25ConnectCostTime", c9545d.field_connectCostTime + ",");
            c32831d.mo53400l("26SendCostTime", ",");
            c32831d.mo53400l("27WaitResponseCostTime", c9545d.field_waitResponseCostTime + ",");
            c32831d.mo53400l("28ReceiveCostTime", c9545d.field_receiveCostTime + ",");
            c32831d.mo53400l("29ClientAddrIP(uint)", c9545d.field_clientHostIP + ",");
            c32831d.mo53400l("30ServerAddrIP(uint)", c9545d.field_serverHostIP + ",");
            c32831d.mo53400l("31dnstype", this.gcI + ",");
            c32831d.mo53400l("32signal(int)", C5023at.getStrength(C4996ah.getContext()) + ",");
            c32831d.mo53400l("33host(string)", this.host + ",");
            c32831d.mo53400l("34MediaType", cos + ",");
            c32831d.mo53400l("35X_Errno(string)", c9545d.field_xErrorNo + ",");
            c32831d.mo53400l("36MaxPackageSize", ",");
            c32831d.mo53400l("37MaxPackageTimeStamp", ",");
            c32831d.mo53400l("38PackageRecordList", ",");
            c32831d.mo53400l("39ExpLayerId", str + ",");
            c32831d.mo53400l("40ExpId", str2 + ",");
            c32831d.mo53400l("41FeedId", ",");
            c32831d.mo53400l("42BizType", i + ",");
            c32831d.mo53400l("43CSeqCheck(uint)", c9545d.field_cSeqCheck + ",");
            c32831d.mo53400l("44isPrivate(uint)", (c9545d.field_usePrivateProtocol ? 1 : 0) + ",");
            C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + c32831d.mo53398Fk());
            C7060h.pYm.mo8381e(13480, c32831d);
            if (c9545d.field_retCode != 200 && c9545d.field_retCode != 0) {
                C7060h.pYm.mo8381e(14071, c32831d);
            }
        }
    }

    /* renamed from: a */
    public boolean mo55536a(C44222az c44222az, String str, long j, String str2) {
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
    public Integer mo38879dv() {
        C1720g.m3537RQ();
        if (!C1720g.m3536RP().isSDCardAvailable() || this.qOa == null) {
            return Integer.valueOf(2);
        }
        int i;
        int i2;
        C26325e c26325e;
        if (coq()) {
            if (9 == this.qOa.qNV) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= this.qOa.qFU.size()) {
                        break;
                    }
                    bau bau = (bau) this.qOa.qFU.valueAt(i2);
                    C5730e.deleteFile(C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46123n(bau));
                    i = i2 + 1;
                }
            } else {
                C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.qOa.qJc + this.qOa.cop());
                C5730e.deleteFile(r0);
            }
        }
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            C39758c c39758c;
            C43558b cnA = C13373af.cnA();
            String str = this.qOa.cHr;
            if (C5046bo.isNullOrNil(str)) {
                c39758c = null;
            } else {
                c39758c = (C39758c) cnA.qHN.get(str);
            }
            if (!(c39758c == null || c39758c.qHS)) {
                c39758c.setStartTime(currentTimeMillis);
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", e.getMessage());
        }
        i = 0;
        if (this.qOa.qFU != null) {
            i = this.qOa.qFU.size();
        }
        C4990ab.m7410d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.qOa.cHr + " pack.mediaObjs.size: " + i + " pack.snsId: " + this.qOa.cFc + " pack.isthumb: " + this.qOa.qNT + " type: " + this.qOa.qNV);
        C44222az c44222az = this.qOa.qNW;
        String str2 = "";
        if (c44222az == null) {
            str2 = "";
        } else if (c44222az.equals(C44222az.xYN)) {
            str2 = "album_friend";
        } else if (c44222az.equals(C44222az.xYO)) {
            str2 = "album_self";
        } else if (c44222az.equals(C44222az.xYP)) {
            str2 = "album_stranger";
        } else if (c44222az.equals(C44222az.xYQ)) {
            str2 = "profile_friend";
        } else if (c44222az.equals(C44222az.xYR)) {
            str2 = "profile_stranger";
        } else if (c44222az.equals(C44222az.xYS)) {
            str2 = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (c44222az.equals(C44222az.xYM)) {
            str2 = "timeline";
        }
        if (!C5046bo.isNullOrNil(str2)) {
            str2 = "&scene=".concat(String.valueOf(str2));
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(C7243d.vxo), C1183p.getString(C13373af.cnl()), Integer.valueOf(C5023at.getNetTypeForStat(C4996ah.getContext())), Integer.valueOf(C5023at.getStrength(C4996ah.getContext())), str2});
        if (9 == this.qOa.qNV) {
            this.qOa.url = mo25482b(this.qOa.url, (bau) this.qOa.qFU.get(0));
        } else {
            this.qOa.url = mo8601Yx(this.qOa.url);
        }
        this.dnsCostTime = C5046bo.anU();
        long j = (long) C26373g.m41964Nu().getInt(this.qOa.qNU ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.qOa.qNU), Boolean.valueOf(this.qOa.qNT), C26373g.m41964Nu().getValue(this.qOa.qNU ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        boolean a = mo55536a(c44222az, this.qOa.url, j, r6);
        this.dnsCostTime = C5046bo.m7566gb(this.dnsCostTime);
        if (9 == this.qOa.qNV) {
            C26325e c18497f = new C18497f();
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= this.qOa.qFU.size()) {
                    break;
                }
                C5730e.m8643tf(C3892an.m6198fZ(C13373af.getAccSnsPath(), ((bau) this.qOa.qFU.valueAt(i2)).f17915Id));
                i = i2 + 1;
            }
            c26325e = c18497f;
        } else {
            C5730e.m8643tf(this.qOa.getPath());
            c26325e = new C26325e();
        }
        if (m57376a(c26325e, a, format)) {
            c26325e.egl = new C1628a() {
                /* renamed from: a */
                public final int mo5082a(String str, int i, C18496c c18496c, final C9545d c9545d, boolean z) {
                    AppMethodBeat.m2504i(36746);
                    if (C34950c.this.qOa == null) {
                        C4990ab.m7412e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
                        AppMethodBeat.m2505o(36746);
                        return 0;
                    }
                    int i2;
                    int i3;
                    if (c9545d != null) {
                        int i4;
                        C18497f c18497f;
                        if (c9545d.field_retCode != 0) {
                            C4990ab.m7413e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", Integer.valueOf(c9545d.field_retCode), Integer.valueOf(C34950c.this.qOa.qNV));
                            C1897b.reportFailIp(c9545d.field_serverIP);
                            if (9 == C34950c.this.qOa.qNV) {
                                BatchSnsReqImageData[] batchSnsReqImageDataArr = c9545d.egb;
                                if (batchSnsReqImageDataArr == null || batchSnsReqImageDataArr.length <= 0) {
                                    C7060h.pYm.mo15419k(1040, 14, 1);
                                    C4990ab.m7412e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
                                    c18497f = (C18497f) c26325e;
                                    c18497f.counter = c18497f.egj;
                                    for (BatchSnsReqImageData batchSnsReqImageData : c18497f.egb) {
                                        i3 = batchSnsReqImageData.picIndex;
                                        C13373af.cnA().mo69138a((bau) C34950c.this.qOa.qFU.get(i3), 1, (C39731e) C34950c.this.qOa.qFK.get(i3), C34950c.this.qOa.qNW);
                                        C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i3));
                                    }
                                    i4 = 2;
                                } else {
                                    C7060h.pYm.mo15419k(1040, 12, 1);
                                    c18497f = (C18497f) c26325e;
                                    C4990ab.m7413e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", Integer.valueOf(c18497f.counter), Integer.valueOf(batchSnsReqImageDataArr.length), Integer.valueOf(c18497f.egj));
                                    c18497f.counter += batchSnsReqImageDataArr.length;
                                    for (BatchSnsReqImageData batchSnsReqImageData2 : batchSnsReqImageDataArr) {
                                        if (batchSnsReqImageData2.retry) {
                                            i2 = batchSnsReqImageData2.picIndex;
                                            C13373af.cnA().mo69138a((bau) C34950c.this.qOa.qFU.get(i2), 1, (C39731e) C34950c.this.qOa.qFK.get(i2), C34950c.this.qOa.qNW);
                                            C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i2));
                                        }
                                    }
                                    i4 = 2;
                                }
                            } else {
                                i4 = 2;
                            }
                        } else {
                            boolean Dj;
                            C4990ab.m7411d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", Integer.valueOf(C34950c.this.qOa.qNV));
                            C34950c.this.qOt = c9545d.field_fileLength;
                            if (9 == C34950c.this.qOa.qNV) {
                                c18497f = (C18497f) c26325e;
                                c18497f.counter++;
                                C4990ab.m7411d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", Integer.valueOf(c18497f.counter), Integer.valueOf(c18497f.egj));
                                Dj = C34950c.this.mo55534Dj(c9545d.index);
                            } else {
                                Dj = C34950c.this.cor();
                            }
                            i4 = !Dj ? 2 : C34950c.this.qOa.qNT ? 3 : 1;
                        }
                        C34950c.this.mo55537b(c9545d);
                        C13373af.bCo().post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(36745);
                                if (9 != C34950c.this.qOa.qNV) {
                                    C34950c.qOr.remove(C34950c.this.qOa.qJg);
                                } else if (((C18497f) c26325e).mo33736Jo()) {
                                    C34950c.qOr.remove(C34950c.this.qOa.qJg);
                                }
                                C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", Integer.valueOf(i4), C34950c.this.qOa.url, C34950c.this.qOa.cHr, Integer.valueOf(c9545d.field_fileLength), Integer.valueOf(C34950c.qOr.size()));
                                if (!C34950c.this.qOa.qNT || i4 == 2) {
                                    if (!C34950c.this.qOa.qNT && (C34950c.this.qOa.qNV == 4 || C34950c.this.qOa.qNV == 6)) {
                                        C13373af.cnC().mo37463fX(C34950c.this.qOa.cHr, C34950c.this.qOa.getPath() + C29036i.m46116j(C34950c.this.cNr));
                                    }
                                } else if (9 == C34950c.this.qOa.qNV) {
                                    C13417av.m21559Yj(((bau) C34950c.this.qOa.qFU.get(c9545d.index)).f17915Id);
                                    C34950c.this.mo55535Dk(c9545d.index);
                                } else {
                                    C13417av.m21559Yj(C34950c.this.qOa.cHr);
                                    C34950c.this.cov();
                                }
                                long gb;
                                if (9 == C34950c.this.qOa.qNV) {
                                    bau bau = (bau) C34950c.this.qOa.qFU.get(c9545d.index);
                                    C18497f c18497f = (C18497f) c26325e;
                                    if (c18497f.mo33736Jo() && !c18497f.egk) {
                                        c18497f.egk = true;
                                        gb = C5046bo.m7566gb(currentTimeMillis);
                                        C4990ab.m7411d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", Long.valueOf(gb));
                                        C7060h.pYm.mo15419k(1040, 3, gb);
                                        C7060h.pYm.mo15419k(1040, 4, 1);
                                        C7060h.pYm.mo15419k(1040, 9, gb);
                                        C7060h.pYm.mo15419k(1040, 10, (long) c18497f.egj);
                                    }
                                    C34950c.this.qNY.mo55533a(i4, bau, C34950c.this.qOa.qNV, C34950c.this.qOa.qNT, C34950c.this.qOa.qJg, c9545d.field_fileLength, c9545d.index, c18497f.mo33736Jo());
                                    AppMethodBeat.m2505o(36745);
                                    return;
                                }
                                if (1 == C34950c.this.qOa.qNV) {
                                    C43558b cnA = C13373af.cnA();
                                    if (cnA.qHO.remove(C34950c.this.qOa.cHr)) {
                                        C4990ab.m7411d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", Long.valueOf(C5046bo.m7566gb(currentTimeMillis)));
                                        C7060h.pYm.mo15419k(1040, 6, gb);
                                        C7060h.pYm.mo15419k(1040, 7, 1);
                                    }
                                }
                                C34950c.this.qNY.mo55533a(i4, C34950c.this.cNr, C34950c.this.qOa.qNV, C34950c.this.qOa.qNT, C34950c.this.qOa.qJg, c9545d.field_fileLength, -1, true);
                                AppMethodBeat.m2505o(36745);
                            }
                        });
                    } else if (c18496c != null) {
                        float f = ((float) c18496c.field_finishedLength) / ((float) c18496c.field_toltalLength);
                        if (C34950c.this.qOa.qNX < f) {
                            C34950c.this.qOa.qNX = f;
                            C4990ab.m7411d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", Integer.valueOf(C34950c.this.qOa.qNV), str, Float.valueOf(f), C34950c.this.qOa.url);
                        }
                    }
                    if (i != 0) {
                        C4990ab.m7413e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", Integer.valueOf(i), Integer.valueOf(C34950c.this.qOa.qNV));
                        if (9 == C34950c.this.qOa.qNV) {
                            C7060h.pYm.mo15419k(1040, 13, 1);
                            C34950c.qOr.remove(C34950c.this.qOa.qJg);
                            C34950c.this.qNY.mo55533a(2, null, C34950c.this.qOa.qNV, C34950c.this.qOa.qNT, C34950c.this.qOa.qJg, -1, -1, true);
                            for (BatchSnsReqImageData batchSnsReqImageData22 : ((C18497f) c26325e).egb) {
                                i3 = batchSnsReqImageData22.picIndex;
                                C13373af.cnA().mo69138a((bau) C34950c.this.qOa.qFU.get(i3), 1, (C39731e) C34950c.this.qOa.qFK.get(i3), C34950c.this.qOa.qNW);
                                C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i3));
                            }
                        }
                    }
                    AppMethodBeat.m2505o(36746);
                    return 0;
                }

                /* renamed from: a */
                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                /* renamed from: l */
                public final byte[] mo5084l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (C37461f.afx().mo51222b(c26325e, -1)) {
                C4990ab.m7416i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
                i = 1;
                return Integer.valueOf(i);
            }
            C4990ab.m7420w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
        }
        i = 2;
        return Integer.valueOf(i);
    }

    /* renamed from: a */
    private boolean m57376a(C26325e c26325e, boolean z, String str) {
        try {
            this.host = new URL(this.qOa.url).getHost();
            List arrayList = new ArrayList();
            this.gcI = C1897b.m4018a(this.host, false, arrayList);
            List arrayList2 = new ArrayList();
            int a = C1897b.m4018a(this.host, true, arrayList2);
            Random random = new Random();
            random.setSeed(C5046bo.anU());
            Collections.shuffle(arrayList, random);
            Collections.shuffle(arrayList2, random);
            while (arrayList.size() > 2) {
                arrayList.remove(0);
            }
            while (arrayList2.size() > 2) {
                arrayList2.remove(0);
            }
            if (9 == this.qOa.qNV) {
                c26325e.field_mediaId = this.qOa.cFc + "_" + this.qOa.qNV;
                if (c26325e instanceof C18497f) {
                    C18497f c18497f = (C18497f) c26325e;
                    c18497f.cFc = this.qOa.cFc;
                    c18497f.gXe = this.qOa.size;
                    c18497f.egj = this.qOa.qFU.size();
                    c18497f.egb = new BatchSnsReqImageData[c18497f.egj];
                    for (int i = 0; i < c18497f.egj; i++) {
                        int keyAt = this.qOa.qFU.keyAt(i);
                        bau bau = (bau) this.qOa.qFU.get(keyAt);
                        BatchSnsReqImageData batchSnsReqImageData = new BatchSnsReqImageData();
                        String str2 = bau.wEH;
                        if (C5046bo.isNullOrNil(str2) && bau.jCt == 2) {
                            str2 = bau.Url;
                        }
                        batchSnsReqImageData.url = mo25482b(str2, bau);
                        batchSnsReqImageData.picIndex = keyAt;
                        batchSnsReqImageData.totalFileSize = 0;
                        batchSnsReqImageData.decryptKey = bau.wFb;
                        batchSnsReqImageData.imageCachePath = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46123n(bau);
                        batchSnsReqImageData.fileKey = bau.f17915Id + "_" + this.qOa.qNV;
                        c18497f.egb[i] = batchSnsReqImageData;
                    }
                }
            } else {
                c26325e.field_mediaId = this.qOa.cHr + "_" + this.qOa.qNV;
                c26325e.egd = this.qOa.getPath() + this.qOa.cop();
                if (this.qOa.qJh != null) {
                    String str3;
                    if (this.qOa.qNT) {
                        str3 = this.qOa.qJh.wFb;
                    } else {
                        str3 = this.qOa.qJh.wEY;
                    }
                    c26325e.snsCipherKey = str3;
                }
            }
            c26325e.url = this.qOa.url;
            c26325e.host = this.host;
            c26325e.referer = str;
            c26325e.ege = C34950c.m57377di(arrayList);
            c26325e.egf = C34950c.m57377di(arrayList2);
            c26325e.egg = this.gcI;
            c26325e.egh = a;
            c26325e.isColdSnsData = z;
            c26325e.signalQuality = C5023at.getStrength(C4996ah.getContext());
            c26325e.snsScene = this.qOa.qNW.tag;
            if (this.qOa.qNV == 8) {
                c26325e.duk = 3;
                c26325e.egi = 109;
                c26325e.fileType = 20204;
            } else if (this.qOa.qNV == 6 || this.qOa.qNV == 4) {
                c26325e.duk = 3;
                c26325e.egi = 105;
                c26325e.fileType = CdnLogic.kMediaTypeAdVideo;
            } else if (this.qOa.qNV == 5) {
                c26325e.duk = 3;
                c26325e.egi = 150;
                c26325e.fileType = 20250;
            } else if (this.qOa.qNV == 2 || this.qOa.qNV == 1 || this.qOa.qNV == 3 || this.qOa.qNV == 9) {
                c26325e.duk = 3;
                c26325e.egi = 100;
                c26325e.fileType = 20201;
            }
            C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", Integer.valueOf(this.qOa.qNV), c26325e);
            return true;
        } catch (MalformedURLException e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(e)));
            return false;
        }
    }

    /* renamed from: di */
    private static String[] m57377di(List<String> list) {
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
            } else if (this.qOa.qFJ.qFQ == 3) {
                str = C29036i.m46102bc(3, this.qOa.qFJ.nQB);
            }
            C13373af.cnC().mo37431XM(str);
        }
    }

    /* renamed from: Dk */
    public final void mo55535Dk(int i) {
        if (!C13373af.cnn()) {
            String bc;
            C39731e c39731e = (C39731e) this.qOa.qFK.get(i);
            bau bau = (bau) this.qOa.qFU.get(i);
            C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", Integer.valueOf(i), Integer.valueOf(c39731e.qFQ));
            C13373af.cnC().mo37451a(bau.f17915Id, (C45434n) this.qOu.get(i), c39731e.qFQ);
            if (c39731e.qFQ == 0) {
                bc = C29036i.m46102bc(0, c39731e.nQB);
            } else {
                bc = null;
            }
            C4990ab.m7417i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", bc);
            C13373af.cnC().mo37431XM(bc);
        }
    }

    public C4946a cin() {
        return C13373af.cnp();
    }
}
