package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;

final class f {
    private static final int aYD = v.aT("nam");
    private static final int aYE = v.aT("trk");
    private static final int aYF = v.aT("cmt");
    private static final int aYG = v.aT("day");
    private static final int aYH = v.aT("ART");
    private static final int aYI = v.aT("too");
    private static final int aYJ = v.aT("alb");
    private static final int aYK = v.aT("com");
    private static final int aYL = v.aT("wrt");
    private static final int aYM = v.aT("lyr");
    private static final int aYN = v.aT("gen");
    private static final int aYO = v.aT("covr");
    private static final int aYP = v.aT("gnre");
    private static final int aYQ = v.aT("grp");
    private static final int aYR = v.aT("disk");
    private static final int aYS = v.aT("trkn");
    private static final int aYT = v.aT("tmpo");
    private static final int aYU = v.aT("cpil");
    private static final int aYV = v.aT("aART");
    private static final int aYW = v.aT("sonm");
    private static final int aYX = v.aT("soal");
    private static final int aYY = v.aT("soar");
    private static final int aYZ = v.aT("soaa");
    private static final int aZa = v.aT("soco");
    private static final int aZb = v.aT("rtng");
    private static final int aZc = v.aT("pgap");
    private static final int aZd = v.aT("sosn");
    private static final int aZe = v.aT("tvsh");
    private static final int aZf = v.aT("----");
    private static final String[] aZg = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    static {
        AppMethodBeat.i(94996);
        AppMethodBeat.o(94996);
    }

    private static TextInformationFrame a(int i, String str, l lVar) {
        AppMethodBeat.i(94991);
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.aXm) {
            lVar.eM(8);
            TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, lVar.eN(readInt - 16));
            AppMethodBeat.o(94991);
            return textInformationFrame;
        }
        new StringBuilder("Failed to parse text attribute: ").append(a.dV(i));
        AppMethodBeat.o(94991);
        return null;
    }

    private static Id3Frame a(int i, String str, l lVar, boolean z, boolean z2) {
        int min;
        AppMethodBeat.i(94992);
        int p = p(lVar);
        if (z2) {
            min = Math.min(1, p);
        } else {
            min = p;
        }
        if (min < 0) {
            new StringBuilder("Failed to parse uint8 attribute: ").append(a.dV(i));
            AppMethodBeat.o(94992);
            return null;
        } else if (z) {
            TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, Integer.toString(min));
            AppMethodBeat.o(94992);
            return textInformationFrame;
        } else {
            Id3Frame commentFrame = new CommentFrame("und", str, Integer.toString(min));
            AppMethodBeat.o(94992);
            return commentFrame;
        }
    }

    private static TextInformationFrame b(int i, String str, l lVar) {
        AppMethodBeat.i(94993);
        int readInt = lVar.readInt();
        if (lVar.readInt() == a.aXm && readInt >= 22) {
            lVar.eM(10);
            readInt = lVar.readUnsignedShort();
            if (readInt > 0) {
                String valueOf = String.valueOf(readInt);
                int readUnsignedShort = lVar.readUnsignedShort();
                if (readUnsignedShort > 0) {
                    valueOf = valueOf + "/" + readUnsignedShort;
                }
                TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, valueOf);
                AppMethodBeat.o(94993);
                return textInformationFrame;
            }
        }
        new StringBuilder("Failed to parse index/count attribute: ").append(a.dV(i));
        AppMethodBeat.o(94993);
        return null;
    }

    private static int p(l lVar) {
        AppMethodBeat.i(94995);
        lVar.eM(4);
        if (lVar.readInt() == a.aXm) {
            lVar.eM(8);
            int readUnsignedByte = lVar.readUnsignedByte();
            AppMethodBeat.o(94995);
            return readUnsignedByte;
        }
        AppMethodBeat.o(94995);
        return -1;
    }

    public static Entry o(l lVar) {
        Entry entry = null;
        AppMethodBeat.i(94990);
        int readInt = lVar.readInt() + lVar.position;
        int readInt2 = lVar.readInt();
        int i = (readInt2 >> 24) & 255;
        String eN;
        if (i == 169 || i == BitUtils.BIT_TURN_ZERO_2) {
            i = 16777215 & readInt2;
            try {
                if (i == aYF) {
                    i = lVar.readInt();
                    if (lVar.readInt() == a.aXm) {
                        lVar.eM(8);
                        eN = lVar.eN(i - 16);
                        entry = new CommentFrame("und", eN, eN);
                    } else {
                        new StringBuilder("Failed to parse comment attribute: ").append(a.dV(readInt2));
                    }
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYD || i == aYE) {
                    entry = a(readInt2, "TIT2", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYK || i == aYL) {
                    entry = a(readInt2, "TCOM", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYG) {
                    entry = a(readInt2, "TDRC", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYH) {
                    entry = a(readInt2, "TPE1", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYI) {
                    entry = a(readInt2, "TSSE", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYJ) {
                    entry = a(readInt2, "TALB", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYM) {
                    entry = a(readInt2, "USLT", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else if (i == aYN) {
                    entry = a(readInt2, "TCON", lVar);
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                } else {
                    if (i == aYQ) {
                        entry = a(readInt2, "TIT1", lVar);
                        lVar.setPosition(readInt);
                        AppMethodBeat.o(94990);
                    }
                    new StringBuilder("Skipped unknown metadata entry: ").append(a.dV(readInt2));
                    lVar.setPosition(readInt);
                    AppMethodBeat.o(94990);
                }
            } catch (Throwable th) {
                lVar.setPosition(readInt);
                AppMethodBeat.o(94990);
            }
        } else if (readInt2 == aYP) {
            readInt2 = p(lVar);
            eN = (readInt2 <= 0 || readInt2 > aZg.length) ? null : aZg[readInt2 - 1];
            if (eN != null) {
                entry = new TextInformationFrame("TCON", null, eN);
            }
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYR) {
            entry = b(readInt2, "TPOS", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYS) {
            entry = b(readInt2, "TRCK", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYT) {
            entry = a(readInt2, "TBPM", lVar, true, false);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYU) {
            entry = a(readInt2, "TCMP", lVar, true, true);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYO) {
            i = lVar.readInt();
            if (lVar.readInt() == a.aXm) {
                readInt2 = a.dU(lVar.readInt());
                eN = readInt2 == 13 ? "image/jpeg" : readInt2 == 14 ? "image/png" : null;
                if (eN != null) {
                    lVar.eM(4);
                    byte[] bArr = new byte[(i - 16)];
                    lVar.readBytes(bArr, 0, bArr.length);
                    entry = new ApicFrame(eN, null, 3, bArr);
                }
            }
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYV) {
            entry = a(readInt2, "TPE2", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYW) {
            entry = a(readInt2, "TSOT", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYX) {
            entry = a(readInt2, "TSO2", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYY) {
            entry = a(readInt2, "TSOA", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aYZ) {
            entry = a(readInt2, "TSOP", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aZa) {
            entry = a(readInt2, "TSOC", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aZb) {
            entry = a(readInt2, "ITUNESADVISORY", lVar, false, false);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aZc) {
            entry = a(readInt2, "ITUNESGAPLESS", lVar, false, true);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aZd) {
            entry = a(readInt2, "TVSHOWSORT", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else if (readInt2 == aZe) {
            entry = a(readInt2, "TVSHOW", lVar);
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        } else {
            if (readInt2 == aZf) {
                entry = d(lVar, readInt);
                lVar.setPosition(readInt);
                AppMethodBeat.o(94990);
            }
            new StringBuilder("Skipped unknown metadata entry: ").append(a.dV(readInt2));
            lVar.setPosition(readInt);
            AppMethodBeat.o(94990);
        }
        return entry;
    }

    private static Id3Frame d(l lVar, int i) {
        AppMethodBeat.i(94994);
        int i2 = -1;
        int i3 = -1;
        Object obj = null;
        Object obj2 = null;
        while (lVar.position < i) {
            int i4 = lVar.position;
            int readInt = lVar.readInt();
            int readInt2 = lVar.readInt();
            lVar.eM(4);
            if (readInt2 == a.aXk) {
                obj2 = lVar.eN(readInt - 12);
            } else if (readInt2 == a.aXl) {
                obj = lVar.eN(readInt - 12);
            } else {
                if (readInt2 == a.aXm) {
                    i2 = readInt;
                    i3 = i4;
                }
                lVar.eM(readInt - 12);
            }
        }
        if ("com.apple.iTunes".equals(obj2) && "iTunSMPB".equals(obj) && i3 != -1) {
            lVar.setPosition(i3);
            lVar.eM(16);
            Id3Frame commentFrame = new CommentFrame("und", obj, lVar.eN(i2 - 16));
            AppMethodBeat.o(94994);
            return commentFrame;
        }
        AppMethodBeat.o(94994);
        return null;
    }
}
