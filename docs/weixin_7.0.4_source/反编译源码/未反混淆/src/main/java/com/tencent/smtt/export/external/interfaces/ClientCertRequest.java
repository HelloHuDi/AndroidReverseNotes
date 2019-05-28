package com.tencent.smtt.export.external.interfaces;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public abstract class ClientCertRequest {
    public abstract void cancel();

    public abstract String getHost();

    public abstract String[] getKeyTypes();

    public abstract int getPort();

    public abstract Principal[] getPrincipals();

    public abstract void ignore();

    public abstract void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr);
}
