package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.util.HashSet;
import java.util.Map;

public final class g {
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
    public static int oXg = i.sHCENCODEVIDEOTIMEOUT;
    public static int oXh = CdnLogic.kMediaTypeBackupFile;
    public static int oXi = 10001;
    public static int oXj;
    public f oXk = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(43312);
            if ((mVar instanceof d) && i == 0 && i2 == 0) {
                d dVar = (d) mVar;
                g.oXj = dVar.oXW;
                if (g.oXj == 0) {
                    g.oXj = g.oWX;
                }
                ab.i(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", dVar.oXX, dVar.oXV);
                if (bo.isNullOrNil(dVar.oXV) || bo.isNullOrNil(dVar.oXX)) {
                    ab.i(g.TAG, "OfflineGetMsgLogic msg is null");
                } else if (g.fy(dVar.oXX, dVar.oXV)) {
                    ab.i(g.TAG, "from cgi");
                    if (br.z(dVar.oXV, "sysmsg") == null) {
                        AppMethodBeat.o(43312);
                        return;
                    }
                    h.pYm.a(135, 71, 1, true);
                    k.bXg();
                    s bXh = k.bXh();
                    String str2 = dVar.oXV;
                    ab.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
                    if (!TextUtils.isEmpty(str2)) {
                        Map z = br.z(str2, "sysmsg");
                        int i3;
                        if (z != null) {
                            z.get(".sysmsg.paymsg.ack_key");
                            i3 = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                        } else {
                            i3 = -1;
                        }
                        if (!(!a.bYE() || i3 == 7 || i3 == 10)) {
                            ab.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
                            bXh.TW(str2);
                            bXh.TX(str2);
                        }
                    }
                }
                ab.i(g.TAG, "mIntercal=" + g.oXj);
                long access$000 = (long) g.oXj;
                g.this.oXm.ae(access$000, access$000);
            }
            AppMethodBeat.o(43312);
        }
    };
    public boolean oXl = true;
    public ap oXm = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(43313);
            if (g.this.oXm != null) {
                if (!com.tencent.mm.kernel.g.RK()) {
                    long access$400 = (long) g.oWV;
                    g.this.oXm.ae(access$400, access$400);
                    AppMethodBeat.o(43313);
                    return false;
                } else if (a.bYE() && a.bYd()) {
                    g.bXd();
                }
            }
            AppMethodBeat.o(43313);
            return false;
        }
    }, false);
    public int status = 0;

    static {
        int intValue;
        AppMethodBeat.i(43323);
        oWW = 30000;
        oXj = oWX;
        com.tencent.mm.kernel.g.RQ();
        Object obj = com.tencent.mm.kernel.g.RP().Ry().get(ac.a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            oXj = intValue;
            if (intValue == 0) {
                oXj = oWX;
            }
        }
        com.tencent.mm.kernel.g.RQ();
        obj = com.tencent.mm.kernel.g.RP().Ry().get(ac.a.BUSINESS_OFFLINE_GETMSG_MAX_POS_TIME_INT, Integer.valueOf(0));
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            if (intValue != 0) {
                oWW = intValue;
            }
        }
        AppMethodBeat.o(43323);
    }

    public static int bXb() {
        return oWW;
    }

    public g() {
        AppMethodBeat.i(43314);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(385, this.oXk);
        AppMethodBeat.o(43314);
    }

    private static boolean a(r rVar) {
        boolean z = false;
        AppMethodBeat.i(43315);
        if (rVar != null) {
            ab.i(TAG, "isOrderClosed lastest status req_key=" + rVar.field_reqkey);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(oXg));
        hashSet.add(Integer.valueOf(oXd));
        hashSet.add(Integer.valueOf(oXe));
        hashSet.add(Integer.valueOf(oXa));
        hashSet.add(Integer.valueOf(-1));
        if (rVar == null || hashSet.contains(Integer.valueOf(rVar.field_status))) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("isOrderClosed true;status==null?");
            if (rVar == null) {
                z = true;
            }
            ab.i(str, stringBuilder.append(z).toString());
            if (rVar != null) {
                ab.i(TAG, "isOrderClosed status.field_status=" + rVar.field_status);
            }
            AppMethodBeat.o(43315);
            return true;
        }
        ab.i(TAG, "isOrderClosed false");
        if (rVar != null) {
            ab.i(TAG, "status=" + rVar.field_status + ";req_key=" + rVar.field_reqkey);
        } else {
            ab.i(TAG, "isOrderClosed status=null");
        }
        AppMethodBeat.o(43315);
        return false;
    }

    private static boolean eN(int i, int i2) {
        AppMethodBeat.i(43317);
        ab.i(TAG, "checkStatus from=" + i + ";to=" + i2);
        if (i == i2) {
            AppMethodBeat.o(43317);
            return false;
        } else if (i == oWY) {
            AppMethodBeat.o(43317);
            return true;
        } else if (i == oWZ) {
            if (i2 != oWZ) {
                AppMethodBeat.o(43317);
                return true;
            }
            AppMethodBeat.o(43317);
            return false;
        } else if (i == oXd) {
            if (i2 == oXg) {
                AppMethodBeat.o(43317);
                return true;
            }
            AppMethodBeat.o(43317);
            return false;
        } else if (i == oXe) {
            if (i2 == oXg) {
                AppMethodBeat.o(43317);
                return true;
            }
            AppMethodBeat.o(43317);
            return false;
        } else if (i == oXa) {
            if (i2 == oXg) {
                AppMethodBeat.o(43317);
                return true;
            }
            AppMethodBeat.o(43317);
            return false;
        } else if (i == oXf) {
            if (i2 == oXg) {
                AppMethodBeat.o(43317);
                return true;
            }
            AppMethodBeat.o(43317);
            return false;
        } else if (i == oXb || i == oXc) {
            if (i2 == oXd || i2 == oXg) {
                AppMethodBeat.o(43317);
                return true;
            }
            AppMethodBeat.o(43317);
            return false;
        } else if (i != oXi) {
            AppMethodBeat.o(43317);
            return false;
        } else if (i2 == oXd || i2 == oXg) {
            AppMethodBeat.o(43317);
            return true;
        } else {
            AppMethodBeat.o(43317);
            return false;
        }
    }

    private static boolean a(r rVar, int i) {
        AppMethodBeat.i(43318);
        if (i == oXa) {
            i = oXg;
        }
        boolean eN = eN(rVar.field_status, i);
        ab.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", Boolean.valueOf(eN), Integer.valueOf(rVar.field_status), Integer.valueOf(i));
        if (eN) {
            rVar.field_status = i;
            k.bXg();
            k.bXk().c(rVar);
        }
        AppMethodBeat.o(43318);
        return eN;
    }

    public static void cM(String str, int i) {
        AppMethodBeat.i(43319);
        if (!bo.isNullOrNil(str)) {
            k.bXg();
            r TY = k.bXk().TY(str);
            if (TY != null) {
                a(TY, i);
                AppMethodBeat.o(43319);
                return;
            }
            TY = new r();
            TY.field_reqkey = str;
            TY.field_status = i;
            k.bXg();
            k.bXk().c(TY);
        }
        AppMethodBeat.o(43319);
    }

    public static void bXc() {
        AppMethodBeat.i(43320);
        ab.i(TAG, "endAllOldOrder");
        k.bXg();
        com.tencent.mm.plugin.offline.b.a bXk = k.bXk();
        ab.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", Integer.valueOf(bXk.bXq()), bXk.bXp());
        Cursor a = bXk.bSd.a(String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[]{"rowid", "OfflineOrderStatus", "rowid"}), null, 2);
        long j = 0;
        if (a == null) {
            ab.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
        } else {
            a.moveToFirst();
            if (!a.isAfterLast() && a.getColumnCount() > 0) {
                j = a.getLong(0);
            }
            a.close();
        }
        if (j - 10 > 0) {
            ab.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", Long.valueOf(j), String.format("DELETE FROM %s WHERE %s < %d;", new Object[]{"OfflineOrderStatus", "rowid", Long.valueOf(j - 10)}));
            bXk.bSd.hY("OfflineOrderStatus", r3);
        } else {
            ab.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", Long.valueOf(j));
        }
        bXk.bSd.hY("OfflineOrderStatus", "UPDATE OfflineOrderStatus SET status=" + oXg + " where status!=" + oXg);
        AppMethodBeat.o(43320);
    }

    public final void stop() {
        AppMethodBeat.i(43321);
        if (a.bYE()) {
            ab.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.oXm.doT());
            if (!this.oXm.doT()) {
                h.pYm.a(135, 62, 1, true);
                this.oXm.stopTimer();
            }
        }
        AppMethodBeat.o(43321);
    }

    public static boolean fy(String str, String str2) {
        Object obj;
        Map z;
        String str3;
        int i;
        AppMethodBeat.i(43316);
        if (bo.isNullOrNil(str2)) {
            ab.i(TAG, "shouldDeal appmsg is null");
            obj = null;
        } else {
            String str4;
            String str5;
            int i2;
            boolean z2;
            Object[] objArr;
            Object[] objArr2;
            z = br.z(str2, "sysmsg");
            str3 = (String) z.get(".sysmsg.paymsg.req_key");
            i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            k.bXg();
            r TY = k.bXk().TY(str3);
            k.bXg();
            r bXo = k.bXk().bXo();
            boolean a = a(bXo);
            if (TY != null) {
                h.pYm.a(135, 63, 1, true);
            } else {
                h.pYm.a(135, 64, 1, true);
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
            ab.i(str4, str5, objArr2);
            if (TY == null) {
                if (bXo == null) {
                    ab.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", str3, Integer.valueOf(i));
                    obj = 1;
                } else if (a) {
                    ab.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", str3, Integer.valueOf(i), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    obj = 1;
                } else {
                    ab.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", str3, Integer.valueOf(i), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    obj = null;
                }
            } else if (a(TY)) {
                ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", TY.field_reqkey, Integer.valueOf(i), Integer.valueOf(TY.field_status));
                obj = null;
            } else if (bXo == null) {
                ab.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status));
                k.bXg();
                k.bXk().TZ(str3);
                obj = null;
            } else {
                ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                if (TY.field_reqkey.equals(bXo.field_reqkey)) {
                    if (eN(bXo.field_status, i)) {
                        ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                        obj = 1;
                    } else {
                        ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                        if (bXo.field_status != i) {
                            ab.i(TAG, "mark reqKey: %s as give up", str3);
                            k.bXg();
                            k.bXk().TZ(str3);
                        }
                        obj = null;
                    }
                } else if (a) {
                    ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    obj = 1;
                } else {
                    ab.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", str3, Integer.valueOf(i), Integer.valueOf(TY.field_status), bXo.field_reqkey, Integer.valueOf(bXo.field_status));
                    k.bXg();
                    k.bXk().TZ(str3);
                    obj = null;
                }
            }
        }
        if (obj != null) {
            k.bXg();
            r bXo2 = k.bXk().bXo();
            z = br.z(str2, "sysmsg");
            i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            str3 = (String) z.get(".sysmsg.paymsg.req_key");
            if (i == 24) {
                h.pYm.a(135, 58, 1, true);
            } else if (i == 6) {
                h.pYm.a(135, 59, 1, true);
            } else if (i == 4 || i == 5 || i == 20) {
                h.pYm.a(135, 60, 1, true);
            } else if (i == 23) {
                h.pYm.a(135, 66, 1, true);
            }
            if (bXo2 == null || bXo2.field_reqkey == null || !bXo2.field_reqkey.equals(str3)) {
                r rVar = new r();
                rVar.field_reqkey = str3;
                if (!bo.isNullOrNil(str)) {
                    rVar.field_ack_key = str;
                }
                rVar.field_status = oWY;
                a(rVar, i);
            } else {
                a(bXo2, i);
            }
            ab.i(TAG, "dealMsg true");
            AppMethodBeat.o(43316);
            return true;
        }
        ab.i(TAG, "dealMsg false");
        AppMethodBeat.o(43316);
        return false;
    }

    static /* synthetic */ void bXd() {
        AppMethodBeat.i(43322);
        ab.i(TAG, "doGetOfflineMsg doScene:NetSceneOfflineGetMsg");
        m dVar = new d();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(dVar, 0);
        AppMethodBeat.o(43322);
    }
}
