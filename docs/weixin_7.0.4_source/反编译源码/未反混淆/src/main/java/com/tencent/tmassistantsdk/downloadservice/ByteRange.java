package com.tencent.tmassistantsdk.downloadservice;

import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteRange {
    protected static final String BYTES_UNIT = "bytes";
    protected static final Pattern CONTENT_RANGE_HEADER_PATTERN = Pattern.compile("^\\s*bytes\\s+(\\d+)-(\\d+)/(\\d+)\\s*$");
    protected static final String INVALID_RANGE_HEADER_REGEX = "((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)";
    protected static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("^\\s*([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)\\s*$");
    protected static final String UNIT_REGEX = "([^=\\s]+)";
    protected static final String VALID_CONTENT_RANGE_HEADER_REGEX = "bytes\\s+(\\d+)-(\\d+)/(\\d+)";
    protected static final String VALID_RANGE_HEADER_REGEX = "([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)";
    protected final Long end;
    protected final long start;

    static {
        AppMethodBeat.i(75699);
        AppMethodBeat.o(75699);
    }

    public ByteRange(long j) {
        this(j, null);
    }

    public ByteRange(long j, long j2) {
        this(j, Long.valueOf(j2));
        AppMethodBeat.i(75692);
        IllegalArgumentException illegalArgumentException;
        if (j < 0) {
            illegalArgumentException = new IllegalArgumentException("If end is provided, start must be positive.");
            AppMethodBeat.o(75692);
            throw illegalArgumentException;
        } else if (j2 < j) {
            illegalArgumentException = new IllegalArgumentException("end must be >= start.");
            AppMethodBeat.o(75692);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.o(75692);
        }
    }

    protected ByteRange(long j, Long l) {
        this.start = j;
        this.end = l;
    }

    public boolean hasEnd() {
        return this.end != null;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        AppMethodBeat.i(75693);
        if (hasEnd()) {
            long longValue = this.end.longValue();
            AppMethodBeat.o(75693);
            return longValue;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Byte-range does not have end.  Check hasEnd() before use");
        AppMethodBeat.o(75693);
        throw illegalStateException;
    }

    public String toString() {
        AppMethodBeat.i(75694);
        String str;
        if (this.end != null) {
            str = "bytes=" + this.start + "-" + this.end;
            AppMethodBeat.o(75694);
            return str;
        } else if (this.start < 0) {
            str = "bytes=" + this.start;
            AppMethodBeat.o(75694);
            return str;
        } else {
            str = "bytes=" + this.start + "-";
            AppMethodBeat.o(75694);
            return str;
        }
    }

    public static ByteRange parseContentRange(String str) {
        AppMethodBeat.i(75695);
        Matcher matcher = CONTENT_RANGE_HEADER_PATTERN.matcher(str);
        if (matcher.matches()) {
            ByteRange byteRange = new ByteRange(bo.anl(matcher.group(1)), bo.anl(matcher.group(2)));
            AppMethodBeat.o(75695);
            return byteRange;
        }
        Throwable th = new Throwable("Invalid content-range format: ".concat(String.valueOf(str)));
        AppMethodBeat.o(75695);
        throw th;
    }

    public static long getTotalSize(String str) {
        AppMethodBeat.i(75696);
        int indexOf = str.indexOf("/");
        if (indexOf == -1) {
            NotFoundException notFoundException = new NotFoundException();
            AppMethodBeat.o(75696);
            throw notFoundException;
        }
        long anl = bo.anl(str.substring(indexOf + 1));
        AppMethodBeat.o(75696);
        return anl;
    }

    public int hashCode() {
        AppMethodBeat.i(75697);
        int hashCode = Long.valueOf(this.start).hashCode() + 629;
        if (this.end != null) {
            hashCode = (hashCode * 37) + this.end.hashCode();
        }
        AppMethodBeat.o(75697);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(75698);
        if (obj instanceof ByteRange) {
            ByteRange byteRange = (ByteRange) obj;
            if (this.start != byteRange.getStart()) {
                AppMethodBeat.o(75698);
                return false;
            } else if (hasEnd() != byteRange.hasEnd()) {
                AppMethodBeat.o(75698);
                return false;
            } else if (hasEnd()) {
                boolean equals = this.end.equals(Long.valueOf(byteRange.getEnd()));
                AppMethodBeat.o(75698);
                return equals;
            } else {
                AppMethodBeat.o(75698);
                return true;
            }
        }
        AppMethodBeat.o(75698);
        return false;
    }
}
