package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class WloginSigInfo implements Parcelable, Serializable {
    public static final Creator<WloginSigInfo> CREATOR = new C61131();
    private static final long serialVersionUID = 1;
    public long _A2_expire_time;
    public byte[] _D2;
    public byte[] _D2Key;
    public byte[] _TGT;
    public byte[] _TGTKey;
    public byte[] _access_token;
    public long _app_pri;
    public long _create_time;
    public byte[] _en_A1;
    public long _expire_time;
    public byte[] _lsKey;
    public byte[] _noPicSig;
    public byte[] _openid;
    public byte[] _openkey;
    public long _ret_appid;
    public byte[] _sKey;
    public byte[] _sid;
    public byte[] _userA5;
    public byte[] _userA8;
    public byte[] _userPasswdSig;
    public byte[] _userSig64;
    public byte[] _userStSig;
    public byte[] _userStWebSig;
    public byte[] _userSt_Key;
    public byte[] _vkey;

    /* renamed from: oicq.wlogin_sdk.sharemem.WloginSigInfo$1 */
    class C61131 implements Creator<WloginSigInfo> {
        C61131() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(96462);
            WloginSigInfo wloginSigInfo = new WloginSigInfo(parcel, null);
            AppMethodBeat.m2505o(96462);
            return wloginSigInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WloginSigInfo[i];
        }
    }

    public WloginSigInfo(long j, long j2, long j3, long j4, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13) {
        AppMethodBeat.m2504i(96464);
        this._expire_time = 0;
        this._A2_expire_time = 0;
        this._create_time = 0;
        this._app_pri = 0;
        this._ret_appid = 0;
        this._app_pri = j;
        this._create_time = j2;
        this._expire_time = j3;
        this._A2_expire_time = j4;
        this._TGT = (byte[]) bArr.clone();
        this._TGTKey = (byte[]) bArr2.clone();
        this._userStSig = (byte[]) bArr3.clone();
        this._userSt_Key = (byte[]) bArr4.clone();
        if (bArr5 != null) {
            this._userStWebSig = (byte[]) bArr5.clone();
        } else {
            this._userStWebSig = new byte[0];
        }
        this._userPasswdSig = new byte[0];
        if (bArr6 != null) {
            this._userA5 = (byte[]) bArr6.clone();
        } else {
            this._userA5 = new byte[0];
        }
        if (bArr7 != null) {
            this._userA8 = (byte[]) bArr7.clone();
        } else {
            this._userA8 = new byte[0];
        }
        if (bArr8 != null) {
            this._lsKey = (byte[]) bArr8.clone();
        } else {
            this._lsKey = new byte[0];
        }
        if (bArr9 != null) {
            this._sKey = (byte[]) bArr9.clone();
        } else {
            this._sKey = new byte[0];
        }
        if (bArr10 != null) {
            this._userSig64 = (byte[]) bArr10.clone();
        } else {
            this._userSig64 = new byte[0];
        }
        if (bArr11 != null) {
            this._openid = (byte[]) bArr11.clone();
        } else {
            this._openid = new byte[0];
        }
        if (bArr12 != null) {
            this._openkey = (byte[]) bArr12.clone();
        } else {
            this._openkey = new byte[0];
        }
        if (bArr13 == null || bArr13.length != 7) {
            this._vkey = new byte[0];
            this._en_A1 = new byte[0];
            this._access_token = new byte[0];
            this._D2 = new byte[0];
            this._D2Key = new byte[0];
            this._sid = new byte[0];
            this._noPicSig = new byte[0];
            AppMethodBeat.m2505o(96464);
            return;
        }
        this._vkey = (byte[]) bArr13[0].clone();
        this._en_A1 = (byte[]) bArr13[1].clone();
        this._access_token = (byte[]) bArr13[2].clone();
        this._D2 = (byte[]) bArr13[3].clone();
        this._D2Key = (byte[]) bArr13[4].clone();
        this._sid = (byte[]) bArr13[5].clone();
        this._noPicSig = (byte[]) bArr13[6].clone();
        AppMethodBeat.m2505o(96464);
    }

    public WloginSigInfo Set(long j, long j2, long j3, long j4, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13) {
        AppMethodBeat.m2504i(96465);
        this._app_pri = j;
        this._create_time = j2;
        this._expire_time = j3;
        this._A2_expire_time = j4;
        this._TGT = (byte[]) bArr.clone();
        this._TGTKey = (byte[]) bArr2.clone();
        this._userStSig = (byte[]) bArr3.clone();
        this._userSt_Key = (byte[]) bArr4.clone();
        if (bArr5 != null) {
            this._userStWebSig = (byte[]) bArr5.clone();
        } else {
            this._userStWebSig = new byte[0];
        }
        this._userPasswdSig = new byte[0];
        if (bArr6 != null) {
            this._userA5 = (byte[]) bArr6.clone();
        } else {
            this._userA5 = new byte[0];
        }
        if (bArr7 != null) {
            this._userA8 = (byte[]) bArr7.clone();
        } else {
            this._userA8 = new byte[0];
        }
        if (bArr8 != null) {
            this._lsKey = (byte[]) bArr8.clone();
        } else {
            this._lsKey = new byte[0];
        }
        if (bArr9 != null) {
            this._sKey = (byte[]) bArr9.clone();
        } else {
            this._sKey = new byte[0];
        }
        if (bArr10 != null) {
            this._userSig64 = (byte[]) bArr10.clone();
        } else {
            this._userSig64 = new byte[0];
        }
        if (bArr11 != null) {
            this._openid = (byte[]) bArr11.clone();
        } else {
            this._openid = new byte[0];
        }
        if (bArr12 != null) {
            this._openkey = (byte[]) bArr12.clone();
        } else {
            this._openkey = new byte[0];
        }
        if (bArr13 == null || bArr13.length != 7) {
            this._vkey = new byte[0];
            this._access_token = new byte[0];
            this._D2 = new byte[0];
            this._D2Key = new byte[0];
            this._sid = new byte[0];
            this._noPicSig = new byte[0];
        } else {
            this._vkey = (byte[]) bArr13[0].clone();
            if (bArr13[1].clone() != null && ((byte[]) bArr13[1].clone()).length > 0) {
                this._en_A1 = (byte[]) bArr13[1].clone();
                if (bArr13[6] == null || bArr13[6].length <= 0) {
                    this._noPicSig = new byte[0];
                } else {
                    this._noPicSig = (byte[]) bArr13[6].clone();
                }
            }
            this._access_token = (byte[]) bArr13[2].clone();
            this._D2 = (byte[]) bArr13[3].clone();
            this._D2Key = (byte[]) bArr13[4].clone();
            this._sid = (byte[]) bArr13[5].clone();
        }
        AppMethodBeat.m2505o(96465);
        return this;
    }

    static {
        AppMethodBeat.m2504i(96463);
        AppMethodBeat.m2505o(96463);
    }

    private WloginSigInfo(Parcel parcel) {
        AppMethodBeat.m2504i(96466);
        this._expire_time = 0;
        this._A2_expire_time = 0;
        this._create_time = 0;
        this._app_pri = 0;
        this._ret_appid = 0;
        readFromParcel(parcel);
        AppMethodBeat.m2505o(96466);
    }

    /* synthetic */ WloginSigInfo(Parcel parcel, WloginSigInfo wloginSigInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(96467);
        parcel.writeByteArray(this._TGT);
        parcel.writeByteArray(this._TGTKey);
        parcel.writeByteArray(this._userStSig);
        parcel.writeByteArray(this._userSt_Key);
        parcel.writeByteArray(this._userStWebSig);
        parcel.writeByteArray(this._userPasswdSig);
        parcel.writeByteArray(this._userA5);
        parcel.writeByteArray(this._userA8);
        parcel.writeByteArray(this._lsKey);
        parcel.writeByteArray(this._sKey);
        parcel.writeByteArray(this._userSig64);
        parcel.writeByteArray(this._openid);
        parcel.writeByteArray(this._openkey);
        parcel.writeByteArray(this._vkey);
        parcel.writeByteArray(this._en_A1);
        parcel.writeByteArray(this._access_token);
        parcel.writeByteArray(this._D2);
        parcel.writeByteArray(this._D2Key);
        parcel.writeByteArray(this._sid);
        parcel.writeByteArray(this._noPicSig);
        parcel.writeLong(this._expire_time);
        parcel.writeLong(this._A2_expire_time);
        parcel.writeLong(this._create_time);
        parcel.writeLong(this._app_pri);
        parcel.writeLong(this._ret_appid);
        AppMethodBeat.m2505o(96467);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(96468);
        this._TGT = parcel.createByteArray();
        this._TGTKey = parcel.createByteArray();
        this._userStSig = parcel.createByteArray();
        this._userSt_Key = parcel.createByteArray();
        this._userStWebSig = parcel.createByteArray();
        this._userPasswdSig = parcel.createByteArray();
        this._userA5 = parcel.createByteArray();
        this._userA8 = parcel.createByteArray();
        this._lsKey = parcel.createByteArray();
        this._sKey = parcel.createByteArray();
        this._userSig64 = parcel.createByteArray();
        this._openid = parcel.createByteArray();
        this._openkey = parcel.createByteArray();
        this._vkey = parcel.createByteArray();
        this._en_A1 = parcel.createByteArray();
        this._access_token = parcel.createByteArray();
        this._D2 = parcel.createByteArray();
        this._D2Key = parcel.createByteArray();
        this._sid = parcel.createByteArray();
        this._noPicSig = parcel.createByteArray();
        this._expire_time = parcel.readLong();
        this._A2_expire_time = parcel.readLong();
        this._create_time = parcel.readLong();
        this._app_pri = parcel.readLong();
        this._ret_appid = parcel.readLong();
        AppMethodBeat.m2505o(96468);
    }
}
