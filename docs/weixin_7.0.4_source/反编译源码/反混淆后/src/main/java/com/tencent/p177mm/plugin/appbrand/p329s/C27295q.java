package com.tencent.p177mm.plugin.appbrand.p329s;

import android.util.Base64;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p297h.C26901k;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.appbrand.s.q */
public final class C27295q {

    /* renamed from: com.tencent.mm.plugin.appbrand.s.q$b */
    public enum C10730b {
        OK,
        FAIL_SIZE_EXCEED_LIMIT;

        static {
            AppMethodBeat.m2505o(91180);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.q$a */
    public static class C27296a implements C10441j {
        public int hfX = BaseClientBuilder.API_PRIORITY_OTHER;
        public String iRE = "__nativeBuffers__";
        public String iRF = "key";
        public String iRG = "id";
        public String iRH = "base64";
    }

    /* renamed from: al */
    public static ByteBuffer m43335al(byte[] bArr) {
        AppMethodBeat.m2504i(91181);
        if (bArr == null) {
            AppMethodBeat.m2505o(91181);
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr, 0, bArr.length);
        allocateDirect.rewind();
        AppMethodBeat.m2505o(91181);
        return allocateDirect;
    }

    /* renamed from: a */
    public static final C10730b m43333a(C6747i c6747i, Map map, C27296a c27296a) {
        JSONException e;
        UnsupportedEncodingException e2;
        boolean z = false;
        AppMethodBeat.m2504i(91182);
        String str;
        String str2;
        C10730b c10730b;
        if (c6747i == null || map == null) {
            str = "MicroMsg.NativeBufferUtil";
            str2 = "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], map is null:[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(c6747i == null);
            if (map == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
            c10730b = C10730b.OK;
            AppMethodBeat.m2505o(91182);
            return c10730b;
        }
        boolean z2;
        if (c27296a == null) {
            c27296a = new C27296a();
        }
        C26901k c26901k = (C26901k) c6747i.mo14970af(C26901k.class);
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
                    jSONObject.put(c27296a.iRF, str2);
                    if (c26901k != null) {
                        nativeBufferId = c26901k.getNativeBufferId();
                        if (nativeBufferId != -1) {
                            ByteBuffer byteBuffer = (ByteBuffer) value;
                            if (byteBuffer == null) {
                                C4990ab.m7420w("MicroMsg.NativeBufferUtil", "processNativeBufferToJs byteBuffer is null");
                            } else {
                                c26901k.setNativeBuffer(nativeBufferId, byteBuffer);
                                jSONObject.put(c27296a.iRG, nativeBufferId);
                                nativeBufferId = i + byteBuffer.capacity();
                                jSONArray.put(jSONObject);
                                z4 = true;
                                it.remove();
                                z3 = z4;
                                i = nativeBufferId;
                            }
                        }
                    }
                    jSONObject.put(c27296a.iRH, new String(Base64.encode(((ByteBuffer) value).array(), 2), ProtocolPackage.ServerEncoding));
                    nativeBufferId = i;
                    try {
                        jSONArray.put(jSONObject);
                        z4 = true;
                    } catch (JSONException e3) {
                        e = e3;
                        C4990ab.m7421w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e.getMessage());
                        z4 = z3;
                        it.remove();
                        z3 = z4;
                        i = nativeBufferId;
                    } catch (UnsupportedEncodingException e4) {
                        e2 = e4;
                        C4990ab.m7421w("MicroMsg.NativeBufferUtil", "processNativeBuffer UnsupportedEncodingException :%s", e2.getMessage());
                        z4 = z3;
                        it.remove();
                        z3 = z4;
                        i = nativeBufferId;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    nativeBufferId = i;
                    C4990ab.m7421w("MicroMsg.NativeBufferUtil", "processNativeBuffer JSONException :%s", e.getMessage());
                    z4 = z3;
                    it.remove();
                    z3 = z4;
                    i = nativeBufferId;
                } catch (UnsupportedEncodingException e6) {
                    e2 = e6;
                    nativeBufferId = i;
                    C4990ab.m7421w("MicroMsg.NativeBufferUtil", "processNativeBuffer UnsupportedEncodingException :%s", e2.getMessage());
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
        if (c26901k != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr2[0] = Boolean.valueOf(z2);
        objArr2[1] = Integer.valueOf(i);
        C4990ab.m7417i(str, str2, objArr2);
        if (i > c27296a.hfX) {
            C4990ab.m7413e("MicroMsg.NativeBufferUtil", "bufferSize exceed the limit, bufferSize = %d, limit = %d", Integer.valueOf(i), Integer.valueOf(c27296a.hfX));
            c10730b = C10730b.FAIL_SIZE_EXCEED_LIMIT;
            AppMethodBeat.m2505o(91182);
            return c10730b;
        }
        if (z3) {
            map.put(c27296a.iRE, jSONArray);
        }
        c10730b = C10730b.OK;
        AppMethodBeat.m2505o(91182);
        return c10730b;
    }

    /* renamed from: a */
    public static final C10730b m43334a(C6747i c6747i, JSONObject jSONObject, C27296a c27296a) {
        boolean z = false;
        AppMethodBeat.m2504i(91183);
        C10730b c10730b;
        if (c6747i == null || jSONObject == null) {
            String str = "MicroMsg.NativeBufferUtil";
            String str2 = "processNativeBufferToJs fail, invalid argument, jsruntime is null:[%b], data is null:[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(c6747i == null);
            if (jSONObject == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
            c10730b = C10730b.OK;
            AppMethodBeat.m2505o(91183);
            return c10730b;
        }
        if (c27296a == null) {
            c27296a = new C27296a();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(c27296a.iRE);
        if (optJSONArray == null) {
            c10730b = C10730b.OK;
            AppMethodBeat.m2505o(91183);
            return c10730b;
        }
        jSONObject.remove(c27296a.iRE);
        int length = optJSONArray.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(c27296a.iRF);
                if (!C5046bo.isNullOrNil(optString)) {
                    int optInt = optJSONObject.optInt(c27296a.iRG, -1);
                    if (optInt == -1) {
                        try {
                            String optString2 = optJSONObject.optString(c27296a.iRH, "");
                            if (C5046bo.isNullOrNil(optString2)) {
                                C4990ab.m7416i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs base64 is null");
                                jSONObject.put(optString, ByteBuffer.allocate(0));
                                i3 = i2;
                            } else {
                                jSONObject.put(optString, ByteBuffer.wrap(Base64.decode(optString2.getBytes(Charset.forName("UTF-8")), 2)));
                                i3 = i2;
                            }
                        } catch (JSONException e) {
                            C4990ab.m7421w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs JSONException :%s", e.getMessage());
                        }
                    } else {
                        C26901k c26901k = (C26901k) c6747i.mo14970af(C26901k.class);
                        if (c26901k == null) {
                            C4990ab.m7420w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferAddon is null, not support");
                            i3 = i2;
                        } else {
                            ByteBuffer nativeBuffer = c26901k.getNativeBuffer(optInt);
                            if (nativeBuffer == null) {
                                C4990ab.m7420w("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs byteBuffer is null");
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
        C4990ab.m7417i("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs bufferSize %d", Integer.valueOf(i2));
        if (i2 > c27296a.hfX) {
            C4990ab.m7413e("MicroMsg.NativeBufferUtil", "processNativeBufferFromJs fail, size exceed limit, bufferSize = %d, limit = %d", Integer.valueOf(i2), Integer.valueOf(c27296a.hfX));
            c10730b = C10730b.FAIL_SIZE_EXCEED_LIMIT;
            AppMethodBeat.m2505o(91183);
            return c10730b;
        }
        c10730b = C10730b.OK;
        AppMethodBeat.m2505o(91183);
        return c10730b;
    }

    /* renamed from: m */
    public static void m43336m(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(91184);
        HashMap hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "convert native buffer parameter fail, event=" + str + ", error=native buffer exceed size limit");
        hashMap.put(SharePluginInfo.ISSUE_KEY_STACK, "");
        c2241c.mo6116bX("onError", new JSONObject(hashMap).toString());
        AppMethodBeat.m2505o(91184);
    }
}
