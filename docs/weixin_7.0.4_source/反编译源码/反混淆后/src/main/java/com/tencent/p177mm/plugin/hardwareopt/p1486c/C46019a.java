package com.tencent.p177mm.plugin.hardwareopt.p1486c;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1422n;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.service.C45690c;
import com.tencent.p177mm.plugin.hardwareopt.p1405b.C28285a;
import com.tencent.p177mm.protocal.protobuf.C23418na;
import com.tencent.p177mm.protocal.protobuf.C23443td;
import com.tencent.p177mm.protocal.protobuf.C46547hj;
import com.tencent.p177mm.protocal.protobuf.abx;
import com.tencent.p177mm.protocal.protobuf.acu;
import com.tencent.p177mm.protocal.protobuf.asz;
import com.tencent.p177mm.protocal.protobuf.bba;
import com.tencent.p177mm.protocal.protobuf.bbg;
import com.tencent.p177mm.protocal.protobuf.buk;
import com.tencent.p177mm.protocal.protobuf.cdp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.hardwareopt.c.a */
public final class C46019a implements C5681a<asz, Context> {
    private Context mContext = null;

    /* renamed from: com.tencent.mm.plugin.hardwareopt.c.a$a */
    static class C34333a extends Exception {
        C34333a() {
            super("hy: positively stop in " + C1447g.getLine());
            AppMethodBeat.m2504i(59275);
            AppMethodBeat.m2505o(59275);
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.m2504i(59279);
        asz ek = m85570ek((Context) obj);
        AppMethodBeat.m2505o(59279);
        return ek;
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x05c3 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x01ac A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x05d9 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0208 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x05dc A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0211 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x05f1 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0306 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x05f4 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x032f A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x05f9 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x038f A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x05fe A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x03b3 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x060e A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0404 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0613 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0419 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0532 A:{Catch:{ Exception -> 0x0618 }} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0593 A:{SYNTHETIC, Splitter:B:73:0x0593} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x01ac A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x05c3 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0208 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x05d9 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0211 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x05dc A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0306 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x05f1 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x032f A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x05f4 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x038f A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x05f9 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x03b3 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x05fe A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0404 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x060e A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0419 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0613 A:{Catch:{ Exception -> 0x0038 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0532 A:{Catch:{ Exception -> 0x0618 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x05ab A:{SYNTHETIC, Splitter:B:81:0x05ab} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ek */
    private asz m85570ek(Context context) {
        Throwable e;
        ActivityManager activityManager;
        MemoryInfo memoryInfo;
        bba bba;
        cdp cdp;
        ConfigurationInfo deviceConfigurationInfo;
        acu acu;
        boolean z;
        Display defaultDisplay;
        Point point;
        int i;
        int i2;
        buk buk;
        C23443td c23443td;
        String str;
        String str2;
        Object[] objArr;
        abx abx;
        asz bFT;
        AppMethodBeat.m2504i(59276);
        this.mContext = context;
        long nanoTime = System.nanoTime();
        C46547hj c46547hj = new C46547hj();
        c46547hj.imei = C5046bo.m7552gN(this.mContext);
        if (C5046bo.isNullOrNil(c46547hj.imei)) {
            C4990ab.m7420w("MicroMsg.TaskFindHardwareInfo", "hy: not got imei. maybe no permission");
            C34333a c34333a = new C34333a();
            AppMethodBeat.m2505o(59276);
            throw c34333a;
        }
        StatFs statFs;
        c46547hj.vJX = Build.MANUFACTURER;
        c46547hj.vJY = Build.MODEL;
        c46547hj.vJZ = VERSION.INCREMENTAL;
        C28285a.bFS().bFT().wwG = c46547hj;
        C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: imei: %s, manufacrtureName: %s, modelName: %s, incremental: %s", c46547hj.imei, c46547hj.vJX, c46547hj.vJY, c46547hj.vJZ);
        C23418na c23418na = new C23418na();
        c23418na.vRD = Build.CPU_ABI;
        Map LA = C1422n.m3011LA();
        c23418na.vRB = C5046bo.m7532bc((String) LA.get("Processor"), "");
        c23418na.vJY = (String) LA.get("model name");
        c23418na.vRE = (String) LA.get("Hardware");
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
            try {
                c23418na.vRC = C5046bo.getInt(randomAccessFile.readLine(), -1) / 1000;
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when close read cpu files", new Object[0]);
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e, "hy: error when reading cpu frequency", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when close read cpu files", new Object[0]);
                        }
                    }
                    C28285a.bFS().bFT().wwH = c23418na;
                    C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", c23418na.vRD, c23418na.vRB, Integer.valueOf(c23418na.vRC), c23418na.vJY, c23418na.vRE);
                    activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                    memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    bba = new bba();
                    bba.wFN = (int) ((memoryInfo.totalMem / 1024) / 1024);
                    bba.wFO = (int) ((memoryInfo.threshold / 1024) / 1024);
                    bba.wFP = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                    bba.ggb = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                    C28285a.bFS().bFT().wwI = bba;
                    C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", Integer.valueOf(bba.wFN), Integer.valueOf(bba.wFO), Integer.valueOf(bba.wFP), Integer.valueOf(bba.ggb));
                    statFs = new StatFs(C6457e.eSl);
                    cdp = new cdp();
                    if (VERSION.SDK_INT >= 18) {
                    }
                    cdp.xdp = Environment.getExternalStorageState().equals("mounted");
                    C28285a.bFS().bFT().wwJ = cdp;
                    C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", Integer.valueOf(cdp.xdo), Boolean.valueOf(cdp.xdp));
                    deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                    acu = new acu();
                    if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    }
                    acu.wkx = deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
                    }
                    acu.wky = z;
                    C1720g.m3528K(C45690c.class);
                    acu.wkz = false;
                    C28285a.bFS().bFT().wwN = acu;
                    C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", Boolean.valueOf(acu.wkx), Boolean.valueOf(acu.wky), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(acu.wkz));
                    defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                    point = new Point();
                    defaultDisplay.getSize(point);
                    i = point.x;
                    i2 = point.y;
                    buk = new buk();
                    buk.wWb = String.valueOf(i) + VideoMaterialUtil.CRAZYFACE_X + i2;
                    buk.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                    C28285a.bFS().bFT().wwK = buk;
                    C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", buk.wWb, Integer.valueOf(buk.density));
                    c23443td = new C23443td();
                    c23443td.wav = C46019a.m85569OB("video/avc");
                    c23443td.waw = C46019a.m85569OB("video/hevc");
                    c23443td.wax = C46019a.bFU();
                    C28285a.bFS().bFT().wwL = c23443td;
                    str = "MicroMsg.TaskFindHardwareInfo";
                    str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                    objArr = new Object[3];
                    objArr[0] = c23443td.wav;
                    objArr[1] = c23443td.waw;
                    if (c23443td.wax != null) {
                    }
                    objArr[2] = Integer.valueOf(c23443td.wax != null ? c23443td.wax.size() : 0);
                    C4990ab.m7411d(str, str2, objArr);
                    abx = new abx();
                    abx.wjw = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
                    if (VERSION.SDK_INT >= 18) {
                    }
                    abx.wjy = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
                    abx.wjz = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                    abx.wjA = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
                    abx.wjB = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
                    abx.wjC = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                    if (VERSION.SDK_INT >= 19) {
                    }
                    abx.wjD = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                    if (VERSION.SDK_INT >= 23) {
                    }
                    abx.wjF = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
                    abx.wjG = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
                    abx.wjH = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
                    abx.wjI = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
                    if (VERSION.SDK_INT >= 19) {
                    }
                    if (VERSION.SDK_INT >= 19) {
                    }
                    abx.wjL = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
                    abx.wjM = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
                    C28285a.bFS().bFT().wwM = abx;
                    C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", Boolean.valueOf(abx.wjw), Boolean.valueOf(abx.wjx), Boolean.valueOf(abx.wjy), Boolean.valueOf(abx.wjz), Boolean.valueOf(abx.wjA), Boolean.valueOf(abx.wjB), Boolean.valueOf(abx.wjC), Boolean.valueOf(abx.wjN), Boolean.valueOf(abx.wjD), Boolean.valueOf(abx.wjE), Boolean.valueOf(abx.wjF), Boolean.valueOf(abx.wjG), Boolean.valueOf(abx.wjH), Boolean.valueOf(abx.wjI), Boolean.valueOf(abx.wjJ), Boolean.valueOf(abx.wjK), Boolean.valueOf(abx.wjL), Boolean.valueOf(abx.wjM));
                    C4990ab.m7417i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000));
                    bFT = C28285a.bFS().bFT();
                    if (bFT != null) {
                    }
                    bFT = C28285a.bFS().bFT();
                    AppMethodBeat.m2505o(59276);
                    return bFT;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(59276);
                    throw e;
                }
            }
        } catch (IOException e4) {
            e = e4;
            randomAccessFile = null;
            C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e, "hy: error when reading cpu frequency", new Object[0]);
            if (randomAccessFile != null) {
            }
            C28285a.bFS().bFT().wwH = c23418na;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", c23418na.vRD, c23418na.vRB, Integer.valueOf(c23418na.vRC), c23418na.vJY, c23418na.vRE);
            activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            bba = new bba();
            bba.wFN = (int) ((memoryInfo.totalMem / 1024) / 1024);
            bba.wFO = (int) ((memoryInfo.threshold / 1024) / 1024);
            bba.wFP = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
            bba.ggb = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
            C28285a.bFS().bFT().wwI = bba;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", Integer.valueOf(bba.wFN), Integer.valueOf(bba.wFO), Integer.valueOf(bba.wFP), Integer.valueOf(bba.ggb));
            statFs = new StatFs(C6457e.eSl);
            cdp = new cdp();
            if (VERSION.SDK_INT >= 18) {
            }
            cdp.xdp = Environment.getExternalStorageState().equals("mounted");
            C28285a.bFS().bFT().wwJ = cdp;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", Integer.valueOf(cdp.xdo), Boolean.valueOf(cdp.xdp));
            deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
            acu = new acu();
            if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            }
            acu.wkx = deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
            }
            acu.wky = z;
            C1720g.m3528K(C45690c.class);
            acu.wkz = false;
            C28285a.bFS().bFT().wwN = acu;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", Boolean.valueOf(acu.wkx), Boolean.valueOf(acu.wky), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(acu.wkz));
            defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
            buk = new buk();
            buk.wWb = String.valueOf(i) + VideoMaterialUtil.CRAZYFACE_X + i2;
            buk.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            C28285a.bFS().bFT().wwK = buk;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", buk.wWb, Integer.valueOf(buk.density));
            c23443td = new C23443td();
            c23443td.wav = C46019a.m85569OB("video/avc");
            c23443td.waw = C46019a.m85569OB("video/hevc");
            c23443td.wax = C46019a.bFU();
            C28285a.bFS().bFT().wwL = c23443td;
            str = "MicroMsg.TaskFindHardwareInfo";
            str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
            objArr = new Object[3];
            objArr[0] = c23443td.wav;
            objArr[1] = c23443td.waw;
            if (c23443td.wax != null) {
            }
            objArr[2] = Integer.valueOf(c23443td.wax != null ? c23443td.wax.size() : 0);
            C4990ab.m7411d(str, str2, objArr);
            abx = new abx();
            abx.wjw = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
            if (VERSION.SDK_INT >= 18) {
            }
            abx.wjy = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
            abx.wjz = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            abx.wjA = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
            abx.wjB = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
            abx.wjC = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT >= 19) {
            }
            abx.wjD = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT >= 23) {
            }
            abx.wjF = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
            abx.wjG = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
            abx.wjH = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
            abx.wjI = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
            if (VERSION.SDK_INT >= 19) {
            }
            if (VERSION.SDK_INT >= 19) {
            }
            abx.wjL = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
            abx.wjM = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
            C28285a.bFS().bFT().wwM = abx;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", Boolean.valueOf(abx.wjw), Boolean.valueOf(abx.wjx), Boolean.valueOf(abx.wjy), Boolean.valueOf(abx.wjz), Boolean.valueOf(abx.wjA), Boolean.valueOf(abx.wjB), Boolean.valueOf(abx.wjC), Boolean.valueOf(abx.wjN), Boolean.valueOf(abx.wjD), Boolean.valueOf(abx.wjE), Boolean.valueOf(abx.wjF), Boolean.valueOf(abx.wjG), Boolean.valueOf(abx.wjH), Boolean.valueOf(abx.wjI), Boolean.valueOf(abx.wjJ), Boolean.valueOf(abx.wjK), Boolean.valueOf(abx.wjL), Boolean.valueOf(abx.wjM));
            C4990ab.m7417i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000));
            bFT = C28285a.bFS().bFT();
            if (bFT != null) {
            }
            bFT = C28285a.bFS().bFT();
            AppMethodBeat.m2505o(59276);
            return bFT;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                    C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e5, "hy: error when close read cpu files", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(59276);
            throw e;
        }
        try {
            C28285a.bFS().bFT().wwH = c23418na;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", c23418na.vRD, c23418na.vRB, Integer.valueOf(c23418na.vRC), c23418na.vJY, c23418na.vRE);
            activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            bba = new bba();
            bba.wFN = (int) ((memoryInfo.totalMem / 1024) / 1024);
            bba.wFO = (int) ((memoryInfo.threshold / 1024) / 1024);
            bba.wFP = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
            bba.ggb = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
            C28285a.bFS().bFT().wwI = bba;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", Integer.valueOf(bba.wFN), Integer.valueOf(bba.wFO), Integer.valueOf(bba.wFP), Integer.valueOf(bba.ggb));
            statFs = new StatFs(C6457e.eSl);
            cdp = new cdp();
            if (VERSION.SDK_INT >= 18) {
                cdp.xdo = (int) ((statFs.getTotalBytes() / 1024) / 1024);
            } else {
                cdp.xdo = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
            }
            cdp.xdp = Environment.getExternalStorageState().equals("mounted");
            C28285a.bFS().bFT().wwJ = cdp;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", Integer.valueOf(cdp.xdo), Boolean.valueOf(cdp.xdp));
            deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
            acu = new acu();
            acu.wkx = deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
                z = true;
            } else {
                z = false;
            }
            acu.wky = z;
            try {
                C1720g.m3528K(C45690c.class);
                acu.wkz = false;
            } catch (Throwable e6) {
                C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e6, "hy: error when retrieve vulkan support!", new Object[0]);
                acu.wkz = false;
            }
            C28285a.bFS().bFT().wwN = acu;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", Boolean.valueOf(acu.wkx), Boolean.valueOf(acu.wky), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(acu.wkz));
            defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
            buk = new buk();
            buk.wWb = String.valueOf(i) + VideoMaterialUtil.CRAZYFACE_X + i2;
            buk.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            C28285a.bFS().bFT().wwK = buk;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", buk.wWb, Integer.valueOf(buk.density));
            c23443td = new C23443td();
            c23443td.wav = C46019a.m85569OB("video/avc");
            c23443td.waw = C46019a.m85569OB("video/hevc");
            c23443td.wax = C46019a.bFU();
            C28285a.bFS().bFT().wwL = c23443td;
            str = "MicroMsg.TaskFindHardwareInfo";
            str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
            objArr = new Object[3];
            objArr[0] = c23443td.wav;
            objArr[1] = c23443td.waw;
            objArr[2] = Integer.valueOf(c23443td.wax != null ? c23443td.wax.size() : 0);
            C4990ab.m7411d(str, str2, objArr);
            abx = new abx();
            abx.wjw = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
            if (VERSION.SDK_INT >= 18) {
                abx.wjx = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            } else {
                abx.wjx = false;
            }
            abx.wjy = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
            abx.wjz = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            abx.wjA = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
            abx.wjB = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
            abx.wjC = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT >= 19) {
                abx.wjN = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            } else {
                abx.wjN = false;
            }
            abx.wjD = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT >= 23) {
                abx.wjE = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
            } else if (C1427q.etg.etr == 1) {
                abx.wjE = true;
            } else {
                abx.wjE = false;
            }
            abx.wjF = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
            abx.wjG = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
            abx.wjH = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
            abx.wjI = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
            if (VERSION.SDK_INT >= 19) {
                abx.wjJ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
            } else {
                abx.wjJ = false;
            }
            if (VERSION.SDK_INT >= 19) {
                abx.wjK = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
            } else {
                abx.wjK = false;
            }
            abx.wjL = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
            abx.wjM = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
            C28285a.bFS().bFT().wwM = abx;
            C4990ab.m7411d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", Boolean.valueOf(abx.wjw), Boolean.valueOf(abx.wjx), Boolean.valueOf(abx.wjy), Boolean.valueOf(abx.wjz), Boolean.valueOf(abx.wjA), Boolean.valueOf(abx.wjB), Boolean.valueOf(abx.wjC), Boolean.valueOf(abx.wjN), Boolean.valueOf(abx.wjD), Boolean.valueOf(abx.wjE), Boolean.valueOf(abx.wjF), Boolean.valueOf(abx.wjG), Boolean.valueOf(abx.wjH), Boolean.valueOf(abx.wjI), Boolean.valueOf(abx.wjJ), Boolean.valueOf(abx.wjK), Boolean.valueOf(abx.wjL), Boolean.valueOf(abx.wjM));
            C4990ab.m7417i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000));
            try {
                bFT = C28285a.bFS().bFT();
                if (bFT != null) {
                    if (bFT.wwH != null) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HARDWARE_CPU_FREQUENCY_MHZ_INT_SYNC, Integer.valueOf(bFT.wwH.vRC));
                    }
                    if (bFT.wwI != null) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HARDWARE_MEMORY_IN_MB_INT_SYNC, Integer.valueOf(bFT.wwI.wFN));
                    }
                }
            } catch (Exception e7) {
                C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e7, "alvinluo save hardware info to config storage exception", new Object[0]);
            }
            bFT = C28285a.bFS().bFT();
            AppMethodBeat.m2505o(59276);
            return bFT;
        } catch (Exception e72) {
            C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e72, "hy: exception when find hardware info", new Object[0]);
            C5688b dMo = C5698f.dMo();
            if (dMo != null) {
                dMo.mo11582cR(null);
            }
            AppMethodBeat.m2505o(59276);
            return null;
        }
    }

    /* renamed from: OB */
    private static String m85569OB(String str) {
        AppMethodBeat.m2504i(59277);
        MediaCodec mediaCodec = null;
        String name;
        try {
            if (VERSION.SDK_INT >= 18) {
                mediaCodec = MediaCodec.createEncoderByType(str);
                name = mediaCodec.getName();
                return name;
            }
            name = "too low version";
            AppMethodBeat.m2505o(59277);
            return name;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e, "hy: error in handle media codec", new Object[0]);
            name = "undefined";
        } finally {
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            AppMethodBeat.m2505o(59277);
        }
    }

    private static LinkedList<bbg> bFU() {
        AppMethodBeat.m2504i(59278);
        int codecCount = MediaCodecList.getCodecCount();
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    Set set = (Set) hashMap.get(str.toLowerCase());
                    if (set == null) {
                        set = new HashSet();
                    }
                    set.add(codecInfoAt.getName());
                    hashMap.put(str.toLowerCase(), set);
                }
            }
        }
        C4990ab.m7417i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", hashMap);
        for (Entry entry : hashMap.entrySet()) {
            bbg bbg = new bbg();
            bbg.clY = (String) entry.getKey();
            LinkedList linkedList2 = new LinkedList();
            if (entry.getValue() != null) {
                linkedList2.addAll((Collection) entry.getValue());
            }
            bbg.wFX = linkedList2;
            linkedList.add(bbg);
        }
        AppMethodBeat.m2505o(59278);
        return linkedList;
    }
}
