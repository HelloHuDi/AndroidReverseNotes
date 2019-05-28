package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.firebase.iid.a */
public final class C32094a {
    /* renamed from: uN */
    public static KeyPair m52220uN() {
        AppMethodBeat.m2504i(108713);
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(2048);
            KeyPair generateKeyPair = instance.generateKeyPair();
            AppMethodBeat.m2505o(108713);
            return generateKeyPair;
        } catch (NoSuchAlgorithmException e) {
            AssertionError assertionError = new AssertionError(e);
            AppMethodBeat.m2505o(108713);
            throw assertionError;
        }
    }
}
