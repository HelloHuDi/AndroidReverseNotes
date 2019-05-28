package com.tencent.ttpic.model;

public class Transition {
    public static final int CUR_EMITTER_PT = 1;
    public static final int EMIT_START_PT = 0;
    public static final int SCREEN_LEFT_TOP = 2;
    public int clearMode;
    public int emissionMode;
    public float emissionRate;
    public String life;
    public int minUpdateInterval;
    public String p0;
    public String p1;
    public String p2;
    public boolean particleAlwaysUpdate;
    public int particleCountMax;
    public String positionX;
    public String positionY;
    public int repeatCount;
    public String rotate;
    public String scale;
}
