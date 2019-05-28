package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.j.f;
import com.tencent.mm.plugin.appbrand.launching.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class ModularizingPkgRetrieverWC implements f, com.tencent.mm.vending.e.a {
    final LoadParams ihZ;
    volatile com.tencent.mm.plugin.appbrand.j.f.a iia;

    static final class a implements com.tencent.mm.ipcinvoker.a<LoadParams, WxaPkgResultProgressPair> {
        private c<WxaPkgResultProgressPair> eGc = null;

        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(131930);
            LoadParams loadParams = (LoadParams) obj;
            this.eGc = cVar;
            n f = com.tencent.mm.plugin.appbrand.launching.n.a.f(loadParams.appId, loadParams.gTy, loadParams.cBc, loadParams.gVu);
            f.a(new n.c() {
                public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(131928);
                    if (a.this.eGc != null) {
                        a.this.eGc.ao(new WxaPkgResultProgressPair(wxaPkgWrappingInfo));
                        a.this.eGc = null;
                    }
                    AppMethodBeat.o(131928);
                }
            });
            f.a(new b() {
                public final void a(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    AppMethodBeat.i(131929);
                    ab.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "hy: prepare job progress callback, %s", wxaPkgLoadProgress.toString());
                    if (a.this.eGc != null) {
                        a.this.eGc.ao(new WxaPkgResultProgressPair(wxaPkgLoadProgress));
                    }
                    AppMethodBeat.o(131929);
                }
            });
            f.prepareAsync();
            AppMethodBeat.o(131930);
        }
    }

    static class WxaPkgResultProgressPair implements Parcelable {
        public static final Creator<WxaPkgResultProgressPair> CREATOR = new Creator<WxaPkgResultProgressPair>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaPkgResultProgressPair[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131936);
                WxaPkgResultProgressPair wxaPkgResultProgressPair = new WxaPkgResultProgressPair(parcel);
                AppMethodBeat.o(131936);
                return wxaPkgResultProgressPair;
            }
        };
        WxaPkgWrappingInfo iif;
        WxaPkgLoadProgress iig;
        private a iih;

        enum a {
            Finish,
            Progressing;

            static {
                AppMethodBeat.o(131939);
            }
        }

        WxaPkgResultProgressPair(Parcel parcel) {
            AppMethodBeat.i(131940);
            this.iif = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
            this.iig = (WxaPkgLoadProgress) parcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader());
            this.iih = (a) parcel.readSerializable();
            AppMethodBeat.o(131940);
        }

        static {
            AppMethodBeat.i(131942);
            AppMethodBeat.o(131942);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131941);
            parcel.writeParcelable(this.iif, i);
            parcel.writeParcelable(this.iig, i);
            parcel.writeSerializable(this.iih);
            AppMethodBeat.o(131941);
        }

        WxaPkgResultProgressPair(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.iif = wxaPkgWrappingInfo;
            this.iih = a.Finish;
        }

        WxaPkgResultProgressPair(WxaPkgLoadProgress wxaPkgLoadProgress) {
            this.iig = wxaPkgLoadProgress;
            this.iih = a.Progressing;
        }
    }

    static final class LoadParams implements Parcelable {
        public static final Creator<LoadParams> CREATOR = new Creator<LoadParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LoadParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131931);
                LoadParams loadParams = new LoadParams(parcel);
                AppMethodBeat.o(131931);
                return loadParams;
            }
        };
        public final String appId;
        public final int cBc;
        public final String gTy;
        public final int gVu;

        /* synthetic */ LoadParams(String str, int i, int i2, String str2, byte b) {
            this(str, i, i2, str2);
        }

        private LoadParams(String str, int i, int i2, String str2) {
            this.appId = str;
            this.cBc = i;
            this.gVu = i2;
            this.gTy = str2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131932);
            parcel.writeString(this.appId);
            parcel.writeInt(this.cBc);
            parcel.writeInt(this.gVu);
            parcel.writeString(this.gTy);
            AppMethodBeat.o(131932);
        }

        LoadParams(Parcel parcel) {
            AppMethodBeat.i(131933);
            this.appId = parcel.readString();
            this.cBc = parcel.readInt();
            this.gVu = parcel.readInt();
            this.gTy = parcel.readString();
            AppMethodBeat.o(131933);
        }

        static {
            AppMethodBeat.i(131935);
            AppMethodBeat.o(131935);
        }

        public final String toString() {
            AppMethodBeat.i(131934);
            String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.cBc + ", pkgVersion=" + this.gVu + ", moduleName='" + this.gTy + '\'' + '}';
            AppMethodBeat.o(131934);
            return str;
        }
    }

    /* synthetic */ ModularizingPkgRetrieverWC(String str, int i, int i2, String str2, byte b) {
        this(str, i, i2, str2);
    }

    public final void dead() {
        this.iia = null;
    }

    private ModularizingPkgRetrieverWC(String str, int i, int i2, String str2) {
        AppMethodBeat.i(131943);
        this.ihZ = new LoadParams(str, i, i2, str2, (byte) 0);
        AppMethodBeat.o(131943);
    }

    public final void start() {
        AppMethodBeat.i(131944);
        ab.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", this.ihZ.toString());
        XIPCInvoker.a("com.tencent.mm", this.ihZ, a.class, new c<WxaPkgResultProgressPair>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(131926);
                WxaPkgResultProgressPair wxaPkgResultProgressPair = (WxaPkgResultProgressPair) obj;
                try {
                    com.tencent.mm.plugin.appbrand.j.f.a aVar;
                    switch (wxaPkgResultProgressPair.iih) {
                        case Finish:
                            WxaPkgWrappingInfo wxaPkgWrappingInfo = wxaPkgResultProgressPair.iif;
                            ab.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "onFinish, input = %s, result = %s", ModularizingPkgRetrieverWC.this.ihZ.toString(), wxaPkgWrappingInfo == null ? null : wxaPkgWrappingInfo.gSP);
                            aVar = ModularizingPkgRetrieverWC.this.iia;
                            if (aVar != null) {
                                aVar.ds(r0);
                                AppMethodBeat.o(131926);
                                return;
                            }
                            break;
                        case Progressing:
                            WxaPkgLoadProgress wxaPkgLoadProgress = wxaPkgResultProgressPair.iig;
                            aVar = ModularizingPkgRetrieverWC.this.iia;
                            if (wxaPkgLoadProgress == null || aVar == null) {
                                ab.e("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "hy: non progress info! should not happen");
                                break;
                            }
                            aVar.a(wxaPkgLoadProgress);
                            AppMethodBeat.o(131926);
                            return;
                            break;
                    }
                    AppMethodBeat.o(131926);
                } catch (NullPointerException e) {
                    al.d(new Runnable() {
                        public final void run() {
                            throw e;
                        }
                    });
                    AppMethodBeat.o(131926);
                }
            }
        });
        AppMethodBeat.o(131944);
    }

    public final void a(com.tencent.mm.plugin.appbrand.j.f.a aVar) {
        this.iia = aVar;
    }
}
