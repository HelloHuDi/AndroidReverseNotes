package com.tencent.ttpic.particle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;

public class ParticleEmitter {
    private static final String TAG = ParticleEmitter.class.getSimpleName();
    public boolean active;
    public float angle;
    public float angleVariance;
    private float audioColorDelta;
    public int blendFuncDestination;
    public int blendFuncSource;
    public float duration;
    public float elapsedTime;
    public float emissionRate;
    public float emitCounter;
    public int emitterType;
    public Vector4 finishColor;
    public Vector4 finishColorVariance;
    public float finishParticleSize;
    public float finishParticleSizeVariance;
    public Vector2 gravity;
    public int maxParticles;
    public float maxRadius;
    public float maxRadiusVariance;
    public float minRadius;
    public float minRadiusVariance;
    public boolean opacityModifyRGB;
    public float[] particleColors;
    public int particleCount;
    private int particleIndex;
    public int[] particleIndices;
    public float particleLifespan;
    public float particleLifespanVariance;
    public float[] particleTextureCoordinates;
    public float[] particleVertices;
    private Particle[] particles;
    private ParticleQuad[] quads;
    public float radialAccelVariance;
    public float radialAcceleration;
    public float radiusSpeed;
    private float rotateParticle = 0.0f;
    public float rotatePerSecond;
    public float rotatePerSecondVariance;
    public float rotationEnd;
    public float rotationEndVariance;
    public float rotationStart;
    public float rotationStartVariance;
    private float scaleParticle = 1.0f;
    public Vector2 sourcePosition;
    public Vector2 sourcePositionVariance;
    public float speed;
    public float speedVariance;
    public Vector4 startColor;
    public Vector4 startColorVariance;
    public float startParticleSize;
    public float startParticleSizeVariance;
    public long startTime;
    public float tangentialAccelVariance;
    public float tangentialAcceleration;
    public int texture;

    enum kParticleTypes {
        kParticleTypeGravity(0),
        kParticleTypeRadial(1);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(83608);
        }

        private kParticleTypes(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.m2504i(83618);
        AppMethodBeat.m2505o(83618);
    }

    public void initEmitter(String str, ParticleConfig particleConfig) {
        AppMethodBeat.m2504i(83609);
        setParticleConfig(str, particleConfig);
        setupArrays();
        AppMethodBeat.m2505o(83609);
    }

    public void updateWithCurrentTime(long j, boolean z) {
        long j2 = 0;
        AppMethodBeat.m2504i(83610);
        if (this.startTime > 0) {
            j2 = j - this.startTime;
        }
        this.startTime = j;
        updateWithDelta((((float) j2) * 1.0f) / 1000.0f, z);
        AppMethodBeat.m2505o(83610);
    }

    private boolean addParticle() {
        AppMethodBeat.m2504i(83611);
        if (this.particleCount == this.maxParticles) {
            AppMethodBeat.m2505o(83611);
            return false;
        }
        initParticle(this.particles[this.particleCount]);
        this.particleCount++;
        AppMethodBeat.m2505o(83611);
        return true;
    }

    private void setParticleConfig(String str, ParticleConfig particleConfig) {
        Vector2 vector2;
        float value;
        Vector4 vector4;
        int value2;
        CharSequence charSequence;
        Bitmap base64ToBitmap;
        String str2 = null;
        AppMethodBeat.m2504i(83612);
        ParticleEmitterConfigBean particleEmitterConfig = particleConfig.getParticleEmitterConfig();
        this.emitterType = particleEmitterConfig.emitterType != null ? particleEmitterConfig.emitterType.getValue() : 0;
        if (particleEmitterConfig.sourcePosition != null) {
            vector2 = new Vector2(particleEmitterConfig.sourcePosition.f14335x, particleEmitterConfig.sourcePosition.f14336y);
        } else {
            vector2 = null;
        }
        this.sourcePosition = vector2;
        if (particleEmitterConfig.sourcePositionVariance != null) {
            vector2 = new Vector2(particleEmitterConfig.sourcePositionVariance.f14337x, particleEmitterConfig.sourcePositionVariance.f14338y);
        } else {
            vector2 = null;
        }
        this.sourcePositionVariance = vector2;
        if (particleEmitterConfig.speed != null) {
            value = particleEmitterConfig.speed.getValue();
        } else {
            value = 0.0f;
        }
        this.speed = value;
        if (particleEmitterConfig.speedVariance != null) {
            value = particleEmitterConfig.speedVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.speedVariance = value;
        if (particleEmitterConfig.particleLifeSpan != null) {
            value = particleEmitterConfig.particleLifeSpan.getValue();
        } else {
            value = 0.0f;
        }
        this.particleLifespan = value;
        if (particleEmitterConfig.particleLifespanVariance != null) {
            value = particleEmitterConfig.particleLifespanVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.particleLifespanVariance = value;
        if (particleEmitterConfig.angle != null) {
            value = particleEmitterConfig.angle.getValue();
        } else {
            value = 0.0f;
        }
        this.angle = value;
        if (particleEmitterConfig.angleVariance != null) {
            value = particleEmitterConfig.angleVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.angleVariance = value;
        if (particleEmitterConfig.gravity != null) {
            vector2 = new Vector2(particleEmitterConfig.gravity.f1683x, particleEmitterConfig.gravity.f1684y);
        } else {
            vector2 = null;
        }
        this.gravity = vector2;
        if (particleEmitterConfig.radialAcceleration != null) {
            value = particleEmitterConfig.radialAcceleration.getValue();
        } else {
            value = 0.0f;
        }
        this.radialAcceleration = value;
        if (particleEmitterConfig.tangentialAcceleration != null) {
            value = particleEmitterConfig.tangentialAcceleration.getValue();
        } else {
            value = 0.0f;
        }
        this.tangentialAcceleration = value;
        if (particleEmitterConfig.tangentialAccelVariance != null) {
            value = particleEmitterConfig.tangentialAccelVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.tangentialAccelVariance = value;
        if (particleEmitterConfig.startColor != null) {
            vector4 = new Vector4(particleEmitterConfig.startColor.red, particleEmitterConfig.startColor.green, particleEmitterConfig.startColor.blue, particleEmitterConfig.startColor.alpha);
        } else {
            vector4 = null;
        }
        this.startColor = vector4;
        if (particleEmitterConfig.startColorVariance != null) {
            vector4 = new Vector4(particleEmitterConfig.startColorVariance.red, particleEmitterConfig.startColorVariance.green, particleEmitterConfig.startColorVariance.blue, particleEmitterConfig.startColorVariance.alpha);
        } else {
            vector4 = null;
        }
        this.startColorVariance = vector4;
        if (particleEmitterConfig.finishColor != null) {
            vector4 = new Vector4(particleEmitterConfig.finishColor.red, particleEmitterConfig.finishColor.green, particleEmitterConfig.finishColor.blue, particleEmitterConfig.finishColor.alpha);
        } else {
            vector4 = null;
        }
        this.finishColor = vector4;
        if (particleEmitterConfig.finishColorVariance != null) {
            vector4 = new Vector4(particleEmitterConfig.finishColorVariance.red, particleEmitterConfig.finishColorVariance.green, particleEmitterConfig.finishColorVariance.blue, particleEmitterConfig.finishColorVariance.alpha);
        } else {
            vector4 = null;
        }
        this.finishColorVariance = vector4;
        if (particleEmitterConfig.maxParticles != null) {
            value2 = particleEmitterConfig.maxParticles.getValue();
        } else {
            value2 = 0;
        }
        this.maxParticles = value2;
        if (particleEmitterConfig.startParticleSize != null) {
            value = particleEmitterConfig.startParticleSize.getValue();
        } else {
            value = 0.0f;
        }
        this.startParticleSize = value;
        if (particleEmitterConfig.startParticleSizeVariance != null) {
            value = particleEmitterConfig.startParticleSizeVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.startParticleSizeVariance = value;
        if (particleEmitterConfig.finishParticleSize != null) {
            value = particleEmitterConfig.finishParticleSize.getValue();
        } else {
            value = 0.0f;
        }
        this.finishParticleSize = value;
        if (particleEmitterConfig.finishParticleSizeVariance != null) {
            value = particleEmitterConfig.finishParticleSizeVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.finishParticleSizeVariance = value;
        if (particleEmitterConfig.duration != null) {
            value = particleEmitterConfig.duration.getValue();
        } else {
            value = 0.0f;
        }
        this.duration = value;
        if (particleEmitterConfig.blendFuncSource != null) {
            value2 = particleEmitterConfig.blendFuncSource.getValue();
        } else {
            value2 = 0;
        }
        this.blendFuncSource = value2;
        if (particleEmitterConfig.blendFuncDestination != null) {
            value2 = particleEmitterConfig.blendFuncDestination.getValue();
        } else {
            value2 = 0;
        }
        this.blendFuncDestination = value2;
        if (particleEmitterConfig.maxRadius != null) {
            value = particleEmitterConfig.maxRadius.getValue();
        } else {
            value = 0.0f;
        }
        this.maxRadius = value;
        if (particleEmitterConfig.maxRadiusVariance != null) {
            value = particleEmitterConfig.maxRadiusVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.maxRadiusVariance = value;
        if (particleEmitterConfig.minRadius != null) {
            value = particleEmitterConfig.minRadius.getValue();
        } else {
            value = 0.0f;
        }
        this.minRadius = value;
        if (particleEmitterConfig.minRadiusVariance != null) {
            value = particleEmitterConfig.minRadiusVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.minRadiusVariance = value;
        if (particleEmitterConfig.rotatePerSecond != null) {
            value = particleEmitterConfig.rotatePerSecond.getValue();
        } else {
            value = 0.0f;
        }
        this.rotatePerSecond = value;
        if (particleEmitterConfig.rotatePerSecondVariance != null) {
            value = particleEmitterConfig.rotatePerSecondVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.rotatePerSecondVariance = value;
        if (particleEmitterConfig.rotationStart != null) {
            value = particleEmitterConfig.rotationStart.getValue();
        } else {
            value = 0.0f;
        }
        this.rotationStart = value;
        if (particleEmitterConfig.rotationStartVariance != null) {
            value = particleEmitterConfig.rotationStartVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.rotationStartVariance = value;
        if (particleEmitterConfig.rotationEnd != null) {
            value = particleEmitterConfig.rotationEnd.getValue();
        } else {
            value = 0.0f;
        }
        this.rotationEnd = value;
        if (particleEmitterConfig.rotationEndVariance != null) {
            value = particleEmitterConfig.rotationEndVariance.getValue();
        } else {
            value = 0.0f;
        }
        this.rotationEndVariance = value;
        this.emissionRate = ((float) this.maxParticles) / this.particleLifespan;
        this.emitCounter = 0.0f;
        if (particleEmitterConfig.texture != null) {
            charSequence = particleEmitterConfig.texture.name;
        } else {
            charSequence = null;
        }
        if (particleEmitterConfig.texture != null) {
            str2 = particleEmitterConfig.texture.data;
        }
        if (TextUtils.isEmpty(charSequence)) {
            base64ToBitmap = base64ToBitmap(str2);
        } else {
            base64ToBitmap = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), str + File.separator + charSequence, 1);
        }
        if (!(base64ToBitmap == null || base64ToBitmap.isRecycled())) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.texture = iArr[0];
            GlUtil.loadTexture(this.texture, base64ToBitmap);
            base64ToBitmap.recycle();
        }
        AppMethodBeat.m2505o(83612);
    }

    private void setupArrays() {
        int i;
        AppMethodBeat.m2504i(83613);
        this.particles = new Particle[this.maxParticles];
        for (i = 0; i < this.particles.length; i++) {
            this.particles[i] = new Particle();
        }
        this.quads = new ParticleQuad[this.maxParticles];
        for (i = 0; i < this.quads.length; i++) {
            this.quads[i] = new ParticleQuad();
        }
        this.particleIndices = new int[(this.maxParticles * 6)];
        this.particleVertices = new float[(this.maxParticles * 18)];
        this.particleTextureCoordinates = new float[(this.maxParticles * 12)];
        this.particleColors = new float[(this.maxParticles * 24)];
        for (i = 0; i < this.maxParticles; i++) {
            this.quads[i].f16567bl.texture.f17535x = 0.0f;
            this.quads[i].f16567bl.texture.f17536y = 0.0f;
            this.quads[i].f16568br.texture.f17535x = 1.0f;
            this.quads[i].f16568br.texture.f17536y = 0.0f;
            this.quads[i].f16569tl.texture.f17535x = 0.0f;
            this.quads[i].f16569tl.texture.f17536y = 1.0f;
            this.quads[i].f16570tr.texture.f17535x = 1.0f;
            this.quads[i].f16570tr.texture.f17536y = 1.0f;
        }
        for (i = 0; i < this.maxParticles; i++) {
            this.particleIndices[(i * 6) + 0] = (i * 4) + 0;
            this.particleIndices[(i * 6) + 1] = (i * 4) + 1;
            this.particleIndices[(i * 6) + 2] = (i * 4) + 2;
            this.particleIndices[(i * 6) + 5] = (i * 4) + 2;
            this.particleIndices[(i * 6) + 4] = (i * 4) + 3;
            this.particleIndices[(i * 6) + 3] = (i * 4) + 1;
        }
        this.active = true;
        this.particleCount = 0;
        this.elapsedTime = 0.0f;
        AppMethodBeat.m2505o(83613);
    }

    private void initParticle(Particle particle) {
        AppMethodBeat.m2504i(83614);
        particle.position.f17535x = this.sourcePosition.f17535x + (this.sourcePositionVariance.f17535x * ParticleUtil.randomMinus1to1());
        particle.position.f17536y = this.sourcePosition.f17536y + (this.sourcePositionVariance.f17536y * ParticleUtil.randomMinus1to1());
        particle.startPos.f17535x = this.sourcePosition.f17535x;
        particle.startPos.f17536y = this.sourcePosition.f17536y;
        float toRadians = (float) Math.toRadians((double) ((this.angle + (this.angleVariance * ParticleUtil.randomMinus1to1())) + this.rotateParticle));
        particle.direction = ParticleUtil.vectorMultiplyScalar(new Vector2((float) Math.cos((double) toRadians), (float) Math.sin((double) toRadians)), this.speed + (this.speedVariance * ParticleUtil.randomMinus1to1()));
        particle.timeToLive = Math.max(0.0f, this.particleLifespan + (this.particleLifespanVariance * ParticleUtil.randomMinus1to1()));
        toRadians = this.maxRadius + (this.maxRadiusVariance * ParticleUtil.randomMinus1to1());
        float randomMinus1to1 = this.minRadius + (this.minRadiusVariance * ParticleUtil.randomMinus1to1());
        particle.radius = toRadians;
        particle.radiusDelta = (randomMinus1to1 - toRadians) / particle.timeToLive;
        particle.angle = (float) Math.toRadians((double) ((this.angle + (this.angleVariance * ParticleUtil.randomMinus1to1())) + this.rotateParticle));
        particle.degreesPerSecond = (float) Math.toRadians((double) (this.rotatePerSecond + (this.rotatePerSecondVariance * ParticleUtil.randomMinus1to1())));
        particle.radialAcceleration = this.radialAcceleration + (this.radialAccelVariance * ParticleUtil.randomMinus1to1());
        particle.tangentialAcceleration = this.tangentialAcceleration + (this.tangentialAccelVariance * ParticleUtil.randomMinus1to1());
        toRadians = this.startParticleSize + (this.startParticleSizeVariance * ParticleUtil.randomMinus1to1());
        particle.particleSizeDelta = ((this.finishParticleSize + (this.finishParticleSizeVariance * ParticleUtil.randomMinus1to1())) - toRadians) / particle.timeToLive;
        particle.particleSize = Math.max(0.0f, toRadians);
        Vector4 vector4 = new Vector4(0.0f, 0.0f, 0.0f, 0.0f);
        vector4.f4890r = this.startColor.f4890r + (this.startColorVariance.f4890r * ParticleUtil.randomMinus1to1());
        vector4.f4889g = this.startColor.f4889g + (this.startColorVariance.f4889g * ParticleUtil.randomMinus1to1());
        vector4.f4888b = this.startColor.f4888b + (this.startColorVariance.f4888b * ParticleUtil.randomMinus1to1());
        vector4.f4887a = this.startColor.f4887a + (this.startColorVariance.f4887a * ParticleUtil.randomMinus1to1());
        Vector4 vector42 = new Vector4(0.0f, 0.0f, 0.0f, 0.0f);
        vector42.f4890r = this.finishColor.f4890r + (this.finishColorVariance.f4890r * ParticleUtil.randomMinus1to1());
        vector42.f4889g = this.finishColor.f4889g + (this.finishColorVariance.f4889g * ParticleUtil.randomMinus1to1());
        vector42.f4888b = this.finishColor.f4888b + (this.finishColorVariance.f4888b * ParticleUtil.randomMinus1to1());
        vector42.f4887a = this.finishColor.f4887a + (this.finishColorVariance.f4887a * ParticleUtil.randomMinus1to1());
        particle.color = vector4;
        particle.deltaColor.f4890r = (vector42.f4890r - vector4.f4890r) / particle.timeToLive;
        particle.deltaColor.f4889g = (vector42.f4889g - vector4.f4889g) / particle.timeToLive;
        particle.deltaColor.f4888b = (vector42.f4888b - vector4.f4888b) / particle.timeToLive;
        particle.deltaColor.f4887a = (vector42.f4887a - vector4.f4887a) / particle.timeToLive;
        toRadians = this.rotationStart + (this.rotationStartVariance * ParticleUtil.randomMinus1to1());
        randomMinus1to1 = this.rotationEnd + (this.rotationEndVariance * ParticleUtil.randomMinus1to1());
        particle.rotation = toRadians;
        particle.rotationDelta = (randomMinus1to1 - toRadians) / particle.timeToLive;
        AppMethodBeat.m2505o(83614);
    }

    public void updateWithDelta(float f, boolean z) {
        float f2;
        AppMethodBeat.m2504i(83615);
        if (z && this.active && this.emissionRate > 0.0f) {
            f2 = 1.0f / this.emissionRate;
            if (this.particleCount < this.maxParticles) {
                this.emitCounter += f;
            }
            if (this.particleCount == 0 && ((double) this.particleLifespanVariance) < 0.01d && this.emitCounter >= ((float) this.maxParticles) * f2) {
                this.emitCounter = (((float) this.maxParticles) * f2) * ParticleUtil.random0to1();
            }
            while (this.particleCount < this.maxParticles && this.emitCounter > f2) {
                addParticle();
                this.emitCounter -= f2;
            }
            this.elapsedTime += f;
            if (this.duration != -1.0f && this.duration < this.elapsedTime) {
                stopParticleEmitter();
            }
        }
        this.particleIndex = 0;
        LogUtils.m50202e(TAG, "updateWithDelta() - particleCount = " + this.particleCount);
        while (this.particleIndex < this.particleCount) {
            Particle particle = this.particles[this.particleIndex];
            particle.timeToLive -= f;
            int i = this.particleIndex * 18;
            if (particle.timeToLive > 0.0f) {
                float f3;
                Vector2 vector2;
                if (this.emitterType == kParticleTypes.kParticleTypeRadial.value) {
                    particle.angle += particle.degreesPerSecond * f;
                    particle.radius += particle.radiusDelta * f;
                    vector2 = new Vector2();
                    vector2.f17535x = (float) (((double) this.sourcePosition.f17535x) - (Math.cos((double) particle.angle) * ((double) particle.radius)));
                    vector2.f17536y = (float) (((double) this.sourcePosition.f17536y) - (Math.sin((double) particle.angle) * ((double) particle.radius)));
                    particle.position = vector2;
                } else {
                    vector2 = new Vector2(0.0f, 0.0f);
                    Vector2 vectorSubtract = ParticleUtil.vectorSubtract(particle.startPos, new Vector2(0.0f, 0.0f));
                    particle.position = ParticleUtil.vectorSubtract(particle.position, vectorSubtract);
                    if (!(particle.position.f17535x == 0.0f && particle.position.f17536y == 0.0f)) {
                        vector2 = ParticleUtil.vectorNormalize(particle.position);
                    }
                    Vector2 vectorMultiplyScalar = ParticleUtil.vectorMultiplyScalar(vector2, particle.radialAcceleration);
                    f3 = vector2.f17535x;
                    vector2.f17535x = -vector2.f17536y;
                    vector2.f17536y = f3;
                    particle.direction = ParticleUtil.vectorAdd(particle.direction, ParticleUtil.vectorMultiplyScalar(ParticleUtil.vectorAdd(ParticleUtil.vectorAdd(vectorMultiplyScalar, ParticleUtil.vectorMultiplyScalar(vector2, particle.tangentialAcceleration)), this.gravity), f));
                    particle.position = ParticleUtil.vectorAdd(particle.position, ParticleUtil.vectorMultiplyScalar(particle.direction, f));
                    particle.position = ParticleUtil.vectorAdd(particle.position, vectorSubtract);
                }
                if (this.audioColorDelta > 0.0f) {
                    particle.color.f4890r = this.startColor.f4890r + (particle.deltaColor.f4890r * this.audioColorDelta);
                    particle.color.f4889g = this.startColor.f4889g + (particle.deltaColor.f4889g * this.audioColorDelta);
                    particle.color.f4888b = this.startColor.f4888b + (particle.deltaColor.f4888b * this.audioColorDelta);
                    particle.color.f4887a = this.startColor.f4887a + (particle.deltaColor.f4887a * this.audioColorDelta);
                } else {
                    Vector4 vector4 = particle.color;
                    vector4.f4890r += particle.deltaColor.f4890r * f;
                    vector4 = particle.color;
                    vector4.f4889g += particle.deltaColor.f4889g * f;
                    vector4 = particle.color;
                    vector4.f4888b += particle.deltaColor.f4888b * f;
                    vector4 = particle.color;
                    vector4.f4887a += particle.deltaColor.f4887a * f;
                }
                particle.particleSize += particle.particleSizeDelta * f;
                particle.particleSize = Math.max(0.0f, particle.particleSize);
                particle.rotation += particle.rotationDelta * f;
                f2 = (particle.particleSize * 0.5f) * this.scaleParticle;
                if (particle.rotation != 0.0f) {
                    float f4 = -f2;
                    float f5 = -f2;
                    f3 = particle.position.f17535x;
                    float f6 = particle.position.f17536y;
                    float toRadians = (float) Math.toRadians((double) particle.rotation);
                    float cos = (float) Math.cos((double) toRadians);
                    toRadians = (float) Math.sin((double) toRadians);
                    float f7 = ((f4 * cos) - (f5 * toRadians)) + f3;
                    float f8 = ((f4 * toRadians) + (f5 * cos)) + f6;
                    float f9 = ((f2 * cos) - (f5 * toRadians)) + f3;
                    f5 = ((f5 * cos) + (f2 * toRadians)) + f6;
                    float f10 = ((f2 * cos) - (f2 * toRadians)) + f3;
                    float f11 = ((f2 * toRadians) + (f2 * cos)) + f6;
                    f3 += (f4 * cos) - (f2 * toRadians);
                    f2 = ((f2 * cos) + (f4 * toRadians)) + f6;
                    this.quads[this.particleIndex].f16567bl.vertex.f17535x = f7;
                    this.quads[this.particleIndex].f16567bl.vertex.f17536y = f8;
                    this.quads[this.particleIndex].f16567bl.color = particle.color;
                    this.quads[this.particleIndex].f16568br.vertex.f17535x = f9;
                    this.quads[this.particleIndex].f16568br.vertex.f17536y = f5;
                    this.quads[this.particleIndex].f16568br.color = particle.color;
                    this.quads[this.particleIndex].f16569tl.vertex.f17535x = f3;
                    this.quads[this.particleIndex].f16569tl.vertex.f17536y = f2;
                    this.quads[this.particleIndex].f16569tl.color = particle.color;
                    this.quads[this.particleIndex].f16570tr.vertex.f17535x = f10;
                    this.quads[this.particleIndex].f16570tr.vertex.f17536y = f11;
                    this.quads[this.particleIndex].f16570tr.color = particle.color;
                    this.particleVertices[i] = this.quads[this.particleIndex].f16567bl.vertex.f17535x;
                    this.particleVertices[i + 1] = this.quads[this.particleIndex].f16567bl.vertex.f17536y;
                    this.particleVertices[i + 2] = 0.0f;
                    this.particleVertices[i + 3] = this.quads[this.particleIndex].f16568br.vertex.f17535x;
                    this.particleVertices[i + 4] = this.quads[this.particleIndex].f16568br.vertex.f17536y;
                    this.particleVertices[i + 5] = 0.0f;
                    this.particleVertices[i + 6] = this.quads[this.particleIndex].f16569tl.vertex.f17535x;
                    this.particleVertices[i + 7] = this.quads[this.particleIndex].f16569tl.vertex.f17536y;
                    this.particleVertices[i + 8] = 0.0f;
                    this.particleVertices[i + 9] = this.quads[this.particleIndex].f16568br.vertex.f17535x;
                    this.particleVertices[i + 10] = this.quads[this.particleIndex].f16568br.vertex.f17536y;
                    this.particleVertices[i + 11] = 0.0f;
                    this.particleVertices[i + 12] = this.quads[this.particleIndex].f16569tl.vertex.f17535x;
                    this.particleVertices[i + 13] = this.quads[this.particleIndex].f16569tl.vertex.f17536y;
                    this.particleVertices[i + 14] = 0.0f;
                    this.particleVertices[i + 15] = this.quads[this.particleIndex].f16570tr.vertex.f17535x;
                    this.particleVertices[i + 16] = this.quads[this.particleIndex].f16570tr.vertex.f17536y;
                    this.particleVertices[i + 17] = 0.0f;
                } else {
                    this.quads[this.particleIndex].f16567bl.vertex.f17535x = particle.position.f17535x - f2;
                    this.quads[this.particleIndex].f16567bl.vertex.f17536y = particle.position.f17536y - f2;
                    this.quads[this.particleIndex].f16567bl.color = particle.color;
                    this.quads[this.particleIndex].f16568br.vertex.f17535x = particle.position.f17535x + f2;
                    this.quads[this.particleIndex].f16568br.vertex.f17536y = particle.position.f17536y - f2;
                    this.quads[this.particleIndex].f16568br.color = particle.color;
                    this.quads[this.particleIndex].f16569tl.vertex.f17535x = particle.position.f17535x - f2;
                    this.quads[this.particleIndex].f16569tl.vertex.f17536y = particle.position.f17536y + f2;
                    this.quads[this.particleIndex].f16569tl.color = particle.color;
                    this.quads[this.particleIndex].f16570tr.vertex.f17535x = particle.position.f17535x + f2;
                    this.quads[this.particleIndex].f16570tr.vertex.f17536y = f2 + particle.position.f17536y;
                    this.quads[this.particleIndex].f16570tr.color = particle.color;
                    this.particleVertices[i] = this.quads[this.particleIndex].f16567bl.vertex.f17535x;
                    this.particleVertices[i + 1] = this.quads[this.particleIndex].f16567bl.vertex.f17536y;
                    this.particleVertices[i + 2] = 0.0f;
                    this.particleVertices[i + 3] = this.quads[this.particleIndex].f16568br.vertex.f17535x;
                    this.particleVertices[i + 4] = this.quads[this.particleIndex].f16568br.vertex.f17536y;
                    this.particleVertices[i + 5] = 0.0f;
                    this.particleVertices[i + 6] = this.quads[this.particleIndex].f16569tl.vertex.f17535x;
                    this.particleVertices[i + 7] = this.quads[this.particleIndex].f16569tl.vertex.f17536y;
                    this.particleVertices[i + 8] = 0.0f;
                    this.particleVertices[i + 9] = this.quads[this.particleIndex].f16568br.vertex.f17535x;
                    this.particleVertices[i + 10] = this.quads[this.particleIndex].f16568br.vertex.f17536y;
                    this.particleVertices[i + 11] = 0.0f;
                    this.particleVertices[i + 12] = this.quads[this.particleIndex].f16569tl.vertex.f17535x;
                    this.particleVertices[i + 13] = this.quads[this.particleIndex].f16569tl.vertex.f17536y;
                    this.particleVertices[i + 14] = 0.0f;
                    this.particleVertices[i + 15] = this.quads[this.particleIndex].f16570tr.vertex.f17535x;
                    this.particleVertices[i + 16] = this.quads[this.particleIndex].f16570tr.vertex.f17536y;
                    this.particleVertices[i + 17] = 0.0f;
                }
                int i2 = this.particleIndex * 12;
                this.particleTextureCoordinates[i2] = 0.0f;
                this.particleTextureCoordinates[i2 + 1] = 0.0f;
                this.particleTextureCoordinates[i2 + 2] = 1.0f;
                this.particleTextureCoordinates[i2 + 3] = 0.0f;
                this.particleTextureCoordinates[i2 + 4] = 0.0f;
                this.particleTextureCoordinates[i2 + 5] = 1.0f;
                this.particleTextureCoordinates[i2 + 6] = this.particleTextureCoordinates[i2 + 2];
                this.particleTextureCoordinates[i2 + 7] = this.particleTextureCoordinates[i2 + 3];
                this.particleTextureCoordinates[i2 + 8] = this.particleTextureCoordinates[i2 + 4];
                this.particleTextureCoordinates[i2 + 9] = this.particleTextureCoordinates[i2 + 5];
                this.particleTextureCoordinates[i2 + 10] = 1.0f;
                this.particleTextureCoordinates[i2 + 11] = 1.0f;
                for (i2 = 0; i2 < 6; i2++) {
                    i = (this.particleIndex * 24) + (i2 * 4);
                    this.particleColors[i] = particle.color.f4890r;
                    this.particleColors[i + 1] = particle.color.f4889g;
                    this.particleColors[i + 2] = particle.color.f4888b;
                    this.particleColors[i + 3] = particle.color.f4887a;
                }
                this.particleIndex++;
            } else {
                if (this.particleIndex != this.particleCount - 1) {
                    this.particles[this.particleIndex].copy(this.particles[this.particleCount - 1]);
                }
                this.particleCount--;
            }
        }
        AppMethodBeat.m2505o(83615);
    }

    public void setSourcePosition(Vector2 vector2) {
        this.sourcePosition.f17535x = vector2.f17535x;
        this.sourcePosition.f17536y = vector2.f17536y;
    }

    public void setExtraScale(float f) {
        this.scaleParticle = f;
    }

    public void setExtraRotate(float f) {
        this.rotateParticle = f;
    }

    public int activeParticleCount() {
        return this.particleCount;
    }

    public static Bitmap base64ToBitmap(String str) {
        AppMethodBeat.m2504i(83616);
        try {
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            AppMethodBeat.m2505o(83616);
            return decodeByteArray;
        } catch (OutOfMemoryError e) {
            AppMethodBeat.m2505o(83616);
            return null;
        }
    }

    private void stopParticleEmitter() {
        this.active = false;
        this.elapsedTime = 0.0f;
        this.emitCounter = 0.0f;
    }

    public boolean totalFinished() {
        if (this.active || this.particleCount != 0) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.active = true;
        this.elapsedTime = 0.0f;
        for (int i = 0; i < this.particleCount; i++) {
            this.particles[i].timeToLive = 0.0f;
        }
        this.emitCounter = 0.0f;
        this.emissionRate = ((float) this.maxParticles) / this.particleLifespan;
    }

    public void clear() {
        AppMethodBeat.m2504i(83617);
        GLES20.glDeleteTextures(1, new int[]{this.texture}, 0);
        AppMethodBeat.m2505o(83617);
    }
}
