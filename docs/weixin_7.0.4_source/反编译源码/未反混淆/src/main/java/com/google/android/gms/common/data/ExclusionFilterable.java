package com.google.android.gms.common.data;

public interface ExclusionFilterable {
    void clearFilters();

    void filterOut(String str);

    void unfilter(String str);
}
