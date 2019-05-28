package com.google.android.exoplayer2.p111i;

import com.google.android.exoplayer2.p1585d.C41599b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

/* renamed from: com.google.android.exoplayer2.i.l */
public final class C32065l {
    public byte[] data;
    public int limit;
    public int position;

    public C32065l(int i) {
        AppMethodBeat.m2504i(95903);
        this.data = new byte[i];
        this.limit = i;
        AppMethodBeat.m2505o(95903);
    }

    public C32065l(byte[] bArr) {
        AppMethodBeat.m2504i(95904);
        this.data = bArr;
        this.limit = bArr.length;
        AppMethodBeat.m2505o(95904);
    }

    public C32065l(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
    }

    public final void reset(int i) {
        AppMethodBeat.m2504i(95905);
        mo52371n(capacity() < i ? new byte[i] : this.data, i);
        AppMethodBeat.m2505o(95905);
    }

    /* renamed from: n */
    public final void mo52371n(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    /* renamed from: tB */
    public final int mo52382tB() {
        return this.limit - this.position;
    }

    /* renamed from: eL */
    public final void mo52368eL(int i) {
        AppMethodBeat.m2504i(95906);
        boolean z = i >= 0 && i <= this.data.length;
        C45039a.checkArgument(z);
        this.limit = i;
        AppMethodBeat.m2505o(95906);
    }

    public final int capacity() {
        return this.data == null ? 0 : this.data.length;
    }

    public final void setPosition(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(95907);
        if (i < 0 || i > this.limit) {
            C41599b.m72864i("ExoPlayer", "position%d, limit:%d", Integer.valueOf(i), Integer.valueOf(this.limit));
        }
        if (i < 0 || i > this.limit) {
            z = false;
        }
        C45039a.checkArgument(z);
        this.position = i;
        AppMethodBeat.m2505o(95907);
    }

    /* renamed from: eM */
    public final void mo52369eM(int i) {
        AppMethodBeat.m2504i(95908);
        setPosition(this.position + i);
        AppMethodBeat.m2505o(95908);
    }

    /* renamed from: c */
    public final void mo52365c(C32064k c32064k, int i) {
        AppMethodBeat.m2504i(95909);
        readBytes(c32064k.data, 0, i);
        c32064k.setPosition(0);
        AppMethodBeat.m2505o(95909);
    }

    public final void readBytes(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95910);
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
        AppMethodBeat.m2505o(95910);
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    /* renamed from: tC */
    public final int mo52383tC() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 8);
    }

    /* renamed from: tD */
    public final int mo52384tD() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    /* renamed from: cM */
    public final long mo52366cM() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    /* renamed from: tE */
    public final long mo52385tE() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 24);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    /* renamed from: tF */
    public final int mo52386tF() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = bArr[i] & 255;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | ((bArr2[i3] & 255) << 24);
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    /* renamed from: tG */
    public final long mo52387tG() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | ((((long) bArr2[i2]) & 255) << 56);
    }

    /* renamed from: tH */
    public final int mo52388tH() {
        AppMethodBeat.m2504i(95911);
        int readUnsignedByte = (((readUnsignedByte() << 21) | (readUnsignedByte() << 14)) | (readUnsignedByte() << 7)) | readUnsignedByte();
        AppMethodBeat.m2505o(95911);
        return readUnsignedByte;
    }

    /* renamed from: tI */
    public final int mo52389tI() {
        AppMethodBeat.m2504i(95912);
        int readInt = readInt();
        if (readInt < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(readInt)));
            AppMethodBeat.m2505o(95912);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(95912);
        return readInt;
    }

    /* renamed from: tJ */
    public final int mo52390tJ() {
        AppMethodBeat.m2504i(95913);
        int tF = mo52386tF();
        if (tF < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(tF)));
            AppMethodBeat.m2505o(95913);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(95913);
        return tF;
    }

    /* renamed from: tK */
    public final long mo52391tK() {
        AppMethodBeat.m2504i(95914);
        long readLong = readLong();
        if (readLong < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Top bit not zero: ".concat(String.valueOf(readLong)));
            AppMethodBeat.m2505o(95914);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(95914);
        return readLong;
    }

    public final String readString(int i) {
        AppMethodBeat.m2504i(95915);
        String a = mo52364a(i, Charset.forName("UTF-8"));
        AppMethodBeat.m2505o(95915);
        return a;
    }

    /* renamed from: a */
    public final String mo52364a(int i, Charset charset) {
        AppMethodBeat.m2504i(95916);
        String str = new String(this.data, this.position, i, charset);
        this.position += i;
        AppMethodBeat.m2505o(95916);
        return str;
    }

    /* renamed from: eN */
    public final String mo52370eN(int i) {
        AppMethodBeat.m2504i(95917);
        if (i == 0) {
            String str = "";
            AppMethodBeat.m2505o(95917);
            return str;
        }
        int i2 = (this.position + i) - 1;
        if (i2 >= this.limit || this.data[i2] != (byte) 0) {
            i2 = i;
        } else {
            i2 = i - 1;
        }
        String str2 = new String(this.data, this.position, i2);
        this.position += i;
        AppMethodBeat.m2505o(95917);
        return str2;
    }

    /* renamed from: tL */
    public final String mo52392tL() {
        AppMethodBeat.m2504i(95918);
        if (mo52382tB() == 0) {
            AppMethodBeat.m2505o(95918);
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != (byte) 0) {
            i++;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position < this.limit) {
            this.position++;
        }
        AppMethodBeat.m2505o(95918);
        return str;
    }

    public final String readLine() {
        AppMethodBeat.m2504i(95919);
        if (mo52382tB() == 0) {
            AppMethodBeat.m2505o(95919);
            return null;
        }
        int i = this.position;
        while (i < this.limit && !C17675v.m27568eQ(this.data[i])) {
            i++;
        }
        if (i - this.position >= 3 && this.data[this.position] == (byte) -17 && this.data[this.position + 1] == (byte) -69 && this.data[this.position + 2] == (byte) -65) {
            this.position += 3;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position == this.limit) {
            AppMethodBeat.m2505o(95919);
            return str;
        }
        if (this.data[this.position] == (byte) 13) {
            this.position++;
            if (this.position == this.limit) {
                AppMethodBeat.m2505o(95919);
                return str;
            }
        }
        if (this.data[this.position] == (byte) 10) {
            this.position++;
        }
        AppMethodBeat.m2505o(95919);
        return str;
    }
}
