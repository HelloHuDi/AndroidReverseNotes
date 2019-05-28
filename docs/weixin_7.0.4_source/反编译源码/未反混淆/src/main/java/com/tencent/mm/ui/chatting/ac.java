package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.k;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.f;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;

public final class ac<T> {
    private String yLB = "";

    private static boolean aM(bi biVar) {
        AppMethodBeat.i(30934);
        e fI = o.ahl().fI(biVar.field_msgSvrId);
        if (fI.offset < fI.frO || fI.frO == 0) {
            AppMethodBeat.o(30934);
            return false;
        }
        AppMethodBeat.o(30934);
        return true;
    }

    public final void a(final T t, Context context, final a aVar) {
        AppMethodBeat.i(30937);
        String str = aVar.csG.field_msgId + " ";
        if (str.equals(this.yLB)) {
            t.makeText(context, context.getString(R.string.bna), 0).show();
            AppMethodBeat.o(30937);
            return;
        }
        Object obj;
        this.yLB = str;
        if (aVar.csG.bAA()) {
            b me = b.me(aVar.csG.field_content);
            if (me.type == 6 && !bo.isNullOrNil(me.fgu)) {
                final com.tencent.mm.pluginsdk.model.app.b d = l.d(aVar.csG, me.csD);
                if (!(d == null || (com.tencent.mm.vfs.e.ct(d.field_fileFullPath) && com.tencent.mm.vfs.e.asZ(d.field_fileFullPath) == d.field_totalLen))) {
                    g gVar = new g();
                    gVar.egl = new g.a() {
                        public final int a(String str, int i, c cVar, d dVar, boolean z) {
                            AppMethodBeat.i(30933);
                            if (i == 0 && cVar != null) {
                                d.field_offset = (long) cVar.field_finishedLength;
                                am.aUq().a(d, new String[0]);
                            }
                            if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                                d.field_status = 199;
                                d.field_offset = d.field_totalLen;
                                am.aUq().a(d, new String[0]);
                                aVar.csG.setStatus(3);
                                aw.ZK();
                                com.tencent.mm.model.c.XO().a(aVar.csG.field_msgId, aVar.csG);
                                new ak(Looper.getMainLooper()).post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(30932);
                                        ac.this.a(t, aVar);
                                        AppMethodBeat.o(30932);
                                    }
                                });
                            }
                            AppMethodBeat.o(30933);
                            return 0;
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] l(String str, byte[] bArr) {
                            return new byte[0];
                        }
                    };
                    gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), aVar.csG.field_talker, aVar.csG.field_msgId);
                    gVar.field_aesKey = me.eyr;
                    gVar.field_fileType = 19;
                    gVar.field_authKey = me.fgA;
                    gVar.egm = me.fgu;
                    if (d == null || bo.isNullOrNil(d.field_fileFullPath)) {
                        aw.ZK();
                        gVar.field_fullpath = l.X(com.tencent.mm.model.c.Ye(), me.title, me.fgp);
                    } else {
                        gVar.field_fullpath = d.field_fileFullPath;
                    }
                    if (!f.afx().b(gVar, -1)) {
                        ab.e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
                    }
                    AppMethodBeat.o(30937);
                    return;
                }
            } else if (me.type == 19) {
                com.tencent.mm.protocal.b.a.c VI = n.VI(me.fgU);
                HashSet hashSet = new HashSet();
                if (!(VI == null || VI.fjr == null)) {
                    Iterator it = VI.fjr.iterator();
                    while (it.hasNext()) {
                        T t2;
                        a aVar2;
                        aar aar = (aar) it.next();
                        String c = n.c(aar, aVar.csG.field_msgId);
                        if (!(bo.isNullOrNil(aar.whr) || com.tencent.mm.vfs.e.ct(c))) {
                            t2 = t;
                            aVar2 = aVar;
                            a(t2, aVar2, aar.whr, aar.who, aar.fgA, c, n.h(aar.mnd, aVar.csG.field_msgId, true), aVar.csG, hashSet);
                        }
                        c = n.f(aar, aVar.csG.field_msgId);
                        if (!(bo.isNullOrNil(aar.fgv) || com.tencent.mm.vfs.e.ct(c))) {
                            t2 = t;
                            aVar2 = aVar;
                            a(t2, aVar2, aar.fgv, aar.fgB, aar.fgA, c, n.h(n.LA(aar.mnd), aVar.csG.field_msgId, true), aVar.csG, hashSet);
                        }
                    }
                }
                if (!hashSet.isEmpty()) {
                    AppMethodBeat.o(30937);
                    return;
                }
            }
        }
        if (aVar.csG.drE()) {
            int i;
            e fI = o.ahl().fI(aVar.csG.field_msgSvrId);
            if (aVar.csG.field_isSend == 1) {
                int i2;
                if (fI.agQ()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i = i2;
            } else if (fI.agQ()) {
                if (com.tencent.mm.vfs.e.ct(o.ahl().q(com.tencent.mm.at.f.a(fI).fDz, "", ""))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (fI.offset < fI.frO || fI.frO == 0) {
                ab.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", Long.valueOf(aVar.csG.field_msgId));
                o.ahm().a(fI.fDy, aVar.csG.field_msgId, i, aVar.csG, R.drawable.b0p, new com.tencent.mm.at.d.a() {
                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
                    }

                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
                        AppMethodBeat.i(30930);
                        boolean z = i3 == 0 && i4 == 0;
                        ab.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", Boolean.valueOf(z), Long.valueOf(aVar.csG.field_msgId), Integer.valueOf(i3), Integer.valueOf(i4));
                        new ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(30929);
                                ac.this.a(t, aVar);
                                AppMethodBeat.o(30929);
                            }
                        });
                        AppMethodBeat.o(30930);
                    }

                    public final void a(long j, long j2, int i, int i2, Object obj) {
                        AppMethodBeat.i(30931);
                        ab.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", Long.valueOf(aVar.csG.field_msgId));
                        AppMethodBeat.o(30931);
                    }
                });
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.o(30937);
                return;
            }
        }
        if (aVar.csG.bws() || aVar.csG.bwt()) {
            s ut = u.ut(aVar.csG.field_imgPath);
            if (ut == null || ut.status == 199) {
                obj = null;
            } else {
                com.tencent.mm.modelvideo.o.all().a(new com.tencent.mm.modelvideo.t.a() {
                    public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
                        AppMethodBeat.i(30928);
                        if (aVar.csG.field_imgPath.equals(aVar.fileName)) {
                            s ut = u.ut(aVar.fileName);
                            if (ut == null || !ut.alz()) {
                                ab.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", Long.valueOf(aVar.csG.field_msgId), aVar.fileName);
                            } else {
                                ab.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", Long.valueOf(aVar.csG.field_msgId), aVar.fileName);
                                com.tencent.mm.modelvideo.o.all().a(this);
                                new ak(Looper.getMainLooper()).post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(30927);
                                        ac.this.a(t, aVar);
                                        AppMethodBeat.o(30927);
                                    }
                                });
                                AppMethodBeat.o(30928);
                                return;
                            }
                        }
                        AppMethodBeat.o(30928);
                    }
                }, Looper.getMainLooper());
                ab.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", Long.valueOf(aVar.csG.field_msgId), aVar.csG.field_imgPath);
                if (ut.aly()) {
                    ab.i("MicroMsg.FavMsgHandle", "start complete online video");
                    u.uA(aVar.csG.field_imgPath);
                } else {
                    ab.i("MicroMsg.FavMsgHandle", "start complete offline video");
                    u.up(aVar.csG.field_imgPath);
                }
                obj = 1;
            }
            if (obj != null) {
                AppMethodBeat.o(30937);
                return;
            }
        }
        this.yLB = "";
        a(t, aVar);
        AppMethodBeat.o(30937);
    }

    private void a(T t, a aVar, String str, String str2, String str3, String str4, String str5, bi biVar, HashSet<String> hashSet) {
        AppMethodBeat.i(30938);
        ab.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", Long.valueOf(biVar.field_msgId), str5, str4);
        hashSet.add(str5);
        g gVar = new g();
        gVar.field_fileType = 19;
        gVar.field_authKey = str3;
        gVar.field_aesKey = str2;
        gVar.egm = str;
        gVar.field_fullpath = str4;
        gVar.field_mediaId = str5;
        final bi biVar2 = biVar;
        final String str6 = str4;
        final HashSet<String> hashSet2 = hashSet;
        final T t2 = t;
        final a aVar2 = aVar;
        gVar.egl = new g.a() {
            public final int a(String str, int i, c cVar, d dVar, boolean z) {
                AppMethodBeat.i(30926);
                Object obj = null;
                if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                    ab.i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", Long.valueOf(biVar2.field_msgId), str, str6);
                    obj = 1;
                }
                if (!(i == 0 && (dVar == null || dVar.field_retCode == 0))) {
                    String str2 = "MicroMsg.FavMsgHandle";
                    String str3 = "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)";
                    Object[] objArr = new Object[5];
                    objArr[0] = Long.valueOf(biVar2.field_msgId);
                    objArr[1] = str;
                    objArr[2] = str6;
                    objArr[3] = Integer.valueOf(i);
                    objArr[4] = Integer.valueOf(dVar == null ? 0 : dVar.field_retCode);
                    ab.e(str2, str3, objArr);
                    obj = 1;
                }
                if (obj == null) {
                    AppMethodBeat.o(30926);
                    return 0;
                }
                hashSet2.remove(str);
                if (hashSet2.isEmpty()) {
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(30925);
                            ac.this.a(t2, aVar2);
                            AppMethodBeat.o(30925);
                        }
                    });
                }
                AppMethodBeat.o(30926);
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        if (!f.afx().b(gVar, -1)) {
            ab.e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
        }
        AppMethodBeat.o(30938);
    }

    /* Access modifiers changed, original: final */
    public final void a(T t, a aVar) {
        AppMethodBeat.i(30939);
        this.yLB = "";
        cl clVar = new cl();
        com.tencent.mm.pluginsdk.model.e.d(clVar, aVar.csG);
        if (t instanceof MMFragment) {
            clVar.cvA.fragment = (MMFragment) t;
        } else if (t instanceof Activity) {
            clVar.cvA.activity = (Activity) t;
        }
        clVar.cvA.cvH = 43;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        if (clVar.cvB.ret == 0) {
            if (aVar.csG.bAA()) {
                com.tencent.mm.modelstat.b.fRa.b(aVar.csG, k.k(aVar.csG));
            } else {
                com.tencent.mm.modelstat.b.fRa.D(aVar.csG);
            }
            if (aVar.csG.bAA() || aVar.csG.drC()) {
                String nW = v.nW(aVar.csG.field_msgSvrId);
                v.b y = v.Zp().y(nW, true);
                y.j("prePublishId", "msg_" + aVar.csG.field_msgSvrId);
                y.j("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(aVar.csG, aVar.mgQ, aVar.mgP));
                y.j("preChatName", aVar.talker);
                y.j("preMsgIndex", Integer.valueOf(0));
                y.j("sendAppMsgScene", Integer.valueOf(1));
                ((i) com.tencent.mm.kernel.g.K(i.class)).a("adExtStr", y, aVar.csG);
                clVar.cvA.cvF = nW;
            }
            b me = b.me(bo.anj(aVar.csG.field_content));
            if (!(me == null || me.type != 5 || me.url == null)) {
                long anT = bo.anT();
                ab.d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                String str = "";
                try {
                    str = URLEncoder.encode(me.url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.FavMsgHandle", e, "", new Object[0]);
                }
                h.pYm.e(13378, str, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
            }
            if (aVar.mgR != null) {
                aVar.mgR.bvs();
            }
            a.a(a.c.Fav, a.d.Samll, aVar.csG, 0);
        }
        AppMethodBeat.o(30939);
    }

    private static boolean aN(bi biVar) {
        AppMethodBeat.i(30935);
        s ut = u.ut(biVar.field_imgPath);
        if (ut == null || ut.status == 199) {
            AppMethodBeat.o(30935);
            return true;
        }
        AppMethodBeat.o(30935);
        return false;
    }

    public static boolean aO(bi biVar) {
        AppMethodBeat.i(30936);
        if (ad.aox(biVar.field_talker) || ad.aox(bf.oy(biVar.field_content))) {
            if (biVar.bAA()) {
                b me = b.me(biVar.field_content);
                if (me.type == 6 && !bo.isNullOrNil(me.fgu)) {
                    com.tencent.mm.pluginsdk.model.app.b d = l.d(biVar, me.csD);
                    if (!(d == null || (com.tencent.mm.vfs.e.ct(d.field_fileFullPath) && com.tencent.mm.vfs.e.asZ(d.field_fileFullPath) == d.field_totalLen))) {
                        AppMethodBeat.o(30936);
                        return false;
                    }
                } else if (me.type == 19) {
                    Iterator it = n.VI(me.fgU).fjr.iterator();
                    while (it.hasNext()) {
                        aar aar = (aar) it.next();
                        String c = n.c(aar, biVar.field_msgId);
                        if (bo.isNullOrNil(aar.whr) || com.tencent.mm.vfs.e.ct(c)) {
                            c = n.f(aar, biVar.field_msgId);
                            if (!bo.isNullOrNil(aar.fgv) && !com.tencent.mm.vfs.e.ct(c)) {
                                AppMethodBeat.o(30936);
                                return false;
                            }
                        } else {
                            AppMethodBeat.o(30936);
                            return false;
                        }
                    }
                }
            }
            if (biVar.drE() && !aM(biVar)) {
                AppMethodBeat.o(30936);
                return false;
            } else if ((biVar.bws() || biVar.bwt()) && !aN(biVar)) {
                AppMethodBeat.o(30936);
                return false;
            } else {
                AppMethodBeat.o(30936);
                return true;
            }
        }
        AppMethodBeat.o(30936);
        return true;
    }
}
