package com.tencent.p177mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsfs.C37945c;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C37710ek;
import com.tencent.p177mm.p230g.p231a.C45320eg;
import com.tencent.p177mm.p230g.p231a.C45333id;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.p177mm.plugin.exdevice.model.C38956j.C34038a;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.atq;
import com.tencent.p177mm.protocal.protobuf.atr;
import com.tencent.p177mm.protocal.protobuf.ats;
import com.tencent.p177mm.protocal.protobuf.att;
import com.tencent.p177mm.protocal.protobuf.atu;
import com.tencent.p177mm.protocal.protobuf.atv;
import com.tencent.p177mm.protocal.protobuf.atw;
import com.tencent.p177mm.protocal.protobuf.cin;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.exdevice.model.g */
public final class C20528g implements C1202f {
    String cEZ;
    long eFm;
    long edW;
    String fFa = "";
    public C1628a fFk = new C68542();
    int lsA;
    String lsB = "send_data_sucess";
    String lsC = "send_data_failed";
    private String lsD = "send_data_sending";
    boolean lsE = false;
    boolean lsF = false;
    public HashMap<String, String> lsG = new HashMap();
    atr lsH;
    long lsI;
    List<C11648b> lsJ = null;
    List<C11648b> lsK = new ArrayList();
    HashMap<String, String> lsL = new HashMap();
    HashMap<String, Integer> lsM = new HashMap();
    HashMap<String, Boolean> lsN = new HashMap();
    C34038a lsO;
    C34038a lsP;
    C34038a lsQ;
    C34038a lsR;
    Runnable lsS = new C205301();
    atr lsT;
    String lsU;
    String lsV;
    int lsW;
    HashMap<Integer, String> lsX = new HashMap();
    boolean lsv = false;
    boolean lsw = false;
    boolean lsx = false;
    String lsy;
    String lsz;

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$3 */
    class C29853 implements C34038a {
        C29853() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            int i2;
            JSONException e;
            AppMethodBeat.m2504i(19253);
            if (i == 15 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                int intValue = ((Integer) objArr[0]).intValue();
                try {
                    C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", new String((byte[]) objArr[1]));
                    int i3 = new JSONObject(r1).getInt("progress");
                    try {
                        C20528g.m31716a(C20528g.this, (String) C20528g.this.lsX.get(Integer.valueOf(intValue)), i3);
                        if (i3 >= 100) {
                            C20528g.this.lsX.remove(Integer.valueOf(intValue));
                        }
                        i2 = i3;
                    } catch (JSONException e2) {
                        e = e2;
                        i2 = i3;
                        C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", e);
                        C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                        AppMethodBeat.m2505o(19253);
                        return;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    i2 = 0;
                }
                C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                AppMethodBeat.m2505o(19253);
                return;
            }
            AppMethodBeat.m2505o(19253);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$2 */
    class C68542 implements C1628a {
        C68542() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(19250);
            C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", C20528g.this.fFa, Integer.valueOf(i), c18496c, c9545d, Boolean.valueOf(C20528g.this.lsE));
            if (c18496c != null) {
                try {
                    int i2;
                    int i3 = (int) ((((float) c18496c.field_finishedLength) / ((float) c18496c.field_toltalLength)) * 100.0f);
                    C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", Integer.valueOf(i3));
                    if (i3 >= 100) {
                        i2 = 99;
                    } else {
                        i2 = i3;
                    }
                    for (String a : C20528g.this.lsG.keySet()) {
                        C20528g.m31716a(C20528g.this, a, i2);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", e);
                    AppMethodBeat.m2505o(19250);
                }
            }
            if (c9545d != null) {
                if (C20528g.this.lsE) {
                    atr atr = new atr();
                    C20528g.this.mo35812a(atr, C20528g.this.edW);
                    C20528g.this.lsE = false;
                    if (C20528g.m31721hJ(C20528g.this.edW).booleanValue() || C20528g.m31722hK(C20528g.this.edW).booleanValue()) {
                        atr.wxK.vRw = c9545d.field_aesKey;
                        atr.wxK.wxO = C20528g.this.lsI;
                        atr.wxK.vRA = c9545d.field_fileId;
                        atr.wxK.Url = c9545d.field_fileUrl;
                        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", atr.wxK.Url);
                    } else if (C20528g.m31720hI(C20528g.this.edW).booleanValue()) {
                        atr.wxL.vRw = c9545d.field_aesKey;
                        atr.wxL.vRA = c9545d.field_fileId;
                        atr.wxL.Url = c9545d.field_fileUrl;
                        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", atr.wxL.Url);
                    } else if (C20528g.m31723hL(C20528g.this.edW).booleanValue()) {
                        atr.wxN.Url = c9545d.field_fileUrl;
                        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", atr.wxN.Url);
                    }
                    C20528g.this.lsH = atr;
                    for (String a2 : C20528g.this.lsG.keySet()) {
                        C9638aw.m17182Rg().mo14541a(new C20535n(atr, (String) C20528g.this.lsG.get(a2), a2, 1), 0);
                    }
                    C20528g.this.lsG.clear();
                }
            }
            AppMethodBeat.m2505o(19250);
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.m2504i(19251);
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(19251);
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            AppMethodBeat.m2504i(19252);
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
            AppMethodBeat.m2505o(19252);
            return bArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$8 */
    class C205298 implements Runnable {
        C205298() {
        }

        public final void run() {
            AppMethodBeat.m2504i(19258);
            C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
            Java2CExDevice.releaseWCLanDeviceLib();
            AppMethodBeat.m2505o(19258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$1 */
    class C205301 implements Runnable {
        C205301() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5 A:{SYNTHETIC, Splitter:B:38:0x00e5} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            int i;
            ats ats;
            String str;
            String str2;
            String str3;
            AppMethodBeat.m2504i(19249);
            try {
                String str4 = C6457e.evi + String.format("%s%d.%s", new Object[]{"image", Integer.valueOf(C20528g.this.cEZ.hashCode()), "jpg"});
                byte[] Kh = C20528g.m31715Kh(C20528g.this.cEZ);
                if (Kh != null) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(Kh, 0, Kh.length);
                    C20528g c20528g = C20528g.this;
                    OutputStream L;
                    try {
                        L = C5730e.m8617L(str4, false);
                        try {
                            decodeByteArray.compress(CompressFormat.JPEG, 80, L);
                            L.flush();
                            if (L != null) {
                                try {
                                    L.close();
                                } catch (IOException e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            try {
                                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                                C20528g.m31719dQ(c20528g.lsV, c20528g.lsC);
                                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                                if (L != null) {
                                    try {
                                        L.close();
                                    } catch (IOException e22) {
                                        C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                    }
                                }
                                C20528g.this.lsz = str4;
                                if (C20528g.this.lsz == null) {
                                }
                                i = -1;
                                ats = new ats();
                                str = C20528g.this.lsz;
                                if (str != null) {
                                }
                                str = null;
                                str2 = null;
                                str3 = null;
                                ats.Type = str;
                                ats.Name = str2;
                                ats.jCo = i;
                                ats.Md5 = str3;
                                C20528g.this.lsT.wxK = ats;
                                C20528g.this.lsT.wxH = 3;
                                C9638aw.m17182Rg().mo14541a(new C20535n(C20528g.this.lsT, C20528g.this.lsU, C20528g.this.lsV, C20528g.this.lsW), 0);
                                AppMethodBeat.m2505o(19249);
                                return;
                            } catch (Throwable th) {
                                e = th;
                                if (L != null) {
                                    try {
                                        L.close();
                                    } catch (IOException e4) {
                                        C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e4, "", new Object[0]);
                                    }
                                }
                                AppMethodBeat.m2505o(19249);
                                throw e;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        L = null;
                    } catch (Throwable th2) {
                        e = th2;
                        L = null;
                        if (L != null) {
                        }
                        AppMethodBeat.m2505o(19249);
                        throw e;
                    }
                    C20528g.this.lsz = str4;
                    if (C20528g.this.lsz == null || C5730e.m8628ct(C20528g.this.lsz)) {
                        i = -1;
                        ats = new ats();
                        str = C20528g.this.lsz;
                        if (str != null || str.length() <= 0) {
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            C5728b c5728b = new C5728b(str);
                            str2 = c5728b.getName();
                            i = (int) c5728b.length();
                            String substring = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
                            str3 = C5730e.atg(str);
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable filePath %s", str);
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileSize %s", Integer.valueOf(i));
                            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileMd5 %s", str3);
                            str = substring;
                        }
                        ats.Type = str;
                        ats.Name = str2;
                        ats.jCo = i;
                        ats.Md5 = str3;
                        C20528g.this.lsT.wxK = ats;
                        C20528g.this.lsT.wxH = 3;
                        C9638aw.m17182Rg().mo14541a(new C20535n(C20528g.this.lsT, C20528g.this.lsU, C20528g.this.lsV, C20528g.this.lsW), 0);
                        AppMethodBeat.m2505o(19249);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mSnsImagePath is null or file not exist!");
                    C20528g.m31719dQ(C20528g.this.lsV, C20528g.this.lsC);
                    AppMethodBeat.m2505o(19249);
                    return;
                }
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get image error !");
                C20528g.m31719dQ(C20528g.this.lsV, C20528g.this.lsC);
                AppMethodBeat.m2505o(19249);
            } catch (Exception e6) {
                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e6, "", new Object[0]);
                AppMethodBeat.m2505o(19249);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$7 */
    class C205317 implements C5015a {
        C205317() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(19257);
            int size = C20528g.this.lsJ.size();
            int i = 0;
            while (i < size) {
                if (((C11648b) C20528g.this.lsJ.get(i)).dFr.contains("internet_to_device") && ((C11648b) C20528g.this.lsJ.get(i)).dFr.contains("wechat_to_device") && !C20528g.this.lsK.contains(C20528g.this.lsJ.get(i))) {
                    C20528g.this.lsK.add(C20528g.this.lsJ.get(i));
                    C20528g.m31717bx(C20528g.this.lsK);
                }
                i++;
            }
            AppMethodBeat.m2505o(19257);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$4 */
    class C205324 implements C34038a {
        C205324() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            Exception e;
            JSONObject jSONObject;
            JSONObject jSONObject2 = null;
            AppMethodBeat.m2504i(19254);
            if (i != 14 || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof byte[])) {
                AppMethodBeat.m2505o(19254);
                return;
            }
            JSONObject jSONObject3;
            Object string;
            try {
                JSONObject jSONObject4 = new JSONObject(new String((byte[]) objArr[0]));
                jSONObject3 = jSONObject4.getJSONObject("deviceInfo");
                try {
                    string = jSONObject3.getString("deviceType");
                    try {
                        jSONObject2 = jSONObject3.getString("deviceId");
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject = jSONObject2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    jSONObject = jSONObject2;
                    JSONObject string2 = jSONObject2;
                }
                JSONObject jSONObject5;
                int size;
                int i2;
                try {
                    if (jSONObject4.isNull(Scopes.PROFILE)) {
                        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
                        AppMethodBeat.m2505o(19254);
                        return;
                    }
                    JSONArray jSONArray = jSONObject4.getJSONArray(Scopes.PROFILE);
                    C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", jSONArray.toString());
                    jSONObject5 = jSONObject3;
                    if (!(string2 == null || r2 == null)) {
                        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", string2, r2);
                    }
                    size = C20528g.this.lsJ.size();
                    i2 = 0;
                    while (i2 < size) {
                        if (((C11648b) C20528g.this.lsJ.get(i2)).field_deviceID.equals(r2) && ((C11648b) C20528g.this.lsJ.get(i2)).field_deviceType.equals(string2) && ((C11648b) C20528g.this.lsJ.get(i2)).dFr.contains("wechat_to_device") && !C20528g.this.lsK.contains(C20528g.this.lsJ.get(i2))) {
                            C20528g.this.lsL.put(r2, jSONObject5.toString());
                            C20528g.this.lsK.add(C20528g.this.lsJ.get(i2));
                            C20528g.m31717bx(C20528g.this.lsK);
                        }
                        i2++;
                    }
                    AppMethodBeat.m2505o(19254);
                } catch (Exception e4) {
                    e = e4;
                    jSONObject = jSONObject2;
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", e);
                    jSONObject5 = jSONObject3;
                    jSONObject2 = jSONObject;
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", string2, r2);
                    size = C20528g.this.lsJ.size();
                    i2 = 0;
                    while (i2 < size) {
                    }
                    AppMethodBeat.m2505o(19254);
                }
            } catch (Exception e5) {
                e = e5;
                jSONObject3 = jSONObject2;
                jSONObject = jSONObject2;
                string2 = jSONObject2;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$6 */
    class C205336 implements C34038a {
        C205336() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            AppMethodBeat.m2504i(19256);
            if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                String str = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                Object obj = null;
                try {
                    JSONObject jSONObject = new JSONObject(new String(str));
                    obj = jSONObject.getString("deviceId");
                    jSONObject.getString("deviceType");
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
                }
                switch (intValue) {
                    case -2:
                    case -1:
                    case 0:
                        C20528g.this.lsN.put(obj, Boolean.FALSE);
                        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = ".concat(String.valueOf(intValue)));
                        AppMethodBeat.m2505o(19256);
                        return;
                    case 1:
                        C20528g.this.lsN.put(obj, Boolean.TRUE);
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
                        break;
                }
                AppMethodBeat.m2505o(19256);
                return;
            }
            AppMethodBeat.m2505o(19256);
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.g$5 */
    class C205345 implements C34038a {
        C205345() {
        }

        /* renamed from: g */
        public final void mo7189g(int i, Object... objArr) {
            AppMethodBeat.m2504i(19255);
            if (i == 12 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                int intValue = ((Integer) objArr[0]).intValue();
                byte[] bArr = (byte[]) objArr[1];
                if (intValue > 0) {
                    String str = (String) C20528g.this.lsX.get(Integer.valueOf(intValue));
                    if (str != null) {
                        try {
                            C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new String(bArr));
                            JSONObject jSONObject = new JSONObject(r2);
                            if (jSONObject.isNull("errcode") || jSONObject.getInt("errcode") == 0) {
                                C20528g.m31719dQ(str, C20528g.this.lsB);
                                C4990ab.m7410d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
                                AppMethodBeat.m2505o(19255);
                                return;
                            }
                            C20528g.m31719dQ(str, C20528g.this.lsC);
                            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", r2);
                            AppMethodBeat.m2505o(19255);
                            return;
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", e);
                            AppMethodBeat.m2505o(19255);
                            return;
                        }
                    }
                }
                C4990ab.m7410d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =".concat(String.valueOf(intValue)));
                AppMethodBeat.m2505o(19255);
                return;
            }
            AppMethodBeat.m2505o(19255);
        }
    }

    public C20528g() {
        AppMethodBeat.m2504i(19259);
        this.lsK.clear();
        this.lsL.clear();
        this.lsN.clear();
        this.lsJ = C45891ad.boW().bpA();
        if (this.lsJ != null && this.lsJ.size() > 0) {
            C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", Integer.valueOf(this.lsJ.size()));
            int size = this.lsJ.size();
            int i = 0;
            while (i < size) {
                if (((C11648b) this.lsJ.get(i)).dFr.contains("internet_to_device") && !((C11648b) this.lsJ.get(i)).dFr.contains("wechat_to_device")) {
                    this.lsK.add(this.lsJ.get(i));
                }
                i++;
            }
            this.lsR = new C29853();
            this.lsO = new C205324();
            this.lsP = new C205345();
            this.lsQ = new C205336();
            C9638aw.m17182Rg().mo14539a(1717, (C1202f) this);
            C38956j.boN().mo61836a(14, this.lsO);
            C38956j.boN().mo61836a(12, this.lsP);
            C38956j.boN().mo61836a(13, this.lsQ);
            C38956j.boN().mo61836a(15, this.lsR);
            C4990ab.m7410d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
        AppMethodBeat.m2505o(19259);
    }

    /* renamed from: hI */
    static Boolean m31720hI(long j) {
        AppMethodBeat.m2504i(19260);
        boolean z = false;
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(19260);
            return bool;
        }
        String str = jf.field_content;
        if (jf.getType() == 49) {
            C8910b me = C8910b.m16064me(str);
            if (me != null && me.type == 6) {
                z = true;
            }
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.m2505o(19260);
        return bool;
    }

    /* renamed from: hJ */
    static Boolean m31721hJ(long j) {
        AppMethodBeat.m2504i(19261);
        boolean z = false;
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(19261);
            return bool;
        }
        if (jf.getType() == 3) {
            z = true;
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.m2505o(19261);
        return bool;
    }

    /* renamed from: hK */
    static Boolean m31722hK(long j) {
        AppMethodBeat.m2504i(19262);
        boolean z = false;
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(19262);
            return bool;
        }
        if (jf.dtA()) {
            z = true;
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.m2505o(19262);
        return bool;
    }

    /* renamed from: hL */
    static Boolean m31723hL(long j) {
        AppMethodBeat.m2504i(19263);
        boolean z = false;
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(19263);
            return bool;
        }
        if (jf.getType() == 62) {
            z = true;
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.m2505o(19263);
        return bool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df A:{SYNTHETIC, Splitter:B:54:0x00df} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e4 A:{SYNTHETIC, Splitter:B:57:0x00e4} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df A:{SYNTHETIC, Splitter:B:54:0x00df} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e4 A:{SYNTHETIC, Splitter:B:57:0x00e4} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df A:{SYNTHETIC, Splitter:B:54:0x00df} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e4 A:{SYNTHETIC, Splitter:B:57:0x00e4} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Kh */
    public static byte[] m31715Kh(String str) {
        Throwable e;
        byte[] bArr = null;
        AppMethodBeat.m2504i(19264);
        C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "url %s", str);
        C1936u a;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            a = C1897b.m4020a(str, null);
            try {
                a.setRequestMethod("GET");
                a.setConnectTimeout(25000);
                a.setReadTimeout(25000);
                inputStream = a.getInputStream();
                try {
                    if (a.getResponseCode() == 200) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            byteArrayOutputStream.close();
                            inputStream.close();
                            a.connection.disconnect();
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e22) {
                                    C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            a.connection.disconnect();
                            AppMethodBeat.m2505o(19264);
                        } catch (Exception e3) {
                            e = e3;
                        }
                        return bArr;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e222) {
                            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                        }
                    }
                    a.connection.disconnect();
                    AppMethodBeat.m2505o(19264);
                    return bArr;
                } catch (Exception e4) {
                    e = e4;
                    byteArrayOutputStream = bArr;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2222) {
                                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e22222) {
                                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.connection.disconnect();
                        }
                        AppMethodBeat.m2505o(19264);
                        return bArr;
                    } catch (Throwable th) {
                        e = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e5) {
                                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e5, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e52) {
                                C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e52, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.connection.disconnect();
                        }
                        AppMethodBeat.m2505o(19264);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    byteArrayOutputStream = bArr;
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (a != null) {
                    }
                    AppMethodBeat.m2505o(19264);
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
            } catch (Throwable th3) {
                e = th3;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (a != null) {
                }
                AppMethodBeat.m2505o(19264);
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
        } catch (Throwable th4) {
            e = th4;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (a != null) {
            }
            AppMethodBeat.m2505o(19264);
            throw e;
        }
    }

    public final TimeLineObject boL() {
        AppMethodBeat.m2504i(19265);
        C45333id c45333id = new C45333id();
        c45333id.cDc.cwT = this.lsy;
        C4879a.xxA.mo10055m(c45333id);
        TimeLineObject timeLineObject = c45333id.cDd.cDe;
        AppMethodBeat.m2505o(19265);
        return timeLineObject;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo35812a(atr atr, long j) {
        AppMethodBeat.m2504i(19266);
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String hM = m31724hM(j);
        if (hM != null && hM.length() > 0) {
            C5728b c5728b = new C5728b(hM);
            str2 = c5728b.getName();
            i = (int) c5728b.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = C5730e.atg(hM);
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", hM);
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", Integer.valueOf(i));
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", str);
        }
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        if (jf.field_msgId == 0) {
            C4990ab.m7410d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            AppMethodBeat.m2505o(19266);
            return false;
        }
        switch (jf.getType()) {
            case 3:
                ats ats = new ats();
                ats.Type = str3;
                ats.Name = str2;
                ats.jCo = i;
                ats.Md5 = str;
                atr.wxK = ats;
                atr.wxH = 3;
                break;
            case 48:
                C9638aw.m17190ZK();
                C5136b Ro = C18628c.m29080XO().mo15261Ro(jf.field_content);
                att att = new att();
                att.vOu = (float) Ro.nJu;
                att.vOv = (float) Ro.nJv;
                att.wxP = (float) Ro.cED;
                att.Label = Ro.label;
                att.wxQ = Ro.eUu;
                atr.wxJ = att;
                atr.wxH = 2;
                break;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
            case 268435505:
                C8910b me = C8910b.m16064me(jf.field_content);
                if (me != null) {
                    if (me.type != 3) {
                        if (me.type != 6) {
                            if (me.type != 5) {
                                if (me.type == 2) {
                                    ats ats2 = new ats();
                                    ats2.Type = "jpg";
                                    ats2.Name = str2;
                                    ats2.jCo = i;
                                    ats2.Md5 = str;
                                    atr.wxK = ats2;
                                    atr.wxH = 3;
                                    break;
                                }
                            }
                            atv atv = new atv();
                            atv.Url = me.url;
                            atv.Title = me.title;
                            atv.wxR = me.description;
                            atv.ncH = me.appName;
                            if (C5046bo.isNullOrNil(atv.ncH)) {
                                C40439f dX = C46494g.m87742dX(me.appId, me.axy);
                                if (dX != null) {
                                    atv.ncH = dX.field_appName;
                                }
                            }
                            atr.wxM = atv;
                            atr.wxH = 5;
                            break;
                        }
                        atq atq = new atq();
                        atq.Type = me.fgp;
                        atq.Name = me.title;
                        atq.jCo = i;
                        atq.Md5 = str;
                        atr.wxL = atq;
                        atr.wxH = 4;
                        break;
                    }
                    atu atu = new atu();
                    atu.Title = me.title;
                    atu.wxR = me.description;
                    atu.Url = me.url;
                    atu.wxS = me.fgn;
                    atu.vYK = me.fgM;
                    atu.wxT = me.fgN;
                    atu.ncH = me.appName;
                    if (C5046bo.isNullOrNil(atu.ncH)) {
                        C40439f dX2 = C46494g.m87742dX(me.appId, me.axy);
                        if (dX2 != null) {
                            atu.ncH = dX2.field_appName;
                        }
                    }
                    atu.wxU = me.fgE;
                    atu.wxV = me.fgF;
                    atu.wxW = me.fgK;
                    atr.wxI = atu;
                    atr.wxH = 1;
                    break;
                }
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                AppMethodBeat.m2505o(19266);
                return false;
                break;
            case 62:
                atw atw = new atw();
                atw.Type = str3;
                atw.jCo = i;
                atw.Md5 = str;
                atw.Name = str2;
                atr.wxN = atw;
                atr.wxH = 6;
                break;
        }
        AppMethodBeat.m2505o(19266);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e0 A:{SYNTHETIC, Splitter:B:42:0x00e0} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e8 A:{SYNTHETIC, Splitter:B:45:0x00e8} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077 A:{SYNTHETIC, Splitter:B:19:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f A:{SYNTHETIC, Splitter:B:22:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e0 A:{SYNTHETIC, Splitter:B:42:0x00e0} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e8 A:{SYNTHETIC, Splitter:B:45:0x00e8} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077 A:{SYNTHETIC, Splitter:B:19:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f A:{SYNTHETIC, Splitter:B:22:0x007f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: B */
    static String m31714B(String str, long j) {
        OutputStream c37945c;
        InputStream openRead;
        IOException e;
        Throwable th;
        AppMethodBeat.m2504i(19267);
        if (str == null) {
            AppMethodBeat.m2505o(19267);
            return null;
        }
        String substring = str.substring(0, str.lastIndexOf("/"));
        substring = substring + "/" + ("image_hd_" + str.hashCode());
        try {
            c37945c = new C37945c(new C5728b(substring), j);
            try {
                openRead = C5730e.openRead(str);
            } catch (IOException e2) {
                e = e2;
                openRead = null;
                try {
                    C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e.getMessage());
                    if (c37945c != null) {
                        try {
                            c37945c.flush();
                            c37945c.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3, "", new Object[0]);
                            AppMethodBeat.m2505o(19267);
                            return null;
                        }
                    }
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e32) {
                            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32, "", new Object[0]);
                            AppMethodBeat.m2505o(19267);
                            return null;
                        }
                    }
                    AppMethodBeat.m2505o(19267);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (c37945c != null) {
                    }
                    if (openRead != null) {
                    }
                    AppMethodBeat.m2505o(19267);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                openRead = null;
                if (c37945c != null) {
                    try {
                        c37945c.flush();
                        c37945c.close();
                    } catch (IOException e322) {
                        C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322, "", new Object[0]);
                        AppMethodBeat.m2505o(19267);
                        return null;
                    }
                }
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e3222) {
                        C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222, "", new Object[0]);
                        AppMethodBeat.m2505o(19267);
                        return null;
                    }
                }
                AppMethodBeat.m2505o(19267);
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (openRead.read(bArr) != -1) {
                    c37945c.write(bArr);
                }
                try {
                    c37945c.flush();
                    c37945c.close();
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e32222) {
                            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222, "", new Object[0]);
                            AppMethodBeat.m2505o(19267);
                            return null;
                        }
                    }
                    AppMethodBeat.m2505o(19267);
                    return substring;
                } catch (IOException e322222) {
                    C4990ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222, "", new Object[0]);
                    AppMethodBeat.m2505o(19267);
                    return null;
                }
            } catch (IOException e4) {
                e322222 = e4;
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e322222.getMessage());
                if (c37945c != null) {
                }
                if (openRead != null) {
                }
                AppMethodBeat.m2505o(19267);
                return null;
            }
        } catch (IOException e5) {
            e322222 = e5;
            openRead = null;
            c37945c = null;
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e322222.getMessage());
            if (c37945c != null) {
            }
            if (openRead != null) {
            }
            AppMethodBeat.m2505o(19267);
            return null;
        } catch (Throwable th4) {
            th = th4;
            openRead = null;
            c37945c = null;
            if (c37945c != null) {
            }
            if (openRead != null) {
            }
            AppMethodBeat.m2505o(19267);
            throw th;
        }
    }

    /* renamed from: hM */
    private String m31724hM(long j) {
        AppMethodBeat.m2504i(19268);
        String str = "";
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
        if (jf.field_msgId == 0) {
            str = "";
            AppMethodBeat.m2505o(19268);
            return str;
        }
        int type = jf.getType();
        String str2 = jf.field_content;
        if (jf.bAA()) {
            C8910b me = C8910b.m16064me(str2);
            if (me != null && (me.type == 6 || me.type == 2)) {
                C30065b aiE = C14877am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                } else {
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                }
            } else if (me != null && (me.type == 3 || me.type == 5)) {
                this.lsw = true;
            }
        } else if (type == 3) {
            C25822e w = C32291o.ahl().mo73124w(jf);
            if (w != null) {
                str = C32291o.ahl().mo73119sj(w.fDz);
                if (C5046bo.isNullOrNil(str)) {
                    str = C32291o.ahl().mo73119sj(w.fDB);
                }
            }
        } else if (type == 62) {
            C37961o.all();
            str = C9720t.m17303uh(jf.field_imgPath);
        } else if (type == 48) {
            this.lsw = true;
        }
        AppMethodBeat.m2505o(19268);
        return str;
    }

    /* renamed from: dQ */
    static void m31719dQ(String str, String str2) {
        AppMethodBeat.m2504i(19269);
        C37710ek c37710ek = new C37710ek();
        c37710ek.cxU.cxW = str2;
        c37710ek.cxU.ceI = str;
        C4879a.xxA.mo10055m(c37710ek);
        AppMethodBeat.m2505o(19269);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19270);
        C4990ab.m7411d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
            AppMethodBeat.m2505o(19270);
            return;
        }
        if (c1207m instanceof C20535n) {
            C20535n c20535n = (C20535n) c1207m;
            if (i == 0 && i2 == 0) {
                cin cin;
                if (c20535n.ehh == null || c20535n.ehh.fsH.fsP == null) {
                    cin = null;
                } else {
                    cin = (cin) c20535n.ehh.fsH.fsP;
                }
                String str2 = cin.xhu;
                if (1 == c20535n.ltE) {
                    C20528g.m31719dQ(c20535n.ceI, this.lsB);
                    AppMethodBeat.m2505o(19270);
                    return;
                }
                String hM;
                String str3 = c20535n.ceI;
                String str4 = (String) this.lsL.get(str3);
                C20528g.m31719dQ(str3, this.lsD);
                if (!this.lsx || this.lsy == null) {
                    hM = m31724hM(this.edW);
                } else {
                    hM = this.lsz;
                }
                if (str4 == null || str4.length() == 0) {
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    C20528g.m31719dQ(str3, this.lsC);
                    AppMethodBeat.m2505o(19270);
                    return;
                }
                if (!this.lsv) {
                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.lsv = true;
                }
                if (!(this.lsN.containsKey(str3) && ((Boolean) this.lsN.get(str3)).booleanValue())) {
                    C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: ".concat(String.valueOf(str4)));
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        C20528g.m31719dQ(str3, this.lsC);
                        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                int useWCLanDeviceService;
                if (this.lsw) {
                    useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lsX.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lsM.put(str3, Integer.valueOf(useWCLanDeviceService));
                        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: ".concat(String.valueOf(useWCLanDeviceService)));
                        AppMethodBeat.m2505o(19270);
                        return;
                    }
                    C20528g.m31719dQ(str3, this.lsC);
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    AppMethodBeat.m2505o(19270);
                    return;
                } else if (hM == null || hM.length() == 0) {
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    C20528g.m31719dQ(str3, this.lsC);
                    AppMethodBeat.m2505o(19270);
                    return;
                } else {
                    useWCLanDeviceService = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), hM.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lsX.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lsM.put(str3, Integer.valueOf(useWCLanDeviceService));
                        C4990ab.m7410d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =".concat(String.valueOf(useWCLanDeviceService)));
                        AppMethodBeat.m2505o(19270);
                        return;
                    }
                    C20528g.m31719dQ(str3, this.lsC);
                    C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                }
            } else {
                C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                C20528g.m31719dQ(c20535n.ceI, this.lsC);
                AppMethodBeat.m2505o(19270);
                return;
            }
        }
        AppMethodBeat.m2505o(19270);
    }

    /* renamed from: c */
    static String m31718c(C11648b c11648b) {
        AppMethodBeat.m2504i(19271);
        String str;
        if (c11648b == null) {
            str = "";
            AppMethodBeat.m2505o(19271);
            return str;
        }
        str = null;
        if (!C5046bo.isNullOrNil(c11648b.dFl)) {
            str = c11648b.dFl;
        } else if (!C5046bo.isNullOrNil(c11648b.dFm)) {
            str = c11648b.dFm;
        } else if (c11648b.field_mac != 0) {
            str = C42992b.m76358ie(c11648b.field_mac);
        } else if (!C5046bo.isNullOrNil(c11648b.field_deviceID)) {
            str = c11648b.field_deviceID;
        }
        str = C5046bo.nullAsNil(str);
        AppMethodBeat.m2505o(19271);
        return str;
    }

    /* renamed from: a */
    static /* synthetic */ void m31716a(C20528g c20528g, String str, int i) {
        AppMethodBeat.m2504i(19272);
        C37710ek c37710ek = new C37710ek();
        c37710ek.cxU.ceI = str;
        if (i >= 100) {
            c37710ek.cxU.cxW = c20528g.lsB;
        } else {
            c37710ek.cxU.cxW = c20528g.lsD;
        }
        c37710ek.cxU.progress = i;
        C4879a.xxA.mo10055m(c37710ek);
        AppMethodBeat.m2505o(19272);
    }

    /* renamed from: bx */
    static /* synthetic */ void m31717bx(List list) {
        AppMethodBeat.m2504i(19273);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((C11648b) list.get(i)).field_deviceType);
            hashMap.put("deviceID", ((C11648b) list.get(i)).field_deviceID);
            hashMap.put("displayName", C20528g.m31718c((C11648b) list.get(i)));
            hashMap.put("iconUrl", ((C11648b) list.get(i)).iconUrl);
            hashMap.put("ability", ((C11648b) list.get(i)).dFr);
            hashMap.put("abilityInf", ((C11648b) list.get(i)).dFs);
            arrayList.add(hashMap);
        }
        C45320eg c45320eg = new C45320eg();
        c45320eg.cxJ.cwW = arrayList;
        C4879a.xxA.mo10055m(c45320eg);
        AppMethodBeat.m2505o(19273);
    }
}
