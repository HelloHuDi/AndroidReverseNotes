package com.tencent.mm.au;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;

public final class a {
    public static int sK(String str) {
        int i = 0;
        AppMethodBeat.i(59950);
        if (str == null || str.length() <= 0) {
            ab.e("Big5Util", "getStrokesCount buffer is empty");
            AppMethodBeat.o(59950);
        } else {
            try {
                int i2;
                byte[] bytes = str.getBytes("big5");
                if (bytes == null || bytes.length < 2) {
                    ab.e("Big5Util", "byteToShort");
                    i2 = 0;
                } else {
                    int i3 = 0;
                    for (i2 = 0; i2 < 2; i2++) {
                        i3 = (short) (((short) (i3 << 8)) | (bytes[i2] & 255));
                    }
                    i2 = CdnLogic.kBizGeneric & i3;
                }
                if (i2 >= 42048 && i2 <= 42049) {
                    i = 1;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 42050 && i2 <= 42067) || (i2 >= 51520 && i2 <= 51524)) {
                    i = 2;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 42068 && i2 <= 42110) || (i2 >= 51525 && i2 <= 51532)) {
                    i = 3;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 42145 && i2 <= 42237) || (i2 >= 51533 && i2 <= 51548)) {
                    i = 4;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 42238 && i2 <= 42463) || (i2 >= 51549 && i2 <= 51626)) {
                    i = 5;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 42464 && i2 <= 42729) || (i2 >= 51627 && i2 <= 51545)) {
                    i = 6;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 42730 && i2 <= 43202) || (i2 >= 51802 && i2 <= 52144)) {
                    i = 7;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 43203 && i2 <= 43844) || (i2 >= 52145 && i2 <= 52700)) {
                    i = 8;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 43845 && i2 <= 44475) || ((i2 >= 52701 && i2 <= 53447) || i2 == 63962)) {
                    i = 9;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 44476 && i2 <= 45229) || (i2 >= 53448 && i2 <= 54346)) {
                    i = 10;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 45230 && i2 <= 46018) || (i2 >= 54347 && i2 <= 55376)) {
                    i = 11;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 46019 && i2 <= 46787) || ((i2 >= 55377 && i2 <= 56496) || i2 == 63963)) {
                    i = 12;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 46788 && i2 <= 47531) || ((i2 >= 56497 && i2 <= 57583) || (i2 >= 63958 && i2 <= 63960))) {
                    i = 13;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 47532 && i2 <= 48116) || (i2 >= 57584 && i2 <= 58597)) {
                    i = 14;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 48117 && i2 <= 48806) || ((i2 >= 58598 && i2 <= 59635) || i2 == 63964)) {
                    i = 15;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 48807 && i2 <= 49268) || ((i2 >= 59636 && i2 <= 60600) || i2 == 63961)) {
                    i = 16;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 49269 && i2 <= 49742) || (i2 >= 60601 && i2 <= 61366)) {
                    i = 17;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 49743 && i2 <= 50014) || (i2 >= 61367 && i2 <= 61930)) {
                    i = 18;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50015 && i2 <= 50260) || (i2 >= 61931 && i2 <= 62460)) {
                    i = 19;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50261 && i2 <= 50390) || (i2 >= 62461 && i2 <= 62911)) {
                    i = 20;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50135 && i2 <= 50538) || (i2 >= 62912 && i2 <= 63189)) {
                    i = 21;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50539 && i2 <= 50631) || (i2 >= 63190 && i2 <= 63439)) {
                    i = 22;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50632 && i2 <= 50672) || (i2 >= 63440 && i2 <= 63652)) {
                    i = 23;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50673 && i2 <= 50772) || (i2 >= 63653 && i2 <= 63725)) {
                    i = 24;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50773 && i2 <= 50788) || (i2 >= 63721 && i2 <= 63850)) {
                    i = 25;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50789 && i2 <= 50795) || (i2 >= 63906 && i2 <= 63905)) {
                    i = 26;
                    AppMethodBeat.o(59950);
                } else if ((i2 >= 50796 && i2 <= 50805) || (i2 >= 63190 && i2 <= 63929)) {
                    i = 27;
                    AppMethodBeat.o(59950);
                } else if ((i2 < 50806 || i2 > 50810) && (i2 < 63930 || i2 > 63941)) {
                    if ((i2 >= 50811 && i2 <= 50814) || (i2 >= 63942 && i2 <= 63957)) {
                        i = 29;
                    }
                    AppMethodBeat.o(59950);
                } else {
                    i = 28;
                    AppMethodBeat.o(59950);
                }
            } catch (UnsupportedEncodingException e) {
                ab.e("Big5Util", "exception:%s", bo.l(e));
            }
        }
        return i;
    }
}
