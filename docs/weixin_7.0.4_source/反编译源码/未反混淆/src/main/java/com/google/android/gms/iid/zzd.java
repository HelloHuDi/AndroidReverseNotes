package com.google.android.gms.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class zzd {
    public static KeyPair zzk() {
        AppMethodBeat.i(57562);
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(2048);
            KeyPair generateKeyPair = instance.generateKeyPair();
            AppMethodBeat.o(57562);
            return generateKeyPair;
        } catch (NoSuchAlgorithmException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.o(57562);
            throw assertionError;
        }
    }
}
