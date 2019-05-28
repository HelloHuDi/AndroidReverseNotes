package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        public final Profile createFromParcel(Parcel parcel) {
            AppMethodBeat.i(71806);
            Profile profile = new Profile(parcel, null);
            AppMethodBeat.o(71806);
            return profile;
        }

        public final Profile[] newArray(int i) {
            return new Profile[i];
        }
    };
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    private static final String TAG = Profile.class.getSimpleName();
    private final String firstName;
    private final String id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;

    /* synthetic */ Profile(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(71820);
        AppMethodBeat.o(71820);
    }

    public static Profile getCurrentProfile() {
        AppMethodBeat.i(71809);
        Profile currentProfile = ProfileManager.getInstance().getCurrentProfile();
        AppMethodBeat.o(71809);
        return currentProfile;
    }

    public static void setCurrentProfile(Profile profile) {
        AppMethodBeat.i(71810);
        ProfileManager.getInstance().setCurrentProfile(profile);
        AppMethodBeat.o(71810);
    }

    public static void fetchProfileForCurrentAccessToken() {
        AppMethodBeat.i(71811);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (AccessToken.isCurrentAccessTokenActive()) {
            Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new GraphMeRequestWithCacheCallback() {
                public final void onSuccess(JSONObject jSONObject) {
                    AppMethodBeat.i(71804);
                    String optString = jSONObject.optString("id");
                    if (optString == null) {
                        AppMethodBeat.o(71804);
                        return;
                    }
                    String optString2 = jSONObject.optString("link");
                    Profile.setCurrentProfile(new Profile(optString, jSONObject.optString(Profile.FIRST_NAME_KEY), jSONObject.optString(Profile.MIDDLE_NAME_KEY), jSONObject.optString(Profile.LAST_NAME_KEY), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
                    AppMethodBeat.o(71804);
                }

                public final void onFailure(FacebookException facebookException) {
                    AppMethodBeat.i(71805);
                    Profile.TAG;
                    new StringBuilder("Got unexpected exception: ").append(facebookException);
                    AppMethodBeat.o(71805);
                }
            });
            AppMethodBeat.o(71811);
            return;
        }
        setCurrentProfile(null);
        AppMethodBeat.o(71811);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        AppMethodBeat.i(71812);
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        AppMethodBeat.o(71812);
    }

    public final Uri getProfilePictureUri(int i, int i2) {
        AppMethodBeat.i(71813);
        Uri profilePictureUri = ImageRequest.getProfilePictureUri(this.id, i, i2);
        AppMethodBeat.o(71813);
        return profilePictureUri;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(71814);
        if (this == obj) {
            AppMethodBeat.o(71814);
            return true;
        } else if (obj instanceof Profile) {
            Profile profile = (Profile) obj;
            if (this.id.equals(profile.id) && this.firstName == null) {
                if (profile.firstName == null) {
                    AppMethodBeat.o(71814);
                    return true;
                }
                AppMethodBeat.o(71814);
                return false;
            } else if (this.firstName.equals(profile.firstName) && this.middleName == null) {
                if (profile.middleName == null) {
                    AppMethodBeat.o(71814);
                    return true;
                }
                AppMethodBeat.o(71814);
                return false;
            } else if (this.middleName.equals(profile.middleName) && this.lastName == null) {
                if (profile.lastName == null) {
                    AppMethodBeat.o(71814);
                    return true;
                }
                AppMethodBeat.o(71814);
                return false;
            } else if (this.lastName.equals(profile.lastName) && this.name == null) {
                if (profile.name == null) {
                    AppMethodBeat.o(71814);
                    return true;
                }
                AppMethodBeat.o(71814);
                return false;
            } else if (!this.name.equals(profile.name) || this.linkUri != null) {
                boolean equals = this.linkUri.equals(profile.linkUri);
                AppMethodBeat.o(71814);
                return equals;
            } else if (profile.linkUri == null) {
                AppMethodBeat.o(71814);
                return true;
            } else {
                AppMethodBeat.o(71814);
                return false;
            }
        } else {
            AppMethodBeat.o(71814);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(71815);
        int hashCode = this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX;
        if (this.firstName != null) {
            hashCode = (hashCode * 31) + this.firstName.hashCode();
        }
        if (this.middleName != null) {
            hashCode = (hashCode * 31) + this.middleName.hashCode();
        }
        if (this.lastName != null) {
            hashCode = (hashCode * 31) + this.lastName.hashCode();
        }
        if (this.name != null) {
            hashCode = (hashCode * 31) + this.name.hashCode();
        }
        if (this.linkUri != null) {
            hashCode = (hashCode * 31) + this.linkUri.hashCode();
        }
        AppMethodBeat.o(71815);
        return hashCode;
    }

    /* Access modifiers changed, original: final */
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(71816);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put(FIRST_NAME_KEY, this.firstName);
            jSONObject.put(MIDDLE_NAME_KEY, this.middleName);
            jSONObject.put(LAST_NAME_KEY, this.lastName);
            jSONObject.put("name", this.name);
            if (this.linkUri != null) {
                jSONObject.put(LINK_URI_KEY, this.linkUri.toString());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        AppMethodBeat.o(71816);
        return jSONObject;
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        AppMethodBeat.i(71817);
        this.id = jSONObject.optString("id", null);
        this.firstName = jSONObject.optString(FIRST_NAME_KEY, null);
        this.middleName = jSONObject.optString(MIDDLE_NAME_KEY, null);
        this.lastName = jSONObject.optString(LAST_NAME_KEY, null);
        this.name = jSONObject.optString("name", null);
        String optString = jSONObject.optString(LINK_URI_KEY, null);
        if (optString != null) {
            uri = Uri.parse(optString);
        }
        this.linkUri = uri;
        AppMethodBeat.o(71817);
    }

    private Profile(Parcel parcel) {
        AppMethodBeat.i(71818);
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        this.linkUri = readString == null ? null : Uri.parse(readString);
        AppMethodBeat.o(71818);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71819);
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        parcel.writeString(this.linkUri == null ? null : this.linkUri.toString());
        AppMethodBeat.o(71819);
    }
}
