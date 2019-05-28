package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.a.b;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.tencent.mm.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class a {
    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return c(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static ColorStateList c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        int[] iArr;
        int depth = xmlPullParser.getDepth() + 1;
        Object[] objArr = new int[20][];
        int[] iArr2 = new int[20];
        int i = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            } else if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes;
                iArr = android.support.v7.a.a.a.ColorStateListItem;
                if (theme == null) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, iArr);
                } else {
                    obtainAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                }
                int color = obtainAttributes.getColor(0, -65281);
                float f = 1.0f;
                if (obtainAttributes.hasValue(1)) {
                    f = obtainAttributes.getFloat(1, 1.0f);
                } else if (obtainAttributes.hasValue(2)) {
                    f = obtainAttributes.getFloat(2, 1.0f);
                }
                obtainAttributes.recycle();
                int i2 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i3 = 0;
                while (i3 < attributeCount) {
                    next = attributeSet.getAttributeNameResource(i3);
                    if (next == 16843173 || next == 16843551 || next == R.attr.ia) {
                        next = i2;
                    } else {
                        int i4 = i2 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                            next = -next;
                        }
                        iArr3[i2] = next;
                        next = i4;
                    }
                    i3++;
                    i2 = next;
                }
                iArr = StateSet.trimStateSet(iArr3, i2);
                iArr2 = c.c(iArr2, i, b.u(color, Math.round(f * ((float) Color.alpha(color)))));
                i++;
                objArr = (int[][]) c.a(objArr, i, iArr);
            }
        }
        iArr = new int[i];
        int[][] iArr4 = new int[i][];
        System.arraycopy(iArr2, 0, iArr, 0, i);
        System.arraycopy(objArr, 0, iArr4, 0, i);
        return new ColorStateList(iArr4, iArr);
    }
}
