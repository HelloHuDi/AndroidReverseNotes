package com.tencent.luggage.sdk.launching;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class OnWXAppResultXPCWrapper<R extends Parcelable> implements Parcelable {
    public static final Creator<OnWXAppResultXPCWrapper> CREATOR = new Creator<OnWXAppResultXPCWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OnWXAppResultXPCWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101671);
            OnWXAppResultXPCWrapper onWXAppResultXPCWrapper = new OnWXAppResultXPCWrapper(parcel, (byte) 0);
            AppMethodBeat.o(101671);
            return onWXAppResultXPCWrapper;
        }
    };
    private final ResultReceiver JF;
    private final b<R> bRf;

    static final class SafeParcelableWrapper implements Parcelable {
        public static final Creator<SafeParcelableWrapper> CREATOR = new Creator<SafeParcelableWrapper>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SafeParcelableWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(101672);
                SafeParcelableWrapper safeParcelableWrapper = new SafeParcelableWrapper(parcel);
                AppMethodBeat.o(101672);
                return safeParcelableWrapper;
            }
        };
        private Parcelable bRi;

        SafeParcelableWrapper(Parcelable parcelable) {
            this.bRi = parcelable;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(101673);
            if (this.bRi == null) {
                parcel.writeString(null);
                AppMethodBeat.o(101673);
                return;
            }
            parcel.writeString(this.bRi.getClass().getName());
            parcel.writeParcelable(this.bRi, i);
            AppMethodBeat.o(101673);
        }

        SafeParcelableWrapper(Parcel parcel) {
            AppMethodBeat.i(101674);
            String readString = parcel.readString();
            if (TextUtils.isEmpty(readString)) {
                this.bRi = null;
                AppMethodBeat.o(101674);
                return;
            }
            try {
                this.bRi = parcel.readParcelable(Class.forName(readString).getClassLoader());
                AppMethodBeat.o(101674);
            } catch (ClassNotFoundException e) {
                d.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "ClassNotFoundException with %s", readString);
                AppMethodBeat.o(101674);
            }
        }

        static {
            AppMethodBeat.i(101675);
            AppMethodBeat.o(101675);
        }
    }

    /* synthetic */ OnWXAppResultXPCWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    public static <R extends Parcelable> void a(b<R> bVar, Parcel parcel) {
        AppMethodBeat.i(101676);
        if (bVar == null) {
            parcel.writeString(null);
            AppMethodBeat.o(101676);
            return;
        }
        parcel.writeParcelable(new OnWXAppResultXPCWrapper((b) bVar), 0);
        AppMethodBeat.o(101676);
    }

    public static b<?> b(Parcel parcel) {
        b<?> bVar;
        AppMethodBeat.i(101677);
        OnWXAppResultXPCWrapper onWXAppResultXPCWrapper = (OnWXAppResultXPCWrapper) parcel.readParcelable(OnWXAppResultXPCWrapper.class.getClassLoader());
        if (onWXAppResultXPCWrapper != null) {
            bVar = onWXAppResultXPCWrapper.bRf;
        } else {
            bVar = null;
        }
        AppMethodBeat.o(101677);
        return bVar;
    }

    private OnWXAppResultXPCWrapper(final b<R> bVar) {
        AppMethodBeat.i(101678);
        this.bRf = bVar;
        this.JF = new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* Access modifiers changed, original: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                AppMethodBeat.i(101669);
                if (bundle == null) {
                    bVar.a(null);
                    AppMethodBeat.o(101669);
                    return;
                }
                bundle.setClassLoader(SafeParcelableWrapper.class.getClassLoader());
                try {
                    bVar.a(((SafeParcelableWrapper) bundle.getParcelable("parcel")).bRi);
                    AppMethodBeat.o(101669);
                } catch (ClassCastException | NullPointerException e) {
                    d.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "onReceiveResult, e = %s", e);
                    bVar.a(null);
                    AppMethodBeat.o(101669);
                }
            }
        };
        AppMethodBeat.o(101678);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(101679);
        this.JF.writeToParcel(parcel, i);
        AppMethodBeat.o(101679);
    }

    private OnWXAppResultXPCWrapper(Parcel parcel) {
        AppMethodBeat.i(101680);
        this.JF = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        this.bRf = new b<R>() {
            public final void a(R r) {
                AppMethodBeat.i(101670);
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("parcel", new SafeParcelableWrapper((Parcelable) r));
                OnWXAppResultXPCWrapper.this.JF.send(-1, bundle);
                AppMethodBeat.o(101670);
            }
        };
        AppMethodBeat.o(101680);
    }

    static {
        AppMethodBeat.i(101681);
        AppMethodBeat.o(101681);
    }
}
