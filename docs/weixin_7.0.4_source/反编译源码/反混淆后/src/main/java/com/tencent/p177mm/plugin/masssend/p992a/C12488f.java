package com.tencent.p177mm.plugin.masssend.p992a;

import android.content.ContentValues;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C1878c;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9723b;
import com.tencent.p177mm.modelvoice.C26497b;
import com.tencent.p177mm.modelvoice.C32848o;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C37965g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bap;
import com.tencent.p177mm.protocal.protobuf.baq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ugc.TXRecordCommon;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.masssend.a.f */
public final class C12488f extends C1207m implements C1918k {
    C1446a eOm;
    boolean eVT;
    public C7472b ehh;
    private C1202f ehi;
    private int fDC;
    int fXf;
    private C39356a ooh;
    int retCode;

    public C12488f(C39356a c39356a, boolean z) {
        this(c39356a, z, 0);
    }

    public C12488f(C39356a c39356a, boolean z, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(22738);
        this.ooh = null;
        this.eOm = null;
        this.retCode = 0;
        this.fXf = 0;
        this.eVT = false;
        this.ooh = c39356a;
        this.fDC = i;
        c39356a.createTime = C5046bo.anU();
        if (c39356a.msgType == 43) {
            c39356a.status = 104;
            C37961o.all();
            c39356a.ood = C9720t.m17305uj(C9720t.m17304ui(c39356a.bNw()));
            C37961o.all();
            c39356a.cde = C9720t.m17305uj(C9720t.m17303uh(c39356a.bNw()));
            this.fXf = 2500;
            if (c39356a.videoSource == 2) {
                this.fXf = 2500;
            }
        } else if (c39356a.msgType == 34) {
            this.fXf = 40;
            c39356a.status = 104;
            c39356a.cde = C32848o.m53701uj(c39356a.bNw());
            c39356a.ood = 0;
        } else if (c39356a.msgType == 3) {
            int i3;
            this.fXf = 40;
            if (i == 1) {
                this.fXf = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            c39356a.ooe = i3;
            c39356a.status = 104;
            c39356a.ood = 0;
            StringBuilder stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            c39356a.cde = (int) C5730e.asZ(stringBuilder.append(C18628c.m29088XW()).append(c39356a.bNw()).toString());
        } else if (c39356a.msgType == 1) {
            this.fXf = 1;
            c39356a.status = 104;
            c39356a.cde = c39356a.bNw().getBytes().length;
            c39356a.ood = 0;
        } else {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "error msgtype:" + c39356a.msgType);
            Assert.assertTrue("error msgtype:" + c39356a.msgType, false);
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bap();
        c1196a.fsK = new baq();
        c1196a.uri = "/cgi-bin/micromsg-bin/masssend";
        c1196a.fsI = JsApiChooseMedia.CTRL_INDEX;
        c1196a.fsL = 84;
        c1196a.fsM = 1000000084;
        this.ehh = c1196a.acD();
        bap bap = (bap) this.ehh.fsG.fsP;
        bap.wEm = C1178g.m2591x(c39356a.bNy().getBytes());
        bap.wEx = c39356a.ooa;
        bap.wEl = c39356a.bNy();
        c39356a.fQv = C5046bo.anU();
        bap.wEn = c39356a.bNv();
        bap.nao = c39356a.msgType;
        bap.wEo = c39356a.oob;
        if (!z) {
            i2 = 0;
        }
        bap.wEy = i2;
        bap.wqw = i;
        this.eOm = new C1446a();
        AppMethodBeat.m2505o(22738);
    }

    public final void cancel() {
        this.eVT = true;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i = 0;
        AppMethodBeat.m2504i(22739);
        this.ehi = c1202f;
        if (this.eVT) {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "isCancel");
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        }
        this.fXf--;
        if (this.fXf < 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        } else if (this.ooh == null) {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        } else if (C5046bo.isNullOrNil(this.ooh.bNy())) {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        } else if (this.ooh.ooa == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        } else if (this.ooh.cde <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        } else if (this.ooh.status == 103 && this.ooh.ood <= 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        } else if (this.ooh.status == 103 || this.ooh.status == 104) {
            int i2;
            bap bap = (bap) this.ehh.fsG.fsP;
            String bNw;
            if (this.ooh.msgType == 43) {
                bNw = this.ooh.bNw();
                if (C5046bo.isNullOrNil(bNw)) {
                    C4990ab.m7410d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                    i2 = -1;
                } else {
                    bap.wEp = new SKBuiltinBuffer_t();
                    bap.wEq = 0;
                    bap.wEu = new SKBuiltinBuffer_t();
                    bap.wEt = 0;
                    bap.wEv = 2;
                    bap.wEo = this.ooh.oob;
                    bap.wEw = this.ooh.videoSource > 0 ? 2 : 0;
                    bap.wEs = this.ooh.ood;
                    bap.wEr = this.ooh.cde;
                    C9723b m;
                    byte[] bArr;
                    SKBuiltinBuffer_t sKBuiltinBuffer_t;
                    if (this.ooh.status == 103) {
                        C37961o.all();
                        m = C9720t.m17301m(C9720t.m17304ui(bNw), this.ooh.fWZ, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                        if (m.ret < 0 || m.cqs == 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + bNw + "]  Error ");
                            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                            i2 = -1;
                        } else {
                            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + bNw + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.ooh.fWZ);
                            if (m.fXD < this.ooh.fWZ) {
                                C4990ab.m7412e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + bNw + "] newOff:" + m.fXD + " OldtOff:" + this.ooh.fWZ);
                                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                                i2 = -1;
                            } else {
                                bArr = new byte[m.cqs];
                                System.arraycopy(m.buf, 0, bArr, 0, m.cqs);
                                bap.wEt = this.ooh.fWZ;
                                sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                                sKBuiltinBuffer_t.setBuffer(bArr);
                                bap.wEu = sKBuiltinBuffer_t;
                            }
                        }
                    } else {
                        C37961o.all();
                        m = C9720t.m17301m(C9720t.m17303uh(bNw), this.ooh.ooc, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                        if (m.ret < 0 || m.cqs == 0) {
                            C4990ab.m7412e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + bNw + "]  Error ");
                            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                            i2 = -1;
                        } else {
                            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + bNw + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.ooh.ooc);
                            if (m.fXD < this.ooh.ooc) {
                                C4990ab.m7412e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + bNw + "] newOff:" + m.fXD + " OldtOff:" + this.ooh.ooc);
                                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                                i2 = -1;
                            } else if (m.fXD >= C1878c.fUE) {
                                C4990ab.m7412e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + bNw + "] maxsize:" + C1878c.fUE);
                                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                                i2 = -1;
                            } else {
                                bArr = new byte[m.cqs];
                                System.arraycopy(m.buf, 0, bArr, 0, m.cqs);
                                bap.wEq = this.ooh.ooc;
                                bap.wEt = this.ooh.fWZ;
                                sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                                sKBuiltinBuffer_t.setBuffer(bArr);
                                bap.wEp = sKBuiltinBuffer_t;
                            }
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    AppMethodBeat.m2505o(22739);
                    return i2;
                }
            } else if (this.ooh.msgType == 34) {
                bap.wEv = 0;
                bap.wEw = 0;
                bap.wEp = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                bap.wEq = 0;
                bap.wEu = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                bap.wEt = 0;
                bap.wEs = 0;
                bap.wEr = this.ooh.cde;
                C26497b uN = C32850q.m53727uN(this.ooh.bNw());
                if (uN == null) {
                    this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                    C4990ab.m7410d("MicroMsg.NetSceneMasSend", "fileop is null");
                    i = -1;
                } else {
                    C37965g cF = uN.mo5461cF(this.ooh.ooc, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                    if (cF.ret < 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.ooh.bNw() + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + this.ooh.ooc);
                        this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                        i = -1;
                    } else if (cF.fXD < this.ooh.ooc || cF.fXD >= 469000) {
                        C4990ab.m7412e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.ooh.bNw() + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + this.ooh.ooc);
                        this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                        i = -1;
                    } else if (this.ooh.cde <= 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.ooh.bNw() + "] read totalLen:" + this.ooh.cde);
                        this.retCode = C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
                        i = -1;
                    } else {
                        byte[] bArr2 = new byte[cF.cqs];
                        System.arraycopy(cF.buf, 0, bArr2, 0, cF.cqs);
                        bap.wEp = new SKBuiltinBuffer_t().setBuffer(bArr2);
                        bap.wEo = this.ooh.oob;
                        bap.wEq = this.ooh.ooc;
                        bap.wEz = uN.getFormat();
                    }
                }
                if (i != 0) {
                    AppMethodBeat.m2505o(22739);
                    return -1;
                }
            } else if (this.ooh.msgType == 3) {
                if (C5046bo.isNullOrNil(this.ooh.bNw())) {
                    C4990ab.m7410d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                    i = -1;
                } else {
                    bap.wEv = 0;
                    bap.wEw = 0;
                    bap.wEp = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    bap.wEq = 0;
                    bap.wEu = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                    bap.wEt = 0;
                    bap.wEs = 0;
                    bap.wEo = 0;
                    bap.wEs = this.ooh.ood;
                    bap.wEr = this.ooh.cde;
                    bap.wqw = this.fDC;
                    StringBuilder stringBuilder = new StringBuilder();
                    C9638aw.m17190ZK();
                    bNw = stringBuilder.append(C18628c.m29088XW()).append(this.ooh.bNw()).toString();
                    int i3 = this.ooh.cde - this.ooh.ooc;
                    if (i3 > TXRecordCommon.AUDIO_SAMPLERATE_8000) {
                        i3 = TXRecordCommon.AUDIO_SAMPLERATE_8000;
                    }
                    byte[] e = C5730e.m8632e(bNw, this.ooh.ooc, i3);
                    if (C5046bo.m7540cb(e)) {
                        C4990ab.m7412e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.ooh.bNw() + "]  Error ");
                        this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                        i = -1;
                    } else {
                        bap.wEq = this.ooh.ooc;
                        bap.wEt = this.ooh.fWZ;
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        sKBuiltinBuffer_t2.setBuffer(e);
                        bap.wEp = sKBuiltinBuffer_t2;
                    }
                }
                if (i != 0) {
                    AppMethodBeat.m2505o(22739);
                    return -1;
                }
            } else if (this.ooh.msgType == 1) {
                bap.wEp = new SKBuiltinBuffer_t().setBuffer(this.ooh.bNw().getBytes());
                bap.wEr = this.ooh.cde;
                bap.wEo = 0;
                bap.wEq = 0;
                bap.wEu = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                bap.wEt = 0;
                bap.wEs = 0;
                bap.wEv = 0;
                bap.wEw = 0;
            } else {
                C4990ab.m7410d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.ooh.msgType);
                this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.m2505o(22739);
                return -1;
            }
            i2 = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(22739);
            return i2;
        } else {
            C4990ab.m7410d("MicroMsg.NetSceneMasSend", "msg type :" + this.ooh.msgType);
            this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.m2505o(22739);
            return -1;
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 2500;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22740);
        C4990ab.m7410d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i2 + " errCode:" + i3);
        if (i2 != 0 || i3 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i2 + " errCode:" + i3);
            this.retCode = (0 - C1447g.getLine()) - 10000;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(22740);
        } else if (this.ooh == null) {
            C4990ab.m7412e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.retCode = (0 - C1447g.getLine()) - 10000;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(22740);
        } else if (this.ooh.status == 104 || this.ooh.status == 103) {
            baq baq = (baq) this.ehh.fsH.fsP;
            bap bap = (bap) this.ehh.fsG.fsP;
            if (bap.wEs > 0 && bap.wEu != null && bap.wEu.getBuffer() != null && !C5046bo.m7540cb(bap.wEu.getBuffer().toByteArray()) && bap.wEt != baq.wEt - bap.wEu.getILen()) {
                C4990ab.m7412e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.retCode = (0 - C1447g.getLine()) - 10000;
                this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.m2505o(22740);
            } else if (bap.wEr <= 0 || bap.wEp == null || bap.wEp.getBuffer() == null || C5046bo.m7540cb(bap.wEp.getBuffer().toByteArray()) || bap.wEq == baq.wEq - bap.wEp.getILen()) {
                this.ooh.fXb = C5046bo.anT();
                int i4 = this.ooh.status;
                if (i4 == 103) {
                    this.ooh.fWZ = bap.wEu.getILen() + bap.wEt;
                    if (this.ooh.fWZ >= this.ooh.ood) {
                        this.ooh.status = 199;
                    }
                } else if (i4 == 104) {
                    this.ooh.ooc = bap.wEp.getILen() + bap.wEq;
                    if (this.ooh.ooc >= this.ooh.cde) {
                        if (this.ooh.ood > 0) {
                            this.ooh.status = 103;
                        } else {
                            this.ooh.status = 199;
                        }
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(i4)));
                    this.retCode = (0 - C1447g.getLine()) - 10000;
                    this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                    AppMethodBeat.m2505o(22740);
                    return;
                }
                if (this.ooh.status == 199) {
                    C46069b bNE = C21270h.bNE();
                    C39356a c39356a = this.ooh;
                    if (c39356a != null) {
                        String str2;
                        String str3;
                        c39356a.bJt = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((c39356a.bJt & 1) != 0) {
                            contentValues.put("clientid", c39356a.bNv());
                        }
                        if ((c39356a.bJt & 2) != 0) {
                            contentValues.put("status", Integer.valueOf(c39356a.status));
                        }
                        if ((c39356a.bJt & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(c39356a.createTime));
                        }
                        if ((c39356a.bJt & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(c39356a.fXb));
                        }
                        if ((c39356a.bJt & 16) != 0) {
                            contentValues.put("filename", c39356a.bNw());
                        }
                        if ((c39356a.bJt & 32) != 0) {
                            contentValues.put("thumbfilename", c39356a.bNx());
                        }
                        if ((c39356a.bJt & 64) != 0) {
                            contentValues.put("tolist", c39356a.bNy());
                        }
                        if ((c39356a.bJt & 128) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(c39356a.ooa));
                        }
                        if ((c39356a.bJt & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(c39356a.msgType));
                        }
                        if ((c39356a.bJt & 512) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(c39356a.oob));
                        }
                        if ((c39356a.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(c39356a.ooc));
                        }
                        if ((c39356a.bJt & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(c39356a.cde));
                        }
                        if ((c39356a.bJt & 4096) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(c39356a.fWZ));
                        }
                        if ((c39356a.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(c39356a.ood));
                        }
                        if ((c39356a.bJt & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(c39356a.videoSource));
                        }
                        if ((c39356a.bJt & 32768) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(c39356a.ooe));
                        }
                        if ((c39356a.bJt & 65536) != 0) {
                            str2 = "reserved3";
                            if (c39356a.fng == null) {
                                str3 = "";
                            } else {
                                str3 = c39356a.fng;
                            }
                            contentValues.put(str2, str3);
                        }
                        if ((c39356a.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                            str2 = "reserved4";
                            if (c39356a.fnh == null) {
                                str3 = "";
                            } else {
                                str3 = c39356a.fnh;
                            }
                            contentValues.put(str2, str3);
                        }
                        if (((int) bNE.fni.insert("massendinfo", "clientid", contentValues)) != -1) {
                            C9638aw.m17190ZK();
                            Object obj = C18628c.m29083XR().aoZ("masssendapp") == null ? 1 : null;
                            C7617ak c7617ak = new C7617ak();
                            c7617ak.setUsername("masssendapp");
                            c7617ak.setContent(C46069b.m85832a(c39356a));
                            c7617ak.mo14742eD(c39356a.createTime);
                            c7617ak.mo14750hO(0);
                            c7617ak.mo14748hM(0);
                            if (obj != null) {
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15807d(c7617ak);
                            } else {
                                C9638aw.m17190ZK();
                                C18628c.m29083XR().mo15767a(c7617ak, "masssendapp");
                            }
                            bNE.doNotify();
                        }
                    }
                    C4990ab.m7410d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(this.eOm != null ? this.eOm.mo4908Mr() : 0)));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(22740);
                } else if (mo4456a(this.ftf, this.ehi) == -1) {
                    this.retCode = 0 - (C1447g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                    this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                    AppMethodBeat.m2505o(22740);
                } else {
                    AppMethodBeat.m2505o(22740);
                }
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.retCode = (0 - C1447g.getLine()) - 10000;
                this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.m2505o(22740);
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.ooh.status);
            this.retCode = (0 - C1447g.getLine()) - 10000;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(22740);
        }
    }

    public final int getType() {
        return JsApiChooseMedia.CTRL_INDEX;
    }
}
