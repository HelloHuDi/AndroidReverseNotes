package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.m */
public final class C12256m {
    /* renamed from: b */
    public static C28332k m20186b(C28332k c28332k) {
        AppMethodBeat.m2504i(21948);
        if (c28332k == null) {
            AppMethodBeat.m2505o(21948);
            return null;
        }
        C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", Long.valueOf(c28332k.xDa));
        if (c28332k.xDa != -1) {
            c28332k.field_status = 7;
            C21088i.bHx().mo46245a(c28332k);
        }
        AppMethodBeat.m2505o(21948);
        return c28332k;
    }

    /* renamed from: a */
    public static C28332k m20185a(C28332k c28332k, long j) {
        AppMethodBeat.m2504i(21949);
        if (c28332k == null) {
            AppMethodBeat.m2505o(21949);
            return null;
        }
        C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "recordSelfShutdownCall, localId: %d, talkTime: %d", Long.valueOf(c28332k.xDa), Long.valueOf(j));
        if (c28332k.xDa != -1) {
            c28332k.field_status = 4;
            c28332k.field_duration = j;
            C21088i.bHx().mo46245a(c28332k);
        }
        AppMethodBeat.m2505o(21949);
        return c28332k;
    }

    /* renamed from: OW */
    public static Cursor m20184OW(String str) {
        AppMethodBeat.m2504i(21950);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(21950);
            return null;
        }
        C21083c OQ = C21088i.bHw().mo36404OQ(str);
        if (OQ == null || OQ.xDa == -1) {
            AppMethodBeat.m2505o(21950);
            return null;
        }
        long j = OQ.xDa;
        Cursor query = C21088i.bHx().bSd.query("IPCallRecord", C28333l.nzF, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc limit 4");
        AppMethodBeat.m2505o(21950);
        return query;
    }

    public static ArrayList<C28332k> bIb() {
        Cursor query;
        AppMethodBeat.m2504i(21951);
        long currentTimeMillis = System.currentTimeMillis();
        C28333l bHx = C21088i.bHx();
        Calendar instance = Calendar.getInstance();
        instance.add(6, -30);
        long timeInMillis = instance.getTimeInMillis();
        Cursor query2 = bHx.bSd.query("IPCallRecord", C28333l.nzF, "calltime>=?", new String[]{String.valueOf(timeInMillis)}, "addressId, phonenumber", null, "calltime desc");
        if (query2.getCount() < 30) {
            query2.close();
            query = C21088i.bHx().bSd.query("IPCallRecord", C28333l.nzF, null, null, "addressId, phonenumber", null, "calltime desc");
        } else {
            query = query2;
        }
        C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "finish query used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            if (query.moveToFirst()) {
                while (!query.isAfterLast() && arrayList.size() <= 30) {
                    C28332k c28332k = new C28332k();
                    c28332k.mo8995d(query);
                    if (c28332k.field_addressId == -1) {
                        C21083c OR = C21088i.bHw().mo36405OR(C46041a.m85641aF(C4996ah.getContext(), c28332k.field_phonenumber));
                        if (OR != null) {
                            long iV;
                            bHx = C21088i.bHx();
                            if (bHx.bSd instanceof C7480h) {
                                iV = ((C7480h) bHx.bSd).mo15639iV(-1);
                            } else {
                                iV = -1;
                            }
                            query2 = C21088i.bHx().mo46244OV(c28332k.field_phonenumber);
                            if (query2.moveToFirst()) {
                                while (!query2.isAfterLast()) {
                                    C28332k c28332k2 = new C28332k();
                                    c28332k2.mo8995d(query2);
                                    c28332k2.field_addressId = OR.xDa;
                                    C21088i.bHx().mo46245a(c28332k2);
                                    query2.moveToNext();
                                }
                            }
                            bHx = C21088i.bHx();
                            if ((bHx.bSd instanceof C7480h) && iV != -1) {
                                ((C7480h) bHx.bSd).mo15640mB(iV);
                            }
                            if (!hashMap.containsKey(c28332k.field_addressId)) {
                                hashMap.put(c28332k.field_addressId, c28332k);
                                arrayList.add(c28332k);
                            }
                        } else if (!hashMap.containsKey(c28332k.field_phonenumber)) {
                            hashMap.put(c28332k.field_phonenumber, c28332k);
                            arrayList.add(c28332k);
                        }
                    } else if (!hashMap.containsKey(c28332k.field_addressId)) {
                        hashMap.put(c28332k.field_addressId, c28332k);
                        arrayList.add(c28332k);
                    }
                    query.moveToNext();
                }
            }
            query.close();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser error: %s", e.getMessage());
            query.close();
        } catch (Throwable th) {
            query.close();
            AppMethodBeat.m2505o(21951);
        }
        C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser, used: %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(21951);
        return arrayList;
    }
}
