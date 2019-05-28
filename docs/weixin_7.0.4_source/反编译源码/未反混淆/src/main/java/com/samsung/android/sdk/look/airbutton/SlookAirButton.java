package com.samsung.android.sdk.look.airbutton;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl;
import com.samsung.android.airbutton.AirButtonImpl.OnItemSelectedListener;
import com.samsung.android.sdk.look.Slook;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SlookAirButton {
    public static final int DIRECTION_AUTO = -1;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_LOWER = 2;
    public static final int DIRECTION_RIGHT = 4;
    public static final int DIRECTION_UPPER = 1;
    public static final int GRAVITY_AUTO = -1;
    public static final int GRAVITY_BOTTOM = 2;
    public static final int GRAVITY_HOVER_POINT = 5;
    public static final int GRAVITY_LEFT = 3;
    public static final int GRAVITY_RIGHT = 4;
    public static final int GRAVITY_TOP = 1;
    private static final String TAG = "AirButtonWidget";
    public static final int UI_TYPE_LIST = 2;
    public static final int UI_TYPE_MENU = 1;
    private AirButtonImpl mAirButtonImpl = null;
    private ItemSelectListener mItemSelectListener;
    private Slook mSlook = new Slook();
    private int mUIType = 2;

    public interface ItemSelectListener {
        void onItemSelected(View view, int i, Object obj);
    }

    public SlookAirButton(View view, SlookAirButtonAdapter slookAirButtonAdapter, int i) {
        AppMethodBeat.i(117251);
        if (!isSupport(1)) {
            AppMethodBeat.o(117251);
        } else if (slookAirButtonAdapter == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("adapter is null");
            AppMethodBeat.o(117251);
            throw illegalArgumentException;
        } else {
            this.mUIType = i;
            this.mAirButtonImpl = new AirButtonImpl(view, slookAirButtonAdapter, i);
            AppMethodBeat.o(117251);
        }
    }

    public void setItemSelectListener(ItemSelectListener itemSelectListener) {
        AppMethodBeat.i(117252);
        if (isSupport(1)) {
            this.mItemSelectListener = itemSelectListener;
            if (this.mItemSelectListener != null) {
                this.mAirButtonImpl.setOnItemSelectedListener(new OnItemSelectedListener() {
                    public void onItemSelected(View view, int i, Object obj) {
                        AppMethodBeat.i(117271);
                        SlookAirButton.this.mItemSelectListener.onItemSelected(view, i, obj);
                        AppMethodBeat.o(117271);
                    }
                });
            }
            AppMethodBeat.o(117252);
            return;
        }
        AppMethodBeat.o(117252);
    }

    public void setGravity(int i) {
        AppMethodBeat.i(117253);
        if (isSupport(1)) {
            switch (i) {
                case -1:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    break;
                default:
                    new StringBuilder("The gravity(").append(i).append(") was wrong.");
                    break;
            }
            if (this.mUIType == 1 && (i == 3 || i == 4)) {
                IllegalStateException illegalStateException = new IllegalStateException("The Gravity is wrong. You cann't use GRAVITY_LEFT/GRAVITY_RIGHT with UI_TYPE_MENU.");
                AppMethodBeat.o(117253);
                throw illegalStateException;
            }
            this.mAirButtonImpl.setGravity(i);
            AppMethodBeat.o(117253);
            return;
        }
        AppMethodBeat.o(117253);
    }

    public int getGravity() {
        AppMethodBeat.i(117254);
        if (isSupport(1)) {
            int gravity = this.mAirButtonImpl.getGravity();
            AppMethodBeat.o(117254);
            return gravity;
        }
        AppMethodBeat.o(117254);
        return 0;
    }

    public void setDirection(int i) {
        AppMethodBeat.i(117255);
        if (isSupport(1)) {
            switch (i) {
                case -1:
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
                default:
                    new StringBuilder("The direction(").append(i).append(") was wrong.");
                    break;
            }
            IllegalStateException illegalStateException;
            if (this.mUIType == 1 && (i == 1 || i == 2)) {
                illegalStateException = new IllegalStateException("The Direction is wrong.you cann't use UPPER/LOWER direction with UI_TYPE_MENU.");
                AppMethodBeat.o(117255);
                throw illegalStateException;
            } else if (this.mUIType == 2 && (i == 3 || i == 4)) {
                illegalStateException = new IllegalStateException("The Direction is wrong.you cann't use LEFT/RIGHT direction with UI_TYPE_LIST.");
                AppMethodBeat.o(117255);
                throw illegalStateException;
            } else {
                this.mAirButtonImpl.setDirection(i);
                AppMethodBeat.o(117255);
                return;
            }
        }
        AppMethodBeat.o(117255);
    }

    public int getDirection() {
        AppMethodBeat.i(117256);
        if (isSupport(1)) {
            int direction = this.mAirButtonImpl.getDirection();
            AppMethodBeat.o(117256);
            return direction;
        }
        AppMethodBeat.o(117256);
        return 0;
    }

    public void setPosition(int i, int i2) {
        AppMethodBeat.i(117257);
        if (isSupport(1)) {
            this.mAirButtonImpl.setPosition(i, i2);
            AppMethodBeat.o(117257);
            return;
        }
        AppMethodBeat.o(117257);
    }

    public void setScrollEnabled(boolean z) {
        AppMethodBeat.i(117258);
        if (isSupport(1)) {
            this.mAirButtonImpl.setScrollEnabled(z);
            AppMethodBeat.o(117258);
            return;
        }
        AppMethodBeat.o(117258);
    }

    public boolean isScrollEnabled() {
        AppMethodBeat.i(117259);
        if (isSupport(1)) {
            boolean isScrollEnabled = this.mAirButtonImpl.isScrollEnabled();
            AppMethodBeat.o(117259);
            return isScrollEnabled;
        }
        AppMethodBeat.o(117259);
        return false;
    }

    private boolean isSupport(int i) {
        AppMethodBeat.i(117260);
        if (this.mSlook.isFeatureEnabled(1)) {
            AppMethodBeat.o(117260);
            return true;
        }
        AppMethodBeat.o(117260);
        return false;
    }

    public void setBounceEffectEnabled(boolean z) {
        AppMethodBeat.i(117261);
        if (isSupport(1)) {
            this.mAirButtonImpl.setBounceEffectEnabled(z);
            AppMethodBeat.o(117261);
            return;
        }
        AppMethodBeat.o(117261);
    }

    public boolean isBounceEffectEnabled() {
        AppMethodBeat.i(117262);
        if (isSupport(1)) {
            boolean isBounceEffectEnabled = this.mAirButtonImpl.isBounceEffectEnabled();
            AppMethodBeat.o(117262);
            return isBounceEffectEnabled;
        }
        AppMethodBeat.o(117262);
        return false;
    }

    public void hide() {
        AppMethodBeat.i(117263);
        if (isSupport(1)) {
            this.mAirButtonImpl.hide();
            AppMethodBeat.o(117263);
            return;
        }
        AppMethodBeat.o(117263);
    }

    public void dismiss() {
        AppMethodBeat.i(117264);
        if (isSupport(1)) {
            this.mAirButtonImpl.dismiss();
            AppMethodBeat.o(117264);
            return;
        }
        AppMethodBeat.o(117264);
    }

    public void setAutoControlEnabled(boolean z) {
        AppMethodBeat.i(117265);
        if (isSupport(1)) {
            this.mAirButtonImpl.setEnabled(z);
            AppMethodBeat.o(117265);
            return;
        }
        AppMethodBeat.o(117265);
    }

    public boolean isAutoControlEnabled() {
        AppMethodBeat.i(117266);
        if (isSupport(1)) {
            boolean isEnabled = this.mAirButtonImpl.isEnabled();
            AppMethodBeat.o(117266);
            return isEnabled;
        }
        AppMethodBeat.o(117266);
        return false;
    }

    public void startAnimationIcon(MotionEvent motionEvent) {
        AppMethodBeat.i(117267);
        if (!isSupport(1)) {
            AppMethodBeat.o(117267);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(117267);
            throw illegalStateException;
        } else if (motionEvent.getAction() != 9) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't ACTION_HOVER_ENTER");
            AppMethodBeat.o(117267);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverEnter(motionEvent);
            AppMethodBeat.o(117267);
        }
    }

    public void moveAnimationIcon(MotionEvent motionEvent) {
        AppMethodBeat.i(117268);
        if (!isSupport(1)) {
            AppMethodBeat.o(117268);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(117268);
            throw illegalStateException;
        } else if (motionEvent.getAction() != 7) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't ACTION_HOVER_MOVE.");
            AppMethodBeat.o(117268);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverMove(motionEvent);
            AppMethodBeat.o(117268);
        }
    }

    public void stopAnimationIcon(MotionEvent motionEvent) {
        AppMethodBeat.i(117269);
        if (!isSupport(1)) {
            AppMethodBeat.o(117269);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(117269);
            throw illegalStateException;
        } else if (motionEvent.getAction() != 10) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't ACTION_HOVER_EXIT.");
            AppMethodBeat.o(117269);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverExit(motionEvent);
            AppMethodBeat.o(117269);
        }
    }

    public void show(MotionEvent motionEvent) {
        AppMethodBeat.i(117270);
        if (!isSupport(1)) {
            AppMethodBeat.o(117270);
        } else if (this.mAirButtonImpl.isEnabled()) {
            IllegalStateException illegalStateException = new IllegalStateException("The mode is auto control. Please disable auto control.");
            AppMethodBeat.o(117270);
            throw illegalStateException;
        } else if (motionEvent.getToolType(0) != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The event isn't TOOL_TYPE_STYLUS.");
            AppMethodBeat.o(117270);
            throw illegalArgumentException;
        } else {
            this.mAirButtonImpl.onHoverButtonSecondary(motionEvent);
            AppMethodBeat.o(117270);
        }
    }
}
