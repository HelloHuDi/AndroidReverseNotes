package com.tencent.p177mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C26341k;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.p1532e.C37868a;
import com.tencent.p177mm.ipcinvoker.p1532e.C42131b;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;

/* renamed from: com.tencent.mm.ipcinvoker.extension.XIPCInvoker */
public final class XIPCInvoker {

    /* renamed from: com.tencent.mm.ipcinvoker.extension.XIPCInvoker$c */
    static class C37869c implements C45413i<WrapperParcelable, WrapperParcelable> {
        private C37869c() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(114095);
            WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
            Object obj2 = wrapperParcelable.eGy;
            String str = wrapperParcelable.eGB;
            if (str == null || str.length() == 0) {
                C26340b.m41916e("IPC.XIPCInvoker", "proxy SyncInvoke failed, class is null or nil.", new Object[0]);
                WrapperParcelable wrapperParcelable2 = new WrapperParcelable(null, null);
                AppMethodBeat.m2505o(114095);
                return wrapperParcelable2;
            }
            C45413i c45413i = (C45413i) C26341k.m41919b(str, C45413i.class);
            if (c45413i == null) {
                C26340b.m41918w("IPC.XIPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", str);
                Object wrapperParcelable3 = new WrapperParcelable(null, null);
                AppMethodBeat.m2505o(114095);
                return wrapperParcelable3;
            }
            WrapperParcelable wrapperParcelable4 = new WrapperParcelable(null, c45413i.mo4785am(obj2));
            AppMethodBeat.m2505o(114095);
            return wrapperParcelable4;
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.extension.XIPCInvoker$a */
    static class C42133a implements C37866a<WrapperParcelable, WrapperParcelable> {
        private C42133a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(114091);
            WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
            Object obj2 = wrapperParcelable.eGy;
            String str = wrapperParcelable.eGB;
            if (str == null || str.length() == 0) {
                C26340b.m41916e("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.", new Object[0]);
                AppMethodBeat.m2505o(114091);
                return;
            }
            C37866a c37866a = (C37866a) C26341k.m41919b(str, C37866a.class);
            if (c37866a == null) {
                C26340b.m41918w("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", str);
                AppMethodBeat.m2505o(114091);
                return;
            }
            c37866a.mo5958a(obj2, new C42134b(c18507c));
            AppMethodBeat.m2505o(114091);
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.extension.XIPCInvoker$b */
    static class C42134b implements C18507c, C37868a {
        C37868a eGA;
        C18507c<WrapperParcelable> eGz;

        C42134b(C18507c<WrapperParcelable> c18507c) {
            AppMethodBeat.m2504i(114092);
            this.eGz = c18507c;
            if (c18507c instanceof C37868a) {
                this.eGA = (C37868a) c18507c;
            }
            AppMethodBeat.m2505o(114092);
        }

        /* renamed from: ao */
        public final void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(114093);
            if (this.eGz != null) {
                this.eGz.mo5960ao(new WrapperParcelable(null, obj));
            }
            AppMethodBeat.m2505o(114093);
        }

        /* renamed from: a */
        public final void mo33744a(C42131b c42131b) {
            AppMethodBeat.m2504i(114094);
            if (this.eGA == null) {
                AppMethodBeat.m2505o(114094);
                return;
            }
            this.eGA.mo33744a(c42131b);
            AppMethodBeat.m2505o(114094);
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.extension.XIPCInvoker$WrapperParcelable */
    static class WrapperParcelable implements Parcelable {
        public static final Creator<WrapperParcelable> CREATOR = new C327151();
        String eGB;
        Object eGy;

        /* renamed from: com.tencent.mm.ipcinvoker.extension.XIPCInvoker$WrapperParcelable$1 */
        static class C327151 implements Creator<WrapperParcelable> {
            C327151() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WrapperParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(114096);
                WrapperParcelable wrapperParcelable = new WrapperParcelable();
                wrapperParcelable.eGB = parcel.readString();
                if (parcel.readInt() == 1) {
                    wrapperParcelable.eGy = C18509c.m28812a(parcel.readString(), parcel);
                }
                AppMethodBeat.m2505o(114096);
                return wrapperParcelable;
            }
        }

        /* synthetic */ WrapperParcelable(byte b) {
            this();
        }

        private WrapperParcelable() {
        }

        public WrapperParcelable(String str, Object obj) {
            this.eGB = str;
            this.eGy = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(114097);
            parcel.writeString(this.eGB);
            if (this.eGy != null) {
                C18508a ar = C18509c.m28815ar(this.eGy);
                if (ar != null) {
                    parcel.writeInt(1);
                    parcel.writeString(ar.getClass().getName());
                    ar.mo20823a(this.eGy, parcel);
                    AppMethodBeat.m2505o(114097);
                    return;
                }
            }
            parcel.writeInt(0);
            AppMethodBeat.m2505o(114097);
        }

        static {
            AppMethodBeat.m2504i(114098);
            AppMethodBeat.m2505o(114098);
        }
    }

    /* renamed from: a */
    public static <T extends C37866a<InputType, ResultType>, InputType, ResultType> void m83629a(String str, InputType inputType, Class<T> cls, final C18507c<ResultType> c18507c) {
        AppMethodBeat.m2504i(114099);
        C9549f.m17012a(str, new WrapperParcelable(cls.getName(), inputType), C42133a.class, new C18507c<WrapperParcelable>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(114090);
                WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
                if (c18507c != null) {
                    if (wrapperParcelable == null) {
                        C26340b.m41918w("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!", new Object[0]);
                        c18507c.mo5960ao(null);
                        AppMethodBeat.m2505o(114090);
                        return;
                    }
                    c18507c.mo5960ao(wrapperParcelable.eGy);
                }
                AppMethodBeat.m2505o(114090);
            }
        });
        AppMethodBeat.m2505o(114099);
    }

    /* renamed from: a */
    public static <T extends C45413i<InputType, ResultType>, InputType, ResultType> ResultType m83628a(String str, InputType inputType, Class<T> cls) {
        AppMethodBeat.m2504i(114100);
        WrapperParcelable wrapperParcelable = (WrapperParcelable) C9549f.m17010a(str, new WrapperParcelable(cls.getName(), inputType), C37869c.class);
        if (wrapperParcelable == null) {
            C26340b.m41918w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
            AppMethodBeat.m2505o(114100);
            return null;
        }
        ResultType resultType = wrapperParcelable.eGy;
        AppMethodBeat.m2505o(114100);
        return resultType;
    }
}
