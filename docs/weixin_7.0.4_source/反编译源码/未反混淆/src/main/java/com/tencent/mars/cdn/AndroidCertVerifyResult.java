package com.tencent.mars.cdn;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidCertVerifyResult {
    private final List<X509Certificate> mCertificateChain;
    private final boolean mIsIssuedByHostMatched;
    private final boolean mIsIssuedByKnownRoot;
    private final int mStatus;

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list) {
        this.mStatus = i;
        this.mIsIssuedByKnownRoot = z;
        this.mCertificateChain = new ArrayList(list);
        this.mIsIssuedByHostMatched = false;
    }

    public AndroidCertVerifyResult(int i, boolean z, List<X509Certificate> list, boolean z2) {
        this.mStatus = i;
        this.mIsIssuedByKnownRoot = z;
        this.mCertificateChain = new ArrayList(list);
        this.mIsIssuedByHostMatched = z2;
    }

    public AndroidCertVerifyResult(int i) {
        this.mStatus = i;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
        this.mIsIssuedByHostMatched = false;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isIssuedByKnownRoot() {
        return this.mIsIssuedByKnownRoot;
    }

    public boolean isIssuedByHostMatched() {
        return this.mIsIssuedByHostMatched;
    }

    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.mCertificateChain.size()][];
        int i = 0;
        while (i < this.mCertificateChain.size()) {
            try {
                bArr[i] = ((X509Certificate) this.mCertificateChain.get(i)).getEncoded();
                i++;
            } catch (CertificateEncodingException e) {
                return new byte[0][];
            }
        }
        return bArr;
    }
}
