package org.xwalk.core;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

public interface ClientCertRequest {
    void cancel();

    String getHost();

    String[] getKeyTypes();

    int getPort();

    Principal[] getPrincipals();

    void ignore();

    void proceed(PrivateKey privateKey, List<X509Certificate> list);
}
