package com.tencent.oscarcamera.particlesystem;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.json.JSONObject;

public class ParticleTemplate {
    public static final String ATTR_COLOR_A = String.format("%s", new Object[]{AttributeConst.f17262A});
    public static final String ATTR_COLOR_B = String.format("%s", new Object[]{AttributeConst.f17263B});
    public static final String ATTR_COLOR_G = String.format("%s", new Object[]{AttributeConst.f17264G});
    public static final String ATTR_COLOR_R = String.format("%s", new Object[]{AttributeConst.f17265R});
    public static final String ATTR_EMIT_RATE = String.format("%s", new Object[]{AttributeConst.EMISSION_RATE});
    public static final String ATTR_HEIGHT = String.format("%s", new Object[]{"height"});
    public static final String ATTR_LIFE = String.format("%s", new Object[]{AttributeConst.LIFE});
    public static final String ATTR_MAX_COUNT = String.format("%s", new Object[]{AttributeConst.MAX_COUNT});
    public static final String ATTR_POS_X = String.format("%s", new Object[]{AttributeConst.f17266X});
    public static final String ATTR_POS_Y = String.format("%s", new Object[]{AttributeConst.f17267Y});
    public static final String ATTR_POS_Z = String.format("%s", new Object[]{AttributeConst.f17268Z});
    public static final String ATTR_WIDTH = String.format("%s", new Object[]{"width"});
    private static final String TAG = ParticleTemplate.class.getSimpleName();
    String mColorA = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mColorB = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mColorG = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mColorR = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    double mEmitRate;
    String mHeight = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mLife = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    int mMaxCount;
    String mPosX = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mPosY = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mPosZ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public Sprite mSprite;
    private ParticleSystemEx mSystem;
    String mWidth = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    static {
        AppMethodBeat.m2504i(81560);
        AppMethodBeat.m2505o(81560);
    }

    public ParticleTemplate(ParticleSystemEx particleSystemEx) {
        AppMethodBeat.m2504i(81554);
        this.mSystem = particleSystemEx;
        this.mSprite = new Sprite();
        AppMethodBeat.m2505o(81554);
    }

    static ParticleTemplate fromJson(ParticleSystemEx particleSystemEx, JSONObject jSONObject, String str) {
        ParticleTemplate particleTemplate;
        AppMethodBeat.m2504i(81555);
        ParticleTemplate particleTemplate2 = new ParticleTemplate(particleSystemEx);
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                Object obj = jSONObject.get(str2);
                if ((obj instanceof Number) || (obj instanceof String)) {
                    initAttr(particleTemplate2, str2, obj);
                } else if ((obj instanceof JSONObject) && TextUtils.equals(str2, "sprite")) {
                    particleTemplate2.initSprite((JSONObject) obj, str);
                } else if ((obj instanceof JSONObject) && TextUtils.equals(str2, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                    particleTemplate2.mSprite.audioPath = ((JSONObject) obj).getString("path");
                }
            }
            particleTemplate = particleTemplate2;
        } catch (Exception e) {
            particleTemplate = null;
        }
        AppMethodBeat.m2505o(81555);
        return particleTemplate;
    }

    private static void initAttr(ParticleTemplate particleTemplate, String str, Object obj) {
        AppMethodBeat.m2504i(81556);
        String str2 = null;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else if (obj instanceof Number) {
            str2 = obj.toString();
        }
        if (str2 == null) {
            AppMethodBeat.m2505o(81556);
            return;
        }
        if (TextUtils.equals(ATTR_MAX_COUNT, str)) {
            int intValue;
            if (obj instanceof Number) {
                intValue = ((Number) obj).intValue();
            } else {
                intValue = 0;
            }
            particleTemplate.mMaxCount = intValue;
            if (particleTemplate.mMaxCount < 0) {
                particleTemplate.mMaxCount = 0;
                AppMethodBeat.m2505o(81556);
                return;
            }
        } else if (TextUtils.equals(ATTR_EMIT_RATE, str)) {
            double doubleValue;
            if (obj instanceof Number) {
                doubleValue = ((Number) obj).doubleValue();
            } else {
                doubleValue = 0.0d;
            }
            particleTemplate.mEmitRate = doubleValue;
            if (particleTemplate.mEmitRate < 0.0d) {
                particleTemplate.mEmitRate = 0.0d;
                AppMethodBeat.m2505o(81556);
                return;
            }
        } else if (TextUtils.equals(ATTR_WIDTH, str)) {
            particleTemplate.mWidth = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_HEIGHT, str)) {
            particleTemplate.mHeight = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_LIFE, str)) {
            particleTemplate.mLife = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_COLOR_R, str)) {
            particleTemplate.mColorR = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_COLOR_G, str)) {
            particleTemplate.mColorG = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_COLOR_B, str)) {
            particleTemplate.mColorB = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_COLOR_A, str)) {
            particleTemplate.mColorA = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_POS_X, str)) {
            particleTemplate.mPosX = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_POS_Y, str)) {
            particleTemplate.mPosY = str2;
            AppMethodBeat.m2505o(81556);
            return;
        } else if (TextUtils.equals(ATTR_POS_Z, str)) {
            particleTemplate.mPosZ = str2;
        }
        AppMethodBeat.m2505o(81556);
    }

    private void preCalTexCoords(Sprite sprite, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(81557);
        int i5 = i2 / i4;
        int i6 = i / i3;
        float f = (((float) i3) * 1.0f) / ((float) i);
        float f2 = (((float) i4) * 1.0f) / ((float) i2);
        sprite.texCoords = new float[((i5 * i6) * 12)];
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            for (int i9 = 0; i9 < i6; i9++) {
                PointF pointF = new PointF(((float) i9) * f, ((float) i8) * f2);
                PointF pointF2 = new PointF(pointF.x, pointF.y + f2);
                PointF pointF3 = new PointF(pointF.x + f, pointF.y);
                PointF pointF4 = new PointF(pointF3.x, pointF.y + f2);
                int i10 = i7 + 1;
                sprite.texCoords[i7] = pointF3.x;
                int i11 = i10 + 1;
                sprite.texCoords[i10] = pointF3.y;
                i10 = i11 + 1;
                sprite.texCoords[i11] = pointF4.x;
                i11 = i10 + 1;
                sprite.texCoords[i10] = pointF4.y;
                int i12 = i11 + 1;
                sprite.texCoords[i11] = pointF2.x;
                i11 = i12 + 1;
                sprite.texCoords[i12] = pointF2.y;
                i12 = i11 + 1;
                sprite.texCoords[i11] = pointF3.x;
                i11 = i12 + 1;
                sprite.texCoords[i12] = pointF3.y;
                int i13 = i11 + 1;
                sprite.texCoords[i11] = pointF2.x;
                i12 = i13 + 1;
                sprite.texCoords[i13] = pointF2.y;
                int i14 = i12 + 1;
                sprite.texCoords[i12] = pointF.x;
                i7 = i14 + 1;
                sprite.texCoords[i14] = pointF.y;
            }
        }
        AppMethodBeat.m2505o(81557);
    }

    private void initSprite(JSONObject jSONObject, String str) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(81558);
        this.mSprite.path = jSONObject.optString("path");
        String str2 = str + File.separator + this.mSprite.path;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if (str2.startsWith("/")) {
            BitmapFactory.decodeFile(str2, options);
        } else {
            try {
                inputStream = this.mSystem.mContext.getAssets().open(str2);
                BitmapFactory.decodeStream(inputStream, null, options);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(81558);
            }
        }
        if (options.outWidth == 0 || options.outHeight == 0) {
            RuntimeException runtimeException = new RuntimeException("tex outWith or outHeight is 0");
            AppMethodBeat.m2505o(81558);
            throw runtimeException;
        }
        this.mSprite.frameCount = (int) doubleValue(jSONObject, "frameCount");
        this.mSprite.width = (int) doubleValue(jSONObject, "width");
        this.mSprite.height = (int) doubleValue(jSONObject, "height");
        this.mSprite.blendMode = (int) doubleValue(jSONObject, "blendMode");
        this.mSprite.animated = (int) doubleValue(jSONObject, "animated");
        this.mSprite.looped = (int) doubleValue(jSONObject, "looped");
        this.mSprite.frameDuration = doubleValue(jSONObject, "frameDuration");
        preCalTexCoords(this.mSprite, options.outWidth, options.outHeight, this.mSprite.width, this.mSprite.height);
        AppMethodBeat.m2505o(81558);
    }

    private double doubleValue(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(81559);
        Object opt = jSONObject.opt(str);
        if (opt == null || !(opt instanceof Number)) {
            AppMethodBeat.m2505o(81559);
            return 0.0d;
        }
        double doubleValue = ((Number) opt).doubleValue();
        AppMethodBeat.m2505o(81559);
        return doubleValue;
    }
}
