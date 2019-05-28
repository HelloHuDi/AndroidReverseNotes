package com.samsung.android.sdk.look.smartclip;

import android.graphics.Rect;

public interface SlookSmartClipDataElement {
    void addTag(SlookSmartClipMetaTag slookSmartClipMetaTag);

    SlookSmartClipMetaTagArray getAllTag();

    Rect getMetaAreaRect();

    SlookSmartClipMetaTagArray getTag(String str);

    void removeTag(String str);

    void setMetaAreaRect(Rect rect);
}
