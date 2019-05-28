package android.support.c.a;

import android.animation.TypeEvaluator;

public final class f implements TypeEvaluator {
    private static final f uG = new f();

    public static f cF() {
        return uG;
    }

    public final Object evaluate(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f2 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        float f3 = ((float) ((intValue >> 16) & 255)) / 255.0f;
        float f4 = ((float) ((intValue >> 8) & 255)) / 255.0f;
        float f5 = ((float) (intValue & 255)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float f6 = ((float) ((intValue2 >> 24) & 255)) / 255.0f;
        float f7 = ((float) ((intValue2 >> 16) & 255)) / 255.0f;
        float f8 = ((float) ((intValue2 >> 8) & 255)) / 255.0f;
        f3 = (float) Math.pow((double) f3, 2.2d);
        f4 = (float) Math.pow((double) f4, 2.2d);
        f5 = (float) Math.pow((double) f5, 2.2d);
        return Integer.valueOf(Math.round(((float) Math.pow((double) (f5 + ((((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - f5) * f)), 0.45454545454545453d)) * 255.0f) | (((Math.round((f2 + ((f6 - f2) * f)) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (f3 + ((((float) Math.pow((double) f7, 2.2d)) - f3) * f)), 0.45454545454545453d)) * 255.0f) << 16)) | (Math.round(((float) Math.pow((double) (f4 + ((((float) Math.pow((double) f8, 2.2d)) - f4) * f)), 0.45454545454545453d)) * 255.0f) << 8)));
    }
}
