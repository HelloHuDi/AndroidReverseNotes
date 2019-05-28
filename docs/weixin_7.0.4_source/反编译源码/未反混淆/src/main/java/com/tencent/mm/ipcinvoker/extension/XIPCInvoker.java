package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.k;

public final class XIPCInvoker {

    static class c implements i<WrapperParcelable, WrapperParcelable> {
        private c() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(114095);
            WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
            Object obj2 = wrapperParcelable.eGy;
            String str = wrapperParcelable.eGB;
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.XIPCInvoker", "proxy SyncInvoke failed, class is null or nil.", new Object[0]);
                WrapperParcelable wrapperParcelable2 = new WrapperParcelable(null, null);
                AppMethodBeat.o(114095);
                return wrapperParcelable2;
            }
            i iVar = (i) k.b(str, i.class);
            if (iVar == null) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", str);
                Object wrapperParcelable3 = new WrapperParcelable(null, null);
                AppMethodBeat.o(114095);
                return wrapperParcelable3;
            }
            WrapperParcelable wrapperParcelable4 = new WrapperParcelable(null, iVar.am(obj2));
            AppMethodBeat.o(114095);
            return wrapperParcelable4;
        }
    }

    static class a implements com.tencent.mm.ipcinvoker.a<WrapperParcelable, WrapperParcelable> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(114091);
            WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
            Object obj2 = wrapperParcelable.eGy;
            String str = wrapperParcelable.eGB;
            if (str == null || str.length() == 0) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.", new Object[0]);
                AppMethodBeat.o(114091);
                return;
            }
            com.tencent.mm.ipcinvoker.a aVar = (com.tencent.mm.ipcinvoker.a) k.b(str, com.tencent.mm.ipcinvoker.a.class);
            if (aVar == null) {
                com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", str);
                AppMethodBeat.o(114091);
                return;
            }
            aVar.a(obj2, new b(cVar));
            AppMethodBeat.o(114091);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.c, com.tencent.mm.ipcinvoker.e.a {
        com.tencent.mm.ipcinvoker.e.a eGA;
        com.tencent.mm.ipcinvoker.c<WrapperParcelable> eGz;

        b(com.tencent.mm.ipcinvoker.c<WrapperParcelable> cVar) {
            AppMethodBeat.i(114092);
            this.eGz = cVar;
            if (cVar instanceof com.tencent.mm.ipcinvoker.e.a) {
                this.eGA = (com.tencent.mm.ipcinvoker.e.a) cVar;
            }
            AppMethodBeat.o(114092);
        }

        public final void ao(Object obj) {
            AppMethodBeat.i(114093);
            if (this.eGz != null) {
                this.eGz.ao(new WrapperParcelable(null, obj));
            }
            AppMethodBeat.o(114093);
        }

        public final void a(com.tencent.mm.ipcinvoker.e.b bVar) {
            AppMethodBeat.i(114094);
            if (this.eGA == null) {
                AppMethodBeat.o(114094);
                return;
            }
            this.eGA.a(bVar);
            AppMethodBeat.o(114094);
        }
    }

    static class WrapperParcelable implements Parcelable {
        public static final Creator<WrapperParcelable> CREATOR = new Creator<WrapperParcelable>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WrapperParcelable[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(114096);
                WrapperParcelable wrapperParcelable = new WrapperParcelable();
                wrapperParcelable.eGB = parcel.readString();
                if (parcel.readInt() == 1) {
                    wrapperParcelable.eGy = c.a(parcel.readString(), parcel);
                }
                AppMethodBeat.o(114096);
                return wrapperParcelable;
            }
        };
        String eGB;
        Object eGy;

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
            AppMethodBeat.i(114097);
            parcel.writeString(this.eGB);
            if (this.eGy != null) {
                a ar = c.ar(this.eGy);
                if (ar != null) {
                    parcel.writeInt(1);
                    parcel.writeString(ar.getClass().getName());
                    ar.a(this.eGy, parcel);
                    AppMethodBeat.o(114097);
                    return;
                }
            }
            parcel.writeInt(0);
            AppMethodBeat.o(114097);
        }

        static {
            AppMethodBeat.i(114098);
            AppMethodBeat.o(114098);
        }
    }

    public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType, ResultType> void a(String str, InputType inputType, Class<T> cls, final com.tencent.mm.ipcinvoker.c<ResultType> cVar) {
        AppMethodBeat.i(114099);
        f.a(str, new WrapperParcelable(cls.getName(), inputType), a.class, new com.tencent.mm.ipcinvoker.c<WrapperParcelable>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(114090);
                WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
                if (cVar != null) {
                    if (wrapperParcelable == null) {
                        com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!", new Object[0]);
                        cVar.ao(null);
                        AppMethodBeat.o(114090);
                        return;
                    }
                    cVar.ao(wrapperParcelable.eGy);
                }
                AppMethodBeat.o(114090);
            }
        });
        AppMethodBeat.o(114099);
    }

    public static <T extends i<InputType, ResultType>, InputType, ResultType> ResultType a(String str, InputType inputType, Class<T> cls) {
        AppMethodBeat.i(114100);
        WrapperParcelable wrapperParcelable = (WrapperParcelable) f.a(str, new WrapperParcelable(cls.getName(), inputType), c.class);
        if (wrapperParcelable == null) {
            com.tencent.mm.ipcinvoker.h.b.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!", new Object[0]);
            AppMethodBeat.o(114100);
            return null;
        }
        ResultType resultType = wrapperParcelable.eGy;
        AppMethodBeat.o(114100);
        return resultType;
    }
}
