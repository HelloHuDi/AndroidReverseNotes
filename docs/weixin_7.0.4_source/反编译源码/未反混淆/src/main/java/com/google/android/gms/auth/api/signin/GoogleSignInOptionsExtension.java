package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public interface GoogleSignInOptionsExtension {
    public static final int FALLBACK_SIGN_IN = 2;
    public static final int FITNESS = 3;
    public static final int GAMES = 1;

    public @interface TypeId {
    }

    @TypeId
    int getExtensionType();

    List<Scope> getImpliedScopes();

    Bundle toBundle();
}
