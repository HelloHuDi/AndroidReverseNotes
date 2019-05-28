package com.tencent.recovery.option;

import android.content.Context;

public interface IOptionsCreator {
    CommonOptions createCommonOptions(Context context);

    ProcessOptions createProcessOptions(String str, int i);
}
