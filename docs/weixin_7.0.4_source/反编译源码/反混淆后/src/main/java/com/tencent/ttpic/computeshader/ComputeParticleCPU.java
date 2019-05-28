package com.tencent.ttpic.computeshader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.particle.ParticleUtil;
import com.tencent.ttpic.particle.Vector2;
import com.tencent.ttpic.particle.Vector4;
import java.util.Random;

public class ComputeParticleCPU {
    private static final int PARTICLE_COUNT = 131072;
    private static float frameTimer = 0.033f;
    private Particle[] particles = new Particle[131072];
    private float timer;
    private UBO ubo;

    public ComputeParticleCPU() {
        AppMethodBeat.m2504i(81851);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 131072; i++) {
            Particle particle = new Particle();
            particle.pos = new Vector2((random.nextFloat() * 2.0f) - 1.0f, (random.nextFloat() * 2.0f) - 1.0f);
            particle.vel = new Vector2(0.0f, 0.0f);
            particle.gradientPos = new Vector4();
            particle.gradientPos.f4890r = particle.pos.f17535x / 2.0f;
            this.particles[i] = particle;
        }
        updateUniformBuffer();
        AppMethodBeat.m2505o(81851);
    }

    private void updateUniformBuffer() {
        AppMethodBeat.m2504i(81852);
        this.ubo = new UBO();
        this.ubo.deltaT = frameTimer * 2.5f;
        this.ubo.destX = (float) (Math.sin(Math.toRadians((double) (this.timer * 360.0f))) * 0.75d);
        this.ubo.destY = 0.0f;
        this.ubo.particleCount = 131072;
        AppMethodBeat.m2505o(81852);
    }

    public void compute() {
        AppMethodBeat.m2504i(81853);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 131072) {
                break;
            }
            Vector2 vector2 = this.particles[i2].vel;
            Vector2 vector22 = this.particles[i2].pos;
            Vector2 vector23 = new Vector2(this.ubo.destX, this.ubo.destY);
            Vector2 vectorSubtract = ParticleUtil.vectorSubtract(vector23, vector22);
            Math.sqrt((double) ParticleUtil.dot(vectorSubtract, vectorSubtract));
            vector2 = ParticleUtil.vectorAdd(vector2, ParticleUtil.vectorMultiplyScalar(repulsion(vector22, vector23), 0.05f));
            vector22 = ParticleUtil.vectorAdd(vector22, ParticleUtil.vectorMultiplyScalar(vector2, this.ubo.deltaT));
            if (((double) vector22.f17535x) < -1.0d || ((double) vector22.f17535x) > 1.0d || ((double) vector22.f17536y) < -1.0d || ((double) vector22.f17536y) > 1.0d) {
                vector2 = ParticleUtil.vectorAdd(ParticleUtil.vectorMultiplyScalar(ParticleUtil.revert(vector2), 0.1f), ParticleUtil.vectorMultiplyScalar(attraction(vector22, vector23), 12.0f));
            } else {
                this.particles[i2].pos = vector22;
            }
            this.particles[i2].vel = vector2;
            Vector4 vector4 = this.particles[i2].gradientPos;
            vector4.f4890r = (float) (((double) vector4.f4890r) + (0.02d * ((double) this.ubo.deltaT)));
            if (((double) this.particles[i2].gradientPos.f4890r) > 1.0d) {
                vector4 = this.particles[i2].gradientPos;
                vector4.f4890r = (float) (((double) vector4.f4890r) - 1.0d);
            }
            i = i2 + 1;
        }
        this.timer += frameTimer * 0.04f;
        if (this.timer > 1.0f) {
            this.timer = 0.0f;
        }
        AppMethodBeat.m2505o(81853);
    }

    private Vector2 attraction(Vector2 vector2, Vector2 vector22) {
        AppMethodBeat.m2504i(81854);
        Vector2 vectorSubtract = ParticleUtil.vectorSubtract(vector22, vector2);
        float sqrt = (float) (1.0d / Math.sqrt((double) (ParticleUtil.dot(vectorSubtract, vectorSubtract) + 0.5f)));
        vectorSubtract = ParticleUtil.vectorMultiplyScalar(vectorSubtract, (sqrt * (sqrt * sqrt)) * 0.0035f);
        AppMethodBeat.m2505o(81854);
        return vectorSubtract;
    }

    /* Access modifiers changed, original: 0000 */
    public Vector2 repulsion(Vector2 vector2, Vector2 vector22) {
        AppMethodBeat.m2504i(81855);
        Vector2 vectorSubtract = ParticleUtil.vectorSubtract(vector22, vector2);
        float sqrt = (float) Math.sqrt((double) ParticleUtil.dot(vectorSubtract, vectorSubtract));
        vectorSubtract = ParticleUtil.vectorMultiplyScalar(vectorSubtract, (1.0f / (sqrt * (sqrt * sqrt))) * -3.5E-5f);
        AppMethodBeat.m2505o(81855);
        return vectorSubtract;
    }
}
