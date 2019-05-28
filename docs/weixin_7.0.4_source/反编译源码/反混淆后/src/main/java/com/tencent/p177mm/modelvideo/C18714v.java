package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelcontrol.C37938c;
import com.tencent.p177mm.modelcontrol.C45448b;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9719c;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9722b;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p232b.p233a.C42099d;
import com.tencent.p177mm.p230g.p232b.p233a.C9514f;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.report.C46180a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

/* renamed from: com.tencent.mm.modelvideo.v */
public final class C18714v implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(50861);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            AppMethodBeat.m2505o(50861);
            return null;
        }
        String str;
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        String a = C1946aa.m4148a(c7254cm.vEC);
        String a2 = C1946aa.m4148a(c7254cm.vEB);
        boolean z = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().has(a2) || str2.equals(a2);
        C4990ab.m7411d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", a2, a, str2, Boolean.valueOf(z));
        C6977h bOr = ((C6982j) C1720g.m3528K(C6982j.class)).bOr();
        if (str2.equals(a2)) {
            str = a;
        } else {
            str = a2;
        }
        C7620bi Q = bOr.mo15241Q(str, c7254cm.ptF);
        C4990ab.m7417i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId), Integer.valueOf(Q.field_flag), Long.valueOf(Q.field_msgSeq), c1197a);
        if (Q.field_msgId != 0 && Q.field_createTime + 604800000 < C1829bf.m3764q(a2, (long) c7254cm.pcX)) {
            C4990ab.m7421w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(c7254cm.ptF), Long.valueOf(Q.field_msgId));
            C1829bf.m3748fm(Q.field_msgId);
            Q.setMsgId(0);
        }
        if (Q.field_msgId != 0) {
            C4990ab.m7411d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", Long.valueOf(c7254cm.ptF));
            AppMethodBeat.m2505o(50861);
            return null;
        }
        String a3 = C1946aa.m4148a(c7254cm.vED);
        C26493s c26493s = new C26493s();
        if (z) {
            a2 = a;
        }
        c26493s.cIS = a2;
        c26493s.createTime = (long) c7254cm.pcX;
        c26493s.cKK = c7254cm.ptF;
        c26493s.fXj = c7254cm.vED.wVI;
        C4990ab.m7417i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", a3, c7254cm.vEG);
        Map z2 = C5049br.m7595z(a3, "msg");
        if (z2 == null) {
            C7060h.pYm.mo8378a(111, 216, 1, false);
            AppMethodBeat.m2505o(50861);
            return null;
        }
        C6575cy c7620bi = new C7620bi();
        c7620bi.mo14791ix(c7254cm.vEG);
        c7620bi.mo14792jA(C1829bf.m3759oF(c7254cm.vEG));
        try {
            int i;
            c26493s.frO = C5046bo.getInt((String) z2.get(".msg.videomsg.$length"), 0);
            c26493s.fXd = C5046bo.getInt((String) z2.get(".msg.videomsg.$playlength"), 0);
            C4990ab.m7417i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", Integer.valueOf(c26493s.frO), Integer.valueOf(c26493s.fXd));
            c26493s.fWW = (String) z2.get(".msg.videomsg.$fromusername");
            if (str2.equals(c26493s.alt())) {
                c26493s.fWW = a;
            }
            c26493s.cMn = (String) z2.get(".msg.statextstr");
            str2 = (String) z2.get(".msg.videomsg.$cdnthumbaeskey");
            String str3 = (String) z2.get(".msg.videomsg.$cdnthumburl");
            int i2 = C5046bo.getInt((String) z2.get(".msg.videomsg.$cdnthumblength"), 0);
            str = (String) z2.get(".msg.videomsg.$tpvideourl");
            final String str4 = (String) z2.get(".msg.videomsg.$tpthumburl");
            String str5 = (String) z2.get(".msg.videomsg.$tpauthkey");
            String str6 = (String) z2.get(".msg.videomsg.$tpthumbaeskey");
            final int i3 = C5046bo.getInt((String) z2.get(".msg.videomsg.$tpthumblength"), 0);
            int i4 = C5046bo.getInt((String) z2.get(".msg.videomsg.$type"), 0);
            C4990ab.m7410d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(i4)));
            if (i4 == 44) {
                i = 1;
            } else {
                i = 0;
            }
            c26493s.fXh = i;
            if (62 == c7254cm.nao) {
                c26493s.fXk = 3;
            } else if (i4 > 0) {
                c26493s.fXk = 2;
            } else {
                c26493s.fXk = 1;
            }
            String bc = C5046bo.m7532bc((String) z2.get(".msg.streamvideo.streamvideourl"), "");
            int i5 = C5046bo.getInt((String) z2.get(".msg.streamvideo.streamvideototaltime"), 0);
            String bc2 = C5046bo.m7532bc((String) z2.get(".msg.streamvideo.streamvideotitle"), "");
            String bc3 = C5046bo.m7532bc((String) z2.get(".msg.streamvideo.streamvideowording"), "");
            String bc4 = C5046bo.m7532bc((String) z2.get(".msg.streamvideo.streamvideoweburl"), "");
            String bc5 = C5046bo.m7532bc((String) z2.get(".msg.streamvideo.streamvideoaduxinfo"), "");
            a = C5046bo.m7532bc((String) z2.get(".msg.streamvideo.streamvideopublishid"), "");
            if (c26493s.fXm == null) {
                c26493s.fXm = new cfh();
            }
            c26493s.fXm.fiI = bc2;
            c26493s.fXm.wid = i5;
            c26493s.fXm.fiG = bc;
            c26493s.fXm.fiJ = bc3;
            c26493s.fXm.fiK = bc4;
            c26493s.fXm.fiM = bc5;
            c26493s.fXm.fiN = a;
            if (c26493s.alt().equals((String) C1720g.m3536RP().mo5239Ry().get(2, (Object) ""))) {
                AppMethodBeat.m2505o(50861);
                return null;
            }
            a = (String) z2.get(".msg.commenturl");
            Map z3 = C5049br.m7595z(a3, "msgoperation");
            if (z3 != null) {
                c7620bi.mo14793jB((String) z3.get(".msgoperation.expinfo.expidstr"));
                c7620bi.mo14790ie(C5046bo.getInt((String) z3.get(".msgoperation.sightmsg.downloadcontroltype"), 0));
                C4990ab.m7417i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", c7620bi.dJE, Integer.valueOf(c7620bi.dJF));
            }
            bc = C9720t.m17302ug(c26493s.alt());
            c26493s.fileName = bc;
            c7620bi.mo14774eI(c26493s.cKK);
            c7620bi.mo14795jv(c26493s.getFileName());
            c7620bi.mo14775eJ(C1829bf.m3764q(c26493s.getUser(), c26493s.createTime));
            c7620bi.mo14794ju(c26493s.getUser());
            c7620bi.setStatus(c7254cm.jBT);
            c7620bi.mo14781hO(z ? 1 : 0);
            if (c7254cm.nao == 62) {
                c7620bi.setType(62);
            } else {
                c7620bi.setType(43);
            }
            c7620bi.setContent(C37963q.m64228d(c26493s.alt(), 0, false));
            c7620bi.mo14796jw(a3);
            c7620bi.mo14799jz(a);
            c7620bi.mo14791ix(c7254cm.vEG);
            C1829bf.m3743a((C7620bi) c7620bi, c1197a);
            long l = C1829bf.m3752l(c7620bi);
            if (l <= 0) {
                C7060h.pYm.mo8378a(111, 215, 1, false);
                C4990ab.m7413e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", Long.valueOf(l), Long.valueOf(c26493s.cKK));
                AppMethodBeat.m2505o(50861);
                return null;
            }
            c26493s.fXe = (int) l;
            c26493s.fXb = C5046bo.anT();
            c26493s.fXf = 0;
            c26493s.status = 111;
            C4990ab.m7410d("MicroMsg.VideoMsgExtension", "Insert fileName[" + c26493s.getFileName() + "] size:" + c26493s.frO + " svrid:" + c26493s.cKK + " timelen:" + c26493s.fXd + " user:" + c26493s.getUser() + " human:" + c26493s.alt());
            if (C37961o.all().mo21059b(c26493s)) {
                C37961o.all();
                final String ui = C9720t.m17304ui(bc);
                byte[] a4 = C1946aa.m4150a(c7254cm.vEF);
                C4990ab.m7417i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", Integer.valueOf(C5046bo.m7541cc(a4)));
                if (C1947ae.giF) {
                    C4990ab.m7420w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a4 = null;
                }
                final long j;
                final long anU;
                final String str7;
                final C26493s c26493s2;
                if (!C5046bo.m7540cb(a4)) {
                    C9720t.m17299a(ui, 0, a4);
                } else if (C5046bo.isNullOrNil(str)) {
                    j = c26493s.cKK;
                    C4990ab.m7417i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), c26493s.getUser(), str3, ui);
                    anU = C5046bo.anU();
                    str7 = ui + ".tmp";
                    C42130g c42130g = new C42130g();
                    c42130g.field_mediaId = C37458c.m63162a("downvideothumb", c26493s.createTime, c26493s.getUser(), String.valueOf(j));
                    c42130g.field_fullpath = str7;
                    c42130g.field_fileType = C42129a.MediaType_THUMBIMAGE;
                    c42130g.field_totalLen = i2;
                    c42130g.field_aesKey = str2;
                    c42130g.field_fileId = str3;
                    c42130g.field_priority = C42129a.efD;
                    c42130g.field_chattype = C1855t.m3896kH(c26493s.getUser()) ? 1 : 0;
                    C4990ab.m7411d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", Integer.valueOf(c42130g.field_chattype), c26493s.getUser());
                    c26493s2 = c26493s;
                    str4 = str3;
                    i3 = i2;
                    c42130g.egl = new C1628a() {
                        /* renamed from: a */
                        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                            AppMethodBeat.m2504i(50860);
                            int a = C18714v.m29265a(i, c9545d, j, c26493s2, ui, str4, i3, str7, anU);
                            AppMethodBeat.m2505o(50860);
                            return a;
                        }

                        /* renamed from: a */
                        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        /* renamed from: l */
                        public final byte[] mo5084l(String str, byte[] bArr) {
                            return null;
                        }
                    };
                    C37461f.afx().mo51222b(c42130g, -1);
                } else {
                    j = c26493s.cKK;
                    C4990ab.m7417i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), c26493s.getUser(), str4, ui);
                    anU = C5046bo.anU();
                    str7 = ui + ".tmp";
                    C42130g c42130g2 = new C42130g();
                    c42130g2.field_mediaId = C37458c.m63162a("downvideothumb", c26493s.createTime, c26493s.getUser(), String.valueOf(j));
                    c42130g2.field_fullpath = str7;
                    c42130g2.field_fileType = 19;
                    c42130g2.field_aesKey = str6;
                    c42130g2.field_authKey = str5;
                    c42130g2.egm = str4;
                    c26493s2 = c26493s;
                    c42130g2.egl = new C1628a() {
                        /* renamed from: a */
                        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                            AppMethodBeat.m2504i(50859);
                            int a = C18714v.m29265a(i, c9545d, j, c26493s2, ui, str4, i3, str7, anU);
                            AppMethodBeat.m2505o(50859);
                            return a;
                        }

                        /* renamed from: a */
                        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        /* renamed from: l */
                        public final byte[] mo5084l(String str, byte[] bArr) {
                            return new byte[0];
                        }
                    };
                    C37461f.afx().mo51222b(c42130g2, -1);
                }
                if (c7620bi.bwt()) {
                    Object obj;
                    C37938c.afC();
                    if (c7620bi.dJF == 1) {
                        obj = 1;
                    } else if (c7620bi.dJF == 2) {
                        obj = null;
                    } else if (C37938c.m64123v(c7620bi)) {
                        str2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("C2CSightNotAutoDownloadTimeRange");
                        C4990ab.m7416i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(str2)));
                        if (C45448b.m83719rR(str2)) {
                            C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
                            obj = null;
                        } else {
                            str = c7620bi.field_talker;
                            C4990ab.m7410d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(str)));
                            i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SIGHTSessionAutoLoadNetwork"), 1);
                            C7616ad aoO;
                            if (i == 3) {
                                C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId));
                                obj = null;
                            } else if (C5023at.isWifi(C4996ah.getContext())) {
                                C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), c7620bi.field_imgPath);
                                aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                                if (aoO == null || ((int) aoO.ewQ) <= 0 || !((C1855t.m3896kH(str) && aoO.dua == 0) || aoO.mo16673DX())) {
                                    obj = 1;
                                } else {
                                    C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
                                    obj = null;
                                }
                            } else if (C5023at.is2G(C4996ah.getContext())) {
                                C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), c7620bi.field_imgPath);
                                obj = null;
                            } else {
                                aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7620bi.field_talker);
                                if (C1855t.m3896kH(c7620bi.field_talker)) {
                                    if (aoO.dua == 0) {
                                        C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), c7620bi.field_imgPath);
                                        obj = null;
                                    } else if ((C5023at.is3G(C4996ah.getContext()) || C5023at.is4G(C4996ah.getContext())) && i == 1) {
                                        C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), c7620bi.field_imgPath);
                                        obj = 1;
                                    } else {
                                        C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
                                        obj = null;
                                    }
                                } else if (aoO.mo16673DX()) {
                                    C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), c7620bi.field_imgPath);
                                    obj = null;
                                } else if ((C5023at.is3G(C4996ah.getContext()) || C5023at.is4G(C4996ah.getContext())) && i == 1) {
                                    C4990ab.m7417i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgSvrId), c7620bi.field_imgPath);
                                    obj = 1;
                                } else {
                                    C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
                                    obj = null;
                                }
                            }
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
                        obj = null;
                    }
                    if (obj != null) {
                        C26494u.m42264up(c7620bi.field_imgPath);
                        C37461f.afx().fyQ.add("video_" + c7620bi.field_msgId);
                    }
                }
                int i6 = 1;
                int i7 = 0;
                if (C1855t.m3896kH(c26493s.getUser())) {
                    i7 = C37921n.m64060mA(c26493s.getUser());
                    if (C1855t.m3928nN(c26493s.getUser()) || !C1855t.m3927nM(c26493s.getUser())) {
                        i6 = 2;
                    } else {
                        i6 = 3;
                    }
                }
                C7060h.pYm.mo8381e(14388, Long.valueOf(c7620bi.field_msgSvrId), Integer.valueOf(i6), "", Integer.valueOf(i7));
                C32847i aln = C37961o.aln();
                synchronized (aln.fVS) {
                    try {
                        aln.fVS.offerFirst(c7620bi);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(50861);
                    }
                }
                aln.ald();
                C1198b c1198b = new C1198b(c7620bi, true);
                return c1198b;
            }
            C4990ab.m7410d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + c26493s.getFileName());
            AppMethodBeat.m2505o(50861);
            return null;
        } catch (Exception e) {
            C7060h.pYm.mo8378a(111, 216, 1, false);
            C4990ab.m7412e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
            C4990ab.m7413e("MicroMsg.VideoMsgExtension", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(50861);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
        int i = 1;
        AppMethodBeat.m2504i(50862);
        C7620bi c7620bi = c1199c.cKd;
        if (c7620bi == null) {
            AppMethodBeat.m2505o(50862);
            return;
        }
        String str = c7620bi.field_imgPath;
        if (!C5046bo.isNullOrNil(str)) {
            C9720t all = C37961o.all();
            if (all.fni.delete("videoinfo2", "filename= ?", new String[]{String.valueOf(str)}) > 0) {
                all.fry.mo10126cF(new C9718a(str, C9722b.DELETE, C9719c.NORMAL, 1, -1));
                all.fry.doNotify();
            } else {
                i = 0;
            }
            if (i != 0) {
                try {
                    C37961o.all();
                    new C5728b(C9720t.m17304ui(str)).delete();
                    C37961o.all();
                    new C5728b(C9720t.m17303uh(str)).delete();
                    AppMethodBeat.m2505o(50862);
                    return;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + C1447g.m3075Mq() + " file:" + str + " msg:" + e.getMessage());
                }
            }
        }
        AppMethodBeat.m2505o(50862);
    }

    /* renamed from: a */
    public static int m29265a(int i, C9545d c9545d, long j, C26493s c26493s, String str, String str2, int i2, String str3, long j2) {
        AppMethodBeat.m2504i(50863);
        if (i != 0) {
            C4990ab.m7413e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), c26493s.getUser(), str2, str);
            new C9514f(C46180a.m86311r(Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(j2), Long.valueOf(C5046bo.anU()), Integer.valueOf(C37458c.m63165bW(C4996ah.getContext())), Integer.valueOf(C42129a.MediaType_THUMBIMAGE), Integer.valueOf(i2), "")).ajK();
            AppMethodBeat.m2505o(50863);
            return i;
        } else if (c9545d == null) {
            AppMethodBeat.m2505o(50863);
            return 0;
        } else {
            String str4;
            if (c9545d.field_retCode != 0) {
                C4990ab.m7413e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(c9545d.field_retCode), Long.valueOf(j), c26493s.getUser(), str2, str);
            } else {
                new File(str3).renameTo(new File(str));
                C4990ab.m7417i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), c26493s.getUser(), str2, str);
                if (c26493s.fXk == 3) {
                    C7060h.pYm.mo8378a(198, 6, (long) i2, false);
                    C7060h.pYm.mo8378a(198, 7, 1, false);
                    C7060h.pYm.mo8378a(198, C1855t.m3896kH(c26493s.getUser()) ? 9 : 8, 1, false);
                } else {
                    C7060h.pYm.mo8378a(198, 11, (long) i2, false);
                    C7060h.pYm.mo8378a(198, 12, 1, false);
                    C7060h.pYm.mo8378a(198, C1855t.m3896kH(c26493s.getUser()) ? 14 : 13, 1, false);
                }
            }
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(c9545d == null ? -1 : c9545d.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(j2);
            objArr[3] = Long.valueOf(C5046bo.anU());
            objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
            objArr[5] = Integer.valueOf(C42129a.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            if (c9545d == null) {
                str4 = "";
            } else {
                str4 = c9545d.efY;
            }
            objArr[15] = str4;
            new C9514f(C46180a.m86311r(objArr)).ajK();
            if (!(c9545d == null || c9545d.field_retCode == 0)) {
                objArr = new Object[16];
                objArr[0] = Integer.valueOf(c9545d == null ? -1 : c9545d.field_retCode);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(C5046bo.anU());
                objArr[4] = Integer.valueOf(C37458c.m63165bW(C4996ah.getContext()));
                objArr[5] = Integer.valueOf(C42129a.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = c9545d == null ? "" : c9545d.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = c9545d == null ? "" : c9545d.efY;
                new C42099d(C46180a.m86311r(objArr)).ajK();
            }
            C9720t all = C37961o.all();
            String fileName = c26493s.getFileName();
            C9719c c9719c = C9719c.NORMAL;
            if (!C5046bo.isNullOrNil(fileName)) {
                C26493s uf = all.mo21063uf(fileName);
                if (uf != null) {
                    all.fry.mo10126cF(new C9718a(uf.getFileName(), C9722b.UPDATE, c9719c, uf.fXk, uf.fVs));
                    all.fry.doNotify();
                }
            }
            AppMethodBeat.m2505o(50863);
            return 0;
        }
    }
}
