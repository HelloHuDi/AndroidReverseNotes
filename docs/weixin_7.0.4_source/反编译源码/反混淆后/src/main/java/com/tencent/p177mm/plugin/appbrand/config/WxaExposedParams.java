package com.tencent.p177mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.config.WxaExposedParams */
public class WxaExposedParams implements Parcelable {
    public static final Creator<WxaExposedParams> CREATOR = new C381601();
    public String appId;
    public int from;
    public int gVt;
    public int gVu;
    public String hiv;
    public String hiw;
    public String iconUrl;
    public String nickname;
    public String pageId;
    public String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a */
    public static class C19154a {
        public String appId = "";
        public int from = 0;
        public int gVt = -1;
        public int gVu = -1;
        public String hiv = "";
        public String hiw = "";
        public String iconUrl = "";
        public String nickname = "";
        public String pageId = "";
        public String username = "";

        /* renamed from: zC */
        public final C19154a mo34388zC(String str) {
            this.appId = str;
            return this;
        }

        /* renamed from: zD */
        public final C19154a mo34389zD(String str) {
            this.username = str;
            return this;
        }

        /* renamed from: zE */
        public final C19154a mo34390zE(String str) {
            this.nickname = str;
            return this;
        }

        /* renamed from: zF */
        public final C19154a mo34391zF(String str) {
            this.iconUrl = str;
            return this;
        }

        /* renamed from: nF */
        public final C19154a mo34387nF(int i) {
            this.from = i;
            return this;
        }

        /* renamed from: zG */
        public final C19154a mo34392zG(String str) {
            this.pageId = str;
            return this;
        }

        public final WxaExposedParams ayP() {
            AppMethodBeat.m2504i(114914);
            WxaExposedParams wxaExposedParams = new WxaExposedParams(this, (byte) 0);
            AppMethodBeat.m2505o(114914);
            return wxaExposedParams;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.WxaExposedParams$1 */
    static class C381601 implements Creator<WxaExposedParams> {
        C381601() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaExposedParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(114913);
            WxaExposedParams wxaExposedParams = new WxaExposedParams(parcel);
            AppMethodBeat.m2505o(114913);
            return wxaExposedParams;
        }
    }

    /* synthetic */ WxaExposedParams(C19154a c19154a, byte b) {
        this(c19154a);
    }

    private WxaExposedParams(C19154a c19154a) {
        this.appId = c19154a.appId;
        this.username = c19154a.username;
        this.nickname = c19154a.nickname;
        this.iconUrl = c19154a.iconUrl;
        this.gVt = c19154a.gVt;
        this.gVu = c19154a.gVu;
        this.hiv = c19154a.hiv;
        this.from = c19154a.from;
        this.pageId = c19154a.pageId;
        this.hiw = c19154a.hiw;
    }

    protected WxaExposedParams(Parcel parcel) {
        AppMethodBeat.m2504i(114915);
        this.appId = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        this.iconUrl = parcel.readString();
        this.gVt = parcel.readInt();
        this.gVu = parcel.readInt();
        this.hiv = parcel.readString();
        this.from = parcel.readInt();
        this.pageId = parcel.readString();
        this.hiw = parcel.readString();
        AppMethodBeat.m2505o(114915);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(114916);
        parcel.writeString(this.appId);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.gVt);
        parcel.writeInt(this.gVu);
        parcel.writeString(this.hiv);
        parcel.writeInt(this.from);
        parcel.writeString(this.pageId);
        parcel.writeString(this.hiw);
        AppMethodBeat.m2505o(114916);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(114918);
        AppMethodBeat.m2505o(114918);
    }

    public String toString() {
        AppMethodBeat.m2504i(114917);
        String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.gVt + ", pkgVersion=" + this.gVu + ", pkgMD5='" + this.hiv + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.hiw + '\'' + '}';
        AppMethodBeat.m2505o(114917);
        return str;
    }
}
