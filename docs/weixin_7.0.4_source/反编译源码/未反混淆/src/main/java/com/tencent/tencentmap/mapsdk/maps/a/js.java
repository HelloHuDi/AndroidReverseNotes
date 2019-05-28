package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bj;

public class js implements bj {
    public String a(int i, int i2, int i3) {
        AppMethodBeat.i(100103);
        int pow = (int) ((Math.pow(2.0d, (double) i3) - 1.0d) - ((double) i2));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://p0.map.gtimg.com/scenic/");
        stringBuffer.append("?z=");
        stringBuffer.append(i3);
        stringBuffer.append("&y=");
        stringBuffer.append(pow);
        stringBuffer.append("&x=");
        stringBuffer.append(i);
        stringBuffer.append("&styleid=");
        stringBuffer.append(7);
        stringBuffer.append("&version=");
        stringBuffer.append(jp.a());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(100103);
        return stringBuffer2;
    }
}
