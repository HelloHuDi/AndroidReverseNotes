package com.tencent.p177mm.openim.p1210a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.p183ai.C1202f;

/* renamed from: com.tencent.mm.openim.a.b */
public interface C32873b extends C1202f, C1694a {

    /* renamed from: com.tencent.mm.openim.a.b$a */
    public enum C32874a {
        TYPE_WORDING,
        TYPE_URL;

        static {
            AppMethodBeat.m2505o(128604);
        }
    }

    /* renamed from: a */
    CharSequence mo44298a(Context context, CharSequence charSequence);

    /* renamed from: a */
    CharSequence mo44299a(Context context, String str, String str2, float f);

    /* renamed from: a */
    String mo44300a(String str, String str2, C32874a c32874a);

    /* renamed from: a */
    void mo44301a(Context context, TextView textView, CharSequence charSequence);

    /* renamed from: a */
    void mo44302a(Context context, TextView textView, CharSequence charSequence, String str, String str2, int i);

    /* renamed from: aZ */
    void mo44303aZ(String str, String str2);

    void anw();

    /* renamed from: b */
    String mo44305b(String str, String str2, C32874a c32874a);

    /* renamed from: ba */
    String mo44306ba(String str, String str2);

    /* renamed from: c */
    String mo44307c(String str, String str2, C32874a c32874a);

    /* renamed from: e */
    SpannableString mo44308e(Context context, String str, int i);

    /* renamed from: u */
    void mo44309u(String str, String str2, String str3);

    /* renamed from: vh */
    Bitmap mo44310vh(String str);

    /* renamed from: vi */
    int mo44311vi(String str);
}
