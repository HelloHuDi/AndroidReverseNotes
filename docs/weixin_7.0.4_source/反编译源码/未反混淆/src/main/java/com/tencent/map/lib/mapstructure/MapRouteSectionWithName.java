package com.tencent.map.lib.mapstructure;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hl;

public class MapRouteSectionWithName {
    public static final int kMaxRoadNameLength = 128;
    public int color;
    public int endNum;
    public String roadName;
    public int startNum;

    public static int byteLength() {
        return 140;
    }

    public byte[] toBytes() {
        AppMethodBeat.i(98163);
        byte[] bArr = new byte[byteLength()];
        System.arraycopy(hl.a(this.startNum), 0, bArr, 0, 4);
        System.arraycopy(hl.a(this.endNum), 0, bArr, 4, 4);
        System.arraycopy(hl.a(this.color), 0, bArr, 8, 4);
        byte[] a = hl.a(this.roadName);
        if (a.length < 128) {
            System.arraycopy(a, 0, bArr, 12, a.length);
        } else {
            System.arraycopy(a, 0, bArr, 12, 128);
        }
        AppMethodBeat.o(98163);
        return bArr;
    }
}
