package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig> CREATOR = new Creator<AppBrandGlobalSystemConfig>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandGlobalSystemConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101792);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig(parcel);
            AppMethodBeat.o(101792);
            return appBrandGlobalSystemConfig;
        }
    };
    private static volatile AppBrandGlobalSystemConfig hfF;
    public static final AppBrandGlobalSystemConfig hfG;
    public int hfH = BaseClientBuilder.API_PRIORITY_OTHER;
    public int hfI;
    public int hfJ;
    public int hfK;
    public int hfL;
    public int hfM;
    public int hfN;
    public String hfO;
    public HttpSetting hfP = new HttpSetting();
    public int[] hfQ;
    public int hfR;
    public int hfS;
    public int hfT;
    public int hfU;
    public int hfV;
    public int hfW;
    public int hfX;
    public int hfY;
    public int hfZ;
    public int hga;
    public String[] hgb;
    public double hgc;
    public int hgd;
    public WeAppSyncVersionSetting hge;
    public PackageManager hgf;
    public long hgg;
    public String[] hgh;
    public int hgi;
    public int hgj;

    public static final class WeAppSyncVersionSetting implements Parcelable {
        public static final Creator<WeAppSyncVersionSetting> CREATOR = new Creator<WeAppSyncVersionSetting>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WeAppSyncVersionSetting[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(101801);
                WeAppSyncVersionSetting weAppSyncVersionSetting = new WeAppSyncVersionSetting(parcel);
                AppMethodBeat.o(101801);
                return weAppSyncVersionSetting;
            }
        };
        public int hgA = 1000;
        public int hgB = 100;
        public long hgy = 21600;
        public long hgz = 604800;

        WeAppSyncVersionSetting() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(101802);
            parcel.writeLong(this.hgy);
            parcel.writeLong(this.hgz);
            parcel.writeInt(this.hgA);
            parcel.writeInt(this.hgB);
            AppMethodBeat.o(101802);
        }

        WeAppSyncVersionSetting(Parcel parcel) {
            AppMethodBeat.i(101803);
            this.hgy = parcel.readLong();
            this.hgz = parcel.readLong();
            this.hgA = parcel.readInt();
            this.hgB = parcel.readInt();
            AppMethodBeat.o(101803);
        }

        static {
            AppMethodBeat.i(101804);
            AppMethodBeat.o(101804);
        }
    }

    public static final class HttpSetting implements Parcelable {
        public static final Creator<HttpSetting> CREATOR = new Creator<HttpSetting>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HttpSetting[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(101793);
                HttpSetting httpSetting = new HttpSetting(parcel);
                AppMethodBeat.o(101793);
                return httpSetting;
            }
        };
        public ArrayList<String> hgn;
        public ArrayList<String> hgo;
        public int hgp;
        public int hgq;
        public int hgr;
        public int hgs;
        public String hgt;
        public int mode = 0;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(101794);
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.hgn);
            parcel.writeStringList(this.hgo);
            parcel.writeInt(this.hgp);
            parcel.writeInt(this.hgq);
            parcel.writeInt(this.hgr);
            parcel.writeInt(this.hgs);
            parcel.writeString(this.hgt);
            AppMethodBeat.o(101794);
        }

        HttpSetting(Parcel parcel) {
            AppMethodBeat.i(101795);
            this.mode = parcel.readInt();
            this.hgn = parcel.createStringArrayList();
            this.hgo = parcel.createStringArrayList();
            this.hgp = parcel.readInt();
            this.hgq = parcel.readInt();
            this.hgr = parcel.readInt();
            this.hgs = parcel.readInt();
            this.hgt = parcel.readString();
            AppMethodBeat.o(101795);
        }

        static {
            AppMethodBeat.i(101796);
            AppMethodBeat.o(101796);
        }
    }

    public static final class PackageManager implements Parcelable {
        public static final Creator<PackageManager> CREATOR = new Creator<PackageManager>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PackageManager[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(101797);
                PackageManager packageManager = new PackageManager(parcel);
                AppMethodBeat.o(101797);
                return packageManager;
            }
        };
        public long hgu = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        public long hgv = 864000;
        public long hgw = 256;
        public int hgx = 5;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(101798);
            parcel.writeLong(this.hgu);
            parcel.writeLong(this.hgv);
            parcel.writeLong(this.hgw);
            parcel.writeInt(this.hgx);
            AppMethodBeat.o(101798);
        }

        protected PackageManager(Parcel parcel) {
            AppMethodBeat.i(101799);
            this.hgu = parcel.readLong();
            this.hgv = parcel.readLong();
            this.hgw = parcel.readLong();
            this.hgx = parcel.readInt();
            AppMethodBeat.o(101799);
        }

        static {
            AppMethodBeat.i(101800);
            AppMethodBeat.o(101800);
        }
    }

    public interface a {
        public static final int[] hgk = new int[0];
        public static final String[] hgl = new String[]{"https://wx.qlogo.cn/"};
        public static final String[] hgm = new String[0];
    }

    static {
        AppMethodBeat.i(101812);
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        hfG = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.hfI = 5;
        hfG.hfJ = 300;
        hfG.hfK = 10;
        hfG.hfL = 1048576;
        hfG.hfM = 1048576;
        hfG.hfN = 20971520;
        hfG.hfQ = a.hgk;
        hfG.hfR = 50;
        hfG.hfS = 11;
        hfG.hfT = 12;
        hfG.hfU = 1800;
        hfG.hfV = 307200;
        hfG.hfW = 25;
        hfG.hfX = 10485760;
        hfG.hfY = 314572800;
        hfG.hfZ = 1;
        hfG.hga = 50;
        hfG.hgb = a.hgl;
        hfG.hgc = 0.0d;
        hfG.hgd = 60;
        hfG.hge = new WeAppSyncVersionSetting();
        hfG.hgf = new PackageManager();
        hfG.hgg = 30;
        hfG.hgh = a.hgm;
        hfG.hgi = 10;
        hfG.hgj = 86400;
        AppMethodBeat.o(101812);
    }

    static synchronized void ayz() {
        synchronized (AppBrandGlobalSystemConfig.class) {
            hfF = null;
        }
    }

    static String ayA() {
        AppMethodBeat.i(101805);
        File file = new File(e.eSk.replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = new File(file, "AppService.conf").getAbsolutePath();
        AppMethodBeat.o(101805);
        return absolutePath;
    }

    private static synchronized AppBrandGlobalSystemConfig ayB() {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig;
        synchronized (AppBrandGlobalSystemConfig.class) {
            AppMethodBeat.i(101806);
            if (hfF == null) {
                String cy;
                try {
                    cy = com.tencent.mm.a.e.cy(ayA());
                } catch (FileNotFoundException e) {
                    ((b) com.tencent.luggage.a.e.B(b.class)).xI();
                    cy = null;
                } catch (IOException e2) {
                    ab.e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", e2);
                    cy = null;
                }
                if (bo.isNullOrNil(cy)) {
                    AppMethodBeat.o(101806);
                    appBrandGlobalSystemConfig = null;
                } else {
                    hfF = yX(cy);
                }
            }
            appBrandGlobalSystemConfig = hfF;
            AppMethodBeat.o(101806);
        }
        return appBrandGlobalSystemConfig;
    }

    public static AppBrandGlobalSystemConfig ayC() {
        AppMethodBeat.i(101807);
        AppBrandGlobalSystemConfig ayB = ayB();
        if (ayB == null) {
            ayB = hfG;
            AppMethodBeat.o(101807);
            return ayB;
        }
        AppMethodBeat.o(101807);
        return ayB;
    }

    private static AppBrandGlobalSystemConfig yX(String str) {
        AppMethodBeat.i(101808);
        ab.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", str);
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
            JSONObject optJSONObject = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    appBrandGlobalSystemConfig.hfP.mode = 1;
                } else if (optString.equals("WhiteList")) {
                    appBrandGlobalSystemConfig.hfP.mode = 2;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("HeaderBlackList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.hfP.hgn = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.hfP.hgn.add(optJSONArray.getString(i));
                    }
                }
                optJSONArray = optJSONObject.optJSONArray("HeaderWhiteList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.hfP.hgo = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.hfP.hgo.add(optJSONArray.getString(i));
                    }
                }
                appBrandGlobalSystemConfig.hfP.hgp = optJSONObject.optInt("WebsocketMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.hfP.hgq = optJSONObject.optInt("UploadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.hfP.hgr = optJSONObject.optInt("DownloadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.hfP.hgs = optJSONObject.optInt("RequestMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.hfP.hgt = optJSONObject.optString("HTTPHeaderReferer");
            }
            appBrandGlobalSystemConfig.hge = new WeAppSyncVersionSetting();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("SyncVersionSetting");
            if (optJSONObject2 != null) {
                appBrandGlobalSystemConfig.hge.hgy = optJSONObject2.optLong("PullVersionInterval", appBrandGlobalSystemConfig.hge.hgy);
                appBrandGlobalSystemConfig.hge.hgz = optJSONObject2.optLong("PullVersionWxaUsageLastInterval", appBrandGlobalSystemConfig.hge.hgz);
                appBrandGlobalSystemConfig.hge.hgA = optJSONObject2.optInt("PullVersionMaxCount", appBrandGlobalSystemConfig.hge.hgA);
                appBrandGlobalSystemConfig.hge.hgB = optJSONObject2.optInt("PullVersionMaxCountPerRequest", appBrandGlobalSystemConfig.hge.hgB);
            }
            appBrandGlobalSystemConfig.hgf = new PackageManager();
            optJSONObject2 = jSONObject.optJSONObject("PackageManager");
            if (optJSONObject2 != null) {
                appBrandGlobalSystemConfig.hgf.hgu = optJSONObject2.optLong("CheckInterval", appBrandGlobalSystemConfig.hgf.hgu);
                appBrandGlobalSystemConfig.hgf.hgv = optJSONObject2.optLong("WithoutContactClearSeconds", appBrandGlobalSystemConfig.hgf.hgv);
                appBrandGlobalSystemConfig.hgf.hgw = optJSONObject2.optLong("ClientStorageMinMB", appBrandGlobalSystemConfig.hgf.hgw);
                appBrandGlobalSystemConfig.hgf.hgx = optJSONObject2.optInt("WholeClientStoragePercent", appBrandGlobalSystemConfig.hgf.hgx);
            }
            appBrandGlobalSystemConfig.hfO = jSONObject.optString("CDNBaseURL");
            appBrandGlobalSystemConfig.hfI = jSONObject.optInt("AppMaxRunningCount", 5);
            appBrandGlobalSystemConfig.hfJ = jSONObject.optInt("TempFileSizeLimitTotal", 300);
            appBrandGlobalSystemConfig.hfK = jSONObject.optInt("DownloadFileSizeLimit", 10);
            appBrandGlobalSystemConfig.hfL = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            appBrandGlobalSystemConfig.hfM = jSONObject.optInt("MaxGlobalStorageItemSize", 1048576);
            appBrandGlobalSystemConfig.hfN = jSONObject.optInt("MaxGlobalStorageSize", 20971520);
            appBrandGlobalSystemConfig.hfX = jSONObject.optInt("NativeBufferSizeLimitByte", 10485760);
            appBrandGlobalSystemConfig.hfY = jSONObject.optInt("NativeBufferQueueLimitByte", 314572800);
            appBrandGlobalSystemConfig.hgj = jSONObject.optInt("WeUseRecallInterval", 86400);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("SyncLaunchSceneList");
            if (optJSONArray2 != null) {
                appBrandGlobalSystemConfig.hfQ = new int[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.hfQ[i] = optJSONArray2.optInt(i, 0);
                }
            }
            if (appBrandGlobalSystemConfig.hfQ == null) {
                appBrandGlobalSystemConfig.hfQ = a.hgk;
            }
            appBrandGlobalSystemConfig.hfR = jSONObject.optInt("StarNumberLimitation", 50);
            appBrandGlobalSystemConfig.hfS = jSONObject.optInt("TaskBarItemCountLimitation", 11);
            appBrandGlobalSystemConfig.hfT = jSONObject.optInt("NewTaskBarRecentsItemCountLimitation", 12);
            appBrandGlobalSystemConfig.hfU = jSONObject.optInt("WidgetImageFlowLimitDuration", 1800);
            appBrandGlobalSystemConfig.hfV = jSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
            appBrandGlobalSystemConfig.hfW = jSONObject.optInt("WidgetDrawMinInterval", 25);
            appBrandGlobalSystemConfig.hfZ = jSONObject.optInt("GameMaxRunningCount", 1);
            appBrandGlobalSystemConfig.hga = jSONObject.optInt("GameDownloadFileSizeLimit", 50);
            optJSONArray2 = jSONObject.optJSONArray("SubContextImgDomain");
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                appBrandGlobalSystemConfig.hgb = a.hgl;
            } else {
                appBrandGlobalSystemConfig.hgb = new String[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.hgb[i] = optJSONArray2.optString(i, null);
                }
            }
            appBrandGlobalSystemConfig.hgc = jSONObject.optDouble("GamePerfCollectSamplePercentage", 0.0d);
            appBrandGlobalSystemConfig.hgd = jSONObject.optInt("GamePerfCollectInterval", 60);
            appBrandGlobalSystemConfig.hgg = jSONObject.optLong("OpendataMaxFileStorageSize", 30);
            optJSONArray2 = jSONObject.optJSONArray("PreDownloadUserNameBlackList");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                appBrandGlobalSystemConfig.hgh = a.hgm;
            } else {
                appBrandGlobalSystemConfig.hgh = new String[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.hgh[i] = optJSONArray2.optString(i, null);
                }
            }
            appBrandGlobalSystemConfig.hgi = jSONObject.optInt("WXDataMaxRequestConcurrent", 10);
            AppMethodBeat.o(101808);
            return appBrandGlobalSystemConfig;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", bo.l(e));
            AppMethodBeat.o(101808);
            return null;
        }
    }

    private AppBrandGlobalSystemConfig() {
        AppMethodBeat.i(101809);
        AppMethodBeat.o(101809);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(101810);
        parcel.writeInt(this.hfH);
        parcel.writeInt(this.hfI);
        parcel.writeInt(this.hfJ);
        parcel.writeInt(this.hfK);
        parcel.writeInt(this.hfL);
        parcel.writeInt(this.hfM);
        parcel.writeInt(this.hfN);
        parcel.writeString(this.hfO);
        parcel.writeParcelable(this.hfP, i);
        parcel.writeIntArray(this.hfQ);
        parcel.writeInt(this.hfR);
        parcel.writeInt(this.hfS);
        parcel.writeInt(this.hfU);
        parcel.writeInt(this.hfV);
        parcel.writeInt(this.hfW);
        parcel.writeInt(this.hfX);
        parcel.writeInt(this.hfY);
        parcel.writeInt(this.hfZ);
        parcel.writeInt(this.hga);
        parcel.writeStringArray(this.hgb);
        parcel.writeDouble(this.hgc);
        parcel.writeInt(this.hgd);
        parcel.writeParcelable(this.hge, i);
        parcel.writeParcelable(this.hgf, i);
        parcel.writeLong(this.hgg);
        parcel.writeStringArray(this.hgh);
        parcel.writeInt(this.hgi);
        parcel.writeInt(this.hgj);
        AppMethodBeat.o(101810);
    }

    protected AppBrandGlobalSystemConfig(Parcel parcel) {
        AppMethodBeat.i(101811);
        this.hfH = parcel.readInt();
        this.hfI = parcel.readInt();
        this.hfJ = parcel.readInt();
        this.hfK = parcel.readInt();
        this.hfL = parcel.readInt();
        this.hfM = parcel.readInt();
        this.hfN = parcel.readInt();
        this.hfO = parcel.readString();
        this.hfP = (HttpSetting) parcel.readParcelable(HttpSetting.class.getClassLoader());
        this.hfQ = parcel.createIntArray();
        this.hfR = parcel.readInt();
        this.hfS = parcel.readInt();
        this.hfU = parcel.readInt();
        this.hfV = parcel.readInt();
        this.hfW = parcel.readInt();
        this.hfX = parcel.readInt();
        this.hfY = parcel.readInt();
        this.hfZ = parcel.readInt();
        this.hga = parcel.readInt();
        this.hgb = parcel.createStringArray();
        this.hgc = parcel.readDouble();
        this.hgd = parcel.readInt();
        this.hge = (WeAppSyncVersionSetting) parcel.readParcelable(WeAppSyncVersionSetting.class.getClassLoader());
        this.hgf = (PackageManager) parcel.readParcelable(PackageManager.class.getClassLoader());
        this.hgg = parcel.readLong();
        this.hgh = parcel.createStringArray();
        this.hgi = parcel.readInt();
        this.hgj = parcel.readInt();
        AppMethodBeat.o(101811);
    }
}
