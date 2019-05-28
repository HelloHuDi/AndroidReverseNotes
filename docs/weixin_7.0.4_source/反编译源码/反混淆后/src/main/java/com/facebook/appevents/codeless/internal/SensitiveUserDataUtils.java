package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SensitiveUserDataUtils {
    public static boolean isSensitiveUserData(View view) {
        AppMethodBeat.m2504i(72106);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (isPassword(textView) || isCreditCard(textView) || isPersonName(textView) || isPostalAddress(textView) || isPhoneNumber(textView) || isEmail(textView)) {
                AppMethodBeat.m2505o(72106);
                return true;
            }
            AppMethodBeat.m2505o(72106);
            return false;
        }
        AppMethodBeat.m2505o(72106);
        return false;
    }

    private static boolean isPassword(TextView textView) {
        AppMethodBeat.m2504i(72107);
        if (textView.getInputType() == 128) {
            AppMethodBeat.m2505o(72107);
            return true;
        }
        boolean z = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        AppMethodBeat.m2505o(72107);
        return z;
    }

    private static boolean isEmail(TextView textView) {
        AppMethodBeat.m2504i(72108);
        if (textView.getInputType() == 32) {
            AppMethodBeat.m2505o(72108);
            return true;
        }
        String textOfView = ViewHierarchy.getTextOfView(textView);
        if (textOfView == null || textOfView.length() == 0) {
            AppMethodBeat.m2505o(72108);
            return false;
        }
        boolean matches = Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
        AppMethodBeat.m2505o(72108);
        return matches;
    }

    private static boolean isPersonName(TextView textView) {
        AppMethodBeat.m2504i(72109);
        if (textView.getInputType() == 96) {
            AppMethodBeat.m2505o(72109);
            return true;
        }
        AppMethodBeat.m2505o(72109);
        return false;
    }

    private static boolean isPostalAddress(TextView textView) {
        AppMethodBeat.m2504i(72110);
        if (textView.getInputType() == 112) {
            AppMethodBeat.m2505o(72110);
            return true;
        }
        AppMethodBeat.m2505o(72110);
        return false;
    }

    private static boolean isPhoneNumber(TextView textView) {
        AppMethodBeat.m2504i(72111);
        if (textView.getInputType() == 3) {
            AppMethodBeat.m2505o(72111);
            return true;
        }
        AppMethodBeat.m2505o(72111);
        return false;
    }

    private static boolean isCreditCard(TextView textView) {
        AppMethodBeat.m2504i(72112);
        String replaceAll = ViewHierarchy.getTextOfView(textView).replaceAll("\\s", "");
        int length = replaceAll.length();
        if (length < 12 || length > 19) {
            AppMethodBeat.m2505o(72112);
            return false;
        }
        boolean z = false;
        int i = 0;
        int i2 = length - 1;
        while (i2 >= 0) {
            char charAt = replaceAll.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                AppMethodBeat.m2505o(72112);
                return false;
            }
            boolean z2;
            length = charAt - 48;
            if (z) {
                length *= 2;
                if (length > 9) {
                    length = (length % 10) + 1;
                }
            }
            i += length;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            i2--;
            z = z2;
        }
        if (i % 10 == 0) {
            AppMethodBeat.m2505o(72112);
            return true;
        }
        AppMethodBeat.m2505o(72112);
        return false;
    }
}
