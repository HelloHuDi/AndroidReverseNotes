package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p947e.C42942d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.p177mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.p177mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.emoji.f.g */
public final class C42945g extends C1207m implements C1918k {
    private C1202f eIc;
    boolean eVT;
    private final C7472b ehh;
    public String fFa;
    private int gOW;
    public String kWA;
    public String kWB;
    String kWC;
    private int kWD;
    private C1628a kWE;
    EmojiGroupInfo kWF;
    public String kWz;

    /* renamed from: com.tencent.mm.plugin.emoji.f.g$1 */
    class C388801 implements C1628a {
        C388801() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(53107);
            if (C5046bo.isNullOrNil(C42945g.this.fFa) || !str.equals(C42945g.this.fFa)) {
                C4990ab.m7410d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
                AppMethodBeat.m2505o(53107);
            } else if (i == -21006) {
                C4990ab.m7411d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", C42945g.this.fFa);
                C42945g.m76268g(C42945g.this.kWz, 6, 0, C42945g.this.fFa);
                AppMethodBeat.m2505o(53107);
            } else if (i != 0) {
                C4990ab.m7413e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", C42945g.this.kWz);
                C42945g.m76268g(C42945g.this.kWz, -1, 0, C42945g.this.fFa);
                AppMethodBeat.m2505o(53107);
            } else if (c18496c == null) {
                if (c9545d != null) {
                    C7060h.pYm.mo8381e(10625, Integer.valueOf(2), c9545d.field_fileId, C42945g.this.kWz, c9545d.field_transInfo);
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", C42945g.this.kWz, Integer.valueOf(c9545d.field_retCode));
                        C42945g.m76268g(C42945g.this.kWz, -1, 0, C42945g.this.fFa);
                    } else {
                        C4990ab.m7410d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                        try {
                            C42942d bjH = C42942d.bjH();
                            String str2 = C42945g.this.kWz;
                            if (bjH.kTF != null && bjH.kTF.contains(str2)) {
                                bjH.kTF.remove(str2);
                            }
                            EmojiLogic.m44078a(C42945g.this.kWz, C42945g.this.kWA, C42945g.this.kWC, C42945g.this.kWF);
                            C42952j.getEmojiStorageMgr().xYn.doNotify();
                            C42945g.m76268g(C42945g.this.kWz, 7, 100, C42945g.this.fFa);
                            File file = new File(C6457e.euQ + C42945g.this.kWz);
                            if (file.isFile() && file.exists()) {
                                file.delete();
                            }
                            C42945g.m76267av(C42945g.this.kWz, true);
                            AppMethodBeat.m2505o(53107);
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + C5046bo.dpG());
                            C42945g.m76268g(C42945g.this.kWz, -1, 0, C42945g.this.fFa);
                            C42945g.m76267av(C42945g.this.kWz, false);
                            AppMethodBeat.m2505o(53107);
                            return 0;
                        } catch (OutOfMemoryError e2) {
                            C4990ab.m7412e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + C5046bo.dpG());
                            C42945g.m76268g(C42945g.this.kWz, -1, 0, C42945g.this.fFa);
                            C42945g.m76267av(C42945g.this.kWz, false);
                            AppMethodBeat.m2505o(53107);
                            return 0;
                        }
                    }
                }
                AppMethodBeat.m2505o(53107);
            } else if (c18496c.field_finishedLength == c18496c.field_toltalLength) {
                C4990ab.m7410d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
                AppMethodBeat.m2505o(53107);
            } else {
                C4990ab.m7411d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", C42945g.this.fFa, Integer.valueOf(c18496c.field_finishedLength), Integer.valueOf(c18496c.field_toltalLength));
                if (!C42945g.this.eVT) {
                    C42945g.m76268g(C42945g.this.kWz, 6, (int) ((((float) c18496c.field_finishedLength) / ((float) c18496c.field_toltalLength)) * 100.0f), C42945g.this.fFa);
                }
                AppMethodBeat.m2505o(53107);
            }
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return null;
        }
    }

    private C42945g(String str, String str2, String str3, String str4, int i, int i2) {
        AppMethodBeat.m2504i(53108);
        this.fFa = "";
        this.kWE = new C388801();
        this.kWz = str;
        this.kWA = str3;
        this.kWB = str2;
        this.kWC = str4;
        this.kWF = null;
        this.kWD = i;
        this.gOW = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ExchangeEmotionPackRequest();
        c1196a.fsK = new ExchangeEmotionPackResponse();
        c1196a.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        c1196a.fsI = v2helper.EMethodSetNgStrength;
        c1196a.fsL = 213;
        c1196a.fsM = 1000000213;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(53108);
    }

    public C42945g(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public C42945g(String str, String str2) {
        this(str, null, str2, null, 0, 0);
    }

    public C42945g(String str) {
        this(str, null, "", null, 1, 0);
    }

    public C42945g(String str, byte b) {
        this(str, null, "", null, 1, 1);
    }

    public C42945g(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, 0, 0);
    }

    public final int getType() {
        return v2helper.EMethodSetNgStrength;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53109);
        C4990ab.m7411d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (this.gOW == 0) {
                File file = new File(C6457e.euQ);
                if (!file.exists()) {
                    file.mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                this.fFa = C37458c.m63162a("downzip", currentTimeMillis, stringBuilder.append(C1668a.m3383QF()).toString(), "emoji");
                EmotionCDNUrl emotionCDNUrl = ((ExchangeEmotionPackResponse) this.ehh.fsH.fsP).DownloadInfo;
                C42130g c42130g = new C42130g();
                c42130g.field_mediaId = this.fFa;
                c42130g.field_fullpath = C6457e.euQ + this.kWz;
                c42130g.field_fileType = C42129a.MediaType_FILE;
                c42130g.field_totalLen = emotionCDNUrl.FileSize;
                c42130g.field_aesKey = emotionCDNUrl.AesKey;
                c42130g.field_fileId = emotionCDNUrl.Url;
                c42130g.field_priority = C42129a.efC;
                c42130g.egl = this.kWE;
                c42130g.field_needStorage = true;
                this.eVT = false;
                if (!C37461f.afx().mo51222b(c42130g, -1)) {
                    C4990ab.m7412e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                C4990ab.m7416i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            C1720g.m3535RO().eJo.mo14541a(new C38881k(this.kWz), 0);
            AppMethodBeat.m2505o(53109);
            return;
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        C42945g.m76268g(this.kWz, -1, 0, this.fFa);
        AppMethodBeat.m2505o(53109);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53110);
        C4990ab.m7410d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.eIc = c1202f;
        if (this.gOW == 0) {
            C42945g.m76268g(this.kWz, 6, 0, this.fFa);
        }
        ExchangeEmotionPackRequest exchangeEmotionPackRequest = (ExchangeEmotionPackRequest) this.ehh.fsG.fsP;
        exchangeEmotionPackRequest.ProductID = this.kWz;
        exchangeEmotionPackRequest.SeriesID = this.kWB;
        exchangeEmotionPackRequest.IsAutomatic = this.kWD;
        exchangeEmotionPackRequest.Scene = this.gOW;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53110);
        return a;
    }

    /* renamed from: g */
    static void m76268g(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(53111);
        C42952j.bkn().mo35678g(str, i, i2, str2);
        AppMethodBeat.m2505o(53111);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(53112);
        super.cancel();
        this.eVT = true;
        AppMethodBeat.m2505o(53112);
    }

    /* renamed from: av */
    static /* synthetic */ void m76267av(String str, boolean z) {
        AppMethodBeat.m2504i(53113);
        if (!C5046bo.isNullOrNil(str)) {
            C4990ab.m7417i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", str, Boolean.valueOf(z));
            C26107cx c26107cx = new C26107cx();
            c26107cx.cvY.cvZ = str;
            c26107cx.cvY.cuy = 2;
            c26107cx.cvY.success = z;
            C4879a.xxA.mo10055m(c26107cx);
        }
        AppMethodBeat.m2505o(53113);
    }
}
