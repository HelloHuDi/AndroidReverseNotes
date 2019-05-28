package com.tencent.p177mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig */
public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig> CREATOR = new C268281();
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

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$WeAppSyncVersionSetting */
    public static final class WeAppSyncVersionSetting implements Parcelable {
        public static final Creator<WeAppSyncVersionSetting> CREATOR = new C101701();
        public int hgA = 1000;
        public int hgB = 100;
        public long hgy = 21600;
        public long hgz = 604800;

        /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$WeAppSyncVersionSetting$1 */
        static class C101701 implements Creator<WeAppSyncVersionSetting> {
            C101701() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WeAppSyncVersionSetting[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(101801);
                WeAppSyncVersionSetting weAppSyncVersionSetting = new WeAppSyncVersionSetting(parcel);
                AppMethodBeat.m2505o(101801);
                return weAppSyncVersionSetting;
            }
        }

        WeAppSyncVersionSetting() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(101802);
            parcel.writeLong(this.hgy);
            parcel.writeLong(this.hgz);
            parcel.writeInt(this.hgA);
            parcel.writeInt(this.hgB);
            AppMethodBeat.m2505o(101802);
        }

        WeAppSyncVersionSetting(Parcel parcel) {
            AppMethodBeat.m2504i(101803);
            this.hgy = parcel.readLong();
            this.hgz = parcel.readLong();
            this.hgA = parcel.readInt();
            this.hgB = parcel.readInt();
            AppMethodBeat.m2505o(101803);
        }

        static {
            AppMethodBeat.m2504i(101804);
            AppMethodBeat.m2505o(101804);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$HttpSetting */
    public static final class HttpSetting implements Parcelable {
        public static final Creator<HttpSetting> CREATOR = new C191531();
        public ArrayList<String> hgn;
        public ArrayList<String> hgo;
        public int hgp;
        public int hgq;
        public int hgr;
        public int hgs;
        public String hgt;
        public int mode = 0;

        /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$HttpSetting$1 */
        static class C191531 implements Creator<HttpSetting> {
            C191531() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HttpSetting[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(101793);
                HttpSetting httpSetting = new HttpSetting(parcel);
                AppMethodBeat.m2505o(101793);
                return httpSetting;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(101794);
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.hgn);
            parcel.writeStringList(this.hgo);
            parcel.writeInt(this.hgp);
            parcel.writeInt(this.hgq);
            parcel.writeInt(this.hgr);
            parcel.writeInt(this.hgs);
            parcel.writeString(this.hgt);
            AppMethodBeat.m2505o(101794);
        }

        HttpSetting(Parcel parcel) {
            AppMethodBeat.m2504i(101795);
            this.mode = parcel.readInt();
            this.hgn = parcel.createStringArrayList();
            this.hgo = parcel.createStringArrayList();
            this.hgp = parcel.readInt();
            this.hgq = parcel.readInt();
            this.hgr = parcel.readInt();
            this.hgs = parcel.readInt();
            this.hgt = parcel.readString();
            AppMethodBeat.m2505o(101795);
        }

        static {
            AppMethodBeat.m2504i(101796);
            AppMethodBeat.m2505o(101796);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$1 */
    static class C268281 implements Creator<AppBrandGlobalSystemConfig> {
        C268281() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandGlobalSystemConfig[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(101792);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig(parcel);
            AppMethodBeat.m2505o(101792);
            return appBrandGlobalSystemConfig;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$PackageManager */
    public static final class PackageManager implements Parcelable {
        public static final Creator<PackageManager> CREATOR = new C268291();
        public long hgu = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        public long hgv = 864000;
        public long hgw = 256;
        public int hgx = 5;

        /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$PackageManager$1 */
        static class C268291 implements Creator<PackageManager> {
            C268291() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PackageManager[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(101797);
                PackageManager packageManager = new PackageManager(parcel);
                AppMethodBeat.m2505o(101797);
                return packageManager;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(101798);
            parcel.writeLong(this.hgu);
            parcel.writeLong(this.hgv);
            parcel.writeLong(this.hgw);
            parcel.writeInt(this.hgx);
            AppMethodBeat.m2505o(101798);
        }

        protected PackageManager(Parcel parcel) {
            AppMethodBeat.m2504i(101799);
            this.hgu = parcel.readLong();
            this.hgv = parcel.readLong();
            this.hgw = parcel.readLong();
            this.hgx = parcel.readInt();
            AppMethodBeat.m2505o(101799);
        }

        static {
            AppMethodBeat.m2504i(101800);
            AppMethodBeat.m2505o(101800);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig$a */
    public interface C26830a {
        public static final int[] hgk = new int[0];
        public static final String[] hgl = new String[]{"https://wx.qlogo.cn/"};
        public static final String[] hgm = new String[0];
    }

    static {
        AppMethodBeat.m2504i(101812);
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        hfG = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.hfI = 5;
        hfG.hfJ = 300;
        hfG.hfK = 10;
        hfG.hfL = 1048576;
        hfG.hfM = 1048576;
        hfG.hfN = 20971520;
        hfG.hfQ = C26830a.hgk;
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
        hfG.hgb = C26830a.hgl;
        hfG.hgc = 0.0d;
        hfG.hgd = 60;
        hfG.hge = new WeAppSyncVersionSetting();
        hfG.hgf = new PackageManager();
        hfG.hgg = 30;
        hfG.hgh = C26830a.hgm;
        hfG.hgi = 10;
        hfG.hgj = 86400;
        AppMethodBeat.m2505o(101812);
    }

    static synchronized void ayz() {
        synchronized (AppBrandGlobalSystemConfig.class) {
            hfF = null;
        }
    }

    static String ayA() {
        AppMethodBeat.m2504i(101805);
        File file = new File(C6457e.eSk.replace("/data/user/0", "/data/data"), "wxaapp/res/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = new File(file, "AppService.conf").getAbsolutePath();
        AppMethodBeat.m2505o(101805);
        return absolutePath;
    }

    private static synchronized AppBrandGlobalSystemConfig ayB() {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig;
        synchronized (AppBrandGlobalSystemConfig.class) {
            AppMethodBeat.m2504i(101806);
            if (hfF == null) {
                String cy;
                try {
                    cy = C1173e.m2566cy(AppBrandGlobalSystemConfig.ayA());
                } catch (FileNotFoundException e) {
                    ((C0997b) C37384e.m62985B(C0997b.class)).mo3977xI();
                    cy = null;
                } catch (IOException e2) {
                    C4990ab.m7413e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", e2);
                    cy = null;
                }
                if (C5046bo.isNullOrNil(cy)) {
                    AppMethodBeat.m2505o(101806);
                    appBrandGlobalSystemConfig = null;
                } else {
                    hfF = AppBrandGlobalSystemConfig.m42705yX(cy);
                }
            }
            appBrandGlobalSystemConfig = hfF;
            AppMethodBeat.m2505o(101806);
        }
        return appBrandGlobalSystemConfig;
    }

    public static AppBrandGlobalSystemConfig ayC() {
        AppMethodBeat.m2504i(101807);
        AppBrandGlobalSystemConfig ayB = AppBrandGlobalSystemConfig.ayB();
        if (ayB == null) {
            ayB = hfG;
            AppMethodBeat.m2505o(101807);
            return ayB;
        }
        AppMethodBeat.m2505o(101807);
        return ayB;
    }

    /* renamed from: yX */
    private static AppBrandGlobalSystemConfig m42705yX(String str) {
        AppMethodBeat.m2504i(101808);
        C4990ab.m7411d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", str);
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
                appBrandGlobalSystemConfig.hfQ = C26830a.hgk;
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
                appBrandGlobalSystemConfig.hgb = C26830a.hgl;
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
                appBrandGlobalSystemConfig.hgh = C26830a.hgm;
            } else {
                appBrandGlobalSystemConfig.hgh = new String[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.hgh[i] = optJSONArray2.optString(i, null);
                }
            }
            appBrandGlobalSystemConfig.hgi = jSONObject.optInt("WXDataMaxRequestConcurrent", 10);
            AppMethodBeat.m2505o(101808);
            return appBrandGlobalSystemConfig;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(101808);
            return null;
        }
    }

    private AppBrandGlobalSystemConfig() {
        AppMethodBeat.m2504i(101809);
        AppMethodBeat.m2505o(101809);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(101810);
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
        AppMethodBeat.m2505o(101810);
    }

    protected AppBrandGlobalSystemConfig(Parcel parcel) {
        AppMethodBeat.m2504i(101811);
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
        AppMethodBeat.m2505o(101811);
    }
}
