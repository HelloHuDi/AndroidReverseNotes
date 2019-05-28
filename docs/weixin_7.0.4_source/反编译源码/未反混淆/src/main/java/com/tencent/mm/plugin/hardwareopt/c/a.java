package com.tencent.mm.plugin.hardwareopt.c;

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
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
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

public final class a implements com.tencent.mm.vending.c.a<asz, Context> {
    private Context mContext = null;

    static class a extends Exception {
        a() {
            super("hy: positively stop in " + g.getLine());
            AppMethodBeat.i(59275);
            AppMethodBeat.o(59275);
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(59279);
        asz ek = ek((Context) obj);
        AppMethodBeat.o(59279);
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
    private asz ek(Context context) {
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
        td tdVar;
        String str;
        String str2;
        Object[] objArr;
        abx abx;
        asz bFT;
        AppMethodBeat.i(59276);
        this.mContext = context;
        long nanoTime = System.nanoTime();
        hj hjVar = new hj();
        hjVar.imei = bo.gN(this.mContext);
        if (bo.isNullOrNil(hjVar.imei)) {
            ab.w("MicroMsg.TaskFindHardwareInfo", "hy: not got imei. maybe no permission");
            a aVar = new a();
            AppMethodBeat.o(59276);
            throw aVar;
        }
        StatFs statFs;
        hjVar.vJX = Build.MANUFACTURER;
        hjVar.vJY = Build.MODEL;
        hjVar.vJZ = VERSION.INCREMENTAL;
        com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwG = hjVar;
        ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: imei: %s, manufacrtureName: %s, modelName: %s, incremental: %s", hjVar.imei, hjVar.vJX, hjVar.vJY, hjVar.vJZ);
        na naVar = new na();
        naVar.vRD = Build.CPU_ABI;
        Map LA = n.LA();
        naVar.vRB = bo.bc((String) LA.get("Processor"), "");
        naVar.vJY = (String) LA.get("model name");
        naVar.vRE = (String) LA.get("Hardware");
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
            try {
                naVar.vRC = bo.getInt(randomAccessFile.readLine(), -1) / 1000;
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when close read cpu files", new Object[0]);
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e, "hy: error when reading cpu frequency", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when close read cpu files", new Object[0]);
                        }
                    }
                    com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwH = naVar;
                    ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", naVar.vRD, naVar.vRB, Integer.valueOf(naVar.vRC), naVar.vJY, naVar.vRE);
                    activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                    memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    bba = new bba();
                    bba.wFN = (int) ((memoryInfo.totalMem / 1024) / 1024);
                    bba.wFO = (int) ((memoryInfo.threshold / 1024) / 1024);
                    bba.wFP = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                    bba.ggb = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                    com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwI = bba;
                    ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", Integer.valueOf(bba.wFN), Integer.valueOf(bba.wFO), Integer.valueOf(bba.wFP), Integer.valueOf(bba.ggb));
                    statFs = new StatFs(e.eSl);
                    cdp = new cdp();
                    if (VERSION.SDK_INT >= 18) {
                    }
                    cdp.xdp = Environment.getExternalStorageState().equals("mounted");
                    com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwJ = cdp;
                    ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", Integer.valueOf(cdp.xdo), Boolean.valueOf(cdp.xdp));
                    deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                    acu = new acu();
                    if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    }
                    acu.wkx = deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
                    }
                    acu.wky = z;
                    com.tencent.mm.kernel.g.K(c.class);
                    acu.wkz = false;
                    com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwN = acu;
                    ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", Boolean.valueOf(acu.wkx), Boolean.valueOf(acu.wky), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(acu.wkz));
                    defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                    point = new Point();
                    defaultDisplay.getSize(point);
                    i = point.x;
                    i2 = point.y;
                    buk = new buk();
                    buk.wWb = String.valueOf(i) + VideoMaterialUtil.CRAZYFACE_X + i2;
                    buk.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                    com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwK = buk;
                    ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", buk.wWb, Integer.valueOf(buk.density));
                    tdVar = new td();
                    tdVar.wav = OB("video/avc");
                    tdVar.waw = OB("video/hevc");
                    tdVar.wax = bFU();
                    com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwL = tdVar;
                    str = "MicroMsg.TaskFindHardwareInfo";
                    str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                    objArr = new Object[3];
                    objArr[0] = tdVar.wav;
                    objArr[1] = tdVar.waw;
                    if (tdVar.wax != null) {
                    }
                    objArr[2] = Integer.valueOf(tdVar.wax != null ? tdVar.wax.size() : 0);
                    ab.d(str, str2, objArr);
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
                    com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwM = abx;
                    ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", Boolean.valueOf(abx.wjw), Boolean.valueOf(abx.wjx), Boolean.valueOf(abx.wjy), Boolean.valueOf(abx.wjz), Boolean.valueOf(abx.wjA), Boolean.valueOf(abx.wjB), Boolean.valueOf(abx.wjC), Boolean.valueOf(abx.wjN), Boolean.valueOf(abx.wjD), Boolean.valueOf(abx.wjE), Boolean.valueOf(abx.wjF), Boolean.valueOf(abx.wjG), Boolean.valueOf(abx.wjH), Boolean.valueOf(abx.wjI), Boolean.valueOf(abx.wjJ), Boolean.valueOf(abx.wjK), Boolean.valueOf(abx.wjL), Boolean.valueOf(abx.wjM));
                    ab.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000));
                    bFT = com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT();
                    if (bFT != null) {
                    }
                    bFT = com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT();
                    AppMethodBeat.o(59276);
                    return bFT;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(59276);
                    throw e;
                }
            }
        } catch (IOException e4) {
            e = e4;
            randomAccessFile = null;
            ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e, "hy: error when reading cpu frequency", new Object[0]);
            if (randomAccessFile != null) {
            }
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwH = naVar;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", naVar.vRD, naVar.vRB, Integer.valueOf(naVar.vRC), naVar.vJY, naVar.vRE);
            activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            bba = new bba();
            bba.wFN = (int) ((memoryInfo.totalMem / 1024) / 1024);
            bba.wFO = (int) ((memoryInfo.threshold / 1024) / 1024);
            bba.wFP = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
            bba.ggb = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwI = bba;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", Integer.valueOf(bba.wFN), Integer.valueOf(bba.wFO), Integer.valueOf(bba.wFP), Integer.valueOf(bba.ggb));
            statFs = new StatFs(e.eSl);
            cdp = new cdp();
            if (VERSION.SDK_INT >= 18) {
            }
            cdp.xdp = Environment.getExternalStorageState().equals("mounted");
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwJ = cdp;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", Integer.valueOf(cdp.xdo), Boolean.valueOf(cdp.xdp));
            deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
            acu = new acu();
            if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            }
            acu.wkx = deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
            }
            acu.wky = z;
            com.tencent.mm.kernel.g.K(c.class);
            acu.wkz = false;
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwN = acu;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", Boolean.valueOf(acu.wkx), Boolean.valueOf(acu.wky), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(acu.wkz));
            defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
            buk = new buk();
            buk.wWb = String.valueOf(i) + VideoMaterialUtil.CRAZYFACE_X + i2;
            buk.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwK = buk;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", buk.wWb, Integer.valueOf(buk.density));
            tdVar = new td();
            tdVar.wav = OB("video/avc");
            tdVar.waw = OB("video/hevc");
            tdVar.wax = bFU();
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwL = tdVar;
            str = "MicroMsg.TaskFindHardwareInfo";
            str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
            objArr = new Object[3];
            objArr[0] = tdVar.wav;
            objArr[1] = tdVar.waw;
            if (tdVar.wax != null) {
            }
            objArr[2] = Integer.valueOf(tdVar.wax != null ? tdVar.wax.size() : 0);
            ab.d(str, str2, objArr);
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
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwM = abx;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", Boolean.valueOf(abx.wjw), Boolean.valueOf(abx.wjx), Boolean.valueOf(abx.wjy), Boolean.valueOf(abx.wjz), Boolean.valueOf(abx.wjA), Boolean.valueOf(abx.wjB), Boolean.valueOf(abx.wjC), Boolean.valueOf(abx.wjN), Boolean.valueOf(abx.wjD), Boolean.valueOf(abx.wjE), Boolean.valueOf(abx.wjF), Boolean.valueOf(abx.wjG), Boolean.valueOf(abx.wjH), Boolean.valueOf(abx.wjI), Boolean.valueOf(abx.wjJ), Boolean.valueOf(abx.wjK), Boolean.valueOf(abx.wjL), Boolean.valueOf(abx.wjM));
            ab.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000));
            bFT = com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT();
            if (bFT != null) {
            }
            bFT = com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT();
            AppMethodBeat.o(59276);
            return bFT;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                    ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e5, "hy: error when close read cpu files", new Object[0]);
                }
            }
            AppMethodBeat.o(59276);
            throw e;
        }
        try {
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwH = naVar;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", naVar.vRD, naVar.vRB, Integer.valueOf(naVar.vRC), naVar.vJY, naVar.vRE);
            activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            bba = new bba();
            bba.wFN = (int) ((memoryInfo.totalMem / 1024) / 1024);
            bba.wFO = (int) ((memoryInfo.threshold / 1024) / 1024);
            bba.wFP = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
            bba.ggb = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwI = bba;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", Integer.valueOf(bba.wFN), Integer.valueOf(bba.wFO), Integer.valueOf(bba.wFP), Integer.valueOf(bba.ggb));
            statFs = new StatFs(e.eSl);
            cdp = new cdp();
            if (VERSION.SDK_INT >= 18) {
                cdp.xdo = (int) ((statFs.getTotalBytes() / 1024) / 1024);
            } else {
                cdp.xdo = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
            }
            cdp.xdp = Environment.getExternalStorageState().equals("mounted");
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwJ = cdp;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", Integer.valueOf(cdp.xdo), Boolean.valueOf(cdp.xdp));
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
                com.tencent.mm.kernel.g.K(c.class);
                acu.wkz = false;
            } catch (Throwable e6) {
                ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e6, "hy: error when retrieve vulkan support!", new Object[0]);
                acu.wkz = false;
            }
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwN = acu;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", Boolean.valueOf(acu.wkx), Boolean.valueOf(acu.wky), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(acu.wkz));
            defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
            buk = new buk();
            buk.wWb = String.valueOf(i) + VideoMaterialUtil.CRAZYFACE_X + i2;
            buk.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwK = buk;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", buk.wWb, Integer.valueOf(buk.density));
            tdVar = new td();
            tdVar.wav = OB("video/avc");
            tdVar.waw = OB("video/hevc");
            tdVar.wax = bFU();
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwL = tdVar;
            str = "MicroMsg.TaskFindHardwareInfo";
            str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
            objArr = new Object[3];
            objArr[0] = tdVar.wav;
            objArr[1] = tdVar.waw;
            objArr[2] = Integer.valueOf(tdVar.wax != null ? tdVar.wax.size() : 0);
            ab.d(str, str2, objArr);
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
            } else if (q.etg.etr == 1) {
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
            com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT().wwM = abx;
            ab.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", Boolean.valueOf(abx.wjw), Boolean.valueOf(abx.wjx), Boolean.valueOf(abx.wjy), Boolean.valueOf(abx.wjz), Boolean.valueOf(abx.wjA), Boolean.valueOf(abx.wjB), Boolean.valueOf(abx.wjC), Boolean.valueOf(abx.wjN), Boolean.valueOf(abx.wjD), Boolean.valueOf(abx.wjE), Boolean.valueOf(abx.wjF), Boolean.valueOf(abx.wjG), Boolean.valueOf(abx.wjH), Boolean.valueOf(abx.wjI), Boolean.valueOf(abx.wjJ), Boolean.valueOf(abx.wjK), Boolean.valueOf(abx.wjL), Boolean.valueOf(abx.wjM));
            ab.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000));
            try {
                bFT = com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT();
                if (bFT != null) {
                    if (bFT.wwH != null) {
                        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_HARDWARE_CPU_FREQUENCY_MHZ_INT_SYNC, Integer.valueOf(bFT.wwH.vRC));
                    }
                    if (bFT.wwI != null) {
                        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_HARDWARE_MEMORY_IN_MB_INT_SYNC, Integer.valueOf(bFT.wwI.wFN));
                    }
                }
            } catch (Exception e7) {
                ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e7, "alvinluo save hardware info to config storage exception", new Object[0]);
            }
            bFT = com.tencent.mm.plugin.hardwareopt.b.a.bFS().bFT();
            AppMethodBeat.o(59276);
            return bFT;
        } catch (Exception e72) {
            ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e72, "hy: exception when find hardware info", new Object[0]);
            b dMo = f.dMo();
            if (dMo != null) {
                dMo.cR(null);
            }
            AppMethodBeat.o(59276);
            return null;
        }
    }

    private static String OB(String str) {
        AppMethodBeat.i(59277);
        MediaCodec mediaCodec = null;
        String name;
        try {
            if (VERSION.SDK_INT >= 18) {
                mediaCodec = MediaCodec.createEncoderByType(str);
                name = mediaCodec.getName();
                return name;
            }
            name = "too low version";
            AppMethodBeat.o(59277);
            return name;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e, "hy: error in handle media codec", new Object[0]);
            name = "undefined";
        } finally {
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            AppMethodBeat.o(59277);
        }
    }

    private static LinkedList<bbg> bFU() {
        AppMethodBeat.i(59278);
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
        ab.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", hashMap);
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
        AppMethodBeat.o(59278);
        return linkedList;
    }
}
