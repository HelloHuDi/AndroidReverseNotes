package android.support.c.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.a.c;
import android.support.v4.a.c.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class e {

    static class a implements TypeEvaluator<b[]> {
        private b[] uF;

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            b[] bVarArr = (b[]) obj;
            b[] bVarArr2 = (b[]) obj2;
            if (c.a(bVarArr, bVarArr2)) {
                if (this.uF == null || !c.a(this.uF, bVarArr)) {
                    this.uF = c.a(bVarArr);
                }
                for (int i = 0; i < bVarArr.length; i++) {
                    this.uF[i].a(bVarArr[i], bVarArr2[i], f);
                }
                return this.uF;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        private a() {
        }
    }

    public static Animator a(Context context, Resources resources, Theme theme, int i) {
        NotFoundException notFoundException;
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i);
            Animator a = a(context, resources, theme, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, 1.0f);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a;
        } catch (XmlPullParserException e) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (IOException e2) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static PropertyValuesHolder a(TypedArray typedArray, int i, int i2, int i3, String str) {
        Object obj;
        TypedValue peekValue = typedArray.peekValue(i2);
        Object obj2 = peekValue != null ? 1 : null;
        int i4 = obj2 != null ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        Object obj3 = peekValue2 != null ? 1 : null;
        int i5 = obj3 != null ? peekValue2.type : 0;
        if (i == 4) {
            if ((obj2 == null || !am(i4)) && (obj3 == null || !am(i5))) {
                i = 0;
            } else {
                i = 3;
            }
        }
        if (i == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            b[] L = c.L(string);
            b[] L2 = c.L(string2);
            if (!(L == null && L2 == null)) {
                if (L != null) {
                    a aVar = new a();
                    if (L2 == null) {
                        return PropertyValuesHolder.ofObject(str, aVar, new Object[]{L});
                    } else if (c.a(L, L2)) {
                        return PropertyValuesHolder.ofObject(str, aVar, new Object[]{L, L2});
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else if (L2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), new Object[]{L2});
                }
            }
            return null;
        }
        PropertyValuesHolder ofFloat;
        TypeEvaluator typeEvaluator = null;
        if (i == 3) {
            typeEvaluator = f.cF();
        }
        if (obj != null) {
            float dimension;
            if (obj2 != null) {
                float dimension2;
                if (i4 == 5) {
                    dimension2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    dimension2 = typedArray.getFloat(i2, 0.0f);
                }
                if (obj3 != null) {
                    if (i5 == 5) {
                        dimension = typedArray.getDimension(i3, 0.0f);
                    } else {
                        dimension = typedArray.getFloat(i3, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2, dimension});
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2});
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArray.getDimension(i3, 0.0f);
                } else {
                    dimension = typedArray.getFloat(i3, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension});
            }
        } else if (obj2 != null) {
            int dimension3;
            if (i4 == 5) {
                dimension3 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (am(i4)) {
                dimension3 = typedArray.getColor(i2, 0);
            } else {
                dimension3 = typedArray.getInt(i2, 0);
            }
            if (obj3 != null) {
                if (i5 == 5) {
                    i4 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (am(i5)) {
                    i4 = typedArray.getColor(i3, 0);
                } else {
                    i4 = typedArray.getInt(i3, 0);
                }
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3, i4});
            } else {
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3});
            }
        } else if (obj3 != null) {
            if (i5 == 5) {
                i4 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (am(i5)) {
                i4 = typedArray.getColor(i3, 0);
            } else {
                i4 = typedArray.getInt(i3, 0);
            }
            ofFloat = PropertyValuesHolder.ofInt(str, new int[]{i4});
        } else {
            ofFloat = null;
        }
        if (ofFloat == null || typeEvaluator == null) {
            return ofFloat;
        }
        ofFloat.setEvaluator(typeEvaluator);
        return ofFloat;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a = (long) android.support.v4.content.a.c.a(typedArray, xmlPullParser, FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1, 300);
        long a2 = (long) android.support.v4.content.a.c.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a3 = android.support.v4.content.a.c.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (android.support.v4.content.a.c.a(xmlPullParser, "valueFrom") && android.support.v4.content.a.c.a(xmlPullParser, "valueTo")) {
            if (a3 == 4) {
                TypedValue peekValue = typedArray.peekValue(5);
                Object obj = peekValue != null ? 1 : null;
                a3 = obj != null ? peekValue.type : 0;
                TypedValue peekValue2 = typedArray.peekValue(6);
                Object obj2 = peekValue2 != null ? 1 : null;
                int i = obj2 != null ? peekValue2.type : 0;
                if ((obj == null || !am(a3)) && (obj2 == null || !am(i))) {
                    a3 = 0;
                } else {
                    a3 = 3;
                }
            }
            if (a(typedArray, a3, 5, 6, "") != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{a(typedArray, a3, 5, 6, "")});
            }
        }
        valueAnimator.setDuration(a);
        valueAnimator.setStartDelay(a2);
        valueAnimator.setRepeatCount(android.support.v4.content.a.c.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(android.support.v4.content.a.c.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
            String b = android.support.v4.content.a.c.b(typedArray2, xmlPullParser, "pathData", 1);
            if (b != null) {
                String b2 = android.support.v4.content.a.c.b(typedArray2, xmlPullParser, "propertyXName", 2);
                String b3 = android.support.v4.content.a.c.b(typedArray2, xmlPullParser, "propertyYName", 3);
                if (b2 == null && b3 == null) {
                    throw new InflateException(typedArray2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                a(c.K(b), objectAnimator, 0.5f * f, b2, b3);
                return;
            }
            objectAnimator.setPropertyName(android.support.v4.content.a.c.b(typedArray2, xmlPullParser, "propertyName", 0));
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f2 = 0.0f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        int i = 0;
        float f3 = f2 / ((float) (min - 1));
        int i2 = 0;
        float f4 = 0.0f;
        while (i2 < min) {
            pathMeasure2.getPosTan(f4, fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            float f5 = f4 + f3;
            if (i + 1 >= arrayList.size() || f5 <= ((Float) arrayList.get(i + 1)).floatValue()) {
                f2 = f5;
            } else {
                f2 = f5 - ((Float) arrayList.get(i + 1)).floatValue();
                int i3 = i + 1;
                pathMeasure2.nextContour();
                i = i3;
            }
            i2++;
            f4 = f2;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (str != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, fArr);
        }
        if (str2 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder2});
        } else if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder, propertyValuesHolder2});
        }
    }

    private static Animator a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        Animator animator = null;
        ArrayList arrayList = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    Object obj;
                    if (name.equals("objectAnimator")) {
                        animator = a(context, resources, theme, attributeSet, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("animator")) {
                        animator = a(context, resources, theme, attributeSet, null, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("set")) {
                        Animator animatorSet2 = new AnimatorSet();
                        TypedArray a = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.uo);
                        Context context2 = context;
                        Resources resources2 = resources;
                        Theme theme2 = theme;
                        XmlPullParser xmlPullParser2 = xmlPullParser;
                        AttributeSet attributeSet2 = attributeSet;
                        a(context2, resources2, theme2, xmlPullParser2, attributeSet2, (AnimatorSet) animatorSet2, android.support.v4.content.a.c.a(a, xmlPullParser, "ordering", 0, 0), f);
                        a.recycle();
                        obj = null;
                        animator = animatorSet2;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] a2 = a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (!(a2 == null || animator == null || !(animator instanceof ValueAnimator))) {
                            ((ValueAnimator) animator).setValues(a2);
                        }
                        obj = 1;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null && obj == null) {
                        ArrayList arrayList2;
                        if (arrayList == null) {
                            arrayList2 = new ArrayList();
                        } else {
                            arrayList2 = arrayList;
                        }
                        arrayList2.add(animator);
                        arrayList = arrayList2;
                    }
                }
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                animatorArr[i2] = (Animator) it.next();
                i2 = i3;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static PropertyValuesHolder[] a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        int i;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3 && eventType != 1) {
                if (eventType != 2) {
                    xmlPullParser.next();
                } else {
                    ArrayList arrayList2;
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        PropertyValuesHolder ofKeyframe;
                        Object a;
                        TypedArray a2 = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.up);
                        String b = android.support.v4.content.a.c.b(a2, xmlPullParser, "propertyName", 3);
                        int a3 = android.support.v4.content.a.c.a(a2, xmlPullParser, "valueType", 2, 4);
                        ArrayList arrayList3 = null;
                        i = a3;
                        while (true) {
                            eventType = xmlPullParser.next();
                            Keyframe keyframe;
                            int i2;
                            if (eventType != 3 && eventType != 1) {
                                if (xmlPullParser.getName().equals("keyframe")) {
                                    if (i == 4) {
                                        TypedArray a4 = android.support.v4.content.a.c.a(resources, theme, Xml.asAttributeSet(xmlPullParser), a.uq);
                                        TypedValue a5 = android.support.v4.content.a.c.a(a4, xmlPullParser, "value");
                                        if ((a5 != null ? 1 : null) == null || !am(a5.type)) {
                                            eventType = 0;
                                        } else {
                                            eventType = 3;
                                        }
                                        a4.recycle();
                                        i = eventType;
                                    }
                                    TypedArray a6 = android.support.v4.content.a.c.a(resources, theme, Xml.asAttributeSet(xmlPullParser), a.uq);
                                    keyframe = null;
                                    float a7 = android.support.v4.content.a.c.a(a6, xmlPullParser, "fraction", 3, -1.0f);
                                    TypedValue a8 = android.support.v4.content.a.c.a(a6, xmlPullParser, "value");
                                    Object obj = a8 != null ? 1 : null;
                                    if (i != 4) {
                                        i2 = i;
                                    } else if (obj == null || !am(a8.type)) {
                                        i2 = 0;
                                    } else {
                                        i2 = 3;
                                    }
                                    if (obj != null) {
                                        switch (i2) {
                                            case 0:
                                                keyframe = Keyframe.ofFloat(a7, android.support.v4.content.a.c.a(a6, xmlPullParser, "value", 0, 0.0f));
                                                break;
                                            case 1:
                                            case 3:
                                                keyframe = Keyframe.ofInt(a7, android.support.v4.content.a.c.a(a6, xmlPullParser, "value", 0, 0));
                                                break;
                                        }
                                    } else if (i2 == 0) {
                                        keyframe = Keyframe.ofFloat(a7);
                                    } else {
                                        keyframe = Keyframe.ofInt(a7);
                                    }
                                    i2 = android.support.v4.content.a.c.a(a6, xmlPullParser, "interpolator", 1);
                                    if (i2 > 0) {
                                        keyframe.setInterpolator(d.loadInterpolator(context, i2));
                                    }
                                    a6.recycle();
                                    if (keyframe != null) {
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        arrayList3.add(keyframe);
                                    }
                                    xmlPullParser.next();
                                }
                                arrayList3 = arrayList3;
                                i = i;
                            } else if (arrayList3 != null) {
                                int size = arrayList3.size();
                                if (size > 0) {
                                    keyframe = (Keyframe) arrayList3.get(0);
                                    Keyframe keyframe2 = (Keyframe) arrayList3.get(size - 1);
                                    float fraction = keyframe2.getFraction();
                                    if (fraction >= 1.0f) {
                                        i2 = size;
                                    } else if (fraction < 0.0f) {
                                        keyframe2.setFraction(1.0f);
                                        i2 = size;
                                    } else {
                                        arrayList3.add(arrayList3.size(), a(keyframe2, 1.0f));
                                        i2 = size + 1;
                                    }
                                    float fraction2 = keyframe.getFraction();
                                    if (fraction2 != 0.0f) {
                                        if (fraction2 < 0.0f) {
                                            keyframe.setFraction(0.0f);
                                        } else {
                                            arrayList3.add(0, a(keyframe, 0.0f));
                                            i2++;
                                        }
                                    }
                                    Keyframe[] keyframeArr = new Keyframe[i2];
                                    arrayList3.toArray(keyframeArr);
                                    for (int i3 = 0; i3 < i2; i3++) {
                                        keyframe = keyframeArr[i3];
                                        if (keyframe.getFraction() < 0.0f) {
                                            if (i3 == 0) {
                                                keyframe.setFraction(0.0f);
                                            } else if (i3 == i2 - 1) {
                                                keyframe.setFraction(1.0f);
                                            } else {
                                                eventType = i3 + 1;
                                                size = i3;
                                                while (eventType < i2 - 1 && keyframeArr[eventType].getFraction() < 0.0f) {
                                                    size = eventType;
                                                    eventType++;
                                                }
                                                a(keyframeArr, keyframeArr[size + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, size);
                                            }
                                        }
                                    }
                                    ofKeyframe = PropertyValuesHolder.ofKeyframe(b, keyframeArr);
                                    if (i == 3) {
                                        ofKeyframe.setEvaluator(f.cF());
                                    }
                                    if (ofKeyframe != null) {
                                        a = a(a2, a3, 0, 1, b);
                                    } else {
                                        PropertyValuesHolder a9 = ofKeyframe;
                                    }
                                    if (a9 == null) {
                                        if (arrayList == null) {
                                            arrayList2 = new ArrayList();
                                        } else {
                                            arrayList2 = arrayList;
                                        }
                                        arrayList2.add(a9);
                                    } else {
                                        arrayList2 = arrayList;
                                    }
                                    a2.recycle();
                                }
                            }
                        }
                        if (arrayList3 != null) {
                        }
                        ofKeyframe = null;
                        if (ofKeyframe != null) {
                        }
                        if (a9 == null) {
                        }
                        a2.recycle();
                    } else {
                        arrayList2 = arrayList;
                    }
                    xmlPullParser.next();
                    arrayList = arrayList2;
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        i = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i];
        for (int i4 = 0; i4 < i; i4++) {
            propertyValuesHolderArr[i4] = (PropertyValuesHolder) arrayList.get(i4);
        }
        return propertyValuesHolderArr;
    }

    private static Keyframe a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    private static void a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static ObjectAnimator a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static ValueAnimator a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray a = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.un);
        TypedArray a2 = android.support.v4.content.a.c.a(resources, theme, attributeSet, a.ur);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a, a2, f, xmlPullParser);
        int a3 = android.support.v4.content.a.c.a(a, xmlPullParser, "interpolator", 0);
        if (a3 > 0) {
            valueAnimator.setInterpolator(d.loadInterpolator(context, a3));
        }
        a.recycle();
        if (a2 != null) {
            a2.recycle();
        }
        return valueAnimator;
    }

    private static boolean am(int i) {
        return i >= 28 && i <= 31;
    }
}
