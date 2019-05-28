package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.util.i;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class ParticleSystem {
    private static final String TAG = ParticleSystem.class.getSimpleName();
    private long mAdvanceIndex = 0;
    private List<ParticleCloud> mClouds = new ArrayList();
    private final Context mContext;
    private ArrayList<Particle> mCopiedParticles = new ArrayList();
    double[] mParamsPool;
    final Particle mPool = new Particle();
    private Random mRandom = new Random();
    private Map<Sprite, ParticleCloud> mSpriteMap = new HashMap();

    public static native double[] nativeAdvance(long[] jArr, double[] dArr, int[] iArr, int i);

    public static native void nativeAdvanceEx(long[] jArr, double[] dArr, int[] iArr, int i, DoubleBuffer doubleBuffer);

    public static native long nativeCompile(String str);

    public static native void nativeReleaseExpression(long[] jArr);

    static {
        AppMethodBeat.i(81540);
        try {
            System.loadLibrary("ParticleSystem");
        } catch (UnsatisfiedLinkError e) {
            LogUtils.e(e);
        } catch (RuntimeException e2) {
            LogUtils.e(e2);
        } catch (Exception e3) {
            LogUtils.e(e3);
        }
        AppMethodBeat.o(81540);
    }

    public ParticleSystem(Context context) {
        AppMethodBeat.i(81525);
        this.mContext = context;
        AppMethodBeat.o(81525);
    }

    /* Access modifiers changed, original: 0000 */
    public Particle advanceObtainUnlocked() {
        AppMethodBeat.i(81526);
        Particle obtainUnlocked = obtainUnlocked();
        for (int i = 0; i < 11; i++) {
            this.mParamsPool[obtainUnlocked.param_offset + i] = (double) Math.abs(this.mRandom.nextInt());
        }
        AppMethodBeat.o(81526);
        return obtainUnlocked;
    }

    private Particle obtainUnlocked() {
        Particle particle;
        AppMethodBeat.i(81527);
        if (this.mPool.next == null) {
            int i = 100;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                particle = new Particle();
                particle.next = this.mPool.next;
                this.mPool.next = particle;
                particle = this.mPool;
                particle.total++;
                i = i2;
            }
        }
        particle = this.mPool.next;
        this.mPool.next = particle.next;
        particle.next = null;
        Particle particle2 = this.mPool;
        particle2.total--;
        AppMethodBeat.o(81527);
        return particle;
    }

    /* Access modifiers changed, original: 0000 */
    public void putUnlocked(Particle particle) {
        particle.next = this.mPool.next;
        this.mPool.next = particle;
        Particle particle2 = this.mPool;
        particle2.total++;
    }

    public void loadParticleData(List<String> list) {
        AppMethodBeat.i(81528);
        if (list == null) {
            AppMethodBeat.o(81528);
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (str.startsWith("/")) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine);
                    }
                    arrayList.add(stringBuilder.toString());
                } else {
                    InputStream open = this.mContext.getAssets().open(str);
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    arrayList.add(new String(bArr));
                }
            }
        } catch (Exception e) {
        }
        if (!arrayList.isEmpty()) {
            loadParticles(arrayList);
        }
        AppMethodBeat.o(81528);
    }

    public void loadParticles(List<String> list) {
        AppMethodBeat.i(81529);
        for (String loadParticle : list) {
            loadParticle(loadParticle);
        }
        loadFinish();
        AppMethodBeat.o(81529);
    }

    public void emitImmediately(double d, double d2, double d3) {
        AppMethodBeat.i(81530);
        for (ParticleCloud particleCloud : this.mClouds) {
            if (particleCloud.mEmitRate == 0) {
                if (((long) particleCloud.mParticles.total) >= particleCloud.mMaxCount) {
                    String.format("max: %d, now %d, can't emit any more", new Object[]{Long.valueOf(particleCloud.mMaxCount), Integer.valueOf(particleCloud.mParticles.total)});
                    AppMethodBeat.o(81530);
                    return;
                }
                particleCloud.emitImmediately(d, d2, d3);
            }
        }
        AppMethodBeat.o(81530);
    }

    private void loadParticle(String str) {
        JSONObject jSONObject;
        AppMethodBeat.i(81531);
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            i.m(TAG, e.getMessage());
            jSONObject = null;
        }
        ParticleCloud fromJson = ParticleCloud.fromJson(this, jSONObject);
        this.mClouds.add(fromJson);
        this.mSpriteMap.put(fromJson.mSprite, fromJson);
        AppMethodBeat.o(81531);
    }

    private void loadFinish() {
        AppMethodBeat.i(81532);
        int i = 0;
        Iterator it = this.mClouds.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = (int) (((Attribute) ((ParticleCloud) it.next()).mAttrs.get(AttributeConst.MAX_COUNT)).value() + ((double) i2));
            } else {
                createCache(i2);
                AppMethodBeat.o(81532);
                return;
            }
        }
    }

    private void createCache(int i) {
        AppMethodBeat.i(81533);
        this.mParamsPool = new double[(i * 11)];
        for (int i2 = 0; i2 < i; i2++) {
            Particle particle = new Particle();
            particle.param_offset = i2 * 11;
            particle.next = this.mPool.next;
            this.mPool.next = particle;
            particle = this.mPool;
            particle.total++;
        }
        for (ParticleCloud createCache : this.mClouds) {
            createCache.createCache();
        }
        AppMethodBeat.o(81533);
    }

    public List<Sprite> getSprites() {
        AppMethodBeat.i(81534);
        ArrayList arrayList = new ArrayList();
        for (ParticleCloud particleCloud : this.mClouds) {
            arrayList.add(particleCloud.mSprite);
        }
        AppMethodBeat.o(81534);
        return arrayList;
    }

    public ArrayList<Particle> advance() {
        AppMethodBeat.i(81535);
        ArrayList arrayList = new ArrayList();
        double currentTimeMillis = ((double) System.currentTimeMillis()) / 1000.0d;
        for (ParticleCloud particleCloud : this.mClouds) {
            Pair advanceExpression;
            synchronized (this.mPool) {
                try {
                    advanceExpression = particleCloud.getAdvanceExpression(currentTimeMillis);
                    nativeAdvanceEx(((ParticleExpressionBundle) advanceExpression.second).expressions, this.mParamsPool, ((ParticleExpressionBundle) advanceExpression.second).param_offsets, ((ParticleExpressionBundle) advanceExpression.second).param_line, particleCloud.mResultBuffer);
                    particleCloud.mResultBuffer.rewind();
                    particleCloud.mResultBuffer.get(particleCloud.mResultArray);
                    int length = particleCloud.mVarAttributes.length;
                    for (int i = 0; i < length; i++) {
                        Attribute attribute = particleCloud.mVarAttributes[i];
                        int i2 = ((Particle) advanceExpression.first).total;
                        int i3 = 0;
                        Particle particle = ((Particle) advanceExpression.first).next;
                        while (particle != null) {
                            particle.a[attribute.mVarIndex] = particleCloud.mResultArray[(i * i2) + i3];
                            particle = particle.next;
                            i3++;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(81535);
                    }
                }
            }
            arrayList.add(advanceExpression.first);
        }
        AppMethodBeat.o(81535);
        return arrayList;
    }

    public ArrayList<Particle> advanceAsync() {
        AppMethodBeat.i(81536);
        this.mCopiedParticles.clear();
        synchronized (this.mPool) {
            try {
                for (ParticleCloud particleCloud : this.mClouds) {
                    this.mCopiedParticles.add(particleCloud.mCopiedParticles);
                    Particle particle = particleCloud.mCopiedParticles;
                    Particle particle2 = particleCloud.mParticles;
                    particle.total = particle2.total;
                    Particle particle3 = particle;
                    while (particle2.next != null) {
                        particle3.next.copy(particle2.next);
                        particle3 = particle3.next;
                        particle2 = particle2.next;
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(81536);
            }
        }
        ArrayList<Particle> arrayList = this.mCopiedParticles;
        return arrayList;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(81537);
        super.finalize();
        for (ParticleCloud release : this.mClouds) {
            release.release();
        }
        AppMethodBeat.o(81537);
    }

    public static long compile(String str) {
        AppMethodBeat.i(81538);
        long nativeCompile = nativeCompile(str);
        AppMethodBeat.o(81538);
        return nativeCompile;
    }

    public static void releaseExpression(long[] jArr) {
        AppMethodBeat.i(81539);
        nativeReleaseExpression(jArr);
        AppMethodBeat.o(81539);
    }
}
