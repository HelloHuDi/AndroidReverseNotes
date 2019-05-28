package com.tencent.luggage.sdk.launching;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class OnWXAppResultXPCWrapper<R extends Parcelable> implements Parcelable {
    public static final Creator<OnWXAppResultXPCWrapper> CREATOR = new C09993();
    /* renamed from: JF */
    private final ResultReceiver f4286JF;
    private final C17829b<R> bRf;

    /* renamed from: com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper$3 */
    static class C09993 implements Creator<OnWXAppResultXPCWrapper> {
        C09993() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OnWXAppResultXPCWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(101671);
            OnWXAppResultXPCWrapper onWXAppResultXPCWrapper = new OnWXAppResultXPCWrapper(parcel, (byte) 0);
            AppMethodBeat.m2505o(101671);
            return onWXAppResultXPCWrapper;
        }
    }

    /* renamed from: com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper$2 */
    class C88772 implements C17829b<R> {
        C88772() {
        }

        /* renamed from: a */
        public final void mo20080a(R r) {
            AppMethodBeat.m2504i(101670);
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("parcel", new SafeParcelableWrapper((Parcelable) r));
            OnWXAppResultXPCWrapper.this.f4286JF.send(-1, bundle);
            AppMethodBeat.m2505o(101670);
        }
    }

    static final class SafeParcelableWrapper implements Parcelable {
        public static final Creator<SafeParcelableWrapper> CREATOR = new C88781();
        private Parcelable bRi;

        /* renamed from: com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper$SafeParcelableWrapper$1 */
        static class C88781 implements Creator<SafeParcelableWrapper> {
            C88781() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SafeParcelableWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(101672);
                SafeParcelableWrapper safeParcelableWrapper = new SafeParcelableWrapper(parcel);
                AppMethodBeat.m2505o(101672);
                return safeParcelableWrapper;
            }
        }

        SafeParcelableWrapper(Parcelable parcelable) {
            this.bRi = parcelable;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(101673);
            if (this.bRi == null) {
                parcel.writeString(null);
                AppMethodBeat.m2505o(101673);
                return;
            }
            parcel.writeString(this.bRi.getClass().getName());
            parcel.writeParcelable(this.bRi, i);
            AppMethodBeat.m2505o(101673);
        }

        SafeParcelableWrapper(Parcel parcel) {
            AppMethodBeat.m2504i(101674);
            String readString = parcel.readString();
            if (TextUtils.isEmpty(readString)) {
                this.bRi = null;
                AppMethodBeat.m2505o(101674);
                return;
            }
            try {
                this.bRi = parcel.readParcelable(Class.forName(readString).getClassLoader());
                AppMethodBeat.m2505o(101674);
            } catch (ClassNotFoundException e) {
                C45124d.m82928e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "ClassNotFoundException with %s", readString);
                AppMethodBeat.m2505o(101674);
            }
        }

        static {
            AppMethodBeat.m2504i(101675);
            AppMethodBeat.m2505o(101675);
        }
    }

    /* synthetic */ OnWXAppResultXPCWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    public static <R extends Parcelable> void m27900a(C17829b<R> c17829b, Parcel parcel) {
        AppMethodBeat.m2504i(101676);
        if (c17829b == null) {
            parcel.writeString(null);
            AppMethodBeat.m2505o(101676);
            return;
        }
        parcel.writeParcelable(new OnWXAppResultXPCWrapper((C17829b) c17829b), 0);
        AppMethodBeat.m2505o(101676);
    }

    /* renamed from: b */
    public static C17829b<?> m27901b(Parcel parcel) {
        C17829b<?> c17829b;
        AppMethodBeat.m2504i(101677);
        OnWXAppResultXPCWrapper onWXAppResultXPCWrapper = (OnWXAppResultXPCWrapper) parcel.readParcelable(OnWXAppResultXPCWrapper.class.getClassLoader());
        if (onWXAppResultXPCWrapper != null) {
            c17829b = onWXAppResultXPCWrapper.bRf;
        } else {
            c17829b = null;
        }
        AppMethodBeat.m2505o(101677);
        return c17829b;
    }

    private OnWXAppResultXPCWrapper(final C17829b<R> c17829b) {
        AppMethodBeat.m2504i(101678);
        this.bRf = c17829b;
        this.f4286JF = new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* Access modifiers changed, original: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.m2504i(101669);
                if (bundle == null) {
                    c17829b.mo20080a(null);
                    AppMethodBeat.m2505o(101669);
                    return;
                }
                bundle.setClassLoader(SafeParcelableWrapper.class.getClassLoader());
                try {
                    c17829b.mo20080a(((SafeParcelableWrapper) bundle.getParcelable("parcel")).bRi);
                    AppMethodBeat.m2505o(101669);
                } catch (ClassCastException | NullPointerException e) {
                    C45124d.m82928e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "onReceiveResult, e = %s", e);
                    c17829b.mo20080a(null);
                    AppMethodBeat.m2505o(101669);
                }
            }
        };
        AppMethodBeat.m2505o(101678);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(101679);
        this.f4286JF.writeToParcel(parcel, i);
        AppMethodBeat.m2505o(101679);
    }

    private OnWXAppResultXPCWrapper(Parcel parcel) {
        AppMethodBeat.m2504i(101680);
        this.f4286JF = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        this.bRf = new C88772();
        AppMethodBeat.m2505o(101680);
    }

    static {
        AppMethodBeat.m2504i(101681);
        AppMethodBeat.m2505o(101681);
    }
}
