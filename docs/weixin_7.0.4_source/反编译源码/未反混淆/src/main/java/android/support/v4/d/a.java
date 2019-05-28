package android.support.v4.d;

import android.support.v4.f.l;
import android.util.Base64;
import java.util.List;

public final class a {
    final String Ke;
    final String Kf;
    final String Kg;
    final List<List<byte[]>> Kh;
    final int Ki = 0;
    final String Kj = new StringBuilder(this.Ke).append("-").append(this.Kf).append("-").append(this.Kg).toString();

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.Ke = (String) l.checkNotNull(str);
        this.Kf = (String) l.checkNotNull(str2);
        this.Kg = (String) l.checkNotNull(str3);
        this.Kh = (List) l.checkNotNull(list);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FontRequest {mProviderAuthority: " + this.Ke + ", mProviderPackage: " + this.Kf + ", mQuery: " + this.Kg + ", mCertificates:");
        for (int i = 0; i < this.Kh.size(); i++) {
            stringBuilder.append(" [");
            List list = (List) this.Kh.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder.append("mCertificatesArray: " + this.Ki);
        return stringBuilder.toString();
    }
}
