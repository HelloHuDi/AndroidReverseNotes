package com.tencent.ttpic.particle;

public class ParticleConfig {
    public ParticleEmitterConfigBean particleEmitterConfig;

    public static class ParticleEmitterConfigBean {
        public AbsolutePositionBean absolutePosition;
        public AngleBean angle;
        public AngleVarianceBean angleVariance;
        public BlendFuncDestinationBean blendFuncDestination;
        public BlendFuncSourceBean blendFuncSource;
        public DurationBean duration;
        public EmitterTypeBean emitterType;
        public FinishColorBean finishColor;
        public FinishColorVarianceBean finishColorVariance;
        public FinishParticleSizeBean finishParticleSize;
        public FinishParticleSizeVarianceBean finishParticleSizeVariance;
        public GravityBean gravity;
        public MaxParticlesBean maxParticles;
        public MaxRadiusBean maxRadius;
        public MaxRadiusVarianceBean maxRadiusVariance;
        public MinRadiusBean minRadius;
        public MinRadiusVarianceBean minRadiusVariance;
        public ParticleLifeSpanBean particleLifeSpan;
        public ParticleLifespanVarianceBean particleLifespanVariance;
        public RadialAccelVarianceBean radialAccelVariance;
        public RadialAccelerationBean radialAcceleration;
        public RotatePerSecondBean rotatePerSecond;
        public RotatePerSecondVarianceBean rotatePerSecondVariance;
        public RotationEndBean rotationEnd;
        public RotationEndVarianceBean rotationEndVariance;
        public RotationStartBean rotationStart;
        public RotationStartVarianceBean rotationStartVariance;
        public SourcePositionBean sourcePosition;
        public SourcePositionVarianceBean sourcePositionVariance;
        public SpeedBean speed;
        public SpeedVarianceBean speedVariance;
        public StartColorBean startColor;
        public StartColorVarianceBean startColorVariance;
        public StartParticleSizeBean startParticleSize;
        public StartParticleSizeVarianceBean startParticleSizeVariance;
        public TangentialAccelVarianceBean tangentialAccelVariance;
        public TangentialAccelerationBean tangentialAcceleration;
        public TextureBean texture;
        public YCoordFlippedBean yCoordFlipped;

        public static class AngleVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class GravityBean {
            public float x;
            public float y;

            public float getX() {
                return this.x;
            }

            public void setX(float f) {
                this.x = f;
            }

            public float getY() {
                return this.y;
            }

            public void setY(float f) {
                this.y = f;
            }
        }

        public static class StartColorVarianceBean {
            public float alpha;
            public float blue;
            public float green;
            public float red;

            public float getAlpha() {
                return this.alpha;
            }

            public void setAlpha(float f) {
                this.alpha = f;
            }

            public float getBlue() {
                return this.blue;
            }

            public void setBlue(float f) {
                this.blue = f;
            }

            public float getGreen() {
                return this.green;
            }

            public void setGreen(float f) {
                this.green = f;
            }

            public float getRed() {
                return this.red;
            }

            public void setRed(float f) {
                this.red = f;
            }
        }

        public static class AngleBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class BlendFuncSourceBean {
            public int value;

            public int getValue() {
                return this.value;
            }

            public void setValue(int i) {
                this.value = i;
            }
        }

        public static class MaxRadiusVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class RotationEndBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class RotationStartBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class AbsolutePositionBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class DurationBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class FinishColorBean {
            public float alpha;
            public float blue;
            public float green;
            public float red;

            public float getAlpha() {
                return this.alpha;
            }

            public void setAlpha(float f) {
                this.alpha = f;
            }

            public float getBlue() {
                return this.blue;
            }

            public void setBlue(float f) {
                this.blue = f;
            }

            public float getGreen() {
                return this.green;
            }

            public void setGreen(float f) {
                this.green = f;
            }

            public float getRed() {
                return this.red;
            }

            public void setRed(float f) {
                this.red = f;
            }
        }

        public static class FinishColorVarianceBean {
            public float alpha;
            public float blue;
            public float green;
            public float red;

            public float getAlpha() {
                return this.alpha;
            }

            public void setAlpha(float f) {
                this.alpha = f;
            }

            public float getBlue() {
                return this.blue;
            }

            public void setBlue(float f) {
                this.blue = f;
            }

            public float getGreen() {
                return this.green;
            }

            public void setGreen(float f) {
                this.green = f;
            }

            public float getRed() {
                return this.red;
            }

            public void setRed(float f) {
                this.red = f;
            }
        }

        public static class MinRadiusBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class RotatePerSecondVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class StartParticleSizeBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class TextureBean {
            public String data;
            public String name;

            public String getName() {
                return this.name;
            }

            public void setName(String str) {
                this.name = str;
            }

            public String getData() {
                return this.data;
            }

            public void setData(String str) {
                this.data = str;
            }
        }

        public static class MaxRadiusBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class MinRadiusVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class SourcePositionBean {
            public float x;
            public float y;

            public float getX() {
                return this.x;
            }

            public void setX(float f) {
                this.x = f;
            }

            public float getY() {
                return this.y;
            }

            public void setY(float f) {
                this.y = f;
            }
        }

        public static class SourcePositionVarianceBean {
            public float x;
            public float y;

            public float getX() {
                return this.x;
            }

            public void setX(float f) {
                this.x = f;
            }

            public float getY() {
                return this.y;
            }

            public void setY(float f) {
                this.y = f;
            }
        }

        public static class StartParticleSizeVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class TangentialAccelerationBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class ParticleLifespanVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class RadialAccelVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class SpeedVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class YCoordFlippedBean {
            public int value;

            public int getValue() {
                return this.value;
            }

            public void setValue(int i) {
                this.value = i;
            }
        }

        public static class BlendFuncDestinationBean {
            public int value;

            public int getValue() {
                return this.value;
            }

            public void setValue(int i) {
                this.value = i;
            }
        }

        public static class EmitterTypeBean {
            public int value;

            public int getValue() {
                return this.value;
            }

            public void setValue(int i) {
                this.value = i;
            }
        }

        public static class FinishParticleSizeBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class ParticleLifeSpanBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class RadialAccelerationBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class RotationStartVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class StartColorBean {
            public float alpha;
            public float blue;
            public float green;
            public float red;

            public float getAlpha() {
                return this.alpha;
            }

            public void setAlpha(float f) {
                this.alpha = f;
            }

            public float getBlue() {
                return this.blue;
            }

            public void setBlue(float f) {
                this.blue = f;
            }

            public float getGreen() {
                return this.green;
            }

            public void setGreen(float f) {
                this.green = f;
            }

            public float getRed() {
                return this.red;
            }

            public void setRed(float f) {
                this.red = f;
            }
        }

        public static class FinishParticleSizeVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class MaxParticlesBean {
            public int value;

            public int getValue() {
                return this.value;
            }

            public void setValue(int i) {
                this.value = i;
            }
        }

        public static class RotatePerSecondBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class RotationEndVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class SpeedBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public static class TangentialAccelVarianceBean {
            public float value;

            public float getValue() {
                return this.value;
            }

            public void setValue(float f) {
                this.value = f;
            }
        }

        public StartColorBean getStartColor() {
            return this.startColor;
        }

        public void setStartColor(StartColorBean startColorBean) {
            this.startColor = startColorBean;
        }

        public SourcePositionBean getSourcePosition() {
            return this.sourcePosition;
        }

        public void setSourcePosition(SourcePositionBean sourcePositionBean) {
            this.sourcePosition = sourcePositionBean;
        }

        public ParticleLifeSpanBean getParticleLifeSpan() {
            return this.particleLifeSpan;
        }

        public void setParticleLifeSpan(ParticleLifeSpanBean particleLifeSpanBean) {
            this.particleLifeSpan = particleLifeSpanBean;
        }

        public MaxRadiusBean getMaxRadius() {
            return this.maxRadius;
        }

        public void setMaxRadius(MaxRadiusBean maxRadiusBean) {
            this.maxRadius = maxRadiusBean;
        }

        public SpeedVarianceBean getSpeedVariance() {
            return this.speedVariance;
        }

        public void setSpeedVariance(SpeedVarianceBean speedVarianceBean) {
            this.speedVariance = speedVarianceBean;
        }

        public RotatePerSecondBean getRotatePerSecond() {
            return this.rotatePerSecond;
        }

        public void setRotatePerSecond(RotatePerSecondBean rotatePerSecondBean) {
            this.rotatePerSecond = rotatePerSecondBean;
        }

        public RotationStartBean getRotationStart() {
            return this.rotationStart;
        }

        public void setRotationStart(RotationStartBean rotationStartBean) {
            this.rotationStart = rotationStartBean;
        }

        public DurationBean getDuration() {
            return this.duration;
        }

        public void setDuration(DurationBean durationBean) {
            this.duration = durationBean;
        }

        public RotatePerSecondVarianceBean getRotatePerSecondVariance() {
            return this.rotatePerSecondVariance;
        }

        public void setRotatePerSecondVariance(RotatePerSecondVarianceBean rotatePerSecondVarianceBean) {
            this.rotatePerSecondVariance = rotatePerSecondVarianceBean;
        }

        public TangentialAccelVarianceBean getTangentialAccelVariance() {
            return this.tangentialAccelVariance;
        }

        public void setTangentialAccelVariance(TangentialAccelVarianceBean tangentialAccelVarianceBean) {
            this.tangentialAccelVariance = tangentialAccelVarianceBean;
        }

        public MaxRadiusVarianceBean getMaxRadiusVariance() {
            return this.maxRadiusVariance;
        }

        public void setMaxRadiusVariance(MaxRadiusVarianceBean maxRadiusVarianceBean) {
            this.maxRadiusVariance = maxRadiusVarianceBean;
        }

        public RadialAccelVarianceBean getRadialAccelVariance() {
            return this.radialAccelVariance;
        }

        public void setRadialAccelVariance(RadialAccelVarianceBean radialAccelVarianceBean) {
            this.radialAccelVariance = radialAccelVarianceBean;
        }

        public FinishParticleSizeBean getFinishParticleSize() {
            return this.finishParticleSize;
        }

        public void setFinishParticleSize(FinishParticleSizeBean finishParticleSizeBean) {
            this.finishParticleSize = finishParticleSizeBean;
        }

        public BlendFuncSourceBean getBlendFuncSource() {
            return this.blendFuncSource;
        }

        public void setBlendFuncSource(BlendFuncSourceBean blendFuncSourceBean) {
            this.blendFuncSource = blendFuncSourceBean;
        }

        public YCoordFlippedBean getYCoordFlipped() {
            return this.yCoordFlipped;
        }

        public void setYCoordFlipped(YCoordFlippedBean yCoordFlippedBean) {
            this.yCoordFlipped = yCoordFlippedBean;
        }

        public EmitterTypeBean getEmitterType() {
            return this.emitterType;
        }

        public void setEmitterType(EmitterTypeBean emitterTypeBean) {
            this.emitterType = emitterTypeBean;
        }

        public TextureBean getTexture() {
            return this.texture;
        }

        public void setTexture(TextureBean textureBean) {
            this.texture = textureBean;
        }

        public MinRadiusVarianceBean getMinRadiusVariance() {
            return this.minRadiusVariance;
        }

        public void setMinRadiusVariance(MinRadiusVarianceBean minRadiusVarianceBean) {
            this.minRadiusVariance = minRadiusVarianceBean;
        }

        public FinishColorVarianceBean getFinishColorVariance() {
            return this.finishColorVariance;
        }

        public void setFinishColorVariance(FinishColorVarianceBean finishColorVarianceBean) {
            this.finishColorVariance = finishColorVarianceBean;
        }

        public StartParticleSizeVarianceBean getStartParticleSizeVariance() {
            return this.startParticleSizeVariance;
        }

        public void setStartParticleSizeVariance(StartParticleSizeVarianceBean startParticleSizeVarianceBean) {
            this.startParticleSizeVariance = startParticleSizeVarianceBean;
        }

        public RotationEndVarianceBean getRotationEndVariance() {
            return this.rotationEndVariance;
        }

        public void setRotationEndVariance(RotationEndVarianceBean rotationEndVarianceBean) {
            this.rotationEndVariance = rotationEndVarianceBean;
        }

        public BlendFuncDestinationBean getBlendFuncDestination() {
            return this.blendFuncDestination;
        }

        public void setBlendFuncDestination(BlendFuncDestinationBean blendFuncDestinationBean) {
            this.blendFuncDestination = blendFuncDestinationBean;
        }

        public AngleBean getAngle() {
            return this.angle;
        }

        public void setAngle(AngleBean angleBean) {
            this.angle = angleBean;
        }

        public RotationStartVarianceBean getRotationStartVariance() {
            return this.rotationStartVariance;
        }

        public void setRotationStartVariance(RotationStartVarianceBean rotationStartVarianceBean) {
            this.rotationStartVariance = rotationStartVarianceBean;
        }

        public FinishColorBean getFinishColor() {
            return this.finishColor;
        }

        public void setFinishColor(FinishColorBean finishColorBean) {
            this.finishColor = finishColorBean;
        }

        public AbsolutePositionBean getAbsolutePosition() {
            return this.absolutePosition;
        }

        public void setAbsolutePosition(AbsolutePositionBean absolutePositionBean) {
            this.absolutePosition = absolutePositionBean;
        }

        public AngleVarianceBean getAngleVariance() {
            return this.angleVariance;
        }

        public void setAngleVariance(AngleVarianceBean angleVarianceBean) {
            this.angleVariance = angleVarianceBean;
        }

        public SourcePositionVarianceBean getSourcePositionVariance() {
            return this.sourcePositionVariance;
        }

        public void setSourcePositionVariance(SourcePositionVarianceBean sourcePositionVarianceBean) {
            this.sourcePositionVariance = sourcePositionVarianceBean;
        }

        public TangentialAccelerationBean getTangentialAcceleration() {
            return this.tangentialAcceleration;
        }

        public void setTangentialAcceleration(TangentialAccelerationBean tangentialAccelerationBean) {
            this.tangentialAcceleration = tangentialAccelerationBean;
        }

        public RotationEndBean getRotationEnd() {
            return this.rotationEnd;
        }

        public void setRotationEnd(RotationEndBean rotationEndBean) {
            this.rotationEnd = rotationEndBean;
        }

        public SpeedBean getSpeed() {
            return this.speed;
        }

        public void setSpeed(SpeedBean speedBean) {
            this.speed = speedBean;
        }

        public MaxParticlesBean getMaxParticles() {
            return this.maxParticles;
        }

        public void setMaxParticles(MaxParticlesBean maxParticlesBean) {
            this.maxParticles = maxParticlesBean;
        }

        public MinRadiusBean getMinRadius() {
            return this.minRadius;
        }

        public void setMinRadius(MinRadiusBean minRadiusBean) {
            this.minRadius = minRadiusBean;
        }

        public ParticleLifespanVarianceBean getParticleLifespanVariance() {
            return this.particleLifespanVariance;
        }

        public void setParticleLifespanVariance(ParticleLifespanVarianceBean particleLifespanVarianceBean) {
            this.particleLifespanVariance = particleLifespanVarianceBean;
        }

        public FinishParticleSizeVarianceBean getFinishParticleSizeVariance() {
            return this.finishParticleSizeVariance;
        }

        public void setFinishParticleSizeVariance(FinishParticleSizeVarianceBean finishParticleSizeVarianceBean) {
            this.finishParticleSizeVariance = finishParticleSizeVarianceBean;
        }

        public GravityBean getGravity() {
            return this.gravity;
        }

        public void setGravity(GravityBean gravityBean) {
            this.gravity = gravityBean;
        }

        public RadialAccelerationBean getRadialAcceleration() {
            return this.radialAcceleration;
        }

        public void setRadialAcceleration(RadialAccelerationBean radialAccelerationBean) {
            this.radialAcceleration = radialAccelerationBean;
        }

        public StartParticleSizeBean getStartParticleSize() {
            return this.startParticleSize;
        }

        public void setStartParticleSize(StartParticleSizeBean startParticleSizeBean) {
            this.startParticleSize = startParticleSizeBean;
        }

        public StartColorVarianceBean getStartColorVariance() {
            return this.startColorVariance;
        }

        public void setStartColorVariance(StartColorVarianceBean startColorVarianceBean) {
            this.startColorVariance = startColorVarianceBean;
        }
    }

    public ParticleEmitterConfigBean getParticleEmitterConfig() {
        return this.particleEmitterConfig;
    }

    public void setParticleEmitterConfig(ParticleEmitterConfigBean particleEmitterConfigBean) {
        this.particleEmitterConfig = particleEmitterConfigBean;
    }
}
