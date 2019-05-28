package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumSet;
import java.util.Iterator;

public enum SmartLoginOption {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    
    public static final EnumSet<SmartLoginOption> ALL = null;
    private final long mValue;

    static {
        ALL = EnumSet.allOf(SmartLoginOption.class);
        AppMethodBeat.o(72484);
    }

    public static EnumSet<SmartLoginOption> parseOptions(long j) {
        AppMethodBeat.i(72483);
        EnumSet noneOf = EnumSet.noneOf(SmartLoginOption.class);
        Iterator it = ALL.iterator();
        while (it.hasNext()) {
            SmartLoginOption smartLoginOption = (SmartLoginOption) it.next();
            if ((smartLoginOption.getValue() & j) != 0) {
                noneOf.add(smartLoginOption);
            }
        }
        AppMethodBeat.o(72483);
        return noneOf;
    }

    private SmartLoginOption(long j) {
        this.mValue = j;
    }

    public final long getValue() {
        return this.mValue;
    }
}
