package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzaaz extends zzaay<FieldDescriptorType, Object> {
    zzaaz(int i) {
        super(i, null);
    }

    public final void zzrg() {
        AppMethodBeat.m2504i(3388);
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzuj()) {
                    break;
                }
                Entry zzah = zzah(i2);
                if (((zzzo) zzah.getKey()).zztk()) {
                    zzah.setValue(Collections.unmodifiableList((List) zzah.getValue()));
                }
                i = i2 + 1;
            }
            for (Entry entry : zzuk()) {
                if (((zzzo) entry.getKey()).zztk()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzrg();
        AppMethodBeat.m2505o(3388);
    }
}
