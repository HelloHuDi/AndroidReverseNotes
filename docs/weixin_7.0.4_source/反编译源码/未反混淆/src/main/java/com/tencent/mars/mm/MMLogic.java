package com.tencent.mars.mm;

import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class MMLogic {
    public static final int MM_STAT_CGI_INFO = 1;
    public static final int MM_STAT_CGI_NETWORK_COST = 7;
    public static final int MM_STAT_DNS = 8;
    public static final int MM_STAT_LONGLINK_BUILD = 3;
    public static final int MM_STAT_LONGLINK_CONNECT = 4;
    public static final int MM_STAT_LONGLINK_DISCONNECT = 5;
    public static final int MM_STAT_LONGLINK_FUNC_CONNECT = 6;
    public static final int MM_STAT_NETWORK_UNREACHABLE = 2;
    public static final int MM_Stat_Local_GetHostByName = 11;
    public static final int MM_Stat_Network_Changed = 10;
    public static final int MM_Stat_Noop_Send = 9;
    private static long lastReportTime = 0;
    private static int totalMobileRecv = 0;
    private static int totalMobileSend = 0;
    private static int totalWifiRecv = 0;
    private static int totalWifiSend = 0;

    public static class ReportInfo {
        public long actionId = 0;
        public long beginTime = 0;
        public String clientIp = "";
        public long connCostTime = 0;
        public long connTotalCostTime = 0;
        public long dnsCostTime = 0;
        public int dnsErrType = 0;
        public String dnsSvrIp = "";
        public int endFlag = 0;
        public int endStep = 0;
        public long endTime = 0;
        public int errCode = 0;
        public int errType = 0;
        public long expand1 = 0;
        public long expand2 = 0;
        public String extraInfo = "";
        public long firstPkgTime = 0;
        public String host = "";
        public String ip = "";
        public int ipType = 0;
        public boolean isSocket = false;
        public int localIp = 0;
        public long netSignal = 0;
        public int netType = 0;
        public int newNetType = 0;
        public long newdnsCostTime = 0;
        public int newdnsErrCode = 0;
        public int newdnsErrType = 0;
        public int port = 0;
        public long recvSize = 0;
        public int refTime1 = 0;
        public int refTime2 = 0;
        public int refTime3 = 0;
        public int retryCount = 0;
        public long rtType = 0;
        public long sendSize = 0;
        public int subNetType = 0;
        public int usedIpIndex = 0;

        public String toString() {
            return String.format("actionId:%d, rtType:%d, begin:%d, end:%d, cost:%d, ip:%s, port:%d, isSocket:%b, netType:%d, ipType:%d, sendSize:%d, recvSize:%d, errType:%d, errCode:%d, netSignal:%d, retryCount:%d, expand1:%d, clientip:%s, expand2:%d, newNetType:%d, subNetType:%d, extraInfo:%s, host:%s, endStep:%d, endFlag:%d", new Object[]{Long.valueOf(this.actionId), Long.valueOf(this.rtType), Long.valueOf(this.beginTime), Long.valueOf(this.endTime), Long.valueOf(this.endTime - this.beginTime), this.ip, Integer.valueOf(this.port), Boolean.valueOf(this.isSocket), Integer.valueOf(this.netType), Integer.valueOf(this.ipType), Long.valueOf(this.sendSize), Long.valueOf(this.recvSize), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.netSignal), Integer.valueOf(this.retryCount), Long.valueOf(this.expand1), this.clientIp, Long.valueOf(this.expand2), Integer.valueOf(this.newNetType), Integer.valueOf(this.subNetType), this.extraInfo, this.host, Integer.valueOf(this.endStep), Integer.valueOf(this.endFlag)});
        }
    }

    static class GetDnsReturn {
        public String[] aryIps;
        public int length;
        public int type;

        private GetDnsReturn() {
            this.type = 0;
            this.aryIps = new String[50];
        }

        /* synthetic */ GetDnsReturn(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static native void getHostIps(String str, GetDnsReturn getDnsReturn);

    public static native String[] getIPsString(boolean z);

    public static native String getIspId();

    public static native String getNetworkServerIp();

    private static native void getSnsIps(boolean z, GetDnsReturn getDnsReturn);

    private static native void getSnsIpsWithHostName(String str, boolean z, GetDnsReturn getDnsReturn);

    public static native void recoverLinkAddrs();

    public static native void reportCGIServerError(int i, int i2);

    public static native void reportFailIp(String str);

    public static native void saveAuthLongIPs(String str, String[] strArr);

    public static native void saveAuthPorts(int[] iArr, int[] iArr2);

    public static native void saveAuthShortIPs(String str, String[] strArr);

    public static native void setDebugIP(String str, String str2, String str3, String str4);

    public static native void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    public static native void setMmtlsCtrlInfo(boolean z);

    public static native void setNewDnsDebugHost(String str, String str2);

    public static native void uploadFile(String str, String str2, String str3);

    public static native void uploadLog(int[] iArr, boolean z, String str, String str2);

    private static String getCurLanguage() {
        try {
            return aa.dor();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getUserIDCLocale() {
        try {
            return bo.gT(ah.getContext()) ? "HK" : "CN";
        } catch (Exception e) {
            return null;
        }
    }

    public static int getSnsIpsForScene(List<String> list, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn();
        getSnsIps(z, getDnsReturn);
        for (int i = 0; i < getDnsReturn.length; i++) {
            list.add(getDnsReturn.aryIps[i]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = "mmsns.qpic.cn";
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : "0.0.0.0";
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    public static int getSnsIpsForSceneWithHostName(List<String> list, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn();
        getSnsIpsWithHostName(str, z, getDnsReturn);
        for (int i = 0; i < getDnsReturn.length; i++) {
            list.add(getDnsReturn.aryIps[i]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = str;
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : "0.0.0.0";
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    public static int getHostByName(String str, List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        GetDnsReturn getDnsReturn = new GetDnsReturn();
        getHostIps(str, getDnsReturn);
        for (int i = 0; i < getDnsReturn.length; i++) {
            list.add(getDnsReturn.aryIps[i]);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.actionId = 11;
        reportInfo.beginTime = currentTimeMillis;
        reportInfo.endTime = currentTimeMillis2;
        reportInfo.clientIp = str;
        reportInfo.ip = getDnsReturn.length > 0 ? getDnsReturn.aryIps[0] : "0.0.0.0";
        reportStat(reportInfo);
        return getDnsReturn.type;
    }

    private static int getJavaActionId(long j) {
        switch ((int) j) {
            case 1:
                return 10955;
            case 2:
                return 10104;
            case 3:
                return 10103;
            case 4:
                return 10105;
            case 5:
                return 10102;
            case 6:
                return 10101;
            case 7:
                return 1105;
            case 8:
                return 10428;
            case 9:
                return -1;
            case 10:
                return -2;
            case 11:
                return -3;
            default:
                return 0;
        }
    }

    public static void reportStat(final ReportInfo reportInfo) {
        try {
            com.tencent.mm.network.aa.anm().post(new Runnable() {
                public final void run() {
                    int access$100 = MMLogic.getJavaActionId(reportInfo.actionId);
                    if (access$100 == 0) {
                        ab.e("C2Java", "ActionId Can not convert");
                        return;
                    }
                    reportInfo.actionId = (long) access$100;
                }
            });
        } catch (Exception e) {
        }
    }

    private static void reportFlow(int i, int i2, int i3, int i4) {
        totalWifiRecv += i;
        totalWifiSend += i2;
        totalMobileRecv += i3;
        totalMobileSend += i4;
        int i5 = ((totalMobileRecv + totalMobileSend) + totalWifiRecv) + totalWifiSend;
        final b bVar = com.tencent.mm.network.aa.ank().geg;
        ab.i("C2Java", "reportNetFlow time[%d,%d] sum:%d wr[%d,%d] ws[%d,%d] mr[%d,%d] ms[%d,%d] fgbg:%b Moniter:%s", Long.valueOf(lastReportTime), Long.valueOf(bo.fp(lastReportTime)), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(totalWifiRecv), Integer.valueOf(i2), Integer.valueOf(totalWifiSend), Integer.valueOf(i3), Integer.valueOf(totalMobileRecv), Integer.valueOf(i4), Integer.valueOf(totalMobileSend), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), bVar);
        if (bVar != null) {
            if (i5 >= 102400 || bo.fp(lastReportTime) >= 30) {
                lastReportTime = bo.anT();
                final int i6 = totalWifiRecv;
                totalWifiRecv = 0;
                final int i7 = totalWifiSend;
                totalWifiSend = 0;
                final int i8 = totalMobileRecv;
                totalMobileRecv = 0;
                final int i9 = totalMobileSend;
                totalMobileSend = 0;
                try {
                    com.tencent.mm.network.aa.anm().post(new Runnable() {
                        public final void run() {
                            try {
                                bVar.u(i6, i7, i8, i9);
                            } catch (Throwable th) {
                                ab.e("C2Java", "reportFlowData :%s", bo.l(th));
                            }
                        }
                    });
                } catch (Throwable th) {
                    ab.e("C2Java", "reportFlowData :%s", bo.l(th));
                }
            }
        }
    }

    private static void onOOBNotify(final String str) {
        ab.i("C2Java", "onOOBNotify:".concat(String.valueOf(str)));
        if (com.tencent.mm.network.aa.anq() == null) {
            Assert.assertTrue(false);
            return;
        }
        try {
            com.tencent.mm.network.aa.anm().post(new Runnable() {
                public final void run() {
                    com.tencent.mm.network.aa.anq().onPush(268369923, bo.isNullOrNil(str) ? null : str.getBytes());
                }
            });
        } catch (Exception e) {
            ab.e("C2Java", "onOOBNotify :%s", bo.l(e));
        }
    }
}
