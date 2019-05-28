package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.id;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
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

public final class g implements f {
    String cEZ;
    long eFm;
    long edW;
    String fFa = "";
    public a fFk = new a() {
        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(19250);
            ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", g.this.fFa, Integer.valueOf(i), cVar, dVar, Boolean.valueOf(g.this.lsE));
            if (cVar != null) {
                try {
                    int i2;
                    int i3 = (int) ((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f);
                    ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", Integer.valueOf(i3));
                    if (i3 >= 100) {
                        i2 = 99;
                    } else {
                        i2 = i3;
                    }
                    for (String a : g.this.lsG.keySet()) {
                        g.a(g.this, a, i2);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", e);
                    AppMethodBeat.o(19250);
                }
            }
            if (dVar != null) {
                if (g.this.lsE) {
                    atr atr = new atr();
                    g.this.a(atr, g.this.edW);
                    g.this.lsE = false;
                    if (g.hJ(g.this.edW).booleanValue() || g.hK(g.this.edW).booleanValue()) {
                        atr.wxK.vRw = dVar.field_aesKey;
                        atr.wxK.wxO = g.this.lsI;
                        atr.wxK.vRA = dVar.field_fileId;
                        atr.wxK.Url = dVar.field_fileUrl;
                        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", atr.wxK.Url);
                    } else if (g.hI(g.this.edW).booleanValue()) {
                        atr.wxL.vRw = dVar.field_aesKey;
                        atr.wxL.vRA = dVar.field_fileId;
                        atr.wxL.Url = dVar.field_fileUrl;
                        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", atr.wxL.Url);
                    } else if (g.hL(g.this.edW).booleanValue()) {
                        atr.wxN.Url = dVar.field_fileUrl;
                        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", atr.wxN.Url);
                    }
                    g.this.lsH = atr;
                    for (String a2 : g.this.lsG.keySet()) {
                        aw.Rg().a(new n(atr, (String) g.this.lsG.get(a2), a2, 1), 0);
                    }
                    g.this.lsG.clear();
                }
            }
            AppMethodBeat.o(19250);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(19251);
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(19251);
        }

        public final byte[] l(String str, byte[] bArr) {
            AppMethodBeat.i(19252);
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
            AppMethodBeat.o(19252);
            return bArr;
        }
    };
    int lsA;
    String lsB = "send_data_sucess";
    String lsC = "send_data_failed";
    private String lsD = "send_data_sending";
    boolean lsE = false;
    boolean lsF = false;
    public HashMap<String, String> lsG = new HashMap();
    atr lsH;
    long lsI;
    List<b> lsJ = null;
    List<b> lsK = new ArrayList();
    HashMap<String, String> lsL = new HashMap();
    HashMap<String, Integer> lsM = new HashMap();
    HashMap<String, Boolean> lsN = new HashMap();
    j.a lsO;
    j.a lsP;
    j.a lsQ;
    j.a lsR;
    Runnable lsS = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5 A:{SYNTHETIC, Splitter:B:38:0x00e5} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            int i;
            ats ats;
            String str;
            String str2;
            String str3;
            AppMethodBeat.i(19249);
            try {
                String str4 = e.evi + String.format("%s%d.%s", new Object[]{"image", Integer.valueOf(g.this.cEZ.hashCode()), "jpg"});
                byte[] Kh = g.Kh(g.this.cEZ);
                if (Kh != null) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(Kh, 0, Kh.length);
                    g gVar = g.this;
                    OutputStream L;
                    try {
                        L = com.tencent.mm.vfs.e.L(str4, false);
                        try {
                            decodeByteArray.compress(CompressFormat.JPEG, 80, L);
                            L.flush();
                            if (L != null) {
                                try {
                                    L.close();
                                } catch (IOException e2) {
                                    ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            try {
                                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                                g.dQ(gVar.lsV, gVar.lsC);
                                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                                if (L != null) {
                                    try {
                                        L.close();
                                    } catch (IOException e22) {
                                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                    }
                                }
                                g.this.lsz = str4;
                                if (g.this.lsz == null) {
                                }
                                i = -1;
                                ats = new ats();
                                str = g.this.lsz;
                                if (str != null) {
                                }
                                str = null;
                                str2 = null;
                                str3 = null;
                                ats.Type = str;
                                ats.Name = str2;
                                ats.jCo = i;
                                ats.Md5 = str3;
                                g.this.lsT.wxK = ats;
                                g.this.lsT.wxH = 3;
                                aw.Rg().a(new n(g.this.lsT, g.this.lsU, g.this.lsV, g.this.lsW), 0);
                                AppMethodBeat.o(19249);
                                return;
                            } catch (Throwable th) {
                                e = th;
                                if (L != null) {
                                    try {
                                        L.close();
                                    } catch (IOException e4) {
                                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e4, "", new Object[0]);
                                    }
                                }
                                AppMethodBeat.o(19249);
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
                        AppMethodBeat.o(19249);
                        throw e;
                    }
                    g.this.lsz = str4;
                    if (g.this.lsz == null || com.tencent.mm.vfs.e.ct(g.this.lsz)) {
                        i = -1;
                        ats = new ats();
                        str = g.this.lsz;
                        if (str != null || str.length() <= 0) {
                            str = null;
                            str2 = null;
                            str3 = null;
                        } else {
                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
                            str2 = bVar.getName();
                            i = (int) bVar.length();
                            String substring = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
                            str3 = com.tencent.mm.vfs.e.atg(str);
                            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable filePath %s", str);
                            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileSize %s", Integer.valueOf(i));
                            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileMd5 %s", str3);
                            str = substring;
                        }
                        ats.Type = str;
                        ats.Name = str2;
                        ats.jCo = i;
                        ats.Md5 = str3;
                        g.this.lsT.wxK = ats;
                        g.this.lsT.wxH = 3;
                        aw.Rg().a(new n(g.this.lsT, g.this.lsU, g.this.lsV, g.this.lsW), 0);
                        AppMethodBeat.o(19249);
                        return;
                    }
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mSnsImagePath is null or file not exist!");
                    g.dQ(g.this.lsV, g.this.lsC);
                    AppMethodBeat.o(19249);
                    return;
                }
                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get image error !");
                g.dQ(g.this.lsV, g.this.lsC);
                AppMethodBeat.o(19249);
            } catch (Exception e6) {
                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e6, "", new Object[0]);
                AppMethodBeat.o(19249);
            }
        }
    };
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

    public g() {
        AppMethodBeat.i(19259);
        this.lsK.clear();
        this.lsL.clear();
        this.lsN.clear();
        this.lsJ = ad.boW().bpA();
        if (this.lsJ != null && this.lsJ.size() > 0) {
            ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", Integer.valueOf(this.lsJ.size()));
            int size = this.lsJ.size();
            int i = 0;
            while (i < size) {
                if (((b) this.lsJ.get(i)).dFr.contains("internet_to_device") && !((b) this.lsJ.get(i)).dFr.contains("wechat_to_device")) {
                    this.lsK.add(this.lsJ.get(i));
                }
                i++;
            }
            this.lsR = new j.a() {
                public final void g(int i, Object... objArr) {
                    int i2;
                    JSONException e;
                    AppMethodBeat.i(19253);
                    if (i == 15 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        try {
                            ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", new String((byte[]) objArr[1]));
                            int i3 = new JSONObject(r1).getInt("progress");
                            try {
                                g.a(g.this, (String) g.this.lsX.get(Integer.valueOf(intValue)), i3);
                                if (i3 >= 100) {
                                    g.this.lsX.remove(Integer.valueOf(intValue));
                                }
                                i2 = i3;
                            } catch (JSONException e2) {
                                e = e2;
                                i2 = i3;
                                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", e);
                                ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                                AppMethodBeat.o(19253);
                                return;
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            i2 = 0;
                        }
                        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                        AppMethodBeat.o(19253);
                        return;
                    }
                    AppMethodBeat.o(19253);
                }
            };
            this.lsO = new j.a() {
                /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void g(int i, Object... objArr) {
                    Exception e;
                    JSONObject jSONObject;
                    JSONObject jSONObject2 = null;
                    AppMethodBeat.i(19254);
                    if (i != 14 || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof byte[])) {
                        AppMethodBeat.o(19254);
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
                                ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
                                AppMethodBeat.o(19254);
                                return;
                            }
                            JSONArray jSONArray = jSONObject4.getJSONArray(Scopes.PROFILE);
                            ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", jSONArray.toString());
                            jSONObject5 = jSONObject3;
                            if (!(string2 == null || r2 == null)) {
                                ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", string2, r2);
                            }
                            size = g.this.lsJ.size();
                            i2 = 0;
                            while (i2 < size) {
                                if (((b) g.this.lsJ.get(i2)).field_deviceID.equals(r2) && ((b) g.this.lsJ.get(i2)).field_deviceType.equals(string2) && ((b) g.this.lsJ.get(i2)).dFr.contains("wechat_to_device") && !g.this.lsK.contains(g.this.lsJ.get(i2))) {
                                    g.this.lsL.put(r2, jSONObject5.toString());
                                    g.this.lsK.add(g.this.lsJ.get(i2));
                                    g.bx(g.this.lsK);
                                }
                                i2++;
                            }
                            AppMethodBeat.o(19254);
                        } catch (Exception e4) {
                            e = e4;
                            jSONObject = jSONObject2;
                            ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", e);
                            jSONObject5 = jSONObject3;
                            jSONObject2 = jSONObject;
                            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", string2, r2);
                            size = g.this.lsJ.size();
                            i2 = 0;
                            while (i2 < size) {
                            }
                            AppMethodBeat.o(19254);
                        }
                    } catch (Exception e5) {
                        e = e5;
                        jSONObject3 = jSONObject2;
                        jSONObject = jSONObject2;
                        string2 = jSONObject2;
                    }
                }
            };
            this.lsP = new j.a() {
                public final void g(int i, Object... objArr) {
                    AppMethodBeat.i(19255);
                    if (i == 12 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        byte[] bArr = (byte[]) objArr[1];
                        if (intValue > 0) {
                            String str = (String) g.this.lsX.get(Integer.valueOf(intValue));
                            if (str != null) {
                                try {
                                    ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new String(bArr));
                                    JSONObject jSONObject = new JSONObject(r2);
                                    if (jSONObject.isNull("errcode") || jSONObject.getInt("errcode") == 0) {
                                        g.dQ(str, g.this.lsB);
                                        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
                                        AppMethodBeat.o(19255);
                                        return;
                                    }
                                    g.dQ(str, g.this.lsC);
                                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", r2);
                                    AppMethodBeat.o(19255);
                                    return;
                                } catch (JSONException e) {
                                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", e);
                                    AppMethodBeat.o(19255);
                                    return;
                                }
                            }
                        }
                        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =".concat(String.valueOf(intValue)));
                        AppMethodBeat.o(19255);
                        return;
                    }
                    AppMethodBeat.o(19255);
                }
            };
            this.lsQ = new j.a() {
                public final void g(int i, Object... objArr) {
                    AppMethodBeat.i(19256);
                    if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                        String str = (String) objArr[0];
                        int intValue = ((Integer) objArr[1]).intValue();
                        Object obj = null;
                        try {
                            JSONObject jSONObject = new JSONObject(new String(str));
                            obj = jSONObject.getString("deviceId");
                            jSONObject.getString("deviceType");
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                            ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
                        }
                        switch (intValue) {
                            case -2:
                            case -1:
                            case 0:
                                g.this.lsN.put(obj, Boolean.FALSE);
                                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = ".concat(String.valueOf(intValue)));
                                AppMethodBeat.o(19256);
                                return;
                            case 1:
                                g.this.lsN.put(obj, Boolean.TRUE);
                                ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
                                break;
                        }
                        AppMethodBeat.o(19256);
                        return;
                    }
                    AppMethodBeat.o(19256);
                }
            };
            aw.Rg().a(1717, (f) this);
            j.boN().a(14, this.lsO);
            j.boN().a(12, this.lsP);
            j.boN().a(13, this.lsQ);
            j.boN().a(15, this.lsR);
            ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
        AppMethodBeat.o(19259);
    }

    static Boolean hI(long j) {
        AppMethodBeat.i(19260);
        boolean z = false;
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(19260);
            return bool;
        }
        String str = jf.field_content;
        if (jf.getType() == 49) {
            j.b me = j.b.me(str);
            if (me != null && me.type == 6) {
                z = true;
            }
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.o(19260);
        return bool;
    }

    static Boolean hJ(long j) {
        AppMethodBeat.i(19261);
        boolean z = false;
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(19261);
            return bool;
        }
        if (jf.getType() == 3) {
            z = true;
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.o(19261);
        return bool;
    }

    static Boolean hK(long j) {
        AppMethodBeat.i(19262);
        boolean z = false;
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(19262);
            return bool;
        }
        if (jf.dtA()) {
            z = true;
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.o(19262);
        return bool;
    }

    static Boolean hL(long j) {
        AppMethodBeat.i(19263);
        boolean z = false;
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        Boolean bool;
        if (jf.field_msgId == 0) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(19263);
            return bool;
        }
        if (jf.getType() == 62) {
            z = true;
        }
        bool = Boolean.valueOf(z);
        AppMethodBeat.o(19263);
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
    public static byte[] Kh(String str) {
        Throwable e;
        byte[] bArr = null;
        AppMethodBeat.i(19264);
        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "url %s", str);
        u a;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            a = com.tencent.mm.network.b.a(str, null);
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
                                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e22) {
                                    ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            a.connection.disconnect();
                            AppMethodBeat.o(19264);
                        } catch (Exception e3) {
                            e = e3;
                        }
                        return bArr;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e222) {
                            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                        }
                    }
                    a.connection.disconnect();
                    AppMethodBeat.o(19264);
                    return bArr;
                } catch (Exception e4) {
                    e = e4;
                    byteArrayOutputStream = bArr;
                    try {
                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2222) {
                                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e22222) {
                                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.connection.disconnect();
                        }
                        AppMethodBeat.o(19264);
                        return bArr;
                    } catch (Throwable th) {
                        e = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e5) {
                                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e5, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e52) {
                                ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e52, "", new Object[0]);
                            }
                        }
                        if (a != null) {
                            a.connection.disconnect();
                        }
                        AppMethodBeat.o(19264);
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
                    AppMethodBeat.o(19264);
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
                AppMethodBeat.o(19264);
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
            AppMethodBeat.o(19264);
            throw e;
        }
    }

    public final TimeLineObject boL() {
        AppMethodBeat.i(19265);
        id idVar = new id();
        idVar.cDc.cwT = this.lsy;
        com.tencent.mm.sdk.b.a.xxA.m(idVar);
        TimeLineObject timeLineObject = idVar.cDd.cDe;
        AppMethodBeat.o(19265);
        return timeLineObject;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(atr atr, long j) {
        AppMethodBeat.i(19266);
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String hM = hM(j);
        if (hM != null && hM.length() > 0) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(hM);
            str2 = bVar.getName();
            i = (int) bVar.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = com.tencent.mm.vfs.e.atg(hM);
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", hM);
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", Integer.valueOf(i));
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", str);
        }
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        if (jf.field_msgId == 0) {
            ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            AppMethodBeat.o(19266);
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
                aw.ZK();
                bi.b Ro = com.tencent.mm.model.c.XO().Ro(jf.field_content);
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
                j.b me = j.b.me(jf.field_content);
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
                            if (bo.isNullOrNil(atv.ncH)) {
                                com.tencent.mm.pluginsdk.model.app.f dX = com.tencent.mm.pluginsdk.model.app.g.dX(me.appId, me.axy);
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
                    if (bo.isNullOrNil(atu.ncH)) {
                        com.tencent.mm.pluginsdk.model.app.f dX2 = com.tencent.mm.pluginsdk.model.app.g.dX(me.appId, me.axy);
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
                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                AppMethodBeat.o(19266);
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
        AppMethodBeat.o(19266);
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
    static String B(String str, long j) {
        OutputStream cVar;
        InputStream openRead;
        IOException e;
        Throwable th;
        AppMethodBeat.i(19267);
        if (str == null) {
            AppMethodBeat.o(19267);
            return null;
        }
        String substring = str.substring(0, str.lastIndexOf("/"));
        substring = substring + "/" + ("image_hd_" + str.hashCode());
        try {
            cVar = new com.tencent.mm.modelsfs.c(new com.tencent.mm.vfs.b(substring), j);
            try {
                openRead = com.tencent.mm.vfs.e.openRead(str);
            } catch (IOException e2) {
                e = e2;
                openRead = null;
                try {
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e.getMessage());
                    if (cVar != null) {
                        try {
                            cVar.flush();
                            cVar.close();
                        } catch (IOException e3) {
                            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3, "", new Object[0]);
                            AppMethodBeat.o(19267);
                            return null;
                        }
                    }
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e32) {
                            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32, "", new Object[0]);
                            AppMethodBeat.o(19267);
                            return null;
                        }
                    }
                    AppMethodBeat.o(19267);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                    }
                    if (openRead != null) {
                    }
                    AppMethodBeat.o(19267);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                openRead = null;
                if (cVar != null) {
                    try {
                        cVar.flush();
                        cVar.close();
                    } catch (IOException e322) {
                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322, "", new Object[0]);
                        AppMethodBeat.o(19267);
                        return null;
                    }
                }
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e3222) {
                        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222, "", new Object[0]);
                        AppMethodBeat.o(19267);
                        return null;
                    }
                }
                AppMethodBeat.o(19267);
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (openRead.read(bArr) != -1) {
                    cVar.write(bArr);
                }
                try {
                    cVar.flush();
                    cVar.close();
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e32222) {
                            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222, "", new Object[0]);
                            AppMethodBeat.o(19267);
                            return null;
                        }
                    }
                    AppMethodBeat.o(19267);
                    return substring;
                } catch (IOException e322222) {
                    ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222, "", new Object[0]);
                    AppMethodBeat.o(19267);
                    return null;
                }
            } catch (IOException e4) {
                e322222 = e4;
                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e322222.getMessage());
                if (cVar != null) {
                }
                if (openRead != null) {
                }
                AppMethodBeat.o(19267);
                return null;
            }
        } catch (IOException e5) {
            e322222 = e5;
            openRead = null;
            cVar = null;
            ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", e322222.getMessage());
            if (cVar != null) {
            }
            if (openRead != null) {
            }
            AppMethodBeat.o(19267);
            return null;
        } catch (Throwable th4) {
            th = th4;
            openRead = null;
            cVar = null;
            if (cVar != null) {
            }
            if (openRead != null) {
            }
            AppMethodBeat.o(19267);
            throw th;
        }
    }

    private String hM(long j) {
        AppMethodBeat.i(19268);
        String str = "";
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(j);
        if (jf.field_msgId == 0) {
            str = "";
            AppMethodBeat.o(19268);
            return str;
        }
        int type = jf.getType();
        String str2 = jf.field_content;
        if (jf.bAA()) {
            j.b me = j.b.me(str2);
            if (me != null && (me.type == 6 || me.type == 2)) {
                com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                } else {
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                }
            } else if (me != null && (me.type == 3 || me.type == 5)) {
                this.lsw = true;
            }
        } else if (type == 3) {
            com.tencent.mm.at.e w = o.ahl().w(jf);
            if (w != null) {
                str = o.ahl().sj(w.fDz);
                if (bo.isNullOrNil(str)) {
                    str = o.ahl().sj(w.fDB);
                }
            }
        } else if (type == 62) {
            com.tencent.mm.modelvideo.o.all();
            str = t.uh(jf.field_imgPath);
        } else if (type == 48) {
            this.lsw = true;
        }
        AppMethodBeat.o(19268);
        return str;
    }

    static void dQ(String str, String str2) {
        AppMethodBeat.i(19269);
        ek ekVar = new ek();
        ekVar.cxU.cxW = str2;
        ekVar.cxU.ceI = str;
        com.tencent.mm.sdk.b.a.xxA.m(ekVar);
        AppMethodBeat.o(19269);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19270);
        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
            AppMethodBeat.o(19270);
            return;
        }
        if (mVar instanceof n) {
            n nVar = (n) mVar;
            if (i == 0 && i2 == 0) {
                cin cin;
                if (nVar.ehh == null || nVar.ehh.fsH.fsP == null) {
                    cin = null;
                } else {
                    cin = (cin) nVar.ehh.fsH.fsP;
                }
                String str2 = cin.xhu;
                if (1 == nVar.ltE) {
                    dQ(nVar.ceI, this.lsB);
                    AppMethodBeat.o(19270);
                    return;
                }
                String hM;
                String str3 = nVar.ceI;
                String str4 = (String) this.lsL.get(str3);
                dQ(str3, this.lsD);
                if (!this.lsx || this.lsy == null) {
                    hM = hM(this.edW);
                } else {
                    hM = this.lsz;
                }
                if (str4 == null || str4.length() == 0) {
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    dQ(str3, this.lsC);
                    AppMethodBeat.o(19270);
                    return;
                }
                if (!this.lsv) {
                    ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.lsv = true;
                }
                if (!(this.lsN.containsKey(str3) && ((Boolean) this.lsN.get(str3)).booleanValue())) {
                    ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: ".concat(String.valueOf(str4)));
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        dQ(str3, this.lsC);
                        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                int useWCLanDeviceService;
                if (this.lsw) {
                    useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lsX.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lsM.put(str3, Integer.valueOf(useWCLanDeviceService));
                        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: ".concat(String.valueOf(useWCLanDeviceService)));
                        AppMethodBeat.o(19270);
                        return;
                    }
                    dQ(str3, this.lsC);
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    AppMethodBeat.o(19270);
                    return;
                } else if (hM == null || hM.length() == 0) {
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    dQ(str3, this.lsC);
                    AppMethodBeat.o(19270);
                    return;
                } else {
                    useWCLanDeviceService = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), hM.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lsX.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lsM.put(str3, Integer.valueOf(useWCLanDeviceService));
                        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =".concat(String.valueOf(useWCLanDeviceService)));
                        AppMethodBeat.o(19270);
                        return;
                    }
                    dQ(str3, this.lsC);
                    ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                }
            } else {
                ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
                dQ(nVar.ceI, this.lsC);
                AppMethodBeat.o(19270);
                return;
            }
        }
        AppMethodBeat.o(19270);
    }

    static String c(b bVar) {
        AppMethodBeat.i(19271);
        String str;
        if (bVar == null) {
            str = "";
            AppMethodBeat.o(19271);
            return str;
        }
        str = null;
        if (!bo.isNullOrNil(bVar.dFl)) {
            str = bVar.dFl;
        } else if (!bo.isNullOrNil(bVar.dFm)) {
            str = bVar.dFm;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.ie(bVar.field_mac);
        } else if (!bo.isNullOrNil(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        str = bo.nullAsNil(str);
        AppMethodBeat.o(19271);
        return str;
    }

    static /* synthetic */ void a(g gVar, String str, int i) {
        AppMethodBeat.i(19272);
        ek ekVar = new ek();
        ekVar.cxU.ceI = str;
        if (i >= 100) {
            ekVar.cxU.cxW = gVar.lsB;
        } else {
            ekVar.cxU.cxW = gVar.lsD;
        }
        ekVar.cxU.progress = i;
        com.tencent.mm.sdk.b.a.xxA.m(ekVar);
        AppMethodBeat.o(19272);
    }

    static /* synthetic */ void bx(List list) {
        AppMethodBeat.i(19273);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((b) list.get(i)).field_deviceType);
            hashMap.put("deviceID", ((b) list.get(i)).field_deviceID);
            hashMap.put("displayName", c((b) list.get(i)));
            hashMap.put("iconUrl", ((b) list.get(i)).iconUrl);
            hashMap.put("ability", ((b) list.get(i)).dFr);
            hashMap.put("abilityInf", ((b) list.get(i)).dFs);
            arrayList.add(hashMap);
        }
        eg egVar = new eg();
        egVar.cxJ.cwW = arrayList;
        com.tencent.mm.sdk.b.a.xxA.m(egVar);
        AppMethodBeat.o(19273);
    }
}
