package com.tencent.p177mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C10598b;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19575a;
import com.tencent.p177mm.plugin.appbrand.launching.C19574n.C19576c;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f.C19252a;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f.C19253b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC */
public final class ModularizingPkgRetrieverWC implements C19251f, C5684a {
    final LoadParams ihZ;
    volatile C19252a iia;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$a */
    static final class C27153a implements C37866a<LoadParams, WxaPkgResultProgressPair> {
        private C18507c<WxaPkgResultProgressPair> eGc = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$a$2 */
        class C271542 implements C10598b {
            C271542() {
            }

            /* renamed from: a */
            public final void mo22111a(WxaPkgLoadProgress wxaPkgLoadProgress) {
                AppMethodBeat.m2504i(131929);
                C4990ab.m7417i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "hy: prepare job progress callback, %s", wxaPkgLoadProgress.toString());
                if (C27153a.this.eGc != null) {
                    C27153a.this.eGc.mo5960ao(new WxaPkgResultProgressPair(wxaPkgLoadProgress));
                }
                AppMethodBeat.m2505o(131929);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$a$1 */
        class C271551 extends C19576c {
            C271551() {
            }

            /* renamed from: b */
            public final void mo6283b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.m2504i(131928);
                if (C27153a.this.eGc != null) {
                    C27153a.this.eGc.mo5960ao(new WxaPkgResultProgressPair(wxaPkgWrappingInfo));
                    C27153a.this.eGc = null;
                }
                AppMethodBeat.m2505o(131928);
            }
        }

        private C27153a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(131930);
            LoadParams loadParams = (LoadParams) obj;
            this.eGc = c18507c;
            C19574n f = C19575a.m30349f(loadParams.appId, loadParams.gTy, loadParams.cBc, loadParams.gVu);
            f.mo34782a(new C271551());
            f.mo34781a(new C271542());
            f.prepareAsync();
            AppMethodBeat.m2505o(131930);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$2 */
    class C384162 implements C18507c<WxaPkgResultProgressPair> {
        C384162() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(131926);
            WxaPkgResultProgressPair wxaPkgResultProgressPair = (WxaPkgResultProgressPair) obj;
            try {
                C19252a c19252a;
                switch (wxaPkgResultProgressPair.iih) {
                    case Finish:
                        WxaPkgWrappingInfo wxaPkgWrappingInfo = wxaPkgResultProgressPair.iif;
                        C4990ab.m7417i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "onFinish, input = %s, result = %s", ModularizingPkgRetrieverWC.this.ihZ.toString(), wxaPkgWrappingInfo == null ? null : wxaPkgWrappingInfo.gSP);
                        c19252a = ModularizingPkgRetrieverWC.this.iia;
                        if (c19252a != null) {
                            c19252a.mo34456ds(r0);
                            AppMethodBeat.m2505o(131926);
                            return;
                        }
                        break;
                    case Progressing:
                        WxaPkgLoadProgress wxaPkgLoadProgress = wxaPkgResultProgressPair.iig;
                        c19252a = ModularizingPkgRetrieverWC.this.iia;
                        if (wxaPkgLoadProgress == null || c19252a == null) {
                            C4990ab.m7412e("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "hy: non progress info! should not happen");
                            break;
                        }
                        c19252a.mo34455a(wxaPkgLoadProgress);
                        AppMethodBeat.m2505o(131926);
                        return;
                        break;
                }
                AppMethodBeat.m2505o(131926);
            } catch (NullPointerException e) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        throw e;
                    }
                });
                AppMethodBeat.m2505o(131926);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$WxaPkgResultProgressPair */
    static class WxaPkgResultProgressPair implements Parcelable {
        public static final Creator<WxaPkgResultProgressPair> CREATOR = new C334281();
        WxaPkgWrappingInfo iif;
        WxaPkgLoadProgress iig;
        private C27152a iih;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$WxaPkgResultProgressPair$a */
        enum C27152a {
            Finish,
            Progressing;

            static {
                AppMethodBeat.m2505o(131939);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$WxaPkgResultProgressPair$1 */
        static class C334281 implements Creator<WxaPkgResultProgressPair> {
            C334281() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaPkgResultProgressPair[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131936);
                WxaPkgResultProgressPair wxaPkgResultProgressPair = new WxaPkgResultProgressPair(parcel);
                AppMethodBeat.m2505o(131936);
                return wxaPkgResultProgressPair;
            }
        }

        WxaPkgResultProgressPair(Parcel parcel) {
            AppMethodBeat.m2504i(131940);
            this.iif = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
            this.iig = (WxaPkgLoadProgress) parcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader());
            this.iih = (C27152a) parcel.readSerializable();
            AppMethodBeat.m2505o(131940);
        }

        static {
            AppMethodBeat.m2504i(131942);
            AppMethodBeat.m2505o(131942);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131941);
            parcel.writeParcelable(this.iif, i);
            parcel.writeParcelable(this.iig, i);
            parcel.writeSerializable(this.iih);
            AppMethodBeat.m2505o(131941);
        }

        WxaPkgResultProgressPair(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.iif = wxaPkgWrappingInfo;
            this.iih = C27152a.Finish;
        }

        WxaPkgResultProgressPair(WxaPkgLoadProgress wxaPkgLoadProgress) {
            this.iig = wxaPkgLoadProgress;
            this.iih = C27152a.Progressing;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$1 */
    public static class C426061 extends C19253b {
        /* renamed from: i */
        public final C19251f mo34457i(C6750i c6750i, String str) {
            AppMethodBeat.m2504i(131925);
            ModularizingPkgRetrieverWC modularizingPkgRetrieverWC = new ModularizingPkgRetrieverWC(c6750i.mAppId, c6750i.mo15034ye().hhd.gVt, c6750i.mo15034ye().hhd.gVu, str, (byte) 0);
            try {
                if (c6750i instanceof C5685b) {
                    c6750i.keep(modularizingPkgRetrieverWC);
                }
            } catch (ClassCastException e) {
                if (C5047bp.dpL() || C5058f.IS_FLAVOR_RED) {
                    AppMethodBeat.m2505o(131925);
                    throw e;
                }
            }
            AppMethodBeat.m2505o(131925);
            return modularizingPkgRetrieverWC;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$LoadParams */
    static final class LoadParams implements Parcelable {
        public static final Creator<LoadParams> CREATOR = new C384171();
        public final String appId;
        public final int cBc;
        public final String gTy;
        public final int gVu;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$LoadParams$1 */
        static class C384171 implements Creator<LoadParams> {
            C384171() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LoadParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131931);
                LoadParams loadParams = new LoadParams(parcel);
                AppMethodBeat.m2505o(131931);
                return loadParams;
            }
        }

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
            AppMethodBeat.m2504i(131932);
            parcel.writeString(this.appId);
            parcel.writeInt(this.cBc);
            parcel.writeInt(this.gVu);
            parcel.writeString(this.gTy);
            AppMethodBeat.m2505o(131932);
        }

        LoadParams(Parcel parcel) {
            AppMethodBeat.m2504i(131933);
            this.appId = parcel.readString();
            this.cBc = parcel.readInt();
            this.gVu = parcel.readInt();
            this.gTy = parcel.readString();
            AppMethodBeat.m2505o(131933);
        }

        static {
            AppMethodBeat.m2504i(131935);
            AppMethodBeat.m2505o(131935);
        }

        public final String toString() {
            AppMethodBeat.m2504i(131934);
            String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.cBc + ", pkgVersion=" + this.gVu + ", moduleName='" + this.gTy + '\'' + '}';
            AppMethodBeat.m2505o(131934);
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
        AppMethodBeat.m2504i(131943);
        this.ihZ = new LoadParams(str, i, i2, str2, (byte) 0);
        AppMethodBeat.m2505o(131943);
    }

    public final void start() {
        AppMethodBeat.m2504i(131944);
        C4990ab.m7417i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", this.ihZ.toString());
        XIPCInvoker.m83629a("com.tencent.mm", this.ihZ, C27153a.class, new C384162());
        AppMethodBeat.m2505o(131944);
    }

    /* renamed from: a */
    public final void mo34453a(C19252a c19252a) {
        this.iia = c19252a;
    }
}
