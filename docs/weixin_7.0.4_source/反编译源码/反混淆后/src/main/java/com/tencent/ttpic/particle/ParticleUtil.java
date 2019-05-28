package com.tencent.ttpic.particle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public class ParticleUtil {
    public static Vector2 vectorSubtract(Vector2 vector2, Vector2 vector22) {
        AppMethodBeat.m2504i(83633);
        Vector2 vector23 = new Vector2(vector2.f17535x - vector22.f17535x, vector2.f17536y - vector22.f17536y);
        AppMethodBeat.m2505o(83633);
        return vector23;
    }

    public static Vector2 vectorNormalize(Vector2 vector2) {
        AppMethodBeat.m2504i(83634);
        if (Float.compare(vector2.f17535x, 0.0f) == 0 && Float.compare(vector2.f17536y, 0.0f) == 0) {
            AppMethodBeat.m2505o(83634);
            return null;
        }
        float sqrt = (float) Math.sqrt(Math.pow((double) vector2.f17535x, 2.0d) + Math.pow((double) vector2.f17535x, 2.0d));
        Vector2 vector22 = new Vector2(vector2.f17535x / sqrt, vector2.f17536y / sqrt);
        AppMethodBeat.m2505o(83634);
        return vector22;
    }

    public static Vector2 vectorMultiplyScalar(Vector2 vector2, float f) {
        AppMethodBeat.m2504i(83635);
        Vector2 vector22 = new Vector2(vector2.f17535x * f, vector2.f17536y * f);
        AppMethodBeat.m2505o(83635);
        return vector22;
    }

    public static Vector2 vectorAdd(Vector2 vector2, Vector2 vector22) {
        AppMethodBeat.m2504i(83636);
        Vector2 vector23 = new Vector2(vector2.f17535x + vector22.f17535x, vector2.f17536y + vector22.f17536y);
        AppMethodBeat.m2505o(83636);
        return vector23;
    }

    public static float randomMinus1to1() {
        AppMethodBeat.m2504i(83637);
        float nextFloat = 1.0f - (new Random().nextFloat() * 2.0f);
        AppMethodBeat.m2505o(83637);
        return nextFloat;
    }

    public static float random0to1() {
        AppMethodBeat.m2504i(83638);
        float nextFloat = new Random().nextFloat();
        AppMethodBeat.m2505o(83638);
        return nextFloat;
    }

    public static float dot(Vector2 vector2, Vector2 vector22) {
        return (vector2.f17535x * vector22.f17535x) + (vector2.f17536y * vector22.f17536y);
    }

    public static Vector2 revert(Vector2 vector2) {
        AppMethodBeat.m2504i(83639);
        Vector2 vector22 = new Vector2(-vector2.f17535x, -vector2.f17536y);
        AppMethodBeat.m2505o(83639);
        return vector22;
    }
}
