package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.model.g.AnonymousClass3;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class i extends h<String, Integer, Boolean> {
    private n feQ = null;
    private String key = "";
    private String nQB;
    private int qIO;
    private String qIP;
    private List<bau> qIQ;

    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(36234);
        super.onPostExecute((Boolean) obj);
        af.cnC().qIp.remove(this.key);
        af.cnC().b(this.key, this.feQ);
        AppMethodBeat.o(36234);
    }

    public i(String str, String str2, List<bau> list) {
        AppMethodBeat.i(36231);
        af.cnC().qIp.add(str);
        this.nQB = str2;
        this.qIP = af.getAccSnsPath();
        this.qIO = af.cnN();
        this.qIQ = list;
        this.key = str;
        AppMethodBeat.o(36231);
    }

    public final a cin() {
        AppMethodBeat.i(36232);
        a cnq = af.cnq();
        AppMethodBeat.o(36232);
        return cnq;
    }

    private boolean a(String str, String str2, List<bau> list) {
        String str3;
        AppMethodBeat.i(36233);
        ab.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + str + " " + str2);
        LinkedList linkedList = new LinkedList();
        int i = 0;
        for (bau bau : list) {
            String f = com.tencent.mm.plugin.sns.data.i.f(bau);
            String e = com.tencent.mm.plugin.sns.data.i.e(bau);
            String fZ = an.fZ(this.qIP, bau.Id);
            if (!e.ct(fZ + f)) {
                if (!e.ct(fZ + e)) {
                    String l = com.tencent.mm.plugin.sns.data.i.l(bau);
                    if (e.ct(fZ + l)) {
                        str3 = l;
                    } else {
                        str3 = com.tencent.mm.plugin.sns.data.i.m(bau);
                    }
                    s.a(fZ, str3, e, (float) af.cnO());
                }
                s.b(fZ, e, f, (float) af.cnN());
            }
            n Xk = com.tencent.mm.plugin.sns.data.i.Xk(fZ + f);
            if (Xk == null) {
                e.deleteFile(fZ + f);
                ab.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(f)));
                AppMethodBeat.o(36233);
                return false;
            }
            linkedList.add(Xk);
            ab.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + Xk + " " + fZ + f);
            int i2 = i + 1;
            if (i2 < 4) {
                i = i2;
            }
        }
        try {
            str3 = an.fZ(this.qIP, str);
            e.tf(str3);
            d.a(com.tencent.mm.plugin.sns.data.i.p(linkedList, this.qIO), 100, CompressFormat.JPEG, str3 + str2, false);
            AppMethodBeat.o(36233);
            return true;
        } catch (IOException e2) {
            ab.printErrStackTrace("MicroMsg.MutiImageLoader", e2, "makeMutilMedia failed: ".concat(String.valueOf(str2)), new Object[0]);
            AppMethodBeat.o(36233);
            return false;
        }
    }

    public final /* synthetic */ Object dv() {
        AppMethodBeat.i(36235);
        String Xa = com.tencent.mm.plugin.sns.data.i.Xa(this.nQB);
        String fZ = an.fZ(this.qIP, this.nQB);
        if (!e.ct(fZ + Xa)) {
            a(this.nQB, Xa, this.qIQ);
        }
        this.feQ = com.tencent.mm.plugin.sns.data.i.Xk(fZ + Xa);
        af.bCo().post(new AnonymousClass3(this.nQB, this.feQ));
        ab.i("MicroMsg.MutiImageLoader", "deocde done bm " + this.feQ + " requestid " + this.nQB + " " + fZ + Xa);
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.o(36235);
        return bool;
    }
}
