package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.storage.s */
public final class C30309s {
    private static int ctE = 0;
    private static String xIj = null;
    private static long xIk = 0;
    private static Boolean xIl = null;
    private static boolean yan = false;

    /* renamed from: com.tencent.mm.storage.s$1 */
    static class C51431 implements Runnable {
        C51431() {
        }

        /* JADX WARNING: Missing block: B:10:0x0037, code skipped:
            if (r2 != 0) goto L_0x0039;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            int i;
            AppMethodBeat.m2504i(139003);
            C40635r aeX = C41747z.aeX();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = aeX.fni.mo10104a("SELECT count(*) FROM BizTimeLineInfo", null, 0);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
            if (i <= Downloads.MIN_WAIT_FOR_NETWORK) {
                int i2 = (C4990ab.getLogLevel() > 0 || i < 500) ? 0 : C5018as.m7465eg("brandService", 1).decodeInt("BizTimeLineDeleteOldData", 0) == 1 ? 1 : 0;
            }
            aeX.fni.mo10108hY("BizTimeLineInfo", String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[]{"BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100)}));
            C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i));
            C30309s.yan = false;
            AppMethodBeat.m2505o(139003);
        }
    }

    /* renamed from: an */
    public static void m48270an(C7620bi c7620bi) {
        AppMethodBeat.m2504i(11894);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(11894);
        } else if (C1192l.m2624mg(c7620bi.field_talker)) {
            AppMethodBeat.m2505o(11894);
        } else if (C1855t.m3896kH(c7620bi.field_talker)) {
            AppMethodBeat.m2505o(11894);
        } else {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7620bi.field_talker);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type) || aoO.dsf()) {
                int i = 0;
                int i2 = -1;
                int i3 = 0;
                long j = 0;
                boolean z = false;
                Object obj = null;
                C1828b oE = C1829bf.m3758oE(c7620bi.dqJ);
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
                        C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", c7620bi.field_talker, Long.valueOf(oE.fmw));
                        AppMethodBeat.m2505o(11894);
                        return;
                    }
                }
                Object obj2 = obj;
                boolean z2 = z;
                long j2 = j;
                if (i2 != 0) {
                    AppMethodBeat.m2505o(11894);
                    return;
                }
                C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b", c7620bi.field_talker, Boolean.valueOf(C30309s.m48272b(c7620bi, i, i3)));
                C46627q B;
                C46627q c46627q;
                if (C30309s.m48272b(c7620bi, i, i3)) {
                    if (oE == null || (oE.fmw & 2) == 0) {
                        B = C41747z.aeX().mo64097B(c7620bi.field_msgSvrId, "msgSvrId");
                        if (B == null) {
                            c46627q = new C46627q();
                        } else {
                            c46627q = B;
                        }
                        c46627q.field_msgId = c7620bi.field_msgId;
                        c46627q.field_msgSvrId = c7620bi.field_msgSvrId;
                        c46627q.field_content = c7620bi.field_content;
                        c46627q.field_type = c7620bi.getType();
                        c46627q.field_talker = c7620bi.field_talker;
                        c46627q.field_talkerId = c7620bi.field_talkerId;
                        c46627q.field_createTime = c7620bi.field_createTime;
                        c46627q.field_imgPath = c7620bi.field_imgPath;
                        c46627q.mo53212ht(c7620bi.dqI);
                        c46627q.mo53213ix(c7620bi.dqJ);
                        if (C30309s.aVO()) {
                            c46627q.field_status = c7620bi.field_status;
                            c46627q.field_hasShow = 0;
                        } else {
                            c46627q.field_status = 4;
                            c46627q.field_hasShow = 1;
                        }
                        if (obj2 != null) {
                            c46627q.drG();
                        }
                        if (B == null) {
                            c46627q.field_isExpand = z2;
                            j = C41747z.aeX().drB();
                            long ag = C30309s.m48269ag(j, c46627q.field_createTime / 1000);
                            if (ag >= 4294967296L) {
                                C4990ab.m7421w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", Long.valueOf(ag));
                                j = C41747z.aeX().drM();
                                ag = C30309s.m48269ag(j, c46627q.field_createTime / 1000);
                            }
                            c46627q.field_orderFlag = (((j2 << 24) & 4278190080L) | (j << 32)) | ag;
                            while (C41747z.aeX().mo64097B(c46627q.field_orderFlag, "orderFlag") != null) {
                                c46627q.field_orderFlag++;
                            }
                            if (aoO == null || !aoO.mo16702Oe()) {
                                c46627q.field_placeTop = 0;
                            } else {
                                c46627q.field_placeTop = 1;
                            }
                            C41747z.aeX().mo64112g(c46627q);
                            if (!yan) {
                                yan = true;
                                C7305d.xDG.mo10152b(new C51431(), "BizTimeLineInfoStorageThread", 1000);
                            }
                            C4990ab.m7419v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", Long.valueOf(j), Long.valueOf(ag), Long.valueOf(c46627q.field_orderFlag));
                            AppMethodBeat.m2505o(11894);
                            return;
                        }
                        C41747z.aeX().mo64113h(c46627q);
                        AppMethodBeat.m2505o(11894);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", c7620bi.field_talker, Long.valueOf(oE.fmw));
                    AppMethodBeat.m2505o(11894);
                    return;
                } else if (C5046bo.isEqual(c7620bi.field_talker, xIj)) {
                    C4990ab.m7419v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", xIj);
                    AppMethodBeat.m2505o(11894);
                    return;
                } else {
                    C23522t aeY = C41747z.aeY();
                    j2 = c7620bi.field_msgSvrId;
                    C46627q c46627q2 = new C46627q();
                    Cursor a = aeY.fni.mo10105a("BizTimeLineSingleMsgInfo", null, "msgSvrId" + "=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
                    if (a.moveToFirst()) {
                        c46627q2.mo8995d(a);
                        a.close();
                        B = c46627q2;
                    } else {
                        a.close();
                        B = null;
                    }
                    if (B == null) {
                        c46627q = new C46627q();
                    } else {
                        c46627q = B;
                    }
                    c46627q.field_msgId = c7620bi.field_msgId;
                    c46627q.field_msgSvrId = c7620bi.field_msgSvrId;
                    c46627q.field_content = c7620bi.field_content;
                    c46627q.field_type = c7620bi.getType();
                    c46627q.field_talker = c7620bi.field_talker;
                    c46627q.field_talkerId = c7620bi.field_talkerId;
                    c46627q.field_createTime = c7620bi.field_createTime;
                    c46627q.field_imgPath = c7620bi.field_imgPath;
                    c46627q.mo53212ht(c7620bi.dqI);
                    c46627q.mo53213ix(c7620bi.dqJ);
                    c46627q.field_status = c7620bi.field_status;
                    if (B == null) {
                        C41747z.aeY().mo39194g(c46627q);
                        AppMethodBeat.m2505o(11894);
                        return;
                    }
                    C41747z.aeY().mo39195h(c46627q);
                    AppMethodBeat.m2505o(11894);
                    return;
                }
            }
            AppMethodBeat.m2505o(11894);
        }
    }

    /* renamed from: b */
    private static boolean m48272b(C7620bi c7620bi, int i, int i2) {
        AppMethodBeat.m2504i(11895);
        if ((c7620bi.drC() || c7620bi.getType() == 1 || c7620bi.getType() == 34 || c7620bi.getType() == 3) && (i == 3 || i2 == 9 || i2 == 15 || i2 == 17)) {
            AppMethodBeat.m2505o(11895);
            return true;
        }
        AppMethodBeat.m2505o(11895);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: pp */
    public static void m48275pp(boolean z) {
        long j;
        int i;
        int i2;
        C7617ak c7617ak;
        Cursor i3;
        AppMethodBeat.m2504i(11896);
        Cursor c = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15804c(C1855t.fkP, null, "officialaccounts");
        if (z) {
            C46627q drI = C41747z.aeX().drI();
            if (drI != null) {
                j = drI.field_createTime;
                i = 0;
                for (i2 = 0; i2 < 50 && c.moveToNext(); i2++) {
                    c7617ak = new C7617ak();
                    c7617ak.mo8995d(c);
                    i3 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15339i(c7617ak.field_username, 3, 0);
                    while (i3.moveToNext()) {
                        C7620bi c7620bi = new C7620bi();
                        c7620bi.mo8995d(i3);
                        if (!z || c7620bi.field_createTime >= j) {
                            Object obj;
                            boolean z2;
                            C46627q B;
                            C46627q c46627q;
                            int i4 = 0;
                            int i5 = -1;
                            int i6 = 0;
                            boolean z3 = false;
                            C1828b oE = C1829bf.m3758oE(c7620bi.dqJ);
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
                                    if (i5 == 0 && C30309s.m48272b(c7620bi, i4, i6)) {
                                        C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrateBizTimeLineMsg %s", c7620bi.field_talker);
                                        B = C41747z.aeX().mo64097B(c7620bi.field_msgSvrId, "msgSvrId");
                                        if (B != null) {
                                            c46627q = new C46627q();
                                        } else {
                                            c46627q = B;
                                        }
                                        c46627q.field_msgId = c7620bi.field_msgId;
                                        c46627q.field_msgSvrId = c7620bi.field_msgSvrId;
                                        c46627q.field_content = c7620bi.field_content;
                                        c46627q.field_type = c7620bi.getType();
                                        c46627q.field_talker = c7620bi.field_talker;
                                        c46627q.field_talkerId = c7620bi.field_talkerId;
                                        c46627q.field_createTime = c7620bi.field_createTime;
                                        c46627q.field_imgPath = c7620bi.field_imgPath;
                                        c46627q.mo53212ht(c7620bi.dqI);
                                        c46627q.mo53213ix(c7620bi.dqJ);
                                        if (obj != null) {
                                            c46627q.drG();
                                        }
                                        if (B == null) {
                                            c46627q.field_status = 4;
                                            c46627q.field_isExpand = z2;
                                            long j2 = 1;
                                            if (z) {
                                                j2 = C41747z.aeX().drB();
                                            }
                                            c46627q.field_orderFlag = (j2 << 32) | (c46627q.field_createTime / 1000);
                                            while (C41747z.aeX().mo64097B(c46627q.field_orderFlag, "orderFlag") != null) {
                                                c46627q.field_orderFlag++;
                                            }
                                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7620bi.field_talker);
                                            if (aoO == null || !aoO.mo16702Oe()) {
                                                c46627q.field_placeTop = 0;
                                            } else {
                                                c46627q.field_placeTop = 1;
                                            }
                                            C41747z.aeX().mo64112g(c46627q);
                                        }
                                    }
                                    i++;
                                }
                            }
                            obj = null;
                            z2 = z3;
                            C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrateBizTimeLineMsg %s", c7620bi.field_talker);
                            B = C41747z.aeX().mo64097B(c7620bi.field_msgSvrId, "msgSvrId");
                            if (B != null) {
                            }
                            c46627q.field_msgId = c7620bi.field_msgId;
                            c46627q.field_msgSvrId = c7620bi.field_msgSvrId;
                            c46627q.field_content = c7620bi.field_content;
                            c46627q.field_type = c7620bi.getType();
                            c46627q.field_talker = c7620bi.field_talker;
                            c46627q.field_talkerId = c7620bi.field_talkerId;
                            c46627q.field_createTime = c7620bi.field_createTime;
                            c46627q.field_imgPath = c7620bi.field_imgPath;
                            c46627q.mo53212ht(c7620bi.dqI);
                            c46627q.mo53213ix(c7620bi.dqJ);
                            if (obj != null) {
                            }
                            if (B == null) {
                            }
                            i++;
                        }
                    }
                    i3.close();
                }
                C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrate %d/%d", Integer.valueOf(c.getCount()), Integer.valueOf(i));
                c.close();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() | 2));
                AppMethodBeat.m2505o(11896);
            }
        }
        j = 0;
        i = 0;
        for (i2 = 0; i2 < 50; i2++) {
            c7617ak = new C7617ak();
            c7617ak.mo8995d(c);
            i3 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15339i(c7617ak.field_username, 3, 0);
            while (i3.moveToNext()) {
            }
            i3.close();
        }
        C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doMigrate %d/%d", Integer.valueOf(c.getCount()), Integer.valueOf(i));
        c.close();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() | 2));
        AppMethodBeat.m2505o(11896);
    }

    /* renamed from: mL */
    public static boolean m48273mL(long j) {
        AppMethodBeat.m2504i(11897);
        if (C41747z.aeX().mo64117mG(j) <= 0) {
            AppMethodBeat.m2505o(11897);
            return false;
        }
        if (C41747z.aeX().drB() <= C41747z.aeX().drL()) {
            C41747z.aeX().drM();
        }
        C41747z.aeX().mo64116mF(j);
        AppMethodBeat.m2505o(11897);
        return true;
    }

    /* renamed from: ao */
    public static void m48271ao(C7620bi c7620bi) {
        AppMethodBeat.m2504i(11898);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(11898);
            return;
        }
        C41747z.aeX().mo64120mJ(c7620bi.field_msgId);
        AppMethodBeat.m2505o(11898);
    }

    /* renamed from: ag */
    private static long m48269ag(long j, long j2) {
        long j3;
        long j4 = -1;
        AppMethodBeat.m2504i(11899);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_GROUP_START_TIME_STRING_SYNC, (Object) "");
        if (!C5046bo.isNullOrNil(str)) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split.length == 2 && C5046bo.getLong(split[0], -1) == j) {
                j4 = j2 - C5046bo.getLong(split[1], -1);
            }
        }
        if (j4 < 0) {
            j3 = 604800;
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_TIME_LINE_GROUP_START_TIME_STRING_SYNC, j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + (j2 - 604800));
            C4990ab.m7411d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", r2, Long.valueOf(j2));
        } else {
            C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", str, Long.valueOf(j2));
            j3 = j4;
        }
        AppMethodBeat.m2505o(11899);
        return j3;
    }

    public static void drP() {
        AppMethodBeat.m2504i(11900);
        if (C30309s.aVO()) {
            boolean z;
            C7617ak c7617ak;
            int mI;
            long j;
            C46627q c46627q;
            C7310be XR = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR();
            C7617ak aoZ = XR.aoZ("officialaccounts");
            if (aoZ == null) {
                z = true;
                c7617ak = new C7617ak("officialaccounts");
            } else {
                z = false;
                c7617ak = aoZ;
            }
            Cursor a = C41747z.aeY().fni.mo10104a("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null, 0);
            C46627q c46627q2 = null;
            if (a.moveToFirst()) {
                c46627q2 = new C46627q();
                c46627q2.mo8995d(a);
            }
            a.close();
            C46627q drI = C41747z.aeX().drI();
            long j2 = c46627q2 != null ? c46627q2.field_createTime : 0;
            if (drI != null) {
                mI = C41747z.aeX().mo64119mI(drI.field_orderFlag);
            } else {
                mI = 0;
            }
            if (drI != null) {
                j = drI.field_createTime;
            } else {
                j = 0;
            }
            c7617ak.mo16713jk(32);
            int baS = C41747z.aeY().baS();
            if (baS <= 0 || mI <= 0) {
                if (baS > 0) {
                    c7617ak.mo16713jk(16);
                    c7617ak.mo14748hM(baS);
                    c46627q = c46627q2;
                } else {
                    c7617ak.mo16712jj(16);
                    c7617ak.mo14748hM(mI);
                    c46627q = drI;
                }
            } else if (j2 > j) {
                c7617ak.mo16713jk(16);
                c7617ak.mo14748hM(baS);
                c46627q = c46627q2;
            } else {
                c7617ak.mo16712jj(16);
                c7617ak.mo14748hM(mI);
                c46627q = drI;
            }
            if (c46627q == null || c46627q.field_msgId == 0) {
                C4990ab.m7420w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
                c7617ak.dsI();
                if (!z) {
                    XR.mo15767a(c7617ak, c7617ak.field_username);
                }
                AppMethodBeat.m2505o(11900);
                return;
            }
            long j3;
            if (c46627q == drI && c46627q.field_placeTop == 1) {
                c7617ak.mo16712jj(32);
            }
            if (c46627q == c46627q2) {
                j3 = c46627q.field_msgId;
                if (xIk == 0) {
                    xIk = C4996ah.doB().getLong("biz_time_line_last_notify_msg_id", -1);
                }
                if (j3 == xIk) {
                    c7617ak.mo16713jk(64);
                } else {
                    c7617ak.mo16712jj(64);
                }
            }
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(c46627q.field_msgId);
            if (jf.field_msgId > 0) {
                c7617ak.mo17068ap(jf);
                c7617ak.setContent(jf.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + jf.field_content);
                c7617ak.mo14757jg(Integer.toString(jf.getType()));
                C5133b Cb = XR.mo15765Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    jf.mo14794ju("officialaccounts");
                    jf.setContent(c7617ak.field_content);
                    Cb.mo10533a(jf, pString, pString2, pInt, true);
                    c7617ak.mo14758jh(pString.value);
                    c7617ak.mo14759ji(pString2.value);
                    c7617ak.mo14751hP(pInt.value);
                }
            } else {
                c7617ak.dsI();
                C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "lastOfMsg is null or MsgId <= 0, lastTalker is %s", c46627q.field_talker);
            }
            if (j2 > j) {
                j = j2;
            }
            c7617ak.mo14742eD(j);
            if (z) {
                j3 = XR.mo15807d(c7617ak);
            } else {
                j3 = (long) XR.mo15767a(c7617ak, c7617ak.field_username);
            }
            C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d", Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(c7617ak.field_conversationTime));
            AppMethodBeat.m2505o(11900);
            return;
        }
        AppMethodBeat.m2505o(11900);
    }

    public static void aom(String str) {
        xIj = str;
    }

    /* renamed from: mM */
    public static void m48274mM(long j) {
        AppMethodBeat.m2504i(11901);
        xIk = j;
        C4996ah.doB().edit().putLong("biz_time_line_last_notify_msg_id", j).apply();
        AppMethodBeat.m2505o(11901);
    }

    /* renamed from: Mj */
    public static void m48267Mj(int i) {
        ctE = i;
    }

    public static int getSessionId() {
        return ctE;
    }

    public static boolean aVO() {
        AppMethodBeat.m2504i(11902);
        boolean booleanValue;
        if (xIl != null) {
            booleanValue = xIl.booleanValue();
            AppMethodBeat.m2505o(11902);
            return booleanValue;
        }
        int decodeInt = C5018as.m7465eg("brandService", 1).decodeInt("BizTimeLineOpenStatus", -1);
        if (decodeInt == 1) {
            xIl = Boolean.TRUE;
        } else if (decodeInt == 0) {
            xIl = Boolean.FALSE;
        }
        if (xIl != null) {
            booleanValue = xIl.booleanValue();
            AppMethodBeat.m2505o(11902);
            return booleanValue;
        }
        C5141c ll = C18624c.abi().mo17131ll("100391");
        booleanValue = ll.isValid() && "1".equals(ll.dru().get("isOpenSubscribeListVersion1"));
        xIl = Boolean.valueOf(booleanValue);
        C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", xIl);
        if (!xIl.booleanValue() && (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() & 1) > 0) {
            xIl = Boolean.TRUE;
            C4990ab.m7416i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen migrated user");
        }
        if (!xIl.booleanValue() && C26373g.m41964Nu().getInt("BizTimeLineOpen", 0) == 1) {
            xIl = Boolean.TRUE;
            C4990ab.m7416i("MicroMsg.BizTimeLineInfoStorageLogic", "BizTimeLineOpen dynamicConfigOpen user");
        }
        booleanValue = xIl.booleanValue();
        AppMethodBeat.m2505o(11902);
        return booleanValue;
    }
}
