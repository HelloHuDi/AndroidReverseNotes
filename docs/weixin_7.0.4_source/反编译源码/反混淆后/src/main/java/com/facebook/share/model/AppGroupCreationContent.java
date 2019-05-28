package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppGroupCreationContent implements ShareModel {
    public static final Creator<AppGroupCreationContent> CREATOR = new C86291();
    private final String description;
    private final String name;
    private AppGroupPrivacy privacy;

    public enum AppGroupPrivacy {
        Open,
        Closed;

        static {
            AppMethodBeat.m2505o(97326);
        }
    }

    /* renamed from: com.facebook.share.model.AppGroupCreationContent$1 */
    static class C86291 implements Creator<AppGroupCreationContent> {
        C86291() {
        }

        public final AppGroupCreationContent createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97321);
            AppGroupCreationContent appGroupCreationContent = new AppGroupCreationContent(parcel);
            AppMethodBeat.m2505o(97321);
            return appGroupCreationContent;
        }

        public final AppGroupCreationContent[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    }

    public static class Builder implements ShareModelBuilder<AppGroupCreationContent, Builder> {
        private String description;
        private String name;
        private AppGroupPrivacy privacy;

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder setAppGroupPrivacy(AppGroupPrivacy appGroupPrivacy) {
            this.privacy = appGroupPrivacy;
            return this;
        }

        public AppGroupCreationContent build() {
            AppMethodBeat.m2504i(97327);
            AppGroupCreationContent appGroupCreationContent = new AppGroupCreationContent(this, null);
            AppMethodBeat.m2505o(97327);
            return appGroupCreationContent;
        }

        public Builder readFrom(AppGroupCreationContent appGroupCreationContent) {
            AppMethodBeat.m2504i(97328);
            if (appGroupCreationContent == null) {
                AppMethodBeat.m2505o(97328);
                return this;
            }
            this = setName(appGroupCreationContent.getName()).setDescription(appGroupCreationContent.getDescription()).setAppGroupPrivacy(appGroupCreationContent.getAppGroupPrivacy());
            AppMethodBeat.m2505o(97328);
            return this;
        }
    }

    /* synthetic */ AppGroupCreationContent(Builder builder, C86291 c86291) {
        this(builder);
    }

    private AppGroupCreationContent(Builder builder) {
        AppMethodBeat.m2504i(97331);
        this.name = builder.name;
        this.description = builder.description;
        this.privacy = builder.privacy;
        AppMethodBeat.m2505o(97331);
    }

    AppGroupCreationContent(Parcel parcel) {
        AppMethodBeat.m2504i(97332);
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.privacy = (AppGroupPrivacy) parcel.readSerializable();
        AppMethodBeat.m2505o(97332);
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final AppGroupPrivacy getAppGroupPrivacy() {
        return this.privacy;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97333);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeSerializable(this.privacy);
        AppMethodBeat.m2505o(97333);
    }

    static {
        AppMethodBeat.m2504i(97334);
        AppMethodBeat.m2505o(97334);
    }
}
