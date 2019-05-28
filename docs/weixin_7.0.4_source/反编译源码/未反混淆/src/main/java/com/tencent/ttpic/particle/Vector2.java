package com.tencent.ttpic.particle;

public class Vector2 {
    public float x;
    public float y;

    Vector2() {
    }

    public Vector2(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public void copy(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
    }
}
