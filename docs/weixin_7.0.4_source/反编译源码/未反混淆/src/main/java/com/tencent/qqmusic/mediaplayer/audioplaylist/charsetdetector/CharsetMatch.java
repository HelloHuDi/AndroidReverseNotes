package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CharsetMatch implements Comparable<CharsetMatch> {
    private String fCharsetName;
    private int fConfidence;
    private InputStream fInputStream = null;
    private String fLang;
    private byte[] fRawInput = null;
    private int fRawLength;

    public Reader getReader() {
        InputStream byteArrayInputStream;
        AppMethodBeat.i(104727);
        InputStream inputStream = this.fInputStream;
        if (inputStream == null) {
            byteArrayInputStream = new ByteArrayInputStream(this.fRawInput, 0, this.fRawLength);
        } else {
            byteArrayInputStream = inputStream;
        }
        try {
            byteArrayInputStream.reset();
            InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream, getName());
            AppMethodBeat.o(104727);
            return inputStreamReader;
        } catch (IOException e) {
            AppMethodBeat.o(104727);
            return null;
        }
    }

    public String getString() {
        AppMethodBeat.i(104728);
        String string = getString(-1);
        AppMethodBeat.o(104728);
        return string;
    }

    public String getString(int i) {
        AppMethodBeat.i(104729);
        String stringBuilder;
        if (this.fInputStream != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            char[] cArr = new char[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            Reader reader = getReader();
            if (i < 0) {
                i = BaseClientBuilder.API_PRIORITY_OTHER;
            }
            while (true) {
                int read = reader.read(cArr, 0, Math.min(i, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
                if (read >= 0) {
                    stringBuilder2.append(cArr, 0, read);
                    i -= read;
                } else {
                    reader.close();
                    stringBuilder = stringBuilder2.toString();
                    AppMethodBeat.o(104729);
                    return stringBuilder;
                }
            }
        }
        stringBuilder = getName();
        int indexOf = stringBuilder.indexOf("_rtl") < 0 ? stringBuilder.indexOf("_ltr") : stringBuilder.indexOf("_rtl");
        if (indexOf > 0) {
            stringBuilder = stringBuilder.substring(0, indexOf);
        }
        String str = new String(this.fRawInput, stringBuilder);
        AppMethodBeat.o(104729);
        return str;
    }

    public int getConfidence() {
        return this.fConfidence;
    }

    public String getName() {
        return this.fCharsetName;
    }

    public String getLanguage() {
        return this.fLang;
    }

    public int compareTo(CharsetMatch charsetMatch) {
        if (this.fConfidence > charsetMatch.fConfidence) {
            return 1;
        }
        if (this.fConfidence < charsetMatch.fConfidence) {
            return -1;
        }
        return 0;
    }

    CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i) {
        AppMethodBeat.i(104730);
        this.fConfidence = i;
        if (charsetDetector.fInputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = charsetDetector.fInputStream;
        this.fCharsetName = charsetRecognizer.getName();
        this.fLang = charsetRecognizer.getLanguage();
        AppMethodBeat.o(104730);
    }

    CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i, String str, String str2) {
        AppMethodBeat.i(104731);
        this.fConfidence = i;
        if (charsetDetector.fInputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = charsetDetector.fInputStream;
        this.fCharsetName = str;
        this.fLang = str2;
        AppMethodBeat.o(104731);
    }
}
