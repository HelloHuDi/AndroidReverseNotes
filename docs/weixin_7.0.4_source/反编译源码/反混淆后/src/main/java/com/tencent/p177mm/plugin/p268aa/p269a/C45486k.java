package com.tencent.p177mm.plugin.p268aa.p269a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C26534f;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C42259g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23389g;
import com.tencent.p177mm.protocal.protobuf.C35967y;
import com.tencent.p177mm.protocal.protobuf.C46549i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.a.k */
public final class C45486k implements C1202f {
    public static String glP = "title";
    public static String glQ = "totalPayAmount";
    public static String glR = "totalUserNumber";
    public static String glS = "perAmount";
    public static String glT = "chatRoomName";
    public static String glU = "launchScene";
    public static String glV = "payerlist";
    public static String glW = Param.TIMESTAMP;
    private static int glX = 131100026;
    private C5688b fsC;
    private boolean glY = false;
    private Map<String, Object> glZ;
    private int mode = 0;

    /* renamed from: c */
    public final boolean mo73276c(int i, Map<String, Object> map) {
        AppMethodBeat.m2504i(40632);
        this.fsC = C5698f.dMj();
        if (this.glY) {
            C4990ab.m7412e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.fsC.mo11582cR(Boolean.FALSE);
            AppMethodBeat.m2505o(40632);
            return false;
        } else if (map == null || map.size() == 0) {
            this.fsC.mo11582cR(Boolean.FALSE);
            AppMethodBeat.m2505o(40632);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", map.keySet());
            this.glY = true;
            this.glZ = map;
            this.mode = i;
            String str;
            long longValue;
            int intValue;
            String str2;
            long longValue2;
            int i2;
            if (i == C1954a.gkT) {
                if (this.glZ.containsKey(glP) && this.glZ.containsKey(glS) && this.glZ.containsKey(glR) && this.glZ.containsKey(glU) && this.glZ.containsKey(glT) && this.glZ.containsKey(glW)) {
                    try {
                        str = (String) this.glZ.get(glP);
                        longValue = ((Long) this.glZ.get(glS)).longValue();
                        int intValue2 = ((Integer) this.glZ.get(glR)).intValue();
                        intValue = ((Integer) this.glZ.get(glU)).intValue();
                        str2 = (String) this.glZ.get(glT);
                        longValue2 = ((Long) this.glZ.get(glW)).longValue();
                        C4990ab.m7416i("MicroMsg.LaunchAALogic", "launchAAByMoney");
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C26534f(longValue, str, intValue2, intValue, longValue2, str2), 0);
                        if (intValue2 > 0 && intValue2 <= 10) {
                            i2 = 13;
                        } else if (intValue2 > 10 && intValue2 <= 20) {
                            i2 = 14;
                        } else if (intValue2 <= 20 || intValue2 > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        C7060h.pYm.mo8378a(407, (long) i2, 1, false);
                        this.fsC.dMi();
                        AppMethodBeat.m2505o(40632);
                        return true;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", e.getMessage());
                        this.fsC.mo11582cR(Boolean.FALSE);
                        this.glY = false;
                        AppMethodBeat.m2505o(40632);
                        return false;
                    }
                }
                this.fsC.mo11582cR(Boolean.FALSE);
                this.glY = false;
                AppMethodBeat.m2505o(40632);
                return false;
            } else if (i != C1954a.gkU) {
                AppMethodBeat.m2505o(40632);
                return false;
            } else if (this.glZ.containsKey(glP) && this.glZ.containsKey(glS) && this.glZ.containsKey(glV) && this.glZ.containsKey(glU) && this.glZ.containsKey(glT) && this.glZ.containsKey(glW)) {
                try {
                    str = (String) this.glZ.get(glP);
                    longValue = ((Long) this.glZ.get(glS)).longValue();
                    List list = (List) this.glZ.get(glV);
                    intValue = ((Integer) this.glZ.get(glU)).intValue();
                    str2 = (String) this.glZ.get(glT);
                    longValue2 = ((Long) this.glZ.get(glW)).longValue();
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C26534f(longValue, str, list, intValue, longValue2, str2), 0);
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
                    C7060h.pYm.mo8378a(407, (long) i2, 1, false);
                    this.fsC.dMi();
                    AppMethodBeat.m2505o(40632);
                    return true;
                } catch (Exception e2) {
                    C4990ab.m7413e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", e2.getMessage());
                    this.fsC.mo11582cR(Boolean.FALSE);
                    this.glY = false;
                    AppMethodBeat.m2505o(40632);
                    return false;
                }
            } else {
                this.fsC.mo11582cR(Boolean.FALSE);
                this.glY = false;
                AppMethodBeat.m2505o(40632);
                return false;
            }
        }
    }

    /* renamed from: r */
    public final boolean mo73277r(Map<String, Object> map) {
        AppMethodBeat.m2504i(40633);
        this.fsC = C5698f.dMj();
        C4990ab.m7416i("MicroMsg.LaunchAALogic", "launchAAByPerson");
        if (this.glY) {
            C4990ab.m7412e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.fsC.mo11582cR(Boolean.FALSE);
            AppMethodBeat.m2505o(40633);
            return false;
        } else if (map == null || map.size() == 0) {
            this.fsC.mo11582cR(Boolean.FALSE);
            AppMethodBeat.m2505o(40633);
            return false;
        } else {
            this.glY = true;
            this.glZ = map;
            this.mode = C1954a.gkV;
            if (this.mode != C1954a.gkV) {
                this.fsC.mo11582cR(Boolean.FALSE);
                AppMethodBeat.m2505o(40633);
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
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C42259g(str, longValue, list, intValue, str2, longValue2), 0);
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
                    C7060h.pYm.mo8378a(407, (long) size, 1, false);
                    this.fsC.dMi();
                    AppMethodBeat.m2505o(40633);
                    return true;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", e.getMessage());
                }
            }
            this.fsC.mo11582cR(Boolean.FALSE);
            this.glY = false;
            AppMethodBeat.m2505o(40633);
            return false;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40634);
        C4990ab.m7411d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", Integer.valueOf(i), Integer.valueOf(i2), c1207m, Integer.valueOf(this.mode));
        String str2;
        String str3;
        Object[] objArr;
        C35967y c35967y;
        if (c1207m.getType() == 1624) {
            this.glY = false;
            if (i == 0 && i2 == 0) {
                C26534f c26534f = (C26534f) c1207m;
                C23389g c23389g = c26534f.gmi;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(c23389g.kCl);
                objArr[1] = c23389g.kCm;
                objArr[2] = Boolean.valueOf(c23389g.vzN == null);
                objArr[3] = c23389g.vzL;
                C4990ab.m7417i(str2, str3, objArr);
                if (c23389g.kCl == 0) {
                    if (c23389g.vzN != null) {
                        C9797h.m17464w(c23389g.vzL, c26534f.chatroomName, c23389g.vzN);
                        C5698f.m8556a(this.fsC, Boolean.TRUE);
                    } else {
                        C9797h.m17453a(c23389g.vzL, false, 0);
                        C5698f.m8556a(this.fsC, Boolean.TRUE);
                    }
                    C9797h.m17463vF(c26534f.chatroomName);
                    C7060h.pYm.mo8378a(407, 0, 1, false);
                    AppMethodBeat.m2505o(40634);
                    return;
                }
                if (this.fsC != null) {
                    if (c23389g.kCl > 0) {
                        c35967y = c23389g.vzT;
                        if (c35967y != null && c35967y.vAF > 0) {
                            this.fsC.mo11582cR(c35967y);
                        } else if (C5046bo.isNullOrNil(c23389g.kCm)) {
                            this.fsC.mo11582cR(Boolean.FALSE);
                        } else {
                            this.fsC.mo11582cR(c23389g.kCm);
                        }
                    } else {
                        this.fsC.mo11582cR(Boolean.FALSE);
                    }
                }
                C7060h.pYm.mo8378a(407, 2, 1, false);
                AppMethodBeat.m2505o(40634);
                return;
            }
            if (this.fsC != null) {
                this.fsC.mo11582cR(Boolean.FALSE);
            }
            C7060h.pYm.mo8378a(407, 1, 1, false);
            AppMethodBeat.m2505o(40634);
            return;
        }
        if (c1207m.getType() == 1655) {
            this.glY = false;
            if (i == 0 && i2 == 0) {
                C42259g c42259g = (C42259g) c1207m;
                C46549i c46549i = c42259g.gmk;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(c46549i.kCl);
                objArr[1] = c46549i.kCm;
                objArr[2] = Boolean.valueOf(c46549i.vzN == null);
                C4990ab.m7417i(str2, str3, objArr);
                C4990ab.m7411d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", c46549i.kCm, c46549i.vzL);
                if (c46549i.kCl == 0) {
                    if (c46549i.vzN != null) {
                        C9797h.m17464w(c46549i.vzL, c42259g.chatroomName, c46549i.vzN);
                        C5698f.m8556a(this.fsC, Boolean.TRUE, c46549i.vzL);
                    } else {
                        C9797h.m17453a(c46549i.vzL, false, 0);
                        C5698f.m8556a(this.fsC, Boolean.TRUE, c46549i.vzL);
                    }
                    C9797h.m17463vF(c42259g.chatroomName);
                    C7060h.pYm.mo8378a(407, 3, 1, false);
                    AppMethodBeat.m2505o(40634);
                    return;
                }
                if (c46549i.kCl > 0) {
                    c35967y = c46549i.vzT;
                    if (c35967y != null && c35967y.vAF > 0) {
                        this.fsC.mo11582cR(c35967y);
                    } else if (C5046bo.isNullOrNil(c46549i.kCm)) {
                        this.fsC.mo11582cR(Boolean.FALSE);
                    } else {
                        this.fsC.mo11582cR(c46549i.kCm);
                    }
                } else {
                    this.fsC.mo11582cR(Boolean.FALSE);
                }
                C7060h.pYm.mo8378a(407, 5, 1, false);
                AppMethodBeat.m2505o(40634);
                return;
            }
            if (this.fsC != null) {
                this.fsC.mo11582cR(Boolean.FALSE);
            }
            C7060h.pYm.mo8378a(407, 4, 1, false);
        }
        AppMethodBeat.m2505o(40634);
    }
}
