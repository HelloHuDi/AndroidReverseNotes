package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppGroupCreationContent implements ShareModel {
    public static final Creator<AppGroupCreationContent> CREATOR = new Creator<AppGroupCreationContent>() {
        public final AppGroupCreationContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97321);
            AppGroupCreationContent appGroupCreationContent = new AppGroupCreationContent(parcel);
            AppMethodBeat.o(97321);
            return appGroupCreationContent;
        }

        public final AppGroupCreationContent[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    };
    private final String description;
    private final String name;
    private AppGroupPrivacy privacy;

    public enum AppGroupPrivacy {
        Open,
        Closed;

        static {
            AppMethodBeat.o(97326);
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
            AppMethodBeat.i(97327);
            AppGroupCreationContent appGroupCreationContent = new AppGroupCreationContent(this, null);
            AppMethodBeat.o(97327);
            return appGroupCreationContent;
        }

        public Builder readFrom(AppGroupCreationContent appGroupCreationContent) {
            AppMethodBeat.i(97328);
            if (appGroupCreationContent == null) {
                AppMethodBeat.o(97328);
                return this;
            }
            this = setName(appGroupCreationContent.getName()).setDescription(appGroupCreationContent.getDescription()).setAppGroupPrivacy(appGroupCreationContent.getAppGroupPrivacy());
            AppMethodBeat.o(97328);
            return this;
        }
    }

    /* synthetic */ AppGroupCreationContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private AppGroupCreationContent(Builder builder) {
        AppMethodBeat.i(97331);
        this.name = builder.name;
        this.description = builder.description;
        this.privacy = builder.privacy;
        AppMethodBeat.o(97331);
    }

    AppGroupCreationContent(Parcel parcel) {
        AppMethodBeat.i(97332);
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.privacy = (AppGroupPrivacy) parcel.readSerializable();
        AppMethodBeat.o(97332);
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
        AppMethodBeat.i(97333);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeSerializable(this.privacy);
        AppMethodBeat.o(97333);
    }

    static {
        AppMethodBeat.i(97334);
        AppMethodBeat.o(97334);
    }
}
