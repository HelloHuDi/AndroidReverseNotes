package com.tencent.p177mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.Serializable;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.plugin.mmsight.model.CaptureMMProxy */
public class CaptureMMProxy extends C31577a {
    private static CaptureMMProxy otb;
    private static String otc = "";

    public static void createProxy(CaptureMMProxy captureMMProxy) {
        otb = captureMMProxy;
    }

    public static CaptureMMProxy getInstance() {
        return otb;
    }

    public CaptureMMProxy(C46607d c46607d) {
        super(c46607d);
    }

    public String getAccVideoPath() {
        AppMethodBeat.m2504i(76434);
        String str = (String) REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
        C4990ab.m7416i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + otc);
        if (!C5046bo.isNullOrNil(str)) {
            otc = str;
        }
        if (C5046bo.isNullOrNil(otc)) {
            AppMethodBeat.m2505o(76434);
            return str;
        }
        str = otc;
        AppMethodBeat.m2505o(76434);
        return str;
    }

    public String getSubCoreImageFullPath(String str) {
        AppMethodBeat.m2504i(76435);
        String str2 = (String) REMOTE_CALL("getSubCoreImageFullPathInMM", str);
        C4990ab.m7416i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath ".concat(String.valueOf(str2)));
        AppMethodBeat.m2505o(76435);
        return str2;
    }

    public Object get(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(76436);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "get %s %s", c5127a, obj);
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", c5127a, obj);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", c5127a, obj, REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(76436);
            return obj;
        }
        AppMethodBeat.m2505o(76436);
        return REMOTE_CALL;
    }

    public int getInt(C5127a c5127a, int i) {
        AppMethodBeat.m2504i(76437);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getInt %s %s", c5127a, Integer.valueOf(i));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", c5127a, Integer.valueOf(i));
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", c5127a, Integer.valueOf(i), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(76437);
            return i;
        }
        i = C5046bo.getInt(REMOTE_CALL.toString(), i);
        AppMethodBeat.m2505o(76437);
        return i;
    }

    public boolean getBoolean(C5127a c5127a, boolean z) {
        AppMethodBeat.m2504i(76438);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", c5127a, Boolean.valueOf(z));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", c5127a, Boolean.valueOf(z));
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", c5127a, Boolean.valueOf(z), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.m2505o(76438);
            return z;
        }
        z = C5046bo.getBoolean(REMOTE_CALL.toString(), z);
        AppMethodBeat.m2505o(76438);
        return z;
    }

    public boolean set(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(76439);
        Boolean bool = (Boolean) REMOTE_CALL("setConfigStorage", c5127a, obj);
        C4990ab.m7411d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", c5127a, obj);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(76439);
        return booleanValue;
    }

    public VideoTransPara getSnsAlbumVideoTransPara() {
        AppMethodBeat.m2504i(76440);
        Parcelable parcelable = (Parcelable) REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
        C4990ab.m7410d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: ".concat(String.valueOf(parcelable)));
        VideoTransPara videoTransPara = (VideoTransPara) parcelable;
        AppMethodBeat.m2505o(76440);
        return videoTransPara;
    }

    public String getDeviceInfoConfig() {
        AppMethodBeat.m2504i(76441);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]));
        AppMethodBeat.m2505o(76441);
        return (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    }

    public String getDynamicConfig(String str) {
        AppMethodBeat.m2504i(76442);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", str, (String) REMOTE_CALL("getDynamicConfigInMM", str));
        AppMethodBeat.m2505o(76442);
        return (String) REMOTE_CALL("getDynamicConfigInMM", str);
    }

    public byte[] getWeixinMeta() {
        AppMethodBeat.m2504i(76443);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]));
        AppMethodBeat.m2505o(76443);
        return (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    }

    public boolean checkUseMMVideoPlayer() {
        AppMethodBeat.m2504i(76444);
        Object REMOTE_CALL = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
        if (REMOTE_CALL != null) {
            C4990ab.m7417i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", REMOTE_CALL);
            boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
            AppMethodBeat.m2505o(76444);
            return booleanValue;
        }
        AppMethodBeat.m2505o(76444);
        return true;
    }

    @C46608f
    public VideoTransPara getSnsAlbumVideoTransParaInMM() {
        AppMethodBeat.m2504i(76445);
        C4990ab.m7410d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
        VideoTransPara afI = C42204d.afF().afI();
        C4990ab.m7410d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(afI)));
        AppMethodBeat.m2505o(76445);
        return afI;
    }

    @C46608f
    public boolean checkUseMMVideoPlayerInMM() {
        AppMethodBeat.m2504i(76446);
        C4990ab.m7410d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
        C42204d.afF();
        boolean afO = C42204d.afO();
        C4990ab.m7410d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: ".concat(String.valueOf(afO)));
        AppMethodBeat.m2505o(76446);
        return afO;
    }

    @C46608f
    public String getAccVideoPathInMM() {
        AppMethodBeat.m2504i(76447);
        C4990ab.m7410d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
        C37961o.alk();
        String accVideoPath = C37961o.getAccVideoPath();
        AppMethodBeat.m2505o(76447);
        return accVideoPath;
    }

    @C46608f
    public String getSubCoreImageFullPathInMM(String str) {
        AppMethodBeat.m2504i(76448);
        C4990ab.m7411d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", str);
        String fullPath = C32291o.ahl().getFullPath(str);
        AppMethodBeat.m2505o(76448);
        return fullPath;
    }

    @C46608f
    public Object getConfigStorage(int i, Object obj) {
        AppMethodBeat.m2504i(76449);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", ((C5127a[]) C5127a.class.getEnumConstants())[i], obj);
        C1720g.m3537RQ();
        Object obj2 = C1720g.m3536RP().mo5239Ry().get(r0, obj);
        AppMethodBeat.m2505o(76449);
        return obj2;
    }

    @C46608f
    public boolean setConfigStorage(int i, Object obj) {
        AppMethodBeat.m2504i(76450);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", ((C5127a[]) C5127a.class.getEnumConstants())[i], obj);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(r0, obj);
        AppMethodBeat.m2505o(76450);
        return true;
    }

    @C46608f
    public String getDeviceInfoConfigInMM() {
        AppMethodBeat.m2504i(76451);
        C1720g.m3537RQ();
        String dur = C1720g.m3536RP().mo5240Rz().dur();
        AppMethodBeat.m2505o(76451);
        return dur;
    }

    @C46608f
    public String getDynamicConfigInMM(String str) {
        AppMethodBeat.m2504i(76452);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue(str);
        AppMethodBeat.m2505o(76452);
        return value;
    }

    @C46608f
    public byte[] getWeixinMetaDataInMM() {
        AppMethodBeat.m2504i(76453);
        byte[] weixinMeta = C42204d.afF().getWeixinMeta();
        AppMethodBeat.m2505o(76453);
        return weixinMeta;
    }

    public final Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.m2504i(76454);
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else if (objArr[i] instanceof C5127a) {
                C4990ab.m7417i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", Integer.valueOf(((C5127a) objArr[i]).ordinal()));
                bundle.putInt(String.valueOf(i), ((C5127a) objArr[i]).ordinal());
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        AppMethodBeat.m2505o(76454);
        return bundle;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(76455);
        C4990ab.m7417i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? C40602e.class : C46608f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable("result_key", (Parcelable) invoke);
                            AppMethodBeat.m2505o(76455);
                            return;
                        }
                        if ("getConfigStorage".equals(str)) {
                            C4990ab.m7417i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", (Serializable) invoke);
                        }
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.m2505o(76455);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CaptureMMProxy", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(76455);
        }
    }
}
