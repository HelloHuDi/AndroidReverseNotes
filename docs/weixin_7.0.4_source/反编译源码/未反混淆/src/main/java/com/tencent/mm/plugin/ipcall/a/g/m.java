package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public final class m {
    public static k b(k kVar) {
        AppMethodBeat.i(21948);
        if (kVar == null) {
            AppMethodBeat.o(21948);
            return null;
        }
        ab.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", Long.valueOf(kVar.xDa));
        if (kVar.xDa != -1) {
            kVar.field_status = 7;
            i.bHx().a(kVar);
        }
        AppMethodBeat.o(21948);
        return kVar;
    }

    public static k a(k kVar, long j) {
        AppMethodBeat.i(21949);
        if (kVar == null) {
            AppMethodBeat.o(21949);
            return null;
        }
        ab.d("MicroMsg.IPCallRecordStorageLogic", "recordSelfShutdownCall, localId: %d, talkTime: %d", Long.valueOf(kVar.xDa), Long.valueOf(j));
        if (kVar.xDa != -1) {
            kVar.field_status = 4;
            kVar.field_duration = j;
            i.bHx().a(kVar);
        }
        AppMethodBeat.o(21949);
        return kVar;
    }

    public static Cursor OW(String str) {
        AppMethodBeat.i(21950);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(21950);
            return null;
        }
        c OQ = i.bHw().OQ(str);
        if (OQ == null || OQ.xDa == -1) {
            AppMethodBeat.o(21950);
            return null;
        }
        long j = OQ.xDa;
        Cursor query = i.bHx().bSd.query("IPCallRecord", l.nzF, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc limit 4");
        AppMethodBeat.o(21950);
        return query;
    }

    public static ArrayList<k> bIb() {
        Cursor query;
        AppMethodBeat.i(21951);
        long currentTimeMillis = System.currentTimeMillis();
        l bHx = i.bHx();
        Calendar instance = Calendar.getInstance();
        instance.add(6, -30);
        long timeInMillis = instance.getTimeInMillis();
        Cursor query2 = bHx.bSd.query("IPCallRecord", l.nzF, "calltime>=?", new String[]{String.valueOf(timeInMillis)}, "addressId, phonenumber", null, "calltime desc");
        if (query2.getCount() < 30) {
            query2.close();
            query = i.bHx().bSd.query("IPCallRecord", l.nzF, null, null, "addressId, phonenumber", null, "calltime desc");
        } else {
            query = query2;
        }
        ab.d("MicroMsg.IPCallRecordStorageLogic", "finish query used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            if (query.moveToFirst()) {
                while (!query.isAfterLast() && arrayList.size() <= 30) {
                    k kVar = new k();
                    kVar.d(query);
                    if (kVar.field_addressId == -1) {
                        c OR = i.bHw().OR(a.aF(ah.getContext(), kVar.field_phonenumber));
                        if (OR != null) {
                            long iV;
                            bHx = i.bHx();
                            if (bHx.bSd instanceof h) {
                                iV = ((h) bHx.bSd).iV(-1);
                            } else {
                                iV = -1;
                            }
                            query2 = i.bHx().OV(kVar.field_phonenumber);
                            if (query2.moveToFirst()) {
                                while (!query2.isAfterLast()) {
                                    k kVar2 = new k();
                                    kVar2.d(query2);
                                    kVar2.field_addressId = OR.xDa;
                                    i.bHx().a(kVar2);
                                    query2.moveToNext();
                                }
                            }
                            bHx = i.bHx();
                            if ((bHx.bSd instanceof h) && iV != -1) {
                                ((h) bHx.bSd).mB(iV);
                            }
                            if (!hashMap.containsKey(kVar.field_addressId)) {
                                hashMap.put(kVar.field_addressId, kVar);
                                arrayList.add(kVar);
                            }
                        } else if (!hashMap.containsKey(kVar.field_phonenumber)) {
                            hashMap.put(kVar.field_phonenumber, kVar);
                            arrayList.add(kVar);
                        }
                    } else if (!hashMap.containsKey(kVar.field_addressId)) {
                        hashMap.put(kVar.field_addressId, kVar);
                        arrayList.add(kVar);
                    }
                    query.moveToNext();
                }
            }
            query.close();
        } catch (Exception e) {
            ab.e("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser error: %s", e.getMessage());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.o(21951);
        }
        ab.d("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser, used: %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(21951);
        return arrayList;
    }
}
