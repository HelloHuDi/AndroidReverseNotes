package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy extends a {
    private static CaptureMMProxy otb;
    private static String otc = "";

    public static void createProxy(CaptureMMProxy captureMMProxy) {
        otb = captureMMProxy;
    }

    public static CaptureMMProxy getInstance() {
        return otb;
    }

    public CaptureMMProxy(d dVar) {
        super(dVar);
    }

    public String getAccVideoPath() {
        AppMethodBeat.i(76434);
        String str = (String) REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
        ab.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + otc);
        if (!bo.isNullOrNil(str)) {
            otc = str;
        }
        if (bo.isNullOrNil(otc)) {
            AppMethodBeat.o(76434);
            return str;
        }
        str = otc;
        AppMethodBeat.o(76434);
        return str;
    }

    public String getSubCoreImageFullPath(String str) {
        AppMethodBeat.i(76435);
        String str2 = (String) REMOTE_CALL("getSubCoreImageFullPathInMM", str);
        ab.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath ".concat(String.valueOf(str2)));
        AppMethodBeat.o(76435);
        return str2;
    }

    public Object get(ac.a aVar, Object obj) {
        AppMethodBeat.i(76436);
        ab.i("MicroMsg.CaptureMMProxy", "get %s %s", aVar, obj);
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, obj);
        ab.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", aVar, obj, REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(76436);
            return obj;
        }
        AppMethodBeat.o(76436);
        return REMOTE_CALL;
    }

    public int getInt(ac.a aVar, int i) {
        AppMethodBeat.i(76437);
        ab.i("MicroMsg.CaptureMMProxy", "getInt %s %s", aVar, Integer.valueOf(i));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Integer.valueOf(i));
        ab.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", aVar, Integer.valueOf(i), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(76437);
            return i;
        }
        i = bo.getInt(REMOTE_CALL.toString(), i);
        AppMethodBeat.o(76437);
        return i;
    }

    public boolean getBoolean(ac.a aVar, boolean z) {
        AppMethodBeat.i(76438);
        ab.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", aVar, Boolean.valueOf(z));
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Boolean.valueOf(z));
        ab.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", aVar, Boolean.valueOf(z), REMOTE_CALL);
        if (REMOTE_CALL == null) {
            AppMethodBeat.o(76438);
            return z;
        }
        z = bo.getBoolean(REMOTE_CALL.toString(), z);
        AppMethodBeat.o(76438);
        return z;
    }

    public boolean set(ac.a aVar, Object obj) {
        AppMethodBeat.i(76439);
        Boolean bool = (Boolean) REMOTE_CALL("setConfigStorage", aVar, obj);
        ab.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", aVar, obj);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(76439);
        return booleanValue;
    }

    public VideoTransPara getSnsAlbumVideoTransPara() {
        AppMethodBeat.i(76440);
        Parcelable parcelable = (Parcelable) REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
        ab.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: ".concat(String.valueOf(parcelable)));
        VideoTransPara videoTransPara = (VideoTransPara) parcelable;
        AppMethodBeat.o(76440);
        return videoTransPara;
    }

    public String getDeviceInfoConfig() {
        AppMethodBeat.i(76441);
        ab.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]));
        AppMethodBeat.o(76441);
        return (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    }

    public String getDynamicConfig(String str) {
        AppMethodBeat.i(76442);
        ab.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", str, (String) REMOTE_CALL("getDynamicConfigInMM", str));
        AppMethodBeat.o(76442);
        return (String) REMOTE_CALL("getDynamicConfigInMM", str);
    }

    public byte[] getWeixinMeta() {
        AppMethodBeat.i(76443);
        ab.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]));
        AppMethodBeat.o(76443);
        return (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    }

    public boolean checkUseMMVideoPlayer() {
        AppMethodBeat.i(76444);
        Object REMOTE_CALL = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
        if (REMOTE_CALL != null) {
            ab.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", REMOTE_CALL);
            boolean booleanValue = ((Boolean) REMOTE_CALL).booleanValue();
            AppMethodBeat.o(76444);
            return booleanValue;
        }
        AppMethodBeat.o(76444);
        return true;
    }

    @f
    public VideoTransPara getSnsAlbumVideoTransParaInMM() {
        AppMethodBeat.i(76445);
        ab.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
        VideoTransPara afI = com.tencent.mm.modelcontrol.d.afF().afI();
        ab.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: ".concat(String.valueOf(afI)));
        AppMethodBeat.o(76445);
        return afI;
    }

    @f
    public boolean checkUseMMVideoPlayerInMM() {
        AppMethodBeat.i(76446);
        ab.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
        com.tencent.mm.modelcontrol.d.afF();
        boolean afO = com.tencent.mm.modelcontrol.d.afO();
        ab.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: ".concat(String.valueOf(afO)));
        AppMethodBeat.o(76446);
        return afO;
    }

    @f
    public String getAccVideoPathInMM() {
        AppMethodBeat.i(76447);
        ab.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
        o.alk();
        String accVideoPath = o.getAccVideoPath();
        AppMethodBeat.o(76447);
        return accVideoPath;
    }

    @f
    public String getSubCoreImageFullPathInMM(String str) {
        AppMethodBeat.i(76448);
        ab.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", str);
        String fullPath = com.tencent.mm.at.o.ahl().getFullPath(str);
        AppMethodBeat.o(76448);
        return fullPath;
    }

    @f
    public Object getConfigStorage(int i, Object obj) {
        AppMethodBeat.i(76449);
        ab.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", ((ac.a[]) ac.a.class.getEnumConstants())[i], obj);
        g.RQ();
        Object obj2 = g.RP().Ry().get(r0, obj);
        AppMethodBeat.o(76449);
        return obj2;
    }

    @f
    public boolean setConfigStorage(int i, Object obj) {
        AppMethodBeat.i(76450);
        ab.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", ((ac.a[]) ac.a.class.getEnumConstants())[i], obj);
        g.RQ();
        g.RP().Ry().set(r0, obj);
        AppMethodBeat.o(76450);
        return true;
    }

    @f
    public String getDeviceInfoConfigInMM() {
        AppMethodBeat.i(76451);
        g.RQ();
        String dur = g.RP().Rz().dur();
        AppMethodBeat.o(76451);
        return dur;
    }

    @f
    public String getDynamicConfigInMM(String str) {
        AppMethodBeat.i(76452);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue(str);
        AppMethodBeat.o(76452);
        return value;
    }

    @f
    public byte[] getWeixinMetaDataInMM() {
        AppMethodBeat.i(76453);
        byte[] weixinMeta = com.tencent.mm.modelcontrol.d.afF().getWeixinMeta();
        AppMethodBeat.o(76453);
        return weixinMeta;
    }

    public final Bundle objectsToBundle(Object... objArr) {
        AppMethodBeat.i(76454);
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else if (objArr[i] instanceof ac.a) {
                ab.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", Integer.valueOf(((ac.a) objArr[i]).ordinal()));
                bundle.putInt(String.valueOf(i), ((ac.a) objArr[i]).ordinal());
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        AppMethodBeat.o(76454);
        return bundle;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(76455);
        ab.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", getClass().getName(), str, Boolean.valueOf(z));
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() != Void.TYPE) {
                        if (invoke instanceof Parcelable) {
                            bundle.putParcelable("result_key", (Parcelable) invoke);
                            AppMethodBeat.o(76455);
                            return;
                        }
                        if ("getConfigStorage".equals(str)) {
                            ab.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", (Serializable) invoke);
                        }
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
            AppMethodBeat.o(76455);
        } catch (Exception e) {
            ab.e("MicroMsg.CaptureMMProxy", "exception:%s", bo.l(e));
            AppMethodBeat.o(76455);
        }
    }
}
