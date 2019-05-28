package com.tencent.oscarcamera.particlesystem;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.util.C16371i;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ParticleSystemEx {
    private static final String TAG = ParticleSystemEx.class.getSimpleName();
    private AdvanceRes[] mAdvanceRes;
    private List<ParticleTemplate> mClouds = new ArrayList();
    final Context mContext;
    private long mNativeCtx;
    private FloatBuffer mParticleCenterBuffer;
    private FloatBuffer mParticleColorBuffer;
    private FloatBuffer mParticleSizeBuffer;
    private FloatBuffer mParticleTexCoord;
    private float[] mPositionIndex;
    private Map<Sprite, ParticleTemplate> mSpriteMap = new HashMap();

    class TexCoord {
        float[] texCoord = new float[12];

        private TexCoord() {
            AppMethodBeat.m2504i(81541);
            AppMethodBeat.m2505o(81541);
        }
    }

    public static native void nativeAdvance(long j, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, FloatBuffer floatBuffer3, FloatBuffer floatBuffer4, AdvanceRes[] advanceResArr);

    public static native void nativeEmitAt(long j, double d, double d2, double d3);

    public static native long nativeInit();

    public static native void nativeRegisterTemplate(long j, Object[] objArr);

    public static native void nativeRelease(long j);

    static {
        AppMethodBeat.m2504i(81553);
        try {
            System.loadLibrary("ParticleSystem");
        } catch (UnsatisfiedLinkError e) {
            LogUtils.m50206e(e);
        } catch (RuntimeException e2) {
            LogUtils.m50206e(e2);
        } catch (Exception e3) {
            LogUtils.m50206e(e3);
        }
        AppMethodBeat.m2505o(81553);
    }

    public ParticleSystemEx(Context context) {
        AppMethodBeat.m2504i(81542);
        this.mContext = context;
        this.mNativeCtx = nativeInit();
        AppMethodBeat.m2505o(81542);
    }

    public void loadTestData() {
        AppMethodBeat.m2504i(81543);
        ArrayList arrayList = new ArrayList();
        arrayList.add("assets://flower1.json");
        loadParticleData(arrayList);
        AppMethodBeat.m2505o(81543);
    }

    public void loadParticleData(List<String> list) {
        AppMethodBeat.m2504i(81544);
        if (list == null) {
            AppMethodBeat.m2505o(81544);
            return;
        }
        try {
            for (String loadParticle : list) {
                loadParticle(loadParticle);
            }
        } catch (Exception e) {
        }
        loadFinish();
        AppMethodBeat.m2505o(81544);
    }

    private void loadParticle(String str) {
        AppMethodBeat.m2504i(81545);
        try {
            String stringBuilder;
            JSONObject jSONObject;
            if (str.startsWith("/")) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                StringBuilder stringBuilder2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder2.append(readLine);
                }
                stringBuilder = stringBuilder2.toString();
            } else {
                InputStream open = this.mContext.getAssets().open(str);
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                stringBuilder = new String(bArr);
            }
            try {
                jSONObject = new JSONObject(stringBuilder);
            } catch (JSONException e) {
                C16371i.m25188m(TAG, e.getMessage());
                jSONObject = null;
            }
            ParticleTemplate fromJson = ParticleTemplate.fromJson(this, jSONObject, str.substring(0, str.lastIndexOf(47)));
            if (fromJson != null) {
                this.mClouds.add(fromJson);
                this.mSpriteMap.put(fromJson.mSprite, fromJson);
            }
            AppMethodBeat.m2505o(81545);
        } catch (Exception e2) {
            AppMethodBeat.m2505o(81545);
        }
    }

    private void loadFinish() {
        AppMethodBeat.m2504i(81546);
        this.mAdvanceRes = new AdvanceRes[this.mClouds.size()];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.mClouds.size(); i3++) {
            ParticleTemplate particleTemplate = (ParticleTemplate) this.mClouds.get(i3);
            i2 += particleTemplate.mMaxCount;
            if (particleTemplate.mMaxCount > i) {
                i = particleTemplate.mMaxCount;
            }
            this.mAdvanceRes[i3] = new AdvanceRes();
        }
        nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
        createCache(i2, i);
        AppMethodBeat.m2505o(81546);
    }

    public List<FrameParticleData> advance() {
        AppMethodBeat.m2504i(81547);
        if (this.mClouds.isEmpty()) {
            AppMethodBeat.m2505o(81547);
            return null;
        }
        nativeAdvance(this.mNativeCtx, this.mParticleCenterBuffer, this.mParticleSizeBuffer, this.mParticleTexCoord, this.mParticleColorBuffer, this.mAdvanceRes);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mAdvanceRes.length) {
                FrameParticleData frameParticleData = new FrameParticleData();
                arrayList.add(frameParticleData);
                AdvanceRes advanceRes = this.mAdvanceRes[i2];
                frameParticleData.particleCount = advanceRes.particleCount;
                frameParticleData.positionIndex = Arrays.copyOf(this.mPositionIndex, advanceRes.particleCount * 6);
                frameParticleData.particleCenter = new float[advanceRes.particleCenterLen];
                this.mParticleCenterBuffer.position(advanceRes.particleCenterOffset);
                this.mParticleCenterBuffer.get(frameParticleData.particleCenter);
                frameParticleData.particleSize = new float[advanceRes.particleSizeLen];
                this.mParticleSizeBuffer.position(advanceRes.particleSizeOffset);
                this.mParticleSizeBuffer.get(frameParticleData.particleSize);
                frameParticleData.texCoords = new float[advanceRes.texCoordsLen];
                this.mParticleTexCoord.position(advanceRes.texCoordsOffset);
                this.mParticleTexCoord.get(frameParticleData.texCoords);
                frameParticleData.particleColor = new float[advanceRes.particleColorLen];
                this.mParticleColorBuffer.position(advanceRes.particleColorOffset);
                this.mParticleColorBuffer.get(frameParticleData.particleColor);
                frameParticleData.audioPath = ((ParticleTemplate) this.mClouds.get(i2)).mSprite.audioPath;
                frameParticleData.playAudio = advanceRes.playAudio;
                frameParticleData.blendMode = ((ParticleTemplate) this.mClouds.get(i2)).mSprite.blendMode;
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(81547);
                return arrayList;
            }
        }
    }

    private void createCache(int i, int i2) {
        AppMethodBeat.m2504i(81548);
        this.mPositionIndex = new float[(i2 * 6)];
        for (int i3 = 0; i3 < this.mPositionIndex.length; i3++) {
            this.mPositionIndex[i3] = ((float) (i3 % 6)) + 0.5f;
        }
        this.mParticleCenterBuffer = ByteBuffer.allocateDirect(((i * 6) * 3) * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mParticleSizeBuffer = ByteBuffer.allocateDirect(((i * 6) * 2) * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mParticleTexCoord = ByteBuffer.allocateDirect(((i * 6) * 2) * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mParticleColorBuffer = ByteBuffer.allocateDirect(((i * 6) * 4) * 32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        AppMethodBeat.m2505o(81548);
    }

    public List<Sprite> getSprites() {
        AppMethodBeat.m2504i(81549);
        ArrayList arrayList = new ArrayList();
        for (ParticleTemplate particleTemplate : this.mClouds) {
            arrayList.add(particleTemplate.mSprite);
        }
        AppMethodBeat.m2505o(81549);
        return arrayList;
    }

    public void release() {
        AppMethodBeat.m2504i(81550);
        if (this.mNativeCtx != -1) {
            nativeRelease(this.mNativeCtx);
            this.mNativeCtx = -1;
        }
        AppMethodBeat.m2505o(81550);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(81551);
        release();
        AppMethodBeat.m2505o(81551);
    }

    public void emitImmediately(float f, float f2, float f3) {
        AppMethodBeat.m2504i(81552);
        nativeEmitAt(this.mNativeCtx, (double) f, (double) f2, (double) f3);
        AppMethodBeat.m2505o(81552);
    }
}
