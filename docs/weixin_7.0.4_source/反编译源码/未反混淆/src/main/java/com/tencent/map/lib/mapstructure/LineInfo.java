package com.tencent.map.lib.mapstructure;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hl;

public class LineInfo {
    private static final int ROAD_NAME_BYTE_LEN = 64;
    public int color;
    public int endNum;
    public String roadName;
    public int speed;
    public int startNum;

    public byte[] fromBytes() {
        AppMethodBeat.i(98162);
        byte[] bArr = new byte[80];
        System.arraycopy(hl.a(this.startNum), 0, bArr, 0, 4);
        System.arraycopy(hl.a(this.endNum), 0, bArr, 4, 4);
        System.arraycopy(hl.a(this.color), 0, bArr, 8, 4);
        System.arraycopy(hl.a(this.speed), 0, bArr, 12, 4);
        byte[] a = hl.a(this.roadName);
        System.arraycopy(a, 0, bArr, 16, a.length);
        AppMethodBeat.o(98162);
        return bArr;
    }
}
