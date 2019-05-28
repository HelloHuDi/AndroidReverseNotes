package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

public class JsapiPermissionWrapper implements Parcelable {
    public static final Creator<JsapiPermissionWrapper> CREATOR = new Creator<JsapiPermissionWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsapiPermissionWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(79977);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(parcel, (byte) 0);
            AppMethodBeat.o(79977);
            return jsapiPermissionWrapper;
        }
    };
    public static final JsapiPermissionWrapper vxI = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper vxJ = new JsapiPermissionWrapper(2);
    public static final JsapiPermissionWrapper vxK = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper vxL = new JsapiPermissionWrapper(4);
    public byte[] vxM;
    private int vxN;
    private Set<Integer> vxO;
    private Set<Integer> vxP;

    /* synthetic */ JsapiPermissionWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(79994);
        AppMethodBeat.o(79994);
    }

    public JsapiPermissionWrapper() {
        this.vxM = null;
        this.vxN = 0;
        this.vxM = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        AppMethodBeat.i(79978);
        this.vxM = null;
        this.vxN = 0;
        if (bArr == null) {
            this.vxM = null;
            AppMethodBeat.o(79978);
            return;
        }
        this.vxM = bArr;
        AppMethodBeat.o(79978);
    }

    public JsapiPermissionWrapper(int i) {
        AppMethodBeat.i(79979);
        this.vxM = null;
        this.vxN = 0;
        this.vxN = i;
        this.vxM = new byte[0];
        AppMethodBeat.o(79979);
    }

    public final int Lx(int i) {
        AppMethodBeat.i(79980);
        if (Lz(i)) {
            AppMethodBeat.o(79980);
            return 1;
        } else if (Ly(i)) {
            AppMethodBeat.o(79980);
            return 0;
        } else if (this.vxN == 1) {
            if (i == 34 || i == 75) {
                ab.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
                AppMethodBeat.o(79980);
                return 0;
            }
            AppMethodBeat.o(79980);
            return 1;
        } else if (this.vxN == 2) {
            if (i == -3) {
                AppMethodBeat.o(79980);
                return 1;
            }
            AppMethodBeat.o(79980);
            return 0;
        } else if (this.vxN == 3) {
            if (i == 34 || i == 75 || i == 23) {
                ab.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
                AppMethodBeat.o(79980);
                return 0;
            }
            AppMethodBeat.o(79980);
            return 1;
        } else if (this.vxN == 4) {
            if (i == 34 || i == 75) {
                ab.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", Integer.valueOf(i));
                AppMethodBeat.o(79980);
                return 0;
            }
            AppMethodBeat.o(79980);
            return 1;
        } else if (i == -2 || i == -3) {
            AppMethodBeat.o(79980);
            return 1;
        } else if (this.vxM == null || i < 0 || i >= this.vxM.length) {
            AppMethodBeat.o(79980);
            return 0;
        } else {
            int i2 = this.vxM[i];
            AppMethodBeat.o(79980);
            return i2;
        }
    }

    public final void a(int i, byte b) {
        int i2 = 0;
        AppMethodBeat.i(79981);
        if (this.vxM == null || i < 0 || i >= this.vxM.length) {
            String str = "MicroMsg.JsapiPermissionWrapper";
            String str2 = "setPermission pos out of range, %s, %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.vxM != null) {
                i2 = this.vxM.length;
            }
            objArr[1] = Integer.valueOf(i2);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(79981);
            return;
        }
        this.vxM[i] = b;
        AppMethodBeat.o(79981);
    }

    public final boolean jB(int i) {
        AppMethodBeat.i(79982);
        if (Lx(i) == 1) {
            AppMethodBeat.o(79982);
            return true;
        }
        AppMethodBeat.o(79982);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(79983);
        String str;
        if (this.vxM == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(79983);
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(180);
        for (byte append : this.vxM) {
            stringBuilder.append(append);
        }
        str = stringBuilder.toString();
        ab.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(79983);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(79984);
        parcel.writeByteArray(this.vxM);
        parcel.writeInt(this.vxN);
        parcel.writeIntArray(dmp());
        parcel.writeIntArray(dmq());
        AppMethodBeat.o(79984);
    }

    private JsapiPermissionWrapper(Parcel parcel) {
        AppMethodBeat.i(79985);
        this.vxM = null;
        this.vxN = 0;
        this.vxM = parcel.createByteArray();
        this.vxN = parcel.readInt();
        A(parcel.createIntArray());
        B(parcel.createIntArray());
        AppMethodBeat.o(79985);
    }

    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(79986);
        bundle.putByteArray("jsapi_perm_wrapper_bytes", this.vxM);
        bundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.vxN);
        bundle.putIntArray("jsapi_perm_wrapper_blacklist", dmp());
        bundle.putIntArray("jsapi_perm_wrapper_whitelist", dmq());
        AppMethodBeat.o(79986);
    }

    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(79987);
        this.vxM = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.vxN = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        A(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        B(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
        AppMethodBeat.o(79987);
    }

    private int[] dmp() {
        AppMethodBeat.i(79988);
        if (this.vxO != null) {
            int[] iArr = new int[this.vxO.size()];
            int i = 0;
            for (Integer num : this.vxO) {
                int i2 = i + 1;
                iArr[i] = num == null ? 0 : num.intValue();
                i = i2;
            }
            AppMethodBeat.o(79988);
            return iArr;
        }
        int[] iArr2 = new int[0];
        AppMethodBeat.o(79988);
        return iArr2;
    }

    private void A(int[] iArr) {
        AppMethodBeat.i(79989);
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
        AppMethodBeat.o(79989);
    }

    private boolean Ly(int i) {
        AppMethodBeat.i(79990);
        if (this.vxO == null || !this.vxO.contains(Integer.valueOf(i))) {
            AppMethodBeat.o(79990);
            return false;
        }
        AppMethodBeat.o(79990);
        return true;
    }

    private int[] dmq() {
        AppMethodBeat.i(79991);
        if (this.vxP != null) {
            int[] iArr = new int[this.vxP.size()];
            int i = 0;
            for (Integer num : this.vxP) {
                int i2 = i + 1;
                iArr[i] = num == null ? 0 : num.intValue();
                i = i2;
            }
            AppMethodBeat.o(79991);
            return iArr;
        }
        int[] iArr2 = new int[0];
        AppMethodBeat.o(79991);
        return iArr2;
    }

    private void B(int[] iArr) {
        AppMethodBeat.i(79992);
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
        AppMethodBeat.o(79992);
    }

    private boolean Lz(int i) {
        AppMethodBeat.i(79993);
        if (this.vxP == null || !this.vxP.contains(Integer.valueOf(i))) {
            AppMethodBeat.o(79993);
            return false;
        }
        AppMethodBeat.o(79993);
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
