package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaExposedParams implements Parcelable {
    public static final Creator<WxaExposedParams> CREATOR = new Creator<WxaExposedParams>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaExposedParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(114913);
            WxaExposedParams wxaExposedParams = new WxaExposedParams(parcel);
            AppMethodBeat.o(114913);
            return wxaExposedParams;
        }
    };
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

    public static class a {
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

        public final a zC(String str) {
            this.appId = str;
            return this;
        }

        public final a zD(String str) {
            this.username = str;
            return this;
        }

        public final a zE(String str) {
            this.nickname = str;
            return this;
        }

        public final a zF(String str) {
            this.iconUrl = str;
            return this;
        }

        public final a nF(int i) {
            this.from = i;
            return this;
        }

        public final a zG(String str) {
            this.pageId = str;
            return this;
        }

        public final WxaExposedParams ayP() {
            AppMethodBeat.i(114914);
            WxaExposedParams wxaExposedParams = new WxaExposedParams(this, (byte) 0);
            AppMethodBeat.o(114914);
            return wxaExposedParams;
        }
    }

    /* synthetic */ WxaExposedParams(a aVar, byte b) {
        this(aVar);
    }

    private WxaExposedParams(a aVar) {
        this.appId = aVar.appId;
        this.username = aVar.username;
        this.nickname = aVar.nickname;
        this.iconUrl = aVar.iconUrl;
        this.gVt = aVar.gVt;
        this.gVu = aVar.gVu;
        this.hiv = aVar.hiv;
        this.from = aVar.from;
        this.pageId = aVar.pageId;
        this.hiw = aVar.hiw;
    }

    protected WxaExposedParams(Parcel parcel) {
        AppMethodBeat.i(114915);
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
        AppMethodBeat.o(114915);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(114916);
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
        AppMethodBeat.o(114916);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(114918);
        AppMethodBeat.o(114918);
    }

    public String toString() {
        AppMethodBeat.i(114917);
        String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.gVt + ", pkgVersion=" + this.gVu + ", pkgMD5='" + this.hiv + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.hiw + '\'' + '}';
        AppMethodBeat.o(114917);
        return str;
    }
}
