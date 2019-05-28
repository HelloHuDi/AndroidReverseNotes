package com.tencent.p177mm.modelvideo;

import android.content.ContentValues;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C18709m.C187073;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.modelvideo.u */
public final class C26494u {
    /* renamed from: ul */
    public static boolean m42260ul(String str) {
        AppMethodBeat.m2504i(50821);
        if (str == null) {
            AppMethodBeat.m2505o(50821);
            return false;
        }
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null) {
            AppMethodBeat.m2505o(50821);
            return false;
        } else if (ut.fXf >= 2500) {
            AppMethodBeat.m2505o(50821);
            return false;
        } else {
            ut.fXf++;
            ut.bJt = 16384;
            boolean f = C26494u.m42253f(ut);
            AppMethodBeat.m2505o(50821);
            return f;
        }
    }

    /* renamed from: um */
    public static boolean m42261um(String str) {
        AppMethodBeat.m2504i(50822);
        C7060h.pYm.mo8378a(111, 218, 1, false);
        C4990ab.m7421w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", str, C5046bo.dpG());
        C37961o.alq().mo44283uC(str);
        if (str == null) {
            AppMethodBeat.m2505o(50822);
            return false;
        }
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(50822);
            return false;
        }
        ut.status = C27011o.CTRL_INDEX;
        ut.fXb = System.currentTimeMillis() / 1000;
        ut.bJt = ActUtil.HEIGHT;
        baa baa = ut.fXn;
        baa.wDQ = 0;
        ut.fXn = baa;
        boolean f = C26494u.m42253f(ut);
        C4990ab.m7410d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + ut.fXe + " old stat:" + ut.status);
        if (ut == null || ut.fXe == 0) {
            AppMethodBeat.m2505o(50822);
            return f;
        }
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut.fXe);
        int type = jf.getType();
        C4990ab.m7417i("MicroMsg.VideoLogic", "set error, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            C7053e.pXa.mo8378a(111, 32, 1, true);
            jf.mo14794ju(ut.getUser());
            jf.setContent(C37963q.m64228d(ut.alt(), -1, true));
            C4990ab.m7410d("MicroMsg.VideoLogic", "[oneliang][setError]");
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(jf.field_msgId, jf);
            AppMethodBeat.m2505o(50822);
            return f;
        }
        AppMethodBeat.m2505o(50822);
        return f;
    }

    /* renamed from: un */
    public static boolean m42262un(String str) {
        AppMethodBeat.m2504i(50823);
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null || ut.fXe == 0) {
            AppMethodBeat.m2505o(50823);
            return false;
        }
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut.fXe);
        int type = jf.getType();
        C4990ab.m7417i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            jf.setContent(C37963q.m64228d(ut.alt(), (long) ut.fXd, false));
            jf.setStatus(2);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) ut.fXe, jf);
            ut.status = 197;
            ut.fXb = C5046bo.anT();
            ut.bJt = ActUtil.HEIGHT;
            C4990ab.m7410d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
            boolean f = C26494u.m42253f(ut);
            AppMethodBeat.m2505o(50823);
            return f;
        }
        AppMethodBeat.m2505o(50823);
        return false;
    }

    /* renamed from: a */
    public static boolean m42239a(String str, int i, String str2, String str3, int i2, String str4, int i3) {
        AppMethodBeat.m2504i(50825);
        boolean a = C26494u.m42240a(str, i, str2, str3, i2, str4, i3, null, "");
        AppMethodBeat.m2505o(50825);
        return a;
    }

    /* renamed from: a */
    public static boolean m42240a(String str, int i, String str2, String str3, int i2, String str4, int i3, cfh cfh, String str5) {
        AppMethodBeat.m2504i(50826);
        C26493s c26493s = new C26493s();
        c26493s.fileName = str;
        c26493s.fXd = i;
        c26493s.cIS = str2;
        c26493s.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        c26493s.createTime = C5046bo.anT();
        c26493s.fXb = C5046bo.anT();
        c26493s.fXj = str4;
        c26493s.fUG = str3;
        c26493s.fXm = cfh;
        c26493s.cMn = str5;
        if (!C5046bo.isNullOrNil(str3)) {
            c26493s.fXh = 1;
        }
        if (i2 > 0) {
            c26493s.fXh = 1;
        }
        if (62 == i3) {
            c26493s.fXk = 3;
        } else if (i2 > 0) {
            c26493s.fXk = 2;
        } else {
            c26493s.fXk = 1;
        }
        C37961o.all();
        int uj = C9720t.m17305uj(C9720t.m17303uh(str));
        if (uj <= 0) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(50826);
            return false;
        }
        c26493s.frO = uj;
        C37961o.all();
        String ui = C9720t.m17304ui(str);
        int uj2 = C9720t.m17305uj(ui);
        if (uj2 <= 0) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "get Thumb size failed :" + ui + " size:" + uj2);
            AppMethodBeat.m2505o(50826);
            return false;
        }
        c26493s.fXa = uj2;
        C4990ab.m7416i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + c26493s.fXa + " videosize:" + c26493s.frO + " msgType:" + i3);
        c26493s.status = 102;
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju(c26493s.getUser());
        c7620bi.setType(i3);
        c7620bi.mo14781hO(1);
        c7620bi.mo14795jv(str);
        c7620bi.setStatus(1);
        c7620bi.mo14775eJ(C1829bf.m3756oC(c26493s.getUser()));
        c26493s.fXe = (int) C1829bf.m3752l(c7620bi);
        boolean b = C37961o.all().mo21059b(c26493s);
        AppMethodBeat.m2505o(50826);
        return b;
    }

    /* renamed from: d */
    public static boolean m42248d(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(50827);
        C26493s c26493s = new C26493s();
        c26493s.fileName = str;
        c26493s.fXd = i;
        c26493s.cIS = str2;
        c26493s.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        c26493s.createTime = C5046bo.anT();
        c26493s.fXb = C5046bo.anT();
        c26493s.fXj = str3;
        c26493s.fXk = 1;
        C37961o.all();
        c26493s.frO = C9720t.m17305uj(C9720t.m17303uh(str));
        C37961o.all();
        c26493s.fXa = C9720t.m17305uj(C9720t.m17304ui(str));
        C4990ab.m7416i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + c26493s.fXa + " videosize:" + c26493s.frO + " msgType:43");
        c26493s.status = 102;
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju(c26493s.getUser());
        c7620bi.setType(43);
        c7620bi.mo14781hO(1);
        c7620bi.mo14795jv(str);
        c7620bi.setStatus(1);
        c7620bi.mo14775eJ(C1829bf.m3756oC(c26493s.getUser()));
        c26493s.fXe = (int) C1829bf.m3752l(c7620bi);
        boolean b = C37961o.all().mo21059b(c26493s);
        AppMethodBeat.m2505o(50827);
        return b;
    }

    /* renamed from: a */
    public static long m42238a(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(50828);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7421w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(50828);
            return -1;
        } else if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7421w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(50828);
            return -1;
        } else {
            int i2;
            C26493s c26493s;
            C26493s c26493s2 = new C26493s();
            c26493s2.fileName = str;
            c26493s2.fXd = 1;
            c26493s2.cIS = str2;
            c26493s2.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
            c26493s2.createTime = C5046bo.anT();
            c26493s2.fXb = C5046bo.anT();
            c26493s2.fXj = null;
            c26493s2.fUG = str3;
            if (!C5046bo.isNullOrNil(str3)) {
                c26493s2.fXh = 1;
            }
            if (62 == i) {
                c26493s2.fXh = 0;
                i2 = 3;
                c26493s = c26493s2;
            } else if (c26493s2.fXh == 0) {
                i2 = 1;
                c26493s = c26493s2;
            } else {
                i2 = -1;
                c26493s = c26493s2;
            }
            c26493s.fXk = i2;
            c26493s2.frO = 0;
            c26493s2.status = 106;
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo14794ju(c26493s2.getUser());
            c7620bi.setType(i);
            c7620bi.mo14781hO(1);
            c7620bi.mo14795jv(str);
            c7620bi.setStatus(8);
            c7620bi.mo14775eJ(C1829bf.m3756oC(c26493s2.getUser()));
            long l = C1829bf.m3752l(c7620bi);
            c26493s2.fXe = (int) l;
            if (C37961o.all().mo21059b(c26493s2)) {
                AppMethodBeat.m2505o(50828);
                return l;
            }
            AppMethodBeat.m2505o(50828);
            return -1;
        }
    }

    /* renamed from: t */
    public static long m42258t(String str, String str2, String str3) {
        AppMethodBeat.m2504i(50829);
        long a = C26494u.m42238a(str, str2, str3, 43);
        AppMethodBeat.m2505o(50829);
        return a;
    }

    /* renamed from: n */
    public static void m42257n(String str, int i, int i2) {
        AppMethodBeat.m2504i(50830);
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null) {
            C4990ab.m7421w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", str, Integer.valueOf(i2));
            AppMethodBeat.m2505o(50830);
            return;
        }
        C37961o.all();
        C4990ab.m7417i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", Integer.valueOf(C9720t.m17305uj(C9720t.m17303uh(str))), Integer.valueOf(i2));
        ut.frO = r0;
        ut.fXd = i;
        baa baa = ut.fXn;
        baa.wDO = false;
        ut.fXn = baa;
        ut.status = 102;
        C37961o.all();
        ut.fXa = C9720t.m17305uj(C9720t.m17304ui(str));
        C4990ab.m7416i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + ut.fXa);
        ut.bJt = 4512;
        C4990ab.m7417i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", Boolean.valueOf(C26494u.m42253f(ut)), Integer.valueOf(i2));
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut.fXe);
        C4990ab.m7417i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), jf.field_talker, Integer.valueOf(jf.getType()), Integer.valueOf(jf.field_isSend), jf.field_imgPath, Integer.valueOf(jf.field_status), Long.valueOf(jf.field_createTime));
        jf.mo14794ju(ut.getUser());
        jf.setType(i2);
        jf.mo14781hO(1);
        jf.mo14795jv(str);
        jf.setStatus(1);
        C4990ab.m7417i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), jf.field_talker, Integer.valueOf(jf.getType()), Integer.valueOf(jf.field_isSend), jf.field_imgPath, Integer.valueOf(jf.field_status), Long.valueOf(jf.field_createTime));
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) ut.fXe, jf);
        AppMethodBeat.m2505o(50830);
    }

    /* renamed from: uo */
    public static int m42263uo(String str) {
        AppMethodBeat.m2504i(50831);
        C26493s ut = C26494u.m42268ut(str);
        int line;
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50831);
            return line;
        } else if (ut.status == 102 || ut.status == 105) {
            int i = ut.status;
            if (ut.status == 102 || ut.fXa != ut.fWZ) {
                ut.status = 103;
            } else {
                ut.status = 104;
            }
            C4990ab.m7410d("MicroMsg.VideoLogic", C1447g.m3075Mq() + "startSend file:" + str + " status:[" + i + "->" + ut.status + "]");
            ut.fXc = C5046bo.anT();
            ut.fXb = C5046bo.anT();
            ut.bJt = 3328;
            if (C26494u.m42253f(ut)) {
                C37961o.alq().run();
                AppMethodBeat.m2505o(50831);
                return 0;
            }
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " update failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50831);
            return line;
        } else {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50831);
            return line;
        }
    }

    /* renamed from: fV */
    public static int m42254fV(long j) {
        AppMethodBeat.m2504i(50832);
        for (C26493s c26493s : C37961o.all().mo21061fU(j)) {
            int i = c26493s.status;
            c26493s.status = 200;
            C4990ab.m7410d("MicroMsg.VideoLogic", C1447g.m3075Mq() + "startSend file:" + c26493s.getFileName() + " status:[" + i + "->" + c26493s.status + "]");
            c26493s.fXc = C5046bo.anT();
            c26493s.fXb = C5046bo.anT();
            c26493s.bJt = 3328;
            if (!C26494u.m42253f(c26493s)) {
                C4990ab.m7412e("MicroMsg.VideoLogic", "ERR on start MassSend:" + C1447g.m3075Mq() + " update failed: " + c26493s.getFileName());
                int line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(50832);
                return line;
            }
        }
        C1720g.m3539RS().mo10302aa(new C187073());
        AppMethodBeat.m2505o(50832);
        return 0;
    }

    /* renamed from: d */
    public static void m42247d(C26493s c26493s) {
        AppMethodBeat.m2504i(50833);
        if (c26493s == null) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "video info is null");
            AppMethodBeat.m2505o(50833);
            return;
        }
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) c26493s.fXe);
        int type = jf.getType();
        C4990ab.m7417i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            jf.mo14781hO(1);
            jf.mo14794ju(c26493s.getUser());
            jf.mo14774eI(c26493s.cKK);
            jf.setStatus(2);
            jf.setContent(C37963q.m64228d(c26493s.alt(), (long) c26493s.fXd, false));
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) c26493s.fXe, jf);
            C4990ab.m7411d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", Long.valueOf(jf.field_msgId));
            AppMethodBeat.m2505o(50833);
            return;
        }
        AppMethodBeat.m2505o(50833);
    }

    /* renamed from: e */
    static boolean m42250e(C26493s c26493s) {
        AppMethodBeat.m2504i(50834);
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) c26493s.fXe);
        int type = jf.getType();
        C4990ab.m7417i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            jf.mo14774eI(c26493s.cKK);
            jf.setContent(C37963q.m64228d(c26493s.alt(), (long) c26493s.fXd, false));
            jf.mo14794ju(c26493s.getUser());
            C4990ab.m7410d("MicroMsg.VideoLogic", "set msg content :" + jf.field_content);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(c26493s.cKK, jf);
            C4990ab.m7411d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", Long.valueOf(jf.field_msgId));
            if (jf.bwt()) {
                C4990ab.m7417i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", Integer.valueOf(c26493s.frO));
            }
            AppMethodBeat.m2505o(50834);
            return true;
        }
        AppMethodBeat.m2505o(50834);
        return false;
    }

    /* renamed from: up */
    public static int m42264up(String str) {
        AppMethodBeat.m2504i(50835);
        C26493s ut = C26494u.m42268ut(str);
        int line;
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50835);
            return line;
        } else if (ut.status == 111 || ut.status == 113 || ut.status == 121 || ut.status == 122 || ut.status == 123) {
            ut.status = 112;
            ut.fXc = C5046bo.anT();
            ut.fXb = C5046bo.anT();
            ut.bJt = 3328;
            if (C26494u.m42253f(ut)) {
                C37961o.alq().alG();
                C37961o.alq().run();
                AppMethodBeat.m2505o(50835);
                return 0;
            }
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " update failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50835);
            return line;
        } else {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50835);
            return line;
        }
    }

    /* renamed from: uq */
    public static int m42265uq(String str) {
        AppMethodBeat.m2504i(50836);
        C26493s ut = C26494u.m42268ut(str);
        int line;
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50836);
            return line;
        } else if (ut.status == 112 || ut.status == 120 || ut.status == 122 || ut.status == 123) {
            ut.status = 113;
            ut.fXb = C5046bo.anT();
            ut.bJt = ActUtil.HEIGHT;
            if (C26494u.m42253f(ut)) {
                AppMethodBeat.m2505o(50836);
                return 0;
            }
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " update failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50836);
            return line;
        } else {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50836);
            return line;
        }
    }

    /* renamed from: ae */
    public static boolean m42242ae(String str, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(50837);
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
            AppMethodBeat.m2505o(50837);
            return false;
        }
        if (i != ut.frO) {
            C4990ab.m7421w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", Integer.valueOf(i), Integer.valueOf(ut.frO));
            ut.frO = i;
            i2 = 32;
        }
        ut.fWY = i;
        ut.fXb = C5046bo.anT();
        C26494u.m42250e(ut);
        ut.status = 199;
        ut.bJt = i2 | 1296;
        boolean f = C26494u.m42253f(ut);
        C4990ab.m7416i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i + " total:" + ut.frO + " status:" + ut.status + " netTimes:" + ut.fXf + " update ret: " + f);
        AppMethodBeat.m2505o(50837);
        return f;
    }

    /* renamed from: ur */
    public static boolean m42266ur(String str) {
        AppMethodBeat.m2504i(50838);
        C4990ab.m7416i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(str)));
        C26493s c26493s = new C26493s();
        c26493s.status = 112;
        c26493s.fXb = C5046bo.anT();
        c26493s.fXc = C5046bo.anT();
        c26493s.fileName = str;
        c26493s.bJt = 3328;
        if (C26494u.m42253f(c26493s)) {
            C37961o.alq().run();
            AppMethodBeat.m2505o(50838);
            return true;
        }
        AppMethodBeat.m2505o(50838);
        return false;
    }

    /* renamed from: us */
    public static boolean m42267us(String str) {
        AppMethodBeat.m2504i(50839);
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null) {
            AppMethodBeat.m2505o(50839);
            return false;
        }
        C4990ab.m7417i("MicroMsg.VideoLogic", "rsetMsgSend %s", str);
        baa baa = ut.fXn;
        if (baa != null) {
            baa.wDQ = 0;
            ut.fXn = baa;
        }
        if (ut.fWZ < ut.fXa) {
            ut.status = 103;
        } else {
            ut.status = 104;
        }
        ut.createTime = C5046bo.anT();
        ut.fXb = C5046bo.anT();
        ut.fXc = C5046bo.anT();
        ut.bJt = 536874752;
        if (C26494u.m42253f(ut)) {
            C37961o.alq().run();
            AppMethodBeat.m2505o(50839);
            return true;
        }
        AppMethodBeat.m2505o(50839);
        return false;
    }

    /* renamed from: ut */
    public static C26493s m42268ut(String str) {
        AppMethodBeat.m2504i(50840);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50840);
            return null;
        }
        C26493s uf = C37961o.all().mo21063uf(str);
        AppMethodBeat.m2505o(50840);
        return uf;
    }

    /* renamed from: f */
    public static boolean m42253f(C26493s c26493s) {
        AppMethodBeat.m2504i(50841);
        if (c26493s == null) {
            AppMethodBeat.m2505o(50841);
            return false;
        } else if ((c26493s.getFileName() == null || c26493s.getFileName().length() <= 0) && c26493s.bJt == -1) {
            AppMethodBeat.m2505o(50841);
            return false;
        } else {
            boolean c = C37961o.all().mo21060c(c26493s);
            AppMethodBeat.m2505o(50841);
            return c;
        }
    }

    /* renamed from: uu */
    public static String m42269uu(String str) {
        AppMethodBeat.m2504i(50842);
        String str2 = C6457e.euR + C5046bo.anU() + VideoMaterialUtil.MP4_SUFFIX;
        if (C5730e.m8644y(str, str2) < 0) {
            AppMethodBeat.m2505o(50842);
            return null;
        }
        AppMethodBeat.m2505o(50842);
        return str2;
    }

    /* renamed from: uv */
    public static boolean m42270uv(String str) {
        AppMethodBeat.m2504i(50845);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            AppMethodBeat.m2505o(50845);
            return false;
        }
        C4990ab.m7410d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(str)));
        C26493s ut = C26494u.m42268ut(str);
        if (ut != null && ut.status == 199) {
            int i = ut.frO;
            C37961o.all();
            int asZ = (int) C5730e.asZ(C9720t.m17303uh(str));
            C4990ab.m7411d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", Integer.valueOf(asZ), Integer.valueOf(i));
            if (asZ > 0 && Math.abs(asZ - i) > 16) {
                C4990ab.m7421w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", Integer.valueOf(asZ), Integer.valueOf(i));
                String fileName = ut.getFileName();
                C7060h.pYm.mo8378a(111, 217, 1, false);
                C26493s ut2 = C26494u.m42268ut(fileName);
                if (ut2 != null) {
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) ut2.fXe);
                    int type = jf.getType();
                    C4990ab.m7417i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", Integer.valueOf(type));
                    if (43 == type || 62 == type) {
                        jf.setContent(C37963q.m64228d(ut2.alt(), (long) ut2.fXd, false));
                        jf.setStatus(2);
                        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a((long) ut2.fXe, jf);
                        ut2.status = 196;
                        ut2.fXb = C5046bo.anT();
                        ut2.bJt = ActUtil.HEIGHT;
                        C4990ab.m7410d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
                        C26494u.m42253f(ut2);
                    }
                }
                AppMethodBeat.m2505o(50845);
                return true;
            }
        }
        AppMethodBeat.m2505o(50845);
        return false;
    }

    /* renamed from: A */
    public static int m42237A(int i, String str) {
        int i2;
        AppMethodBeat.m2504i(50846);
        long yz = C5046bo.m7588yz();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!C37961o.alo().mo67754b(str, pInt, pInt2) || C5046bo.m7549fp((long) pInt.value) >= 300) {
            i2 = 0;
        } else {
            i2 = pInt2.value;
        }
        if (i2 < 0 || i2 >= i - 1) {
            i2 = 0;
        }
        C4990ab.m7411d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", Integer.valueOf(i2), Integer.valueOf(pInt.value), str, Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(50846);
        return i2;
    }

    /* renamed from: f */
    public static void m42252f(String str, int i, boolean z) {
        AppMethodBeat.m2504i(50847);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7421w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", str);
            AppMethodBeat.m2505o(50847);
            return;
        }
        boolean z2;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        long yz = C5046bo.m7588yz();
        long update;
        if (C37961o.alo().mo67755uB(str)) {
            C42228x alo = C37961o.alo();
            int anU = (int) (C5046bo.anU() / 1000);
            if (!C5046bo.isNullOrNil(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("starttime", Integer.valueOf(anU));
                contentValues.put("playduration", Integer.valueOf(i2));
                update = (long) alo.bSd.update("VideoPlayHistory", contentValues, "filename=?", new String[]{str});
                C4990ab.m7416i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(update)));
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            int i3;
            C42228x alo2 = C37961o.alo();
            int anU2 = (int) (C5046bo.anU() / 1000);
            if (z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!C5046bo.isNullOrNil(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("filename", str);
                contentValues2.put("starttime", Integer.valueOf(anU2));
                contentValues2.put("playduration", Integer.valueOf(i2));
                contentValues2.put("downloadway", Integer.valueOf(i3));
                update = alo2.bSd.insert("VideoPlayHistory", "filename", contentValues2);
                C4990ab.m7416i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(update)));
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        C4990ab.m7411d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", Boolean.valueOf(z2), str, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(50847);
    }

    /* renamed from: uw */
    public static void m42271uw(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(50848);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50848);
            return;
        }
        if (C37961o.alo().bSd.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
            z = false;
        }
        C4990ab.m7410d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        AppMethodBeat.m2505o(50848);
    }

    /* renamed from: e */
    public static String m42249e(long j, int i) {
        AppMethodBeat.m2504i(50849);
        String str = j + "_" + i;
        AppMethodBeat.m2505o(50849);
        return str;
    }

    /* renamed from: f */
    public static int m42251f(long j, String str) {
        int i = -1;
        AppMethodBeat.m2504i(50850);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50850);
        } else {
            try {
                String[] split = str.split("_");
                if (split == null || split.length != 2) {
                    AppMethodBeat.m2505o(50850);
                } else {
                    if (C5046bo.getLong(split[0], 0) == j) {
                        i = C5046bo.getInt(split[1], 0);
                        AppMethodBeat.m2505o(50850);
                    }
                    AppMethodBeat.m2505o(50850);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e.toString());
            }
        }
        return i;
    }

    /* renamed from: af */
    public static void m42243af(String str, int i) {
        AppMethodBeat.m2504i(50851);
        C26493s ut = C26494u.m42268ut(str);
        if (ut != null) {
            ut.status = 122;
            ut.fXc = C5046bo.anT();
            ut.fXb = C5046bo.anT();
            ut.egF = i;
            ut.bJt = 268438784;
            C4990ab.m7416i("MicroMsg.VideoLogic", "set online video Completion ret: " + C37961o.all().mo21060c(ut) + " status: " + ut.status);
        }
        AppMethodBeat.m2505o(50851);
    }

    /* renamed from: ux */
    public static boolean m42272ux(String str) {
        AppMethodBeat.m2504i(50852);
        C26493s ut = C26494u.m42268ut(str);
        if (ut != null) {
            ut.videoFormat = 2;
            ut.bJt = 2;
            C4990ab.m7417i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", Boolean.valueOf(C37961o.all().mo21060c(ut)), str, Integer.valueOf(2));
            AppMethodBeat.m2505o(50852);
            return C37961o.all().mo21060c(ut);
        }
        AppMethodBeat.m2505o(50852);
        return false;
    }

    /* renamed from: uy */
    public static boolean m42273uy(String str) {
        AppMethodBeat.m2504i(50853);
        C26493s ut = C26494u.m42268ut(str);
        if (ut != null) {
            ut.videoFormat = 2;
            ut.status = 199;
            ut.fXc = C5046bo.anT();
            ut.fXb = C5046bo.anT();
            ut.egF = 19;
            ut.bJt = 268438786;
            boolean c = C37961o.all().mo21060c(ut);
            C4990ab.m7416i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + c + " status: " + ut.status);
            AppMethodBeat.m2505o(50853);
            return c;
        }
        AppMethodBeat.m2505o(50853);
        return false;
    }

    /* renamed from: uz */
    public static boolean m42274uz(String str) {
        AppMethodBeat.m2504i(50854);
        C26493s ut = C26494u.m42268ut(str);
        if (ut != null) {
            ut.videoFormat = 2;
            ut.bJt = 2;
            boolean c = C37961o.all().mo21060c(ut);
            C4990ab.m7416i("MicroMsg.VideoLogic", "set hevc video format ret: " + c + " status: " + ut.status);
            AppMethodBeat.m2505o(50854);
            return c;
        }
        AppMethodBeat.m2505o(50854);
        return false;
    }

    /* renamed from: uA */
    public static int m42259uA(String str) {
        AppMethodBeat.m2504i(50855);
        C26493s ut = C26494u.m42268ut(str);
        int line;
        if (ut == null) {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50855);
            return line;
        } else if (ut.status == 111 || ut.status == 113 || ut.status == 121 || ut.status == 122 || ut.status == 123) {
            line = 256;
            C42204d.afF();
            if (C42204d.afM()) {
                ut.status = 122;
            } else {
                C4990ab.m7420w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                ut.status = 112;
                ut.fWY = 0;
                line = 272;
            }
            ut.fXc = C5046bo.anT();
            ut.fXb = C5046bo.anT();
            ut.bJt = (line | 2048) | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            if (C26494u.m42253f(ut)) {
                C37961o.alq().alG();
                C37961o.alq().run();
                AppMethodBeat.m2505o(50855);
                return 0;
            }
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " update failed: " + str);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50855);
            return line;
        } else {
            C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(50855);
            return line;
        }
    }

    /* renamed from: ag */
    public static boolean m42244ag(String str, int i) {
        AppMethodBeat.m2504i(50856);
        boolean b = C26494u.m42245b(C26494u.m42268ut(str), i);
        AppMethodBeat.m2505o(50856);
        return b;
    }

    /* renamed from: b */
    public static boolean m42245b(C26493s c26493s, int i) {
        AppMethodBeat.m2504i(50857);
        if (c26493s != null) {
            c26493s.egF = i;
            c26493s.bJt = 268435456;
            boolean f = C26494u.m42253f(c26493s);
            AppMethodBeat.m2505o(50857);
            return f;
        }
        AppMethodBeat.m2505o(50857);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m42241a(String str, PInt pInt, PInt pInt2) {
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(50858);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.VideoLogic", "get media info but path is null");
            AppMethodBeat.m2505o(50858);
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                pInt.value = C5046bo.m7576mA((long) C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                pInt2.value = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0) / 1000;
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
                    if (mediaMetadataRetriever != null) {
                    }
                    C4990ab.m7411d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
                    AppMethodBeat.m2505o(50858);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                    }
                    AppMethodBeat.m2505o(50858);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever = null;
            C4990ab.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            C4990ab.m7411d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
            AppMethodBeat.m2505o(50858);
            return true;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            AppMethodBeat.m2505o(50858);
            throw th;
        }
        C4990ab.m7411d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
        AppMethodBeat.m2505o(50858);
        return true;
    }

    /* renamed from: c */
    public static boolean m42246c(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(50824);
        boolean a = C26494u.m42239a(str, i, str2, str3, 0, "", 43);
        AppMethodBeat.m2505o(50824);
        return a;
    }

    /* renamed from: g */
    public static int m42255g(C26493s c26493s) {
        AppMethodBeat.m2504i(50843);
        if (c26493s.frO == 0) {
            AppMethodBeat.m2505o(50843);
            return 0;
        }
        C4990ab.m7410d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + c26493s.fWY + " " + c26493s.frO);
        int i = (c26493s.fWY * 100) / c26493s.frO;
        AppMethodBeat.m2505o(50843);
        return i;
    }

    /* renamed from: h */
    public static int m42256h(C26493s c26493s) {
        AppMethodBeat.m2504i(50844);
        if (c26493s.frO == 0) {
            AppMethodBeat.m2505o(50844);
            return 0;
        }
        C4990ab.m7410d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + c26493s.fVG + " " + c26493s.frO);
        int i = (c26493s.fVG * 100) / c26493s.frO;
        AppMethodBeat.m2505o(50844);
        return i;
    }
}
