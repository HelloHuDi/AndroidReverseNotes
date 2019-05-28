package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.amk;
import com.tencent.p177mm.protocal.protobuf.aml;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.emoji.f.p */
public final class C42948p extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private int gOW;
    public byte[] kWS;
    private int kXd;

    public C42948p(int i, byte[] bArr) {
        this(i, bArr, (byte) 0);
    }

    private C42948p(int i, byte[] bArr, byte b) {
        AppMethodBeat.m2504i(53143);
        this.kWS = null;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amk();
        c1196a.fsK = new aml();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        c1196a.fsI = 720;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.kXd = i;
        this.kWS = bArr;
        this.gOW = 0;
        AppMethodBeat.m2505o(53143);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53144);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        aml aml = (aml) ((C7472b) c1929q).fsH.fsP;
        if (aml.ReqBuf != null) {
            this.kWS = C1946aa.m4150a(aml.ReqBuf);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53144);
    }

    public final int getType() {
        return 720;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53145);
        this.ehi = c1202f;
        amk amk = (amk) this.ehh.fsG.fsP;
        amk.DesignerUin = this.kXd;
        if (this.kWS != null) {
            amk.ReqBuf = C1946aa.m4152ad(this.kWS);
        } else {
            amk.ReqBuf = new SKBuiltinBuffer_t();
        }
        amk.Scene = this.gOW;
        C4990ab.m7410d("MicroMsg.emoji.NetSceneGetPersonalDesigner", amk.ReqBuf == null ? "Buf is NULL" : amk.ReqBuf.toString());
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53145);
        return a;
    }

    public final aml bkE() {
        if (this.ehh == null) {
            return null;
        }
        return (aml) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public static C20383f m76275a(aml aml) {
        AppMethodBeat.m2504i(53146);
        C4990ab.m7410d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (aml == null) {
            AppMethodBeat.m2505o(53146);
            return null;
        }
        C20383f c20383f = new C20383f();
        if (!(aml == null || aml.EmotionList == null)) {
            c20383f.kVp = aml.EmotionList.size();
            ArrayList arrayList = new ArrayList();
            Iterator it = aml.EmotionList.iterator();
            while (it.hasNext()) {
                EmotionSummary emotionSummary = (EmotionSummary) it.next();
                if (emotionSummary.ProductID != null) {
                    arrayList.add(new C11546f(emotionSummary));
                }
            }
            c20383f.kVq = arrayList;
        }
        AppMethodBeat.m2505o(53146);
        return c20383f;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 100;
    }
}
