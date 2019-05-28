package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.wxmm.v2helper;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class g extends m implements k {
    private f eIc;
    boolean eVT;
    private final b ehh;
    public String fFa;
    private int gOW;
    public String kWA;
    public String kWB;
    String kWC;
    private int kWD;
    private a kWE;
    EmojiGroupInfo kWF;
    public String kWz;

    private g(String str, String str2, String str3, String str4, int i, int i2) {
        AppMethodBeat.i(53108);
        this.fFa = "";
        this.kWE = new a() {
            public final int a(String str, int i, c cVar, d dVar, boolean z) {
                AppMethodBeat.i(53107);
                if (bo.isNullOrNil(g.this.fFa) || !str.equals(g.this.fFa)) {
                    ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
                    AppMethodBeat.o(53107);
                } else if (i == -21006) {
                    ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", g.this.fFa);
                    g.g(g.this.kWz, 6, 0, g.this.fFa);
                    AppMethodBeat.o(53107);
                } else if (i != 0) {
                    ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", g.this.kWz);
                    g.g(g.this.kWz, -1, 0, g.this.fFa);
                    AppMethodBeat.o(53107);
                } else if (cVar == null) {
                    if (dVar != null) {
                        h.pYm.e(10625, Integer.valueOf(2), dVar.field_fileId, g.this.kWz, dVar.field_transInfo);
                        if (dVar.field_retCode != 0) {
                            ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", g.this.kWz, Integer.valueOf(dVar.field_retCode));
                            g.g(g.this.kWz, -1, 0, g.this.fFa);
                        } else {
                            ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                            try {
                                com.tencent.mm.plugin.emoji.e.d bjH = com.tencent.mm.plugin.emoji.e.d.bjH();
                                String str2 = g.this.kWz;
                                if (bjH.kTF != null && bjH.kTF.contains(str2)) {
                                    bjH.kTF.remove(str2);
                                }
                                EmojiLogic.a(g.this.kWz, g.this.kWA, g.this.kWC, g.this.kWF);
                                j.getEmojiStorageMgr().xYn.doNotify();
                                g.g(g.this.kWz, 7, 100, g.this.fFa);
                                File file = new File(e.euQ + g.this.kWz);
                                if (file.isFile() && file.exists()) {
                                    file.delete();
                                }
                                g.av(g.this.kWz, true);
                                AppMethodBeat.o(53107);
                            } catch (Exception e) {
                                ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bo.dpG());
                                g.g(g.this.kWz, -1, 0, g.this.fFa);
                                g.av(g.this.kWz, false);
                                AppMethodBeat.o(53107);
                                return 0;
                            } catch (OutOfMemoryError e2) {
                                ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bo.dpG());
                                g.g(g.this.kWz, -1, 0, g.this.fFa);
                                g.av(g.this.kWz, false);
                                AppMethodBeat.o(53107);
                                return 0;
                            }
                        }
                    }
                    AppMethodBeat.o(53107);
                } else if (cVar.field_finishedLength == cVar.field_toltalLength) {
                    ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
                    AppMethodBeat.o(53107);
                } else {
                    ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", g.this.fFa, Integer.valueOf(cVar.field_finishedLength), Integer.valueOf(cVar.field_toltalLength));
                    if (!g.this.eVT) {
                        g.g(g.this.kWz, 6, (int) ((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f), g.this.fFa);
                    }
                    AppMethodBeat.o(53107);
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return null;
            }
        };
        this.kWz = str;
        this.kWA = str3;
        this.kWB = str2;
        this.kWC = str4;
        this.kWF = null;
        this.kWD = i;
        this.gOW = i2;
        b.a aVar = new b.a();
        aVar.fsJ = new ExchangeEmotionPackRequest();
        aVar.fsK = new ExchangeEmotionPackResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        aVar.fsI = v2helper.EMethodSetNgStrength;
        aVar.fsL = 213;
        aVar.fsM = 1000000213;
        this.ehh = aVar.acD();
        AppMethodBeat.o(53108);
    }

    public g(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public g(String str, String str2) {
        this(str, null, str2, null, 0, 0);
    }

    public g(String str) {
        this(str, null, "", null, 1, 0);
    }

    public g(String str, byte b) {
        this(str, null, "", null, 1, 1);
    }

    public g(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, 0, 0);
    }

    public final int getType() {
        return v2helper.EMethodSetNgStrength;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53109);
        ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (this.gOW == 0) {
                File file = new File(e.euQ);
                if (!file.exists()) {
                    file.mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.RN();
                this.fFa = com.tencent.mm.al.c.a("downzip", currentTimeMillis, stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString(), "emoji");
                EmotionCDNUrl emotionCDNUrl = ((ExchangeEmotionPackResponse) this.ehh.fsH.fsP).DownloadInfo;
                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                gVar.field_mediaId = this.fFa;
                gVar.field_fullpath = e.euQ + this.kWz;
                gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
                gVar.field_totalLen = emotionCDNUrl.FileSize;
                gVar.field_aesKey = emotionCDNUrl.AesKey;
                gVar.field_fileId = emotionCDNUrl.Url;
                gVar.field_priority = com.tencent.mm.i.a.efC;
                gVar.egl = this.kWE;
                gVar.field_needStorage = true;
                this.eVT = false;
                if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
                    ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                ab.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            com.tencent.mm.kernel.g.RO().eJo.a(new k(this.kWz), 0);
            AppMethodBeat.o(53109);
            return;
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        g(this.kWz, -1, 0, this.fFa);
        AppMethodBeat.o(53109);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(53110);
        ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.eIc = fVar;
        if (this.gOW == 0) {
            g(this.kWz, 6, 0, this.fFa);
        }
        ExchangeEmotionPackRequest exchangeEmotionPackRequest = (ExchangeEmotionPackRequest) this.ehh.fsG.fsP;
        exchangeEmotionPackRequest.ProductID = this.kWz;
        exchangeEmotionPackRequest.SeriesID = this.kWB;
        exchangeEmotionPackRequest.IsAutomatic = this.kWD;
        exchangeEmotionPackRequest.Scene = this.gOW;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53110);
        return a;
    }

    static void g(String str, int i, int i2, String str2) {
        AppMethodBeat.i(53111);
        j.bkn().g(str, i, i2, str2);
        AppMethodBeat.o(53111);
    }

    public final void cancel() {
        AppMethodBeat.i(53112);
        super.cancel();
        this.eVT = true;
        AppMethodBeat.o(53112);
    }

    static /* synthetic */ void av(String str, boolean z) {
        AppMethodBeat.i(53113);
        if (!bo.isNullOrNil(str)) {
            ab.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", str, Boolean.valueOf(z));
            cx cxVar = new cx();
            cxVar.cvY.cvZ = str;
            cxVar.cvY.cuy = 2;
            cxVar.cvY.success = z;
            com.tencent.mm.sdk.b.a.xxA.m(cxVar);
        }
        AppMethodBeat.o(53113);
    }
}
