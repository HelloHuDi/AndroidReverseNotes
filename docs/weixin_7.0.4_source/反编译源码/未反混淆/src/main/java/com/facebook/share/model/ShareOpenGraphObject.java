package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Creator<ShareOpenGraphObject> CREATOR = new Creator<ShareOpenGraphObject>() {
        public final ShareOpenGraphObject createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97543);
            ShareOpenGraphObject shareOpenGraphObject = new ShareOpenGraphObject(parcel);
            AppMethodBeat.o(97543);
            return shareOpenGraphObject;
        }

        public final ShareOpenGraphObject[] newArray(int i) {
            return new ShareOpenGraphObject[i];
        }
    };

    public static final class Builder extends com.facebook.share.model.ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            AppMethodBeat.i(97546);
            putBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY, true);
            AppMethodBeat.o(97546);
        }

        public final ShareOpenGraphObject build() {
            AppMethodBeat.i(97547);
            ShareOpenGraphObject shareOpenGraphObject = new ShareOpenGraphObject(this, null);
            AppMethodBeat.o(97547);
            return shareOpenGraphObject;
        }

        /* Access modifiers changed, original: final */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97548);
            Builder builder = (Builder) readFrom((ShareOpenGraphValueContainer) (ShareOpenGraphObject) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
            AppMethodBeat.o(97548);
            return builder;
        }
    }

    /* synthetic */ ShareOpenGraphObject(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareOpenGraphObject(Builder builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.Builder) builder);
    }

    ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(97550);
        AppMethodBeat.o(97550);
    }
}
