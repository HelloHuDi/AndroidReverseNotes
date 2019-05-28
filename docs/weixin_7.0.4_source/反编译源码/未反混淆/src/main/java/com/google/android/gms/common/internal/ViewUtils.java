package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewUtils {
    private ViewUtils() {
    }

    public static String getXmlAttributeString(String str, String str2, Context context, AttributeSet attributeSet, boolean z, boolean z2, String str3) {
        AppMethodBeat.i(89728);
        String attributeValue = attributeSet == null ? null : attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z) {
            String substring = attributeValue.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                context.getResources().getValue(new StringBuilder((String.valueOf(packageName).length() + 8) + String.valueOf(substring).length()).append(packageName).append(":string/").append(substring).toString(), typedValue, true);
            } catch (NotFoundException e) {
                new StringBuilder((String.valueOf(str2).length() + 30) + String.valueOf(attributeValue).length()).append("Could not find resource for ").append(str2).append(": ").append(attributeValue);
            }
            if (typedValue.string != null) {
                attributeValue = typedValue.string.toString();
            } else {
                substring = String.valueOf(typedValue);
                new StringBuilder((String.valueOf(str2).length() + 28) + String.valueOf(substring).length()).append("Resource ").append(str2).append(" was not a string: ").append(substring);
            }
        }
        if (z2 && attributeValue == null) {
            new StringBuilder(String.valueOf(str2).length() + 33).append("Required XML attribute \"").append(str2).append("\" missing");
        }
        AppMethodBeat.o(89728);
        return attributeValue;
    }
}
