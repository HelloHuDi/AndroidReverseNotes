package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends com.tencent.mm.sdk.e.j<i> {
    public static final String[] fnj = new String[]{com.tencent.mm.sdk.e.j.a(i.ccO, "BackupMoveTime")};
    public e bSd;

    static {
        AppMethodBeat.i(29009);
        AppMethodBeat.o(29009);
    }

    public j(h hVar) {
        super(hVar, i.ccO, "BackupMoveTime", null);
        AppMethodBeat.i(29003);
        this.bSd = hVar;
        long currentTimeMillis = System.currentTimeMillis();
        long iV = hVar.iV(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new String[]{"CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )"}));
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.hY("BackupMoveTime", (String) arrayList.get(i));
        }
        ab.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        hVar.mB(iV);
        ab.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(29003);
    }

    public final void a(String str, LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        AppMethodBeat.i(29004);
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
                gp gpVar;
                long longValue2 = ((Long) it.next()).longValue();
                if (longValue2 == 0) {
                    longValue2 = Long.MAX_VALUE;
                }
                String str3 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" AND sessionName = \"" + str2 + "\" ";
                ab.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:".concat(String.valueOf(str3)));
                Cursor rawQuery = this.bSd.rawQuery(str3, null);
                if (rawQuery == null) {
                    ab.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", str, str2);
                    gpVar = null;
                } else if (rawQuery.moveToFirst()) {
                    i iVar = new i();
                    iVar.d(rawQuery);
                    rawQuery.close();
                    gpVar = iVar.field_moveTime;
                } else {
                    rawQuery.close();
                    gpVar = null;
                }
                if (gpVar == null || gpVar.vIM.size() <= 0 || longValue2 < ((go) gpVar.vIM.getFirst()).startTime || longValue > ((go) gpVar.vIM.getLast()).endTime) {
                    linkedList3.add(str2);
                    linkedList4.add(Long.valueOf(longValue));
                    linkedList4.add(Long.valueOf(longValue2));
                } else {
                    Object obj2;
                    LinkedList linkedList5 = gpVar.vIM;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= linkedList5.size() || longValue > longValue2) {
                            obj2 = obj;
                        } else {
                            go goVar = (go) linkedList5.get(i2);
                            if (longValue <= goVar.endTime) {
                                if (longValue < goVar.startTime) {
                                    obj = 1;
                                    linkedList3.add(str2);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < goVar.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = goVar.startTime;
                                        obj2 = 1;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(goVar.startTime));
                                }
                                longValue = goVar.endTime;
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
        AppMethodBeat.o(29004);
    }

    public final void f(String str, LinkedList<m> linkedList) {
        HashMap hashMap;
        AppMethodBeat.i(29005);
        ab.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
        HashMap hashMap2 = new HashMap();
        String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" ";
        ab.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:".concat(String.valueOf(str2)));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        if (rawQuery == null) {
            ab.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", str);
            hashMap = hashMap2;
        } else {
            while (rawQuery.moveToNext()) {
                i iVar = new i();
                iVar.d(rawQuery);
                hashMap2.put(iVar.field_sessionName, iVar);
            }
            rawQuery.close();
            hashMap = hashMap2;
        }
        if (this.bSd.delete("BackupMoveTime", "deviceId= ? ", new String[]{String.valueOf(str)}) < 0) {
            ab.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", str);
            AppMethodBeat.o(29005);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            i iVar2 = (i) hashMap.get(mVar.field_sessionName);
            if (iVar2 == null) {
                go goVar = new go();
                goVar.startTime = mVar.field_startTime;
                goVar.endTime = mVar.field_endTime;
                i iVar3 = new i();
                iVar3.field_deviceId = str;
                iVar3.field_sessionName = mVar.field_sessionName;
                iVar3.field_moveTime = new gp();
                iVar3.field_moveTime.vIM = new LinkedList();
                iVar3.field_moveTime.vIM.add(goVar);
                hashMap.put(mVar.field_sessionName, iVar3);
            } else {
                a(iVar2.field_moveTime.vIM, mVar);
            }
        }
        for (String str3 : hashMap.keySet()) {
            ab.i("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId insert BackupMoveTimeStorage ret[%b], sessionName:%s", Boolean.valueOf(b((c) hashMap.get(str3))), str3);
        }
        AppMethodBeat.o(29005);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(LinkedList<go> linkedList, m mVar) {
        AppMethodBeat.i(29006);
        if (mVar.field_startTime > mVar.field_endTime) {
            AppMethodBeat.o(29006);
            return;
        }
        Object obj;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            go goVar = (go) it.next();
            if (mVar.field_startTime < goVar.endTime) {
                if (mVar.field_endTime < goVar.startTime) {
                    goVar = new go();
                    goVar.startTime = mVar.field_startTime;
                    goVar.endTime = mVar.field_endTime;
                    linkedList.add(goVar);
                    obj = 1;
                } else {
                    int obj2;
                    if (mVar.field_startTime < goVar.startTime) {
                        goVar.startTime = mVar.field_startTime;
                    }
                    if (mVar.field_endTime > goVar.endTime) {
                        goVar.endTime = mVar.field_endTime;
                        while (it.hasNext()) {
                            go goVar2 = (go) it.next();
                            if (mVar.field_endTime <= goVar2.startTime) {
                                break;
                            } else if (mVar.field_endTime <= goVar2.endTime) {
                                goVar.endTime = goVar2.endTime;
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
                    goVar = new go();
                    goVar.startTime = mVar.field_startTime;
                    goVar.endTime = mVar.field_endTime;
                    linkedList.add(goVar);
                }
                AppMethodBeat.o(29006);
            }
        }
        obj2 = null;
        if (obj2 == null) {
        }
        AppMethodBeat.o(29006);
    }

    public final boolean drx() {
        AppMethodBeat.i(29007);
        ab.i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", Boolean.valueOf(this.bSd.hY("BackupMoveTime", "delete from BackupMoveTime")));
        AppMethodBeat.o(29007);
        return this.bSd.hY("BackupMoveTime", "delete from BackupMoveTime");
    }
}
