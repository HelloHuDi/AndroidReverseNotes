package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class Storage {
    private static final Lock zzaf = new ReentrantLock();
    @GuardedBy("sLk")
    private static Storage zzag;
    private final Lock zzah = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences zzai;

    static {
        AppMethodBeat.m2504i(60406);
        AppMethodBeat.m2505o(60406);
    }

    @VisibleForTesting
    private Storage(Context context) {
        AppMethodBeat.m2504i(60392);
        this.zzai = context.getSharedPreferences("com.google.android.gms.signin", 0);
        AppMethodBeat.m2505o(60392);
    }

    public static Storage getInstance(Context context) {
        AppMethodBeat.m2504i(60391);
        Preconditions.checkNotNull(context);
        zzaf.lock();
        try {
            if (zzag == null) {
                zzag = new Storage(context.getApplicationContext());
            }
            Storage storage = zzag;
            return storage;
        } finally {
            zzaf.unlock();
            AppMethodBeat.m2505o(60391);
        }
    }

    @VisibleForTesting
    public static void setInstance(@Nullable Storage storage) {
        AppMethodBeat.m2504i(60390);
        zzaf.lock();
        try {
            zzag = storage;
        } finally {
            zzaf.unlock();
            AppMethodBeat.m2505o(60390);
        }
    }

    private static String zza(String str, String str2) {
        AppMethodBeat.m2504i(60405);
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2).toString();
        AppMethodBeat.m2505o(60405);
        return stringBuilder;
    }

    @Nullable
    @VisibleForTesting
    private final GoogleSignInAccount zzb(String str) {
        AppMethodBeat.m2504i(60397);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(60397);
            return null;
        }
        String fromStore = getFromStore(zza("googleSignInAccount", str));
        if (fromStore != null) {
            try {
                GoogleSignInAccount fromJsonString = GoogleSignInAccount.fromJsonString(fromStore);
                AppMethodBeat.m2505o(60397);
                return fromJsonString;
            } catch (JSONException e) {
                AppMethodBeat.m2505o(60397);
                return null;
            }
        }
        AppMethodBeat.m2505o(60397);
        return null;
    }

    @Nullable
    @VisibleForTesting
    private final GoogleSignInOptions zzc(String str) {
        AppMethodBeat.m2504i(60399);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(60399);
            return null;
        }
        String fromStore = getFromStore(zza("googleSignInOptions", str));
        if (fromStore != null) {
            try {
                GoogleSignInOptions fromJsonString = GoogleSignInOptions.fromJsonString(fromStore);
                AppMethodBeat.m2505o(60399);
                return fromJsonString;
            } catch (JSONException e) {
                AppMethodBeat.m2505o(60399);
                return null;
            }
        }
        AppMethodBeat.m2505o(60399);
        return null;
    }

    public void clear() {
        AppMethodBeat.m2504i(60404);
        this.zzah.lock();
        try {
            this.zzai.edit().clear().apply();
        } finally {
            this.zzah.unlock();
            AppMethodBeat.m2505o(60404);
        }
    }

    /* Access modifiers changed, original: protected */
    @Nullable
    public String getFromStore(String str) {
        AppMethodBeat.m2504i(60401);
        this.zzah.lock();
        try {
            String string = this.zzai.getString(str, null);
            return string;
        } finally {
            this.zzah.unlock();
            AppMethodBeat.m2505o(60401);
        }
    }

    @Nullable
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        AppMethodBeat.m2504i(60396);
        GoogleSignInAccount zzb = zzb(getFromStore("defaultGoogleSignInAccount"));
        AppMethodBeat.m2505o(60396);
        return zzb;
    }

    @Nullable
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        AppMethodBeat.m2504i(60398);
        GoogleSignInOptions zzc = zzc(getFromStore("defaultGoogleSignInAccount"));
        AppMethodBeat.m2505o(60398);
        return zzc;
    }

    @Nullable
    public String getSavedRefreshToken() {
        AppMethodBeat.m2504i(60400);
        String fromStore = getFromStore("refreshToken");
        AppMethodBeat.m2505o(60400);
        return fromStore;
    }

    /* Access modifiers changed, original: protected */
    public void removeFromStore(String str) {
        AppMethodBeat.m2504i(60403);
        this.zzah.lock();
        try {
            this.zzai.edit().remove(str).apply();
        } finally {
            this.zzah.unlock();
            AppMethodBeat.m2505o(60403);
        }
    }

    public void removeSavedDefaultGoogleSignInAccount() {
        AppMethodBeat.m2504i(60402);
        String fromStore = getFromStore("defaultGoogleSignInAccount");
        removeFromStore("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(fromStore)) {
            removeFromStore(zza("googleSignInAccount", fromStore));
            removeFromStore(zza("googleSignInOptions", fromStore));
        }
        AppMethodBeat.m2505o(60402);
    }

    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.m2504i(60393);
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        saveToStore("defaultGoogleSignInAccount", googleSignInAccount.getObfuscatedIdentifier());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String obfuscatedIdentifier = googleSignInAccount.getObfuscatedIdentifier();
        saveToStore(zza("googleSignInAccount", obfuscatedIdentifier), googleSignInAccount.toJsonForStorage());
        saveToStore(zza("googleSignInOptions", obfuscatedIdentifier), googleSignInOptions.toJson());
        AppMethodBeat.m2505o(60393);
    }

    public void saveRefreshToken(String str) {
        AppMethodBeat.m2504i(60394);
        if (!TextUtils.isEmpty(str)) {
            saveToStore("refreshToken", str);
        }
        AppMethodBeat.m2505o(60394);
    }

    /* Access modifiers changed, original: protected */
    public void saveToStore(String str, String str2) {
        AppMethodBeat.m2504i(60395);
        this.zzah.lock();
        try {
            this.zzai.edit().putString(str, str2).apply();
        } finally {
            this.zzah.unlock();
            AppMethodBeat.m2505o(60395);
        }
    }
}
