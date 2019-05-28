package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

final class zzabg {
    static String zza(zzyw zzyw) {
        AppMethodBeat.i(3410);
        zzabh zzabh = new zzabh(zzyw);
        StringBuilder stringBuilder = new StringBuilder(zzabh.size());
        for (int i = 0; i < zzabh.size(); i++) {
            byte zzae = zzabh.zzae(i);
            switch (zzae) {
                case (byte) 7:
                    stringBuilder.append("\\a");
                    break;
                case (byte) 8:
                    stringBuilder.append("\\b");
                    break;
                case (byte) 9:
                    stringBuilder.append("\\t");
                    break;
                case (byte) 10:
                    stringBuilder.append("\\n");
                    break;
                case (byte) 11:
                    stringBuilder.append("\\v");
                    break;
                case (byte) 12:
                    stringBuilder.append("\\f");
                    break;
                case (byte) 13:
                    stringBuilder.append("\\r");
                    break;
                case (byte) 34:
                    stringBuilder.append("\\\"");
                    break;
                case (byte) 39:
                    stringBuilder.append("\\'");
                    break;
                case (byte) 92:
                    stringBuilder.append("\\\\");
                    break;
                default:
                    if (zzae >= (byte) 32 && zzae <= (byte) 126) {
                        stringBuilder.append((char) zzae);
                        break;
                    }
                    stringBuilder.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    stringBuilder.append((char) (((zzae >>> 6) & 3) + 48));
                    stringBuilder.append((char) (((zzae >>> 3) & 7) + 48));
                    stringBuilder.append((char) ((zzae & 7) + 48));
                    break;
                    break;
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(3410);
        return stringBuilder2;
    }
}
