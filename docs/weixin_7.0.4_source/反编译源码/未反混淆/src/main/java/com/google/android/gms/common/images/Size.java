package com.google.android.gms.common.images;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class Size {
    private final int zzps;
    private final int zzpt;

    public Size(int i, int i2) {
        this.zzps = i;
        this.zzpt = i2;
    }

    public static Size parseSize(String str) {
        AppMethodBeat.i(61245);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("string must not be null");
            AppMethodBeat.o(61245);
            throw illegalArgumentException;
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        NumberFormatException zzi;
        if (indexOf < 0) {
            zzi = zzi(str);
            AppMethodBeat.o(61245);
            throw zzi;
        }
        try {
            Size size = new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            AppMethodBeat.o(61245);
            return size;
        } catch (NumberFormatException e) {
            zzi = zzi(str);
            AppMethodBeat.o(61245);
            throw zzi;
        }
    }

    private static NumberFormatException zzi(String str) {
        AppMethodBeat.i(61244);
        NumberFormatException numberFormatException = new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 16).append("Invalid Size: \"").append(str).append("\"").toString());
        AppMethodBeat.o(61244);
        throw numberFormatException;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzps == size.zzps && this.zzpt == size.zzpt;
    }

    public final int getHeight() {
        return this.zzpt;
    }

    public final int getWidth() {
        return this.zzps;
    }

    public final int hashCode() {
        return this.zzpt ^ ((this.zzps << 16) | (this.zzps >>> 16));
    }

    public final String toString() {
        AppMethodBeat.i(61243);
        int i = this.zzps;
        String str = i + VideoMaterialUtil.CRAZYFACE_X + this.zzpt;
        AppMethodBeat.o(61243);
        return str;
    }
}
