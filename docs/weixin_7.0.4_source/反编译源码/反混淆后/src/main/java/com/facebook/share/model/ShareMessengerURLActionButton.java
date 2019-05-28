package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Creator<ShareMessengerURLActionButton> CREATOR = new C86301();
    private final Uri fallbackUrl;
    private final boolean isMessengerExtensionURL;
    private final boolean shouldHideWebviewShareButton;
    private final Uri url;
    private final WebviewHeightRatio webviewHeightRatio;

    /* renamed from: com.facebook.share.model.ShareMessengerURLActionButton$1 */
    static class C86301 implements Creator<ShareMessengerURLActionButton> {
        C86301() {
        }

        public final ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97504);
            ShareMessengerURLActionButton shareMessengerURLActionButton = new ShareMessengerURLActionButton(parcel);
            AppMethodBeat.m2505o(97504);
            return shareMessengerURLActionButton;
        }

        public final ShareMessengerURLActionButton[] newArray(int i) {
            return new ShareMessengerURLActionButton[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareMessengerActionButton.Builder<ShareMessengerURLActionButton, Builder> {
        private Uri fallbackUrl;
        private boolean isMessengerExtensionURL;
        private boolean shouldHideWebviewShareButton;
        private Uri url;
        private WebviewHeightRatio webviewHeightRatio;

        public final Builder setUrl(Uri uri) {
            this.url = uri;
            return this;
        }

        public final Builder setIsMessengerExtensionURL(boolean z) {
            this.isMessengerExtensionURL = z;
            return this;
        }

        public final Builder setFallbackUrl(Uri uri) {
            this.fallbackUrl = uri;
            return this;
        }

        public final Builder setWebviewHeightRatio(WebviewHeightRatio webviewHeightRatio) {
            this.webviewHeightRatio = webviewHeightRatio;
            return this;
        }

        public final Builder setShouldHideWebviewShareButton(boolean z) {
            this.shouldHideWebviewShareButton = z;
            return this;
        }

        public final Builder readFrom(ShareMessengerURLActionButton shareMessengerURLActionButton) {
            AppMethodBeat.m2504i(97507);
            if (shareMessengerURLActionButton == null) {
                AppMethodBeat.m2505o(97507);
                return this;
            }
            this = setUrl(shareMessengerURLActionButton.getUrl()).setIsMessengerExtensionURL(shareMessengerURLActionButton.getIsMessengerExtensionURL()).setFallbackUrl(shareMessengerURLActionButton.getFallbackUrl()).setWebviewHeightRatio(shareMessengerURLActionButton.getWebviewHeightRatio()).setShouldHideWebviewShareButton(shareMessengerURLActionButton.getShouldHideWebviewShareButton());
            AppMethodBeat.m2505o(97507);
            return this;
        }

        public final ShareMessengerURLActionButton build() {
            AppMethodBeat.m2504i(97508);
            ShareMessengerURLActionButton shareMessengerURLActionButton = new ShareMessengerURLActionButton(this, null);
            AppMethodBeat.m2505o(97508);
            return shareMessengerURLActionButton;
        }
    }

    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact;

        static {
            AppMethodBeat.m2505o(97514);
        }
    }

    /* synthetic */ ShareMessengerURLActionButton(Builder builder, C86301 c86301) {
        this(builder);
    }

    private ShareMessengerURLActionButton(Builder builder) {
        super((com.facebook.share.model.ShareMessengerActionButton.Builder) builder);
        AppMethodBeat.m2504i(97515);
        this.url = builder.url;
        this.isMessengerExtensionURL = builder.isMessengerExtensionURL;
        this.fallbackUrl = builder.fallbackUrl;
        this.webviewHeightRatio = builder.webviewHeightRatio;
        this.shouldHideWebviewShareButton = builder.shouldHideWebviewShareButton;
        AppMethodBeat.m2505o(97515);
    }

    ShareMessengerURLActionButton(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(parcel);
        AppMethodBeat.m2504i(97516);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.isMessengerExtensionURL = z;
        this.fallbackUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.webviewHeightRatio = (WebviewHeightRatio) parcel.readSerializable();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.shouldHideWebviewShareButton = z2;
        AppMethodBeat.m2505o(97516);
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final boolean getIsMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    public final Uri getFallbackUrl() {
        return this.fallbackUrl;
    }

    public final WebviewHeightRatio getWebviewHeightRatio() {
        return this.webviewHeightRatio;
    }

    public final boolean getShouldHideWebviewShareButton() {
        return this.shouldHideWebviewShareButton;
    }

    static {
        AppMethodBeat.m2504i(97517);
        AppMethodBeat.m2505o(97517);
    }
}
