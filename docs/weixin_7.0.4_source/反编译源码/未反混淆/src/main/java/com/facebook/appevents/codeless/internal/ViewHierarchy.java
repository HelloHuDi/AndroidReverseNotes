package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.i;
import android.util.Base64;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchy {
    private static final int ADAPTER_VIEW_ITEM_BITMASK = 9;
    private static final int BUTTON_BITMASK = 2;
    private static final int CHECKBOX_BITMASK = 15;
    private static final String CHILDREN_VIEW_KEY = "childviews";
    private static final String CLASS_NAME_KEY = "classname";
    private static final String CLASS_TYPE_BITMASK_KEY = "classtypebitmask";
    private static final int CLICKABLE_VIEW_BITMASK = 5;
    private static final String DESC_KEY = "description";
    private static final String DIMENSION_HEIGHT_KEY = "height";
    private static final String DIMENSION_KEY = "dimension";
    private static final String DIMENSION_LEFT_KEY = "left";
    private static final String DIMENSION_SCROLL_X_KEY = "scrollx";
    private static final String DIMENSION_SCROLL_Y_KEY = "scrolly";
    private static final String DIMENSION_TOP_KEY = "top";
    private static final String DIMENSION_VISIBILITY_KEY = "visibility";
    private static final String DIMENSION_WIDTH_KEY = "width";
    private static final String GET_ACCESSIBILITY_METHOD = "getAccessibilityDelegate";
    private static final String HINT_KEY = "hint";
    private static final String ICON_BITMAP = "icon_image";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String ID_KEY = "id";
    private static final int IMAGEVIEW_BITMASK = 1;
    private static final int INPUT_BITMASK = 11;
    private static final int LABEL_BITMASK = 10;
    private static final int PICKER_BITMASK = 12;
    private static final int RADIO_GROUP_BITMASK = 14;
    private static final int RATINGBAR_BITMASK = 16;
    private static final int REACT_NATIVE_BUTTON_BITMASK = 6;
    private static final int SWITCH_BITMASK = 13;
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static final String TAG_KEY = "tag";
    private static final int TEXTVIEW_BITMASK = 0;
    private static final String TEXT_IS_BOLD = "is_bold";
    private static final String TEXT_IS_ITALIC = "is_italic";
    private static final String TEXT_KEY = "text";
    private static final String TEXT_SIZE = "font_size";
    private static final String TEXT_STYLE = "text_style";

    static {
        AppMethodBeat.i(72132);
        AppMethodBeat.o(72132);
    }

    public static ViewGroup getParentOfView(View view) {
        AppMethodBeat.i(72117);
        if (view == null) {
            AppMethodBeat.o(72117);
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            AppMethodBeat.o(72117);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        AppMethodBeat.o(72117);
        return viewGroup;
    }

    public static List<View> getChildrenOfView(View view) {
        AppMethodBeat.i(72118);
        ArrayList arrayList = new ArrayList();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        AppMethodBeat.o(72118);
        return arrayList;
    }

    public static JSONObject setBasicInfoOfView(View view, JSONObject jSONObject) {
        AppMethodBeat.i(72119);
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(CLASS_NAME_KEY, view.getClass().getCanonicalName());
            jSONObject.put(CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put(TEXT_KEY, "");
            } else {
                jSONObject.put(TEXT_KEY, textOfView);
            }
            jSONObject.put(HINT_KEY, hintOfView);
            if (tag != null) {
                jSONObject.put(TAG_KEY, tag.toString());
            }
            if (contentDescription != null) {
                jSONObject.put("description", contentDescription.toString());
            }
            jSONObject.put(DIMENSION_KEY, getDimensionOfView(view));
        } catch (JSONException e) {
            Utility.logd(TAG, e);
        }
        AppMethodBeat.o(72119);
        return jSONObject;
    }

    public static JSONObject setAppearanceOfView(View view, JSONObject jSONObject, float f) {
        AppMethodBeat.i(72120);
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Typeface typeface = textView.getTypeface();
                if (typeface != null) {
                    jSONObject2.put(TEXT_SIZE, (double) textView.getTextSize());
                    jSONObject2.put(TEXT_IS_BOLD, typeface.isBold());
                    jSONObject2.put(TEXT_IS_ITALIC, typeface.isItalic());
                    jSONObject.put(TEXT_STYLE, jSONObject2);
                }
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((float) view.getHeight()) / f <= 44.0f && ((float) view.getWidth()) / f <= 44.0f) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put(ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            }
        } catch (JSONException e) {
            Utility.logd(TAG, e);
        }
        AppMethodBeat.o(72120);
        return jSONObject;
    }

    public static JSONObject getDictionaryOfView(View view) {
        JSONObject jSONObject;
        AppMethodBeat.i(72121);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2 = setBasicInfoOfView(view, jSONObject2);
            try {
                JSONArray jSONArray = new JSONArray();
                List childrenOfView = getChildrenOfView(view);
                for (int i = 0; i < childrenOfView.size(); i++) {
                    jSONArray.put(getDictionaryOfView((View) childrenOfView.get(i)));
                }
                jSONObject2.put(CHILDREN_VIEW_KEY, jSONArray);
                jSONObject = jSONObject2;
            } catch (JSONException e) {
                jSONObject = jSONObject2;
            }
        } catch (JSONException e2) {
            jSONObject = jSONObject2;
        }
        AppMethodBeat.o(72121);
        return jSONObject;
    }

    private static int getClassTypeBitmask(View view) {
        AppMethodBeat.i(72122);
        int i = 0;
        if (view instanceof ImageView) {
            i = 2;
        }
        if (isClickableView(view)) {
            i |= 32;
        }
        if (isAdapterViewItem(view)) {
            i |= 512;
        }
        if (view instanceof TextView) {
            i = (i | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) | 1;
            if (view instanceof Button) {
                i |= 4;
                if (view instanceof Switch) {
                    i |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                } else if (view instanceof CheckBox) {
                    i |= 32768;
                }
            }
            if (view instanceof EditText) {
                i |= 2048;
            }
        } else if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            i |= 4096;
        } else if (view instanceof RatingBar) {
            i |= 65536;
        } else if (view instanceof RadioGroup) {
            i |= 16384;
        } else if ((view instanceof ViewGroup) && isRCTButton(view)) {
            i |= 64;
        }
        AppMethodBeat.o(72122);
        return i;
    }

    public static boolean isClickableView(View view) {
        AppMethodBeat.i(72123);
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                AppMethodBeat.o(72123);
                return false;
            }
            OnClickListener onClickListener = null;
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 != null) {
                onClickListener = (OnClickListener) declaredField2.get(obj);
            }
            if (onClickListener != null) {
                AppMethodBeat.o(72123);
                return true;
            }
            AppMethodBeat.o(72123);
            return false;
        } catch (Exception e) {
            AppMethodBeat.o(72123);
            return false;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        AppMethodBeat.i(72124);
        ViewParent parent = view.getParent();
        if (parent == null || !((parent instanceof AdapterView) || (parent instanceof i))) {
            AppMethodBeat.o(72124);
            return false;
        }
        AppMethodBeat.o(72124);
        return true;
    }

    public static String getTextOfView(View view) {
        Object text;
        AppMethodBeat.i(72125);
        int year;
        int month;
        int dayOfMonth;
        if (view instanceof TextView) {
            text = ((TextView) view).getText();
            if (view instanceof Switch) {
                text = ((Switch) view).isChecked() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
        } else if (view instanceof Spinner) {
            text = ((Spinner) view).getSelectedItem();
            text = text != null ? text.toString() : null;
        } else if (view instanceof DatePicker) {
            DatePicker datePicker = (DatePicker) view;
            year = datePicker.getYear();
            month = datePicker.getMonth();
            dayOfMonth = datePicker.getDayOfMonth();
            text = String.format("%04d-%02d-%02d", new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)});
        } else if (view instanceof TimePicker) {
            TimePicker timePicker = (TimePicker) view;
            year = timePicker.getCurrentHour().intValue();
            month = timePicker.getCurrentMinute().intValue();
            text = String.format("%02d:%02d", new Object[]{Integer.valueOf(year), Integer.valueOf(month)});
        } else if (view instanceof RadioGroup) {
            RadioGroup radioGroup = (RadioGroup) view;
            dayOfMonth = radioGroup.getCheckedRadioButtonId();
            int childCount = radioGroup.getChildCount();
            for (month = 0; month < childCount; month++) {
                View childAt = radioGroup.getChildAt(month);
                if (childAt.getId() == dayOfMonth && (childAt instanceof RadioButton)) {
                    text = ((RadioButton) childAt).getText();
                    break;
                }
            }
            text = null;
        } else {
            text = view instanceof RatingBar ? String.valueOf(((RatingBar) view).getRating()) : null;
        }
        String str;
        if (text == null) {
            str = "";
            AppMethodBeat.o(72125);
            return str;
        }
        str = text.toString();
        AppMethodBeat.o(72125);
        return str;
    }

    public static String getHintOfView(View view) {
        AppMethodBeat.i(72126);
        Object obj = null;
        if (view instanceof TextView) {
            obj = ((TextView) view).getHint();
        } else if (view instanceof EditText) {
            obj = ((EditText) view).getHint();
        }
        String str;
        if (obj == null) {
            str = "";
            AppMethodBeat.o(72126);
            return str;
        }
        str = obj.toString();
        AppMethodBeat.o(72126);
        return str;
    }

    private static JSONObject getDimensionOfView(View view) {
        AppMethodBeat.i(72127);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DIMENSION_TOP_KEY, view.getTop());
            jSONObject.put(DIMENSION_LEFT_KEY, view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put(DIMENSION_VISIBILITY_KEY, view.getVisibility());
        } catch (JSONException e) {
        }
        AppMethodBeat.o(72127);
        return jSONObject;
    }

    public static AccessibilityDelegate getExistingDelegate(View view) {
        AppMethodBeat.i(72128);
        try {
            AccessibilityDelegate accessibilityDelegate = (AccessibilityDelegate) view.getClass().getMethod(GET_ACCESSIBILITY_METHOD, new Class[0]).invoke(view, new Object[0]);
            AppMethodBeat.o(72128);
            return accessibilityDelegate;
        } catch (NoSuchMethodException e) {
            AppMethodBeat.o(72128);
            return null;
        } catch (NullPointerException e2) {
            AppMethodBeat.o(72128);
            return null;
        } catch (SecurityException e3) {
            AppMethodBeat.o(72128);
            return null;
        } catch (IllegalAccessException e4) {
            AppMethodBeat.o(72128);
            return null;
        } catch (InvocationTargetException e5) {
            AppMethodBeat.o(72128);
            return null;
        }
    }

    public static OnTouchListener getExistingOnTouchListener(View view) {
        AppMethodBeat.i(72129);
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(view);
            if (obj == null) {
                AppMethodBeat.o(72129);
                return null;
            }
            OnTouchListener onTouchListener;
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
                onTouchListener = (OnTouchListener) declaredField2.get(obj);
            } else {
                onTouchListener = null;
            }
            AppMethodBeat.o(72129);
            return onTouchListener;
        } catch (NoSuchFieldException e) {
            Utility.logd(TAG, e);
            AppMethodBeat.o(72129);
            return null;
        } catch (ClassNotFoundException e2) {
            Utility.logd(TAG, e2);
            AppMethodBeat.o(72129);
            return null;
        } catch (IllegalAccessException e22) {
            Utility.logd(TAG, e22);
            AppMethodBeat.o(72129);
            return null;
        }
    }

    public static boolean isRCTButton(View view) {
        AppMethodBeat.i(72130);
        if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup") || getExistingDelegate(view) == null || ((ViewGroup) view).getChildCount() <= 0) {
            AppMethodBeat.o(72130);
            return false;
        }
        AppMethodBeat.o(72130);
        return true;
    }

    public static boolean isRCTTextView(View view) {
        AppMethodBeat.i(72131);
        boolean equals = view.getClass().getName().equals("com.facebook.react.views.view.ReactTextView");
        AppMethodBeat.o(72131);
        return equals;
    }
}
