package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p210ca.C1344f;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.v */
public final class C5616v {
    public static final int[] ynp = new int[]{16843087, 16843088, 16843379};
    public static final int[] ynq = new int[]{16843379};

    /* renamed from: com.tencent.mm.ui.v$a */
    static final class C5615a implements Factory {
        LayoutInflater layoutInflater;

        private C5615a() {
        }

        /* synthetic */ C5615a(byte b) {
            this();
        }

        private View createView(String str, String str2, AttributeSet attributeSet) {
            AppMethodBeat.m2504i(106106);
            View view = null;
            try {
                view = this.layoutInflater.createView(str, str2, attributeSet);
            } catch (InflateException | ClassNotFoundException e) {
            }
            AppMethodBeat.m2505o(106106);
            return view;
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            View view = null;
            AppMethodBeat.m2504i(106105);
            try {
                if (str.indexOf(".") == -1) {
                    View createView;
                    if (str.equals("WebView")) {
                        createView = createView(str, "android.webkit.", attributeSet);
                    } else {
                        createView = null;
                    }
                    if (createView == null) {
                        createView = createView(str, "android.widget.", attributeSet);
                    }
                    if (createView == null) {
                        view = createView(str, "android.view.", attributeSet);
                    } else {
                        view = createView;
                    }
                } else {
                    view = this.layoutInflater.createView(str, null, attributeSet);
                }
                if ((view instanceof ViewStub) && VERSION.SDK_INT >= 21) {
                    ((ViewStub) view).setLayoutInflater(this.layoutInflater);
                }
                if (view == null) {
                    C4990ab.m7420w("MicroMsg.MMLayoutInflater", "Inflate view, ClassNotFound ".concat(String.valueOf(str)));
                } else if (str.equals("TextView") || str.equals("Button") || str.equals("EditText") || str.equals("CheckBox") || str.equals("ImageView") || str.equals("CheckedTextView") || str.equals("com.tencent.mm.ui.widget.MMTextView") || str.equals("com.tencent.mm.ui.widget.MMEditText") || str.equals("com.tencent.mm.ui.widget.MMNeat7extView") || str.equals("com.tencent.mm.ui.base.MMClearEditText") || str.equals("com.tencent.mm.ui.widget.edittext.PasterEditText") || str.equals("com.tenpay.android.wechat.TenpaySecureEditText") || str.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText") || str.equals("com.tencent.mm.ui.tools.MMTruncTextView") || str.equals("com.tencent.mm.plugin.brandservice.ui.base.CatalogView") || str.equals("com.tencent.mm.ui.tools.CustomFitTextView") || str.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText") || str.equals("com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView") || str.equals("com.tencent.mm.plugin.game.ui.GameDropdownView") || str.equals("com.tencent.mm.ui.ScrollAlwaysTextView") || str.equals("com.tencent.mm.ui.base.MMAutoSizeTextView") || str.equals("com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView") || str.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsTextView") || str.equals("com.tencent.mm.plugin.sns.ui.MaskTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsEditText") || str.equals("com.tencent.mm.kiss.widget.textview.PLSysTextView") || str.equals("com.tencent.mm.ui.base.EllipsizeTextView") || str.equals("com.tencent.mm.wallet_core.ui.WalletTextView")) {
                    float f;
                    float dm = C1338a.m2860dm(context);
                    if ((dm != 1.875f && dm != 2.025f) || str.equals("com.tencent.mm.ui.widget.MMTextView") || str.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsTextView") || str.equals("com.tencent.mm.plugin.sns.ui.MaskTextView") || str.equals("com.tencent.mm.ui.widget.MMNeat7extView")) {
                        f = dm;
                    } else {
                        f = 1.625f;
                    }
                    TextView textView;
                    TypedArray obtainStyledAttributes;
                    int i;
                    int resourceId;
                    if (str.equals("TextView") || str.equals("com.tencent.mm.ui.widget.MMTextView") || str.equals("com.tencent.mm.wallet_core.ui.WalletTextView")) {
                        textView = (TextView) view;
                        textView.setTextSize(1, (f * textView.getTextSize()) / C1338a.getDensity(textView.getContext()));
                        context.getAssets();
                        C1344f.dmU();
                        if (C1344f.dmV()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5616v.ynp);
                            for (i = 0; i < C5616v.ynp.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (C5616v.ynp[i] == 16843379) {
                                        textView.setContentDescription(context.getString(resourceId));
                                    } else if (C5616v.ynp[i] == 16843088) {
                                        textView.setHint(context.getString(resourceId));
                                    } else {
                                        textView.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("Button")) {
                        Button button = (Button) view;
                        button.setTextSize(1, (f * button.getTextSize()) / C1338a.getDensity(button.getContext()));
                        context.getAssets();
                        C1344f.dmU();
                        if (C1344f.dmV()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5616v.ynp);
                            for (i = 0; i < C5616v.ynp.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (C5616v.ynp[i] == 16843379) {
                                        button.setContentDescription(context.getString(resourceId));
                                    } else if (C5616v.ynp[i] == 16843088) {
                                        button.setHint(context.getString(resourceId));
                                    } else {
                                        button.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("EditText") || str.equals("com.tencent.mm.ui.widget.MMEditText") || str.equals("com.tencent.mm.ui.base.MMClearEditText") || str.equals("com.tencent.mm.ui.widget.edittext.PasterEditText") || str.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText") || str.equals("com.tenpay.android.wechat.TenpaySecureEditText") || str.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText") || str.equals("com.tencent.mm.plugin.sns.ui.SnsEditText")) {
                        EditText editText = (EditText) view;
                        editText.setTextSize(1, (f * editText.getTextSize()) / C1338a.getDensity(editText.getContext()));
                        context.getAssets();
                        C1344f.dmU();
                        if (C1344f.dmV()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5616v.ynp);
                            for (i = 0; i < C5616v.ynp.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (C5616v.ynp[i] == 16843379) {
                                        editText.setContentDescription(context.getString(resourceId));
                                    } else if (C5616v.ynp[i] == 16843088) {
                                        editText.setHint(context.getString(resourceId));
                                    } else {
                                        editText.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("CheckBox")) {
                        CheckBox checkBox = (CheckBox) view;
                        checkBox.setTextSize(1, (f * checkBox.getTextSize()) / C1338a.getDensity(checkBox.getContext()));
                        context.getAssets();
                        C1344f.dmU();
                        if (C1344f.dmV()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5616v.ynp);
                            for (i = 0; i < C5616v.ynp.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (C5616v.ynp[i] == 16843379) {
                                        checkBox.setContentDescription(context.getString(resourceId));
                                    } else if (C5616v.ynp[i] == 16843088) {
                                        checkBox.setHint(context.getString(resourceId));
                                    } else {
                                        checkBox.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("ImageView")) {
                        ImageView imageView = (ImageView) view;
                        context.getAssets();
                        C1344f.dmU();
                        if (C1344f.dmV()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5616v.ynq);
                            i = 0;
                            while (i < C5616v.ynq.length) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0 && C5616v.ynq[i] == 16843379) {
                                    imageView.setContentDescription(context.getString(resourceId));
                                }
                                i++;
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("com.tencent.mm.ui.widget.MMNeat7extView")) {
                        MMNeat7extView mMNeat7extView = (MMNeat7extView) view;
                        mMNeat7extView.setTextSize(1, (f * mMNeat7extView.getTextSize()) / C1338a.getDensity(mMNeat7extView.getContext()));
                    } else {
                        textView = (TextView) view;
                        textView.setTextSize(1, (f * textView.getTextSize()) / C1338a.getDensity(textView.getContext()));
                    }
                }
            } catch (ClassNotFoundException e) {
                C4990ab.m7421w("MicroMsg.MMLayoutInflater", "[cpan] class not found. name:%s. Use default Inflate.", str);
            } catch (InflateException e2) {
                C4990ab.m7421w("MicroMsg.MMLayoutInflater", "[cpan] Inflate failed. name:%s. Use default Inflate.", str);
            }
            AppMethodBeat.m2505o(106105);
            return view;
        }
    }

    /* renamed from: a */
    public static LayoutInflater m8408a(LayoutInflater layoutInflater) {
        AppMethodBeat.m2504i(106107);
        C1338a.m2860dm(layoutInflater.getContext());
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(layoutInflater.getContext());
        C5615a c5615a = new C5615a();
        c5615a.layoutInflater = cloneInContext;
        cloneInContext.setFactory(c5615a);
        AppMethodBeat.m2505o(106107);
        return cloneInContext;
    }

    /* renamed from: hu */
    public static LayoutInflater m8409hu(Context context) {
        AppMethodBeat.m2504i(106108);
        C1338a.m2860dm(context);
        LayoutInflater cloneInContext = LayoutInflater.from(context).cloneInContext(context);
        C5615a c5615a = new C5615a();
        c5615a.layoutInflater = cloneInContext;
        cloneInContext.setFactory(c5615a);
        AppMethodBeat.m2505o(106108);
        return cloneInContext;
    }
}
