package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharsetDetector {
    private static final List<CSRecognizerInfo> ALL_CS_RECOGNIZERS;
    private static final int kBufSize = 8000;
    short[] fByteStats = new short[256];
    boolean fC1Bytes = false;
    String fDeclaredEncoding;
    private boolean[] fEnabledRecognizers;
    byte[] fInputBytes = new byte[8000];
    int fInputLen;
    InputStream fInputStream;
    byte[] fRawInput;
    int fRawLength;
    private boolean fStripTags = false;

    static class CSRecognizerInfo {
        boolean isDefaultEnabled;
        CharsetRecognizer recognizer;

        CSRecognizerInfo(CharsetRecognizer charsetRecognizer, boolean z) {
            this.recognizer = charsetRecognizer;
            this.isDefaultEnabled = z;
        }
    }

    public CharsetDetector() {
        AppMethodBeat.i(104747);
        AppMethodBeat.o(104747);
    }

    public CharsetDetector setDeclaredEncoding(String str) {
        this.fDeclaredEncoding = str;
        return this;
    }

    public CharsetDetector setText(byte[] bArr) {
        this.fRawInput = bArr;
        this.fRawLength = bArr.length;
        return this;
    }

    public CharsetDetector setText(InputStream inputStream) {
        int i = 8000;
        AppMethodBeat.i(104748);
        this.fInputStream = inputStream;
        this.fInputStream.mark(8000);
        this.fRawInput = new byte[8000];
        this.fRawLength = 0;
        while (i > 0) {
            int read = this.fInputStream.read(this.fRawInput, this.fRawLength, i);
            if (read <= 0) {
                break;
            }
            this.fRawLength += read;
            i -= read;
        }
        this.fInputStream.reset();
        AppMethodBeat.o(104748);
        return this;
    }

    public CharsetMatch detect() {
        AppMethodBeat.i(104749);
        CharsetMatch[] detectAll = detectAll();
        if (detectAll == null || detectAll.length == 0) {
            AppMethodBeat.o(104749);
            return null;
        }
        CharsetMatch charsetMatch = detectAll[0];
        AppMethodBeat.o(104749);
        return charsetMatch;
    }

    public CharsetMatch[] detectAll() {
        AppMethodBeat.i(104750);
        ArrayList arrayList = new ArrayList();
        MungeInput();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ALL_CS_RECOGNIZERS.size()) {
                CSRecognizerInfo cSRecognizerInfo = (CSRecognizerInfo) ALL_CS_RECOGNIZERS.get(i2);
                if (this.fEnabledRecognizers != null ? this.fEnabledRecognizers[i2] : cSRecognizerInfo.isDefaultEnabled) {
                    CharsetMatch match = cSRecognizerInfo.recognizer.match(this);
                    if (match != null) {
                        arrayList.add(match);
                    }
                }
                i = i2 + 1;
            } else {
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                CharsetMatch[] charsetMatchArr = (CharsetMatch[]) arrayList.toArray(new CharsetMatch[arrayList.size()]);
                AppMethodBeat.o(104750);
                return charsetMatchArr;
            }
        }
    }

    public Reader getReader(InputStream inputStream, String str) {
        Reader reader = null;
        AppMethodBeat.i(104751);
        this.fDeclaredEncoding = str;
        try {
            setText(inputStream);
            CharsetMatch detect = detect();
            if (detect == null) {
                AppMethodBeat.o(104751);
            } else {
                reader = detect.getReader();
                AppMethodBeat.o(104751);
            }
        } catch (IOException e) {
            AppMethodBeat.o(104751);
        }
        return reader;
    }

    public String getString(byte[] bArr, String str) {
        String str2 = null;
        AppMethodBeat.i(104752);
        this.fDeclaredEncoding = str;
        try {
            setText(bArr);
            CharsetMatch detect = detect();
            if (detect == null) {
                AppMethodBeat.o(104752);
            } else {
                str2 = detect.getString(-1);
                AppMethodBeat.o(104752);
            }
        } catch (IOException e) {
            AppMethodBeat.o(104752);
        }
        return str2;
    }

    public static String[] getAllDetectableCharsets() {
        AppMethodBeat.i(104753);
        String[] strArr = new String[ALL_CS_RECOGNIZERS.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                strArr[i2] = ((CSRecognizerInfo) ALL_CS_RECOGNIZERS.get(i2)).recognizer.getName();
                i = i2 + 1;
            } else {
                AppMethodBeat.o(104753);
                return strArr;
            }
        }
    }

    public boolean inputFilterEnabled() {
        return this.fStripTags;
    }

    public boolean enableInputFilter(boolean z) {
        boolean z2 = this.fStripTags;
        this.fStripTags = z;
        return z2;
    }

    private void MungeInput() {
        int i;
        int i2;
        int i3;
        AppMethodBeat.i(104754);
        if (this.fStripTags) {
            i = 0;
            i2 = 0;
            short s = (short) 0;
            int i4 = 0;
            for (i3 = 0; i3 < this.fRawLength && i4 < this.fInputBytes.length; i3++) {
                byte b = this.fRawInput[i3];
                if (b == (byte) 60) {
                    if (s != (short) 0) {
                        i++;
                    }
                    i2++;
                    s = true;
                }
                if (s == (short) 0) {
                    int i5 = i4 + 1;
                    this.fInputBytes[i4] = b;
                    i4 = i5;
                }
                if (b == (byte) 62) {
                    s = (short) 0;
                }
            }
            this.fInputLen = i4;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i2 < 5 || i2 / 5 < r2 || (this.fInputLen < 100 && this.fRawLength > 600)) {
            i3 = this.fRawLength;
            if (i3 > 8000) {
                i3 = 8000;
            }
            i = 0;
            while (i < i3) {
                this.fInputBytes[i] = this.fRawInput[i];
                i++;
            }
            this.fInputLen = i;
        }
        Arrays.fill(this.fByteStats, (short) 0);
        for (i3 = 0; i3 < this.fInputLen; i3++) {
            i = this.fInputBytes[i3] & 255;
            short[] sArr = this.fByteStats;
            sArr[i] = (short) (sArr[i] + 1);
        }
        this.fC1Bytes = false;
        for (i3 = 128; i3 <= JsApiGetBackgroundAudioState.CTRL_INDEX; i3++) {
            if (this.fByteStats[i3] != (short) 0) {
                this.fC1Bytes = true;
                AppMethodBeat.o(104754);
                return;
            }
        }
        AppMethodBeat.o(104754);
    }

    static {
        AppMethodBeat.i(104757);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF8(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF_16_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF_16_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF_32_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF_32_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sjis(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022JP(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022CN(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022KR(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_gb_18030(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_euc_jp(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_euc_kr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_big5(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_1(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_2(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_5_ru(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_6_ar(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_7_el(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_8_I_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_8_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_windows_1251(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_windows_1256(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_KOI8_R(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_8859_9_tr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_IBM424_he_rtl(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_IBM424_he_ltr(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_IBM420_ar_rtl(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_IBM420_ar_ltr(), false));
        ALL_CS_RECOGNIZERS = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(104757);
    }

    @Deprecated
    public String[] getDetectableCharsets() {
        AppMethodBeat.i(104755);
        ArrayList arrayList = new ArrayList(ALL_CS_RECOGNIZERS.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ALL_CS_RECOGNIZERS.size()) {
                CSRecognizerInfo cSRecognizerInfo = (CSRecognizerInfo) ALL_CS_RECOGNIZERS.get(i2);
                if (this.fEnabledRecognizers == null ? cSRecognizerInfo.isDefaultEnabled : this.fEnabledRecognizers[i2]) {
                    arrayList.add(cSRecognizerInfo.recognizer.getName());
                }
                i = i2 + 1;
            } else {
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                AppMethodBeat.o(104755);
                return strArr;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @Deprecated
    public CharsetDetector setDetectableCharset(String str, boolean z) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(104756);
        int i3 = 0;
        while (i3 < ALL_CS_RECOGNIZERS.size()) {
            CSRecognizerInfo cSRecognizerInfo = (CSRecognizerInfo) ALL_CS_RECOGNIZERS.get(i3);
            if (cSRecognizerInfo.recognizer.getName().equals(str)) {
                i = cSRecognizerInfo.isDefaultEnabled == z ? 1 : 0;
                if (i3 >= 0) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid encoding: \"" + str + "\"");
                    AppMethodBeat.o(104756);
                    throw illegalArgumentException;
                }
                if (this.fEnabledRecognizers == null && i == 0) {
                    this.fEnabledRecognizers = new boolean[ALL_CS_RECOGNIZERS.size()];
                    while (i2 < ALL_CS_RECOGNIZERS.size()) {
                        this.fEnabledRecognizers[i2] = ((CSRecognizerInfo) ALL_CS_RECOGNIZERS.get(i2)).isDefaultEnabled;
                        i2++;
                    }
                }
                if (this.fEnabledRecognizers != null) {
                    this.fEnabledRecognizers[i3] = z;
                }
                AppMethodBeat.o(104756);
                return this;
            }
            i3++;
        }
        i = 0;
        i3 = -1;
        if (i3 >= 0) {
        }
    }
}
