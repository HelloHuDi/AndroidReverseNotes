package com.facebook;

import android.content.Intent;
import android.support.p057v4.content.C37116d;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final C37116d localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(C37116d c37116d, ProfileCache profileCache) {
        AppMethodBeat.m2504i(71825);
        Validate.notNull(c37116d, "localBroadcastManager");
        Validate.notNull(profileCache, "profileCache");
        this.localBroadcastManager = c37116d;
        this.profileCache = profileCache;
        AppMethodBeat.m2505o(71825);
    }

    static ProfileManager getInstance() {
        AppMethodBeat.m2504i(71826);
        if (instance == null) {
            synchronized (ProfileManager.class) {
                try {
                    if (instance == null) {
                        instance = new ProfileManager(C37116d.m62125S(FacebookSdk.getApplicationContext()), new ProfileCache());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(71826);
                    }
                }
            }
        }
        ProfileManager profileManager = instance;
        AppMethodBeat.m2505o(71826);
        return profileManager;
    }

    /* Access modifiers changed, original: final */
    public final Profile getCurrentProfile() {
        return this.currentProfile;
    }

    /* Access modifiers changed, original: final */
    public final boolean loadCurrentProfile() {
        AppMethodBeat.m2504i(71827);
        Profile load = this.profileCache.load();
        if (load != null) {
            setCurrentProfile(load, false);
            AppMethodBeat.m2505o(71827);
            return true;
        }
        AppMethodBeat.m2505o(71827);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void setCurrentProfile(Profile profile) {
        AppMethodBeat.m2504i(71828);
        setCurrentProfile(profile, true);
        AppMethodBeat.m2505o(71828);
    }

    private void setCurrentProfile(Profile profile, boolean z) {
        AppMethodBeat.m2504i(71829);
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
        AppMethodBeat.m2505o(71829);
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        AppMethodBeat.m2504i(71830);
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.mo59172c(intent);
        AppMethodBeat.m2505o(71830);
    }
}
