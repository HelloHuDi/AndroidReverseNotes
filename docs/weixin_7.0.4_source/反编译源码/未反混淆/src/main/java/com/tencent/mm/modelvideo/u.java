package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class u {
    public static boolean ul(String str) {
        AppMethodBeat.i(50821);
        if (str == null) {
            AppMethodBeat.o(50821);
            return false;
        }
        s ut = ut(str);
        if (ut == null) {
            AppMethodBeat.o(50821);
            return false;
        } else if (ut.fXf >= 2500) {
            AppMethodBeat.o(50821);
            return false;
        } else {
            ut.fXf++;
            ut.bJt = 16384;
            boolean f = f(ut);
            AppMethodBeat.o(50821);
            return f;
        }
    }

    public static boolean um(String str) {
        AppMethodBeat.i(50822);
        h.pYm.a(111, 218, 1, false);
        ab.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", str, bo.dpG());
        o.alq().uC(str);
        if (str == null) {
            AppMethodBeat.o(50822);
            return false;
        }
        s ut = ut(str);
        if (ut == null) {
            ab.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(str)));
            AppMethodBeat.o(50822);
            return false;
        }
        ut.status = o.CTRL_INDEX;
        ut.fXb = System.currentTimeMillis() / 1000;
        ut.bJt = ActUtil.HEIGHT;
        baa baa = ut.fXn;
        baa.wDQ = 0;
        ut.fXn = baa;
        boolean f = f(ut);
        ab.d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + ut.fXe + " old stat:" + ut.status);
        if (ut == null || ut.fXe == 0) {
            AppMethodBeat.o(50822);
            return f;
        }
        bi jf = ((j) g.K(j.class)).bOr().jf((long) ut.fXe);
        int type = jf.getType();
        ab.i("MicroMsg.VideoLogic", "set error, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            e.pXa.a(111, 32, 1, true);
            jf.ju(ut.getUser());
            jf.setContent(q.d(ut.alt(), -1, true));
            ab.d("MicroMsg.VideoLogic", "[oneliang][setError]");
            ((j) g.K(j.class)).bOr().a(jf.field_msgId, jf);
            AppMethodBeat.o(50822);
            return f;
        }
        AppMethodBeat.o(50822);
        return f;
    }

    public static boolean un(String str) {
        AppMethodBeat.i(50823);
        s ut = ut(str);
        if (ut == null || ut.fXe == 0) {
            AppMethodBeat.o(50823);
            return false;
        }
        bi jf = ((j) g.K(j.class)).bOr().jf((long) ut.fXe);
        int type = jf.getType();
        ab.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            jf.setContent(q.d(ut.alt(), (long) ut.fXd, false));
            jf.setStatus(2);
            ((j) g.K(j.class)).bOr().a((long) ut.fXe, jf);
            ut.status = 197;
            ut.fXb = bo.anT();
            ut.bJt = ActUtil.HEIGHT;
            ab.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
            boolean f = f(ut);
            AppMethodBeat.o(50823);
            return f;
        }
        AppMethodBeat.o(50823);
        return false;
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3) {
        AppMethodBeat.i(50825);
        boolean a = a(str, i, str2, str3, i2, str4, i3, null, "");
        AppMethodBeat.o(50825);
        return a;
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3, cfh cfh, String str5) {
        AppMethodBeat.i(50826);
        s sVar = new s();
        sVar.fileName = str;
        sVar.fXd = i;
        sVar.cIS = str2;
        sVar.fWW = (String) g.RP().Ry().get(2, (Object) "");
        sVar.createTime = bo.anT();
        sVar.fXb = bo.anT();
        sVar.fXj = str4;
        sVar.fUG = str3;
        sVar.fXm = cfh;
        sVar.cMn = str5;
        if (!bo.isNullOrNil(str3)) {
            sVar.fXh = 1;
        }
        if (i2 > 0) {
            sVar.fXh = 1;
        }
        if (62 == i3) {
            sVar.fXk = 3;
        } else if (i2 > 0) {
            sVar.fXk = 2;
        } else {
            sVar.fXk = 1;
        }
        o.all();
        int uj = t.uj(t.uh(str));
        if (uj <= 0) {
            ab.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
            AppMethodBeat.o(50826);
            return false;
        }
        sVar.frO = uj;
        o.all();
        String ui = t.ui(str);
        int uj2 = t.uj(ui);
        if (uj2 <= 0) {
            ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + ui + " size:" + uj2);
            AppMethodBeat.o(50826);
            return false;
        }
        sVar.fXa = uj2;
        ab.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + sVar.fXa + " videosize:" + sVar.frO + " msgType:" + i3);
        sVar.status = 102;
        bi biVar = new bi();
        biVar.ju(sVar.getUser());
        biVar.setType(i3);
        biVar.hO(1);
        biVar.jv(str);
        biVar.setStatus(1);
        biVar.eJ(bf.oC(sVar.getUser()));
        sVar.fXe = (int) bf.l(biVar);
        boolean b = o.all().b(sVar);
        AppMethodBeat.o(50826);
        return b;
    }

    public static boolean d(String str, int i, String str2, String str3) {
        AppMethodBeat.i(50827);
        s sVar = new s();
        sVar.fileName = str;
        sVar.fXd = i;
        sVar.cIS = str2;
        sVar.fWW = (String) g.RP().Ry().get(2, (Object) "");
        sVar.createTime = bo.anT();
        sVar.fXb = bo.anT();
        sVar.fXj = str3;
        sVar.fXk = 1;
        o.all();
        sVar.frO = t.uj(t.uh(str));
        o.all();
        sVar.fXa = t.uj(t.ui(str));
        ab.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + sVar.fXa + " videosize:" + sVar.frO + " msgType:43");
        sVar.status = 102;
        bi biVar = new bi();
        biVar.ju(sVar.getUser());
        biVar.setType(43);
        biVar.hO(1);
        biVar.jv(str);
        biVar.setStatus(1);
        biVar.eJ(bf.oC(sVar.getUser()));
        sVar.fXe = (int) bf.l(biVar);
        boolean b = o.all().b(sVar);
        AppMethodBeat.o(50827);
        return b;
    }

    public static long a(String str, String str2, String str3, int i) {
        AppMethodBeat.i(50828);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", Integer.valueOf(i));
            AppMethodBeat.o(50828);
            return -1;
        } else if (bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", Integer.valueOf(i));
            AppMethodBeat.o(50828);
            return -1;
        } else {
            int i2;
            s sVar;
            s sVar2 = new s();
            sVar2.fileName = str;
            sVar2.fXd = 1;
            sVar2.cIS = str2;
            sVar2.fWW = (String) g.RP().Ry().get(2, (Object) "");
            sVar2.createTime = bo.anT();
            sVar2.fXb = bo.anT();
            sVar2.fXj = null;
            sVar2.fUG = str3;
            if (!bo.isNullOrNil(str3)) {
                sVar2.fXh = 1;
            }
            if (62 == i) {
                sVar2.fXh = 0;
                i2 = 3;
                sVar = sVar2;
            } else if (sVar2.fXh == 0) {
                i2 = 1;
                sVar = sVar2;
            } else {
                i2 = -1;
                sVar = sVar2;
            }
            sVar.fXk = i2;
            sVar2.frO = 0;
            sVar2.status = 106;
            bi biVar = new bi();
            biVar.ju(sVar2.getUser());
            biVar.setType(i);
            biVar.hO(1);
            biVar.jv(str);
            biVar.setStatus(8);
            biVar.eJ(bf.oC(sVar2.getUser()));
            long l = bf.l(biVar);
            sVar2.fXe = (int) l;
            if (o.all().b(sVar2)) {
                AppMethodBeat.o(50828);
                return l;
            }
            AppMethodBeat.o(50828);
            return -1;
        }
    }

    public static long t(String str, String str2, String str3) {
        AppMethodBeat.i(50829);
        long a = a(str, str2, str3, 43);
        AppMethodBeat.o(50829);
        return a;
    }

    public static void n(String str, int i, int i2) {
        AppMethodBeat.i(50830);
        s ut = ut(str);
        if (ut == null) {
            ab.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", str, Integer.valueOf(i2));
            AppMethodBeat.o(50830);
            return;
        }
        o.all();
        ab.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", Integer.valueOf(t.uj(t.uh(str))), Integer.valueOf(i2));
        ut.frO = r0;
        ut.fXd = i;
        baa baa = ut.fXn;
        baa.wDO = false;
        ut.fXn = baa;
        ut.status = 102;
        o.all();
        ut.fXa = t.uj(t.ui(str));
        ab.i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + ut.fXa);
        ut.bJt = 4512;
        ab.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", Boolean.valueOf(f(ut)), Integer.valueOf(i2));
        bi jf = ((j) g.K(j.class)).bOr().jf((long) ut.fXe);
        ab.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), jf.field_talker, Integer.valueOf(jf.getType()), Integer.valueOf(jf.field_isSend), jf.field_imgPath, Integer.valueOf(jf.field_status), Long.valueOf(jf.field_createTime));
        jf.ju(ut.getUser());
        jf.setType(i2);
        jf.hO(1);
        jf.jv(str);
        jf.setStatus(1);
        ab.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), jf.field_talker, Integer.valueOf(jf.getType()), Integer.valueOf(jf.field_isSend), jf.field_imgPath, Integer.valueOf(jf.field_status), Long.valueOf(jf.field_createTime));
        ((j) g.K(j.class)).bOr().a((long) ut.fXe, jf);
        AppMethodBeat.o(50830);
    }

    public static int uo(String str) {
        AppMethodBeat.i(50831);
        s ut = ut(str);
        int line;
        if (ut == null) {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50831);
            return line;
        } else if (ut.status == 102 || ut.status == 105) {
            int i = ut.status;
            if (ut.status == 102 || ut.fXa != ut.fWZ) {
                ut.status = 103;
            } else {
                ut.status = 104;
            }
            ab.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.Mq() + "startSend file:" + str + " status:[" + i + "->" + ut.status + "]");
            ut.fXc = bo.anT();
            ut.fXb = bo.anT();
            ut.bJt = 3328;
            if (f(ut)) {
                o.alq().run();
                AppMethodBeat.o(50831);
                return 0;
            }
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " update failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50831);
            return line;
        } else {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50831);
            return line;
        }
    }

    public static int fV(long j) {
        AppMethodBeat.i(50832);
        for (s sVar : o.all().fU(j)) {
            int i = sVar.status;
            sVar.status = 200;
            ab.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.Mq() + "startSend file:" + sVar.getFileName() + " status:[" + i + "->" + sVar.status + "]");
            sVar.fXc = bo.anT();
            sVar.fXb = bo.anT();
            sVar.bJt = 3328;
            if (!f(sVar)) {
                ab.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.Mq() + " update failed: " + sVar.getFileName());
                int line = 0 - com.tencent.mm.compatible.util.g.getLine();
                AppMethodBeat.o(50832);
                return line;
            }
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(50737);
                ab.d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + m.this.running + " sending:" + m.this.cqU);
                if (!m.this.running) {
                    m.this.cqV = 5;
                    m.this.cqZ.evE = SystemClock.elapsedRealtime();
                    m.this.cqU = false;
                }
                m.this.running = true;
                m.this.cra.ae(10, 10);
                AppMethodBeat.o(50737);
            }

            public final String toString() {
                AppMethodBeat.i(50738);
                String str = super.toString() + "|run";
                AppMethodBeat.o(50738);
                return str;
            }
        });
        AppMethodBeat.o(50832);
        return 0;
    }

    public static void d(s sVar) {
        AppMethodBeat.i(50833);
        if (sVar == null) {
            ab.e("MicroMsg.VideoLogic", "video info is null");
            AppMethodBeat.o(50833);
            return;
        }
        bi jf = ((j) g.K(j.class)).bOr().jf((long) sVar.fXe);
        int type = jf.getType();
        ab.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            jf.hO(1);
            jf.ju(sVar.getUser());
            jf.eI(sVar.cKK);
            jf.setStatus(2);
            jf.setContent(q.d(sVar.alt(), (long) sVar.fXd, false));
            ((j) g.K(j.class)).bOr().a((long) sVar.fXe, jf);
            ab.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", Long.valueOf(jf.field_msgId));
            AppMethodBeat.o(50833);
            return;
        }
        AppMethodBeat.o(50833);
    }

    static boolean e(s sVar) {
        AppMethodBeat.i(50834);
        bi jf = ((j) g.K(j.class)).bOr().jf((long) sVar.fXe);
        int type = jf.getType();
        ab.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            jf.eI(sVar.cKK);
            jf.setContent(q.d(sVar.alt(), (long) sVar.fXd, false));
            jf.ju(sVar.getUser());
            ab.d("MicroMsg.VideoLogic", "set msg content :" + jf.field_content);
            ((j) g.K(j.class)).bOr().b(sVar.cKK, jf);
            ab.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", Long.valueOf(jf.field_msgId));
            if (jf.bwt()) {
                ab.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", Integer.valueOf(sVar.frO));
            }
            AppMethodBeat.o(50834);
            return true;
        }
        AppMethodBeat.o(50834);
        return false;
    }

    public static int up(String str) {
        AppMethodBeat.i(50835);
        s ut = ut(str);
        int line;
        if (ut == null) {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50835);
            return line;
        } else if (ut.status == 111 || ut.status == 113 || ut.status == 121 || ut.status == 122 || ut.status == 123) {
            ut.status = 112;
            ut.fXc = bo.anT();
            ut.fXb = bo.anT();
            ut.bJt = 3328;
            if (f(ut)) {
                o.alq().alG();
                o.alq().run();
                AppMethodBeat.o(50835);
                return 0;
            }
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " update failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50835);
            return line;
        } else {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50835);
            return line;
        }
    }

    public static int uq(String str) {
        AppMethodBeat.i(50836);
        s ut = ut(str);
        int line;
        if (ut == null) {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50836);
            return line;
        } else if (ut.status == 112 || ut.status == 120 || ut.status == 122 || ut.status == 123) {
            ut.status = 113;
            ut.fXb = bo.anT();
            ut.bJt = ActUtil.HEIGHT;
            if (f(ut)) {
                AppMethodBeat.o(50836);
                return 0;
            }
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " update failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50836);
            return line;
        } else {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50836);
            return line;
        }
    }

    public static boolean ae(String str, int i) {
        int i2 = 0;
        AppMethodBeat.i(50837);
        s ut = ut(str);
        if (ut == null) {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
            AppMethodBeat.o(50837);
            return false;
        }
        if (i != ut.frO) {
            ab.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", Integer.valueOf(i), Integer.valueOf(ut.frO));
            ut.frO = i;
            i2 = 32;
        }
        ut.fWY = i;
        ut.fXb = bo.anT();
        e(ut);
        ut.status = 199;
        ut.bJt = i2 | 1296;
        boolean f = f(ut);
        ab.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i + " total:" + ut.frO + " status:" + ut.status + " netTimes:" + ut.fXf + " update ret: " + f);
        AppMethodBeat.o(50837);
        return f;
    }

    public static boolean ur(String str) {
        AppMethodBeat.i(50838);
        ab.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(str)));
        s sVar = new s();
        sVar.status = 112;
        sVar.fXb = bo.anT();
        sVar.fXc = bo.anT();
        sVar.fileName = str;
        sVar.bJt = 3328;
        if (f(sVar)) {
            o.alq().run();
            AppMethodBeat.o(50838);
            return true;
        }
        AppMethodBeat.o(50838);
        return false;
    }

    public static boolean us(String str) {
        AppMethodBeat.i(50839);
        s ut = ut(str);
        if (ut == null) {
            AppMethodBeat.o(50839);
            return false;
        }
        ab.i("MicroMsg.VideoLogic", "rsetMsgSend %s", str);
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
        ut.createTime = bo.anT();
        ut.fXb = bo.anT();
        ut.fXc = bo.anT();
        ut.bJt = 536874752;
        if (f(ut)) {
            o.alq().run();
            AppMethodBeat.o(50839);
            return true;
        }
        AppMethodBeat.o(50839);
        return false;
    }

    public static s ut(String str) {
        AppMethodBeat.i(50840);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50840);
            return null;
        }
        s uf = o.all().uf(str);
        AppMethodBeat.o(50840);
        return uf;
    }

    public static boolean f(s sVar) {
        AppMethodBeat.i(50841);
        if (sVar == null) {
            AppMethodBeat.o(50841);
            return false;
        } else if ((sVar.getFileName() == null || sVar.getFileName().length() <= 0) && sVar.bJt == -1) {
            AppMethodBeat.o(50841);
            return false;
        } else {
            boolean c = o.all().c(sVar);
            AppMethodBeat.o(50841);
            return c;
        }
    }

    public static String uu(String str) {
        AppMethodBeat.i(50842);
        String str2 = com.tencent.mm.compatible.util.e.euR + bo.anU() + VideoMaterialUtil.MP4_SUFFIX;
        if (com.tencent.mm.vfs.e.y(str, str2) < 0) {
            AppMethodBeat.o(50842);
            return null;
        }
        AppMethodBeat.o(50842);
        return str2;
    }

    public static boolean uv(String str) {
        AppMethodBeat.i(50845);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            AppMethodBeat.o(50845);
            return false;
        }
        ab.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(str)));
        s ut = ut(str);
        if (ut != null && ut.status == 199) {
            int i = ut.frO;
            o.all();
            int asZ = (int) com.tencent.mm.vfs.e.asZ(t.uh(str));
            ab.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", Integer.valueOf(asZ), Integer.valueOf(i));
            if (asZ > 0 && Math.abs(asZ - i) > 16) {
                ab.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", Integer.valueOf(asZ), Integer.valueOf(i));
                String fileName = ut.getFileName();
                h.pYm.a(111, 217, 1, false);
                s ut2 = ut(fileName);
                if (ut2 != null) {
                    bi jf = ((j) g.K(j.class)).bOr().jf((long) ut2.fXe);
                    int type = jf.getType();
                    ab.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", Integer.valueOf(type));
                    if (43 == type || 62 == type) {
                        jf.setContent(q.d(ut2.alt(), (long) ut2.fXd, false));
                        jf.setStatus(2);
                        ((j) g.K(j.class)).bOr().a((long) ut2.fXe, jf);
                        ut2.status = 196;
                        ut2.fXb = bo.anT();
                        ut2.bJt = ActUtil.HEIGHT;
                        ab.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
                        f(ut2);
                    }
                }
                AppMethodBeat.o(50845);
                return true;
            }
        }
        AppMethodBeat.o(50845);
        return false;
    }

    public static int A(int i, String str) {
        int i2;
        AppMethodBeat.i(50846);
        long yz = bo.yz();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!o.alo().b(str, pInt, pInt2) || bo.fp((long) pInt.value) >= 300) {
            i2 = 0;
        } else {
            i2 = pInt2.value;
        }
        if (i2 < 0 || i2 >= i - 1) {
            i2 = 0;
        }
        ab.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", Integer.valueOf(i2), Integer.valueOf(pInt.value), str, Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(50846);
        return i2;
    }

    public static void f(String str, int i, boolean z) {
        AppMethodBeat.i(50847);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", str);
            AppMethodBeat.o(50847);
            return;
        }
        boolean z2;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        long yz = bo.yz();
        long update;
        if (o.alo().uB(str)) {
            x alo = o.alo();
            int anU = (int) (bo.anU() / 1000);
            if (!bo.isNullOrNil(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("starttime", Integer.valueOf(anU));
                contentValues.put("playduration", Integer.valueOf(i2));
                update = (long) alo.bSd.update("VideoPlayHistory", contentValues, "filename=?", new String[]{str});
                ab.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(update)));
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            int i3;
            x alo2 = o.alo();
            int anU2 = (int) (bo.anU() / 1000);
            if (z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!bo.isNullOrNil(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("filename", str);
                contentValues2.put("starttime", Integer.valueOf(anU2));
                contentValues2.put("playduration", Integer.valueOf(i2));
                contentValues2.put("downloadway", Integer.valueOf(i3));
                update = alo2.bSd.insert("VideoPlayHistory", "filename", contentValues2);
                ab.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(update)));
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        ab.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", Boolean.valueOf(z2), str, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(50847);
    }

    public static void uw(String str) {
        boolean z = true;
        AppMethodBeat.i(50848);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50848);
            return;
        }
        if (o.alo().bSd.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
            z = false;
        }
        ab.d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        AppMethodBeat.o(50848);
    }

    public static String e(long j, int i) {
        AppMethodBeat.i(50849);
        String str = j + "_" + i;
        AppMethodBeat.o(50849);
        return str;
    }

    public static int f(long j, String str) {
        int i = -1;
        AppMethodBeat.i(50850);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50850);
        } else {
            try {
                String[] split = str.split("_");
                if (split == null || split.length != 2) {
                    AppMethodBeat.o(50850);
                } else {
                    if (bo.getLong(split[0], 0) == j) {
                        i = bo.getInt(split[1], 0);
                        AppMethodBeat.o(50850);
                    }
                    AppMethodBeat.o(50850);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e.toString());
            }
        }
        return i;
    }

    public static void af(String str, int i) {
        AppMethodBeat.i(50851);
        s ut = ut(str);
        if (ut != null) {
            ut.status = 122;
            ut.fXc = bo.anT();
            ut.fXb = bo.anT();
            ut.egF = i;
            ut.bJt = 268438784;
            ab.i("MicroMsg.VideoLogic", "set online video Completion ret: " + o.all().c(ut) + " status: " + ut.status);
        }
        AppMethodBeat.o(50851);
    }

    public static boolean ux(String str) {
        AppMethodBeat.i(50852);
        s ut = ut(str);
        if (ut != null) {
            ut.videoFormat = 2;
            ut.bJt = 2;
            ab.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", Boolean.valueOf(o.all().c(ut)), str, Integer.valueOf(2));
            AppMethodBeat.o(50852);
            return o.all().c(ut);
        }
        AppMethodBeat.o(50852);
        return false;
    }

    public static boolean uy(String str) {
        AppMethodBeat.i(50853);
        s ut = ut(str);
        if (ut != null) {
            ut.videoFormat = 2;
            ut.status = 199;
            ut.fXc = bo.anT();
            ut.fXb = bo.anT();
            ut.egF = 19;
            ut.bJt = 268438786;
            boolean c = o.all().c(ut);
            ab.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + c + " status: " + ut.status);
            AppMethodBeat.o(50853);
            return c;
        }
        AppMethodBeat.o(50853);
        return false;
    }

    public static boolean uz(String str) {
        AppMethodBeat.i(50854);
        s ut = ut(str);
        if (ut != null) {
            ut.videoFormat = 2;
            ut.bJt = 2;
            boolean c = o.all().c(ut);
            ab.i("MicroMsg.VideoLogic", "set hevc video format ret: " + c + " status: " + ut.status);
            AppMethodBeat.o(50854);
            return c;
        }
        AppMethodBeat.o(50854);
        return false;
    }

    public static int uA(String str) {
        AppMethodBeat.i(50855);
        s ut = ut(str);
        int line;
        if (ut == null) {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " getinfo failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50855);
            return line;
        } else if (ut.status == 111 || ut.status == 113 || ut.status == 121 || ut.status == 122 || ut.status == 123) {
            line = 256;
            d.afF();
            if (d.afM()) {
                ut.status = 122;
            } else {
                ab.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                ut.status = 112;
                ut.fWY = 0;
                line = 272;
            }
            ut.fXc = bo.anT();
            ut.fXb = bo.anT();
            ut.bJt = (line | 2048) | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            if (f(ut)) {
                o.alq().alG();
                o.alq().run();
                AppMethodBeat.o(50855);
                return 0;
            }
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " update failed: " + str);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50855);
            return line;
        } else {
            ab.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.Mq() + " get status failed: " + str + " status:" + ut.status);
            line = 0 - com.tencent.mm.compatible.util.g.getLine();
            AppMethodBeat.o(50855);
            return line;
        }
    }

    public static boolean ag(String str, int i) {
        AppMethodBeat.i(50856);
        boolean b = b(ut(str), i);
        AppMethodBeat.o(50856);
        return b;
    }

    public static boolean b(s sVar, int i) {
        AppMethodBeat.i(50857);
        if (sVar != null) {
            sVar.egF = i;
            sVar.bJt = 268435456;
            boolean f = f(sVar);
            AppMethodBeat.o(50857);
            return f;
        }
        AppMethodBeat.o(50857);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(String str, PInt pInt, PInt pInt2) {
        Throwable e;
        Throwable th;
        AppMethodBeat.i(50858);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.VideoLogic", "get media info but path is null");
            AppMethodBeat.o(50858);
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                pInt.value = bo.mA((long) bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                pInt2.value = bo.getInt(mediaMetadataRetriever.extractMetadata(20), 0) / 1000;
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
                    if (mediaMetadataRetriever != null) {
                    }
                    ab.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
                    AppMethodBeat.o(50858);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                    }
                    AppMethodBeat.o(50858);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever = null;
            ab.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            ab.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
            AppMethodBeat.o(50858);
            return true;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            AppMethodBeat.o(50858);
            throw th;
        }
        ab.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
        AppMethodBeat.o(50858);
        return true;
    }

    public static boolean c(String str, int i, String str2, String str3) {
        AppMethodBeat.i(50824);
        boolean a = a(str, i, str2, str3, 0, "", 43);
        AppMethodBeat.o(50824);
        return a;
    }

    public static int g(s sVar) {
        AppMethodBeat.i(50843);
        if (sVar.frO == 0) {
            AppMethodBeat.o(50843);
            return 0;
        }
        ab.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + sVar.fWY + " " + sVar.frO);
        int i = (sVar.fWY * 100) / sVar.frO;
        AppMethodBeat.o(50843);
        return i;
    }

    public static int h(s sVar) {
        AppMethodBeat.i(50844);
        if (sVar.frO == 0) {
            AppMethodBeat.o(50844);
            return 0;
        }
        ab.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + sVar.fVG + " " + sVar.frO);
        int i = (sVar.fVG * 100) / sVar.frO;
        AppMethodBeat.o(50844);
        return i;
    }
}
