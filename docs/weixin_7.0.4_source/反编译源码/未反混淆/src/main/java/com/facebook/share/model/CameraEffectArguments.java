package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectArguments implements ShareModel {
    public static final Creator<CameraEffectArguments> CREATOR = new Creator<CameraEffectArguments>() {
        public final CameraEffectArguments createFromParcel(Parcel parcel) {
            AppMethodBeat.i(97335);
            CameraEffectArguments cameraEffectArguments = new CameraEffectArguments(parcel);
            AppMethodBeat.o(97335);
            return cameraEffectArguments;
        }

        public final CameraEffectArguments[] newArray(int i) {
            return new CameraEffectArguments[i];
        }
    };
    private final Bundle params;

    public static class Builder implements ShareModelBuilder<CameraEffectArguments, Builder> {
        private Bundle params = new Bundle();

        public Builder() {
            AppMethodBeat.i(97338);
            AppMethodBeat.o(97338);
        }

        public Builder putArgument(String str, String str2) {
            AppMethodBeat.i(97339);
            this.params.putString(str, str2);
            AppMethodBeat.o(97339);
            return this;
        }

        public Builder putArgument(String str, String[] strArr) {
            AppMethodBeat.i(97340);
            this.params.putStringArray(str, strArr);
            AppMethodBeat.o(97340);
            return this;
        }

        public Builder readFrom(CameraEffectArguments cameraEffectArguments) {
            AppMethodBeat.i(97341);
            if (cameraEffectArguments != null) {
                this.params.putAll(cameraEffectArguments.params);
            }
            AppMethodBeat.o(97341);
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(97342);
            Builder readFrom = readFrom((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
            AppMethodBeat.o(97342);
            return readFrom;
        }

        public CameraEffectArguments build() {
            AppMethodBeat.i(97343);
            CameraEffectArguments cameraEffectArguments = new CameraEffectArguments(this, null);
            AppMethodBeat.o(97343);
            return cameraEffectArguments;
        }
    }

    /* synthetic */ CameraEffectArguments(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CameraEffectArguments(Builder builder) {
        AppMethodBeat.i(97346);
        this.params = builder.params;
        AppMethodBeat.o(97346);
    }

    CameraEffectArguments(Parcel parcel) {
        AppMethodBeat.i(97347);
        this.params = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(97347);
    }

    public String getString(String str) {
        AppMethodBeat.i(97348);
        String string = this.params.getString(str);
        AppMethodBeat.o(97348);
        return string;
    }

    public String[] getStringArray(String str) {
        AppMethodBeat.i(97349);
        String[] stringArray = this.params.getStringArray(str);
        AppMethodBeat.o(97349);
        return stringArray;
    }

    public Object get(String str) {
        AppMethodBeat.i(97350);
        Object obj = this.params.get(str);
        AppMethodBeat.o(97350);
        return obj;
    }

    public Set<String> keySet() {
        AppMethodBeat.i(97351);
        Set keySet = this.params.keySet();
        AppMethodBeat.o(97351);
        return keySet;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(97352);
        parcel.writeBundle(this.params);
        AppMethodBeat.o(97352);
    }

    static {
        AppMethodBeat.i(97353);
        AppMethodBeat.o(97353);
    }
}
