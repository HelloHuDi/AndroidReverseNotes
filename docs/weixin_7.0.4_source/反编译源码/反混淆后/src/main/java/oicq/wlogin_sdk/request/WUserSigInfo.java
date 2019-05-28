package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;

public class WUserSigInfo implements Serializable {
    static final long serialVersionUID = 0;
    public byte[] _A2;
    public byte[] _A2_Key;
    public byte[] _D2;
    public byte[] _D2_Key;
    public byte[] _access_token;
    public byte[] _in_ksid;
    public byte[] _lsKey;
    public byte[] _noPicSig;
    public byte[] _openid;
    public byte[] _openkey;
    public byte[] _reserveData;
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

    public void get_clone(WloginSigInfo wloginSigInfo) {
        AppMethodBeat.m2504i(96425);
        this._userStSig = wloginSigInfo._userStSig == null ? new byte[0] : (byte[]) wloginSigInfo._userStSig.clone();
        this._userSt_Key = wloginSigInfo._userSt_Key == null ? new byte[0] : (byte[]) wloginSigInfo._userSt_Key.clone();
        this._userStWebSig = wloginSigInfo._userStWebSig == null ? new byte[0] : (byte[]) wloginSigInfo._userStWebSig.clone();
        this._userPasswdSig = wloginSigInfo._en_A1 == null ? new byte[0] : (byte[]) wloginSigInfo._en_A1.clone();
        this._userA5 = wloginSigInfo._userA5 == null ? new byte[0] : (byte[]) wloginSigInfo._userA5.clone();
        this._userA8 = wloginSigInfo._userA8 == null ? new byte[0] : (byte[]) wloginSigInfo._userA8.clone();
        this._lsKey = wloginSigInfo._lsKey == null ? new byte[0] : (byte[]) wloginSigInfo._lsKey.clone();
        this._sKey = wloginSigInfo._sKey == null ? new byte[0] : (byte[]) wloginSigInfo._sKey.clone();
        this._userSig64 = wloginSigInfo._userSig64 == null ? new byte[0] : (byte[]) wloginSigInfo._userSig64.clone();
        this._openid = wloginSigInfo._openid == null ? new byte[0] : (byte[]) wloginSigInfo._openid.clone();
        this._openkey = wloginSigInfo._openkey == null ? new byte[0] : (byte[]) wloginSigInfo._openkey.clone();
        this._vkey = wloginSigInfo._vkey == null ? new byte[0] : (byte[]) wloginSigInfo._vkey.clone();
        this._A2 = wloginSigInfo._TGT == null ? new byte[0] : (byte[]) wloginSigInfo._TGT.clone();
        this._A2_Key = wloginSigInfo._TGTKey == null ? new byte[0] : (byte[]) wloginSigInfo._TGTKey.clone();
        this._access_token = wloginSigInfo._access_token == null ? new byte[0] : (byte[]) wloginSigInfo._access_token.clone();
        this._D2 = wloginSigInfo._D2 == null ? new byte[0] : (byte[]) wloginSigInfo._D2.clone();
        this._D2_Key = wloginSigInfo._D2Key == null ? new byte[0] : (byte[]) wloginSigInfo._D2Key.clone();
        this._sid = wloginSigInfo._sid == null ? new byte[0] : (byte[]) wloginSigInfo._sid.clone();
        this._noPicSig = wloginSigInfo._noPicSig == null ? new byte[0] : (byte[]) wloginSigInfo._noPicSig.clone();
        AppMethodBeat.m2505o(96425);
    }
}
