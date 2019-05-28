package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Creator<ShareOpenGraphObject> CREATOR = new C86311();

    /* renamed from: com.facebook.share.model.ShareOpenGraphObject$1 */
    static class C86311 implements Creator<ShareOpenGraphObject> {
        C86311() {
        }

        public final ShareOpenGraphObject createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97543);
            ShareOpenGraphObject shareOpenGraphObject = new ShareOpenGraphObject(parcel);
            AppMethodBeat.m2505o(97543);
            return shareOpenGraphObject;
        }

        public final ShareOpenGraphObject[] newArray(int i) {
            return new ShareOpenGraphObject[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            AppMethodBeat.m2504i(97546);
            putBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY, true);
            AppMethodBeat.m2505o(97546);
        }

        public final ShareOpenGraphObject build() {
            AppMethodBeat.m2504i(97547);
            ShareOpenGraphObject shareOpenGraphObject = new ShareOpenGraphObject(this, null);
            AppMethodBeat.m2505o(97547);
            return shareOpenGraphObject;
        }

        /* Access modifiers changed, original: final */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.m2504i(97548);
            Builder builder = (Builder) readFrom((ShareOpenGraphValueContainer) (ShareOpenGraphObject) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
            AppMethodBeat.m2505o(97548);
            return builder;
        }
    }

    /* synthetic */ ShareOpenGraphObject(Builder builder, C86311 c86311) {
        this(builder);
    }

    private ShareOpenGraphObject(Builder builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.Builder) builder);
    }

    ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.m2504i(97550);
        AppMethodBeat.m2505o(97550);
    }
}
