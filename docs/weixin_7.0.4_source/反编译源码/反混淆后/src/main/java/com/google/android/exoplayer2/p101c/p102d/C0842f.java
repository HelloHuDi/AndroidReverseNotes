package com.google.android.exoplayer2.p101c.p102d;

import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;

/* renamed from: com.google.android.exoplayer2.c.d.f */
final class C0842f {
    private static final int aYD = C17675v.m27562aT("nam");
    private static final int aYE = C17675v.m27562aT("trk");
    private static final int aYF = C17675v.m27562aT("cmt");
    private static final int aYG = C17675v.m27562aT("day");
    private static final int aYH = C17675v.m27562aT("ART");
    private static final int aYI = C17675v.m27562aT("too");
    private static final int aYJ = C17675v.m27562aT("alb");
    private static final int aYK = C17675v.m27562aT("com");
    private static final int aYL = C17675v.m27562aT("wrt");
    private static final int aYM = C17675v.m27562aT("lyr");
    private static final int aYN = C17675v.m27562aT("gen");
    private static final int aYO = C17675v.m27562aT("covr");
    private static final int aYP = C17675v.m27562aT("gnre");
    private static final int aYQ = C17675v.m27562aT("grp");
    private static final int aYR = C17675v.m27562aT("disk");
    private static final int aYS = C17675v.m27562aT("trkn");
    private static final int aYT = C17675v.m27562aT("tmpo");
    private static final int aYU = C17675v.m27562aT("cpil");
    private static final int aYV = C17675v.m27562aT("aART");
    private static final int aYW = C17675v.m27562aT("sonm");
    private static final int aYX = C17675v.m27562aT("soal");
    private static final int aYY = C17675v.m27562aT("soar");
    private static final int aYZ = C17675v.m27562aT("soaa");
    private static final int aZa = C17675v.m27562aT("soco");
    private static final int aZb = C17675v.m27562aT("rtng");
    private static final int aZc = C17675v.m27562aT("pgap");
    private static final int aZd = C17675v.m27562aT("sosn");
    private static final int aZe = C17675v.m27562aT("tvsh");
    private static final int aZf = C17675v.m27562aT("----");
    private static final String[] aZg = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    static {
        AppMethodBeat.m2504i(94996);
        AppMethodBeat.m2505o(94996);
    }

    /* renamed from: a */
    private static TextInformationFrame m1924a(int i, String str, C32065l c32065l) {
        AppMethodBeat.m2504i(94991);
        int readInt = c32065l.readInt();
        if (c32065l.readInt() == C32025a.aXm) {
            c32065l.mo52369eM(8);
            TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, c32065l.mo52370eN(readInt - 16));
            AppMethodBeat.m2505o(94991);
            return textInformationFrame;
        }
        new StringBuilder("Failed to parse text attribute: ").append(C32025a.m52019dV(i));
        AppMethodBeat.m2505o(94991);
        return null;
    }

    /* renamed from: a */
    private static Id3Frame m1923a(int i, String str, C32065l c32065l, boolean z, boolean z2) {
        int min;
        AppMethodBeat.m2504i(94992);
        int p = C0842f.m1928p(c32065l);
        if (z2) {
            min = Math.min(1, p);
        } else {
            min = p;
        }
        if (min < 0) {
            new StringBuilder("Failed to parse uint8 attribute: ").append(C32025a.m52019dV(i));
            AppMethodBeat.m2505o(94992);
            return null;
        } else if (z) {
            TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, Integer.toString(min));
            AppMethodBeat.m2505o(94992);
            return textInformationFrame;
        } else {
            Id3Frame commentFrame = new CommentFrame("und", str, Integer.toString(min));
            AppMethodBeat.m2505o(94992);
            return commentFrame;
        }
    }

    /* renamed from: b */
    private static TextInformationFrame m1925b(int i, String str, C32065l c32065l) {
        AppMethodBeat.m2504i(94993);
        int readInt = c32065l.readInt();
        if (c32065l.readInt() == C32025a.aXm && readInt >= 22) {
            c32065l.mo52369eM(10);
            readInt = c32065l.readUnsignedShort();
            if (readInt > 0) {
                String valueOf = String.valueOf(readInt);
                int readUnsignedShort = c32065l.readUnsignedShort();
                if (readUnsignedShort > 0) {
                    valueOf = valueOf + "/" + readUnsignedShort;
                }
                TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, valueOf);
                AppMethodBeat.m2505o(94993);
                return textInformationFrame;
            }
        }
        new StringBuilder("Failed to parse index/count attribute: ").append(C32025a.m52019dV(i));
        AppMethodBeat.m2505o(94993);
        return null;
    }

    /* renamed from: p */
    private static int m1928p(C32065l c32065l) {
        AppMethodBeat.m2504i(94995);
        c32065l.mo52369eM(4);
        if (c32065l.readInt() == C32025a.aXm) {
            c32065l.mo52369eM(8);
            int readUnsignedByte = c32065l.readUnsignedByte();
            AppMethodBeat.m2505o(94995);
            return readUnsignedByte;
        }
        AppMethodBeat.m2505o(94995);
        return -1;
    }

    /* renamed from: o */
    public static Entry m1927o(C32065l c32065l) {
        Entry entry = null;
        AppMethodBeat.m2504i(94990);
        int readInt = c32065l.readInt() + c32065l.position;
        int readInt2 = c32065l.readInt();
        int i = (readInt2 >> 24) & 255;
        String eN;
        if (i == 169 || i == BitUtils.BIT_TURN_ZERO_2) {
            i = 16777215 & readInt2;
            try {
                if (i == aYF) {
                    i = c32065l.readInt();
                    if (c32065l.readInt() == C32025a.aXm) {
                        c32065l.mo52369eM(8);
                        eN = c32065l.mo52370eN(i - 16);
                        entry = new CommentFrame("und", eN, eN);
                    } else {
                        new StringBuilder("Failed to parse comment attribute: ").append(C32025a.m52019dV(readInt2));
                    }
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYD || i == aYE) {
                    entry = C0842f.m1924a(readInt2, "TIT2", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYK || i == aYL) {
                    entry = C0842f.m1924a(readInt2, "TCOM", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYG) {
                    entry = C0842f.m1924a(readInt2, "TDRC", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYH) {
                    entry = C0842f.m1924a(readInt2, "TPE1", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYI) {
                    entry = C0842f.m1924a(readInt2, "TSSE", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYJ) {
                    entry = C0842f.m1924a(readInt2, "TALB", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYM) {
                    entry = C0842f.m1924a(readInt2, "USLT", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else if (i == aYN) {
                    entry = C0842f.m1924a(readInt2, "TCON", c32065l);
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                } else {
                    if (i == aYQ) {
                        entry = C0842f.m1924a(readInt2, "TIT1", c32065l);
                        c32065l.setPosition(readInt);
                        AppMethodBeat.m2505o(94990);
                    }
                    new StringBuilder("Skipped unknown metadata entry: ").append(C32025a.m52019dV(readInt2));
                    c32065l.setPosition(readInt);
                    AppMethodBeat.m2505o(94990);
                }
            } catch (Throwable th) {
                c32065l.setPosition(readInt);
                AppMethodBeat.m2505o(94990);
            }
        } else if (readInt2 == aYP) {
            readInt2 = C0842f.m1928p(c32065l);
            eN = (readInt2 <= 0 || readInt2 > aZg.length) ? null : aZg[readInt2 - 1];
            if (eN != null) {
                entry = new TextInformationFrame("TCON", null, eN);
            }
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYR) {
            entry = C0842f.m1925b(readInt2, "TPOS", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYS) {
            entry = C0842f.m1925b(readInt2, "TRCK", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYT) {
            entry = C0842f.m1923a(readInt2, "TBPM", c32065l, true, false);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYU) {
            entry = C0842f.m1923a(readInt2, "TCMP", c32065l, true, true);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYO) {
            i = c32065l.readInt();
            if (c32065l.readInt() == C32025a.aXm) {
                readInt2 = C32025a.m52018dU(c32065l.readInt());
                eN = readInt2 == 13 ? "image/jpeg" : readInt2 == 14 ? "image/png" : null;
                if (eN != null) {
                    c32065l.mo52369eM(4);
                    byte[] bArr = new byte[(i - 16)];
                    c32065l.readBytes(bArr, 0, bArr.length);
                    entry = new ApicFrame(eN, null, 3, bArr);
                }
            }
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYV) {
            entry = C0842f.m1924a(readInt2, "TPE2", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYW) {
            entry = C0842f.m1924a(readInt2, "TSOT", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYX) {
            entry = C0842f.m1924a(readInt2, "TSO2", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYY) {
            entry = C0842f.m1924a(readInt2, "TSOA", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aYZ) {
            entry = C0842f.m1924a(readInt2, "TSOP", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aZa) {
            entry = C0842f.m1924a(readInt2, "TSOC", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aZb) {
            entry = C0842f.m1923a(readInt2, "ITUNESADVISORY", c32065l, false, false);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aZc) {
            entry = C0842f.m1923a(readInt2, "ITUNESGAPLESS", c32065l, false, true);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aZd) {
            entry = C0842f.m1924a(readInt2, "TVSHOWSORT", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else if (readInt2 == aZe) {
            entry = C0842f.m1924a(readInt2, "TVSHOW", c32065l);
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        } else {
            if (readInt2 == aZf) {
                entry = C0842f.m1926d(c32065l, readInt);
                c32065l.setPosition(readInt);
                AppMethodBeat.m2505o(94990);
            }
            new StringBuilder("Skipped unknown metadata entry: ").append(C32025a.m52019dV(readInt2));
            c32065l.setPosition(readInt);
            AppMethodBeat.m2505o(94990);
        }
        return entry;
    }

    /* renamed from: d */
    private static Id3Frame m1926d(C32065l c32065l, int i) {
        AppMethodBeat.m2504i(94994);
        int i2 = -1;
        int i3 = -1;
        Object obj = null;
        Object obj2 = null;
        while (c32065l.position < i) {
            int i4 = c32065l.position;
            int readInt = c32065l.readInt();
            int readInt2 = c32065l.readInt();
            c32065l.mo52369eM(4);
            if (readInt2 == C32025a.aXk) {
                obj2 = c32065l.mo52370eN(readInt - 12);
            } else if (readInt2 == C32025a.aXl) {
                obj = c32065l.mo52370eN(readInt - 12);
            } else {
                if (readInt2 == C32025a.aXm) {
                    i2 = readInt;
                    i3 = i4;
                }
                c32065l.mo52369eM(readInt - 12);
            }
        }
        if ("com.apple.iTunes".equals(obj2) && "iTunSMPB".equals(obj) && i3 != -1) {
            c32065l.setPosition(i3);
            c32065l.mo52369eM(16);
            Id3Frame commentFrame = new CommentFrame("und", obj, c32065l.mo52370eN(i2 - 16));
            AppMethodBeat.m2505o(94994);
            return commentFrame;
        }
        AppMethodBeat.m2505o(94994);
        return null;
    }
}
