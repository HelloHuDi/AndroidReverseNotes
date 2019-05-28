package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    public static final int aVH = c.aT("ftyp");
    public static final int aVI = c.aT("avc1");
    public static final int aVJ = c.aT("avc3");
    public static final int aVK = c.aT("hvc1");
    public static final int aVL = c.aT("hev1");
    public static final int aVM = c.aT("s263");
    public static final int aVN = c.aT("d263");
    public static final int aVO = c.aT("mdat");
    public static final int aVP = c.aT("mp4a");
    public static final int aVR = c.aT("wave");
    public static final int aVU = c.aT("ac-3");
    public static final int aVV = c.aT("dac3");
    public static final int aVW = c.aT("ec-3");
    public static final int aVX = c.aT("dec3");
    public static final int aVY = c.aT("dtsc");
    public static final int aVZ = c.aT("dtsh");
    public static final int aWA = c.aT("stsd");
    public static final int aWB = c.aT("pssh");
    public static final int aWC = c.aT("sinf");
    public static final int aWD = c.aT("schm");
    public static final int aWE = c.aT("schi");
    public static final int aWF = c.aT("tenc");
    public static final int aWG = c.aT("encv");
    public static final int aWH = c.aT("enca");
    public static final int aWI = c.aT("frma");
    public static final int aWJ = c.aT("saiz");
    public static final int aWK = c.aT("saio");
    public static final int aWN = c.aT("uuid");
    public static final int aWO = c.aT("senc");
    public static final int aWP = c.aT("pasp");
    public static final int aWQ = c.aT("TTML");
    public static final int aWR = c.aT("vmhd");
    public static final int aWS = c.aT("mp4v");
    public static final int aWT = c.aT("stts");
    public static final int aWU = c.aT("stss");
    public static final int aWV = c.aT("ctts");
    public static final int aWW = c.aT("stsc");
    public static final int aWX = c.aT("stsz");
    public static final int aWZ = c.aT("stco");
    public static final int aWa = c.aT("dtsl");
    public static final int aWb = c.aT("dtse");
    public static final int aWc = c.aT("ddts");
    public static final int aWd = c.aT("tfdt");
    public static final int aWe = c.aT("tfhd");
    public static final int aWf = c.aT("trex");
    public static final int aWg = c.aT("trun");
    public static final int aWh = c.aT("sidx");
    public static final int aWi = c.aT("moov");
    public static final int aWj = c.aT("mvhd");
    public static final int aWk = c.aT("trak");
    public static final int aWl = c.aT("mdia");
    public static final int aWm = c.aT("minf");
    public static final int aWn = c.aT("stbl");
    public static final int aWo = c.aT("avcC");
    public static final int aWp = c.aT("hvcC");
    public static final int aWq = c.aT("esds");
    public static final int aWr = c.aT("moof");
    public static final int aWs = c.aT("traf");
    public static final int aWt = c.aT("mvex");
    public static final int aWv = c.aT("tkhd");
    public static final int aWw = c.aT("edts");
    public static final int aWx = c.aT("elst");
    public static final int aWy = c.aT("mdhd");
    public static final int aWz = c.aT("hdlr");
    public static final int aXa = c.aT("co64");
    public static final int aXb = c.aT("tx3g");
    public static final int aXc = c.aT("wvtt");
    public static final int aXd = c.aT("stpp");
    public static final int aXf = c.aT("samr");
    public static final int aXg = c.aT("sawb");
    public static final int aXh = c.aT("udta");
    public static final int aXi = c.aT("meta");
    public static final int aXj = c.aT("ilst");
    public static final int aXk = c.aT("mean");
    public static final int aXl = c.aT("name");
    public static final int aXm = c.aT("data");
    public static final int gjK = c.aT("----");
    private int gjL;
    private long gjM;
    public long gjN;
    private int type;

    static {
        AppMethodBeat.i(117828);
        AppMethodBeat.o(117828);
    }

    public a(int i, long j, int i2, long j2) {
        this.gjL = i;
        this.gjN = j;
        this.type = i2;
        this.gjM = j2;
    }

    public final boolean anX() {
        return this.type == aWi;
    }

    public final boolean anY() {
        return this.gjL == 0;
    }

    public final long getEndPos() {
        AppMethodBeat.i(117826);
        long size = this.gjN + getSize();
        AppMethodBeat.o(117826);
        return size;
    }

    public final long getSize() {
        if (this.gjM > 0) {
            return this.gjM;
        }
        return (long) this.gjL;
    }

    public String toString() {
        AppMethodBeat.i(117827);
        StringBuilder append = new StringBuilder("Atom{atomSize=").append(this.gjL).append(", atomLargeSize=").append(this.gjM).append(", type=");
        int i = this.type;
        String stringBuilder = append.append(new String(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)})).append(", beginPos=").append(this.gjN).append('}').toString();
        AppMethodBeat.o(117827);
        return stringBuilder;
    }
}
