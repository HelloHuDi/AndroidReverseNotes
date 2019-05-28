package com.tencent.mm.ui;

public interface IChattingUIProxy {
    void onEnterBegin();

    void onEnterEnd();

    void onExitBegin();

    void onExitEnd();

    void onInit(int i, boolean z);
}
