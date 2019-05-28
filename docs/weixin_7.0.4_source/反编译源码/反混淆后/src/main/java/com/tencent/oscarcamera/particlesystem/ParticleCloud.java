package com.tencent.oscarcamera.particlesystem;

import android.text.TextUtils;
import android.util.Pair;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class ParticleCloud {
    private static final String TAG = ParticleCloud.class.getSimpleName();
    private static final HashMap<String, Object> s_params = new HashMap();
    private long[] mAttrExpressions;
    private double[] mAttrValue;
    public HashMap<String, Attribute> mAttrs = new HashMap();
    Particle mCopiedParticles = new Particle();
    long mEmitRate;
    double mLastQuotaTime;
    long mMaxCount;
    public String mName;
    Particle mParticles = new Particle();
    long mQuota;
    double[] mResultArray;
    DoubleBuffer mResultBuffer;
    public Sprite mSprite;
    private ParticleSystem mSystem;
    Attribute[] mVarAttributes;
    private long[] mVarExpressions;
    private int[] param_offsets;

    static {
        AppMethodBeat.m2504i(81524);
        AppMethodBeat.m2505o(81524);
    }

    public ParticleCloud(ParticleSystem particleSystem) {
        AppMethodBeat.m2504i(81513);
        this.mSystem = particleSystem;
        this.mSprite = new Sprite();
        AppMethodBeat.m2505o(81513);
    }

    public Pair<Particle, ParticleExpressionBundle> getAdvanceExpression(double d) {
        AppMethodBeat.m2504i(81514);
        ParticleExpressionBundle particleExpressionBundle = new ParticleExpressionBundle();
        Particle particle = this.mParticles.next;
        Particle particle2 = this.mParticles;
        while (particle != null) {
            if (particle.f15108a[2] <= 0.0d || particle.f15108a[2] + particle.birth > d) {
                advanceParticle(particle, d);
                this.mSystem.mParamsPool[particle.param_offset + 10] = d - particle.birth;
                particle2 = particle;
                particle = particle.next;
            } else {
                particle2.next = particle.next;
                Particle particle3 = particle.next;
                this.mSystem.putUnlocked(particle);
                particle = this.mParticles;
                particle.total--;
                particle = particle3;
            }
        }
        computeQuota(d);
        if (((long) this.mParticles.total) < this.mMaxCount && this.mQuota > 0) {
            long min = Math.min(this.mMaxCount - ((long) this.mParticles.total), this.mQuota);
            this.mQuota -= min;
            while (true) {
                long j = min - 1;
                if (min <= 0) {
                    break;
                }
                particle2 = this.mSystem.advanceObtainUnlocked();
                initParticle(particle2, d);
                this.mSystem.mParamsPool[particle2.param_offset + 10] = d - particle2.birth;
                particle2.next = this.mParticles.next;
                this.mParticles.next = particle2;
                particle2 = this.mParticles;
                particle2.total++;
                min = j;
            }
        }
        particle = this.mParticles.next;
        int i = this.mParticles.total;
        for (int i2 = 0; i2 < i; i2++) {
            this.param_offsets[i2] = particle.param_offset;
            particle = particle.next;
        }
        particleExpressionBundle.expressions = this.mVarExpressions;
        particleExpressionBundle.param_line = this.mParticles.total;
        particleExpressionBundle.param_offsets = this.param_offsets;
        Pair pair = new Pair(this.mParticles, particleExpressionBundle);
        AppMethodBeat.m2505o(81514);
        return pair;
    }

    private void computeQuota(double d) {
        if (this.mLastQuotaTime == 0.0d) {
            this.mLastQuotaTime = d;
        } else {
            int i = (int) (((double) this.mEmitRate) * (d - this.mLastQuotaTime));
            if (i > 0) {
                this.mQuota += (long) i;
                this.mLastQuotaTime = (((double) i) / ((double) this.mEmitRate)) + this.mLastQuotaTime;
            }
        }
        if (this.mQuota > this.mMaxCount - ((long) this.mParticles.total)) {
            this.mQuota = this.mMaxCount - ((long) this.mParticles.total);
        }
    }

    private void advanceParticle(Particle particle, double d) {
        if (this.mSprite.animated == 1) {
            long j = (long) ((int) ((d - particle.birth) / this.mSprite.frameDuration));
            int i = (int) (j % ((long) this.mSprite.frameCount));
            if (this.mSprite.looped != 1) {
                if (this.mSprite.looped == 2) {
                    if (((j / ((long) this.mSprite.frameCount)) & 1) == 1) {
                        i = (this.mSprite.frameCount - 1) - i;
                    }
                } else if (j >= ((long) this.mSprite.frameCount)) {
                    i = this.mSprite.frameCount - 1;
                }
            }
            particle.currFrame = i;
        }
    }

    private void initParticle(Particle particle, double d) {
        AppMethodBeat.m2504i(81515);
        particle.birth = d;
        particle.tex = this.mSprite.path;
        particle.frameCount = this.mSprite.frameCount;
        particle.musicPlayed = false;
        particle.f15108a[2] = (double) ((long) this.mAttrValue[2]);
        particle.f15108a[0] = this.mAttrValue[0];
        particle.f15108a[1] = this.mAttrValue[1];
        particle.f15108a[7] = this.mAttrValue[7];
        particle.f15108a[8] = this.mAttrValue[8];
        particle.f15108a[9] = this.mAttrValue[9];
        particle.f15108a[3] = this.mAttrValue[3];
        particle.f15108a[4] = this.mAttrValue[4];
        particle.f15108a[5] = this.mAttrValue[5];
        particle.f15108a[6] = this.mAttrValue[6];
        advanceParticle(particle, d);
        AppMethodBeat.m2505o(81515);
    }

    private void optimized() {
        int i = 0;
        AppMethodBeat.m2504i(81516);
        this.mMaxCount = (long) ((Attribute) this.mAttrs.get(AttributeConst.MAX_COUNT)).value();
        this.mEmitRate = (long) ((Attribute) this.mAttrs.get(AttributeConst.EMISSION_RATE)).value();
        this.mAttrExpressions = new long[10];
        this.mAttrExpressions[2] = ((Attribute) this.mAttrs.get(AttributeConst.LIFE)).expression();
        this.mAttrExpressions[3] = ((Attribute) this.mAttrs.get(AttributeConst.f17265R)).expression();
        this.mAttrExpressions[4] = ((Attribute) this.mAttrs.get(AttributeConst.f17264G)).expression();
        this.mAttrExpressions[5] = ((Attribute) this.mAttrs.get(AttributeConst.f17263B)).expression();
        this.mAttrExpressions[6] = ((Attribute) this.mAttrs.get(AttributeConst.f17262A)).expression();
        this.mAttrExpressions[7] = ((Attribute) this.mAttrs.get(AttributeConst.f17266X)).expression();
        this.mAttrExpressions[8] = ((Attribute) this.mAttrs.get(AttributeConst.f17267Y)).expression();
        this.mAttrExpressions[9] = ((Attribute) this.mAttrs.get(AttributeConst.f17268Z)).expression();
        this.mAttrExpressions[0] = ((Attribute) this.mAttrs.get("width")).expression();
        this.mAttrExpressions[1] = ((Attribute) this.mAttrs.get("height")).expression();
        this.mAttrValue = new double[10];
        this.mAttrValue[2] = ((Attribute) this.mAttrs.get(AttributeConst.LIFE)).value();
        this.mAttrValue[3] = ((Attribute) this.mAttrs.get(AttributeConst.f17265R)).value();
        this.mAttrValue[4] = ((Attribute) this.mAttrs.get(AttributeConst.f17264G)).value();
        this.mAttrValue[5] = ((Attribute) this.mAttrs.get(AttributeConst.f17263B)).value();
        this.mAttrValue[6] = ((Attribute) this.mAttrs.get(AttributeConst.f17262A)).value();
        this.mAttrValue[7] = ((Attribute) this.mAttrs.get(AttributeConst.f17266X)).value();
        this.mAttrValue[8] = ((Attribute) this.mAttrs.get(AttributeConst.f17267Y)).value();
        this.mAttrValue[9] = ((Attribute) this.mAttrs.get(AttributeConst.f17268Z)).value();
        this.mAttrValue[0] = ((Attribute) this.mAttrs.get("width")).value();
        this.mAttrValue[1] = ((Attribute) this.mAttrs.get("height")).value();
        ArrayList arrayList = new ArrayList();
        for (String str : this.mAttrs.keySet()) {
            Attribute attribute = (Attribute) this.mAttrs.get(str);
            if (attribute.expression() != -1) {
                arrayList.add(attribute);
            }
        }
        this.mVarExpressions = new long[arrayList.size()];
        this.mVarAttributes = new Attribute[arrayList.size()];
        int size = arrayList.size();
        while (i < size) {
            this.mVarExpressions[i] = ((Attribute) arrayList.get(i)).expression();
            this.mVarAttributes[i] = (Attribute) arrayList.get(i);
            i++;
        }
        this.param_offsets = new int[(((int) ((Attribute) this.mAttrs.get(AttributeConst.MAX_COUNT)).value()) * 11)];
        AppMethodBeat.m2505o(81516);
    }

    static ParticleCloud fromJson(ParticleSystem particleSystem, JSONObject jSONObject) {
        ParticleCloud particleCloud;
        AppMethodBeat.m2504i(81517);
        ParticleCloud particleCloud2 = new ParticleCloud(particleSystem);
        try {
            particleCloud2.mName = (String) jSONObject.get("name");
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object obj = jSONObject.get(str);
                if ((obj instanceof Number) || (obj instanceof String)) {
                    Attribute createAttr = createAttr(str, obj);
                    particleCloud2.mAttrs.put(createAttr.mName, createAttr);
                } else if ((obj instanceof JSONObject) && TextUtils.equals(str, "sprite")) {
                    particleCloud2.initSprite((JSONObject) obj);
                } else if ((obj instanceof JSONObject) && TextUtils.equals(str, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                    particleCloud2.mSprite.audioPath = ((JSONObject) obj).getString("path");
                }
            }
            particleCloud2.optimized();
            particleCloud = particleCloud2;
        } catch (Exception e) {
            particleCloud = null;
        }
        AppMethodBeat.m2505o(81517);
        return particleCloud;
    }

    private static Attribute createAttr(String str, Object obj) {
        AppMethodBeat.m2504i(81518);
        Attribute attribute = new Attribute();
        attribute.mName = str;
        attribute.mValue = new Value(obj);
        attribute.mVarIndex = AttributeConst.ATTR_INDEX_MAP.containsKey(str) ? ((Integer) AttributeConst.ATTR_INDEX_MAP.get(str)).intValue() : -1;
        AppMethodBeat.m2505o(81518);
        return attribute;
    }

    private void initSprite(JSONObject jSONObject) {
        AppMethodBeat.m2504i(81519);
        this.mSprite.path = jSONObject.optString("path");
        this.mSprite.frameCount = (int) doubleValue(jSONObject, "frameCount");
        this.mSprite.width = (int) doubleValue(jSONObject, "width");
        this.mSprite.height = (int) doubleValue(jSONObject, "height");
        this.mSprite.blendMode = (int) doubleValue(jSONObject, "blendMode");
        this.mSprite.animated = (int) doubleValue(jSONObject, "animated");
        this.mSprite.looped = (int) doubleValue(jSONObject, "looped");
        this.mSprite.frameDuration = doubleValue(jSONObject, "frameDuration");
        AppMethodBeat.m2505o(81519);
    }

    private double doubleValue(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(81520);
        Object opt = jSONObject.opt(str);
        if (opt == null || !(opt instanceof Number)) {
            AppMethodBeat.m2505o(81520);
            return 0.0d;
        }
        double doubleValue = ((Number) opt).doubleValue();
        AppMethodBeat.m2505o(81520);
        return doubleValue;
    }

    public void createCache() {
        AppMethodBeat.m2504i(81521);
        this.mResultBuffer = ByteBuffer.allocateDirect((int) ((this.mMaxCount * ((long) this.mVarExpressions.length)) * 64)).order(ByteOrder.nativeOrder()).asDoubleBuffer();
        this.mResultArray = new double[((int) (this.mMaxCount * ((long) this.mVarExpressions.length)))];
        this.mCopiedParticles = new Particle();
        Particle particle = this.mCopiedParticles;
        for (int i = 0; ((long) i) < this.mMaxCount; i++) {
            particle.next = new Particle();
            particle = particle.next;
        }
        AppMethodBeat.m2505o(81521);
    }

    public void release() {
        AppMethodBeat.m2504i(81522);
        ParticleSystem.releaseExpression(this.mVarExpressions);
        AppMethodBeat.m2505o(81522);
    }

    public void emitImmediately(double d, double d2, double d3) {
        AppMethodBeat.m2504i(81523);
        double currentTimeMillis = ((double) System.currentTimeMillis()) / 1000.0d;
        Particle advanceObtainUnlocked = this.mSystem.advanceObtainUnlocked();
        initParticle(advanceObtainUnlocked, currentTimeMillis);
        advanceObtainUnlocked.touchedPosition[0] = d;
        advanceObtainUnlocked.touchedPosition[1] = d2;
        advanceObtainUnlocked.touchedPosition[2] = d3;
        advanceObtainUnlocked.next = this.mParticles.next;
        this.mParticles.next = advanceObtainUnlocked;
        Particle particle = this.mParticles;
        particle.total++;
        AppMethodBeat.m2505o(81523);
    }
}
