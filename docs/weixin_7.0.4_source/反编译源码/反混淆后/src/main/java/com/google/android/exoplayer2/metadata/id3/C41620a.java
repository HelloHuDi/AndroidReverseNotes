package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.C17679a;
import com.google.android.exoplayer2.metadata.C36689d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.exoplayer2.metadata.id3.a */
public final class C41620a implements C17679a {
    public static final int bbg = C17675v.m27562aT("ID3");
    private final C8699a bfv;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.a$a */
    public interface C8699a {
        /* renamed from: f */
        boolean mo19251f(int i, int i2, int i3, int i4, int i5);
    }

    /* renamed from: com.google.android.exoplayer2.metadata.id3.a$b */
    static final class C41621b {
        final int bfw;
        final boolean bfx;
        final int bfy;

        public C41621b(int i, boolean z, int i2) {
            this.bfw = i;
            this.bfx = z;
            this.bfy = i2;
        }
    }

    static {
        AppMethodBeat.m2504i(95321);
        AppMethodBeat.m2505o(95321);
    }

    public C41620a() {
        this(null);
    }

    public C41620a(C8699a c8699a) {
        this.bfv = c8699a;
    }

    /* renamed from: a */
    public final Metadata mo19234a(C36689d c36689d) {
        AppMethodBeat.m2504i(95310);
        ByteBuffer byteBuffer = c36689d.aEY;
        Metadata d = mo66752d(byteBuffer.array(), byteBuffer.limit());
        AppMethodBeat.m2505o(95310);
        return d;
    }

    /* renamed from: d */
    public final Metadata mo66752d(byte[] bArr, int i) {
        AppMethodBeat.m2504i(95311);
        List arrayList = new ArrayList();
        C32065l c32065l = new C32065l(bArr, i);
        C41621b x = C41620a.m72926x(c32065l);
        if (x == null) {
            AppMethodBeat.m2505o(95311);
            return null;
        }
        int i2;
        boolean z;
        int i3 = c32065l.position;
        if (x.bfw == 2) {
            i2 = 6;
        } else {
            i2 = 10;
        }
        int i4 = x.bfy;
        if (x.bfx) {
            i4 = C41620a.m72922f(c32065l, x.bfy);
        }
        c32065l.mo52368eL(i4 + i3);
        if (C41620a.m72917a(c32065l, x.bfw, i2, false)) {
            z = false;
        } else if (x.bfw == 4 && C41620a.m72917a(c32065l, 4, i2, true)) {
            z = true;
        } else {
            new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(x.bfw);
            AppMethodBeat.m2505o(95311);
            return null;
        }
        while (c32065l.mo52382tB() >= i2) {
            Id3Frame a = C41620a.m72916a(x.bfw, c32065l, z, i2, this.bfv);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Metadata metadata = new Metadata(arrayList);
        AppMethodBeat.m2505o(95311);
        return metadata;
    }

    /* renamed from: x */
    private static C41621b m72926x(C32065l c32065l) {
        AppMethodBeat.m2504i(95312);
        if (c32065l.mo52382tB() < 10) {
            AppMethodBeat.m2505o(95312);
            return null;
        } else if (c32065l.mo52384tD() != bbg) {
            AppMethodBeat.m2505o(95312);
            return null;
        } else {
            int i;
            boolean z;
            int readUnsignedByte = c32065l.readUnsignedByte();
            c32065l.mo52369eM(1);
            int readUnsignedByte2 = c32065l.readUnsignedByte();
            int tH = c32065l.mo52388tH();
            if (readUnsignedByte == 2) {
                int i2;
                if ((readUnsignedByte2 & 64) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    AppMethodBeat.m2505o(95312);
                    return null;
                }
                i = tH;
            } else if (readUnsignedByte == 3) {
                if (((readUnsignedByte2 & 64) != 0 ? 1 : 0) != 0) {
                    i = c32065l.readInt();
                    c32065l.mo52369eM(i);
                    tH -= i + 4;
                }
                i = tH;
            } else if (readUnsignedByte == 4) {
                if (((readUnsignedByte2 & 64) != 0 ? 1 : 0) != 0) {
                    i = c32065l.mo52388tH();
                    c32065l.mo52369eM(i - 4);
                    tH -= i;
                }
                if ((readUnsignedByte2 & 16) != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    tH -= 10;
                }
                i = tH;
            } else {
                AppMethodBeat.m2505o(95312);
                return null;
            }
            if (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) {
                z = false;
            } else {
                z = true;
            }
            C41621b c41621b = new C41621b(readUnsignedByte, z, i);
            AppMethodBeat.m2505o(95312);
            return c41621b;
        }
    }

    /* renamed from: a */
    private static Id3Frame m72916a(int i, C32065l c32065l, boolean z, int i2, C8699a c8699a) {
        int tI;
        int readUnsignedShort;
        AppMethodBeat.m2504i(95314);
        int readUnsignedByte = c32065l.readUnsignedByte();
        int readUnsignedByte2 = c32065l.readUnsignedByte();
        int readUnsignedByte3 = c32065l.readUnsignedByte();
        int readUnsignedByte4 = i >= 3 ? c32065l.readUnsignedByte() : 0;
        if (i == 4) {
            tI = c32065l.mo52389tI();
            if (!z) {
                tI = (((tI & 255) | (((tI >> 8) & 255) << 7)) | (((tI >> 16) & 255) << 14)) | (((tI >> 24) & 255) << 21);
            }
        } else if (i == 3) {
            tI = c32065l.mo52389tI();
        } else {
            tI = c32065l.mo52384tD();
        }
        if (i >= 3) {
            readUnsignedShort = c32065l.readUnsignedShort();
        } else {
            readUnsignedShort = 0;
        }
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && tI == 0 && readUnsignedShort == 0) {
            c32065l.setPosition(c32065l.limit);
            AppMethodBeat.m2505o(95314);
            return null;
        }
        int i3 = c32065l.position + tI;
        if (i3 > c32065l.limit) {
            c32065l.setPosition(c32065l.limit);
            AppMethodBeat.m2505o(95314);
            return null;
        } else if (c8699a == null || c8699a.mo19251f(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
            int i4;
            Object obj = null;
            Object obj2 = null;
            Object obj3 = null;
            Object i42 = null;
            Object obj4 = null;
            Object obj5;
            if (i == 3) {
                Object obj6;
                obj5 = (readUnsignedShort & 128) != 0 ? 1 : null;
                obj2 = (readUnsignedShort & 64) != 0 ? 1 : null;
                if ((readUnsignedShort & 32) != 0) {
                    obj6 = 1;
                } else {
                    obj6 = null;
                }
                i42 = obj5;
                obj4 = obj6;
                obj = obj5;
            } else if (i == 4) {
                obj5 = (readUnsignedShort & 64) != 0 ? 1 : null;
                obj = (readUnsignedShort & 8) != 0 ? 1 : null;
                obj2 = (readUnsignedShort & 4) != 0 ? 1 : null;
                obj3 = (readUnsignedShort & 2) != 0 ? 1 : null;
                if ((readUnsignedShort & 1) != 0) {
                    i42 = 1;
                    obj4 = obj5;
                } else {
                    i42 = null;
                    obj4 = obj5;
                }
            }
            if (obj == null && obj2 == null) {
                int i5;
                Id3Frame id3Frame;
                if (obj4 != null) {
                    i5 = tI - 1;
                    c32065l.mo52369eM(1);
                } else {
                    i5 = tI;
                }
                if (i42 != null) {
                    i5 -= 4;
                    c32065l.mo52369eM(4);
                }
                if (obj3 != null) {
                    i5 = C41620a.m72922f(c32065l, i5);
                }
                int readUnsignedByte5;
                String ek;
                byte[] bArr;
                int h;
                String str;
                byte[] bArr2;
                int h2;
                String ek2;
                if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = c32065l.readUnsignedByte();
                        ek = C41620a.m72920ek(readUnsignedByte5);
                        bArr = new byte[(i5 - 1)];
                        c32065l.readBytes(bArr, 0, i5 - 1);
                        h = C41620a.m72924h(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, h, ek);
                        h += C41620a.m72921el(readUnsignedByte5);
                        if (h < bArr.length) {
                            ek = new String(bArr, h, C41620a.m72924h(bArr, h, readUnsignedByte5) - h, ek);
                        } else {
                            ek = "";
                        }
                        id3Frame = new TextInformationFrame("TXXX", str, ek);
                    }
                } else if (readUnsignedByte == 84) {
                    ek = C41620a.m72923g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = c32065l.readUnsignedByte();
                        String ek3 = C41620a.m72920ek(readUnsignedByte5);
                        byte[] bArr3 = new byte[(i5 - 1)];
                        c32065l.readBytes(bArr3, 0, i5 - 1);
                        id3Frame = new TextInformationFrame(ek, null, new String(bArr3, 0, C41620a.m72924h(bArr3, 0, readUnsignedByte5), ek3));
                    }
                } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = c32065l.readUnsignedByte();
                        ek = C41620a.m72920ek(readUnsignedByte5);
                        bArr = new byte[(i5 - 1)];
                        c32065l.readBytes(bArr, 0, i5 - 1);
                        h = C41620a.m72924h(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, h, ek);
                        i42 = h + C41620a.m72921el(readUnsignedByte5);
                        if (i42 < bArr.length) {
                            ek = new String(bArr, i42, C41620a.m72919e(bArr, i42) - i42, "ISO-8859-1");
                        } else {
                            ek = "";
                        }
                        id3Frame = new UrlLinkFrame("WXXX", str, ek);
                    }
                } else if (readUnsignedByte == 87) {
                    ek = C41620a.m72923g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    bArr2 = new byte[i5];
                    c32065l.readBytes(bArr2, 0, i5);
                    id3Frame = new UrlLinkFrame(ek, null, new String(bArr2, 0, C41620a.m72919e(bArr2, 0), "ISO-8859-1"));
                } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                    bArr2 = new byte[i5];
                    c32065l.readBytes(bArr2, 0, i5);
                    i42 = C41620a.m72919e(bArr2, 0);
                    id3Frame = new PrivFrame(new String(bArr2, 0, i42, "ISO-8859-1"), C41620a.m72925i(bArr2, i42 + 1, bArr2.length));
                } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i == 2)) {
                    readUnsignedByte5 = c32065l.readUnsignedByte();
                    ek = C41620a.m72920ek(readUnsignedByte5);
                    bArr = new byte[(i5 - 1)];
                    c32065l.readBytes(bArr, 0, i5 - 1);
                    h = C41620a.m72919e(bArr, 0);
                    str = new String(bArr, 0, h, "ISO-8859-1");
                    h++;
                    h2 = C41620a.m72924h(bArr, h, readUnsignedByte5);
                    String str2 = new String(bArr, h, h2 - h, ek);
                    h = C41620a.m72921el(readUnsignedByte5) + h2;
                    h2 = C41620a.m72924h(bArr, h, readUnsignedByte5);
                    id3Frame = new GeobFrame(str, str2, new String(bArr, h, h2 - h, ek), C41620a.m72925i(bArr, C41620a.m72921el(readUnsignedByte5) + h2, bArr.length));
                } else if (!i != 2 ? !(readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) : !(readUnsignedByte == 65 && readUnsignedByte2 == 80 && readUnsignedByte3 == 73 && readUnsignedByte4 == 67)) {
                    int readUnsignedByte6 = c32065l.readUnsignedByte();
                    ek2 = C41620a.m72920ek(readUnsignedByte6);
                    byte[] bArr4 = new byte[(i5 - 1)];
                    c32065l.readBytes(bArr4, 0, i5 - 1);
                    if (i == 2) {
                        readUnsignedByte5 = 2;
                        ek = "image/" + C17675v.m27560aR(new String(bArr4, 0, 3, "ISO-8859-1"));
                        if (ek.equals("image/jpg")) {
                            ek = "image/jpeg";
                        }
                    } else {
                        readUnsignedByte5 = C41620a.m72919e(bArr4, 0);
                        ek = C17675v.m27560aR(new String(bArr4, 0, readUnsignedByte5, "ISO-8859-1"));
                        if (ek.indexOf(47) == -1) {
                            ek = "image/".concat(String.valueOf(ek));
                        }
                    }
                    h2 = bArr4[readUnsignedByte5 + 1] & 255;
                    readUnsignedByte5 += 2;
                    tI = C41620a.m72924h(bArr4, readUnsignedByte5, readUnsignedByte6);
                    id3Frame = new ApicFrame(ek, new String(bArr4, readUnsignedByte5, tI - readUnsignedByte5, ek2), h2, C41620a.m72925i(bArr4, C41620a.m72921el(readUnsignedByte6) + tI, bArr4.length));
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i == 2)) {
                    if (i5 < 4) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = c32065l.readUnsignedByte();
                        ek = C41620a.m72920ek(readUnsignedByte5);
                        bArr = new byte[3];
                        c32065l.readBytes(bArr, 0, 3);
                        ek2 = new String(bArr, 0, 3);
                        bArr = new byte[(i5 - 4)];
                        c32065l.readBytes(bArr, 0, i5 - 4);
                        int h3 = C41620a.m72924h(bArr, 0, readUnsignedByte5);
                        String str3 = new String(bArr, 0, h3, ek);
                        h3 += C41620a.m72921el(readUnsignedByte5);
                        if (h3 < bArr.length) {
                            ek = new String(bArr, h3, C41620a.m72924h(bArr, h3, readUnsignedByte5) - h3, ek);
                        } else {
                            ek = "";
                        }
                        id3Frame = new CommentFrame(ek2, str3, ek);
                    }
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                    id3Frame = C41620a.m72915a(c32065l, i5, i, z, i2, c8699a);
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                    id3Frame = C41620a.m72918b(c32065l, i5, i, z, i2, c8699a);
                } else {
                    ek = C41620a.m72923g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    bArr = new byte[i5];
                    c32065l.readBytes(bArr, 0, i5);
                    id3Frame = new BinaryFrame(ek, bArr);
                }
                if (id3Frame == null) {
                    try {
                        new StringBuilder("Failed to decode frame: id=").append(C41620a.m72923g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)).append(", frameSize=").append(i5);
                    } catch (UnsupportedEncodingException e) {
                        c32065l.setPosition(i3);
                        AppMethodBeat.m2505o(95314);
                        return null;
                    } catch (Throwable th) {
                        c32065l.setPosition(i3);
                        AppMethodBeat.m2505o(95314);
                    }
                }
                c32065l.setPosition(i3);
                AppMethodBeat.m2505o(95314);
                return id3Frame;
            }
            c32065l.setPosition(i3);
            AppMethodBeat.m2505o(95314);
            return null;
        } else {
            c32065l.setPosition(i3);
            AppMethodBeat.m2505o(95314);
            return null;
        }
    }

    /* renamed from: f */
    private static int m72922f(C32065l c32065l, int i) {
        AppMethodBeat.m2504i(95317);
        byte[] bArr = c32065l.data;
        int i2 = c32065l.position;
        int i3 = i;
        while (i2 + 1 < i3) {
            if ((bArr[i2] & 255) == 255 && bArr[i2 + 1] == (byte) 0) {
                System.arraycopy(bArr, i2 + 2, bArr, i2 + 1, (i3 - i2) - 2);
                i3--;
            }
            i2++;
        }
        AppMethodBeat.m2505o(95317);
        return i3;
    }

    /* renamed from: ek */
    private static String m72920ek(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }

    /* renamed from: g */
    private static String m72923g(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(95318);
        String format;
        if (i == 2) {
            format = String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            AppMethodBeat.m2505o(95318);
            return format;
        }
        format = String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        AppMethodBeat.m2505o(95318);
        return format;
    }

    /* renamed from: h */
    private static int m72924h(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95319);
        int e = C41620a.m72919e(bArr, i);
        if (i2 == 0 || i2 == 3) {
            AppMethodBeat.m2505o(95319);
            return e;
        }
        while (e < bArr.length - 1) {
            if (e % 2 == 0 && bArr[e + 1] == (byte) 0) {
                AppMethodBeat.m2505o(95319);
                return e;
            }
            e = C41620a.m72919e(bArr, e + 1);
        }
        e = bArr.length;
        AppMethodBeat.m2505o(95319);
        return e;
    }

    /* renamed from: e */
    private static int m72919e(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* renamed from: el */
    private static int m72921el(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    /* renamed from: i */
    private static byte[] m72925i(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95320);
        byte[] bArr2;
        if (i2 <= i) {
            bArr2 = new byte[0];
            AppMethodBeat.m2505o(95320);
            return bArr2;
        }
        bArr2 = Arrays.copyOfRange(bArr, i, i2);
        AppMethodBeat.m2505o(95320);
        return bArr2;
    }

    /* renamed from: a */
    private static boolean m72917a(C32065l c32065l, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(95313);
        int i3 = c32065l.position;
        while (c32065l.mo52382tB() >= i2) {
            try {
                int readInt;
                long cM;
                int readUnsignedShort;
                if (i >= 3) {
                    readInt = c32065l.readInt();
                    cM = c32065l.mo52366cM();
                    readUnsignedShort = c32065l.readUnsignedShort();
                } else {
                    readInt = c32065l.mo52384tD();
                    cM = (long) c32065l.mo52384tD();
                    readUnsignedShort = 0;
                }
                if (readInt == 0 && cM == 0 && readUnsignedShort == 0) {
                    c32065l.setPosition(i3);
                    AppMethodBeat.m2505o(95313);
                    return true;
                }
                long j;
                Object obj;
                if (i != 4 || z) {
                    j = cM;
                } else if ((8421504 & cM) != 0) {
                    c32065l.setPosition(i3);
                    AppMethodBeat.m2505o(95313);
                    return false;
                } else {
                    j = (((cM >> 24) & 255) << 21) | (((255 & cM) | (((cM >> 8) & 255) << 7)) | (((cM >> 16) & 255) << 14));
                }
                Object obj2 = null;
                if (i == 4) {
                    obj2 = (readUnsignedShort & 64) != 0 ? 1 : null;
                    obj = (readUnsignedShort & 1) != 0 ? 1 : null;
                } else if (i == 3) {
                    obj2 = (readUnsignedShort & 32) != 0 ? 1 : null;
                    obj = (readUnsignedShort & 128) != 0 ? 1 : null;
                } else {
                    obj = null;
                }
                int i4 = 0;
                if (obj2 != null) {
                    i4 = 1;
                }
                if (obj != null) {
                    i4 += 4;
                }
                if (j < ((long) i4)) {
                    c32065l.setPosition(i3);
                    AppMethodBeat.m2505o(95313);
                    return false;
                } else if (((long) c32065l.mo52382tB()) < j) {
                    c32065l.setPosition(i3);
                    AppMethodBeat.m2505o(95313);
                    return false;
                } else {
                    c32065l.mo52369eM((int) j);
                }
            } catch (Throwable th) {
                c32065l.setPosition(i3);
                AppMethodBeat.m2505o(95313);
            }
        }
        c32065l.setPosition(i3);
        AppMethodBeat.m2505o(95313);
        return true;
    }

    /* renamed from: a */
    private static ChapterFrame m72915a(C32065l c32065l, int i, int i2, boolean z, int i3, C8699a c8699a) {
        AppMethodBeat.m2504i(95315);
        int i4 = c32065l.position;
        int e = C41620a.m72919e(c32065l.data, i4);
        String str = new String(c32065l.data, i4, e - i4, "ISO-8859-1");
        c32065l.setPosition(e + 1);
        e = c32065l.readInt();
        int readInt = c32065l.readInt();
        long cM = c32065l.mo52366cM();
        if (cM == 4294967295L) {
            cM = -1;
        }
        long cM2 = c32065l.mo52366cM();
        if (cM2 == 4294967295L) {
            cM2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (c32065l.position < i4) {
            Id3Frame a = C41620a.m72916a(i2, c32065l, z, i3, c8699a);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        ChapterFrame chapterFrame = new ChapterFrame(str, e, readInt, cM, cM2, id3FrameArr);
        AppMethodBeat.m2505o(95315);
        return chapterFrame;
    }

    /* renamed from: b */
    private static ChapterTocFrame m72918b(C32065l c32065l, int i, int i2, boolean z, int i3, C8699a c8699a) {
        AppMethodBeat.m2504i(95316);
        int i4 = c32065l.position;
        int e = C41620a.m72919e(c32065l.data, i4);
        String str = new String(c32065l.data, i4, e - i4, "ISO-8859-1");
        c32065l.setPosition(e + 1);
        e = c32065l.readUnsignedByte();
        boolean z2 = (e & 2) != 0;
        boolean z3 = (e & 1) != 0;
        int readUnsignedByte = c32065l.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte];
        for (e = 0; e < readUnsignedByte; e++) {
            int i5 = c32065l.position;
            int e2 = C41620a.m72919e(c32065l.data, i5);
            strArr[e] = new String(c32065l.data, i5, e2 - i5, "ISO-8859-1");
            c32065l.setPosition(e2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (c32065l.position < i4) {
            Id3Frame a = C41620a.m72916a(i2, c32065l, z, i3, c8699a);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        ChapterTocFrame chapterTocFrame = new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
        AppMethodBeat.m2505o(95316);
        return chapterTocFrame;
    }
}
