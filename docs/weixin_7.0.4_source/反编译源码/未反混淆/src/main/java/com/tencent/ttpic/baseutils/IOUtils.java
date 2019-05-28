package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final String LINE_SEPARATOR;
    public static final String LINE_SEPARATOR_UNIX = "\n";
    public static final String LINE_SEPARATOR_WINDOWS = "\r\n";

    static {
        AppMethodBeat.i(49765);
        StringWriter stringWriter = new StringWriter(4);
        new PrintWriter(stringWriter).println();
        LINE_SEPARATOR = stringWriter.toString();
        AppMethodBeat.o(49765);
    }

    public static void closeQuietly(Reader reader) {
        AppMethodBeat.i(49717);
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                AppMethodBeat.o(49717);
                return;
            }
        }
        AppMethodBeat.o(49717);
    }

    public static void closeQuietly(Writer writer) {
        AppMethodBeat.i(49718);
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                AppMethodBeat.o(49718);
                return;
            }
        }
        AppMethodBeat.o(49718);
    }

    public static void closeQuietly(InputStream inputStream) {
        AppMethodBeat.i(49719);
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                AppMethodBeat.o(49719);
                return;
            }
        }
        AppMethodBeat.o(49719);
    }

    public static void closeQuietly(OutputStream outputStream) {
        AppMethodBeat.i(49720);
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                AppMethodBeat.o(49720);
                return;
            }
        }
        AppMethodBeat.o(49720);
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(49721);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(49721);
                return;
            } catch (Throwable th) {
                LogUtils.e(th);
            }
        }
        AppMethodBeat.o(49721);
    }

    public static byte[] toByteArray(InputStream inputStream) {
        AppMethodBeat.i(49722);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(49722);
        return toByteArray;
    }

    public static byte[] toByteArray(Reader reader) {
        AppMethodBeat.i(49723);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(reader, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(49723);
        return toByteArray;
    }

    public static byte[] toByteArray(Reader reader, String str) {
        AppMethodBeat.i(49724);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(reader, byteArrayOutputStream, str);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(49724);
        return toByteArray;
    }

    public static byte[] toByteArray(String str) {
        AppMethodBeat.i(49725);
        byte[] bytes = str.getBytes();
        AppMethodBeat.o(49725);
        return bytes;
    }

    public static char[] toCharArray(InputStream inputStream) {
        AppMethodBeat.i(49726);
        Writer charArrayWriter = new CharArrayWriter();
        copy(inputStream, charArrayWriter);
        char[] toCharArray = charArrayWriter.toCharArray();
        AppMethodBeat.o(49726);
        return toCharArray;
    }

    public static char[] toCharArray(InputStream inputStream, String str) {
        AppMethodBeat.i(49727);
        Writer charArrayWriter = new CharArrayWriter();
        copy(inputStream, charArrayWriter, str);
        char[] toCharArray = charArrayWriter.toCharArray();
        AppMethodBeat.o(49727);
        return toCharArray;
    }

    public static char[] toCharArray(Reader reader) {
        AppMethodBeat.i(49728);
        Writer charArrayWriter = new CharArrayWriter();
        copy(reader, charArrayWriter);
        char[] toCharArray = charArrayWriter.toCharArray();
        AppMethodBeat.o(49728);
        return toCharArray;
    }

    public static String toString(InputStream inputStream) {
        AppMethodBeat.i(49729);
        Writer stringWriter = new StringWriter();
        copy(inputStream, stringWriter);
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(49729);
        return stringWriter2;
    }

    public static String toString(InputStream inputStream, String str) {
        AppMethodBeat.i(49730);
        Writer stringWriter = new StringWriter();
        copy(inputStream, stringWriter, str);
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(49730);
        return stringWriter2;
    }

    public static String toString(Reader reader) {
        AppMethodBeat.i(49731);
        Writer stringWriter = new StringWriter();
        copy(reader, stringWriter);
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(49731);
        return stringWriter2;
    }

    public static String toString(byte[] bArr) {
        AppMethodBeat.i(49732);
        String str = new String(bArr);
        AppMethodBeat.o(49732);
        return str;
    }

    public static String toString(byte[] bArr, String str) {
        AppMethodBeat.i(49733);
        String str2;
        if (str == null) {
            str2 = new String(bArr);
            AppMethodBeat.o(49733);
            return str2;
        }
        str2 = new String(bArr, str);
        AppMethodBeat.o(49733);
        return str2;
    }

    public static List readLines(InputStream inputStream) {
        AppMethodBeat.i(49734);
        List readLines = readLines(new InputStreamReader(inputStream));
        AppMethodBeat.o(49734);
        return readLines;
    }

    public static List readLines(InputStream inputStream, String str) {
        AppMethodBeat.i(49735);
        List readLines;
        if (str == null) {
            readLines = readLines(inputStream);
            AppMethodBeat.o(49735);
            return readLines;
        }
        readLines = readLines(new InputStreamReader(inputStream, str));
        AppMethodBeat.o(49735);
        return readLines;
    }

    public static List readLines(Reader reader) {
        AppMethodBeat.i(49736);
        BufferedReader bufferedReader = new BufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        for (Object readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            arrayList.add(readLine);
        }
        AppMethodBeat.o(49736);
        return arrayList;
    }

    public static InputStream toInputStream(byte[] bArr) {
        AppMethodBeat.i(49737);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        AppMethodBeat.o(49737);
        return byteArrayInputStream;
    }

    public static InputStream toInputStream(String str) {
        AppMethodBeat.i(49738);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        AppMethodBeat.o(49738);
        return byteArrayInputStream;
    }

    public static InputStream toInputStream(String str, String str2) {
        AppMethodBeat.i(49739);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2 != null ? str.getBytes(str2) : str.getBytes());
        AppMethodBeat.o(49739);
        return byteArrayInputStream;
    }

    public static void write(byte[] bArr, OutputStream outputStream) {
        AppMethodBeat.i(49740);
        if (bArr != null) {
            outputStream.write(bArr);
        }
        AppMethodBeat.o(49740);
    }

    public static void write(byte[] bArr, Writer writer) {
        AppMethodBeat.i(49741);
        if (bArr != null) {
            writer.write(new String(bArr));
        }
        AppMethodBeat.o(49741);
    }

    public static void write(byte[] bArr, Writer writer, String str) {
        AppMethodBeat.i(49742);
        if (bArr != null) {
            if (str == null) {
                write(bArr, writer);
                AppMethodBeat.o(49742);
                return;
            }
            writer.write(new String(bArr, str));
        }
        AppMethodBeat.o(49742);
    }

    public static void write(char[] cArr, Writer writer) {
        AppMethodBeat.i(49743);
        if (cArr != null) {
            writer.write(cArr);
        }
        AppMethodBeat.o(49743);
    }

    public static void write(char[] cArr, OutputStream outputStream) {
        AppMethodBeat.i(49744);
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes());
        }
        AppMethodBeat.o(49744);
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) {
        AppMethodBeat.i(49745);
        if (cArr != null) {
            if (str == null) {
                write(cArr, outputStream);
                AppMethodBeat.o(49745);
                return;
            }
            outputStream.write(new String(cArr).getBytes(str));
        }
        AppMethodBeat.o(49745);
    }

    public static void write(String str, Writer writer) {
        AppMethodBeat.i(49746);
        if (str != null) {
            writer.write(str);
        }
        AppMethodBeat.o(49746);
    }

    public static void write(String str, OutputStream outputStream) {
        AppMethodBeat.i(49747);
        if (str != null) {
            outputStream.write(str.getBytes());
        }
        AppMethodBeat.o(49747);
    }

    public static void write(String str, OutputStream outputStream, String str2) {
        AppMethodBeat.i(49748);
        if (str != null) {
            if (str2 == null) {
                write(str, outputStream);
                AppMethodBeat.o(49748);
                return;
            }
            outputStream.write(str.getBytes(str2));
        }
        AppMethodBeat.o(49748);
    }

    public static void write(StringBuffer stringBuffer, Writer writer) {
        AppMethodBeat.i(49749);
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
        AppMethodBeat.o(49749);
    }

    public static void write(StringBuffer stringBuffer, OutputStream outputStream) {
        AppMethodBeat.i(49750);
        if (stringBuffer != null) {
            outputStream.write(stringBuffer.toString().getBytes());
        }
        AppMethodBeat.o(49750);
    }

    public static void write(StringBuffer stringBuffer, OutputStream outputStream, String str) {
        AppMethodBeat.i(49751);
        if (stringBuffer != null) {
            if (str == null) {
                write(stringBuffer, outputStream);
                AppMethodBeat.o(49751);
                return;
            }
            outputStream.write(stringBuffer.toString().getBytes(str));
        }
        AppMethodBeat.o(49751);
    }

    public static void writeLines(Collection collection, String str, OutputStream outputStream) {
        AppMethodBeat.i(49752);
        if (collection == null) {
            AppMethodBeat.o(49752);
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        for (Object next : collection) {
            if (next != null) {
                outputStream.write(next.toString().getBytes());
            }
            outputStream.write(str.getBytes());
        }
        AppMethodBeat.o(49752);
    }

    public static void writeLines(Collection collection, String str, OutputStream outputStream, String str2) {
        AppMethodBeat.i(49753);
        if (str2 == null) {
            writeLines(collection, str, outputStream);
            AppMethodBeat.o(49753);
        } else if (collection == null) {
            AppMethodBeat.o(49753);
        } else {
            if (str == null) {
                str = LINE_SEPARATOR;
            }
            for (Object next : collection) {
                if (next != null) {
                    outputStream.write(next.toString().getBytes(str2));
                }
                outputStream.write(str.getBytes(str2));
            }
            AppMethodBeat.o(49753);
        }
    }

    public static void writeLines(Collection collection, String str, Writer writer) {
        AppMethodBeat.i(49754);
        if (collection == null) {
            AppMethodBeat.o(49754);
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        for (Object next : collection) {
            if (next != null) {
                writer.write(next.toString());
            }
            writer.write(str);
        }
        AppMethodBeat.o(49754);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(49755);
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            AppMethodBeat.o(49755);
            return -1;
        }
        int i = (int) copyLarge;
        AppMethodBeat.o(49755);
        return i;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(49756);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                AppMethodBeat.o(49756);
                return j;
            }
        }
    }

    public static void copy(InputStream inputStream, Writer writer) {
        AppMethodBeat.i(49757);
        copy(new InputStreamReader(inputStream), writer);
        AppMethodBeat.o(49757);
    }

    public static void copy(InputStream inputStream, Writer writer, String str) {
        AppMethodBeat.i(49758);
        if (str == null) {
            copy(inputStream, writer);
            AppMethodBeat.o(49758);
            return;
        }
        copy(new InputStreamReader(inputStream, str), writer);
        AppMethodBeat.o(49758);
    }

    public static int copy(Reader reader, Writer writer) {
        AppMethodBeat.i(49759);
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > 2147483647L) {
            AppMethodBeat.o(49759);
            return -1;
        }
        int i = (int) copyLarge;
        AppMethodBeat.o(49759);
        return i;
    }

    public static long copyLarge(Reader reader, Writer writer) {
        AppMethodBeat.i(49760);
        char[] cArr = new char[4096];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 != read) {
                writer.write(cArr, 0, read);
                j += (long) read;
            } else {
                AppMethodBeat.o(49760);
                return j;
            }
        }
    }

    public static void copy(Reader reader, OutputStream outputStream) {
        AppMethodBeat.i(49761);
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
        AppMethodBeat.o(49761);
    }

    public static void copy(Reader reader, OutputStream outputStream, String str) {
        AppMethodBeat.i(49762);
        if (str == null) {
            copy(reader, outputStream);
            AppMethodBeat.o(49762);
            return;
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, str);
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
        AppMethodBeat.o(49762);
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) {
        AppMethodBeat.i(49763);
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        for (int read = inputStream.read(); -1 != read; read = inputStream.read()) {
            if (read != inputStream2.read()) {
                AppMethodBeat.o(49763);
                return false;
            }
        }
        if (inputStream2.read() == -1) {
            AppMethodBeat.o(49763);
            return true;
        }
        AppMethodBeat.o(49763);
        return false;
    }

    public static boolean contentEquals(Reader reader, Reader reader2) {
        AppMethodBeat.i(49764);
        if (!(reader instanceof BufferedReader)) {
            reader = new BufferedReader(reader);
        }
        if (!(reader2 instanceof BufferedReader)) {
            reader2 = new BufferedReader(reader2);
        }
        for (int read = reader.read(); -1 != read; read = reader.read()) {
            if (read != reader2.read()) {
                AppMethodBeat.o(49764);
                return false;
            }
        }
        if (reader2.read() == -1) {
            AppMethodBeat.o(49764);
            return true;
        }
        AppMethodBeat.o(49764);
        return false;
    }
}
