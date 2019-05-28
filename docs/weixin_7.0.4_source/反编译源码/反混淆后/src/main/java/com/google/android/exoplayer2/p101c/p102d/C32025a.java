package com.google.android.exoplayer2.p101c.p102d;

import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.d.a */
abstract class C32025a {
    public static final int aVH = C17675v.m27562aT("ftyp");
    public static final int aVI = C17675v.m27562aT("avc1");
    public static final int aVJ = C17675v.m27562aT("avc3");
    public static final int aVK = C17675v.m27562aT("hvc1");
    public static final int aVL = C17675v.m27562aT("hev1");
    public static final int aVM = C17675v.m27562aT("s263");
    public static final int aVN = C17675v.m27562aT("d263");
    public static final int aVO = C17675v.m27562aT("mdat");
    public static final int aVP = C17675v.m27562aT("mp4a");
    public static final int aVQ = C17675v.m27562aT(".mp3");
    public static final int aVR = C17675v.m27562aT("wave");
    public static final int aVS = C17675v.m27562aT("lpcm");
    public static final int aVT = C17675v.m27562aT("sowt");
    public static final int aVU = C17675v.m27562aT("ac-3");
    public static final int aVV = C17675v.m27562aT("dac3");
    public static final int aVW = C17675v.m27562aT("ec-3");
    public static final int aVX = C17675v.m27562aT("dec3");
    public static final int aVY = C17675v.m27562aT("dtsc");
    public static final int aVZ = C17675v.m27562aT("dtsh");
    public static final int aWA = C17675v.m27562aT("stsd");
    public static final int aWB = C17675v.m27562aT("pssh");
    public static final int aWC = C17675v.m27562aT("sinf");
    public static final int aWD = C17675v.m27562aT("schm");
    public static final int aWE = C17675v.m27562aT("schi");
    public static final int aWF = C17675v.m27562aT("tenc");
    public static final int aWG = C17675v.m27562aT("encv");
    public static final int aWH = C17675v.m27562aT("enca");
    public static final int aWI = C17675v.m27562aT("frma");
    public static final int aWJ = C17675v.m27562aT("saiz");
    public static final int aWK = C17675v.m27562aT("saio");
    public static final int aWL = C17675v.m27562aT("sbgp");
    public static final int aWM = C17675v.m27562aT("sgpd");
    public static final int aWN = C17675v.m27562aT("uuid");
    public static final int aWO = C17675v.m27562aT("senc");
    public static final int aWP = C17675v.m27562aT("pasp");
    public static final int aWQ = C17675v.m27562aT("TTML");
    public static final int aWR = C17675v.m27562aT("vmhd");
    public static final int aWS = C17675v.m27562aT("mp4v");
    public static final int aWT = C17675v.m27562aT("stts");
    public static final int aWU = C17675v.m27562aT("stss");
    public static final int aWV = C17675v.m27562aT("ctts");
    public static final int aWW = C17675v.m27562aT("stsc");
    public static final int aWX = C17675v.m27562aT("stsz");
    public static final int aWY = C17675v.m27562aT("stz2");
    public static final int aWZ = C17675v.m27562aT("stco");
    public static final int aWa = C17675v.m27562aT("dtsl");
    public static final int aWb = C17675v.m27562aT("dtse");
    public static final int aWc = C17675v.m27562aT("ddts");
    public static final int aWd = C17675v.m27562aT("tfdt");
    public static final int aWe = C17675v.m27562aT("tfhd");
    public static final int aWf = C17675v.m27562aT("trex");
    public static final int aWg = C17675v.m27562aT("trun");
    public static final int aWh = C17675v.m27562aT("sidx");
    public static final int aWi = C17675v.m27562aT("moov");
    public static final int aWj = C17675v.m27562aT("mvhd");
    public static final int aWk = C17675v.m27562aT("trak");
    public static final int aWl = C17675v.m27562aT("mdia");
    public static final int aWm = C17675v.m27562aT("minf");
    public static final int aWn = C17675v.m27562aT("stbl");
    public static final int aWo = C17675v.m27562aT("avcC");
    public static final int aWp = C17675v.m27562aT("hvcC");
    public static final int aWq = C17675v.m27562aT("esds");
    public static final int aWr = C17675v.m27562aT("moof");
    public static final int aWs = C17675v.m27562aT("traf");
    public static final int aWt = C17675v.m27562aT("mvex");
    public static final int aWu = C17675v.m27562aT("mehd");
    public static final int aWv = C17675v.m27562aT("tkhd");
    public static final int aWw = C17675v.m27562aT("edts");
    public static final int aWx = C17675v.m27562aT("elst");
    public static final int aWy = C17675v.m27562aT("mdhd");
    public static final int aWz = C17675v.m27562aT("hdlr");
    public static final int aXa = C17675v.m27562aT("co64");
    public static final int aXb = C17675v.m27562aT("tx3g");
    public static final int aXc = C17675v.m27562aT("wvtt");
    public static final int aXd = C17675v.m27562aT("stpp");
    public static final int aXe = C17675v.m27562aT("c608");
    public static final int aXf = C17675v.m27562aT("samr");
    public static final int aXg = C17675v.m27562aT("sawb");
    public static final int aXh = C17675v.m27562aT("udta");
    public static final int aXi = C17675v.m27562aT("meta");
    public static final int aXj = C17675v.m27562aT("ilst");
    public static final int aXk = C17675v.m27562aT("mean");
    public static final int aXl = C17675v.m27562aT("name");
    public static final int aXm = C17675v.m27562aT("data");
    public static final int aXn = C17675v.m27562aT("emsg");
    public static final int aXo = C17675v.m27562aT("st3d");
    public static final int aXp = C17675v.m27562aT("sv3d");
    public static final int aXq = C17675v.m27562aT("proj");
    public static final int aXr = C17675v.m27562aT("vp08");
    public static final int aXs = C17675v.m27562aT("vp09");
    public static final int aXt = C17675v.m27562aT("vpcC");
    public static final int aXu = C17675v.m27562aT("camm");
    public static final int aXv = C17675v.m27562aT("alac");
    public final int type;

    /* renamed from: com.google.android.exoplayer2.c.d.a$a */
    static final class C32026a extends C32025a {
        public final long aXw;
        public final List<C32027b> aXx = new ArrayList();
        public final List<C32026a> aXy = new ArrayList();

        public C32026a(int i, long j) {
            super(i);
            AppMethodBeat.m2504i(94935);
            this.aXw = j;
            AppMethodBeat.m2505o(94935);
        }

        /* renamed from: a */
        public final void mo52321a(C32027b c32027b) {
            AppMethodBeat.m2504i(94936);
            this.aXx.add(c32027b);
            AppMethodBeat.m2505o(94936);
        }

        /* renamed from: a */
        public final void mo52320a(C32026a c32026a) {
            AppMethodBeat.m2504i(94937);
            this.aXy.add(c32026a);
            AppMethodBeat.m2505o(94937);
        }

        /* renamed from: dW */
        public final C32027b mo52322dW(int i) {
            AppMethodBeat.m2504i(94938);
            int size = this.aXx.size();
            for (int i2 = 0; i2 < size; i2++) {
                C32027b c32027b = (C32027b) this.aXx.get(i2);
                if (c32027b.type == i) {
                    AppMethodBeat.m2505o(94938);
                    return c32027b;
                }
            }
            AppMethodBeat.m2505o(94938);
            return null;
        }

        /* renamed from: dX */
        public final C32026a mo52323dX(int i) {
            AppMethodBeat.m2504i(94939);
            int size = this.aXy.size();
            for (int i2 = 0; i2 < size; i2++) {
                C32026a c32026a = (C32026a) this.aXy.get(i2);
                if (c32026a.type == i) {
                    AppMethodBeat.m2505o(94939);
                    return c32026a;
                }
            }
            AppMethodBeat.m2505o(94939);
            return null;
        }

        public final String toString() {
            AppMethodBeat.m2504i(94940);
            String str = C32025a.m52019dV(this.type) + " leaves: " + Arrays.toString(this.aXx.toArray()) + " containers: " + Arrays.toString(this.aXy.toArray());
            AppMethodBeat.m2505o(94940);
            return str;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.a$b */
    static final class C32027b extends C32025a {
        public final C32065l aXz;

        public C32027b(int i, C32065l c32065l) {
            super(i);
            this.aXz = c32065l;
        }
    }

    public C32025a(int i) {
        this.type = i;
    }

    public String toString() {
        return C32025a.m52019dV(this.type);
    }

    /* renamed from: dT */
    public static int m52017dT(int i) {
        return (i >> 24) & 255;
    }

    /* renamed from: dU */
    public static int m52018dU(int i) {
        return 16777215 & i;
    }

    /* renamed from: dV */
    public static String m52019dV(int i) {
        return ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
