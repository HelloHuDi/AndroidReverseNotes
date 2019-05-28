package com.tencent.mm.plugin.sns.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.ui.MMFragment;

public interface b extends a {
    String getAccSnsPath();

    String getAccSnsTmpPath();

    MMFragment instantiateAlbumFragment(Context context, Bundle bundle);
}
