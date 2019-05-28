package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class AppBrandBackgroundFetchDataStorageIPC implements h {

    static class WxappIdentityWithAppId implements Parcelable {
        public static final Creator<WxappIdentityWithAppId> CREATOR = new Creator<WxappIdentityWithAppId>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxappIdentityWithAppId[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(129789);
                WxappIdentityWithAppId wxappIdentityWithAppId = new WxappIdentityWithAppId(parcel);
                AppMethodBeat.o(129789);
                return wxappIdentityWithAppId;
            }
        };
        public String csB;
        public int hca;

        public WxappIdentityWithAppId(String str, int i) {
            this.csB = str;
            this.hca = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(129790);
            parcel.writeString(this.csB);
            parcel.writeInt(this.hca);
            AppMethodBeat.o(129790);
        }

        protected WxappIdentityWithAppId(Parcel parcel) {
            AppMethodBeat.i(129791);
            this.csB = parcel.readString();
            this.hca = parcel.readInt();
            AppMethodBeat.o(129791);
        }

        static {
            AppMethodBeat.i(129792);
            AppMethodBeat.o(129792);
        }
    }

    static class c implements i<WxappIdentity, IPCLong> {
        private c() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(129782);
            IPCLong b = b((WxappIdentity) obj);
            AppMethodBeat.o(129782);
            return b;
        }

        private static IPCLong b(WxappIdentity wxappIdentity) {
            AppMethodBeat.i(129781);
            IPCLong iPCLong;
            if (wxappIdentity == null || bo.isNullOrNil(wxappIdentity.username)) {
                ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetUpdateTimeCall:data or username is null");
                iPCLong = new IPCLong(0);
                AppMethodBeat.o(129781);
                return iPCLong;
            }
            try {
                IPCLong iPCLong2 = new IPCLong(((h) g.K(h.class)).aQ(wxappIdentity.username, wxappIdentity.hca));
                AppMethodBeat.o(129781);
                return iPCLong2;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetUpdateTimeCall fail", e);
                iPCLong = new IPCLong(0);
                AppMethodBeat.o(129781);
                return iPCLong;
            }
        }
    }

    static class b implements i<WxappIdentityWithAppId, AppBrandBackgroundFetchDataParcel> {
        private b() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(129780);
            AppBrandBackgroundFetchDataParcel a = a((WxappIdentityWithAppId) obj);
            AppMethodBeat.o(129780);
            return a;
        }

        private static AppBrandBackgroundFetchDataParcel a(WxappIdentityWithAppId wxappIdentityWithAppId) {
            AppMethodBeat.i(129779);
            if (wxappIdentityWithAppId == null || bo.isNullOrNil(wxappIdentityWithAppId.csB)) {
                ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetByAppIdCall:data or appid is null");
                AppMethodBeat.o(129779);
                return null;
            }
            try {
                AppBrandBackgroundFetchDataParcel aR = ((h) g.K(h.class)).aR(wxappIdentityWithAppId.csB, wxappIdentityWithAppId.hca);
                AppMethodBeat.o(129779);
                return aR;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetByAppIdCall fail", e);
                AppMethodBeat.o(129779);
                return null;
            }
        }
    }

    static class d implements i<WxappParams, IPCBoolean> {
        private d() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(129784);
            IPCBoolean a = a((WxappParams) obj);
            AppMethodBeat.o(129784);
            return a;
        }

        private static IPCBoolean a(WxappParams wxappParams) {
            AppMethodBeat.i(129783);
            IPCBoolean iPCBoolean;
            if (wxappParams == null || bo.isNullOrNil(wxappParams.username)) {
                ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "SetCall:data or username is null");
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(129783);
                return iPCBoolean;
            }
            try {
                iPCBoolean = new IPCBoolean(((h) g.K(h.class)).a(wxappParams.username, wxappParams.hca, wxappParams.data, wxappParams.path, wxappParams.query, wxappParams.scene, wxappParams.time));
                AppMethodBeat.o(129783);
                return iPCBoolean;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "SetCall fail", e);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(129783);
                return iPCBoolean;
            }
        }
    }

    static class WxappIdentity implements Parcelable {
        public static final Creator<WxappIdentity> CREATOR = new Creator<WxappIdentity>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxappIdentity[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(129785);
                WxappIdentity wxappIdentity = new WxappIdentity(parcel);
                AppMethodBeat.o(129785);
                return wxappIdentity;
            }
        };
        public int hca;
        public String username;

        public WxappIdentity(String str, int i) {
            this.username = str;
            this.hca = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(129786);
            parcel.writeString(this.username);
            parcel.writeInt(this.hca);
            AppMethodBeat.o(129786);
        }

        protected WxappIdentity(Parcel parcel) {
            AppMethodBeat.i(129787);
            this.username = parcel.readString();
            this.hca = parcel.readInt();
            AppMethodBeat.o(129787);
        }

        static {
            AppMethodBeat.i(129788);
            AppMethodBeat.o(129788);
        }
    }

    static class a implements i<WxappIdentity, IPCBoolean> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(129778);
            IPCBoolean a = a((WxappIdentity) obj);
            AppMethodBeat.o(129778);
            return a;
        }

        private static IPCBoolean a(WxappIdentity wxappIdentity) {
            AppMethodBeat.i(129777);
            IPCBoolean iPCBoolean;
            if (wxappIdentity == null || bo.isNullOrNil(wxappIdentity.username)) {
                ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "DeleteCall:data or username is null");
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(129777);
                return iPCBoolean;
            }
            try {
                IPCBoolean iPCBoolean2 = new IPCBoolean(((h) g.K(h.class)).ao(wxappIdentity.username, wxappIdentity.hca));
                AppMethodBeat.o(129777);
                return iPCBoolean2;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "DeleteCall fail", e);
                iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(129777);
                return iPCBoolean;
            }
        }
    }

    static class WxappParams implements Parcelable {
        public static final Creator<WxappParams> CREATOR = new Creator<WxappParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxappParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(129793);
                WxappParams wxappParams = new WxappParams(parcel);
                AppMethodBeat.o(129793);
                return wxappParams;
            }
        };
        public String data;
        public int hca;
        public String path;
        public String query;
        public int scene;
        public long time;
        public String username;

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
            AppMethodBeat.i(129794);
            parcel.writeString(this.username);
            parcel.writeInt(this.hca);
            parcel.writeString(this.data);
            parcel.writeString(this.path);
            parcel.writeString(this.query);
            parcel.writeInt(this.scene);
            parcel.writeLong(this.time);
            AppMethodBeat.o(129794);
        }

        protected WxappParams(Parcel parcel) {
            AppMethodBeat.i(129795);
            this.username = parcel.readString();
            this.hca = parcel.readInt();
            this.data = parcel.readString();
            this.path = parcel.readString();
            this.query = parcel.readString();
            this.scene = parcel.readInt();
            this.time = parcel.readLong();
            AppMethodBeat.o(129795);
        }

        static {
            AppMethodBeat.i(129796);
            AppMethodBeat.o(129796);
        }
    }

    public final boolean a(String str, int i, String str2, String str3, String str4, int i2, long j) {
        AppMethodBeat.i(129797);
        ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC set");
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new WxappParams(str, i, str2, str3, str4, i2, j), d.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(129797);
            return false;
        }
        AppMethodBeat.o(129797);
        return true;
    }

    public final boolean ao(String str, int i) {
        AppMethodBeat.i(129798);
        ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC delete");
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new WxappIdentity(str, i), a.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(129798);
            return false;
        }
        AppMethodBeat.o(129798);
        return true;
    }

    public final long aQ(String str, int i) {
        AppMethodBeat.i(129799);
        ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC getUpdateTime");
        IPCLong iPCLong = (IPCLong) XIPCInvoker.a("com.tencent.mm", new WxappIdentity(str, i), c.class);
        if (iPCLong != null) {
            long j = iPCLong.value;
            AppMethodBeat.o(129799);
            return j;
        }
        AppMethodBeat.o(129799);
        return 0;
    }

    public final AppBrandBackgroundFetchDataParcel aR(String str, int i) {
        AppMethodBeat.i(129800);
        ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC getByAppId");
        AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = (AppBrandBackgroundFetchDataParcel) XIPCInvoker.a("com.tencent.mm", new WxappIdentityWithAppId(str, i), b.class);
        AppMethodBeat.o(129800);
        return appBrandBackgroundFetchDataParcel;
    }
}
