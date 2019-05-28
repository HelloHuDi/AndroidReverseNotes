package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.ipcinvoker.type.IPCLong;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC */
public final class AppBrandBackgroundFetchDataStorageIPC implements C26798h {

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$WxappIdentityWithAppId */
    static class WxappIdentityWithAppId implements Parcelable {
        public static final Creator<WxappIdentityWithAppId> CREATOR = new C191191();
        public String csB;
        public int hca;

        /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$WxappIdentityWithAppId$1 */
        static class C191191 implements Creator<WxappIdentityWithAppId> {
            C191191() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxappIdentityWithAppId[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(129789);
                WxappIdentityWithAppId wxappIdentityWithAppId = new WxappIdentityWithAppId(parcel);
                AppMethodBeat.m2505o(129789);
                return wxappIdentityWithAppId;
            }
        }

        public WxappIdentityWithAppId(String str, int i) {
            this.csB = str;
            this.hca = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(129790);
            parcel.writeString(this.csB);
            parcel.writeInt(this.hca);
            AppMethodBeat.m2505o(129790);
        }

        protected WxappIdentityWithAppId(Parcel parcel) {
            AppMethodBeat.m2504i(129791);
            this.csB = parcel.readString();
            this.hca = parcel.readInt();
            AppMethodBeat.m2505o(129791);
        }

        static {
            AppMethodBeat.m2504i(129792);
            AppMethodBeat.m2505o(129792);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$c */
    static class C19120c implements C45413i<WxappIdentity, IPCLong> {
        private C19120c() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(129782);
            IPCLong b = C19120c.m29728b((WxappIdentity) obj);
            AppMethodBeat.m2505o(129782);
            return b;
        }

        /* renamed from: b */
        private static IPCLong m29728b(WxappIdentity wxappIdentity) {
            AppMethodBeat.m2504i(129781);
            IPCLong iPCLong;
            if (wxappIdentity == null || C5046bo.isNullOrNil(wxappIdentity.username)) {
                C4990ab.m7420w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetUpdateTimeCall:data or username is null");
                iPCLong = new IPCLong(0);
                AppMethodBeat.m2505o(129781);
                return iPCLong;
            }
            try {
                IPCLong iPCLong2 = new IPCLong(((C26798h) C1720g.m3528K(C26798h.class)).mo21500aQ(wxappIdentity.username, wxappIdentity.hca));
                AppMethodBeat.m2505o(129781);
                return iPCLong2;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetUpdateTimeCall fail", e);
                iPCLong = new IPCLong(0);
                AppMethodBeat.m2505o(129781);
                return iPCLong;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$b */
    static class C19121b implements C45413i<WxappIdentityWithAppId, AppBrandBackgroundFetchDataParcel> {
        private C19121b() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(129780);
            AppBrandBackgroundFetchDataParcel a = C19121b.m29734a((WxappIdentityWithAppId) obj);
            AppMethodBeat.m2505o(129780);
            return a;
        }

        /* renamed from: a */
        private static AppBrandBackgroundFetchDataParcel m29734a(WxappIdentityWithAppId wxappIdentityWithAppId) {
            AppMethodBeat.m2504i(129779);
            if (wxappIdentityWithAppId == null || C5046bo.isNullOrNil(wxappIdentityWithAppId.csB)) {
                C4990ab.m7420w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetByAppIdCall:data or appid is null");
                AppMethodBeat.m2505o(129779);
                return null;
            }
            try {
                AppBrandBackgroundFetchDataParcel aR = ((C26798h) C1720g.m3528K(C26798h.class)).mo21501aR(wxappIdentityWithAppId.csB, wxappIdentityWithAppId.hca);
                AppMethodBeat.m2505o(129779);
                return aR;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetByAppIdCall fail", e);
                AppMethodBeat.m2505o(129779);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$d */
    static class C19122d implements C45413i<WxappParams, IPCBoolean> {
        private C19122d() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(129784);
            IPCBoolean a = C19122d.m29736a((WxappParams) obj);
            AppMethodBeat.m2505o(129784);
            return a;
        }

        /* renamed from: a */
        private static IPCBoolean m29736a(WxappParams wxappParams) {
            AppMethodBeat.m2504i(129783);
            IPCBoolean iPCBoolean;
            if (wxappParams == null || C5046bo.isNullOrNil(wxappParams.username)) {
                C4990ab.m7420w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "SetCall:data or username is null");
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(129783);
                return iPCBoolean;
            }
            try {
                iPCBoolean = new IPCBoolean(((C26798h) C1720g.m3528K(C26798h.class)).mo21499a(wxappParams.username, wxappParams.hca, wxappParams.data, wxappParams.path, wxappParams.query, wxappParams.scene, wxappParams.time));
                AppMethodBeat.m2505o(129783);
                return iPCBoolean;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "SetCall fail", e);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(129783);
                return iPCBoolean;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$WxappIdentity */
    static class WxappIdentity implements Parcelable {
        public static final Creator<WxappIdentity> CREATOR = new C191231();
        public int hca;
        public String username;

        /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$WxappIdentity$1 */
        static class C191231 implements Creator<WxappIdentity> {
            C191231() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxappIdentity[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(129785);
                WxappIdentity wxappIdentity = new WxappIdentity(parcel);
                AppMethodBeat.m2505o(129785);
                return wxappIdentity;
            }
        }

        public WxappIdentity(String str, int i) {
            this.username = str;
            this.hca = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(129786);
            parcel.writeString(this.username);
            parcel.writeInt(this.hca);
            AppMethodBeat.m2505o(129786);
        }

        protected WxappIdentity(Parcel parcel) {
            AppMethodBeat.m2504i(129787);
            this.username = parcel.readString();
            this.hca = parcel.readInt();
            AppMethodBeat.m2505o(129787);
        }

        static {
            AppMethodBeat.m2504i(129788);
            AppMethodBeat.m2505o(129788);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$a */
    static class C19124a implements C45413i<WxappIdentity, IPCBoolean> {
        private C19124a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(129778);
            IPCBoolean a = C19124a.m29738a((WxappIdentity) obj);
            AppMethodBeat.m2505o(129778);
            return a;
        }

        /* renamed from: a */
        private static IPCBoolean m29738a(WxappIdentity wxappIdentity) {
            AppMethodBeat.m2504i(129777);
            IPCBoolean iPCBoolean;
            if (wxappIdentity == null || C5046bo.isNullOrNil(wxappIdentity.username)) {
                C4990ab.m7420w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "DeleteCall:data or username is null");
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(129777);
                return iPCBoolean;
            }
            try {
                IPCBoolean iPCBoolean2 = new IPCBoolean(((C26798h) C1720g.m3528K(C26798h.class)).mo21502ao(wxappIdentity.username, wxappIdentity.hca));
                AppMethodBeat.m2505o(129777);
                return iPCBoolean2;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "DeleteCall fail", e);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.m2505o(129777);
                return iPCBoolean;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$WxappParams */
    static class WxappParams implements Parcelable {
        public static final Creator<WxappParams> CREATOR = new C191251();
        public String data;
        public int hca;
        public String path;
        public String query;
        public int scene;
        public long time;
        public String username;

        /* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC$WxappParams$1 */
        static class C191251 implements Creator<WxappParams> {
            C191251() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxappParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(129793);
                WxappParams wxappParams = new WxappParams(parcel);
                AppMethodBeat.m2505o(129793);
                return wxappParams;
            }
        }

        public WxappParams(String str, int i, String str2, String str3, String str4, int i2, long j) {
            this.username = str;
            this.hca = i;
            this.data = str2;
            this.path = str3;
            this.query = str4;
            this.scene = i2;
            this.time = j;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(129794);
            parcel.writeString(this.username);
            parcel.writeInt(this.hca);
            parcel.writeString(this.data);
            parcel.writeString(this.path);
            parcel.writeString(this.query);
            parcel.writeInt(this.scene);
            parcel.writeLong(this.time);
            AppMethodBeat.m2505o(129794);
        }

        protected WxappParams(Parcel parcel) {
            AppMethodBeat.m2504i(129795);
            this.username = parcel.readString();
            this.hca = parcel.readInt();
            this.data = parcel.readString();
            this.path = parcel.readString();
            this.query = parcel.readString();
            this.scene = parcel.readInt();
            this.time = parcel.readLong();
            AppMethodBeat.m2505o(129795);
        }

        static {
            AppMethodBeat.m2504i(129796);
            AppMethodBeat.m2505o(129796);
        }
    }

    /* renamed from: a */
    public final boolean mo21499a(String str, int i, String str2, String str3, String str4, int i2, long j) {
        AppMethodBeat.m2504i(129797);
        C4990ab.m7410d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC set");
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", new WxappParams(str, i, str2, str3, str4, i2, j), C19122d.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.m2505o(129797);
            return false;
        }
        AppMethodBeat.m2505o(129797);
        return true;
    }

    /* renamed from: ao */
    public final boolean mo21502ao(String str, int i) {
        AppMethodBeat.m2504i(129798);
        C4990ab.m7410d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC delete");
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.m83628a("com.tencent.mm", new WxappIdentity(str, i), C19124a.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.m2505o(129798);
            return false;
        }
        AppMethodBeat.m2505o(129798);
        return true;
    }

    /* renamed from: aQ */
    public final long mo21500aQ(String str, int i) {
        AppMethodBeat.m2504i(129799);
        C4990ab.m7410d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC getUpdateTime");
        IPCLong iPCLong = (IPCLong) XIPCInvoker.m83628a("com.tencent.mm", new WxappIdentity(str, i), C19120c.class);
        if (iPCLong != null) {
            long j = iPCLong.value;
            AppMethodBeat.m2505o(129799);
            return j;
        }
        AppMethodBeat.m2505o(129799);
        return 0;
    }

    /* renamed from: aR */
    public final AppBrandBackgroundFetchDataParcel mo21501aR(String str, int i) {
        AppMethodBeat.m2504i(129800);
        C4990ab.m7410d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC getByAppId");
        AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = (AppBrandBackgroundFetchDataParcel) XIPCInvoker.m83628a("com.tencent.mm", new WxappIdentityWithAppId(str, i), C19121b.class);
        AppMethodBeat.m2505o(129800);
        return appBrandBackgroundFetchDataParcel;
    }
}
