package com.tencent.p177mm.plugin.sight.decode.p1020a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.TextView;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13321g;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;

/* renamed from: com.tencent.mm.plugin.sight.decode.a.a */
public interface C34915a {
    /* renamed from: bf */
    void mo8509bf(String str, boolean z);

    void ckX();

    boolean ckY();

    void clear();

    /* renamed from: fi */
    void mo8513fi(int i, int i2);

    Object getTagObject();

    Context getUIContext();

    String getVideoPath();

    void setCanPlay(boolean z);

    void setDrawableWidth(int i);

    void setForceRecordState(boolean z);

    void setOnCompletionListener(C13304e c13304e);

    void setOnDecodeDurationListener(C13325f c13325f);

    void setOnSightCompletionAction(C13321g c13321g);

    void setPosition(int i);

    void setSightInfoView(TextView textView);

    void setTagObject(Object obj);

    void setThumbBmp(Bitmap bitmap);
}
