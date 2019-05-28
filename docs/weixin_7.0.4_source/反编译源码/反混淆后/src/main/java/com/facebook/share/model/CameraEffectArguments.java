package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectArguments implements ShareModel {
    public static final Creator<CameraEffectArguments> CREATOR = new C176191();
    private final Bundle params;

    /* renamed from: com.facebook.share.model.CameraEffectArguments$1 */
    static class C176191 implements Creator<CameraEffectArguments> {
        C176191() {
        }

        public final CameraEffectArguments createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(97335);
            CameraEffectArguments cameraEffectArguments = new CameraEffectArguments(parcel);
            AppMethodBeat.m2505o(97335);
            return cameraEffectArguments;
        }

        public final CameraEffectArguments[] newArray(int i) {
            return new CameraEffectArguments[i];
        }
    }

    public static class Builder implements ShareModelBuilder<CameraEffectArguments, Builder> {
        private Bundle params = new Bundle();

        public Builder() {
            AppMethodBeat.m2504i(97338);
            AppMethodBeat.m2505o(97338);
        }

        public Builder putArgument(String str, String str2) {
            AppMethodBeat.m2504i(97339);
            this.params.putString(str, str2);
            AppMethodBeat.m2505o(97339);
            return this;
        }

        public Builder putArgument(String str, String[] strArr) {
            AppMethodBeat.m2504i(97340);
            this.params.putStringArray(str, strArr);
            AppMethodBeat.m2505o(97340);
            return this;
        }

        public Builder readFrom(CameraEffectArguments cameraEffectArguments) {
            AppMethodBeat.m2504i(97341);
            if (cameraEffectArguments != null) {
                this.params.putAll(cameraEffectArguments.params);
            }
            AppMethodBeat.m2505o(97341);
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.m2504i(97342);
            Builder readFrom = readFrom((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
            AppMethodBeat.m2505o(97342);
            return readFrom;
        }

        public CameraEffectArguments build() {
            AppMethodBeat.m2504i(97343);
            CameraEffectArguments cameraEffectArguments = new CameraEffectArguments(this, null);
            AppMethodBeat.m2505o(97343);
            return cameraEffectArguments;
        }
    }

    /* synthetic */ CameraEffectArguments(Builder builder, C176191 c176191) {
        this(builder);
    }

    private CameraEffectArguments(Builder builder) {
        AppMethodBeat.m2504i(97346);
        this.params = builder.params;
        AppMethodBeat.m2505o(97346);
    }

    CameraEffectArguments(Parcel parcel) {
        AppMethodBeat.m2504i(97347);
        this.params = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.m2505o(97347);
    }

    public String getString(String str) {
        AppMethodBeat.m2504i(97348);
        String string = this.params.getString(str);
        AppMethodBeat.m2505o(97348);
        return string;
    }

    public String[] getStringArray(String str) {
        AppMethodBeat.m2504i(97349);
        String[] stringArray = this.params.getStringArray(str);
        AppMethodBeat.m2505o(97349);
        return stringArray;
    }

    public Object get(String str) {
        AppMethodBeat.m2504i(97350);
        Object obj = this.params.get(str);
        AppMethodBeat.m2505o(97350);
        return obj;
    }

    public Set<String> keySet() {
        AppMethodBeat.m2504i(97351);
        Set keySet = this.params.keySet();
        AppMethodBeat.m2505o(97351);
        return keySet;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(97352);
        parcel.writeBundle(this.params);
        AppMethodBeat.m2505o(97352);
    }

    static {
        AppMethodBeat.m2504i(97353);
        AppMethodBeat.m2505o(97353);
    }
}
