package com.tencent.matrix.resource;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class a {
    static void cc(View view) {
        if (view != null && view.getContext() != null) {
            Drawable drawable;
            int childCount;
            Field declaredField;
            if (view != null) {
                try {
                    view.setOnClickListener(null);
                } catch (Throwable th) {
                }
                try {
                    view.setOnCreateContextMenuListener(null);
                } catch (Throwable th2) {
                }
                try {
                    view.setOnFocusChangeListener(null);
                } catch (Throwable th3) {
                }
                try {
                    view.setOnKeyListener(null);
                } catch (Throwable th4) {
                }
                try {
                    view.setOnLongClickListener(null);
                } catch (Throwable th5) {
                }
                try {
                    view.setOnClickListener(null);
                } catch (Throwable th6) {
                }
                try {
                    view.setOnTouchListener(null);
                } catch (Throwable th7) {
                }
                if (view.getBackground() != null) {
                    view.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                        public final void onViewAttachedToWindow(View view) {
                        }

                        public final void onViewDetachedFromWindow(View view) {
                            try {
                                view.getBackground().setCallback(null);
                                view.setBackgroundDrawable(null);
                            } catch (Throwable th) {
                            }
                            try {
                                view.destroyDrawingCache();
                            } catch (Throwable th2) {
                            }
                            view.removeOnAttachStateChangeListener(this);
                        }
                    });
                }
            }
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                if (imageView != null) {
                    drawable = imageView.getDrawable();
                    if (drawable != null) {
                        drawable.setCallback(null);
                    }
                    imageView.setImageDrawable(null);
                }
            }
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                for (Drawable drawable2 : textView.getCompoundDrawables()) {
                    if (drawable2 != null) {
                        drawable2.setCallback(null);
                    }
                }
                textView.setCompoundDrawables(null, null, null, null);
                textView.setOnEditorActionListener(null);
                textView.setKeyListener(null);
                textView.setMovementMethod(null);
                if ((textView instanceof EditText) && textView != null) {
                    try {
                        textView.setHint("");
                        declaredField = TextView.class.getDeclaredField("mListeners");
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(textView);
                        if (obj instanceof ArrayList) {
                            ((ArrayList) obj).clear();
                        }
                    } catch (Throwable th8) {
                    }
                }
            }
            if (view instanceof ProgressBar) {
                ProgressBar progressBar = (ProgressBar) view;
                drawable = progressBar.getProgressDrawable();
                if (drawable != null) {
                    progressBar.setProgressDrawable(null);
                    drawable.setCallback(null);
                }
                drawable = progressBar.getIndeterminateDrawable();
                if (drawable != null) {
                    progressBar.setIndeterminateDrawable(null);
                    drawable.setCallback(null);
                }
            }
            if (view instanceof ListView) {
                ListView listView = (ListView) view;
                drawable = listView.getSelector();
                if (drawable != null) {
                    drawable.setCallback(null);
                }
                try {
                    if (listView.getAdapter() != null) {
                        listView.setAdapter(null);
                    }
                } catch (Throwable th9) {
                }
                try {
                    listView.setOnScrollListener(null);
                } catch (Throwable th10) {
                }
                try {
                    listView.setOnItemClickListener(null);
                } catch (Throwable th11) {
                }
                try {
                    listView.setOnItemLongClickListener(null);
                } catch (Throwable th12) {
                }
                try {
                    listView.setOnItemSelectedListener(null);
                } catch (Throwable th13) {
                }
            }
            if (view instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) view;
                if (frameLayout != null) {
                    drawable = frameLayout.getForeground();
                    if (drawable != null) {
                        drawable.setCallback(null);
                        frameLayout.setForeground(null);
                    }
                }
            }
            if (view instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) view;
                if (linearLayout != null && 11 <= VERSION.SDK_INT) {
                    if (16 <= VERSION.SDK_INT) {
                        drawable = linearLayout.getDividerDrawable();
                    } else {
                        try {
                            declaredField = linearLayout.getClass().getDeclaredField("mDivider");
                            declaredField.setAccessible(true);
                            drawable = (Drawable) declaredField.get(linearLayout);
                        } catch (Throwable th14) {
                            drawable = null;
                        }
                    }
                    if (drawable != null) {
                        drawable.setCallback(null);
                        linearLayout.setDividerDrawable(null);
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    cc(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
