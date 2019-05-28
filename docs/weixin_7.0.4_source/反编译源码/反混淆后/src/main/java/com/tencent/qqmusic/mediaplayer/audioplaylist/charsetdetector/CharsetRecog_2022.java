package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class CharsetRecog_2022 extends CharsetRecognizer {

    static class CharsetRecog_2022KR extends CharsetRecog_2022 {
        private byte[][] escapeSequences = new byte[][]{new byte[]{(byte) 27, (byte) 36, (byte) 41, (byte) 67}};

        CharsetRecog_2022KR() {
        }

        /* Access modifiers changed, original: 0000 */
        public String getName() {
            return "ISO-2022-KR";
        }

        /* Access modifiers changed, original: 0000 */
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            return match == 0 ? null : new CharsetMatch(charsetDetector, this, match);
        }
    }

    static class CharsetRecog_2022CN extends CharsetRecog_2022 {
        private byte[][] escapeSequences = new byte[][]{new byte[]{(byte) 27, (byte) 36, (byte) 41, (byte) 65}, new byte[]{(byte) 27, (byte) 36, (byte) 41, (byte) 71}, new byte[]{(byte) 27, (byte) 36, (byte) 42, (byte) 72}, new byte[]{(byte) 27, (byte) 36, (byte) 41, (byte) 69}, new byte[]{(byte) 27, (byte) 36, (byte) 43, (byte) 73}, new byte[]{(byte) 27, (byte) 36, (byte) 43, (byte) 74}, new byte[]{(byte) 27, (byte) 36, (byte) 43, (byte) 75}, new byte[]{(byte) 27, (byte) 36, (byte) 43, (byte) 76}, new byte[]{(byte) 27, (byte) 36, (byte) 43, (byte) 77}, new byte[]{(byte) 27, (byte) 78}, new byte[]{(byte) 27, (byte) 79}};

        CharsetRecog_2022CN() {
            AppMethodBeat.m2504i(104733);
            AppMethodBeat.m2505o(104733);
        }

        /* Access modifiers changed, original: 0000 */
        public String getName() {
            return "ISO-2022-CN";
        }

        /* Access modifiers changed, original: 0000 */
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.m2504i(104734);
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                AppMethodBeat.m2505o(104734);
                return null;
            }
            CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
            AppMethodBeat.m2505o(104734);
            return charsetMatch;
        }
    }

    static class CharsetRecog_2022JP extends CharsetRecog_2022 {
        private byte[][] escapeSequences = new byte[][]{new byte[]{(byte) 27, (byte) 36, (byte) 40, (byte) 67}, new byte[]{(byte) 27, (byte) 36, (byte) 40, (byte) 68}, new byte[]{(byte) 27, (byte) 36, (byte) 64}, new byte[]{(byte) 27, (byte) 36, (byte) 65}, new byte[]{(byte) 27, (byte) 36, (byte) 66}, new byte[]{(byte) 27, (byte) 38, (byte) 64}, new byte[]{(byte) 27, (byte) 40, (byte) 66}, new byte[]{(byte) 27, (byte) 40, (byte) 72}, new byte[]{(byte) 27, (byte) 40, (byte) 73}, new byte[]{(byte) 27, (byte) 40, (byte) 74}, new byte[]{(byte) 27, (byte) 46, (byte) 65}, new byte[]{(byte) 27, (byte) 46, (byte) 70}};

        CharsetRecog_2022JP() {
            AppMethodBeat.m2504i(104739);
            AppMethodBeat.m2505o(104739);
        }

        /* Access modifiers changed, original: 0000 */
        public String getName() {
            return "ISO-2022-JP";
        }

        /* Access modifiers changed, original: 0000 */
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.m2504i(104740);
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                AppMethodBeat.m2505o(104740);
                return null;
            }
            CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
            AppMethodBeat.m2505o(104740);
            return charsetMatch;
        }
    }

    CharsetRecog_2022() {
    }

    /* Access modifiers changed, original: 0000 */
    public int match(byte[] bArr, int i, byte[][] bArr2) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < i) {
            int i7;
            if (bArr[i6] == (byte) 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i - i6 >= bArr3.length) {
                        i7 = 1;
                        while (i7 < bArr3.length) {
                            if (bArr3[i7] == bArr[i6 + i7]) {
                                i7++;
                            }
                        }
                        i5++;
                        i6 += bArr3.length - 1;
                        i7 = i3;
                        i2 = i4;
                        break;
                    }
                }
                i2 = i4 + 1;
                if (bArr[i6] != (byte) 14 || bArr[i6] == (byte) 15) {
                    i7 = i3 + 1;
                } else {
                    i7 = i3;
                }
            } else {
                i2 = i4;
                if (bArr[i6] != (byte) 14) {
                }
                i7 = i3 + 1;
            }
            i6++;
            i3 = i7;
            i4 = i2;
        }
        if (i5 == 0) {
            return 0;
        }
        i2 = ((i5 * 100) - (i4 * 100)) / (i5 + i4);
        if (i5 + i3 < 5) {
            i2 -= (5 - (i5 + i3)) * 10;
        }
        if (i2 >= 0) {
            return i2;
        }
        return 0;
    }
}
