package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.Validate;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class ProfileCache {
    static final String CACHED_PROFILE_KEY = "com.facebook.ProfileManager.CachedProfile";
    static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    private final SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    ProfileCache() {
        AppMethodBeat.i(71821);
        AppMethodBeat.o(71821);
    }

    /* Access modifiers changed, original: final */
    public final Profile load() {
        AppMethodBeat.i(71822);
        String string = this.sharedPreferences.getString(CACHED_PROFILE_KEY, null);
        if (string != null) {
            try {
                Profile profile = new Profile(new JSONObject(string));
                AppMethodBeat.o(71822);
                return profile;
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.o(71822);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void save(Profile profile) {
        AppMethodBeat.i(71823);
        Validate.notNull(profile, Scopes.PROFILE);
        JSONObject toJSONObject = profile.toJSONObject();
        if (toJSONObject != null) {
            this.sharedPreferences.edit().putString(CACHED_PROFILE_KEY, toJSONObject.toString()).apply();
        }
        AppMethodBeat.o(71823);
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.i(71824);
        this.sharedPreferences.edit().remove(CACHED_PROFILE_KEY).apply();
        AppMethodBeat.o(71824);
    }
}
