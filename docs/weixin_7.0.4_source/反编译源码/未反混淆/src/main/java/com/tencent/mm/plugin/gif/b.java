package com.tencent.mm.plugin.gif;

import android.graphics.drawable.Drawable;
import com.tencent.mm.ui.e.b.a;

public abstract class b extends Drawable implements a {
    public abstract void pause();

    public abstract void recycle();

    public abstract void reset();

    public abstract void resume();
}
