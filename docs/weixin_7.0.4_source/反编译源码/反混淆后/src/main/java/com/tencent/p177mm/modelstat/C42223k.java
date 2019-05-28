package com.tencent.p177mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.modelstat.k */
public final class C42223k {
    private static final String FORMAT;
    int bJt = -2;
    public int fSZ = 0;
    public int fTA = 0;
    public int fTB = 0;
    public int fTa = 0;
    public int fTb = 0;
    public int fTc = 0;
    public int fTd = 0;
    public int fTe = 0;
    public int fTf = 0;
    public int fTg = 0;
    public int fTh = 0;
    public int fTi = 0;
    public int fTj = 0;
    public int fTk = 0;
    public int fTl = 0;
    public int fTm = 0;
    public int fTn = 0;
    public int fTo = 0;
    public int fTp = 0;
    public int fTq = 0;
    public int fTr = 0;
    public int fTs = 0;
    public int fTt = 0;
    public int fTu = 0;
    public int fTv = 0;
    public int fTw = 0;
    public int fTx = 0;
    public int fTy = 0;
    public int fTz = 0;
    /* renamed from: id */
    public int f17169id = 0;

    /* renamed from: d */
    public final void mo67751d(Cursor cursor) {
        AppMethodBeat.m2504i(78740);
        this.f17169id = cursor.getInt(0);
        this.fSZ = cursor.getInt(1);
        this.fTa = cursor.getInt(2);
        this.fTb = cursor.getInt(3);
        this.fTc = cursor.getInt(4);
        this.fTd = cursor.getInt(5);
        this.fTe = cursor.getInt(6);
        this.fTf = cursor.getInt(7);
        this.fTg = cursor.getInt(8);
        this.fTh = cursor.getInt(9);
        this.fTi = cursor.getInt(10);
        this.fTj = cursor.getInt(11);
        this.fTk = cursor.getInt(12);
        this.fTl = cursor.getInt(13);
        this.fTm = cursor.getInt(14);
        this.fTn = cursor.getInt(15);
        this.fTo = cursor.getInt(16);
        this.fTp = cursor.getInt(17);
        this.fTq = cursor.getInt(18);
        this.fTr = cursor.getInt(19);
        this.fTs = cursor.getInt(20);
        this.fTt = cursor.getInt(21);
        this.fTu = cursor.getInt(22);
        this.fTv = cursor.getInt(23);
        this.fTw = cursor.getInt(24);
        this.fTx = cursor.getInt(25);
        this.fTy = cursor.getInt(26);
        this.fTz = cursor.getInt(27);
        this.fTA = cursor.getInt(28);
        this.fTB = cursor.getInt(29);
        AppMethodBeat.m2505o(78740);
    }

    static {
        AppMethodBeat.m2504i(78742);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetStatInfo:");
        stringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
        FORMAT = stringBuilder.toString();
        AppMethodBeat.m2505o(78742);
    }

    public final String toString() {
        AppMethodBeat.m2504i(78741);
        String format = String.format(FORMAT, new Object[]{Integer.valueOf(this.fTi), Integer.valueOf(this.fTy), Integer.valueOf(this.fTk), Integer.valueOf(this.fTu), Integer.valueOf(this.fTA), Integer.valueOf(this.fTw), Integer.valueOf(this.fTj), Integer.valueOf(this.fTz), Integer.valueOf(this.fTl), Integer.valueOf(this.fTv), Integer.valueOf(this.fTB), Integer.valueOf(this.fTx), Integer.valueOf(this.fTa), Integer.valueOf(this.fTb), Integer.valueOf(this.fTm), Integer.valueOf(this.fTn), Integer.valueOf(this.fTc), Integer.valueOf(this.fTd), Integer.valueOf(this.fTo), Integer.valueOf(this.fTp), Integer.valueOf(this.fTe), Integer.valueOf(this.fTf), Integer.valueOf(this.fTq), Integer.valueOf(this.fTr), Integer.valueOf(this.fTg), Integer.valueOf(this.fTh), Integer.valueOf(this.fTs), Integer.valueOf(this.fTt)});
        AppMethodBeat.m2505o(78741);
        return format;
    }
}
