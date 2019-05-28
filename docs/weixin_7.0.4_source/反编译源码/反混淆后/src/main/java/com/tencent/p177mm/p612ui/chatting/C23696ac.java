package com.tencent.p177mm.p612ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.chatting.C40707a.C23688d;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40706c;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.plugin.fav.p408b.p969c.C43061a;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.chatting.ac */
public final class C23696ac<T> {
    private String yLB = "";

    /* renamed from: aM */
    private static boolean m36533aM(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30934);
        C25822e fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
        if (fI.offset < fI.frO || fI.frO == 0) {
            AppMethodBeat.m2505o(30934);
            return false;
        }
        AppMethodBeat.m2505o(30934);
        return true;
    }

    /* renamed from: a */
    public final void mo39529a(final T t, Context context, final C43061a c43061a) {
        AppMethodBeat.m2504i(30937);
        String str = c43061a.csG.field_msgId + " ";
        if (str.equals(this.yLB)) {
            C23639t.makeText(context, context.getString(C25738R.string.bna), 0).show();
            AppMethodBeat.m2505o(30937);
            return;
        }
        Object obj;
        this.yLB = str;
        if (c43061a.csG.bAA()) {
            C8910b me = C8910b.m16064me(c43061a.csG.field_content);
            if (me.type == 6 && !C5046bo.isNullOrNil(me.fgu)) {
                final C30065b d = C4733l.m7101d(c43061a.csG, me.csD);
                if (!(d == null || (C5730e.m8628ct(d.field_fileFullPath) && C5730e.asZ(d.field_fileFullPath) == d.field_totalLen))) {
                    C42130g c42130g = new C42130g();
                    c42130g.egl = new C1628a() {

                        /* renamed from: com.tencent.mm.ui.chatting.ac$4$1 */
                        class C155741 implements Runnable {
                            C155741() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(30932);
                                C23696ac.this.mo39530a(t, c43061a);
                                AppMethodBeat.m2505o(30932);
                            }
                        }

                        /* renamed from: a */
                        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                            AppMethodBeat.m2504i(30933);
                            if (i == 0 && c18496c != null) {
                                d.field_offset = (long) c18496c.field_finishedLength;
                                C14877am.aUq().mo48326a(d, new String[0]);
                            }
                            if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                                d.field_status = 199;
                                d.field_offset = d.field_totalLen;
                                C14877am.aUq().mo48326a(d, new String[0]);
                                c43061a.csG.setStatus(3);
                                C9638aw.m17190ZK();
                                C18628c.m29080XO().mo15284a(c43061a.csG.field_msgId, c43061a.csG);
                                new C7306ak(Looper.getMainLooper()).post(new C155741());
                            }
                            AppMethodBeat.m2505o(30933);
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
                    c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), c43061a.csG.field_talker, c43061a.csG.field_msgId);
                    c42130g.field_aesKey = me.eyr;
                    c42130g.field_fileType = 19;
                    c42130g.field_authKey = me.fgA;
                    c42130g.egm = me.fgu;
                    if (d == null || C5046bo.isNullOrNil(d.field_fileFullPath)) {
                        C9638aw.m17190ZK();
                        c42130g.field_fullpath = C4733l.m7083X(C18628c.m29096Ye(), me.title, me.fgp);
                    } else {
                        c42130g.field_fullpath = d.field_fileFullPath;
                    }
                    if (!C37461f.afx().mo51222b(c42130g, -1)) {
                        C4990ab.m7412e("MicroMsg.FavMsgHandle", "openim attach download failed before rescend");
                    }
                    AppMethodBeat.m2505o(30937);
                    return;
                }
            } else if (me.type == 19) {
                C44099c VI = C43436n.m77547VI(me.fgU);
                HashSet hashSet = new HashSet();
                if (!(VI == null || VI.fjr == null)) {
                    Iterator it = VI.fjr.iterator();
                    while (it.hasNext()) {
                        T t2;
                        C43061a c43061a2;
                        aar aar = (aar) it.next();
                        String c = C43436n.m77558c(aar, c43061a.csG.field_msgId);
                        if (!(C5046bo.isNullOrNil(aar.whr) || C5730e.m8628ct(c))) {
                            t2 = t;
                            c43061a2 = c43061a;
                            m36532a(t2, c43061a2, aar.whr, aar.who, aar.fgA, c, C43436n.m77564h(aar.mnd, c43061a.csG.field_msgId, true), c43061a.csG, hashSet);
                        }
                        c = C43436n.m77562f(aar, c43061a.csG.field_msgId);
                        if (!(C5046bo.isNullOrNil(aar.fgv) || C5730e.m8628ct(c))) {
                            t2 = t;
                            c43061a2 = c43061a;
                            m36532a(t2, c43061a2, aar.fgv, aar.fgB, aar.fgA, c, C43436n.m77564h(C43436n.m77546LA(aar.mnd), c43061a.csG.field_msgId, true), c43061a.csG, hashSet);
                        }
                    }
                }
                if (!hashSet.isEmpty()) {
                    AppMethodBeat.m2505o(30937);
                    return;
                }
            }
        }
        if (c43061a.csG.drE()) {
            int i;
            C25822e fI = C32291o.ahl().mo73112fI(c43061a.csG.field_msgSvrId);
            if (c43061a.csG.field_isSend == 1) {
                int i2;
                if (fI.agQ()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i = i2;
            } else if (fI.agQ()) {
                if (C5730e.m8628ct(C32291o.ahl().mo73118q(C37478f.m63225a(fI).fDz, "", ""))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (fI.offset < fI.frO || fI.frO == 0) {
                C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav start  msgID:%d", Long.valueOf(c43061a.csG.field_msgId));
                C32291o.ahm().mo33467a(fI.fDy, c43061a.csG.field_msgId, i, c43061a.csG, C25738R.drawable.b0p, new C9017a() {

                    /* renamed from: com.tencent.mm.ui.chatting.ac$3$1 */
                    class C236931 implements Runnable {
                        C236931() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(30929);
                            C23696ac.this.mo39530a(t, c43061a);
                            AppMethodBeat.m2505o(30929);
                        }
                    }

                    /* renamed from: a */
                    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
                    }

                    /* renamed from: a */
                    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(30930);
                        boolean z = i3 == 0 && i4 == 0;
                        C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", Boolean.valueOf(z), Long.valueOf(c43061a.csG.field_msgId), Integer.valueOf(i3), Integer.valueOf(i4));
                        new C7306ak(Looper.getMainLooper()).post(new C236931());
                        AppMethodBeat.m2505o(30930);
                    }

                    /* renamed from: a */
                    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
                        AppMethodBeat.m2504i(30931);
                        C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", Long.valueOf(c43061a.csG.field_msgId));
                        AppMethodBeat.m2505o(30931);
                    }
                });
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(30937);
                return;
            }
        }
        if (c43061a.csG.bws() || c43061a.csG.bwt()) {
            C26493s ut = C26494u.m42268ut(c43061a.csG.field_imgPath);
            if (ut == null || ut.status == 199) {
                obj = null;
            } else {
                C37961o.all().mo21053a(new C9721a() {

                    /* renamed from: com.tencent.mm.ui.chatting.ac$2$1 */
                    class C236921 implements Runnable {
                        C236921() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(30927);
                            C23696ac.this.mo39530a(t, c43061a);
                            AppMethodBeat.m2505o(30927);
                        }
                    }

                    /* renamed from: a */
                    public final void mo11381a(C9718a c9718a) {
                        AppMethodBeat.m2504i(30928);
                        if (c43061a.csG.field_imgPath.equals(c9718a.fileName)) {
                            C26493s ut = C26494u.m42268ut(c9718a.fileName);
                            if (ut == null || !ut.alz()) {
                                C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", Long.valueOf(c43061a.csG.field_msgId), c9718a.fileName);
                            } else {
                                C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", Long.valueOf(c43061a.csG.field_msgId), c9718a.fileName);
                                C37961o.all().mo21052a(this);
                                new C7306ak(Looper.getMainLooper()).post(new C236921());
                                AppMethodBeat.m2505o(30928);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(30928);
                    }
                }, Looper.getMainLooper());
                C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", Long.valueOf(c43061a.csG.field_msgId), c43061a.csG.field_imgPath);
                if (ut.aly()) {
                    C4990ab.m7416i("MicroMsg.FavMsgHandle", "start complete online video");
                    C26494u.m42259uA(c43061a.csG.field_imgPath);
                } else {
                    C4990ab.m7416i("MicroMsg.FavMsgHandle", "start complete offline video");
                    C26494u.m42264up(c43061a.csG.field_imgPath);
                }
                obj = 1;
            }
            if (obj != null) {
                AppMethodBeat.m2505o(30937);
                return;
            }
        }
        this.yLB = "";
        mo39530a(t, c43061a);
        AppMethodBeat.m2505o(30937);
    }

    /* renamed from: a */
    private void m36532a(T t, C43061a c43061a, String str, String str2, String str3, String str4, String str5, C7620bi c7620bi, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(30938);
        C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", Long.valueOf(c7620bi.field_msgId), str5, str4);
        hashSet.add(str5);
        C42130g c42130g = new C42130g();
        c42130g.field_fileType = 19;
        c42130g.field_authKey = str3;
        c42130g.field_aesKey = str2;
        c42130g.egm = str;
        c42130g.field_fullpath = str4;
        c42130g.field_mediaId = str5;
        final C7620bi c7620bi2 = c7620bi;
        final String str6 = str4;
        final HashSet<String> hashSet2 = hashSet;
        final T t2 = t;
        final C43061a c43061a2 = c43061a;
        c42130g.egl = new C1628a() {

            /* renamed from: com.tencent.mm.ui.chatting.ac$1$1 */
            class C236911 implements Runnable {
                C236911() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(30925);
                    C23696ac.this.mo39530a(t2, c43061a2);
                    AppMethodBeat.m2505o(30925);
                }
            }

            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                AppMethodBeat.m2504i(30926);
                Object obj = null;
                if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                    C4990ab.m7417i("MicroMsg.FavMsgHandle", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", Long.valueOf(c7620bi2.field_msgId), str, str6);
                    obj = 1;
                }
                if (!(i == 0 && (c9545d == null || c9545d.field_retCode == 0))) {
                    String str2 = "MicroMsg.FavMsgHandle";
                    String str3 = "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)";
                    Object[] objArr = new Object[5];
                    objArr[0] = Long.valueOf(c7620bi2.field_msgId);
                    objArr[1] = str;
                    objArr[2] = str6;
                    objArr[3] = Integer.valueOf(i);
                    objArr[4] = Integer.valueOf(c9545d == null ? 0 : c9545d.field_retCode);
                    C4990ab.m7413e(str2, str3, objArr);
                    obj = 1;
                }
                if (obj == null) {
                    AppMethodBeat.m2505o(30926);
                    return 0;
                }
                hashSet2.remove(str);
                if (hashSet2.isEmpty()) {
                    new C7306ak(Looper.getMainLooper()).post(new C236911());
                }
                AppMethodBeat.m2505o(30926);
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
        if (!C37461f.afx().mo51222b(c42130g, -1)) {
            C4990ab.m7412e("MicroMsg.FavMsgHandle", "recv openim record, add task failed");
        }
        AppMethodBeat.m2505o(30938);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo39530a(T t, C43061a c43061a) {
        AppMethodBeat.m2504i(30939);
        this.yLB = "";
        C45316cl c45316cl = new C45316cl();
        C40443e.m69377d(c45316cl, c43061a.csG);
        if (t instanceof MMFragment) {
            c45316cl.cvA.fragment = (MMFragment) t;
        } else if (t instanceof Activity) {
            c45316cl.cvA.activity = (Activity) t;
        }
        c45316cl.cvA.cvH = 43;
        C4879a.xxA.mo10055m(c45316cl);
        if (c45316cl.cvB.ret == 0) {
            if (c43061a.csG.bAA()) {
                C45457b.fRa.mo73261b(c43061a.csG, C1191k.m2615k(c43061a.csG));
            } else {
                C45457b.fRa.mo73248D(c43061a.csG);
            }
            if (c43061a.csG.bAA() || c43061a.csG.drC()) {
                String nW = C37922v.m64078nW(c43061a.csG.field_msgSvrId);
                C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                y.mo53356j("prePublishId", "msg_" + c43061a.csG.field_msgSvrId);
                y.mo53356j("preUsername", C5378c.m8122a(c43061a.csG, c43061a.mgQ, c43061a.mgP));
                y.mo53356j("preChatName", c43061a.talker);
                y.mo53356j("preMsgIndex", Integer.valueOf(0));
                y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                ((C46210i) C1720g.m3528K(C46210i.class)).mo55530a("adExtStr", y, c43061a.csG);
                c45316cl.cvA.cvF = nW;
            }
            C8910b me = C8910b.m16064me(C5046bo.anj(c43061a.csG.field_content));
            if (!(me == null || me.type != 5 || me.url == null)) {
                long anT = C5046bo.anT();
                C4990ab.m7411d("MicroMsg.FavMsgHandle", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                String str = "";
                try {
                    str = URLEncoder.encode(me.url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.FavMsgHandle", e, "", new Object[0]);
                }
                C7060h.pYm.mo8381e(13378, str, Long.valueOf(anT), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
            }
            if (c43061a.mgR != null) {
                c43061a.mgR.bvs();
            }
            C40707a.m70380a(C40706c.Fav, C23688d.Samll, c43061a.csG, 0);
        }
        AppMethodBeat.m2505o(30939);
    }

    /* renamed from: aN */
    private static boolean m36534aN(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30935);
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        if (ut == null || ut.status == 199) {
            AppMethodBeat.m2505o(30935);
            return true;
        }
        AppMethodBeat.m2505o(30935);
        return false;
    }

    /* renamed from: aO */
    public static boolean m36535aO(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30936);
        if (C7616ad.aox(c7620bi.field_talker) || C7616ad.aox(C1829bf.m3762oy(c7620bi.field_content))) {
            if (c7620bi.bAA()) {
                C8910b me = C8910b.m16064me(c7620bi.field_content);
                if (me.type == 6 && !C5046bo.isNullOrNil(me.fgu)) {
                    C30065b d = C4733l.m7101d(c7620bi, me.csD);
                    if (!(d == null || (C5730e.m8628ct(d.field_fileFullPath) && C5730e.asZ(d.field_fileFullPath) == d.field_totalLen))) {
                        AppMethodBeat.m2505o(30936);
                        return false;
                    }
                } else if (me.type == 19) {
                    Iterator it = C43436n.m77547VI(me.fgU).fjr.iterator();
                    while (it.hasNext()) {
                        aar aar = (aar) it.next();
                        String c = C43436n.m77558c(aar, c7620bi.field_msgId);
                        if (C5046bo.isNullOrNil(aar.whr) || C5730e.m8628ct(c)) {
                            c = C43436n.m77562f(aar, c7620bi.field_msgId);
                            if (!C5046bo.isNullOrNil(aar.fgv) && !C5730e.m8628ct(c)) {
                                AppMethodBeat.m2505o(30936);
                                return false;
                            }
                        } else {
                            AppMethodBeat.m2505o(30936);
                            return false;
                        }
                    }
                }
            }
            if (c7620bi.drE() && !C23696ac.m36533aM(c7620bi)) {
                AppMethodBeat.m2505o(30936);
                return false;
            } else if ((c7620bi.bws() || c7620bi.bwt()) && !C23696ac.m36534aN(c7620bi)) {
                AppMethodBeat.m2505o(30936);
                return false;
            } else {
                AppMethodBeat.m2505o(30936);
                return true;
            }
        }
        AppMethodBeat.m2505o(30936);
        return true;
    }
}
