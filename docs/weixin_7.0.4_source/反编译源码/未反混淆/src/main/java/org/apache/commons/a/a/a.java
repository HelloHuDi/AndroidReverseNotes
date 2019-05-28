package org.apache.commons.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private int BWA;
    private byte[] BWB;
    private boolean BWC;
    private final List<byte[]> BWy;
    private int BWz;
    private int count;

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        AppMethodBeat.i(136486);
        this.BWy = new ArrayList();
        this.BWC = true;
        synchronized (this) {
            try {
                Vl(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136486);
            }
        }
    }

    private void Vl(int i) {
        AppMethodBeat.i(136487);
        if (this.BWz < this.BWy.size() - 1) {
            this.BWA += this.BWB.length;
            this.BWz++;
            this.BWB = (byte[]) this.BWy.get(this.BWz);
            AppMethodBeat.o(136487);
            return;
        }
        if (this.BWB == null) {
            this.BWA = 0;
        } else {
            i = Math.max(this.BWB.length << 1, i - this.BWA);
            this.BWA += this.BWB.length;
        }
        this.BWz++;
        this.BWB = new byte[i];
        this.BWy.add(this.BWB);
        AppMethodBeat.o(136487);
    }

    public final void write(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(136488);
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(136488);
            throw indexOutOfBoundsException;
        } else if (i2 == 0) {
            AppMethodBeat.o(136488);
        } else {
            synchronized (this) {
                try {
                    int i3 = this.count + i2;
                    int i4 = this.count - this.BWA;
                    int i5 = i2;
                    while (i5 > 0) {
                        int min = Math.min(i5, this.BWB.length - i4);
                        System.arraycopy(bArr, (i + i2) - i5, this.BWB, i4, min);
                        i5 -= min;
                        if (i5 > 0) {
                            Vl(i3);
                            i4 = 0;
                        }
                    }
                    this.count = i3;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(136488);
                }
            }
        }
    }

    public final synchronized void write(int i) {
        AppMethodBeat.i(136489);
        int i2 = this.count - this.BWA;
        if (i2 == this.BWB.length) {
            Vl(this.count + 1);
            i2 = 0;
        }
        this.BWB[i2] = (byte) i;
        this.count++;
        AppMethodBeat.o(136489);
    }

    public final void close() {
    }

    public final synchronized byte[] toByteArray() {
        byte[] bArr;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(136490);
            int i2 = this.count;
            if (i2 == 0) {
                bArr = EMPTY_BYTE_ARRAY;
                AppMethodBeat.o(136490);
            } else {
                byte[] bArr2 = new byte[i2];
                Iterator it = this.BWy.iterator();
                while (true) {
                    int i3 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    bArr = (byte[]) it.next();
                    int min = Math.min(bArr.length, i2);
                    System.arraycopy(bArr, 0, bArr2, i3, min);
                    i = i3 + min;
                    i2 -= min;
                    if (i2 == 0) {
                        break;
                    }
                }
                AppMethodBeat.o(136490);
                bArr = bArr2;
            }
        }
        return bArr;
    }

    @Deprecated
    public final String toString() {
        AppMethodBeat.i(136491);
        String str = new String(toByteArray(), Charset.defaultCharset());
        AppMethodBeat.o(136491);
        return str;
    }
}
