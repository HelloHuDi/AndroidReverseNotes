package com.tencent.ttpic.device;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import java.util.HashMap;

public class DeviceInstance {
    public static final String BRAND_MEIZU = "MEIZU";
    private static final String[][] BRAND_NAMES;
    public static final String BRAND_VIVO = "VIVO";
    public static final String BRAND_XIAOMI = "XIAOMI";
    private static final DeviceInstance INSTANCE = new DeviceInstance();
    public static final String MODEL_COOLPAD_8150 = "8150";
    public static final String MODEL_K_TOUCH_W619 = "K-Touch W619";
    public static final String MODEL_NEXUS_6 = "MOTOROLA_Nexus_6";
    public static final String MODEL_NEXUS_6P = "HUAWEI_Nexus_6P";
    public static final String NUBIA_NX511J = "NUBIA_NX511J";
    private static final String[][] SOC_SCORE;
    private static String TAG = DeviceInstance.class.getSimpleName();
    private String mDeviceName = "";
    private HashMap<String, String> mModelMap = new HashMap();
    private HashMap<String, String> mSocMap = new HashMap();

    enum DEVICE_MEM {
        GN9010("GN9010", 81920),
        vivo_Y23L("vivo_Y23L", 81920),
        vivo_Y27("vivo_Y27", 81920),
        HUAWEI_PLK("HUAWEI_PLK-AL10", 81920);
        
        private final String device;
        private final int sizeInKB;

        static {
            AppMethodBeat.m2505o(49838);
        }

        private DEVICE_MEM(String str, int i) {
            this.device = str;
            this.sizeInKB = i;
        }
    }

    public enum SOC_CLASS {
        NULL(-1, -1),
        HIGH(0, WearableStatusCodes.TARGET_NODE_NOT_CONNECTED),
        NORMAL(1, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS),
        LOW(2, 1000),
        V_LOW(3, 0);
        
        public int score;
        public int value;

        static {
            AppMethodBeat.m2505o(49842);
        }

        private SOC_CLASS(int i, int i2) {
            this.value = i;
            this.score = i2;
        }

        public final String toString() {
            AppMethodBeat.m2504i(49841);
            String str = "SOC_CLASS{value=" + this.value + ", score=" + this.score + '}';
            AppMethodBeat.m2505o(49841);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(49853);
        String[][] strArr = new String[49][];
        strArr[0] = new String[]{"motorola", "MOTOROLA"};
        strArr[1] = new String[]{"mot", "MOTOROLA"};
        strArr[2] = new String[]{"FIH", "MOTOROLA"};
        strArr[3] = new String[]{"Sony Ericsson", "SONYERICSSON"};
        strArr[4] = new String[]{"Sony", "SONY"};
        strArr[5] = new String[]{"samsung", "SAMSUNG"};
        strArr[6] = new String[]{"HTC", "HTC"};
        strArr[7] = new String[]{"HUN", "HTC"};
        strArr[8] = new String[]{"LGE", "LG"};
        strArr[9] = new String[]{"alps", "OPPO"};
        strArr[10] = new String[]{"OPPO", "OPPO"};
        strArr[11] = new String[]{"TCL", "TCL"};
        strArr[12] = new String[]{"LENOVO", "LENOVO"};
        strArr[13] = new String[]{"ZTE", "ZTE"};
        strArr[14] = new String[]{"Meizu", BRAND_MEIZU};
        strArr[15] = new String[]{"Xiaomi", BRAND_XIAOMI};
        strArr[16] = new String[]{"HUAWEI", "HUAWEI"};
        strArr[17] = new String[]{"TIANYU", "TIANYU"};
        strArr[18] = new String[]{"sprd", "TIANYU"};
        strArr[19] = new String[]{"K-Touch", "TIANYU"};
        strArr[20] = new String[]{"YuLong", "COOLPAD"};
        strArr[21] = new String[]{"CoolPad", "COOLPAD"};
        strArr[22] = new String[]{"Amazon", "AMAZON"};
        strArr[23] = new String[]{"Hisense", "HISENSE"};
        strArr[24] = new String[]{"Acer", "ACER"};
        strArr[25] = new String[]{"GIONEE", "JINLI"};
        strArr[26] = new String[]{"Philips", "PHILIPS"};
        strArr[27] = new String[]{"asus", "GOOGLE"};
        strArr[28] = new String[]{"Google", "GOOGLE"};
        strArr[29] = new String[]{"snda.com", "SHENGDA"};
        strArr[30] = new String[]{"koobee", "KUBI"};
        strArr[31] = new String[]{"AMOI", "XIAXIN"};
        strArr[32] = new String[]{"Fason", "FANSHANG"};
        strArr[33] = new String[]{"ainol", "AINUO"};
        strArr[34] = new String[]{"Dell", "DELL"};
        strArr[35] = new String[]{"dlkjl12389", "DPD"};
        strArr[36] = new String[]{"haier", "HAIER"};
        strArr[37] = new String[]{"sharp", "SHARP"};
        strArr[38] = new String[]{"BBK", "BBK"};
        strArr[39] = new String[]{"vivo", BRAND_VIVO};
        strArr[40] = new String[]{"nubia", "NUBIA"};
        strArr[41] = new String[]{"KONKA", "KONKA"};
        strArr[42] = new String[]{"LeMobile", "LESHI"};
        strArr[43] = new String[]{"Letv", "LESHI"};
        strArr[44] = new String[]{"Meitu", "MEITU"};
        strArr[45] = new String[]{"OnePlus", "ONEPLUS"};
        strArr[46] = new String[]{"360", "QIHOO"};
        strArr[47] = new String[]{"CMDC", "CMDC"};
        strArr[48] = new String[]{"DOOV", "DOOV"};
        BRAND_NAMES = strArr;
        strArr = new String[102][];
        strArr[0] = new String[]{"Samsung Exynos 8895", "6500"};
        strArr[1] = new String[]{"Samsung Exynos 8890", "5300"};
        strArr[2] = new String[]{"Qualcomm Snapdragon 835", "6100"};
        strArr[3] = new String[]{"Qualcomm Snapdragon 821", "4500"};
        strArr[4] = new String[]{"Qualcomm Snapdragon 820", "4100"};
        strArr[5] = new String[]{"Qualcomm Snapdragon 660", "4100"};
        strArr[6] = new String[]{"Hisilicon Kirin 960", "6000"};
        strArr[7] = new String[]{"HiSilicon Kirin 955", "5300"};
        strArr[8] = new String[]{"HiSilicon Kirin 950", "5100"};
        strArr[9] = new String[]{"Mediatek Helio X27", "4800"};
        strArr[10] = new String[]{"Qualcomm Snapdragon 810", "3800"};
        strArr[11] = new String[]{"Qualcomm Snapdragon 653", "3800"};
        strArr[12] = new String[]{"Qualcomm Snapdragon 652", "3600"};
        strArr[13] = new String[]{"Qualcomm Snapdragon 650", "3500"};
        strArr[14] = new String[]{"Qualcomm Snapdragon 808", "3300"};
        strArr[15] = new String[]{"Qualcomm Snapdragon 805", "3200"};
        strArr[16] = new String[]{"Qualcomm Snapdragon 626", "3200"};
        strArr[17] = new String[]{"Qualcomm Snapdragon 801", "3100"};
        strArr[18] = new String[]{"Qualcomm Snapdragon 625", "3100"};
        strArr[19] = new String[]{"Mediatek MT6797T Helio X25", "3800"};
        strArr[20] = new String[]{"Mediatek Helio X23", "3800"};
        strArr[21] = new String[]{"Mediatek MT6797 Helio X20", "3700"};
        strArr[22] = new String[]{"Mediatek MT6795 Helio X10", "3400"};
        strArr[23] = new String[]{"Mediatek M675x Helio P25", "3700"};
        strArr[24] = new String[]{"Mediatek M6757 Helio P20", "3600"};
        strArr[25] = new String[]{"Mediatek MT6755T Helio P15", "3300"};
        strArr[26] = new String[]{"Mediatek MT6755 Helio P10", "3300"};
        strArr[27] = new String[]{"Mediatek MT6797M", "3600"};
        strArr[28] = new String[]{"Mediatek MT6753T", "3100"};
        strArr[29] = new String[]{"Mediatek MT6753", "3100"};
        strArr[30] = new String[]{"HiSilicon Kirin 935", "3500"};
        strArr[31] = new String[]{"HiSilicon Kirin 930", "3400"};
        strArr[32] = new String[]{"HiSilicon Kirin 659", "3400"};
        strArr[33] = new String[]{"HiSilicon Kirin 655", "3400"};
        strArr[34] = new String[]{"HiSilicon Kirin 650", "3300"};
        strArr[35] = new String[]{"Samsung Exynos 7420", "3900"};
        strArr[36] = new String[]{"Samsung Exynos 7870", "3400"};
        strArr[37] = new String[]{"Samsung Exynos 7580", "3400"};
        strArr[38] = new String[]{"Samsung Exynos 5433", "3300"};
        strArr[39] = new String[]{"Samsung Exynos 5430", "3100"};
        strArr[40] = new String[]{"NVIDIA Tegra X1", "3100"};
        strArr[41] = new String[]{"Intel Atom Z8500", "3100"};
        strArr[42] = new String[]{"Qualcomm Snapdragon 800", "2700"};
        strArr[43] = new String[]{"Qualcomm Snapdragon 617", "2400"};
        strArr[44] = new String[]{"Qualcomm Snapdragon 616", "1900"};
        strArr[45] = new String[]{"Qualcomm Snapdragon 615", "1800"};
        strArr[46] = new String[]{"Qualcomm Snapdragon 600", "1800"};
        strArr[47] = new String[]{"Qualcomm Snapdragon 435", "2800"};
        strArr[48] = new String[]{"Qualcomm Snapdragon 430", "2700"};
        strArr[49] = new String[]{"Qualcomm Snapdragon 427", "2600"};
        strArr[50] = new String[]{"Qualcomm Snapdragon 425", "1700"};
        strArr[51] = new String[]{"Qualcomm Snapdragon 415", "1300"};
        strArr[52] = new String[]{"Qualcomm Snapdragon 412", "1200"};
        strArr[53] = new String[]{"Qualcomm Snapdragon 410", "1100"};
        strArr[54] = new String[]{"Qualcomm Snapdragon S4 MSM8960 Pro", "1200"};
        strArr[55] = new String[]{"Qualcomm Snapdragon S4 Pro APQ8064", "1700"};
        strArr[56] = new String[]{"Mediatek MT6795", "2600"};
        strArr[57] = new String[]{"Mediatek MT6752m", "2900"};
        strArr[58] = new String[]{"Mediatek MT6752", "1800"};
        strArr[59] = new String[]{"Mediatek MT6755M", "2600"};
        strArr[60] = new String[]{"Mediatek MT6735", "1600"};
        strArr[61] = new String[]{"Mediatek MT6735P", "1600"};
        strArr[62] = new String[]{"Mediatek MT6737", "1800"};
        strArr[63] = new String[]{"Mediatek MT6750", "2100"};
        strArr[64] = new String[]{"Mediatek MT6595", "2500"};
        strArr[65] = new String[]{"Mediatek MT6592", "2200"};
        strArr[66] = new String[]{"Mediatek MT6582", "1600"};
        strArr[67] = new String[]{"Mediatek MT6580", "1500"};
        strArr[68] = new String[]{"Samsung Exynos 7578", "1800"};
        strArr[69] = new String[]{"Samsung Exynos 7570", "1700"};
        strArr[70] = new String[]{"Samsung Exynos 5800", "2300"};
        strArr[71] = new String[]{"Samsung Exynos 5422", "2000"};
        strArr[72] = new String[]{"Samsung Exynos 5420", "2000"};
        strArr[73] = new String[]{"Samsung Exynos 5410", "1700"};
        strArr[74] = new String[]{"Samsung Exynos 5260", "1700"};
        strArr[75] = new String[]{"Samsung Exynos 5250", "1200"};
        strArr[76] = new String[]{"Samsung Exynos 4412", "1500"};
        strArr[77] = new String[]{"HiSilicon Kirin 928", "2300"};
        strArr[78] = new String[]{"HiSilicon Kirin 920 Hi3630", "1800"};
        strArr[79] = new String[]{"HiSilicon Kirin 920", "1800"};
        strArr[80] = new String[]{"HiSilicon Kirin 925", "2200"};
        strArr[81] = new String[]{"HiSilicon Kirin 910T", "2200"};
        strArr[82] = new String[]{"HiSilicon Kirin 620", "2000"};
        strArr[83] = new String[]{"Intel Atom Z2560", "2800"};
        strArr[84] = new String[]{"Intel Atom Z3745", "2100"};
        strArr[85] = new String[]{"NVIDIA Tegra K1", "2700"};
        strArr[86] = new String[]{"NVIDIA Tegra K1 Denver", "2700"};
        strArr[87] = new String[]{"NVIDIA Tegra 4", "2200"};
        strArr[88] = new String[]{"Qualcomm Snapdragon 400", "900"};
        strArr[89] = new String[]{"Qualcomm Snapdragon 210", "600"};
        strArr[90] = new String[]{"Qualcomm Snapdragon 208", "600"};
        strArr[91] = new String[]{"Qualcomm Snapdragon 200", "600"};
        strArr[92] = new String[]{"Qualcomm Snapdragon S4 MSM8960T", "900"};
        strArr[93] = new String[]{"Qualcomm Snapdragon S4 MSM8960", "800"};
        strArr[94] = new String[]{"Qualcomm Snapdragon S4 Plus MSM8227", "600"};
        strArr[95] = new String[]{"Samsung Exynos 4210", "700"};
        strArr[96] = new String[]{"Samsung Exynos 3470", "900"};
        strArr[97] = new String[]{"NVIDIA Tegra 3 T30L", "900"};
        strArr[98] = new String[]{"NVIDIA Tegra 3 T30", "800"};
        strArr[99] = new String[]{"Ti OMAP 4470", "800"};
        strArr[100] = new String[]{"Ti OMAP 4460", "600"};
        strArr[101] = new String[]{"Ti OMAP 4430", "500"};
        SOC_SCORE = strArr;
        AppMethodBeat.m2505o(49853);
    }

    public static DeviceInstance getInstance() {
        return INSTANCE;
    }

    private DeviceInstance() {
        int i;
        AppMethodBeat.m2504i(49843);
        for (i = 0; i < BRAND_NAMES.length; i++) {
            this.mModelMap.put(BRAND_NAMES[i][0].toUpperCase(), BRAND_NAMES[i][1]);
        }
        for (i = 0; i < SOC_SCORE.length; i++) {
            this.mSocMap.put(SOC_SCORE[i][0], SOC_SCORE[i][1]);
        }
        showDeviceInfo();
        AppMethodBeat.m2505o(49843);
    }

    public String getDeviceName() {
        AppMethodBeat.m2504i(49844);
        if (TextUtils.isEmpty(this.mDeviceName)) {
            if (Build.MODEL.equalsIgnoreCase(MODEL_K_TOUCH_W619)) {
                this.mDeviceName = ((String) this.mModelMap.get("TIANYU")) + " " + Build.MODEL;
            } else if (Build.MODEL.equalsIgnoreCase(MODEL_COOLPAD_8150) && Build.BRAND.equalsIgnoreCase("COOLPAD")) {
                this.mDeviceName = ((String) this.mModelMap.get("COOLPAD")) + " " + Build.MODEL;
            } else {
                this.mDeviceName = ((String) this.mModelMap.get(Build.MANUFACTURER.toUpperCase())) + " " + Build.MODEL;
            }
            this.mDeviceName = this.mDeviceName.replace(" ", "_").replace("+", "").replace("(t)", "");
        }
        String str = this.mDeviceName;
        AppMethodBeat.m2505o(49844);
        return str;
    }

    public SOC_CLASS getDeviceSocClass(String str) {
        AppMethodBeat.m2504i(49845);
        LogUtils.m50199d(TAG, "[getDeviceSocClass] + BEGIN, socInfo = ".concat(String.valueOf(str)));
        Object obj = "";
        if (!(TextUtils.isEmpty(str) || this.mSocMap == null || !this.mSocMap.containsKey(str))) {
            obj = (String) this.mSocMap.get(str);
        }
        LogUtils.m50199d(TAG, "[getDeviceSocClass] scoreValue = ".concat(String.valueOf(obj)));
        SOC_CLASS soc_class = SOC_CLASS.NULL;
        if (!TextUtils.isEmpty(obj)) {
            int parseInt = Integer.parseInt(obj);
            if (parseInt >= SOC_CLASS.HIGH.score) {
                obj = SOC_CLASS.HIGH;
            } else if (parseInt >= SOC_CLASS.NORMAL.score) {
                obj = SOC_CLASS.NORMAL;
            } else if (parseInt >= SOC_CLASS.LOW.score) {
                obj = SOC_CLASS.LOW;
            } else if (parseInt > SOC_CLASS.V_LOW.score) {
                obj = SOC_CLASS.V_LOW;
            }
            LogUtils.m50199d(TAG, "[getDeviceSocClass] + END, socClass = ".concat(String.valueOf(obj)));
            AppMethodBeat.m2505o(49845);
            return obj;
        }
        SOC_CLASS soc_class2 = soc_class;
        LogUtils.m50199d(TAG, "[getDeviceSocClass] + END, socClass = ".concat(String.valueOf(obj)));
        AppMethodBeat.m2505o(49845);
        return obj;
    }

    public boolean isXiaoMiDevice() {
        AppMethodBeat.m2504i(49846);
        LogUtils.m50199d(TAG, "[isXiaoMiDevice] + BEGIN");
        boolean z = false;
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith(BRAND_XIAOMI)) {
            z = true;
        }
        LogUtils.m50199d(TAG, "[isXiaoMiDevice] + END, isXiaomi = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49846);
        return z;
    }

    public boolean isViVoDevice() {
        AppMethodBeat.m2504i(49847);
        LogUtils.m50199d(TAG, "[isViVoDevice] + BEGIN");
        boolean z = false;
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith(BRAND_VIVO)) {
            z = true;
        }
        LogUtils.m50199d(TAG, "[isViVoDevice] + END, isViVo = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49847);
        return z;
    }

    public boolean isVivoY23LDevice() {
        AppMethodBeat.m2504i(49848);
        String deviceName = getDeviceName();
        if (TextUtils.isEmpty(deviceName) || !deviceName.equals("VIVO_vivo_Y23L")) {
            AppMethodBeat.m2505o(49848);
            return false;
        }
        AppMethodBeat.m2505o(49848);
        return true;
    }

    public boolean isMeiZuDevice() {
        AppMethodBeat.m2504i(49849);
        LogUtils.m50199d(TAG, "[isMeiZuDevice] + BEGIN");
        boolean z = false;
        String deviceName = getDeviceName();
        if (!TextUtils.isEmpty(deviceName) && deviceName.startsWith(BRAND_MEIZU)) {
            z = true;
        }
        LogUtils.m50199d(TAG, "[isMeiZuDevice] + END, isMeizu = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49849);
        return z;
    }

    public int getMaxMemorySizeInKB() {
        AppMethodBeat.m2504i(49850);
        String trim = getDeviceName().toLowerCase().trim();
        int access$100;
        for (DEVICE_MEM device_mem : DEVICE_MEM.values()) {
            if (trim.endsWith(device_mem.device.toLowerCase())) {
                access$100 = device_mem.sizeInKB;
                AppMethodBeat.m2505o(49850);
                return access$100;
            }
        }
        AppMethodBeat.m2505o(49850);
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public boolean needLoadAll() {
        AppMethodBeat.m2504i(49851);
        String trim = getDeviceName().toLowerCase().trim();
        for (DEVICE_MEM access$000 : DEVICE_MEM.values()) {
            if (trim.endsWith(access$000.device.toLowerCase())) {
                AppMethodBeat.m2505o(49851);
                return true;
            }
        }
        AppMethodBeat.m2505o(49851);
        return false;
    }

    private void showDeviceInfo() {
        AppMethodBeat.m2504i(49852);
        LogUtils.m50199d(TAG, "****** DeviceInfo  (+) *****");
        LogUtils.m50199d(TAG, "DeviceName = " + getDeviceName());
        LogUtils.m50199d(TAG, "SubName = " + getDeviceName() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase());
        LogUtils.m50199d(TAG, "MODEL = " + Build.MODEL);
        LogUtils.m50199d(TAG, "SDK_INT = " + VERSION.SDK_INT);
        LogUtils.m50199d(TAG, "BRAND = " + Build.BRAND);
        LogUtils.m50199d(TAG, "DEVICE = " + Build.DEVICE);
        LogUtils.m50199d(TAG, "DISPLAY = " + Build.DISPLAY);
        LogUtils.m50199d(TAG, "HARDWARE = " + Build.HARDWARE);
        LogUtils.m50199d(TAG, "MANUFACTURER = " + Build.MANUFACTURER);
        LogUtils.m50199d(TAG, "PRODUCT = " + Build.PRODUCT);
        LogUtils.m50199d(TAG, "TAGS = " + Build.TAGS);
        LogUtils.m50199d(TAG, "USER = " + Build.USER);
        LogUtils.m50199d(TAG, "TYPE = " + Build.TYPE);
        LogUtils.m50199d(TAG, "BOARD = " + Build.BOARD);
        LogUtils.m50199d(TAG, "****** DeviceInfo (-) *****");
        AppMethodBeat.m2505o(49852);
    }
}
