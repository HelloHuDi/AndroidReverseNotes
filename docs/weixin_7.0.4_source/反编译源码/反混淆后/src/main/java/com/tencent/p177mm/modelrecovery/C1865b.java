package com.tencent.p177mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.modelrecovery.b */
public final class C1865b {
    public static HashMap<String, Integer> fMI;

    /* renamed from: com.tencent.mm.modelrecovery.b$b */
    public static class C1866b {
        public int fMO;
        public int fMP;
        public int fMQ;
        public int fMR;
        public int fMS;
        public int fMT;
        public int fMU;
        public int fMV;
        public int fMW;
        public int fMX;
        public int fMY;
        public int fMZ;

        public final String toString() {
            AppMethodBeat.m2504i(16548);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.fMO > 0) {
                stringBuffer.append("appForegroundExpCount:" + this.fMO + " ");
            }
            if (this.fMP > 0) {
                stringBuffer.append("appBackgroundExpCount:" + this.fMP + " ");
            }
            if (this.fMQ > 0) {
                stringBuffer.append("componentForegroundExpCount:" + this.fMQ + " ");
            }
            if (this.fMR > 0) {
                stringBuffer.append("componentBackgroundExpCount:" + this.fMR + " ");
            }
            if (this.fMS > 0) {
                stringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.fMS + " ");
            }
            if (this.fMT > 0) {
                stringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.fMT + " ");
            }
            if (this.fMU > 0) {
                stringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.fMU + " ");
            }
            if (this.fMV > 0) {
                stringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.fMV + " ");
            }
            if (this.fMW > 0) {
                stringBuffer.append("appForegroundTimeoutExpCount:" + this.fMW + " ");
            }
            if (this.fMX > 0) {
                stringBuffer.append("appBackgroundTimeoutExpCount:" + this.fMX + " ");
            }
            if (this.fMY > 0) {
                stringBuffer.append("componentForegroundTimeoutExpCount:" + this.fMY + " ");
            }
            if (this.fMZ > 0) {
                stringBuffer.append("componentBackgroundTimeoutExpCount:" + this.fMZ + " ");
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.m2505o(16548);
            return stringBuffer2;
        }
    }

    /* renamed from: com.tencent.mm.modelrecovery.b$a */
    public static class C1867a {
        public int enb;
        public int fMJ;
        public int fMK;
        public int fML;
        public int fMM;
        public int fMN;

        public final String toString() {
            AppMethodBeat.m2504i(16547);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.enb > 0) {
                stringBuffer.append("totalCount:" + this.enb + " ");
            }
            if (this.fMJ > 0) {
                stringBuffer.append("enterRecoveryCount:" + this.fMJ + " ");
            }
            if (this.fMK > 0) {
                stringBuffer.append("existRecoveryProcessCount:" + this.fMK + " ");
            }
            if (this.fML > 0) {
                stringBuffer.append("foregroundExpCount:" + this.fML + " ");
            }
            if (this.fMM > 0) {
                stringBuffer.append("backgroundExpCount:" + this.fMM + " ");
            }
            if (this.fMN > 0) {
                stringBuffer.append("normalCount:" + this.fMN + " ");
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.m2505o(16547);
            return stringBuffer2;
        }
    }

    public static void aiA() {
        AppMethodBeat.m2504i(16549);
        List<RecoveryStatusItem> a = RecoveryReporter.m8725a(C4996ah.getContext(), "ProcessStatus", RecoveryStatusItem.class);
        C4990ab.m7416i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + a.size());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (RecoveryStatusItem recoveryStatusItem : a) {
            Object obj;
            C1867a c1867a = hashMap.containsKey(recoveryStatusItem.processName) ? (C1867a) hashMap.get(recoveryStatusItem.processName) : new C1867a();
            if (hashMap2.containsKey(recoveryStatusItem.processName)) {
                obj = (C1866b) hashMap2.get(recoveryStatusItem.processName);
            } else {
                obj = new C1866b();
            }
            c1867a.enb++;
            if (recoveryStatusItem.AqZ == 1) {
                c1867a.fML++;
            } else {
                c1867a.fMM++;
            }
            Object obj2 = null;
            int obj22;
            switch (recoveryStatusItem.Arb) {
                case 1:
                    if (recoveryStatusItem.AqZ != 1) {
                        obj.fMP++;
                        switch (recoveryStatusItem.Arc) {
                            case 4096:
                                obj.fMX++;
                                obj22 = 1;
                                break;
                            case 65536:
                            case 1048576:
                                obj.fMT++;
                                obj22 = 1;
                                break;
                        }
                    }
                    obj.fMO++;
                    switch (recoveryStatusItem.Arc) {
                        case 4096:
                            obj.fMW++;
                            obj22 = 1;
                            break;
                        case 65536:
                        case 1048576:
                            obj.fMS++;
                            obj22 = 1;
                            break;
                    }
                    break;
                case 16:
                    if (recoveryStatusItem.AqZ != 1) {
                        obj.fMR++;
                        switch (recoveryStatusItem.Arc) {
                            case 4096:
                                obj.fMZ++;
                                obj22 = 1;
                                break;
                            case 65536:
                            case 1048576:
                                obj.fMV++;
                                obj22 = 1;
                                break;
                        }
                    }
                    obj.fMQ++;
                    switch (recoveryStatusItem.Arc) {
                        case 4096:
                            obj.fMY++;
                            obj22 = 1;
                            break;
                        case 65536:
                        case 1048576:
                            obj.fMU++;
                            obj22 = 1;
                            break;
                    }
                    break;
            }
            if (obj22 == null) {
                C4990ab.m7416i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
            }
            hashMap.put(recoveryStatusItem.processName, c1867a);
            hashMap2.put(recoveryStatusItem.processName, obj);
        }
        C1865b.m3978i(hashMap);
        C1865b.m3979j(hashMap2);
        RecoveryReporter.m8727bX(C4996ah.getContext(), "ProcessStatus");
        AppMethodBeat.m2505o(16549);
    }

    /* renamed from: i */
    private static void m3978i(HashMap<String, C1867a> hashMap) {
        AppMethodBeat.m2504i(16550);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (fMI.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) fMI.get(entry.getKey())).intValue();
                C1867a c1867a = (C1867a) entry.getValue();
                if (c1867a.enb > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) c1867a.enb);
                    arrayList.add(iDKey);
                }
                if (c1867a.fMJ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) c1867a.fMJ);
                    arrayList.add(iDKey);
                }
                if (c1867a.fMK > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) c1867a.fMK);
                    arrayList.add(iDKey);
                }
                if (c1867a.fML > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) c1867a.fML);
                    arrayList.add(iDKey);
                }
                if (c1867a.fMM > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) c1867a.fMM);
                    arrayList.add(iDKey);
                }
                if (c1867a.fMN > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) c1867a.fMN);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            C7060h.pYm.mo8379b(arrayList, true);
        }
        C4990ab.m7417i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", C4996ah.getProcessName(), hashMap.toString());
        AppMethodBeat.m2505o(16550);
    }

    /* renamed from: j */
    private static void m3979j(HashMap<String, C1866b> hashMap) {
        AppMethodBeat.m2504i(16551);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (fMI.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) fMI.get(entry.getKey())).intValue();
                C1866b c1866b = (C1866b) entry.getValue();
                if (c1866b.fMO > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) c1866b.fMO);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMP > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) c1866b.fMP);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMQ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) c1866b.fMQ);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMR > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) c1866b.fMR);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMS > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) c1866b.fMS);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMT > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) c1866b.fMT);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMU > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 6);
                    iDKey.SetValue((long) c1866b.fMU);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMV > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 7);
                    iDKey.SetValue((long) c1866b.fMV);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMW > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 8);
                    iDKey.SetValue((long) c1866b.fMW);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMX > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 9);
                    iDKey.SetValue((long) c1866b.fMX);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMY > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 10);
                    iDKey.SetValue((long) c1866b.fMY);
                    arrayList.add(iDKey);
                }
                if (c1866b.fMZ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 11);
                    iDKey.SetValue((long) c1866b.fMZ);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            C7060h.pYm.mo8379b(arrayList, true);
        }
        C4990ab.m7417i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", C4996ah.getProcessName(), hashMap.toString());
        AppMethodBeat.m2505o(16551);
    }

    static {
        AppMethodBeat.m2504i(16552);
        HashMap hashMap = new HashMap();
        fMI = hashMap;
        hashMap.put(C4996ah.getPackageName(), Integer.valueOf(0));
        fMI.put(C4996ah.getPackageName() + ":push", Integer.valueOf(20));
        fMI.put(C4996ah.getPackageName() + ":tools", Integer.valueOf(40));
        fMI.put(C4996ah.getPackageName() + ":exdevice", Integer.valueOf(60));
        fMI.put(C4996ah.getPackageName() + ":sandbox", Integer.valueOf(80));
        AppMethodBeat.m2505o(16552);
    }
}
