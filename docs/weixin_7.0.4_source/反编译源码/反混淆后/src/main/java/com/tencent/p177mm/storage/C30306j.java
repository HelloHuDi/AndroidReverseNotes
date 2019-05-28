package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.protocal.protobuf.C44122go;
import com.tencent.p177mm.protocal.protobuf.C44123gp;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.storage.j */
public final class C30306j extends C7563j<C40630i> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C40630i.ccO, "BackupMoveTime")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(29009);
        AppMethodBeat.m2505o(29009);
    }

    public C30306j(C7480h c7480h) {
        super(c7480h, C40630i.ccO, "BackupMoveTime", null);
        AppMethodBeat.m2504i(29003);
        this.bSd = c7480h;
        long currentTimeMillis = System.currentTimeMillis();
        long iV = c7480h.mo15639iV(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new String[]{"CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )"}));
        for (int i = 0; i < arrayList.size(); i++) {
            c7480h.mo10108hY("BackupMoveTime", (String) arrayList.get(i));
        }
        C4990ab.m7411d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        c7480h.mo15640mB(iV);
        C4990ab.m7417i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(29003);
    }

    /* renamed from: a */
    public final void mo48593a(String str, LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        AppMethodBeat.m2504i(29004);
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            Object obj = null;
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (!it.hasNext()) {
                    break;
                }
                C44123gp c44123gp;
                long longValue2 = ((Long) it.next()).longValue();
                if (longValue2 == 0) {
                    longValue2 = Long.MAX_VALUE;
                }
                String str3 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" AND sessionName = \"" + str2 + "\" ";
                C4990ab.m7410d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:".concat(String.valueOf(str3)));
                Cursor rawQuery = this.bSd.rawQuery(str3, null);
                if (rawQuery == null) {
                    C4990ab.m7413e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", str, str2);
                    c44123gp = null;
                } else if (rawQuery.moveToFirst()) {
                    C40630i c40630i = new C40630i();
                    c40630i.mo8995d(rawQuery);
                    rawQuery.close();
                    c44123gp = c40630i.field_moveTime;
                } else {
                    rawQuery.close();
                    c44123gp = null;
                }
                if (c44123gp == null || c44123gp.vIM.size() <= 0 || longValue2 < ((C44122go) c44123gp.vIM.getFirst()).startTime || longValue > ((C44122go) c44123gp.vIM.getLast()).endTime) {
                    linkedList3.add(str2);
                    linkedList4.add(Long.valueOf(longValue));
                    linkedList4.add(Long.valueOf(longValue2));
                } else {
                    Object obj2;
                    LinkedList linkedList5 = c44123gp.vIM;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= linkedList5.size() || longValue > longValue2) {
                            obj2 = obj;
                        } else {
                            C44122go c44122go = (C44122go) linkedList5.get(i2);
                            if (longValue <= c44122go.endTime) {
                                if (longValue < c44122go.startTime) {
                                    obj = 1;
                                    linkedList3.add(str2);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < c44122go.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = c44122go.startTime;
                                        obj2 = 1;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(c44122go.startTime));
                                }
                                longValue = c44122go.endTime;
                            }
                            i = i2 + 1;
                        }
                    }
                    obj2 = obj;
                    if (longValue <= longValue2) {
                        linkedList3.add(str2);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        linkedList3.add(str2);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(29004);
    }

    /* renamed from: f */
    public final void mo48595f(String str, LinkedList<C15443m> linkedList) {
        HashMap hashMap;
        AppMethodBeat.m2504i(29005);
        C4990ab.m7416i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
        HashMap hashMap2 = new HashMap();
        String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" ";
        C4990ab.m7410d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:".concat(String.valueOf(str2)));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        if (rawQuery == null) {
            C4990ab.m7413e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", str);
            hashMap = hashMap2;
        } else {
            while (rawQuery.moveToNext()) {
                C40630i c40630i = new C40630i();
                c40630i.mo8995d(rawQuery);
                hashMap2.put(c40630i.field_sessionName, c40630i);
            }
            rawQuery.close();
            hashMap = hashMap2;
        }
        if (this.bSd.delete("BackupMoveTime", "deviceId= ? ", new String[]{String.valueOf(str)}) < 0) {
            C4990ab.m7413e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", str);
            AppMethodBeat.m2505o(29005);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C15443m c15443m = (C15443m) it.next();
            C40630i c40630i2 = (C40630i) hashMap.get(c15443m.field_sessionName);
            if (c40630i2 == null) {
                C44122go c44122go = new C44122go();
                c44122go.startTime = c15443m.field_startTime;
                c44122go.endTime = c15443m.field_endTime;
                C40630i c40630i3 = new C40630i();
                c40630i3.field_deviceId = str;
                c40630i3.field_sessionName = c15443m.field_sessionName;
                c40630i3.field_moveTime = new C44123gp();
                c40630i3.field_moveTime.vIM = new LinkedList();
                c40630i3.field_moveTime.vIM.add(c44122go);
                hashMap.put(c15443m.field_sessionName, c40630i3);
            } else {
                C30306j.m48262a(c40630i2.field_moveTime.vIM, c15443m);
            }
        }
        for (String str3 : hashMap.keySet()) {
            C4990ab.m7417i("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId insert BackupMoveTimeStorage ret[%b], sessionName:%s", Boolean.valueOf(mo10101b((C4925c) hashMap.get(str3))), str3);
        }
        AppMethodBeat.m2505o(29005);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m48262a(LinkedList<C44122go> linkedList, C15443m c15443m) {
        AppMethodBeat.m2504i(29006);
        if (c15443m.field_startTime > c15443m.field_endTime) {
            AppMethodBeat.m2505o(29006);
            return;
        }
        Object obj;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C44122go c44122go = (C44122go) it.next();
            if (c15443m.field_startTime < c44122go.endTime) {
                if (c15443m.field_endTime < c44122go.startTime) {
                    c44122go = new C44122go();
                    c44122go.startTime = c15443m.field_startTime;
                    c44122go.endTime = c15443m.field_endTime;
                    linkedList.add(c44122go);
                    obj = 1;
                } else {
                    int obj2;
                    if (c15443m.field_startTime < c44122go.startTime) {
                        c44122go.startTime = c15443m.field_startTime;
                    }
                    if (c15443m.field_endTime > c44122go.endTime) {
                        c44122go.endTime = c15443m.field_endTime;
                        while (it.hasNext()) {
                            C44122go c44122go2 = (C44122go) it.next();
                            if (c15443m.field_endTime <= c44122go2.startTime) {
                                break;
                            } else if (c15443m.field_endTime <= c44122go2.endTime) {
                                c44122go.endTime = c44122go2.endTime;
                                it.remove();
                                obj2 = 1;
                                break;
                            } else {
                                it.remove();
                            }
                        }
                    }
                    obj2 = 1;
                }
                if (obj2 == null) {
                    c44122go = new C44122go();
                    c44122go.startTime = c15443m.field_startTime;
                    c44122go.endTime = c15443m.field_endTime;
                    linkedList.add(c44122go);
                }
                AppMethodBeat.m2505o(29006);
            }
        }
        obj2 = null;
        if (obj2 == null) {
        }
        AppMethodBeat.m2505o(29006);
    }

    public final boolean drx() {
        AppMethodBeat.m2504i(29007);
        C4990ab.m7417i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", Boolean.valueOf(this.bSd.mo10108hY("BackupMoveTime", "delete from BackupMoveTime")));
        AppMethodBeat.m2505o(29007);
        return this.bSd.mo10108hY("BackupMoveTime", "delete from BackupMoveTime");
    }
}
