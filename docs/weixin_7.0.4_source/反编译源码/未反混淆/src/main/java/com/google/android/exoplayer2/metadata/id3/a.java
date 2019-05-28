package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public static final int bbg = v.aT("ID3");
    private final a bfv;

    public interface a {
        boolean f(int i, int i2, int i3, int i4, int i5);
    }

    static final class b {
        final int bfw;
        final boolean bfx;
        final int bfy;

        public b(int i, boolean z, int i2) {
            this.bfw = i;
            this.bfx = z;
            this.bfy = i2;
        }
    }

    static {
        AppMethodBeat.i(95321);
        AppMethodBeat.o(95321);
    }

    public a() {
        this(null);
    }

    public a(a aVar) {
        this.bfv = aVar;
    }

    public final Metadata a(d dVar) {
        AppMethodBeat.i(95310);
        ByteBuffer byteBuffer = dVar.aEY;
        Metadata d = d(byteBuffer.array(), byteBuffer.limit());
        AppMethodBeat.o(95310);
        return d;
    }

    public final Metadata d(byte[] bArr, int i) {
        AppMethodBeat.i(95311);
        List arrayList = new ArrayList();
        l lVar = new l(bArr, i);
        b x = x(lVar);
        if (x == null) {
            AppMethodBeat.o(95311);
            return null;
        }
        int i2;
        boolean z;
        int i3 = lVar.position;
        if (x.bfw == 2) {
            i2 = 6;
        } else {
            i2 = 10;
        }
        int i4 = x.bfy;
        if (x.bfx) {
            i4 = f(lVar, x.bfy);
        }
        lVar.eL(i4 + i3);
        if (a(lVar, x.bfw, i2, false)) {
            z = false;
        } else if (x.bfw == 4 && a(lVar, 4, i2, true)) {
            z = true;
        } else {
            new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(x.bfw);
            AppMethodBeat.o(95311);
            return null;
        }
        while (lVar.tB() >= i2) {
            Id3Frame a = a(x.bfw, lVar, z, i2, this.bfv);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Metadata metadata = new Metadata(arrayList);
        AppMethodBeat.o(95311);
        return metadata;
    }

    private static b x(l lVar) {
        AppMethodBeat.i(95312);
        if (lVar.tB() < 10) {
            AppMethodBeat.o(95312);
            return null;
        } else if (lVar.tD() != bbg) {
            AppMethodBeat.o(95312);
            return null;
        } else {
            int i;
            boolean z;
            int readUnsignedByte = lVar.readUnsignedByte();
            lVar.eM(1);
            int readUnsignedByte2 = lVar.readUnsignedByte();
            int tH = lVar.tH();
            if (readUnsignedByte == 2) {
                int i2;
                if ((readUnsignedByte2 & 64) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    AppMethodBeat.o(95312);
                    return null;
                }
                i = tH;
            } else if (readUnsignedByte == 3) {
                if (((readUnsignedByte2 & 64) != 0 ? 1 : 0) != 0) {
                    i = lVar.readInt();
                    lVar.eM(i);
                    tH -= i + 4;
                }
                i = tH;
            } else if (readUnsignedByte == 4) {
                if (((readUnsignedByte2 & 64) != 0 ? 1 : 0) != 0) {
                    i = lVar.tH();
                    lVar.eM(i - 4);
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
                AppMethodBeat.o(95312);
                return null;
            }
            if (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) {
                z = false;
            } else {
                z = true;
            }
            b bVar = new b(readUnsignedByte, z, i);
            AppMethodBeat.o(95312);
            return bVar;
        }
    }

    private static Id3Frame a(int i, l lVar, boolean z, int i2, a aVar) {
        int tI;
        int readUnsignedShort;
        AppMethodBeat.i(95314);
        int readUnsignedByte = lVar.readUnsignedByte();
        int readUnsignedByte2 = lVar.readUnsignedByte();
        int readUnsignedByte3 = lVar.readUnsignedByte();
        int readUnsignedByte4 = i >= 3 ? lVar.readUnsignedByte() : 0;
        if (i == 4) {
            tI = lVar.tI();
            if (!z) {
                tI = (((tI & 255) | (((tI >> 8) & 255) << 7)) | (((tI >> 16) & 255) << 14)) | (((tI >> 24) & 255) << 21);
            }
        } else if (i == 3) {
            tI = lVar.tI();
        } else {
            tI = lVar.tD();
        }
        if (i >= 3) {
            readUnsignedShort = lVar.readUnsignedShort();
        } else {
            readUnsignedShort = 0;
        }
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && tI == 0 && readUnsignedShort == 0) {
            lVar.setPosition(lVar.limit);
            AppMethodBeat.o(95314);
            return null;
        }
        int i3 = lVar.position + tI;
        if (i3 > lVar.limit) {
            lVar.setPosition(lVar.limit);
            AppMethodBeat.o(95314);
            return null;
        } else if (aVar == null || aVar.f(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
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
                    lVar.eM(1);
                } else {
                    i5 = tI;
                }
                if (i42 != null) {
                    i5 -= 4;
                    lVar.eM(4);
                }
                if (obj3 != null) {
                    i5 = f(lVar, i5);
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
                        readUnsignedByte5 = lVar.readUnsignedByte();
                        ek = ek(readUnsignedByte5);
                        bArr = new byte[(i5 - 1)];
                        lVar.readBytes(bArr, 0, i5 - 1);
                        h = h(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, h, ek);
                        h += el(readUnsignedByte5);
                        if (h < bArr.length) {
                            ek = new String(bArr, h, h(bArr, h, readUnsignedByte5) - h, ek);
                        } else {
                            ek = "";
                        }
                        id3Frame = new TextInformationFrame("TXXX", str, ek);
                    }
                } else if (readUnsignedByte == 84) {
                    ek = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = lVar.readUnsignedByte();
                        String ek3 = ek(readUnsignedByte5);
                        byte[] bArr3 = new byte[(i5 - 1)];
                        lVar.readBytes(bArr3, 0, i5 - 1);
                        id3Frame = new TextInformationFrame(ek, null, new String(bArr3, 0, h(bArr3, 0, readUnsignedByte5), ek3));
                    }
                } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = lVar.readUnsignedByte();
                        ek = ek(readUnsignedByte5);
                        bArr = new byte[(i5 - 1)];
                        lVar.readBytes(bArr, 0, i5 - 1);
                        h = h(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, h, ek);
                        i42 = h + el(readUnsignedByte5);
                        if (i42 < bArr.length) {
                            ek = new String(bArr, i42, e(bArr, i42) - i42, "ISO-8859-1");
                        } else {
                            ek = "";
                        }
                        id3Frame = new UrlLinkFrame("WXXX", str, ek);
                    }
                } else if (readUnsignedByte == 87) {
                    ek = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    bArr2 = new byte[i5];
                    lVar.readBytes(bArr2, 0, i5);
                    id3Frame = new UrlLinkFrame(ek, null, new String(bArr2, 0, e(bArr2, 0), "ISO-8859-1"));
                } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                    bArr2 = new byte[i5];
                    lVar.readBytes(bArr2, 0, i5);
                    i42 = e(bArr2, 0);
                    id3Frame = new PrivFrame(new String(bArr2, 0, i42, "ISO-8859-1"), i(bArr2, i42 + 1, bArr2.length));
                } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i == 2)) {
                    readUnsignedByte5 = lVar.readUnsignedByte();
                    ek = ek(readUnsignedByte5);
                    bArr = new byte[(i5 - 1)];
                    lVar.readBytes(bArr, 0, i5 - 1);
                    h = e(bArr, 0);
                    str = new String(bArr, 0, h, "ISO-8859-1");
                    h++;
                    h2 = h(bArr, h, readUnsignedByte5);
                    String str2 = new String(bArr, h, h2 - h, ek);
                    h = el(readUnsignedByte5) + h2;
                    h2 = h(bArr, h, readUnsignedByte5);
                    id3Frame = new GeobFrame(str, str2, new String(bArr, h, h2 - h, ek), i(bArr, el(readUnsignedByte5) + h2, bArr.length));
                } else if (!i != 2 ? !(readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) : !(readUnsignedByte == 65 && readUnsignedByte2 == 80 && readUnsignedByte3 == 73 && readUnsignedByte4 == 67)) {
                    int readUnsignedByte6 = lVar.readUnsignedByte();
                    ek2 = ek(readUnsignedByte6);
                    byte[] bArr4 = new byte[(i5 - 1)];
                    lVar.readBytes(bArr4, 0, i5 - 1);
                    if (i == 2) {
                        readUnsignedByte5 = 2;
                        ek = "image/" + v.aR(new String(bArr4, 0, 3, "ISO-8859-1"));
                        if (ek.equals("image/jpg")) {
                            ek = "image/jpeg";
                        }
                    } else {
                        readUnsignedByte5 = e(bArr4, 0);
                        ek = v.aR(new String(bArr4, 0, readUnsignedByte5, "ISO-8859-1"));
                        if (ek.indexOf(47) == -1) {
                            ek = "image/".concat(String.valueOf(ek));
                        }
                    }
                    h2 = bArr4[readUnsignedByte5 + 1] & 255;
                    readUnsignedByte5 += 2;
                    tI = h(bArr4, readUnsignedByte5, readUnsignedByte6);
                    id3Frame = new ApicFrame(ek, new String(bArr4, readUnsignedByte5, tI - readUnsignedByte5, ek2), h2, i(bArr4, el(readUnsignedByte6) + tI, bArr4.length));
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i == 2)) {
                    if (i5 < 4) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = lVar.readUnsignedByte();
                        ek = ek(readUnsignedByte5);
                        bArr = new byte[3];
                        lVar.readBytes(bArr, 0, 3);
                        ek2 = new String(bArr, 0, 3);
                        bArr = new byte[(i5 - 4)];
                        lVar.readBytes(bArr, 0, i5 - 4);
                        int h3 = h(bArr, 0, readUnsignedByte5);
                        String str3 = new String(bArr, 0, h3, ek);
                        h3 += el(readUnsignedByte5);
                        if (h3 < bArr.length) {
                            ek = new String(bArr, h3, h(bArr, h3, readUnsignedByte5) - h3, ek);
                        } else {
                            ek = "";
                        }
                        id3Frame = new CommentFrame(ek2, str3, ek);
                    }
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                    id3Frame = a(lVar, i5, i, z, i2, aVar);
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                    id3Frame = b(lVar, i5, i, z, i2, aVar);
                } else {
                    ek = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    bArr = new byte[i5];
                    lVar.readBytes(bArr, 0, i5);
                    id3Frame = new BinaryFrame(ek, bArr);
                }
                if (id3Frame == null) {
                    try {
                        new StringBuilder("Failed to decode frame: id=").append(g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)).append(", frameSize=").append(i5);
                    } catch (UnsupportedEncodingException e) {
                        lVar.setPosition(i3);
                        AppMethodBeat.o(95314);
                        return null;
                    } catch (Throwable th) {
                        lVar.setPosition(i3);
                        AppMethodBeat.o(95314);
                    }
                }
                lVar.setPosition(i3);
                AppMethodBeat.o(95314);
                return id3Frame;
            }
            lVar.setPosition(i3);
            AppMethodBeat.o(95314);
            return null;
        } else {
            lVar.setPosition(i3);
            AppMethodBeat.o(95314);
            return null;
        }
    }

    private static int f(l lVar, int i) {
        AppMethodBeat.i(95317);
        byte[] bArr = lVar.data;
        int i2 = lVar.position;
        int i3 = i;
        while (i2 + 1 < i3) {
            if ((bArr[i2] & 255) == 255 && bArr[i2 + 1] == (byte) 0) {
                System.arraycopy(bArr, i2 + 2, bArr, i2 + 1, (i3 - i2) - 2);
                i3--;
            }
            i2++;
        }
        AppMethodBeat.o(95317);
        return i3;
    }

    private static String ek(int i) {
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

    private static String g(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(95318);
        String format;
        if (i == 2) {
            format = String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            AppMethodBeat.o(95318);
            return format;
        }
        format = String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        AppMethodBeat.o(95318);
        return format;
    }

    private static int h(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95319);
        int e = e(bArr, i);
        if (i2 == 0 || i2 == 3) {
            AppMethodBeat.o(95319);
            return e;
        }
        while (e < bArr.length - 1) {
            if (e % 2 == 0 && bArr[e + 1] == (byte) 0) {
                AppMethodBeat.o(95319);
                return e;
            }
            e = e(bArr, e + 1);
        }
        e = bArr.length;
        AppMethodBeat.o(95319);
        return e;
    }

    private static int e(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static int el(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static byte[] i(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95320);
        byte[] bArr2;
        if (i2 <= i) {
            bArr2 = new byte[0];
            AppMethodBeat.o(95320);
            return bArr2;
        }
        bArr2 = Arrays.copyOfRange(bArr, i, i2);
        AppMethodBeat.o(95320);
        return bArr2;
    }

    private static boolean a(l lVar, int i, int i2, boolean z) {
        AppMethodBeat.i(95313);
        int i3 = lVar.position;
        while (lVar.tB() >= i2) {
            try {
                int readInt;
                long cM;
                int readUnsignedShort;
                if (i >= 3) {
                    readInt = lVar.readInt();
                    cM = lVar.cM();
                    readUnsignedShort = lVar.readUnsignedShort();
                } else {
                    readInt = lVar.tD();
                    cM = (long) lVar.tD();
                    readUnsignedShort = 0;
                }
                if (readInt == 0 && cM == 0 && readUnsignedShort == 0) {
                    lVar.setPosition(i3);
                    AppMethodBeat.o(95313);
                    return true;
                }
                long j;
                Object obj;
                if (i != 4 || z) {
                    j = cM;
                } else if ((8421504 & cM) != 0) {
                    lVar.setPosition(i3);
                    AppMethodBeat.o(95313);
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
                    lVar.setPosition(i3);
                    AppMethodBeat.o(95313);
                    return false;
                } else if (((long) lVar.tB()) < j) {
                    lVar.setPosition(i3);
                    AppMethodBeat.o(95313);
                    return false;
                } else {
                    lVar.eM((int) j);
                }
            } catch (Throwable th) {
                lVar.setPosition(i3);
                AppMethodBeat.o(95313);
            }
        }
        lVar.setPosition(i3);
        AppMethodBeat.o(95313);
        return true;
    }

    private static ChapterFrame a(l lVar, int i, int i2, boolean z, int i3, a aVar) {
        AppMethodBeat.i(95315);
        int i4 = lVar.position;
        int e = e(lVar.data, i4);
        String str = new String(lVar.data, i4, e - i4, "ISO-8859-1");
        lVar.setPosition(e + 1);
        e = lVar.readInt();
        int readInt = lVar.readInt();
        long cM = lVar.cM();
        if (cM == 4294967295L) {
            cM = -1;
        }
        long cM2 = lVar.cM();
        if (cM2 == 4294967295L) {
            cM2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (lVar.position < i4) {
            Id3Frame a = a(i2, lVar, z, i3, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        ChapterFrame chapterFrame = new ChapterFrame(str, e, readInt, cM, cM2, id3FrameArr);
        AppMethodBeat.o(95315);
        return chapterFrame;
    }

    private static ChapterTocFrame b(l lVar, int i, int i2, boolean z, int i3, a aVar) {
        AppMethodBeat.i(95316);
        int i4 = lVar.position;
        int e = e(lVar.data, i4);
        String str = new String(lVar.data, i4, e - i4, "ISO-8859-1");
        lVar.setPosition(e + 1);
        e = lVar.readUnsignedByte();
        boolean z2 = (e & 2) != 0;
        boolean z3 = (e & 1) != 0;
        int readUnsignedByte = lVar.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte];
        for (e = 0; e < readUnsignedByte; e++) {
            int i5 = lVar.position;
            int e2 = e(lVar.data, i5);
            strArr[e] = new String(lVar.data, i5, e2 - i5, "ISO-8859-1");
            lVar.setPosition(e2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (lVar.position < i4) {
            Id3Frame a = a(i2, lVar, z, i3, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        ChapterTocFrame chapterTocFrame = new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
        AppMethodBeat.o(95316);
        return chapterTocFrame;
    }
}
