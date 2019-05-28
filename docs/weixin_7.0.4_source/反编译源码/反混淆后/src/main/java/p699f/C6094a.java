package p699f;

import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;

/* renamed from: f.a */
public abstract class C6094a {
    public final int height;
    public final int width;

    public abstract byte[] chS();

    /* renamed from: n */
    public abstract byte[] mo13483n(int i, byte[] bArr);

    protected C6094a(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        byte[] bArr = new byte[this.width];
        StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            bArr = mo13483n(i, bArr);
            for (int i2 = 0; i2 < this.width; i2++) {
                char c;
                int i3 = bArr[i2] & 255;
                if (i3 < 64) {
                    c = '#';
                } else if (i3 < 128) {
                    c = '+';
                } else if (i3 < C33250az.CTRL_INDEX) {
                    c = '.';
                } else {
                    c = ' ';
                }
                stringBuilder.append(c);
            }
            stringBuilder.append(10);
        }
        return stringBuilder.toString();
    }
}
