package com.samsung.android.sdk.look.smartclip;

import java.util.ArrayList;

public abstract class SlookSmartClipMetaTagArray extends ArrayList<SlookSmartClipMetaTag> {
    public abstract SlookSmartClipMetaTagArray getTag(String str);

    public abstract void removeTag(String str);
}
