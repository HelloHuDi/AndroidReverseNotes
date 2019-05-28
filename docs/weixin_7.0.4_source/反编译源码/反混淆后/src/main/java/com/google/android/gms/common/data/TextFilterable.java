package com.google.android.gms.common.data;

import android.content.Context;

public interface TextFilterable {
    public static final StringFilter CONTAINS = new zzc();
    public static final StringFilter STARTS_WITH = new zzd();
    public static final StringFilter WORD_STARTS_WITH = new zze();

    public interface StringFilter {
        boolean matches(String str, String str2);
    }

    void setFilterTerm(Context context, StringFilter stringFilter, String str);

    void setFilterTerm(Context context, String str);
}
