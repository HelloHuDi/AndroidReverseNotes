package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Creator<ShareOpenGraphAction> CREATOR = new Creator<ShareOpenGraphAction>() {
        public final ShareOpenGraphAction createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97518);
            ShareOpenGraphAction shareOpenGraphAction = new ShareOpenGraphAction(parcel);
            AppMethodBeat.o(97518);
            return shareOpenGraphAction;
        }

        public final ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    };

    public static final class Builder extends com.facebook.share.model.ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        private static final String ACTION_TYPE_KEY = "og:type";

        public final Builder setActionType(String str) {
            AppMethodBeat.i(97521);
            putString(ACTION_TYPE_KEY, str);
            AppMethodBeat.o(97521);
            return this;
        }

        public final ShareOpenGraphAction build() {
            AppMethodBeat.i(97522);
            ShareOpenGraphAction shareOpenGraphAction = new ShareOpenGraphAction(this, null);
            AppMethodBeat.o(97522);
            return shareOpenGraphAction;
        }

        public final Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            AppMethodBeat.i(97523);
            if (shareOpenGraphAction == null) {
                AppMethodBeat.o(97523);
                return this;
            }
            this = ((Builder) super.readFrom((ShareOpenGraphValueContainer) shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
            AppMethodBeat.o(97523);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97524);
            Builder readFrom = readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
            AppMethodBeat.o(97524);
            return readFrom;
        }
    }

    /* synthetic */ ShareOpenGraphAction(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ShareOpenGraphAction(Builder builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.Builder) builder);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    public final String getActionType() {
        AppMethodBeat.i(97528);
        String string = getString("og:type");
        AppMethodBeat.o(97528);
        return string;
    }

    static {
        AppMethodBeat.i(97529);
        AppMethodBeat.o(97529);
    }
}
