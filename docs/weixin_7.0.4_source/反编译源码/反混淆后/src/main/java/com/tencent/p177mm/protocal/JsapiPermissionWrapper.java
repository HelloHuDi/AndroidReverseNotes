package com.tencent.p177mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.protocal.JsapiPermissionWrapper */
public class JsapiPermissionWrapper implements Parcelable {
    public static final Creator<JsapiPermissionWrapper> CREATOR = new C404941();
    public static final JsapiPermissionWrapper vxI = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper vxJ = new JsapiPermissionWrapper(2);
    public static final JsapiPermissionWrapper vxK = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper vxL = new JsapiPermissionWrapper(4);
    public byte[] vxM;
    private int vxN;
    private Set<Integer> vxO;
    private Set<Integer> vxP;

    /* renamed from: com.tencent.mm.protocal.JsapiPermissionWrapper$1 */
    static class C404941 implements Creator<JsapiPermissionWrapper> {
        C404941() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsapiPermissionWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(79977);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(parcel, (byte) 0);
            AppMethodBeat.m2505o(79977);
            return jsapiPermissionWrapper;
        }
    }

    /* synthetic */ JsapiPermissionWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.m2504i(79994);
        AppMethodBeat.m2505o(79994);
    }

    public JsapiPermissionWrapper() {
        this.vxM = null;
        this.vxN = 0;
        this.vxM = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        AppMethodBeat.m2504i(79978);
        this.vxM = null;
        this.vxN = 0;
        if (bArr == null) {
            this.vxM = null;
            AppMethodBeat.m2505o(79978);
            return;
        }
        this.vxM = bArr;
        AppMethodBeat.m2505o(79978);
    }

    public JsapiPermissionWrapper(int i) {
        AppMethodBeat.m2504i(79979);
        this.vxM = null;
        this.vxN = 0;
        this.vxN = i;
        this.vxM = new byte[0];
        AppMethodBeat.m2505o(79979);
    }

    /* renamed from: Lx */
    public final int mo69828Lx(int i) {
        AppMethodBeat.m2504i(79980);
        if (m79374Lz(i)) {
            AppMethodBeat.m2505o(79980);
            return 1;
        } else if (m79373Ly(i)) {
            AppMethodBeat.m2505o(79980);
            return 0;
        } else if (this.vxN == 1) {
            if (i == 34 || i == 75) {
                C4990ab.m7417i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(79980);
                return 0;
            }
            AppMethodBeat.m2505o(79980);
            return 1;
        } else if (this.vxN == 2) {
            if (i == -3) {
                AppMethodBeat.m2505o(79980);
                return 1;
            }
            AppMethodBeat.m2505o(79980);
            return 0;
        } else if (this.vxN == 3) {
            if (i == 34 || i == 75 || i == 23) {
                C4990ab.m7417i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(79980);
                return 0;
            }
            AppMethodBeat.m2505o(79980);
            return 1;
        } else if (this.vxN == 4) {
            if (i == 34 || i == 75) {
                C4990ab.m7417i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(79980);
                return 0;
            }
            AppMethodBeat.m2505o(79980);
            return 1;
        } else if (i == -2 || i == -3) {
            AppMethodBeat.m2505o(79980);
            return 1;
        } else if (this.vxM == null || i < 0 || i >= this.vxM.length) {
            AppMethodBeat.m2505o(79980);
            return 0;
        } else {
            int i2 = this.vxM[i];
            AppMethodBeat.m2505o(79980);
            return i2;
        }
    }

    /* renamed from: a */
    public final void mo69829a(int i, byte b) {
        int i2 = 0;
        AppMethodBeat.m2504i(79981);
        if (this.vxM == null || i < 0 || i >= this.vxM.length) {
            String str = "MicroMsg.JsapiPermissionWrapper";
            String str2 = "setPermission pos out of range, %s, %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.vxM != null) {
                i2 = this.vxM.length;
            }
            objArr[1] = Integer.valueOf(i2);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(79981);
            return;
        }
        this.vxM[i] = b;
        AppMethodBeat.m2505o(79981);
    }

    /* renamed from: jB */
    public final boolean mo69833jB(int i) {
        AppMethodBeat.m2504i(79982);
        if (mo69828Lx(i) == 1) {
            AppMethodBeat.m2505o(79982);
            return true;
        }
        AppMethodBeat.m2505o(79982);
        return false;
    }

    public String toString() {
        AppMethodBeat.m2504i(79983);
        String str;
        if (this.vxM == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(79983);
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(180);
        for (byte append : this.vxM) {
            stringBuilder.append(append);
        }
        str = stringBuilder.toString();
        C4990ab.m7411d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(79983);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(79984);
        parcel.writeByteArray(this.vxM);
        parcel.writeInt(this.vxN);
        parcel.writeIntArray(dmp());
        parcel.writeIntArray(dmq());
        AppMethodBeat.m2505o(79984);
    }

    private JsapiPermissionWrapper(Parcel parcel) {
        AppMethodBeat.m2504i(79985);
        this.vxM = null;
        this.vxN = 0;
        this.vxM = parcel.createByteArray();
        this.vxN = parcel.readInt();
        m79371A(parcel.createIntArray());
        m79372B(parcel.createIntArray());
        AppMethodBeat.m2505o(79985);
    }

    public final void toBundle(Bundle bundle) {
        AppMethodBeat.m2504i(79986);
        bundle.putByteArray("jsapi_perm_wrapper_bytes", this.vxM);
        bundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.vxN);
        bundle.putIntArray("jsapi_perm_wrapper_blacklist", dmp());
        bundle.putIntArray("jsapi_perm_wrapper_whitelist", dmq());
        AppMethodBeat.m2505o(79986);
    }

    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.m2504i(79987);
        this.vxM = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.vxN = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        m79371A(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        m79372B(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
        AppMethodBeat.m2505o(79987);
    }

    private int[] dmp() {
        AppMethodBeat.m2504i(79988);
        if (this.vxO != null) {
            int[] iArr = new int[this.vxO.size()];
            int i = 0;
            for (Integer num : this.vxO) {
                int i2 = i + 1;
                iArr[i] = num == null ? 0 : num.intValue();
                i = i2;
            }
            AppMethodBeat.m2505o(79988);
            return iArr;
        }
        int[] iArr2 = new int[0];
        AppMethodBeat.m2505o(79988);
        return iArr2;
    }

    /* renamed from: A */
    private void m79371A(int[] iArr) {
        AppMethodBeat.m2504i(79989);
        if (this.vxO == null) {
            this.vxO = new HashSet();
        } else {
            this.vxO.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.vxO.add(Integer.valueOf(valueOf));
            }
        }
        AppMethodBeat.m2505o(79989);
    }

    /* renamed from: Ly */
    private boolean m79373Ly(int i) {
        AppMethodBeat.m2504i(79990);
        if (this.vxO == null || !this.vxO.contains(Integer.valueOf(i))) {
            AppMethodBeat.m2505o(79990);
            return false;
        }
        AppMethodBeat.m2505o(79990);
        return true;
    }

    private int[] dmq() {
        AppMethodBeat.m2504i(79991);
        if (this.vxP != null) {
            int[] iArr = new int[this.vxP.size()];
            int i = 0;
            for (Integer num : this.vxP) {
                int i2 = i + 1;
                iArr[i] = num == null ? 0 : num.intValue();
                i = i2;
            }
            AppMethodBeat.m2505o(79991);
            return iArr;
        }
        int[] iArr2 = new int[0];
        AppMethodBeat.m2505o(79991);
        return iArr2;
    }

    /* renamed from: B */
    private void m79372B(int[] iArr) {
        AppMethodBeat.m2504i(79992);
        if (this.vxP == null) {
            this.vxP = new HashSet();
        } else {
            this.vxP.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.vxP.add(Integer.valueOf(valueOf));
            }
        }
        AppMethodBeat.m2505o(79992);
    }

    /* renamed from: Lz */
    private boolean m79374Lz(int i) {
        AppMethodBeat.m2504i(79993);
        if (this.vxP == null || !this.vxP.contains(Integer.valueOf(i))) {
            AppMethodBeat.m2505o(79993);
            return false;
        }
        AppMethodBeat.m2505o(79993);
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsapiPermissionWrapper)) {
            return false;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) obj;
        if (this.vxM == jsapiPermissionWrapper.vxM) {
            return true;
        }
        if (this.vxM == null || jsapiPermissionWrapper.vxM == null || this.vxM.length != jsapiPermissionWrapper.vxM.length) {
            return false;
        }
        for (int i = 0; i < this.vxM.length; i++) {
            if (this.vxM[i] != jsapiPermissionWrapper.vxM[i]) {
                return false;
            }
        }
        return true;
    }
}
