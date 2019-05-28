package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b {
    public static HashMap<String, Integer> fMI;

    public static class b {
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
            AppMethodBeat.i(16548);
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
            AppMethodBeat.o(16548);
            return stringBuffer2;
        }
    }

    public static class a {
        public int enb;
        public int fMJ;
        public int fMK;
        public int fML;
        public int fMM;
        public int fMN;

        public final String toString() {
            AppMethodBeat.i(16547);
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
            AppMethodBeat.o(16547);
            return stringBuffer2;
        }
    }

    public static void aiA() {
        AppMethodBeat.i(16549);
        List<RecoveryStatusItem> a = RecoveryReporter.a(ah.getContext(), "ProcessStatus", RecoveryStatusItem.class);
        ab.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + a.size());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (RecoveryStatusItem recoveryStatusItem : a) {
            Object obj;
            a aVar = hashMap.containsKey(recoveryStatusItem.processName) ? (a) hashMap.get(recoveryStatusItem.processName) : new a();
            if (hashMap2.containsKey(recoveryStatusItem.processName)) {
                obj = (b) hashMap2.get(recoveryStatusItem.processName);
            } else {
                obj = new b();
            }
            aVar.enb++;
            if (recoveryStatusItem.AqZ == 1) {
                aVar.fML++;
            } else {
                aVar.fMM++;
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
                ab.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
            }
            hashMap.put(recoveryStatusItem.processName, aVar);
            hashMap2.put(recoveryStatusItem.processName, obj);
        }
        i(hashMap);
        j(hashMap2);
        RecoveryReporter.bX(ah.getContext(), "ProcessStatus");
        AppMethodBeat.o(16549);
    }

    private static void i(HashMap<String, a> hashMap) {
        AppMethodBeat.i(16550);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (fMI.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) fMI.get(entry.getKey())).intValue();
                a aVar = (a) entry.getValue();
                if (aVar.enb > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) aVar.enb);
                    arrayList.add(iDKey);
                }
                if (aVar.fMJ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) aVar.fMJ);
                    arrayList.add(iDKey);
                }
                if (aVar.fMK > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) aVar.fMK);
                    arrayList.add(iDKey);
                }
                if (aVar.fML > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) aVar.fML);
                    arrayList.add(iDKey);
                }
                if (aVar.fMM > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) aVar.fMM);
                    arrayList.add(iDKey);
                }
                if (aVar.fMN > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(v2helper.EMethodSetSpkEnhance);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) aVar.fMN);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            h.pYm.b(arrayList, true);
        }
        ab.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", ah.getProcessName(), hashMap.toString());
        AppMethodBeat.o(16550);
    }

    private static void j(HashMap<String, b> hashMap) {
        AppMethodBeat.i(16551);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (fMI.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) fMI.get(entry.getKey())).intValue();
                b bVar = (b) entry.getValue();
                if (bVar.fMO > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) bVar.fMO);
                    arrayList.add(iDKey);
                }
                if (bVar.fMP > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) bVar.fMP);
                    arrayList.add(iDKey);
                }
                if (bVar.fMQ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) bVar.fMQ);
                    arrayList.add(iDKey);
                }
                if (bVar.fMR > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) bVar.fMR);
                    arrayList.add(iDKey);
                }
                if (bVar.fMS > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) bVar.fMS);
                    arrayList.add(iDKey);
                }
                if (bVar.fMT > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) bVar.fMT);
                    arrayList.add(iDKey);
                }
                if (bVar.fMU > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 6);
                    iDKey.SetValue((long) bVar.fMU);
                    arrayList.add(iDKey);
                }
                if (bVar.fMV > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 7);
                    iDKey.SetValue((long) bVar.fMV);
                    arrayList.add(iDKey);
                }
                if (bVar.fMW > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 8);
                    iDKey.SetValue((long) bVar.fMW);
                    arrayList.add(iDKey);
                }
                if (bVar.fMX > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 9);
                    iDKey.SetValue((long) bVar.fMX);
                    arrayList.add(iDKey);
                }
                if (bVar.fMY > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 10);
                    iDKey.SetValue((long) bVar.fMY);
                    arrayList.add(iDKey);
                }
                if (bVar.fMZ > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 11);
                    iDKey.SetValue((long) bVar.fMZ);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            h.pYm.b(arrayList, true);
        }
        ab.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", ah.getProcessName(), hashMap.toString());
        AppMethodBeat.o(16551);
    }

    static {
        AppMethodBeat.i(16552);
        HashMap hashMap = new HashMap();
        fMI = hashMap;
        hashMap.put(ah.getPackageName(), Integer.valueOf(0));
        fMI.put(ah.getPackageName() + ":push", Integer.valueOf(20));
        fMI.put(ah.getPackageName() + ":tools", Integer.valueOf(40));
        fMI.put(ah.getPackageName() + ":exdevice", Integer.valueOf(60));
        fMI.put(ah.getPackageName() + ":sandbox", Integer.valueOf(80));
        AppMethodBeat.o(16552);
    }
}
