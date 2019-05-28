package com.tencent.mm.plugin.appbrand.s;

import android.util.Base64;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class q {

    public enum b {
        OK,
        FAIL_SIZE_EXCEED_LIMIT;

        static {
            AppMethodBeat.o(91180);
        }
    }

    public static class a implements j {
        public int hfX = BaseClientBuilder.API_PRIORITY_OTHER;
        public String iRE = "__nativeBuffers__";
        public String iRF = "key";
        public String iRG = "id";
        public String iRH = "base64";
    }

    public static ByteBuffer al(byte[] bArr) {
        AppMethodBeat.i(91181);
        if (bArr == null) {
            AppMethodBeat.o(91181);
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr, 0, bArr.length);
        allocateDirect.rewind();
        AppMethodBeat.o(91181);
        return allocateDirect;
    }

    public static final b a(i iVar, Map map, a aVar) {
        JSONException e;
        UnsupportedEncodingException e2;
        boolean z = false;
        AppMethodBeat.i(91182);
        String str;
        String str2;
        b bVar;
        if (iVar == null || map == null) {
            str = "MicroMsg.NativeBufferUtil";
            str2 = "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(iVar == null);
            if (map == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.e(str, str2, objArr);
            bVar = b.OK;
            AppMethodBeat.o(91182);
            return bVar;
        }
        boolean z2;
        if (aVar == null) {
            aVar = new a();
        }
        k kVar = (k) iVar.af(k.class);
        JSONArray jSONArray = new JSONArray();
        Iterator it = map.entrySet().iterator();
        boolean z3 = false;
        int i = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            str2 = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null && (value instanceof ByteBuffer)) {
                int nativeBufferId;
                boolean z4;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(aVar.iRF, str2);
                    if (kVar != null) {
                        nativeBufferId = kVar.getNativeBufferId();
                        if (nativeBufferId != -1) {
                            ByteBuffer byteBuffer = (ByteBuffer) value;
                            if (byteBuffer == null) {
                                ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
                            } else {
                                kVar.setNativeBuffer(nativeBufferId, byteBuffer);
                                jSONObject.put(aVar.iRG, nativeBufferId);
                                nativeBufferId = i + byteBuffer.capacity();
                                jSONArray.put(jSONObject);
                                z4 = true;
                                it.remove();
                                z3 = z4;
                                i = nativeBufferId;
                            }
                        }
                    }
                    jSONObject.put(aVar.iRH, new String(Base64.encode(((ByteBuffer) value).array(), 2), ProtocolPackage.ServerEncoding));
                    nativeBufferId = i;
                    try {
                        jSONArray.put(jSONObject);
                        z4 = true;
                    } catch (JSONException e3) {
                        e = e3;
                        ab.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e.getMessage());
                        z4 = z3;
                        it.remove();
                        z3 = z4;
                        i = nativeBufferId;
                    } catch (UnsupportedEncodingException e4) {
                        e2 = e4;
                        ab.w("MicroMsg.NativeBufferUtil", "processNativeBuffer UnsupportedEncodingException :%s", e2.getMessage());
                        z4 = z3;
                        it.remove();
                        z3 = z4;
                        i = nativeBufferId;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    nativeBufferId = i;
                    ab.w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e.getMessage());
                    z4 = z3;
                    it.remove();
                    z3 = z4;
                    i = nativeBufferId;
                } catch (UnsupportedEncodingException e6) {
                    e2 = e6;
                    nativeBufferId = i;
                    ab.w("MicroMsg.NativeBufferUtil", "processNativeBuffer UnsupportedEncodingException :%s", e2.getMessage());
                    z4 = z3;
                    it.remove();
                    z3 = z4;
                    i = nativeBufferId;
                }
                it.remove();
                z3 = z4;
                i = nativeBufferId;
            }
        }
        str = "MicroMsg.NativeBufferUtil";
        str2 = "ToJs useX5JSCore %b,bufferSize %d";
        Object[] objArr2 = new Object[2];
        if (kVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr2[0] = Boolean.valueOf(z2);
        objArr2[1] = Integer.valueOf(i);
        ab.i(str, str2, objArr2);
        if (i > aVar.hfX) {
            ab.e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", Integer.valueOf(i), Integer.valueOf(aVar.hfX));
            bVar = b.FAIL_SIZE_EXCEED_LIMIT;
            AppMethodBeat.o(91182);
            return bVar;
        }
        if (z3) {
            map.put(aVar.iRE, jSONArray);
        }
        bVar = b.OK;
        AppMethodBeat.o(91182);
        return bVar;
    }

    public static final b a(i iVar, JSONObject jSONObject, a aVar) {
        boolean z = false;
        AppMethodBeat.i(91183);
        b bVar;
        if (iVar == null || jSONObject == null) {
            String str = "MicroMsg.NativeBufferUtil";
            String str2 = "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(iVar == null);
            if (jSONObject == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.e(str, str2, objArr);
            bVar = b.OK;
            AppMethodBeat.o(91183);
            return bVar;
        }
        if (aVar == null) {
            aVar = new a();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(aVar.iRE);
        if (optJSONArray == null) {
            bVar = b.OK;
            AppMethodBeat.o(91183);
            return bVar;
        }
        jSONObject.remove(aVar.iRE);
        int length = optJSONArray.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(aVar.iRF);
                if (!bo.isNullOrNil(optString)) {
                    int optInt = optJSONObject.optInt(aVar.iRG, -1);
                    if (optInt == -1) {
                        try {
                            String optString2 = optJSONObject.optString(aVar.iRH, "");
                            if (bo.isNullOrNil(optString2)) {
                                ab.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                                jSONObject.put(optString, ByteBuffer.allocate(0));
                                i3 = i2;
                            } else {
                                jSONObject.put(optString, ByteBuffer.wrap(Base64.decode(optString2.getBytes(Charset.forName("UTF-8")), 2)));
                                i3 = i2;
                            }
                        } catch (JSONException e) {
                            ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", e.getMessage());
                        }
                    } else {
                        k kVar = (k) iVar.af(k.class);
                        if (kVar == null) {
                            ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
                            i3 = i2;
                        } else {
                            ByteBuffer nativeBuffer = kVar.getNativeBuffer(optInt);
                            if (nativeBuffer == null) {
                                ab.w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
                                i3 = i2;
                            } else {
                                nativeBuffer.position(0);
                                jSONObject.put(optString, nativeBuffer);
                                i3 = nativeBuffer.capacity() + i2;
                            }
                        }
                    }
                    i++;
                    i2 = i3;
                }
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        ab.i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", Integer.valueOf(i2));
        if (i2 > aVar.hfX) {
            ab.e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", Integer.valueOf(i2), Integer.valueOf(aVar.hfX));
            bVar = b.FAIL_SIZE_EXCEED_LIMIT;
            AppMethodBeat.o(91183);
            return bVar;
        }
        bVar = b.OK;
        AppMethodBeat.o(91183);
        return bVar;
    }

    public static void m(c cVar, String str) {
        AppMethodBeat.i(91184);
        HashMap hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "convert native buffer parameter fail, event=" + str + ", error=native buffer exceed size limit");
        hashMap.put(SharePluginInfo.ISSUE_KEY_STACK, "");
        cVar.bX("onError", new JSONObject(hashMap).toString());
        AppMethodBeat.o(91184);
    }
}
