package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ugc.TXRecordCommon;
import junit.framework.Assert;

public final class f extends m implements k {
    a eOm;
    boolean eVT;
    public b ehh;
    private com.tencent.mm.ai.f ehi;
    private int fDC;
    int fXf;
    private a ooh;
    int retCode;

    public f(a aVar, boolean z) {
        this(aVar, z, 0);
    }

    public f(a aVar, boolean z, int i) {
        int i2 = 1;
        AppMethodBeat.i(22738);
        this.ooh = null;
        this.eOm = null;
        this.retCode = 0;
        this.fXf = 0;
        this.eVT = false;
        this.ooh = aVar;
        this.fDC = i;
        aVar.createTime = bo.anU();
        if (aVar.msgType == 43) {
            aVar.status = 104;
            o.all();
            aVar.ood = t.uj(t.ui(aVar.bNw()));
            o.all();
            aVar.cde = t.uj(t.uh(aVar.bNw()));
            this.fXf = 2500;
            if (aVar.videoSource == 2) {
                this.fXf = 2500;
            }
        } else if (aVar.msgType == 34) {
            this.fXf = 40;
            aVar.status = 104;
            aVar.cde = com.tencent.mm.modelvoice.o.uj(aVar.bNw());
            aVar.ood = 0;
        } else if (aVar.msgType == 3) {
            int i3;
            this.fXf = 40;
            if (i == 1) {
                this.fXf = 1250;
                i3 = 1;
            } else {
                i3 = 0;
            }
            aVar.ooe = i3;
            aVar.status = 104;
            aVar.ood = 0;
            StringBuilder stringBuilder = new StringBuilder();
            aw.ZK();
            aVar.cde = (int) e.asZ(stringBuilder.append(c.XW()).append(aVar.bNw()).toString());
        } else if (aVar.msgType == 1) {
            this.fXf = 1;
            aVar.status = 104;
            aVar.cde = aVar.bNw().getBytes().length;
            aVar.ood = 0;
        } else {
            ab.d("MicroMsg.NetSceneMasSend", "error msgtype:" + aVar.msgType);
            Assert.assertTrue("error msgtype:" + aVar.msgType, false);
        }
        b.a aVar2 = new b.a();
        aVar2.fsJ = new bap();
        aVar2.fsK = new baq();
        aVar2.uri = "/cgi-bin/micromsg-bin/masssend";
        aVar2.fsI = JsApiChooseMedia.CTRL_INDEX;
        aVar2.fsL = 84;
        aVar2.fsM = 1000000084;
        this.ehh = aVar2.acD();
        bap bap = (bap) this.ehh.fsG.fsP;
        bap.wEm = g.x(aVar.bNy().getBytes());
        bap.wEx = aVar.ooa;
        bap.wEl = aVar.bNy();
        aVar.fQv = bo.anU();
        bap.wEn = aVar.bNv();
        bap.nao = aVar.msgType;
        bap.wEo = aVar.oob;
        if (!z) {
            i2 = 0;
        }
        bap.wEy = i2;
        bap.wqw = i;
        this.eOm = new a();
        AppMethodBeat.o(22738);
    }

    public final void cancel() {
        this.eVT = true;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ai.f fVar) {
        int i = 0;
        AppMethodBeat.i(22739);
        this.ehi = fVar;
        if (this.eVT) {
            ab.d("MicroMsg.NetSceneMasSend", "isCancel");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        }
        this.fXf--;
        if (this.fXf < 0) {
            ab.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        } else if (this.ooh == null) {
            ab.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        } else if (bo.isNullOrNil(this.ooh.bNy())) {
            ab.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        } else if (this.ooh.ooa == 0) {
            ab.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        } else if (this.ooh.cde <= 0) {
            ab.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        } else if (this.ooh.status == 103 && this.ooh.ood <= 0) {
            ab.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        } else if (this.ooh.status == 103 || this.ooh.status == 104) {
            int i2;
            bap bap = (bap) this.ehh.fsG.fsP;
            String bNw;
            if (this.ooh.msgType == 43) {
                bNw = this.ooh.bNw();
                if (bo.isNullOrNil(bNw)) {
                    ab.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
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
                    t.b m;
                    byte[] bArr;
                    SKBuiltinBuffer_t sKBuiltinBuffer_t;
                    if (this.ooh.status == 103) {
                        o.all();
                        m = t.m(t.ui(bNw), this.ooh.fWZ, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                        if (m.ret < 0 || m.cqs == 0) {
                            ab.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + bNw + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                            i2 = -1;
                        } else {
                            ab.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + bNw + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.ooh.fWZ);
                            if (m.fXD < this.ooh.fWZ) {
                                ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + bNw + "] newOff:" + m.fXD + " OldtOff:" + this.ooh.fWZ);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
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
                        o.all();
                        m = t.m(t.uh(bNw), this.ooh.ooc, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                        if (m.ret < 0 || m.cqs == 0) {
                            ab.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + bNw + "]  Error ");
                            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                            i2 = -1;
                        } else {
                            ab.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + bNw + "] read ret:" + m.ret + " readlen:" + m.cqs + " newOff:" + m.fXD + " netOff:" + this.ooh.ooc);
                            if (m.fXD < this.ooh.ooc) {
                                ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + bNw + "] newOff:" + m.fXD + " OldtOff:" + this.ooh.ooc);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                                i2 = -1;
                            } else if (m.fXD >= com.tencent.mm.modelvideo.c.fUE) {
                                ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + bNw + "] maxsize:" + com.tencent.mm.modelvideo.c.fUE);
                                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
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
                    AppMethodBeat.o(22739);
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
                com.tencent.mm.modelvoice.b uN = q.uN(this.ooh.bNw());
                if (uN == null) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                    ab.d("MicroMsg.NetSceneMasSend", "fileop is null");
                    i = -1;
                } else {
                    com.tencent.mm.modelvoice.g cF = uN.cF(this.ooh.ooc, TXRecordCommon.AUDIO_SAMPLERATE_8000);
                    if (cF.ret < 0) {
                        ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.ooh.bNw() + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + this.ooh.ooc);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                        i = -1;
                    } else if (cF.fXD < this.ooh.ooc || cF.fXD >= 469000) {
                        ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.ooh.bNw() + "] read ret:" + cF.ret + " readlen:" + cF.cqs + " newOff:" + cF.fXD + " netOff:" + this.ooh.ooc);
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                        i = -1;
                    } else if (this.ooh.cde <= 0) {
                        ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.ooh.bNw() + "] read totalLen:" + this.ooh.cde);
                        this.retCode = com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK;
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
                    AppMethodBeat.o(22739);
                    return -1;
                }
            } else if (this.ooh.msgType == 3) {
                if (bo.isNullOrNil(this.ooh.bNw())) {
                    ab.d("MicroMsg.NetSceneMasSend", "getFilename is null");
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
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
                    aw.ZK();
                    bNw = stringBuilder.append(c.XW()).append(this.ooh.bNw()).toString();
                    int i3 = this.ooh.cde - this.ooh.ooc;
                    if (i3 > TXRecordCommon.AUDIO_SAMPLERATE_8000) {
                        i3 = TXRecordCommon.AUDIO_SAMPLERATE_8000;
                    }
                    byte[] e = e.e(bNw, this.ooh.ooc, i3);
                    if (bo.cb(e)) {
                        ab.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.ooh.bNw() + "]  Error ");
                        this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
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
                    AppMethodBeat.o(22739);
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
                ab.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.ooh.msgType);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                AppMethodBeat.o(22739);
                return -1;
            }
            i2 = a(eVar, this.ehh, this);
            AppMethodBeat.o(22739);
            return i2;
        } else {
            ab.d("MicroMsg.NetSceneMasSend", "msg type :" + this.ooh.msgType);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
            AppMethodBeat.o(22739);
            return -1;
        }
    }

    public final m.b b(com.tencent.mm.network.q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 2500;
    }

    public final void a(m.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(22740);
        ab.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + i2 + " errCode:" + i3);
        if (i2 != 0 || i3 != 0) {
            ab.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + i2 + " errCode:" + i3);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(22740);
        } else if (this.ooh == null) {
            ab.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(22740);
        } else if (this.ooh.status == 104 || this.ooh.status == 103) {
            baq baq = (baq) this.ehh.fsH.fsP;
            bap bap = (bap) this.ehh.fsG.fsP;
            if (bap.wEs > 0 && bap.wEu != null && bap.wEu.getBuffer() != null && !bo.cb(bap.wEu.getBuffer().toByteArray()) && bap.wEt != baq.wEt - bap.wEu.getILen()) {
                ab.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.o(22740);
            } else if (bap.wEr <= 0 || bap.wEp == null || bap.wEp.getBuffer() == null || bo.cb(bap.wEp.getBuffer().toByteArray()) || bap.wEq == baq.wEq - bap.wEp.getILen()) {
                this.ooh.fXb = bo.anT();
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
                    ab.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(i4)));
                    this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                    this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                    AppMethodBeat.o(22740);
                    return;
                }
                if (this.ooh.status == 199) {
                    b bNE = h.bNE();
                    a aVar = this.ooh;
                    if (aVar != null) {
                        String str2;
                        String str3;
                        aVar.bJt = -1;
                        ContentValues contentValues = new ContentValues();
                        if ((aVar.bJt & 1) != 0) {
                            contentValues.put("clientid", aVar.bNv());
                        }
                        if ((aVar.bJt & 2) != 0) {
                            contentValues.put("status", Integer.valueOf(aVar.status));
                        }
                        if ((aVar.bJt & 4) != 0) {
                            contentValues.put("createtime", Long.valueOf(aVar.createTime));
                        }
                        if ((aVar.bJt & 8) != 0) {
                            contentValues.put("lastmodifytime", Long.valueOf(aVar.fXb));
                        }
                        if ((aVar.bJt & 16) != 0) {
                            contentValues.put("filename", aVar.bNw());
                        }
                        if ((aVar.bJt & 32) != 0) {
                            contentValues.put("thumbfilename", aVar.bNx());
                        }
                        if ((aVar.bJt & 64) != 0) {
                            contentValues.put("tolist", aVar.bNy());
                        }
                        if ((aVar.bJt & 128) != 0) {
                            contentValues.put("tolistcount", Integer.valueOf(aVar.ooa));
                        }
                        if ((aVar.bJt & 256) != 0) {
                            contentValues.put("msgtype", Integer.valueOf(aVar.msgType));
                        }
                        if ((aVar.bJt & 512) != 0) {
                            contentValues.put("mediatime", Integer.valueOf(aVar.oob));
                        }
                        if ((aVar.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                            contentValues.put("datanetoffset", Integer.valueOf(aVar.ooc));
                        }
                        if ((aVar.bJt & 2048) != 0) {
                            contentValues.put("datalen", Integer.valueOf(aVar.cde));
                        }
                        if ((aVar.bJt & 4096) != 0) {
                            contentValues.put("thumbnetoffset", Integer.valueOf(aVar.fWZ));
                        }
                        if ((aVar.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
                            contentValues.put("thumbtotallen", Integer.valueOf(aVar.ood));
                        }
                        if ((aVar.bJt & 16384) != 0) {
                            contentValues.put("reserved1", Integer.valueOf(aVar.videoSource));
                        }
                        if ((aVar.bJt & 32768) != 0) {
                            contentValues.put("reserved2", Integer.valueOf(aVar.ooe));
                        }
                        if ((aVar.bJt & 65536) != 0) {
                            str2 = "reserved3";
                            if (aVar.fng == null) {
                                str3 = "";
                            } else {
                                str3 = aVar.fng;
                            }
                            contentValues.put(str2, str3);
                        }
                        if ((aVar.bJt & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                            str2 = "reserved4";
                            if (aVar.fnh == null) {
                                str3 = "";
                            } else {
                                str3 = aVar.fnh;
                            }
                            contentValues.put(str2, str3);
                        }
                        if (((int) bNE.fni.insert("massendinfo", "clientid", contentValues)) != -1) {
                            aw.ZK();
                            Object obj = c.XR().aoZ("masssendapp") == null ? 1 : null;
                            ak akVar = new ak();
                            akVar.setUsername("masssendapp");
                            akVar.setContent(b.a(aVar));
                            akVar.eD(aVar.createTime);
                            akVar.hO(0);
                            akVar.hM(0);
                            if (obj != null) {
                                aw.ZK();
                                c.XR().d(akVar);
                            } else {
                                aw.ZK();
                                c.XR().a(akVar, "masssendapp");
                            }
                            bNE.doNotify();
                        }
                    }
                    ab.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(this.eOm != null ? this.eOm.Mr() : 0)));
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(22740);
                } else if (a(this.ftf, this.ehi) == -1) {
                    this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + Downloads.MIN_WAIT_FOR_NETWORK);
                    this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                    AppMethodBeat.o(22740);
                } else {
                    AppMethodBeat.o(22740);
                }
            } else {
                ab.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.ehi.onSceneEnd(3, -1, "doScene failed", this);
                AppMethodBeat.o(22740);
            }
        } else {
            ab.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.ooh.status);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(22740);
        }
    }

    public final int getType() {
        return JsApiChooseMedia.CTRL_INDEX;
    }
}
