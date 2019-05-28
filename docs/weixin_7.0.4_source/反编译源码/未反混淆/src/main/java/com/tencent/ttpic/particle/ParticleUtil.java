package com.tencent.ttpic.particle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public class ParticleUtil {
    public static Vector2 vectorSubtract(Vector2 vector2, Vector2 vector22) {
        AppMethodBeat.i(83633);
        Vector2 vector23 = new Vector2(vector2.x - vector22.x, vector2.y - vector22.y);
        AppMethodBeat.o(83633);
        return vector23;
    }

    public static Vector2 vectorNormalize(Vector2 vector2) {
        AppMethodBeat.i(83634);
        if (Float.compare(vector2.x, 0.0f) == 0 && Float.compare(vector2.y, 0.0f) == 0) {
            AppMethodBeat.o(83634);
            return null;
        }
        float sqrt = (float) Math.sqrt(Math.pow((double) vector2.x, 2.0d) + Math.pow((double) vector2.x, 2.0d));
        Vector2 vector22 = new Vector2(vector2.x / sqrt, vector2.y / sqrt);
        AppMethodBeat.o(83634);
        return vector22;
    }

    public static Vector2 vectorMultiplyScalar(Vector2 vector2, float f) {
        AppMethodBeat.i(83635);
        Vector2 vector22 = new Vector2(vector2.x * f, vector2.y * f);
        AppMethodBeat.o(83635);
        return vector22;
    }

    public static Vector2 vectorAdd(Vector2 vector2, Vector2 vector22) {
        AppMethodBeat.i(83636);
        Vector2 vector23 = new Vector2(vector2.x + vector22.x, vector2.y + vector22.y);
        AppMethodBeat.o(83636);
        return vector23;
    }

    public static float randomMinus1to1() {
        AppMethodBeat.i(83637);
        float nextFloat = 1.0f - (new Random().nextFloat() * 2.0f);
        AppMethodBeat.o(83637);
        return nextFloat;
    }

    public static float random0to1() {
        AppMethodBeat.i(83638);
        float nextFloat = new Random().nextFloat();
        AppMethodBeat.o(83638);
        return nextFloat;
    }

    public static float dot(Vector2 vector2, Vector2 vector22) {
        return (vector2.x * vector22.x) + (vector2.y * vector22.y);
    }

    public static Vector2 revert(Vector2 vector2) {
        AppMethodBeat.i(83639);
        Vector2 vector22 = new Vector2(-vector2.x, -vector2.y);
        AppMethodBeat.o(83639);
        return vector22;
    }
}
