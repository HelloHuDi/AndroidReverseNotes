package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Creator<ShareOpenGraphAction> CREATOR = new C320121();

    public static final class Builder extends com.facebook.share.model.ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        private static final String ACTION_TYPE_KEY = "og:type";

        public final Builder setActionType(String str) {
            AppMethodBeat.m2504i(97521);
            putString(ACTION_TYPE_KEY, str);
            AppMethodBeat.m2505o(97521);
            return this;
        }

        public final ShareOpenGraphAction build() {
            AppMethodBeat.m2504i(97522);
            ShareOpenGraphAction shareOpenGraphAction = new ShareOpenGraphAction(this, null);
            AppMethodBeat.m2505o(97522);
            return shareOpenGraphAction;
        }

        public final Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            AppMethodBeat.m2504i(97523);
            if (shareOpenGraphAction == null) {
                AppMethodBeat.m2505o(97523);
                return this;
            }
            this = ((Builder) super.readFrom((ShareOpenGraphValueContainer) shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
            AppMethodBeat.m2505o(97523);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.m2504i(97524);
            Builder readFrom = readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
            AppMethodBeat.m2505o(97524);
            return readFrom;
        }
    }

    /* renamed from: com.facebook.share.model.ShareOpenGraphAction$1 */
    static class C320121 implements Creator<ShareOpenGraphAction> {
        C320121() {
        }

        public final ShareOpenGraphAction createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97518);
            ShareOpenGraphAction shareOpenGraphAction = new ShareOpenGraphAction(parcel);
            AppMethodBeat.m2505o(97518);
            return shareOpenGraphAction;
        }

        public final ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    }

    /* synthetic */ ShareOpenGraphAction(Builder builder, C320121 c320121) {
        this(builder);
    }

    private ShareOpenGraphAction(Builder builder) {
        super((com.facebook.share.model.ShareOpenGraphValueContainer.Builder) builder);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    public final String getActionType() {
        AppMethodBeat.m2504i(97528);
        String string = getString("og:type");
        AppMethodBeat.m2505o(97528);
        return string;
    }

    static {
        AppMethodBeat.m2504i(97529);
        AppMethodBeat.m2505o(97529);
    }
}
