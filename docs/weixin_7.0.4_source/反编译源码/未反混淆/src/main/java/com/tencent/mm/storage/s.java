package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.c.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class s {
    private static int ctE = 0;
    private static String xIj = null;
    private static long xIk = 0;
    private static Boolean xIl = null;
    private static boolean yan = false;

    public static void an(bi biVar) {
        AppMethodBeat.i(11894);
        if (biVar == null) {
            AppMethodBeat.o(11894);
        } else if (l.mg(biVar.field_talker)) {
            AppMethodBeat.o(11894);
        } else if (t.kH(biVar.field_talker)) {
            AppMethodBeat.o(11894);
        } else {
            ad aoO = ((j) g.K(j.class)).XM().aoO(biVar.field_talker);
            if (aoO == null || !a.jh(aoO.field_type) || aoO.dsf()) {
                int i = 0;
                int i2 = -1;
                int i3 = 0;
                long j = 0;
                boolean z = false;
                Object obj = null;
                b oE = bf.oE(biVar.dqJ);
                if (oE != null) {
                    i = oE.fmq;
                    i2 = oE.fmr;
                    i3 = oE.fms;
                    j = (long) oE.fmv;
                    if ((oE.fmw & 8) != 0) {
                        z = true;
                    }
                    if ((oE.fmw & 16) != 0) {
                        obj = 1;
                    }
                    if ((oE.fmw & 4) != 0) {
                        ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", biVar.field_talker, Long.valueOf(oE.fmw));
                        AppMethodBeat.o(11894);
                        return;
                    }
                }
                Object obj2 = obj;
                boolean z2 = z;
                long j2 = j;
                if (i2 != 0) {
                    AppMethodBeat.o(11894);
                    return;
                }
                ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", biVar.field_talker, Boolean.valueOf(b(biVar, i, i3)));
                q B;
                q qVar;
                if (b(biVar, i, i3)) {
                    if (oE == null || (oE.fmw & 2) == 0) {
                        B = z.aeX().B(biVar.field_msgSvrId, "msgSvrId");
                        if (B == null) {
                            qVar = new q();
                        } else {
                            qVar = B;
                        }
                        qVar.field_msgId = biVar.field_msgId;
                        qVar.field_msgSvrId = biVar.field_msgSvrId;
                        qVar.field_content = biVar.field_content;
                        qVar.field_type = biVar.getType();
                        qVar.field_talker = biVar.field_talker;
                        qVar.field_talkerId = biVar.field_talkerId;
                        qVar.field_createTime = biVar.field_createTime;
                        qVar.field_imgPath = biVar.field_imgPath;
                        qVar.ht(biVar.dqI);
                        qVar.ix(biVar.dqJ);
                        if (aVO()) {
                            qVar.field_status = biVar.field_status;
                            qVar.field_hasShow = 0;
                        } else {
                            qVar.field_status = 4;
                            qVar.field_hasShow = 1;
                        }
                        if (obj2 != null) {
                            qVar.drG();
                        }
                        if (B == null) {
                            qVar.field_isExpand = z2;
                            j = z.aeX().drB();
                            long ag = ag(j, qVar.field_createTime / 1000);
                            if (ag >= 4294967296L) {
                                ab.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", Long.valueOf(ag));
                                j = z.aeX().drM();
                                ag = ag(j, qVar.field_createTime / 1000);
                            }
                            qVar.field_orderFlag = (((j2 << 24) & 4278190080L) | (j << 32)) | ag;
                            while (z.aeX().B(qVar.field_orderFlag, "orderFlag") != null) {
                                qVar.field_orderFlag++;
                            }
                            if (aoO == null || !aoO.Oe()) {
                                qVar.field_placeTop = 0;
                            } else {
                                qVar.field_placeTop = 1;
                            }
                            z.aeX().g(qVar);
                            if (!yan) {
                                yan = true;
                                d.xDG.b(new Runnable() {
                                    /* JADX WARNING: Missing block: B:10:0x0037, code skipped:
            if (r2 != 0) goto L_0x0039;
     */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void run() {
                                        int i;
                                        AppMethodBeat.i(139003);
                                        r aeX = z.aeX();
                                        long currentTimeMillis = System.currentTimeMillis();
                                        Cursor a = aeX.fni.a("SELECT count(*) FROM BizTimeLineInfo", null, 0);
                                        if (a.moveToFirst()) {
                                            i = a.getInt(0);
                                        } else {
                                            i = 0;
                                        }
                                        a.close();
                                        if (i <= Downloads.MIN_WAIT_FOR_NETWORK) {
                                            int i2 = (ab.getLogLevel() > 0 || i < 500) ? 0 : as.eg("brandService", 1).decodeInt("BizTimeLineDeleteOldData", 0) == 1 ? 1 : 0;
                                        }
                                        aeX.fni.hY("BizTimeLineInfo", String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[]{"BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100)}));
                                        ab.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i));
                                        s.yan = false;
                                        AppMethodBeat.o(139003);
                                    }
                                }, "BizTimeLineInfoStorageThread", 1000);
                            }
                            ab.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", Long.valueOf(j), Long.valueOf(ag), Long.valueOf(qVar.field_orderFlag));
                            AppMethodBeat.o(11894);
                            return;
                        }
                        z.aeX().h(qVar);
                        AppMethodBeat.o(11894);
                        return;
                    }
                    ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", biVar.field_talker, Long.valueOf(oE.fmw));
                    AppMethodBeat.o(11894);
                    return;
                } else if (bo.isEqual(biVar.field_talker, xIj)) {
                    ab.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", xIj);
                    AppMethodBeat.o(11894);
                    return;
                } else {
                    t aeY = z.aeY();
                    j2 = biVar.field_msgSvrId;
                    q qVar2 = new q();
                    Cursor a = aeY.fni.a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
                    if (a.moveToFirst()) {
                        qVar2.d(a);
                        a.close();
                        B = qVar2;
                    } else {
                        a.close();
                        B = null;
                    }
                    if (B == null) {
                        qVar = new q();
                    } else {
                        qVar = B;
                    }
                    qVar.field_msgId = biVar.field_msgId;
                    qVar.field_msgSvrId = biVar.field_msgSvrId;
                    qVar.field_content = biVar.field_content;
                    qVar.field_type = biVar.getType();
                    qVar.field_talker = biVar.field_talker;
                    qVar.field_talkerId = biVar.field_talkerId;
                    qVar.field_createTime = biVar.field_createTime;
                    qVar.field_imgPath = biVar.field_imgPath;
                    qVar.ht(biVar.dqI);
                    qVar.ix(biVar.dqJ);
                    qVar.field_status = biVar.field_status;
                    if (B == null) {
                        z.aeY().g(qVar);
                        AppMethodBeat.o(11894);
                        return;
                    }
                    z.aeY().h(qVar);
                    AppMethodBeat.o(11894);
                    return;
                }
            }
            AppMethodBeat.o(11894);
        }
    }

    private static boolean b(bi biVar, int i, int i2) {
        AppMethodBeat.i(11895);
        if ((biVar.drC() || biVar.getType() == 1 || biVar.getType() == 34 || biVar.getType() == 3) && (i == 3 || i2 == 9 || i2 == 15 || i2 == 17)) {
            AppMethodBeat.o(11895);
            return true;
        }
        AppMethodBeat.o(11895);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void pp(boolean z) {
        long j;
        int i;
        int i2;
        ak akVar;
        Cursor i3;
        AppMethodBeat.i(11896);
        Cursor c = ((j) g.K(j.class)).XR().c(t.fkP, null, "officialaccounts");
        if (z) {
            q drI = z.aeX().drI();
            if (drI != null) {
                j = drI.field_createTime;
                i = 0;
                for (i2 = 0; i2 < 50 && c.moveToNext(); i2++) {
                    akVar = new ak();
                    akVar.d(c);
                    i3 = ((j) g.K(j.class)).bOr().i(akVar.field_username, 3, 0);
                    while (i3.moveToNext()) {
                        bi biVar = new bi();
                        biVar.d(i3);
                        if (!z || biVar.field_createTime >= j) {
                            Object obj;
                            boolean z2;
                            q B;
                            q qVar;
                            int i4 = 0;
                            int i5 = -1;
                            int i6 = 0;
                            boolean z3 = false;
                            b oE = bf.oE(biVar.dqJ);
                            if (oE != null) {
                                i4 = oE.fmq;
                                i5 = oE.fmr;
                                i6 = oE.fms;
                                if ((oE.fmw & 8) != 0) {
                                    z3 = true;
                                }
                                if ((oE.fmw & 16) != 0) {
                                    obj = 1;
                                    z2 = z3;
                                    if (i5 == 0 && b(biVar, i4, i6)) {
                                        ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrateBizTimeLineMsg %s", biVar.field_talker);
                                        B = z.aeX().B(biVar.field_msgSvrId, "msgSvrId");
                                        if (B != null) {
                                            qVar = new q();
                                        } else {
                                            qVar = B;
                                        }
                                        qVar.field_msgId = biVar.field_msgId;
                                        qVar.field_msgSvrId = biVar.field_msgSvrId;
                                        qVar.field_content = biVar.field_content;
                                        qVar.field_type = biVar.getType();
                                        qVar.field_talker = biVar.field_talker;
                                        qVar.field_talkerId = biVar.field_talkerId;
                                        qVar.field_createTime = biVar.field_createTime;
                                        qVar.field_imgPath = biVar.field_imgPath;
                                        qVar.ht(biVar.dqI);
                                        qVar.ix(biVar.dqJ);
                                        if (obj != null) {
                                            qVar.drG();
                                        }
                                        if (B == null) {
                                            qVar.field_status = 4;
                                            qVar.field_isExpand = z2;
                                            long j2 = 1;
                                            if (z) {
                                                j2 = z.aeX().drB();
                                            }
                                            qVar.field_orderFlag = (j2 << 32) | (qVar.field_createTime / 1000);
                                            while (z.aeX().B(qVar.field_orderFlag, "orderFlag") != null) {
                                                qVar.field_orderFlag++;
                                            }
                                            ad aoO = ((j) g.K(j.class)).XM().aoO(biVar.field_talker);
                                            if (aoO == null || !aoO.Oe()) {
                                                qVar.field_placeTop = 0;
                                            } else {
                                                qVar.field_placeTop = 1;
                                            }
                                            z.aeX().g(qVar);
                                        }
                                    }
                                    i++;
                                }
                            }
                            obj = null;
                            z2 = z3;
                            ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrateBizTimeLineMsg %s", biVar.field_talker);
                            B = z.aeX().B(biVar.field_msgSvrId, "msgSvrId");
                            if (B != null) {
                            }
                            qVar.field_msgId = biVar.field_msgId;
                            qVar.field_msgSvrId = biVar.field_msgSvrId;
                            qVar.field_content = biVar.field_content;
                            qVar.field_type = biVar.getType();
                            qVar.field_talker = biVar.field_talker;
                            qVar.field_talkerId = biVar.field_talkerId;
                            qVar.field_createTime = biVar.field_createTime;
                            qVar.field_imgPath = biVar.field_imgPath;
                            qVar.ht(biVar.dqI);
                            qVar.ix(biVar.dqJ);
                            if (obj != null) {
                            }
                            if (B == null) {
                            }
                            i++;
                        }
                    }
                    i3.close();
                }
                ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrate %d/%d", Integer.valueOf(c.getCount()), Integer.valueOf(i));
                c.close();
                g.RP().Ry().set(ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(((Integer) g.RP().Ry().get(ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() | 2));
                AppMethodBeat.o(11896);
            }
        }
        j = 0;
        i = 0;
        for (i2 = 0; i2 < 50; i2++) {
            akVar = new ak();
            akVar.d(c);
            i3 = ((j) g.K(j.class)).bOr().i(akVar.field_username, 3, 0);
            while (i3.moveToNext()) {
            }
            i3.close();
        }
        ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrate %d/%d", Integer.valueOf(c.getCount()), Integer.valueOf(i));
        c.close();
        g.RP().Ry().set(ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(((Integer) g.RP().Ry().get(ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() | 2));
        AppMethodBeat.o(11896);
    }

    public static boolean mL(long j) {
        AppMethodBeat.i(11897);
        if (z.aeX().mG(j) <= 0) {
            AppMethodBeat.o(11897);
            return false;
        }
        if (z.aeX().drB() <= z.aeX().drL()) {
            z.aeX().drM();
        }
        z.aeX().mF(j);
        AppMethodBeat.o(11897);
        return true;
    }

    public static void ao(bi biVar) {
        AppMethodBeat.i(11898);
        if (biVar == null) {
            AppMethodBeat.o(11898);
            return;
        }
        z.aeX().mJ(biVar.field_msgId);
        AppMethodBeat.o(11898);
    }

    private static long ag(long j, long j2) {
        long j3;
        long j4 = -1;
        AppMethodBeat.i(11899);
        String str = (String) g.RP().Ry().get(ac.a.USERINFO_BIZ_TIME_LINE_GROUP_START_TIME_STRING_SYNC, (Object) "");
        if (!bo.isNullOrNil(str)) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length == 2 && bo.getLong(split[0], -1) == j) {
                j4 = j2 - bo.getLong(split[1], -1);
            }
        }
        if (j4 < 0) {
            j3 = 604800;
            g.RP().Ry().set(ac.a.USERINFO_BIZ_TIME_LINE_GROUP_START_TIME_STRING_SYNC, j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (j2 - 604800));
            ab.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", r2, Long.valueOf(j2));
        } else {
            ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", str, Long.valueOf(j2));
            j3 = j4;
        }
        AppMethodBeat.o(11899);
        return j3;
    }

    public static void drP() {
        AppMethodBeat.i(11900);
        if (aVO()) {
            boolean z;
            ak akVar;
            int mI;
            long j;
            q qVar;
            be XR = ((j) g.K(j.class)).XR();
            ak aoZ = XR.aoZ("officialaccounts");
            if (aoZ == null) {
                z = true;
                akVar = new ak("officialaccounts");
            } else {
                z = false;
                akVar = aoZ;
            }
            Cursor a = z.aeY().fni.a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
            q qVar2 = null;
            if (a.moveToFirst()) {
                qVar2 = new q();
                qVar2.d(a);
            }
            a.close();
            q drI = z.aeX().drI();
            long j2 = qVar2 != null ? qVar2.field_createTime : 0;
            if (drI != null) {
                mI = z.aeX().mI(drI.field_orderFlag);
            } else {
                mI = 0;
            }
            if (drI != null) {
                j = drI.field_createTime;
            } else {
                j = 0;
            }
            akVar.jk(32);
            int baS = z.aeY().baS();
            if (baS <= 0 || mI <= 0) {
                if (baS > 0) {
                    akVar.jk(16);
                    akVar.hM(baS);
                    qVar = qVar2;
                } else {
                    akVar.jj(16);
                    akVar.hM(mI);
                    qVar = drI;
                }
            } else if (j2 > j) {
                akVar.jk(16);
                akVar.hM(baS);
                qVar = qVar2;
            } else {
                akVar.jj(16);
                akVar.hM(mI);
                qVar = drI;
            }
            if (qVar == null || qVar.field_msgId == 0) {
                ab.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
                akVar.dsI();
                if (!z) {
                    XR.a(akVar, akVar.field_username);
                }
                AppMethodBeat.o(11900);
                return;
            }
            long j3;
            if (qVar == drI && qVar.field_placeTop == 1) {
                akVar.jj(32);
            }
            if (qVar == qVar2) {
                j3 = qVar.field_msgId;
                if (xIk == 0) {
                    xIk = ah.doB().getLong("biz_time_line_last_notify_msg_id", -1);
                }
                if (j3 == xIk) {
                    akVar.jk(64);
                } else {
                    akVar.jj(64);
                }
            }
            bi jf = ((j) g.K(j.class)).bOr().jf(qVar.field_msgId);
            if (jf.field_msgId > 0) {
                akVar.ap(jf);
                akVar.setContent(jf.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + jf.field_content);
                akVar.jg(Integer.toString(jf.getType()));
                be.b Cb = XR.Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    jf.ju("officialaccounts");
                    jf.setContent(akVar.field_content);
                    Cb.a(jf, pString, pString2, pInt, true);
                    akVar.jh(pString.value);
                    akVar.ji(pString2.value);
                    akVar.hP(pInt.value);
                }
            } else {
                akVar.dsI();
                ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", qVar.field_talker);
            }
            if (j2 > j) {
                j = j2;
            }
            akVar.eD(j);
            if (z) {
                j3 = XR.d(akVar);
            } else {
                j3 = (long) XR.a(akVar, akVar.field_username);
            }
            ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(akVar.field_conversationTime));
            AppMethodBeat.o(11900);
            return;
        }
        AppMethodBeat.o(11900);
    }

    public static void aom(String str) {
        xIj = str;
    }

    public static void mM(long j) {
        AppMethodBeat.i(11901);
        xIk = j;
        ah.doB().edit().putLong("biz_time_line_last_notify_msg_id", j).apply();
        AppMethodBeat.o(11901);
    }

    public static void Mj(int i) {
        ctE = i;
    }

    public static int getSessionId() {
        return ctE;
    }

    public static boolean aVO() {
        AppMethodBeat.i(11902);
        boolean booleanValue;
        if (xIl != null) {
            booleanValue = xIl.booleanValue();
            AppMethodBeat.o(11902);
            return booleanValue;
        }
        int decodeInt = as.eg("brandService", 1).decodeInt("BizTimeLineOpenStatus", -1);
        if (decodeInt == 1) {
            xIl = Boolean.TRUE;
        } else if (decodeInt == 0) {
            xIl = Boolean.FALSE;
        }
        if (xIl != null) {
            booleanValue = xIl.booleanValue();
            AppMethodBeat.o(11902);
            return booleanValue;
        }
        c ll = c.abi().ll("100391");
        booleanValue = ll.isValid() && "1".equals(ll.dru().get("isOpenSubscribeListVersion1"));
        xIl = Boolean.valueOf(booleanValue);
        ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", xIl);
        if (!xIl.booleanValue() && (((Integer) g.RP().Ry().get(ac.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() & 1) > 0) {
            xIl = Boolean.TRUE;
            ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
        }
        if (!xIl.booleanValue() && com.tencent.mm.m.g.Nu().getInt("BizTimeLineOpen", 0) == 1) {
            xIl = Boolean.TRUE;
            ab.i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen dynamicConfigOpen user");
        }
        booleanValue = xIl.booleanValue();
        AppMethodBeat.o(11902);
        return booleanValue;
    }
}
