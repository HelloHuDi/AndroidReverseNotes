package com.tencent.p177mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C21925g.C219223;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.model.i */
public final class C46222i extends C39759h<String, Integer, Boolean> {
    private C45434n feQ = null;
    private String key = "";
    private String nQB;
    private int qIO;
    private String qIP;
    private List<bau> qIQ;

    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(36234);
        super.onPostExecute((Boolean) obj);
        C13373af.cnC().qIp.remove(this.key);
        C13373af.cnC().mo37456b(this.key, this.feQ);
        AppMethodBeat.m2505o(36234);
    }

    public C46222i(String str, String str2, List<bau> list) {
        AppMethodBeat.m2504i(36231);
        C13373af.cnC().qIp.add(str);
        this.nQB = str2;
        this.qIP = C13373af.getAccSnsPath();
        this.qIO = C13373af.cnN();
        this.qIQ = list;
        this.key = str;
        AppMethodBeat.m2505o(36231);
    }

    public final C4946a cin() {
        AppMethodBeat.m2504i(36232);
        C4946a cnq = C13373af.cnq();
        AppMethodBeat.m2505o(36232);
        return cnq;
    }

    /* renamed from: a */
    private boolean m86442a(String str, String str2, List<bau> list) {
        String str3;
        AppMethodBeat.m2504i(36233);
        C4990ab.m7416i("MicroMsg.MutiImageLoader", "makeMutilMedia " + str + " " + str2);
        LinkedList linkedList = new LinkedList();
        int i = 0;
        for (bau bau : list) {
            String f = C29036i.m46110f(bau);
            String e = C29036i.m46108e(bau);
            String fZ = C3892an.m6198fZ(this.qIP, bau.f17915Id);
            if (!C5730e.m8628ct(fZ + f)) {
                if (!C5730e.m8628ct(fZ + e)) {
                    String l = C29036i.m46121l(bau);
                    if (C5730e.m8628ct(fZ + l)) {
                        str3 = l;
                    } else {
                        str3 = C29036i.m46122m(bau);
                    }
                    C13478s.m21641a(fZ, str3, e, (float) C13373af.cnO());
                }
                C13478s.m21644b(fZ, e, f, (float) C13373af.cnN());
            }
            C45434n Xk = C29036i.m46088Xk(fZ + f);
            if (Xk == null) {
                C5730e.deleteFile(fZ + f);
                C4990ab.m7412e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(f)));
                AppMethodBeat.m2505o(36233);
                return false;
            }
            linkedList.add(Xk);
            C4990ab.m7416i("MicroMsg.MutiImageLoader", "getbitmap from bm " + Xk + " " + fZ + f);
            int i2 = i + 1;
            if (i2 < 4) {
                i = i2;
            }
        }
        try {
            str3 = C3892an.m6198fZ(this.qIP, str);
            C5730e.m8643tf(str3);
            C5056d.m7625a(C29036i.m46125p(linkedList, this.qIO), 100, CompressFormat.JPEG, str3 + str2, false);
            AppMethodBeat.m2505o(36233);
            return true;
        } catch (IOException e2) {
            C4990ab.printErrStackTrace("MicroMsg.MutiImageLoader", e2, "makeMutilMedia failed: ".concat(String.valueOf(str2)), new Object[0]);
            AppMethodBeat.m2505o(36233);
            return false;
        }
    }

    /* renamed from: dv */
    public final /* synthetic */ Object mo25905dv() {
        AppMethodBeat.m2504i(36235);
        String Xa = C29036i.m46078Xa(this.nQB);
        String fZ = C3892an.m6198fZ(this.qIP, this.nQB);
        if (!C5730e.m8628ct(fZ + Xa)) {
            m86442a(this.nQB, Xa, this.qIQ);
        }
        this.feQ = C29036i.m46088Xk(fZ + Xa);
        C13373af.bCo().post(new C219223(this.nQB, this.feQ));
        C4990ab.m7416i("MicroMsg.MutiImageLoader", "deocde done bm " + this.feQ + " requestid " + this.nQB + " " + fZ + Xa);
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.m2505o(36235);
        return bool;
    }
}
