package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class a {
    public static KeyPair uN() {
        AppMethodBeat.i(108713);
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(2048);
            KeyPair generateKeyPair = instance.generateKeyPair();
            AppMethodBeat.o(108713);
            return generateKeyPair;
        } catch (NoSuchAlgorithmException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.o(108713);
            throw assertionError;
        }
    }
}
