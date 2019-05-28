package com.google.android.gms.common.server.response;

import android.support.v4.widget.j;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
    private static final char[] zzwv = new char[]{'u', 'l', 'l'};
    private static final char[] zzww = new char[]{'r', 'u', 'e'};
    private static final char[] zzwx = new char[]{'r', 'u', 'e', '\"'};
    private static final char[] zzwy = new char[]{'a', 'l', 's', 'e'};
    private static final char[] zzwz = new char[]{'a', 'l', 's', 'e', '\"'};
    private static final char[] zzxa = new char[]{10};
    private static final zza<Integer> zzxc = new zza();
    private static final zza<Long> zzxd = new zzb();
    private static final zza<Float> zzxe = new zzc();
    private static final zza<Double> zzxf = new zzd();
    private static final zza<Boolean> zzxg = new zze();
    private static final zza<String> zzxh = new zzf();
    private static final zza<BigInteger> zzxi = new zzg();
    private static final zza<BigDecimal> zzxj = new zzh();
    private final char[] zzwq = new char[1];
    private final char[] zzwr = new char[32];
    private final char[] zzws = new char[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
    private final StringBuilder zzwt = new StringBuilder(32);
    private final StringBuilder zzwu = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    private final Stack<Integer> zzxb = new Stack();

    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    interface zza<O> {
        O zzh(FastParser fastParser, BufferedReader bufferedReader);
    }

    static {
        AppMethodBeat.i(61552);
        AppMethodBeat.o(61552);
    }

    public FastParser() {
        AppMethodBeat.i(61522);
        AppMethodBeat.o(61522);
    }

    private final int zza(BufferedReader bufferedReader, char[] cArr) {
        AppMethodBeat.i(61541);
        char zzj = zzj(bufferedReader);
        ParseException parseException;
        if (zzj == 0) {
            parseException = new ParseException("Unexpected EOF");
            AppMethodBeat.o(61541);
            throw parseException;
        } else if (zzj == ',') {
            parseException = new ParseException("Missing value");
            AppMethodBeat.o(61541);
            throw parseException;
        } else if (zzj == 'n') {
            zzb(bufferedReader, zzwv);
            AppMethodBeat.o(61541);
            return 0;
        } else {
            int i;
            bufferedReader.mark(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (zzj == '\"') {
                i = 0;
                int i2 = 0;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    char c = cArr[i];
                    if (Character.isISOControl(c)) {
                        parseException = new ParseException("Unexpected control character while reading string");
                        AppMethodBeat.o(61541);
                        throw parseException;
                    } else if (c == '\"' && i2 == 0) {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i + 1));
                        AppMethodBeat.o(61541);
                        return i;
                    } else {
                        i2 = c == IOUtils.DIR_SEPARATOR_WINDOWS ? i2 == 0 ? 1 : 0 : 0;
                        i++;
                    }
                }
            } else {
                cArr[0] = zzj;
                i = 1;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = 0;
                        AppMethodBeat.o(61541);
                        return i;
                    }
                    i++;
                }
            }
            if (i == cArr.length) {
                parseException = new ParseException("Absurdly long value");
                AppMethodBeat.o(61541);
                throw parseException;
            }
            parseException = new ParseException("Unexpected EOF");
            AppMethodBeat.o(61541);
            throw parseException;
        }
    }

    private final String zza(BufferedReader bufferedReader) {
        String str = null;
        AppMethodBeat.i(61526);
        this.zzxb.push(Integer.valueOf(2));
        char zzj = zzj(bufferedReader);
        ParseException parseException;
        switch (zzj) {
            case '\"':
                this.zzxb.push(Integer.valueOf(3));
                str = zzb(bufferedReader, this.zzwr, this.zzwt, null);
                zzk(3);
                if (zzj(bufferedReader) == ':') {
                    AppMethodBeat.o(61526);
                    break;
                }
                parseException = new ParseException("Expected key/value separator");
                AppMethodBeat.o(61526);
                throw parseException;
            case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                zzk(2);
                zzk(1);
                zzk(5);
                AppMethodBeat.o(61526);
                break;
            case '}':
                zzk(2);
                AppMethodBeat.o(61526);
                break;
            default:
                parseException = new ParseException("Unexpected token: " + zzj);
                AppMethodBeat.o(61526);
                throw parseException;
        }
        return str;
    }

    private final String zza(BufferedReader bufferedReader, char[] cArr, StringBuilder stringBuilder, char[] cArr2) {
        AppMethodBeat.i(61530);
        switch (zzj(bufferedReader)) {
            case '\"':
                String zzb = zzb(bufferedReader, cArr, stringBuilder, cArr2);
                AppMethodBeat.o(61530);
                return zzb;
            case 'n':
                zzb(bufferedReader, zzwv);
                AppMethodBeat.o(61530);
                return null;
            default:
                ParseException parseException = new ParseException("Expected string");
                AppMethodBeat.o(61530);
                throw parseException;
        }
    }

    private final <T extends FastJsonResponse> ArrayList<T> zza(BufferedReader bufferedReader, Field<?, ?> field) {
        ParseException parseException;
        AppMethodBeat.i(61539);
        ArrayList arrayList = new ArrayList();
        char zzj = zzj(bufferedReader);
        ParseException parseException2;
        switch (zzj) {
            case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                zzk(5);
                AppMethodBeat.o(61539);
                return arrayList;
            case 'n':
                zzb(bufferedReader, zzwv);
                zzk(5);
                AppMethodBeat.o(61539);
                return null;
            case '{':
                this.zzxb.push(Integer.valueOf(1));
                while (true) {
                    try {
                        FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                        if (zza(bufferedReader, newConcreteTypeInstance)) {
                            arrayList.add(newConcreteTypeInstance);
                            zzj = zzj(bufferedReader);
                            switch (zzj) {
                                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                    if (zzj(bufferedReader) != '{') {
                                        parseException2 = new ParseException("Expected start of next object in array");
                                        AppMethodBeat.o(61539);
                                        throw parseException2;
                                    }
                                    this.zzxb.push(Integer.valueOf(1));
                                case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                                    zzk(5);
                                    AppMethodBeat.o(61539);
                                    return arrayList;
                                default:
                                    parseException2 = new ParseException("Unexpected token: " + zzj);
                                    AppMethodBeat.o(61539);
                                    throw parseException2;
                            }
                        }
                        AppMethodBeat.o(61539);
                        return arrayList;
                    } catch (InstantiationException e) {
                        parseException = new ParseException("Error instantiating inner object", e);
                        AppMethodBeat.o(61539);
                        throw parseException;
                    } catch (IllegalAccessException e2) {
                        parseException = new ParseException("Error instantiating inner object", e2);
                        AppMethodBeat.o(61539);
                        throw parseException;
                    }
                }
            default:
                parseException2 = new ParseException("Unexpected token: " + zzj);
                AppMethodBeat.o(61539);
                throw parseException2;
        }
    }

    private final <O> ArrayList<O> zza(BufferedReader bufferedReader, zza<O> zza) {
        AppMethodBeat.i(61529);
        char zzj = zzj(bufferedReader);
        if (zzj != 'n') {
            ParseException parseException;
            if (zzj == '[') {
                this.zzxb.push(Integer.valueOf(5));
                ArrayList arrayList = new ArrayList();
                while (true) {
                    bufferedReader.mark(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    switch (zzj(bufferedReader)) {
                        case 0:
                            parseException = new ParseException("Unexpected EOF");
                            AppMethodBeat.o(61529);
                            throw parseException;
                        case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                            break;
                        case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                            zzk(5);
                            AppMethodBeat.o(61529);
                            return arrayList;
                        default:
                            bufferedReader.reset();
                            arrayList.add(zza.zzh(this, bufferedReader));
                            break;
                    }
                }
            }
            parseException = new ParseException("Expected start of array");
            AppMethodBeat.o(61529);
            throw parseException;
        }
        zzb(bufferedReader, zzwv);
        AppMethodBeat.o(61529);
        return null;
    }

    static /* synthetic */ boolean zza(FastParser fastParser, BufferedReader bufferedReader, boolean z) {
        AppMethodBeat.i(61548);
        boolean zza = fastParser.zza(bufferedReader, false);
        AppMethodBeat.o(61548);
        return zza;
    }

    private final boolean zza(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) {
        AppMethodBeat.i(61525);
        Map fieldMappings = fastJsonResponse.getFieldMappings();
        Object zza = zza(bufferedReader);
        if (zza == null) {
            zzk(1);
            AppMethodBeat.o(61525);
            return false;
        }
        while (zza != null) {
            Field field = (Field) fieldMappings.get(zza);
            if (field == null) {
                zza = zzb(bufferedReader);
            } else {
                ParseException parseException;
                this.zzxb.push(Integer.valueOf(4));
                char zzj;
                ParseException parseException2;
                switch (field.getTypeIn()) {
                    case 0:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setInteger(field, zzd(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setIntegers(field, zza(bufferedReader, zzxc));
                        break;
                    case 1:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setBigInteger(field, zzf(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setBigIntegers(field, zza(bufferedReader, zzxi));
                        break;
                    case 2:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setLong(field, zze(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setLongs(field, zza(bufferedReader, zzxd));
                        break;
                    case 3:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setFloat(field, zzg(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setFloats(field, zza(bufferedReader, zzxe));
                        break;
                    case 4:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setDouble(field, zzh(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setDoubles(field, zza(bufferedReader, zzxf));
                        break;
                    case 5:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setBigDecimal(field, zzi(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setBigDecimals(field, zza(bufferedReader, zzxj));
                        break;
                    case 6:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setBoolean(field, zza(bufferedReader, false));
                            break;
                        }
                        fastJsonResponse.setBooleans(field, zza(bufferedReader, zzxg));
                        break;
                    case 7:
                        if (!field.isTypeInArray()) {
                            fastJsonResponse.setString(field, zzc(bufferedReader));
                            break;
                        }
                        fastJsonResponse.setStrings(field, zza(bufferedReader, zzxh));
                        break;
                    case 8:
                        fastJsonResponse.setDecodedBytes(field, Base64Utils.decode(zza(bufferedReader, this.zzws, this.zzwu, zzxa)));
                        break;
                    case 9:
                        fastJsonResponse.setDecodedBytes(field, Base64Utils.decodeUrlSafe(zza(bufferedReader, this.zzws, this.zzwu, zzxa)));
                        break;
                    case 10:
                        Map hashMap;
                        zzj = zzj(bufferedReader);
                        if (zzj != 'n') {
                            if (zzj == '{') {
                                this.zzxb.push(Integer.valueOf(1));
                                hashMap = new HashMap();
                                while (true) {
                                    switch (zzj(bufferedReader)) {
                                        case 0:
                                            parseException2 = new ParseException("Unexpected EOF");
                                            AppMethodBeat.o(61525);
                                            throw parseException2;
                                        case '\"':
                                            String zzb = zzb(bufferedReader, this.zzwr, this.zzwt, null);
                                            String str;
                                            String valueOf;
                                            if (zzj(bufferedReader) == ':') {
                                                if (zzj(bufferedReader) == '\"') {
                                                    hashMap.put(zzb, zzb(bufferedReader, this.zzwr, this.zzwt, null));
                                                    char zzj2 = zzj(bufferedReader);
                                                    if (zzj2 == ',') {
                                                        break;
                                                    } else if (zzj2 == '}') {
                                                        zzk(1);
                                                        break;
                                                    } else {
                                                        parseException2 = new ParseException("Unexpected character while parsing string map: " + zzj2);
                                                        AppMethodBeat.o(61525);
                                                        throw parseException2;
                                                    }
                                                }
                                                str = "Expected String value for key ";
                                                valueOf = String.valueOf(zzb);
                                                parseException = new ParseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                                AppMethodBeat.o(61525);
                                                throw parseException;
                                            }
                                            str = "No map value found for key ";
                                            valueOf = String.valueOf(zzb);
                                            parseException = new ParseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                            AppMethodBeat.o(61525);
                                            throw parseException;
                                        case '}':
                                            zzk(1);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            parseException2 = new ParseException("Expected start of a map object");
                            AppMethodBeat.o(61525);
                            throw parseException2;
                        }
                        zzb(bufferedReader, zzwv);
                        hashMap = null;
                        fastJsonResponse.setStringMap(field, hashMap);
                        break;
                    case 11:
                        if (field.isTypeInArray()) {
                            zzj = zzj(bufferedReader);
                            if (zzj != 'n') {
                                this.zzxb.push(Integer.valueOf(5));
                                if (zzj == '[') {
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), zza(bufferedReader, field));
                                    break;
                                }
                                parseException2 = new ParseException("Expected array start");
                                AppMethodBeat.o(61525);
                                throw parseException2;
                            }
                            zzb(bufferedReader, zzwv);
                            fastJsonResponse.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), null);
                            break;
                        }
                        zzj = zzj(bufferedReader);
                        if (zzj == 'n') {
                            zzb(bufferedReader, zzwv);
                            fastJsonResponse.addConcreteTypeInternal(field, field.getOutputFieldName(), null);
                            break;
                        }
                        this.zzxb.push(Integer.valueOf(1));
                        if (zzj != '{') {
                            parseException2 = new ParseException("Expected start of object");
                            AppMethodBeat.o(61525);
                            throw parseException2;
                        }
                        try {
                            FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                            zza(bufferedReader, newConcreteTypeInstance);
                            fastJsonResponse.addConcreteTypeInternal(field, field.getOutputFieldName(), newConcreteTypeInstance);
                            break;
                        } catch (InstantiationException e) {
                            parseException = new ParseException("Error instantiating inner object", e);
                            AppMethodBeat.o(61525);
                            throw parseException;
                        } catch (IllegalAccessException e2) {
                            parseException = new ParseException("Error instantiating inner object", e2);
                            AppMethodBeat.o(61525);
                            throw parseException;
                        }
                    default:
                        parseException = new ParseException("Invalid field type " + field.getTypeIn());
                        AppMethodBeat.o(61525);
                        throw parseException;
                }
                zzk(4);
                zzk(2);
                char zzj3 = zzj(bufferedReader);
                switch (zzj3) {
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        zza = zza(bufferedReader);
                        break;
                    case '}':
                        zza = null;
                        break;
                    default:
                        parseException = new ParseException("Expected end of object or field separator, but found: " + zzj3);
                        AppMethodBeat.o(61525);
                        throw parseException;
                }
            }
        }
        PostProcessor postProcessor = fastJsonResponse.getPostProcessor();
        if (postProcessor != null) {
            postProcessor.postProcess(fastJsonResponse);
        }
        zzk(1);
        AppMethodBeat.o(61525);
        return true;
    }

    private final boolean zza(BufferedReader bufferedReader, boolean z) {
        AppMethodBeat.i(61535);
        while (true) {
            char zzj = zzj(bufferedReader);
            ParseException parseException;
            switch (zzj) {
                case '\"':
                    if (z) {
                        parseException = new ParseException("No boolean value found in string");
                        AppMethodBeat.o(61535);
                        throw parseException;
                    }
                    z = true;
                case 'f':
                    zzb(bufferedReader, z ? zzwz : zzwy);
                    AppMethodBeat.o(61535);
                    return false;
                case 'n':
                    zzb(bufferedReader, zzwv);
                    AppMethodBeat.o(61535);
                    return false;
                case 't':
                    zzb(bufferedReader, z ? zzwx : zzww);
                    AppMethodBeat.o(61535);
                    return true;
                default:
                    parseException = new ParseException("Unexpected token: " + zzj);
                    AppMethodBeat.o(61535);
                    throw parseException;
            }
        }
    }

    private final String zzb(BufferedReader bufferedReader) {
        char zzj;
        ParseException parseException;
        AppMethodBeat.i(61527);
        bufferedReader.mark(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        int i;
        int i2;
        ParseException parseException2;
        switch (zzj(bufferedReader)) {
            case '\"':
                if (bufferedReader.read(this.zzwq) != -1) {
                    char c = this.zzwq[0];
                    i = 0;
                    while (true) {
                        if (c == '\"' && i == 0) {
                            break;
                        }
                        i2 = c == IOUtils.DIR_SEPARATOR_WINDOWS ? i == 0 ? 1 : 0 : 0;
                        if (bufferedReader.read(this.zzwq) == -1) {
                            parseException2 = new ParseException("Unexpected EOF while parsing string");
                            AppMethodBeat.o(61527);
                            throw parseException2;
                        }
                        c = this.zzwq[0];
                        if (Character.isISOControl(c)) {
                            parseException2 = new ParseException("Unexpected control character while reading string");
                            AppMethodBeat.o(61527);
                            throw parseException2;
                        }
                        i = i2;
                    }
                } else {
                    parseException2 = new ParseException("Unexpected EOF while parsing string");
                    AppMethodBeat.o(61527);
                    throw parseException2;
                }
                break;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                parseException2 = new ParseException("Missing value");
                AppMethodBeat.o(61527);
                throw parseException2;
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                this.zzxb.push(Integer.valueOf(5));
                bufferedReader.mark(32);
                if (zzj(bufferedReader) != ']') {
                    bufferedReader.reset();
                    int i3 = 1;
                    i = 0;
                    int i4 = 0;
                    while (i3 > 0) {
                        char zzj2 = zzj(bufferedReader);
                        if (zzj2 == 0) {
                            parseException2 = new ParseException("Unexpected EOF while parsing array");
                            AppMethodBeat.o(61527);
                            throw parseException2;
                        } else if (Character.isISOControl(zzj2)) {
                            parseException2 = new ParseException("Unexpected control character while reading array");
                            AppMethodBeat.o(61527);
                            throw parseException2;
                        } else {
                            if (zzj2 == '\"' && i4 == 0) {
                                i = i == 0 ? 1 : 0;
                            }
                            i2 = (zzj2 == '[' && i == 0) ? i3 + 1 : i3;
                            i3 = (zzj2 == ']' && i == 0) ? i2 - 1 : i2;
                            if (zzj2 != IOUtils.DIR_SEPARATOR_WINDOWS || i == 0) {
                                i4 = 0;
                            } else {
                                i4 = i4 == 0 ? 1 : 0;
                            }
                        }
                    }
                    zzk(5);
                    break;
                }
                zzk(5);
                break;
                break;
            case '{':
                this.zzxb.push(Integer.valueOf(1));
                bufferedReader.mark(32);
                zzj = zzj(bufferedReader);
                if (zzj == '}') {
                    zzk(1);
                    break;
                } else if (zzj == '\"') {
                    bufferedReader.reset();
                    zza(bufferedReader);
                    do {
                    } while (zzb(bufferedReader) != null);
                    zzk(1);
                    break;
                } else {
                    parseException = new ParseException("Unexpected token " + zzj);
                    AppMethodBeat.o(61527);
                    throw parseException;
                }
            default:
                bufferedReader.reset();
                zza(bufferedReader, this.zzws);
                break;
        }
        zzj = zzj(bufferedReader);
        switch (zzj) {
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                zzk(2);
                String zza = zza(bufferedReader);
                AppMethodBeat.o(61527);
                return zza;
            case '}':
                zzk(2);
                AppMethodBeat.o(61527);
                return null;
            default:
                parseException = new ParseException("Unexpected token " + zzj);
                AppMethodBeat.o(61527);
                throw parseException;
        }
    }

    private static String zzb(BufferedReader bufferedReader, char[] cArr, StringBuilder stringBuilder, char[] cArr2) {
        AppMethodBeat.i(61531);
        stringBuilder.setLength(0);
        bufferedReader.mark(cArr.length);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = bufferedReader.read(cArr);
            ParseException parseException;
            if (read != -1) {
                int i3 = 0;
                while (i3 < read) {
                    int i4;
                    char c = cArr[i3];
                    if (Character.isISOControl(c)) {
                        if (cArr2 != null) {
                            for (char c2 : cArr2) {
                                if (c2 == c) {
                                    i4 = 1;
                                    break;
                                }
                            }
                        }
                        i4 = 0;
                        if (i4 == 0) {
                            parseException = new ParseException("Unexpected control character while reading string");
                            AppMethodBeat.o(61531);
                            throw parseException;
                        }
                    }
                    if (c == '\"' && i2 == 0) {
                        stringBuilder.append(cArr, 0, i3);
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i3 + 1));
                        String unescapeString;
                        if (i != 0) {
                            unescapeString = JsonUtils.unescapeString(stringBuilder.toString());
                            AppMethodBeat.o(61531);
                            return unescapeString;
                        }
                        unescapeString = stringBuilder.toString();
                        AppMethodBeat.o(61531);
                        return unescapeString;
                    }
                    if (c == IOUtils.DIR_SEPARATOR_WINDOWS) {
                        i4 = 1;
                        i2 = i2 == 0 ? 1 : 0;
                    } else {
                        i4 = i;
                        i2 = 0;
                    }
                    i3++;
                    i = i4;
                }
                stringBuilder.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                parseException = new ParseException("Unexpected EOF while parsing string");
                AppMethodBeat.o(61531);
                throw parseException;
            }
        }
    }

    private final void zzb(BufferedReader bufferedReader, char[] cArr) {
        AppMethodBeat.i(61542);
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.zzwr, 0, cArr.length - i);
            ParseException parseException;
            if (read == -1) {
                parseException = new ParseException("Unexpected EOF");
                AppMethodBeat.o(61542);
                throw parseException;
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != this.zzwr[i2]) {
                    parseException = new ParseException("Unexpected character");
                    AppMethodBeat.o(61542);
                    throw parseException;
                }
            }
            i += read;
        }
        AppMethodBeat.o(61542);
    }

    static /* synthetic */ float zzc(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61546);
        float zzg = fastParser.zzg(bufferedReader);
        AppMethodBeat.o(61546);
        return zzg;
    }

    private final String zzc(BufferedReader bufferedReader) {
        AppMethodBeat.i(61528);
        String zza = zza(bufferedReader, this.zzwr, this.zzwt, null);
        AppMethodBeat.o(61528);
        return zza;
    }

    static /* synthetic */ double zzd(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61547);
        double zzh = fastParser.zzh(bufferedReader);
        AppMethodBeat.o(61547);
        return zzh;
    }

    private final int zzd(BufferedReader bufferedReader) {
        int i = 0;
        AppMethodBeat.i(61532);
        int zza = zza(bufferedReader, this.zzws);
        if (zza == 0) {
            AppMethodBeat.o(61532);
            return 0;
        }
        char[] cArr = this.zzws;
        ParseException parseException;
        if (zza > 0) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (cArr[0] == '-') {
                i2 = j.INVALID_ID;
                i3 = 1;
                i4 = 1;
            } else {
                i2 = -2147483647;
                i3 = 0;
                i4 = 0;
            }
            if (i3 < zza) {
                i5 = i3 + 1;
                i = Character.digit(cArr[i3], 10);
                if (i < 0) {
                    parseException = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(61532);
                    throw parseException;
                }
                i = -i;
            } else {
                i5 = i3;
            }
            while (i5 < zza) {
                i3 = i5 + 1;
                i5 = Character.digit(cArr[i5], 10);
                if (i5 < 0) {
                    parseException = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(61532);
                    throw parseException;
                } else if (i < -214748364) {
                    parseException = new ParseException("Number too large");
                    AppMethodBeat.o(61532);
                    throw parseException;
                } else {
                    i *= 10;
                    if (i < i2 + i5) {
                        parseException = new ParseException("Number too large");
                        AppMethodBeat.o(61532);
                        throw parseException;
                    }
                    i -= i5;
                    i5 = i3;
                }
            }
            if (i4 == 0) {
                i = -i;
                AppMethodBeat.o(61532);
                return i;
            } else if (i5 > 1) {
                AppMethodBeat.o(61532);
                return i;
            } else {
                parseException = new ParseException("No digits to parse");
                AppMethodBeat.o(61532);
                throw parseException;
            }
        }
        parseException = new ParseException("No number to parse");
        AppMethodBeat.o(61532);
        throw parseException;
    }

    private final long zze(BufferedReader bufferedReader) {
        long j = 0;
        AppMethodBeat.i(61533);
        int zza = zza(bufferedReader, this.zzws);
        if (zza == 0) {
            AppMethodBeat.o(61533);
            return 0;
        }
        char[] cArr = this.zzws;
        ParseException parseException;
        if (zza > 0) {
            long j2;
            int i;
            int i2;
            int i3;
            if (cArr[0] == '-') {
                j2 = Long.MIN_VALUE;
                i = 1;
                i2 = 1;
            } else {
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
            }
            if (i < zza) {
                i3 = i + 1;
                int digit = Character.digit(cArr[i], 10);
                if (digit < 0) {
                    parseException = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(61533);
                    throw parseException;
                }
                j = (long) (-digit);
            } else {
                i3 = i;
            }
            while (i3 < zza) {
                i = i3 + 1;
                i3 = Character.digit(cArr[i3], 10);
                if (i3 < 0) {
                    parseException = new ParseException("Unexpected non-digit character");
                    AppMethodBeat.o(61533);
                    throw parseException;
                } else if (j < -922337203685477580L) {
                    parseException = new ParseException("Number too large");
                    AppMethodBeat.o(61533);
                    throw parseException;
                } else {
                    j *= 10;
                    if (j < ((long) i3) + j2) {
                        parseException = new ParseException("Number too large");
                        AppMethodBeat.o(61533);
                        throw parseException;
                    }
                    j -= (long) i3;
                    i3 = i;
                }
            }
            if (i2 == 0) {
                j = -j;
                AppMethodBeat.o(61533);
                return j;
            } else if (i3 > 1) {
                AppMethodBeat.o(61533);
                return j;
            } else {
                parseException = new ParseException("No digits to parse");
                AppMethodBeat.o(61533);
                throw parseException;
            }
        }
        parseException = new ParseException("No number to parse");
        AppMethodBeat.o(61533);
        throw parseException;
    }

    static /* synthetic */ String zze(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61549);
        String zzc = fastParser.zzc(bufferedReader);
        AppMethodBeat.o(61549);
        return zzc;
    }

    static /* synthetic */ BigInteger zzf(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61550);
        BigInteger zzf = fastParser.zzf(bufferedReader);
        AppMethodBeat.o(61550);
        return zzf;
    }

    private final BigInteger zzf(BufferedReader bufferedReader) {
        AppMethodBeat.i(61534);
        int zza = zza(bufferedReader, this.zzws);
        if (zza == 0) {
            AppMethodBeat.o(61534);
            return null;
        }
        BigInteger bigInteger = new BigInteger(new String(this.zzws, 0, zza));
        AppMethodBeat.o(61534);
        return bigInteger;
    }

    private final float zzg(BufferedReader bufferedReader) {
        AppMethodBeat.i(61536);
        int zza = zza(bufferedReader, this.zzws);
        if (zza == 0) {
            AppMethodBeat.o(61536);
            return 0.0f;
        }
        float parseFloat = Float.parseFloat(new String(this.zzws, 0, zza));
        AppMethodBeat.o(61536);
        return parseFloat;
    }

    static /* synthetic */ BigDecimal zzg(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61551);
        BigDecimal zzi = fastParser.zzi(bufferedReader);
        AppMethodBeat.o(61551);
        return zzi;
    }

    private final double zzh(BufferedReader bufferedReader) {
        AppMethodBeat.i(61537);
        int zza = zza(bufferedReader, this.zzws);
        if (zza == 0) {
            AppMethodBeat.o(61537);
            return 0.0d;
        }
        double parseDouble = Double.parseDouble(new String(this.zzws, 0, zza));
        AppMethodBeat.o(61537);
        return parseDouble;
    }

    private final BigDecimal zzi(BufferedReader bufferedReader) {
        AppMethodBeat.i(61538);
        int zza = zza(bufferedReader, this.zzws);
        if (zza == 0) {
            AppMethodBeat.o(61538);
            return null;
        }
        BigDecimal bigDecimal = new BigDecimal(new String(this.zzws, 0, zza));
        AppMethodBeat.o(61538);
        return bigDecimal;
    }

    private final char zzj(BufferedReader bufferedReader) {
        AppMethodBeat.i(61540);
        if (bufferedReader.read(this.zzwq) == -1) {
            AppMethodBeat.o(61540);
            return 0;
        }
        while (Character.isWhitespace(this.zzwq[0])) {
            if (bufferedReader.read(this.zzwq) == -1) {
                AppMethodBeat.o(61540);
                return 0;
            }
        }
        char c = this.zzwq[0];
        AppMethodBeat.o(61540);
        return c;
    }

    private final void zzk(int i) {
        AppMethodBeat.i(61543);
        if (this.zzxb.isEmpty()) {
            ParseException parseException = new ParseException("Expected state " + i + " but had empty stack");
            AppMethodBeat.o(61543);
            throw parseException;
        }
        int intValue = ((Integer) this.zzxb.pop()).intValue();
        if (intValue != i) {
            ParseException parseException2 = new ParseException("Expected state " + i + " but had " + intValue);
            AppMethodBeat.o(61543);
            throw parseException2;
        }
        AppMethodBeat.o(61543);
    }

    public void parse(InputStream inputStream, T t) {
        AppMethodBeat.i(61523);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        ParseException parseException;
        try {
            this.zzxb.push(Integer.valueOf(0));
            char zzj = zzj(bufferedReader);
            ParseException parseException2;
            switch (zzj) {
                case 0:
                    parseException2 = new ParseException("No data to parse");
                    AppMethodBeat.o(61523);
                    throw parseException2;
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    this.zzxb.push(Integer.valueOf(5));
                    Map fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        Field field = (Field) ((Entry) fieldMappings.entrySet().iterator().next()).getValue();
                        t.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), zza(bufferedReader, field));
                        break;
                    }
                    parseException2 = new ParseException("Object array response class must have a single Field");
                    AppMethodBeat.o(61523);
                    throw parseException2;
                case '{':
                    this.zzxb.push(Integer.valueOf(1));
                    zza(bufferedReader, (FastJsonResponse) t);
                    break;
                default:
                    parseException = new ParseException("Unexpected token: " + zzj);
                    AppMethodBeat.o(61523);
                    throw parseException;
            }
            zzk(0);
            try {
                bufferedReader.close();
                AppMethodBeat.o(61523);
            } catch (IOException e) {
                AppMethodBeat.o(61523);
            }
        } catch (IOException e2) {
            parseException = new ParseException(e2);
            AppMethodBeat.o(61523);
            throw parseException;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
            }
            AppMethodBeat.o(61523);
        }
    }

    public void parse(String str, T t) {
        AppMethodBeat.i(61524);
        InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            parse(byteArrayInputStream, (FastJsonResponse) t);
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
            }
            AppMethodBeat.o(61524);
        }
    }
}
