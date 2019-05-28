package com.tencent.smtt.export.external.interfaces;

import android.net.http.SslCertificate;

public interface SslError {
    boolean addError(int i);

    SslCertificate getCertificate();

    int getPrimaryError();

    boolean hasError(int i);
}
