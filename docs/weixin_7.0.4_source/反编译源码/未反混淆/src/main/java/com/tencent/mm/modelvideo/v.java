package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.al.c;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class v implements e {
    public final b b(a aVar) {
        AppMethodBeat.i(50861);
        cm cmVar = aVar.eAB;
        if (cmVar == null) {
            ab.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            AppMethodBeat.o(50861);
            return null;
        }
        String str;
        String str2 = (String) g.RP().Ry().get(2, (Object) "");
        String a = aa.a(cmVar.vEC);
        String a2 = aa.a(cmVar.vEB);
        boolean z = ((j) g.K(j.class)).XU().has(a2) || str2.equals(a2);
        ab.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", a2, a, str2, Boolean.valueOf(z));
        h bOr = ((j) g.K(j.class)).bOr();
        if (str2.equals(a2)) {
            str = a;
        } else {
            str = a2;
        }
        bi Q = bOr.Q(str, cmVar.ptF);
        ab.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId), Integer.valueOf(Q.field_flag), Long.valueOf(Q.field_msgSeq), aVar);
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < bf.q(a2, (long) cmVar.pcX)) {
            ab.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(cmVar.ptF), Long.valueOf(Q.field_msgId));
            bf.fm(Q.field_msgId);
            Q.setMsgId(0);
        }
        if (Q.field_msgId != 0) {
            ab.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", Long.valueOf(cmVar.ptF));
            AppMethodBeat.o(50861);
            return null;
        }
        String a3 = aa.a(cmVar.vED);
        s sVar = new s();
        if (z) {
            a2 = a;
        }
        sVar.cIS = a2;
        sVar.createTime = (long) cmVar.pcX;
        sVar.cKK = cmVar.ptF;
        sVar.fXj = cmVar.vED.wVI;
        ab.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", a3, cmVar.vEG);
        Map z2 = br.z(a3, "msg");
        if (z2 == null) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 216, 1, false);
            AppMethodBeat.o(50861);
            return null;
        }
        cy biVar = new bi();
        biVar.ix(cmVar.vEG);
        biVar.jA(bf.oF(cmVar.vEG));
        try {
            int i;
            sVar.frO = bo.getInt((String) z2.get(".msg.videomsg.$length"), 0);
            sVar.fXd = bo.getInt((String) z2.get(".msg.videomsg.$playlength"), 0);
            ab.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", Integer.valueOf(sVar.frO), Integer.valueOf(sVar.fXd));
            sVar.fWW = (String) z2.get(".msg.videomsg.$fromusername");
            if (str2.equals(sVar.alt())) {
                sVar.fWW = a;
            }
            sVar.cMn = (String) z2.get(".msg.statextstr");
            str2 = (String) z2.get(".msg.videomsg.$cdnthumbaeskey");
            String str3 = (String) z2.get(".msg.videomsg.$cdnthumburl");
            int i2 = bo.getInt((String) z2.get(".msg.videomsg.$cdnthumblength"), 0);
            str = (String) z2.get(".msg.videomsg.$tpvideourl");
            final String str4 = (String) z2.get(".msg.videomsg.$tpthumburl");
            String str5 = (String) z2.get(".msg.videomsg.$tpauthkey");
            String str6 = (String) z2.get(".msg.videomsg.$tpthumbaeskey");
            final int i3 = bo.getInt((String) z2.get(".msg.videomsg.$tpthumblength"), 0);
            int i4 = bo.getInt((String) z2.get(".msg.videomsg.$type"), 0);
            ab.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(i4)));
            if (i4 == 44) {
                i = 1;
            } else {
                i = 0;
            }
            sVar.fXh = i;
            if (62 == cmVar.nao) {
                sVar.fXk = 3;
            } else if (i4 > 0) {
                sVar.fXk = 2;
            } else {
                sVar.fXk = 1;
            }
            String bc = bo.bc((String) z2.get(".msg.streamvideo.streamvideourl"), "");
            int i5 = bo.getInt((String) z2.get(".msg.streamvideo.streamvideototaltime"), 0);
            String bc2 = bo.bc((String) z2.get(".msg.streamvideo.streamvideotitle"), "");
            String bc3 = bo.bc((String) z2.get(".msg.streamvideo.streamvideowording"), "");
            String bc4 = bo.bc((String) z2.get(".msg.streamvideo.streamvideoweburl"), "");
            String bc5 = bo.bc((String) z2.get(".msg.streamvideo.streamvideoaduxinfo"), "");
            a = bo.bc((String) z2.get(".msg.streamvideo.streamvideopublishid"), "");
            if (sVar.fXm == null) {
                sVar.fXm = new cfh();
            }
            sVar.fXm.fiI = bc2;
            sVar.fXm.wid = i5;
            sVar.fXm.fiG = bc;
            sVar.fXm.fiJ = bc3;
            sVar.fXm.fiK = bc4;
            sVar.fXm.fiM = bc5;
            sVar.fXm.fiN = a;
            if (sVar.alt().equals((String) g.RP().Ry().get(2, (Object) ""))) {
                AppMethodBeat.o(50861);
                return null;
            }
            a = (String) z2.get(".msg.commenturl");
            Map z3 = br.z(a3, "msgoperation");
            if (z3 != null) {
                biVar.jB((String) z3.get(".msgoperation.expinfo.expidstr"));
                biVar.ie(bo.getInt((String) z3.get(".msgoperation.sightmsg.downloadcontroltype"), 0));
                ab.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", biVar.dJE, Integer.valueOf(biVar.dJF));
            }
            bc = t.ug(sVar.alt());
            sVar.fileName = bc;
            biVar.eI(sVar.cKK);
            biVar.jv(sVar.getFileName());
            biVar.eJ(bf.q(sVar.getUser(), sVar.createTime));
            biVar.ju(sVar.getUser());
            biVar.setStatus(cmVar.jBT);
            biVar.hO(z ? 1 : 0);
            if (cmVar.nao == 62) {
                biVar.setType(62);
            } else {
                biVar.setType(43);
            }
            biVar.setContent(q.d(sVar.alt(), 0, false));
            biVar.jw(a3);
            biVar.jz(a);
            biVar.ix(cmVar.vEG);
            bf.a((bi) biVar, aVar);
            long l = bf.l(biVar);
            if (l <= 0) {
                com.tencent.mm.plugin.report.service.h.pYm.a(111, 215, 1, false);
                ab.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", Long.valueOf(l), Long.valueOf(sVar.cKK));
                AppMethodBeat.o(50861);
                return null;
            }
            sVar.fXe = (int) l;
            sVar.fXb = bo.anT();
            sVar.fXf = 0;
            sVar.status = 111;
            ab.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + sVar.getFileName() + "] size:" + sVar.frO + " svrid:" + sVar.cKK + " timelen:" + sVar.fXd + " user:" + sVar.getUser() + " human:" + sVar.alt());
            if (o.all().b(sVar)) {
                o.all();
                final String ui = t.ui(bc);
                byte[] a4 = aa.a(cmVar.vEF);
                ab.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", Integer.valueOf(bo.cc(a4)));
                if (ae.giF) {
                    ab.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a4 = null;
                }
                final long j;
                final long anU;
                final String str7;
                final s sVar2;
                if (!bo.cb(a4)) {
                    t.a(ui, 0, a4);
                } else if (bo.isNullOrNil(str)) {
                    j = sVar.cKK;
                    ab.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), sVar.getUser(), str3, ui);
                    anU = bo.anU();
                    str7 = ui + ".tmp";
                    com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                    gVar.field_mediaId = c.a("downvideothumb", sVar.createTime, sVar.getUser(), String.valueOf(j));
                    gVar.field_fullpath = str7;
                    gVar.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
                    gVar.field_totalLen = i2;
                    gVar.field_aesKey = str2;
                    gVar.field_fileId = str3;
                    gVar.field_priority = com.tencent.mm.i.a.efD;
                    gVar.field_chattype = t.kH(sVar.getUser()) ? 1 : 0;
                    ab.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", Integer.valueOf(gVar.field_chattype), sVar.getUser());
                    sVar2 = sVar;
                    str4 = str3;
                    i3 = i2;
                    gVar.egl = new com.tencent.mm.i.g.a() {
                        public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                            AppMethodBeat.i(50860);
                            int a = v.a(i, dVar, j, sVar2, ui, str4, i3, str7, anU);
                            AppMethodBeat.o(50860);
                            return a;
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] l(String str, byte[] bArr) {
                            return null;
                        }
                    };
                    f.afx().b(gVar, -1);
                } else {
                    j = sVar.cKK;
                    ab.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), sVar.getUser(), str4, ui);
                    anU = bo.anU();
                    str7 = ui + ".tmp";
                    com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
                    gVar2.field_mediaId = c.a("downvideothumb", sVar.createTime, sVar.getUser(), String.valueOf(j));
                    gVar2.field_fullpath = str7;
                    gVar2.field_fileType = 19;
                    gVar2.field_aesKey = str6;
                    gVar2.field_authKey = str5;
                    gVar2.egm = str4;
                    sVar2 = sVar;
                    gVar2.egl = new com.tencent.mm.i.g.a() {
                        public final int a(String str, int i, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                            AppMethodBeat.i(50859);
                            int a = v.a(i, dVar, j, sVar2, ui, str4, i3, str7, anU);
                            AppMethodBeat.o(50859);
                            return a;
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] l(String str, byte[] bArr) {
                            return new byte[0];
                        }
                    };
                    f.afx().b(gVar2, -1);
                }
                if (biVar.bwt()) {
                    Object obj;
                    com.tencent.mm.modelcontrol.c.afC();
                    if (biVar.dJF == 1) {
                        obj = 1;
                    } else if (biVar.dJF == 2) {
                        obj = null;
                    } else if (com.tencent.mm.modelcontrol.c.v(biVar)) {
                        str2 = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("C2CSightNotAutoDownloadTimeRange");
                        ab.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(str2)));
                        if (com.tencent.mm.modelcontrol.b.rR(str2)) {
                            ab.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
                            obj = null;
                        } else {
                            str = biVar.field_talker;
                            ab.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(str)));
                            i = bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("SIGHTSessionAutoLoadNetwork"), 1);
                            ad aoO;
                            if (i == 3) {
                                ab.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId));
                                obj = null;
                            } else if (at.isWifi(ah.getContext())) {
                                ab.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), biVar.field_imgPath);
                                aoO = ((j) g.K(j.class)).XM().aoO(str);
                                if (aoO == null || ((int) aoO.ewQ) <= 0 || !((t.kH(str) && aoO.dua == 0) || aoO.DX())) {
                                    obj = 1;
                                } else {
                                    ab.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
                                    obj = null;
                                }
                            } else if (at.is2G(ah.getContext())) {
                                ab.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), biVar.field_imgPath);
                                obj = null;
                            } else {
                                aoO = ((j) g.K(j.class)).XM().aoO(biVar.field_talker);
                                if (t.kH(biVar.field_talker)) {
                                    if (aoO.dua == 0) {
                                        ab.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), biVar.field_imgPath);
                                        obj = null;
                                    } else if ((at.is3G(ah.getContext()) || at.is4G(ah.getContext())) && i == 1) {
                                        ab.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), biVar.field_imgPath);
                                        obj = 1;
                                    } else {
                                        ab.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
                                        obj = null;
                                    }
                                } else if (aoO.DX()) {
                                    ab.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), biVar.field_imgPath);
                                    obj = null;
                                } else if ((at.is3G(ah.getContext()) || at.is4G(ah.getContext())) && i == 1) {
                                    ab.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgSvrId), biVar.field_imgPath);
                                    obj = 1;
                                } else {
                                    ab.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
                                    obj = null;
                                }
                            }
                        }
                    } else {
                        ab.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
                        obj = null;
                    }
                    if (obj != null) {
                        u.up(biVar.field_imgPath);
                        f.afx().fyQ.add("video_" + biVar.field_msgId);
                    }
                }
                int i6 = 1;
                int i7 = 0;
                if (t.kH(sVar.getUser())) {
                    i7 = n.mA(sVar.getUser());
                    if (t.nN(sVar.getUser()) || !t.nM(sVar.getUser())) {
                        i6 = 2;
                    } else {
                        i6 = 3;
                    }
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(14388, Long.valueOf(biVar.field_msgSvrId), Integer.valueOf(i6), "", Integer.valueOf(i7));
                i aln = o.aln();
                synchronized (aln.fVS) {
                    try {
                        aln.fVS.offerFirst(biVar);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(50861);
                    }
                }
                aln.ald();
                b bVar = new b(biVar, true);
                return bVar;
            }
            ab.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + sVar.getFileName());
            AppMethodBeat.o(50861);
            return null;
        } catch (Exception e) {
            com.tencent.mm.plugin.report.service.h.pYm.a(111, 216, 1, false);
            ab.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
            ab.e("MicroMsg.VideoMsgExtension", "exception:%s", bo.l(e));
            AppMethodBeat.o(50861);
            return null;
        }
    }

    public final void a(e.c cVar) {
        int i = 1;
        AppMethodBeat.i(50862);
        bi biVar = cVar.cKd;
        if (biVar == null) {
            AppMethodBeat.o(50862);
            return;
        }
        String str = biVar.field_imgPath;
        if (!bo.isNullOrNil(str)) {
            t all = o.all();
            if (all.fni.delete("videoinfo2", "filename= ?", new String[]{String.valueOf(str)}) > 0) {
                all.fry.cF(new t.a.a(str, t.a.b.DELETE, t.a.c.NORMAL, 1, -1));
                all.fry.doNotify();
            } else {
                i = 0;
            }
            if (i != 0) {
                try {
                    o.all();
                    new com.tencent.mm.vfs.b(t.ui(str)).delete();
                    o.all();
                    new com.tencent.mm.vfs.b(t.uh(str)).delete();
                    AppMethodBeat.o(50862);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.Mq() + " file:" + str + " msg:" + e.getMessage());
                }
            }
        }
        AppMethodBeat.o(50862);
    }

    public static int a(int i, d dVar, long j, s sVar, String str, String str2, int i2, String str3, long j2) {
        AppMethodBeat.i(50863);
        if (i != 0) {
            ab.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), sVar.getUser(), str2, str);
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(j2), Long.valueOf(bo.anU()), Integer.valueOf(c.bW(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(i2), "")).ajK();
            AppMethodBeat.o(50863);
            return i;
        } else if (dVar == null) {
            AppMethodBeat.o(50863);
            return 0;
        } else {
            String str4;
            if (dVar.field_retCode != 0) {
                ab.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(dVar.field_retCode), Long.valueOf(j), sVar.getUser(), str2, str);
            } else {
                new File(str3).renameTo(new File(str));
                ab.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), sVar.getUser(), str2, str);
                if (sVar.fXk == 3) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 6, (long) i2, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 7, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, t.kH(sVar.getUser()) ? 9 : 8, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 11, (long) i2, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, 12, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(198, t.kH(sVar.getUser()) ? 14 : 13, 1, false);
                }
            }
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(j2);
            objArr[3] = Long.valueOf(bo.anU());
            objArr[4] = Integer.valueOf(c.bW(ah.getContext()));
            objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = dVar == null ? "" : dVar.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            if (dVar == null) {
                str4 = "";
            } else {
                str4 = dVar.efY;
            }
            objArr[15] = str4;
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
            if (!(dVar == null || dVar.field_retCode == 0)) {
                objArr = new Object[16];
                objArr[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(bo.anU());
                objArr[4] = Integer.valueOf(c.bW(ah.getContext()));
                objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = dVar == null ? "" : dVar.efY;
                new com.tencent.mm.g.b.a.d(com.tencent.mm.plugin.report.a.r(objArr)).ajK();
            }
            t all = o.all();
            String fileName = sVar.getFileName();
            t.a.c cVar = t.a.c.NORMAL;
            if (!bo.isNullOrNil(fileName)) {
                s uf = all.uf(fileName);
                if (uf != null) {
                    all.fry.cF(new t.a.a(uf.getFileName(), t.a.b.UPDATE, cVar, uf.fXk, uf.fVs));
                    all.fry.doNotify();
                }
            }
            AppMethodBeat.o(50863);
            return 0;
        }
    }
}
