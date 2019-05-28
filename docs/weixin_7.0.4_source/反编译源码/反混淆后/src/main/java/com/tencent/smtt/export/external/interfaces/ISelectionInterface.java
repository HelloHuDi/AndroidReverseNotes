package com.tencent.smtt.export.external.interfaces;

import android.graphics.Rect;

public interface ISelectionInterface {
    public static final int CARETSELECTION = 1;
    public static final int EDITABLESELECTION = 4;
    public static final short HELD_FIRST_WIDGET = (short) 0;
    public static final short HELD_NOTHING = (short) -1;
    public static final short HELD_SECOND_WIDGET = (short) 1;
    public static final int INPUTSELECTION = 2;
    public static final int NONESELECTION = 0;
    public static final int NORMALSELECTION = 3;

    String getText();

    void hideSelectionView();

    void onRetrieveFingerSearchContextResponse(String str, String str2, int i);

    void onSelectCancel();

    void onSelectionBegin(Rect rect, Rect rect2, int i, int i2, short s);

    void onSelectionBeginFailed(int i, int i2);

    void onSelectionChange(Rect rect, Rect rect2, int i, int i2, short s);

    void onSelectionDone(Rect rect, boolean z);

    void setText(String str, boolean z);

    void updateHelperWidget(Rect rect, Rect rect2);
}
