package com.tencent.ttpic.particle;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Particle {
    public float angle;
    public Vector4 color = new Vector4();
    public float degreesPerSecond;
    public Vector4 deltaColor = new Vector4();
    public Vector2 direction = new Vector2();
    public float particleSize;
    public float particleSizeDelta;
    public Vector2 position = new Vector2();
    public float radialAcceleration;
    public float radius;
    public float radiusDelta;
    public float rotation;
    public float rotationDelta;
    public Vector2 startPos = new Vector2();
    public float tangentialAcceleration;
    public float timeToLive;

    public Particle() {
        AppMethodBeat.i(83604);
        AppMethodBeat.o(83604);
    }

    public void copy(Particle particle) {
        AppMethodBeat.i(83605);
        this.position.copy(particle.position);
        this.direction.copy(particle.direction);
        this.startPos.copy(particle.startPos);
        this.color.copy(particle.color);
        this.deltaColor.copy(particle.deltaColor);
        this.rotation = particle.rotation;
        this.rotationDelta = particle.rotationDelta;
        this.radialAcceleration = particle.radialAcceleration;
        this.tangentialAcceleration = particle.tangentialAcceleration;
        this.radius = particle.radius;
        this.radiusDelta = particle.radiusDelta;
        this.angle = particle.angle;
        this.degreesPerSecond = particle.degreesPerSecond;
        this.particleSize = particle.particleSize;
        this.particleSizeDelta = particle.particleSizeDelta;
        this.timeToLive = particle.timeToLive;
        AppMethodBeat.o(83605);
    }
}
