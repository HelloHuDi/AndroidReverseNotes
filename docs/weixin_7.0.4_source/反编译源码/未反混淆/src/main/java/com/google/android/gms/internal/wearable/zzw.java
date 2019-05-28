package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzw {
    private static final int zzhn = 11;
    private static final int zzho = 12;
    private static final int zzhp = 16;
    private static final int zzhq = 26;
    private static final int[] zzhr = new int[0];
    public static final long[] zzhs = new long[0];
    public static final float[] zzht = new float[0];
    private static final double[] zzhu = new double[0];
    private static final boolean[] zzhv = new boolean[0];
    public static final String[] zzhw = new String[0];
    private static final byte[][] zzhx = new byte[0][];
    public static final byte[] zzhy = new byte[0];

    public static final int zzb(zzk zzk, int i) {
        AppMethodBeat.i(70784);
        int i2 = 1;
        int position = zzk.getPosition();
        zzk.zzd(i);
        while (zzk.zzj() == i) {
            zzk.zzd(i);
            i2++;
        }
        zzk.zzc(position, i);
        AppMethodBeat.o(70784);
        return i2;
    }
}
