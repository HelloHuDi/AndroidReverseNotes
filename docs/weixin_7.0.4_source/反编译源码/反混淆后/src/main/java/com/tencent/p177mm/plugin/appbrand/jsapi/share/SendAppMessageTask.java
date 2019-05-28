package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p181af.C8909j.C8913a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18452c;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18453d;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C18454e;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C26289b;
import com.tencent.p177mm.p230g.p232b.p233a.C26288cs.C26290a;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.cwl;
import com.tencent.p177mm.protocal.protobuf.cwm;
import com.tencent.p177mm.protocal.protobuf.cwu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.soter.core.biometric.FaceManager;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask */
public class SendAppMessageTask extends MainProcessTask {
    public static final Creator<SendAppMessageTask> CREATOR = new C313062();
    public String appId;
    public int axy;
    public int cBc;
    public String cOv;
    public String cacheKey;
    public String cst;
    public String description;
    public int duk = C8913a.BUSINESS_MAX.ordinal();
    public String fhu;
    public int fmr;
    public boolean hIs;
    public String hWD;
    public String hWE;
    public String hWF;
    public String hWG;
    public int hWH = 1;
    public int hWI;
    public int hWJ;
    public String hWK;
    public String hWL;
    public String hWM;
    public boolean hWN;
    public boolean hWO;
    public String hWP;
    public String hWQ;
    public String hWR;
    public String hWS;
    public String hWT;
    public ArrayList<ShareInfo> hWU;
    public String hiv;
    public Runnable hww;
    public String iconUrl;
    public String nickname;
    public String path;
    public int scene = 1000;
    public String title;
    public String toUser;
    public int type;
    public String url;
    public String userName;
    public int version;
    public boolean withShareTicket;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask$2 */
    static class C313062 implements Creator<SendAppMessageTask> {
        C313062() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendAppMessageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(131461);
            SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(parcel);
            AppMethodBeat.m2505o(131461);
            return sendAppMessageTask;
        }
    }

    public SendAppMessageTask() {
        AppMethodBeat.m2504i(131462);
        AppMethodBeat.m2505o(131462);
    }

    public final void asP() {
        Bitmap a;
        AppMethodBeat.m2504i(131463);
        C4990ab.m7417i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", this.userName, this.hWE);
        byte[] bArr = new byte[0];
        if (!C5046bo.isNullOrNil(this.hWE) && (this.hWE.startsWith("http://") || this.hWE.startsWith("https://"))) {
            a = C37926b.abR().mo60681a(this.hWE, null);
        } else if (C5046bo.isNullOrNil(this.hWF)) {
            a = null;
        } else {
            a = C5056d.aml(this.hWF);
            if (this.hIs) {
                boolean deleteFile = C5730e.deleteFile(this.hWF);
                C4990ab.m7419v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", this.hWF, Boolean.valueOf(deleteFile));
            } else {
                C4990ab.m7419v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", this.hWF);
            }
        }
        if (a == null || a.isRecycled()) {
            C4990ab.m7412e("MicroMsg.SendAppMessageTask", "thumb image is null");
        } else {
            C4990ab.m7416i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
            Bitmap createBitmap = Bitmap.createBitmap(a.getWidth(), a.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(a, 0.0f, 0.0f, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            C4990ab.m7417i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", createBitmap);
            createBitmap.recycle();
        }
        C4990ab.m7417i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", this.appId, this.title, this.description, this.userName, this.path, this.hWE);
        C37922v.m64076Zp().mo60676y(C37922v.m64078nW("wxapp_" + this.appId + this.path), true).mo53356j("prePublishId", "wxapp_" + this.appId + this.path);
        C8910b c8910b = new C8910b();
        c8910b.title = this.title;
        c8910b.description = this.description;
        c8910b.fiP = this.userName;
        c8910b.fiO = this.path;
        c8910b.fiQ = this.appId;
        c8910b.fiZ = this.cBc;
        c8910b.fja = this.version;
        c8910b.fiS = this.hiv;
        c8910b.fiR = this.type;
        c8910b.fiY = this.hWI;
        c8910b.url = this.url;
        c8910b.fjb = this.iconUrl;
        c8910b.cMm = "wxapp_" + this.appId + this.path;
        c8910b.cMg = this.userName;
        c8910b.cMh = this.nickname;
        C37435f c41728a = new C41728a();
        c41728a.feY = this.hWN;
        c41728a.feZ = this.cacheKey;
        c41728a.ffa = this.fmr;
        c41728a.ffb = this.hWO;
        c41728a.ffk = this.cOv;
        c41728a.ffl = this.hWE;
        c41728a.ffm = C5046bo.isNullOrNil(this.hWE);
        c8910b.mo20334a(c41728a);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.appId);
        stringBuilder.append("_");
        C1720g.m3534RN();
        stringBuilder.append(C1183p.getString(C1668a.m3383QF()));
        stringBuilder.append("_");
        stringBuilder.append(C5046bo.anT());
        stringBuilder.append("_");
        stringBuilder.append(this.hWJ);
        c8910b.fiU = stringBuilder.toString();
        if (1 == this.hWH) {
            c8910b.type = 33;
        } else if (2 == this.hWH) {
            c8910b.type = 44;
            c8910b.fiW = this.duk;
            c8910b.fiX = this.hWG;
        } else if (this.hWH == 3) {
            c8910b.type = 46;
            c8910b.appId = this.hWQ;
            c8910b.appName = this.hWR;
            c8910b.cMg = this.hWS;
            c8910b.cMh = null;
            c41728a.appThumbUrl = this.hWT;
        }
        C4990ab.m7417i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b", Boolean.valueOf(this.hWO), Boolean.valueOf(this.withShareTicket));
        if (this.hWO && this.withShareTicket) {
            m50562a(c8910b, bArr, stringBuilder, this.scene, this.hWO, this.fhu);
            AppMethodBeat.m2505o(131463);
        } else if (this.withShareTicket) {
            m50562a(c8910b, bArr, stringBuilder, this.scene, this.hWO, this.fhu);
            AppMethodBeat.m2505o(131463);
        } else {
            Iterator it = new LinkedList(C5046bo.m7508P(this.toUser.split(","))).iterator();
            while (it.hasNext()) {
                m50561a(c8910b, bArr, (String) it.next(), stringBuilder, this.scene);
            }
            AppMethodBeat.m2505o(131463);
        }
    }

    public final void asQ() {
        AppMethodBeat.m2504i(131464);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(131464);
    }

    /* renamed from: a */
    private static void m50565a(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, int i3, String str11, int i4) {
        AppMethodBeat.m2504i(131465);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.SendAppMessageTask", "appId is Null!");
            AppMethodBeat.m2505o(131465);
            return;
        }
        Object encode;
        String encode2;
        String str12 = "";
        try {
            str12 = C18178q.encode(C5046bo.nullAsNil(str6), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.SendAppMessageTask", "encode share page path error!");
        }
        String str13 = "";
        try {
            str13 = C18178q.encode(C5046bo.nullAsNil(str7), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C4990ab.m7412e("MicroMsg.SendAppMessageTask", "encode current page path error!");
        }
        Object obj = "";
        try {
            encode = C18178q.encode(C5046bo.nullAsNil(str10), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            C4990ab.m7412e("MicroMsg.SendAppMessageTask", "encode current html url error!");
            encode = obj;
        }
        try {
            encode2 = C18178q.encode(C5046bo.nullAsNil(str11), "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            C4990ab.m7412e("MicroMsg.SendAppMessageTask", "encode thumb Icon url error!");
            encode2 = "";
        }
        try {
            str5 = C18178q.encode(C5046bo.nullAsNil(str5), "UTF-8");
        } catch (UnsupportedEncodingException e5) {
            C4990ab.m7412e("MicroMsg.SendAppMessageTask", "encode shareTitle error!");
        }
        int i5 = i3 + 1000;
        C4990ab.m7411d("MicroMsg.SendAppMessageTask", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s, appServiceType %s, thumbIconUrl %s, appVersion %d", Integer.valueOf(14077), str, Integer.valueOf(i), str2, str3, str7, str8, str5, str6, str9, Integer.valueOf(i2), str4, Integer.valueOf(i5), encode2, Integer.valueOf(i4));
        C7060h.pYm.mo8381e(14077, str, Integer.valueOf(i), str2, str3, str13, str8, str5, str12, str9, "", Integer.valueOf(i2), str4, encode, Integer.valueOf(i5), encode2, Integer.valueOf(i4));
        AppMethodBeat.m2505o(131465);
    }

    /* renamed from: a */
    private void m50562a(C8910b c8910b, byte[] bArr, StringBuilder stringBuilder, int i, boolean z, String str) {
        AppMethodBeat.m2504i(131466);
        C1196a c1196a = new C1196a();
        c1196a.fsI = FaceManager.FACE_ACQUIRED_NO_FOCUS;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        cwl cwl = new cwl();
        cwl.csB = this.appId;
        final LinkedList linkedList = new LinkedList(C5046bo.m7508P(this.toUser.split(",")));
        cwl.xse = linkedList;
        cwl.xsg = str;
        cwl.xsf = z;
        c1196a.fsJ = cwl;
        c1196a.fsK = new cwm();
        final C8910b c8910b2 = c8910b;
        final int i2 = i;
        final byte[] bArr2 = bArr;
        final StringBuilder stringBuilder2 = stringBuilder;
        C1226w.m2654a(c1196a.acD(), new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(131460);
                C4990ab.m7417i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                cwm cwm = (cwm) c7472b.fsH.fsP;
                if (i != 0 || i2 != 0 || cwm == null || C5046bo.m7548ek(cwm.xsh)) {
                    if (c8910b2.fiR == 3) {
                        c8910b2.fiR = 2;
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        SendAppMessageTask.m50564a(SendAppMessageTask.this, c8910b2, bArr2, (String) it.next(), stringBuilder2, i2);
                    }
                } else {
                    LinkedList linkedList = cwm.xsh;
                    SendAppMessageTask.this.hWU = new ArrayList();
                    for (int i3 = 0; i3 < linkedList.size(); i3++) {
                        cwu cwu;
                        if (i3 < linkedList.size()) {
                            cwu = (cwu) linkedList.get(i3);
                        } else {
                            cwu = new cwu();
                        }
                        c8910b2.fiV = cwu.wYs;
                        SendAppMessageTask.this.hWU.add(new ShareInfo(cwu.wYs, cwu.xsu));
                        C41728a c41728a = (C41728a) c8910b2.mo20333X(C41728a.class);
                        c41728a.ffb = cwu.xsf;
                        if (cwu.xsf && cwu.xsv != null) {
                            C18452c c18452c;
                            c41728a.ffc = cwu.xsv.content;
                            c41728a.ffd = cwu.xsv.wYm;
                            c41728a.ffe = cwu.xsv.wYn;
                            c41728a.fff = cwu.xsv.wYo;
                            c41728a.ffg = cwu.xsv.wYp;
                            c41728a.ffh = cwu.xsv.wYr;
                            c41728a.ffj = cwu.xsv.state;
                            c41728a.ffi = cwu.xsv.wYq;
                            C26288cs hH = new C26288cs().mo44049hE(SendAppMessageTask.this.appId).mo44050hF(SendAppMessageTask.this.path).mo44051hG(cwu.wYs).mo44052hH((String) linkedList.get(i3));
                            if (((String) linkedList.get(i3)).toLowerCase().endsWith("@chatroom")) {
                                c18452c = C18452c.YES;
                            } else {
                                c18452c = C18452c.NO;
                            }
                            hH.dhB = c18452c;
                            hH.dhC = C26289b.SHAREAPPMSG;
                            hH.cVR = (long) i2;
                            C26288cs hI = hH.mo44053hI(SendAppMessageTask.this.cst);
                            hI.dhG = C26290a.m41777hp(SendAppMessageTask.this.fmr + 1000);
                            hI = hI.mo44048Hk();
                            hI.dhE = C18453d.DOING;
                            hI.dhF = C18454e.NOTSUBSCRIBE;
                            hI.ajK();
                        }
                        SendAppMessageTask.m50564a(SendAppMessageTask.this, c8910b2, bArr2, (String) linkedList.get(i3), stringBuilder2, i2);
                    }
                }
                SendAppMessageTask.m50563a(SendAppMessageTask.this);
                AppMethodBeat.m2505o(131460);
                return 0;
            }
        });
        AppMethodBeat.m2505o(131466);
    }

    /* renamed from: a */
    private void m50561a(C8910b c8910b, byte[] bArr, String str, StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(131467);
        ((C42401a) C1720g.m3528K(C42401a.class)).mo21553a(c8910b, this.appId, this.title, str, bArr);
        if (!C5046bo.isNullOrNil(this.hWD)) {
            C18372qb c18372qb = new C18372qb();
            c18372qb.cMq.cMr = str;
            c18372qb.cMq.content = this.hWD;
            c18372qb.cMq.type = C1855t.m3925nK(str);
            c18372qb.cMq.flags = 0;
            C4879a.xxA.mo10055m(c18372qb);
        }
        int i2 = 1;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(str);
            i2 = oe != null ? oe.size() : 0;
        }
        SendAppMessageTask.m50565a(this.appId, i, this.cst, this.hWK, str, this.title, this.path, this.hWL, this.hWM, i2, stringBuilder.toString(), this.hWP, this.fmr, this.hWE, this.axy);
        AppMethodBeat.m2505o(131467);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(131468);
        this.appId = parcel.readString();
        this.userName = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.hWD = parcel.readString();
        this.toUser = parcel.readString();
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.type = parcel.readInt();
        this.hWE = parcel.readString();
        this.iconUrl = parcel.readString();
        this.hWF = parcel.readString();
        this.hIs = parcel.readInt() == 1;
        this.cBc = parcel.readInt();
        this.hiv = parcel.readString();
        this.version = parcel.readInt();
        this.nickname = parcel.readString();
        this.hWJ = parcel.readInt();
        this.scene = parcel.readInt();
        this.cst = parcel.readString();
        this.hWK = parcel.readString();
        this.hWL = parcel.readString();
        this.hWM = parcel.readString();
        this.withShareTicket = parcel.readByte() == (byte) 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hWN = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.hWO = z2;
        this.fhu = parcel.readString();
        this.cacheKey = parcel.readString();
        this.fmr = parcel.readInt();
        this.hWP = parcel.readString();
        this.hWU = parcel.readArrayList(SendAppMessageTask.class.getClassLoader());
        this.cOv = parcel.readString();
        this.axy = parcel.readInt();
        this.duk = parcel.readInt();
        this.hWG = parcel.readString();
        this.hWI = parcel.readInt();
        this.hWH = parcel.readInt();
        this.hWQ = parcel.readString();
        this.hWR = parcel.readString();
        this.hWS = parcel.readString();
        this.hWT = parcel.readString();
        AppMethodBeat.m2505o(131468);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(131469);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeString(this.userName);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.hWD);
        parcel.writeString(this.toUser);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeInt(this.type);
        parcel.writeString(this.hWE);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.hWF);
        parcel.writeInt(this.hIs ? 1 : 0);
        parcel.writeInt(this.cBc);
        parcel.writeString(this.hiv);
        parcel.writeInt(this.version);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.hWJ);
        parcel.writeInt(this.scene);
        parcel.writeString(this.cst);
        parcel.writeString(this.hWK);
        parcel.writeString(this.hWL);
        parcel.writeString(this.hWM);
        parcel.writeByte((byte) (this.withShareTicket ? 1 : 0));
        if (this.hWN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.hWO) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.fhu);
        parcel.writeString(this.cacheKey);
        parcel.writeInt(this.fmr);
        parcel.writeString(this.hWP);
        parcel.writeList(this.hWU);
        parcel.writeString(this.cOv);
        parcel.writeInt(this.axy);
        parcel.writeInt(this.duk);
        parcel.writeString(this.hWG);
        parcel.writeInt(this.hWI);
        parcel.writeInt(this.hWH);
        parcel.writeString(this.hWQ);
        parcel.writeString(this.hWR);
        parcel.writeString(this.hWS);
        parcel.writeString(this.hWT);
        AppMethodBeat.m2505o(131469);
    }

    protected SendAppMessageTask(Parcel parcel) {
        AppMethodBeat.m2504i(131470);
        mo6032g(parcel);
        AppMethodBeat.m2505o(131470);
    }

    static {
        AppMethodBeat.m2504i(131473);
        AppMethodBeat.m2505o(131473);
    }

    /* renamed from: a */
    static /* synthetic */ void m50563a(SendAppMessageTask sendAppMessageTask) {
        AppMethodBeat.m2504i(131472);
        sendAppMessageTask.aCb();
        AppMethodBeat.m2505o(131472);
    }
}
