package com.tencent.p177mm.plugin.p878a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.a.a */
public class C37990a {
    public static final int aVH = C42258c.m74641aT("ftyp");
    public static final int aVI = C42258c.m74641aT("avc1");
    public static final int aVJ = C42258c.m74641aT("avc3");
    public static final int aVK = C42258c.m74641aT("hvc1");
    public static final int aVL = C42258c.m74641aT("hev1");
    public static final int aVM = C42258c.m74641aT("s263");
    public static final int aVN = C42258c.m74641aT("d263");
    public static final int aVO = C42258c.m74641aT("mdat");
    public static final int aVP = C42258c.m74641aT("mp4a");
    public static final int aVR = C42258c.m74641aT("wave");
    public static final int aVU = C42258c.m74641aT("ac-3");
    public static final int aVV = C42258c.m74641aT("dac3");
    public static final int aVW = C42258c.m74641aT("ec-3");
    public static final int aVX = C42258c.m74641aT("dec3");
    public static final int aVY = C42258c.m74641aT("dtsc");
    public static final int aVZ = C42258c.m74641aT("dtsh");
    public static final int aWA = C42258c.m74641aT("stsd");
    public static final int aWB = C42258c.m74641aT("pssh");
    public static final int aWC = C42258c.m74641aT("sinf");
    public static final int aWD = C42258c.m74641aT("schm");
    public static final int aWE = C42258c.m74641aT("schi");
    public static final int aWF = C42258c.m74641aT("tenc");
    public static final int aWG = C42258c.m74641aT("encv");
    public static final int aWH = C42258c.m74641aT("enca");
    public static final int aWI = C42258c.m74641aT("frma");
    public static final int aWJ = C42258c.m74641aT("saiz");
    public static final int aWK = C42258c.m74641aT("saio");
    public static final int aWN = C42258c.m74641aT("uuid");
    public static final int aWO = C42258c.m74641aT("senc");
    public static final int aWP = C42258c.m74641aT("pasp");
    public static final int aWQ = C42258c.m74641aT("TTML");
    public static final int aWR = C42258c.m74641aT("vmhd");
    public static final int aWS = C42258c.m74641aT("mp4v");
    public static final int aWT = C42258c.m74641aT("stts");
    public static final int aWU = C42258c.m74641aT("stss");
    public static final int aWV = C42258c.m74641aT("ctts");
    public static final int aWW = C42258c.m74641aT("stsc");
    public static final int aWX = C42258c.m74641aT("stsz");
    public static final int aWZ = C42258c.m74641aT("stco");
    public static final int aWa = C42258c.m74641aT("dtsl");
    public static final int aWb = C42258c.m74641aT("dtse");
    public static final int aWc = C42258c.m74641aT("ddts");
    public static final int aWd = C42258c.m74641aT("tfdt");
    public static final int aWe = C42258c.m74641aT("tfhd");
    public static final int aWf = C42258c.m74641aT("trex");
    public static final int aWg = C42258c.m74641aT("trun");
    public static final int aWh = C42258c.m74641aT("sidx");
    public static final int aWi = C42258c.m74641aT("moov");
    public static final int aWj = C42258c.m74641aT("mvhd");
    public static final int aWk = C42258c.m74641aT("trak");
    public static final int aWl = C42258c.m74641aT("mdia");
    public static final int aWm = C42258c.m74641aT("minf");
    public static final int aWn = C42258c.m74641aT("stbl");
    public static final int aWo = C42258c.m74641aT("avcC");
    public static final int aWp = C42258c.m74641aT("hvcC");
    public static final int aWq = C42258c.m74641aT("esds");
    public static final int aWr = C42258c.m74641aT("moof");
    public static final int aWs = C42258c.m74641aT("traf");
    public static final int aWt = C42258c.m74641aT("mvex");
    public static final int aWv = C42258c.m74641aT("tkhd");
    public static final int aWw = C42258c.m74641aT("edts");
    public static final int aWx = C42258c.m74641aT("elst");
    public static final int aWy = C42258c.m74641aT("mdhd");
    public static final int aWz = C42258c.m74641aT("hdlr");
    public static final int aXa = C42258c.m74641aT("co64");
    public static final int aXb = C42258c.m74641aT("tx3g");
    public static final int aXc = C42258c.m74641aT("wvtt");
    public static final int aXd = C42258c.m74641aT("stpp");
    public static final int aXf = C42258c.m74641aT("samr");
    public static final int aXg = C42258c.m74641aT("sawb");
    public static final int aXh = C42258c.m74641aT("udta");
    public static final int aXi = C42258c.m74641aT("meta");
    public static final int aXj = C42258c.m74641aT("ilst");
    public static final int aXk = C42258c.m74641aT("mean");
    public static final int aXl = C42258c.m74641aT("name");
    public static final int aXm = C42258c.m74641aT("data");
    public static final int gjK = C42258c.m74641aT("----");
    private int gjL;
    private long gjM;
    public long gjN;
    private int type;

    static {
        AppMethodBeat.m2504i(117828);
        AppMethodBeat.m2505o(117828);
    }

    public C37990a(int i, long j, int i2, long j2) {
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
        AppMethodBeat.m2504i(117826);
        long size = this.gjN + getSize();
        AppMethodBeat.m2505o(117826);
        return size;
    }

    public final long getSize() {
        if (this.gjM > 0) {
            return this.gjM;
        }
        return (long) this.gjL;
    }

    public String toString() {
        AppMethodBeat.m2504i(117827);
        StringBuilder append = new StringBuilder("Atom{atomSize=").append(this.gjL).append(", atomLargeSize=").append(this.gjM).append(", type=");
        int i = this.type;
        String stringBuilder = append.append(new String(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)})).append(", beginPos=").append(this.gjN).append('}').toString();
        AppMethodBeat.m2505o(117827);
        return stringBuilder;
    }
}
