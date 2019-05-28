package android.support.p057v4.p063d;

import android.support.p057v4.p065f.C0416l;
import android.util.Base64;
import java.util.List;

/* renamed from: android.support.v4.d.a */
public final class C0385a {
    /* renamed from: Ke */
    final String f429Ke;
    /* renamed from: Kf */
    final String f430Kf;
    /* renamed from: Kg */
    final String f431Kg;
    /* renamed from: Kh */
    final List<List<byte[]>> f432Kh;
    /* renamed from: Ki */
    final int f433Ki = 0;
    /* renamed from: Kj */
    final String f434Kj = new StringBuilder(this.f429Ke).append("-").append(this.f430Kf).append("-").append(this.f431Kg).toString();

    public C0385a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f429Ke = (String) C0416l.checkNotNull(str);
        this.f430Kf = (String) C0416l.checkNotNull(str2);
        this.f431Kg = (String) C0416l.checkNotNull(str3);
        this.f432Kh = (List) C0416l.checkNotNull(list);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FontRequest {mProviderAuthority: " + this.f429Ke + ", mProviderPackage: " + this.f430Kf + ", mQuery: " + this.f431Kg + ", mCertificates:");
        for (int i = 0; i < this.f432Kh.size(); i++) {
            stringBuilder.append(" [");
            List list = (List) this.f432Kh.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder.append("mCertificatesArray: " + this.f433Ki);
        return stringBuilder.toString();
    }
}
