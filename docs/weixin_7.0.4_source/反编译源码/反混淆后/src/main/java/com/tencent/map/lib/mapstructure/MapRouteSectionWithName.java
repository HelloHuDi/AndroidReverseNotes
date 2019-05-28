package com.tencent.map.lib.mapstructure;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36517hl;

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
        AppMethodBeat.m2504i(98163);
        byte[] bArr = new byte[byteLength()];
        System.arraycopy(C36517hl.m60438a(this.startNum), 0, bArr, 0, 4);
        System.arraycopy(C36517hl.m60438a(this.endNum), 0, bArr, 4, 4);
        System.arraycopy(C36517hl.m60438a(this.color), 0, bArr, 8, 4);
        byte[] a = C36517hl.m60439a(this.roadName);
        if (a.length < 128) {
            System.arraycopy(a, 0, bArr, 12, a.length);
        } else {
            System.arraycopy(a, 0, bArr, 12, 128);
        }
        AppMethodBeat.m2505o(98163);
        return bArr;
    }
}
