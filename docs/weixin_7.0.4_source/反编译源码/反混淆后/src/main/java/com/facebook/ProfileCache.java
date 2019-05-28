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
        AppMethodBeat.m2504i(71821);
        AppMethodBeat.m2505o(71821);
    }

    /* Access modifiers changed, original: final */
    public final Profile load() {
        AppMethodBeat.m2504i(71822);
        String string = this.sharedPreferences.getString(CACHED_PROFILE_KEY, null);
        if (string != null) {
            try {
                Profile profile = new Profile(new JSONObject(string));
                AppMethodBeat.m2505o(71822);
                return profile;
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(71822);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void save(Profile profile) {
        AppMethodBeat.m2504i(71823);
        Validate.notNull(profile, Scopes.PROFILE);
        JSONObject toJSONObject = profile.toJSONObject();
        if (toJSONObject != null) {
            this.sharedPreferences.edit().putString(CACHED_PROFILE_KEY, toJSONObject.toString()).apply();
        }
        AppMethodBeat.m2505o(71823);
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.m2504i(71824);
        this.sharedPreferences.edit().remove(CACHED_PROFILE_KEY).apply();
        AppMethodBeat.m2505o(71824);
    }
}
