package com.tencent.p177mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.storage.C44222az;

/* renamed from: com.tencent.mm.plugin.sns.data.f */
public final class C43539f {
    public String cFc;
    public bau cNr;
    public String key;
    public String qFR;
    public String qFS;
    public C44222az qFT;
    public SparseArray<bau> qFU;
    public int requestType;
    public int size;

    public C43539f() {
        AppMethodBeat.m2504i(35799);
        this.qFU = new SparseArray();
        AppMethodBeat.m2505o(35799);
    }

    public C43539f(String str, SparseArray<bau> sparseArray, String str2, C44222az c44222az, int i) {
        this.cFc = str;
        this.qFU = sparseArray;
        this.requestType = 9;
        this.key = str2;
        this.qFT = c44222az;
        this.size = i;
    }

    public C43539f(bau bau, int i, String str, C44222az c44222az, String str2, String str3) {
        this.cNr = bau;
        this.requestType = i;
        this.qFT = c44222az;
        this.key = str;
        this.qFR = str2;
        this.qFS = str3;
    }
}
