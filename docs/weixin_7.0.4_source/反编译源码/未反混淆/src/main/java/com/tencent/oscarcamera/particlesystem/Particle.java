package com.tencent.oscarcamera.particlesystem;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Particle {
    public double[] a = new double[10];
    public double birth;
    public int currFrame;
    public int frameCount;
    public boolean musicPlayed = false;
    public Particle next = null;
    int param_offset;
    public String tex;
    public int total = 0;
    public double[] touchedPosition = new double[3];

    public Particle() {
        AppMethodBeat.i(81511);
        AppMethodBeat.o(81511);
    }

    public String toString() {
        AppMethodBeat.i(81512);
        String format = String.format("(%f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %d, %d)", new Object[]{Double.valueOf(this.a[2]), Double.valueOf(this.a[0]), Double.valueOf(this.a[1]), Double.valueOf(this.a[7]), Double.valueOf(this.a[8]), Double.valueOf(this.a[9]), Double.valueOf(this.a[3]), Double.valueOf(this.a[4]), Double.valueOf(this.a[5]), Double.valueOf(this.a[6]), Integer.valueOf(this.frameCount), Integer.valueOf(this.currFrame)});
        AppMethodBeat.o(81512);
        return format;
    }

    /* Access modifiers changed, original: 0000 */
    public void copy(Particle particle) {
        if (particle != null) {
            this.tex = particle.tex;
            this.frameCount = particle.frameCount;
            this.currFrame = particle.currFrame;
            int length = this.a.length;
            for (int i = 0; i < length; i++) {
                this.a[i] = particle.a[i];
            }
            this.touchedPosition[0] = particle.touchedPosition[0];
            this.touchedPosition[1] = particle.touchedPosition[1];
            this.touchedPosition[2] = particle.touchedPosition[2];
        }
    }
}
