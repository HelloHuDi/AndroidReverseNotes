package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Class(creator = "CredentialPickerConfigCreator")
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzf();
    @Field(getter = "shouldShowCancelButton", id = 2)
    private final boolean mShowCancelButton;
    @Field(getter = "shouldShowAddAccountButton", id = 1)
    private final boolean zzcq;
    @Field(getter = "isForNewAccount", id = 3)
    @Deprecated
    private final boolean zzcr;
    @Field(getter = "getPromptInternalId", id = 4)
    private final int zzcs;
    @Field(id = 1000)
    private final int zzy;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    public static class Builder {
        private boolean mShowCancelButton = true;
        private boolean zzcq = false;
        private int zzct = 1;

        public CredentialPickerConfig build() {
            AppMethodBeat.m2504i(50315);
            CredentialPickerConfig credentialPickerConfig = new CredentialPickerConfig(this, null);
            AppMethodBeat.m2505o(50315);
            return credentialPickerConfig;
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.zzct = z ? 3 : 1;
            return this;
        }

        public Builder setPrompt(int i) {
            this.zzct = i;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzcq = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    static {
        AppMethodBeat.m2504i(50319);
        AppMethodBeat.m2505o(50319);
    }

    @Constructor
    CredentialPickerConfig(@Param(id = 1000) int i, @Param(id = 1) boolean z, @Param(id = 2) boolean z2, @Param(id = 3) boolean z3, @Param(id = 4) int i2) {
        int i3 = 3;
        boolean z4 = true;
        AppMethodBeat.m2504i(50316);
        this.zzy = i;
        this.zzcq = z;
        this.mShowCancelButton = z2;
        if (i < 2) {
            this.zzcr = z3;
            if (!z3) {
                i3 = 1;
            }
            this.zzcs = i3;
            AppMethodBeat.m2505o(50316);
            return;
        }
        if (i2 != 3) {
            z4 = false;
        }
        this.zzcr = z4;
        this.zzcs = i2;
        AppMethodBeat.m2505o(50316);
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.zzcq, builder.mShowCancelButton, false, builder.zzct);
        AppMethodBeat.m2504i(50317);
        AppMethodBeat.m2505o(50317);
    }

    /* synthetic */ CredentialPickerConfig(Builder builder, zze zze) {
        this(builder);
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.zzcs == 3;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzcq;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(50318);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, shouldShowAddAccountButton());
        SafeParcelWriter.writeBoolean(parcel, 2, shouldShowCancelButton());
        SafeParcelWriter.writeBoolean(parcel, 3, isForNewAccount());
        SafeParcelWriter.writeInt(parcel, 4, this.zzcs);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(50318);
    }
}
