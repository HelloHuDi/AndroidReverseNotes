package com.tencent.mm.openim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;

public interface b extends f, com.tencent.mm.kernel.c.a {

    public enum a {
        TYPE_WORDING,
        TYPE_URL;

        static {
            AppMethodBeat.o(128604);
        }
    }

    CharSequence a(Context context, CharSequence charSequence);

    CharSequence a(Context context, String str, String str2, float f);

    String a(String str, String str2, a aVar);

    void a(Context context, TextView textView, CharSequence charSequence);

    void a(Context context, TextView textView, CharSequence charSequence, String str, String str2, int i);

    void aZ(String str, String str2);

    void anw();

    String b(String str, String str2, a aVar);

    String ba(String str, String str2);

    String c(String str, String str2, a aVar);

    SpannableString e(Context context, String str, int i);

    void u(String str, String str2, String str3);

    Bitmap vh(String str);

    int vi(String str);
}
