package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.af.f;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.cs.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import com.tencent.soter.core.biometric.FaceManager;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SendAppMessageTask extends MainProcessTask {
    public static final Creator<SendAppMessageTask> CREATOR = new Creator<SendAppMessageTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendAppMessageTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131461);
            SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(parcel);
            AppMethodBeat.o(131461);
            return sendAppMessageTask;
        }
    };
    public String appId;
    public int axy;
    public int cBc;
    public String cOv;
    public String cacheKey;
    public String cst;
    public String description;
    public int duk = a.BUSINESS_MAX.ordinal();
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

    public SendAppMessageTask() {
        AppMethodBeat.i(131462);
        AppMethodBeat.o(131462);
    }

    public final void asP() {
        Bitmap a;
        AppMethodBeat.i(131463);
        ab.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", this.userName, this.hWE);
        byte[] bArr = new byte[0];
        if (!bo.isNullOrNil(this.hWE) && (this.hWE.startsWith("http://") || this.hWE.startsWith("https://"))) {
            a = b.abR().a(this.hWE, null);
        } else if (bo.isNullOrNil(this.hWF)) {
            a = null;
        } else {
            a = d.aml(this.hWF);
            if (this.hIs) {
                boolean deleteFile = e.deleteFile(this.hWF);
                ab.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", this.hWF, Boolean.valueOf(deleteFile));
            } else {
                ab.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", this.hWF);
            }
        }
        if (a == null || a.isRecycled()) {
            ab.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        } else {
            ab.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
            Bitmap createBitmap = Bitmap.createBitmap(a.getWidth(), a.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(a, 0.0f, 0.0f, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            ab.i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", createBitmap);
            createBitmap.recycle();
        }
        ab.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", this.appId, this.title, this.description, this.userName, this.path, this.hWE);
        v.Zp().y(v.nW("wxapp_" + this.appId + this.path), true).j("prePublishId", "wxapp_" + this.appId + this.path);
        j.b bVar = new j.b();
        bVar.title = this.title;
        bVar.description = this.description;
        bVar.fiP = this.userName;
        bVar.fiO = this.path;
        bVar.fiQ = this.appId;
        bVar.fiZ = this.cBc;
        bVar.fja = this.version;
        bVar.fiS = this.hiv;
        bVar.fiR = this.type;
        bVar.fiY = this.hWI;
        bVar.url = this.url;
        bVar.fjb = this.iconUrl;
        bVar.cMm = "wxapp_" + this.appId + this.path;
        bVar.cMg = this.userName;
        bVar.cMh = this.nickname;
        f aVar = new com.tencent.mm.af.a();
        aVar.feY = this.hWN;
        aVar.feZ = this.cacheKey;
        aVar.ffa = this.fmr;
        aVar.ffb = this.hWO;
        aVar.ffk = this.cOv;
        aVar.ffl = this.hWE;
        aVar.ffm = bo.isNullOrNil(this.hWE);
        bVar.a(aVar);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.appId);
        stringBuilder.append("_");
        g.RN();
        stringBuilder.append(p.getString(com.tencent.mm.kernel.a.QF()));
        stringBuilder.append("_");
        stringBuilder.append(bo.anT());
        stringBuilder.append("_");
        stringBuilder.append(this.hWJ);
        bVar.fiU = stringBuilder.toString();
        if (1 == this.hWH) {
            bVar.type = 33;
        } else if (2 == this.hWH) {
            bVar.type = 44;
            bVar.fiW = this.duk;
            bVar.fiX = this.hWG;
        } else if (this.hWH == 3) {
            bVar.type = 46;
            bVar.appId = this.hWQ;
            bVar.appName = this.hWR;
            bVar.cMg = this.hWS;
            bVar.cMh = null;
            aVar.appThumbUrl = this.hWT;
        }
        ab.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b", Boolean.valueOf(this.hWO), Boolean.valueOf(this.withShareTicket));
        if (this.hWO && this.withShareTicket) {
            a(bVar, bArr, stringBuilder, this.scene, this.hWO, this.fhu);
            AppMethodBeat.o(131463);
        } else if (this.withShareTicket) {
            a(bVar, bArr, stringBuilder, this.scene, this.hWO, this.fhu);
            AppMethodBeat.o(131463);
        } else {
            Iterator it = new LinkedList(bo.P(this.toUser.split(","))).iterator();
            while (it.hasNext()) {
                a(bVar, bArr, (String) it.next(), stringBuilder, this.scene);
            }
            AppMethodBeat.o(131463);
        }
    }

    public final void asQ() {
        AppMethodBeat.i(131464);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(131464);
    }

    private static void a(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, int i3, String str11, int i4) {
        AppMethodBeat.i(131465);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.SendAppMessageTask", "appId is Null!");
            AppMethodBeat.o(131465);
            return;
        }
        Object encode;
        String encode2;
        String str12 = "";
        try {
            str12 = q.encode(bo.nullAsNil(str6), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.SendAppMessageTask", "encode share page path error!");
        }
        String str13 = "";
        try {
            str13 = q.encode(bo.nullAsNil(str7), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            ab.e("MicroMsg.SendAppMessageTask", "encode current page path error!");
        }
        Object obj = "";
        try {
            encode = q.encode(bo.nullAsNil(str10), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            ab.e("MicroMsg.SendAppMessageTask", "encode current html url error!");
            encode = obj;
        }
        try {
            encode2 = q.encode(bo.nullAsNil(str11), "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            ab.e("MicroMsg.SendAppMessageTask", "encode thumb Icon url error!");
            encode2 = "";
        }
        try {
            str5 = q.encode(bo.nullAsNil(str5), "UTF-8");
        } catch (UnsupportedEncodingException e5) {
            ab.e("MicroMsg.SendAppMessageTask", "encode shareTitle error!");
        }
        int i5 = i3 + 1000;
        ab.d("MicroMsg.SendAppMessageTask", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s, appServiceType %s, thumbIconUrl %s, appVersion %d", Integer.valueOf(14077), str, Integer.valueOf(i), str2, str3, str7, str8, str5, str6, str9, Integer.valueOf(i2), str4, Integer.valueOf(i5), encode2, Integer.valueOf(i4));
        h.pYm.e(14077, str, Integer.valueOf(i), str2, str3, str13, str8, str5, str12, str9, "", Integer.valueOf(i2), str4, encode, Integer.valueOf(i5), encode2, Integer.valueOf(i4));
        AppMethodBeat.o(131465);
    }

    private void a(j.b bVar, byte[] bArr, StringBuilder stringBuilder, int i, boolean z, String str) {
        AppMethodBeat.i(131466);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = FaceManager.FACE_ACQUIRED_NO_FOCUS;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        cwl cwl = new cwl();
        cwl.csB = this.appId;
        final LinkedList linkedList = new LinkedList(bo.P(this.toUser.split(",")));
        cwl.xse = linkedList;
        cwl.xsg = str;
        cwl.xsf = z;
        aVar.fsJ = cwl;
        aVar.fsK = new cwm();
        final j.b bVar2 = bVar;
        final int i2 = i;
        final byte[] bArr2 = bArr;
        final StringBuilder stringBuilder2 = stringBuilder;
        w.a(aVar.acD(), new w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(131460);
                ab.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                cwm cwm = (cwm) bVar.fsH.fsP;
                if (i != 0 || i2 != 0 || cwm == null || bo.ek(cwm.xsh)) {
                    if (bVar2.fiR == 3) {
                        bVar2.fiR = 2;
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        SendAppMessageTask.a(SendAppMessageTask.this, bVar2, bArr2, (String) it.next(), stringBuilder2, i2);
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
                        bVar2.fiV = cwu.wYs;
                        SendAppMessageTask.this.hWU.add(new ShareInfo(cwu.wYs, cwu.xsu));
                        com.tencent.mm.af.a aVar = (com.tencent.mm.af.a) bVar2.X(com.tencent.mm.af.a.class);
                        aVar.ffb = cwu.xsf;
                        if (cwu.xsf && cwu.xsv != null) {
                            c cVar;
                            aVar.ffc = cwu.xsv.content;
                            aVar.ffd = cwu.xsv.wYm;
                            aVar.ffe = cwu.xsv.wYn;
                            aVar.fff = cwu.xsv.wYo;
                            aVar.ffg = cwu.xsv.wYp;
                            aVar.ffh = cwu.xsv.wYr;
                            aVar.ffj = cwu.xsv.state;
                            aVar.ffi = cwu.xsv.wYq;
                            cs hH = new cs().hE(SendAppMessageTask.this.appId).hF(SendAppMessageTask.this.path).hG(cwu.wYs).hH((String) linkedList.get(i3));
                            if (((String) linkedList.get(i3)).toLowerCase().endsWith("@chatroom")) {
                                cVar = c.YES;
                            } else {
                                cVar = c.NO;
                            }
                            hH.dhB = cVar;
                            hH.dhC = cs.b.SHAREAPPMSG;
                            hH.cVR = (long) i2;
                            cs hI = hH.hI(SendAppMessageTask.this.cst);
                            hI.dhG = cs.a.hp(SendAppMessageTask.this.fmr + 1000);
                            hI = hI.Hk();
                            hI.dhE = cs.d.DOING;
                            hI.dhF = cs.e.NOTSUBSCRIBE;
                            hI.ajK();
                        }
                        SendAppMessageTask.a(SendAppMessageTask.this, bVar2, bArr2, (String) linkedList.get(i3), stringBuilder2, i2);
                    }
                }
                SendAppMessageTask.a(SendAppMessageTask.this);
                AppMethodBeat.o(131460);
                return 0;
            }
        });
        AppMethodBeat.o(131466);
    }

    private void a(j.b bVar, byte[] bArr, String str, StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(131467);
        ((com.tencent.mm.plugin.appbrand.compat.a.a) g.K(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(bVar, this.appId, this.title, str, bArr);
        if (!bo.isNullOrNil(this.hWD)) {
            qb qbVar = new qb();
            qbVar.cMq.cMr = str;
            qbVar.cMq.content = this.hWD;
            qbVar.cMq.type = t.nK(str);
            qbVar.cMq.flags = 0;
            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
        }
        int i2 = 1;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List oe = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().oe(str);
            i2 = oe != null ? oe.size() : 0;
        }
        a(this.appId, i, this.cst, this.hWK, str, this.title, this.path, this.hWL, this.hWM, i2, stringBuilder.toString(), this.hWP, this.fmr, this.hWE, this.axy);
        AppMethodBeat.o(131467);
    }

    public final void g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(131468);
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
        AppMethodBeat.o(131468);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(131469);
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
        AppMethodBeat.o(131469);
    }

    protected SendAppMessageTask(Parcel parcel) {
        AppMethodBeat.i(131470);
        g(parcel);
        AppMethodBeat.o(131470);
    }

    static {
        AppMethodBeat.i(131473);
        AppMethodBeat.o(131473);
    }

    static /* synthetic */ void a(SendAppMessageTask sendAppMessageTask) {
        AppMethodBeat.i(131472);
        sendAppMessageTask.aCb();
        AppMethodBeat.o(131472);
    }
}
