package com.facebook;

import android.content.Intent;
import android.support.v4.content.d;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final d localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(d dVar, ProfileCache profileCache) {
        AppMethodBeat.i(71825);
        Validate.notNull(dVar, "localBroadcastManager");
        Validate.notNull(profileCache, "profileCache");
        this.localBroadcastManager = dVar;
        this.profileCache = profileCache;
        AppMethodBeat.o(71825);
    }

    static ProfileManager getInstance() {
        AppMethodBeat.i(71826);
        if (instance == null) {
            synchronized (ProfileManager.class) {
                try {
                    if (instance == null) {
                        instance = new ProfileManager(d.S(FacebookSdk.getApplicationContext()), new ProfileCache());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(71826);
                    }
                }
            }
        }
        ProfileManager profileManager = instance;
        AppMethodBeat.o(71826);
        return profileManager;
    }

    /* Access modifiers changed, original: final */
    public final Profile getCurrentProfile() {
        return this.currentProfile;
    }

    /* Access modifiers changed, original: final */
    public final boolean loadCurrentProfile() {
        AppMethodBeat.i(71827);
        Profile load = this.profileCache.load();
        if (load != null) {
            setCurrentProfile(load, false);
            AppMethodBeat.o(71827);
            return true;
        }
        AppMethodBeat.o(71827);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void setCurrentProfile(Profile profile) {
        AppMethodBeat.i(71828);
        setCurrentProfile(profile, true);
        AppMethodBeat.o(71828);
    }

    private void setCurrentProfile(Profile profile, boolean z) {
        AppMethodBeat.i(71829);
        Profile profile2 = this.currentProfile;
        this.currentProfile = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
        AppMethodBeat.o(71829);
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        AppMethodBeat.i(71830);
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.c(intent);
        AppMethodBeat.o(71830);
    }
}
