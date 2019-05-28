package com.tencent.mm.plugin.aa.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;
import java.util.List;
import java.util.Map;

public final class k implements f {
    public static String glP = "title";
    public static String glQ = "totalPayAmount";
    public static String glR = "totalUserNumber";
    public static String glS = "perAmount";
    public static String glT = "chatRoomName";
    public static String glU = "launchScene";
    public static String glV = "payerlist";
    public static String glW = Param.TIMESTAMP;
    private static int glX = 131100026;
    private b fsC;
    private boolean glY = false;
    private Map<String, Object> glZ;
    private int mode = 0;

    public final boolean c(int i, Map<String, Object> map) {
        AppMethodBeat.i(40632);
        this.fsC = com.tencent.mm.vending.g.f.dMj();
        if (this.glY) {
            ab.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.fsC.cR(Boolean.FALSE);
            AppMethodBeat.o(40632);
            return false;
        } else if (map == null || map.size() == 0) {
            this.fsC.cR(Boolean.FALSE);
            AppMethodBeat.o(40632);
            return false;
        } else {
            ab.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", map.keySet());
            this.glY = true;
            this.glZ = map;
            this.mode = i;
            String str;
            long longValue;
            int intValue;
            String str2;
            long longValue2;
            int i2;
            if (i == a.gkT) {
                if (this.glZ.containsKey(glP) && this.glZ.containsKey(glS) && this.glZ.containsKey(glR) && this.glZ.containsKey(glU) && this.glZ.containsKey(glT) && this.glZ.containsKey(glW)) {
                    try {
                        str = (String) this.glZ.get(glP);
                        longValue = ((Long) this.glZ.get(glS)).longValue();
                        int intValue2 = ((Integer) this.glZ.get(glR)).intValue();
                        intValue = ((Integer) this.glZ.get(glU)).intValue();
                        str2 = (String) this.glZ.get(glT);
                        longValue2 = ((Long) this.glZ.get(glW)).longValue();
                        ab.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
                        g.RQ();
                        g.RO().eJo.a(new com.tencent.mm.plugin.aa.a.a.f(longValue, str, intValue2, intValue, longValue2, str2), 0);
                        if (intValue2 > 0 && intValue2 <= 10) {
                            i2 = 13;
                        } else if (intValue2 > 10 && intValue2 <= 20) {
                            i2 = 14;
                        } else if (intValue2 <= 20 || intValue2 > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        h.pYm.a(407, (long) i2, 1, false);
                        this.fsC.dMi();
                        AppMethodBeat.o(40632);
                        return true;
                    } catch (Exception e) {
                        ab.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", e.getMessage());
                        this.fsC.cR(Boolean.FALSE);
                        this.glY = false;
                        AppMethodBeat.o(40632);
                        return false;
                    }
                }
                this.fsC.cR(Boolean.FALSE);
                this.glY = false;
                AppMethodBeat.o(40632);
                return false;
            } else if (i != a.gkU) {
                AppMethodBeat.o(40632);
                return false;
            } else if (this.glZ.containsKey(glP) && this.glZ.containsKey(glS) && this.glZ.containsKey(glV) && this.glZ.containsKey(glU) && this.glZ.containsKey(glT) && this.glZ.containsKey(glW)) {
                try {
                    str = (String) this.glZ.get(glP);
                    longValue = ((Long) this.glZ.get(glS)).longValue();
                    List list = (List) this.glZ.get(glV);
                    intValue = ((Integer) this.glZ.get(glU)).intValue();
                    str2 = (String) this.glZ.get(glT);
                    longValue2 = ((Long) this.glZ.get(glW)).longValue();
                    g.RQ();
                    g.RO().eJo.a(new com.tencent.mm.plugin.aa.a.a.f(longValue, str, list, intValue, longValue2, str2), 0);
                    i2 = list.size();
                    if (i2 > 0 && i2 <= 10) {
                        i2 = 13;
                    } else if (i2 > 10 && i2 <= 20) {
                        i2 = 14;
                    } else if (i2 <= 20 || i2 > 50) {
                        i2 = 16;
                    } else {
                        i2 = 15;
                    }
                    h.pYm.a(407, (long) i2, 1, false);
                    this.fsC.dMi();
                    AppMethodBeat.o(40632);
                    return true;
                } catch (Exception e2) {
                    ab.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", e2.getMessage());
                    this.fsC.cR(Boolean.FALSE);
                    this.glY = false;
                    AppMethodBeat.o(40632);
                    return false;
                }
            } else {
                this.fsC.cR(Boolean.FALSE);
                this.glY = false;
                AppMethodBeat.o(40632);
                return false;
            }
        }
    }

    public final boolean r(Map<String, Object> map) {
        AppMethodBeat.i(40633);
        this.fsC = com.tencent.mm.vending.g.f.dMj();
        ab.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
        if (this.glY) {
            ab.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.fsC.cR(Boolean.FALSE);
            AppMethodBeat.o(40633);
            return false;
        } else if (map == null || map.size() == 0) {
            this.fsC.cR(Boolean.FALSE);
            AppMethodBeat.o(40633);
            return false;
        } else {
            this.glY = true;
            this.glZ = map;
            this.mode = a.gkV;
            if (this.mode != a.gkV) {
                this.fsC.cR(Boolean.FALSE);
                AppMethodBeat.o(40633);
                return false;
            }
            if (this.glZ.containsKey(glP) && this.glZ.containsKey(glQ) && this.glZ.containsKey(glV) && this.glZ.containsKey(glU) && this.glZ.containsKey(glT) && this.glZ.containsKey(glW)) {
                try {
                    String str = (String) this.glZ.get(glP);
                    long longValue = ((Long) this.glZ.get(glQ)).longValue();
                    List list = (List) this.glZ.get(glV);
                    int intValue = ((Integer) this.glZ.get(glU)).intValue();
                    String str2 = (String) this.glZ.get(glT);
                    long longValue2 = ((Long) this.glZ.get(glW)).longValue();
                    g.RQ();
                    g.RO().eJo.a(new com.tencent.mm.plugin.aa.a.a.g(str, longValue, list, intValue, str2, longValue2), 0);
                    int size = list.size();
                    if (size > 0 && size <= 10) {
                        size = 17;
                    } else if (size > 10 && size <= 20) {
                        size = 18;
                    } else if (size <= 20 || size > 50) {
                        size = 20;
                    } else {
                        size = 19;
                    }
                    h.pYm.a(407, (long) size, 1, false);
                    this.fsC.dMi();
                    AppMethodBeat.o(40633);
                    return true;
                } catch (Exception e) {
                    ab.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", e.getMessage());
                }
            }
            this.fsC.cR(Boolean.FALSE);
            this.glY = false;
            AppMethodBeat.o(40633);
            return false;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40634);
        ab.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", Integer.valueOf(i), Integer.valueOf(i2), mVar, Integer.valueOf(this.mode));
        String str2;
        String str3;
        Object[] objArr;
        y yVar;
        if (mVar.getType() == 1624) {
            this.glY = false;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.aa.a.a.f fVar = (com.tencent.mm.plugin.aa.a.a.f) mVar;
                com.tencent.mm.protocal.protobuf.g gVar = fVar.gmi;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(gVar.kCl);
                objArr[1] = gVar.kCm;
                objArr[2] = Boolean.valueOf(gVar.vzN == null);
                objArr[3] = gVar.vzL;
                ab.i(str2, str3, objArr);
                if (gVar.kCl == 0) {
                    if (gVar.vzN != null) {
                        h.w(gVar.vzL, fVar.chatroomName, gVar.vzN);
                        com.tencent.mm.vending.g.f.a(this.fsC, Boolean.TRUE);
                    } else {
                        h.a(gVar.vzL, false, 0);
                        com.tencent.mm.vending.g.f.a(this.fsC, Boolean.TRUE);
                    }
                    h.vF(fVar.chatroomName);
                    h.pYm.a(407, 0, 1, false);
                    AppMethodBeat.o(40634);
                    return;
                }
                if (this.fsC != null) {
                    if (gVar.kCl > 0) {
                        yVar = gVar.vzT;
                        if (yVar != null && yVar.vAF > 0) {
                            this.fsC.cR(yVar);
                        } else if (bo.isNullOrNil(gVar.kCm)) {
                            this.fsC.cR(Boolean.FALSE);
                        } else {
                            this.fsC.cR(gVar.kCm);
                        }
                    } else {
                        this.fsC.cR(Boolean.FALSE);
                    }
                }
                h.pYm.a(407, 2, 1, false);
                AppMethodBeat.o(40634);
                return;
            }
            if (this.fsC != null) {
                this.fsC.cR(Boolean.FALSE);
            }
            h.pYm.a(407, 1, 1, false);
            AppMethodBeat.o(40634);
            return;
        }
        if (mVar.getType() == 1655) {
            this.glY = false;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.aa.a.a.g gVar2 = (com.tencent.mm.plugin.aa.a.a.g) mVar;
                i iVar = gVar2.gmk;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(iVar.kCl);
                objArr[1] = iVar.kCm;
                objArr[2] = Boolean.valueOf(iVar.vzN == null);
                ab.i(str2, str3, objArr);
                ab.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", iVar.kCm, iVar.vzL);
                if (iVar.kCl == 0) {
                    if (iVar.vzN != null) {
                        h.w(iVar.vzL, gVar2.chatroomName, iVar.vzN);
                        com.tencent.mm.vending.g.f.a(this.fsC, Boolean.TRUE, iVar.vzL);
                    } else {
                        h.a(iVar.vzL, false, 0);
                        com.tencent.mm.vending.g.f.a(this.fsC, Boolean.TRUE, iVar.vzL);
                    }
                    h.vF(gVar2.chatroomName);
                    h.pYm.a(407, 3, 1, false);
                    AppMethodBeat.o(40634);
                    return;
                }
                if (iVar.kCl > 0) {
                    yVar = iVar.vzT;
                    if (yVar != null && yVar.vAF > 0) {
                        this.fsC.cR(yVar);
                    } else if (bo.isNullOrNil(iVar.kCm)) {
                        this.fsC.cR(Boolean.FALSE);
                    } else {
                        this.fsC.cR(iVar.kCm);
                    }
                } else {
                    this.fsC.cR(Boolean.FALSE);
                }
                h.pYm.a(407, 5, 1, false);
                AppMethodBeat.o(40634);
                return;
            }
            if (this.fsC != null) {
                this.fsC.cR(Boolean.FALSE);
            }
            h.pYm.a(407, 4, 1, false);
        }
        AppMethodBeat.o(40634);
    }
}
