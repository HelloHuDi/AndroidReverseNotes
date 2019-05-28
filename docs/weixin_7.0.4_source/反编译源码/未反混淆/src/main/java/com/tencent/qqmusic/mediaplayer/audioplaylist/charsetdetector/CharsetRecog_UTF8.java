package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.view.d;

class CharsetRecog_UTF8 extends CharsetRecognizer {
    CharsetRecog_UTF8() {
    }

    /* Access modifiers changed, original: 0000 */
    public String getName() {
        return "UTF-8";
    }

    /* Access modifiers changed, original: 0000 */
    public CharsetMatch match(CharsetDetector charsetDetector) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(104765);
        byte[] bArr = charsetDetector.fRawInput;
        if (charsetDetector.fRawLength >= 3 && (bArr[0] & 255) == d.MIC_PTU_SHISHANG2 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191) {
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < charsetDetector.fRawLength) {
            int i6;
            byte b = bArr[i3];
            if ((b & 128) != 0) {
                int i7;
                if ((b & 224) == az.CTRL_INDEX) {
                    i7 = 1;
                    i6 = i3;
                } else if ((b & 240) == 224) {
                    i7 = 2;
                    i6 = i3;
                } else if ((b & d.MIC_PTU_ZIPAI_THURSDAY) == 240) {
                    i7 = 3;
                    i6 = i3;
                } else {
                    i4++;
                    i6 = i3;
                }
                while (true) {
                    i6++;
                    if (i6 >= charsetDetector.fRawLength) {
                        break;
                    } else if ((bArr[i6] & az.CTRL_INDEX) != 128) {
                        i4++;
                        break;
                    } else {
                        i3 = i7 - 1;
                        if (i3 == 0) {
                            i5++;
                            break;
                        }
                        i7 = i3;
                    }
                }
            } else {
                i6 = i3;
            }
            i3 = i6 + 1;
        }
        if (i != 0 && i4 == 0) {
            i2 = 100;
        } else if (i != 0 && i5 > i4 * 10) {
            i2 = 80;
        } else if (i5 > 3 && i4 == 0) {
            i2 = 100;
        } else if (i5 > 0 && i4 == 0) {
            i2 = 80;
        } else if (i5 == 0 && i4 == 0) {
            i2 = 15;
        } else if (i5 > i4 * 10) {
            i2 = 25;
        }
        if (i2 == 0) {
            AppMethodBeat.o(104765);
            return null;
        }
        CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, i2);
        AppMethodBeat.o(104765);
        return charsetMatch;
    }
}
