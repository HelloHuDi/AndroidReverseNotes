package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class CharsetRecog_Unicode extends CharsetRecognizer {

    static class CharsetRecog_UTF_16_BE extends CharsetRecog_Unicode {
        CharsetRecog_UTF_16_BE() {
        }

        /* Access modifiers changed, original: 0000 */
        public String getName() {
            return "UTF-16BE";
        }

        /* Access modifiers changed, original: 0000 */
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.m2504i(104738);
            byte[] bArr = charsetDetector.fRawInput;
            int i = 10;
            int min = Math.min(bArr.length, 30);
            int i2 = 0;
            while (i2 < min - 1) {
                int codeUnit16FromBytes = CharsetRecog_Unicode.codeUnit16FromBytes(bArr[i2], bArr[i2 + 1]);
                if (i2 != 0 || codeUnit16FromBytes != 65279) {
                    i = CharsetRecog_Unicode.adjustConfidence(codeUnit16FromBytes, i);
                    if (i == 0 || i == 100) {
                        break;
                    }
                    i2 += 2;
                } else {
                    i = 100;
                    break;
                }
            }
            if (min < 4 && r1 < 100) {
                i = 0;
            }
            if (i > 0) {
                CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, i);
                AppMethodBeat.m2505o(104738);
                return charsetMatch;
            }
            AppMethodBeat.m2505o(104738);
            return null;
        }
    }

    static abstract class CharsetRecog_UTF_32 extends CharsetRecog_Unicode {
        public abstract int getChar(byte[] bArr, int i);

        public abstract String getName();

        CharsetRecog_UTF_32() {
        }

        /* Access modifiers changed, original: 0000 */
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int i = 0;
            byte[] bArr = charsetDetector.fRawInput;
            int i2 = (charsetDetector.fRawLength / 4) * 4;
            if (i2 == 0) {
                return null;
            }
            int i3;
            if (getChar(bArr, 0) == 65279) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6 += 4) {
                int i7 = getChar(bArr, i6);
                if (i7 < 0 || i7 >= 1114111 || (i7 >= 55296 && i7 <= 57343)) {
                    i4++;
                } else {
                    i5++;
                }
            }
            if (i3 != 0 && i4 == 0) {
                i = 100;
            } else if (i3 != 0 && i5 > i4 * 10) {
                i = 80;
            } else if (i5 > 3 && i4 == 0) {
                i = 100;
            } else if (i5 > 0 && i4 == 0) {
                i = 80;
            } else if (i5 > i4 * 10) {
                i = 25;
            }
            if (i == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, i);
        }
    }

    static class CharsetRecog_UTF_16_LE extends CharsetRecog_Unicode {
        CharsetRecog_UTF_16_LE() {
        }

        /* Access modifiers changed, original: 0000 */
        public String getName() {
            return "UTF-16LE";
        }

        /* Access modifiers changed, original: 0000 */
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.m2504i(104713);
            byte[] bArr = charsetDetector.fRawInput;
            int i = 10;
            int min = Math.min(bArr.length, 30);
            int i2 = 0;
            while (i2 < min - 1) {
                int codeUnit16FromBytes = CharsetRecog_Unicode.codeUnit16FromBytes(bArr[i2 + 1], bArr[i2]);
                if (i2 != 0 || codeUnit16FromBytes != 65279) {
                    i = CharsetRecog_Unicode.adjustConfidence(codeUnit16FromBytes, i);
                    if (i == 0 || i == 100) {
                        break;
                    }
                    i2 += 2;
                } else {
                    i = 100;
                    break;
                }
            }
            if (min < 4 && r1 < 100) {
                i = 0;
            }
            if (i > 0) {
                CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, i);
                AppMethodBeat.m2505o(104713);
                return charsetMatch;
            }
            AppMethodBeat.m2505o(104713);
            return null;
        }
    }

    static class CharsetRecog_UTF_32_LE extends CharsetRecog_UTF_32 {
        CharsetRecog_UTF_32_LE() {
        }

        /* Access modifiers changed, original: 0000 */
        public int getChar(byte[] bArr, int i) {
            return ((((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 1] & 255) << 8)) | (bArr[i + 0] & 255);
        }

        /* Access modifiers changed, original: 0000 */
        public String getName() {
            return "UTF-32LE";
        }
    }

    static class CharsetRecog_UTF_32_BE extends CharsetRecog_UTF_32 {
        CharsetRecog_UTF_32_BE() {
        }

        /* Access modifiers changed, original: 0000 */
        public int getChar(byte[] bArr, int i) {
            return ((((bArr[i + 0] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
        }

        /* Access modifiers changed, original: 0000 */
        public String getName() {
            return "UTF-32BE";
        }
    }

    public abstract String getName();

    public abstract CharsetMatch match(CharsetDetector charsetDetector);

    CharsetRecog_Unicode() {
    }

    static int codeUnit16FromBytes(byte b, byte b2) {
        return ((b & 255) << 8) | (b2 & 255);
    }

    static int adjustConfidence(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = i2 - 10;
        } else if ((i < 32 || i > 255) && i != 10) {
            i3 = i2;
        } else {
            i3 = i2 + 10;
        }
        if (i3 < 0) {
            return 0;
        }
        if (i3 <= 100) {
            return i3;
        }
        return 100;
    }
}
