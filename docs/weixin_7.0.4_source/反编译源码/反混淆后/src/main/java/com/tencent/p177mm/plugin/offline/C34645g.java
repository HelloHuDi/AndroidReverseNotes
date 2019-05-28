package com.tencent.p177mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p1496b.C34644a;
import com.tencent.p177mm.plugin.offline.p478a.C12735d;
import com.tencent.p177mm.plugin.offline.p478a.C21404r;
import com.tencent.p177mm.plugin.offline.p478a.C21405s;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.offline.g */
public final class C34645g {
    public static String TAG = "MicroMsg.OfflineGetMsgLogic";
    public static int oWV = 5000;
    private static int oWW;
    private static int oWX = 5000;
    public static int oWY = 0;
    public static int oWZ = 24;
    public static int oXa = 4;
    public static int oXb = 8;
    public static int oXc = 23;
    public static int oXd = 6;
    public static int oXe = 5;
    public static int oXf = 20;
    public static int oXg = C1625i.sHCENCODEVIDEOTIMEOUT;
    public static int oXh = CdnLogic.kMediaTypeBackupFile;
    public static int oXi = 10001;
    public static int oXj;
    public C1202f oXk = new C127431();
    public boolean oXl = true;
    public C7564ap oXm = new C7564ap(new C286372(), false);
    public int status = 0;

    /* renamed from: com.tencent.mm.plugin.offline.g$1 */
    class C127431 implements C1202f {
        C127431() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(43312);
            if ((c1207m instanceof C12735d) && i == 0 && i2 == 0) {
                C12735d c12735d = (C12735d) c1207m;
                C34645g.oXj = c12735d.oXW;
                if (C34645g.oXj == 0) {
                    C34645g.oXj = C34645g.oWX;
                }
                C4990ab.m7417i(C34645g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", c12735d.oXX, c12735d.oXV);
                if (C5046bo.isNullOrNil(c12735d.oXV) || C5046bo.isNullOrNil(c12735d.oXX)) {
                    C4990ab.m7416i(C34645g.TAG, "OfflineGetMsgLogic msg is null");
                } else if (C34645g.m56849fy(c12735d.oXX, c12735d.oXV)) {
                    C4990ab.m7416i(C34645g.TAG, "from cgi");
                    if (C5049br.m7595z(c12735d.oXV, "sysmsg") == null) {
                        AppMethodBeat.m2505o(43312);
                        return;
                    }
                    C7060h.pYm.mo8378a(135, 71, 1, true);
                    C7007k.bXg();
                    C21405s bXh = C7007k.bXh();
                    String str2 = c12735d.oXV;
                    C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
                    if (!TextUtils.isEmpty(str2)) {
                        Map z = C5049br.m7595z(str2, "sysmsg");
                        int i3;
                        if (z != null) {
                            z.get(".sysmsg.paymsg.ack_key");
                            i3 = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                        } else {
                            i3 = -1;
                        }
                        if (!(!C28630a.bYE() || i3 == 7 || i3 == 10)) {
                            C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
                            bXh.mo36864TW(str2);
                            bXh.mo36865TX(str2);
                        }
                    }
                }
                C4990ab.m7416i(C34645g.TAG, "mIntercal=" + C34645g.oXj);
                long access$000 = (long) C34645g.oXj;
                C34645g.this.oXm.mo16770ae(access$000, access$000);
            }
            AppMethodBeat.m2505o(43312);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.g$2 */
    class C286372 implements C5015a {
        C286372() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(43313);
            if (C34645g.this.oXm != null) {
                if (!C1720g.m3531RK()) {
                    long access$400 = (long) C34645g.oWV;
                    C34645g.this.oXm.mo16770ae(access$400, access$400);
                    AppMethodBeat.m2505o(43313);
                    return false;
                } else if (C28630a.bYE() && C28630a.bYd()) {
                    C34645g.bXd();
                }
            }
            AppMethodBeat.m2505o(43313);
            return false;
        }
    }

    static {
        int intValue;
        AppMethodBeat.m2504i(43323);
        oWW = 30000;
        oXj = oWX;
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            oXj = intValue;
            if (intValue == 0) {
                oXj = oWX;
            }
        }
        C1720g.m3537RQ();
        obj = C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_OFFLINE_GETMSG_MAX_POS_TIME_INT, Integer.valueOf(0));
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            if (intValue != 0) {
                oWW = intValue;
            }
        }
        AppMethodBeat.m2505o(43323);
    }

    public static int bXb() {
        return oWW;
    }

    public C34645g() {
        AppMethodBeat.m2504i(43314);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, this.oXk);
        AppMethodBeat.m2505o(43314);
    }

    /* renamed from: a */
    private static boolean m56845a(C21404r c21404r) {
        boolean z = false;
        AppMethodBeat.m2504i(43315);
        if (c21404r != null) {
            C4990ab.m7416i(TAG, "isOrderClosed lastest status req_key=" + c21404r.field_reqkey);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(oXg));
        hashSet.add(Integer.valueOf(oXd));
        hashSet.add(Integer.valueOf(oXe));
        hashSet.add(Integer.valueOf(oXa));
        hashSet.add(Integer.valueOf(-1));
        if (c21404r == null || hashSet.contains(Integer.valueOf(c21404r.field_status))) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("isOrderClosed true;status==null?");
            if (c21404r == null) {
                z = true;
            }
            C4990ab.m7416i(str, stringBuilder.append(z).toString());
            if (c21404r != null) {
                C4990ab.m7416i(TAG, "isOrderClosed status.field_status=" + c21404r.field_status);
            }
            AppMethodBeat.m2505o(43315);
            return true;
        }
        C4990ab.m7416i(TAG, "isOrderClosed false");
        if (c21404r != null) {
            C4990ab.m7416i(TAG, "status=" + c21404r.field_status + ";req_key=" + c21404r.field_reqkey);
        } else {
            C4990ab.m7416i(TAG, "isOrderClosed status=null");
        }
        AppMethodBeat.m2505o(43315);
        return false;
    }

    /* renamed from: eN */
    private static boolean m56848eN(int i, int i2) {
        AppMethodBeat.m2504i(43317);
        C4990ab.m7416i(TAG, "checkStatus from=" + i + ";to=" + i2);
        if (i == i2) {
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i == oWY) {
            AppMethodBeat.m2505o(43317);
            return true;
        } else if (i == oWZ) {
            if (i2 != oWZ) {
                AppMethodBeat.m2505o(43317);
                return true;
            }
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i == oXd) {
            if (i2 == oXg) {
                AppMethodBeat.m2505o(43317);
                return true;
            }
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i == oXe) {
            if (i2 == oXg) {
                AppMethodBeat.m2505o(43317);
                return true;
            }
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i == oXa) {
            if (i2 == oXg) {
                AppMethodBeat.m2505o(43317);
                return true;
            }
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i == oXf) {
            if (i2 == oXg) {
                AppMethodBeat.m2505o(43317);
                return true;
            }
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i == oXb || i == oXc) {
            if (i2 == oXd || i2 == oXg) {
                AppMethodBeat.m2505o(43317);
                return true;
            }
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i != oXi) {
            AppMethodBeat.m2505o(43317);
            return false;
        } else if (i2 == oXd || i2 == oXg) {
            AppMethodBeat.m2505o(43317);
            return true;
        } else {
            AppMethodBeat.m2505o(43317);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m56846a(C21404r c21404r, int i) {
        AppMethodBeat.m2504i(43318);
        if (i == oXa) {
            i = oXg;
        }
        boolean eN = C34645g.m56848eN(c21404r.field_status, i);
        C4990ab.m7417i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", Boolean.valueOf(eN), Integer.valueOf(c21404r.field_status), Integer.valueOf(i));
        if (eN) {
            c21404r.field_status = i;
            C7007k.bXg();
            C7007k.bXk().mo55239c(c21404r);
        }
        AppMethodBeat.m2505o(43318);
        return eN;
    }

    /* renamed from: cM */
    public static void m56847cM(String str, int i) {
        AppMethodBeat.m2504i(43319);
        if (!C5046bo.isNullOrNil(str)) {
            C7007k.bXg();
            C21404r TY = C7007k.bXk().mo55234TY(str);
            if (TY != null) {
                C34645g.m56846a(TY, i);
                AppMethodBeat.m2505o(43319);
                return;
            }
            TY = new C21404r();
            TY.field_reqkey = str;
            TY.field_status = i;
            C7007k.bXg();
            C7007k.bXk().mo55239c(TY);
        }
        AppMethodBeat.m2505o(43319);
    }

    public static void bXc() {
        AppMethodBeat.m2504i(43320);
        C4990ab.m7416i(TAG, "endAllOldOrder");
        C7007k.bXg();
        C34644a bXk = C7007k.bXk();
        C4990ab.m7417i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", Integer.valueOf(bXk.bXq()), bXk.bXp());
        Cursor a = bXk.bSd.mo10104a(String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[]{"rowid", "OfflineOrderStatus", "rowid"}), null, 2);
        long j = 0;
        if (a == null) {
            C4990ab.m7412e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
        } else {
            a.moveToFirst();
            if (!a.isAfterLast() && a.getColumnCount() > 0) {
                j = a.getLong(0);
            }
            a.close();
        }
        if (j - 10 > 0) {
            C4990ab.m7417i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", Long.valueOf(j), String.format("DELETE FROM %s WHERE %s < %d;", new Object[]{"OfflineOrderStatus", "rowid", Long.valueOf(j - 10)}));
            bXk.bSd.mo10108hY("OfflineOrderStatus", r3);
        } else {
            C4990ab.m7417i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", Long.valueOf(j));
        }
        bXk.bSd.mo10108hY("OfflineOrderStatus", "UPDATE OfflineOrderStatus SET status=" + oXg + " where status!=" + oXg);
        AppMethodBeat.m2505o(43320);
    }

    public final void stop() {
        AppMethodBeat.m2504i(43321);
        if (C28630a.bYE()) {
            C4990ab.m7416i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.oXm.doT());
            if (!this.oXm.doT()) {
                C7060h.pYm.mo8378a(135, 62, 1, true);
                this.oXm.stopTimer();
            }
        }
        AppMethodBeat.m2505o(43321);
    }

    /* renamed from: fy */
    public static boolean m56849fy(String str, String str2) {
        Object obj;
        Map z;
        String str3;
        int i;
        AppMethodBeat.m2504i(43316);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7416i(TAG, "shouldDeal appmsg is null");
            obj = null;
        } else {
            String str4;
            String str5;
            int i2;
            boolean z2;
            Object[] objArr;
            Object[] objArr2;
            z = C5049br.m7595z(str2, "sysmsg");
            str3 = (String) z.get(".sysmsg.paymsg.req_key");
            i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            C7007k.bXg();
            C21404r TY = C7007k.bXk().mo55234TY(str3);
            C7007k.bXg();
            C21404r bXo = C7007k.bXk().bXo();
            boolean a = C34645g.m56845a(bXo);
            if (TY != null) {
                C7060h.pYm.mo8378a(135, 63, 1, true);
            } else {
                C7060h.pYm.mo8378a(135, 64, 1, true);
            }
            Object[] objArr3;
            if (bXo != null) {
                str4 = TAG;
                str5 = "latestStatus: reqKey: %s, status:%d, isLatestClose: %b";
                objArr3 = new Object[3];
                objArr3[0] = bXo.field_reqkey;
                objArr3[1] = Integer.valueOf(bXo.field_status);
                i2 = 2;
                z2 = a;
                objArr = objArr3;
                objArr2 = objArr3;
            } else {
                str4 = TAG;
                str5 = "latestStatus is null. isLatestClose: %b, localStatus is null ?: %b";
                objArr3 = new Object[2];
                objArr3[0] = Boolean.valueOf(a);
                i2 = 1;
                if (TY == null) {
                    z2 = true;
                    objArr = objArr3;
                    objArr2 = objArr3;
                } else {
                    z2 = false;
                    objArr = objArr3;
                    objArr2 = objArr3;
                }
            }
            objArr[i2] = Boolean.valueOf(z2);
            C4990ab.m7417i(str4, str5, objArr2);
            if (TY == null) {
                if (bXo == null) {
                    C4990ab.m7417i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", str3, Integer.valueOf(i));
                    obj = 1;
                } else if (a) {
                    C4990ab.m7417i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", str3, Integer.valueOf(i), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    obj = 1;
                } else {
                    C4990ab.m7417i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", str3, Integer.valueOf(i), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    obj = null;
                }
            } else if (C34645g.m56845a(TY)) {
                C4990ab.m7417i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", TY.field_reqkey, Integer.valueOf(i), Integer.valueOf(TY.field_status));
                obj = null;
            } else if (bXo == null) {
                C4990ab.m7417i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status));
                C7007k.bXg();
                C7007k.bXk().mo55235TZ(str3);
                obj = null;
            } else {
                C4990ab.m7417i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                if (TY.field_reqkey.equals(bXo.field_reqkey)) {
                    if (C34645g.m56848eN(bXo.field_status, i)) {
                        C4990ab.m7417i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                        obj = 1;
                    } else {
                        C4990ab.m7417i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                        if (bXo.field_status != i) {
                            C4990ab.m7417i(TAG, "mark reqKey: %s as give up", str3);
                            C7007k.bXg();
                            C7007k.bXk().mo55235TZ(str3);
                        }
                        obj = null;
                    }
                } else if (a) {
                    C4990ab.m7417i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    obj = 1;
                } else {
                    C4990ab.m7417i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    C7007k.bXg();
                    C7007k.bXk().mo55235TZ(str3);
                    obj = null;
                }
            }
        }
        if (obj != null) {
            C7007k.bXg();
            C21404r bXo2 = C7007k.bXk().bXo();
            z = C5049br.m7595z(str2, "sysmsg");
            i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            str3 = (String) z.get(".sysmsg.paymsg.req_key");
            if (i == 24) {
                C7060h.pYm.mo8378a(135, 58, 1, true);
            } else if (i == 6) {
                C7060h.pYm.mo8378a(135, 59, 1, true);
            } else if (i == 4 || i == 5 || i == 20) {
                C7060h.pYm.mo8378a(135, 60, 1, true);
            } else if (i == 23) {
                C7060h.pYm.mo8378a(135, 66, 1, true);
            }
            if (bXo2 == null || bXo2.field_reqkey == null || !bXo2.field_reqkey.equals(str3)) {
                C21404r c21404r = new C21404r();
                c21404r.field_reqkey = str3;
                if (!C5046bo.isNullOrNil(str)) {
                    c21404r.field_ack_key = str;
                }
                c21404r.field_status = oWY;
                C34645g.m56846a(c21404r, i);
            } else {
                C34645g.m56846a(bXo2, i);
            }
            C4990ab.m7416i(TAG, "dealMsg true");
            AppMethodBeat.m2505o(43316);
            return true;
        }
        C4990ab.m7416i(TAG, "dealMsg false");
        AppMethodBeat.m2505o(43316);
        return false;
    }

    static /* synthetic */ void bXd() {
        AppMethodBeat.m2504i(43322);
        C4990ab.m7416i(TAG, "doGetOfflineMsg doScene:NetSceneOfflineGetMsg");
        C1207m c12735d = new C12735d();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c12735d, 0);
        AppMethodBeat.m2505o(43322);
    }
}
